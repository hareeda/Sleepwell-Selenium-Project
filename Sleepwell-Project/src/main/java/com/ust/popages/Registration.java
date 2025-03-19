package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class Registration {

	public WebDriver driver;
	private ReusableMethods method;

	/************ REGISTRATION PAGE WEB ELEMENTS ************/

	@FindBy(id = "signup-first-name")
	public WebElement firstname;

	@FindBy(id = "signup-last-name")
	public WebElement lasttname;

	@FindBy(id = "signup-email-id")
	public WebElement email;

	@FindBy(id = "signup-phone-number")
	public WebElement mobile;

	@FindBy(id = "signup-dobDate")
	public WebElement date;

	@FindBy(id = "signup-password")
	public WebElement password;

	@FindBy(xpath = "//input[@value = 'Create Account']")
	public WebElement ck;

	@FindBy(xpath = "//div[16]/div[1]/div[2]")
	public WebElement successMsg;

	@FindBy(className = "signup-email-id-error")
	public WebElement errorMsg;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public Registration(WebDriver driver) {
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

	/************ REGISTRATION PAGE METHODS ************/

	// Method to enter the text onto the element passed to it.
	public void enterDetails(String text, WebElement element) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		method.enterText(text, element);
	}

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	// Method to check if the element is disabled.
	public boolean checkBtnDisabled(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		return method.isElementNotClickable(element);
	}

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}
}
