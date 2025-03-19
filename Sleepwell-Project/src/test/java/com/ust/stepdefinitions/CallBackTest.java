package com.ust.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.base.Settings;
import com.ust.popages.CallBackForm;
import com.ust.popages.ContactUsPage;
import com.ust.popages.HomePage;
import com.ust.popages.InstitutionalPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CallBackTest {

	public WebDriver driver = CucumberHooks.driver;
	Properties objprop = Settings.obj_prop;
	Properties exprop = Settings.expresult_prop;

	CallBackForm cbform;
	HomePage hpage;
	InstitutionalPage instpage;
	ContactUsPage cupage;

	@Given("the user is in the homepage.")
	public void the_user_is_in_the_homepage() {
		hpage = Settings.setUp();
		assertTrue(hpage.verifyCurrentUrl(objprop.getProperty("base")), "Home Page was not loaded properly!");
	}

	@Given("user clicks on the menu icon.")
	public void user_clicks_on_the_menu_icon() {
		hpage.click(hpage.menuBar);
	}
	
	@Given("user clicks on Institutional Enquiry link")
	public void user_clicks_on_institutional_enquiry_link() {
		instpage = hpage.clickInstEnquiry(hpage.institutionalEnquiry);
		assertTrue(instpage.verifyCurrentUrl(exprop.getProperty("instenquiry")));
	}

	@Given("user clicks on Sleepwell Saathi: Sofa Refurbishment button")
	public void user_clicks_on_sleepwell_saathi_sofa_refurbishment_button() {
		cupage = instpage.clcikSofaRefurbishment(instpage.sofarefurbishment);
		assertTrue(instpage.verifyCurrentUrl(exprop.getProperty("saathi")));
	}

	@Given("user click on Mattress@Home button")
	public void user_click_on_mattress_home_button() {
		cbform = cupage.clickCallBack(cupage.saathiHome);
		assertTrue(cbform.verifyCurrentUrl(exprop.getProperty("callback")));
	}

	@When("user click on Submit")
	public void user_click_on_submit() {
		cbform.click(cbform.sumbitbtn);
	}

	@Then("validates that the button is disabled since no details is entered.")
	public void validates_that_the_button_is_disabled_since_no_details_is_entered() {
		assertTrue(cbform.buttonDisabled(cbform.sumbitbtn));
	}

	@When("the user enters details")
	public void user_enters_details(io.cucumber.datatable.DataTable dataTable) {
		Settings.waits(2000);
		List<Map<String, String>> formDataList = dataTable.asMaps(String.class, String.class);
		Map<String, String> formValues1 = formDataList.get(0);
		cbform.setinfo(formValues1.get("name"), formValues1.get("phonenum"), formValues1.get("email"),
				formValues1.get("pin"));
		cbform.click(cbform.sumbitbtn);
	}

	@Then("validate the submission submited message")
	public void validate_the_submission_submited_message() {
		assertTrue(cupage.successMsg.getText().equals(exprop.getProperty("succsubmit"))
				|| cupage.successMsg.getText().equals(exprop.getProperty("saveddata")));
	}
}
