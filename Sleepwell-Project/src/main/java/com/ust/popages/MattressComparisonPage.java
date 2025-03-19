package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class MattressComparisonPage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ MATTRESS COMPARISON PAGE WEB ELEMENTS ************/

	@FindBy(className = "compare-product-section")
	public WebElement element;

	@FindBy(css = "#fproductD1Id .product-name")
	public WebElement pdt1Text;

	@FindBy(css = "#fproductD2Id .product-name")
	public WebElement pdt2Text;

	@FindBy(xpath = "//span[@id='selected-option1Id']")
	public WebElement firstDrpdwn;

	@FindBy(xpath = "//span[@id='selected-option2Id']")
	public WebElement secondDrpdwn;

	@FindBy(css = "li:nth-child(1) .citem0Cls:nth-child(4)")
	public WebElement DualMattress1;

	@FindBy(css = "li:nth-child(1) .citem1Cls:nth-child(3)")
	public WebElement Utsav;

	@FindBy(css = "li:nth-child(1) .citem0Cls:nth-child(1)")
	public WebElement Utsavcomfort2;

	@FindBy(css = "li:nth-child(1) .citem1Cls:nth-child(5)")
	public WebElement StraightBack2;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public MattressComparisonPage(WebDriver driver) {
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

	/************ MATTRESS COMPARISON PAGE METHODS ************/

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}
}
