package browser.masssearch.strategies;

import browser.Browser;
import browser.masssearch.MassSearchStrategy;
import configuration.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class ReconfigureTabStrategy extends MassSearchStrategy {
    public ReconfigureTabStrategy(Browser browser) {
        super(browser);
    }

    @Override
    public String search() {
        boolean successful = updatePageToConfiguration();
        // TODO: do something with this?
        return getBrowser().scrapeASCII();
    }

    public boolean updatePageToConfiguration() {
        try {
            // TODO: optimize to do no request if el doesn't change
            WebElement input = getBrowser().getElement("inputText");
            WebElement fontList = getBrowser().getElement("fontList");
            WebElement width = getBrowser().getElement("taagCharWidth");
            WebElement height = getBrowser().getElement("taagCharHeight");

            Wait<WebDriver> wait = new WebDriverWait(getBrowser().getDriver(), Duration.ofSeconds(2));
            wait.until(d -> input.isDisplayed());


            Configuration config = getBrowser().getConfig();

            input.clear();
            input.sendKeys(config.getText());

            fontList.sendKeys(config.getFont());
            width.sendKeys(config.getWidth().toString());
            height.sendKeys(config.getHeight().toString());

        } catch (Exception e) {
            System.out.println("ERROR: " + Arrays.toString(e.getStackTrace()));
            return false;
        }

        return true;
    }
}
