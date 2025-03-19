package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class MattressSelectorPage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ MATTRESS SELECTOR PAGE WEB ELEMENTS ************/

	@FindBy(css = "#queans0Id label:nth-child(1)")
	public WebElement single;

	@FindBy(css = "#queans0Id label:nth-child(2)")
	public WebElement couple;

	@FindBy(css = "#queans0Id label:nth-child(3)")
	public WebElement patient;

	@FindBy(css = "#queans0Id label:nth-child(4)")
	public WebElement guest;

	@FindBy(css = "#queans0Id label:nth-child(5)")
	public WebElement allmemberuse;

	@FindBy(css = "label > input[type='radio'][id='6'][name='2'][tabindex='0']")
	public WebElement yes;

	@FindBy(css = "label > input[type='radio'][id='7'][name='2'][tabindex='0']")
	public WebElement no;

	@FindBy(css = "#queans2Id label:nth-child(1)")
	public WebElement gentle;

	@FindBy(css = "#queans2Id label:nth-child(2)")
	public WebElement mediumfirm;

	@FindBy(css = "#queans2Id label:nth-child(3)")
	public WebElement firm;

	@FindBy(css = "#queans2Id label:nth-child(4)")
	public WebElement spring;

	@FindBy(css = "#queans2Id label:nth-child(5)")
	public WebElement hitech;

	@FindBy(css = "#queans3Id label:nth-child(1)")
	public WebElement side;

	@FindBy(css = "#queans3Id label:nth-child(2)")
	public WebElement back;

	@FindBy(css = "#queans3Id label:nth-child(3)")
	public WebElement stomach;

	@FindBy(css = "#queans3Id label:nth-child(4)")
	public WebElement multiple;

	@FindBy(css = ".mselectCls:nth-child(1)")
	public WebElement page1;
	
	@FindBy(css = "li.mselectCls[data-slide='3'][data='2']")
	public WebElement page3;

	@FindBy(css = ".mselectCls:nth-child(5)")
	public WebElement page5;
	
	@FindBy(css = "button.slick-next.slick-arrow.slick-custom.slick-custom-next")
	public WebElement nextpage;

	@FindBy(css = "label:nth-child(1) h5")
	public WebElement allergies;

	@FindBy(css = "label:nth-child(2) h5")
	public WebElement pain;

	@FindBy(css = "label:nth-child(3) h5")
	public WebElement tossing;

	@FindBy(css = "label:nth-child(4) h5")
	public WebElement sweating;

	@FindBy(css = "label:nth-child(5) h5")
	public WebElement discomfort;

	@FindBy(css = "label:nth-child(6) h5")
	public WebElement noprob;

	@FindBy(css = ".product-selector-submit")
	public WebElement submit;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public MattressSelectorPage(WebDriver driver) {
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

	/************ MATTRESS SELECTOR PAGE METHODS ************/

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	// Method to click on the element passed to it and passes the driver to Mattress
	// Selector Results page.
	public SelectorResultsPage clickSubmit(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new SelectorResultsPage(driver);
	}

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}

}
