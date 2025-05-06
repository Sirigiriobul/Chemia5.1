package Testcases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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

import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.CRD_Left_Menu_Tabs;
import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.Embedded_Excel_Temp_Page;
import CHEMIASOFT.Chemia.Utilites.BaseClass;
import CHEMIASOFT.Chemia.Utilites.CaptureScreenShot;
import CHEMIASOFT.Chemia.Utilites.Utility;
import CHEMIASOFT.Chemia.Utilites.setBrowser;
import CHEMIASOFT.Chemia.login.PageObjects.CommonLoginPage;
import CHEMIASOFT.Chemia.login.PageObjects.CompanyName;
import CHEMIASOFT.Chemia.login.PageObjects.MainPage;
import Chemia.Project.Creation.PageObject.Project_AuditTrail_Page;
import Chemia.Project.Creation.PageObject.Project_Creation_Page;
import Chemia.Project.Creation.PageObject.Project_NoteBook_Page;
import Chemia.Project.Creation.PageObject.Project_Users_Page;

public class TS_Chemia_CRD_04_NotebookEditor extends BaseClass {
//	Utility Myutility;
//	WebDriver driver;
//	// Actions actions = new Actions (driver);
//
//	CompanyName cname; // Company Name Page
//	CommonLoginPage loginpage; // Login Page
//	MainPage mainPage;
//	CRD_Left_Menu_Tabs LeftMenuIcon;
//	Project_Creation_Page ProjectCreation;
//	Project_NoteBook_Page projectNotebook;
//	Project_Users_Page projectUsers;
//	Embedded_Excel_Temp_Page ExcelTemplate;
//	Project_AuditTrail_Page AuditTrail;
//	@BeforeSuite
//	// In before suite we will call the browser & pass the URL to open the
//	// application
//	// also maximize the browser
//	public void beforesuite() throws Exception {
//
//		System.out.println("Suit executed & starting the browser");
//		this.Myutility = new Utility();
//		this.driver = setBrowser.browser();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.navigate().refresh();
//		driver.get(this.Myutility.getDataFromProparties("URL"));
//
//	}
//
//	@AfterSuite
//	// In after suite we quite the driver. That means we close the browser
//
//	public void afterSuite() {
//		System.out.println("Suit completed");
//		//this.driver.quit();
//	}
//
//	// Extent Reports
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
				this.Myutility.PathOfReport() + "/" + date + " " + "TS_Chemia_CRD_04.html");
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
//
//	@AfterTest
//	// In after Test we flush out the report for saving all the data
//	public void afterTest() {
//
//		extent.flush();
//	}
//
	@BeforeMethod
//	 in Before method we will initiate all the class which are needed for the test
//	 case
	public void beforeMethod() throws Exception {
		// Pages
		this.cname = new CompanyName(driver); // Company Name Page
		this.loginpage = new CommonLoginPage(driver); // Common Login Page
		this.mainPage = new MainPage(driver); // Main Page
		ProjectCreation = new Project_Creation_Page(driver);
		this.projectNotebook=new Project_NoteBook_Page(driver);
		this.projectUsers = new Project_Users_Page(driver);
		this.ExcelTemplate = new Embedded_Excel_Temp_Page(driver);
		this.AuditTrail    = new Project_AuditTrail_Page (driver);
	

	}
