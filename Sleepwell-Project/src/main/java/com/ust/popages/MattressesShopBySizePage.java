package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class MattressesShopBySizePage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ MATTRESS SHOP BY SIZE PAGE WEB ELEMENTS ************/

	@FindBy(xpath = "//div[@class='product-title'][text()='Ortho Pro Profiled Mattress']")
	public WebElement text;

	@FindBy(id = "sid")
	public WebElement sizeText;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public MattressesShopBySizePage(WebDriver driver) {
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

	/************ MATTRESS SHOP BY SIZE PAGE METHODS ************/

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	// Method to verify the expected result with the element text.
	public boolean verifyExpectedResult(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

}
