package com.dc4.webfulfillment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dc4.webfulfillment.commons.WebDriverFactory;

public class LoginPage extends WebDriverFactory {

	@FindBy(xpath = "//input[@id='c2' and @name='ssousername']")
	WebElement username;

	@FindBy(xpath = "//input[@type='password' and @name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);

	}

	public void Login() {
		// System.out.println("Im in login");
		// System.out.println(prop.getProperty("userName"));
		username.sendKeys(prop.getProperty("userName"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		// test.log(LogStatus.INFO, "Login button Clicked");
	}

}
