package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public enum BrowserType {
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