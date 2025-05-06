package CHEMIASOFT.Chemia.login.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLoginPage {
	WebDriver driver;
	WebDriverWait wait;

	public CommonLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement UserName; // user name text field
	@FindBy(xpath = "//input[@name='password']")
	WebElement UserPassword; // password text field
	@FindBy(xpath = "//button[contains(text(),login)]")
	WebElement LoginButton;// Login button
	@FindBy(xpath = "//span[text()='Multiple Login']")
	WebElement MultipleLoginPopup; // multiple login popup
	// yes button on the multiple login popup
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement MultipleLoginPopupYesButton;
	// No button on the multiple login popup
	@FindBy(xpath = "//span[contains(text(),'No')]")
	WebElement MultipleLoginPopupNoButton;
	

	public void username(String data) {
		this.wait.until(ExpectedConditions.elementToBeClickable(UserName));
		this.UserName.clear();
		this.UserName.sendKeys(data);
	}

	public void userpassword(String data) {
		this.wait.until(ExpectedConditions.elementToBeClickable(UserPassword));
		UserPassword.clear();
		UserPassword.sendKeys(data);

	}

	public void loginbutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		this.LoginButton.click();
	}

	public void MutipleLoginpopupYesButton() {

		this.wait.until(ExpectedConditions.elementToBeClickable(MultipleLoginPopupYesButton));
		MultipleLoginPopupYesButton.click();
	}

	public void multipleloginpopup() {

		this.wait.until(ExpectedConditions.elementToBeClickable(MultipleLoginPopup));

	}
	public void login(String userName, String password) throws Exception {

		username(userName);
		userpassword(password);
		loginbutton();
		try {
			multipleloginpopup();
			MutipleLoginpopupYesButton();
			username(userName);
			userpassword(password);
			loginbutton();
		} catch (Exception e) {
			System.out.println("Multiple Login Popup Is not displayed..");
		}
//		this.mainPage.RandD();
//		Thread.sleep(5000);
	}
}
