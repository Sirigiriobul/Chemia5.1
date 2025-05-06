package Testcases_ARD;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

import CHEMIASOFT.ARD.PageObjects.AD_experimentsPage;
import CHEMIASOFT.ARD.PageObjects.ARD_LeftMenuItemsPage;
import CHEMIASOFT.ARD.PageObjects.MyATRS_ARDPage;
import CHEMIASOFT.ARD.PageObjects.Project_Creation_ARD_Module;
import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.Embedded_Excel_Temp_Page;
import CHEMIASOFT.Chemia.Utilites.CaptureScreenShot;
import CHEMIASOFT.Chemia.Utilites.Utility;
import CHEMIASOFT.Chemia.Utilites.setBrowser;
import CHEMIASOFT.Chemia.login.PageObjects.CommonLoginPage;
import CHEMIASOFT.Chemia.login.PageObjects.CompanyName;
import CHEMIASOFT.Chemia.login.PageObjects.MainPage;
import Chemia.Project.Creation.PageObject.Team_Creation_Page;

public class ATRExperimentFlow_ARD {

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
	Project_Creation_ARD_Module ProjectCreationARD;
	AD_experimentsPage experimentPage;
	String expcode ;
	String ATRFormNo ;
	//Output Excel Sheet Details
		//int RowNumber = 1;
		int outputSheetNumber = 6 ;//Test cases Output Sheet name:ARD Experiment
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
		this.ProjectCreationARD =new Project_Creation_ARD_Module(driver);
		this.experimentPage = new AD_experimentsPage(driver);
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
	
	@Test(priority = 01)
	public void TC_01CreatingProject() throws Exception {
		System.out.println("**********************Method Starting: TC_01CreatingProject******************************");
		this.test = extent.createTest(
				"TS_ARD_5_1 | TC_01(Creating project)");
		this.CompaneyName();
		test.createNode("Creating project");
		int sheetNum=Myutility.getARDSheetNumber("ARD Projectdata");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("UserName");
		String password=(String) rowData.get("Password");
		this.login(Username,password);Thread.sleep(4000);
		driver.navigate().refresh();Thread.sleep(4000);
		test.log(Status.PASS, "loged in with user ID = " + Username);
		this.ProjectCreationARD.addProjecticon();
		this.ProjectCreationARD.ProductName((String) rowData.get("Product Name"));
		this.ProjectCreationARD.ProjectCode((String) rowData.get("Project Code"));
		this.ProjectCreationARD.ProjectCode((String) rowData.get("Project Code"));

		this.ProjectCreationARD.customeorMarket((String) rowData.get("Customer/Market"));
		this.ProjectCreationARD.ProjectType((String) rowData.get("Project Type"));
		Thread.sleep(1000);
		this.ProjectCreationARD.EnteringDescription((String) rowData.get("Description"));Thread.sleep(1000);
		this.ProjectCreationARD.Clickingonsavebutton();Thread.sleep(3000);
		this.ProjectCreationARD.Clickingondefaultnotebookyesbutton();Thread.sleep(1000);
		
		this.ProjectCreationARD.Clickingonsavebutton();Thread.sleep(4000);
//		this.ProjectCreationARD.Clickingoncancelbutton();
		test.log(Status.PASS, "Poject got Created" + (String) rowData.get("Product Name"));
		Thread.sleep(1000);//Need to add assertions here
		}//TC_01

