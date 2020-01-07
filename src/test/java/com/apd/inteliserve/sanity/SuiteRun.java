package com.apd.inteliserve.sanity;

import org.testng.annotations.Test;

import com.apd.inteliserve.general.XLSReader;

public class SuiteRun {

	@Test
	public void suiteRun(){
		XLSReader suite = new XLSReader("testsuite.xlsx");
		suite.getTests("select * from TestCase where Active='Y'");
	}
}
