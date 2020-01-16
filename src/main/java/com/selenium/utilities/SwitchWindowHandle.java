/**
 * This class is used to switch to a new window
 */

package com.selenium.utilities;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * @author NivedhaNatarajan
 */

public class SwitchWindowHandle {
	
	public static Logger _LOGGER = Logger.getLogger(SwitchWindowHandle.class);
	
	public static String getSwitchWindowHandle (WebDriver driver) throws InterruptedException
	{
		String parentWindow, newWindow = null;
		parentWindow = driver.getWindowHandle();
		_LOGGER.info("Parent window Handle : " + parentWindow);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles)
		{
			if (!handle.equals(parentWindow))
			{
				_LOGGER.info("Current window Handle : " + handle);
				newWindow = handle;
				Thread.sleep(2000);
			}
		}
		return newWindow;
	}

}