	@Test(priority = 02)
	public void TC_02AddingAttributes() throws Exception {
		System.out.println("**********************Method Starting: TC_02AddingAttributes******************************");

		this.test = extent.createTest(
				"TS_ARD_5_1 | TC_02(Validating the attributes functionality)");
//	this.CompaneyName();
	int sheetNum=Myutility.getARDSheetNumber("ARD Projectdata");
	 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
	System.out.println("Project RowData "+rowData);
//	String Username=(String) rowData.get("UserName");
//	String password=(String) rowData.get("Password");
//	this.login(Username,password);
//	driver.navigate().refresh();
//	test.log(Status.PASS, "loged in with user ID = " + Username);
//	driver.navigate().refresh();
	this.ProjectCreationARD.Clickingonhomebutton();
	Thread.sleep(2000);
	this.ProjectCreationARD.Clickingondropdown();
	Thread.sleep(2000);
	this.ProjectCreationARD.GetprojectName((String) rowData.get("Project Code"));
	Thread.sleep(4000);
	this.ProjectCreationARD.Go_button();Thread.sleep(3000);
	ProjectCreationARD.clickAttachmentTabProjectLevel();
	
	ProjectCreationARD.clickSUmmaryTabProjectLevel();
	Thread.sleep(1000);
	this.ProjectCreationARD.Clickingonattributebutton();
	test.log(Status.PASS, "Clicked on Add Attribute Button");

	Thread.sleep(1000);
	this.ProjectCreationARD.Enteringattributename("ATT-1");
	this.ProjectCreationARD.Clickingonattributetype();
	this.ProjectCreationARD.Selectingattributenumber();
	Thread.sleep(1000);
	this.ProjectCreationARD.Entering_att_number_value("40");
	Thread.sleep(1000);
	this.ProjectCreationARD.Clickingonattsavebutton();
	test.log(Status.PASS, "Number type Attribute is Saved In Project Editor ");

	Thread.sleep(3000);
	}//TC_02
	
	@Test(priority = 03)
	public void TC_03AddingUsersToProjectAndNotebook() throws Exception {
		System.out.println("**********************Method Starting: TC_03AddingUsersToProjectAndNotebook******************************");

		this.test = extent.createTest(
				"TS_ARD_5_1 | TC_03(Adding users to Project)");
//		this.CompaneyName();
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
		test.createNode("Adding users to Project");
		int sheetNum=Myutility.getARDSheetNumber("ARD Projectdata");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("UserName");
		String password=(String) rowData.get("Password");
	
//		this.login(Username,password);
		Thread.sleep(3000);
		this.ProjectCreationARD.Clickingonhomebutton();Thread.sleep(2000);

		this.ProjectCreationARD.Clickingondropdown();
		Thread.sleep(2000);

		this.ProjectCreationARD.GetprojectName((String) rowData.get("Project Code"));
		Thread.sleep(4000);
		this.ProjectCreationARD.Go_button();
		Thread.sleep(2000);
		//driver.navigate().refresh();
		ProjectCreationARD.clickUsersTabProjectLevel();Thread.sleep(2000);
		int UserssheetNum=Myutility.getARDSheetNumber("ARD Project Users");
		Map<String, Object> usersrowData=Myutility.prepareRowData(1, UserssheetNum);
		System.out.println("ARD Project Users"+usersrowData);
		
		String[] rolesInChemia=((String) usersrowData.get("RoleInChemia")).split(",");
		String[] usersForProject=((String) usersrowData.get("UsersProjectLevel")).split(",");
		
		for (int i = 0; i < rolesInChemia.length; i++) {
			
			ProjectCreationARD.clickOnAddButtonProjectLevel();
			ProjectCreationARD.clickroledropdownProjectLevel();
			ProjectCreationARD.slectRoleProjectLevel(rolesInChemia[i].trim());
            for (int j = i; j < usersForProject.length;) {
            	
            	ProjectCreationARD.searchUsersProjectLevel(usersForProject[j].trim().toLowerCase());Thread.sleep(3000);
        		ProjectCreationARD.clickUserCheckboxProjectLevel(usersForProject[j].trim());
        		ProjectCreationARD.clickonNotebookSelectAllCheckbox();Thread.sleep(2000);
        		ProjectCreationARD.clickSaveOnAdduesrsProjectLevel();Thread.sleep(2000);
                //driver.manage().window().maximize();
//        		Assert.assertTrue(this.ExcelTemplate.GetTostMessageForNotebook().contains("is added successfully!"));
//    			test.log(Status.PASS, "Adding User "+usersForProject[j] +" To the Project");
    			Thread.sleep(2000);
        		break;
                }//for
        }//for  

	}//TC_03
	
