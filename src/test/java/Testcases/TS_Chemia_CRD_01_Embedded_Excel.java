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
import CHEMIASOFT.Chemia.Utilites.CaptureScreenShot;
import CHEMIASOFT.Chemia.Utilites.Utility;
import CHEMIASOFT.Chemia.Utilites.setBrowser;
import CHEMIASOFT.Chemia.login.PageObjects.CommonLoginPage;
import CHEMIASOFT.Chemia.login.PageObjects.CompanyName;
import CHEMIASOFT.Chemia.login.PageObjects.MainPage;

public class TS_Chemia_CRD_01_Embedded_Excel {
	Utility Myutility;
	WebDriver driver;
	// Actions actions = new Actions
	// (driver);D:\eclipse\automation\Chemia\Documents\Chemia PDF.pdf

	CompanyName cname; // Company Name Page
	CommonLoginPage loginpage; // Login Page
	MainPage mainpage; // Main Page
	CRD_Left_Menu_Tabs LeftMenuIcon; // Left Menu
	Embedded_Excel_Temp_Page ExcelTemplate;

	// Excel Sheet
	int ColumnNumber = 11;
	int RowNumber = 1;
	int SheetNumber = 1;

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

	//@AfterSuite
	// In after suite we quite the driver. That means we close the browser

	public void afterSuite() {
		System.out.println("Suit completed");
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
				this.Myutility.PathOfReport() + "/" + date + " " + "TS_Chemia_CRD_01.html");
		// Setting title for the document
		spark.config().setDocumentTitle("Chemia | CRD Automation Report");// title of the report
		// Setting name of the report
		spark.config().setReportName("CRD Master data | Embedded Excel Template ");// name of the
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
		this.LeftMenuIcon = new CRD_Left_Menu_Tabs(driver); // Left menu
		this.ExcelTemplate = new Embedded_Excel_Temp_Page(driver);
//		this.test = extent
//				.createTest("Login with credentials");
		this.CompaneyName();
//		test.createNode("Enterd Companey name");
		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
		//test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
		this.LeftMenuIcon.clickonLeftMenuIcon();
		this.LeftMenuIcon.MasterData();
		this.LeftMenuIcon.EmbeddedExcelTemplate();
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
		this.LeftMenuIcon = new CRD_Left_Menu_Tabs(driver); // Left menu
		this.ExcelTemplate = new Embedded_Excel_Temp_Page(driver);
//		this.test = extent
//				.createTest("Login with credentials");
//		this.CompaneyName();
//		test.createNode("Enterd Companey name");
//		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
//		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
//		driver.navigate().refresh();

		
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

			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), SheetNumber, RowNumber, ColumnNumber,
					String.valueOf(Status.PASS));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), SheetNumber, RowNumber, ColumnNumber + 1,
					screenshortpath.substring(46));

		}
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName() + "Test Case is Failed  ");
			test.log(Status.FAIL, "Test Case is Faild due to  " + result.getThrowable());
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);

			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), SheetNumber, RowNumber, ColumnNumber,
					String.valueOf(Status.FAIL));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), SheetNumber, RowNumber, ColumnNumber + 1,
					screenshortpath.substring(46));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), SheetNumber, RowNumber, ColumnNumber + 2,
					"Test Case is failed due to  " + result.getThrowable());

		}
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skiped is " + result.getName());
			String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
			test.addScreenCaptureFromPath(screenshortpath);

			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), SheetNumber, RowNumber, ColumnNumber,
					String.valueOf(Status.SKIP));
			Myutility.writeOnFTSexcelFile(this.Myutility.TestCaseXLPath(), SheetNumber, RowNumber, ColumnNumber + 1,
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
		this.mainpage.RandD();
	}

	public void logout() {

		this.mainpage.logout();

	}
