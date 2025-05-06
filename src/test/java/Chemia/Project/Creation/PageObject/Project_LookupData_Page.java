package Chemia.Project.Creation.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project_LookupData_Page {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public Project_LookupData_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
}
	@FindBy(xpath = "//span[contains(text(),'ADD')]")
	WebElement add_button;
	
	public void clickOnAdd_Lookup() {
		try {
			Thread.sleep(2000);
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollBy(0, document.body.scrollHeight);");
			wait.until(ExpectedConditions.elementToBeClickable(add_button));
			
			action = new Actions(driver);
			action.moveToElement(add_button).build().perform();
			add_button.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.print("Unable to Click on Add Button in Experiments");
		}
	}//clickOnAdd_Lookup
	
}
