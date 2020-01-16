/**
 * This class contains pageobjects and actions of signup with facebook page
 */

package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author NivedhaNataraja
 *
 */

public class SignUpWithFacebook {

	WebDriver driver;

	public SignUpWithFacebook(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	@CacheLookup
	WebElement email;

	@FindBy(how = How.ID, using = "pass")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.NAME, using = "login")
	@CacheLookup
	WebElement login;

	@FindBy(how = How.ID, using = "forgot-password-link")
	@CacheLookup
	WebElement forgotPassword;

	@FindBy(how = How.XPATH, using = "//a[text()='Create New Account']")
	@CacheLookup
	WebElement createNewAccount;
	
	@FindBy(how = How.XPATH, using = "//h2[@class='uiHeaderTitle']")
	@CacheLookup
	WebElement securityCode;
	
	@FindBy(how = How.XPATH, using = "//span[@id='permissions_list']")
	@CacheLookup
	WebElement permissionList;
	
	@FindBy(how = How.XPATH, using = "//i[@class='_lz5 img sp_bDjiB2FhHrx sx_0eedd8']")
	@CacheLookup
	WebElement switchUserDropDown;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Switch User']")
	@CacheLookup
	WebElement switchUser;

	public void typeEmail(String userName) {
		email.clear();
		email.sendKeys(userName);
	}

	public void typePassword(String userPassword) {
		password.clear();
		password.sendKeys(userPassword);
	}

	public void clickLogin() {
		login.click();
	}

	public void clickForgotPassword() {
		forgotPassword.click();
	}

	public void clickCreateNewAccount() {
		createNewAccount.click();
	}
	
	public void getSecurityCodeText() {
		securityCode.click();
	}
	
	public String getPermissionList() {
		return permissionList.getText();
	}
	
	public WebElement getSwitchUserDropDown() {
		return switchUserDropDown;
	}
	
	public void clickSwitchUserDropDown() {
		switchUserDropDown.click();
	}
	
	public void clickSwitchUser() {
		switchUser.click();
	}

}
