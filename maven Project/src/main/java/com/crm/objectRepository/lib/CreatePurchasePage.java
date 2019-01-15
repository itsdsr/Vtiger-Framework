package com.crm.objectRepository.lib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class CreatePurchasePage extends BaseClass{

	@FindBy(name="subject")
	private WebElement purchaseSubjectName;
	
	@FindBy(xpath="//input[@name='vendor_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement selectVendor;
	
	@FindBy(name="bill_street")
	private WebElement enterBillingAddress;
	
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copyBillingAdress;
	
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement selectProduct;
	
	@FindBy(name="qty1")
	private WebElement enterProductQuantity;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement savePurchaseOrder;
	
	@FindBy(xpath="//span[contains(text(), 'Purchase Order Information')]")
	private WebElement orderInfo;
	
	public WebElement getPurchaseSubjectName(String purchaseSubject) throws InterruptedException {
		wLib.wairForCompleteToSendKeys(purchaseSubjectName, purchaseSubject);
		return purchaseSubjectName;
	}

	public WebElement getEnterBillingAddress(String billingAddress) throws InterruptedException {
		wLib.wairForCompleteToSendKeys(enterBillingAddress, billingAddress);
		return enterBillingAddress;
	}

	public WebElement getCopyBillingAdress() throws InterruptedException {
		wLib.wairForCompleteToClick(copyBillingAdress);
		return copyBillingAdress;
	}

	public WebElement getEnterProductQuantity(String quantity) throws InterruptedException {
		wLib.wairForCompleteToSendKeys(enterProductQuantity, quantity);
		return enterProductQuantity;
	}

	public WebElement getSavePurchaseOrder() throws InterruptedException {
		wLib.wairForCompleteToClick(savePurchaseOrder);
		return savePurchaseOrder;
	}
	
	

	public String orderInfo() {
		return orderInfo.getText();
	}

	public void selectVendordtls(String vendorName) throws InterruptedException {
		wLib.wairForCompleteToClick(selectVendor);
		Set<String> vendorset=driver.getWindowHandles();
		Iterator<String> vendorIt=vendorset.iterator();
		String vendorParentWindow=vendorIt.next();
		String vendorChildWindow=vendorIt.next();
		driver.switchTo().window(vendorChildWindow);
		List<WebElement> vendorList=driver.findElements(By.xpath("//a[text()='"+vendorName+"']"));
		for(WebElement vendorWb:vendorList) {
			wLib.wairForCompleteToClick(vendorWb);
		}
		driver.switchTo().window(vendorParentWindow);
	}

	public void selectProductdtls(String productName) throws InterruptedException {
		wLib.wairForCompleteToClick(selectProduct);
		Set<String> ProductSet=driver.getWindowHandles();
		Iterator<String> productIt=ProductSet.iterator();
		String parentProductWindow2=productIt.next();
		String childProductWindow2=productIt.next();
		driver.switchTo().window(childProductWindow2);
		List<WebElement> productlist=driver.findElements(By.xpath("//a[text()='"+productName+"']"));
			for(WebElement wbproductlist:productlist) {
				wLib.wairForCompleteToClick(wbproductlist);	
			}
		driver.switchTo().window(parentProductWindow2);
	}
}
