package com.dc4.webfulfillment.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class WebDriverFactory {

	public static ChromeDriver driver;
	public static String chromeDriverPath = "D:/Softwares/chromedriver_win32/";
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Properties prop = new Properties();
	FileInputStream fileInput = null;
	String configPath = "C:\\Users\\shriniwas.alle\\git\\WebFulfillment\\Web-Fulfillment\\src\\com\\dc4\\webfulfillment\\config\\config.properties";

	@BeforeSuite
	public void beforeSuite() {
		String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
		extent = new ExtentReports(extentReportFile, true);
		File file = new File(configPath);
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@BeforeTest
	public void setDriver() {
	
		System.setProperty("webdriver.chrome.driver", chromeDriverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(
				"http://boon.mps.spscommerce.net:7777/sso/jsp/login.jsp?site2pstoretoken=v1.4~4AC915A3~B9AA8DE67D404F9CC3DB39417DCAD4DF15E2F7EC0C84EC3C63B73B86CBDA98E663A371B9F2C5F664818489F238CDD16F1DB5766B8C9E285074AB073A8CFDEFF50D835CA3137274A83F3DDABE1CD0AF685F2EF31AEC4892F10D833742B7A94BE9F0F2C5954B5FD03FEB29DDA3F5DADE74654971C7CC919108535708F0B3D3A38BCCB92FFC9C6CEAC9150C2D3CB024BA4FDCEC8563BBDBE8253564AC0E81861789ED30DE0AE95CC37244E9CCA5B5F6A3496C00B9830D5C3480CDBBD184AB8A4ABAA7B7AFDA9E164343D7E48C0DDE0A88B0&p_error_code=&p_submit_url=http%3A%2F%2Fboon.mps.spscommerce.net%3A7777%2Fsso%2Fauth&p_cancel_url=http%3A%2F%2Fdc4ui.p01.pro%3A7777&ssousername=");
		driver.manage().window().maximize();
	}

	/*
	 * @AfterMethod public void testClosure() { dr.close(); dr.quit();
	 * test.log(LogStatus.INFO, "Browser Closed successfully...");
	 * 
	 * extent.endTest(test); }
	 */

	@AfterSuite
	public void afterSuite() {
		extent.flush();
		extent.close();

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String capture(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String dest = System.getProperty("user.dir") + "\\ScreenShots\\" + screenShotName + "_" + timeStamp + ".png";

		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}

	/*
	 * @AfterTest public void getResult(ITestResult result) throws IOException {
	 * if (result.getStatus() == ITestResult.FAILURE) { String screenShotPath =
	 * capture(driver, result.getMethod().getMethodName());
	 * test.log(LogStatus.FAIL, result.getThrowable()); test.log(LogStatus.FAIL,
	 * "Snapshot below: " + test.addScreenCapture(screenShotPath)); }
	 * driver.close(); driver.quit(); test.log(LogStatus.INFO,
	 * "Browser Closed successfully..."); extent.endTest(test); }
	 */

}