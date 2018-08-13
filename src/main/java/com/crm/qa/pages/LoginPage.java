package com.crm.qa.pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase {
	
	//PageFactory or OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Login;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement CrmLogo;
	
	//Initializing the pageObjects
public LoginPage(){
	PageFactory.initElements(driver, this);

}

//Actions
public String validateLoginPageTitle(){
	return driver.getTitle();
}


public boolean validateCRMLogo(){
	return CrmLogo.isDisplayed();
}

public HomePage Login(String Username,String Password){
	username.sendKeys(Username);
	password.sendKeys(Password);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	js.executeScript("arguments[0].click();",Login);
	
	/*Actions actions=new Actions(driver);
	actions.moveToElement(Login).click().build().perform();
	Login.click();*/
	
	return new HomePage();
	
}
}
