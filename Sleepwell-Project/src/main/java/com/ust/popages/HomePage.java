package com.ust.popages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.reusable.ReusableMethods;

public class HomePage {

	private WebDriver driver;
	private ReusableMethods method;

	/************ NAVBAR WEB ELEMENTS ************/

	@FindBy(xpath = "NEW")
	public WebElement newNav;

	@FindBy(linkText = "SHOP MATTRESSES")
	public WebElement mattressesDropdown;

	@FindBy(linkText = "SHOP PILLOWS")
	public WebElement pillow;

	@FindBy(linkText = "FIND SHOWROOM")
	public WebElement findShowroom;

	@FindBy(xpath = "//span[@class='offer visit-linkCls']")
	public WebElement offerNav;

	@FindBy(xpath = "//span[@class='search icon']")
	public WebElement searchIcon;

	@FindBy(id = "search-inputId")
	public WebElement search;

	@FindBy(id = "store-location-cta2Id")
	public WebElement location;

	@FindBy(name = "select-pin")
	public WebElement pincode;

	@FindBy(id = "selectCity")
	public WebElement citydropdown;

	@FindBy(css = "input[type='submit'][class='site-btn location-btn']")
	public WebElement submit;

	@FindBy(xpath = "//div[2]/div[1]/div[1]/button[1]")
	public WebElement searchbtn;

	@FindBy(id = "accountNameId")
	public WebElement signInIncon;

	@FindBy(xpath = "//a[@class='cart icon cart-icon']")
	public WebElement cartIcon;

	@FindBy(className = "hamburger-menu")
	public WebElement menuBar;

	/************ MATRESS DROPDOWN'S WEB ELEMENTS ************/

	@FindBy(linkText = "MATTRESS SELECTOR")
	public WebElement mattressSelector;

	@FindBy(linkText = "COMPARE MATTRESSES")
	public WebElement compareMattresses;

	@FindBy(linkText = "ALL MATTRESSES")
	public WebElement allMattresses;

	@FindBy(partialLinkText = "need")
	public WebElement shopByNeed;

	@FindBy(partialLinkText = "user")
	public WebElement shopByUser;

	@FindBy(partialLinkText = "tech")
	public WebElement shopByTech;

	@FindBy(partialLinkText = "price")
	public WebElement shopByPrice;

	@FindBy(partialLinkText = "size")
	public WebElement shopBySize;

	/************ SHOP BY NEED DROPDOWN'S WEB ELEMENTS ************/

	@FindBy(xpath = "//a[@class='visit-linkCls' and contains(text(), 'Cozy & snug')]")
	public WebElement cozysnug;

	@FindBy(xpath = "//a[@class='visit-linkCls' and contains(text(), 'No partner disturbance')]")
	public WebElement nopartnerdisturbance;

	@FindBy(xpath = "//a[@class='visit-linkCls' and contains(text(), 'Multi activity')]")
	public WebElement multiactivity;

	@FindBy(css = "li:nth-child(1) li:nth-child(4) > .visit-linkCls")
	public WebElement backsupport;

	@FindBy(css = "li:nth-child(1) li:nth-child(5) > .visit-linkCls")
	public WebElement reversible;

	/************ SHOP BY USER DROPDOWN'S WEB ELEMENTS ************/

	@FindBy(css = "li:nth-child(2) li:nth-child(1) > .visit-linkCls")
	public WebElement indvidual;

	@FindBy(css = "li:nth-child(2) li:nth-child(2) > .visit-linkCls")
	public WebElement couplewithkids;

	@FindBy(css = "li:nth-child(2) li:nth-child(3) > .visit-linkCls")
	public WebElement couples;

	@FindBy(css = "li:nth-child(2) li:nth-child(4) > .visit-linkCls")
	public WebElement guests;

	@FindBy(css = "li:nth-child(2) li:nth-child(5) > .visit-linkCls")
	public WebElement elders;

