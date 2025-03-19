package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class LoginPage {

	private WebDriver driver;
	private ReusableMethods method;

	/************ LOGIN PAGE WEB ELEMENTS ************/

	@FindBy(id = "user-emailId")
	public WebElement emailid;

	@FindBy(id = "login-password")
	public WebElement passkey;

	@FindBy(css = "input[value=\"sign in\"].site-btn")
	public WebElement signinbtn;

	@FindBy(linkText = "Or continue as guest")
	public WebElement guestLogin;

	@FindBy(className = "loginValError")
	public WebElement errorText;

	@FindBy(css = "body > div.breadcrumbs-wrapper > div > ul > li:nth-child(1) > a")
	public WebElement home;

	@FindBy(linkText = "New to Sleepwell? Create a new account")
	public WebElement registerLink;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public LoginPage(WebDriver driver) {
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

	/************ LOGIN PAGE METHODS ************/

	// Method to enter the text onto the element passed to it.
	public void enterDetails(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		method.enterText(text, element);
	}

	// Method to click on the element passed to it and passes the driver to profile
	// page.
	public ProfilePage signclick(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new ProfilePage(driver);
	}

	// Method to click on the element passed to it and passes the driver to home
	// page.
	public HomePage clickGuestLogin(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new HomePage(driver);
	}

	// Method to click on the element passed to it.
	public HomePage clickHome(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new HomePage(driver);
	}

	// Method to click on the element passed to it and passes the driver to
	// registration page.
	public Registration clickRegister(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new Registration(driver);
	}

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		method.clickOnElement(element);
	}
}
