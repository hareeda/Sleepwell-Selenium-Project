package com.ust.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.base.Settings;
import com.ust.popages.HomePage;
import com.ust.popages.NewPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Newtest {
	
	public WebDriver driver = CucumberHooks.driver;
	Properties objprop = Settings.obj_prop;
	Properties exprop = Settings.expresult_prop;
	
	HomePage hpage;
	NewPage npage;
	Settings set;
	
	@Given("the user in the homepage")
	public void the_user_in_the_homepage() {
		hpage = Settings.setUp();
		assertTrue(hpage.verifyCurrentUrl(objprop.getProperty("base")), "Home Page was not loaded properly!");		
	}

	@When("I click the new page link")
	public void i_click_the_new_page_link() {
		npage = hpage.clickNewLink(hpage.newlink);
	}

	@Then("I validate the new page outcomes")
	public void i_validate_the_new_page_outcomes() {
		assertTrue(npage.verifyCurrentUrl(exprop.getProperty("urlnew")));
	}

}
