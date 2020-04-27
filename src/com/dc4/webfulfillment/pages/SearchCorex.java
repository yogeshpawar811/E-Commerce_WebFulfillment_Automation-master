package com.dc4.webfulfillment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dc4.webfulfillment.commons.Utility;
import com.dc4.webfulfillment.commons.WebDriverFactory;

public class SearchCorex {

	@FindBy(xpath = "//*[text()='Catalog']")
	WebElement catalogTb;

	@FindBy(xpath = "//td/a[text()='Search CORECS']")
	WebElement searchCORECSLk;

	@FindBy(xpath = "//label[text()='Salesforce']//following::input[1]")
	WebElement salesforceId;

	@FindBy(xpath = "//img[@alt='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//th[text()='Dc4']//following::td[5]")
	WebElement dc4CompanyUID;

	@FindBy(xpath = "//*[text()='DC4']")
	WebElement dc4Tb;
	
	public SearchCorex() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}

	public void searchCompany(String salesforceID) throws InterruptedException {
		catalogTb.click();
		Utility.waitForPageElement("xpath", "//td/a[text()='Search CORECS']");
		searchCORECSLk.click();
		salesforceId.sendKeys(salesforceID);
		searchBtn.click();
	}
	
	public String getCompanyUID() {
		String DC4CompanyUID = dc4CompanyUID.getText();
		System.out.println("DC4CompanyUID:" + DC4CompanyUID);
		return DC4CompanyUID;
	}
	
	
}
