package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class CheckOutPage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public CheckOutPage(WebDriver driver) {
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

	/************ CHECKOUT PAGE METHODS ************/

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}

}
