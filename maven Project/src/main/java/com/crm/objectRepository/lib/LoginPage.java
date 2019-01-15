package com.crm.objectRepository.lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	@FindBy(name="user_name")
	private WebElement userNameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//utilization through getters
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}
	
	//utilization through business library / methods
	public void logInToApp(String username, String password) {
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
	
	
}
