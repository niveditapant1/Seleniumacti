package com.actitime.automaion.ActitimeFunctionalAutomation.homePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.actitime.automaion.ActitimeFunctionalAutomation.testBase.TestBase;
import com.actitime.automaion.ActitimeFunctionalAutomation.uiAction.LoginPage;

public class TC0001InvalidLogin extends TestBase {
	public static final Logger log = Logger.getLogger(TC0001InvalidLogin.class.getName());
	
	LoginPage login;
	
	@BeforeClass
	public void setup() {
	intl();
	}
	
	@Test
	public void InvalidLogin () {
		log.info("====Testcase start===" );
		login = new LoginPage(driver);
		login.loginpagedetail("admin", "admin");
		AssertJUnit.assertEquals(login.invalidgettext(),"Username or Password is invalid. Please try again.");
		
		log.info("====Testcase END===" );
	}
@AfterClass	
public void endsetup() {
	driver.close();
}

}
