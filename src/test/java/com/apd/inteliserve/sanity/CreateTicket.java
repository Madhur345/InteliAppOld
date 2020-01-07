package com.apd.inteliserve.sanity;

import com.apd.inteliserve.general.Keyword;
import com.apd.inteliserve.general.Lib;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

/**
 * @author MadhurVK
 *
 */

public class CreateTicket extends Keyword {

	@Test
	public  void createTicket() throws Exception {
		extentTest = extent.startTest("CreateTicket");
		extentTest.log(LogStatus.PASS, "Test Started");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SoftAssert s = new SoftAssert();
		try{
			clickCreateTicketMenu();
			extentTest.log(LogStatus.PASS, "Cliked on Create Ticket Menu");
			String actualTitle=getcreteTicketTitleText();
			String expectedTitle=Lib.getCellValue("ExpectedText",1,1);
			if(actualTitle.equals(expectedTitle)){
				extentTest.log(LogStatus.PASS, "Title Matched");
			}
			else{
				extentTest.log(LogStatus.FAIL, "Title Not Matched");
			}
			s.assertEquals(actualTitle, expectedTitle);
			String username = "Appium Tool " + new Random().nextInt(1000);
			MobileElement titleTextBox=getTitleTextBox();
			String actualTitleTextBox=titleTextBox.getText();
			String expectedTitleTextBox=Lib.getCellValue("ExpectedText",2,1);
			if(actualTitleTextBox.equals(expectedTitleTextBox)){
				extentTest.log(LogStatus.PASS, "Title Text Verified");
			}
			else{
				extentTest.log(LogStatus.FAIL, "Title Text Not Verified");
			}
			s.assertEquals(actualTitleTextBox,expectedTitleTextBox);
			titleTextBox.sendKeys(username);
			extentTest.log(LogStatus.PASS, "Title Entered");
			MobileElement description=getDiscriptionTextBox();
			String actualDescription =description.getText();
			String expectedDescription=Lib.getCellValue("Expectedtext",3, 1);
			if(actualDescription.equals(expectedDescription)){
				extentTest.log(LogStatus.PASS, "Description Text Verified");
			}
			else{
				extentTest.log(LogStatus.FAIL, "Description Text Not Verified");
			}
			s.assertEquals(actualDescription, expectedDescription);
			description.sendKeys("	This tool is  used for automating manual test cases");
			extentTest.log(LogStatus.PASS, "Description Entered");
			clickCreateTicketButton();
			extentTest.log(LogStatus.PASS, "Clicked On Create Ticket Button");
			waitForMiniumTimeToLoad();
			MobileElement listItem=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
					+ "new UiSelector().text(\""+username+"\"))"));
			extentTest.log(LogStatus.PASS, "Verified That Ticket Is Craeted Successfully");
			listItem.click();
			extentTest.log(LogStatus.PASS, "Clicked On Created Ticket To Check Ticket Discription Is Opening");
			waitForMiniumTimeToLoad();
			listItem.click();
			extentTest.log(LogStatus.PASS, "Closed Ticket Discription Section");
			extentTest.log(LogStatus.PASS, "Test Successfull");
			s.assertAll();
		}catch(Exception e){
			e.printStackTrace();
			extentTest.log(LogStatus.FAIL, e.getMessage());
			extentTest.log(LogStatus.FAIL, "Test Failed");
			Assert.fail("Create Ticket Test Failed");
		}
	}
}

