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

	// TODO: mass search outside of browser.Browser should load/clear configs, bring in a browser.Browser, configuration.Configuration.
	// Mass searching should occur within this: loadnew config, then search, over and over. No mutator within a retriever

	public Browser() {
		this(BrowserType.FIREFOX.driver(), new Configuration());
	}

	public Browser(WebDriver driver, Configuration config) {
		this.config = config;
		this.driver = driver;
	}

	public Browser(BrowserType browser, Configuration config) {
		this(browser.driver(), config);
	}

	public Browser(Configuration config) {
		this(BrowserType.FIREFOX.driver(), config);
	}

	public void open() {
		driver.get(config.generateURL()); // Navigate to website
	}

	public String scrapeASCII() {
		WebElement displayBox = getElement("taag_output_text");

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> displayBox.isDisplayed());

		return displayBox.getText();
	}

	public WebElement getElement(String id) {
		WebElement el = driver.findElement(By.id(id)); // Query Element

		return el;
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
