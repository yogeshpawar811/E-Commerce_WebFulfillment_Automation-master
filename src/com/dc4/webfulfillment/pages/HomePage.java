package com.dc4.webfulfillment.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dc4.webfulfillment.commons.WebDriverFactory;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends WebDriverFactory {

	@FindBy(xpath = "//h1[contains(text(), 'DC4 Customer Manager - Home')]")
	WebElement verifyText;

	@FindBy(xpath = "//span[contains(text(), 'Logged in as')]")
	WebElement loggedInText;

	public HomePage() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);

	}

	public void verifyHomePage() {

		// if (loggedInText.getText().contentEquals("ABC"))
		if (loggedInText.getText().contentEquals("DC4 Customer Manager - Home")) {

			test.log(LogStatus.INFO, "Verified the home page successfully.");
			test.log(LogStatus.INFO, "Login successfull.");
			// assertEquals(loggedInText.getText(), "DC4 Customer Manager -
			// Home");
			assertTrue(true);

		} else {
			assertTrue(false, loggedInText.getText() + " is not " + "DC4 Customer Manager - Home");
			test.log(LogStatus.FAIL, "Failed while verifying the home page.");

		}

	}

}