	@Test(priority = 04)
	public void TC_04AddingAttchmentsToProject() throws Exception {
		System.out.println("**********************Method Starting: TC_04AddingAttchmentsToProject******************************");

		this.test = extent.createTest(
				" TS_CRD_5_1| TC_04(Adding attachments to the Project Level");
//		this.CompaneyName();
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Adding attachments to the Project Level");
		int sheetNum=Myutility.getARDSheetNumber("ARD Projectdata");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("TeamLead");
		String password=(String) rowData.get("Password");
		
		
		this.login(Username,password);
		
		this.ProjectCreationARD.Clickingonhomebutton();Thread.sleep(3000);
		this.ProjectCreationARD.Clickingondropdown();
		this.ProjectCreationARD.GetprojectName((String) rowData.get("Project Code"));
		test.log(Status.PASS, "Navigated to the Project "+(String) rowData.get("Project Code"));

		Thread.sleep(3000);
		this.ProjectCreationARD.Go_button();
		Thread.sleep(1000);
		this.ProjectCreationARD.clickAttachmentTabProjectLevel();
		Thread.sleep(2000);
		this.ProjectCreationARD.Attachmentuploadbutton();
		Thread.sleep(2000);
		this.ProjectCreationARD.Entering_Attachment_password((String) rowData.get("Password"));
		Thread.sleep(2000);
		this.ProjectCreationARD.Attachment_Auth_Confirm_Button();
		Thread.sleep(1000);
		
		this.ProjectCreationARD.Attachment_File(this.Myutility.PDFPath());
		Thread.sleep(3000);
		this.ProjectCreationARD.Entering_Attachment_Name("PDF");
		this.ProjectCreationARD.Entering_Attachment_Description((String) rowData.get("Description"));
		Thread.sleep(2000);
		this.ProjectCreationARD.Attachment_Save_Button();Thread.sleep(4000);
		test.log(Status.PASS, "Attachements Added successfully");
	}
	@Test(priority = 5)
	public void TC_05VerifyProjectAUditTrail() throws Exception {
		System.out.println("**********************Method Starting: TC_05VerifyProjectAUditTrail******************************");

		this.test = extent.createTest(
				" TS_ARD_5_1| TC_05(Verifying Project Audit Trail");
//		this.CompaneyName();
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();		
		test.createNode("Verifying Project Audit Trail");
		int sheetNum=Myutility.getARDSheetNumber("ARD Projectdata");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("TeamLead");
		String password=(String) rowData.get("Password");
		
		
//		this.login(Username,password);
		driver.navigate().refresh();

//		this.ProjectCreationARD.Clickingonhomebutton();Thread.sleep(3000);

//		this.ProjectCreationARD.Clickingondropdown();
//		this.ProjectCreationARD.GetprojectName((String) rowData.get("Project Code"));
//		test.log(Status.PASS, "Navigated to the Project "+(String) rowData.get("Project Code"));
//
//		Thread.sleep(3000);
//		this.ProjectCreationARD.Go_button();
//		Thread.sleep(1000);
	    this.ProjectCreationARD.clickAuditTrailTabProjectLevel();
	    this.ProjectCreationARD.Project_Audit_Trail_Arrow_Button();
	
	}
	@Test(priority = 6)
	public void TC_06CreatingExperimentParameters() throws Exception {
		System.out.println("**********************Method Starting: TC_06CreatingExperimentParameters******************************");

		this.test = extent.createTest(
				" TS_ARD_5_1| TC_06(Creating Experiment Parameters");
//		this.CompaneyName();
		test.createNode("Creating Experiment Flow");
		int sheetNum=Myutility.getARDSheetNumber("ARD Experiment Sections");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

//		String Username=(String) rowData.get("UserName");
//		String password=(String) rowData.get("Password");
//		this.login(Username,password);
			
		this.ProjectCreationARD.Clickingonhomebutton();Thread.sleep(3000);

		this.ProjectCreationARD.Clickingondropdown();
		this.ProjectCreationARD.GetprojectName((String) rowData.get("Project Code"));
		test.log(Status.PASS, "Navigated to the Project "+(String) rowData.get("Project Code"));
		Thread.sleep(4000);
		this.ProjectCreationARD.Go_button();
		Thread.sleep(1000);
		experimentPage.clcikOnNotebook((String) rowData.get("Notebook"));Thread.sleep(3000);
		int sheetNum1=Myutility.getARDSheetNumber("ExpParameters");
	    this.experimentPage.clickon_Experiment_Parameter_Tab();
	    
	    for(int i=1;i<=3;i++) {
			 Map<String, Object> ExpParameter=Myutility.prepareRowData(i, sheetNum1);
		this.experimentPage.clickon_Experiment_Parameter_AddButton();
		this.experimentPage.Enter_Experiment_Parameter_ParameterCode((String) ExpParameter.get("Code"));
		this.experimentPage.Enter_Experiment_Parameter_ParameterName((String) ExpParameter.get("Parameter Name"));
		this.experimentPage.clickon_Select_I_O((String) ExpParameter.get("Input/Output"));
		this.experimentPage.clickon_Select_Type("NUMERIC");

		this.experimentPage.clickon_Select_UserEntered_Formula((String) ExpParameter.get("User Entered/Formula"));

		if(((String) ExpParameter.get("User Entered/Formula")).equalsIgnoreCase("FORMULA")) {
			this.experimentPage.Enter_Experiment_Parameter_FormulaValue((String) ExpParameter.get("Formula"));
		}


		this.experimentPage.clickon_Select_UOM((String) ExpParameter.get("UOM"));
		//this.ProjectCreation.Enter_Experiment_Parameter_Description((String) ExpParameter.get("Description"));
//		this.experimentPage.clickon_Experiment_Parameter_SaveButton();
		this.experimentPage.clickon_Experiment_Parameter_CancelButton();

		test.log(Status.PASS, "Added Experiment Parameter "+(String) ExpParameter.get("Parameter Name"));

		}

	}
	//******************************ATR rising******************
	@Test(priority = 7)
	public void TC_07_ValidateATRsubmission() throws Exception {
		System.out.println("**********************Method Starting: TC_07_ValidateATRsubmission******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Submit new ATR | TC_07(Submit new ATR )");
//		this.CompaneyName();
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		int sheetNum=Myutility.getARDSheetNumber("ATR Data");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("ATR Data"+RowData);
			
		test.createNode("Creating new ATR with existing form");
		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(5000);
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
		ATRFormNo = aTRsPage.getATRFormNumber();Thread.sleep(1000);
		System.out.println("ATR form no:"+ATRFormNo);

        mainpage.closePopup();	
	}
	
