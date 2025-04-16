import browser.Browser;
import browser.masssearch.MassSearchEnabler;
import browser.BrowserType;
import browser.masssearch.MassSearchStrategy;
import browser.masssearch.strategies.NewTabStrategy;
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

		Browser browser = new Browser(BrowserType.FIREFOX);
		MassSearchStrategy strategy = new RefreshStrategy(browser);
		MassSearchEnabler foxyLoader = new MassSearchEnabler(browser, Configuration.bundle(fonts, texts), strategy);

//		String[] output = foxyLoader.massSearch();
//
//		for (String s : output) {
//			System.out.println(s.stripTrailing());
//			System.out.println();
//		}



		foxyLoader.quit();
	}
}
