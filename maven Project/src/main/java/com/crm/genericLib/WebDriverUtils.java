package com.crm.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtils {

	
	//wait for page to load
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//wait for any element is avl in GUI
	public void waitForElementPresent(WebDriver driver, WebElement wb) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	
	//wait for element complete load and avl in GUI
	public void wairForCompleteToClick(WebElement wb) throws InterruptedException {
		int count =0;
		while(count<4) {
			try {
				wb.click();
				break;
			}catch(Throwable t) {
				System.out.println("Handle the Exception");
				Thread.sleep(1000);
				count++;
			}
		}
	}
	//wait for element complete load and avl in GUI
		public void wairForCompleteToDisplay(WebElement wb) throws InterruptedException {
			int count =0;
			while(count<4) {
				try {	
					//driver.findElement(By.name(id)).sendKeys(name);
					wb.isDisplayed();
					break;
				}catch(Throwable t) {
					System.out.println("Handle the Exception");
					Thread.sleep(1000);
					count++;
				}
			}
		}
		//wait for element complete load and avl in GUI
				public void wairForCompleteToSendKeys(WebElement wb, String str) throws InterruptedException {
					int count =0;
					while(count<4) {
						try {	
							wb.sendKeys(str);
							break;
						}catch(Throwable t) {
							System.out.println("Handle the Exception");
							Thread.sleep(1000);
							count++;
						}
					}
				}
	public void waitForSelectElement(WebDriver driver, WebElement wb, String visibility) throws InterruptedException {
		int count =0;
		while(count<4) {
			try {
				Select sel=new Select(wb);
				sel.selectByVisibleText(visibility);
				break;
			}catch(Throwable t) {
				System.out.println("Handle the Exception");
				Thread.sleep(3000);
				count++;
			}
		}
	}
}
