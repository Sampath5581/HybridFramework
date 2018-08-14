package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;


	public TestBase(){
	
	try{
		prop=new Properties();
		FileInputStream fs=new FileInputStream("D:\\Selenium\\android\\HybridFramework\\HybridFramework\\src\\main\\java\\com\\crm\\qa\\configuration\\config.properties");
		prop.load(fs);
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
		}	
	
	public static void initalization(){
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equals("chrome")){
			String b=System.getProperty("user.dir")+"\\Browserdrivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",b);
			driver=new ChromeDriver();
		}else if(BrowserName.equals("IE")){
			String b=System.getProperty("user.dir")+"\\Browserdrivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",b);
			driver=new InternetExplorerDriver();
		}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
	
		
		
	}
		
		
		
		
		

}