package com.apd.inteliserve.sanity;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.apd.inteliserve.general.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;

/**
 * @author Ranjit 
 *
 */
public class Demo extends BaseTest {
	@Test
	public void demoPageTesting() throws InterruptedException {
		extentTest = extent.startTest("Demo");
		extentTest.log(LogStatus.INFO, "Test Started");
		extentTest.log(LogStatus.INFO, "Performing Operations");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Demo']")).click();
		Reporter.log("Demo Console Output",true);
		Reporter.log("______________________________________",true);
		Reporter.log("Demo page is clicked", true);
		driver.findElement(By.className("android.widget.RadioButton")).click();
		Reporter.log("Report what IVA wants", true);
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//android.widget.EditText[@text='Type your message here']")).sendKeys("Unisys");
		MobileElement textBox=driver.findElement(By.className("android.widget.EditText")); //Added by Vishal
		textBox.sendKeys("Unisys");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Send message']")).click();
		Reporter.log("Message sent", true);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='No']")).click();//Added by Vishal
		//driver.findElements(By.className("android.widget.RadioButton")).get(1).click();
		Reporter.log("No option is clicked", true);
		Reporter.log("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------",true);
	}
}


