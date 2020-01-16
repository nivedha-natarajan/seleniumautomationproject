/**
 * This class contains the PageObjects of Signup with Email
 */

package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.selenium.utilities.ExplicitWait;

/**
 * @author NivedhaNatarajan
 *
 */

public class SignUpWithEmail {
	
WebDriver driver;
	
	public SignUpWithEmail(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//button[text()='Facebook']")
	@CacheLookup
	WebElement switchToFacebook;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Google']")
	@CacheLookup
	WebElement switchToGoogle;
	
	@FindBy(how = How.ID, using = "email-signup-email")
	@CacheLookup
	WebElement typeEmailId;
	
	@FindBy(how = How.ID, using = "email-signup-user[first_name]")
	@CacheLookup
	WebElement typeFirstName;
	
	@FindBy(how = How.NAME, using = "user[last_name]")
	@CacheLookup
	WebElement typeLastName;
	
	@FindBy(how = How.ID, using = "email-signup-password")
	@CacheLookup
	WebElement typePassword;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_y9ev9r']/select[@id='email-signupuser[birthday_month]']")
	@CacheLookup
	WebElement clickSelectMonth;
	
	@FindBy(how = How.ID, using = "email-signupuser[birthday_month]")
	@CacheLookup
	WebElement selectMonth;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_y9ev9r']/select[@id='email-signupuser[birthday_day]']")
	@CacheLookup
	WebElement clickSelectDay;
	
	@FindBy(how = How.ID, using = "email-signupuser[birthday_day]")
	@CacheLookup
	WebElement selectDay;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_y9ev9r']/select[@id='email-signupuser[birthday_year]']")
	@CacheLookup
	WebElement clickSelectYear;
	
	@FindBy(how = How.ID, using = "email-signupuser[birthday_year]")
	@CacheLookup
	WebElement selectYear;
	
	@FindBy(how = How.CLASS_NAME, using = "_1rp5252")
	@CacheLookup
	WebElement closeButton;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Sign up']")
	@CacheLookup
	WebElement signUpButton;
	
	@FindBy(how = How.CLASS_NAME, using = "_foa2bi")
	@CacheLookup
	WebElement receiveMarketingCheckBox;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Log in']")
	@CacheLookup
	WebElement logInButton;
	
	public void clickSwitchToFacebook() {
		switchToFacebook.click();
	}

	public void clickSwitchToGoogle() {
		switchToGoogle.click();
	}

	public void typeEmailId(String emailID) {
		typeEmailId.clear();
		typeEmailId.sendKeys(emailID);
	}

	public void typeFirstName(String firstName) {
		typeFirstName.clear();
		typeFirstName.sendKeys(firstName);
	}

	public void typeLastName(String lastName) {
		typeLastName.clear();
		typeLastName.sendKeys(lastName);
	}

	public void typePassword(String password) {
		typePassword.clear();
		typePassword.sendKeys(password);
	}

	public void getSelectMonth(String month) {
		Select months = new Select(selectMonth);
		clickSelectMonth.click();
		ExplicitWait.getExplicitWait(driver, selectMonth);
		months.selectByVisibleText(month);
	}

	public void getSelectDay(String day) {
		Select days = new Select(selectDay);
		clickSelectDay.click();
		ExplicitWait.getExplicitWait(driver, selectDay);
		days.selectByVisibleText(day);
	}

	public void getSelectYear(String year) {
		Select years = new Select(selectYear);
		clickSelectYear.click();
		ExplicitWait.getExplicitWait(driver, selectYear);
		years.selectByVisibleText(year);
	}

	public void clickCloseButton() {
		closeButton.click();
	}

	public void clickSignUpButton() {
		signUpButton.click();
	}

	public void clickReceiveMarketingCheckBox() {
		receiveMarketingCheckBox.click();
	}

	public void clickLogInButton() {
		logInButton.click();
	}

}
