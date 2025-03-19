package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class ContactUsPage {
	
	private WebDriver driver;
	private ReusableMethods method;

	/************ CONTACT US PAGE WEB ELEMENTS ************/

	@FindBy(id = "firstName")
	public WebElement first;

	@FindBy(id = "lastName")
	public WebElement last;

	@FindBy(id = "emailId")
	public WebElement email;

	@FindBy(id = "mobileNo")
	public WebElement num;

	@FindBy(id = "message")
	public WebElement msg;

	@FindBy(css = "div.write-to-us-form > div > input")
	public WebElement submit;
	
	@FindBy(xpath = "//section[1]/ul[1]/li[3]/a[1]")
	public WebElement saathiHome;
	
	@FindBy(xpath = "//div[16]/div[1]/div[2]")
	public WebElement successMsg;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public ContactUsPage(WebDriver driver) {
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

	/************ CONTACT US PAGE METHODS ************/

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

	// Method to check if the element is disabled.
	public boolean buttonDisabled(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		return method.isElementNotClickable(element);
	}

	// Method to click on the element passed to it and passes the driver to callback form page.
	public CallBackForm clickCallBack(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new CallBackForm(driver);
	}

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.urlContains(text);
	}

	// Method to set the text passed as parameter inside the corresponding elements.
	public void setinfo(String firstn, String lastn, String mail, String phnnumber, String mesg) {
		method.enterText(firstn, first);
		method.enterText(lastn, last);
		method.enterText(mail, email);
		method.enterText(phnnumber, num);
		method.enterText(mesg, msg);
	}
}
