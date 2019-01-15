package com.crm.objectRepository.lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class ContactPage extends BaseClass{

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContact;

	public void createContact() throws InterruptedException {
		wLib.wairForCompleteToClick(createContact);
	}

		// test

}
