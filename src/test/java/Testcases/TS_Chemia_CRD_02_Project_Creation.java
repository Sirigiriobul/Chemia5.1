package Testcases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import CHEMIASOFT.Chemia.Utilites.BaseClass;
import CHEMIASOFT.Chemia.Utilites.CaptureScreenShot;
import CHEMIASOFT.Chemia.Utilites.Utility;
import CHEMIASOFT.Chemia.Utilites.setBrowser;
import CHEMIASOFT.Chemia.login.PageObjects.CommonLoginPage;
import CHEMIASOFT.Chemia.login.PageObjects.CompanyName;
import CHEMIASOFT.Chemia.login.PageObjects.MainPage;
import Chemia.Project.Creation.PageObject.Project_Creation_Page;

public class TS_Chemia_CRD_02_Project_Creation extends BaseClass {

//	Utility Myutility;
//	WebDriver driver;
//	// Actions actions = new Actions (driver);
//
//	CompanyName cname; // Company Name Page
//	CommonLoginPage loginpage; // Login Page
//	MainPage mainPage;
//	CRD_Left_Menu_Tabs LeftMenuIcon;
//	Project_Creation_Page ProjectCreation;

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
////		driver.get(this.Myutility.getDataFromProparties("URL"));
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
//	public ExtentSparkReporter spark;
//	public ExtentReports extent;
//	public ExtentTest test;
//
//	@BeforeTest
//	// In before Test we create the extent report & attach the screen short to the
//	// report
//	// At the same time we also give more info about like which browser is used, who
//	// tested etc by using
//
//	public void beforetest() throws Exception {
//
//		// Formating the data
//		String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
//		// creates one extent report on the given path
//		this.spark = new ExtentSparkReporter(
//				this.Myutility.PathOfReport() + "/" + date + " " + "TS_Chemia_CRD_02.html");
//		// Setting title for the document
//		spark.config().setDocumentTitle("Chemia | CRD Automation Report");// title of the report
//		// Setting name of the report
//		// spark.config().setReportName("CRD Master data | Dosage Form ");// name of the
//		// report
//		// Selecting the theme
//		spark.config().setTheme(Theme.DARK);
//
//		// Creates the report
//		this.extent = new ExtentReports();
//		// Attaches the report
//		extent.attachReporter(this.spark);
//
//		// Extra information to write on the report
//		extent.setSystemInfo("Browser", this.Myutility.getDataFromProparties("browser"));
//		extent.setSystemInfo("Host", this.Myutility.getDataFromProparties("host"));
//		extent.setSystemInfo("os", this.Myutility.getDataFromProparties("os"));
//		extent.setSystemInfo("Tester Name", this.Myutility.getDataFromProparties("tester"));
//	}
//
//	@AfterTest
//	// In after Test we flush out the report for saving all the data
//	public void afterTest() {
//
//		extent.flush();
//	}

	@BeforeMethod
	// in Before method we will initiate all the class which are needed for the test
	// case
	public void beforeMethod() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Pages
		this.cname = new CompanyName(driver); // Company Name Page
		this.loginpage = new CommonLoginPage(driver); // Common Login Page
		this.mainPage = new MainPage(driver); // Main Page
		this.ProjectCreation = new Project_Creation_Page(driver);
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
				"TS_Chemia_CRD_02_Project_Creation | TC_1(Clicking on Add project icon and without enter mandatory fields then click on save button )");
		CompaneyName();
		test.createNode("Enterd Companey name");
		login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
		this.ProjectCreation.addProjecticon();
		this.ProjectCreation.Clickingonsavebutton();
		Thread.sleep(5000);
		/*
		 * this.ProjectCreation.ProductName("Project");this.ProjectCreation.ProjectCode(
		 * "RC-1"); this.ProjectCreation.customeorMarket("India");
		 * this.ProjectCreation.ProjectType("Testing");
		 * this.ProjectCreation.EnteringDescription("Project Created Successfully");
		 * this.ProjectCreation.Clickingonsavebutton();
		 */

	}

	@Test(priority = 2)
	public void TC_2() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_02_Project_Creation | TC_2(Enter only product name and click on save button )");
		driver.navigate().refresh();
		this.ProjectCreation.ProductName("Project");
		this.ProjectCreation.Clickingonsavebutton();
		Thread.sleep(1000);

	}

	@Test(priority = 3)
	public void TC_3() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_02_Project_Creation | TC_3(Enter only project code and click on save button)");
		driver.navigate().refresh();
		this.ProjectCreation.ProjectCode("RC-1");
		this.ProjectCreation.Clickingonsavebutton();
		Thread.sleep(1000);

	}

	@Test(priority = 4)
	public void TC_4() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_02_Project_Creation | TC_4(Enter only project type and click on save button)");
		driver.navigate().refresh();
		this.ProjectCreation.ProjectType("Testing");
		this.ProjectCreation.Clickingonsavebutton();
		Thread.sleep(1000);

	}

	@Test(priority = 5)
	public void TC_5() throws Exception {
		this.test = extent.createTest(
				"TS_Chemia_CRD_02_Project_Creation | TC_5(Enter all the mandatory fields and click on cancel button)");
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.ProjectCreation.ProductName("Project");
		this.ProjectCreation.ProjectCode("RC-1");
		this.ProjectCreation.customeorMarket("India");
		this.ProjectCreation.ProjectType("Testing");
		Thread.sleep(1000);
		this.ProjectCreation.EnteringDescription("Project Created Successfully");
		this.ProjectCreation.Clickingoncancelbutton();
		// Thread.sleep(5000);

	}

