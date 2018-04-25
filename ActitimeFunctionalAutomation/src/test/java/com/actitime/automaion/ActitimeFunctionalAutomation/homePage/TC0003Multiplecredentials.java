package com.actitime.automaion.ActitimeFunctionalAutomation.homePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.automaion.ActitimeFunctionalAutomation.testBase.TestBase;
import com.actitime.automaion.ActitimeFunctionalAutomation.uiAction.LoginPage;

public class TC0003Multiplecredentials extends TestBase{
	
LoginPage login;
public static final Logger log = Logger.getLogger(TC0003Multiplecredentials.class.getName());
//String user = "admin";
//String pwd = "manager";

@BeforeClass
public void setup() {
intl();
}
@DataProvider(name = "TestdataLogin")
public String[][] gettestdata() {
	log.info("-----multiple user log");;
	 String[][] testdatarecord = getexceldata("TestData.xlsx","TestdataLogin");
	
	return testdatarecord;
	
}

@Test(dataProvider="TestdataLogin")
public void testmultiplelogin(String username,String password,String runmode) {
	if(runmode.equalsIgnoreCase("n")) {
		throw new SkipException("user try to skip testcases");
	}
log.info("-----multiple user log");;
login = new LoginPage(driver);
	login.loginpagedetail(username, password);
	takescreenshot("logintest"+username+password);
boolean statusoflogin = login.successlogin();
if(statusoflogin=true) {
	login.logout();
}

else {
	pagerefresh();
}
	
AssertJUnit.assertEquals(statusoflogin, true);
log.info("-----multiple end user log");;

}



@AfterClass	
public void endsetup() {
	driver.close();
	

}
}
