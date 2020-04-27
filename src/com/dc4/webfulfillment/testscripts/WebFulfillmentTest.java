package com.dc4.webfulfillment.testscripts;

import org.testng.annotations.Test;

import com.dc4.webfulfillment.commons.WebDriverFactory;
import com.dc4.webfulfillment.dataprovider.DataProviders;
import com.dc4.webfulfillment.pages.DC4Page;
import com.dc4.webfulfillment.pages.LoginPage;
import com.dc4.webfulfillment.pages.SearchCompany;
import com.dc4.webfulfillment.pages.SearchCorex;

public class WebFulfillmentTest extends WebDriverFactory {
	
	LoginPage login;
	SearchCompany search;
	SearchCorex searchCorex;
	DC4Page dc4;
	
	@Test(priority = 1)
	public void successfullLogin() throws InterruptedException {
		login = new LoginPage();
		login.Login();
	}

	@Test(dataProvider = "companyNames", dataProviderClass = DataProviders.class, priority = 2)
	public void searchCompanyUsingSalesForce(String companyName, String salesforceID) throws Exception {
		searchCorex = new SearchCorex();
		searchCorex.searchCompany(salesforceID);
	}
	
	@Test(priority=3)
	public void searchCompany() throws Exception {
		searchCorex = new SearchCorex();
		dc4 = new DC4Page();
		String companyUID = searchCorex.getCompanyUID();
		dc4.clickOnDC4Tab();
		dc4.enterCompanyUID(companyUID);
	}
}
