package libraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utlityClass {
	public static String getTestDatafromEXCEl(int rowindex, int cellIndex) throws Exception {
		FileInputStream file = new FileInputStream(
				"C:\\Personal Data\\amazon_Site\\excelFIle\\TestCase_Practice-page.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String values = sh.getRow(rowindex).getCell(cellIndex).getStringCellValue();

		return values;

	}

	public  static String getPropertyData(String key) throws Exception {
		FileInputStream file = new FileInputStream(
				"C:\\Personal Data\\amazon_Site\\propertyFile.properties\\pData.properties");
		Properties p = new Properties();
		p.load(file);
		String getPData = p.getProperty(key);
		return getPData;

	}

	public  static void getScreenShotonFailure(WebDriver driver, int TCID) throws IOException {
  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  File dest= new File("C:\\Users\\rohin\\OneDrive\\Documents\\ScreenShots\\TC"+TCID+".jpg");
  org.openqa.selenium.io.FileHandler.copy(src, dest);
	}

}
