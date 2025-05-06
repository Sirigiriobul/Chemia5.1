package Chemia.Project.Creation.PageObject;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project_N_Experiments_Page {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor js;
	public Project_N_Experiments_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;

	
}
	@FindBy(xpath = "//button[@id='addExpDialog']//span[text()=' Add ']")
	WebElement add_button; // add button5.1
	public void clickOnAddInExperiment() {
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
	}//clickOnAddInExperiment
	@FindBy(xpath = "//p-dropdown[@optionvalue='routeid']//div[@aria-label='dropdown trigger']")
	WebElement Route_dropdown; // selectUserRole dropdown
	public void clickOnRoute() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Route_dropdown));
		this.Route_dropdown.click();		
	}//clickOnRoute
	
	public void slectRoute(String route) {
		WebElement selectedroute=driver.findElement(By.xpath("//p-dropdownitem//Li/span[text()='"+route+"']"));
		wait.until(ExpectedConditions.elementToBeClickable(selectedroute));
		selectedroute.click();		
	}//slectRoute
	
	@FindBy(xpath = "//p-dropdown[@optionvalue='stageid']//div[@aria-label='dropdown trigger']")
	WebElement stage_dropdown; // selectUserRole dropdown
	public void clickOnStage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(stage_dropdown));
		this.stage_dropdown.click();		
	}//clickOnStage
	
	public void slectStage(String stage) {
		WebElement selectedstage=driver.findElement(By.xpath("//p-dropdownitem//Li/span[text()='"+stage+"']"));
		wait.until(ExpectedConditions.elementToBeClickable(selectedstage));
		selectedstage.click();		
	}//slectStage
	
	public void clickOnEnterAIm() {
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='aimId_ifr']"));
		driver.switchTo().frame(frameElement);
		
	}//clickOnEnterAIm
	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement aim_text_area; // selectUserRole dropdown
	public void enter_Aim(String aim) {
		this.wait.until(ExpectedConditions.elementToBeClickable(aim_text_area));
		this.aim_text_area.click();	
		this.aim_text_area.clear();	
		this.aim_text_area.sendKeys(aim);
		driver.switchTo().defaultContent();

	}//enter_Aim
	
	public void clickOnEnterAImInExp() {
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='expAim_ifr']"));
		Actions a = new Actions(driver);
		a.scrollToElement(frameElement);
		driver.switchTo().frame(frameElement);
		
	}//clickOnEnterAIm
	
	@FindBy(xpath = "//button[@id='saveExperimentId']/span[text()=' Save ']")
	WebElement save_Experiment; // selectUserRole dropdown
	public void saveExperiment() {
		driver.switchTo().defaultContent();

		this.wait.until(ExpectedConditions.elementToBeClickable(save_Experiment));
		this.save_Experiment.click();		
	}//saveExperiment
	
	@FindBy(xpath = "//button[@id='cancelExperimentAdd']/span[text()=' Cancel ']")
	WebElement cancel_Experiment; // selectUserRole dropdown
	public void cancelExperiment() {
		this.wait.until(ExpectedConditions.elementToBeClickable(cancel_Experiment));
		this.cancel_Experiment.click();		
	}//cancelExperiment
	
	@FindBy(xpath = "//tbody//tr[1]/td[contains(@class,'column-experimentDisplayId')]//a")//first row have the latest exp link
	WebElement exp_link;
	public String getExperimentcode() {
		WebElement expCode = driver.findElement(By.xpath("//*[@id='summary']//app-experiment-summary//tr//td//strong[normalize-space()='Experiment Code:']/..//following-sibling::td[1]//mat-label"));

		return this.wait.until(ExpectedConditions.elementToBeClickable(expCode)).getText();
	}

	public void clickOnExpLink() {
		this.wait.until(ExpectedConditions.elementToBeClickable(exp_link));
		this.exp_link.click();	
       }
	public void clcikOnExpLinkInNotebook(String expcode) {
		
		WebElement expLink = driver.findElement(By.xpath("//tbody//tr/td[contains(@class,'experimentDisplayId')]//a[contains(text(),'"+expcode+"')]"));
		this.wait.until(ExpectedConditions.elementToBeClickable(expLink));
		expLink.click();
	}
	
	public void clcikOnLinkInExpPage(String link) {
		
		WebElement expsubtablink = driver.findElement(By.xpath("//table[@id='summaryTable']//*[self::span or self::a][contains(text(),'"+link+"')]"));
		 js.executeScript("arguments[0].scrollIntoView(true);", expsubtablink);
		this.wait.until(ExpectedConditions.elementToBeClickable(expsubtablink));
		
		expsubtablink.click();
	}
	public void acceptAlert() {
	 Alert alert = driver.switchTo().alert();

     // Get the alert text
     String alertText = alert.getText();
     System.out.println("Alert text: " + alertText);
     
     // Accept the alert
     alert.accept();
     }
	@FindBy(xpath = "//div//span[text()='Restore Experiment Information']")
	WebElement restoteInfInExp_Popup; // editInput Button
	public boolean isRestoreInformationPopupEnabled() {
		this.wait.until(ExpectedConditions.elementToBeClickable(restoteInfInExp_Popup));
		return restoteInfInExp_Popup.isDisplayed();
	}//isRestoreInformationPopupEnabled
	
	@FindBy(xpath = "//button[@id='save']//span[text()=' Yes']")
	WebElement restoteInfInExpYes_button; // editInput Button
	public void clickOnYesInRestoreInformationPopup() {

	this.wait.until(ExpectedConditions.elementToBeClickable(restoteInfInExpYes_button));
	this.restoteInfInExpYes_button.click();	
	}
	@FindBy(xpath = "//button[@id='cancel']//span[text()=' No ']")
	WebElement restoteInfInExpNo_button; // editInput Button
	public void clickOnNoInRestoreInformationPopup() {

	this.wait.until(ExpectedConditions.elementToBeClickable(restoteInfInExpNo_button));
	this.restoteInfInExpNo_button.click();	
	}
	
	//***************************************Inside Experiments******************************************
	
	//*****************Exp Input Values edit and add functional menthods**************************
	
	@FindBy(xpath = "//span//mat-icon[@id='addInputId']")
	WebElement addInput_button; // editInput Button
	public void clickOnAddInput() {

//		this.wait.until(ExpectedConditions.elementToBeClickable(addInput_button));
//		this.addInput_button.click();		
//		WebElement element=driver.findElement(By.xpath("//button[@id='addsaveStageButtonId']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(addInput_button));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addInput_button);
	}//clickOnAddInput
	
	public void clickOnInputsettings(String chemical) {
		WebElement settingsInput_button=driver.findElement(By.xpath("//table[@id='experimentInputTable']//tr//td//span[contains(text(),'"+chemical+"')]/../following-sibling::td//figure//mat-icon[@mattooltip='settings']"));

		this.wait.until(ExpectedConditions.elementToBeClickable(settingsInput_button));
		settingsInput_button.click();		
	}//clickOnInputsettings
	
	@FindBy(xpath = "//div//a//span[text()='Edit']")
	WebElement editInput_button; // editInput Button 5.1 change
	public void clickOnEditInput() {

//		this.wait.until(ExpectedConditions.elementToBeClickable(editInput_button));
//		this.editInput_button.click();
//		WebElement element=driver.findElement(By.xpath("//button[@id='addsaveStageButtonId']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(editInput_button));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editInput_button);
	}//clickOnEditInput
	
	@FindBy(xpath = "//p-dropdown[@id='chemicalNameId']//input[contains(@class,'inputtext ')]")
	WebElement chemicalName_input; // editInput Button
	public void enterChemiacalName(String val) {

		this.wait.until(ExpectedConditions.elementToBeClickable(chemicalName_input));
		chemicalName_input.clear();
		chemicalName_input.sendKeys(val);		
	}//enterChemiacalName
	
	@FindBy(xpath = "//p-dropdown[@formcontrolname='vendorName']//input[contains(@class,'inputtext ')]")
	WebElement vendorName_input; 
	public void enterVenderName(String val) {

		this.wait.until(ExpectedConditions.elementToBeClickable(vendorName_input));
		vendorName_input.clear();
		vendorName_input.sendKeys(val);		
	}//enterVenderName
	
	@FindBy(xpath = "//p-dropdown[@formcontrolname='batchNo']//input[contains(@class,'inputtext ')]")
	WebElement bacthNo_input;
	public void enterBatchNoName(String val) {

		this.wait.until(ExpectedConditions.elementToBeClickable(bacthNo_input));
		bacthNo_input.clear();
		bacthNo_input.sendKeys(val);		
	}//enterBatchNoName
	
	@FindBy(xpath = "//p-inputnumber[@id='molwt']//input")
	WebElement molWt_input;   
	public void enterMolWt(String val) {

		this.wait.until(ExpectedConditions.elementToBeClickable(molWt_input));
		molWt_input.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		molWt_input.sendKeys(Keys.BACK_SPACE);
		molWt_input.sendKeys(val);
	}//enterMolWt
	
	@FindBy(xpath = "//input[@formcontrolname='reqQty']")
	WebElement reqQty_input;
	public void enterreqQty(String val) {

		this.wait.until(ExpectedConditions.elementToBeClickable(reqQty_input));
		reqQty_input.clear();
		reqQty_input.sendKeys(val);		
	}//enterreqQty
	
	@FindBy(xpath = "//p-dropdown[@id='quantityUomId']//div[@class='p-dropdown-trigger']")
	WebElement uOMdropdown_trigger;
	
	public void enterreqQtyMsrUnit(String val) {

		this.wait.until(ExpectedConditions.elementToBeClickable(uOMdropdown_trigger));
		uOMdropdown_trigger.click();
		
		WebElement mesure=driver.findElement(By.xpath("//p-dropdownitem//li//span[text()='"+val+"']"));	
		this.wait.until(ExpectedConditions.elementToBeClickable(mesure));
		mesure.click();
		
	}//enterreqQtyMsrUnit
	
	@FindBy(xpath = "//button[@id='saveExperimentId']//span")
	WebElement save_button; 
	public void clickOnSave() {

//		this.wait.until(ExpectedConditions.elementToBeClickable(save_button));
//		save_button.click();
		this.wait
		.until(ExpectedConditions
				.elementToBeClickable(save_button));
 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", save_button);
	}//clickOnSave
	@FindBy(xpath = "//button[@id='cancelExperimentAdd']//span")
	WebElement cancel_button; 
	public void clickOncancel() {

//		this.wait.until(ExpectedConditions.elementToBeClickable(cancel_button));
//		cancel_button.click();
		this.wait
		.until(ExpectedConditions
				.elementToBeClickable(cancel_button));
 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancel_button);
	}//clickOnSave

	public void Input_Embedded_Excel() {
		this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//app-input//img[@id='commentsInputId']"))))
				.click();
	}
	public void Embedded_Excel_Dropdown() {
		this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='sheetsExcelId']//chevrondownicon"))))
				.click();
	}
	public void Embedded_Excel_Template() {
		this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//ul//span[contains(text(),'Excel Template-03')]"))))
				.click();
	}
	public void Input_Embedded_Excel_Savebutton() {
		this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//button[@id='inputexcelId']"))))
				.click();
	}
	
	
	//********************************************Specific Equipment add methods*****************
	public void clickOnAddEuipment() {

		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span//mat-icon[@id='addEqpId']")))).click();
	}//clickOnAddEuipment
	
	@FindBy(xpath = "//table//th[contains(text(),'Instrument / Equipment Type')]/../td//input[contains(@class,'inputtext ')]")
	WebElement equipmentType_input; 
	public void enterEquipmentType(String val) {

		this.wait.until(ExpectedConditions.elementToBeClickable(equipmentType_input));
		equipmentType_input.clear();
		equipmentType_input.sendKeys(val);		
	}//enterEquipmentType
	
	@FindBy(xpath = "//table//th[contains(text(),'Instrument / Equipment Name')]/../td//input[contains(@class,'inputtext ')]")
	WebElement equipmentName_input; 
	public void enterEquipmentName(String val) {

		this.wait.until(ExpectedConditions.elementToBeClickable(equipmentName_input));
		equipmentName_input.clear();
		equipmentName_input.sendKeys(val);		
	}//enterEquipmentName
	public void clickOnStartDateinEquip() {

		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p-calendar[@id='starttimeid']//span//button")))).click();
	}//clickOnStartDateinEquip
	
	public void clickOnEndtDateinEquip() {

		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p-calendar[@id='endtimeid']//span//button")))).click();
	}//clickOnEndtDateinEquip
	
	public void clickOnSaveEquip() {

		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='save']//span[text()=' Save ']")))).click();
	}//clickOnSaveEquip
	
	public void clickOnCancelEquip() {

		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button//span[text()=' Cancel ']")))).click();
	}//clickOnCancelEquip it works for Cancel post remarks as well.
	
	@FindBy(xpath = "//p-checkbox[@inputid='binary']")
	WebElement equipment_manualentry_checkbox; 
	public void equipment_manualentry_checkbox() {
 
		this.wait.until(ExpectedConditions.elementToBeClickable(equipment_manualentry_checkbox));
		equipment_manualentry_checkbox.click();	
	}//equipment_manualentry_checkbox
	
	@FindBy(xpath = "//table//th[contains(text(),' Instrument / Equipment Code')]/../td//input[contains(@class,'inputtext ')]")
	WebElement equipmentCode_input; 
	public void enterEquipmentCode(String val) {
 
		this.wait.until(ExpectedConditions.elementToBeClickable(equipmentCode_input));
		equipmentCode_input.clear();
		equipmentCode_input.sendKeys(val);		
	}//enterEquipmentCode
	//**********************Precautions Methods******************
	@FindBy(xpath = "//div[contains(@class,'panelTitle') and normalize-space(text())='Precautions']//mat-icon")
	WebElement addPrecaution_button; 
	public void clickOnAddPrecaution() {
		this.wait.until(ExpectedConditions.elementToBeClickable(addPrecaution_button));
		addPrecaution_button.click();
		}//clickOnAddPrecaution
	public void enterPrecautionMnually(String caution) {
		
		WebElement precautionFrame = driver.findElement(By.xpath("//iframe[@id='precautionCkId_ifr']"));
		driver.switchTo().frame(precautionFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@data-id='precautionCkId']"));

		textArea.click();
		textArea.clear();
//		textArea.sendKeys(Keys.ENTER);
		textArea.sendKeys(caution);
		driver.switchTo().defaultContent();
		}
	public void selectPredefinePrecaution(String caution) {//5.1 changes
		WebElement checkBox = driver.findElement(By.xpath("//table[@id='precautiontable']//td//mat-label[contains(text(),'"+caution+"')]/../..//td//mat-checkbox//div/input/.."));
		this.wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
	}
	
	public void clickOnSavePrecaution() {

		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='savePreConfig']//span[text()='Save']")))).click();
	}//clickOnSavePrecaution
	
	public void clickOnCancelPrecaution() {

		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='camcelPreConfig']//span[text()=' Cancel']")))).click();
	}//clickOnCancelPrecaution
	//*********************************************Attachments**************
	@FindBy(xpath = "//div[contains(@class,'panelTitle') and normalize-space(text())='Attachment']//mat-icon")
	WebElement uploadAttach_button; 
	public void clickOnUploadAttachments() {
		this.wait.until(ExpectedConditions.elementToBeClickable(uploadAttach_button));
		uploadAttach_button.click();
		}//clickOnAddPrecaution
	public void clickOnSaveUploadFile() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//button[@id='saveExpAttachment']"))))
				.click();
	}//clickOnSaveUploadFile
	//*********************************************Procedure and Observation**************
	
	public void clickOnuploadExcel() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='tabularorLinear']//img[@id='commentsInputId']")))).click();
	}//clickOnuploadExcel
	
	public void clickOnuploadRTF() {
			
			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='tabularorLinear']//mat-icon[@id='addObsUploadId']")))).click();
		}//clickOnuploadExcel
		
	public void clickOnDeleteExcel() {
			
			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='tabularorLinear']//mat-icon[@title='Delete Excel']")))).click();
		}//clickOnDeleteExcel

	public void clickOnAddStepforProsedure() {
		WebElement element=driver.findElement(By.xpath("//button[@id='saveProcedureId']//span[text()=' ADD STEP ']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element))
				.click();
	}//clickOnAddStep
	public void clickOnRemoveforProsedure() {
		WebElement element=driver.findElement(By.xpath("//button[@id='saveProcedureId']//span[text()=' REMOVE STEP ']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element))
				.click();
	}//clickOnAddStep
	
	public void enterProcedure(String Procedure) {
			
			WebElement procedureFrame = driver.findElement(By.xpath("//iframe[@id='tempProcedureDataId_ifr']"));
			driver.switchTo().frame(procedureFrame);
			WebElement textArea = driver.findElement(By.xpath("//body[@data-id='tempProcedureDataId']"));
	
			textArea.click();
			textArea.clear();
			textArea.sendKeys(Procedure);
			driver.switchTo().defaultContent();
			}
		
	public void clickOnSaveProcedure() {
	
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='saveProcedureId']//span[text()=' Save ']")))).click();
	}//clickOnSaveProcedure
	
	public void clickOnSaveEditProcedure() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='ediProcObsId']//span[text()=' Save ']")))).click();
	}//clickOnSaveEditProcedure
	public void clickOnActionsForastep(String val) {
		WebElement actionFig = driver.findElement(By.xpath("//tbody//tr//td[contains(@class,'StepNo') ]//mat-label[normalize-space()='"+val+"' ]/../following-sibling::td[contains(@class,'Action')]//mat-icon"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", actionFig);
		this.wait.until(ExpectedConditions.elementToBeClickable(actionFig));
		actionFig.click();
			
	}//clickOnActionsForastep

	public void clickOnEditObservation() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div//a/span[normalize-space()='Edit Observation']"))))
		.click();
	}//clickOnEditObservation
	public void clickOnremoveStep() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div//a/span[normalize-space()='Remove Step']"))))
		.click();
	}//clickOnremoveStep
	public void clickOnEditStep() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div//a/span[normalize-space()='Edit Step']"))))
		.click();
	}//clickOnremoveStep
	public void clickOnInsertStep() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div//a/span[normalize-space()='Insert Step above']"))))
		.click();
	}//clickOnInsertStep
	
	public int getTotalRowsCountofProcandObse() {
		 WebElement table = driver.findElement(By.id("experimentEquipTable"));

       // Get all rows in the table (excluding the header)
       List<WebElement> rows = table.findElements(By.xpath(".//tr"));
       
       // Print the count of rows (excluding header)
       int rowCount = rows.size() - 1; // Subtract 1 for the header row
       System.out.println("Number of rows: " + rowCount);
		return rowCount;
	}//getTotalRowsCountofProcandObse
	public void enterObservation(String Observation) {
		
		WebElement observationFrame = driver.findElement(By.xpath("//iframe[@id='tempObservationDataIdObs_ifr']"));
		driver.switchTo().frame(observationFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@data-id='tempObservationDataIdObs']"));

		textArea.click();
		textArea.clear();
		textArea.sendKeys(Observation);
		driver.switchTo().defaultContent();
		}//enterObservation
	
	public void enterQtyInObservation(String val) {
		driver.manage().window().fullscreen();
		WebElement ele=driver.findElement(By.xpath("//input[@id='obsquantityId']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(ele)).clear();
		ele.sendKeys(val);	

	}//enterQtyInObservation
	
	public void enterTempInObservation(String val) {
		WebElement ele=driver.findElement(By.xpath("//input[@id='temperatureId']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(ele)).clear();
		ele.sendKeys(val);		
	}//enterTempInObservation
	
	public void clickOnstartDate() {
		this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-calendar[@id='activityStarttimeId']//span//button")))
		.click();		
	}//clickOnstartDate
	public void clickOnEndDate() {
		this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-calendar[@id='activityendTime']//span//button")))
		.click();		
	}//clickOnstartDate
	public void selectTodaysDate() {		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String date = dtf.format(now).toString();
		String[] date1 = date.split("/");

		WebElement toDaysDate = driver.findElement(By.xpath(
				"//table[contains(@class,'p-datepicker-calendar')]//tbody//td/span[not(contains(@class,'p-disabled')) and text()='"
						+ date1[2] + "']"));
		toDaysDate.click();
	}
	public void clickOnSaveObservation() {
		driver.manage().window().fullscreen();

		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='addNewObsId']//span[text()=' Save ']")))).click();
		driver.manage().window().maximize();
	}//clickOnSaveObservation
	public void clickOnCancelObservation() {
		driver.manage().window().fullscreen();

			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='cancelProObsId1']//span[text()=' Cancel ']")))).click();
			driver.manage().window().maximize();
	
		}//clickOnCnacelObservation
	
	public void selectallRowsInObservations() {
		WebElement checkBox = driver.findElement(By.xpath("//mat-checkbox[@id='selectObsAllId']//div[@class='mdc-checkbox']"));//5.1 changes
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkBox);
		this.wait
		.until(ExpectedConditions
				.elementToBeClickable(checkBox))
		.click();
		}//selectallRowsInObservations
	//*********************************************Scheme*****************************************************************
	public void clickOndeleteScheme() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span//mat-icon[@id='deleteSchemeId']")))).click();
	}//clickOndeleteScheme
	public void clickOnuploadScheme() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span//mat-icon[@id='uploadSchemeId']")))).click();
	}//clickOnuploadScheme
	public void clickOnDownloadScheme() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span//mat-icon[@id='downloadSchemeId']")))).click();
	}//clickOnuploadScheme
