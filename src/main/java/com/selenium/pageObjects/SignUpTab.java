/**
 * This class contains PageObjects of Signup Tab
 */

package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author NivedhaNatarajan
 *
 */

public class SignUpTab {
	
	WebDriver driver;
	
	public SignUpTab(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[text()='Sign up with Email']")
	@CacheLookup
	WebElement signUpWithEmail;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Continue with Facebook']")
	@CacheLookup
	WebElement continueWithFacebook;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Continue with Google']")
	@CacheLookup
	WebElement continueWithGoogle;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Log in']")
	@CacheLookup
	WebElement login;
	
	@FindBy(how = How.CLASS_NAME, using = "_1rp5252")
	@CacheLookup
	WebElement closeButton;

	public void clickSignUpWithEmail() {
		signUpWithEmail.click();
	}

	public void clickContinueWithFacebook() {
		 continueWithFacebook.click();
	}

	public void clickContinueWithGoogle() {
		 continueWithGoogle.click();
	}

	public void clickLogin() {
		 login.click();
	}

	public void clickCloseButton() {
		 closeButton.click();
	}	

}
