package it.steps;

import it.cargo.CargoLifecycle;

import java.net.MalformedURLException;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;

public class LifecycleSteps {

	protected CargoLifecycle cargoLifecycle = new CargoLifecycle();

	@BeforeStory
	public void initWebApplication() throws MalformedURLException {
		cargoLifecycle.start();
	}

	@AfterStory
	public void stopWebApplication() {
		cargoLifecycle.stop();
	}

}
