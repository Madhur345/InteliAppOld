package com.apd.inteliserve.sanity;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.apd.inteliserve.general.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidElement;

/**
 * @author Ranjit 
 *
 */
public class Survey extends BaseTest {

	@Test
	public void SurveyPageTesting() throws InterruptedException {
		extentTest = extent.startTest("Survey");
		extentTest.log(LogStatus.INFO, "Test Started");
		extentTest.log(LogStatus.INFO, "Performing Operations");
		Reporter.log("Survey Console Output",true);
		Reporter.log("______________________________________",true);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Survey']")).click();
		Reporter.log("survey is clicked", true);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Tell us about yourself']")).click();
		Reporter.log("tell us about yourself  is clicked", true);
		Thread.sleep(15000);
		List<AndroidElement> options = driver.findElements(By.className("android.widget.RadioButton"));
		for (int i = 0; i <options.size() ; i++) {
			options.get(i).click();
		}
		// Added by Vishal
		Thread.sleep(5000);
		Reporter.log("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------",true);
		
	}
}
