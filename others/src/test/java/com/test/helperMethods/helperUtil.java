package com.test.helperMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//import com.test.pages.*;
import org.testng.annotations.*;

public class helperUtil {

	public static WebDriver driver;
	public Properties prop;
	public String baseUrl = "";
	public String chromeDriverPath = "";

	public static void checkEleLoaded(WebDriver ndriver, String passedXpath) throws InterruptedException {
		driver = ndriver;
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passedXpath)));
	}
	
	public static void checkEleLoadedByWebElement(WebDriver ndriver, WebElement passedElement) throws InterruptedException {
		driver = ndriver;
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passedElement.toString())));
	}

	public void isClickAble(WebDriver ndriver, String passedXpath) throws InterruptedException {
		driver = ndriver;
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passedXpath)));
	}

	public boolean checkBooleanEleLoaded(WebDriver ndriver, String passedXpath) throws InterruptedException {
		boolean retCheckBooleanEleLoaded = false;
		try {
			driver = ndriver;
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			WebDriverWait wait = new WebDriverWait(driver, 4);
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passedXpath))) != null) {
				retCheckBooleanEleLoaded = true;
			} else {
				retCheckBooleanEleLoaded = false;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return retCheckBooleanEleLoaded;
	}

	public String randString(int size) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		int n = size;
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public int getRandomNumber(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1)) + min;
	}

	public boolean compareStr(int strVal, String compStr) {
		int compStrLen = compStr.length();
		if (strVal == compStrLen) {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickElement(WebDriver driver, String element) {
		if (driver.findElement(By.xpath(element)) != null) {
			driver.findElement(By.xpath(element)).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean clearElement(WebDriver driver, String element) throws InterruptedException {
		if (driver.findElement(By.xpath(element)) != null) {
			driver.findElement(By.xpath(element)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(element)).clear();
			return true;
		} else {
			return false;
		}
	}

	public boolean sendKeysElement(WebDriver driver, String element, String typeValue) {
		if (driver.findElement(By.xpath(element)) != null) {
			driver.findElement(By.xpath(element)).sendKeys(typeValue);
			return true;
		} else {
			return false;
		}
	}

	public boolean isSelectedOrNot(WebDriver driver, String element) {
		if (driver.findElement(By.xpath(element)) != null) {
			driver.findElement(By.xpath(element)).isSelected();
			return true;
		} else {
			return false;
		}
	}

	public boolean isEnabledOrNot(WebDriver driver, String element) {
		if (driver.findElement(By.xpath(element)) != null) {
			driver.findElement(By.xpath(element)).isEnabled();
			return true;
		} else {
			return false;
		}
	}

	public boolean isDisabledOrNot(WebDriver driver, String element) {
		if (driver.findElement(By.xpath(element)) != null) {
			driver.findElement(By.xpath(element)).isDisplayed();
			return true;
		} else {
			return false;
		}
	}

	public boolean findElementsThenClickIt(WebDriver driver, String element) {
		List<WebElement> checkElements = driver.findElements(By.xpath(element));
		int lencheckElements = checkElements.size();
		System.out.println("lencheckElements : " + lencheckElements);
		int count = 1;
		if ((lencheckElements > 0) && (count == 1)) {
			WebElement firstCheckbox = driver.findElement(By.xpath(element + "[1]"));
			System.out.println("firstCheckbox " + firstCheckbox);
			driver.findElement(By.xpath(element + "[1]")).click();
			count = count + 1;
			return true;
		} else {
			return false;
		}
	}

	public boolean checkIfClickedWithWD(WebDriver driver, WebElement element) {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkIfClickedByIfElse(WebDriver driver, WebElement element) {
		try {
			if ((driver.findElement(By.xpath("")) != null)) {
				driver.findElement(By.xpath("")).click();
			} else {

			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return false;
	}

	public boolean listElement(List<WebElement> element) {
		for (int i = 0; i <= element.size(); i++) {
			driver.findElement(By.xpath("element[i]")).click();
		}
		return false;
	}

	public boolean checkIfElementsExistOnPage(WebDriver driver, WebElement element) {
		boolean value = false;
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebDriverWait wait = new WebDriverWait(driver, 5);
			if (wait.until(ExpectedConditions.visibilityOf(element)) != null) {
				value = true;
			} else {
				value = false;
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return value;
	}

}
