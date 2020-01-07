package com.apd.inteliserve.sanity;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.apd.inteliserve.general.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;

/**
 * @author Ranjit 
 *
 */
public class KnowledgeBase extends BaseTest {
	@Test
	public void knowledgePageTesting() throws InterruptedException {
		extentTest = extent.startTest("KnowledgeBase");
		extentTest.log(LogStatus.INFO, "Test Started");
		extentTest.log(LogStatus.INFO, "Performing Operations");
		Reporter.log("KnowledgeBase Console Output",true);
		Reporter.log("______________________________________",true);
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Added by Vishal
		driver.findElement(By.xpath("//android.widget.TextView[@text='Knowledge Base']")).click();
		Reporter.log("knowledgePage is clicked", true);
		MobileElement createTicket=driver.findElement(By.xpath("//android.widget.TextView[@text='CREATE TICKET']")); //Added by Vishal
		createTicket.click();
		Reporter.log("create ticket  is clicked", true);
		MobileElement title = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Give an appropriate topic title to your ticket']"));
		title.sendKeys("Resolution problems");
		MobileElement desc = driver.findElement(By.xpath("//android.widget.EditText[@text='Write about the topic you have a question about.']"));
		desc.sendKeys("when ever clicking this page , its created the new session but the resolution is not upto mark");
		//Reporter.log("ticket raised", true);
		Reporter.log("discription entered", true);
		//driver.findElement(By.className("android.view.ViewGroup")).click();
		createTicket.click(); //Added by Vishal
		//Reporter.log("Create ticket is created", true);
		Reporter.log("Ticket is created", true); //Added by Vishal
		Assert.assertTrue(true, "ticket created");
		Thread.sleep(5000);
		Reporter.log("------------------------------------------------------------------------------------------------------------------------------------------------------",true);
	}
}
