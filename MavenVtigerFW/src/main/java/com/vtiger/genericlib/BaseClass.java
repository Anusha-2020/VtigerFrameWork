package com.vtiger.genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.objectrepository.LoginPageElements;

public class BaseClass {
	
	public static WebDriver driver;
	public DataUtility data = new DataUtility();
	public WebDriverCommonUtils wlib = new WebDriverCommonUtils();
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("-----Database Connect----");
	}
	@Parameters("browser")
	@BeforeClass
	public void configBC() throws IOException
	{
		System.out.println("-----Browser Launch Starts----");
		String browser = data.getDataFromProperties("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");

			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(data.getDataFromProperties("url"));
		System.out.println("-----Browser Launch Starts----");
	}
	@BeforeMethod
	public void configBM() throws IOException
	{
		System.out.println("-----Login Starts----");
		LoginPageElements login = PageFactory.initElements(driver, LoginPageElements.class);
		login.getUsername().sendKeys(data.getDataFromProperties("username"));
		login.getPassword().sendKeys(data.getDataFromProperties("password"));
		login.getLoginBtn().click();
		System.out.println("-----Login Ends----");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("-----Logout Starts----");
		WebElement signout = driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		Actions act = new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("-----Logout Ends----");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("-----Close browser----");
		driver.quit();
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("-----Database Disconnect----");
	}

}
