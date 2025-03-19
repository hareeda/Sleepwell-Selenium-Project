package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class MattressesShopByTechPage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ MATTRESS SHOP BY TECH PAGE WEB ELEMENTS ************/

	@FindBy(xpath = "//div/div[2]/div/div/div/div[1]/div/h2")
	public WebElement proFitrestText;

	@FindBy(linkText = "Pro Nexa mattress")
	public WebElement NexaText;

	@FindBy(linkText = "Ortho mattress")
	public WebElement orthoText;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public MattressesShopByTechPage(WebDriver driver) {
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

	/************ MATTRESS SHOP BY TECH PAGE METHODS ************/

	// Method to verify the expected result with the element text.
	public boolean verifyExpectedResult(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

}
