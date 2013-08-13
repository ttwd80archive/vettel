package it.steps;

import static org.hamcrest.MatcherAssert.*;
import it.pages.Home;
import it.pages.PageFactory;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ApplicationSteps {

	private final Home home;

	public ApplicationSteps(final PageFactory pageFactory) {
		home = pageFactory.newHome();
	}

	@Given("I am on the home page")
	public void givenIAmOnTheHomePage() {
		home.go();
	}

	@When("I login as $username $password")
	public void whenILogInAs(final String username, final String password) {
		home.logIn(username, password);
	}

	@Then("I am logged in as admin")
	public void thenIAmLoggedIn() {
		assertThat(home.getCurrentUrl(), Matchers.equalTo("http://localhost:8280/vettel/admin/index"));
	}
}
