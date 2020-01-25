package com.apd.inteliserve.sanity;

import org.testng.annotations.Test;
import com.apd.inteliserve.general.XLSReader;

//This Test Script is for Generating TestNG.xml file from Excel Input

public class SuiteRun {

	@Test
	public void suiteRun(){
		XLSReader suite = new XLSReader("testsuite.xlsx");
		suite.getTests("select * from TestCase where Active='Y'");
	}
}
