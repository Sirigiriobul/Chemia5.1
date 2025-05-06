package Testcases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import CHEMIASOFT.Chemia.Utilites.Utility;

public class DriverManager {
	static Utility Myutility= new Utility();

    // Step 1: Create a private static instance of WebDriver
    private static WebDriver driver = null;

    // Step 2: Private constructor to prevent instantiation
    private DriverManager() {
    }

    // Step 3: Provide a public static method to get the instance of WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize the WebDriver if it is null
            // Here we use ChromeDriver, but you can choose others like FirefoxDriver
//            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            String downloadFilepath =Myutility.downloads_path() ;
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", downloadFilepath);
            prefs.put("download.prompt_for_download", false);
            prefs.put("safebrowsing.enabled", true);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

             driver = new ChromeDriver(options);
//		     driver = new ChromeDriver();
            // Configure driver options here if needed
        }
        return driver;
    }

    // Optional: Method to close the driver and clean up resources
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the driver to null to allow re-initialization
        }
    }
}
