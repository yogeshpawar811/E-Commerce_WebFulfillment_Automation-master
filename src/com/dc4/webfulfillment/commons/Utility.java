package com.dc4.webfulfillment.commons;

import org.openqa.selenium.By;

public class Utility {

	public static boolean waitForPageElement(String locator, String locatorDescription) {
		// int counter=0;
		boolean matched = false;
		for (int counter = 0; counter <= 20; counter++) {
			try {
				switch (locator) {
				case "id":
					WebDriverFactory.getDriver().findElement(By.id(locatorDescription)); {
					matched = true;
					break;

					// return true;
				}
				case "xpath":
					WebDriverFactory.getDriver().findElements(By.xpath(locatorDescription)); {
					matched = true;
					break;

					// return true;
				}
				case "name":
					WebDriverFactory.getDriver().findElement(By.name(locatorDescription)); {
					matched = true;
					break;

					// return true;
				}
				}
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					System.out.println("The Element " + locatorDescription + " is not found in " + counter + " sec.");
					// counter++;
				} catch (InterruptedException e1) {
					e1.getStackTrace();
				}
			}
		}
		if (matched)
			return true;
		else
			return false;

	}
}
