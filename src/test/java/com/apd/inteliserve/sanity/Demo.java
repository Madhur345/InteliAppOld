//package com.apd.inteliserve.sanity;
//
//import java.util.List;
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.Test;
//import com.apd.inteliserve.general.Keyword;
//import com.apd.inteliserve.general.Keyword1;
//import com.relevantcodes.extentreports.LogStatus;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidElement;
//
///**
// * @author Ranjit 
// *
// */
//public class Demo extends Keyword {
//	@Test
//	public void demoPageTesting() throws Exception {
//		extentTest = extent.startTest("CallAnAgent");
//		extentTest.log(LogStatus.PASS, "Test Started");
//		waitForAllElementsVisibility();
//		try {
//			clickDemoMenu();
//			Reporter.log("Demo page is clicked", true);
//			clickButtonpath();
//			Reporter.log("Report what IVA wants", true);
//			MobileElement element = typeMessage();
//			element.sendKeys("Unisys");
//			Reporter.log("Company unisys is send", true);
//			sendMessage();
//			Reporter.log("Message sent", true);
//			List<AndroidElement> options = otherTopic();
//			for (MobileElement MobileElement : options) {
//				System.out.println(MobileElement.getAttribute("content-desc"));
//				if (MobileElement.getAttribute("content-desc").equalsIgnoreCase("No")) {
//					Reporter.log("No option is clicked", true);
//				}
//			}
//			humbergMenu();
//			visibilty0fSpecificElement("MUTE_PATH");
//			Reporter.log("Mute option is clicked", true);
//			MobileElement element1 = closeReset();
//			element1.click();
//			Reporter.log("conversatation is clicked", true);
//		} catch (Exception e) {
//			e.printStackTrace();
//			extentTest.log(LogStatus.FAIL, e.getMessage());
//			extentTest.log(LogStatus.FAIL, "Test Failed");
//			Assert.fail();
//		}
//	}
//}
