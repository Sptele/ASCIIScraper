import browser.Browser;
import browser.masssearch.MassSearchEnabler;
import browser.masssearch.strategies.NewTabStrategy;
import browser.masssearch.strategies.ReconfigureTabStrategy;
import browser.masssearch.strategies.RefreshStrategy;
import configuration.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.Stopwatch;

public class MassSearchTimer {

	private MassSearchEnabler search;

	public MassSearchTimer() {
	}


	@BeforeEach
	void setUp() {
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

		search = new MassSearchEnabler(new Browser(), Configuration.bundle(fonts, texts));


	}

	@Test
	@Stopwatch
	void NewTab() {
		search.setStrategy(new NewTabStrategy(search.getBrowser()));

		search.massSearch();

		search.quit();
	}

	@Test
	@Stopwatch
	void Reconfigure() {
		search.setStrategy(new ReconfigureTabStrategy(search.getBrowser()));

		search.massSearch();

		search.quit();
	}

	@Test
	@Stopwatch
	void Refresh() {
		search.setStrategy(new RefreshStrategy(search.getBrowser()));

		search.massSearch();

		search.quit();
	}
}
