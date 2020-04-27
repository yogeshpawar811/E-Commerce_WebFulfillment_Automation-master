package com.dc4.webfulfillment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dc4.webfulfillment.commons.Utility;
import com.dc4.webfulfillment.commons.WebDriverFactory;

public class DC4Page {

	@FindBy(xpath = "//*[text()='DC4']")
	WebElement dc4Tb;
	
	@FindBy(xpath = "//*[text()='Company UID']//following::input[1]")
	WebElement companyId;
	
	public DC4Page() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public boolean isPageLoaded() {
		return Utility.waitForPageElement("xpath", "//*[text()='Company UID']//following::input[1]");
	}
	
	public void clickOnDC4Tab() {
		dc4Tb.click();
	}

	public void enterCompanyUID(String companyUID) {
		companyId.sendKeys(companyUID);;
	}
}
