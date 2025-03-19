package com.ust.popages;

import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class PillowsPage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ PILLOWS PAGE WEB ELEMENTS ************/

	@FindBy(css = "li:nth-child(1) > label h5")
	public WebElement fibrepillows;

	@FindBy(css = "li:nth-child(2) .itemcontent")
	public WebElement regualrtechpillows;

	@FindBy(css = "li:nth-child(3) h5")
	public WebElement contourtechpillows;

	@FindBy(xpath = "//span[@class='total-results' and text()='No Records Found']")
	public WebElement noresults;

	@FindBy(css = ".clear-btn:nth-child(2)")
	public WebElement clearfilter;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public PillowsPage(WebDriver driver) {
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

	/************ PILLOWS PAGE METHODS ************/

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

	// Method to verify the expected result with the element text.
	public boolean verifyExpectedResult(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

	// Method returning a list of elements present in each categories.
	 public LinkedList<WebElement> getListElements() {
	        LinkedList<WebElement> elementsList = new LinkedList<>();
	        elementsList.addAll(driver.findElements(By.cssSelector("#plistid > .product-tile:nth-child(1) .product-title")));
	        elementsList.addAll(driver.findElements(By.cssSelector(".product-tile:nth-child(2) .product-title")));
	        elementsList.addAll(driver.findElements(By.cssSelector(".product-tile:nth-child(3) .product-title")));
	        return elementsList;
	    }

}
