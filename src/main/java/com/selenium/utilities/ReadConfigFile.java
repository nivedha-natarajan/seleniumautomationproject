/**
 * This class is used to read the configuration details of the application
 */

package com.selenium.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * @author NivedhaNatarajan
 */

public class ReadConfigFile {
	
	public static Logger _LOGGER = Logger.getLogger(ReadConfigFile.class);
	Properties properties;
	
	public ReadConfigFile ()
	{
		BufferedReader readfile;
		try {
			readfile = new BufferedReader(new FileReader("./Configuration/config.properties"));
			_LOGGER.info("Configuration file opened");
			properties = new Properties();
			try {
				properties.load(readfile);
				_LOGGER.info("Configuration file loaded to properties");
				readfile.close();
				_LOGGER.info("Configuration file closed");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at the specified location");
		}
		
	}
	
	public String getChromeDriverPath()
	{
		String driverPath = properties.getProperty("chromeDriverPath");
		if (driverPath != null)
		{
			_LOGGER.info("Driverpath value read from Configuration file");
			return driverPath;
		}
		else
		{
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
		}
	}
	
	public String getFireFoxDriverPath()
	{
		String driverPath = properties.getProperty("fireFoxDriverPath");
		if (driverPath != null)
		{
			_LOGGER.info("Driverpath value read from Configuration file");
			return driverPath;
		}
		else
		{
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
		}
	}
	
	public String getIEDriverPath()
	{
		String driverPath = properties.getProperty("IEDriverPath");
		if (driverPath != null)
		{
			_LOGGER.info("Driverpath value read from Configuration file");
			return driverPath;
		}
		else
		{
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
		}
	}
	
	public long getImplicitWait()
	{
		String implicitWait = properties.getProperty("implicitWait");
		if (implicitWait != null)
		{
			_LOGGER.info("ImplicitWait value read from Configuration file");
			return Long.parseLong(implicitWait);
		}
		else
		{
			throw new RuntimeException("ImplicitWait not specified in the Configuration.properties file.");		
		}
	}
	
	public long getpageLoadTimeOut ()
	{
		String pageLoadTimeOut = properties.getProperty("pageLoadTimeOut");
		if (pageLoadTimeOut != null)
		{
			_LOGGER.info("PageTimeOut value read from Configuration file");
			return Long.parseLong(pageLoadTimeOut);
		}
		else
		{
			throw new RuntimeException("PageLoadTimeOut not specified in the Configuration.properties file.");		
		}
	}
	
	public String getURL()
	{
		String url = properties.getProperty("url");
		if (url != null)
		{
			_LOGGER.info("URL value read from Configuration file");
			return url;
		}
		else
		{
			throw new RuntimeException("URL not specified in the Configuration.properties file.");		
		}
	}
	
	public String getHomePageTitle()
	{
		String homePageTitle = properties.getProperty("homePageTitle");
		if (homePageTitle != null)
		{
			_LOGGER.info("HomePage Title value read from Configuration file");
			return homePageTitle;
		}
		else
		{
			throw new RuntimeException("HomePage Title not specified in the Configuration.properties file.");		
		}
	}
	
	public String getExploreStayTitle()
	{
		String exploreStayTitle = properties.getProperty("exploreStayTitle");
		if (exploreStayTitle != null)
		{
			_LOGGER.info("ExploreStay Title value read from Configuration file");
			return exploreStayTitle;
		}
		else
		{
			throw new RuntimeException("ExploreStay Title not specified in the Configuration.properties file.");		
		}
	}
	
	public String getTestDataWorkbook()
	{
		String testDataWorkbook = properties.getProperty("testDataWorkbook");
		if (testDataWorkbook != null)
		{
			_LOGGER.info("TestData Workbook value read from Configuration file");
			return testDataWorkbook;
		}
		else
		{
			throw new RuntimeException("TestData Workbook not specified in the Configuration.properties file.");		
		}
	}
}
