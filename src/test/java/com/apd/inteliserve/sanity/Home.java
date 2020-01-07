package com.apd.inteliserve.sanity;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.apd.inteliserve.general.Keyword;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

/**
 * @author MadhurVK
 *
 */

public class Home extends Keyword {


	@Test
	public void homePageTest() throws Exception {
		extentTest = extent.startTest("Home");
		extentTest.log(LogStatus.PASS, "Test Started");
		SoftAssert s = new SoftAssert();
		Reporter.log("Home Console Output",true);
		Reporter.log("______________________________________",true);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try{
			clickHomeMenu();
			extentTest.log(LogStatus.PASS, "Cliked on Create Home Menu");
			waitForIvaChatToLoad();
			MobileElement textBox=getEditTextBox();
			textBox.sendKeys("Tell me about Unisys ");
			clickSendMessage();
			extentTest.log(LogStatus.PASS, "Request Data Sent");
			waitForMiniumTimeToLoad();
			clickNoButton();
			extentTest.log(LogStatus.PASS, "clicked on No Button");
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
			waitForIvaChatToLoad();
			textBox.sendKeys("Tell me about Unisys ");
			clickSendMessage();
			extentTest.log(LogStatus.PASS, "Request Data Sent");
			clickNoButton();
			extentTest.log(LogStatus.PASS, "clicked on No Button");
			MobileElement video=viewVideo();
			waitForMaxmimunTimeToLoad();
			if(video.isDisplayed()){
				extentTest.log(LogStatus.PASS, "Video Displayed");
				video.click();
				extentTest.log(LogStatus.PASS, "Clicked On Video");
			}
			s.assertTrue(video.isDisplayed());
			waitForMiniumTimeToLoad();
			playVideo();
			extentTest.log(LogStatus.PASS, "Video Played");
			waitForMaxmimunTimeToLoad();
			extentTest.log(LogStatus.PASS, "Test Successfull");
			Reporter.log("------------------------------------------------------------------------------------------------------------------------------------------------------",true);
			s.assertAll();
		}catch(Exception e){
			e.printStackTrace();
			extentTest.log(LogStatus.FAIL, e.getMessage());
			extentTest.log(LogStatus.FAIL, "Test Failed");
			Assert.fail("Home Test Failed");
		}
	}
}

