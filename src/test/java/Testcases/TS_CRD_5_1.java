package Testcases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
import CHEMIASOFT.Chemia.Utilites.CaptureScreenShot;
import CHEMIASOFT.Chemia.Utilites.Utility;
import CHEMIASOFT.Chemia.Utilites.setBrowser;
import CHEMIASOFT.Chemia.login.PageObjects.CommonLoginPage;
import CHEMIASOFT.Chemia.login.PageObjects.CompanyName;
import CHEMIASOFT.Chemia.login.PageObjects.MainPage;
import Chemia.Project.Creation.PageObject.Project_Creation_Page;
import Chemia.Project.Creation.PageObject.Project_N_Experiments_Page;
import Chemia.Project.Creation.PageObject.Project_NoteBook_Page;
import Chemia.Project.Creation.PageObject.Project_Users_Page;
import Chemia.Project.Creation.PageObject.Team_Creation_Page;

public class TS_CRD_5_1 {
	Utility Myutility;
	WebDriver driver;
	// Actions actions = new Actions (driver);

	CompanyName cname; // Company Name Page
	CommonLoginPage loginpage; // Login Page
	MainPage mainPage;
	CRD_Left_Menu_Tabs LeftMenuIcon;
	Project_Creation_Page ProjectCreation;
	Project_Users_Page projectUsers;
	Embedded_Excel_Temp_Page ExcelTemplate;
	Project_NoteBook_Page projectNotebook;
	Project_N_Experiments_Page ExperimentsPage;
	Team_Creation_Page teamcreation;
	String createdExperiment;
	//Output Excel Sheet Details
	int RowNumber = 1;
	int outputSheetNumber = 3;
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
		
//		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
//		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
	}

	@AfterSuite
	// In after suite we quite the driver. That means we close the browser

	public void afterSuite() {
		System.out.println("Suit completed");
		logout();
		driver.quit();
	}

	// Extent Reports
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeClass
	// In before Test we create the extent report & attach the screen short to the
	// report
	// At the same time we also give more info about like which browser is used, who
	// tested etc by using

	public void beforetest() throws Exception {

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

	@AfterClass
	// In after Test we flush out the report for saving all the data
	public void afterTest() {

		extent.flush();
	}

	@BeforeMethod
	// in Before method we will initiate all the class which are needed for the test
	// case
	public void beforeMethod() {
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Pages
		this.cname = new CompanyName(driver); // Company Name Page
		this.loginpage = new CommonLoginPage(driver); // Common Login Page
		this.mainPage = new MainPage(driver); // Main Page
		this.ProjectCreation = new Project_Creation_Page(driver);
		this.projectUsers = new Project_Users_Page(driver);
		this.ExcelTemplate = new Embedded_Excel_Temp_Page(driver);
		this.projectNotebook=new Project_NoteBook_Page(driver);
		this.ExperimentsPage = new Project_N_Experiments_Page(driver);
		this.teamcreation = new Team_Creation_Page(driver);
		this.LeftMenuIcon = new CRD_Left_Menu_Tabs(driver);
	}
	@AfterMethod
	// In after method we will get the result for each test case. According to the
	// result we will mark the test case as pass, Fail (or) Skip
	// At the same we will save the result on both Excel & extent report along with
	// the screen short number
	public void AfterMethod(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + "Test Case is Passed ");
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber,
					String.valueOf(Status.PASS));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber + 1,
					screenshortpath.substring(46));
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName() + "Test Case is Failed  ");
			test.log(Status.FAIL, "Test Case is Faild due to  " + result.getThrowable());
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);

			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber,
					String.valueOf(Status.FAIL));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber + 1,
					screenshortpath.substring(46));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber + 2,
					"Test Case is failed due to  " + result.getThrowable());

		}
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skiped is " + result.getName());
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);

			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber,
					String.valueOf(Status.SKIP));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), outputSheetNumber, RowNumber, ColumnNumber + 1,
					screenshortpath.substring(46));

		}
		this.RowNumber += 1;

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
		this.mainPage.RandD();
		Thread.sleep(5000);
		driver.navigate().refresh();//Written this code (Line 198 to 215 )to handle blank page which is coming after clicking on R&D
		try {
			driver.navigate().refresh();
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
		} catch (Exception e) {
			System.out.println("Already Navigated to Dashboard.");
		}
	}

	public void logout() {

		this.mainPage.logout();

	}
	@Test(priority = 1)
	public void TC_01() throws Exception {
		System.out.println("****************Method Starting: TC_01********************************");

		this.test = extent.createTest(
				"TS_CRD_5_1 | TC_01(Creating project)");
		this.CompaneyName();
		test.createNode("Creating project");
		int sheetNum=Myutility.getSheetNumber("Projectdata");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("UserName");
		String password=(String) rowData.get("Password");
		this.login(Username,password);
		driver.navigate().refresh();
		test.log(Status.PASS, "loged in with user ID = " + Username);
		this.ProjectCreation.addProjecticon();
		this.ProjectCreation.ProductName((String) rowData.get("Product Name"));
		this.ProjectCreation.ProjectCode((String) rowData.get("Project Code"));
		this.ProjectCreation.customeorMarket((String) rowData.get("Customer/Market"));
		this.ProjectCreation.ProjectType((String) rowData.get("Project Type"));
		Thread.sleep(1000);
		this.ProjectCreation.EnteringDescription((String) rowData.get("Description"));
		this.ProjectCreation.Clickingonsavebutton();Thread.sleep(3000);
		test.log(Status.PASS, "Poject got Created" + (String) rowData.get("Product Name"));
		Thread.sleep(1000);//Need to add assertions here
		}//TC_01
	
	@Test(priority = 2)
	public void TC_02() throws Exception {
		System.out.println("****************Method Starting: TC_02********************************");

		this.test = extent.createTest(
				"TS_CRD_5_1 | TC_02(Validating the attributes functionality)");
	
	int sheetNum=Myutility.getSheetNumber("Projectdata");
	 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
	System.out.println("Project RowData "+rowData);
//	driver.navigate().refresh();
	this.ProjectCreation.Clickingonhomebutton();
	Thread.sleep(1000);
	this.ProjectCreation.DropdownButton();
	Thread.sleep(2000);
	this.ProjectCreation.GetprojectName((String) rowData.get("Project Code"));
	Thread.sleep(4000);
	this.ProjectCreation.Go_button();
	projectUsers.clickExpparametersTabProjectLevel();
	
	projectUsers.clickSUmmaryTabProjectLevel();

	this.ProjectCreation.Clickingonattributebutton();
	test.log(Status.PASS, "Clicked on Add Attribute Button");

	Thread.sleep(1000);
	this.ProjectCreation.Enteringattributename("ATT-1");
	this.ProjectCreation.Clickingonattributetype();
	this.ProjectCreation.Selectingattributenumber();
	Thread.sleep(1000);
	this.ProjectCreation.Entering_att_number_value("50");
	Thread.sleep(1000);
	this.ProjectCreation.Clickingonattsavebutton();
	test.log(Status.PASS, "Number type Attribute is Saved In Project Editor ");

	Thread.sleep(1000);
	}//TC_02
	
	@Test(priority = 3)
	public void TC_03() throws Exception {
		System.out.println("****************Method Starting: TC_03********************************");

		this.test = extent.createTest(
				"TS_CRD_5_1 | TC_03(verifying the created user in Users tab by default");
//	
//	driver.navigate().refresh();
//	this.ProjectCreation.Clickingonhomebutton();
//	this.ProjectCreation.DropdownButton();
//	Thread.sleep(2000);
		
		int sheetNum=Myutility.getSheetNumber("Projectdata");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);
