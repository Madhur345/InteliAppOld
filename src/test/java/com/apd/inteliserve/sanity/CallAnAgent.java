package com.apd.inteliserve.sanity;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.apd.inteliserve.general.Keyword;
import com.apd.inteliserve.general.Lib;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/**
 * @author MadhurVK
 *
 */
public class CallAnAgent extends Keyword {

	@Test
	public void callAgent() throws Exception {
		extentTest = extent.startTest("CallAnAgent");
		extentTest.log(LogStatus.PASS, "Test Started");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SoftAssert s = new SoftAssert();
		try{
			clickCallAnAgentMenu();
			extentTest.log(LogStatus.PASS, "Cliked on Call An Agent Menu");
			String actualText=getCallAnAgentHeaderText();
			Reporter.log("The actual text displayed is "+actualText,true);
			String expectedText =Lib.getCellValue("Expectedtext",4, 1);
			s.assertEquals(actualText, expectedText);
			extentTest.log(LogStatus.PASS, "Call an Agent Text Verified");
			MobileElement agentNumber=getAgentNumber();
			if(agentNumber.isDisplayed()){
				extentTest.log(LogStatus.PASS, "Agent Number Displayed");
				Reporter.log("Agent number displayed is " +agentNumber.getText(),true);
				extentTest.log(LogStatus.PASS, "Got The Agent Number");
				driver.findElement(Lib.getLocator("CALL_BUTTON")).click();
				extentTest.log(LogStatus.PASS, "Call Placed Successfully");
			}
			waitForMiniumTimeToLoad();
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			extentTest.log(LogStatus.PASS, "Click On Back Button For First Time");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			extentTest.log(LogStatus.PASS, "Click On Back Button Again");
			extentTest.log(LogStatus.PASS, "Test Successfull");
			s.assertAll();
		}catch(Exception e){
			e.printStackTrace();
			extentTest.log(LogStatus.FAIL, e.getMessage());
			extentTest.log(LogStatus.FAIL, "Test Failed");
			Assert.fail("CallAnAgent Test Failed");
		}
	}
}