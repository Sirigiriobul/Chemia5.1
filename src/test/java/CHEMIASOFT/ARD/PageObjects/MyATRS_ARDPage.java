package CHEMIASOFT.ARD.PageObjects;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyATRS_ARDPage {


	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public MyATRS_ARDPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
	}
	//***************************************************ATR Tests and experiment Icons on top menu**********
	public void  ClickOnTeamQue() {
		WebElement element = driver.findElement(By.xpath("//p[normalize-space()='Team Queue']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnAssigned() {
		WebElement element = driver.findElement(By.xpath("//p[normalize-space()='Assigned']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnInProgress() {
		WebElement element = driver.findElement(By.xpath("//p[normalize-space()='In Progress']"));
//		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnInVerReq() {
		WebElement element = driver.findElement(By.xpath("//p[normalize-space()='Veri. Req.']"));
//		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnInRework() {
		WebElement element = driver.findElement(By.xpath("//p[normalize-space()='Rework']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnInReqEnhancement() {
		WebElement element = driver.findElement(By.xpath("//p[normalize-space()='Enhan. Req']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	
	//***********************NEW ATR Methods**********************************************************************
	
	@FindBy(xpath = "//mat-icon[normalize-space()='home']")
	WebElement Clickingonhomebutton; //Clicking on add project icon 

	public void Clickingonhomebutton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Clickingonhomebutton));
		this.Clickingonhomebutton.click();


	}
	public void clcikOnNewATR() {
		WebElement element = driver.findElement(By.xpath("//button[@id='newAtrPopup_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clickAndSlectFormType(String formType) {
		WebElement formTypedropdown = driver.findElement(By.xpath("//p-dropdown[@id='formTypeId_Dropdown']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+formType+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
	public void clcikOnSubmitFormType() {
		WebElement element = driver.findElement(By.xpath("//button[@id='add-button']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void enterProjectCode(String TeamName) {
		WebElement teamName = driver.findElement(By.xpath("//*[@id='projectCodeId']//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys(TeamName);
	}
	public void clickAndSlectReportType(String formType) {
		WebElement formTypedropdown = driver.findElement(By.xpath("//p-dropdown[@id='formTypeId']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+formType+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
	
	public void enterFormRemarks(String val) {
		WebElement teamName = driver.findElement(By.xpath("//th[@id='remarksId']//..//textarea"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys(val);
	}
	public void enterFormObjectives(String val) {
		WebElement teamName = driver.findElement(By.xpath("//th[@id='objectiveId']//..//textarea"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys(val);
	}
	public void enterFormAttrText(String val) {
		WebElement teamName = driver.findElement(By.xpath("//input[@id='inputtext_attributeValue']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys(val);
	}
	public void enterFormAttrNumber(String val) {
		WebElement teamName = driver.findElement(By.xpath("//input[@id='withoutgrouping']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys(val);
	}
	public void enterTodaysDate() {		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String date = dtf.format(now).toString();
		WebElement toDaysDate = driver.findElement(By.xpath("//input[@id='inputtext_attributeValueID']"));
		toDaysDate.sendKeys(date);
	}
	
	public void selectTodaysDate() {		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String date = dtf.format(now).toString();
		String[] date1 = date.split("/");
		if(date1[2].startsWith("0")) {
			date1[2]=date1[2].substring(1);}
		
		System.out.println("Date is: "+date1[2]);

		WebElement toDaysDate = driver.findElement(By.xpath(
				"//table[contains(@class,'p-datepicker-calendar')]//tbody//td/span[not(contains(@class,'p-disabled')) and text()='"
						+ date1[2] + "']"));
		toDaysDate.click();
	}
	public void clcikOnSampleCodeAddIcon() {
		WebElement element = driver.findElement(By.xpath("//*[@id='sampledetails_experiment']//mat-icon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void enterSampleCode(String val) {
		WebElement element = driver.findElement(By.xpath("//*[@id='inputtext_sampleCode']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void enterBatchNo(String val) {
		WebElement element = driver.findElement(By.xpath("//*[@id='inputtext_batchNoId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void enterSampleQty(String val) {				
		WebElement element = driver.findElement(By.xpath("//*[@id='inputtext_quantity']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void enterDescr(String val) {
		WebElement element = driver.findElement(By.xpath("//*[@id='inputtext_sampledescription']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void clickAndSlectSampleType(String formType) {
		WebElement formTypedropdown = driver.findElement(By.xpath("//p-dropdown[@id='sampleTypeId_List']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+formType+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
	public void clickAndSlectQtyUOM(String val) {
		WebElement formTypedropdown = driver.findElement(By.xpath("//p-dropdown[@id='formControlNameDropdown_uomList']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+val+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
	public void clcikOnSaveSample() {
		WebElement element = driver.findElement(By.xpath("//button[@id='savesample_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clickonFirstTestCheckbox() {
		WebElement checkbox = driver.findElement(By.xpath("//tr[1]//td//*[@id='testSelect_onRowClick']//div[@class='mdc-checkbox']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(checkbox))
									.click();
		}
	public void clcikOnRemoveTestIcon() {
		WebElement element = driver.findElement(By.xpath("//mat-icon[@id='deleteTest_']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clickAndSlectPriority(String val) {
		WebElement formTypedropdown = driver.findElement(By.xpath("//p-dropdown[@id='priorityId_priId']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+val+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
	public void enterTestRemarks(String val) {				
		WebElement element = driver.findElement(By.xpath("//input[@id='inputtextremarksId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void clickAndSlectTeamInTest(String val) {
		WebElement formTypedropdown = driver.findElement(By.xpath("//p-dropdown[@id='sampleQtyUomId_atrTlId']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+val+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
	public void clcikOnSaveTestIcon() {
		WebElement element = driver.findElement(By.xpath("//mat-icon[@id='saveTestId_']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnAddSupportDocsIcon() {
		WebElement element = driver.findElement(By.xpath("//mat-icon[@id='showDialog_id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void enterAttachmentName(String val) {				
		WebElement element = driver.findElement(By.xpath("//strong[contains(text(),'Attachment Name :')]//..//following-sibling::td//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void clickAndSlectAttchmentType() {
		WebElement formTypedropdown = driver.findElement(By.xpath("//table[@id='attachmentId']//following-sibling::p-dialog//p-dropdown[@id='formTypeId']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'Supporting Doc')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
			 
		}
	public void clcikOnUploadDocsAndReports(String path) {
		WebElement element = driver.findElement(By.xpath("//button[@id='upload_btn']//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);			
		element.sendKeys(path);		
	}
	public void clcikOnDocsAndReportsSave() {
		WebElement element = driver.findElement(By.xpath("//button[@id='saveAttachment_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnATRFormSave() {
		WebElement element = driver.findElement(By.xpath("//button[@id='saveATRForm_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnATRFormSubmit() {
		WebElement element = driver.findElement(By.xpath("//button[@id='validateAtrForm_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clickAndSlectTeam(String val) {
		WebElement formTypedropdown = driver.findElement(By.xpath("//p-dropdown[@id='verList_teamLeadList']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'Team_01(SS_ARD_TL)')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
	public void enterPassword(String val) {				
		WebElement element = driver.findElement(By.xpath("//input[@id='testdetailServicepassword']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void clcikOnATRFormSubmitAfterEsighn() {
		WebElement element = driver.findElement(By.xpath("//button[@id='save_submitForm']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnATRFormSubmitAfterEsighnInExp() {
		WebElement element = driver.findElement(By.xpath("//button[@id='submitFormId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnATRFormSubmitAfterEsighnInExp1() {
		WebElement element = driver.findElement(By.xpath("//button[@id='submitFormId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnATRFormCancelAfterEsighn() {
		WebElement element = driver.findElement(By.xpath("//button[@id='cancel_cancelSubmit']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public String getATRFormNumber() {
		WebElement element = driver.findElement(By.xpath("//th[@id='formnoId']//..//following-sibling::td//mat-label"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);	
			return element.getText();		
	}
	//************Test Accept relate Methods********************
	public void clickonSamplecodeCheckbox(String samplecode) {
		WebElement checkbox = driver.findElement(By.xpath("//mat-label[normalize-space()='"+samplecode+"']//..//preceding-sibling::td//div[@class='mdc-checkbox']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(checkbox))
									.click();
		}
	public void clcikOnAcceptTest() {
		WebElement element = driver.findElement(By.xpath("//button[@id='validateTestAccept_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void enterPasswordForAccept(String val) {				
		WebElement element = driver.findElement(By.xpath("//input[@id='atrtestdetailspassword']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void clcikOntestAcceptSubmit() {
		WebElement element = driver.findElement(By.xpath("//button[@id='testAccept_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnProcessTest() {
		WebElement element = driver.findElement(By.xpath("//button[@id='processTest_btn' or @id='processTestId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));		
			element.click();		
	}
	//****************************Test Processing methods******************
	public void clcikOnGenerateTestNo() {
		WebElement element = driver.findElement(By.xpath("//button[@id='generateARNumberId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();		
	}
	public String getTestNumber() {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Test No.')]//following::td[1]"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			
			return element.getText();		
	}
	public void enterPasswor(String val) {				
		WebElement element = driver.findElement(By.xpath("//input[@id='atrtestdetailspassword']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void enterNotebookRefNo(String val) {				
		WebElement element = driver.findElement(By.xpath("//input[@id='testdetailServiceinputtext']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void clcikOnSaveNBrefNo() {
		WebElement element = driver.findElement(By.xpath("//*[@mattooltip='Click here to save notebook reference.']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();		
	}
	public void enterTestResults(String val) {
		
		WebElement iFrame = driver.findElement(By.xpath("//div[text()='Test Results']//..//iframe"));
		driver.switchTo().frame(iFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@id='tinymce']"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys(val);
		driver.switchTo().defaultContent();
		}
	public void enterResultsRemarks(String val) {	
		WebElement iFrame = driver.findElement(By.xpath("//div[text()='Result Remarks ']//..//iframe"));
		driver.switchTo().frame(iFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@id='tinymce']"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys(val);
		driver.switchTo().defaultContent();
		}
	public void enterAdRemarks(String val) {	
		WebElement iFrame = driver.findElement(By.xpath("//div[text()='AD Remarks ']//following::iframe"));
		 js.executeScript("arguments[0].scrollIntoView(true);", iFrame);
		driver.switchTo().frame(iFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@id='tinymce']"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys(val);
		driver.switchTo().defaultContent();
		}
	public void clcikOnAttachmentAddIcon() {
		WebElement element = driver.findElement(By.xpath("//mat-icon[@id='rawdataattachmentsId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void uploadRawDataAttachment(String path) {				
		WebElement element = driver.findElement(By.xpath("//input[@id='onUpload_input']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		 element.sendKeys(path);
	}
	public void enterRawDataAttachmentName(String path) {				
		WebElement element = driver.findElement(By.xpath("//div[@role='dialog']//input[@type='text']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(path);
	}
	public void clcikOnRawDataAttachmentSave() {
		WebElement element = driver.findElement(By.xpath("//button[@id='saveRawdataAttach_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void  ClickOnReport() {
		WebElement element = driver.findElement(By.xpath("//button//span[normalize-space()='Report']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnReportUpload() {
		WebElement element = driver.findElement(By.xpath("//button[@id='showDialog_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnReportUploadFinalReport() {
		WebElement element = driver.findElement(By.xpath("//button[@id='click_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnSaveRepot() {
		WebElement element = driver.findElement(By.xpath("//button[@id='saveFinalReport_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnAction() {
		WebElement element = driver.findElement(By.xpath("//button//span[normalize-space()='Action']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnTestSubmit() {
		WebElement element = driver.findElement(By.xpath("//button[@id='validateSubmitId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void clickAndSlectReviewer(String tl) {
		WebElement formTypedropdown = driver.findElement(By.xpath("//p-dropdown[@id='analystdropId']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+tl+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	}
	public void enterATRResultSubmitRemarks(String val) {
		WebElement teamName = driver.findElement(By.xpath("//textarea[@id='remark']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys(val);
	}
	public void enterATRResultSubmitPassword(String val) {
		WebElement element = driver.findElement(By.xpath("//input[@type='password']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(val);
	}
	public void  ClickOnTestSubmitFinal() {
		WebElement element = driver.findElement(By.xpath("//button[@id='save']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	//*************************************Verify methods*************************
	public void  ClickOnTestReport() {
		WebElement element = driver.findElement(By.xpath("//button//span[contains(text(),'Report')]"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnTestReportView() {
		WebElement element = driver.findElement(By.xpath("//button[@id='viewFinalReportId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnTestVerify() {
		WebElement element = driver.findElement(By.xpath("//button[@id='validateBeforeVerify']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnTestVerifySubmit() {
		WebElement element = driver.findElement(By.xpath("//button[@id='verifyATR']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	//***************************Request enhancement Methods***********************
	public void  ClickOnVerifiedTest(String atrformNo) {
		WebElement element = driver.findElement(By.xpath("//mat-label[contains(text(),'VERIFIED')]//..//preceding-sibling::td//a[contains(text(),'"+atrformNo+"')]"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnTestDetailsDropdown() {
		WebElement element = driver.findElement(By.xpath("//mat-icon[@id='arrowDropDownCcircleId_']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnTestReqEnhancement() {
		WebElement element = driver.findElement(By.xpath("//a[@id='loadReportActionId_']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void enterenhancementRemarks() {
		WebElement teamName = driver.findElement(By.xpath("//textarea[@id='deptDescId_actionRemarks']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys("Requesting for enhancement");
	}
	public void  ClickOnReqEnhancementButton() {
		WebElement element = driver.findElement(By.xpath("//button[@id='save_testReportAction']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnReqEnhancementAssighn() {
		WebElement element = driver.findElement(By.xpath("//button[@id='loadAssignuserList_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void clickAndSlectAnalyst(String analyst) {
		WebElement formTypedropdown = driver.findElement(By.xpath("//p-dropdown[@id='verList_chemistList']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", formTypedropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(formTypedropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+analyst+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	}
	public void enterTestAssgihnPassword(String pwd) {
		WebElement element = driver.findElement(By.xpath("//input[@id='atrtestdetailspassword']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(pwd);
	}
	public void  ClickOnTestAssighnSubmit() {
		WebElement element = driver.findElement(By.xpath("//button[@id='save_validateTestAssign']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnTestAccpet() {
		WebElement element = driver.findElement(By.xpath("//a[@id='loadReportActionId_b']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void enterTestAcceptRemarks(String val) {
		WebElement teamName = driver.findElement(By.xpath("//textarea[@id='deptDescId_actionRemarks']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys(val);
	}
	public void  ClickOnTestAccpetFinal() {
		WebElement element = driver.findElement(By.xpath("//button[@id='save_testReportAction']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public String getATRFormNumberStatus(String val) {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+val+"')]//..//following-sibling::td[contains(@class,'column-status')]//mat-label"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			
			return element.getText();		
	}
}
