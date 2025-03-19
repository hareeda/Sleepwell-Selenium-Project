package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class InstitutionalPage {

	WebDriver driver;
	private ReusableMethods method;

	/************ INSTITUTIONAL ENQUIRY PAGE WEB ELEMENTS ************/

	@FindBy(id = "requirement")
	public WebElement requirementFor;

	@FindBy(id = "productRequirement")
	public WebElement productReq;

	@FindBy(id = "quantity")
	public WebElement quantitys;

	@FindBy(id = "Otherproducts")
	public WebElement otherProducts;

	@FindBy(id = "state")
	public WebElement selectState;

	@FindBy(id = "city")
	public WebElement selectCity;

	@FindBy(id = "personName")
	public WebElement pername;

	@FindBy(id = "organisationName")
	public WebElement orgName;

	@FindBy(id = "emailId")
	public WebElement mailId;

	@FindBy(id = "mobileNumber")
	public WebElement phNumber;

	@FindBy(id = "description")
	public WebElement desCription;

	@FindBy(id = "site-btnId")
	public WebElement registerbtn;

	@FindBy(xpath = "//span[contains(text(),'Please Select Your Drop Down')]")
	public WebElement errText;

	@FindBy(xpath = "//div[16]/div[1]/div[2]")
	public WebElement successMsg;

	@FindBy(xpath = "//a[@href='/saathi' and contains(@class, 'submenu-card')]")
	public WebElement sofarefurbishment;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public InstitutionalPage(WebDriver driver) {
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

	/************ INSTITUTIONAL ENQUIRY PAGE METHODS ************/

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	// Method to enter the text onto the element passed to it.
	public void enterDetails(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		method.enterText(text, element);
	}

	// Method to select the intended option from the dropdown element.
	public void enterDetailsDrop(WebElement element, String text) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		method.selectDropDownText(element, text);
	}

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}

	// Method to check if the element is disabled.
	public boolean checkBtnDisabled(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		return method.isElementNotClickable(element);
	}

	public ContactUsPage clcikSofaRefurbishment(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new ContactUsPage(driver);
	}

}
