package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class MattressShopByNeedPage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ MATTRESS SHOP BY NEED PAGE WEB ELEMENTS ************/

	@FindBy(linkText = "ALL COZY & SNUG")
	public WebElement allCozyText;

	@FindBy(linkText = "ALL NPD MATTRESSES")
	public WebElement allNDPText;

	@FindBy(linkText = "ALL MULTI ACTIVITY")
	public WebElement allMultiText;

	@FindBy(linkText = "ALL BACK SUPPORT")
	public WebElement allBackText;

	@FindBy(linkText = "ALL BASICS MATTRESSES")
	public WebElement allBasicsText;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public MattressShopByNeedPage(WebDriver driver) {
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

	/************ MATTRESS SHOP BY NEED PAGE METHODS ************/

	public boolean verifyExpectedResult(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

}
