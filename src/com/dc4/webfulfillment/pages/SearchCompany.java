package com.dc4.webfulfillment.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dc4.webfulfillment.commons.WebDriverFactory;

public class SearchCompany {

	@FindBy(xpath = "//a[text()='Browse Customers']")
	WebElement browseCustomers;

	@FindBy(xpath = "//input[@id='inputText41' and @class='x8']")
	WebElement companyName;

	@FindBy(xpath = "//img[@alt='Search']")
	WebElement searchBtn;

	@FindBy(id = "//table[@id='table1']")
	WebElement searchResult;

	public SearchCompany() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}

	@SuppressWarnings("unchecked")
	public void searchCompany(String company) throws InterruptedException {

		System.out.println("Enter in searchCompany Method under class__________________________________" + company);
		browseCustomers.click();
		companyName.clear();
		companyName.sendKeys(company);
		// System.out.println("yogesh");
		searchBtn.click();
		Thread.sleep(2000);
		List<WebElement> e2 = (List<WebElement>) searchResult.getSize();
		System.out.println("Table size: " + e2);

	}

}
