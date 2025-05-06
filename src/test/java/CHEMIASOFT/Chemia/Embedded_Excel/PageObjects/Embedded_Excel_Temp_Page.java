package CHEMIASOFT.Chemia.Embedded_Excel.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Embedded_Excel_Temp_Page {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public Embedded_Excel_Temp_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@FindBy(xpath = "//div[contains(@class,'p-toast-summary')]")
	WebElement TostMessage; // Tost Message

	public String GetTostMessage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(TostMessage));
		return this.TostMessage.getText();
	}
	
	@FindBy(xpath = "//div[contains(@class,'p-toast-detail')]")
	WebElement TostMessageNotebook; // Tost Message for notebook level

	public String GetTostMessageForNotebook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(TostMessageNotebook));
		System.out.print("Toast message: "+this.TostMessageNotebook.getText());
		return this.TostMessageNotebook.getText();
	}

	@FindBy(xpath = "//mat-icon[@mattooltip='Add']")
	WebElement AddEmbeddedexcelbutton; // add button for embedded exceltemplate

	public void ClickOnAddButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(AddEmbeddedexcelbutton));
		AddEmbeddedexcelbutton.click();

	}

	@FindBy(xpath = "//span[contains(text(), ' Save ')]")
	WebElement SaveButtonOnuploadexceltemplate; // save button for upload excel template

	public void SaveButtonOnuploadexceltemplate() {
		this.wait.until(ExpectedConditions.elementToBeClickable(SaveButtonOnuploadexceltemplate));
		SaveButtonOnuploadexceltemplate.click();
	}

	@FindBy(id = "tempSaveCancelId")
	WebElement Cancelbuttonforuploadexceltemplate; // save button for upload excel template

	public void Clickoncancelbutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Cancelbuttonforuploadexceltemplate));
		Cancelbuttonforuploadexceltemplate.click();
	}

	@FindBy(css = "span[class*='p-dialog-header']")
	WebElement Closebuttonforuploadexceltemplate; // save button for upload excel template

	public void Clickonclosebutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Closebuttonforuploadexceltemplate));
		Closebuttonforuploadexceltemplate.click();
	}

	@FindBy(xpath = "//input[@id='templateNameId']")
	WebElement TemplateName;

	public void TemplateName(String Value) {
		this.wait.until(ExpectedConditions.elementToBeClickable(TemplateName));
		this.TemplateName.sendKeys(Value);

	}

	public String GetTemplateName(int i) {
		return this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[2]"))))
				.getText().trim();

	}

	@FindBy(xpath = "//input[@id='templateNameId']")
	// "//input[@id='templateNameId']")
	WebElement TemplateNameClear;

	public void TemplateNameClear() {
		this.wait.until(ExpectedConditions.elementToBeClickable(TemplateNameClear));
		//this.TemplateNameClear.clear();
		TemplateNameClear.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text   
		TemplateNameClear.sendKeys(Keys.BACK_SPACE); // Delete selected text
		
	}

	
	@FindBy(id = ("descId"))
	WebElement Description;

	public void Description(String Data) {
		this.wait.until(ExpectedConditions.elementToBeClickable(Description));
		this.Description.sendKeys(Data);

	}

	@FindBy(id = "formFileLg")
	WebElement Upload_Button;

	public void Upload_Button() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Upload_Button));
		this.Upload_Button.click();

	}
/*
	@FindBy(xpath = "//tbody//tr[1]//mat-slide-toggle")
	WebElement ToggleButton;

	public void ToggleButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ToggleButton));
		this.ToggleButton.click();
	}
*/
	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement DisablepopupsaveButton;

	public void DisablepopupsaveButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(DisablepopupsaveButton));
		this.DisablepopupsaveButton.click();
	}

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement DisablepopupcancelButton;

	public void DisablepopupcancelButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(DisablepopupcancelButton));
		this.DisablepopupcancelButton.click();
	}

	public void EnableButton(int i) {
		 this.wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr[" + i + "]//mat-slide-toggle]"))))
				.click();
	}

	public void DisableButton(int i) {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr[" + i + "]//mat-slide-toggle"))))
				.click();

	}

	public void EditButton(int i) {
		this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr[" + i + "]//mat-icon[1]"))))
				.click();

	}
	public void ToggleButton(int i) {
		this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr[" + i + "]//mat-icon[3]"))))
				.click();

	}
	
	
	
	
	
	@FindBy(xpath = "//button[@id='tempSavessId']")
	// tbody//tr[5]//mat-icon[@title='Show']
	WebElement UpdateexcelsaveButton;

	public void UpdateexcelsaveButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(UpdateexcelsaveButton));
		this.UpdateexcelsaveButton.click();
	}

	@FindBy(css = "#preEmb1")
	// tbody//tr[5]//mat-icon[@title='Show']
	WebElement PreviewButton;

	public void PreviewButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(PreviewButton));
		this.PreviewButton.click();
	}

	@FindBy(xpath = "//button[@aria-label='Download the Excel Template']")
	WebElement DownloadButton;

	public void DownloadButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(DownloadButton));
		this.DownloadButton.click();
	}

	@FindBy(xpath = "//span[@class='p-dialog-header-close-icon ng-tns-c61-37 pi pi-times']")
	WebElement Previewclosebutton;

	public void Previewclosebutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Previewclosebutton));
		Previewclosebutton.click();
	}

	@FindBy(xpath = "//button[contains(@aria-label,'Next page')]")
	WebElement Pagenextbutton;

	public void Pagenextbutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Pagenextbutton));
		Pagenextbutton.click();
	}

	/*
	 * @FindBy(xpath = "//tbody//tr[1]//mat-slide-toggle") WebElement ToggleButton;
	 * 
	 * public void ToggleButton() {
	 * this.wait.until(ExpectedConditions.elementToBeClickable(ToggleButton));
	 * this.ToggleButton.click(); }
	 * 
	 */

}
