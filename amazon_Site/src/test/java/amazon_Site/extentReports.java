package amazon_Site;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReports {
@Test
public void generateReports() throws Exception
{
ExtentReports extentReports= new ExtentReports();//Engine
	ExtentSparkReporter sparkReporter= new ExtentSparkReporter("C:\\File\\extentReports.html");//reporter
	//attach enginee with reporter
	extentReports.attachReporter(sparkReporter);
		extentReports.flush();
		//Desktop.getDesktop().browse(new File("report.html").toURI());
	
}
}
