package com.apd.inteliserve.sanity;

import java.util.List;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.apd.inteliserve.general.Keyword;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

/**
 * @author VishalMadhur
 *
 */

//This Test Script is for Testing "Schedule Contact" Page

public class ScheduleContact extends Keyword{

	@Test
	public void scheduleContact() throws InterruptedException {
		extentTest = extent.startTest("ScheduleContact");
		extentTest.log(LogStatus.PASS, "Test Started");
		waitForAllElementsVisibility();
		Reporter.log("ScheduleContact Console Output",true);
		Reporter.log("______________________________________",true);
		try{
			click("SCHEDULE_CONTACT_LINK");
			extentTest.log(LogStatus.PASS, "Cliked on Schedule Contact Menu");
			waitForIvaChatToLoad();
			sendTestData("EDIT_TEXTBOX", "TestData", 1, 1);
			extentTest.log(LogStatus.PASS, "Mobile Number Entered"); 
			waitForSpecificElementVisibility("SEND_MESSAGE_ICON");
			extentTest.log(LogStatus.PASS, "Mobile Number Sent");
			waitForMaxmimunTimeToLoad();
			sendTestData("EDIT_TEXTBOX", "TestData", 2, 1);
			waitForSpecificElementVisibility("SEND_MESSAGE_ICON");
			extentTest.log(LogStatus.PASS, "Region/Country Selected");
			waitForMiniumTimeToLoad();
			sendTestData("EDIT_TEXTBOX", "TestData", 3, 1);
			waitForSpecificElementVisibility("SEND_MESSAGE_ICON");
			extentTest.log(LogStatus.PASS, "Date Entered");
			waitForMiniumTimeToLoad();
			sendTestData("EDIT_TEXTBOX", "TestData", 4, 1);
			waitForSpecificElementVisibility("SEND_MESSAGE_ICON");
			extentTest.log(LogStatus.PASS, "Time Entered");
			waitForIvaChatToLoad();
			sendTestData("EDIT_TEXTBOX", "TestData", 6, 1);
			waitForSpecificElementVisibility("SEND_MESSAGE_ICON");
			extentTest.log(LogStatus.PASS, "Contact Reason Entered");
			waitForIvaChatToLoad();
			click("YES_BUTTON");
			extentTest.log(LogStatus.PASS, "clicked On Yes Button");
			waitForIvaChatToLoad();
			click("NO_BUTTON");
			extentTest.log(LogStatus.PASS, "clicked On No Button");
			waitForIvaChatToLoad();
			click("CHAT_TOGGLE_BUTTON");
			extentTest.log(LogStatus.PASS, "Chat Details Opened");
			waitForMiniumTimeToLoad();
			Reporter.log("Getting text after conversation is closed",true);
			Reporter.log("===================================================================",true);
			List<AndroidElement> text= getElements("IVA_TEXT");
			for(MobileElement element : text) {
				String getData= element.getText();
				Reporter.log(getData,true);
			}
			extentTest.log(LogStatus.PASS, "Got The Text");
			click("CLOSE_CHAT_NOTES_ICON");
			extentTest.log(LogStatus.PASS, "closed Chat Notes");
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
			List<AndroidElement> text1= getElements("IVA_TEXT");
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