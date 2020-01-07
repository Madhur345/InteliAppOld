package com.apd.inteliserve.sanity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.apd.inteliserve.general.Keyword;
import com.apd.inteliserve.general.Lib;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

/**
 * @author MadhurVK
 *
 */

public class ScheduleContact extends Keyword{

	@Test
	public void scheduleContact() throws InterruptedException {
		extentTest = extent.startTest("ScheduleContact");
		extentTest.log(LogStatus.PASS, "Test Started");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("ScheduleContact Console Output",true);
		Reporter.log("______________________________________",true);
		try{
			clickScheduleContactMenu();
			waitForIvaChatToLoad();
			extentTest.log(LogStatus.PASS, "Cliked on Schedule Contact Menu");
			MobileElement textBox=getEditTextBox();
			String mobileNumber=Lib.getPropertyValue("MOBILE");
			waitForIvaChatToLoad();;
			textBox.sendKeys(mobileNumber);
			extentTest.log(LogStatus.PASS, "Mobile Number Entered");
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Lib.getLocator("SEND_MESSAGE"))).click();
			extentTest.log(LogStatus.PASS, "Mobile Number Sent");
			String country=Lib.getPropertyValue("COUNTRY");
			waitForIvaChatToLoad();;
			textBox.sendKeys(country);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Lib.getLocator("SEND_MESSAGE"))).click();
			extentTest.log(LogStatus.PASS, "Region/Country Selected");
			String date=Lib.getPropertyValue("DATE");
			waitForIvaChatToLoad();;
			textBox.sendKeys(date);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Lib.getLocator("SEND_MESSAGE"))).click();
			extentTest.log(LogStatus.PASS, "Date Entered");
			String time =Lib.getPropertyValue("TIME");
			waitForIvaChatToLoad();;
			textBox.sendKeys(time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Lib.getLocator("SEND_MESSAGE"))).click();
			extentTest.log(LogStatus.PASS, "Time Entered");
			waitForIvaChatToLoad();;
			textBox.sendKeys("I need a ios and a android mobile  for testing");
			wait.until(ExpectedConditions.visibilityOfElementLocated(Lib.getLocator("SEND_MESSAGE"))).click();
			extentTest.log(LogStatus.PASS, "Contact Reason Entered");
			waitForIvaChatToLoad();;
			clickYesButton();
			extentTest.log(LogStatus.PASS, "clicked On Yes Button");
			waitForIvaChatToLoad();
			clickNoButton();
			extentTest.log(LogStatus.PASS, "clicked On No Button");
			waitForIvaChatToLoad();;
			clickChatToggleButton();
			extentTest.log(LogStatus.PASS, "Chat Details Opened");
			waitForIvaChatToLoad();;
			Reporter.log("Getting text after conversation is closed",true);
			Reporter.log("===================================================================",true);
			List<AndroidElement> text= getIVAText();
			for(MobileElement element : text) {
				String getData= element.getText();
				Reporter.log(getData,true);
			}
			extentTest.log(LogStatus.PASS, "Got The Text");
			closeChatNotes();
			extentTest.log(LogStatus.PASS, "closed Chat Notes");
			clickToggleButton();
			extentTest.log(LogStatus.PASS, "Cliked On Toggle Button");
			clickMuteIcon();
			extentTest.log(LogStatus.PASS, "Conversation Muted");
			waitForMiniumTimeToLoad();
			clickUnMuteIcon();
			extentTest.log(LogStatus.PASS, "Conversation Unmuted");
			clickResetIcon();
			waitForIvaChatToLoad();
			Reporter.log("Getting text after reseting conversation",true);
			Reporter.log("===================================================================",true);
			List<AndroidElement> text1= getIVAText();
			for(MobileElement element1 : text1) {
				String reset= element1.getText();
				Reporter.log(reset,true);
			}
			extentTest.log(LogStatus.PASS, "Conversation Reseted");
			extentTest.log(LogStatus.PASS, "Test Successfull");
			Reporter.log("------------------------------------------------------------------------------------------------------------------------------------------------------",true);
		}catch(Exception e){
			e.printStackTrace();
			extentTest.log(LogStatus.FAIL, e.getMessage());
			extentTest.log(LogStatus.FAIL, "Test Failed");
			Assert.fail(" Schedule Contact Test Failed");
		}
	}
}