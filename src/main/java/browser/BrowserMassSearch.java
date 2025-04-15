package browser;

import browser.masssearch.MassSearchStrategy;
import configuration.Configuration;

import java.util.Arrays;
import java.util.Objects;

public class BrowserMassSearch {
    private Browser browser;
    private Configuration[] configs;

    public BrowserMassSearch(Browser browser, Configuration[] configs) {
        this.browser = browser;
        this.configs = configs;
    }

    public BrowserMassSearch(Configuration[] configs) {
        this(new Browser(), configs);
    }

    public BrowserMassSearch(Browser browser) {
        this(browser, null);
    }

    public BrowserMassSearch() {
        this(new Browser(), null);
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public Configuration[] getConfigs() {
        return configs;
    }

    public void setConfigs(Configuration[] configs) {
        this.configs = configs;
    }

    public String[] massSearch(MassSearchStrategy strategy) {
        String[] rtnr = new String[configs.length];

        for (int i = 0; i < configs.length; i++) {
            browser.setConfig(configs[i]);

            rtnr[i] = strategy.search();
        }

        return rtnr;
    }

    public void quit() {
        browser.quit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrowserMassSearch that = (BrowserMassSearch) o;
        return Objects.equals(browser, that.browser) && Arrays.equals(configs, that.configs);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(browser);
        result = 31 * result + Arrays.hashCode(configs);
        return result;
    }

    @Override
    public String toString() {
        return browser.toString() + " -> " + Arrays.toString(configs);
    }
}
