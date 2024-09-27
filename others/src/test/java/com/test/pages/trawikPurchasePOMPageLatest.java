package com.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // Import WebDriver to interact with the browser.
import org.openqa.selenium.WebElement; // Import WebElement to locate elements.
import org.openqa.selenium.support.FindBy; // Import FindBy to locate elements.
import org.openqa.selenium.support.How; // Import How to specify the locator strategy.
import org.openqa.selenium.support.PageFactory; // Import PageFactory to initialize elements.

import com.test.utils.utilsClass;
import com.test.helperMethods.helperUtil;

/**
 * This class represents the Google Home Page.
 */
public class trawikPurchasePOMPageLatest {

	public String valCoverageStartDate = null;
	public String valCoverageEndDate = null;
	public String valArrivalDate = null;
	public ArrayList<String> arListDate = new ArrayList<String>();
	utilsClass calDateValue = new utilsClass();

	// WebDriver reference variable.
	private WebDriver driver;
	helperUtil hc = new helperUtil();

	/**
	 * Constructor for the atlasAmericaPurchasePOMPageLatest class.
	 * 
	 * @param driver The WebDriver instance.
	 */
	public trawikPurchasePOMPageLatest(WebDriver driver) {
		// Assign the WebDriver instance to the 'driver' variable.
		this.driver = driver;
		// Initialize the WebElements using the PageFactory.
		PageFactory.initElements(driver, this);
	}

	// 1st page 
	String destination_home_country_USA_POM_Str = "US";
	//@FindBy(how = How.XPATH, using = "//*[@data-value='US']")
	@FindBy(how = How.XPATH, using = "//*[@data-value='US']")
	WebElement destination_home_country_USA_POM_WE;
	
	
	// 1st set 1 thro 5!
		public boolean selectdestination_home_country_USA_POM_WE() throws InterruptedException {

			try {

				Thread.sleep(3000);

				destination_home_country_USA_POM_WE.click();

				Thread.sleep(2500);



				return true;
			} catch (Exception exp) {
				System.out.println("Exception : " + exp);
				return false;
			}
		}
	
	// 2nd page

