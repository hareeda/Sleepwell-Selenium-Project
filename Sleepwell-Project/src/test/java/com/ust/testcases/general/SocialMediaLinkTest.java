package com.ust.testcases.general;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.SocialMediaPage;

@Listeners(TestListener.class)
public class SocialMediaLinkTest extends Settings {

	// Page objects of necessary pages.
	HomePage hpage;
	SocialMediaPage smpage;

	// Verifying the facebook icon navigation.
	@Test(priority = 1)
	public void verifyFacebookLink() {
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
		smpage = hpage.clickSocialMediaLink(hpage.facebook); // Clicking on Facebook icon
		assertTrue(smpage.verifyCurrentUrl(expresult_prop.getProperty("facebook"))); // Asserting navigation to site's facebook page.
		hpage = navigateBack(); // Navigating back to HomePage.
	}
	
	// Verifying the instagram icon navigation.
	@Test(priority = 2)
	public void verifyInstagramLink() {
		smpage = hpage.clickSocialMediaLink(hpage.instagram); // Clicking on Instagram icon
		assertTrue(smpage.verifyCurrentUrl(expresult_prop.getProperty("instagram"))); // Asserting navigation to site's instagram page.
		hpage = navigateBack(); // Navigating back to HomePage.
	}
	
	// Verifying the youtube icon navigation.
	@Test(priority = 3)
	public void verifyYoutubeLink() {
		smpage = hpage.clickSocialMediaLink(hpage.youtube); // Clicking on Youtube icon
		assertTrue(smpage.verifyCurrentUrl(expresult_prop.getProperty("youtube"))); // Asserting navigation to site's youtube page.
		hpage = navigateBack(); // Navigating back to HomePage.
	}
	
	// Verifying the twitter icon navigation.
	@Test(priority = 4)
	public void verifyTwitterLink() {
		smpage = hpage.clickSocialMediaLink(hpage.twitter); // Clicking on Twitter icon
		assertTrue(smpage.verifyCurrentUrl(expresult_prop.getProperty("twitter"))); // Asserting navigation to site's twitter page.
		hpage = navigateBack(); // Navigating back to HomePage.
	}
}
