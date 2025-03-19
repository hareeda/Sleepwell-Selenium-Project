package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class WarrantyRegistrationPage {
	
	@FindBy(css = "section > div:nth-child(1) > h1")
	public WebElement warrantyText;
	
	@FindBy(id = "amazon")
	public WebElement radioBtn;
	
	@FindBy(id = "serialNo")
	public WebElement serialNumber;
	
	@FindBy(id = "purchaseDate")
	public WebElement date;
	
	@FindBy(id = "firstName")
	public WebElement fname;
	
	@FindBy(id = "lastName")
	public WebElement lname;
	
	@FindBy(id = "emailId")
	public WebElement emailfield;
	
	@FindBy(id = "mobileNo")
	public WebElement mobileNumber;
	
	@FindBy(id = "pinCode")
	public WebElement pincode;
	
	@FindBy(id = "city")
	public WebElement cityField;
	
	@FindBy(id = "state")
	public WebElement stateField;
	
	@FindBy(id = "country")
	public WebElement countryField;
	
	@FindBy(xpath = "//section/div[2]/div/div[1]/input")
	public WebElement registerBtn;
	
	@FindBy(xpath = "//div[contains(@class, 'snackbar-message') and contains(text(), 'Error : Invalid Mobile number')]")
	public WebElement errormsgMobNo;
	
	@FindBy(xpath = "//div[contains(@class, 'snackbar-message') and contains(text(), 'Error : Serial number not found')]")
	public WebElement errormsgSerialNo;
	
	public WebDriver driver;
	ReusableMethods method;
 
	public WarrantyRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		method = new ReusableMethods(driver);
	}
	
	public String getResult(WebElement element) {
		return method.getTextString(element);
	}
	
	public void click(WebElement element) {
		method.clickOnElement(element);
	}
	
	public void enterDetails(String text, WebElement element) {
		method.enterText(text, element);
	}

	public boolean verifyCurrentUrl(String text) {
		return method.urlContains(text);
	}
	
}
