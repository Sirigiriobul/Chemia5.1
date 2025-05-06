package Testcases_ARD;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import CHEMIASOFT.ARD.PageObjects.ARD_LeftMenuItemsPage;
import CHEMIASOFT.ARD.PageObjects.MyATRS_ARDPage;
import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.Embedded_Excel_Temp_Page;
import CHEMIASOFT.Chemia.Utilites.CaptureScreenShot;
import CHEMIASOFT.Chemia.Utilites.Utility;
import CHEMIASOFT.Chemia.Utilites.setBrowser;
import CHEMIASOFT.Chemia.login.PageObjects.CommonLoginPage;
import CHEMIASOFT.Chemia.login.PageObjects.CompanyName;
import CHEMIASOFT.Chemia.login.PageObjects.MainPage;
import Chemia.Project.Creation.PageObject.Team_Creation_Page;

public class MyATRs_CompleteFlow {

	Utility Myutility;
	WebDriver driver;
	// Actions actions = new Actions
	// (driver);D:\eclipse\automation\Chemia\Documents\Chemia PDF.pdf

	CompanyName cname; // Company Name Page
	CommonLoginPage loginpage; // Login Page
	MainPage mainpage; // Main Page
	ARD_LeftMenuItemsPage LeftMenuIcon;
	Embedded_Excel_Temp_Page ExcelTemplate;
	Team_Creation_Page teamcreation;
	MyATRS_ARDPage aTRsPage;
	
	String ATRFormNo ;
	//Output Excel Sheet Details
		int RowNumber = 1;
		int outputSheetNumber = 5 ;//Test cases Output Sheet name:ARD complete flow
		int ColumnNumber = 11;

	@BeforeSuite
	// In before suite we will call the browser & pass the URL to open the
	// application
	// also maximize the browser
	public void beforesuite() throws Exception {

		System.out.println("Suit executed & starting the browser");
		this.Myutility = new Utility();
		this.driver = setBrowser.browser();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		driver.get(this.Myutility.getDataFromProparties("URL"));

	}

	@AfterSuite
	// In after suite we quite the driver. That means we close the browser

	public void afterSuite() {
		System.out.println("Suit completed");
		logout();
		this.driver.quit();
	}

	// Extent Reports
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	// In before Test we create the extent report & attach the screen short to the
	// report
	// At the same time we also give more info about like which browser is used, who
	// tested etc by using

	public void beforetest() throws Exception {

		// Formating the data
		String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		// creates one extent report on the given path
		this.spark = new ExtentSparkReporter(
				this.Myutility.PathOfReport() + "/" + date + " " + "TS_Chemia_ARD_01.html");
		// Setting title for the document
		spark.config().setDocumentTitle("Chemia | ARD Automation Report");// title of the report
		// Setting name of the report
		spark.config().setReportName("ARD Teame ctreation And adding Users to it ");// name of the
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
		
		this.cname = new CompanyName(driver); // Company Name Page
		this.loginpage = new CommonLoginPage(driver); // Common Login Page
		this.mainpage = new MainPage(driver); // Main Page
	}

	@AfterTest
	// In after Test we flush out the report for saving all the data
	public void afterTest() {

		extent.flush();
	}

	@BeforeMethod
	// in Before method we will initiate all the class which are needed for the test
	// case
	public void beforeMethod() throws Exception {
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Pages
		this.cname = new CompanyName(driver); // Company Name Page
		this.loginpage = new CommonLoginPage(driver); // Common Login Page
		this.mainpage = new MainPage(driver); // Main Page
		this.LeftMenuIcon = new ARD_LeftMenuItemsPage(driver); // Left menu
		this.ExcelTemplate = new Embedded_Excel_Temp_Page(driver);
		this.teamcreation = new Team_Creation_Page(driver);
		this.aTRsPage = new MyATRS_ARDPage(driver);

		
	}