//
//	@AfterMethod
//	// In after method we will get the result for each test case. According to the
//	// result we will mark the test case as pass, Fail (or) Skip
//	// At the same we will save the result on both Excel & extent report along with
//	// the screen short number
//	public void AfterMethod(ITestResult result) throws Exception {
//
//		if (result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, result.getName() + "Test Case is Passed ");
//			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
//			test.addScreenCaptureFromPath(screenshortpath);
//
//		}
//		if (result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, result.getName() + "Test Case is Failed  ");
//			test.log(Status.FAIL, "Test Case is Faild due to  " + result.getThrowable());
//			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
//			test.addScreenCaptureFromPath(screenshortpath);
//
//		}
//		if (result.getStatus() == ITestResult.SKIP) {
//			test.log(Status.SKIP, "Test Case Skiped is " + result.getName());
//			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
//			test.addScreenCaptureFromPath(screenshortpath);
//
//		}
//
//	}
//
//	public void CompaneyName() throws Exception {
//
//		this.cname.Companey_name(this.Myutility.getDataFromProparties("Companeyname"));
//		this.cname.nextButton();
//
//	}
//
//	public void login(String userName, String password) throws Exception {
//
//		this.loginpage.username(userName);
//		this.loginpage.userpassword(password);
//		this.loginpage.loginbutton();
//		try {
//			this.loginpage.multipleloginpopup();
//			this.loginpage.MutipleLoginpopupYesButton();
//			this.loginpage.username(userName);
//			this.loginpage.userpassword(password);
//			this.loginpage.loginbutton();
//		} catch (Exception e) {
//			System.out.println("Multiple Login Popup Is not displayed..");
//		}
//		this.mainPage.RandD();
//		Thread.sleep(5000);
//	}
//
//	public void logout() {
//
//		this.mainPage.logout();
//
//	}

	@Test(priority = 1)
	public void TC_1() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_04_NotebookEditor | TC_1(Create Notebook for project with out manditory fields)");
		CompaneyName();
		test.createNode("Create Notebook for project with out manditory fields");
		login("SS_CRD_HOD", "Chemia@1234");
		//test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
		//driver.navigate().refresh();
		this.ProjectCreation.DropdownButton();
		this.ProjectCreation.GetprojectName("PC01");
		Thread.sleep(3000);
		this.ProjectCreation.Go_button();
		projectUsers.clickNoteBookTabProjectLevel();
		this.ProjectCreation.Addbuttonfornotebook(); Thread.sleep(1000);
		projectNotebook.clearNoteBookName();
		projectNotebook.enterDescriptionNoteBook("");
		 this.ProjectCreation.Savebuttonfornotebook();
		 System.out.println(this.ExcelTemplate.GetTostMessageForNotebook());

		 Assert.assertEquals(this.ExcelTemplate.GetTostMessageForNotebook(), "Please fill all the mandatory (*) fields!");
	}
	
	@Test(priority = 2)
	public void TC_2() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_04_NotebookEditor | TC_2(navigate to the note book and verify edit Functionality)");
//	//	this.CompaneyName();
		test.createNode("navigate to the note book and verify edit Functionality");
//		//this.login("SS_CRD_HOD", "Chemia@1234");
//		//test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
//		//driver.navigate().refresh();
//		this.ProjectCreation.DropdownButton();
//		this.ProjectCreation.GetprojectName("PCode_1");
//		Thread.sleep(3000);
//		this.ProjectCreation.Clickingonnotebooktab(); Thread.sleep(1000);
//		this.ProjectCreation.Addbuttonfornotebook(); Thread.sleep(1000);
//		projectNotebook.clearNoteBookName();
//		projectNotebook.enterNoteBookName("NoteBookedit1");
//		this.ProjectCreation.Enteringnotebookdescription(); Thread.sleep(1000);
//		this.ProjectCreation.Savebuttonfornotebook(); Thread.sleep(2000);
//		
////		this.ProjectCreation.Go_button();
		projectUsers.clickOnProjectbreadcrumb("PC01");

		projectNotebook.clickOnNotebook("NoteBookedit");
		projectUsers.clickOnAudittrailTabNotebookLevel();
		projectUsers.clickOnSummaryTabNotebookLevel();
		projectNotebook.editNoteBook();
		projectNotebook.clearNoteBookNameInSummary();
		projectNotebook.changeNoteBookNameTo("NoteBook_QA");
		projectNotebook.enterDescriptionNoteBook("Automation Testing");
		projectNotebook.saveChangesNoteBook();
		Assert.assertEquals(this.ExcelTemplate.GetTostMessageForNotebook(), "Notebook has been updated successfully");
		
		//SetBack Name from NoteBook_QA to E000058 and empty Description
		
		projectNotebook.editNoteBook();
		projectNotebook.clearNoteBookNameInSummary();
		projectNotebook.changeNoteBookNameTo("NoteBookedit");
		projectNotebook.enterDescriptionNoteBook("");
		projectNotebook.saveChangesNoteBook();
	}
	
	@Test(priority = 3)
	public void TC_3() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_04_NotebookEditor | TC_3(Check notebook close functinality with out experiments)");
		//this.CompaneyName();
		test.createNode("Check notebook close functinality with out experiments");
		//this.login("SS_CRD_HOD", "Chemia@1234");
		//test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
		//driver.navigate().refresh();
