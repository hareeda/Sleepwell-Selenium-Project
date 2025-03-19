package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class FaqPage {

	WebDriver driver;
	private ReusableMethods method;

	/************ FAQ PAGE WEB ELEMENTS ************/

	@FindBy(xpath = "//p[contains(text(),'Below are some frequently asked questions about sl')]")
	public WebElement faqwelcometext;
	
	@FindBy(css = "a[href='tel:1800 570 5700'].site-btn")
	public WebElement homeservices;
	
	@FindBy(xpath = "//a[contains(text(),'CHAT')]")
	public WebElement onlineservices;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public FaqPage(WebDriver driver) {
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

	/************ FAQ PAGE METHODS ************/

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}

	// Method to verify the expected string with the element text.
	public boolean verifyExpectedString(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

	public boolean verifyElementClickable(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		return method.isElementClickable(element);
	}

	public boolean verifyExpectedString(String text, String expected) {
		if (text == null || expected == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.isStringMatch(text, expected);
	}

	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}
}
