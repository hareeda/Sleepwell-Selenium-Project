package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class ReversiblePage {

	private WebDriver driver;
	private ReusableMethods method;

	/************ REVERSIBLE MATTRESSES PAGE WEB ELEMENTS ************/

	@FindBy(css = ".product-tile:nth-child(1) .product:nth-child(3)")
	public WebElement dualpromattress;

	@FindBy(xpath = "//h5[text()='Dual Pro Profiled Mattress']")
	public WebElement dualpromattressucctext;

	@FindBy(xpath = "//h2/span")
	public WebElement quantity;

	@FindBy(css = ".product-tile:nth-child(2) .product:nth-child(3)")
	public WebElement dualmattress;

	@FindBy(xpath = "//h5[text()='Dual Mattress']")
	public WebElement dualmattressucctext;

	@FindBy(css = ".product-tile:nth-child(3) .product:nth-child(3)")
	public WebElement stargoldmattress;

	@FindBy(css = ".product-tile:nth-child(4) .product:nth-child(3)")
	public WebElement revital2mattress;

	@FindBy(css = "h2 > .popup-close-btn:nth-child(2)")
	public WebElement close;

	@FindBy(css = ".cart")
	public WebElement carticon;

	@FindBy(id = "pdAddToCartID")
	public WebElement addToCart;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public ReversiblePage(WebDriver driver) {
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

	/************ REVERSIBLE MATTRESSES PAGE METHODS ************/

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}

	// Method to click on the element passed to it and passes the driver to Cart
	// page.
	public CartPage clickCartIcon(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new CartPage(driver);
	}

	// Method to verify the expected result with the element text.
	public boolean verifyString(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringEquals(text, element);
	}

}
