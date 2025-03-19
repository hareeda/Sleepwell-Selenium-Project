package com.ust.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.base.Settings;
import com.ust.popages.HomePage;
import com.ust.popages.WarrantyRegistrationPage;
import com.ust.reusable.ReusableMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WarrantyRegistrationTest {
	
	public WebDriver driver = CucumberHooks.driver;
	Properties exprop = Settings.expresult_prop;
	Properties objprop = Settings.obj_prop;
	
	ReusableMethods method;
	HomePage hpage;
	WarrantyRegistrationPage wrpage;

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		hpage = Settings.setUp();
		method = new ReusableMethods(driver);
		assertTrue(hpage.verifyCurrentUrl(objprop.getProperty("base")), "Home Page was not loaded properly!"); 
	}

	@When("the user clicks on the menu bar")
	public void the_user_clicks_on_the_menu_bar() {
		hpage.click(hpage.menuBar);
	}

	@When("the user clicks Warranty Registration from the menu")
	public void the_user_clicks_warranty_registration_from_the_menu() {
		method.scrolltoElement(hpage.warrantyRegistration);
		wrpage = hpage.clickWarrantyRegistration(hpage.warrantyRegistration);
	}

	@When("the user should see the warranty registration form")
	public void the_user_should_see_the_warranty_registration_form() {
		assertTrue(wrpage.verifyCurrentUrl(exprop.getProperty("warrantyregistration")));
	}

	@When("the user selects Amazon as the purchase source")
	public void the_user_selects_amazon_as_the_purchase_source() {	
		wrpage.click(wrpage.radioBtn);
	}

	@When("the user enters {string} in the serial number field")
	public void the_user_enters_in_the_serial_number_field(String string) {
		wrpage.enterDetails(string, wrpage.serialNumber);
	}

	@When("the user enters {string} in the date of purchase field")
	public void the_user_enters_in_the_date_of_purchase_field(String string) {
		wrpage.enterDetails(string, wrpage.date);
	}

	@When("the user enters {string} in the first name field")
	public void the_user_enters_in_the_first_name_field(String string) {
		wrpage.enterDetails(string, wrpage.fname);
	}

	@When("the user enters {string} in the last name field")
	public void the_user_enters_in_the_last_name_field(String string) {
		wrpage.enterDetails(string, wrpage.lname);
	}

	@When("the user enters {string} in the email ID field")
	public void the_user_enters_in_the_email_id_field(String string) {
		wrpage.enterDetails(string, wrpage.emailfield);
	}

	@When("the user enters {string} in the mobile number field")
	public void the_user_enters_in_the_mobile_number_field(String string) {
		wrpage.enterDetails(string, wrpage.mobileNumber);
	}

	@When("the user enters {string} in the pincode field")
	public void the_user_enters_in_the_pincode_field(String string) throws InterruptedException {
		wrpage.enterDetails(string, wrpage.pincode);
		wrpage.click(wrpage.cityField);
	}

	@When("the user clicks the Register button")
	public void the_user_clicks_the_register_button() {
		wrpage.click(wrpage.registerBtn);
	}
	
	@Then("the user should see a serial number error message {string}")
	public void the_user_should_see_a_serial_number_error_message(String string) {
		assertTrue(wrpage.errormsgSerialNo.getText().contains(string));
	}
	
	@Then("the user clicks the Register button again")
	public void the_user_clicks_the_register_button_again() {
		wrpage.click(wrpage.registerBtn);
	}

	@Then("the user should see a mobile error message {string}")
	public void the_user_should_see_a_mobile_error_message(String string) {
		assertTrue(wrpage.errormsgMobNo.getText().contains(string));
	}

}