//for loop for outer and inner loop

	@Test(priority = 1)
	public void TC_1() throws Exception {
		this.test = extent
				.createTest("TS_Chemia_CRD_01 | TC_1(Adding Embedded Excel Template without mandatory fields)");
//		this.CompaneyName();
//		test.createNode("Enterd Companey name");
//		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
//		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
//		this.LeftMenuIcon.clickonLeftMenuIcon();
//		this.LeftMenuIcon.MasterData();
//		this.LeftMenuIcon.EmbeddedExcelTemplate();
		Thread.sleep(3000);
		this.ExcelTemplate.ClickOnAddButton();
		this.ExcelTemplate.SaveButtonOnuploadexceltemplate();
		System.out.println("Message:"+this.ExcelTemplate.GetTostMessage());
		Assert.assertEquals(this.ExcelTemplate.GetTostMessage(), "Please enter the mandatory field!");

	}

	@Test(priority = 2)
	public void TC_2() throws Exception {
		this.test = extent
				.createTest("TS_Chemia_CRD_01 | TC_2(Adding Embedded Excel Template without uploading the file)");
		driver.navigate().refresh();
		this.ExcelTemplate.ClickOnAddButton();
		this.ExcelTemplate.TemplateName("Excel Template-03");
		//Thread.sleep(2000);
		this.ExcelTemplate.SaveButtonOnuploadexceltemplate();
		//Thread.sleep(2000);

	}

