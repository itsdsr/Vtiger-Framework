package com.crm.objectRepository.lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class ProductPage extends BaseClass{

	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProduct;
	
	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(name="unit_price")
	private WebElement unitPrice;
	
	@FindBy(name="button")
	private WebElement saveButton;


	public void createProduct(String productname , String unitprice) throws InterruptedException {
		wLib.wairForCompleteToClick(createProduct);
		wLib.wairForCompleteToSendKeys(productName, productname);
		wLib.wairForCompleteToSendKeys(unitPrice, unitprice);
		wLib.wairForCompleteToClick(saveButton);
	}
	
	
}
