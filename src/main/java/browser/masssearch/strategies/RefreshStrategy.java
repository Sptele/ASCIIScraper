package browser.masssearch.strategies;

import browser.Browser;
import browser.masssearch.MassSearchStrategy;

public class RefreshStrategy extends MassSearchStrategy {

    public RefreshStrategy(Browser browser) {
        super(browser);
    }

    @Override
    public String search() {
        getBrowser().getDriver().navigate().refresh();
        getBrowser().open();

        return getBrowser().scrapeASCII();
    }
}
