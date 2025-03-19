package com.ust.testcases.general;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.CartPage;
import com.ust.popages.CheckOutPage;
import com.ust.popages.HomePage;
import com.ust.popages.ReversiblePage;

@Listeners(TestListener.class)
public class CartTest extends Settings {

	// Page objects of necessary pages.
	HomePage hpage;
	CartPage cartpage;
	ReversiblePage repage;
	CheckOutPage checkpage;

	// Verifying that user navigates to the reversible mattress page.
	@Test(priority = 1)
	public void navigateToReversibleMattressPage() {
		hpage = setUp(); // Passing the driver to HomePage object after opening the site.
		assertTrue(hpage.verifyCurrentUrl(obj_prop.getProperty("base")), "Home Page was not loaded properly!"); // Asserting
																												// that
																												// the
																												// site
																												// has
																												// loaded
																												// properly
																												// or
																												// not.
		hpage.click(hpage.mattressesDropdown); // Clicking on Mattress Dropdown element.
		repage = hpage.clickReversible(hpage.reversible); // Clicking on Reversible option under shop by need.
		assertTrue(repage.verifyCurrentUrl(expresult_prop.getProperty("reversibleurl"))); // Asserting whether the user
																							// reached the reversible
																							// mattress page.
	}

	// Verifying adding products to cart.
	@Test(priority = 2)
	public void verifyProductAdding() {
		repage.click(repage.dualpromattress); // Clicking on Dual Pro Mattress Product.
		repage.click(repage.addToCart); // Clicking on Add to Cart button element.
		repage.click(repage.close); // Clicking on the close button of add to cart popup.
		navigateBack(); // Navigating back to the Products page.
		repage.click(repage.dualmattress); // Clicking on Dual Mattress Product.
		repage.click(repage.addToCart); // Clicking on Add to Cart button element.
		explicitWait().until(ExpectedConditions.visibilityOf(repage.dualmattressucctext)); // Waiting for the expected
																							// text to be visible.
		assertTrue(repage.verifyString(repage.dualmattressucctext, expresult_prop.getProperty("dualmattress"))); // Asserting
																													// the
																													// expected
																													// text
																													// with
																													// element
																													// text.
		assertTrue(repage.verifyString(repage.dualpromattressucctext, expresult_prop.getProperty("dualpromattress"))); // Asserting
																														// the
																														// expected
																														// text
																														// with
																														// element
																														// text.
		repage.click(repage.close); // Clicking on the close button of add to cart popup.
	}

	// Verifying navigation to Cart Page on clicking Cart icon.
	@Test(priority = 3)
	public void verifyNavigatetoCartPage() {
		cartpage = repage.clickCartIcon(repage.carticon); // Clicking on cart icon.
		assertTrue(cartpage.verifyCurrentUrl(expresult_prop.getProperty("cart"))); // Asserting whether the user reached
																					// the CartPage.
	}

	// Verifying Deletion of product from cart.
	@Test(priority = 4)
	public void verifyDeletingProductFromCart() {
		cartpage.click(cartpage.delete); // Clicking on delete icon of Dual Mattress product.
		assertTrue(method.verifyElementNotPresent(cartpage.dltdqty)); // Asserting whether the deleted element is not
																		// present after deletion.
	}

	// Verifying adding and removing from cart.
	@Test(priority = 5)
	public void verifyAddingandRemovingQuantityofSelected() {
		cartpage.click(cartpage.increaseqtypdt1); // Clicking on + icon of Dual Pro Mattress
		cartpage.click(cartpage.increaseqtypdt1); // Clicking on + icon of Dual Pro Mattress
		cartpage.click(cartpage.increaseqtypdt1); // Clicking on + icon of Dual Pro Mattress
		explicitWait().until(driver -> {
            return cartpage.qtypdt1.getText().contains("4") ? cartpage.qtypdt1 : null;
        }); // Waiting for the quantity to be increased.
		assertTrue(cartpage.verifyQty(cartpage.qtypdt1, "4")); // Asserting whether the quantity has increased to 4.
		cartpage.click(cartpage.decreaseqtypdt1); // Clicking on - icon of Dual Pro Mattress
		cartpage.click(cartpage.decreaseqtypdt1); // Clicking on - icon of Dual Pro Mattress
		explicitWait().until(driver -> {
            return cartpage.qtypdt1.getText().contains("2") ? cartpage.qtypdt1 : null;
        });  // Waiting for the quantity to be decreased.
		assertTrue(cartpage.verifyQty(cartpage.qtypdt1, "2")); // Asserting whether the quantity has decreased to 2.
	}

	// Verifying navigation to CheckoutPage on clicking Checkout button.
	@Test(priority = 6)
	public void verifyNavigatetoCheckoutPage() {
		checkpage = cartpage.clickCheckOutBtn(cartpage.checkOutBtn); // Clciking on checkout button element.
		assertTrue(checkpage.verifyCurrentUrl(expresult_prop.getProperty("checkout"))); // Asserting whether the user
																						// reached the CheckoutPage.
	}

}