//*****************************************************Exp.Parameters*********************************************************
	public void clickOnAddExpParamtrs() {
		 WebElement element=driver.findElement(By.xpath("//div//mat-icon[@id='addExpQuantResult']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}//clickOnAddExpParamtrs
	
	public void clickOnDeleteExpParamtrs() {
		 WebElement element=driver.findElement(By.xpath("//div//mat-icon[@id='removeExpQuantResult']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}//clickOnDeleteExpParamtrs
	
	public void clickOnSaveExpParamtrs() {
		 WebElement element=driver.findElement(By.xpath("//div//mat-icon[@id='saveExpQuantResult']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}//clickOnSaveExpParamtrs
	public void clickOnClosetoastPopup() {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//p-toastitem//button//timesicon"))))
				.click();
	}//clickOnClosetoastPopup
	
	public void clickOnEditExpParamtrs() {
		 WebElement element=driver.findElement(By.xpath("//div//mat-icon[@id='editExpQuantResult']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
	}//clickOnEditExpParamtrs
	
	public void enterExperiment_Parameter_Value(String value,int rownum) {
		WebElement ele=driver.findElement(By.xpath("//tr["+rownum+"]//input[@id='expResultParamValue']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(ele));
		 ele.clear();
		 ele.sendKeys(value);
	}
	public void enterExperiment_Parameter_Value(String value) {
		WebElement ele=driver.findElement(By.xpath("//input[@id='expResultParamValue']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(ele));
		 ele.clear();
		 ele.sendKeys(value);
	}
	public void enterExperiment_resultPar_remarks(String value) {
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//input[@id='expResultremarks']"))))
				.sendKeys(value);
	}
	public void selectrow(int rownum) {
		this.wait
		.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//table[@id='experimentResultsTable']//tr["+rownum+"]//td//mat-checkbox//input[@type='checkbox']/.."))))
		.click();
		}//selectLastrow
	public void clickYesOnexpParameterRemove() {
		this.wait
		.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//button//span[text()='Yes']"))))
		.click();//work for procedure remove as well
		}//clickYesOnexpParameterRemove 
	public void selectallRows() {
		WebElement checkBox = driver.findElement(By.xpath("//mat-checkbox[@id='expResultChkall']//div[@class='mdc-checkbox']"));//5.1 changes
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkBox);
		this.wait
		.until(ExpectedConditions
				.elementToBeClickable(checkBox))
		.click();
		}//selectallRows
	
	public String getResultParameterofRow(String rownum) {
		
		return driver.findElement(By.xpath("//table[@id='experimentResultsTable']//tr["+rownum+"]//td[contains(@class,'column-ParamValue')]//mat-label")).getText();
	}
	public int getTotalRowsCount() {
		 WebElement table = driver.findElement(By.id("experimentResultsTable"));

        // Get all rows in the table (excluding the header)
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        
        // Print the count of rows (excluding header)
        int rowCount = rows.size() - 1; // Subtract 1 for the header row
        System.out.println("Number of rows: " + rowCount);
		return rowCount;
	}
	//*******************************************TLC***********************
	public void clickOnUPloadTLC() {
		this.wait
		.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[@id='tlc']//mat-icon[normalize-space()='upload']"))))
		.click();//work for procedure remove as well
		}//clickOnUPloadTLC
	
	//********************************************Conclusion************************
	public void enterConclusion(String conclusion) {
		WebElement precautionFrame = driver.findElement(By.xpath("//iframe[@id='expconclusion_ifr']"));
		driver.switchTo().frame(precautionFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@data-id='expconclusion']"));

		textArea.click();
		textArea.clear();
		textArea.sendKeys(conclusion);
		driver.switchTo().defaultContent();

	}
	//**************************************Save Section
	public void clickOnExpsave() {
		WebElement element=driver.findElement(By.xpath("//*[@id='saveExperimentIdAuthId']//span[text()='Save']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);//work for procedure remove as well
		}//clickOnExpsave
	public void clickOnSubmitVerification() {
		WebElement element=driver.findElement(By.xpath("//*[@id='submitExperimentId']//span[normalize-space()='Submit For Verification']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}//clickOnExpsave

	
	public void enterSaveExpComments(String Comments) {
		
		WebElement procedureFrame = driver.findElement(By.xpath("//iframe[@id='saveingexpcomments_ifr']"));
		driver.switchTo().frame(procedureFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@data-id='saveingexpcomments']"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys(Comments);
		driver.switchTo().defaultContent();
		}

	public String getSuccessMessage() {
		
		return this.wait
				.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//h1")))).getText().trim();
	}
	
	public void clickOnViewNotebook() {
		this.wait
		.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//h2[contains(text(),'To view the notebook')]//span"))))
		.click();
		}//clickOnViewNotebook
	
	public void clickOnExperiments(String expLink) {
		WebElement explink=driver.findElement(By.xpath("//tbody//tr/td[contains(@class,'column-experimentDisplayId')]//a[contains(text(),'"+expLink+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(explink));
		explink.click();		
	}//clickOnExperiments
	public void clickOnVerifierOrApproverdropdown() {
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='verList' or @id='approverUserList']//div[@aria-label='dropdown trigger']"))))
		.click();
	}//clickOnVerifierOrApproverdropdown
	
	public void slectVerifierOrApprover(String teamlead) {
		WebElement selectVerifier=driver.findElement(By.xpath("//p-dropdown[@id='verList' or @id='approverUserList']//span[contains(text(), '"+teamlead+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(selectVerifier));
		selectVerifier.click();		
	}//slectVerifierOrApprover
	
		public void enterVerificationComments(String Comments) {
				
				WebElement procedureFrame = driver.findElement(By.xpath("//iframe[@id='verificationsubmitcomments_ifr']"));
				driver.switchTo().frame(procedureFrame);
				WebElement textArea = driver.findElement(By.xpath("//body[@data-id='verificationsubmitcomments']"));
				textArea.click();
				textArea.clear();
				textArea.sendKeys(Comments);
				driver.switchTo().defaultContent();
				}
		
		public void clickConfirmOnUserVerForm() {
				driver.manage().window().fullscreen();

		
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//button[@id='sendForVerificationId']"))))
					.click();
				driver.manage().window().maximize();
		}
		
		//************************************************Review level methods***********************
		public String getStatusOfExperiment(String expCode) {
			WebElement expstatus = driver.findElement(By.xpath("//tbody//tr//td//*[self::span or self::a][contains(text(),'"+expCode+"')]/../following-sibling::td[contains(@class,'column-experimentStatus')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", expstatus);			
			 return expstatus.getText().trim();
			}
		public void slectVerificationIcon() {
			WebElement verificationIcon=driver.findElement(By.xpath("//img[@id='verificationreqExpTl']"));
			wait.until(ExpectedConditions.elementToBeClickable(verificationIcon));
			verificationIcon.click();		
		}//slectVerificationIcon
		public void slectVerified1Icon() {
			WebElement verificationIcon=driver.findElement(By.xpath("//img[@id='verifiedExpTl']"));
			wait.until(ExpectedConditions.elementToBeClickable(verificationIcon));
			verificationIcon.click();		
		}//slectVerificationIcon
		public void slectVerifiedIcon() {
			WebElement VerifiedIcon=driver.findElement(By.xpath("//img[@id='verifiedExp']"));
			wait.until(ExpectedConditions.elementToBeClickable(VerifiedIcon));
			VerifiedIcon.click();		
		}//slectVerifiedIcon
		public void slectUnlockIcon() {
			WebElement VerifiedIcon=driver.findElement(By.xpath("//img[@id='unlockedExp']"));
			wait.until(ExpectedConditions.elementToBeClickable(VerifiedIcon));
			VerifiedIcon.click();		
		}//slectVerifiedIcon
		public void slectAprovalIcon() {
			WebElement aprovalIcon=driver.findElement(By.xpath("//img[@id='approvalTl']"));
			wait.until(ExpectedConditions.elementToBeClickable(aprovalIcon));
			aprovalIcon.click();		
		}//slectVerifiedIcon
		public void slectReworkExpIcon() {
			WebElement slectReworkExpIcon=driver.findElement(By.xpath("//img[@id='reworkExpTl' or @id='reworkExp']"));
			wait.until(ExpectedConditions.elementToBeClickable(slectReworkExpIcon));
			slectReworkExpIcon.click();		
		}//slectReworkExpIcon
		public void slectUnlockExpIcon() {
			WebElement slectUnlockIcon=driver.findElement(By.xpath("//img[@id='unlockExp']"));
			wait.until(ExpectedConditions.elementToBeClickable(slectUnlockIcon));
			slectUnlockIcon.click();		
		}//slectUnlockExpIcon
		public void slectReworkArovalIcon() {
			WebElement reworkArovalIcon=driver.findElement(By.xpath("//img[@id='approvalTl']"));
			wait.until(ExpectedConditions.elementToBeClickable(reworkArovalIcon));
			reworkArovalIcon.click();		
		}//slectReworkArovalIcon
		public void slectSubmittedIcon() {
			WebElement submittedIcon=driver.findElement(By.xpath("//img[@id='submittedTl']"));
			wait.until(ExpectedConditions.elementToBeClickable(submittedIcon));
			submittedIcon.click();		
		}//slectSubmittedIcon
		
		public void clickOnExpInVerReqstdPage(String expcode) {//works for all pages
			WebElement explink=driver.findElement(By.xpath("//tbody//tr/td[contains(@class,'column-ExperimentCode') or contains(@class, 'experimentDisplayId')]//a[contains(text(),'"+expcode+"')]"));
			wait.until(ExpectedConditions.elementToBeClickable(explink));
			explink.click();		
		}//clickOnExpInVerReqstdPage
		
		public void clickOnApprove() {
			WebElement approve_button=driver.findElement(By.xpath("//button[@id='approveButtonId']//span[normalize-space()='Approve']"));
			wait.until(ExpectedConditions.elementToBeClickable(approve_button));
			approve_button.click();		
		}//clickOnApprove
		
		public void clickOnReturn() {
			WebElement return_button=driver.findElement(By.xpath("//button[@id='reworkButtonId']//span[normalize-space()='Return']"));
			wait.until(ExpectedConditions.elementToBeClickable(return_button));
			return_button.click();		
		}//clickOnReturn
		
		public void clickOnVerify() {
			WebElement verify_button=driver.findElement(By.xpath("//button[@id='reAuthVerifyButtonId']//span[normalize-space()='Verify']"));
			wait.until(ExpectedConditions.elementToBeClickable(verify_button));
			verify_button.click();		
		}//clickOnVerify
		
		
		public void enterReturnComments(String Comments) {
			
			WebElement procedureFrame = driver.findElement(By.xpath("//iframe[@id='reworkCommentsId_ifr']"));
			driver.switchTo().frame(procedureFrame);
			WebElement textArea = driver.findElement(By.xpath("//body[@data-id='reworkCommentsId']"));
			textArea.click();
			textArea.clear();
			textArea.sendKeys(Comments);
			driver.switchTo().defaultContent();
			}
		
		public void clickConfirmOnReturnForm() {
			driver.manage().window().fullscreen();
			 WebElement element=driver.findElement(By.xpath("//button[@id='sendForReworkId']"));
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//			 this.wait
//				.until(ExpectedConditions
//						.elementToBeClickable(driver.findElement(By.xpath("//button[@id='closeReworkDialogId']"))))
//				.click();
				driver.manage().window().maximize();
		}
		public void clickOnConfirmInForm() {
//			 JavascriptExecutor js = (JavascriptExecutor) driver;
//		        js.executeScript("document.body.style.zoom = '0.75';");
//			driver.manage().window().fullscreen();

			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//button//span[normalize-space()='Confirm']"))))
					.click();
//			  js.executeScript("document.body.style.zoom = '1.0';");

//				driver.manage().window().maximize();

		}//clickOnConfirmInForm
		
		public void clickOnAddPostVerificationRemarks() {
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//div[@id='postremarks']//mat-icon"))))
					.click();
		}//clickOnAddPostVerificationRemarks
		
		public void clickOnSubmitforaproval() {
			WebElement submit_button=driver.findElement(By.xpath("//button[@id='submitAuthExperimentId']//span[normalize-space()='Submit']"));
			wait.until(ExpectedConditions.elementToBeClickable(submit_button));
			submit_button.click();		
		}//clickOnSubmitforaproval
		
		public void enterCommentsForApproval(String comments) {//works for approve submit comments , unlock comments and QA comments.
			WebElement commentBox=driver.findElement(By.xpath("//p-editor[@data-id='approveCommentsId' or @id='unlockCommentsId' or @id='qaCommentId']//p"));
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(commentBox));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", commentBox);
			commentBox.sendKeys(comments);
		}//enterCommentsForApproval

		public void clickOnAimDropdown() {
			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='aimListId']//div[@aria-label='dropdown trigger']"))))
			.click();
		}//clickOnAimDropdown
		
		public void slectAimAcheived(String aimachived) {
			WebElement selectAim=driver.findElement(By.xpath("//p-dropdown[@id='aimListId']//span[contains(text(), '"+aimachived+"')]"));
			wait.until(ExpectedConditions.elementToBeClickable(selectAim));
			selectAim.click();		
		}//slectVerifierOrApprover
		public void enterApproveComments(String Comments) {
			
			WebElement procedureFrame = driver.findElement(By.xpath("//iframe[@id='approveCommentsId_ifr']"));
			driver.switchTo().frame(procedureFrame);
			WebElement textArea = driver.findElement(By.xpath("//body[@data-id='approveCommentsId']"));
			textArea.click();
			textArea.clear();
			textArea.sendKeys(Comments);
			driver.switchTo().defaultContent();
			}
		
//*****************************************************clone and other functionalities related to experiment**************************
		public void clickOnView() {
			WebElement element=driver.findElement(By.xpath("//button[@id='viewExpId']//span[normalize-space()='View']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element))
					.click();
		}//clickOnView
		public void clickOnHighlight() {
			WebElement element=driver.findElement(By.xpath("//button[@id='highlightExpId']//span[normalize-space()='Highlight']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element))
					.click();
		}//clickOnHighlight
		
		public void clickOnEvent() {
			WebElement element=driver.findElement(By.xpath("//button[@id='eventExpId']//span[normalize-space()='Event']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element))
					.click();
		}//clickOnEvent
		
		public void clickOnClone() {
			WebElement element=driver.findElement(By.xpath("//button[@id='cloneBtnId']//span[normalize-space()='Clone']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element))
					.click();
		}//clickOnClone
		public void clickOnHistory() {
			WebElement element=driver.findElement(By.xpath("//button[@id='historyExpId']//span[normalize-space()='History']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element))
					.click();
		}//clickOnHistory
		public void clickOnVersionComparison() {
			WebElement element=driver.findElement(By.xpath("//button//span[normalize-space()='Version Comparison']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element))
					.click();
		}//clickOnVersionComparison
		public void clickOnexportPDF() {
			WebElement element=driver.findElement(By.xpath("//button[@id='reportBtnId']//span[normalize-space()='Export PDF']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element))
					.click();
		}//clickOnClone
		public void clickOnUnlokRequest() {
			WebElement element=driver.findElement(By.xpath("//button[@id='unlockButtonId']//span[normalize-space()='Unlock Request']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element))
					.click();
		}//clickOnUnlokRequest
		
		public void selectCheckBoxforApprovedExp(String exp) {
			WebElement checkBox=driver.findElement(By.xpath("//tbody//tr//td[contains(@class,'experimentDisplayId')]//span[contains(text(),'"+exp+"')]/../preceding-sibling::td//mat-checkbox//div[@class='mdc-checkbox']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", checkBox);
			wait.until(ExpectedConditions.elementToBeClickable(checkBox));
			checkBox.click();
		}//selectCheckBoxforApprovedEx
		public void selectCheckBoxforAnExp(String exp) {
			WebElement checkBox=driver.findElement(By.xpath("//tbody//tr//td[contains(@class,'experimentDisplayId')]//a[contains(text(),'"+exp+"')]/../preceding-sibling::td//mat-checkbox//div[@class='mdc-checkbox']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", checkBox);
			wait.until(ExpectedConditions.elementToBeClickable(checkBox));
			checkBox.click();
		}//selectCheckBoxforAnEx
	
		public void selectCheckBoxInCloneExpPopuo() {
			WebElement checkBox=driver.findElement(By.xpath("//p-checkbox[@id='chkCloneExp']//div[@class='p-checkbox-box']"));
			wait.until(ExpectedConditions.elementToBeClickable(checkBox));
			checkBox.click();
		}//selectCheckBoxInCloneExpPopuo
		public void clickOnViewCloneExpInNotebook() {
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//h2[contains(text(),'To view the cloned experiment')]//a"))))
			.click();
			}//clickOnViewCloneExpInNotebook
		public void clickOnModifyCloneExpInNotebook() {
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//h2[contains(text(),'To modify the cloned experiment ')]//a"))))
			.click();
			}//clickOnModifyCloneExpInNotebook

		public void clickOnReferenceExpCode() {
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//*[@id='summary']//app-experiment-summary//tr//td//strong[normalize-space()='Reference ExpCode :']/..//following-sibling::td[1]//mat-label/a"))))
			.click();			
		}//clickOnReferenceExpCode

		public void dragFocusToRefExpPopup() throws InterruptedException {
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//p-dialog//table[@id='summaryTable']/..//div[normalize-space()='SUMMARY']"))))
			.click();	
			
			  Actions actions = new Actions(driver);

	            // Scroll down using Page Down key multiple times
	            for (int i = 0; i < 5; i++) { // Adjust the count as needed
	                actions.sendKeys(Keys.PAGE_DOWN).perform();
	                Thread.sleep(1000); // Optional: add a short pause to see the effect
	            }
		}

		public String getRefExperimentcode() {
			WebElement expCode = driver.findElement(By.xpath("//*[@id='summary']//app-experiment-summary//tr//td//strong[normalize-space()='Reference ExpCode :']/..//following-sibling::td[1]//mat-label/a"));

			return this.wait.until(ExpectedConditions.elementToBeClickable(expCode)).getText();
		}

		public void disableCheckBoxClonePopup() {
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//p-checkbox[@id='chkCloneExp']//checkicon"))))
			.click();			
		}
		
		public void clickOnProjectdropdown() {
			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='projectlistdropDownId']//div[@aria-label='dropdown trigger']"))))
			.click();		
		}//clickOnProjectdropdown
		public void clickOnNoteBookDropdown() {
			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='notebooklistdropDownId']//div[@aria-label='dropdown trigger']"))))
			.click();		
		}//clickOnProjectdropdown
		
		
		public void slectValue(String value) {
			WebElement selectedvalue=driver.findElement(By.xpath("//p-dropdownitem//Li/span[contains(text(),'"+value+"')]"));
			wait.until(ExpectedConditions.elementToBeClickable(selectedvalue));
			selectedvalue.click();		
		}//slectValue
//		//*********************************Methods for unlock Functionality *******************

		public String getExperementUnlockEventDetail() {
			WebElement expstatus = driver.findElement(By.xpath("//tbody//tr//td[contains(@class,'EventType') and  contains(text(),'Request for unlock experiment')]//following-sibling::td[contains(@class,'EventDetails')]"));
			String status=this.wait.until(ExpectedConditions.elementToBeClickable(expstatus)).getText();
			return status.trim();
			}
		public void selectCheckBoxforUnclokExp(String exp) {
			WebElement checkBox=driver.findElement(By.xpath("//tbody//tr//td[contains(@class,'ExperimentCode')]//a[contains(text(),'"+exp+"')]/../preceding-sibling::td//mat-checkbox//div[@class='mdc-checkbox']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", checkBox);
			wait.until(ExpectedConditions.elementToBeClickable(checkBox));
			checkBox.click();
		}//selectCheckBoxforUnclokExp
		public void clickOnProcessForUnclokExp() {
			WebElement element=driver.findElement(By.xpath("//button[@id='processUnlockExperimentId']//span[text()='Process']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element))
					.click();
		}//clickOnProcessForUnclokExp
		
		//*********************************Methods for Event Page*******************
		
		public void clickOnEventTypedropdown() {
			this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='eventTypeId']//div[@aria-label='dropdown trigger']"))))
					.click();
		}//clickOnUserDropdown
		public void clickOnUserDropdownInEvents() {
			this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='selectUserId']//div[@aria-label='dropdown trigger']"))))
					.click();
		}//clickOnUserDropdown

		public void clcikOnGo() throws InterruptedException {
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//button[@id='goButoon']//mat-icon"))))
			.click();	
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
					actions.sendKeys(Keys.PAGE_DOWN).perform();
//			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		}
		
		public void clickOnStartDateForEvents() {
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//p-calendar[@id='auditTrailfromDateId']//button"))))
			.click();
		}
		public void clickOnEndDateforEvents() {
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//p-calendar[@id='auditTrailtoDateId']//button"))))
			.click();
		}
		public void selectDate(int year,int Month,int day) {
			 LocalDate desiredDate = LocalDate.of(year, Month, day);
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
		        // Loop until we find the desired month and year
		        while (true) {
		            // Get the currently displayed month and year
		            String displayedMonthYear = driver.findElement(By.xpath("//div[contains(@class, 'p-datepicker-title ')]")).getText(); 
		            System.out.println("Displayed Date "+displayedMonthYear);

		            if (displayedMonthYear.equals(desiredDate.format(formatter))) {
		                break; // Desired month and year found
		            }
		            // Click the next button to go to the next month
		            driver.findElement(By.xpath("//chevronlefticon")).click();
		        }

		        // Once the correct month is displayed, select the exact date
		        WebElement dateElement = driver.findElement(By.xpath("//table[contains(@class,'p-datepicker-calendar')]//tbody//td/span[not(contains(@class,'p-disabled')) and text()='"+desiredDate.getDayOfMonth()+"']")); 
		        dateElement.click();
		}//selectDate
		//*********************Methods for exportPDF*************************************************
		public boolean isfiledownloaded(String downloadsPath) {
			 File folder = new File(downloadsPath);
		        
		        // List files in the folder
		        File[] files = folder.listFiles();
		        
		        // Check if the folder exists and contains files
		        return files != null && files.length > 0;
		    }

		public String getFileName(String downloadsPath) {
			 File directory = new File(downloadsPath);
		        File[] files = directory.listFiles();

		        if (files != null && files.length > 0) {
		            long lastModified = Long.MIN_VALUE;
		            File lastFile = null;

		            // Loop through the files to find the most recently modified file
		            for (File file : files) {
		                if (file.isFile() && file.lastModified() > lastModified) {
		                    lastModified = file.lastModified();
		                    lastFile = file;
		                }
		            }

		            if (lastFile != null) {
		                return lastFile.getName(); // Return the name of the last downloaded file
		            }
		        }
		        return null; // No file found		}
		}
		//*********************Methods for History*********************************
		public void clickOnRefversionDropdown() {
			WebElement refDropdown=driver.findElement(By.xpath("//th[text()='Reference  Version']//../td[2]//div[@aria-label='dropdown trigger']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", refDropdown);
				wait.until(ExpectedConditions.elementToBeClickable(refDropdown));
				refDropdown.click();
						
		}//clickOnRefversionDropdown
		public void clickOnModifiedVersionDropdown() {
			WebElement refDropdown=driver.findElement(By.xpath("//th[text()='Modified Version']//../td[1]//div[@aria-label='dropdown trigger']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", refDropdown);
				wait.until(ExpectedConditions.elementToBeClickable(refDropdown));
				refDropdown.click();
						
		}//clickOnModifiedVersionDropdown
		
		
		public void slectValueInRefdropdown() {
			WebElement selectedvalue=driver.findElement(By.xpath("//p-dropdownitem//Li/span[text()='1']"));//selecting first version here
			 js.executeScript("arguments[0].scrollIntoView(true);", selectedvalue);
				wait.until(ExpectedConditions.elementToBeClickable(selectedvalue));
				selectedvalue.click();
					
		}//slectValueInRefdropdown
		public void slectValueInModifiedDropdown() {
			WebElement selectedvalue=driver.findElement(By.xpath("//p-dropdownitem//Li/span[text()='6']"));//selecting first version here
			 js.executeScript("arguments[0].scrollIntoView(true);", selectedvalue);
				wait.until(ExpectedConditions.elementToBeClickable(selectedvalue));
				selectedvalue.click();
					
		}//slectValueInRefdropdown
		public void clickOnCompare() {
			WebElement compare_button=driver.findElement(By.xpath("//button//span[text()=' Compare ']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", compare_button);
				wait.until(ExpectedConditions.elementToBeClickable(compare_button));
				compare_button.click();	
		}//clickOnCompare
		public void scrollTopVersion() throws InterruptedException {
			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iFrame1']"));
			driver.switchTo().frame(frameElement);
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//table[@id='summaryTable']/..//div[normalize-space()='SUMMARY']"))))
			.click();	
			
			  Actions actions = new Actions(driver);

	            // Scroll down using Page Down key multiple times
	            for (int i = 0; i < 10; i++) { // Adjust the count as needed
	                actions.sendKeys(Keys.PAGE_DOWN).perform();
	                Thread.sleep(1000); // Optional: add a short pause to see the effect
	            }
				driver.switchTo().defaultContent();
		}
		public void scrollBottomVersion() throws InterruptedException {
			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iFrame2']"));
			driver.switchTo().frame(frameElement);
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//table[@id='summaryTable']/..//div[normalize-space()='SUMMARY']"))))
			.click();	
			
			  Actions actions = new Actions(driver);

	            // Scroll down using Page Down key multiple times
	            for (int i = 0; i < 10; i++) { // Adjust the count as needed
	                actions.sendKeys(Keys.PAGE_DOWN).perform();
	                Thread.sleep(1000); // Optional: add a short pause to see the effect
	            }
				driver.switchTo().defaultContent();

		}
		
		
		
		//*********************Methods for Highlights*********************************

		public void enterHighlightedComments(String comments) {
			
			WebElement Frame = driver.findElement(By.xpath("//iframe[@id='highlightCmt_ifr']"));
			driver.switchTo().frame(Frame);
			WebElement textArea = driver.findElement(By.xpath("//body[@data-id='highlightCmt']"));

			textArea.click();
			textArea.clear();
//			textArea.sendKeys(Keys.ENTER);
			textArea.sendKeys(comments);
			driver.switchTo().defaultContent();
			}
		public void clickOnSaveHighlitedComments() {

			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='saveHighlightExpId']//span[text()=' Save ']")))).click();
		}//clickOnSaveHighlitedComments
		public void clickOnCancelHighlitedComments() {

			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='closeHighlightExpId']//span[text()=' Cancel ']")))).click();
		}//clickOnCancelHighlitedComments
		
		public void clickOneditHighlightComments(String exp) {

			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table//tr//td[contains(@class,'experimentDisplayId')]//span[contains(text(),'"+exp+"')]/..//following-sibling::td[contains(@class,'highlighted ')]//mat-icon[@id='editHighlightExpId']"))))
			.click();
		}//clickOneditHighlightComments
		public void clickOnDeleteHighlightComments(String exp) {

			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table//tr//td[contains(@class,'experimentDisplayId')]//span[contains(text(),'"+exp+"')]/..//following-sibling::td[contains(@class,'highlighted ')]//mat-icon[@id='deleteHighlightExpId']"))))
			.click();
		}//clickOnDeleteHighlightComments
		public void clickOnYesDeletelHighlitedCommentsPopup() {

			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Yes']")))).click();
		}//clickOnYesDeletelHighlitedCommentsPopup
		
		//*************************************************search methods***************

		public void Clickingonsearch() {
			WebElement element=driver.findElement(By.xpath("//a[@id='searchMainId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();	
		}
		public void ClickingonGensearch() {
			WebElement element=driver.findElement(By.xpath("//mat-icon[@id='searchGenId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
		}
		public void enterDataForsearchmin3char(String val) {
			WebElement element=driver.findElement(By.xpath("//input[@id='inputId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.sendKeys(val);
		}
		public void ClickingonSearch() {
			WebElement element=driver.findElement(By.xpath("//button[@id='genSearchId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
		}
		public void ClickingonMatchingNotebooks() {
			WebElement element=driver.findElement(By.xpath("//mat-panel-title[contains(text(),'Matching Notebooks')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
//			 this.wait
//				.until(ExpectedConditions
//						.elementToBeClickable(driver.findElement(By.xpath("//button[@id='genSearchId']"))))
//				.click();
		}
		public void ClickingonMatchingProjects() {
			WebElement element=driver.findElement(By.xpath("//mat-panel-title[contains(text(),'Matching Projects')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();

		}
		public void ClickingonMatchingExperiments() {
			WebElement element=driver.findElement(By.xpath("//mat-panel-title[contains(text(),'Matching Experiments')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();

		}
		
		public void Clickingoncriteriasearch() {
			WebElement element=driver.findElement(By.xpath("//mat-icon[@id='searchCriId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
			
		}
		
		public void Clickingonsearchprojectbutton() {
			WebElement element=driver.findElement(By.xpath("//mat-radio-button[@id='projectSerachId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
			
		}
		public void ClickingonsearchTestsButton() {
			WebElement element=driver.findElement(By.xpath("//mat-radio-button[@id='testSerachId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
			
		}
		public void ClickingonSearchExperimentbutton() {
			WebElement element=driver.findElement(By.xpath("//mat-radio-button[@id='expSerachId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
		}
		
		public void ClickingonprojectstatusANdSelect(String status) {
			WebElement element=driver.findElement(By.xpath("//p-dropdown[@id='selectedProjectStatusId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[text()='"+status+"']"))))
				.click();
		}
		public void ClickingonProductNameANdSelect(String prodName) {
			WebElement element=driver.findElement(By.xpath("//p-dropdown[@id='searchProjId']//div[@aria-label='dropdown trigger']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+prodName+"')]"))))
				.click();
		}
		public void ClickingonRouteANdSelect(String route) {
			WebElement element=driver.findElement(By.xpath("//p-dropdown[@id='staheId']//div[@aria-label='dropdown trigger']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+route+"')]"))))
				.click();
		}
		public void ClickingonStageANdSelect(String stage) {
			WebElement element=driver.findElement(By.xpath("//p-dropdown[@id='stageName']//div[@aria-label='dropdown trigger']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+stage+"')]"))))
				.click();
		}
		public void ClickingonCreatedByANdSelect(String user) {
			WebElement element=driver.findElement(By.xpath("//p-dropdown[@id='createdById']//div[@aria-label='dropdown trigger']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+user+"')]"))))
				.click();
		}
		public void ClickingonApprovedByANdSelect(String user) {
			WebElement element=driver.findElement(By.xpath("//p-dropdown[@id='approvedById']//div[@aria-label='dropdown trigger']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+user+"')]"))))
				.click();
		}
		public void ClickingonProjectCodeANdSelect(String projCode) {
			WebElement element=driver.findElement(By.xpath("//p-dropdown[@id='projectSearchId']//div[@aria-label='dropdown trigger']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+projCode+"')]"))))
				.click();
		}
		public void enterProductName(String prodName) {
			WebElement element=driver.findElement(By.xpath("//input[@id='productName']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.clear();
				element.sendKeys(prodName);
		}
		public void enterCreatedBy(String user) {
			WebElement element=driver.findElement(By.xpath("//input[@id='createById']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.clear();
				element.sendKeys(user);
		}
		public void enterExpCode(String expcode) {
			WebElement element=driver.findElement(By.xpath("//input[@id='code']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.clear();
				element.sendKeys(expcode);
		}
		public void enterNoteBook(String notebook) {
			WebElement element=driver.findElement(By.xpath("//input[@id='nId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.clear();
				element.sendKeys(notebook);
		}
		public void clickOnFromDate() {
			WebElement element=driver.findElement(By.xpath("//th//strong[text()='From Date:']/../following-sibling::th//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
		}
		public void clickOnToDate() {
			WebElement element=driver.findElement(By.xpath("//th//strong[text()='To Date:']/../following-sibling::th//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
		}
		
		
		
		public void ClickingonExpSearchImg() throws InterruptedException {
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//button[@id='searchExpId']"))))
					.click();
			 
				WebElement nextpage=driver.findElement(By.xpath("//button[@aria-label='Next page']"));
				this.wait
				.until(ExpectedConditions.visibilityOf(nextpage));
				Thread.sleep(2000);
		        js.executeScript("arguments[0].scrollIntoView(true);", nextpage);
				for(int i=0;i<4;i++) {
				if(nextpage.isEnabled())
					nextpage.click();
				Thread.sleep(2000);

				}//for
		}
		public void ClickingonTestSearchImg() throws InterruptedException {
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//button[@id='searchTestId']"))))
					.click();
			 
				WebElement nextpage=driver.findElement(By.xpath("//button[@aria-label='Next page']"));
				this.wait
				.until(ExpectedConditions.visibilityOf(nextpage));
				Thread.sleep(2000);
		        js.executeScript("arguments[0].scrollIntoView(true);", nextpage);
				for(int i=0;i<4;i++) {
				if(nextpage.isEnabled())
					nextpage.click();
				Thread.sleep(2000);

				}//for
		}
		
		public void ClickingonprojectSearchImg() throws InterruptedException {
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//mat-icon[@id='searchId']"))))
					.click();
				WebElement nextpage=driver.findElement(By.xpath("//button[@aria-label='Next page']"));
				this.wait
				.until(ExpectedConditions.visibilityOf(nextpage));
				Thread.sleep(2000);
				js.executeScript("arguments[0].scrollIntoView(true);", nextpage);

		        if(nextpage.isEnabled()) {
		        	for(int i=0;i<4;i++) {
		        		nextpage.click();
						Thread.sleep(2000);

		        	}
				}//if
		}
		public void ClickingonStandalonATRCheckbox() throws InterruptedException {
			 
				WebElement nextpage=driver.findElement(By.xpath("//mat-checkbox[@id='standaloneATRFlagId']//div[@class='mdc-checkbox']"));
				this.wait
				.until(ExpectedConditions.visibilityOf(nextpage));
				Thread.sleep(2000);
		        js.executeScript("arguments[0].scrollIntoView(true);", nextpage);
		        nextpage.click();
		}
		public void ClickingonExperimentalATRCheckbox() throws InterruptedException {
			 
			WebElement nextpage=driver.findElement(By.xpath("//mat-checkbox[@id='expAtrId']//div[@class='mdc-checkbox']"));
			this.wait
			.until(ExpectedConditions.visibilityOf(nextpage));
			Thread.sleep(2000);
	        js.executeScript("arguments[0].scrollIntoView(true);", nextpage);
	        nextpage.click();
	}
		public void ClickingonProjectCodeANdSelectInTestSearh(String prodName) {
			WebElement element=driver.findElement(By.xpath("//p-dropdown[@id='proId']//div[@aria-label='dropdown trigger']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+prodName+" ')]"))))
				.click();
		}
		public void ClickingonTeststatusANdSelect(String status) {
			WebElement element=driver.findElement(By.xpath("//p-dropdown[@id='textstatusId']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				this.wait
				.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[text()='"+status+"']"))))
				.click();
		}
		public void enterSamplecode(String samplecode) {
			WebElement element=driver.findElement(By.xpath("//input[@id='sampleCode']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.clear();
				element.sendKeys(samplecode);
		}
		public void clearSamplecode() {
			WebElement element=driver.findElement(By.xpath("//input[@id='sampleCode']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				   Actions actions = new Actions(driver);
		            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		            actions.sendKeys(Keys.DELETE).perform();
				
		}
		public void enterARNumber(String arnumber) {
			WebElement element=driver.findElement(By.xpath("//input[@id='arnumber']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.clear();
				element.sendKeys(arnumber);
		}
		public void enterBatchCode(String batchcode) {
			WebElement element=driver.findElement(By.xpath("//input[@id='bathNumner']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.clear();
				element.sendKeys(batchcode);
		}
//*******************************QA Comments methods*********************
		public void clickOnQAComments() {
			WebElement element=driver.findElement(By.xpath("//span[normalize-space()='QA Comments']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
		}
		public void clickOnAddButton() {
			WebElement add_button=driver.findElement(By.xpath("//span[text()=' Add']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", add_button);
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(add_button));
			 js.executeScript("arguments[0].click();", add_button);	
		}//clickOnAddButton
		public boolean commnetsDisplayed() {
			WebElement commentsSection=driver.findElement(By.xpath("//div[contains(@class,'panelTitle')and contains(text(),'QA Comments')]"));
			return commentsSection.isDisplayed();

		}//commnetsDisplayed
		
	}//
