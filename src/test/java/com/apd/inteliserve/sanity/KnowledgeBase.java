//package com.apd.inteliserve.sanity;
//
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.Test;
//import com.apd.inteliserve.general.Keyword;
//import com.apd.inteliserve.general.Lib;
//import com.relevantcodes.extentreports.LogStatus;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;
//
///**
// * @author Ranjit 
// *
// */
//public class KnowledgeBase extends Keyword {
//	@Test
//	public void knowledgePageTesting() throws Exception {
//		extentTest = extent.startTest("CallAnAgent");
//		extentTest.log(LogStatus.PASS, "Test Started");
//		waitForAllElementsVisibility();
//		try {
//			clickKnowledgeBaseMenu();
//			Reporter.log("knowledgePage is clicked", true);
//			MobileElement one = editPath();
//			one.sendKeys("create user");
//			Reporter.log("Typed on the text box", true);
//			clickGoButton();
//			Reporter.log("go button clicked", true);
//			MobileElement knowledgebaseOptions;
//			knowledgebaseOptions = passPath();
//			knowledgebaseOptions.click();
//			Reporter.log("clicked on tsc-password reset", true);
//			String actualValue = knowledgebaseOptions.getText();
//			String expectedValue = Lib.getCellValue("ExpectedText", 5, 1);
//			if (actualValue.contains(expectedValue))
//				Assert.assertEquals(actualValue, expectedValue, "values are not equal");
//			knowledgebaseOptions.click();
//			driver.pressKey(new KeyEvent(AndroidKey.BACK));
//			maximunTime();
//			classPath();
//			visibilty0fSpecificElement("KNOWLEDGE_PATH");
//			Reporter.log("known outeges page is clicked", true);
//			minumumTime();
//			MobileElement knowledgebaseOptions2;
//			knowledgebaseOptions2 = outageOption();
//			knowledgebaseOptions2.click();
//			String actualResult1 = knowledgebaseOptions2.getText();
//			String expectedResult1 = Lib.getCellValue("ExpectedText", 6, 1);
//			Assert.assertEquals(actualResult1, expectedResult1, "not same");
//			minumumTime();
//			knowledgebaseOptions2.click();
//			Reporter.log("outage option is varified", true);
//			classPath();
//			visibilty0fSpecificElement("KNOWLEDGE_PATH");
//			Reporter.log("knowledgePage is clicked", true);
//			Thread.sleep(3000);
//			createTicket();
//			Reporter.log("create ticket  is clicked", true);
//			MobileElement title;
//			title = editText();
//			title.sendKeys("Resolution problems");
//			Reporter.log("Resolution problem send in title box", true);
//			maximunTime();
//			MobileElement desc;
//			desc = editText1();
//			desc.sendKeys(
//					"when ever clicking this page , its created the new session but the resolution is not upto mark");
//			Reporter.log("ticket raised", true);
//			classPath();
//			minumumTime();
//			Assert.assertTrue(true, "ticket created");
//			Thread.sleep(5000);
//			clickKnowledgeBaseMenu();
//			Reporter.log("Knowledge pata clicked", true);
//			openTicket();
//			Reporter.log("open ticket  is clicked", true);
//			MobileElement choice;
//			choice = arkaOption();
//			choice.click();
//			Thread.sleep(1000);
//			choice.click();
//			Reporter.log("arka option  is clicked", true);
//			classPath();
//		} catch (Exception e) {
//			e.printStackTrace();
//			extentTest.log(LogStatus.FAIL, e.getMessage());
//			extentTest.log(LogStatus.FAIL, "Test Failed");
//			Assert.fail();
//		}
//	}
//}
