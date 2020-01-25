//package com.apd.inteliserve.sanity;
//
//import java.util.List;
//import org.openqa.selenium.support.ui.WebDriverWait;
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
//public class Video extends Keyword {
//	WebDriverWait wait;
//
//	@Test
//	public void videoPageTesting() throws Exception {
//		extentTest = extent.startTest("CallAnAgent");
//		extentTest.log(LogStatus.PASS, "Test Started");
//		waitForAllElementsVisibility();
//		try {
//			clickVideoMenu();
//			Reporter.log("Video page clicked", true);
//			List<AndroidElement> options = clickButtonpath();
//			for (MobileElement mobileElement : options) {
//				System.out.println(mobileElement.getAttribute("content-desc"));
//			}
//			ivaWork();
//			Reporter.log("How IVA work is clicked", true);
//			visibilty0fSpecificElement("OPTION_LIST");
//			Reporter.log("No option is clicked", true);
//			resetHumberg();
//			String raw = driver.findElement(Lib.getLocator("MUTE_PATH")).getAttribute("content-desc");
//			Reporter.log("Mute option is clicked", true);
//			String raw2 =Lib.getCellValue("ExpectedTest", 8, 1);
//			if (raw.contains(raw2))
//				Assert.assertEquals(raw, raw2, "values are not equal");
//			MobileElement element1 = closeReset();
//			element1.click();
//			Reporter.log("conversatation is clicked", true);
//			String expectedValue =Lib.getCellValue("ExpectedText", 9, 1);
//			String actualValue = element1.getAttribute("content-desc");
//			if (actualValue.contains(expectedValue))
//				Assert.assertEquals(actualValue, expectedValue, "values are not equal");
//		} catch (Exception e) {
//			e.printStackTrace();
//			extentTest.log(LogStatus.FAIL, e.getMessage());
//			extentTest.log(LogStatus.FAIL, "Test Failed");
//			Assert.fail();
//		}
//	}
//}