//		this.ProjectCreation.DropdownButton();
//		this.ProjectCreation.GetprojectName("PCode_1");
//		Thread.sleep(3000);
//		this.ProjectCreation.Go_button();
		Thread.sleep(3000);

		projectUsers.clickOnProjectbreadcrumb("PC01");

		projectNotebook.clickOnNotebook("NoteBookedit");
		projectUsers.clickOnAudittrailTabNotebookLevel();
		projectUsers.clickOnSummaryTabNotebookLevel();
		projectNotebook.closeNoteBook();
		projectNotebook.clickYesOnCloseNoteBookPopup();
		projectNotebook.entercloseCommentsInNoteBook("Closing for Automation");
		projectNotebook.saveCloseNoteBook();
		
		projectUsers.clickEventsTabProjectLevel();
		String eventDetails=AuditTrail.getFirstEventDetails();
		System.out.print("Event : "+eventDetails);
		Assert.assertTrue(eventDetails.contains("Notebook NoteBookedit is closed"));
	}
	
	@Test(priority = 4)
	public void TC_4() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_04_NotebookEditor | TC_4(Check closed notebook re open functinality with out experiments)");
		//CompaneyName();
		test.createNode("Check closed notebook re open functinality with out experiments");
//		this.login("SS_CRD_HOD", "Chemia@1234");
//		ProjectCreation.DropdownButton();
//		this.ProjectCreation.GetprojectName("PC01");
//		Thread.sleep(3000);
//		this.ProjectCreation.Go_button();
		
		Thread.sleep(3000);

		projectUsers.clickNoteBookTabProjectLevel();
		projectNotebook.selectNoteBookInNoteBookTab("NoteBookedit");
		projectNotebook.clickOnReopenInNotebookTab();
		projectNotebook.clickyesReopenNoteBook();
		Thread.sleep(3000);
		projectUsers.clickNoteBookTabProjectLevel();

		String noteBookStatus=projectNotebook.getNotebookStatus("NoteBookedit").trim();
		System.out.print("noteBookStatus : "+noteBookStatus);
		Assert.assertTrue(noteBookStatus.equalsIgnoreCase("NEW"));
	}
	
	@Test(priority = 5)
	public void TC_5() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_04_NotebookEditor | TC_5(Create note book and verify deactivate functionality)");
//		//this.CompaneyName();
		test.createNode("Create note book and verify deactivate functionality");
//		//this.login("SS_CRD_HOD", "Chemia@1234");
//		this.ProjectCreation.DropdownButton();
//		this.ProjectCreation.GetprojectName("PCode_1");
//		Thread.sleep(3000);
//		this.ProjectCreation.Go_button();
//		projectUsers.clickNoteBookTabProjectLevel();
		this.ProjectCreation.Addbuttonfornotebook(); Thread.sleep(1000);
		projectNotebook.clearNoteBookName();
		projectNotebook.enterNoteBookName("DeactivatNB");
		projectNotebook.enterDescriptionNoteBook("Deactivate NB");
		this.ProjectCreation.Savebuttonfornotebook();
			projectUsers.clickOnSummaryTabNotebookLevel();
			projectNotebook.deactivateNoteBook();
			projectNotebook.clickYesOnCloseNoteBookPopup();//this method work for yes button in multiple popups.
			projectUsers.clickEventsTabProjectLevel();
		String eventDetails=AuditTrail.getFirstEventDetails();
		System.out.print("Event : "+eventDetails);
		Assert.assertTrue(eventDetails.contains("Notebook DeactivatNB is deactivated"));
	}

}//TS_Chemia_CRD_04_NotebookEditor
