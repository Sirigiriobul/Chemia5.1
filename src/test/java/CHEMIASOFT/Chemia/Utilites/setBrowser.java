package CHEMIASOFT.Chemia.Utilites;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Testcases.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class setBrowser {

	public static WebDriver browser() throws Exception {

		Utility myUtility = new Utility();
		WebDriver driver = null;

		if (myUtility.getDataFromProparties("browser").equalsIgnoreCase("chrome")) {
//			ChromeOptions options=new ChromeOptions();
//			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//			  Map<String, Object> prefs = new HashMap<>();
//		        prefs.put("profile.default_content_settings.popups", 0); // Disable popups
//		        prefs.put("download.default_directory", "C:\\Users\\swathi.boda\\Downloads"); // Set download directory
//		        prefs.put("download.prompt_for_download", false); // Do not prompt for download
//		        prefs.put("download.directory_upgrade", true); // Upgrade download directory if needed
//
//		        // Create ChromeOptions and set preferences
//		       
//		        options.setExperimentalOption("prefs", prefs);

		        // Initialize WebDriver with ChromeOptions
		        driver = DriverManager.getDriver();
		        } else if (myUtility.getDataFromProparties("browser").equalsIgnoreCase("edge")) {
			EdgeOptions options=new EdgeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver=new EdgeDriver(options);
		} else if (myUtility.getDataFromProparties("browser").equalsIgnoreCase("Firefox")) {
			FirefoxOptions options=new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver=new FirefoxDriver(options);
		} else {
			System.out.println("Inavlid browser");
		}
		return driver;
	}

}
