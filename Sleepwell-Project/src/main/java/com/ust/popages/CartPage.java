package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class CartPage {

	private WebDriver driver;
	private ReusableMethods method;

	/************ CART PAGE WEB ELEMENTS ************/
	
	@FindBy(xpath = "//button[@class='increase-qty' and @data='0']")
	public WebElement increaseqtypdt1;

	@FindBy(id = "cart-qtyid0")
	public WebElement qtypdt1;

	@FindBy(xpath = "//button[@class='decrease-qty' and @data='0']")
	public WebElement decreaseqtypdt1;

	@FindBy(className = "delete-item")
	public WebElement delete;

	@FindBy(xpath = "//h5[text()='Dual Mattress']")
	public WebElement dltdqty;
	
	@FindBy(css = "input[type='submit'][value='Proceed to checkout']")
	public WebElement checkOutBtn;

	/************ PARAMATERIZED CONSTRUCTOR ************/
	
	public CartPage(WebDriver driver) {
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

	/************ CART PAGE METHODS ************/
	
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

	// Method to verify the expected quantity text is the text of element.
	public boolean verifyQty(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringEquals(text, element);
	}

	// Method to click on Checkout button element passed to it and passes the driver to checkout page.
	public CheckOutPage clickCheckOutBtn(WebElement element) {
		method.clickOnElement(element);
		return new CheckOutPage(driver);
	}
}
