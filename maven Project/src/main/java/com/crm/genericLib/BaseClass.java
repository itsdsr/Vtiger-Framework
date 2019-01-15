package com.crm.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.objectRepository.lib.HomePage;
import com.crm.objectRepository.lib.LoginPage;

public class BaseClass extends WebDriverUtils{
	public static WebDriver driver;
	public static WebDriverUtils wLib=new WebDriverUtils();
	public static FileUtils fLib=new FileUtils();
	public static Random num=new Random();
	
	@BeforeClass
	public void driverLaunch() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
	}
	@BeforeMethod
	public void logIn() throws Throwable {
		Properties pObj=fLib.getPropertyfileOblect();
		String URL=pObj.getProperty("URL");
		String userName=pObj.getProperty("userName");
		String passWord=pObj.getProperty("passWord");
		wLib.waitForPageToLoad(driver);
		driver.get(URL);	
		/*driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(passWord);
		driver.findElement(By.id("submitButton")).click();*/
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.logInToApp(userName, passWord);
	}
	@AfterMethod
	public void logOut() {
		/*String signOutXpath="//img[@src='themes/softed/images/user.PNG']";
		WebElement signOutMouse=driver.findElement(By.xpath(signOutXpath));
		Actions act1=new Actions(driver);
		act1.moveToElement(signOutMouse).perform();
		driver.findElement(By.linkText("Sign Out")).click();*/
		HomePage homepage=PageFactory.initElements(driver, HomePage.class);
		homepage.clickSignOut();
		
	}
	@AfterClass
	public void closeDricer() {
		driver.close();
	}
	
	@BeforeSuite
	public void dBConnection(){
		System.out.println("****Data Base Connected****");
	}
	
	@AfterSuite
	public void backUpResult() throws IOException {
		String cDate=new Date().toString().replace(" ","_").replace(":","_");
		File dstFile=new File(".//backup//"+cDate+"_batchResult.html");
		File srcFile=new File("./test-output/emailable-report.html");
		org.apache.commons.io.FileUtils.copyFile(srcFile,dstFile);
	}
}
