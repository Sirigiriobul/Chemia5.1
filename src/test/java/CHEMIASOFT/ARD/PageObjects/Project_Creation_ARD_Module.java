package CHEMIASOFT.ARD.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project_Creation_ARD_Module {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor js;
	public Project_Creation_ARD_Module(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
}
	
	public void addProjecticon() {
		
		WebElement element = driver.findElement(By.xpath("//mat-icon[text()='add']"));//5.1 changes
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait
		.until(ExpectedConditions
				.elementToBeClickable(element))
		.click();

	}
	public void GetprojectName(String ProjectName) {
		
		List<WebElement> AllProjectNames = driver.findElements(By.xpath("//li[@role='option']"));
		
		for(WebElement IndiviualProjectName : AllProjectNames) {
			
			String ProjectCode = IndiviualProjectName.getText().split(" ")[0].trim(); 
			
			if(ProjectCode.equals(ProjectName)) {
				
				wait.until(ExpectedConditions.elementToBeClickable(IndiviualProjectName));
				IndiviualProjectName.click();
				break;
				
			}}
	}
	@FindBy(xpath = "//span[@class='button-text']")
	WebElement Go_button; //Clicking on add project icon 

	public void Go_button() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Go_button));
		this.Go_button.click();

	}
	
	@FindBy(xpath = "//span[text()=' Save']")
	WebElement Clickingonsavebutton; 

	public void Clickingonsavebutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Clickingonsavebutton));
		this.Clickingonsavebutton.click();

	}
	@FindBy(xpath = "//button[@id='backToDashboardId']")
	WebElement Clickingoncancelbutton; 

	public void Clickingoncancelbutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Clickingoncancelbutton));
		this.Clickingoncancelbutton.click();

	}

	@FindBy(xpath = "//input[@formcontrolname='productName']")
	WebElement ProductName; //Clicking on add project icon 

	public void ProductName(String value) {
		this.wait.until(ExpectedConditions.elementToBeClickable(ProductName));
		this.ProductName.sendKeys(value);

	}

	@FindBy(xpath = "//input[@formcontrolname='projectCode']")
	WebElement ProductNameClear;

	public void ProductNameClear() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ProductNameClear));
		this.ProductNameClear.clear();

	}
	
	@FindBy(xpath = "//input[@formcontrolname='projectCode']")
	WebElement ProjectCode; //Clicking on add project icon 

	public void ProjectCode(String value) {
		this.wait.until(ExpectedConditions.elementToBeClickable(ProjectCode));
		this.ProjectCode.sendKeys(value);

	}
	
	@FindBy(xpath = "//input[@formcontrolname='projName']")
	WebElement ProjectCodeClear;

	public void ProjectCodeClear() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ProjectCodeClear));
		this.ProjectCodeClear.clear();

	}
	

	@FindBy(xpath = "//input[@formcontrolname='customeorMarket']")
	WebElement customeorMarket; //Clicking on add project icon 

	public void customeorMarket(String value) {
		this.wait.until(ExpectedConditions.elementToBeClickable(customeorMarket));
		this.customeorMarket.sendKeys(value);

	}
	
	@FindBy(xpath = "//input[@formcontrolname='apiType']")
	WebElement ProjectType; //Clicking on add project icon 

	public void ProjectType(String value) {
		this.wait.until(ExpectedConditions.elementToBeClickable(ProjectType));
		this.ProjectType.sendKeys(value);

	}
	
	@FindBy(xpath = "//input[@formcontrolname='apiType']")
	WebElement ProjectTypeClear;

	public void ProjectTypeClear() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ProjectTypeClear));
		this.ProjectTypeClear.clear();

	}
	

	@FindBy(xpath = "//textarea[@inputid='descriptionTextarea']")
	WebElement EnteringDescription; //Clicking on add project icon 

	public void EnteringDescription(String value) {
		this.wait.until(ExpectedConditions.elementToBeClickable(EnteringDescription));
		EnteringDescription.click();
		this.EnteringDescription.sendKeys(value);

	}


	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	WebElement DescriptionClear;

	public void DescriptionClear() {
		this.wait.until(ExpectedConditions.elementToBeClickable(DescriptionClear));
		this.DescriptionClear.clear();

	}
	
	@FindBy(xpath = "//span[text()=' Yes ']")
	WebElement Clickingondefaultnotebookyesbutton; //Clicking on add project icon 

	public void Clickingondefaultnotebookyesbutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Clickingondefaultnotebookyesbutton));
		this.Clickingondefaultnotebookyesbutton.click();
	
	}
	@FindBy(xpath = "//mat-icon[normalize-space()='home']")
	WebElement Clickingonhomebutton; //Clicking on add project icon 

	public void Clickingonhomebutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Clickingonhomebutton));
		this.Clickingonhomebutton.click();


	}
	@FindBy(xpath = "//p-dropdown[@id='projectListId']")
	WebElement Clickingondropdown; //Clicking on add project icon 

	public void Clickingondropdown() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Clickingondropdown));
		this.Clickingondropdown.click();
	}
	public void Clickingonattributebutton() {
		WebElement attrbute_button = driver.findElement(By.xpath("//mat-icon[@id='addAttrButton']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", attrbute_button);
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(attrbute_button))
				.click();
		
	}
	
	public void Clickingonattributetype() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='changeAttributeValueTable']"))))
				.click();
		
	}
	
	public void Clickingonattsavebutton() {
		WebElement element=driver.findElement(By.xpath("//button[@id='SaveAttr_btn']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);//5.1Change
		
	}
	public void Clickingonattcancelbutton() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//button[@id='cancel']"))))
				.click();
		
	}
	
	public void Enteringattributename(String value) {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//input[@id='attributeNameInputtext']"))))
				.sendKeys(value);
		
	}
	public void Selectingattributetext() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[text()='TEXT']"))))
				.click();
	}
	
	public void Entering_att_text_value(String value) {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//input[@id='attValueid']"))))
				.sendKeys(value);
	}
	
	public void Editing_att_text_value(String value) {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//input[@id='attValueid']"))))
				.clear();
	}
	
	
	public void Selectingattributenumber() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[text()='NUMBER']"))))
				.click();
	}
	public void Entering_att_number_value(String value) {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//input[@id='numberinputtext']"))))
				.sendKeys(value);
	}
	
	public void Selectingattributedate() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[text()='DATE']"))))
				.click();
	}
	

	public void Clickingonattributedate() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//p-calendar[@dateformat='dd-mm-yy']"))))
				.click();
	}
	
	public void Attributedatenextbutton() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[@class='p-datepicker-next-icon pi pi-chevron-right ng-tns-c227-36']"))))
				.click();
	}
	
	public void Attributeeditbutton() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr[1]//td[6]/button[@id='edit']"))))
				.click();
	}
	@FindBy(xpath = "//mat-icon[@id='projectSummaryId']")
	WebElement clickSummaryTabProjectLevel;  

	public void clickSUmmaryTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickSummaryTabProjectLevel));
		this.clickSummaryTabProjectLevel.click();
	}
	@FindBy(xpath = "//mat-icon[contains(text(),'person')]")
	WebElement clickUsersTabProjectLevel; 

	public void clickUsersTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickUsersTabProjectLevel));
		this.clickUsersTabProjectLevel.click();
	}
	@FindBy(xpath = "//mat-icon[contains(text(),'library_books')]")
	WebElement clickNotebookTabProjectLevel; 

	public void clickNotebookTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickNotebookTabProjectLevel));
		this.clickNotebookTabProjectLevel.click();
	}
	@FindBy(xpath = "//mat-icon[contains(text(),'attachment')]")
	WebElement clickAttachmentTabProjectLevel; 

	public void clickAttachmentTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickAttachmentTabProjectLevel));
		this.clickAttachmentTabProjectLevel.click();
	}
	@FindBy(xpath = "//mat-icon[contains(text(),'event_note')]")
	WebElement clickAuditTrailTabProjectLevel;

	public void clickAuditTrailTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickAuditTrailTabProjectLevel));
		this.clickAuditTrailTabProjectLevel.click();
	}
	
	@FindBy(xpath = "//span[contains(text(),'STP Worksheets')]")
	WebElement clickonSTPNotebook;

	public void clickonSTPNotebook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickonSTPNotebook));
		this.clickonSTPNotebook.click();
	}
	@FindBy(xpath = "//span[contains(text(),'Method Development')]")
	WebElement clickonMethodDevelopmentNotebook; //Clicking on add project icon 

	public void clickonMethodDevelopmentNotebook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickonMethodDevelopmentNotebook));
		this.clickonMethodDevelopmentNotebook.click();
	}
	@FindBy(xpath = "//span[contains(text(),'Method Validation')]")
	WebElement clickonMethodValidationNotebook; //Clicking on add project icon 

	public void clickonMethodValidationNotebook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickonMethodValidationNotebook));
		this.clickonMethodValidationNotebook.click();
	}
	@FindBy(xpath = "//span[contains(text(),'Routine Analysis')]")
	WebElement clickonRoutineAnalysisNotebook; //Clicking on add project icon 

	public void clickonRoutineAnalysisNotebook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickonRoutineAnalysisNotebook));
		this.clickonRoutineAnalysisNotebook.click();
	}
	@FindBy(xpath = "//span[contains(text(),' Add ')]")
	WebElement clickOnAddButtonProjectLevel; //Clicking on add project icon 

	public void clickOnAddButtonProjectLevel() {
		 js.executeScript("arguments[0].scrollIntoView(true);", clickOnAddButtonProjectLevel);
			wait.until(ExpectedConditions.elementToBeClickable(clickOnAddButtonProjectLevel));
			clickOnAddButtonProjectLevel.click();
			
	}
	@FindBy(xpath = "//p-dropdown[@id='loadUserList_Id']//div[@aria-label='dropdown trigger']")
	WebElement clickroledropdownProjectLevel; //Clicking on add project icon 

	public void clickroledropdownProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickroledropdownProjectLevel));
		this.clickroledropdownProjectLevel.click();
	}
	public void slectRoleProjectLevel(String role) {
		WebElement selectedrole=driver.findElement(By.xpath("//p-dropdownitem//Li/span[text()='"+role+"']"));
		wait.until(ExpectedConditions.elementToBeClickable(selectedrole));
		selectedrole.click();		
	}
	@FindBy(xpath = "//input[@id='selectAllNb']")
	WebElement clickonNotebookSelectAllCheckbox; //Clicking on add project icon 

	public void clickonNotebookSelectAllCheckbox() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickonNotebookSelectAllCheckbox));
		this.clickonNotebookSelectAllCheckbox.click();
	}
	@FindBy(xpath = "//span[contains(text(),' Save ')]")
	WebElement clickSaveOnAdduesrsProjectLevel; //Clicking on add project icon 

	public void clickSaveOnAdduesrsProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickSaveOnAdduesrsProjectLevel));
		this.clickSaveOnAdduesrsProjectLevel.click();
	}
	
	@FindBy(xpath = "//input[@id='onSearchid']")
	WebElement searchUser_input; // searchUser input
	public void searchUsersProjectLevel(String user) {
		this.wait.until(ExpectedConditions.elementToBeClickable(searchUser_input));
		searchUser_input.click();
		this.searchUser_input.sendKeys(user);		
	}//searchUs
	
	public void clickUserCheckboxProjectLevel(String user) {
		WebElement userCheckbox=driver.findElement(By.xpath("//span[contains(text(),'"+user+"')]//preceding::input[@id='usr']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", userCheckbox);
		wait.until(ExpectedConditions.elementToBeClickable(userCheckbox));
		userCheckbox.click();		
	}//clickUserCheckboxProjectLevel
	
	public void Attachmentuploadbutton() throws InterruptedException {
		WebElement element=driver.findElement(By.xpath("//button[@id='openUploadFileDialogId']"));
		this.wait
		.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
}
	public void Entering_Attachment_password(String Password) {
		WebElement element=driver.findElement(By.xpath("//input[@id='passwordId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.sendKeys(Password);
	}
	
	public void Attachment_Auth_Confirm_Button() throws InterruptedException {
		WebElement element=driver.findElement(By.xpath("//button[@id='validatePasswordsave_btn']"));
		this.wait
		.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
}
	public void Attachment_File(String path) {
		WebElement element=driver.findElement(By.xpath("//input[@id='onUpload_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
//			wait.until(ExpectedConditions.elementToBeClickable(element));
		//	element.clear();
			element.sendKeys(path);
	}
//	public void Attachment_File(String path) {
//		WebElement attachFile= driver.findElement(By.xpath("//button[@class='btn']"));//Giving two Ids to work on both expUpload and project level
//		this.wait
//				.until(ExpectedConditions
//						.elementToBeClickable(attachFile));
//		 attachFile.sendKeys(path);
//	
//}
	
	//input[@id='onUpload_btn']
	public void Entering_Attachment_Name(String value) {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//input[@id='attachNameinputtext']"))))//Giving two Ids to work on both expUpload and project level
				.sendKeys(value);
	}
	public void Entering_Attachment_Description(String value) {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//textarea[@id='descriptionId']"))))
				.sendKeys(value);
	}
	
	public void Attachment_Save_Button() throws InterruptedException {
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),' Save ')]"));
		this.wait
		.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
	}
	public void Project_Audit_Trail_Arrow_Button() throws InterruptedException {
		WebElement element=driver.findElement(By.xpath("//button[@id='filterAuditId']"));
		this.wait
		.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
	}
	
	
	
	
	
	
	
}
