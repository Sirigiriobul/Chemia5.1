package CHEMIASOFT.Chemia.login.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	WebDriver driver;
	WebDriverWait wait;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	}

	@FindBy(xpath = "//h5[contains(text(),'Chemistry R&D')]")
	WebElement R_And_D; // Chemistry
	@FindBy(xpath = "//h5[contains(text(),'Analytical R&D')]")
	WebElement AR_And_D; // Chemistry

	@FindBy(xpath = "//h5[contains(text(),'Inventory')]")
	WebElement lie; // LIE

	@FindBy(xpath = "//h5[contains(text(),'Reports')]")
	WebElement reports; // Reports


	@FindBy(xpath = "//div[@id='myTopnav']//button[contains(.,' User ')]")
	WebElement UserDropdown; // User

	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	WebElement LogOutButton;
	
	@FindBy(xpath = "//button[contains(@class, 'p-dialog-header-close')]")
	WebElement popupClose_button;
	@FindBy(xpath = "//h2[normalize-space()='Experiments']")
	WebElement dashBoardDisplay;
	
	public void RandD() {
		this.wait.until(ExpectedConditions.elementToBeClickable(R_And_D));
		this.R_And_D.click();
	}
	public void ClickOnARDModule() {
		this.wait.until(ExpectedConditions.elementToBeClickable(AR_And_D));
		this.AR_And_D.click();
	}

	public void LIE() {
		this.wait.until(ExpectedConditions.elementToBeClickable(lie));
		this.lie.click();
	}

	public void Reports() {
		this.wait.until(ExpectedConditions.elementToBeClickable(reports));
		this.reports.click();
	}
	public boolean isdashboardDisplayed() {
		this.wait.until(ExpectedConditions.elementToBeClickable(dashBoardDisplay));
		return dashBoardDisplay.isDisplayed();	
		}
	public void closePopup() {
		this.wait.until(ExpectedConditions.elementToBeClickable(popupClose_button));
		popupClose_button.click();
		}//closePopup
	
	
	
	public void logout() {
		try {
			closePopup();
		} catch (Exception e) {
			System.out.println("No popups present in the page to close.");
		}
		this.wait.until(ExpectedConditions.elementToBeClickable(UserDropdown));
			this.UserDropdown.click();
			this.wait.until(ExpectedConditions.elementToBeClickable(LogOutButton));
			this.LogOutButton.click();
		
	}

}
