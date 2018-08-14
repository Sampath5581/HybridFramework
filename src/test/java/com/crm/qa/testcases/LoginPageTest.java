package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Excelreadutil;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void SetUp(){
	
	initalization();
	 loginpage=new LoginPage();
	
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest(){
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void CRMLogoImageTest(){
		boolean v=loginpage.validateCRMLogo();
		Assert.assertTrue(v);
	}
	
	@Test(priority=3,dataProvider ="Data")
	public void loginTest(String username,String password){
		homepage=loginpage.Login(username, password);
		//homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		 Assert.assertEquals(true, driver.getTitle().contains("CRMPRO"));
	}
	
	@DataProvider(name="Data")
	public Object[][] passdata(){
	Excelreadutil v=new Excelreadutil("D:\\Selenium\\android\\HybridFramework\\HybridFramework\\src\\main\\java\\com\\crm\\qa\\Data\\Testdata.xlsx");
	//System.out.println(v.getdata(0, 0, 0));
	int rows=v.getRowcount(0);
	Object[][] data=new Object[rows][2];
	for(int i=1;i<rows;i++) {
		data[i][0]=v.getdata(0, i, 0);
		data[i][1]=v.getdata(0, i, 1);
	}
	
	
	return data;
}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
		
	}
	
	

