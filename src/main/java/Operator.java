import browser.Browser;
import browser.BrowserMassSearch;
import browser.BrowserType;
import browser.masssearch.strategies.ReconfigureTabStrategy;
import browser.masssearch.strategies.RefreshStrategy;
import configuration.Configuration;

import java.util.Arrays;

public class Operator {
	public static void main(String[] args) {
		String[] fonts = {
				"Graffiti",
				"3D Diagonal",
				"Alpha",
				"Acrobatic",
				"Avatar",
				"Babyface",
				"Big Money-ne",
				"Big Money-nw",
				"Big Money-se",
				"Big Money-sw"
		};

		String[] texts = {
				"Hello World!",
				"Java Power!",
				"ASCII Vibes",
				"Code & Chill",
				"Stay Creative",
				"Bug Free Zone",
				"Hello, TAAG!",
				"Pixel Dreams",
				"Hack the Day",
				"Credit to Patorjk"
		};


//		System.out.println("URL: " + foxy.getConfig().generateURL());
//		System.out.println("Navigating...");
//
//		foxy.open();
//		String out = foxy.scrapeASCII();
//
//		System.out.println(out);


		BrowserMassSearch foxyLoader = new BrowserMassSearch(new Browser(BrowserType.EDGE.driver(), new Configuration()), Configuration.bundle(fonts, texts));
		System.out.println(Arrays.toString(foxyLoader.massSearch(new ReconfigureTabStrategy(foxyLoader.getBrowser()))));

		foxyLoader.quit();
	}
}
