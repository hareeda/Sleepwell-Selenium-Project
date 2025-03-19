package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class ProfilePage {

	private WebDriver driver;
	private ReusableMethods method;

	/************ PROFILE PAGE WEB ELEMENTS ************/

	@FindBy(id = "user-email")
	public WebElement emailText;

	@FindBy(linkText = "Log out")
	public WebElement logout;

	@FindBy(id = "logout-proceed")
	public WebElement yes;

	@FindBy(id = "dshboard-heading")
	public WebElement profileText;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public ProfilePage(WebDriver driver) {
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

	/************ PROFILE PAGE METHODS ************/

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	// Method to click on the element passed to it and passes the driver to Login
	// page.
	public LoginPage clickYes(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new LoginPage(driver);
	}

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}

}
