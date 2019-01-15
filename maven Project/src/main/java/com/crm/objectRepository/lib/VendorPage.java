package com.crm.objectRepository.lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.genericLib.BaseClass;
import com.crm.genericLib.WebDriverUtils;

public class VendorPage extends BaseClass{

	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVendor;
	
	@FindBy(name="vendorname")
	private WebElement enterVendorname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickSaveBtn;
	
	public void createVendor(String vendorName) throws InterruptedException {
		wLib.wairForCompleteToClick(createVendor);
		wLib.wairForCompleteToSendKeys(enterVendorname, vendorName);
		wLib.wairForCompleteToClick(clickSaveBtn);
	}
}