//			
//			this.ProjectCreation.GetprojectName((String) rowData.get("Project Code"));
//			Thread.sleep(4000);
//			this.ProjectCreation.Go_button();

	String Username=(String) rowData.get("UserName");
	projectUsers.clickUsersTabProjectLevel();
	test.log(Status.PASS, "Clicked on Users Tab In Project Level");

	System.out.println("diplayname"+projectUsers.getFirstDIsplayName());
	Assert.assertTrue(Username.equalsIgnoreCase(projectUsers.getFirstDIsplayName()));
	test.createNode("Validate default user in Users Tab Removing Functionality");

	projectUsers.clickdeleteProjectLevel(Username);
	projectUsers.clickYesRemoveUserProjectLevel();
	
	Assert.assertEquals(this.ExcelTemplate.GetTostMessageForNotebook(), "The logged in user cannot be removed");
	test.log(Status.PASS, "The logged in user cannot be removed"+Username);

	}//TC_03
	
	@Test(priority = 4)
	public void TC_04() throws Exception {
		System.out.println("****************Method Starting: TC_04********************************");

		this.test = extent.createTest(
				"TS_CRD_5_1 | TC_04(Adding users to Project)");
//		this.CompaneyName();
		test.createNode("Adding multiple users to project");
		int sheetNum=Myutility.getSheetNumber("Projectdata");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

//		String Username=(String) rowData.get("UserName");
//		String password=(String) rowData.get("Password");
//		
//		
//		this.login(Username,password);
//		
//		this.ProjectCreation.Clickingonhomebutton();
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(2000);
//
//		this.ProjectCreation.GetprojectName((String) rowData.get("Project Code"));
//		Thread.sleep(4000);
//		this.ProjectCreation.Go_button();

		projectUsers.clickUsersTabProjectLevel();
		int UserssheetNum=Myutility.getSheetNumber("data for Users Tab");
		Map<String, Object> usersrowData=Myutility.prepareRowData(1, UserssheetNum);
		System.out.println("usersrowData"+usersrowData);
		
		String[] rolesInChemia=((String) usersrowData.get("RoleInChemia")).split(",");
		String[] usersForProject=((String) usersrowData.get("UsersProjectLevel")).split(",");
		
		for (int i = 0; i < rolesInChemia.length; i++) {
			
			projectUsers.clickOnAddProjectLevel();
			projectUsers.clickroledropdownProjectLevel();
			projectUsers.slectRoleProjectLevel(rolesInChemia[i].trim());
            for (int j = i; j < usersForProject.length;) {
            	
        		projectUsers.searchUsersProjectLevel(usersForProject[j].trim().toLowerCase());
        		projectUsers.clickUserCheckboxProjectLevel(usersForProject[j].trim());
                driver.manage().window().fullscreen();
        		//projectUsers.clickCancelOnAdduesrsProjectLevel();
        		projectUsers.clickSaveOnAdduesrsProjectLevel();
                driver.manage().window().maximize();
        		Assert.assertTrue(this.ExcelTemplate.GetTostMessageForNotebook().contains(usersForProject[j])&&this.ExcelTemplate.GetTostMessageForNotebook().contains("successfully added"));
    			test.log(Status.PASS, "Adding User "+usersForProject[j] +" To the Project");

        		break;
                }//for
        }//for  

	}//TC_04
	@Test(priority = 5)
	public void TC_05() throws Exception {
		System.out.println("****************Method Starting: TC_05********************************");

		this.test = extent.createTest(
				"TS_CRD_5_1 | TC_05(Check users remove functionality in Project level)");
		test.createNode("Checking users remove functionality");
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
//		this.CompaneyName();
		int sheetNum=Myutility.getSheetNumber("Projectdata");
		Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
//		this.login((String) rowData.get("Approver"),(String) rowData.get("Password"));
//		
//		this.ProjectCreation.Clickingonhomebutton();
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(2000);
//
//		this.ProjectCreation.GetprojectName((String) rowData.get("Project Code"));
//		Thread.sleep(4000);
//		this.ProjectCreation.Go_button();
		projectUsers.clickUsersTabProjectLevel();

		String name =projectUsers.getNamewithUserName("SS_CRD_QA");
		projectUsers.clickdeleteProjectLevel("SS_CRD_QA");
		Thread.sleep(3000);
		projectUsers.clickYesRemoveUserProjectLevel();Thread.sleep(3000);
		
		Assert.assertTrue(this.ExcelTemplate.GetTostMessageForNotebook().contains("has been removed from project successfully")&&this.ExcelTemplate.GetTostMessageForNotebook().contains(name));
		String screenshortpath = CaptureScreenShot.GetScreenShort(driver, "deleted User");
		test.addScreenCaptureFromPath(screenshortpath);
		test.log(Status.PASS, "Removed User "+name+" From the Project");
		//Adding the QA user again
//				projectUsers.clickOnAddProjectLevel();
//				projectUsers.clickroledropdownProjectLevel();
//				projectUsers.slectRoleProjectLevel("Chemistry QA");Thread.sleep(2000);
//		    		projectUsers.searchUsersProjectLevel("SS_CRD_QA");
//		    		projectUsers.clickUserCheckboxProjectLevel("SS_CRD_QA");
//		            driver.manage().window().fullscreen();
//		    		//projectUsers.clickCancelOnAdduesrsProjectLevel();
//		    		projectUsers.clickSaveOnAdduesrsProjectLevel();
//		            driver.manage().window().maximize();

		}//TC_05
	@Test(priority = 6)
	public void TC_06() throws Exception {
		System.out.println("****************Method Starting: TC_06********************************");

		this.test = extent.createTest(
				" TS_CRD_5_1| TC_06(Create Notebook)");
//		this.CompaneyName();
		test.createNode("Create Notebook and Navigate in to it");
		int sheetNum=Myutility.getSheetNumber("Projectdata");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
//			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("UserName");
		String password=(String) rowData.get("Password");
		
		
//		this.login(Username,password);
//		
//		this.ProjectCreation.Clickingonhomebutton();
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(2000);
//
//		this.ProjectCreation.GetprojectName((String) rowData.get("Project Code"));
//		Thread.sleep(4000);
//		this.ProjectCreation.Go_button();

		projectUsers.clickNoteBookTabProjectLevel();Thread.sleep(2000);//called this method to overcome overlapping leftmenu
		this.ProjectCreation.Addbuttonfornotebook(); Thread.sleep(1000);
		test.log(Status.PASS, "Click On Note book add button in note book Tab");

		int UserssheetNum=Myutility.getSheetNumber("data for Users Tab");
		Map<String, Object> usersrowData=Myutility.prepareRowData(1, UserssheetNum);
		
		projectNotebook.clearNoteBookName();
		projectNotebook.enterNoteBookName((String) usersrowData.get("NoteBooks"));
		projectNotebook.enterDescriptionNoteBook((String) usersrowData.get("Description"));
		this.ProjectCreation.Savebuttonfornotebook();
		Thread.sleep(2000);
		//Need to add assertions here
		test.log(Status.PASS, "Created Note Book"+(String) usersrowData.get("NoteBooks")+" From the Project");
//		projectNotebook.clickOnNotebook((String) usersrowData.get("NoteBooks"));
	}//TC_06
	
	@Test(priority = 7)
	public void TC_07() throws Exception {
		System.out.println("****************Method Starting: TC_07********************************");

		this.test = extent.createTest(
				" TS_CRD_5_1| TC_07(Adding users to Notebook)");
		test.createNode("Adding multiple users to Notebook");
		int UserssheetNum=Myutility.getSheetNumber("data for Users Tab");
		Map<String, Object> usersrowData=Myutility.prepareRowData(1, UserssheetNum);
		projectUsers.clickOnAudittrailTabNotebookLevel();	

		projectUsers.clickOnUsersTabNotebookLevel();
		test.createNode("Adding multiple users to Notebook");

		String[] usersForNotebook=((String) usersrowData.get("UsersNotebook")).split(",");
		System.out.println("users notebook level rowData"+usersForNotebook);
		
		for(String notebookUser:usersForNotebook) {
		test.log(Status.PASS, "Click On User add button in Note Users Tab");
		projectUsers.clickOnAddNotebookLevel();
		projectUsers.clickcheckBoxofUserInAdduserPopupNotebookLevel(notebookUser);
		projectUsers.clickYesOnAdduserPopupNotebookLevel();
		//projectUsers.clickCancelOnAdduserPopupNotebookLevel();
		Assert.assertTrue(projectUsers.isUseraddedInNotebook(notebookUser));
		test.log(Status.PASS, "Adding User "+notebookUser +" To the Notebook");

		}//for
		
	}//TC_07
	
	@Test(priority = 8)
	public void TC_08() throws Exception {
		System.out.println("****************Method Starting: TC_08********************************");

		this.test = extent.createTest(
				"TS_CRD_5_1 | TC_08(Creating route for a project");
//		this.CompaneyName();
	
		int sheetNum=Myutility.getSheetNumber("ROSData");
		 Map<String, Object> ROSdata=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project ROS Data "+ROSdata);
			this.logout();Thread.sleep(1000);
			driver.navigate().refresh();
			String Username=(String) ROSdata.get("UserName");
			String password=(String) ROSdata.get("Password");
			this.login(Username,password);

		this.ProjectCreation.Clickingonhomebutton();
		this.ProjectCreation.DropdownButton();
		this.ProjectCreation.GetprojectName((String) ROSdata.get("Project Code"));
		Thread.sleep(3000);
		this.ProjectCreation.Go_button();
			
//		projectUsers.clickOnProjectbreadcrumb((String) ROSdata.get("Project Code"));
//		test.log(Status.PASS, "Navigated back to project from notebook");

		Thread.sleep(3000);
		test.createNode("Creating Route for Project");
		projectUsers.clickROSTabProjectLevel();Thread.sleep(2000);
		test.log(Status.PASS, "Navigated to ROS Tab");

		this.ProjectCreation.ROS_addbutton();Thread.sleep(2000);
		this.ProjectCreation.Entering_route_initial_value((String) ROSdata.get("Route Initials"));
		this.ProjectCreation.Entering_route_name_value((String) ROSdata.get("Route"));
		this.ProjectCreation.Entering_route_description_value((String) ROSdata.get("Description"));
		this.ProjectCreation.Fileuploadbutton();
		this.Myutility.Uploadfile(this.Myutility.SVG_FILEPath()); 
		this.ProjectCreation.Routesavebutton();
		Thread.sleep(3000);
		//Need to add assertions here
		test.log(Status.PASS, "Created Route for a Project "+(String) ROSdata.get("Project Code"));

	}//TC_08

	@Test(priority = 9)
	public void TC_09() throws Exception {
		System.out.println("****************Method Starting: TC_09********************************");

		this.test = extent.createTest(
				"TS_CRD_5_1 | TC_09(Creating stage for a route in a project");
		test.createNode("Creating stage for Route");
		int sheetNum=Myutility.getSheetNumber("ROSData");
		 Map<String, Object> ROSdata=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project ROS Data "+ROSdata);
		this.ProjectCreation.Routearrowbutton((String) ROSdata.get("Route Initials"));
		Thread.sleep(3000);
		test.log(Status.PASS, "Navigated to add stage for the Route");

		this.ProjectCreation.Stageaddbutton((String) ROSdata.get("Route Initials"));
		this.ProjectCreation.Entering_stageinitial_value((String) ROSdata.get("Stage Initials"));
		this.ProjectCreation.Entering_stage_value((String) ROSdata.get("Stage Initials"));
		this.ProjectCreation.Entering_stage_description("Creating Stage");
		this.ProjectCreation.Schemeuploadbutton();
		
		this.Myutility.Uploadfile(this.Myutility.SVG_FILEPath()); 
		Thread.sleep(3000);

		this.ProjectCreation.Inputaddbutton();
		this.ProjectCreation.Inputtypedropdown();
		this.ProjectCreation.Selectinginputtype((String) ROSdata.get("Type"));
		this.ProjectCreation.Clickingon_Chemicalname();
		this.ProjectCreation.Entering_Chemicalname((String) ROSdata.get("Chemical Name"));
		this.ProjectCreation.Entering_CAS_NO((String) ROSdata.get("CAS No."));Thread.sleep(1000);
		this.ProjectCreation.Entering_molWt((String) ROSdata.get("Mol.Wt."));Thread.sleep(1000);
		this.ProjectCreation.Inputaddbutton();Thread.sleep(1000);
		this.ProjectCreation.Deleteinputbutton();Thread.sleep(1000);
		this.ProjectCreation.Stageinputsavebutton();
		//Need to add assertions here
		test.log(Status.PASS, "Created Stage for a Route "+(String) ROSdata.get("Route Initials"));
	}//TC_09
	
	@Test(priority = 10)
	public void TC_10() throws Exception {
		System.out.println("****************Method Starting: TC_10********************************");
		this.test = extent.createTest(
				" TS_CRD_5_1| TC_10(Adding attachments to the Project Level");
//		this.CompaneyName();
		test.createNode("Adding attachments to the Project Level");
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		int sheetNum=Myutility.getSheetNumber("ROSData");
		Map<String, Object> ROSdata=Myutility.prepareRowData(1, sheetNum);
		this.login((String) ROSdata.get("UserName"),(String) ROSdata.get("Password"));

		test.log(Status.PASS, "Login with User ID"+(String) ROSdata.get("UserName"));

		System.out.println("Project ROS Data "+ROSdata);
		this.ProjectCreation.DropdownButton();
		this.ProjectCreation.GetprojectName((String) ROSdata.get("Project Code"));
		test.log(Status.PASS, "Navigated to the Project "+(String) ROSdata.get("Project Code"));

		Thread.sleep(3000);
		this.ProjectCreation.Go_button();Thread.sleep(3000);
		this.projectUsers.clickAttachmentTabProjectLevel();
		Thread.sleep(2000);
		this.ProjectCreation.Attachmentuploadbutton();
		Thread.sleep(2000);
		this.ProjectCreation.Entering_Attachment_password((String) ROSdata.get("Password"));
		Thread.sleep(2000);
		this.ProjectCreation.Attachment_Auth_Confirm_Button();
		this.ProjectCreation.Attachment_File(this.Myutility.PDFPath());
		Thread.sleep(3000);
		this.ProjectCreation.Entering_Attachment_Name("PDF");
		this.ProjectCreation.Entering_Attachment_Description((String) ROSdata.get("Description"));
		Thread.sleep(2000);
		this.ProjectCreation.Attachment_Save_Button();
		test.log(Status.PASS, "Attachements Added successfully");
		//Need to add assertions here	
	}//TC_10
	
	@Test(priority = 11)
	public void TC_11() throws Exception {
		System.out.println("****************Method Starting: TC_11********************************");
		this.test = extent.createTest(
				"TS_CRD_5_1 | TC_11(Adding Experiment parameters in Project)");
//		this.CompaneyName();
		test.createNode("Adding experiment parameters in Project");
//		this.login("SS_CRD_HOD", "Chemia@1234");
		//test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
//		driver.navigate().refresh();
//		this.ProjectCreation.Clickingonhomebutton();
		int sheetNum=Myutility.getSheetNumber("ExpParameters");
//		int rowcount=Myutility.getRowCount(sheetNum);		
//		 Map<String, Object> ExpParameters=Myutility.prepareRowData(1, sheetNum);
//			System.out.println("Project ExpPar"+ExpParameters);
//		this.ProjectCreation.DropdownButton();
//		this.ProjectCreation.GetprojectName((String) ExpParameters.get("Project Code"));
//		Thread.sleep(3000);
//		this.ProjectCreation.Go_button();
		Thread.sleep(2000);
		projectUsers.clickExpparametersTabProjectLevel();
		
		for(int i=1;i<=3;i++) {
			 Map<String, Object> ExpParameter=Myutility.prepareRowData(i, sheetNum);
		this.ProjectCreation.experimentparametersaddbutton();
		this.ProjectCreation.Experiment_Parameter_Code((String) ExpParameter.get("Code"));
		this.ProjectCreation.Experiment_Parameter_Name((String) ExpParameter.get("Parameter Name"));
		this.ProjectCreation.Experiment_Parameter_I_O_Dropdown();
		this.ProjectCreation.Experiment_Parameter_Input((String) ExpParameter.get("Input/Output"));
		this.ProjectCreation.Experiment_Parameter_Formula_dropdown();
		this.ProjectCreation.Experiment_Parameter_Formula_User_Entered((String) ExpParameter.get("User Entered/Formula"));
		if(((String) ExpParameter.get("User Entered/Formula")).equalsIgnoreCase("FORMULA"))
			this.ProjectCreation.enterFormulaForAExpparameter((String) ExpParameter.get("Formula"));

		this.ProjectCreation.Experiment_Parameter_TYPE_Dropdown();
		this.ProjectCreation.Experiment_Parameter_Type((String) ExpParameter.get("Type"));
		this.ProjectCreation.Experiment_Parameter_UOM();
		this.ProjectCreation.Experiment_Parameter_UOM_Values((String) ExpParameter.get("UOM"));
		//this.ProjectCreation.Experiment_Parameter_Description((String) ExpParameter.get("Description"));
		this.ProjectCreation.Experiment_Parameter_Save();
		test.log(Status.PASS, "Added Experiment Parameter "+(String) ExpParameter.get("Parameter Name"));

		}
		//Need to add assertions here
	}//TC_11
	
	@Test(priority = 12)
	public void TC_12() throws Exception {
		System.out.println("****************Method Starting: TC_12********************************");
		this.test = extent.createTest(
				" TS_CRD_5_1| TC_12(Navigate to notebook and create experiment");
		this.CompaneyName();
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
		test.createNode("Creating experiment");
		int sheetNum=Myutility.getSheetNumber("ExperimentPage");
		Map<String, Object> expData=Myutility.prepareRowData(1, sheetNum);
		System.out.println("Project Exp Data "+expData);
		Thread.sleep(5000);
		this.login((String) expData.get("UserName"),(String) expData.get("Password"));
		test.log(Status.PASS, "Loged In with UserId"+(String) expData.get("UserName"));
		navigateToNotebook((String) expData.get("Project Code"),(String) expData.get("NoteBooks"));
//		this.ProjectCreation.DropdownButton();
//		this.ProjectCreation.GetprojectName((String) expData.get("Project"));
//		Thread.sleep(3000);
//		this.ProjectCreation.Go_button();
//		projectNotebook.clickOnNotebook((String) expData.get("NoteBooks"));
		test.log(Status.PASS, "Navigated to Notebook"+(String) expData.get("NoteBooks"));

		projectUsers.clickExperimentTabNotebookLevel();
		ExperimentsPage.clickOnAddInExperiment();Thread.sleep(2000);

		ExperimentsPage.clickOnRoute();
		ExperimentsPage.slectRoute((String) expData.get("Route Initials"));
		Thread.sleep(2000);

		ExperimentsPage.clickOnStage();
		ExperimentsPage.slectStage((String) expData.get("Stage Initials"));
		Thread.sleep(2000);

		ExperimentsPage.clickOnEnterAIm();
		ExperimentsPage.enter_Aim("Aim is added");
		
		String expName=(String) expData.get("Project Code")+"/"+(String) expData.get("Route Initials")+(String) expData.get("Stage Initials")+"/"+(String) expData.get("NoteBooks");
		System.out.println(" Exp Name"+expName);
		ExperimentsPage.saveExperiment();
		//ExperimentsPage.cancelExperiment();Experiment Proj_1/ACETYL ROUTS1/Test_Nb/002 is added to notebook
		
		Assert.assertTrue(this.ExcelTemplate.GetTostMessageForNotebook().contains("is added to notebook")&&this.ExcelTemplate.GetTostMessageForNotebook().contains(expName));
		test.log(Status.PASS, "Created Experiment Successfully");
		Thread.sleep(2000);

	}//TC_12
	@Test(priority = 13)
	public void TC_13() throws Exception {
		System.out.println("****************Method Starting: TC_13********************************");
		this.test = extent.createTest(
				" TS_CRD_5_1 | TC_09(Navigate to experiment Edit fields and Save");
//		this.CompaneyName();
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("editing experiment specification.");
		int sheetNum=Myutility.getSheetNumber("ExperimentPage");
		Map<String, Object> expData=Myutility.prepareRowData(1, sheetNum);
		System.out.println("Project Exp Data "+expData);
		this.login((String) expData.get("UserName"),(String) expData.get("Password"));
		test.log(Status.PASS, "Loged In with UserId"+(String) expData.get("UserName"));
		navigateToNotebook((String) expData.get("Project Code"),(String) expData.get("NoteBooks"));
		projectUsers.clickExperimentTabNotebookLevel();
		
		ExperimentsPage.clickOnExpLink();
		Thread.sleep(4000);
		try {
			if(ExperimentsPage.isRestoreInformationPopupEnabled()) {
//				ExperimentsPage.clickOnYesInRestoreInformationPopup();
			ExperimentsPage.clickOnNoInRestoreInformationPopup();}
		}catch(Exception e) {
			test.log(Status.PASS, "Restore experiment InformationPopup not displayed");

		}
		createdExperiment=ExperimentsPage.getExperimentcode();
		test.log(Status.PASS, "Navigated to Created Experiment "+createdExperiment);

        System.out.println("expCode:"+createdExperiment);

		ExperimentsPage.clcikOnLinkInExpPage("Summary");
		Thread.sleep(2000);
		ExperimentsPage.clickOnEnterAImInExp();
		ExperimentsPage.enter_Aim((String) expData.get("Aim"));
		
		ExperimentsPage.clcikOnLinkInExpPage("Inputs");

		ExperimentsPage.clickOnInputsettings((String) expData.get("ChemicalName in Project"));//chemical name which we are going to change
		ExperimentsPage.clickOnEditInput();
		ExperimentsPage.enterVenderName((String) expData.get("Vendor Name"));Thread.sleep(2000);
		ExperimentsPage.enterBatchNoName((String) expData.get("Batch No"));Thread.sleep(2000);
		ExperimentsPage.enterMolWt((String) expData.get("Mol.Wt"));Thread.sleep(2000);
		ExperimentsPage.enterreqQty((String) expData.get("Required Qty"));Thread.sleep(2000);
		ExperimentsPage.enterreqQtyMsrUnit((String) expData.get("Required Qty weight"));Thread.sleep(2000);
//		ExperimentsPage.clickOncancel();
		ExperimentsPage.clickOnSave();
		test.log(Status.PASS, "Edited existing Input. ");

		ExperimentsPage.clickOnAddInput();
		ExperimentsPage.enterChemiacalName((String) expData.get("New ChemicalName"));Thread.sleep(2000);
		ExperimentsPage.enterVenderName((String) expData.get("Vendor Name"));Thread.sleep(2000);
		ExperimentsPage.enterBatchNoName((String) expData.get("Batch No"));Thread.sleep(2000);
		ExperimentsPage.enterMolWt((String) expData.get("Mol.Wt"));Thread.sleep(2000);
		ExperimentsPage.enterreqQty((String) expData.get("Required Qty"));Thread.sleep(2000);
		ExperimentsPage.enterreqQtyMsrUnit((String) expData.get("Required Qty weight"));Thread.sleep(2000);
//		ExperimentsPage.clickOncancel();
		ExperimentsPage.clickOnSave();
		test.log(Status.PASS, "Added new Input.");
		Thread.sleep(4000);
		ExperimentsPage.Input_Embedded_Excel();Thread.sleep(2000);
		ExperimentsPage.Embedded_Excel_Dropdown();Thread.sleep(2000);
		ExperimentsPage.Embedded_Excel_Template();Thread.sleep(2000);
		ExperimentsPage.Input_Embedded_Excel_Savebutton();Thread.sleep(2000);
		test.log(Status.PASS, "Added Embedded excel for Inputs");

		ExperimentsPage.clcikOnLinkInExpPage("Specific Equipments");
		Thread.sleep(2000);
		ExperimentsPage.clickOnAddEuipment();
		ExperimentsPage.equipment_manualentry_checkbox();
		ExperimentsPage.enterEquipmentType((String) expData.get("EquipType"));Thread.sleep(1000);
		ExperimentsPage.enterEquipmentName((String) expData.get("EquipName"));Thread.sleep(1000);
		ExperimentsPage.enterEquipmentCode((String) expData.get("EquipCode"));Thread.sleep(1000);
		ExperimentsPage.clickOnStartDateinEquip();
		ExperimentsPage.selectTodaysDate();Thread.sleep(1000);
		ExperimentsPage.clickOnEndtDateinEquip();
		ExperimentsPage.selectTodaysDate();Thread.sleep(1000);

		
		ExperimentsPage.clickOnSaveEquip();Thread.sleep(2000);
		//ExperimentsPage.clickOnCancelEquip();Thread.sleep(1000);
		test.log(Status.PASS, "Added new Equipment");

		ExperimentsPage.clcikOnLinkInExpPage("Precautions");
		Thread.sleep(2000);
		ExperimentsPage.enterPrecautionMnually((String) expData.get("PrecautionsManual"));Thread.sleep(2000);
		ExperimentsPage.clickOnAddPrecaution();
		test.log(Status.PASS, "Added new Precaution Manually.");

		String precaustions=(String) expData.get("PrecautionPreDefine");
		 String[] allprecaustions =precaustions.split(",");
	        
	        for (String precaustion : allprecaustions) {
	            System.out.println(precaustion);
	    		ExperimentsPage.selectPredefinePrecaution(precaustion);Thread.sleep(2000);
	    		test.log(Status.PASS, "Added existing Precaution from selecting checkbox. "+precaustion);
	        }
//		ExperimentsPage.selectPredefinePrecaution((String) expData.get("PrecautionPreDefine"));Thread.sleep(2000);
		ExperimentsPage.clickOnSavePrecaution();
		//ExperimentsPage.clickOnCancelPrecaution();
		test.log(Status.PASS, "Saved all the precautions selected an entered");


		
		ExperimentsPage.clcikOnLinkInExpPage("Attachments");
		
		Thread.sleep(2000);
		this.ExperimentsPage.clickOnUploadAttachments();
		Thread.sleep(2000);
		this.ProjectCreation.Entering_Attachment_password((String) expData.get("Password"));
		Thread.sleep(2000);
		this.ProjectCreation.Attachment_Auth_Confirm_Button();
		this.ProjectCreation.Attachment_File(this.Myutility.PDFPath());
		Thread.sleep(3000);
		this.ProjectCreation.Entering_Attachment_Name("PDF");
		this.ProjectCreation.Entering_Attachment_Description("Attachment Added Successfully");
		Thread.sleep(2000);
		//ProjectCreation.AttachmentPopUoCLose_Button();
		this.ProjectCreation.Attachment_Save_Button();Thread.sleep(2000);
		test.log(Status.PASS, "Saved Attachments");

		ExperimentsPage.clcikOnLinkInExpPage("Procedure and Observation");Thread.sleep(1000);
		ExperimentsPage.clickOnuploadExcel();
		ExperimentsPage.Embedded_Excel_Dropdown();Thread.sleep(1000);
		ExperimentsPage.Embedded_Excel_Template();Thread.sleep(1000);
		ExperimentsPage.Input_Embedded_Excel_Savebutton();Thread.sleep(1000);
		ExperimentsPage.clickOnDeleteExcel();Thread.sleep(1000);
		test.log(Status.PASS, "Uploaded and deleted Embedded excel for Procedure and Observation");

		
		ExperimentsPage.clickOnAddStepforProsedure();
		ExperimentsPage.enterProcedure((String) expData.get("Procedure"));Thread.sleep(2000);
		ExperimentsPage.clickOnSaveProcedure();Thread.sleep(2000);
		test.log(Status.PASS, "Saved the prosedure");

		ExperimentsPage.clickOnActionsForastep("1");
		ExperimentsPage.clickOnEditObservation();	
		ExperimentsPage.enterObservation((String) expData.get("Observation"));Thread.sleep(2000);
		ExperimentsPage.enterQtyInObservation((String) expData.get("Qty"));Thread.sleep(2000);
		ExperimentsPage.enterTempInObservation((String) expData.get("DegreeCentigrade"));Thread.sleep(2000);
		ExperimentsPage.clickOnstartDate();
		ExperimentsPage.selectTodaysDate();Thread.sleep(2000);
		ExperimentsPage.clickOnEndDate();
		ExperimentsPage.selectTodaysDate();Thread.sleep(2000);

		//ExperimentsPage.clickOnCancelObservation();
		ExperimentsPage.clickOnSaveObservation();
		test.log(Status.PASS, "Added Observation to the prosedure");

		ExperimentsPage.clickOnActionsForastep("1");
		ExperimentsPage.clickOnInsertStep();
		ExperimentsPage.enterProcedure((String) expData.get("Procedure"));Thread.sleep(1000);
		ExperimentsPage.clickOnSaveProcedure();Thread.sleep(1000);
		test.log(Status.PASS, "Added procedure through Insert step from Actions");

		ExperimentsPage.clickOnActionsForastep("1");
		ExperimentsPage.clickOnEditStep();
		ExperimentsPage.enterProcedure("Step Edited..");Thread.sleep(1000);
		ExperimentsPage.clickOnSaveEditProcedure();Thread.sleep(1000);
		test.log(Status.PASS, "Edited the recently added the prosedure from Actions");

		ExperimentsPage.clickOnActionsForastep("1");Thread.sleep(1000);

		ExperimentsPage.clickOnremoveStep();Thread.sleep(1000);
		ExperimentsPage.clickYesOnexpParameterRemove();Thread.sleep(1000);//this method working for removing step as well.
		test.log(Status.PASS, "Removed recently added the prosedure from Actions");

		ExperimentsPage.clickOnuploadRTF();Thread.sleep(1000);
		this.Myutility.Uploadfile(this.Myutility.uploadRTF2_FILEPath());Thread.sleep(5000);//uploading file which have 8steps
		test.log(Status.PASS, "Added the prosedure by uploading RTF file");

		ExperimentsPage.selectallRowsInObservations();Thread.sleep(1000);
		ExperimentsPage.clickOnRemoveforProsedure();Thread.sleep(3000);
		
		ExperimentsPage.clickOnuploadRTF();Thread.sleep(1000);
		this.Myutility.Uploadfile(this.Myutility.uploadRTF1_FILEPath());Thread.sleep(5000);//uploading file which have only one step
		ExperimentsPage.clickOnActionsForastep("2");Thread.sleep(1000);

		ExperimentsPage.clickOnEditObservation();	
		ExperimentsPage.enterObservation((String) expData.get("Observation"));Thread.sleep(2000);
		ExperimentsPage.enterQtyInObservation((String) expData.get("Qty"));Thread.sleep(2000);
		ExperimentsPage.enterTempInObservation((String) expData.get("DegreeCentigrade"));Thread.sleep(2000);
		ExperimentsPage.clickOnstartDate();
		ExperimentsPage.selectTodaysDate();Thread.sleep(2000);
		ExperimentsPage.clickOnEndDate();
		ExperimentsPage.selectTodaysDate();Thread.sleep(2000);

		//ExperimentsPage.clickOnCancelObservation();
		ExperimentsPage.clickOnSaveObservation();
		test.log(Status.PASS, "Saving the procedure which are uploaded by RTF file");

		Thread.sleep(3000);
		
		ExperimentsPage.clcikOnLinkInExpPage("Scheme");Thread.sleep(3000);
//		ExperimentsPage.clickOndeleteScheme();
		ExperimentsPage.clickOnuploadScheme();Thread.sleep(2000);
		this.Myutility.Uploadfile(this.Myutility.updateSVG_FILEPath()); 
		Thread.sleep(2000);
//		ExperimentsPage.clickOnDownloadScheme();
		Thread.sleep(2000);
		test.log(Status.PASS, "Uploaded Scheme file");

		ExperimentsPage.clcikOnLinkInExpPage("Exp.Parameters");
		int expParsheetNum=Myutility.getSheetNumber("ExpParameters");
		int rowCount = Myutility.getRowCount(expParsheetNum);

		for(int i = 4; i <= rowCount; i++) {//adding 2 prameters extra
		 Map<String, Object> expparmetersData=Myutility.prepareRowData(i, expParsheetNum);
		ExperimentsPage.clickOnAddExpParamtrs();
		ProjectCreation.Experiment_Parameter_Code((String) expparmetersData.get("Code"));Thread.sleep(1000);
		ProjectCreation.Experiment_Parameter_Name((String) expparmetersData.get("Parameter Name"));Thread.sleep(1000);
		ProjectCreation.Experiment_Parameter_I_O_Dropdown();Thread.sleep(1000);
		ProjectCreation.Experiment_Parameter_Input((String) expparmetersData.get("Input/Output"));Thread.sleep(1000);
		ProjectCreation.Experiment_Parameter_Formula_dropdown();Thread.sleep(1000);
		ProjectCreation.Experiment_Parameter_Formula_User_Entered((String) expparmetersData.get("User Entered/Formula"));Thread.sleep(1000);
		ProjectCreation.Experiment_Parameter_TYPE_Dropdown();Thread.sleep(1000);
		ProjectCreation.Experiment_Parameter_Type((String) expparmetersData.get("Type"));Thread.sleep(1000);

		ExperimentsPage.enterExperiment_Parameter_Value((String) expparmetersData.get("Value"));Thread.sleep(1000);
		ProjectCreation.Experiment_Parameter_UOM();Thread.sleep(1000);
		ProjectCreation.Experiment_Parameter_UOM_Values((String) expparmetersData.get("UOM"));Thread.sleep(1000);
		ExperimentsPage.clickOnSaveExpParamtrs();Thread.sleep(4000);
		//ExperimentsPage.clickOnClosetoastPopup();
		}//for
		test.log(Status.PASS, "Adding parameters inside Experiment");

		int numOfPar=ExperimentsPage.getTotalRowsCount();

		for(int i = numOfPar; i >=4; i--) {   //to remove last added parameters
		ExperimentsPage.selectrow(i);Thread.sleep(1000);
		}//for
		ExperimentsPage.clickOnDeleteExpParamtrs();Thread.sleep(1000);
		ExperimentsPage.clickYesOnexpParameterRemove();Thread.sleep(2000);
		test.log(Status.PASS, "Deleting newly added parameters inside Experiment");
		ExperimentsPage.selectallRows();
		ExperimentsPage.clickOnEditExpParamtrs();
		int sum=0;
		for(int i = 1; i <= 2; i++) {//entering values for starting 2 parameters which are given at project level.
			 Map<String, Object> expparmeterData=Myutility.prepareRowData(i, expParsheetNum);
			 ExperimentsPage.enterExperiment_Parameter_Value((String) expparmeterData.get("Value"),i);Thread.sleep(2000);
			 sum=sum+Integer.parseInt((String) expparmeterData.get("Value"));
		}//for
		System.out.println("Valuse of sum : "+sum);
		ExperimentsPage.clickOnSaveExpParamtrs();Thread.sleep(1000);
		ExperimentsPage.clickOnClosetoastPopup();Thread.sleep(1000);
		test.log(Status.PASS, "Added values to the Experement parameters");

		int parameterValue=Integer.parseInt(ExperimentsPage.getResultParameterofRow("3"));
		System.out.println("ParameterValue of 3rd row  : "+parameterValue);
		
		ExperimentsPage.clcikOnLinkInExpPage("TLC");Thread.sleep(1000);
		ExperimentsPage.clickOnUPloadTLC();Thread.sleep(2000);
		this.Myutility.Uploadfile(this.Myutility.uploadTLC_FilePath());
		Thread.sleep(3000);
		test.log(Status.PASS, "Uploaded file in TLC section");

		ExperimentsPage.clcikOnLinkInExpPage("Conclusion");
		ExperimentsPage.enterConclusion((String) expData.get("Conclusion"));
		test.log(Status.PASS, "Added Conclusion");
		
		boolean flag=saveExperimentNavigateToNotebook(expData);Thread.sleep(1000);
		Assert.assertTrue(flag, "Experiment saved sucessfully");
		test.log(Status.PASS, "Experiment saved sucessfully and Navigate back to Note Book");

		
	}//TC_13

	@Test(priority = 14)
	public void TC_14() throws Exception {
		System.out.println("****************Method Starting: TC_14********************************");
		this.test = extent.createTest(
				" TS_CRD_5_1| TC_13(Navigate to the saved experiment and send for Verification request )");
//		this.CompaneyName();
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
		test.createNode("Clicking on recently created experiment link ");
		int sheetNum=Myutility.getSheetNumber("ExperimentPage");
		 Map<String, Object> expData=Myutility.prepareRowData(1, sheetNum);
//			this.login((String) expData.get("UserName"),(String) expData.get("Password"));Thread.sleep(2000);
//			navigateToNotebook((String) expData.get("Project Code"),(String) expData.get("NoteBooks"));

		 ExperimentsPage.clickOnExperiments(createdExperiment);Thread.sleep(4000);
			try {
				if(ExperimentsPage.isRestoreInformationPopupEnabled()) {
//					ExperimentsPage.clickOnYesInRestoreInformationPopup();
				ExperimentsPage.clickOnNoInRestoreInformationPopup();}
			}catch(Exception e) {
				test.log(Status.PASS, "Restore experiment InformationPopup not displayed");
			}
		test.createNode("Sending Experiment for VERIFICATION REQUESTED");

		String expStatusafterSubVer=expSubmitVerification(expData,createdExperiment);
		Assert.assertEquals(expStatusafterSubVer, "VERIFICATION REQUESTED");
		test.log(Status.PASS, "Experiment sent for VERIFICATION REQUESTED sucessfully and Navigate back to Note Book");

	}//TC_14
	
	@Test(priority = 15)
	public void TC_15() throws Exception {
		System.out.println("****************Method Starting: TC_15********************************");

		this.test = extent.createTest(
				" TS_CRD_5_1| TC_13(Navigate to the saved experiment and send for Verification Rework )");
		int sheetNum=Myutility.getSheetNumber("ExperimentPage");
		 Map<String, Object> expData=Myutility.prepareRowData(1, sheetNum);
		test.createNode("Sending experiment for rework");
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();	
//		this.CompaneyName();
		this.login((String) expData.get("Verifier"),(String) expData.get("Password"));Thread.sleep(2000);
		//createdExperiment="";
		ExperimentsPage.slectVerificationIcon();
		ExperimentsPage.clickOnExpInVerReqstdPage(createdExperiment);
		ExperimentsPage.clickOnReturn();
		ExperimentsPage.enterReturnComments("Check section Attachments");
		this.ProjectCreation.Entering_password("Chemia@1234");

		ExperimentsPage.clickConfirmOnReturnForm();Thread.sleep(2000);
		if(ExperimentsPage.getSuccessMessage().equalsIgnoreCase("SUCCESS MESSAGE")) {
			ExperimentsPage.clickOnViewNotebook();Thread.sleep(4000);
			String expStatus=ExperimentsPage.getStatusOfExperiment(createdExperiment);
			System.out.println("Experiment Status"+expStatus);
			Assert.assertEquals(expStatus, "VERIFICATION REWORK");
		}
			test.log(Status.PASS, "Experiment sent for VERIFICATION REWORK sucessfully and Navigate back to Note Book");

	}//TC_15
	
	@Test(priority = 16)
	public void TC_16() throws Exception {
		System.out.println("****************Method Starting: TC_16********************************");
		this.test = extent.createTest(
				" TS_CRD_5_1| TC_13(Navigate to the experiment and Work on Rework )");
		int sheetNum=Myutility.getSheetNumber("ExperimentPage");
		 Map<String, Object> expData=Myutility.prepareRowData(1, sheetNum);
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();	
//		this.CompaneyName();
		this.login((String) expData.get("UserName"),(String) expData.get("Password"));Thread.sleep(2000);
		//createdExperiment="";
		test.createNode("Editing experiment for rework");
		ExperimentsPage.slectReworkExpIcon();Thread.sleep(2000);
		ExperimentsPage.clickOnExpInVerReqstdPage(createdExperiment);
		ExperimentsPage.clcikOnLinkInExpPage("Procedure and Observation");

		ExperimentsPage.clickOnActionsForastep("1");
		ExperimentsPage.clickOnEditObservation();	
		ExperimentsPage.enterObservation((String) expData.get("Observation"));Thread.sleep(2000);
		ExperimentsPage.clickOnSaveObservation();Thread.sleep(1000);
		test.log(Status.PASS, "Rework completed By editing Observation");

		test.createNode("Again Submitting for verification after rework");

		String expStatusafterSubVer=expSubmitVerification(expData,createdExperiment);
		Assert.assertEquals(expStatusafterSubVer, "VERIFICATION REQUESTED");
		test.log(Status.PASS, "Experiment sent for VERIFICATION REQUESTED sucessfully after rework and Navigate back to Note Book");

	}//TC_16
	
	@Test(priority = 17)
	public void TC_17() throws Exception {
		System.out.println("****************Method Starting: TC_17********************************");
		this.test = extent.createTest(
				" TS_CRD_5_1| TC_13(Navigate to the experiment and Veriying Submitted experiment By TL .)");
		int sheetNum=Myutility.getSheetNumber("ExperimentPage");
		 Map<String, Object> expData=Myutility.prepareRowData(1, sheetNum);
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();	
//		this.CompaneyName();
		this.login((String) expData.get("Verifier"),(String) expData.get("Password"));Thread.sleep(2000);
		//createdExperiment="";
		test.createNode("Verifying Submitted experiment By TL .");
		ExperimentsPage.slectVerificationIcon();Thread.sleep(1000);
		ExperimentsPage.clickOnExpInVerReqstdPage(createdExperiment);Thread.sleep(1000);

		String expStatusAfterVerify=verifyExperiment(expData,createdExperiment);
		System.out.println("Experiment Status"+expStatusAfterVerify);
		Assert.assertEquals(expStatusAfterVerify, "VERIFIED");test.log(Status.PASS, "Experiment sent for VERIFICATION REQUESTED sucessfully after rework and Navigate back to Note Book");
		test.log(Status.PASS, "Experiment Verified By TL and Navigate back to Note Book");
	}//TC_17
	
	@Test(priority = 18)
	public void TC_18() throws Exception {
		System.out.println("****************Method Starting: TC_18********************************");
		this.test = extent.createTest(
				" TS_CRD_5_1| TC_13(Navigate to the experiment and Submit By chemist )");
		int sheetNum=Myutility.getSheetNumber("ExperimentPage");
		 Map<String, Object> expData=Myutility.prepareRowData(1, sheetNum);
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();	
//		this.CompaneyName();
		this.login((String) expData.get("UserName"),(String) expData.get("Password"));Thread.sleep(2000);
		//createdExperiment="";
		test.createNode("Submitting verified experiment for Approval by chemist");
		ExperimentsPage.slectVerifiedIcon();Thread.sleep(2000);
		ExperimentsPage.clickOnExpInVerReqstdPage(createdExperiment);Thread.sleep(2000);
		try {
			if(ExperimentsPage.isRestoreInformationPopupEnabled())
				ExperimentsPage.clickOnYesInRestoreInformationPopup();
//			ExperimentsPage.clickOnNoInRestoreInformationPopup();
			}catch(Exception e) {
			test.log(Status.PASS, "Restore experiment InformationPopup not displayed");
			}	
		String expStatusAfterSubmit=submitExperimentToApprove(expData,createdExperiment);
		System.out.println("Experiment Status"+expStatusAfterSubmit);
		Assert.assertEquals(expStatusAfterSubmit, "SUBMITTED");
		test.log(Status.PASS, "Experiment sent for VERIFICATION REQUESTED sucessfully after rework and Navigate back to Note Book");

	}//TC_18
	
	@Test(priority = 19)
	public void TC_19() throws Exception {
		System.out.println("****************Method Starting: TC_19********************************");

		this.test = extent.createTest(
				" TS_CRD_5_1| TC_13(Navigate to the experiment and Approving Submitted experiment by TL.)");
		int sheetNum=Myutility.getSheetNumber("ExperimentPage");
		 Map<String, Object> expData=Myutility.prepareRowData(1, sheetNum);
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();	
//		this.CompaneyName();
		this.login((String) expData.get("Verifier"),(String) expData.get("Password"));Thread.sleep(2000);
		//createdExperiment="";
		test.createNode("Approving Submitted experiment by TL.");
		ExperimentsPage.slectAprovalIcon();Thread.sleep(1000);
		ExperimentsPage.clickOnExpInVerReqstdPage(createdExperiment);Thread.sleep(1000);
		String expStatusAfterrApprove=approveExperiment(expData,createdExperiment);
		System.out.println("Experiment Status"+expStatusAfterrApprove);
		Assert.assertEquals(expStatusAfterrApprove, "APPROVED");
		test.log(Status.PASS, "Experiment Approved By TL and Navigate back to Note Book");
	}//TC_19
	
	public void navigateToNotebook(String project,String noteBook) throws Exception {
		this.ProjectCreation.DropdownButton();
		this.ProjectCreation.GetprojectName(project);
		Thread.sleep(3000);
		this.ProjectCreation.Go_button();
		projectNotebook.clickOnNotebook(noteBook);
		projectUsers.clickExperimentTabNotebookLevel();
	}
	
	public void workOnCloneExperiment(Map<String, Object> cloneData,ExtentTest test) throws Exception {

		ExperimentsPage.clcikOnLinkInExpPage("Conclusion");
		ExperimentsPage.enterConclusion((String) cloneData.get("Conclusion"));
		ExperimentsPage.clcikOnLinkInExpPage("Summary");
		ExperimentsPage.clickOnReferenceExpCode();Thread.sleep(4000);
		String screenshortpath = CaptureScreenShot.GetScreenShort(driver, "Refrence Experiment ");
		test.addScreenCaptureFromPath(screenshortpath);
		
		ExperimentsPage.dragFocusToRefExpPopup();
		
		mainPage.closePopup();
		//saveExperimentNavigateToNotebook(cloneData);
		boolean flag=saveExperimentNavigateToNotebook(cloneData);Thread.sleep(1000);
		Assert.assertTrue(flag, "Experiment saved sucessfully");
		
	}//workOnCloneExperiment
	public boolean saveExperimentNavigateToNotebook(Map<String, Object> rowData) throws Exception {
		boolean flag = false;
		ExperimentsPage.clickOnExpsave();
		ExperimentsPage.enterSaveExpComments((String) rowData.get("Comments"));
		this.ProjectCreation.Entering_Attachment_password((String) rowData.get("Password"));
		Thread.sleep(2000);
		this.ProjectCreation.Attachment_Auth_Confirm_Button();Thread.sleep(3000);

		System.out.println("Sucess Message"+ExperimentsPage.getSuccessMessage());

		if(ExperimentsPage.getSuccessMessage().equalsIgnoreCase("SUCCESS MESSAGE")) {
			flag = true;
			ExperimentsPage.clickOnViewNotebook();Thread.sleep(1000);
		}//if
		else
			mainPage.closePopup();
		return flag;
	
	}//saveExperimentNavigateToNotebook
	
	private String approveExperiment(Map<String, Object> expData, String experimentCode) throws InterruptedException {
		ExperimentsPage.clickOnApprove();Thread.sleep(1000);
		ExperimentsPage.clickOnAimDropdown();Thread.sleep(1000);
		ExperimentsPage.slectAimAcheived((String) expData.get("Aimacheived"));Thread.sleep(1000);
		ExperimentsPage.enterApproveComments((String) expData.get("Comments"));Thread.sleep(1000);
		this.ProjectCreation.Entering_password((String) expData.get("Password"));
		ExperimentsPage.clickOnConfirmInForm();Thread.sleep(2000);
		String exptatusafterApproval = null;
		if(ExperimentsPage.getSuccessMessage().equalsIgnoreCase("SUCCESS MESSAGE")) {
		ExperimentsPage.clickOnViewNotebook();Thread.sleep(4000);
		exptatusafterApproval=ExperimentsPage.getStatusOfExperiment(experimentCode);
		System.out.println("Experiment Status "+exptatusafterApproval);
		}//if		
		return exptatusafterApproval;
	}//approveExperiment

	private String submitExperimentToApprove(Map<String, Object> expData, String experimentCode) throws InterruptedException {
		String expstatus = null;
		ExperimentsPage.clcikOnLinkInExpPage("Summary");Thread.sleep(1000);
		ExperimentsPage.clcikOnLinkInExpPage("Scheme");Thread.sleep(1000);
		ExperimentsPage.clcikOnLinkInExpPage("Inputs");Thread.sleep(1000);
		ExperimentsPage.clcikOnLinkInExpPage("Specific Equipments");Thread.sleep(1000);
		ExperimentsPage.clcikOnLinkInExpPage("Precautions");Thread.sleep(1000);
		ExperimentsPage.clcikOnLinkInExpPage("Procedure and Observation");Thread.sleep(1000);
		ExperimentsPage.clcikOnLinkInExpPage("TLC");Thread.sleep(1000);
		ExperimentsPage.clcikOnLinkInExpPage("Attachments");Thread.sleep(1000);
		ExperimentsPage.clcikOnLinkInExpPage("Exp.Parameters");Thread.sleep(1000);
		ExperimentsPage.clcikOnLinkInExpPage("Post Verification Remarks");Thread.sleep(1000);
//		ExperimentsPage.clickOnAddPostVerificationRemarks();Thread.sleep(1000);
//		ExperimentsPage.clickOnCancelEquip();//this method work to cancel Post Verification Remarks popup uncomment them

		ExperimentsPage.clickOnSubmitforaproval();
		ExperimentsPage.enterApproveComments((String) expData.get("Comments"));Thread.sleep(1000);
		ExperimentsPage.clickOnVerifierOrApproverdropdown();Thread.sleep(1000);
		ExperimentsPage.slectVerifierOrApprover((String) expData.get("Verifier"));Thread.sleep(1000);
		this.ProjectCreation.Entering_password((String) expData.get("Password"));
		ExperimentsPage.clickOnConfirmInForm();Thread.sleep(2000);
			if(ExperimentsPage.getSuccessMessage().equalsIgnoreCase("SUCCESS MESSAGE")) {
			ExperimentsPage.clickOnViewNotebook();Thread.sleep(4000);
			expstatus=ExperimentsPage.getStatusOfExperiment(experimentCode);
			System.out.println("Experiment Status "+expstatus);
			}		
		return expstatus;
	}//submitExperimentToApprove

	private String expSubmitVerification(Map<String, Object> expData,String experimentCode) throws InterruptedException {
		ExperimentsPage.clickOnSubmitVerification();Thread.sleep(1000);
		ExperimentsPage.enterVerificationComments((String) expData.get("Comments"));Thread.sleep(1000);
		ExperimentsPage.clickOnVerifierOrApproverdropdown();Thread.sleep(1000);
		ExperimentsPage.slectVerifierOrApprover((String) expData.get("Verifier"));Thread.sleep(1000);
		this.ProjectCreation.Entering_password((String) expData.get("Password"));

		ExperimentsPage.clickConfirmOnUserVerForm();Thread.sleep(3000);
		String expStatus=null;
	
			if(ExperimentsPage.getSuccessMessage().equalsIgnoreCase("SUCCESS MESSAGE")) {
			ExperimentsPage.clickOnViewNotebook();Thread.sleep(4000);
			expStatus=ExperimentsPage.getStatusOfExperiment(experimentCode);
			System.out.println("Experiment Status"+expStatus);
			}
	
		return expStatus;
	}//expSubmitVerification
	private String verifyExperiment(Map<String, Object> expData,String experimentCode) throws InterruptedException {
	ExperimentsPage.clickOnVerify();Thread.sleep(1000);
	this.ProjectCreation.Entering_password((String) expData.get("Password"));
	ExperimentsPage.clickOnConfirmInForm();Thread.sleep(2000);
	String expStatusAfetrVerify=null;

		if(ExperimentsPage.getSuccessMessage().equalsIgnoreCase("SUCCESS MESSAGE")) {
				ExperimentsPage.clickOnViewNotebook();Thread.sleep(4000);
				expStatusAfetrVerify=ExperimentsPage.getStatusOfExperiment(experimentCode);
				System.out.println("Experiment Status"+expStatusAfetrVerify);
		}//if
	return expStatusAfetrVerify;
	}//verifyExperiment
	@Test(priority = 1)
	public void TC_CloneExperiment() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_03_CompleteFlow | TC_CloneExperiment(Navigate to approved experiment and validate clone functionality for same project and notebook");
		this.CompaneyName();
////		this.logout();Thread.sleep(1000);
////		driver.navigate().refresh();
		int sheetNum=Myutility.getSheetNumber("cloneandother");
		 Map<String, Object> cloneData=Myutility.prepareRowData(1, sheetNum);
		test.createNode("Navigate to approved experiment");
		this.login((String) cloneData.get("UserName"),(String) cloneData.get("Password"));

		
		System.out.println("Project Clone Data "+cloneData);
		Thread.sleep(5000);
		navigateToNotebook((String) cloneData.get("Project"),(String) cloneData.get("NoteBooks"));
		test.createNode("Add highlights to an experiment");

		ExperimentsPage.selectCheckBoxforApprovedExp((String) cloneData.get("CloneExpCode"));
		ExperimentsPage.clickOnHighlight();Thread.sleep(1000);
		ExperimentsPage.enterHighlightedComments((String) cloneData.get("Comments"));Thread.sleep(1000);
		ExperimentsPage.clickOnSaveHighlitedComments();Thread.sleep(1000);
		Assert.assertEquals(this.ExcelTemplate.GetTostMessageForNotebook(), "Selected Experiment(s) has been highlighted successfully!");//method works to get toast message text.
		test.createNode("Remove highlights of an experiment");

		ExperimentsPage.clickOneditHighlightComments((String) cloneData.get("CloneExpCode"));
		ExperimentsPage.clickOnCancelHighlitedComments();Thread.sleep(1000);
		ExperimentsPage.clickOnDeleteHighlightComments((String) cloneData.get("CloneExpCode"));Thread.sleep(1000);
		ExperimentsPage.clickOnYesDeletelHighlitedCommentsPopup();Thread.sleep(1000);
		Assert.assertEquals(this.ExcelTemplate.GetTostMessageForNotebook(), "Experiment is removed from highlighted!");Thread.sleep(1000);
		Thread.sleep(1000);
		test.createNode("Validate export PDF functionality");
		ExperimentsPage.selectCheckBoxforApprovedExp((String) cloneData.get("CloneExpCode"));
		ExperimentsPage.clickOnView();
		ExperimentsPage.clickOnexportPDF();Thread.sleep(10000);//taking much time to download need to implement fluent wait here
		String downloadsPath=this.Myutility.downloads_path();
		if(ExperimentsPage.isfiledownloaded(downloadsPath)) {
			String fileName=ExperimentsPage.getFileName(downloadsPath);
			System.out.println("The Name of the file downloaded is"+fileName);
			this.driver.get(downloadsPath+"/"+fileName);Thread.sleep(8000);
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, "downloaded export PDF File");

			this.driver.navigate().back();	Thread.sleep(4000);
			test.addScreenCaptureFromPath(screenshortpath);

		}
		test.createNode("Validate clone functionality for the same project");

		ExperimentsPage.clickOnClone();Thread.sleep(1000);
		ExperimentsPage.clickOnConfirmInForm();Thread.sleep(2000);
		if(ExperimentsPage.getSuccessMessage().equalsIgnoreCase("SUCCESS MESSAGE")) {
			ExperimentsPage.clickOnModifyCloneExpInNotebook();Thread.sleep(4000);
			String ExpCode=ExperimentsPage.getExperimentcode();
			System.out.println("Experiment code "+ExpCode);
			String refExpCode=ExperimentsPage.getRefExperimentcode();
			System.out.println("Reference Experiment code "+refExpCode);
			workOnCloneExperiment(cloneData,test);

			Assert.assertEquals((String) cloneData.get("CloneExpCode"),refExpCode);
		}//if
		else
			mainPage.closePopup();
