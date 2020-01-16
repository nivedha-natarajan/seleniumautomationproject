/**
 * 
 */

package com.selenium.testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pageObjects.HomePage;
import com.selenium.pageObjects.SignUpTab;
import com.selenium.pageObjects.SignUpWithFacebook;
import com.selenium.testData.ReadTestDocument;
import com.selenium.utilities.SwitchWindowHandle;

import junit.framework.Assert;

/**
 * @author NivedhaNatarajan
 *
 */

public class TC_003_SignUpWithFacebook extends LaunchBrowser {

	Logger _LOGGER = Logger.getLogger(TC_003_SignUpWithFacebook.class);
	HomePage homePage = null;
	SignUpTab signUpTab = null;
	ReadTestDocument readTestDocument = null;
	SignUpWithFacebook signUpWithFacebook = null;


	@DataProvider
	public String[][] getTestData()
	{
		readTestDocument = getReadTestDocument();
		String[][] testData = readTestDocument.getTestData(WB, "TC_003_SignUpWithFacebook");
		return testData;
	}

	@Test(dataProvider = "getTestData")
	public void signUpWithFacebook (String userName, String password)
	{
		homePage = new HomePage(driver);
		signUpTab = new SignUpTab(driver);
		signUpWithFacebook = new SignUpWithFacebook(driver);
		String homeWindowHandle = getHomeWindowHandle();

		try
		{
			driver.navigate().refresh();
			_LOGGER.info("Page is Refreshed");
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
				Assert.assertEquals(getHomePageTitle(), driver.getTitle());
				_LOGGER.info("Page title is matching - " + driver.getTitle());
			} catch(AssertionError e)
			{
				_LOGGER.error("Page title is not matching - " + driver.getTitle()+"\n Error - " + e);
			}

			homePage.clickSignUp();		
			_LOGGER.info("In Signup tab page");

			signUpTab.clickContinueWithFacebook();
			_LOGGER.info("In Signup with Facebook page");

			driver.switchTo().window(SwitchWindowHandle.getSwitchWindowHandle(driver));
			_LOGGER.info("Switched to the new Window");

			_LOGGER.info("Title of the new Page - " + driver.getTitle());

			signUpWithFacebook.typeEmail(userName);
			_LOGGER.info("Facebook username entered : " + userName);
			signUpWithFacebook.typePassword(password);
			_LOGGER.info("Facebook password entered : " + password);
			signUpWithFacebook.clickLogin();
			_LOGGER.info("Login button clicked");

			_LOGGER.info("Log in page Title - " + driver.getTitle());

			try
			{
				if (signUpWithFacebook.getSwitchUserDropDown().isDisplayed())
				{
					signUpWithFacebook.clickSwitchUserDropDown();
					signUpWithFacebook.clickSwitchUser();
					_LOGGER.info("Logged out of the User : " + userName);

					driver.close();
					_LOGGER.info("Facebook window closed");

					driver.switchTo().window(homeWindowHandle);
					_LOGGER.info("Window handle switched to Home window");
				}
			}
			catch (NoSuchElementException e)
			{
				_LOGGER.error("User is not Present - " + userName);

				driver.close();
				_LOGGER.info("Facebook window closed");				

				driver.switchTo().window(homeWindowHandle);
				_LOGGER.info("Window handle switched to Home window");

				throw new Error();
			}

		}
		catch (Exception e)
		{
			_LOGGER.error("Test errored with the message : " + e);
			throw new Error(e);
		}
	}

	public void setReadTestDocument()
	{
		readTestDocument = new ReadTestDocument();
	}

	public ReadTestDocument getReadTestDocument()
	{
		if (readTestDocument != null)
		{
			return readTestDocument;
		}
		else
		{
			setReadTestDocument();
			return readTestDocument;
		}
	}

}
