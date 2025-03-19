package com.ust.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.base.Settings;
import com.ust.popages.HomePage;
import com.ust.popages.OffersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OfferTest {

	public WebDriver driver = CucumberHooks.driver;
	Properties objprop = Settings.obj_prop;
	Properties exprop = Settings.expresult_prop;

	HomePage hpage;
	OffersPage offerpage;
	Settings set;
	
	@Given("the user in the Homepage")
	public void the_user_in_the_homepage() {
		hpage = Settings.setUp();
		assertTrue(hpage.verifyCurrentUrl(objprop.getProperty("base")), "Home Page was not loaded properly!");
	}

	@When("I click the offer link")
	public void i_click_the_offer_link() {
		offerpage = hpage.clickOfferLink(hpage.offerlink);
	}

	@Then("I validate offer outcomes")
	public void i_validate_offer_outcomes() {
		assertTrue(offerpage.verifyExpectedResults(offerpage.offerText, exprop.getProperty("offertext")));
	}
}
