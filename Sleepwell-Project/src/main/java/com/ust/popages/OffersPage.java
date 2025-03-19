package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class OffersPage {

	public WebDriver driver;
	private ReusableMethods method;// created a object for reusable method

	/************ OFFERS PAGE WEB ELEMENTS ************/

	@FindBy(css = "div.sl-container h1")
	public WebElement offerText;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public OffersPage(WebDriver driver) {
		if (driver == null) {
			throw new NullPointerException("driver cannot be null");
		}
		this.driver = driver;
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			// handle exception
		}
		method = new ReusableMethods(driver);
	}

	/************ OFFERS PAGE METHODS ************/

	// Method to verify the expected result with the element text.
	public boolean verifyExpectedResults(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}
}
