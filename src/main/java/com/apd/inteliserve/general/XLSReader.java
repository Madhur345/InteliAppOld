package com.apd.inteliserve.general;


import java.io.File;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XLSReader implements IAutoConstant {

    private final Fillo fillo;
   // private final String filePath;

    private Connection connection;

    public XLSReader(String filePath) {
        fillo = new Fillo();
      //  this.filePath = filePath;
    }

    public void getTests(String query) {
        try {
            connection = fillo.getConnection(TESTSUITE_EXCEL_PATH);
            Recordset recordset = connection.executeQuery(query);
            this.createSuite(recordset);
        } catch (FilloException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private void createSuite(Recordset recordset) {
        XmlMapper xmlMapper = new XmlMapper();
        Suite suite = new Suite("UnisysAutomationSuite");
//        Suite suite1 = new Suite("UnisysAutomationSuite");
        try {
            while (recordset.next()) {

                String testName = recordset.getField("TestCaseDescription");
                String className = recordset.getField("ClassName");
//                String param = "Data";
//                String paramValue = recordset.getField("Data");

                suite.addTest(testName, className);
            }
            xmlMapper.writeValue(new File(TESTNG_FILE_PATH), suite);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            recordset.close();
        }
    }

}
