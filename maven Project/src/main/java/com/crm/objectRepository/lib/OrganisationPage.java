package com.crm.objectRepository.lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class OrganisationPage extends BaseClass{
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganisation;
	
	@FindBy(name="accountname")
	private WebElement enterAccountName;
	
	@FindBy(linkText="button")
	private WebElement clickOnSave;
	
	
	public void createOrganisation(String orgName) throws InterruptedException {
		wLib.wairForCompleteToClick(createOrganisation);
		wLib.wairForCompleteToSendKeys(enterAccountName, orgName);
		wLib.wairForCompleteToClick(clickOnSave);
	}
}
