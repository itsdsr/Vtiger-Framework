package com.countPurchaseOrder;

import org.openqa.selenium.support.PageFactory;

/**
 * @author Puja
 *
 */

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.genericLib.BaseClass;
import com.crm.objectRepository.lib.CreatePurchasePage;
import com.crm.objectRepository.lib.HomePage;
import com.crm.objectRepository.lib.ProductPage;
import com.crm.objectRepository.lib.PurchasePage;
import com.crm.objectRepository.lib.VendorPage;

public class PurchaseOrderForAllOrder extends BaseClass{
	@Test
	public static void countAfterCreateOrderTest() throws Throwable {
		
		String purchaseSubjectName=fLib.getExcelData("Sheet1",3,0)+num.nextInt(100);
		String vendorName=fLib.getExcelData("Sheet1",3,2)+num.nextInt(100);
		String BillingAddressName=fLib.getExcelData("Sheet1", 3, 1)+num.nextInt(100);
		String productName=fLib.getExcelData("Sheet1", 3, 4)+num.nextInt(100);
		String productQuantity=fLib.getExcelData("Sheet1", 3, 8)+num.nextInt(100);
		String productPrice=fLib.getExcelData("Sheet1", 3, 5)+num.nextInt(100);
	
		
//More
		HomePage homepage=PageFactory.initElements(driver, HomePage.class);
		homepage.clickMore();

		
//purchase Order
		homepage.clickMore();
		homepage.getClickPurchaseOrders();		
		PurchasePage purchasepage=PageFactory.initElements(driver, PurchasePage.class);
		String expOrderCount =Integer.parseInt(purchasepage.count())+1+"";
		//Reporter.log(expOrderCount, true);
//More
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
	//click on purchase page
		purchasepage.clickPurchaseOrder();
//verification of purchase order list
		String actStatus=purchasepage.textRecords();
		String actOrderCount=purchasepage.count();
		Assert.assertEquals(expOrderCount, actOrderCount);
		fLib.setExcelData("Sheet1", 3, 11,actStatus);

				/*if(actStatus.contains(expStatus)) {
					Reporter.log("Total Record is:"+str[6], true);
					fLib.setExcelData("Sheet1", 3, 11,actStatus);
				}
				else{
					Reporter.log("Purchase is not created", true);
				}*/
	}
}
