package com.ust.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.base.Settings;
import com.ust.popages.HomePage;
import com.ust.popages.WarrantyPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WarrantyTest {

	public WebDriver driver = CucumberHooks.driver;
	Properties objprop = Settings.obj_prop;
	Properties exprop = Settings.expresult_prop;

	HomePage hpage;
	WarrantyPage wpage;
	Settings set;

	@Given("the user is in the website homepage")
	public void the_user_is_in_the_website_homepage() {
		hpage = Settings.setUp();
		assertTrue(hpage.verifyCurrentUrl(objprop.getProperty("base")), "Home Page was not loaded properly!");
	}

	@When("user click on the Menu button")
	public void user_click_on_the_menu_button() {
		hpage.click(hpage.menuBar);
	}

	@When("user click on the Warranty link in the menu bar.")
	public void user_click_on_the_warranty_link_in_the_menu_bar() {
		wpage = hpage.clickWarranty(hpage.warrantylink);
	}

	@Then("user validate the Warranty link policy of website is displayed.")
	public void user_validate_the_warranty_link_policy_of_website_is_displayed() {
		assertTrue(wpage.verifyExpectedText(wpage.WarrentyText, exprop.getProperty("warrantytext")));
	}

}
