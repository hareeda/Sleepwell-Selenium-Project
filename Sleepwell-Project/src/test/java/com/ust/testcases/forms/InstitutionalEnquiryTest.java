package com.ust.testcases.forms;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.InstitutionalPage;

@Listeners(TestListener.class)
public class InstitutionalEnquiryTest extends Settings {

	// Page objects of necessary pages.
	HomePage hpage;
	InstitutionalPage ipage;

	// Verifying whether user navigates to institutional form page.
	@Test(priority = 1)
	public void verifyNavigatetoForm() {
		hpage = setUp(); // Passing the driver to HomePage object after opening the site.
		assertTrue(hpage.verifyCurrentUrl(obj_prop.getProperty("base")), "Home Page was not loaded properly!"); // Asserting
																												// that
																												// the
																												// site
																												// has
																												// loaded
																												// properly
																												// or
																												// not.
		hpage.click(hpage.menuBar); // Clicking on menu icon.
		ipage = hpage.clickInstEnquiry(hpage.institutionalEnquiry); // Clicking on Institutional Enquiry element and
																	// passing the driver InstitutionalPage object.
		assertTrue(ipage.verifyCurrentUrl(expresult_prop.getProperty("instenquiry"))); // Asserting whether user was
																						// navigated to the
																						// InstitutionalPage.
	}

	// Verifying blank submission of Institutional Enquiry form.
	@Test(priority = 2)
	public void verifyBlankForm() {
		ipage.click(ipage.registerbtn); // Clicking on Register button without entering any details.
		assertTrue(ipage.errText.getText().equals(expresult_prop.getProperty("insterror"))); // Asserting the error text
																								// displayed.
	}

	// Verifying the Institutional Form Submission
	@Test(priority = 3)
	public void verifyInstitutionalFormSubmission() {
		ipage.enterDetailsDrop(ipage.requirementFor, obj_prop.getProperty("requirementfor")); // Entering keys to
																								// requirementfor
																								// element.
		ipage.enterDetailsDrop(ipage.productReq, obj_prop.getProperty("productreq")); // Entering keys to
																						// productrequirement element.
		ipage.enterDetails(ipage.quantitys, obj_prop.getProperty("quantity")); // Entering keys to quantity element.
		ipage.enterDetailsDrop(ipage.otherProducts, obj_prop.getProperty("othprod")); // Entering keys to otherProducts
																						// element.
		ipage.enterDetails(ipage.selectState, obj_prop.getProperty("state")); // Entering keys to selectState element.
		ipage.enterDetails(ipage.selectCity, obj_prop.getProperty("city")); // Entering keys to selectCity element.
		ipage.enterDetails(ipage.pername, obj_prop.getProperty("firstname")); // Entering keys to pername element.
		ipage.enterDetails(ipage.orgName, obj_prop.getProperty("orgname")); // Entering keys to orgName element.
		ipage.enterDetails(ipage.mailId, obj_prop.getProperty("email")); // Entering keys to mailId element.
		ipage.enterDetails(ipage.phNumber, obj_prop.getProperty("mobile")); // Entering keys to phNumber element.
		ipage.enterDetails(ipage.desCription, obj_prop.getProperty("description")); // Entering keys to desCription
																					// element.
		ipage.click(ipage.registerbtn); // Clicking on Register button element.
		assertTrue(ipage.checkBtnDisabled(ipage.registerbtn)); // Asserting whether the button has been disabled after
																// submission.
	}
}
