package com.crm.objectRepository.lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class PurchasePage extends BaseClass{

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private static WebElement clickNewPurchaseOrder;
	
	@FindBy(linkText="Purchase Order")
	private WebElement clickPurchaseOrder;
	
	@FindBy(xpath="//table[@class='layerPopupTransport']/tbody/tr/td[contains(text(),'Showing Records')]")
	private WebElement showingRecords;
	
	public void clickNewPurchase() throws InterruptedException {
		wLib.wairForCompleteToClick(clickNewPurchaseOrder);
	}

	public void clickPurchaseOrder() throws InterruptedException {
		wLib.wairForCompleteToClick(clickPurchaseOrder);
	}
	public String count() {
		String[] noOfCount=(showingRecords.getText()).split(" ");
		return noOfCount[6];
	}
	public String textRecords() {
		return showingRecords.getText();
	}
	
	public String countRecordsAfterCreate() {
		String[] noOfCount=(showingRecords.getText()).split(" ");
		String expOrderCount =Integer.parseInt(noOfCount[6])+1+"";
		return expOrderCount;
	}
}
