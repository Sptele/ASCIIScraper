package browser.masssearch;

import browser.Browser;

public abstract class MassSearchStrategy {
    private final Browser browser;

    public MassSearchStrategy(Browser browser) {
        this.browser = browser;
    }

    public Browser getBrowser() {
        return browser;
    }

    public abstract String search();


}
