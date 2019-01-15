package com.crm.objectRepository.lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class QuotePage extends BaseClass{

	@FindBy(xpath="//img[@title='Create Quote...']")
	private WebElement createQuote;

	public void createQuote() throws InterruptedException {
		wLib.wairForCompleteToClick(createQuote);
	}
	
}