//	@Test(priority = 6)
//	public void TC_6() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_6(Enter all the mandatory fields and click on save button)");
//		driver.navigate().refresh();
//		this.ProjectCreation.addProjecticon();
//		this.ProjectCreation.ProductName("Project");
//		this.ProjectCreation.ProjectCode("RC-1");
//		this.ProjectCreation.customeorMarket("India");
//		this.ProjectCreation.ProjectType("Testing");
//		//Thread.sleep(1000);
//		this.ProjectCreation.EnteringDescription("Project Created Successfully");
//		this.ProjectCreation.Clickingonsavebutton();
//		//Thread.sleep(5000);
//	}
//
//	@Test(priority = 7)
//	public void TC_7() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_7(Creating another project with existing details )");
//		driver.navigate().refresh();
//		this.ProjectCreation.ProductName("Project");
//		this.ProjectCreation.ProjectCode("RC-1");
//		this.ProjectCreation.customeorMarket("India");
//		this.ProjectCreation.ProjectType("Testing");
//		this.ProjectCreation.EnteringDescription("Project Created Successfully");
//		this.ProjectCreation.Clickingonsavebutton();
//		//Thread.sleep(5000);
//	}
//
//	@Test(priority = 8)
//	public void TC_8() throws Exception {
//		this.test = extent.createTest("TS_Chemia_CRD_02_Project_Creation | TC_8(Creating new project  )");
//		driver.navigate().refresh();
//		this.ProjectCreation.ProductName("Project");
//		this.ProjectCreation.ProjectCode("RC-17");
//		this.ProjectCreation.customeorMarket("India");
//		this.ProjectCreation.ProjectType("Testing");
//		this.ProjectCreation.EnteringDescription("Project Created Successfully");
//		this.ProjectCreation.Clickingonsavebutton();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonhomebutton();
//		//Thread.sleep(1000);
//	}
//
//	@Test(priority = 9)
//	public void TC_9() throws Exception {
//		System.out.println("******************TC-9*****************");
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_9(Clicking on edit button expect created by column remaining all fields will be editable)");
//
//		driver.navigate().refresh();
//		this.ProjectCreation.DropdownButton();
//		//Thread.sleep(2000);
//		this.ProjectCreation.GetprojectName("RC_12");
//		Thread.sleep(3000);
//		this.ProjectCreation.Go_button();
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingoneditbutton();
//		//Thread.sleep(1000);
//		this.ProjectCreation.DescriptionClear();
//		//Thread.sleep(1000);
//		this.ProjectCreation.EnteringDescription("Edited");
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonsavebutton();
//
//	}
//
//	@Test(priority = 10)
//	public void TC_10() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_10(In edit mode remove all the mandatory fields and click on save button)");
//		driver.navigate().refresh();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingoneditbutton();
//		//Thread.sleep(1000);
//		this.ProjectCreation.ProductNameClear();
//		this.ProjectCreation.ProjectCodeClear();
//		this.ProjectCreation.ProjectTypeClear();
//		this.ProjectCreation.DescriptionClear();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonsavebutton();
//	}
//
//	@Test(priority = 11)
//	public void TC_11() throws Exception {
//		System.out.println("******************TC-11*****************");
//
//		this.test = extent.createTest("TS_Chemia_CRD_02_Project_Creation | TC_11(Closing Project)");
//		// this.CompaneyName();
//		// test.createNode("Enterd Companey name");
//		// this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0,
//		// 1, 3));
//		// test.log(Status.PASS, "loged in with user ID = " +
//		// this.Myutility.LoadXLfile(0, 1, 1));
//		driver.navigate().refresh();
//		this.ProjectCreation.Clickingonhomebutton();
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(2000);
//		this.ProjectCreation.GetprojectName("RC_12");
//		Thread.sleep(2000);
//		this.ProjectCreation.Go_button();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonclosebutton();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Yesbuttononcloseproject();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonhomebutton();
//
//	}
//
//	@Test(priority = 12)
//	public void TC_12() throws Exception {
//		System.out.println("******************TC-12*****************");
//
//		this.test = extent.createTest("TS_Chemia_CRD_02_Project_Creation | TC_12(Reopening Project)");
//		driver.navigate().refresh();
//		//Thread.sleep(1000);
//		//this.LeftMenuIcon.clickonLeftMenuIcon();
//		driver.findElement(By.xpath("//a[@id='sidebar-toggle']")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'Project ')]")).click();
//		driver.findElement(By.xpath("//span[contains(text(),' Closed Projects ')]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//tbody//tr//td[1]/../td/a[@id='navigateToProjectEditorId']")).click();
//		driver.navigate().refresh();
//
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[@id='reopen']")).click();
//		this.ProjectCreation.YesbuttononReopenproject();
//		this.ProjectCreation.Clickingonhomebutton();
//	}
//
//	@Test(priority = 13)
//	public void TC_13() throws Exception {
//		System.out.println("******************TC-13*****************");
//
//		this.test = extent.createTest("TS_Chemia_CRD_02_Project_Creation | TC_13(Deactivating project)");
//		this.ProjectCreation.Clickingonhomebutton();
//		Thread.sleep(1000);
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(2000);
//		this.ProjectCreation.GetprojectName("RC_12");
//		Thread.sleep(2000);
//		this.ProjectCreation.Go_button();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingondeactivatebutton();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Yesbuttonondeactivateproject();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonhomebutton();
//
//	}
//
//	@Test(priority = 14)
//	public void TC_14() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_14(Trying to deactivating project after creating notebook to the project)");
//		driver.navigate().refresh();
//		Thread.sleep(1000);
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(2000);
//		this.ProjectCreation.GetprojectName("RC-17");
//		Thread.sleep(2000);
//		this.ProjectCreation.Go_button();
//		//Thread.sleep(1000);
//		/*
//		 * this.ProjectCreation.Clickingonnotebooktab(); Thread.sleep(1000);
//		 * this.ProjectCreation.Clickingonnotebooktab(); Thread.sleep(1000);
//		 * this.ProjectCreation.Addbuttonfornotebook(); Thread.sleep(1000);
//		 * this.ProjectCreation.Enteringnotebookdescription(); Thread.sleep(1000);
//		 * this.ProjectCreation.Savebuttonfornotebook(); Thread.sleep(2000);
//		 * this.ProjectCreation.Clickingonbread_crumbicon(); Thread.sleep(2000);
//		 */
//		this.ProjectCreation.Clickingondeactivatebutton();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Yesbuttonondeactivateproject();
//	}
//
//	@Test(priority = 15)
//	public void TC_15() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_15(In criteria search section deactivated project should display)");
//		/*this.CompaneyName();
//		test.createNode("Enterd Companey name");
//		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
//		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));*/
//		driver.navigate().refresh();
//		//Thread.sleep(2000);
//		this.ProjectCreation.Clickingonsearch();
//		//Thread.sleep(3000);
//		this.ProjectCreation.Clickingoncriteriasearch();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonsearchproject();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonprojectstatus();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Selectingstatus();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonprojectsearch();
//		//Thread.sleep(1000);
//	}
//
//	@Test(priority = 16)
//	public void TC_16() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_16(Trying to add attribute and attribute types should display)");
//		
//		this.ProjectCreation.Clickingonhomebutton();
//		//Thread.sleep(1000);
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(1000);
//		this.ProjectCreation.GetprojectName("RC-17");
//		Thread.sleep(2000);
//		this.ProjectCreation.Go_button();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattributebutton();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattributetype();
//		//Thread.sleep(1000);
//
//	}
//
//	@Test(priority = 17)
//	public void TC_17() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_17(Trying to save attribute without entering mandatory fields");
//		/*this.CompaneyName();
//		test.createNode("Enterd Companey name");
//		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
//		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
//		this.ProjectCreation.Clickingonhomebutton();
//		Thread.sleep(1000);
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(1000);
//		this.ProjectCreation.GetprojectName("RC-17");
//		Thread.sleep(2000);
//		this.ProjectCreation.Go_button();
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattributebutton();
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattributetype();
//		Thread.sleep(1000);*/
//
//		// upto till up delete
//		//Thread.sleep(2000);
//		this.ProjectCreation.Clickingonattsavebutton();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattcancelbutton();
//		//Thread.sleep(1000);
//
//	}
//
//	@Test(priority = 18)
//	public void TC_18() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_18(Trying to add attribute_text ");
//		/*this.CompaneyName();
//		test.createNode("Enterd Companey name");
//		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
//		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
//		this.ProjectCreation.Clickingonhomebutton();
//		Thread.sleep(1000);
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(1000);
//		this.ProjectCreation.GetprojectName("RC-17");
//		Thread.sleep(2000);
//		this.ProjectCreation.Go_button();
//		Thread.sleep(1000);*/
//		this.ProjectCreation.Clickingonattributebutton();
//		//Thread.sleep(1000);
//
//		// upto till up delete
//		this.ProjectCreation.Enteringattributename("ATT-1");
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattributetype();
//		Thread.sleep(1000);
//		this.ProjectCreation.Selectingattributetext();
//		Thread.sleep(1000);
//		this.ProjectCreation.Entering_att_text_value("Attribute Added");
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattsavebutton();
//		//Thread.sleep(1000);
//
//	}
//
//	@Test(priority = 19)
//	public void TC_19() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_19(Trying to add attribute_Number ");
//		/*this.CompaneyName();
//		test.createNode("Enterd Companey name");
//		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
//		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
//		this.ProjectCreation.Clickingonhomebutton();
//		Thread.sleep(1000);
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(1000);
//		this.ProjectCreation.GetprojectName("RC-17");
//		Thread.sleep(2000);
//		this.ProjectCreation.Go_button();*/
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattributebutton();
//		//Thread.sleep(1000);
//
//		// upto till up delete
//		this.ProjectCreation.Enteringattributename("ATT-2");
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattributetype();
//		Thread.sleep(1000);
//		this.ProjectCreation.Selectingattributenumber();
//		Thread.sleep(1000);
//		this.ProjectCreation.Entering_att_number_value("50");
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattsavebutton();
//		//Thread.sleep(1000);
//	}
//
//	@Test(priority = 20)
//	public void TC_20() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_20(Trying to add attribute_Date");
//		/*this.CompaneyName();
//		test.createNode("Enterd Companey name");
//		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
//		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
//		this.ProjectCreation.Clickingonhomebutton();
//		Thread.sleep(1000);
//		this.ProjectCreation.DropdownButton();
//		Thread.sleep(1000);
//		this.ProjectCreation.GetprojectName("RC-17");
//		Thread.sleep(2000);
//		this.ProjectCreation.Go_button();
//		Thread.sleep(1000);*/
//		this.ProjectCreation.Clickingonattributebutton();
//		//Thread.sleep(1000);
//
//		this.ProjectCreation.Enteringattributename("ATT-3");
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattributetype();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Selectingattributedate();
//		//Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattributedate();
//		//Thread.sleep(1000);
//		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(dtf.format(now));
//		String date = dtf.format(now).toString();
//		String[] date1 = date.split("/");
//
//		WebElement toDaysDate = driver.findElement(By.xpath(
//				"//table[contains(@class,'p-datepicker-calendar')]//tbody//td/span[not(contains(@class,'p-disabled')) and text()='"
//						+ date1[2] + "']"));
//		toDaysDate.click();
//	
//		//driver.findElement(By.xpath("//table[contains(@class,'p-datepicker-calendar')]//tbody//td/span[not(contains(@class,'p-disabled')) and text()='28']")).click();
//		this.ProjectCreation.Clickingonattsavebutton();
//	}
//
//	@Test(priority = 21)
//	public void TC_21() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_02_Project_Creation | TC_21(Trying to editing attribute");
//		this.ProjectCreation.Attributeeditbutton();
//		Thread.sleep(1000);
//		this.ProjectCreation.Selectingattributetext();
//
//		this.ProjectCreation.Editing_att_text_value("");
//		Thread.sleep(1000);
//		this.ProjectCreation.Entering_att_text_value("Edited");
//		Thread.sleep(1000);
//		this.ProjectCreation.Clickingonattsavebutton();
//	
//	}
	
}