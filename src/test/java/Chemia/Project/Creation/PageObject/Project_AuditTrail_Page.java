package Chemia.Project.Creation.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project_AuditTrail_Page {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public Project_AuditTrail_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	@FindBy(xpath = "//tbody//tr[1]//td[contains(@class,'EventDetails')]")
	WebElement firstRoweventDetails; // Tost Message for notebook level

	public String getFirstEventDetails() {
		this.wait.until(ExpectedConditions.elementToBeClickable(firstRoweventDetails));
		return this.firstRoweventDetails.getText();
	}
	
	
	
	
	
	
}//Project_AuditTrail_Page
