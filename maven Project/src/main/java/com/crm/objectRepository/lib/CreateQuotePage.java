package com.crm.objectRepository.lib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class CreateQuotePage extends BaseClass{

	
	@FindBy(name="subject")
	private WebElement enterSubject;
	
	@FindBy(xpath="//input[@name='contact_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement selectContact;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement selectOrganisation;
	
	@FindBy(name="bill_street")
	private WebElement billingStreet;
	
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copyAddress;
	
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement selectProduct;
	
	@FindBy(xpath="qty1")
	private WebElement quantity;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement quoteSave;
	
	public void selectContact(String lastName) {
		selectContact.click();
		//select Contact from child window 
		Set<String> contactset=driver.getWindowHandles();
		Iterator<String> contactit=contactset.iterator();
		String parentContactWindow=contactit.next();
		String childContactWindow=contactit.next();
			driver.switchTo().window(childContactWindow);
			List<WebElement> contactlist=driver.findElements(By.linkText(""+lastName+""));
				for(WebElement wb:contactlist) {
					wb.click();
					driver.switchTo().alert().accept();
				}	
			driver.switchTo().window(parentContactWindow);
	}
	public void selectOrganisation(String orgName) {
		selectOrganisation.click();
		Set<String> organizationSet=driver.getWindowHandles();
		Iterator<String> organizationIt=organizationSet.iterator();
		String parentOrganizationWindow1=organizationIt.next();
		String childOrganizationWindow1=organizationIt.next();
	driver.switchTo().window(childOrganizationWindow1);
	List<WebElement> organisationlist=driver.findElements(By.xpath("//a[text()='"+orgName+"']"));
	for(WebElement wb:organisationlist) {
		wb.click();
		driver.switchTo().alert().accept();
	}	
	driver.switchTo().window(parentOrganizationWindow1);
	}
	
	public void selectProduct(String productName) {
		selectProduct.click();
		Set<String> ProductSet=driver.getWindowHandles();
		Iterator<String> productIt=ProductSet.iterator();
		String parentProductWindow2=productIt.next();
		String childProductWindow2=productIt.next();
		driver.switchTo().window(childProductWindow2);
		List<WebElement> productlist=driver.findElements(By.xpath("//a[text()='"+productName+"']"));
		for(WebElement wb:productlist) {
			wb.click();	
		}
	driver.switchTo().window(parentProductWindow2);
	}
	public void createQuote(String quoteName, String lastName,String orgName, String BillingAddressName, String productName, String productQuantity) throws InterruptedException {
		wLib.wairForCompleteToSendKeys(enterSubject, quoteName);
		selectContact(lastName);
		selectOrganisation(orgName);
		wLib.wairForCompleteToSendKeys(billingStreet, BillingAddressName);
		wLib.wairForCompleteToClick(copyAddress);
		selectProduct(productName);
		wLib.wairForCompleteToSendKeys(quantity, productQuantity);
		wLib.wairForCompleteToClick(quoteSave);
	}

}
