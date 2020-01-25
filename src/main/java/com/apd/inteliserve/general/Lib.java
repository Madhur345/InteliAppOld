package com.apd.inteliserve.general;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author  VishalMadhur
 *
 */
public class Lib implements IAutoConstant {
	public static Workbook wb;
	static String propertyValue ="";
	static Properties prop=new Properties();

	public static ExtentReports generateExtentReport() {
		ExtentReports extent =null;
		try {
			Date d = new Date();
			String currentDate = d.toString().replaceAll(":","_");
			extent=new ExtentReports(System.getProperty("user.dir")+"/ExtentReports/"+"InteliServe Test Automation Report" +"_"+ currentDate + ".html", true);
			extent.loadConfig(new File(System.getProperty("user.dir")+""+REPORTS_CONFIG_PATH+"")); 
			extent.addSystemInfo("Appium Version", "1.15.1").addSystemInfo("Platform", "Android").addSystemInfo("Android Version", "9-Pie").addSystemInfo("User Name", "Vishal Madhur");
		}catch(Exception e) {
		}
		return extent;
	}
	public static String getCellValue(String sheet,int row,int colomn){
		String cellValue ="";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			cellValue =wb.getSheet(sheet).getRow(row).getCell(colomn).toString();
		} catch (Exception e) {
		}
		return cellValue;
	}
	public static int getRowCount(String sheet){
		int rowCount =0;
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount =wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
		}
		return rowCount;
	}


	public static String captureScreenshots(WebDriver driver,String testCaseName){
		Date d = new Date();
		String currentDate = d.toString().replaceAll(":","_");
		String screenShotPath = System.getProperty("user.dir") + "/screenshots/" +testCaseName+"_"+currentDate+".png";
		try{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenShotPath);
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception e){
		}
		return screenShotPath;
	}

	public static String getPropertyValue(String key){
		try{
			prop.load(new FileInputStream(CONFIG_PATH));
			propertyValue=prop.getProperty(key);
		}catch(Exception e){
		}
		return propertyValue;
	}
	
	public static  By getLocator(String logicalElementName) throws Exception
	{
		prop.load(new FileInputStream(OBJECTREPOSITORY_PATH));
		String locator = prop.getProperty(logicalElementName);
		System.out.println("Logical name" +prop.getProperty(logicalElementName));
		String locatorType = locator.split(">")[0];
		System.out.println("String locatorType [0]--------->" +locatorType);
		String locatorValue = locator.split(">")[1];
		System.out.println("String locatorType [1]----->" +locatorValue);
		System.out.println(MobileBy.xpath((locatorValue)));
		if(locatorType.toLowerCase().equals("id"))
			return MobileBy.id(locatorValue);
		else if(locatorType.toLowerCase().equals("name"))
			return MobileBy.name(locatorValue);
		else if((locatorType.toLowerCase().equals("classname")) ||
				(locatorType.toLowerCase().equals("class")))
			return MobileBy.className(locatorValue);
		else if((locatorType.toLowerCase().equals("tagname")) ||
				(locatorType.toLowerCase().equals("tag")))
			return MobileBy.className(locatorValue);
		else if((locatorType.toLowerCase().equals("linktext")) ||
				(locatorType.toLowerCase().equals("link")))
			return MobileBy.linkText(locatorValue);
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return MobileBy.partialLinkText(locatorValue);
		else if((locatorType.toLowerCase().equals("cssselector")) ||
				(locatorType.toLowerCase().equals("css")))
			return MobileBy.cssSelector(locatorValue);
		else if(locatorType.toLowerCase().equals("xpath"))
			return MobileBy.xpath((locatorValue));
		else
			throw new Exception("Locator type '" + locatorType + "'is not defined!!");
	}
}
