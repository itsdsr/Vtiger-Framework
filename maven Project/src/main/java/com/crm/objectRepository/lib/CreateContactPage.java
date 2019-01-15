package com.crm.objectRepository.lib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class CreateContactPage extends BaseClass{

	@FindBy(name="lastname")
	private WebElement enterLastName;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement selectOrganisation;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveContact;
	
	public void createContact(String lastname, String orgName) throws InterruptedException {
		wLib.wairForCompleteToSendKeys(enterLastName, lastname);
		Set<String> organisationSet=driver.getWindowHandles();
		Iterator<String> organisationIt=organisationSet.iterator();
		String parentOrganisationWindow=organisationIt.next();
		String childOrganisationWindow=organisationIt.next();
		driver.switchTo().window(childOrganisationWindow);
		List<WebElement> list=driver.findElements(By.xpath("//a[text()='"+orgName+"']"));
		for(WebElement wb:list) {
			wb.click();
		}
		driver.switchTo().window(parentOrganisationWindow);
		wLib.wairForCompleteToClick(saveContact);
	}
}