	@AfterMethod
	// In after method we will get the result for each test case. According to the
	// result we will mark the test case as pass, Fail (or) Skip
	// At the same we will save the result on both Excel & extent report along with
	// the screen short number
	public void AfterMethod(ITestResult result) throws Exception {
        int rowNumber = this.Myutility.getRowNumberByCellValue(this.Myutility.TestCaseXLPath(), outputSheetNumber, result.getName(), 0);

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + "Test Case is Passed ");
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);
			System.out.println("Method rowNumber"+rowNumber);
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, rowNumber, ColumnNumber,
					String.valueOf(Status.PASS));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, rowNumber, ColumnNumber + 1,
					screenshortpath.substring(46));
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName() + "Test Case is Failed  ");
			test.log(Status.FAIL, "Test Case is Faild due to  " + result.getThrowable());
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);

			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, rowNumber, ColumnNumber,
					String.valueOf(Status.FAIL));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, rowNumber, ColumnNumber + 1,
					screenshortpath.substring(46));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, rowNumber, ColumnNumber + 2,
					"Test Case is failed due to  " + result.getThrowable());
		}
		
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skiped is " + result.getName());
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);

			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, rowNumber, ColumnNumber,
					String.valueOf(Status.SKIP));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, rowNumber, ColumnNumber + 1,
					screenshortpath.substring(46));

		}
