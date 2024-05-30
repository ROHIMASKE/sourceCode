package libraryFiles;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserClassBase {
	public WebDriver driver;
	 public ExtentReports extent;
	
	@BeforeSuite
	public void setUpSuite()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "rohi maske");
	
	}
	@Parameters("browser")
	@BeforeTest
	
	public void launchBrowser(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("Chrome")
				|| browser.equalsIgnoreCase("google chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge") || browser.equalsIgnoreCase("EDGE")
				|| browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else

		{
			Reporter.log("sorry do not browser in system");
		}

		driver.get(utlityClass.getPropertyData("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("running Test in:"+browser);

	}
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}

}