	//*******************************Experiment Flow ***********************
	
	@Test(priority = 8)
	public void TC_08CreateandEditExperiment() throws Exception {
		System.out.println("**********************Method Starting: TC_08CreateandEditExperiment******************************");

		this.test = extent.createTest(
				" TS_ARD_5_1| TC_06(Creating Experiment Flow");
//		this.CompaneyName();
		test.createNode("Creating Experiment Flow");
		int sheetNum=Myutility.getARDSheetNumber("ARD Experiment Sections");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("UserName");
		String password=(String) rowData.get("Password");				
//		this.login(Username,password);
		driver.navigate().refresh();

		this.ProjectCreationARD.Clickingonhomebutton();Thread.sleep(2000);

		this.ProjectCreationARD.Clickingondropdown();
		this.ProjectCreationARD.GetprojectName((String) rowData.get("Project Code"));
		test.log(Status.PASS, "Navigated to the Project "+(String) rowData.get("Project Code"));
		Thread.sleep(4000);
		this.ProjectCreationARD.Go_button();
		Thread.sleep(2000);
		experimentPage.clcikOnNotebook((String) rowData.get("Notebook"));Thread.sleep(3000);
		experimentPage.clickonAdd_Experiment_Button();
		experimentPage.clickAndSlectTemplate((String) rowData.get("Exp Template"));
		experimentPage.clickAndSlectTesttype((String) rowData.get("Test Type"));
		experimentPage.clickAndSlectSubtype((String) rowData.get("Sub Type"));
		experimentPage.enterExperimentAim((String) rowData.get("Description"));
		experimentPage.clcikOnSaveExperiment();Thread.sleep(4000);
//		experimentPage.clcikOnCancelExperiment();Thread.sleep(1000);

		experimentPage.clickOnExpLink();Thread.sleep(1000);
		expcode = experimentPage.getExperimentcode();
	try {
		experimentPage.clcikOnNoRestoreExperimentData();Thread.sleep(1000);
		//experimentPage.clcikOnYesRestoreExperimentData();Thread.sleep(1000);

	}
	catch(Exception e) {
        System.out.println("Restore experiment opup not displayed");

	}
			experimentPage.clcikOnSampleDetailsAddIcon();Thread.sleep(1000);
		experimentPage.enterSampleCode("Samplecode_"+this.Myutility.getDataFromProparties("Key"));Thread.sleep(1000);
		experimentPage.clickonSamplecodeCheckbox(ATRFormNo);Thread.sleep(1000);
		experimentPage.clcikOnATRSaveTest();Thread.sleep(4000);
		experimentPage.clickonSendforverificationCheckbox(ATRFormNo);Thread.sleep(1000);
		experimentPage.clcikOnATRTestEditIcon(ATRFormNo);Thread.sleep(1000);
		experimentPage.enterTestResultsInExp((String) rowData.get("Value"));Thread.sleep(1000);
		experimentPage.enterResultsRemarksInexp((String) rowData.get("Description"));Thread.sleep(1000);
		experimentPage.enterAdRemarksInExp((String) rowData.get("Description"));Thread.sleep(1000);
		experimentPage.clcikOnAttachmentAddIconInExp();Thread.sleep(1000);
		experimentPage.uploadRawDataAttachmentInExp(this.Myutility.JPGPath());Thread.sleep(1000);
		experimentPage.enterRawDataAttachmentNameInExp("Attachment");Thread.sleep(1000);
		experimentPage.ClickOnSaveAttachment();Thread.sleep(1000);
		experimentPage.ClickOnTsetReport();Thread.sleep(1000);
		experimentPage.ClickOnUploadReport();Thread.sleep(1000);
		experimentPage.uploadReportFortest(this.Myutility.PDFPath());Thread.sleep(1000);
		experimentPage.ClickOnSaveFinalReport();Thread.sleep(1000);
		experimentPage.ClickOnSaveTestFinal();Thread.sleep(3000);
		
		
		experimentPage.clcikOnWeighningDetailsAddIcon();Thread.sleep(1000);
		experimentPage.ClickOnWDEnterMunually();Thread.sleep(1000);
		experimentPage.enterParticularsWD((String) rowData.get("Particulars"));Thread.sleep(1000);
		experimentPage.enterTareweight("10");Thread.sleep(1000);
		experimentPage.clickAndSlectUOM((String) rowData.get("UOM"));Thread.sleep(1000);
		experimentPage.enterGrosswt("14");Thread.sleep(1000);
		experimentPage.enterInstrumentIDWD((String) rowData.get("InstrumentID"));Thread.sleep(1000);
		experimentPage.enterRemarksWD((String) rowData.get("Description"));Thread.sleep(1000);
		experimentPage.clcikOnSaveWD();Thread.sleep(4000);
//		experimentPage.clcikOnCancelWD();Thread.sleep(1000);
		
		experimentPage.clcikOnPHDetailsAddIcon();Thread.sleep(1000);
		experimentPage.ClickOnPHDEnterMunually();Thread.sleep(1000);
		experimentPage.enterParticularsPHD((String) rowData.get("Particulars"));Thread.sleep(1000);
		experimentPage.enterPHvalue("9");Thread.sleep(1000);
		experimentPage.enterTemperature((String) rowData.get("Value"));Thread.sleep(1000);
		experimentPage.enterInstrumentIDPHD((String) rowData.get("InstrumentID"));Thread.sleep(1000);
		experimentPage.enterRemarksPHD((String) rowData.get("Description"));Thread.sleep(1000);
		experimentPage.clcikOnSavePHD();Thread.sleep(4000);
//		experimentPage.clcikOnCancelPHD();Thread.sleep(1000);
		
		
		
		experimentPage.clcikOnEquipmentDetailsAddIcon();Thread.sleep(1000);
		
		experimentPage.equipment_manualentry_checkbox();Thread.sleep(1000);
		experimentPage.enterInstrumentType((String) rowData.get("InstrumentID"));Thread.sleep(1000);
		experimentPage.enterInstrumentName((String) rowData.get("InstrumentID"));Thread.sleep(1000);
		experimentPage.enterInstrumentCode((String) rowData.get("InstrumentID"));Thread.sleep(1000);
		experimentPage.clcikOnStartDate();Thread.sleep(1000);
		aTRsPage.selectTodaysDate();Thread.sleep(1000);
		experimentPage.clcikOnEndDate();Thread.sleep(1000);
		aTRsPage.selectTodaysDate();Thread.sleep(1000);
		experimentPage.enterRemarksED((String) rowData.get("Description"));Thread.sleep(1000);
		experimentPage.clcikOnSaveED();Thread.sleep(4000);
//		experimentPage.clcikOnCancelED();Thread.sleep(1000);
		
		experimentPage.scrollToEmbededExcel();Thread.sleep(1000);
		int excelVal=6;
		for(int i=2;i<=6;i++) {
			if(!(i==4)) {
			for(int j=1;j<=2;j++) {
			experimentPage.enterembededValues(i,j,excelVal);Thread.sleep(1000);
			excelVal=excelVal+2;
			}
			}

		}

		
		experimentPage.enterRichText("Adding RichText Data");Thread.sleep(1000);
		experimentPage.enterStandardPreparation("Adding Standard Preparation Data");Thread.sleep(1000);
		
		experimentPage.Enter_Experiment_Combined_Data((String) rowData.get("Value"));Thread.sleep(1000);
		
		experimentPage.Click_Experiment_Data_Combined_Addbutton();Thread.sleep(1000);
		experimentPage.Enter_Experiment_Data_Combined((String) rowData.get("Value"));Thread.sleep(1000);
		experimentPage.Click_Experiment_Data_Combined_Savebutton();Thread.sleep(1000);
		
		experimentPage.Click_Experiment_Params_date();Thread.sleep(1000);
		
		experimentPage.Click_Experiment_Datatable_Addbutton();Thread.sleep(1000);
		experimentPage.Enter_Experiment_Datatable_Individualval((String) rowData.get("Value"));Thread.sleep(1000);
		experimentPage.Click_Experiment_Datatable_Savebutton();Thread.sleep(1000);
		
		
		experimentPage.Click_Experiment_Attachment_Uploadbutton();Thread.sleep(1000);
		experimentPage.Enter_Experiment_Attachment_Password((String) rowData.get("Password"));Thread.sleep(1000);
		experimentPage.ClickOnAttachmentSubmit();Thread.sleep(1000);
		experimentPage.uploadAttachmentFile(this.Myutility.PDFPath());Thread.sleep(1000);
		experimentPage.enterAttachmentName("Attachment1 PDF");Thread.sleep(1000);
		experimentPage.clickOnsaveAttachment();Thread.sleep(3000);
		
		int sheetNum1=Myutility.getARDSheetNumber("ExpParameters");
		for(int i=1;i<=3;i++) {
			 Map<String, Object> ExpParameter=Myutility.prepareRowData(i, sheetNum1);
		this.experimentPage.clcikOnExpparametersAddIcon();Thread.sleep(2000);
		this.experimentPage.enterExpParamCode((String) ExpParameter.get("Code"));Thread.sleep(1000);
		this.experimentPage.enterExpParamName((String) ExpParameter.get("Parameter Name"));Thread.sleep(1000);
		this.experimentPage.clickAndSlectIOValue((String) ExpParameter.get("Input/Output"));Thread.sleep(1000);
		this.experimentPage.clickAndSlectUserEneteredOrFormula((String) ExpParameter.get("User Entered/Formula"));Thread.sleep(1000);


		if(((String) ExpParameter.get("User Entered/Formula")).equalsIgnoreCase("FORMULA")) {
			this.experimentPage.enterExpFormula((String) ExpParameter.get("Formula"));Thread.sleep(1000);
		}
		if(((String) ExpParameter.get("User Entered/Formula")).equalsIgnoreCase("USER ENTERED")) 
		{
		this.experimentPage.clickAndSlectexpType((String) ExpParameter.get("Type"));Thread.sleep(1000);
		this.experimentPage.enterExpParametervalue((String) ExpParameter.get("Value"));Thread.sleep(1000);
		}
		
		this.experimentPage.clickAndExpSlectUOM((String) ExpParameter.get("UOM"));Thread.sleep(1000);
		this.experimentPage.clcikOnSaveExpparameter();Thread.sleep(4000);

		}
		this.experimentPage.enterConclusion((String) rowData.get("Description"));Thread.sleep(1000);

		this.experimentPage.clcikOnSaveExperimentAfterEdits();
		this.experimentPage.enterSaveComments((String) rowData.get("Description"));Thread.sleep(1000);
		this.experimentPage.enterSavePassword((String) rowData.get("Password"));
		this.experimentPage.clcikOnConfirmExperimentSave();Thread.sleep(4000);
		this.experimentPage.clcikOnToViewNotebook();Thread.sleep(4000);
		this.experimentPage.clickOnExperiments(expcode);Thread.sleep(4000);
		experimentPage.clickonSendforverificationCheckbox(ATRFormNo);Thread.sleep(1000);

		submitForApprove(rowData);Thread.sleep(1000);
		this.experimentPage.clcikOnToViewNotebook();Thread.sleep(4000);
		Assert.assertTrue(this.experimentPage.getStatusOfExperiment(expcode).equalsIgnoreCase("SUBMITTED"));


	}
	private void submitForApprove(Map<String, Object> rowData) throws Exception {
        System.out.println("**********************Sub Method Starting: submitForApprove******************************");
    	this.experimentPage.clcikOnSubmitApprovalExperimentAfterEdits();Thread.sleep(1000);
		this.experimentPage.clcikOnYesonATRResultSubmissionAlert();Thread.sleep(1000);
		this.experimentPage.enterApproveComments((String) rowData.get("Description"));Thread.sleep(000);
		this.experimentPage.clickAndExpSlectApprover((String) rowData.get("Teamlead"));Thread.sleep(2000);
		this.experimentPage.enterApprovePassword((String) rowData.get("Password"));Thread.sleep(2000);
		this.experimentPage.clcikOnConfirmExperimentApproveSending();Thread.sleep(4000);
		
    }
	