//		mainPage.logout();	
	}//TC_CloneExperiment for same project and notebook
	
	
	
	@Test(priority = 2)
	public void TC_CloneExperimentforAnotheProject() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_03_CompleteFlow | TC_CloneExperiment(Navigate to approved experiment and validate clone functionality for another project and notebook");
//		this.CompaneyName();
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		int sheetNum=Myutility.getSheetNumber("cloneandother");
		 Map<String, Object> cloneData=Myutility.prepareRowData(1, sheetNum);
//		test.createNode("Navigate to approved experiment");
		this.login((String) cloneData.get("UserName"),(String) cloneData.get("Password"));
//
//		
//		System.out.println("Project Clone Data "+cloneData);
//		Thread.sleep(5000);
//		
		navigateToNotebook((String) cloneData.get("Project"),(String) cloneData.get("NoteBooks"));
		 
//		projectUsers.clickOnProjectbreadcrumb((String) cloneData.get("NoteBooks"));
		ExperimentsPage.selectCheckBoxforApprovedExp((String) cloneData.get("CloneExpCode"));
		ExperimentsPage.clickOnView();
		test.createNode("Validate clone functionality for another project and notebook");

		ExperimentsPage.clickOnClone();Thread.sleep(1000);
		ExperimentsPage.disableCheckBoxClonePopup();
		ExperimentsPage.clickOnProjectdropdown();
		ExperimentsPage.slectValue((String) cloneData.get("clnDifProject"));
		ExperimentsPage.clickOnNoteBookDropdown();
		ExperimentsPage.slectValue((String) cloneData.get("clnProj-notebook"));
		ExperimentsPage.clickOnRoute();
		ExperimentsPage.slectValue((String) cloneData.get("Route Initials"));
		ExperimentsPage.clickOnStage();
		ExperimentsPage.slectValue((String) cloneData.get("Stage Initials"));

		ExperimentsPage.clickOnConfirmInForm();Thread.sleep(2000);
		if(ExperimentsPage.getSuccessMessage().equalsIgnoreCase("SUCCESS MESSAGE")) {
			ExperimentsPage.clickOnModifyCloneExpInNotebook();Thread.sleep(4000);
			String ExpCode=ExperimentsPage.getExperimentcode();
			System.out.println("Experiment code "+ExpCode);
			String refExpCode=ExperimentsPage.getRefExperimentcode();
			System.out.println("Experiment code "+refExpCode);
			workOnCloneExperiment(cloneData,test);
			
			Assert.assertEquals((String) cloneData.get("CloneExpCode"), refExpCode);
			Assert.assertNotEquals(ExpCode.substring(0, ExpCode.length()-3), refExpCode.substring(0, refExpCode.length()-3));
				
		}//if
		else
			mainPage.closePopup();
		
//		mainPage.logout();Thread.sleep(1000);

	}//TC_CloneExperimentforAnotheProject
	
	@Test(priority = 3)
	public void TC_UnlockandApproveExperiment() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_03_CompleteFlow | TC_UnlockExperiment(Navigate to approved experiment and validate unlock functionality and process the flow till approve.");
//		this.CompaneyName();
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		int sheetNum=Myutility.getSheetNumber("cloneandother");
		 Map<String, Object> unLockExpData=Myutility.prepareRowData(1, sheetNum);
		test.createNode("Navigate to approved experiment and Requesy for unlcok");
		this.login((String) unLockExpData.get("UserName"),(String) unLockExpData.get("Password"));
		System.out.println("Project Clone Data "+unLockExpData);
		Thread.sleep(3000);
		String expCode=(String) unLockExpData.get("UnlockExpCode");
		this.ProjectCreation.Clickingonhomebutton();

		navigateToNotebook((String) unLockExpData.get("Project"),(String) unLockExpData.get("NoteBooks"));
		ExperimentsPage.selectCheckBoxforApprovedExp(expCode);
		ExperimentsPage.clickOnView();Thread.sleep(2000);
		ExperimentsPage.clickOnUnlokRequest();
		ExperimentsPage.enterCommentsForApproval((String) unLockExpData.get("Comments"));Thread.sleep(2000);
		ExperimentsPage.clickOnConfirmInForm();Thread.sleep(2000);
		if(ExperimentsPage.getSuccessMessage().equalsIgnoreCase("SUCCESS MESSAGE")) {
		ExperimentsPage.clickOnViewNotebook();Thread.sleep(4000);
		ExperimentsPage.selectCheckBoxforApprovedExp(expCode);
		ExperimentsPage.clickOnEvent();Thread.sleep(2000);
		String expEventDetail=ExperimentsPage.getExperementUnlockEventDetail();
		System.out.println("Experiment event Detail: "+expEventDetail);

		//Assert.assertTrue(expEventDetail.contains("Unlock requested for experiment "+expCode));
		}
		mainPage.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Process the experiment for Unlock");

		this.login((String) unLockExpData.get("CRDHOD"),(String) unLockExpData.get("Password"));
		Thread.sleep(2000);

		ExperimentsPage.slectUnlockExpIcon();Thread.sleep(3000);
		ExperimentsPage.selectCheckBoxforUnclokExp(expCode);
		ExperimentsPage.clickOnProcessForUnclokExp();
		Assert.assertEquals(this.ExcelTemplate.GetTostMessageForNotebook(), "Experiment is Unlocked Successfully.");
		navigateToNotebook((String) unLockExpData.get("Project"),(String) unLockExpData.get("NoteBooks"));
		String expStatusAfterUnlocked=ExperimentsPage.getStatusOfExperiment(expCode);
		System.out.println("Experiment Status after Unlocked"+expStatusAfterUnlocked);
		Assert.assertEquals(expStatusAfterUnlocked, "UNLOCKED");
		
		mainPage.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		this.login((String) unLockExpData.get("UserName"),(String) unLockExpData.get("Password"));
		Thread.sleep(2000);
		
		//navigateToNotebook((String) unLockExpData.get("Project"),(String) unLockExpData.get("NoteBooks"));
		ExperimentsPage.slectUnlockIcon();Thread.sleep(1000);

		ExperimentsPage.clickOnExpInVerReqstdPage(expCode);Thread.sleep(2000);//Works for unlock exp.Clicks as well
		try {
			if(ExperimentsPage.isRestoreInformationPopupEnabled()) {
//				ExperimentsPage.clickOnYesInRestoreInformationPopup();
			ExperimentsPage.clickOnNoInRestoreInformationPopup();}

	
		}catch(Exception e) {
			test.log(Status.PASS, "Restore experiment InformationPopup not displayed");

		}
		
		ExperimentsPage.clcikOnLinkInExpPage("Exp.Parameters");
		int expParsheetNum=Myutility.getSheetNumber("ExpParameters");
		ExperimentsPage.selectallRows();
		ExperimentsPage.clickOnEditExpParamtrs();
		for(int i = 1; i <= 2; i++) {//entering values for starting 2 parameters which are given at project level.
			 Map<String, Object> expparmeterData=Myutility.prepareRowData(i, expParsheetNum);
			 ExperimentsPage.enterExperiment_Parameter_Value((String) expparmeterData.get("ValuesForUnlcok"),i);Thread.sleep(2000);
		}//for

		ExperimentsPage.clickOnSaveExpParamtrs();Thread.sleep(1000);
		ExperimentsPage.clickOnClosetoastPopup();Thread.sleep(1000);

		int parameterValue=Integer.parseInt(ExperimentsPage.getResultParameterofRow("3"));
		System.out.println("ParameterValue of 3rd row  : "+parameterValue);
		
		saveExperimentNavigateToNotebook(unLockExpData);Thread.sleep(1000);
		ExperimentsPage.clickOnExperiments(expCode);Thread.sleep(1000);
		try {
			if(ExperimentsPage.isRestoreInformationPopupEnabled()) {
//				ExperimentsPage.clickOnYesInRestoreInformationPopup();
			ExperimentsPage.clickOnNoInRestoreInformationPopup();}
		}catch(Exception e) {
			test.log(Status.PASS, "Restore experiment InformationPopup not displayed");
		}
		String expStatusafterSubVer=expSubmitVerification(unLockExpData,expCode);
		Assert.assertEquals(expStatusafterSubVer, "VERIFICATION REQUESTED");
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Veriying Submitted experiment By TL .");

		this.login((String) unLockExpData.get("Verifier"),(String) unLockExpData.get("Password"));
		ExperimentsPage.slectVerificationIcon();Thread.sleep(1000);
		ExperimentsPage.clickOnExpInVerReqstdPage(expCode);Thread.sleep(1000);

		String expStatusAfterVerify=verifyExperiment(unLockExpData,expCode);
		System.out.println("Experiment Status"+expStatusAfterVerify);
		Assert.assertEquals(expStatusAfterVerify, "VERIFIED");
		
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();

		test.createNode("Submitting verified experiment for Approval by chemist");
		this.login((String) unLockExpData.get("UserName"),(String) unLockExpData.get("Password"));
		
		ExperimentsPage.slectVerifiedIcon();Thread.sleep(2000);
		ExperimentsPage.clickOnExpInVerReqstdPage(expCode);Thread.sleep(2000);
		try {
			if(ExperimentsPage.isRestoreInformationPopupEnabled())
				ExperimentsPage.clickOnYesInRestoreInformationPopup();
//			ExperimentsPage.clickOnNoInRestoreInformationPopup();
			}catch(Exception e) {
			test.log(Status.PASS, "Restore experiment InformationPopup not displayed");
			}	
		String expStatusAfterSubmit=submitExperimentToApprove(unLockExpData,expCode);
		System.out.println("Experiment Status"+expStatusAfterSubmit);
		Assert.assertEquals(expStatusAfterSubmit, "SUBMITTED");
		
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Approving Submitted experiment by TL.");
		this.login((String) unLockExpData.get("Verifier"),(String) unLockExpData.get("Password"));
		
		ExperimentsPage.slectAprovalIcon();Thread.sleep(1000);
		ExperimentsPage.clickOnExpInVerReqstdPage(expCode);Thread.sleep(1000);
		String expStatusAfterrApprove=approveExperiment(unLockExpData,expCode);
		System.out.println("Experiment Status"+expStatusAfterrApprove);
		Assert.assertEquals(expStatusAfterrApprove, "APPROVED");

	}//TC_UnlockExperiment
	
	@Test(priority = 4)
		public void TC_ExperimentsEventsAndHistory() throws Exception {
			this.test = extent.createTest(
					"TS_Chemia_CRD_03_CompleteFlow | TC_ExperimentsEvents(Navigate to approved experiment and validate Events scenarios: Event Type,User,Start Date and End Date also History functonality");
//			this.CompaneyName();
			this.logout();Thread.sleep(1000);
			driver.navigate().refresh();
			int sheetNum=Myutility.getSheetNumber("cloneandother");
			 Map<String, Object> unLockExpData=Myutility.prepareRowData(1, sheetNum);
			test.createNode("Navigate to approved experiment Events");
			this.login((String) unLockExpData.get("UserName"),(String) unLockExpData.get("Password"));
			
			navigateToNotebook((String) unLockExpData.get("Project"),(String) unLockExpData.get("NoteBooks"));
			ExperimentsPage.selectCheckBoxforApprovedExp((String) unLockExpData.get("ApprovedExp"));
			ExperimentsPage.clickOnEvent();Thread.sleep(3000);
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, "Events of Experiment");
			test.addScreenCaptureFromPath(screenshortpath);
			String expEvents=(String) unLockExpData.get("EventType");
			 String[] allEvents =expEvents.split(",");
		        
		        for (String event : allEvents) {
		            System.out.println("Event name : "+event);
		        	ExperimentsPage.clickOnEventTypedropdown();Thread.sleep(1000);
		            try {
		    		ExperimentsPage.slectValue(event);Thread.sleep(1000);
		    		ExperimentsPage.clcikOnGo();Thread.sleep(1000);
		    		String screenshortpath1 = CaptureScreenShot.GetScreenShort(driver, event+" Event of Experiment");
		    		test.addScreenCaptureFromPath(screenshortpath1);
		    		}
		            catch(Exception e) {
			            System.out.println(event+" Event is not there");
		            }
		    	 }//for
		        
				driver.navigate().refresh();
	        	ExperimentsPage.clickOnEventTypedropdown();Thread.sleep(1000);
	    		ExperimentsPage.slectValue("All");Thread.sleep(1000);
	    		String startDate=(String) unLockExpData.get("StartDate");
	    		ExperimentsPage.clickOnStartDateForEvents();Thread.sleep(1000);
	    		String[] sdate =startDate.split(",");
	    		ExperimentsPage.selectDate(Integer.parseInt(sdate[0]), Integer.parseInt(sdate[1]), Integer.parseInt(sdate[2]));Thread.sleep(1000);
	    		ExperimentsPage.clickOnEndDateforEvents();Thread.sleep(1000);
	    		
	    		String endDate=(String) unLockExpData.get("EndDate");
	    		String[] edate =endDate.split(",");
	    		ExperimentsPage.selectDate(Integer.parseInt(edate[0]), Integer.parseInt(edate[1]), Integer.parseInt(edate[2]));Thread.sleep(1000);
	    		ExperimentsPage.clcikOnGo();Thread.sleep(1000);
	    		String screenshortpat = CaptureScreenShot.GetScreenShort(driver, " Events of an Experiment in time frame");
		    		test.addScreenCaptureFromPath(screenshortpat);
				driver.navigate().refresh();

	    		String eventUsers=(String) unLockExpData.get("EventUsers");
	   		 String[] allusers =eventUsers.split(",");
	   	        
	   	        for (String user : allusers) {
	   	            System.out.println("User name : "+user);
	   	        	ExperimentsPage.clickOnUserDropdownInEvents();Thread.sleep(1000);
	   	            try {
	   	    		ExperimentsPage.slectValue(user);Thread.sleep(1000);
	   	    		ExperimentsPage.clcikOnGo();Thread.sleep(1000);
	   	    		String screenshortpath1 = CaptureScreenShot.GetScreenShort(driver, user+" related actions on an Experiment");
	   	    		test.addScreenCaptureFromPath(screenshortpath1);
	   	    		}
	   	            catch(Exception e) {
	   		            System.out.println(user+" User is not there");
	   	            }
	   	    	 }//for
	   	       
	   	        this.ProjectCreation.Clickingonhomebutton();Thread.sleep(1000);
	   			driver.navigate().refresh();

	   			test.createNode("Navigate to an experiment History to check versions");
	   			navigateToNotebook((String) unLockExpData.get("Project"),(String) unLockExpData.get("NoteBooks"));

