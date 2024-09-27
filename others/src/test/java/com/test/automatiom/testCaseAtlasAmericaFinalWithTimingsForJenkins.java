package com.test.automatiom;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import com.test.helperMethods.*;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.*;
import java.net.URL;

public class testCaseAtlasAmericaFinalWithTimingsForJenkins {

	public static WebDriver driver;
	public Properties prop, expText;
	public String baseUrl = "";

	utilsClass calDateValue = new utilsClass();
	helperUtil helperUtls = new helperUtil();

	public void setUp() throws FileNotFoundException, IOException, MalformedURLException {

		prop = new Properties();
		prop.load(new FileInputStream("./Configuration/configuration_file"));

		expText = new Properties();
		expText.load(new FileInputStream("./AssertationFields/AssertationFieldsTexts"));

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();

		baseUrl = prop.getProperty("baseuUrl_Other");
		// driver.get(baseUrl);

		driver.manage().window().maximize();

	}

	@BeforeTest
	public void addtlsetUp() throws FileNotFoundException, IOException, MalformedURLException {

		prop = new Properties();
		prop.load(new FileInputStream("./Configuration/configuration_file"));

		expText = new Properties();
		expText.load(new FileInputStream("./AssertationFields/AssertationFieldsTexts"));

//		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//		driver = new ChromeDriver();

		/////

		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-extensions");
//		// --disable-save-password-bubble
//		options.addArguments("disable-infobars");
//		options.addArguments("--disable-notifications");
//		options.addArguments("--ignore-certificate-errors");

		// TODO Auto-generated method stub
		String url1="http://localhost:4444/wd/hub";
		String url2="http://vcautomation.docker:4444/wd/hub";
		String url3 = "http://qa-docker.visitorscoverage.ws:4444/wd/hub";
		
		//URL url = url=new URL(prop.getProperty("DockerURL_LOCAL"));
		
		URL url = url=new URL(url3);
		DesiredCapabilities dcap = DesiredCapabilities.chrome();
		dcap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new RemoteWebDriver(url, dcap);
		driver.manage().window().maximize();

		/////

		//baseUrl_TW
		//baseUrl = prop.getProperty("baseUrl_TW");
		//baseuUrl_Other
		baseUrl = prop.getProperty("baseuUrl_Other");
		// driver.get(baseUrl);

		//driver.manage().window().maximize();

	}