	@Test(priority = 9)
	public void TC_09SendExperimentForRework() throws Exception {
		System.out.println("**********************Method Starting: TC_09SendExperimentForRework******************************");

		this.test = extent.createTest(
				" TS_ARD_5_1| TC_09(Send Experiment rework");
//		this.CompaneyName();
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Sending experiment for rework");
		int sheetNum=Myutility.getARDSheetNumber("ARD Experiment Sections");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("Teamlead");
		String password=(String) rowData.get("Password");
		
		
		this.login(Username,password);Thread.sleep(4000);
		driver.navigate().refresh();Thread.sleep(4000);
		this.experimentPage.clickOnApprovalIcon();Thread.sleep(1000);

		this.experimentPage.clickOnExperimentsUnderApprovalRequests(expcode);Thread.sleep(1000);
		this.experimentPage.clcikOnEditSubmittedTest();Thread.sleep(1000);
		this.experimentPage.clcikOnRejectTestByTL();Thread.sleep(1000);
		this.experimentPage.enterrejectComments("Try to get more accurate");Thread.sleep(1000);
		this.experimentPage.clcikOnDone();Thread.sleep(1000);
		this.experimentPage.clcikOnSampledetailsAddcomments();Thread.sleep(1000);
		this.experimentPage.enterSampleDetailsComments("Added comments in Sample details");Thread.sleep(1000);
		this.experimentPage.clcikOnSDCommentsAdd();Thread.sleep(1000);

		this.experimentPage.clcikOnReturnExperiment();Thread.sleep(1000);
		this.experimentPage.enterReworkComments("Experiment is sending for rework");Thread.sleep(1000);
		this.experimentPage.enterReworkPassword((String) rowData.get("Password"));Thread.sleep(1000);
		this.experimentPage.clcikOnConfirmExperimentRework();Thread.sleep(3000);
//		this.experimentPage.clcikOnCancelExperimentRework();Thread.sleep(1000);

		this.experimentPage.clcikOnToViewNotebook();Thread.sleep(4000);
		Assert.assertTrue(this.experimentPage.getStatusOfExperiment(expcode).equalsIgnoreCase("REWORK"));

	}
	@Test(priority = 10)
	public void TC_10SendExperimentForApproveAfterRewok() throws Exception {
		System.out.println("**********************Method Starting: TC_10SendExperimentForApproveAfterRewok******************************");

		this.test = extent.createTest(
				" TS_ARD_5_1| TC_010(Send Experiment rework");
//		this.CompaneyName();
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Sending experiment for Approve after rework");
		int sheetNum=Myutility.getARDSheetNumber("ARD Experiment Sections");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("UserName");
		String password=(String) rowData.get("Password");
		
		
		this.login(Username,password);Thread.sleep(2000);
		driver.navigate().refresh();Thread.sleep(4000);
		this.experimentPage.clickOnReworkIcon();Thread.sleep(1000);
		this.experimentPage.clickOnExperimentsUnderApprovalRequests(expcode);Thread.sleep(1000);//works to click any experiment link
		experimentPage.clcikOnATRTestEditIcon(ATRFormNo);Thread.sleep(1000);
		experimentPage.enterTestResultsInExp("34");Thread.sleep(1000);//changed TestResults value here
		experimentPage.ClickOnSaveTestFinal();Thread.sleep(1000);
		experimentPage.clickonSendforverificationCheckbox(ATRFormNo);Thread.sleep(1000);

		submitForApprove(rowData);Thread.sleep(1000);
		this.experimentPage.clcikOnToViewNotebook();Thread.sleep(4000);
		Assert.assertTrue(this.experimentPage.getStatusOfExperiment(expcode).equalsIgnoreCase("SUBMITTED"));

	}
	@Test(priority = 11)
	public void TC_11ApproveExperiment() throws Exception {
		System.out.println("**********************Method Starting: TC_11ApproveExperiment******************************");

		this.test = extent.createTest(
				" TS_ARD_5_1| TC_11(Experiment Approve by TL");
//		this.CompaneyName();
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Sending experiment for rework");
		int sheetNum=Myutility.getARDSheetNumber("ARD Experiment Sections");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("Teamlead");
		String password=(String) rowData.get("Password");
		
		
		this.login(Username,password);Thread.sleep(2000);
		driver.navigate().refresh();Thread.sleep(4000);
		
		this.experimentPage.clickOnApprovalIcon();Thread.sleep(1000);

		this.experimentPage.clickOnExperimentsUnderApprovalRequests(expcode);Thread.sleep(1000);
		this.experimentPage.clcikOnEditSubmittedTest();Thread.sleep(1000);
		this.experimentPage.clcikOnConfirmTestByTL();Thread.sleep(1000);
		this.experimentPage.enterAcceptComments("Test Accepted By TL");Thread.sleep(1000);
		this.experimentPage.clcikOnDone();Thread.sleep(1000);

		this.experimentPage.clcikOnApproveExperiment();Thread.sleep(1000);
		this.experimentPage.clickAndAimAchieved((String) rowData.get("AimAcheived"));Thread.sleep(1000);

		this.experimentPage.enterApprovedComments("Experiment is approved");Thread.sleep(1000);
		this.experimentPage.enterApprovedPassword((String) rowData.get("Password"));Thread.sleep(1000);
		
		this.experimentPage.clcikOnConfirmExperimentApproval();Thread.sleep(1000);
//		this.experimentPage.clcikOnCancelExperimentApproval();Thread.sleep(1000);

		this.experimentPage.clcikOnToViewNotebook();Thread.sleep(4000);
		Assert.assertTrue(this.experimentPage.getStatusOfExperiment(expcode).equalsIgnoreCase("APPROVED"));

	}
}