package com.actitime.automaion.ActitimeFunctionalAutomation.homePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;

import com.actitime.automaion.ActitimeFunctionalAutomation.testBase.TestBase;
import com.actitime.automaion.ActitimeFunctionalAutomation.uiAction.LoginPage;

public class TC0002ValidPassword extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC0002ValidPassword.class.getName());
	LoginPage login;
	@BeforeClass
	public void setup() {
		intl();
	}
	
	@Test
	public void ValidUserNamePassword() {
		
		login = new LoginPage(driver);
		log.info("====teststart===");
		login.loginpagedetail("admin","manager");
		System.out.println(login.pagetitle());
		AssertJUnit.assertEquals(login.successlogin(), false);
		log.info("====testend===");
		
	}
	
	@AfterClass
	public void endsetup() {
		driver.close();
	}
		
	}
	


