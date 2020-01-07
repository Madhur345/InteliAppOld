package com.apd.inteliserve.general;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * @author MadhurVK
 *
 */
public class BaseTest implements IAutoConstant{
	public static  AndroidDriver<AndroidElement> driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static AppiumDriverLocalService service;


	@BeforeSuite
	public void setEnvironmentAndOpenApplication() throws Exception {
		extent=Lib.generateExtentReport();
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		String device=Lib.getPropertyValue("DEVICENAME");
		String udidNumber=Lib.getPropertyValue("UDID");
		String version=Lib.getPropertyValue("PLATFORMVERSION");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName",device);
		capabilities.setCapability("udid", udidNumber);
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion", version); 
		capabilities.setCapability("appPackage", "com.serviont.inteliapp");
		capabilities.setCapability("appActivity","com.serviont.inteliapp.MainActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Keyword.loginInteliApp();
		Keyword.waitForMaxmimunTimeToLoad();
		Keyword.clickHamburgerMenu();
	}

	@AfterMethod
	public void getResultStatus(ITestResult result) throws Exception
	{
		Keyword.clickHamburgerMenu();
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); 
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); 
			String screenshotPath = Lib.captureScreenshots(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); 
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
		}
		extent.endTest(extentTest);
	}

	@AfterSuite
	public void closeApplicationAndEndReport() throws Exception{
		Keyword.clickLogoutLink();
		for (String s : Reporter.getOutput()) { 
			extent.setTestRunnerOutput(s); 
		}
		extent.flush();
		extent.close();
		driver.quit();
		service.stop();
	}
}

