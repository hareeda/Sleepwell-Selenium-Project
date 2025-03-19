package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class SearchResultPage {

	public WebDriver driver;
	private ReusableMethods method;

	/************ SEARCH RESULTS PAGE WEB ELEMENTS ************/

	@FindBy(xpath = "//div[@id=\"comfort-id\"]/div[2]")
	public WebElement searchResultText1;

	@FindBy(id = "result-info")
	public WebElement searchResultText2;

	@FindBy(id = "clear-btn1")
	public WebElement close;

	@FindBy(id = "search-input-1")
	public WebElement search;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public SearchResultPage(WebDriver driver) {
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

	/************ SEARCH RESULTS PAGE METHODS ************/

	// Method to verify the search result with the element text.
	public boolean verifySearchResult(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	public void enterSearchText(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		method.enterTextEnter(text, element);
	}

}
