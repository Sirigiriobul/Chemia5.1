package Testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import CHEMIASOFT.Chemia.Utilites.CaptureScreenShot;
import CHEMIASOFT.Chemia.Utilites.Utility;
import CHEMIASOFT.Chemia.Utilites.setBrowser;

public class iTestListner implements ITestListener {
	Utility Myutility;
	WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestResult context) throws Exception {
		System.out.println("Test Started");

//		this.Myutility = new Utility();

		System.out.println("Execution Started");
		// Formating the data
		String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		// creates one extent report on the given path
		this.spark = new ExtentSparkReporter(
				this.Myutility.PathOfReport() + "/" + date + " " + "TS_Chemia_CRD_03.html");
		// Setting title for the document
		spark.config().setDocumentTitle("Chemia | CRD Automation Report");// title of the report
		// Setting name of the report
		// spark.config().setReportName("CRD Master data | Dosage Form ");// name of the
		// report
		// Selecting the theme
		spark.config().setTheme(Theme.DARK);

		// Creates the report
		this.extent = new ExtentReports();
		// Attaches the report
		extent.attachReporter(this.spark);

		// Extra information to write on the report
		extent.setSystemInfo("Browser", this.Myutility.getDataFromProparties("browser"));
		extent.setSystemInfo("Host", this.Myutility.getDataFromProparties("host"));
		extent.setSystemInfo("os", this.Myutility.getDataFromProparties("os"));
		extent.setSystemInfo("Tester Name", this.Myutility.getDataFromProparties("tester"));
	  
	  }
	public void onTestStart(ITestResult context) {
		this.Myutility = new Utility();
		try {
			this.driver = setBrowser.browser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Execution Started");
		// Formating the data
		String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		// creates one extent report on the given path
		this.spark = new ExtentSparkReporter(
				this.Myutility.PathOfReport() + "/" + date + " " + "TS_Chemia_CRD_03.html");
		// Setting title for the document
		spark.config().setDocumentTitle("Chemia | CRD Automation Report");// title of the report
		// Setting name of the report
		// spark.config().setReportName("CRD Master data | Dosage Form ");// name of the
		// report
		// Selecting the theme
		spark.config().setTheme(Theme.DARK);

		// Creates the report
		this.extent = new ExtentReports();
		// Attaches the report
		extent.attachReporter(this.spark);
		try {
		// Extra information to write on the report
		extent.setSystemInfo("Browser", this.Myutility.getDataFromProparties("browser"));
		extent.setSystemInfo("Host", this.Myutility.getDataFromProparties("host"));
		extent.setSystemInfo("os", this.Myutility.getDataFromProparties("os"));
		extent.setSystemInfo("Tester Name", this.Myutility.getDataFromProparties("tester"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	public void onTestSuccess(ITestResult result) {
		System.out.println("test Passed");
		test=extent.createTest(result.getName());
		test.log(Status.PASS, result.getName() + "Test Case is Passed ");
		String screenshortpath;
		try {
			screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber,
//				String.valueOf(Status.PASS));
//		Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber + 1,
//				screenshortpath.substring(46));
	  }

	public void onTestFailure(ITestResult result) {
		System.out.println("test failed");
		test=extent.createTest(result.getName());

		test.log(Status.FAIL, result.getName() + "Test Case is Failed  ");
		test.log(Status.FAIL, "Test Case is Faild due to  " + result.getThrowable());
		String screenshortpath;
		try {
			screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber,
//				String.valueOf(Status.FAIL));
//		Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber + 1,
//				screenshortpath.substring(46));
//		Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber + 2,
//				"Test Case is failed due to  " + result.getThrowable());

	
	  }
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped");
	  }
	public void onFinish(ITestContext result) {
		System.out.println("test completed");
		test=extent.createTest(result.getName());

		extent.flush();
	  }
}
