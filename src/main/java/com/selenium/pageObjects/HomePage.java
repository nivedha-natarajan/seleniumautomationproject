/**
 * This class contains all the webObjects present in the HomePage
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
public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[text()='Sign up']")
	@CacheLookup
	WebElement signUp;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Host a home']")
	@CacheLookup
	WebElement hostAHome;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Host an experience']")
	@CacheLookup
	WebElement hostAnExperience;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Help']")
	@CacheLookup
	WebElement help;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Log in']")
	@CacheLookup
	WebElement logIn;
	
	@FindBy(how = How.CLASS_NAME, using = "_1uqovkx6")
	@CacheLookup
	WebElement logo;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='_1s04l2o']/li[1]")
	@CacheLookup
	WebElement language;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='_1s04l2o']/li[2]")
	@CacheLookup
	WebElement currency;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Close']")
	@CacheLookup
	WebElement footerClose;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Explore Airbnb']")
	@CacheLookup
	WebElement explore;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Airbnb Plus places to stay']")
	@CacheLookup
	WebElement plus;
	
	@FindBy(how = How.XPATH, using = "//span[text()='EXPLORE STAYS']")
	@CacheLookup
	WebElement exploreStays;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_ubzwse']/h1")
	@CacheLookup
	WebElement searchText;
	
	@FindBy(how = How.CLASS_NAME, using = "_1f8ev6q")
	@CacheLookup
	WebElement where;
	
	@FindBy(how = How.ID, using = "checkin_input")
	@CacheLookup
	WebElement checkIn;
	
	@FindBy(how = How.ID, using = "checkout_input")
	@CacheLookup
	WebElement checkOut;
	
	@FindBy(how = How.CLASS_NAME, using = "_18s8f6ik")
	@CacheLookup
	WebElement previous;
	
	@FindBy(how = How.CLASS_NAME, using = "_1h5uiygl")
	@CacheLookup
	WebElement next;
	
	@FindBy(how = How.XPATH, using = "//td[@role='button' and contains(@aria-label,' as your start date. It's available.')]")
	@CacheLookup
	WebElement availableStartDate;
	
	@FindBy(how = How.XPATH, using = "//td[@role='button' and contains(@aria-label,' as your end date. It's available.')]")
	@CacheLookup
	WebElement availableEndDate;
	
	@FindBy(how = How.CLASS_NAME, using = "_gucugi")
	@CacheLookup
	WebElement pickMonthYear;

	@FindBy(how = How.XPATH, using = "//table[@class='_p5jgym']/tbody/tr/td")
	@CacheLookup
	WebElement selectDates;
	
	@FindBy(how = How.ID, using = "lp-guestpicker")
	@CacheLookup
	WebElement guestPicker;

	@FindBy(how = How.XPATH, using = "//div[@class='_9cfq872']/div/div[1]/div/div/div/div[2]/div/div[3]/button/span")
	@CacheLookup
	WebElement adultPlus;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_9cfq872']/div/div[1]/div/div/div/div[2]/div/div/button/span")
	@CacheLookup
	WebElement adultMinus;

	@FindBy(how = How.XPATH, using = "//div[@class='_9cfq872']/div/div[1]/div/div/div/div[2]/div/div/div")
	@CacheLookup
	WebElement adultCount;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_9cfq872']/div/div[2]/div/div/div/div[2]/div/div[3]/button/span")
	@CacheLookup
	WebElement childrenPlus;

	@FindBy(how = How.XPATH, using = "//div[@class='_9cfq872']/div/div[2]/div/div/div/div[2]/div/div/button/span")
	@CacheLookup
	WebElement childrenMinus;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_9cfq872']/div/div[2]/div/div/div/div[2]/div/div/div")
	@CacheLookup
	WebElement childrenCount;

	@FindBy(how = How.XPATH, using = "//div[@class='_9cfq872']/div/div[3]/div/div/div/div[2]/div/div[3]/button/span")
	@CacheLookup
	WebElement infantsPlus;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_9cfq872']/div/div[3]/div/div/div/div[2]/div/div/button/span")
	@CacheLookup
	WebElement infantsMinus;

	@FindBy(how = How.XPATH, using = "//div[@class='_9cfq872']/div/div[3]/div/div/div/div[2]/div/div/div")
	@CacheLookup
	WebElement infantsCount;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_j1kt73']/span")
	@CacheLookup
	WebElement guestCount;

	@FindBy(how = How.XPATH, using = "//div[@class='_j1kt73']/span/span")
	@CacheLookup
	WebElement guestCountInfant;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Clear']")
	@CacheLookup
	WebElement clearButton;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	@CacheLookup
	WebElement searchButton;
	
	@FindBy(how = How.CLASS_NAME, using = "_1oltmu")
	@CacheLookup
	WebElement whereClearButton;
	
	@FindBy(how = How.XPATH, using = "//button[@class='optanon-allow-all accept-cookies-button']")
	@CacheLookup
	WebElement acceptCookies;
	
	public void clickAcceptCookies()
	{
		acceptCookies.click();
	}
	
	public WebElement getCurrency()
	{
		return currency;
	}
	
	public WebElement getLogIn()
	{
		return logIn;
	}
	
	public WebElement getSignUp()
	{
		return signUp;
	}
	
	public WebElement getLanguage()
	{
		return language;
	}
	
	public WebElement getHostAHome()
	{
		return hostAHome;
	}
	
	public WebElement getHostAnExperience()
	{
		return hostAnExperience;
	}
	
	public WebElement getHelp()
	{
		return help;
	}
	
	public WebElement getLogo()
	{
		return logo;
	}
	
	public WebElement getExplore()
	{
		return explore;
	}
	
	public WebElement getAirBnBPlus()
	{
		return plus;
	}
	
	public WebElement getExploreStays()
	{
		return exploreStays;
	}
	
	public void clickExploreStays()
	{
		exploreStays.click();
	}
	
	public void clickCurrency()
	{
		currency.click();
	}
	
	public void clickLanguage()
	{
		language.click();
	}
	
	public void clickHostAHome()
	{
		hostAHome.click();
	}
	
	public void clickHostAnExperience()
	{
		hostAnExperience.click();
	}
	
	public void clickHelp()
	{
		help.click();
	}
	
	public void clickSignUp()
	{
		signUp.click();
	}
	
	public void clickLogIn()
	{
		logIn.click();
	}
	
	public void clickLogo()
	{
		logo.click();
	}
	
	public String getHomeSearchText()
	{
		return searchText.getText();
	}
	
	public void setSearchWhere(String place)
	{
		where.sendKeys(place);
	}
}