	/************ SHOP BY TECH DROPDOWN'S WEB ELEMENTS ************/

	@FindBy(css = "li:nth-child(3) li:nth-child(1) > .visit-linkCls")
	public WebElement pronexa;

	@FindBy(css = "li:nth-child(3) li:nth-child(2) > .visit-linkCls")
	public WebElement profitrest;

	@FindBy(css = "li:nth-child(3) li:nth-child(3) > .visit-linkCls")
	public WebElement prolatex;

	@FindBy(css = "li:nth-child(3) li:nth-child(4) > .visit-linkCls")
	public WebElement spintech;

	@FindBy(css = "li:nth-child(3) li:nth-child(5) > .visit-linkCls")
	public WebElement acuprofile;

	/************ SHOP BY PRICE DROPDOWN'S WEB ELEMENTS ************/

	@FindBy(css = "li:nth-child(4) li:nth-child(1) > .visit-linkCls")
	public WebElement above4k;

	@FindBy(css = "li:nth-child(4) li:nth-child(2) > .visit-linkCls")
	public WebElement above15k;

	@FindBy(css = "li:nth-child(4) li:nth-child(3) > .visit-linkCls")
	public WebElement above25k;

	@FindBy(css = "li:nth-child(4) li:nth-child(4) > .visit-linkCls")
	public WebElement above35k;

	/************ SHOP BY SIZE DROPDOWN'S WEB ELEMENTS ************/

	@FindBy(css = "li:nth-child(5) li:nth-child(1) > .visit-linkCls")
	public WebElement kingsize;

	@FindBy(css = "li:nth-child(5) li:nth-child(2) > .visit-linkCls")
	public WebElement queensize;

	@FindBy(css = "li:nth-child(5) li:nth-child(3) > .visit-linkCls")
	public WebElement singlebed;

	@FindBy(css = "li:nth-child(5) li:nth-child(4) > .visit-linkCls")
	public WebElement doublebed;

	@FindBy(css = "li:nth-child(5) li:nth-child(5) > .visit-linkCls")
	public WebElement custom;

	/************ MENU'S WEB ELEMENTS ************/

	@FindBy(xpath = "//span[contains(text(),'My ACCOUNT')]")
	public WebElement myAccountDropdown;

	@FindBy(xpath = "//a[text()='FAQs']")
	public WebElement faqs;

	@FindBy(xpath = "//li[12]/a[1]")
	public WebElement warrantyRegistration;

	@FindBy(linkText = "Institutional enquiry")
	public WebElement institutionalEnquiry;

	@FindBy(linkText = "WARRANTY")
	public WebElement warrantylink;

	@FindBy(xpath = "//span[@style = 'cursor: pointer;']")
	public WebElement offerlink;

	/************ MY ACOOUNT DROPDOWN'S WEB ELEMENTS ************/

	@FindBy(id = "myProfile")
	public WebElement myProfile;

	@FindBy(id = "myAddress")
	public WebElement myAddress;

	@FindBy(id = "myOrder")
	public WebElement myOrder;

	@FindBy(xpath = "//a[contains(text(),'Track Order')]")
	public WebElement trackorder;

	@FindBy(xpath = "//a[@href='https://mysleepwell.com/new' and @class='visit-linkCls']")
	public WebElement newlink;

	/************ SOCIAL MEDIA LINK WEB ELEMENTS ************/

	@FindBy(className = "facebook")
	public WebElement facebook;

	@FindBy(className = "instagram")
	public WebElement instagram;

	@FindBy(className = "youtube")
	public WebElement youtube;

	@FindBy(className = "twitter")
	public WebElement twitter;

	/************ PARAMATERIZED CONSTRUCTOR ************/

