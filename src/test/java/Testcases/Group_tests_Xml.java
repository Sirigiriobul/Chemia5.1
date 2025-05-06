package Testcases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.CRD_Left_Menu_Tabs;
import CHEMIASOFT.Chemia.Embedded_Excel.PageObjects.Embedded_Excel_Temp_Page;
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

public class Group_tests_Xml {
	
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
	@BeforeSuite
	// In before suite we will call the browser & pass the URL to open the
	// application
	// also maximize the browser
	public void beforeclass() throws Exception {

		System.out.println("Suit executed & starting the browser");
		this.Myutility = new Utility();
		this.driver = setBrowser.browser();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		driver.get(this.Myutility.getDataFromProparties("URL"));
//		int searchDataSheetNum=Myutility.getSheetNumber("Search Data");
//		 Map<String, Object> searchData=Myutility.prepareRowData(1, searchDataSheetNum);
//		
//		this.login(this.Myutility.LoadXLfile(0, 1, 1), this.Myutility.LoadXLfile(0, 1, 3));
//		test.log(Status.PASS, "loged in with user ID = " + this.Myutility.LoadXLfile(0, 1, 1));
	}
	@BeforeMethod
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

	@AfterClass
	// In after suite we quite the driver. That means we close the browser

	public void afterClass() {
		System.out.println("Suit completed");
		logout();
		driver.quit();
	}

  
    // Sample Test 1 (Group: smoke, Priority: 1)
    @Test(groups = "smoke", priority = 1)
    public void testSmoke() throws Exception {
//        try {
//            // Simulating the test logic
//            System.out.println("Executing Regression Test");
//
//            
//        } catch (Exception e) {
//       	 System.out.println("testSmoke Failed");
//
//        }
    	this.CompaneyName();
		int sheetNum=Myutility.getSheetNumber("Projectdata");
		 Map<String, Object> rowData=Myutility.prepareRowData(1, sheetNum);
			System.out.println("Project RowData "+rowData);

		String Username=(String) rowData.get("UserName");
		String password=(String) rowData.get("Password");
		this.login(Username,password);
		driver.navigate().refresh();
    }

    // Sample Test 2 (Group: regression, Priority: 2)
    @Test(groups = "regression", priority = 2)
    public void testRegression() {
        try {
            // Simulating the test logic
            System.out.println("Executing Regression Test");

            
        } catch (Exception e) {
        	 System.out.println("testRegression Failed");
        }
    }

    // Sample Test 3 (Group: smoke, Priority: 3)
    @Test(groups = "smoke", priority = 3)
    public void testSmoke3() {
        try {
            // Simulating the test logic
            System.out.println("Executing testSmoke3 ");

            
        } catch (Exception e) {
       	 System.out.println("testSmoke3 Failed");

        }
    }

    // Sample Test 4 (Group: sanity, Priority: 4)
    @Test(groups = "sanity", priority = 4)
    public void testSanity() {
        try {
            // Simulating the test logic
            System.out.println("Executing testSanity ");

            
        } catch (Exception e) {
       	 System.out.println("testSanity Failed");
        }
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

}
