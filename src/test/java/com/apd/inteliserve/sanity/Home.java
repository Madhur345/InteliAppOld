package com.apd.inteliserve.sanity;


import java.util.List;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.apd.inteliserve.general.Keyword;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

/**
 * @author  VishalMadhur
 *
 */

//This Test Script is for Testing "Home" Page

public class Home extends Keyword {


	@Test
	public void homePageTest() throws Exception {
		extentTest = extent.startTest("Home");
		extentTest.log(LogStatus.PASS, "Test Started");
		SoftAssert s = new SoftAssert();
		Reporter.log("Home Console Output",true);
		Reporter.log("______________________________________",true);
		waitForAllElementsVisibility();
		try{
			click("HOME_LINK");
			extentTest.log(LogStatus.PASS, "Cliked on Create Home Menu");
			waitForIvaChatToLoad();
			sendTestData("EDIT_TEXTBOX", "TestData", 7, 1);
			click("SEND_MESSAGE_ICON");
			extentTest.log(LogStatus.PASS, "Request Data Sent");
			waitForMiniumTimeToLoad();
			click("NO_BUTTON");
			extentTest.log(LogStatus.PASS, "clicked on No Button");
			click("TOGGLE_BUTTON");
			extentTest.log(LogStatus.PASS, "Cliked On Toggle Button");
			click("MUTE_ICON");
			extentTest.log(LogStatus.PASS, "Conversation Muted");
			waitForMiniumTimeToLoad();
			click("UNMUTE_ICON");
			extentTest.log(LogStatus.PASS, "Conversation Unmuted");
			click("RESET_ICON");
			waitForIvaChatToLoad();
			Reporter.log("Getting text after reseting conversation",true);
			Reporter.log("===================================================================",true);
			List<AndroidElement> text= getElements("IVA_TEXT");
			for(MobileElement element : text) {
				String reset= element.getText();
				Reporter.log(reset,true);
			}
			waitForIvaChatToLoad();
			sendTestData("EDIT_TEXTBOX", "TestData", 7, 1);
			click("SEND_MESSAGE_ICON");
			extentTest.log(LogStatus.PASS, "Request Data Sent");
			click("NO_BUTTON");
			extentTest.log(LogStatus.PASS, "clicked on No Button");
			MobileElement video=getElement("VIDEO_VIEW");
			waitForMaxmimunTimeToLoad();
			if(video.isDisplayed()){
				extentTest.log(LogStatus.PASS, "Video Displayed");
				video.click();
				extentTest.log(LogStatus.PASS, "Clicked On Video");
			}
			s.assertTrue(video.isDisplayed());
			waitForMiniumTimeToLoad();
			click("VIDEO_PLAY");
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

