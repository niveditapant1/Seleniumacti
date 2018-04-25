package com.actitime.automaion.ActitimeFunctionalAutomation.CustomListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.actitime.automaion.ActitimeFunctionalAutomation.testBase.TestBase;

public class Listner extends TestBase implements ITestListener  {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Calendar calinstant =  Calendar.getInstance();
		String methodname = result.getName();
		SimpleDateFormat formater = new SimpleDateFormat("mm_dd_yyyy_hh_mm_ss");
		try {		
File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String replocation = new File(System.getProperty("user.dir")).getAbsolutePath()+"src/main/java/com/actitime/automaion/UIautomation";
File dsrfile = new File((String)replocation+"/Sucess_screen_shot/"+methodname+"_"+formater.format(calinstant.getTime())+".png");

	FileUtils.copyFile(scrfile,dsrfile);
Reporter.log("<a href='"+ dsrfile.getAbsolutePath()+" '>img.scr-'"+ dsrfile.getAbsolutePath() + "' height='100' width='100'/> </a>");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Calendar calinstant =  Calendar.getInstance();
		String methodname = result.getName();
		SimpleDateFormat formater = new SimpleDateFormat("mm_dd_yyyy_hh_mm_ss");
		try {		
File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String replocation = new File(System.getProperty("user.dir")).getAbsolutePath()+"src/main/java/com/actitime/automaion/UIautomation";
File dsrfile = new File((String)replocation+"/failure_screen_shot/"+methodname+"_"+formater.format(calinstant.getTime())+".png");

	FileUtils.copyFile(scrfile,dsrfile);
Reporter.log("<a href='"+ dsrfile.getAbsolutePath()+" '>img.scr-'"+ dsrfile.getAbsolutePath() + "' height='100' width='100'/> </a>");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
