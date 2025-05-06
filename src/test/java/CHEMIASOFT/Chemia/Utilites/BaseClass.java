package CHEMIASOFT.Chemia.Utilites;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.CRD_Left_Menu_Tabs;
import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.Embedded_Excel_Temp_Page;
import CHEMIASOFT.Chemia.login.PageObjects.CommonLoginPage;
import CHEMIASOFT.Chemia.login.PageObjects.CompanyName;
import CHEMIASOFT.Chemia.login.PageObjects.MainPage;
import Chemia.Project.Creation.PageObject.Project_AuditTrail_Page;
import Chemia.Project.Creation.PageObject.Project_Creation_Page;
import Chemia.Project.Creation.PageObject.Project_NoteBook_Page;
import Chemia.Project.Creation.PageObject.Project_Users_Page;

public class BaseClass {
protected Utility Myutility;
protected WebDriver driver;
// Actions actions = new Actions (driver);

protected CompanyName cname; // Company Name Page
public CommonLoginPage loginpage; // Login Page
public MainPage mainPage;
public CRD_Left_Menu_Tabs LeftMenuIcon;
public Project_Creation_Page ProjectCreation;
public Project_NoteBook_Page projectNotebook;
public Project_Users_Page projectUsers;
public Embedded_Excel_Temp_Page ExcelTemplate;
public Project_AuditTrail_Page AuditTrail;
@BeforeSuite
// In before suite we will call the browser & pass the URL to open the
// application
// also maximize the browser
public void beforesuite() throws Exception {

	System.out.println("Suit executed & starting the browser");
	Myutility = new Utility();
	this.driver = setBrowser.browser();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.navigate().refresh();
	driver.get(this.Myutility.getDataFromProparties("URL"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}

@AfterSuite
// In after suite we quite the driver. That means we close the browser

public void afterSuite() {
	System.out.println("Suit completed");
	//this.driver.quit();
	  if (driver != null) {
          driver.quit();
      }
}

// Extent Reports
public ExtentSparkReporter spark;
public ExtentReports extent;
public ExtentTest test;

@BeforeClass
// In before Class we create the extent report & attach the screen short to the
// report
// At the same time we also give more info about like which browser is used, who
// tested etc by using

public void beforeclass() throws Exception {
	
	// Formating the data
	String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
	// creates one extent report on the given path
	this.spark = new ExtentSparkReporter(
			Myutility.PathOfReport() + "/" + date + " " + "TS_Chemia_CRD_04.html");
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
	this.mainPage = new MainPage(driver); // Main Page
	this.ProjectCreation = new Project_Creation_Page(driver);
	this.projectNotebook=new Project_NoteBook_Page(driver);
	this.projectUsers = new Project_Users_Page(driver);
	this.ExcelTemplate = new Embedded_Excel_Temp_Page(driver);
	this.AuditTrail    = new Project_AuditTrail_Page (driver);
	

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

	}
	if (result.getStatus() == ITestResult.FAILURE) {
		test.log(Status.FAIL, result.getName() + "Test Case is Failed  ");
		test.log(Status.FAIL, "Test Case is Faild due to  " + result.getThrowable());
		String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
		test.addScreenCaptureFromPath(screenshortpath);

	}
	if (result.getStatus() == ITestResult.SKIP) {
		test.log(Status.SKIP, "Test Case Skiped is " + result.getName());
		String screenshortpath = CaptureScreenShot.GetScreenShort(driver, result.getName());
		test.addScreenCaptureFromPath(screenshortpath);

	}

}

public void CompaneyName() throws Exception {
	System.out.println(this.Myutility.getDataFromProparties("Companeyname"));
	cname.Companey_name(this.Myutility.getDataFromProparties("Companeyname"));
	cname.nextButton();
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
}

public void logout() {

	this.mainPage.logout();

}

}