//		this.RowNumber += 1;

	}

	public void CompaneyName() throws Exception {

		this.cname.Companey_name(this.Myutility.getDataFromProparties("Companeyname"));
		this.cname.nextButton();

	}

	public void login(String userName, String password) throws Exception {

		this.loginpage.username(userName);
		this.loginpage.userpassword(password);
		this.loginpage.loginbutton();
		try {
			this.loginpage.multipleloginpopup();
			this.loginpage.MutipleLoginpopupYesButton();
			this.loginpage.username(userName);
			this.loginpage.userpassword(password);
			this.loginpage.loginbutton();
		} catch (Exception e) {
			System.out.println("Multiple Login Popup Is not displayed..");
		}
		this.mainpage.ClickOnARDModule();
	}

	public void logout() {

		this.mainpage.logout();

	}

	@Test(priority = 1)
	public void TC_01_ValidateATRsubmission() throws Exception {
		System.out.println("**********************Method Starting: TC_01_ValidateATRsubmission******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Submit new ATR | TC_01(Submit new ATR )");
		this.CompaneyName();
		int sheetNum=Myutility.getARDSheetNumber("ATR Data");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("ATR Data"+RowData);
			
		test.createNode("Creating new ATR with existing form");
		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(7000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnATRForms();Thread.sleep(1000);
		LeftMenuIcon.clcikOnMyATRs();Thread.sleep(3000);
		aTRsPage.clcikOnNewATR();Thread.sleep(3000);

		aTRsPage.clickAndSlectFormType((String) RowData.get("Form Type"));Thread.sleep(2000);
		aTRsPage.clcikOnSubmitFormType();Thread.sleep(3000);
		aTRsPage.enterProjectCode("NotApplicable");Thread.sleep(1000);
		aTRsPage.clickAndSlectReportType((String) RowData.get("Report Type"));Thread.sleep(1000);
		aTRsPage.enterFormRemarks((String) RowData.get("Description"));Thread.sleep(1000);
		aTRsPage.enterFormObjectives("Objects Added");Thread.sleep(1000);
		aTRsPage.enterFormAttrText((String) RowData.get("UOM"));Thread.sleep(1000);
		aTRsPage.enterFormAttrNumber((String) RowData.get("Value"));Thread.sleep(1000);
		aTRsPage.enterTodaysDate();Thread.sleep(1000);

		aTRsPage.clcikOnSampleCodeAddIcon();Thread.sleep(1000);
		aTRsPage.enterSampleCode("Samplecode_"+this.Myutility.getDataFromProparties("Key"));Thread.sleep(1000);
		aTRsPage.enterBatchNo("Batch_"+this.Myutility.getDataFromProparties("Key"));Thread.sleep(1000);
		aTRsPage.clickAndSlectSampleType((String) RowData.get("SampleType"));Thread.sleep(1000);
		aTRsPage.enterSampleQty((String) RowData.get("Value"));Thread.sleep(1000);
		aTRsPage.enterDescr((String) RowData.get("Description"));Thread.sleep(1000);
		aTRsPage.clickAndSlectQtyUOM((String) RowData.get("UOM"));Thread.sleep(1000);
		aTRsPage.clcikOnSaveSample();Thread.sleep(5000);

		aTRsPage.clickonFirstTestCheckbox();Thread.sleep(1000);
		aTRsPage.clcikOnRemoveTestIcon();Thread.sleep(4000);
		aTRsPage.clickonFirstTestCheckbox();Thread.sleep(1000);
		aTRsPage.clickAndSlectPriority((String) RowData.get("Priority"));Thread.sleep(1000);
		aTRsPage.enterSampleQty((String) RowData.get("Value"));Thread.sleep(1000);//value should be less than or equal to sample Qty
		aTRsPage.enterTestRemarks((String) RowData.get("Description"));Thread.sleep(1000);
//		aTRsPage.clickAndSlectTeamInTest((String) RowData.get("TeamName"));Thread.sleep(2000);
		aTRsPage.clcikOnSaveTestIcon();Thread.sleep(4000);

		aTRsPage.clcikOnAddSupportDocsIcon();Thread.sleep(2000);
		aTRsPage.enterAttachmentName("Attch_"+this.Myutility.getDataFromProparties("Key"));Thread.sleep(1000);
		aTRsPage.clickAndSlectAttchmentType();Thread.sleep(2000);
		aTRsPage.clcikOnUploadDocsAndReports(this.Myutility.JPGPath());Thread.sleep(2000);
		aTRsPage.clcikOnDocsAndReportsSave();Thread.sleep(2000);
//		aTRsPage.clcikOnATRFormSave();Thread.sleep(2000);

		aTRsPage.clcikOnATRFormSubmit();Thread.sleep(2000);
		aTRsPage.clickAndSlectTeam((String) RowData.get("TeamName"));Thread.sleep(2000);
		aTRsPage.enterPassword((String) RowData.get("Password"));Thread.sleep(1000);
		aTRsPage.clcikOnATRFormSubmitAfterEsighn();Thread.sleep(4000);
	//	aTRsPage.clcikOnATRFormCancelAfterEsighn();Thread.sleep(1000);
		ATRFormNo = aTRsPage.getATRFormNumber();
		System.out.println("ATR form no:"+ATRFormNo);

//        mainpage.closePopup();	
	}//TC_01_ValidateATRsubmission
	
	@Test(priority = 2)
	public void TC_02_ValidateTestAssghining() throws Exception {
		System.out.println("**********************Method Starting: TC_02_ValidateTestAssghining******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Test Assghining to slef | TC_02(self test assighning )");
//		this.CompaneyName();
		int sheetNum=Myutility.getARDSheetNumber("ATR Data");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("ATR Data"+RowData);
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("ATR Selfacceptance");
		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(7000);
		this.aTRsPage.Clickingonhomebutton();Thread.sleep(2000);
		aTRsPage.ClickOnTeamQue();Thread.sleep(1000);
		aTRsPage.clickonSamplecodeCheckbox(ATRFormNo);Thread.sleep(1000);
		aTRsPage.clcikOnAcceptTest();Thread.sleep(1000);
		aTRsPage.enterPasswordForAccept((String) RowData.get("Password"));Thread.sleep(2000);
		aTRsPage.clcikOntestAcceptSubmit();Thread.sleep(1000);
		test.createNode("ATR processing .");

		this.aTRsPage.Clickingonhomebutton();Thread.sleep(2000);
		aTRsPage.ClickOnAssigned();Thread.sleep(1000);
		aTRsPage.clickonSamplecodeCheckbox(ATRFormNo);Thread.sleep(1000);
		aTRsPage.clcikOnProcessTest();Thread.sleep(3000);
		aTRsPage.clcikOnGenerateTestNo();Thread.sleep(3000);
       
	}
	
	@Test(priority = 3)
	public void TC_03_ValidateTestSubmission() throws Exception {
		System.out.println("**********************Method Starting: TC_03_ValidateTestSubmission******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Test Process | TC_03(self Test process and Submission)");
//		this.CompaneyName();
		int sheetNum=Myutility.getARDSheetNumber("ATR Data");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("ATR Data"+RowData);
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
		test.createNode("ATR test Process");
//		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(5000);
		this.aTRsPage.Clickingonhomebutton();Thread.sleep(2000);
		aTRsPage.ClickOnInProgress();Thread.sleep(1000);
		aTRsPage.clickonSamplecodeCheckbox(ATRFormNo);Thread.sleep(1000);
		aTRsPage.clcikOnProcessTest();Thread.sleep(1000);
		String testNo = aTRsPage.getTestNumber();
		System.out.println("Test no:"+testNo);
		aTRsPage.enterNotebookRefNo("NotApplicable");Thread.sleep(1000);
		aTRsPage.clcikOnSaveNBrefNo();Thread.sleep(1000);

		aTRsPage.enterTestResults((String) RowData.get("Value"));Thread.sleep(1000);
		aTRsPage.enterResultsRemarks((String) RowData.get("Description"));Thread.sleep(1000);
		aTRsPage.enterAdRemarks((String) RowData.get("Description"));Thread.sleep(1000);
		aTRsPage.clcikOnAttachmentAddIcon();Thread.sleep(1000);
		aTRsPage.uploadRawDataAttachment(this.Myutility.JPGPath());Thread.sleep(3000);
		aTRsPage.enterRawDataAttachmentName("Raw Attachment");Thread.sleep(1000);
		aTRsPage.clcikOnRawDataAttachmentSave();Thread.sleep(1000);
		aTRsPage.ClickOnReport();Thread.sleep(1000);
		aTRsPage.ClickOnReportUpload();Thread.sleep(1000);

		aTRsPage.ClickOnReportUploadFinalReport();Thread.sleep(1000);
		this.Myutility.Uploadfile(this.Myutility.PDFPath());Thread.sleep(2000);
		aTRsPage.ClickOnSaveRepot();Thread.sleep(1000);
		aTRsPage.ClickOnAction();Thread.sleep(1000);

		aTRsPage.ClickOnTestSubmit();Thread.sleep(1000);

		aTRsPage.clickAndSlectReviewer((String) RowData.get("Teamlead"));Thread.sleep(1000);
		aTRsPage.enterATRResultSubmitRemarks((String) RowData.get("Description"));Thread.sleep(1000);
		aTRsPage.enterATRResultSubmitPassword((String) RowData.get("Password"));Thread.sleep(1000);
		aTRsPage.ClickOnTestSubmitFinal();Thread.sleep(3000);
	}
	@Test(priority = 4)
	public void TC_04_ValidateTestVerifying() throws Exception {
		System.out.println("**********************Method Starting: TC_04_ValidateTestVerifying******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Test Verify | TC_04(self Test Verify)");
//		this.CompaneyName();
		int sheetNum=Myutility.getARDSheetNumber("ATR Data");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("ATR Data"+RowData);
			VerifyTestByTL(RowData);Thread.sleep(1000);
	}
	private void VerifyTestByTL(Map<String, Object> lineData) throws Exception {
        System.out.println("**********************Sub Method Starting: VerifyTestByTL******************************");
    	this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Test Verify");
		this.login((String) lineData.get("Teamlead"),(String) lineData.get("Password"));Thread.sleep(7000);
		this.aTRsPage.Clickingonhomebutton();Thread.sleep(2000);
		aTRsPage.ClickOnInVerReq();Thread.sleep(2000);
		aTRsPage.clickonSamplecodeCheckbox(ATRFormNo);Thread.sleep(1000);
		aTRsPage.clcikOnProcessTest();Thread.sleep(2000);
		aTRsPage.ClickOnTestReport();Thread.sleep(1000);
		aTRsPage.ClickOnTestReportView();Thread.sleep(5000);
		String screenshortpath = CaptureScreenShot.GetScreenShort(driver, "Result report");
   		test.addScreenCaptureFromPath(screenshortpath);
        mainpage.closePopup();	

		aTRsPage.ClickOnTestVerify();Thread.sleep(1000);
		aTRsPage.enterATRResultSubmitRemarks((String) lineData.get("Description"));Thread.sleep(1000);
		aTRsPage.enterATRResultSubmitPassword((String) lineData.get("Password"));Thread.sleep(1000);
		aTRsPage.ClickOnTestVerifySubmit();Thread.sleep(1000);	
    }
	@Test(priority = 5)
	public void TC_05_ValidateTestRequestEnhancement() throws Exception {
		System.out.println("**********************Method Starting: TC_05_ValidateTestRequestEnhancement******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Test Request Enhancement | TC_05(self Test Request Enhancement)");
//		this.CompaneyName();
		int sheetNum=Myutility.getARDSheetNumber("ATR Data");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("ATR Data"+RowData);
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Test Request Enhancement");
		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(5000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnATRForms();Thread.sleep(1000);
		LeftMenuIcon.clcikOnMyATRs();Thread.sleep(3000);
		
		aTRsPage.ClickOnVerifiedTest(ATRFormNo);Thread.sleep(3000);
		aTRsPage.ClickOnTestDetailsDropdown();Thread.sleep(3000);
		aTRsPage.ClickOnTestReqEnhancement();Thread.sleep(3000);
		aTRsPage.enterenhancementRemarks();Thread.sleep(3000);
		aTRsPage.ClickOnReqEnhancementButton();Thread.sleep(3000);
        mainpage.closePopup();			
	}//TC_05_ValidateTestRequestEnhancement
	@Test(priority = 6)
	public void TC_06_ValidateRequestEnTestAssighningAndProcessTest() throws Exception {
		System.out.println("**********************Method Starting: TC_06_ValidateRequestEnTestAssighningAndProcessTest******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Test Assighn | TC_06(Test Assighning and process)");
//		this.CompaneyName();
		int sheetNum=Myutility.getARDSheetNumber("ATR Data");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("ATR Data"+RowData);
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Test Assighn to Analist");
		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(5000);
		this.aTRsPage.Clickingonhomebutton();Thread.sleep(2000);
		aTRsPage.ClickOnInReqEnhancement();Thread.sleep(2000);
		aTRsPage.clickonSamplecodeCheckbox(ATRFormNo);Thread.sleep(1000);
		aTRsPage.ClickOnReqEnhancementAssighn();Thread.sleep(2000);
		aTRsPage.clickAndSlectAnalyst((String) RowData.get("UserName"));Thread.sleep(2000);

		aTRsPage.enterTestAssgihnPassword((String) RowData.get("Password"));Thread.sleep(2000);
		aTRsPage.ClickOnTestAssighnSubmit();Thread.sleep(2000);
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Test process ny Analyst after req enhancement");
		
		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(5000);
		this.aTRsPage.Clickingonhomebutton();Thread.sleep(2000);
		aTRsPage.ClickOnInProgress();Thread.sleep(1000);
		aTRsPage.clickonSamplecodeCheckbox(ATRFormNo);Thread.sleep(1000);
		aTRsPage.clcikOnProcessTest();Thread.sleep(1000);
		String testNo = aTRsPage.getTestNumber();
		System.out.println("Test no:"+testNo);

		aTRsPage.enterTestResults((String) RowData.get("New Value"));Thread.sleep(1000);
		
		aTRsPage.ClickOnAction();Thread.sleep(1000);
		aTRsPage.ClickOnTestSubmit();Thread.sleep(1000);

		aTRsPage.clickAndSlectReviewer((String) RowData.get("Teamlead"));Thread.sleep(1000);
		aTRsPage.enterATRResultSubmitRemarks((String) RowData.get("Description"));Thread.sleep(1000);
		aTRsPage.enterATRResultSubmitPassword((String) RowData.get("Password"));Thread.sleep(1000);
		aTRsPage.ClickOnTestSubmitFinal();Thread.sleep(3000);
	}
	@Test(priority = 7)
public void TC_07_ValidateTestAcceptFromAnalystAfterVerifying() throws Exception {
		System.out.println("**********************Method Starting: TC_07_ValidateTestAcceptFromAnalyst******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Test Accept | TC_07(self Test Accept)");
//		this.CompaneyName();
		int sheetNum=Myutility.getARDSheetNumber("ATR Data");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("ATR Data"+RowData);
			
		VerifyTestByTL(RowData);Thread.sleep(1000);	//SUb method is used to verify the test
		
		
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Test Accept");
		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(5000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnATRForms();Thread.sleep(1000);
		LeftMenuIcon.clcikOnMyATRs();Thread.sleep(3000);
		
		aTRsPage.ClickOnVerifiedTest(ATRFormNo);Thread.sleep(3000);
		aTRsPage.ClickOnTestDetailsDropdown();Thread.sleep(3000);
		aTRsPage.ClickOnTestAccpet();Thread.sleep(3000);
		aTRsPage.enterTestAcceptRemarks((String) RowData.get("Description"));Thread.sleep(3000);
		aTRsPage.ClickOnTestAccpetFinal();Thread.sleep(3000);	

//        mainpage.closePopup();	
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();

	}
	
	
}
