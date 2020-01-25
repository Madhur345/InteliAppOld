package com.apd.inteliserve.general;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

/**
 * @author  VishalMadhur
 *
 */


public class Keyword extends BaseTest{

	//Method to Login to InteliApp

	public static void loginInteliApp() throws Exception{
		try{
		driver.findElement((Lib.getLocator("ACCEPT_LINK"))).click();
		driver.findElement(Lib.getLocator("EMAIL_TEXTBOX")).sendKeys(Lib.getPropertyValue("Email"));
		driver.findElement(Lib.getLocator("SIGNIN_BUTTON")).click();
		driver.findElement(Lib.getLocator("SELECT_USERNAME")).click();
		}catch(Exception e){
			e.printStackTrace();
			extentTest.log(LogStatus.FAIL, "Failed to login");
		}
	}
	public static void clickHamburgerMenu() throws Exception{
		driver.findElement(Lib.getLocator("HAMBURER_MENU")).click();
	}

	//Method for Click Action
	public static  void click(String element){
		try{
			driver.findElement(Lib.getLocator(element)).click();
			extentTest.log(LogStatus.PASS, element +" found"); 
		}catch(Exception e){
			String screenshotPath = Lib.captureScreenshots(driver, element);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extentTest.log(LogStatus.FAIL, element + " is Not Displayed or Clickable");
			extentTest.log(LogStatus.FAIL, e.getMessage());
		}
	}

	//Method to Send Test Data
	public  void sendTestData(String element,String sheet,int row,int colomn) throws Exception{
		try{
			driver.findElement(Lib.getLocator(element)).sendKeys(Lib.getCellValue(sheet, row, colomn));
		}catch(Exception e){
			String screenshotPath = Lib.captureScreenshots(driver, element);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extentTest.log(LogStatus.FAIL, "Failed To Send Data in Element "+ element +" As Element is not present");
		}
	}

	//Method to Get Text for Element
	public String getText(String element){
		try{
			return driver.findElement((Lib.getLocator(element))).getText();
		}catch(Exception e){
			String screenshotPath = Lib.captureScreenshots(driver, element);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extentTest.log(LogStatus.FAIL, "Failed to Get Text for Element " + element);
			extentTest.log(LogStatus.FAIL, e.getMessage());
		}
		return null;
	}

	// Method to Find Element in Web Page
	public static MobileElement getElement(String element){
		try{
			return driver.findElement(Lib.getLocator(element));
		}catch(Exception e){
			String screenshotPath = Lib.captureScreenshots(driver, element);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			
			extentTest.log(LogStatus.FAIL, e.getMessage());
		}
		return null;
	}

	// Method to Find Element in Web Page
	public static List<AndroidElement> getElements(String element){
		try{
			return driver.findElements(Lib.getLocator(element));
		}catch(Exception e){
			String screenshotPath = Lib.captureScreenshots(driver, element);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extentTest.log(LogStatus.FAIL, element+" Elements are Not Present");
			extentTest.log(LogStatus.FAIL, e.getMessage());
		}
		return null;
	}

	//Methods for Waits & Threads
	public void waitForAllElementsVisibility(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void waitForSpecificElementVisibility(String element){
		try{
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Lib.getLocator(element))).click();
		}catch(Exception e){
			String screenshotPath = Lib.captureScreenshots(driver, element);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extentTest.log(LogStatus.FAIL, element + " Element is Not Visible ");
		}
	}

	public void waitForIvaChatToLoad() throws InterruptedException{
		Thread.sleep(15000);
	}
	public static  void waitForMaxmimunTimeToLoad() throws InterruptedException{
		Thread.sleep(10000);
	}
	public  void waitForMiniumTimeToLoad() throws InterruptedException{
		Thread.sleep(5000);
	}
}