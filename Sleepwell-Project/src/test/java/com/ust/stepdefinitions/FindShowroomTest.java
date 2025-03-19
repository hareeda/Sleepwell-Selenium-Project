package com.ust.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.base.Settings;
import com.ust.popages.FindShowroomPage;
import com.ust.popages.HomePage;
import com.ust.reusable.ReusableMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindShowroomTest {
	
	public WebDriver driver = CucumberHooks.driver;
	Properties exprop = Settings.expresult_prop;
	Properties objprop = Settings.obj_prop;
	
	ReusableMethods method;
	HomePage hpage;
	FindShowroomPage fspage;
	Settings set;

	@Given("the user is in  homepage.")
	public void the_user_is_in_homepage() {
		hpage = Settings.setUp();
		method = new ReusableMethods(driver);
		assertTrue(hpage.verifyCurrentUrl(objprop.getProperty("base")), "Home Page was not loaded properly!");
	}

	@When("user clicks on Find Showroom and navigates to the store locator page.")
	public void user_clicks_on_find_showroom_and_navigates_to_the_store_locator_page() {
		fspage = hpage.clickFindShowroom(hpage.findShowroom);
		assertTrue(fspage.verifyCurrentUrl(exprop.getProperty("store")));
	}

	@When("user select a city {string}")
	public void user_select_a_city(String text) {
		fspage.click(fspage.citySelectContainer);
		fspage.enterString(text, fspage.enterACityText);
	}

	@When("user select an area {string}")
	public void user_select_an_area(String text) {
		fspage.click(fspage.areaSelectContainer);
		fspage.enterString(text, fspage.enterACityText);
		method.scrolltoElement(fspage.resText);
	}

	@Then("validate that the store near to given area is displayed")
	public void validate_that_the_store_near_to_given_area_is_displayed() {
		assertTrue(fspage.verifyExpectedResult(exprop.getProperty("findshowroomresult"), fspage.resText));
	}

	@Then("validate that an error is shown")
	public void validate_that_an_error_is_shown() {
		assertTrue(fspage.verifyExpectedResult(exprop.getProperty("finderrorresult"), fspage.errorText));
	}

}
