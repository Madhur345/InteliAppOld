package com.apd.inteliserve.sanity;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.apd.inteliserve.general.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

/**
 * @author Ranjit 
 *
 */
public class Video extends BaseTest {
	@Test
	public void videoPageTesting() throws InterruptedException {
		extentTest = extent.startTest("Video");
		extentTest.log(LogStatus.INFO, "Test Started");
		extentTest.log(LogStatus.INFO, "Performing Operations");
		Reporter.log("Video Console Output",true);
		Reporter.log("______________________________________",true);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//Added by Vishal
		driver.findElement(By.xpath("//android.widget.TextView[@text='Video']")).click();
		Thread.sleep(15000);
		List<AndroidElement> options = driver.findElements(By.className("android.widget.RadioButton"));
		Reporter.log("Videopage option to be dispaly", true);
		int count = options.size();
		System.out.println(count);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='How does IVA work ?']")).click();
		Thread.sleep(3000);
		List<AndroidElement> choice = driver.findElements(By.className("android.widget.RadioButton"));
		for (MobileElement MobileElement : choice) {
			System.out.println(MobileElement.getText());
			//			if(MobileElement.equals("No")) {            
			//				MobileElement.click();
			//			}
			if(MobileElement.getText().equals("No")) {             //Added by Vishal
				MobileElement.click();
			}
		}
		Reporter.log("No button clicked", true);
		Thread.sleep(5000);  //Added by vishal
		driver.findElement(By.xpath("//android.view.View[contains(@text,'It’s a menu toggle button.')]")).click();
		extentTest.log(LogStatus.PASS, "Cliked On Toggle Button");
		driver.findElement(By.xpath("//android.widget.Button[@text='Mute']")).click();
		extentTest.log(LogStatus.PASS, "Conversation Muted");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Unmute']")).click();
		extentTest.log(LogStatus.PASS, "Conversation Unmuted");
		driver.findElement(By.xpath("//android.widget.Button[@text='Reset Conversation']")).click();
		Thread.sleep(10000);
		Reporter.log("Getting text after reseting conversation",true);
		Reporter.log("------------------------------------------------------------------------------------------------------------------------------------------------------",true);
	}
}
