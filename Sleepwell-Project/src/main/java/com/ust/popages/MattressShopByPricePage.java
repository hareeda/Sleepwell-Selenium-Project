package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class MattressShopByPricePage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ MATTRESS SHOP BY PRICE PAGE WEB ELEMENTS ************/

	@FindBy(id = "listsortId")
	public WebElement priceText;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public MattressShopByPricePage(WebDriver driver) {
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

	/************ MATTRESS SHOP BY PRICE PAGE METHODS ************/

	// Method to verify the expected result with the element text.
	public boolean verifyExpectedResult(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

}
