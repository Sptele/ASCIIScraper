import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

enum BrowserType {
	CHROME {
		@Override
		public WebDriver driver() {
			return new ChromeDriver();
		}
	}, FIREFOX {
		@Override
		public WebDriver driver() {
			return new FirefoxDriver();
		}
	}, SAFARI {
		@Override
		public WebDriver driver() {
			return new SafariDriver();
		}
	}, INTERNET_EXPLORER {
		@Override
		public WebDriver driver() {
			return new InternetExplorerDriver();
		}
	}, EDGE {
		@Override
		public WebDriver driver() {
			return new EdgeDriver();
		}
	};

	public abstract WebDriver driver();
}

public class Browser {

	private Configuration config;
	private WebDriver driver;
	private ArrayList<Configuration> loadedConfigs;

	public Browser() {
		this(BrowserType.FIREFOX.driver(), new Configuration());
	}

	public Browser(WebDriver driver, Configuration config) {
		this.config = config;
		this.driver = driver;

		loadedConfigs = new ArrayList<>();
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
		open();

		WebElement displayBox = getElement("taag_output_text");

		return displayBox.getText();
	}

	public WebElement getElement(String id) {
		WebElement el = driver.findElement(By.id(id)); // Query Element

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> el.isDisplayed());

		return el;
	}

	public boolean updatePageToConfiguration() {
		try {
			// TODO: optimize to do no request if el doesn't change
			WebElement input = getElement("inputText");
			WebElement fontList = getElement("fontList");
			WebElement width = getElement("taagCharWidth");
			WebElement height = getElement("taagCharHeight");

			input.clear();
			input.sendKeys(config.getText());

			fontList.sendKeys(config.getFont());
			width.sendKeys(config.getWidth().toString());
			height.sendKeys(config.getHeight().toString());

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public void loadConfigurations(Configuration[] configs) {
		loadedConfigs.addAll(Arrays.asList(configs));
	}

	public void clearLoadedConfigurations() {
		loadedConfigs.clear();
	}

	public String[] massSearch() {
		String[] rtnr = new String[loadedConfigs.size()];
		System.out.println(loadedConfigs);

		for (int i = 0; i < loadedConfigs.size(); i++) {
			setConfig(loadedConfigs.get(i));

			// Approach A: Search in new tabs
//			rtnr[i] = search();
//			driver.switchTo().newWindow(WindowType.TAB);

			// Approach B: Reconfigure window
//			updatePageToConfiguration();
//			rtnr[i] = scrapeASCII(); // TODO: possible error: doesn't work if you call two searches sequentially

			// Approach C: Refresh the page
			rtnr[i] = scrapeASCII();
			driver.navigate().refresh();
		}

		return rtnr;
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
