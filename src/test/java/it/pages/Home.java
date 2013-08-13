package it.pages;

import static org.openqa.selenium.By.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Home extends FluentWebDriverPage {

	public Home(final WebDriverProvider webDriverProvider) {
		super(webDriverProvider);
	}

	public void go() {
		get("http://localhost:8280/vettel");
	}

	public void logIn(final String username, final String password) {
		try {
			input(id("j_username")).sendKeys(username);
			input(id("j_password")).sendKeys(password + "\n");
		} catch (final Exception e) {
			e.printStackTrace();
			final TakesScreenshot takesScreenshot = (TakesScreenshot) getDriverProvider().get();
			final File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("screenshot.png"));
			} catch (final IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