	@Test
	public void test() throws InterruptedException {

		// System.out.println(calDateValue.calDatePlusListDays(0, 0, 19, 5));
		String valCoverageStartDate = null;
		String valCoverageEndDate = null;
		String valArrivalDate = null;
		ArrayList<String> arListDate = new ArrayList<String>();
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

		driver.get(baseUrl);
		Thread.sleep(8000);
		// helperUtil.checkEleLoaded(driver, "");

		// 1st page
		// Handle the accept button

		// Timer
		helperUtil.checkEleLoaded(driver, "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/button");

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(5000);

		// Destination country

		// Timer
		helperUtil.checkEleLoaded(driver, "//*[@id=\"destination_home_country\"]");

		driver.findElement(By.xpath("//*[@id=\"destination_home_country\"]")).click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[2]");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[2]"))
				.click();
		Thread.sleep(2000);

		// US Green card or not

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]"))
				.click();
		// Thread.sleep(2000);

		// Select not a green-card

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[1]"))
				.click();
		// Thread.sleep(2000);

		// Traveler's Citizenship

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]"))
				.click();
		// Thread.sleep(2000);

		// Traveler's Citizenship country

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]"))
				.click();
		// Thread.sleep(2000);

		// Traveler's Residence Home Country

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]"))
				.click();
		// Thread.sleep(2000);

		// Traveler's Choice of Residence Home Country

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]"))
				.click();
		// Thread.sleep(2000);

		valCoverageStartDate = valArrivalDate;
		System.out.println("valCoverageStartDate:" + valCoverageStartDate + ":");

		// Timer
		helperUtil.checkEleLoaded(driver, "//input[@placeholder='Coverage Start Date']");

		driver.findElement(By.xpath("//input[@placeholder='Coverage Start Date']")).click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver, "//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']");

		driver.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']")).click();
		Thread.sleep(2000);

		// Timer
		// helperUtil.checkEleLoaded(driver, "//div[normalize-space()='\" +
		// valCoverageStartDate + \"']");

		// driver.findElement(By.xpath("//div[normalize-space()='14']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='" + valCoverageStartDate + "']")).click();
		// Thread.sleep(2000);

		// Coverage End Date

		// Timer
		helperUtil.checkEleLoaded(driver, "//input[@placeholder='Coverage End Date']");

		driver.findElement(By.xpath("//input[@placeholder='Coverage End Date']")).click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver, "//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']");

		driver.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']")).click();
		Thread.sleep(2000);

		// Timer
		// helperUtil.checkEleLoaded(driver, "//div[normalize-space()='\" +
		// valCoverageEndDate + \"']");

		// driver.findElement(By.xpath("//div[normalize-space()='14']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='" + valCoverageEndDate + "']")).click();
		// Thread.sleep(2000);

		// Click checkBox:

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"))
				.click();
		// Thread.sleep(2000);

		// DOB section:

		// Timer
		helperUtil.checkEleLoaded(driver, "//input[@placeholder='Month']");

		driver.findElement(By.xpath("//input[@placeholder='Month']")).click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver, "//span[normalize-space()='Jan']");

		driver.findElement(By.xpath("//span[normalize-space()='Jan']")).click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("01");
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("1985");
		// Thread.sleep(2000);

		// Email section:

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("test@costtest.com");
		Thread.sleep(2000);

		// Continue button section
		WebElement element = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/span/button"));
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(element).click().build().perform();

		Thread.sleep(10000);

		// 2nd page

		// Timer
		// helperUtil.checkEleLoaded(driver, "//*[@id=\"accidental_death_rider\"]");

		driver.findElement(By.xpath("//*[@id=\"accidental_death_rider\"]")).click();
		Thread.sleep(3000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"//*[@id=\"purchase-policy-step-container-2\"]/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[2]");

		driver.findElement(By.xpath(
				"//*[@id=\"purchase-policy-step-container-2\"]/div[2]/div/div[3]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[2]"))
				.click();
		Thread.sleep(3000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"//*[@id=\"purchase-policy-step-container-2\"]/div[2]/div/div[4]/div/div/span/button");

		// continue button
		driver.findElement(
				By.xpath("//*[@id=\"purchase-policy-step-container-2\"]/div[2]/div/div[4]/div/div/span/button"))
				.click();
		Thread.sleep(12000);

		// 3rd page popup
		// driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]")).click();
		// Thread.sleep(2000);

		// 3rd page first name

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[1]/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[1]/label/div/div/div[1]/div/input"))
				.sendKeys("tester");
		// Thread.sleep(2000);

		// 3rd page middle name

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/label/div/div/div[1]/div/input"))
				.sendKeys("test");
		// Thread.sleep(2000);

		// 3rd page last name

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input"))
				.sendKeys("testing");
		// Thread.sleep(2000);

		// 3rd gender

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[5]/div/span/div/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[5]/div/span/div/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[5]/div/span/div/div/div/ul/li[1]");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[5]/div/span/div/div/div/ul/li[1]"))
				.click();
		Thread.sleep(2000);

		// 3rd passport number

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[6]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[6]/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[6]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[6]/label/div/div/div[1]/div/input"))
				.sendKeys("12345678T");
		// Thread.sleep(2000);

		// 3rd page home address

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div/label/div/div/div[1]/div/input"))
				.sendKeys("123 tester");
		// Thread.sleep(2000);

		// 3rd page home address city

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[1]/div/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[1]/div/label/div/div/div[1]/div/input"))
				.sendKeys("Santa Clara");
		Thread.sleep(2000);

		// 3rd home address city state

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/span/div/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/span/div/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				// "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/span/div/div/div/ul/li[2]");
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/span/div/div/div/ul/li[2]");

		driver.findElement(By.xpath(
				// "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/span/div/div/div/ul/li[2]"))
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/span/div/div/div/ul/li[2]"))
				.click();
		// Thread.sleep(2000);

		// no zip code

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[3]/div[2]/div/div/div/div/div/div/div/div/div/div");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[3]/div[2]/div/div/div/div/div/div/div/div/div/div"))
				.click();
		// Thread.sleep(2000);

		// mobile

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div/div/span/div/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div/div/span/div/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div/div/span/div/div/div/ul/li[1]");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div/div/span/div/div/div/ul/li[1]"))
				.click();
		// Thread.sleep(2000);

		// mobile phone number

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/label/div/div/div[1]/div/input"))
				.sendKeys("123456789");
		// Thread.sleep(2000);

		// beneficiary name

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[1]/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[1]/label/div/div/div[1]/div/input"))
				.sendKeys("testing all");
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/span/div/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/span/div/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/span/div/div/div/ul/li[1]");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/span/div/div/div/ul/li[1]"))
				.click();
		// Thread.sleep(2000);

		// acknowledgement

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[6]/div/div/div/div/div/div/div/div/div/div/div");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[6]/div/div/div/div/div/div/div/div/div/div/div"))
				.click();
		// Thread.sleep(2000);

		// continue

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[7]/div/div/span/button");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[7]/div/div/span/button"))
				.click();
		Thread.sleep(2000);

		// 4th page

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[1]/div/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[1]/div/label/div/div/div[1]/div/input"))
				.sendKeys("testing all");
		// Thread.sleep(2000);

		// cc number

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div/label/div/div/div[1]/div/input"))
				.sendKeys("4111111111111111");
		// Thread.sleep(2000);

		// cc number cvv

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/div/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/div/label/div/div/div[1]/div/input"))
				.sendKeys("124");
		// Thread.sleep(2000);

		// exp date

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(5000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input"))
				.sendKeys("1227");
		// Thread.sleep(2000);

		// billing address street address

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/label/div/div/div[1]/div/input"))
				.sendKeys("123 tester");
		// Thread.sleep(2000);

		// country

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/span/div/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/span/div/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/span/div/div/div/ul/li[233]");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/span/div/div/div/ul/li[233]"))
				.click();
		// Thread.sleep(2000);

		// state

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/span/div/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/span/div/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/span/div/div/div/ul/li[6]");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/span/div/div/div/ul/li[6]"))
				.click();
		Thread.sleep(2000);

		// city

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[1]/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[1]/label/div/div/div[1]/div/input"))
				.sendKeys("Santa Clara");
		Thread.sleep(2000);

		// zipCode

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[2]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[2]/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[2]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[2]/label/div/div/div[1]/div/input"))
				.sendKeys("95054");
		Thread.sleep(6000);

		// mobile

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div/div/span/div/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div/div/span/div/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div/div/span/div/div/div/ul/li[1]");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div/div/span/div/div/div/ul/li[1]"))
				.click();
		// Thread.sleep(2000);

		// mobile phone number

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div[1]/div/label/div/div/div[1]/div/input"))
				.click();
		// Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div[1]/div/label/div/div/div[1]/div/input"))
				.sendKeys("123456789");
		// Thread.sleep(9000);

		// Clicking the zipcode button so the mobile phone number is accepted.
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[2]/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(8000);

		// checkbox
		// driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/input")).click();
		driver.findElement(By.xpath(
				"//*[@id=\"purchase-policy-step-container-4\"]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div"))
				.click();
		Thread.sleep(2000);

		// complete button
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[6]/div/span/button"))
				.click();
		Thread.sleep(2000);

		driver.close();

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

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
