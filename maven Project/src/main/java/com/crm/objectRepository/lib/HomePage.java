package com.crm.objectRepository.lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//a[text()='More']/..")
	private WebElement moreOption;
	
	@FindBy(xpath="//a[@id='more' and text()='Vendors']")
	private WebElement clickVendor;
	
	@FindBy(linkText="Products")
	private WebElement clickProducts;
	
	@FindBy(linkText="Purchase Order")
	private WebElement clickPurchaseOrders;
	
	@FindBy(linkText="Organizations")
	private WebElement clickOrganisation;
	
	@FindBy(linkText="Contacts")
	private WebElement clickContacts;
	
	@FindBy(linkText="Quotes")
	private WebElement clickQuotes;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOut;
	
	@FindBy(xpath="Sign Out")
	private WebElement signOutBtn;

	public void clickMore() {
		Actions ac=new Actions(driver);		
		ac.moveToElement(moreOption).perform();
	}
	
	public WebElement getClickVendor() throws InterruptedException {
		wLib.wairForCompleteToClick(clickVendor);
		return clickVendor;
	}
	
	public WebElement getClickProducts() throws InterruptedException {
		wLib.wairForCompleteToClick(clickProducts);
		return clickProducts;
	}
	
	public WebElement getClickPurchaseOrders() throws InterruptedException {
		wLib.wairForCompleteToClick(clickPurchaseOrders);
		return clickPurchaseOrders;
	}
	
	public WebElement getClickOrganisation() throws InterruptedException {
		wLib.wairForCompleteToClick(clickOrganisation);
		return clickOrganisation;
	}

	public WebElement getClickContacts() throws InterruptedException {
		wLib.wairForCompleteToClick(clickContacts);
		return clickContacts;
	}

	public WebElement getClickQuotes() throws InterruptedException {
		wLib.wairForCompleteToClick(clickQuotes);
		return clickQuotes;
	}

	public void clickSignOut() {
		Actions ac=new Actions(driver);		
		ac.moveToElement(signOut).perform();
	}

}
