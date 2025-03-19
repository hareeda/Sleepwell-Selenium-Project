package com.ust.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.base.Settings;
import com.ust.popages.ContactUsPage;
import com.ust.popages.HomePage;
import com.ust.popages.InstitutionalPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsTest {
	
	ContactUsPage cupage;
	InstitutionalPage instpage;
	HomePage hpage;

	public WebDriver driver = CucumberHooks.driver;
	Properties objprop = Settings.obj_prop;
	Properties exprop = Settings.expresult_prop;

	@Given("the user in the homepage.")
	public void the_user_in_the_homepage() {
		hpage = Settings.setUp();
		assertTrue(hpage.verifyCurrentUrl(objprop.getProperty("base")), "Home Page was not loaded properly!");
	}

	@Given("user clicks on menu icon.")
	public void user_clicks_on_menu_icon() {
		hpage.click(hpage.menuBar);
	}

	@Given("user clicks on Institutional Enquiry")
	public void user_clicks_on_institutional_enquiry() {
		instpage = hpage.clickInstEnquiry(hpage.institutionalEnquiry);
		assertTrue(instpage.verifyCurrentUrl(exprop.getProperty("instenquiry")));
	}

	@Given("user clicks on Sleepwell Saathi: Sofa Refurbishment")
	public void user_clicks_on_sleepwell_saathi_refurbishment_home() {
		cupage = instpage.clcikSofaRefurbishment(instpage.sofarefurbishment);
		assertTrue(instpage.verifyCurrentUrl(exprop.getProperty("saathi")));
	}

	@When("user enters details")
	public void user_enters_details(io.cucumber.datatable.DataTable dataTable) {
		Settings.waits(2000);
		List<Map<String, String>> formDataList = dataTable.asMaps(String.class, String.class);
		Map<String, String> formValues1 = formDataList.get(0);
		cupage.setinfo(formValues1.get("firstname"), formValues1.get("lastname"), formValues1.get("email"),
				formValues1.get("number"), formValues1.get("message"));
		cupage.click(cupage.submit);
	}

	@Then("validate the submission submitted message")
	public void validate_the_submission_submitted_message() {
		assertTrue(cupage.successMsg.getText().equals(exprop.getProperty("succsubmit"))
				|| cupage.successMsg.getText().equals(exprop.getProperty("saveddata")));
	}

	@When("user clicks on Submit")
	public void user_clicks_on_submit() {
		cupage.click(cupage.submit);
	}

	@Then("validate that the button is disabled since no data is entered.")
	public void validate_that_the_button_is_disabled_since_no_data_is_entered() {
		assertTrue(cupage.buttonDisabled(cupage.submit));
	}

}
