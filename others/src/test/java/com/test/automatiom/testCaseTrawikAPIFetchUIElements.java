package com.test.automatiom;

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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import com.test.utils.utilsClass;
import com.test.helperMethods.*;
import com.test.pages.*;

// Addtl section 

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.given;
import java.io.File;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Properties;

import org.openqa.selenium.support.FindBy;

//

public class testCaseTrawikAPIFetchUIElements {

	public static WebDriver driver;
	public Properties prop, expText;
	public String baseUrl = "";

	utilsClass calDateValue = new utilsClass();
	helperUtil helperUtls = new helperUtil();

	@BeforeTest
	public void setUp() throws FileNotFoundException, IOException {

		prop = new Properties();
		prop.load(new FileInputStream("./Configuration/configuration_file"));

		expText = new Properties();
		expText.load(new FileInputStream("./AssertationFields/AssertationFieldsTexts"));

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();

		baseUrl = prop.getProperty("baseUrl_TW");
		// driver.get(baseUrl);

		driver.manage().window().maximize();

	}

	@Parameters({ "testOption" })
	@Test
	public void test(String testOption) throws InterruptedException, JSONException {
		String noJSONByPASS = "1";
		String JSONByPASS = "1";
		///// apiFetch Section:

		// URL :
		// https://staging.builds.visitorscoverage.ws/app/policy/purchaseflow/visitor/169/

		RestAssured.baseURI = "https://staging.builds.visitorscoverage.ws/app/policy/purchaseflow/visitor/169/";

		// Send the POST request with the JSON file
		Response response = given().header("Content-Type", "application/x-www-form-urlencoded")
				.header("Accept", "application/json").contentType(ContentType.JSON).when().get().then().extract()
				.response();

		JSONObject jsonObj = new JSONObject(response.prettyPrint());
		response.prettyPrint();
		System.out.println("Response  : " + response.asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath jsonPath = response.jsonPath();

		// Page 1

		String destination_home_country = jsonPath.getString("flow.steps[0].sections[0].fields[0].field_form_name");
		System.out.println("printing the value as follows : " + destination_home_country);

		String destination_home_country_USA = jsonPath.getString("flow.steps[0].sections[0].fields[0].allowed[0]");
		System.out.println("printing the value as follows : " + destination_home_country_USA);

		String user_citizenship = jsonPath.getString("flow.steps[0].sections[0].fields[2].field_form_name");
		System.out.println("printing the value as follows : " + user_citizenship);

		String user_residence = jsonPath.getString("flow.steps[0].sections[0].fields[3].field_form_name");
		System.out.println("printing the value as follows : " + user_residence);

		String quote_email_id = jsonPath.getString("flow.steps[0].sections[2].fields[0].field_form_name");
		System.out.println("printing the value as follows : " + quote_email_id);

		//

		/////

		trawikPurchasePOMPageLatest tw = new trawikPurchasePOMPageLatest(driver);
		// System.out.println(calDateValue.calDatePlusListDays(0, 0, 19, 5));
		String valCoverageStartDate = null;
		String valCoverageEndDate = null;
		String valArrivalDate = null;
		ArrayList<String> arListDate = new ArrayList<String>();
		// arListDate.addAll(calDateValue.calDatePlusListDays(0, 0, 19, 5));
		arListDate.addAll(calDateValue.calDatePlusListDays(0, 0, 37, 5));
		for (int index = 0; index < arListDate.size(); index++) {
			// System.out.println(arListDate.get(index));

			if (index == 1) {
				System.out.println(arListDate.get(index));
				System.out.println(calDateValue.splitDates(arListDate.get(index)));
				valCoverageEndDate = calDateValue.splitDates(arListDate.get(index));
				valCoverageEndDate = valCoverageEndDate.replaceFirst("^0+(?!$)", "");
				System.out.println("valCoverageEndDate : " + valCoverageEndDate);
			}

			if (index == 2) {
				System.out.println(arListDate.get(index));
				System.out.println(calDateValue.splitDates(arListDate.get(index)));
				valCoverageStartDate = arListDate.get(index);
				valCoverageStartDate = valCoverageStartDate.replaceFirst("^0+(?!$)", "");
				System.out.println("valCoverageStartDate : " + valCoverageStartDate);
				valArrivalDate = calDateValue.splitDates(arListDate.get(index));
				valArrivalDate = valArrivalDate.replaceFirst("^0+(?!$)", "");
				System.out.println("valArrivalDate : " + valArrivalDate);
			}
		}

		driver.get(baseUrl);
		Thread.sleep(6000);

		// to handle accept cookies button
		try {
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/button")).click();
			Thread.sleep(2500);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		
		// Destination Country

		if ((noJSONByPASS.equals("1"))) {
			helperUtil.checkEleLoaded(driver, "//*[@id=\"destination_home_country\"]");
			driver.findElement(By.xpath("//*[@id=\"destination_home_country\"]")).click();
			Thread.sleep(2500);

			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[1]");
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/span/div/div/div/ul/li[1]"))
					.click();
			Thread.sleep(2500);

		}

		if ((JSONByPASS.equals("0"))) {
			// Added from JSON
			// helperUtil.checkEleLoaded(driver, destination_home_country);
			Thread.sleep(2500);
			driver.findElement(By.id(destination_home_country)).click();
			Thread.sleep(2500);
			try {

				WebElement destination_home_country_element = driver
						.findElement(By.xpath("//*[@data-value='" + destination_home_country_USA + "']"));
				destination_home_country_element.click();

				// tw.selectdestination_home_country_USA_POM_WE();

				// drop down failed

			} catch (Exception e) {
				System.out.println("Exception : Test step failed : " + e);
			}

		}

		/////

		// Traveler's Citizenship

		if ((noJSONByPASS.equals("1"))) {
			Thread.sleep(2500);
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/input");
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/input"))
					.click();
			Thread.sleep(2500);

			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/div/ul/li[2]");
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/div/ul/li[2]"))
					.click();
			Thread.sleep(2500);
		}

		if ((JSONByPASS.equals("0"))) {
			Thread.sleep(2500);
			// Added from JSON
			// helperUtil.checkEleLoaded(driver,"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/input");
			driver.findElement(By.id(user_citizenship)).click();
			Thread.sleep(2500);

			try {
				String user_citizenship_top_countries = jsonPath
						.getString("flow.steps[0].sections[0].fields[2].top_countries[0]");
				System.out.println("printing the value as follows : " + user_citizenship_top_countries);

				WebElement user_citizenship_top_countries_element = driver
						.findElement(By.xpath("//*[@data-value='" + user_citizenship_top_countries + "']"));
				user_citizenship_top_countries_element.click();
				// drop down failed

			} catch (Exception e) {
				System.out.println("Exception : test step failed : " + e);
			}

		}

		// Traveler's Residence Home country 9 years (since it was introduced)

		// Timer
//		helperUtil.checkEleLoaded(driver,
//				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]");
//
//		driver.findElement(By.xpath(
//				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]"))
//				.click();
//		Thread.sleep(2500);

		// Timer
//		helperUtil.checkEleLoaded(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.id(user_residence)).click();
		Thread.sleep(2500);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[1]/div[1]/div[1]/div[1]/ul[1]/li[2]"))
				.click();
		Thread.sleep(2500);

		valCoverageStartDate = valArrivalDate;
		System.out.println("valCoverageStartDate:" + valCoverageStartDate + ":");

		// Timer
		helperUtil.checkEleLoaded(driver, "//input[@placeholder='Coverage Start Date']");

		driver.findElement(By.xpath("//input[@placeholder='Coverage Start Date']")).click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver, "//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']");

		driver.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']")).click();
		Thread.sleep(2000);

		// Timer
		// driver.findElement(By.xpath("//div[normalize-space()='14']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='" + valCoverageStartDate + "']")).click();
		Thread.sleep(2000);

		// Coverage End Date

		// Timer
		helperUtil.checkEleLoaded(driver, "//input[@placeholder='Coverage End Date']");

		driver.findElement(By.xpath("//input[@placeholder='Coverage End Date']")).click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver, "//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']");

		driver.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[normalize-space()='" + valCoverageEndDate + "']")).click();
		Thread.sleep(2000);

		// Arrival Date

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[6]/div/div[2]/div[1]/div/div/div/div/div/div/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[6]/div/div[2]/div[1]/div/div/div/div/div/div/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver, "//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']");

