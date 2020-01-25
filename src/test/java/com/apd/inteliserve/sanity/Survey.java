//package com.apd.inteliserve.sanity;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.Test;
//import com.apd.inteliserve.general.Keyword;
//import com.apd.inteliserve.general.Lib;
//import com.relevantcodes.extentreports.LogStatus;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidElement;
//
///**
// * @author Ranjit 
// *
// */
//public class Survey extends Keyword {
//	@Test
//	public void SurveyPageTesting() throws Exception {
//		extentTest = extent.startTest("CallAnAgent");
//		extentTest.log(LogStatus.PASS, "Test Started");
//		waitForAllElementsVisibility();
//		try {
//			clickSurveyMenu();
//			Reporter.log("survey is clicked", true);
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			List<AndroidElement> options = optionList();
//			for (MobileElement mobileElement : options) {
//				System.out.println(mobileElement.getAttribute("content-desc"));
//			}
//			listOfButton();
//			Reporter.log("tell us about yourself  is clicked", true);
//			visibilty0fSpecificElement("SELECT_REGION");
//			Reporter.log("select region is is clicked", true);
//			Thread.sleep(5000);
//			MobileElement chatNote = closeChatNote();
//			chatNote.click();
//			chatNote.click();
//			visibilty0fSpecificElementAndsendKey("TYPE_TEXTMESSAGE", "india");
//			sendMessage2();
//			Reporter.log("country india is selected", true);
//			closeChatNote().click();
//			closeChatNote().click();
//			visibilty0fSpecificElementAndsendKey("TYPE_TEXTMESSAGE", "banglore");
//			visibilty0fSpecificElement("SEND_MESSAGE");
//			Reporter.log("City entered", true);
//			visibilty0fSpecificElement("OTHER_TEXT");
//			List<AndroidElement> options1 = optionsList();
//			for (MobileElement mobileElement : options1) {
//				System.out.println(mobileElement.getAttribute("content-desc"));
//			}
//			robotPath();
//			visibilty0fSpecificElement("VALUE_ROBOT");
//			Reporter.log("Internet of Things and smart home tech is entered", true);
//			visibilty0fSpecificElement("QUOTE_VALUE");
//			Reporter.log("'Life Begins at The End Of Your Comfort Zone", true);
//			MobileElement one = testingStyle();
//			one.click();
//			dimpleValue();
//			otherTopic();
//			resetHumberg();
//			MobileElement element1 = closeReset();
//			element1.click();
//			Reporter.log("conversatation is clicked", true);
//			String expectedValue =Lib.getCellValue("ExpectedText", 7, 1);
//			String actualValue = element1.getAttribute("content-desc");
//			if (actualValue.contains(expectedValue))
//				Assert.assertEquals(actualValue, expectedValue, "values are not equal");
//		} catch (Exception e) {
//			e.printStackTrace();
//			extentTest.log(LogStatus.FAIL, e.getMessage());
//			extentTest.log(LogStatus.FAIL, "Test Failed");
//			Assert.fail();
//
//		}
//	}
//}