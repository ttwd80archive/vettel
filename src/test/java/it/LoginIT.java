package it;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class LoginIT extends AbstractWebClientIT {

	@Test
	public void testLoginBad() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		final HtmlPage htmlPage = webClient.getPage(APP_BASE);
		((HtmlInput) htmlPage.getElementById("j_username")).setValueAttribute("admin");
		((HtmlInput) htmlPage.getElementById("j_password")).setValueAttribute("***");
		final HtmlPage nextPage = ((HtmlInput) htmlPage.getElementById("submit")).click();
	}
}
