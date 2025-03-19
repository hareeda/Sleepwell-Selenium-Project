package com.ust.reusable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods {

	public WebDriver driver;
	public Actions actions;

	public ReusableMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Reusable method for opening the url.
	public void getURL(String url) {
		try {
			driver.get(url);
		} catch (WebDriverException e) {
			// Handle WebDriverException if there is an issue with WebDriver interactions
			System.err.println("Error navigating to URL: " + url);
			e.printStackTrace(); // Print stack trace for debugging purposes
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error navigating to URL: " + url);
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
	}

	// Reusable method for clicking an element.
	public void clickOnElement(WebElement element) {
		try {
			Thread.sleep(500);
			element.click();
		} catch (InterruptedException e) {
			// Handle InterruptedException if the thread is interrupted while sleeping
	        e.printStackTrace(); // Print stack trace for debugging purposes
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage()); // Handle NoSuchElementException
		}
	}

	// Reusable method for getting string text.
	public String getTextString(WebElement element) {
		try {
            String text = element.getText();
            return text;
        } catch (Exception e) {
            // Handle any exceptions that occur during retrieving text from the element
            System.err.println("Error retrieving text from element.");
            e.printStackTrace(); // Print stack trace for debugging purposes
            return null; // Returning null as there was an unexpected error
        }
	}

	// Reusable method for entering string text to input box and clicking enter.
	public void enterTextEnter(String text, WebElement element) {
		try {
			Thread.sleep(500);
			element.sendKeys(text, Keys.ENTER);
		} catch (InterruptedException e) {
			// Handle InterruptedException if the thread is interrupted while sleeping
	        e.printStackTrace(); // Print stack trace for debugging purposes
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage()); // Handle NoSuchElementException
		}
	}

	// Reusable method for entering string text to input box.
	public void enterText(String text, WebElement element) {
		try {
			Thread.sleep(500);
			element.clear();
			element.sendKeys(text);
		} catch (InterruptedException e) {
			// Handle InterruptedException if the thread is interrupted while sleeping
	        e.printStackTrace(); // Print stack trace for debugging purposes
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage()); // Handle NoSuchElementException
		}
	}

	// Reusable method for verifying element String contains text.
	public boolean isStringMatch(String text, WebElement element) {
		if ((element.getText()).contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	// Reusable method for verifying element String equals text.
	public boolean isStringEquals(String text, WebElement element) {
		if ((element.getText()).equals(text)) {
			return true;
		} else {
			return false;
		}
	}

	// Reusable method for verifying current url equals url.
	public boolean verifyURL(String url) {
		if ((driver.getCurrentUrl()).equals(url)) {
			return true;
		} else {
			return false;
		}
	}

	// Reusable method for verifying current url contains text.
	public boolean urlContains(String text) {
		if ((driver.getCurrentUrl()).contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	// Reusable method verifying element is present.
	public boolean verifyElementPresent(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	// Reusable method verifying element is not present.
	public boolean verifyElementNotPresent(WebElement element) {
		try {
			return !element.isDisplayed();
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	// Reusable method verifying element is enabled.
	public boolean isElementClickable(WebElement element) {
		return element.isEnabled();
	}

	// Reusable method verifying element is disabled.
	public boolean isElementNotClickable(WebElement element) {
		return !element.isEnabled();
	}

	// Reusable method to select dropdown using VisibleText.
	public void selectDropDownText(WebElement element, String text) {
		try {
			Select dropDwn = new Select(element);
			dropDwn.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage()); // Handle NoSuchElementException
		}
	}

	// Reusable method to select dropdown using Index.
	public void selectDropDownIndex(WebElement element, int index) {
		try {
			Select dropDwn = new Select(element);
			dropDwn.selectByIndex(index);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage()); // Handle NoSuchElementException
		}
	}

	// Reusable method to select dropdown using Value.
	public void selectDropDownValue(WebElement element, String value) {
		try {
			Select dropDwn = new Select(element);
			dropDwn.selectByValue(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage()); // Handle NoSuchElementException
		}
	}

	// Reusable method to get the alert text.
	public String getAlertText() {
		try {
			return driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			// Handle NoAlertPresentException if there is no alert present
			System.err.println("No alert present.");
			return null; // Returning null as there is no alert present
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error retrieving text from alert.");
			e.printStackTrace(); // Print stack trace for debugging purposes
			return null; // Returning null as there was an unexpected error
		}
	}

	// Reusable method to accept the alert.
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// Handle NoAlertPresentException if there is no alert present
			System.err.println("No alert present.");
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error retrieving text from alert.");
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
	}

	// Reusable method for scrolling.
	public void scrolltoElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage()); // Handle NoSuchElementException
		} catch (Exception e) {
			// Handle any exceptions that occur during scrolling
			System.err.println("Error scrolling element into view.");
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
	}

	public boolean isStringMatch(String text, String expected) {
		if (expected.contains(text)) {
			return true;
		} else {
			return false;
		}
	}
}
