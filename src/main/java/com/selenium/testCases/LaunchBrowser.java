/**
 * This is the base class for all the testcases which provides @Before and @After class method
 */

package com.selenium.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aspose.cells.Workbook;
import com.selenium.utilities.ReadConfigFile;

/**
 * @author NivedhaNatarajan
 *
 */

public class LaunchBrowser {

	public WebDriver driver=null;
	public static Logger _LOGGER;
	ReadConfigFile configFile = new ReadConfigFile();
	public static Workbook WB;

	@BeforeSuite
	public void getDataWorkBook() throws Exception
	{
		WB = new Workbook(configFile.getTestDataWorkbook());
	}

	@BeforeClass
	@Parameters({"browser"})
	public void getLaunchBrowser(String browser)
	{
		String browserName = browser.toLowerCase();
		try
		{
			_LOGGER = Logger.getLogger(LaunchBrowser.class);
			PropertyConfigurator.configure("Log4j.properties");

			if (browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", configFile.getChromeDriverPath());
				driver = new ChromeDriver();

			} 
			else  if(browserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", configFile.getFireFoxDriverPath());
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", configFile.getIEDriverPath());
				driver = new InternetExplorerDriver();
			}
			else
			{
				_LOGGER.error("Browser name given in the file is not correct - "+browserName);
			}

			_LOGGER.info("Browser and driver properties set");

			driver.manage().deleteAllCookies();
			_LOGGER.info("Cookies deleted");

			driver.manage().timeouts().pageLoadTimeout(configFile.getpageLoadTimeOut(), TimeUnit.SECONDS );
			_LOGGER.info("Default page load time set");

			driver.manage().timeouts().implicitlyWait(configFile.getImplicitWait(), TimeUnit.SECONDS);
			_LOGGER.info("Default implicit wait set");

			driver.get(configFile.getURL());
			_LOGGER.info("Page URL is loaded");

			driver.manage().window().maximize();
			_LOGGER.info("Window maximized");

		}
		catch (Exception e)
		{
			_LOGGER.error("Initialization of the browser failed  with the  error - "+e);
		}
	}

	public void setCustomPageLoadTimeOut(int pageLoadTimeOut, WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS );
		_LOGGER.info("Custom page load time set");
	}

	public void setCustomImplicitWait(int implicitWait, WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		_LOGGER.info("Custom implicit wait set");
	}

	public void setDefaultPageLoadTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(configFile.getpageLoadTimeOut(), TimeUnit.SECONDS );
		_LOGGER.info("Default page load time set");
	}

	public void setDefaultImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(configFile.getImplicitWait(), TimeUnit.SECONDS);
		_LOGGER.info("Default implicit wait set");
	}

	public void openUrl(WebDriver driver)
	{
		driver.get(configFile.getURL());
		_LOGGER.info("URL is loaded");

		driver.manage().window().maximize();
		_LOGGER.info("Window maximized");
	}	

	public String getHomeWindowHandle ()
	{
		return driver.getWindowHandle();
	}

	public String getHomePageTitle()
	{
		return configFile.getHomePageTitle();
	}

	public String getExploreStayTitle()
	{
		return configFile.getExploreStayTitle();
	}

	public Workbook getTestDataWorkbook()
	{
		return WB;
	}

	public Logger getLogger()
	{
		return _LOGGER;
	}

	@AfterClass
	public void getcloseBrowser()
	{
		driver.quit();
		_LOGGER.info("Browser is closed");
	}

}
