package browser.masssearch.strategies;

import browser.Browser;
import browser.masssearch.MassSearchStrategy;
import org.openqa.selenium.WindowType;

public class NewTabStrategy extends MassSearchStrategy {
    public NewTabStrategy(Browser browser) {
        super(browser);
    }

    @Override
    public String search() {
        String rtnr = getBrowser().scrapeASCII();
        getBrowser().getDriver().switchTo().newWindow(WindowType.TAB);

        return rtnr;
    }
}
