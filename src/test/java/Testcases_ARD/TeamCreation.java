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

import CHEMIASOFT.ARD.PageObjects.ARD_LeftMenuItemsPage;
import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.CRD_Left_Menu_Tabs;
import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.Embedded_Excel_Temp_Page;
import CHEMIASOFT.Chemia.Utilites.CaptureScreenShot;
import CHEMIASOFT.Chemia.Utilites.Utility;
import CHEMIASOFT.Chemia.Utilites.setBrowser;
import CHEMIASOFT.Chemia.login.PageObjects.CommonLoginPage;
import CHEMIASOFT.Chemia.login.PageObjects.CompanyName;
import CHEMIASOFT.Chemia.login.PageObjects.MainPage;
import Chemia.Project.Creation.PageObject.Team_Creation_Page;

public class TeamCreation {

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
	//Output Excel Sheet Details
			int RowNumber = 1;
			int outputSheetNumber = 4 ;//Test cases Output Sheet name:ARDMasterData
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
//for loop for outer and inner loop

//	@Test(priority = 1)
//	public void TC_01_ValidateTeamCreation() throws Exception {
//		System.out.println("**********************Method Starting: TC_01_ValidateTeamCreation******************************");
//
//		this.test = extent.createTest(
//				"TS_Chemia_ARD_5.1_Team Creation | TC_01(Create team and add members to it)");
//		this.CompaneyName();
//		test.createNode("Creating  team.");
////
//		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
//		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
//			System.out.println("Team Data "+RowData);
//		Thread.sleep(3000);
//		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(5000);
//		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(2000);
//		LeftMenuIcon.ATRMenu();Thread.sleep(2000);
//		LeftMenuIcon.ClickOnARDTeam();Thread.sleep(3000);
//		teamcreation.clickonAddTeamButtonARD();Thread.sleep(3000);
//		teamcreation.clickAndSlectCRDTL((String) RowData.get("TL"));
//		teamcreation.clickAndSlectCRDHOD((String) RowData.get("HOD"));
//		teamcreation.enterTeamName((String) RowData.get("TeamName"));
//		teamcreation.enterTeamDescription((String) RowData.get("Description"));
////		teamcreation.clickOncancelteam();
//		teamcreation.clickOnSaveteam();
//		Thread.sleep(1000);
////		Assert.assertTrue(this.ExcelTemplate.GetTostMessageForNotebook().contains("New Team "+(String) RowData.get("TeamName")+" has been added!"));
//
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
//		test.createNode("Adding team members to team.");
//		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(5000);
//		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
//		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(2000);
//		LeftMenuIcon.clcikOnTL_ATRTeams();Thread.sleep(2000);
//		LeftMenuIcon.clcikOnTL_MyTeam();Thread.sleep(3000);
//		driver.navigate().refresh();
//
//		String Users=(String) RowData.get("Members");
//	    String[] allusers =Users.split(",");
//		        
//		        for (String user : allusers) {
//		            System.out.println("User name is : "+user);
//		            try {
//		        		teamcreation.clickOnAddteamMembrARD();Thread.sleep(2000);
//		            	teamcreation.clickAndSlectARDTeamMembr(user);
//		            	if(user.contains("TL")) {
//		            		teamcreation.clickOnReviewCheckBox();
//		            	}
//		            	Thread.sleep(2000);
//		    		}
//		            catch(Exception e) {
//			            System.out.println("user "+user+" is not there");
//		            }
//		    		teamcreation.clickOncancelteam();
////		            teamcreation.clickOnSaveteamMembr();Thread.sleep(2000);
//		    	 }//for
//				
//	}//TC_ValidateTeamCreation
	@Test(priority = 2)
	public void TC_02_ValidateTestTechniqueCreation() throws Exception {
		System.out.println("**********************Method Starting: TC_02_ValidateTestTechniqueCreation******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Create Test Technique | TC_02(Create Test Technique)");
		this.CompaneyName();
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
		test.createNode("Creating  Test Technique.");

		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Team Data "+RowData);
		Thread.sleep(3000);
		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(8000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(2000);
		LeftMenuIcon.clcikOnTL_Configurations();Thread.sleep(2000);
		LeftMenuIcon.clcikOnTL_TestTechniques();Thread.sleep(3000);
		teamcreation.clickonAddTestTechnique();Thread.sleep(1000);
		teamcreation.enterTechniqueName("Techn_"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
		teamcreation.enterDescription((String) RowData.get("Description"));Thread.sleep(1000);
//		teamcreation.clickonCancelTestTechnique();
        teamcreation.clickonSaveTestTechnique();
			
	}
	@Test(priority = 3)
	public void TC_03_ValidateCreatingTestConfiguration() throws Exception {
		System.out.println("**********************Method Starting: TC_03_ValidateCreatingTestConfiguration******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Create Test Configurations | TC_03(Creating two tests with result parameters as Text and Number)");
//		this.CompaneyName();
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		test.createNode("Creating  Test Configurations.");

		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Team Data "+RowData);
		Thread.sleep(3000);
		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(9000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(2000);
		LeftMenuIcon.clcikOnTL_Configurations();Thread.sleep(2000);
		LeftMenuIcon.clcikOnTL_TestConfiguration();Thread.sleep(3000);
		String resultTypes=(String) RowData.get("ResultTypes");
  		String[] allTypes =resultTypes.split(",");
  	        
  	    for (String resultType : allTypes) {
		
		teamcreation.clickonADDTestConfig();Thread.sleep(1000);
		teamcreation.enterAnalysisTechnicalCode("TC_"+resultType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
		teamcreation.enterTestType("TT_"+resultType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
		teamcreation.enterTestSubType("ST_"+resultType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
		teamcreation.clickAndSlectTestTechnique("Techn_"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
		teamcreation.clickAndSlectResultType(resultType);Thread.sleep(1000);
		if(resultType.equalsIgnoreCase("NUMBER")) {
			teamcreation.clickAndSlectUOMValueIfNum((String) RowData.get("UOM"));Thread.sleep(1000);
		}
		else{
			teamcreation.clickonADDResultParameter();Thread.sleep(1000);
			teamcreation.enterParameterName("Parameter_"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
			teamcreation.clickAndSlectPopupResultTypeAsText();Thread.sleep(1000);
//			teamcreation.clickonCancelAddresultparamtr();
	        teamcreation.clickonSaveAddresultparamtr();Thread.sleep(2000);
		}
		teamcreation.enterDescription((String) RowData.get("Description"));Thread.sleep(1000);
//		teamcreation.clickonCancelTestTechnique();//works for all cancel buttons
        teamcreation.clickonSaveTestTechnique();Thread.sleep(2000);//works for all Save buttons
			
  	        }//for
	}//TC_03_ValidateTestConfiguration
	
	@Test(priority = 4)
	public void TC_04_ValidateCreatingTestGroup() throws Exception {
		System.out.println("**********************Method Starting: TC_04_ValidateCreatingTestGroup******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Create Test Group | TC_04(Creating group with two tests)");
//		this.CompaneyName();
////		this.logout();Thread.sleep(1000);
////		driver.navigate().refresh();
		test.createNode("Creating  Test Group.");

		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Team Data "+RowData);
		Thread.sleep(3000);
//		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(9000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(2000);
		LeftMenuIcon.clcikOnTL_Configurations();Thread.sleep(2000);
		LeftMenuIcon.clcikOnTL_TestGroups();Thread.sleep(2000);
		teamcreation.clickonADDTestGroup();Thread.sleep(1000);
		teamcreation.enterGroupName("TGroup_"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
		teamcreation.enterGroupDescr((String) RowData.get("Description"));Thread.sleep(1000);
		teamcreation.clickonSaveTestGroup();Thread.sleep(3000);

		teamcreation.clickonTestGroupRightArrow();Thread.sleep(1000);
		teamcreation.clickonAddTestDetails();Thread.sleep(1000);

		String resultTypes=(String) RowData.get("ResultTypes");
 		 String[] allTypes =resultTypes.split(",");
 	        
 	        for (String resultType : allTypes) {
 	   		teamcreation.clickonAddTestCheckbox("TT_"+resultType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);

 	        }
// 	       teamcreation.clickOncancelteam();//works for all cancel buttons
         teamcreation.clickOnSaveteam();//works for all Save buttons
		
	}
	
	@Test(priority = 5)
	public void TC_05_ValidateCreatingATRAtrributes() throws Exception {
		System.out.println("**********************Method Starting: TC_05_ValidateCreatingATRAtrributes******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Create ATR Attributes | TC_05(Creating ATR Attributess with text,Number and date.)");
//		this.CompaneyName();
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
		test.createNode("Creating  ATR Attributes.");

		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Team Data "+RowData);
		Thread.sleep(3000);
//		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(5000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(2000);
		LeftMenuIcon.clcikOnTL_Configurations();Thread.sleep(2000);
		LeftMenuIcon.clcikOnTL_ATRAttributes();Thread.sleep(2000);
		
		String attributeTypes=(String) RowData.get("AttributeTypes");
		 String[] allTypes =attributeTypes.split(",");
	        
	        for (String attrType : allTypes) {
	    		teamcreation.clickonADDAttribute();Thread.sleep(1000);     	
	    		teamcreation.enterAttributeName("Attr_"+attrType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
	    		teamcreation.clickAndSlectAttribteType(attrType);Thread.sleep(1000);
	    		teamcreation.enterMaxLength((String) RowData.get("MaxLenth"));Thread.sleep(1000);
		
//	    		teamcreation.clickOncancelteam();//works for all cancel buttons
 	            teamcreation.clickOnSaveteam();Thread.sleep(2000);//works for all Save buttons
		
	}//for
	
	
	}//TC_05_ValidateCreatingATRAtrributes
	
	
	@Test(priority = 6)
	public void TC_06_ValidateCreatingFormType() throws Exception {
		System.out.println("**********************Method Starting: TC_06_ValidateCreatingFormType******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Create Formtype | TC_06(Creating Formtype with adding attributes and group so that tests added in default)");
//		this.CompaneyName();
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
		test.createNode("Creating  Form type.");

		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Team Data "+RowData);
		Thread.sleep(3000);
//		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(9000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_Configurations();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_FormTypes();Thread.sleep(1000);
		teamcreation.clickonAddFormType();Thread.sleep(1000);
		
		teamcreation.enterFortypeName("SWtestFom"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
		teamcreation.enterFormTypeDescr((String) RowData.get("Description"));Thread.sleep(1000);
//		teamcreation.clickOncancelteam();Thread.sleep(8000);//works for all cancel button
		teamcreation.clickOnSaveteam();Thread.sleep(4000);//works for all Save buttons
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_Configurations();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_FormTypes();Thread.sleep(1000);
 		teamcreation.clickAndSlectFormType("SWtestFom"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000); //To avoid error page exception again navigating and selecting from type from drop down
		
		teamcreation.clickonAddFormAttribute();Thread.sleep(1000);
		
		String attributeTypes=(String) RowData.get("AttributeTypes");
		 String[] allTypes =attributeTypes.split(",");
	        
	        for (String attrType : allTypes) {
		teamcreation.clickonAttributeCheckboxforFomType("Attr_"+attrType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(3000);
	        }//for
		
// 	       teamcreation.clickOncancelteam();//works for all cancel buttons
            teamcreation.clickOnSaveteam();Thread.sleep(3000);//works for all Save buttons
		
 		teamcreation.clickAndSlectTestGroup("TGroup_"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
 		teamcreation.clickonAddGroupInFormType();Thread.sleep(1000);
	    Assert.assertTrue(this.ExcelTemplate.GetTostMessageForNotebook().contains("Test Group(s) added to Form Type "+"SWtestFom"+this.Myutility.getDataFromProparties("Key1")+" successfully!"));

	}
	@Test(priority = 7)
	public void TC_07_ValidateCreatingTemplateDataItems() throws Exception {
		System.out.println("**********************Method Starting: TC_07_ValidateCreatingTemplateDataItems******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Create excel Template Data items | TC_07(Creating Data Items with integer and text data Types)");
//		this.CompaneyName();
////		this.logout();Thread.sleep(1000);
////		driver.navigate().refresh();
		test.createNode("Creating  Template Data items.");

		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Team Data "+RowData);
		Thread.sleep(3000);
//		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(9000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_ADExperiments();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_TemplateDataItems();Thread.sleep(1000);
		
		String dataItemTypes=(String) RowData.get("DataItemTypes");
		 String[] allTypes =dataItemTypes.split(",");
	        
	        for (String DIType : allTypes) {
		teamcreation.clickonAddTemplateDataItem();Thread.sleep(1000);
		teamcreation.enterDataItemName("DI_"+DIType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
		teamcreation.clickAndSlectDataType(DIType);Thread.sleep(1000);
		if(DIType.equalsIgnoreCase("Text")) {
			teamcreation.clickAndSlectLengthcategory("Medium");Thread.sleep(1000);
		}
		teamcreation.enterDataItemDescr((String) RowData.get("Description"));Thread.sleep(1000);
//		  teamcreation.clickOncancelteam();//works for all cancel buttons
          teamcreation.clickOnSaveteam();Thread.sleep(2000);//works for all Save buttons
//          mainpage.closePopup();
	        }	          

	}//TC_07_ValidateCreatingTemplateDataItems
	
	@Test(priority = 8)
	public void TC_08_ValidateCreatingTemplateSections() throws Exception {
		System.out.println("**********************Method Starting: TC_08_ValidateCreatingTemplateSections******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Create excel Template Sections| TC_08(Creating All Types of Template Sections)");
//		this.CompaneyName();
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
		test.createNode("Creating  excel Template Sections.");

		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Team Data "+RowData);
		Thread.sleep(3000);
//		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(9000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_ADExperiments();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_ExperimentTemplateSections();Thread.sleep(1000);
		
		String sectionTypes=(String) RowData.get("SectionsTypes");
		 String[] allTypes =sectionTypes.split(",");
	        
	        for (String scetion : allTypes) {
	    		teamcreation.clickonAddTemplateSections();Thread.sleep(1000);
	    		teamcreation.enterSectionName(scetion+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
	    		teamcreation.enterUniqueIdentifier(scetion+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
	    		teamcreation.clickAndSlectSectionType(scetion);Thread.sleep(1000);
	    		teamcreation.enterTemplateSectionDescr((String) RowData.get("Description"));Thread.sleep(1000);

	        	 switch (scetion) {
	             case "Richtext":
	 	    		teamcreation.enterSectionHeight((String) RowData.get("MaxLenth"));Thread.sleep(1000);

	                 break;

	             case "Standard Preparation":
		 	    	teamcreation.enterSectionHeightOnStandardPreparation((String) RowData.get("MaxLenth"));Thread.sleep(1000);

	                 break;

	             case "Combined":
	            	 String dataItemTypes=(String) RowData.get("DataItemTypes");
	        		 String[] DallTypes =dataItemTypes.split(",");
	        	        
	        	        for (String DIType : DallTypes) {
	        	        	if(DIType.equalsIgnoreCase("Integer")) {
	        	        		teamcreation.clickonAddCombiParm();Thread.sleep(1000);	            	 
	        	        		teamcreation.clickAndSlectParamDataItem("DI_"+DIType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
	        	        		teamcreation.clickonSaveCombiParm();Thread.sleep(1000);
	        	        	}
	        	        	else  {
	        	        		 teamcreation.enterDataTbaleName("Dtble"+scetion+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000); 
	        	        		 teamcreation.enterDescrDatatble((String) RowData.get("Description"));Thread.sleep(1000); 
	        	        		 teamcreation.clickonAddCombiDataTble();Thread.sleep(1000); 
	        			 	     teamcreation.clickAndSlectDataTbleDataItem("DI_"+DIType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
	        		 	    	 teamcreation.enterDatatbleRelativewidth((String) RowData.get("MaxLenth"));Thread.sleep(1000);

	        			 	     teamcreation.clickonSaveDataTble();Thread.sleep(1000);
	        	        	}
	        	        }
	                 break;
	             case "Params":
	        	        		teamcreation.clickonAddItemSection();Thread.sleep(1000);
	        	        		teamcreation.enterDataItemName("DI_Date"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
	        	        		teamcreation.clickAndSlectDataType("Date");Thread.sleep(1000);
	        	        		teamcreation.enterDataItemDescr((String) RowData.get("Description"));Thread.sleep(1000);
	        	                teamcreation.clickOnSaveteam();Thread.sleep(4000);//works for all Save buttons
	        	                mainpage.closePopup();
	        	        		teamcreation.clickonAddCombiParm();Thread.sleep(1000);	            	 
	        	        		teamcreation.clickAndSlectParamDataItem("DI_Date"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
	        	        		teamcreation.clickonSaveCombiParm();Thread.sleep(1000);
	        	       		
	        	        		break;
	             case "Datatable":
	            	 String dataItemTypes1=(String) RowData.get("DataItemTypes");
	        		 String[] DallTypes1 =dataItemTypes1.split(",");
	        	        
	        	        for (String DIType : DallTypes1) {
	        	        	if(DIType.equalsIgnoreCase("Integer")) {
	        	        		 teamcreation.enterDataTbaleName("Dtble"+scetion+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000); 
	        	        		 teamcreation.enterDescrDatatble((String) RowData.get("Description"));Thread.sleep(1000); 
	        	        		 teamcreation.clickonAddCombiDataTble();Thread.sleep(1000); 
	        			 	     teamcreation.clickAndSlectDataTbleDataItem("DI_"+DIType+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);
	        		 	    	 teamcreation.enterDatatbleRelativewidth((String) RowData.get("MaxLenth"));Thread.sleep(1000);
	        			 	     teamcreation.clickonSaveDataTble();Thread.sleep(1000);
	        	        	}
	        	        }
	                 break;
	             case "Embedded Excel":
		 	    		teamcreation.AddExcel();Thread.sleep(2000);
		 	    		this.Myutility.Uploadfile(this.Myutility.uploadAddexcelInSectionsPath()); Thread.sleep(2000);
		 	    		teamcreation.clickonSaveExcel();Thread.sleep(9000);
		 	    		String screenshortpath = CaptureScreenShot.GetScreenShort(driver, scetion+" related Section Template");
		   	    		test.addScreenCaptureFromPath(screenshortpath);
		   	    		teamcreation.clickonOkPDFPreview();
		                 break;
	             default:
	                 System.out.println("No action matched");
	                 break;
	         }
	        	 	teamcreation.clickonSaveSections();Thread.sleep(2000);
//	        	 	teamcreation.clickonCancelSections();Thread.sleep(2000);

	 	    		teamcreation.clickonSectionShowPreview();Thread.sleep(2000);
	 	    		String screenshortpath = CaptureScreenShot.GetScreenShort(driver, scetion+" related Section Template");
	   	    		test.addScreenCaptureFromPath(screenshortpath);
	 	    		teamcreation.clickonBackToTemplateSections();Thread.sleep(2000);         	 
	        }
	
	}//TC_08_ValidateCreatingTemplateSections
	
	@Test(priority = 9)
	public void TC_09_ValidateCreatingExperimentTemplate() throws Exception {
		System.out.println("**********************Method Starting: TC_09_ValidateCreatingExperimentTemplate******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Create Experiment Template | TC_09(Creating Experiment template with All Types of Template Sections)");
//		this.CompaneyName();
////		this.logout();Thread.sleep(1000);
////		driver.navigate().refresh();
		test.createNode("Creating  Experiment Template.");

		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Team Data "+RowData);
		Thread.sleep(3000);
//		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(9000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_ADExperiments();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_ExperimentTemplate();Thread.sleep(1000);
		
		teamcreation.clickonAddTemplate();Thread.sleep(1000);	            	 
		teamcreation.enterTemplateName("Experiment Temlate_"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);	            	 
		teamcreation.enterTemplateDescr((String) RowData.get("Description"));Thread.sleep(1000);
//		LeftMenuIcon.clickonLeftMenuIcon();//overlap leftmenu

		
		String sectionTypes=(String) RowData.get("SectionsTypes");
		String[] allTypes =sectionTypes.split(",");
	        int j=1;
	        for (String scetion : allTypes) {
	    		teamcreation.clickonAddSectionsForTemplate();Thread.sleep(1000);	            	 
	    		teamcreation.clickAndSlectSectionAndIncludeClone(j,scetion+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(1000);	  
	    		j++;
	        }
	    teamcreation.clickonSaveSectionsForTemplate();Thread.sleep(1000);
	    teamcreation.clickonPreviewTemplate();Thread.sleep(2000);
	    teamcreation.scrollTemplatePreview();Thread.sleep(1000);
        mainpage.closePopup();//Closing the Template Preview Popup
	    teamcreation.clickonSaveExperimentTeplate();Thread.sleep(1000);
//	    teamcreation.clickonBackExperimentTeplate();Thread.sleep(1000);

	    
	}//TC_09_ValidateCreatingExperimentTemplate
	
	@Test(priority = 10)
	public void TC_10_ValidateExperimentTemplateSubmitandApprove() throws Exception {
		System.out.println("**********************Method Starting: TC_10_ValidateExperimentTemplateSubmitandApprove******************************");

		this.test = extent.createTest(
				"TS_Chemia_ARD_5.1_Submit and Approve Experiment Template | TC_10(Submit and Approve Experiment template)");
//		this.CompaneyName();
//		this.logout();Thread.sleep(1000);
//		driver.navigate().refresh();
		test.createNode("Submit and Approve an Experiment Template");

		int sheetNum=Myutility.getARDSheetNumber("TeamCreation");
		 Map<String, Object> RowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Team Data "+RowData);
		Thread.sleep(3000);
//		this.login((String) RowData.get("Teamlead"),(String) RowData.get("Password"));Thread.sleep(9000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);

		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_ADExperiments();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_ExperimentTemplate();Thread.sleep(1000);
		teamcreation.clickOnExperimentTemplateLink("Experiment Temlate_"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(3000);
		teamcreation.clickonSubmitExperimentTeplate();Thread.sleep(1000);
		teamcreation.clickonYesForSubmitExperimentTeplate();Thread.sleep(1000);
		
		this.logout();Thread.sleep(1000);
		driver.navigate().refresh();
		
		//Add assertions here
		this.login((String) RowData.get("UserName"),(String) RowData.get("Password"));Thread.sleep(9000);
		LeftMenuIcon.Clickingonhomebutton();Thread.sleep(2000);
		LeftMenuIcon.clickonLeftMenuIcon();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_ADExperiments();Thread.sleep(1000);
		LeftMenuIcon.clcikOnTL_TemplatePendingApproval();Thread.sleep(1000);
		teamcreation.clickOnExperimentTemplateLink("Experiment Temlate_"+this.Myutility.getDataFromProparties("Key1"));Thread.sleep(3000);
		teamcreation.clickonApproveExperimentTeplate();Thread.sleep(1000);
		teamcreation.enterApproverPassword((String) RowData.get("Password"));Thread.sleep(3000);
		teamcreation.clickonApproveExperimentTeplateAfterAuthentication();Thread.sleep(1000);
		
	}//TC_10_ValidateExperimentTemplateSubmitandApprove
	
	
}
