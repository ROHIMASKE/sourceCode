package libraryFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	public WebDriver driver;
	
	@BeforeTest
	
	public void amazonTest() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		driver.findElement(By.id("ap_email")).sendKeys(utlityClass.getPropertyData("number"));
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ap_password")).sendKeys(utlityClass.getPropertyData("pass"));
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.id("ap_email")).sendKeys(utlityClass.getPropertyData("number"));
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ap_password")).sendKeys(utlityClass.getPropertyData("pass"));
		driver.findElement(By.id("signInSubmit")).click();
		}
	SoftAssert ass= new SoftAssert();
	@Test
	
	public void Tc1() throws Exception {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\\\"nav-logo-sprites\\\"]")));
		WebElement amazonText = driver.findElement(By.xpath("//a[@id=\"nav-logo-sprites\"]"));
		ass.assertTrue(amazonText.isDisplayed());
		
	}
	@Test
	public void TC2() throws Exception {
	
		System.out.println("running Test case one");
		Thread.sleep(2000);
		String expURL = "https://www.amazon.com/";
		String actaulurl = driver.getCurrentUrl();
		ass.assertEquals(expURL, actaulurl);
	}
	@Test
	public void TC3() throws Exception
	{
		String title="Amazon.com. Spend less. Smile more.";
		Thread.sleep(2000);
		String getTitle = driver.getTitle();
		ass.assertEquals(title, getTitle);
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