	public HomePage(WebDriver driver) {
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

	/************ HOME PAGE METHODS ************/

	// Method to click on the element passed to it and passes the driver to Mattress
	// Shop by need page.
	public MattressShopByNeedPage clickshopByNeed(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new MattressShopByNeedPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Mattress
	// Shop by user page.
	public MattressesShopByUserPage clickshopByUserNeed(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new MattressesShopByUserPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Mattress
	// Shop by tech page.
	public MattressesShopByTechPage clickshopByTech(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new MattressesShopByTechPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Mattress
	// Shop by price page.
	public MattressShopByPricePage clickshopByPrice(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new MattressShopByPricePage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Mattress
	// Shop by size page.
	public MattressesShopBySizePage clickshopBySize(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new MattressesShopBySizePage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Mattress
	// Selector page.
	public MattressSelectorPage clickMattresses(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new MattressSelectorPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Offer
	// page.
	public OffersPage clickOfferLink(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new OffersPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to New
	// page.
	public NewPage clickNewLink(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new NewPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Pillows
	// page.
	public PillowsPage clickPillows(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new PillowsPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Find
	// Showroom page.
	public FindShowroomPage clickFindShowroom(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new FindShowroomPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Search
	// Results page.
	public SearchResultPage enterSearchText(WebElement element, String text) {
		method.enterTextEnter(text, element);
		return new SearchResultPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Contact
	// Us page.
	public ContactUsPage clickSaathiSofaRefurbishment(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new ContactUsPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Profile
	// page.
	public ProfilePage clickMyProfile(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new ProfilePage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Login
	// page.
	public LoginPage clickMyProfileSignIn(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new LoginPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to FAQ
	// page.
	public FaqPage clickFAQS(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new FaqPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Login
	// page.
	public LoginPage clickLogin(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new LoginPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to
	// Institutional page.
	public InstitutionalPage clickInstEnquiry(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new InstitutionalPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Mattress
	// Comparison page.
	public MattressComparisonPage clickMattressCompare(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new MattressComparisonPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Warranty
	// page.
	public WarrantyPage clickWarranty(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new WarrantyPage(driver);
	}

	// Method to click on the element passed to it and passes the driver to
	// Reversible Mattress page.
	public ReversiblePage clickReversible(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new ReversiblePage(driver);
	}

	// Method to click on the element passed to it and passes the driver to Server
	// Error page.
	public ServerErrorPage geturl(String url) {
		if (url == null) {
			throw new NullPointerException("Text cannot be null");
		}
		method.getURL(url);
		return new ServerErrorPage(driver);
	}
	
	public WarrantyRegistrationPage clickWarrantyRegistration(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new WarrantyRegistrationPage(driver);
	}

	// Method to click on the element passed to it.
	public void click(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
	}

	// Method to verify whether driver's current url contains the text passed.
	public boolean verifyCurrentUrl(String url) {
		if (url == null) {
			throw new NullPointerException("Text cannot be null");
		}
		return method.verifyURL(url);
	}

	// Method to verify that the dropdown element is clickable.
	public boolean verifyDropDownClickable(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		return method.isElementClickable(element);
	}

	// Method to verify that the link element is clickable.
	public boolean verifyLinkClickable(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		return method.isElementClickable(element);
	}

	// Method to verify the expected text is the text of element.
	public boolean verifyLinkText(String text, WebElement element) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		return method.isStringMatch(text, element);
	}

	// Method to click on the element passed to it and passes the driver to Social
	// Media page.
	public SocialMediaPage clickSocialMediaLink(WebElement element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		method.clickOnElement(element);
		return new SocialMediaPage(driver);
	}

	public void enterPincode(String text, WebElement element) {
		if (element == null || text == null) {
			throw new NullPointerException("Element or Text cannot be null");
		}
		method.enterText(text, element);
	}

	public boolean verifyExpectedText(WebElement element, String text) {
		return method.isStringMatch(text, element);
	}

	public void selectCityFromDropDown(WebElement element, String text) {
		method.selectDropDownValue(element, text);
	}

}
