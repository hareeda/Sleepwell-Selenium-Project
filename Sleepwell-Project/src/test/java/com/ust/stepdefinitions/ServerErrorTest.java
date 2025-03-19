package com.ust.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.base.Settings;
import com.ust.popages.HomePage;
import com.ust.popages.ServerErrorPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServerErrorTest {

	public WebDriver driver = CucumberHooks.driver;
	Properties objprop = Settings.obj_prop;
	Properties exprop = Settings.expresult_prop;

	HomePage hpage;
	ServerErrorPage serpage;
	Settings set;

	@Given("the user is on the application homepage")
	public void the_user_is_on_the_application_homepage() {
		hpage = Settings.setUp();
		assertTrue(hpage.verifyCurrentUrl(objprop.getProperty("base")), "Home Page was not loaded properly!");
	}

	@When("the user clicks on cart button it triggers a server error")
	public void the_user_performs_an_action_that_triggers_a_server_error() {
		hpage.click(hpage.cartIcon);
		serpage = hpage.geturl(objprop.getProperty("servererrorurl"));
	}

	@Then("the user should be displayed an appropriate error message")
	public void the_user_should_be_displayed_an_appropriate_error_message() {
		assertTrue(serpage.errorText.isDisplayed());
	}

	@Then("the error message should clearly indicate a server error.")
	public void the_error_message_should_clearly_indicate_a_server_error() {
		assertTrue(serpage.verifyExpectedText(serpage.errorText, exprop.getProperty("servererrormsg")));
	}

}
