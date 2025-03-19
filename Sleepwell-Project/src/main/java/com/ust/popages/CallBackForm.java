package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class CallBackForm {

	WebDriver driver;
	private ReusableMethods method; // created a object for reusable method

	/************ CALL BACK FORM PAGE WEB ELEMENTS ************/
	
	@FindBy(id = "bannerName")
	public WebElement fullName;

	@FindBy(id = "phone")
	public WebElement mnumber;

	@FindBy(id = "rqemailId")
	public WebElement mailid;

	@FindBy(id = "pinCode")
	public WebElement pinCode;

	@FindBy(css = "input.site-btn.f1")
	public WebElement sumbitbtn;

	@FindBy(xpath = "//div[16]/div[1]/div[2]")
	public WebElement successMsg;

	/************ PARAMATERIZED CONSTRUCTOR ************/
	
	public CallBackForm(WebDriver driver) {
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

	/************ CALL BACK FORM PAGE METHODS ************/

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	// Method to enter the text onto the element passed to it.
	public void enterDetails(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		method.enterText(text, element);
	}

	// Method to check if the element is disabled.
	public boolean buttonDisabled(WebElement element) {
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

	// Method to set the text passed as parameter inside the corresponding elements.
	public void setinfo(String name, String num, String mail, String pin) {
		method.enterText(name, fullName);
		method.enterText(num, mnumber);
		method.enterText(mail, mailid);
		method.enterText(pin, pinCode);
	}
}
