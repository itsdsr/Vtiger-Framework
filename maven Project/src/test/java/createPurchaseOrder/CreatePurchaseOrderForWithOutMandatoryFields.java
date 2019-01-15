package com.createPurchaseOrder;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericLib.BaseClass;
import com.crm.objectRepository.lib.CreatePurchasePage;
import com.crm.objectRepository.lib.HomePage;
import com.crm.objectRepository.lib.ProductPage;
import com.crm.objectRepository.lib.PurchasePage;
import com.crm.objectRepository.lib.VendorPage;
@Listeners(com.crm.genericLib.ListnerImpClass.class)

public class CreatePurchaseOrderForWithOutMandatoryFields extends BaseClass{
	@Test
	public static void CreateOrderWithOutMandatoryFields() throws Throwable {
		

		String purchaseSubjectName=fLib.getExcelData("Sheet1",4,0)+num.nextInt(100);
		String vendorName=fLib.getExcelData("Sheet1",4,2)+num.nextInt(100);
		String BillingAddressName=fLib.getExcelData("Sheet1", 4, 1)+num.nextInt(100);
		String productName=fLib.getExcelData("Sheet1", 4, 4)+num.nextInt(100);
		String productQuantity=fLib.getExcelData("Sheet1", 4, 8)+num.nextInt(100);
		String productPrice=fLib.getExcelData("Sheet1", 4, 5)+num.nextInt(100);
		
		//More
		HomePage homepage=PageFactory.initElements(driver, HomePage.class);
		homepage.clickMore();
		
//create vendor
		homepage.getClickVendor();
		VendorPage vendorpage=PageFactory.initElements(driver, VendorPage.class);
		vendorpage.createVendor(vendorName);
		
		
//create product
		homepage.getClickProducts();
		ProductPage productPage=PageFactory.initElements(driver, ProductPage.class);
		productPage.createProduct(productName, productPrice);
		
				
//purchase Order
		homepage.clickMore();
		homepage.getClickPurchaseOrders();
		PurchasePage purchasepage=PageFactory.initElements(driver, PurchasePage.class);
		String expOrderCount =Integer.parseInt(purchasepage.count())+1+"";
		purchasepage.clickNewPurchase();
		
//create Purchase order
		CreatePurchasePage createpurchasepage=PageFactory.initElements(driver, CreatePurchasePage.class);
		createpurchasepage.getPurchaseSubjectName(purchaseSubjectName);
	//select vendor from child window
		createpurchasepage.selectVendordtls(vendorName);
		createpurchasepage.getEnterBillingAddress(BillingAddressName);
		createpurchasepage.getCopyBillingAdress();
	//select product from child window
		createpurchasepage.selectProductdtls(productName);
		createpurchasepage.getEnterProductQuantity(productQuantity);
		createpurchasepage.getSavePurchaseOrder();
	//Get the text of alert window
		Alert alt = driver.switchTo().alert();
		String actStatus = alt.getText();
		
	//click on purchase page
		purchasepage.clickPurchaseOrder();
				
				
//verification of purchase order list
		String actOrderCount=purchasepage.count();
		Assert.assertEquals(expOrderCount, actOrderCount);
		fLib.setExcelData("Sheet1", 4, 11,actStatus);
				/*if(expStatus.equals(actStatus)) {
					Reporter.log(actStatus, true);
					fLib.setExcelData("Sheet1", 4, 11,actStatus);
				}
				else{
					Reporter.log("Purchase Created Successfully", true);
				}*/
	}

}
