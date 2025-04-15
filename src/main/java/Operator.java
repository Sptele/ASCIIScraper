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


		Browser foxy = new Browser();

//		System.out.println("URL: " + foxy.getConfig().generateURL());
//		System.out.println("Navigating...");
//
//		foxy.open();
//		String out = foxy.scrapeASCII();
//
//		System.out.println(out);

		foxy.loadConfigurations(Configuration.bundle(fonts, texts));
		System.out.println(Arrays.toString(foxy.massSearch()));

		foxy.quit();
	}
}
