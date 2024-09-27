package com.test.automatiom;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;

import com.test.utils.utilsClass;
import com.test.pages.atlasAmericaPurchasePOMPageLatest;
import com.test.helperMethods.*;

public class testCaseAtlasAmericaFinalWithTimingsPOMWiseFinal {

	public static WebDriver driver;
	public Properties prop, expText;
	public String baseUrl = "";

	public String verboseOutput = "";
	public boolean testStatus;

	// Utils object
	utilsClass calDateValue = new utilsClass();

	// HelperUtils object
	helperUtil helperUtls = new helperUtil();

	@BeforeTest
	public void setUp() throws FileNotFoundException, IOException {

		prop = new Properties();
		prop.load(new FileInputStream("./Configuration/configuration_file"));

		expText = new Properties();
		expText.load(new FileInputStream("./AssertationFields/AssertationFieldsTexts"));

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();

		baseUrl = prop.getProperty("baseuUrl_Other");
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	@Test
	public void testCaseAtlasAmericaFinalWithTimingsPOMWise() throws InterruptedException {

		// POM object
		atlasAmericaPurchasePOMPageLatest ap = new atlasAmericaPurchasePOMPageLatest(driver);

		// 1st Page

		// click AcceptCookies Button
		testStatus = ap.clickButton();
		System.out.println("testStatus : " + testStatus);

		// Destination Country Section

		// Click Destination Country
		testStatus = ap.clickDestinationCountryInputTxt();
		System.out.println("testStatus : " + testStatus);

		// Select Destination Country
		testStatus = ap.selectDestinationCountryInput();
		System.out.println("testStatus : " + testStatus);
		
		// Select usGreenCard or not
		testStatus = ap.usGreenCardOrNotInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.nonUSGreenCardInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.travelerCitizenshipInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.travelerResidenceCountryInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.travelerResidenceHomeCountryInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.travelerChoiceResidenceHomeCountryInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.coverageStartDateInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.vIconInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.selectCoverageDateInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.clickEndDateInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.vIconInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.selectEndateInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.clickCheckBoxInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.monthDOBInput();
		System.out.println("testStatus : " + testStatus);
		
		testStatus = ap.selectMonthInput();
		System.out.println("testStatus : " + testStatus);
		
		Thread.sleep(5000);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
