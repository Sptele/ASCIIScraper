package browser;

import browser.masssearch.MassSearchStrategy;
import configuration.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class Browser {

	private Configuration config;
	private WebDriver driver;

	public Browser() {
		this(BrowserType.FIREFOX.driver(), new Configuration());
	}

	public Browser(WebDriver driver, Configuration config) {
		this.config = config;
		this.driver = driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public Browser(BrowserType browser, Configuration config) {
		this(browser.driver(), config);
	}

	public Browser(Configuration config) {
		this(BrowserType.FIREFOX.driver(), config);
	}

	public Browser(BrowserType browser) {
		this(browser.driver(), new Configuration());
	}

	public void open() {
		driver.get(config.generateURL()); // Navigate to website
	}

	public String scrapeASCII() {
		WebElement displayBox = getElement("taag_output_text");

		return displayBox.getText();
	}

	public WebElement getElement(String id) {
		return driver.findElement(By.id(id));
	}

	public void quit() {
		driver.quit();
	}

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
