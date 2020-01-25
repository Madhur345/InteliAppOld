package com.apd.inteliserve.sanity;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.apd.inteliserve.general.Keyword;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

/**
 * @author VishalMadhur
 *
 */

//This Test Script is for Testing "Outages" Page

public class Outages extends Keyword {

	@Test
	public void outagesTest() throws Exception {
		extentTest = extent.startTest("Outages");
		extentTest.log(LogStatus.PASS, "Test Started");
		waitForAllElementsVisibility();
		try{
			click("OUTAGES_LINK");
			extentTest.log(LogStatus.PASS, "Cliked on Outages Menu");
			click("EXCHNAGE_OUTAGE");
			extentTest.log(LogStatus.PASS, "Clicking On First Item");
			extentTest.log(LogStatus.INFO, "Checking If Scrolling Is Working");
			String lastItem="HelpSTAR Test Drive Outage";
			MobileElement listItem=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
					+ "new UiSelector().text(\""+lastItem+"\"))"));
			extentTest.log(LogStatus.PASS, "Scrolling Happend Successfully");
			extentTest.log(LogStatus.INFO, "Clicking On Last Item After Scrolling");
			listItem.click();
			extentTest.log(LogStatus.PASS, "Clicked On Last Item After Scrolling");
			waitForMiniumTimeToLoad();
			listItem.click();
			extentTest.log(LogStatus.PASS, "Description Of Opened Item Closed");
			extentTest.log(LogStatus.PASS, "Test Successfull");
		}catch(Exception e){
			e.printStackTrace();
			extentTest.log(LogStatus.FAIL, e.getMessage());
			extentTest.log(LogStatus.FAIL, "Test Failed");
			Assert.fail("Outages Test Failed");
		}
	}
}

