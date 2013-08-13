package it;

import org.junit.Before;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

public class AbstractWebClientIT extends AbstractCargoIT {

	protected WebClient webClient;
	protected final String APP_BASE = "http://localhost:8280/vettel";

	@Before
	public void initWebClient() {
		webClient = new WebClient(BrowserVersion.CHROME);
	}

	@Before
	public void destroyWebClient() {
		webClient.closeAllWindows();
	}
}