//	@Test(priority = 3)
//	public void TC_3() throws Exception {
//		this.test = extent.createTest("TS_Chemia_CRD_01 | TC_3(Adding Embedded Excel Template with word file)");
//		driver.navigate().refresh();
//		this.ExcelTemplate.ClickOnAddButton();
//		this.ExcelTemplate.TemplateName("Excel Template-03");
//		this.ExcelTemplate.Description("Added");
//		this.ExcelTemplate.Upload_Button();
//		this.Myutility.Uploadfile(this.Myutility.DocumentPath()); //
//		Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 4)
//	public void TC_4() throws Exception {
//		this.test = extent.createTest("TS_Chemia_CRD_01 | TC_4(Adding Embedded Excel Template with PDF file)");
//		driver.navigate().refresh();
//		this.ExcelTemplate.ClickOnAddButton();
//		this.ExcelTemplate.TemplateName("Excel Template-03");
//		this.ExcelTemplate.Description("Added");
//		this.ExcelTemplate.Upload_Button();
//		this.Myutility.Uploadfile(this.Myutility.PDFPath()); //
//		Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 5)
//	public void TC_5() throws Exception {
//		this.test = extent.createTest("TS_Chemia_CRD_01 | TC_5(Adding Embedded Excel Template with JPG file)");
//		driver.navigate().refresh();
//		this.ExcelTemplate.ClickOnAddButton();
//		this.ExcelTemplate.TemplateName("Excel Template-03");
//		this.ExcelTemplate.Description("Added");
//		this.ExcelTemplate.Upload_Button();
//		this.Myutility.Uploadfile(this.Myutility.JPGPath()); //
//		Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 6)
//	public void TC_6() throws Exception {
//		this.test = extent.createTest("TS_Chemia_CRD_01 | TC_6(Adding Embedded Excel Template with XLSX file)");
//		driver.navigate().refresh();
//		Thread.sleep(3000);
//		this.ExcelTemplate.ClickOnAddButton();
//		this.ExcelTemplate.TemplateName("Excel Template-03");
//		this.ExcelTemplate.Description("Added");
//		this.ExcelTemplate.Upload_Button();
//		this.Myutility.Uploadfile(this.Myutility.xlsxPath());
//		Thread.sleep(2000);
//		this.ExcelTemplate.SaveButtonOnuploadexceltemplate(); // Clickonsavebutton();
//		Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 7)
//	public void TC_7() throws Exception {
//		this.test = extent.createTest("TS_Chemia_CRD_01 | TC_7(Adding same template name for Embedded Excel Template)");
//		driver.navigate().refresh();
//		Thread.sleep(3000);
//		this.ExcelTemplate.ClickOnAddButton();
//		this.ExcelTemplate.TemplateName("Excel Template-03");
//		this.ExcelTemplate.Description("Added");
//		this.ExcelTemplate.Upload_Button();
//		this.Myutility.Uploadfile(this.Myutility.xlsxPath());
//		Thread.sleep(2000);
//		this.ExcelTemplate.SaveButtonOnuploadexceltemplate(); //
//		// this.ExcelTemplate.Clickonclosebutton();
//		Assert.assertEquals(this.ExcelTemplate.GetTostMessage(),
//				"Template with this name already exist. Kindly enter some unique name. !!");
//		//Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 8)
//	public void TC_8() throws Exception {
//		this.test = extent
//				.createTest("TS_Chemia_CRD_01 | TC_8(Modifying an Embedded Excel Template with out mandatory fields)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		// outer loop for navigating through pages
//		for (j = 1; j < 4; j++) {
//
//			// Inner loop for iterating & comparing the XL template names
//			for (i = 1; i <= 10; i++) {
//
//				// comparing the stored value & breaking the inner loop when found
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//		// this.ExcelTemplate.Pagenextbutton();
//		//Thread.sleep(1000);
//		this.ExcelTemplate.EditButton(i);
//		System.out.println("Template name found");
//		//Thread.sleep(10000);
//		this.ExcelTemplate.TemplateNameClear();
//		//Thread.sleep(2000);
//		this.ExcelTemplate.UpdateexcelsaveButton();
//		//Thread.sleep(2000);
//		Assert.assertEquals(this.ExcelTemplate.GetTostMessage(), "Please enter the mandatory field!");
//		//Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 9)
//	public void TC_9() throws Exception {
//		this.test = extent.createTest("TS_Chemia_CRD_01 | TC_9(Modifying an Embedded Excel Template with Word fields)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		for (j = 1; j < 3; j++) {
//
//			for (i = 1; i <= 10; i++) {
//
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//		//Thread.sleep(1000);
//		this.ExcelTemplate.EditButton(i);
//	//	Thread.sleep(1000);
//		this.ExcelTemplate.Upload_Button();
//		this.Myutility.Uploadfile(this.Myutility.DocumentPath());
//		// this.ExcelTemplate.Clickonclosebutton();
//		Assert.assertEquals(this.ExcelTemplate.GetTostMessage(), "Invalid File Type, Kindly select (.xlsx) file.");
//	//	Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 10)
//	public void TC_10() throws Exception {
//		this.test = extent.createTest("TS_Chemia_CRD_01 | TC_10(Modifying an Embedded Excel Template with PDF fields)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		for (j = 1; j < 3; j++) {
//
//			for (i = 1; i <= 10; i++) {
//
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//		//Thread.sleep(1000);
//		this.ExcelTemplate.EditButton(i);
//	//	Thread.sleep(1000);
//		this.ExcelTemplate.Upload_Button();
//		
//		this.Myutility.Uploadfile(this.Myutility.PDFPath());
//		// this.ExcelTemplate.Clickonclosebutton();
//		Thread.sleep(2000);
//		Assert.assertEquals(this.ExcelTemplate.GetTostMessage(), "Invalid File Type, Kindly select (.xlsx) file.");
//
//	}
//
//	@Test(priority = 11)
//	public void TC_11() throws Exception {
//		this.test = extent.createTest("TS_Chemia_CRD_01 | TC_11(Modifying an Embedded Excel Template with JPG fields)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		for (j = 1; j < 3; j++) {
//
//			for (i = 1; i <= 10; i++) {
//
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//		//Thread.sleep(1000);
//		this.ExcelTemplate.EditButton(i);
//		//Thread.sleep(1000);
//		this.ExcelTemplate.Upload_Button();
//		this.Myutility.Uploadfile(this.Myutility.JPGPath());
//		// this.ExcelTemplate.Clickonclosebutton();
//		Assert.assertEquals(this.ExcelTemplate.GetTostMessage(), "Invalid File Type, Kindly select (.xlsx) file.");
//		//Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 12)
//	public void TC_12() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_01 | TC_12(Modifying an Embedded Excel Template with existing template name)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		for (j = 1; j < 3; j++) {
//
//			for (i = 1; i <= 10; i++) {
//
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//		//Thread.sleep(3000); // this.ExcelTemplate.Pagenextbutton();
//		this.ExcelTemplate.EditButton(i);
//		this.ExcelTemplate.TemplateNameClear();
//		this.ExcelTemplate.TemplateName("Excel-3");
//		this.ExcelTemplate.UpdateexcelsaveButton();
//		Thread.sleep(2000);
//		Assert.assertEquals(this.ExcelTemplate.GetTostMessage(),
//				"Template with this name already exist. Kindly enter some unique name. !!");
//
//	}
//
//	@Test(priority = 13)
//	public void TC_13() throws Exception {
//		this.test = extent
//				.createTest("TS_Chemia_CRD_01 | TC_13(Clicking on preview button for Embedded Excel Template)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		for (j = 1; j < 3; j++) {
//
//			for (i = 1; i <= 10; i++) {
//
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//		//Thread.sleep(2000);
//		this.ExcelTemplate.PreviewButton();
//		//Thread.sleep(2000); // this.ExcelTemplate.Previewclosebutton();
//
//	}
//
//	@Test(priority = 14)
//	public void TC_14() throws Exception {
//		this.test = extent
//				.createTest("TS_Chemia_CRD_01 | TC_14(Clicking on download button for Embedded Excel Template)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		for (j = 1; j < 3; j++) {
//
//			for (i = 1; i <= 10; i++) {
//
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//		//Thread.sleep(1000);
//		this.ExcelTemplate.PreviewButton();
//		//Thread.sleep(2000);
//		this.ExcelTemplate.DownloadButton();
//		Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 15)
//	public void TC_15() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_01 | TC_15(Disable popup Clicking on cancel button for Embedded Excel Template)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		for (j = 1; j < 3; j++) {
//
//			for (i = 1; i <= 10; i++) {
//
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//		//Thread.sleep(2000);
//		// this.ExcelTemplate.ToggleButton(i);
//		this.ExcelTemplate.DisableButton(i);
//		this.ExcelTemplate.DisablepopupcancelButton();
//		//Thread.sleep(2000);
//	}
//
//	@Test(priority = 16)
//	public void TC_16() throws Exception {
//		this.test = extent.createTest(
//				"TS_Chemia_CRD_01 | TC_16(Disable popup Clicking on save button for Embedded Excel Template)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		for (j = 1; j < 3; j++) {
//
//			for (i = 1; i <= 10; i++) {
//
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//		//Thread.sleep(2000);
//		// this.ExcelTemplate.ToggleButton(i);
//		this.ExcelTemplate.DisableButton(i);
//		this.ExcelTemplate.DisablepopupsaveButton();
//		//Thread.sleep(2000);
//	}
//
//	@Test(priority = 17)
//	public void TC_17() throws Exception {
//		this.test = extent
//				.createTest("TS_Chemia_CRD_01 | TC_17(Clicking on enable button for Embedded Excel Template)");
//		driver.navigate().refresh();
//		boolean found = false;
//		int i = 0;
//		int j = 0;
//
//		for (j = 1; j < 3; j++) {
//
//			for (i = 1; i <= 10; i++) {
//
//				if (this.ExcelTemplate.GetTemplateName(i).equals(this.Myutility.TemplateDataXLpath(1, 1, 0))) {
//					System.out.println(this.ExcelTemplate.GetTemplateName(i));
//					System.out.println("Template name found  " + i);
//					found = true;
//					break;
//				}
//
//			}
//			// Breaking the outher loop after breaking the inner loop imeadiatly
//			if (found) {
//				break;
//			} else {
//				// clicks on next page button if the inner loop not braked
//				this.ExcelTemplate.Pagenextbutton();
//
//			}
//		}
//
//		//Thread.sleep(2000);
//		this.ExcelTemplate.DisableButton(i);
//		//Thread.sleep(2000);
//	}

}
