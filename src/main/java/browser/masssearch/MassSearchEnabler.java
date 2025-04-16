package browser.masssearch;

import browser.Browser;
import configuration.Configuration;

import java.util.Arrays;
import java.util.Objects;

public class MassSearchEnabler {
    private Browser browser;
    private Configuration[] configs;

    private MassSearchStrategy strategy;

    public MassSearchEnabler(Browser browser, Configuration[] configs) {
        this.browser = browser;
        this.configs = configs;
    }

    public MassSearchEnabler(Browser browser, Configuration[] configs, MassSearchStrategy strategy) {
        this.browser = browser;
        this.configs = configs;
        this.strategy = strategy;
    }

    public MassSearchEnabler(Configuration[] configs) {
        this(new Browser(), configs);
    }

    public MassSearchEnabler(Browser browser) {
        this(browser, null);
    }

    public MassSearchEnabler() {
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

    public MassSearchStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MassSearchStrategy strategy) {
        this.strategy = strategy;
    }

    public String[] massSearch() {
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
        MassSearchEnabler that = (MassSearchEnabler) o;
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