//	   			projectUsers.clickOnProjectbreadcrumb((String) unLockExpData.get("NoteBooks"));
	   			ExperimentsPage.selectCheckBoxforApprovedExp((String) unLockExpData.get("ApprovedExp"));
	   			ExperimentsPage.clickOnHistory();Thread.sleep(1000);
	   			ExperimentsPage.clickOnVersionComparison();Thread.sleep(1000);
	   			ExperimentsPage.clickOnModifiedVersionDropdown();Thread.sleep(1000);
	   			ExperimentsPage.slectValueInModifiedDropdown();Thread.sleep(1000);
	   			ExperimentsPage.clickOnRefversionDropdown();Thread.sleep(1000);
	   			ExperimentsPage.slectValueInRefdropdown();Thread.sleep(1000);
	   			ExperimentsPage.clickOnCompare();Thread.sleep(1000);
	   			ExperimentsPage.scrollTopVersion();
	   			ExperimentsPage.scrollBottomVersion();
			
		}//TC_ExperimentsEvents
		
//		@Test(groups = "smoke", priority = 1)
//		
//		public void TC_SearchFunctonality_GeneralSearch() throws Exception {
//			test = extent.createTest(
//					"TS_Chemia_CRD_03_CompleteFlow | TC_SearchFunctonality(Navigate to search and check different search functionalities)");
//			this.CompaneyName();
////			this.logout();Thread.sleep(1000);
////			driver.navigate().refresh();
//			int searchDataSheetNum=Myutility.getSheetNumber("Search Data");
//			 Map<String, Object> searchData=Myutility.prepareRowData(1, searchDataSheetNum);
//			test.createNode("Navigate to Search page and check General Search Project functionality");
//			
//			this.login((String) searchData.get("UserName"),(String) searchData.get("Password"));
//			ProjectCreation.Clickingonsearch();Thread.sleep(3000);
//			ExperimentsPage.ClickingonGensearch();Thread.sleep(3000);
//			ExperimentsPage.enterDataForsearchmin3char("tes");Thread.sleep(1000);
//			ExperimentsPage.ClickingonSearch();Thread.sleep(1000);
//			ExperimentsPage.ClickingonMatchingProjects();Thread.sleep(1000);
//			String screenshortpath1 = CaptureScreenShot.GetScreenShort(driver, "Matching Projects Data");
//			test.addScreenCaptureFromPath(screenshortpath1);
//			ExperimentsPage.ClickingonMatchingNotebooks();Thread.sleep(1000);
//			String screenshortpath2 = CaptureScreenShot.GetScreenShort(driver, "Matching Notebooks Data");
//			test.addScreenCaptureFromPath(screenshortpath2);
//			ExperimentsPage.ClickingonMatchingExperiments();Thread.sleep(1000);
//			String screenshortpath3 = CaptureScreenShot.GetScreenShort(driver, "Matching Experiments Data");
//			test.addScreenCaptureFromPath(screenshortpath3);
//		}//TC_SearchFunctonality_GeneralSearch
//	@Test(groups = "smoke", priority = 2)
//		
//		public void TC_SearchFunctonality_Criteria_SearchProjects() throws Exception {
//			this.test = extent.createTest(
//					"TS_Chemia_CRD_03_CompleteFlow | TC_SearchFunctonality(Navigate to search and check different search functionalities)");
////			this.CompaneyName();
////			this.logout();Thread.sleep(1000);
////			driver.navigate().refresh();
//			int searchDataSheetNum=Myutility.getSheetNumber("Search Data");
//			 Map<String, Object> searchData=Myutility.prepareRowData(1, searchDataSheetNum);
//			test.createNode("Check Search Project functionality In Criteria Search");
//			ExperimentsPage.Clickingoncriteriasearch();Thread.sleep(1000);
//			ExperimentsPage.Clickingonsearchprojectbutton();Thread.sleep(1000);
//			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, "Clciked on search Project radio Button");
//			test.addScreenCaptureFromPath(screenshortpath);
//			
//					String projectCodes=(String) searchData.get("Project Code");
//					String[] allprojectCodes =projectCodes.split(",");
//		        
//			        for (String projectCode : allprojectCodes) {
//			            System.out.println("Project code is : "+projectCode);
//			            try {
//				        	ExperimentsPage.ClickingonProjectCodeANdSelect(projectCode);Thread.sleep(1000);
//				        	ExperimentsPage.ClickingonprojectSearchImg();
//			    		String screenshortpath4 = CaptureScreenShot.GetScreenShort(driver, projectCode+" data");
//			    		test.addScreenCaptureFromPath(screenshortpath4);
//			    		}
//			            catch(Exception e) {
//				            System.out.println(projectCode+" Project Code is not there");
//			            }
//			    	 }//for
//					
//					ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);
//					ExperimentsPage.Clickingonsearchprojectbutton();Thread.sleep(1000);//for refresh page using these lines
//
//			        String productNames=(String) searchData.get("Product Name");
//			        String[] allproductNames =productNames.split(",");
//				        
//				    for (String productName : allproductNames) {
//				            System.out.println("Product Name is : "+productName);
//				            try {
//					        	ExperimentsPage.enterProductName(productName);Thread.sleep(1000);
//					        	ExperimentsPage.ClickingonprojectSearchImg();
//				    		String screenshortpath5 = CaptureScreenShot.GetScreenShort(driver, productName+" data");
//				    		test.addScreenCaptureFromPath(screenshortpath5);
//				    		}
//				            catch(Exception e) {
//					            System.out.println(productName+" Product Name is not there");
//				            }
//				   }//for
//				    ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);
//					ExperimentsPage.Clickingonsearchprojectbutton();Thread.sleep(1000);//for refresh page using these lines
//
//				    String statusTypes=(String) searchData.get("Project Status");
//				    String[] allstatusTypes =statusTypes.split(",");
//					        
//					        for (String statusType : allstatusTypes) {
//					            System.out.println("Status Type is : "+statusType);
//					            try {
//						        	ExperimentsPage.ClickingonprojectstatusANdSelect(statusType);Thread.sleep(1000);
//						        	ExperimentsPage.ClickingonprojectSearchImg();
//					    		String screenshortpath6= CaptureScreenShot.GetScreenShort(driver, statusType+" data");
//					    		test.addScreenCaptureFromPath(screenshortpath6);
//					    		}
//					            catch(Exception e) {
//						            System.out.println(statusType+" Status Type is not there");
//					            }
//					    	 }//for
//					 ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);
//					 ExperimentsPage.Clickingonsearchprojectbutton();Thread.sleep(1000);//for refresh page using these lines
//	        
//					 String users=(String) searchData.get("CraetedBy");
//					 String[] allUsers =users.split(",");
//						        
//						     for (String user : allUsers) {
//						    	 System.out.println("The User is : "+user);
//						        try {
//							       ExperimentsPage.enterCreatedBy(user);Thread.sleep(1000);
//							       ExperimentsPage.ClickingonprojectSearchImg();
//						    	String screenshortpath7 = CaptureScreenShot.GetScreenShort(driver, "Created By "+user+" data");
//						    	test.addScreenCaptureFromPath(screenshortpath7);
//						    	}
//						        catch(Exception e) {
//							    System.out.println(user+" User is not there");
//						        }
//						     }//for
//	}//TC_SearchFunctonality_Criteria_SearchProjects
//	@Test(groups = "smoke", priority = 3)
//
//	public void TC_SearchFunctonality_Criteria_SearchExperiments() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_03_CompleteFlow | TC_SearchFunctonality(Navigate to search and check different search functionalities)");
//		
//					int searchDataSheetNum=Myutility.getSheetNumber("Search Data");
//					Map<String, Object> searchDataForexperiment=Myutility.prepareRowData(2, searchDataSheetNum);
//					test.createNode("Validate Search Experiments functionality in Criteria Search");
//					ExperimentsPage.Clickingoncriteriasearch();Thread.sleep(1000);
//
//					ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);
//					ExperimentsPage.ClickingonProductNameANdSelect((String) searchDataForexperiment.get("Project Code"));Thread.sleep(1000);
//					ExperimentsPage.ClickingonExpSearchImg();Thread.sleep(1000);
//					String projectCodepath = CaptureScreenShot.GetScreenShort(driver, "Project Code data in Search Project");
//			    	test.addScreenCaptureFromPath(projectCodepath);
//					ExperimentsPage.ClickingonRouteANdSelect((String) searchDataForexperiment.get("Route"));
//					ExperimentsPage.ClickingonExpSearchImg();Thread.sleep(1000);
//					String routeScreenpath = CaptureScreenShot.GetScreenShort(driver, "Route data in Search Project");
//			    	test.addScreenCaptureFromPath(routeScreenpath);
//					ExperimentsPage.ClickingonStageANdSelect((String) searchDataForexperiment.get("Stage"));
//					ExperimentsPage.ClickingonExpSearchImg();Thread.sleep(1000);
//					String stageScreenpath = CaptureScreenShot.GetScreenShort(driver, "Stage data in Search Project");
//			    	test.addScreenCaptureFromPath(stageScreenpath);
//
//					ExperimentsPage.Clickingonsearchprojectbutton();Thread.sleep(1000);
//					ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);//for refresh page using these lines
//					
//					ExperimentsPage.enterExpCode((String) searchDataForexperiment.get("CloneExpCode"));
//					ExperimentsPage.ClickingonExpSearchImg();Thread.sleep(1000);
//					String expCodeScreenpath = CaptureScreenShot.GetScreenShort(driver, "Expcode data in Search Project");
//			    	test.addScreenCaptureFromPath(expCodeScreenpath);
//					
//					ExperimentsPage.Clickingonsearchprojectbutton();Thread.sleep(1000);
//					ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);//for refresh page using these lines
//					
//					ExperimentsPage.ClickingonProductNameANdSelect((String) searchDataForexperiment.get("Project Code"));Thread.sleep(1000);
//					ExperimentsPage.ClickingonCreatedByANdSelect((String) searchDataForexperiment.get("CraetedBy"));
//					ExperimentsPage.ClickingonExpSearchImg();Thread.sleep(1000);
//					String createdByScreenpath = CaptureScreenShot.GetScreenShort(driver, "Craeted By data in Search Project");
//			    	test.addScreenCaptureFromPath(createdByScreenpath);
//			    	
//			    	ExperimentsPage.Clickingonsearchprojectbutton();Thread.sleep(1000);
//					ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);//for refresh page using these lines
//
//					ExperimentsPage.ClickingonProductNameANdSelect((String) searchDataForexperiment.get("Project Code"));Thread.sleep(1000);
//					ExperimentsPage.ClickingonApprovedByANdSelect((String) searchDataForexperiment.get("Approved By"));
//					ExperimentsPage.ClickingonExpSearchImg();Thread.sleep(1000);
//					String approvedByScreenpath = CaptureScreenShot.GetScreenShort(driver, "Approved By data in Search Project");
//			    	test.addScreenCaptureFromPath(approvedByScreenpath);
//			    	
//			    	ExperimentsPage.Clickingonsearchprojectbutton();Thread.sleep(1000);
//					ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);//for refresh page using these lines
//					
//			    	String startDate=(String) searchDataForexperiment.get("From Date");
//		    		ExperimentsPage.clickOnFromDate();Thread.sleep(1000);
//		    		String[] sdate =startDate.split(",");
//		    		ExperimentsPage.selectDate(Integer.parseInt(sdate[0]), Integer.parseInt(sdate[1]), Integer.parseInt(sdate[2]));Thread.sleep(1000);
//		    		ExperimentsPage.ClickingonExpSearchImg();Thread.sleep(1000);
//					String startDatePath = CaptureScreenShot.GetScreenShort(driver, "Start Date related data in Search Project");
//			    	test.addScreenCaptureFromPath(startDatePath);
//			    	
//		    		String endDate=(String) searchDataForexperiment.get("To Date");
//		    		ExperimentsPage.clickOnToDate();Thread.sleep(1000);
//		    		String[] edate =endDate.split(",");
//		    		ExperimentsPage.selectDate(Integer.parseInt(edate[0]), Integer.parseInt(edate[1]), Integer.parseInt(edate[2]));Thread.sleep(1000);
//		    		ExperimentsPage.ClickingonExpSearchImg();Thread.sleep(1000);
//					String toDatePath = CaptureScreenShot.GetScreenShort(driver, "To Date related data in Search Project");
//			    	test.addScreenCaptureFromPath(toDatePath);
//		}//TC_SearchFunctonality_Criteria_SearchExperiments
//
//	@Test(groups = "smoke", priority = 4)
//
//	public void TC_SearchFunctonality_Criteria_SearchTests() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_03_CompleteFlow | TC_SearchFunctonality(Login with other user and check search test functionality)");
//		this.CompaneyName();
////		this.logout();Thread.sleep(1000);
////		driver.navigate().refresh();
//		int searchDataSheetNum=Myutility.getSheetNumber("Search Data");
//		 Map<String, Object> searchData=Myutility.prepareRowData(3, searchDataSheetNum);
//		test.createNode("Check Search Tests functionality In Criteria Search");
//		this.login((String) searchData.get("UserName"),(String) searchData.get("Password"));
//		ProjectCreation.Clickingonsearch();Thread.sleep(3000);
//		ExperimentsPage.Clickingoncriteriasearch();Thread.sleep(1000);
//		ExperimentsPage.ClickingonsearchTestsButton();Thread.sleep(1000);
//		ExperimentsPage.ClickingonProjectCodeANdSelectInTestSearh((String) searchData.get("Project Code"));
//		ExperimentsPage.ClickingonTestSearchImg();Thread.sleep(1000);
//		
//		String statusTypes=(String) searchData.get("Project Status");
//	    String[] allstatusTypes =statusTypes.split(",");
//		        
//		        for (String statusType : allstatusTypes) {
//		            System.out.println("Status Type is : "+statusType);
//		            try {
//			        	ExperimentsPage.ClickingonTeststatusANdSelect(statusType);Thread.sleep(1000);
//			        	ExperimentsPage.ClickingonTestSearchImg();
//		    		String screenshortpath6= CaptureScreenShot.GetScreenShort(driver, statusType+" data");
//		    		test.addScreenCaptureFromPath(screenshortpath6);
//		    		}
//		            catch(Exception e) {
//			            System.out.println(statusType+" Status Type is not there");
//		            }
//		    	 }//for
//			ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);//for refresh page using these lines
//			ExperimentsPage.ClickingonsearchTestsButton();Thread.sleep(1000);
//
//			ExperimentsPage.ClickingonProjectCodeANdSelectInTestSearh((String) searchData.get("Project Code"));
//			ExperimentsPage.enterSamplecode((String) searchData.get("Sample Code"));Thread.sleep(1000);
//			ExperimentsPage.ClickingonTestSearchImg();Thread.sleep(1000);
//			ExperimentsPage.clearSamplecode();Thread.sleep(1000);
//			ExperimentsPage.enterARNumber((String) searchData.get("AR Number"));Thread.sleep(1000);
//			ExperimentsPage.ClickingonTestSearchImg();Thread.sleep(1000);
//			
//			ExperimentsPage.ClickingonSearchExperimentbutton();Thread.sleep(1000);//for refresh page using these lines
//			ExperimentsPage.ClickingonsearchTestsButton();Thread.sleep(1000);
//			ExperimentsPage.ClickingonStandalonATRCheckbox();Thread.sleep(1000);//Disable the Standalone ATR checkbox
//			ExperimentsPage.ClickingonExperimentalATRCheckbox();Thread.sleep(1000);//enable the Experiment ATR checkbox
//			ExperimentsPage.ClickingonProjectCodeANdSelectInTestSearh((String) searchData.get("Project Code"));
//			ExperimentsPage.ClickingonTestSearchImg();Thread.sleep(1000);
//			ExperimentsPage.enterSamplecode((String) searchData.get("SampleCode Atr"));Thread.sleep(1000);
//			ExperimentsPage.ClickingonTestSearchImg();Thread.sleep(1000);
//			ExperimentsPage.clearSamplecode();Thread.sleep(1000);
//			ExperimentsPage.enterBatchCode((String) searchData.get("Batch Number"));Thread.sleep(1000);
//			ExperimentsPage.ClickingonTestSearchImg();Thread.sleep(1000);
//
//
//
//	}//TC_SearchFunctonality_Criteria_SearchTests
//	
//	
//	@Test(groups = "sanity", priority = 1)
//	public void TC_ValidateQAComments() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_03_CompleteFlow | TC_09(Create experiment and add QA comments to it)");
////		this.CompaneyName();
////		this.logout();Thread.sleep(1000);
////		driver.navigate().refresh();
//		test.createNode("Creating  experiment.");
//
//		int sheetNum=Myutility.getSheetNumber("Qa Data");
//		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
//			System.out.println("Project Exp Data "+RowData);
//		Thread.sleep(5000);
//		this.login((String) RowData.get("Chemist"),(String) RowData.get("Password"));
//		Thread.sleep(3000);
//		navigateToNotebook((String) RowData.get("Project"),(String) RowData.get("NoteBooks"));
//
//		ExperimentsPage.clickOnAddInExperiment();Thread.sleep(2000);
//
//		ExperimentsPage.clickOnRoute();
//		ExperimentsPage.slectRoute((String) RowData.get("Route Initials"));
//		Thread.sleep(2000);
//
//		ExperimentsPage.clickOnStage();
//		ExperimentsPage.slectStage((String) RowData.get("Stage Initials"));
//		Thread.sleep(2000);
//
//		ExperimentsPage.clickOnEnterAIm();
//		ExperimentsPage.enter_Aim("Aim is added");
//
//		ExperimentsPage.saveExperiment();Thread.sleep(2000);
//		driver.navigate().refresh();
//		test.createNode("Navigating to experiments in a notebook");
//		
//		ExperimentsPage.clickOnExpLink();
//		Thread.sleep(4000);
//		try {
//			if(ExperimentsPage.isRestoreInformationPopupEnabled()) {
////				ExperimentsPage.clickOnYesInRestoreInformationPopup();
//			ExperimentsPage.clickOnNoInRestoreInformationPopup();}
//
//	
//		}catch(Exception e) {
//			test.log(Status.PASS, "Restore experiment InformationPopup not displayed");
//
//		}
//		String qaExperiment=ExperimentsPage.getExperimentcode();
//        System.out.println("QA expCode:"+qaExperiment);
//		boolean flag=saveExperimentNavigateToNotebook(RowData);Thread.sleep(1000);
//		Assert.assertTrue(flag, "Experiment saved sucessfully");
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
//		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));
//		navigateToNotebook((String) RowData.get("Project"),(String) RowData.get("NoteBooks"));
//
//		ExperimentsPage.selectCheckBoxforApprovedExp(qaExperiment);
//		ExperimentsPage.clickOnView();
//		ExperimentsPage.clickOnQAComments();Thread.sleep(1000);
//		ExperimentsPage.enterCommentsForApproval((String) RowData.get("QA Comments"));Thread.sleep(1000);
//		ExperimentsPage.clickOnAddButton();Thread.sleep(1000);
//		Assert.assertTrue(ExperimentsPage.commnetsDisplayed(), "QA comments added successfully");		
//
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
//		this.login((String) RowData.get("Chemist"),(String) RowData.get("Password"));
//		navigateToNotebook((String) RowData.get("Project"),(String) RowData.get("NoteBooks"));
//		ExperimentsPage.selectCheckBoxforAnExp(qaExperiment);
//		ExperimentsPage.clickOnView();
//		Assert.assertTrue(ExperimentsPage.commnetsDisplayed());		
//
//	}//TC_ValidateQAComments
//	@Test(groups = "sanity", priority = 2)
//	public void TC_ValidateTeamCreation() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_03_CompleteFlow | TC_09(Create team and add members to it)");
////		this.CompaneyName();
////		this.logout();Thread.sleep(1000);
////		driver.navigate().refresh();
//		test.createNode("Creating  team.");
//
//		int sheetNum=Myutility.getSheetNumber("TeamData");
//		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
//			System.out.println("Team Data "+RowData);
//		Thread.sleep(3000);
//		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(3000);
//		LeftMenuIcon.clickonLeftMenuIcon();
//		LeftMenuIcon.ATR();
//		LeftMenuIcon.Team();Thread.sleep(3000);
//		teamcreation.clickonAddTeamButton();
//		teamcreation.clickAndSlectCRDTL((String) RowData.get("TL"));
//		teamcreation.clickAndSlectCRDHOD((String) RowData.get("HOD"));
//		teamcreation.enterTeamName((String) RowData.get("TeamName"));
//		teamcreation.enterTeamDescription((String) RowData.get("Description"));
////		teamcreation.clickOncancelteam();
//		teamcreation.clickOnSaveteam();
//		Thread.sleep(1000);
//		Assert.assertTrue(this.ExcelTemplate.GetTostMessageForNotebook().contains("New Team "+(String) RowData.get("TeamName")+" has been added!"));
//
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
//		test.createNode("Adding team members to team.");
//		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(3000);
//		LeftMenuIcon.clickonLeftMenuIcon();
//		LeftMenuIcon.TL_ATR();
//		LeftMenuIcon.TL_ATR_team();Thread.sleep(3000);
//		driver.navigate().refresh();
//
//		teamcreation.clickonAddTeamMembersButton();Thread.sleep(2000);
//		teamcreation.clickOnuserDropdown();
//		String Users=(String) RowData.get("Members");
//	    String[] allusers =Users.split(",");
//		        
//		        for (String user : allusers) {
//		            System.out.println("User name is : "+user);
//		            try {
//		            	teamcreation.selectcheckboxForUser(user);
//		            	Thread.sleep(2000);
//		    		}
//		            catch(Exception e) {
//			            System.out.println("user "+user+" is not there");
//		            }
//		    	 }//for
//		    teamcreation.closeMultiSelectPopup();
//			teamcreation.clickOncancelteam();
////				teamcreation.clickOnSaveteam();
//	}//TC_ValidateTeamCreation
	
}//TS_CRD_5_1