		driver.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[normalize-space()='" + valCoverageStartDate + "']")).click();
		Thread.sleep(2000);

		// DOB section:

		// Timer
		helperUtil.checkEleLoaded(driver, "//input[@placeholder='Month']");

		driver.findElement(By.xpath("//input[@placeholder='Month']")).click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver, "//span[normalize-space()='Jan']");

		driver.findElement(By.xpath("//span[normalize-space()='Jan']")).click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("01");
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("1985");
		Thread.sleep(2000);

		// Email section:

		if ((noJSONByPASS.equals("1"))) {
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
					.click();
			Thread.sleep(2000);

			helperUtil.checkEleLoaded(driver,
					"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
					.sendKeys("test@costtest.com");
			Thread.sleep(2000);

		}

		if ((JSONByPASS.equals("0"))) {
			try {
				driver.findElement(By.id(quote_email_id)).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("Exception : test step failed : " + e);
			}

		}

		// Continue button section
		WebElement element = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/span/button"));
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(element).click().build().perform();

		Thread.sleep(10000);

		// 2nd page

		if ((noJSONByPASS.equals("0"))) {

			Thread.sleep(2500);

			System.out.println("testOption : " + testOption);
			// Accidental Death and Disability upgrade

			// 1st set of 1 thro 5

			if (testOption.equals("disabilityUpgradeNone_HomeCountryNo")) {
				tw.selectOptAddOnBenefitsNone();
			}

			if (testOption.equals("disabilityUpgrade50k_HomeCountryNo")) {
				tw.selectOptAddOnBenefits50k();
			}

			if (testOption.equals("disabilityUpgrade100k_HomeCountryNo")) {
				tw.selectOptAddOnBenefits100k();
			}

			if (testOption.equals("disabilityUpgrade250k_HomeCountryNo")) {
				tw.selectOptAddOnBenefits250k();
			}

			if (testOption.equals("disabilityUpgrade500k_HomeCountryNo")) {
				tw.selectOptAddOnBenefits500k();
			}

			// 2nd set 1 thro'5

			if (testOption.equals("disabilityUpgradeNone_HomeCountryYes")) {
				tw.selectOptAddOnBenefitsNone_homeCountry_Yes();
			}

			if (testOption.equals("disabilityUpgrade50k_HomeCountryYes")) {
				tw.selectOptAddOnBenefits50k_homeCountry_Yes();
			}

			if (testOption.equals("disabilityUpgrade100k_HomeCountryYes")) {
				tw.selectOptAddOnBenefits100k_homeCountry_Yes();
			}

			if (testOption.equals("disabilityUpgrade250k_HomeCountryYes")) {
				tw.selectOptAddOnBenefits250k_homeCountry_Yes();
			}

			if (testOption.equals("disabilityUpgrade500k_HomeCountryYes")) {
				tw.selectOptAddOnBenefits500k_homeCountry_Yes();
			}

			// 3rd set of 1 thro 5

			if (testOption.equals("disabilityUpgradeNone_SportActivityYes1")) {
				tw.selectOptAddOnBenefitsNone_sportsActivityCoverageDropDownYes1();
			}

			if (testOption.equals("disabilityUpgrade50k_SportActivityYes1")) {
				tw.selectOptAddOnBenefits50k_sportsActivityCoverageDropDownYes1();
			}

			if (testOption.equals("disabilityUpgrade100k_SportActivityYes1")) {
				tw.selectOptAddOnBenefits100k_sportsActivityCoverageDropDownYes1();
			}

			if (testOption.equals("disabilityUpgrade250k_SportActivityYes1")) {
				tw.selectOptAddOnBenefits250k_sportsActivityCoverageDropDownYes1();
			}

			if (testOption.equals("disabilityUpgrade500k_SportActivityYes1")) {
				tw.selectOptAddOnBenefits500k_sportsActivityCoverageDropDownYes1();
			}

			Thread.sleep(2500);

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[4]/div/div/span/button"))
					.click();
			Thread.sleep(2500);

			// click on upgrade if presented.

			try {
				driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/div[3]/button[1]")).click();
			} catch (Exception e) {
				System.out.println("Exception for upgrade : " + e);
			}

			Thread.sleep(2500);

		}

		if ((JSONByPASS.equals("1"))) {

			// 2nd page

			try {

				String accidentalDeath_DropDown = jsonPath
						.getString("flow.steps[1].sections[1].fields[0].field_form_name");
				System.out.println("printing the value as follows : " + accidentalDeath_DropDown);

				Thread.sleep(2500);
				// Added from JSON
				// helperUtil.checkEleLoaded(driver,"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/input");
				driver.findElement(By.id(accidentalDeath_DropDown)).click();
				Thread.sleep(2500);

				String accidentalDeath_DropDown_None = jsonPath
						.getString("flow.steps[1].sections[1].fields[0].options[0].id");
				System.out.println("printing the value as follows : " + accidentalDeath_DropDown_None);

				WebElement accidentalDeath_DropDown_None_element = driver
						.findElement(By.xpath("//*[@data-value='" + accidentalDeath_DropDown_None + "']"));
				accidentalDeath_DropDown_None_element.click();
				// drop down failed

			} catch (Exception e) {
				System.out.println("Exception : test step failed : " + e);
			}

			try {

				String follow_me_home_new = jsonPath.getString("flow.steps[1].sections[1].fields[1].field_form_name");
				System.out.println("printing the value as follows : " + follow_me_home_new);

				Thread.sleep(2500);
				// Added from JSON
				// helperUtil.checkEleLoaded(driver,"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/input");
				driver.findElement(By.id(follow_me_home_new)).click();
				Thread.sleep(2500);

				String follow_me_home_new_options_no = jsonPath
						.getString("flow.steps[1].sections[1].fields[1].options[0].id");
				System.out.println("printing the value as follows : " + follow_me_home_new_options_no);

				Thread.sleep(2500);
				driver.findElement(By.xpath("/*[@data-value='" + follow_me_home_new_options_no + "']")).click();

			} catch (Exception e) {
				System.out.println("Exception : test step failed : " + e);
			}

			try {

				String athletic_sports_new = jsonPath.getString("flow.steps[1].sections[1].fields[2].field_form_name");
				System.out.println("printing the value as follows : " + athletic_sports_new);

				Thread.sleep(2500);
				// Added from JSON
				// helperUtil.checkEleLoaded(driver,"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/input");
				driver.findElement(By.id(athletic_sports_new)).click();
				Thread.sleep(2500);

				String athletic_sports_new_no = jsonPath.getString("flow.steps[1].sections[1].fields[2].options[0].id");
				System.out.println("printing the value as follows : " + athletic_sports_new_no);

				Thread.sleep(2500);
				driver.findElement(By.xpath("/*[@data-value='" + athletic_sports_new_no + "']")).click();

			} catch (Exception e) {
				System.out.println("Exception : test step failed : " + e);
			}

			Thread.sleep(2500);

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[4]/div/div/span/button"))
					.click();
			Thread.sleep(2500);

			// click on upgrade if presented.

			try {
				driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/div[3]/button[1]")).click();
			} catch (Exception e) {
				System.out.println("Exception for upgrade : " + e);
			}

			Thread.sleep(2500);

		}

		//3rd page 
		
		if ((noJSONByPASS.equals("0"))) {
			
			// 3rd page first name
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[1]/label/div/div/div[1]/div/input");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[1]/label/div/div/div[1]/div/input"))
					.click();
			Thread.sleep(2000);
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[1]/label/div/div/div[1]/div/input");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[1]/label/div/div/div[1]/div/input"))
					.sendKeys("tester");
			Thread.sleep(2000);
	
			// 3rd page middle name
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/label/div/div/div[1]/div/input");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/label/div/div/div[1]/div/input"))
					.click();
			Thread.sleep(2000);
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/label/div/div/div[1]/div/input");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/label/div/div/div[1]/div/input"))
					.sendKeys("test");
			Thread.sleep(2000);
	
			// 3rd page last name
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input"))
					.click();
			Thread.sleep(2000);
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[3]/label/div/div/div[1]/div/input"))
					.sendKeys("testing");
			Thread.sleep(2000);
	
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
	
			// 3rd page home address (name)
	
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
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/span/div/div/div/ul/li[2]");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/span/div/div/div/ul/li[2]"))
					.click();
			Thread.sleep(2000);
	
			// no zip code
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[3]/div[2]/div/div/div/div/div/div/div/div/div/div");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div[3]/div[2]/div/div/div/div/div/div/div/div/div/div"))
					.click();
			Thread.sleep(2000);
	
			// mobile
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div/div/span/div/div/input");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div/div/span/div/div/input"))
					.click();
			Thread.sleep(2000);
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div/div/span/div/div/div/ul/li[1]");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div/div/span/div/div/div/ul/li[1]"))
					.click();
			Thread.sleep(2000);
	
			// mobile phone number
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/label/div/div/div[1]/div/input");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/label/div/div/div[1]/div/input"))
					.click();
			Thread.sleep(2000);
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/label/div/div/div[1]/div/input");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/label/div/div/div[1]/div/input"))
					.sendKeys("123456789");
			Thread.sleep(2000);
	
			///
	
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
			Thread.sleep(2000);
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/span/div/div/input");
			// "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/span/div/div/input"
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/span/div/div/input"))
					.click();
			Thread.sleep(2000);
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/span/div/div/div/ul/li[1]");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/span/div/div/div/ul/li[1]"))
					.click();
			Thread.sleep(2000);
	
			// acknowledgement
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[6]/div/div/div/div/div/div/div/div/div/div/div");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[6]/div/div/div/div/div/div/div/div/div/div/div"))
					.click();
			Thread.sleep(2000);
	
			// continue
	
			// Timer
			helperUtil.checkEleLoaded(driver,
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[7]/div/div/span/button");
	
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[7]/div/div/span/button"))
					.click();
			Thread.sleep(2000);
	
			///
			
			
		}

		if(JSONByPASS.equals("1")) {
			
			try {

				//Provide additional traveler information
				
				String main_applicant_first_name = jsonPath.getString("flow.steps[2].sections[0].fields[0].field_form_name");
				System.out.println("printing the value as follows : " + main_applicant_first_name);

				Thread.sleep(2500);
				// Added from JSON
				// helperUtil.checkEleLoaded(driver,"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/input");
				driver.findElement(By.id(main_applicant_first_name)).click();
				Thread.sleep(2500);

				String main_applicant_first_name_text = jsonPath.getString("flow.steps[2].sections[0].fields[0].form_type");
				System.out.println("printing the value as follows : " + main_applicant_first_name_text);

				Thread.sleep(2500);
				driver.findElement(By.xpath("/*[@data-value='" + main_applicant_first_name_text + "']")).click();

			} catch (Exception e) {
				System.out.println("Exception : test step failed : " + e);
			}
			
		}

		/////

		// 4th page
		
		if(JSONByPASS.equals("1")) {
			
			try {
				
				String name_on_card = jsonPath.getString("flow.steps[3].sections[2].fields[0].field_form_name");
				System.out.println("printing the value as follows : " + name_on_card);

				Thread.sleep(2500);
				// Added from JSON
				// helperUtil.checkEleLoaded(driver,"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[3]/div/div[2]/span/div/div/input");
				driver.findElement(By.id(name_on_card)).click();
				Thread.sleep(2500);
				
			} catch (Exception e) {
				System.out.println("Exception : " + e);
			}
				
		}
		

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[1]/div/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[1]/div/label/div/div/div[1]/div/input"))
				.sendKeys("testing all");
		Thread.sleep(2000);

		// cc number

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[1]/div/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[1]/div/div/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[1]/div/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[1]/div/div/label/div/div/div[1]/div/input"))
				.sendKeys("4111111111111111");
		Thread.sleep(2000);

		// cc number cvv

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/label/div/div/div[1]/div/input"))
				.sendKeys("124");
		Thread.sleep(2000);

		// exp date

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[3]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[3]/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(5000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[3]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div/div/div/div[2]/div[3]/label/div/div/div[1]/div/input"))
				.sendKeys("1227");
		Thread.sleep(2000);

		// billing address street address

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/label/div/div/div[1]/div/input"))
				.sendKeys("123 tester");
		Thread.sleep(2000);

		// country

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/span/div/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/span/div/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/span/div/div/div/ul/li[233]");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/span/div/div/div/ul/li[233]"))
				.click();
		Thread.sleep(2000);

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
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div/div/span/div/div/div/ul/li[1]");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div/div/span/div/div/div/ul/li[1]"))
				.click();
		Thread.sleep(2000);

		// mobile phone number

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div[1]/div/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(2000);

		// Timer
		helperUtil.checkEleLoaded(driver,
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div[1]/div/label/div/div/div[1]/div/input");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/div[1]/div/label/div/div/div[1]/div/input"))
				.sendKeys("123456789");
		Thread.sleep(3000);

		// Clicking the zipcode button so the mobile phone number is accepted.
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/div/div[1]/div[3]/div[2]/label/div/div/div[1]/div/input"))
				.click();
		Thread.sleep(6000);

		// checkbox
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[5]/div/div/div[1]/div/div/div[1]/div/div/div/div/div"))
				.click();
		Thread.sleep(2000);

		// complete button
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[6]/div/span/button"))
				.click();
		Thread.sleep(2000);

		/////

		/*
		 * 
		 */

		/////

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

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
