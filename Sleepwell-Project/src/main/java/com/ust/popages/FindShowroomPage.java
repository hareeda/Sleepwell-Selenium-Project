package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class FindShowroomPage {

	WebDriver driver;
	private ReusableMethods method;

	/************ FIND SHOWROOM PAGE WEB ELEMENTS ************/

	@FindBy(id = "select2-cityId-container")
	public WebElement citySelectContainer;

	@FindBy(className = "select2-search__field")
	public WebElement enterACityText;

	@FindBy(id = "select2-areaId-container")
	public WebElement areaSelectContainer;

	@FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']")
	public WebElement enterAnAreaText;

	@FindBy(id = "storecnt")
	public WebElement resText;

	@FindBy(id = "select2-cityId-results")
	public WebElement errorText;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public FindShowroomPage(WebDriver driver) {
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

	/************ FIND SHOWROOM PAGE METHODS ************/

	// Method to verify the expected result with the element text.
	public boolean verifyExpectedResult(String text, WebElement element) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String url) {
		if (url == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(url);
	}

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	// Method to enter the text onto the element passed to it.
	public void enterString(String text, WebElement element) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		method.enterTextEnter(text, element);
	}

}
