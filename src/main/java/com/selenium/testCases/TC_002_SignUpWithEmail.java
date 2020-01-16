/**
 * To check whether the user could able to login to the application using Email option
 */

package com.selenium.testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pageObjects.HomePage;
import com.selenium.pageObjects.SignUpTab;
import com.selenium.pageObjects.SignUpWithEmail;
import com.selenium.testData.ReadTestDocument;

import junit.framework.Assert;

/**
 * @author NivedhaNatarajan
 *
 */

public class TC_002_SignUpWithEmail extends LaunchBrowser {

	Logger _LOGGER = Logger.getLogger(TC_002_SignUpWithEmail.class);
	HomePage homePage = null;
	SignUpTab signUpTab = null;
	SignUpWithEmail signUpWithEmail = null;
	ReadTestDocument readTestDocument = null;

	@DataProvider
	public String[][] getTestData()
	{
		readTestDocument = getReadTestDocument();
		String[][] testData = readTestDocument.getTestData(WB, "TC_002_SignUpWithEmail");
		return testData;
	}

	@Test(dataProvider="getTestData")
	public void signUpWithGmail(String emailID, String firstName, String lastName, String password, String month, String day, String year, String marketingMessages) throws InterruptedException
	{
		homePage = new HomePage(driver);
		signUpTab = new SignUpTab(driver);
		signUpWithEmail = new SignUpWithEmail(driver);

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

			signUpTab.clickSignUpWithEmail();
			_LOGGER.info("In Signup with Email page");

			signUpWithEmail.typeEmailId(emailID);
			_LOGGER.info("User EmailID entered : " + emailID);
			signUpWithEmail.typeFirstName(firstName);
			_LOGGER.info("User First Name entered : " + firstName);
			signUpWithEmail.typeLastName(lastName);
			_LOGGER.info("User Last Name entered : " + lastName);
			signUpWithEmail.typePassword(password);
			_LOGGER.info("User password entered : " + password);
			signUpWithEmail.getSelectMonth(month);
			_LOGGER.info("User Birth month entered : " + month);
			signUpWithEmail.getSelectDay(day);
			_LOGGER.info("User Birth day entered : " + day);
			signUpWithEmail.getSelectYear(year);
			_LOGGER.info("User Birth year entered : " + year);
			if (marketingMessages.equalsIgnoreCase("Y"))
			{
				signUpWithEmail.clickReceiveMarketingCheckBox();
				_LOGGER.info("Selected - Receive marketing messages checkbox : " + marketingMessages);
			}
			else
			{
				_LOGGER.info("Not Selected - Receive marketing messages checkbox : " + marketingMessages);
			}
			Thread.sleep(3000);
			signUpWithEmail.clickCloseButton();
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
