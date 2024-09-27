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
public class atlasAmericaPurchasePOMPageLatest {

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
	public atlasAmericaPurchasePOMPageLatest(WebDriver driver) {
		// Assign the WebDriver instance to the 'driver' variable.
		this.driver = driver;
		// Initialize the WebElements using the PageFactory.
		PageFactory.initElements(driver, this);
	}

	// 1st page

	// Click Accept button
	String acceptButtonXPath = "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/button";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/button")
	WebElement acceptCookieButton;

	public boolean clickButton() throws InterruptedException {

		Thread.sleep(7000);
		hc.checkEleLoaded(driver, acceptButtonXPath);
		try {
			acceptCookieButton.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}
	}

	// click Destination Country
	String destinationCountryInputTxtXpath = "//*[@id=\"destination_home_country\"]";
	@FindBy(how = How.XPATH, using = "//*[@id=\"destination_home_country\"]")
	WebElement destinationCountryInputTxt;

	public boolean clickDestinationCountryInputTxt() throws InterruptedException {
		hc.checkEleLoaded(driver, destinationCountryInputTxtXpath);
		try {
			destinationCountryInputTxt.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	// select Destination Country
	String destinationCountryInputSelectXpath = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[2]";
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[2]")
	WebElement destinationCountryInputSelect;

	public boolean selectDestinationCountryInput() throws InterruptedException {
		hc.checkEleLoaded(driver, destinationCountryInputSelectXpath);
		try {
			destinationCountryInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	// select US Green card or not
	String usGreenCardOrNotXpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]";
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]")
	WebElement usGreenCardOrNotInputSelect;

	public boolean usGreenCardOrNotInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, usGreenCardOrNotXpath);
		try {
			usGreenCardOrNotInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	String nonUSGreenCardXpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[1]";
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
	WebElement nonUSGreenCardInputSelect;

	public boolean nonUSGreenCardInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, nonUSGreenCardXpath);
		try {
			nonUSGreenCardInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	// Traveler's citizenship
	String travelerCitizenshipXpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]";
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]")
	WebElement travelerCitizenshipInputSelect;

	public boolean travelerCitizenshipInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, travelerCitizenshipXpath);
		try {
			travelerCitizenshipInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	String travelerCitizenshipCountryXpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]";
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")
	WebElement travelerCitizenshipCountryInputSelect;

	public boolean travelerResidenceCountryInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, travelerCitizenshipCountryXpath);
		try {
			travelerCitizenshipCountryInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	// Traveler's Residence Home Country
	String travelerResidenceHomeCountryXpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]";
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]")
	WebElement travelerResidenceHomeCountryInputSelect;

	public boolean travelerResidenceHomeCountryInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, travelerResidenceHomeCountryXpath);
		try {
			travelerResidenceHomeCountryInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	String travelerChoiceResidenceHomeCountryXpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]";
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")
	WebElement travelerChoiceResidenceHomeCountryInputSelect;

	public boolean travelerChoiceResidenceHomeCountryInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, travelerChoiceResidenceHomeCountryXpath);
		try {
			travelerChoiceResidenceHomeCountryInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	// Coverage Start Date
	String valueCoverageStartDate = getDates();
	String coverageStartDateXpath = "//input[@placeholder='Coverage Start Date']";
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Coverage Start Date']")
	WebElement coverageStartDateInputSelect;

	public boolean coverageStartDateInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, coverageStartDateXpath);
		try {
			coverageStartDateInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	String vIconXpath = "//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']";
	@FindBy(how = How.XPATH, using = "//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']")
	WebElement vIconInputSelect;

	public boolean vIconInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, vIconXpath);
		try {
			vIconInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	String selectCoverageDateXpath = "//div[normalize-space()='" + valueCoverageStartDate + "']";

	public boolean selectCoverageDateInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, selectCoverageDateXpath);
		try {
			driver.findElement(By.xpath(selectCoverageDateXpath)).click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	// Coverage End Date
	String clickEndDateXpath = "//input[@placeholder='Coverage End Date']";

	public boolean clickEndDateInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, clickEndDateXpath);
		try {
			driver.findElement(By.xpath(clickEndDateXpath)).click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	String selectEndDateXpath = "//div[normalize-space()='" + valCoverageEndDate + "']";

	public boolean selectEndateInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, selectEndDateXpath);
		try {
			driver.findElement(By.xpath(selectEndDateXpath)).click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}
	
	// click the selection checkBox
	String clickCheckBox = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]";
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement clickCheckBoxSelect;
	
	public boolean clickCheckBoxInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, clickCheckBox);
		try {
			clickCheckBoxSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}

	// Date Of Birth Section
		// click the month section of Date of birth
	String monthDOBXpath = "//input[@placeholder='Month']";
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Month']")
	WebElement monthDOBSelect;
	
	public boolean monthDOBInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, monthDOBXpath);
		try {
			monthDOBSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}
		//  select month of Date Of Birth
	String selectMonthXpath = "//span[normalize-space()='Jan']";
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Jan']")
	WebElement selectMonthInputSelect;
	
	public boolean selectMonthInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, selectMonthXpath);
		try {
			selectMonthInputSelect.click();
			return true;
		} catch (Exception exp) {
			System.out.println("Exception : " + exp);
			return false;
		}

	}
	
		// click the date section of Date Of Birth
	String clickDateXpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement clickDateInputSelect;
	
	public boolean clickDateInput() throws InterruptedException {
		Thread.sleep(1500);
		hc.checkEleLoaded(driver, clickDateXpath);
		try {
			clickDateInputSelect.click();
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
