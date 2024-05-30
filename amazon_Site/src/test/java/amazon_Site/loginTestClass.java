package amazon_Site;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import bsh.util.Util;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import libraryFiles.browserClassBase;
import libraryFiles.utlityClass;

public class loginTestClass extends browserClassBase {
	int TCID = 101;
	public WebDriver driever;

	@BeforeClass
	public void openbrowser() throws Exception {
		System.out.println("running openbrowser");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Conditions of Use']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
		Thread.sleep(2000);
		System.out.println("running initilialzing browser");
		driver.findElement(By.id("ap_email")).sendKeys(utlityClass.getPropertyData("number"));
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(utlityClass.getPropertyData("pass"));
		Thread.sleep(2000);
		driver.findElement(By.id("signInSubmit")).click();
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		act.moveToElement(ele).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=\"Sign Out\"]")).click();
		Thread.sleep(2000);

	}

	@BeforeMethod
	public void initializeApplication() throws Exception {
		driver.findElement(By.id("ap_email")).sendKeys(utlityClass.getPropertyData("number"));
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ap_password")).sendKeys(utlityClass.getPropertyData("pass"));
		driver.findElement(By.id("signInSubmit")).click();
	}

	SoftAssert ass = new SoftAssert();

	@Test
	public void TC1() throws Exception {
		ExtentTest test = extent.createTest("TC1");
		
		Thread.sleep(2000);
		System.out.println("running Test case one");
		String expURL = "https://www.amazon.com/.";
		String actaulurl = driver.getCurrentUrl();
		ass.assertEquals(expURL, actaulurl);
		
		
		extent.flush();

	}
	
	
	
	/*
	 * @Test public void TC2() throws Exception { Thread.sleep(2000); String
	 * title="Your Amazon.com"; String getTitle = driver.getTitle();
	 * ass.assertEquals(title, getTitle); ass.assertAll(); }
	 */
	 

	@AfterMethod
	
	public void closeBrowser(ITestResult tr) throws Exception {
		if (tr.getStatus() == ITestResult.FAILURE) {
			utlityClass.getScreenShotonFailure(driever, TCID);
		}
		
		Thread.sleep(5000);

	}

	@AfterClass
	public void teardown() {
		System.out.println("running teaer down");
	}
	
}
