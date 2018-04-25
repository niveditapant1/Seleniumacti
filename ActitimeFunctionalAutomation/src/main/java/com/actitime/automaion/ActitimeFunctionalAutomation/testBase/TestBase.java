package com.actitime.automaion.ActitimeFunctionalAutomation.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.actitime.automaion.ActitimeFunctionalAutomation.excelReader.ExcelReader;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;
	String Url = "https://demo.actitime.com/login.do";
	String browser = "firefox";
	ExcelReader excel;

	//String browser = "chrome";

	public void intl() {
		selectBrowser(browser);
		getUrl(Url);
		String log4jConfPath ="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public void selectBrowser(String browser) {
if (browser.equalsIgnoreCase("firefox"))		{
	System.out.println(System.getProperty("user.dir"));
	System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "drivers/geckodriver");
	log.info("Creating the log for" + browser);
	driver = new FirefoxDriver();
}

else if(browser.equalsIgnoreCase("chrome")) {
	System.out.println(System.getProperty("user.dir"));
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver");
	log.info("Creating the log for" + browser);
	driver = new ChromeDriver();
}
	}
	
	public void getUrl(String Url) {
		log.info("Navigating to " + Url);
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	//excel reading method
	
	public String[][] getexceldata(String excelname,String sheetname) {
		String path = System.getProperty("user.dir")+"/src/main/java/com/actitime/automaion/ActitimeFunctionalAutomation/data/"+excelname;
		excel = new ExcelReader(path);
	String[][] data = excel.getDataFromSheet(sheetname, excelname);
		return data;
	}
	
	public void pagerefresh() {
		driver.navigate().refresh();
	}
		
public void waitforElement( int timeOutInSeconds,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		}
		
public void takescreenshot(String name) {
			Calendar calinstant =  Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("mm_dd_yyyy_hh_mm_ss");
			try {		
File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String replocation = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/actitime/automaion/ActitimeFunctionalAutomation/screenshot/";
File dsrfile = new File((String)replocation+name+"_"+	formater.format(calinstant.getTime())+".png");
	
		FileUtils.copyFile(scrfile,dsrfile);
	Reporter.log("<a href='"+ dsrfile.getAbsolutePath()+" '>img.scr-'"+ dsrfile.getAbsolutePath() + "' height='100' width='100'/> </a>");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
		
		
		
	
}

