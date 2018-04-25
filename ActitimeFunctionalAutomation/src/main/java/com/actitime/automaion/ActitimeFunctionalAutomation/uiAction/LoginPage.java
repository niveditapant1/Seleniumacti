package com.actitime.automaion.ActitimeFunctionalAutomation.uiAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.automaion.ActitimeFunctionalAutomation.testBase.TestBase;


public class LoginPage extends TestBase {
	
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	@FindBy (id="username")
	WebElement Username;
	
	@FindBy (name="pwd")
	WebElement Password;
	
	@FindBy (id="loginButton")
	WebElement Loginbtn;
	
	@FindBy (xpath="//span [contains( text(),'Username or Password is invalid.')]")
	WebElement InvalidUSRMESSAGE;
	
	@FindBy(xpath="//a[@id='logoutLink']")
	WebElement Logout;
	

	public LoginPage(WebDriver driver) {
	this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginpagedetail(String user , String pwd) {
		
		Username.sendKeys(user);
		log.info("username provided" + Username.toString() );

		Password.sendKeys(pwd);
		log.info("password provided" + Password.toString());
		Loginbtn.click();
		log.info("click on login btoon"+ Loginbtn.toString() );
	}
		
	public String invalidgettext() {
		log.info(InvalidUSRMESSAGE.getText());
return InvalidUSRMESSAGE.getText();
	}
		
	public String pagetitle() {
		log.info("====after login titile of the page is ===");
		return driver.getTitle();
	}
	
	public boolean successlogin() {
	try {
		log.info("==logout button is check");

		Logout.isDisplayed();

		log.info("==logout button is true"+Logout.toString());

		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void logout() {
		waitforElement(100,Logout);
		pagerefresh();
		Logout.click();
		log.info("logout from the application" + Logout.toString() );
	}
		
		
		
	
	
}
		
		
		
	
	


