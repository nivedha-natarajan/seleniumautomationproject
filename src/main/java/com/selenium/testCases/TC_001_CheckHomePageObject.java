/**
 * This class is to check whether all the Home page Objects are present or not
 */

package com.selenium.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

import com.selenium.pageObjects.HomePage;

/**
 * @author NivedhaNatarajan
 *
 */

public class TC_001_CheckHomePageObject extends LaunchBrowser {

	Logger _LOGGER = Logger.getLogger(TC_001_CheckHomePageObject.class);
	Actions action = null;
	HomePage homePage = null;

	@Test(priority = 1, groups="A")
	public void checkHomePageTabs() throws InterruptedException
	{
		homePage = getHomePage();
		action = getAction();

		try
		{
			try
			{
				Thread.sleep(2000);
				homePage.clickAcceptCookies();
				_LOGGER.info("Cookies popup is present and accepted");
			}
			catch(NoSuchElementException e)
			{
				_LOGGER.info("Cookies popup is not present");
			}
			try
			{
				AssertJUnit.assertEquals(getHomePageTitle(), driver.getTitle());
				_LOGGER.info("Page title is matching - " + driver.getTitle());
			} catch(AssertionError e)
			{
				_LOGGER.error("Page title is not matching - " + driver.getTitle()+"\n Error - " + e, e);
			}

			AssertJUnit.assertTrue("Language tab is not present in the Home page", homePage.getLanguage().isDisplayed());
			AssertJUnit.assertTrue("Currency tab is not present in the Home page", homePage.getCurrency().isDisplayed());
			AssertJUnit.assertTrue("Host a Home tab is not present in the Home page", homePage.getHostAHome().isDisplayed());
			AssertJUnit.assertTrue("Host an Experience tab is not present in the Home page", homePage.getHostAnExperience().isDisplayed());
			AssertJUnit.assertTrue("Help tab is not present in the Home page", homePage.getHelp().isDisplayed());
			AssertJUnit.assertTrue("SignUp tab is not present in the Home page", homePage.getSignUp().isDisplayed());
			AssertJUnit.assertTrue("LogIn tab is not present in the Home page", homePage.getLogIn().isDisplayed());
			AssertJUnit.assertTrue("Logo tab is not present in the Home page", homePage.getLogo().isDisplayed());

			action.moveToElement(homePage.getExplore()).perform();
			Thread.sleep(1000);
			AssertJUnit.assertTrue("Explore is not present in the Home page", homePage.getExplore().isDisplayed());
			_LOGGER.info("Explore is present in the Home page");
			action.moveToElement(homePage.getAirBnBPlus()).perform();
			Thread.sleep(1000);
			AssertJUnit.assertTrue("AirBnB Plus is not present in the Home page", homePage.getAirBnBPlus().isDisplayed());
			_LOGGER.info("AirBnB Plus is present in the Home page");
			action.moveToElement(homePage.getExploreStays()).perform();
			Thread.sleep(1000);
			AssertJUnit.assertTrue("AirBnB Explore stays is not present in the Home page", homePage.getExploreStays().isDisplayed());
			_LOGGER.info("AirBnB Explore stays is present in the Home page");
			homePage.clickExploreStays();

		}
		catch(NoSuchElementException e)
		{
			_LOGGER.error("Test errored with the message : " + e);
			throw new Error(e);
		}
	}

	@Test(dependsOnMethods = "checkHomePageTabs", groups="A")
	public void checkExplorePageTitle()
	{
		homePage = getHomePage();

		try
		{
			try
			{
				AssertJUnit.assertEquals(getExploreStayTitle(), driver.getTitle());
				_LOGGER.info("Explore Plus page title is matching - " + driver.getTitle());
			} 
			catch(AssertionError e)
			{
				_LOGGER.error("Explore Plus page title is not matching - " + driver.getTitle()+"\n Error - " + e, e);
			}
		}
		catch (Exception e)
		{
			_LOGGER.error("Test errored with the message : " + e);
			throw new Error(e);
		}
	}

	public void setHomePage()
	{
		homePage = new HomePage(driver);
	}

	public HomePage getHomePage()
	{
		if (homePage != null)
		{
			return homePage;
		}
		else
		{
			setHomePage();
			return homePage;
		}
	}

	private void setAction() {
		action = new Actions(driver);
	}

	private Actions getAction() 
	{
		if (action != null)
		{
			return action;
		}
		else
		{
			setAction();
			return action;
		}
	}

}
