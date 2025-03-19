package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class SelectorResultsPage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ SELECTOR RESULTS PAGE WEB ELEMENTS ************/

	@FindBy(xpath = "//section[2]/div[1]/div[2]/div[1]/span[1]")
	public WebElement validtext;

	@FindBy(className = "back-btn")
	public WebElement backbtn;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public SelectorResultsPage(WebDriver driver) {
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

	// Method to verify the expected result with the element text.
	public boolean verifyExpectedResult(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

	public MattressSelectorPage clickBack(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new MattressSelectorPage(driver);
	}

}
