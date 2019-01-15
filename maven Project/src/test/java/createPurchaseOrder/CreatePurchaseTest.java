package com.createPurchaseOrder;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.genericLib.BaseClass;
import com.crm.objectRepository.lib.CreatePurchasePage;
import com.crm.objectRepository.lib.HomePage;
import com.crm.objectRepository.lib.ProductPage;
import com.crm.objectRepository.lib.PurchasePage;
import com.crm.objectRepository.lib.VendorPage;

public class CreatePurchaseTest extends BaseClass{

	@Test
	public void createPurchaseOrderTest() throws Throwable {
		
		
	String purchaseSubjectName=fLib.getExcelData("Sheet1",2,0)+num.nextInt(100);
	String vendorName=fLib.getExcelData("Sheet1",2,2)+num.nextInt(100);
	String BillingAddressName=fLib.getExcelData("Sheet1", 2, 1)+num.nextInt(100);
	String productName=fLib.getExcelData("Sheet1", 2, 4)+num.nextInt(100);
	String productQuantity=fLib.getExcelData("Sheet1", 2, 8)+num.nextInt(100);
	String productPrice=fLib.getExcelData("Sheet1", 2, 5)+num.nextInt(100);
	
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
			
	//verification
			String expStatus=fLib.getExcelData("Sheet1", 2, 10);
			String actStatus=createpurchasepage.orderInfo();
			boolean result=actStatus.contains(expStatus);
			Assert.assertTrue(result);
			fLib.setExcelData("Sheet1", 2, 11,actStatus);

			

}
}
