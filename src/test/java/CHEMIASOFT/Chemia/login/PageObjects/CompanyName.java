package CHEMIASOFT.Chemia.login.PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyName {

	WebDriverWait wait;
	WebDriver driver;

	// Constructor
	public CompanyName(WebDriver driver) {
		// to initialize the constructor
		this.driver = driver;
		// To initialize the elements on the class
		PageFactory.initElements(driver, this);
		// Wait statement for explicit wait
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@FindBy(xpath = "//input[@type='text']")
	WebElement compName;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement nextButton;

	// methods
	public void Companey_name(String data) {
		this.wait.until(ExpectedConditions.elementToBeClickable(compName));
		this.compName.sendKeys(data);

	}

	public void nextButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		nextButton.click();
	}
	public void CompaneyName(String name) throws Exception {
		System.out.println(name);
		Companey_name(name);
		nextButton();

	}


}