	// click disabilityUpgradeDropDown
	String disabilityUpgradeDropDown = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/input";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/input")
	WebElement disabilityUpgradeDropDownWebElement;

	// select option "none" from the Drop Down
	String disabilityUpgradeDropDownNone = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/input";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/input")
	WebElement disabilityUpgradeDropDownNoneWebElement;

	// select option "increase to $50,0000.00
	String disabilityUpgradeDropDown50k = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[2]";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[2]")
	WebElement disabilityUpgradeDropDown50kWebElement;

	// select option "increase to $100,0000.00
	String disabilityUpgradeDropDown100k = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[3]";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[3]")
	WebElement disabilityUpgradeDropDown100kWebElement;

	// select option "increase to $250,0000.00
	String disabilityUpgradeDropDown250k = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[4]";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[4]")
	WebElement disabilityUpgradeDropDown250kWebElement;

	// select option "increase to $500,0000.00
	String disabilityUpgradeDropDown500k = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[5]";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[5]")
	WebElement disabilityUpgradeDropDown500kWebElement;

	// section to deal with "Return to home country" drop down

	// click the "Return to home country drop down"
	String returnToHomeCountryDropDown = "//input[@id='follow_me_home_new']";
	@FindBy(how = How.XPATH, using = "//input[@id='follow_me_home_new']")
	WebElement returnToHomeCountryDropDownWebElement;

	// select the option "Yes" from "Return to home country" drop down
	String returnToHomeCountryDropDownYes = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[2]/div/div[2]/span/div/div/div/ul/li[1]/span";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[2]/div/div[2]/span/div/div/div/ul/li[1]/span")
	WebElement returnToHomeCountryDropDownYesWebElement;

	// select the option "No" from "Return to home country" drop down
	String returnToHomeCountryDropDownNo = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[2]/div/div[2]/span/div/div/div/ul/li[2]";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[2]/div/div[2]/span/div/div/div/ul/li[2]")
	WebElement returnToHomeCountryDropDownNoWebElement;

	// section to deal with "Sports Activity Coverage"

	// click "Sports Activity Coverage" drop down

	// *[@id=\"athletic_sports_new\"]

	String sportsActivityCoverageDropDown = "//*[@id=\"athletic_sports_new\"]";
	@FindBy(how = How.XPATH, using = "//*[@id=\"athletic_sports_new\"]")
	WebElement sportsActivityCoverageDropDownWebElement;

	// select option "yes1" from "Sports Activity Coverage" drop down

	String sportsActivityCoverageDropDownYes1 = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[3]/div/div[2]/span/div/div/div/ul/li[1]";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[3]/div/div[2]/span/div/div/div/ul/li[1]")
	WebElement sportsActivityCoverageDropDownWebYes1Element;
	
	// select option "Yes2" from "Sports Activity Coverage" drop down

	String sportsActivityCoverageDropDownYes2 = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[2]/div/div[2]/span/div/div/div/ul/li[2]";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div/div[2]/div/div[2]/span/div/div/div/ul/li[2]")
	WebElement sportsActivityCoverageDropDownWebYes2Element;
	
	// select option "no" from "Sports Activity Coverage" drop down

	String sportsActivityCoverageDropDownNo = "//*[@id=\"athletic_sports_new\"]";
	@FindBy(how = How.XPATH, using = "//*[@id=\"athletic_sports_new\"]")
	WebElement sportsActivityCoverageDropDownWebNoElement;

	// 1st set 1 thro 5!
	public boolean selectOptAddOnBenefitsNone() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDownNone);
			disabilityUpgradeDropDownNoneWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits50k() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown50k);
			disabilityUpgradeDropDown50kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits100k() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown100k);
			disabilityUpgradeDropDown100kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits250k() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown250k);
			disabilityUpgradeDropDown250kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits500k() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown500k);
			disabilityUpgradeDropDown500kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	// 2nd set of 1 thro 5:

	public boolean selectOptAddOnBenefitsNone_homeCountry_Yes() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDownNone);
			disabilityUpgradeDropDownNoneWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownYes);
			returnToHomeCountryDropDownYesWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits50k_homeCountry_Yes() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown50k);
			disabilityUpgradeDropDown50kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownYes);
			returnToHomeCountryDropDownYesWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits100k_homeCountry_Yes() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown100k);
			disabilityUpgradeDropDown100kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownYes);
			returnToHomeCountryDropDownYesWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits250k_homeCountry_Yes() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown250k);
			disabilityUpgradeDropDown250kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownYes);
			returnToHomeCountryDropDownYesWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits500k_homeCountry_Yes() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown500k);
			disabilityUpgradeDropDown500kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownYes);
			returnToHomeCountryDropDownYesWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownNo);
			sportsActivityCoverageDropDownWebNoElement.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}
	// 3rd set 1 thro 5!
	public boolean selectOptAddOnBenefitsNone_sportsActivityCoverageDropDownYes1() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDownNone);
			disabilityUpgradeDropDownNoneWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownYes1);
			sportsActivityCoverageDropDownWebYes1Element.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits50k_sportsActivityCoverageDropDownYes1() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown50k);
			disabilityUpgradeDropDown50kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownYes1);
			sportsActivityCoverageDropDownWebYes1Element.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits100k_sportsActivityCoverageDropDownYes1() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown100k);
			disabilityUpgradeDropDown100kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownYes1);
			sportsActivityCoverageDropDownWebYes1Element.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits250k_sportsActivityCoverageDropDownYes1() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown250k);
			disabilityUpgradeDropDown250kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownYes1);
			sportsActivityCoverageDropDownWebYes1Element.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	public boolean selectOptAddOnBenefits500k_sportsActivityCoverageDropDownYes1() throws InterruptedException {

		try {

			Thread.sleep(3000);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown);
			disabilityUpgradeDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, disabilityUpgradeDropDown500k);
			disabilityUpgradeDropDown500kWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDown);
			returnToHomeCountryDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, returnToHomeCountryDropDownNo);
			returnToHomeCountryDropDownNoWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDown);
			sportsActivityCoverageDropDownWebElement.click();

			Thread.sleep(2500);

			hc.checkEleLoaded(driver, sportsActivityCoverageDropDownYes1);
			sportsActivityCoverageDropDownWebYes1Element.click();

			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	// select date for Date of Birth

	// end of 1st page

	public String getDates() {
		// System.out.println(calDateValue.calDatePlusListDays(0, 0, 19, 5));
		// String valCoverageStartDate = null;
		// String valCoverageEndDate = null;
		// String valArrivalDate = null;
		// ArrayList<String> arListDate = new ArrayList<String>();
		arListDate.addAll(calDateValue.calDatePlusListDays(0, 0, 19, 5));

		for (int index = 0; index < arListDate.size(); index++) {
			System.out.println(arListDate.get(index));

			if (index == 1) {
				System.out.println(arListDate.get(index));
				System.out.println(calDateValue.splitDates(arListDate.get(index)));
				valCoverageEndDate = calDateValue.splitDates(arListDate.get(index));
				valCoverageEndDate = removeZero(valCoverageEndDate);
				System.out.println("valCoverageEndDate : " + valCoverageEndDate);
			}

			if (index == 2) {
				System.out.println(arListDate.get(index));
				System.out.println(calDateValue.splitDates(arListDate.get(index)));
				valCoverageStartDate = arListDate.get(index);
				System.out.println("valCoverageStartDate : " + valCoverageStartDate);
				valArrivalDate = calDateValue.splitDates(arListDate.get(index));
				System.out.println("valArrivalDate : " + valArrivalDate);
				valArrivalDate = removeZero(valArrivalDate);
				System.out.println("Find and replace in a line :" + valArrivalDate + ":");
				System.out.println("");
			}
		}

		System.out.println("=====> valCoverageStartDate : " + valCoverageStartDate);
		System.out.println("=====> valArrivalDate : " + valArrivalDate);

		valCoverageStartDate = valArrivalDate;

		System.out.println("=====> valCoverageStartDate : " + valCoverageStartDate);
		System.out.println("=====> valArrivalDate : " + valArrivalDate);

		return valCoverageStartDate;
	}

	public void selectByList() throws InterruptedException {
		// WebDriver driver = new ChromeDriver();
		driver.get("https://www.bstackdemo.com/");
		Thread.sleep(3500);
		driver.findElement(By.xpath("//select")).click();
		Thread.sleep(3500);
		List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
		String option = "Highest to lowest";
		// Iterate the list using for loop
		for (int i = 0; i < allOptions.size(); i++) {
			Thread.sleep(3500);
			if (allOptions.get(i).getText().contains(option)) {
				Thread.sleep(3500);
				allOptions.get(i).click();
				Thread.sleep(3500);
				System.out.println("clicked");
				break;
			}
		}
	}

	public static String removeZero(String str) {

		// Count leading zeros

		// Initially setting loop counter to 0
		int i = 0;
		while (i < str.length() && str.charAt(i) == '0')
			i++;

		// Converting string into StringBuffer object
		// as strings are immutable
		StringBuffer sb = new StringBuffer(str);

		// The StringBuffer replace function removes
		// i characters from given index (0 here)
		sb.replace(0, i, "");

		// Returning string after removing zeros
		return sb.toString();
	}

	//
}
