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

public class AD_experimentsPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public AD_experimentsPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
	}
	@FindBy(xpath = "//a[@id='sidebar-toggle']")
	WebElement clickonLeftMenuIcon;  //LeftMenuIcon
	
	public void clickonLeftMenuIcon() {
		 js.executeScript("arguments[0].scrollIntoView(true);", clickonLeftMenuIcon);
			this.wait.until(ExpectedConditions.elementToBeClickable(clickonLeftMenuIcon));
			
			clickonLeftMenuIcon.click();
			}
	//**********************NotebookTabs*******************************************
		@FindBy(xpath = "//mat-icon[@id='projectParamsUsrId']")
		WebElement clickExpParametersNBLevel;

		public void clickExpParametersTabProjectLevel() {
			this.wait.until(ExpectedConditions.elementToBeClickable(clickExpParametersNBLevel));
			this.clickExpParametersNBLevel.click();
		}
		@FindBy(xpath = "//mat-icon[@id='notebookSummaryId']")
		WebElement clickSummaryTabNBLevel;

		public void clickSummayTabProjectLevel() {
			this.wait.until(ExpectedConditions.elementToBeClickable(clickSummaryTabNBLevel));
			this.clickSummaryTabNBLevel.click();
		}
		//***********************Click On Top Icons*************************
		public void clickOnApprovalIcon() {
			WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Approval')]/preceding::img[contains(@title,'Experiments pending approval')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
			 js.executeScript("arguments[0].click();", element);
		}
		public void clickOnReworkIcon() {
			WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Rework')]/preceding::img[contains(@title,'Experiments returned during  approval')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
			 js.executeScript("arguments[0].click();", element);
//
//				this.wait.until(ExpectedConditions.elementToBeClickable(element));		
//				element.click();
//				element.click();

		}
		
	//******************************************Experiment Parameters Adding in notebook level**********************
		@FindBy(xpath = "//mat-icon[@id='projectParamsUsrId']")

		WebElement clickon_Experiment_Parameter_Button; 

		public void clickon_Experiment_Parameter_Tab() {

			 js.executeScript("arguments[0].scrollIntoView(true);", clickon_Experiment_Parameter_Button);

				this.wait.until(ExpectedConditions.elementToBeClickable(clickon_Experiment_Parameter_Button));

				clickon_Experiment_Parameter_Button.click();

				}

		@FindBy(xpath = "//button[@id='AddNewRow_btn']")

		WebElement clickon_Experiment_Parameter_AddButton;  //LeftMenuIcon

		public void clickon_Experiment_Parameter_AddButton() {

			 js.executeScript("arguments[0].scrollIntoView(true);", clickon_Experiment_Parameter_AddButton);

				this.wait.until(ExpectedConditions.elementToBeClickable(clickon_Experiment_Parameter_AddButton));

				clickon_Experiment_Parameter_AddButton.click();

				}

		@FindBy(xpath = "//input[@id='parameterCodeinputtext']")

		WebElement Enter_Experiment_Parameter_ParameterCode;  //LeftMenuIcon

		public void Enter_Experiment_Parameter_ParameterCode(String value) {

			 js.executeScript("arguments[0].scrollIntoView(true);", Enter_Experiment_Parameter_ParameterCode);

				this.wait.until(ExpectedConditions.elementToBeClickable(Enter_Experiment_Parameter_ParameterCode));

				Enter_Experiment_Parameter_ParameterCode.sendKeys(value);

				}

		@FindBy(xpath = "//input[@id='resultParameterNameInputtext']")

		WebElement Enter_Experiment_Parameter_ParameterName;  //LeftMenuIcon

		public void Enter_Experiment_Parameter_ParameterName(String value) {

			 js.executeScript("arguments[0].scrollIntoView(true);", Enter_Experiment_Parameter_ParameterName);

				this.wait.until(ExpectedConditions.elementToBeClickable(Enter_Experiment_Parameter_ParameterName));

				Enter_Experiment_Parameter_ParameterName.sendKeys(value);

				}

		public void clickon_Select_I_O(String name) {

			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='ResultsId']//chevrondownicon"));

			 js.executeScript("arguments[0].scrollIntoView(true);", element);

								 this.wait

										.until(ExpectedConditions

												.elementToBeClickable(element))

										.click();

								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));

								 js.executeScript("arguments[0].scrollIntoView(true);", element1);

								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();

		}

		public void clickon_Select_UserEntered_Formula (String name) {

			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='inputFormulaId']//chevrondownicon"));

			 js.executeScript("arguments[0].scrollIntoView(true);", element);

								 this.wait

										.until(ExpectedConditions

												.elementToBeClickable(element))

										.click();

								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));

								 js.executeScript("arguments[0].scrollIntoView(true);", element1);

								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();

		}
		@FindBy(xpath = "//input[@id='validateinputtext']")

		WebElement Enter_Experiment_Parameter_Formula_Value;  

		public void Enter_Experiment_Parameter_FormulaValue(String value) {

			 js.executeScript("arguments[0].scrollIntoView(true);", Enter_Experiment_Parameter_ParameterName);

				this.wait.until(ExpectedConditions.elementToBeClickable(Enter_Experiment_Parameter_ParameterName));

				Enter_Experiment_Parameter_ParameterName.sendKeys(value);

				}

		public void clickon_Select_Type (String name) {

			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='selectInputOptionId']//chevrondownicon"));

			 js.executeScript("arguments[0].scrollIntoView(true);", element);

								 this.wait

										.until(ExpectedConditions

												.elementToBeClickable(element))

										.click();

								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));

								 js.executeScript("arguments[0].scrollIntoView(true);", element1);

								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();

		}

		public void clickon_Select_UOM (String name) {

			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='resultParameterUnitId']//chevrondownicon"));

			 js.executeScript("arguments[0].scrollIntoView(true);", element);

								 this.wait

										.until(ExpectedConditions

												.elementToBeClickable(element))

										.click();

								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));

								 js.executeScript("arguments[0].scrollIntoView(true);", element1);

								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();

		}

		@FindBy(xpath = "//input[@id='resultParameterRemarksInputtext']")

		WebElement Enter_Experiment_Parameter_Description;  //LeftMenuIcon

		public void Enter_Experiment_Parameter_Description(String value) {

			 js.executeScript("arguments[0].scrollIntoView(true);", Enter_Experiment_Parameter_Description);

				this.wait.until(ExpectedConditions.elementToBeClickable(Enter_Experiment_Parameter_Description));

				Enter_Experiment_Parameter_Description.sendKeys(value);

				}

		@FindBy(xpath = "//button[@id='SaveResultId']/mat-icon")

		WebElement clickon_Experiment_Parameter_SaveButton;

		public void clickon_Experiment_Parameter_SaveButton() {

			 js.executeScript("arguments[0].scrollIntoView(true);", clickon_Experiment_Parameter_SaveButton);

				this.wait.until(ExpectedConditions.elementToBeClickable(clickon_Experiment_Parameter_SaveButton));

				clickon_Experiment_Parameter_SaveButton.click();

				}

		@FindBy(xpath = "//button[@id='Cancel_btn']")

		WebElement clickon_Experiment_Parameter_CancelButton;  //LeftMenuIcon

		public void clickon_Experiment_Parameter_CancelButton() {

			 js.executeScript("arguments[0].scrollIntoView(true);", clickon_Experiment_Parameter_CancelButton);

				this.wait.until(ExpectedConditions.elementToBeClickable(clickon_Experiment_Parameter_CancelButton));

				clickon_Experiment_Parameter_CancelButton.click();

				}


		@FindBy(xpath = "//mat-icon[@id='notebookEventsId']")

		WebElement clickon_Notebook_AuditTrail;  //LeftMenuIcon

		public void clickon_Notebook_AuditTrail() {

			 js.executeScript("arguments[0].scrollIntoView(true);", clickon_Notebook_AuditTrail);

				this.wait.until(ExpectedConditions.elementToBeClickable(clickon_Notebook_AuditTrail));

				clickon_Notebook_AuditTrail.click();

				}

		@FindBy(xpath = "//button[@id='filterAudit_btn']")

		WebElement clickon_Notebook_AuditTrail_Go_button;  //LeftMenuIcon

		public void clickon_Notebook_AuditTrail_Go_button() {

			 js.executeScript("arguments[0].scrollIntoView(true);", clickon_Notebook_AuditTrail_Go_button);

				this.wait.until(ExpectedConditions.elementToBeClickable(clickon_Notebook_AuditTrail_Go_button));

				clickon_Notebook_AuditTrail_Go_button.click();

				}	
	 
	//*************************************ExperimentAdd Methods************************
	public void clcikOnNotebook(String Val) {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Method Development')]//..//img"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));		
			element.click();		
	}
	@FindBy(xpath = "//span[text()=' Add Experiment ']")
	WebElement clickonAdd_Experiment_Button;  //LeftMenuIcon
	public void clickonAdd_Experiment_Button() {
		 js.executeScript("arguments[0].scrollIntoView(true);", clickonAdd_Experiment_Button);
			this.wait.until(ExpectedConditions.elementToBeClickable(clickonAdd_Experiment_Button));
			clickonAdd_Experiment_Button.click();
			}
	public void clickAndSlectTemplate(String name) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='updateValuesId']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	}
	public void clickAndSlectSubtype(String name) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='testSubTypeList_btn']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	}
	public void clickAndSlectTesttype(String name) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='loadTestSubTypeId']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	}
	public void enterExperimentAim(String desc) {
		WebElement frameElement = driver.findElement(By.xpath("//td[@id='expAimEdotor']//iframe"));
		driver.switchTo().frame(frameElement);
		
		WebElement desc_text=driver.findElement(By.xpath("//body[@id='tinymce']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
		desc_text.click();	
		desc_text.clear();	
		desc_text.sendKeys(desc);
		
		driver.switchTo().defaultContent();

	}
	public void clcikOnSaveExperiment() {
		WebElement element = driver.findElement(By.xpath("//button[@id='createExperiment_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();		
	}
	public void clcikOnCancelExperiment() {
		WebElement element = driver.findElement(By.xpath("//button[@id='cancelPopup_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();		
	}
	@FindBy(xpath = "//tbody//tr[1]/td[contains(@class,'column-experimentDisplayId')]//a")//first row have the latest exp link
	WebElement exp_link;
	public void clickOnExpLink() {
		 js.executeScript("arguments[0].scrollIntoView(true);", exp_link);
		this.wait.until(ExpectedConditions.elementToBeClickable(exp_link));
		this.exp_link.click();	
       }
	public String getExperimentcode() {
		WebElement expCode = driver.findElement(By.xpath("//th[contains(text(),' Experiment Code:')]//..//td[1]//mat-label"));
		 js.executeScript("arguments[0].scrollIntoView(true);", expCode);

		return this.wait.until(ExpectedConditions.elementToBeClickable(expCode)).getText();
	}
	
	//*********************************************Experiment edit methods***************************
	public void clcikOnNoRestoreExperimentData() {
		WebElement element = driver.findElement(By.xpath("//button[@Id='closeInterMediateSaveId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));		
			element.click();		
	}
	public void clcikOnYesRestoreExperimentData() {
		WebElement element = driver.findElement(By.xpath("//button[@Id='loadInterMediateSaveExperimentId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));		
			element.click();		
	}
	
	//**************************************Sample Details Methods*****************************************
	public void clcikOnSampleDetailsAddIcon() {
		WebElement element = driver.findElement(By.xpath("//*[@id='addMultipleSample_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));		
			element.click();		
	}
	public void enterSampleCode(String val) {
		WebElement element = driver.findElement(By.xpath("//div[@role='dialog']//th[contains(@class,'samplecode')]//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).click();
							 element.sendKeys(val);
	}
	public void clickonSamplecodeCheckbox(String samplecode) {
		WebElement checkbox = driver.findElement(By.xpath("//mat-label[normalize-space()='"+samplecode+"']//..//preceding-sibling::td//div[@class='mdc-checkbox']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(checkbox))
									.click();
		}
	public void clcikOnATRSaveTest() {
		WebElement element = driver.findElement(By.xpath("//button[@id='saveMultipleSample_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clickonSendforverificationCheckbox(String atrformno) {
		WebElement checkbox = driver.findElement(By.xpath("//a[contains(text(),'"+atrformno+"')]//following::td//div[@class='mdc-checkbox']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(checkbox))
									.click();
		}
	public void clcikOnATRTestEditIcon(String atrformno) {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+atrformno+"')]//following::td//mat-icon[@mattooltip='Edit']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void enterTestResultsInExp(String val) {
		
		WebElement iFrame = driver.findElement(By.xpath("//*[text()=' Test Results ']//..//iframe"));
		driver.switchTo().frame(iFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@id='tinymce']"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys(val);
		driver.switchTo().defaultContent();
		}
	public void enterResultsRemarksInexp(String val) {	
		WebElement iFrame = driver.findElement(By.xpath("//*[contains(text(),'Result Remarks')]//..//iframe"));
		driver.switchTo().frame(iFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@id='tinymce']"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys(val);
		driver.switchTo().defaultContent();
		}
	public void enterAdRemarksInExp(String val) {	
		WebElement iFrame = driver.findElement(By.xpath("//*[contains(text(),'AD Remarks')]//..//iframe"));
		 js.executeScript("arguments[0].scrollIntoView(true);", iFrame);
		driver.switchTo().frame(iFrame);
		WebElement textArea = driver.findElement(By.xpath("//body[@id='tinymce']"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys(val);
		driver.switchTo().defaultContent();
		}
	public void clcikOnAttachmentAddIconInExp() {
		WebElement element = driver.findElement(By.xpath("//mat-icon[@mattooltip='Upload File']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void uploadRawDataAttachmentInExp(String path) {				
		WebElement element = driver.findElement(By.xpath("//button//input[@type='file']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		 element.sendKeys(path);
	}
	public void enterRawDataAttachmentNameInExp(String path) {				
		WebElement element = driver.findElement(By.xpath("//strong[contains(text(),'Attachment Name :')]//..//following::td//input[@type='text']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(path);
	}
	public void  ClickOnSaveAttachment() {
		WebElement element = driver.findElement(By.xpath("//button[@id='saveRawdataAttach_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnTsetReport() {
		WebElement element = driver.findElement(By.xpath("//button[@id='edit_button_d']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnUploadReport() {
		WebElement element = driver.findElement(By.xpath("//button[@id='uploadFinalReport_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void uploadReportFortest(String path) {				
		WebElement element = driver.findElement(By.xpath("//button[@id='finalreport_id']//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		 element.sendKeys(path);
	}
	public void  ClickOnSaveFinalReport() {
		WebElement element = driver.findElement(By.xpath("//button[@id='add_button_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void  ClickOnSaveTestFinal() {
		WebElement element = driver.findElement(By.xpath("//button[@id='saveSampleResultsToList_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	
	//*********************************************Weighing Details Methods************************
	public void clcikOnWeighningDetailsAddIcon() {
		WebElement element = driver.findElement(By.xpath("//app-weighing-details-editor//mat-icon[@id='add_circle_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));		
			element.click();		
	}
	public void  ClickOnWDEnterMunually() {
		WebElement element = driver.findElement(By.xpath("//a[@id='showAddManuallyPopup_id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();	
	}
	public void enterParticularsWD(String value) {
		WebElement element = driver.findElement(By.xpath("//th[contains(text(),'Particulars')]//..//following-sibling::td//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void enterTareweight(String value) {
		WebElement element = driver.findElement(By.xpath("//th[contains(text(),'Tare Weight')]//..//following-sibling::td//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void clickAndSlectUOM(String name) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='uomList_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();	
	}
	public void enterGrosswt(String value) {
		WebElement element = driver.findElement(By.xpath("//th[contains(text(),'Gross Weight')]//..//following-sibling::td//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void enterInstrumentIDWD(String value) {
		WebElement element = driver.findElement(By.xpath("//th[contains(text(),'Instrument Id')]//..//following-sibling::td//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void enterRemarksWD(String value) {
		WebElement element = driver.findElement(By.xpath("//th[contains(text(),'Remarks')]//..//following-sibling::td//input"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void clcikOnSaveWD() {
		WebElement element = driver.findElement(By.xpath("//button[@id='saveWeighingValues_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();		
	}
	public void clcikOnCancelWD() {
		WebElement element = driver.findElement(By.xpath("//button[@id='hideAddWtPopup_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();		
	}
	//*********************************************PH Details Methods************************
		public void clcikOnPHDetailsAddIcon() {
			WebElement element = driver.findElement(By.xpath("//app-ph-details-editor//mat-icon[@id='add_circle_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));		
				element.click();		
		}
		public void  ClickOnPHDEnterMunually() {
			WebElement element = driver.findElement(By.xpath("//a[@id='showAddManuallyPopup_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));	
			element.click();	
		}
		public void enterParticularsPHD(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='pName_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterPHvalue(String value) {
			WebElement element = driver.findElement(By.xpath("//th[contains(text(),'PH Value')]//..//following-sibling::td//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterTemperature(String value) {
			WebElement element = driver.findElement(By.xpath("//th[contains(text(),'Temperature')]//..//following-sibling::td//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterInstrumentIDPHD(String value) {
			WebElement element = driver.findElement(By.xpath("//div[@id='equipCodeListId']//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterRemarksPHD(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='remarksInputId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clcikOnSavePHD() {
			WebElement element = driver.findElement(By.xpath("//button[@id='panelPhDetails_Btn']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnCancelPHD() {
			WebElement element = driver.findElement(By.xpath("//button[@id='hideAddPhPopup_btn']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
	//*******************************************Equipment Details Methods*********************
		public void clcikOnEquipmentDetailsAddIcon() {
			WebElement element = driver.findElement(By.xpath("//mat-icon[@id='addEquipment_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));		
				element.click();		
		}
		@FindBy(xpath = "//input[@id='checkBoxChanged_Id-input']//..")
		WebElement equipment_manualentry_checkbox; 
		public void equipment_manualentry_checkbox() {
	 
			this.wait.until(ExpectedConditions.elementToBeClickable(equipment_manualentry_checkbox));
			equipment_manualentry_checkbox.click();	
		}//equipment_manualentry_checkbox
		public void enterInstrumentType(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='manualEntryFlag_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterInstrumentName(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='equipmentName_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterInstrumentCode(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='equipmentCode_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clcikOnStartDate() {
			WebElement element = driver.findElement(By.xpath("//th[@id='endtimeId']//preceding::td//button"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));		
				element.click();		
		}
		public void clcikOnEndDate() {
			WebElement element = driver.findElement(By.xpath("//th[@id='endtimeId']//following::td//button"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));		
				element.click();		
		}
		public void enterRemarksED(String value) {
			WebElement element = driver.findElement(By.xpath("//textarea[@id='remarks_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clcikOnSaveED() {
			WebElement element = driver.findElement(By.xpath("//button[@id='saveEquipment_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnCancelED() {
			WebElement element = driver.findElement(By.xpath("//button[@id='cancleAddEquipment_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
	//***************************************************Enter Section Values*************************
		//*************************Enter embedded values************************
		public void scrollToEmbededExcel() {
			WebElement element = driver.findElement(By.xpath("//div[contains(@id,'EmbeddedExcel')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
						
		}
		public void enterembededValues(int row,int column,int value) {
			WebElement element = driver.findElement(By.xpath("//div[contains(@id,'EmbeddedExcel')]//table//tr["+row+"]//td[@data-x='"+column+"']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).click();
				 js.executeScript("arguments[0].innerText = '"+value+"';", element);

		}
	//*****************************************************Enter Richtext Values******************************************
		public void enterRichText(String caution) {
			
			WebElement precautionFrame = driver.findElement(By.xpath("//iframe[contains(@id,'Richtext')]"));
			driver.switchTo().frame(precautionFrame);
			WebElement textArea = driver.findElement(By.xpath("//body[contains(@data-id,'Richtext')]"));

			textArea.click();
			textArea.clear();
//			textArea.sendKeys(Keys.ENTER);
			textArea.sendKeys(caution);
			driver.switchTo().defaultContent();
			}
		public void enterStandardPreparation(String caution) {
			
			WebElement precautionFrame = driver.findElement(By.xpath("//iframe[contains(@id,'Standard Preparation')]"));
			driver.switchTo().frame(precautionFrame);
			WebElement textArea = driver.findElement(By.xpath("//body[contains(@data-id,'Standard Preparation')]"));

			textArea.click();
			textArea.clear();
//			textArea.sendKeys(Keys.ENTER);
			textArea.sendKeys(caution);
			driver.switchTo().defaultContent();
			}
		
		@FindBy(xpath = "//div[@id='displayShortDISection_Id']//input[@id='shortIdNum']")
		WebElement Enter_Experiment_Combined_Data;  //LeftMenuIcon
		public void Enter_Experiment_Combined_Data(String value) {
			 js.executeScript("arguments[0].scrollIntoView(true);", Enter_Experiment_Combined_Data);
				this.wait.until(ExpectedConditions.elementToBeClickable(Enter_Experiment_Combined_Data));
				Enter_Experiment_Combined_Data.sendKeys(value);
				}
		@FindBy(xpath = "//div[contains(text(),' DtbleCombined')]//mat-icon[@id='addToDataTableList_Id']")
		WebElement Click_Experiment_Data_Combined_Addbutton;  //LeftMenuIcon
		public void Click_Experiment_Data_Combined_Addbutton() {
			 js.executeScript("arguments[0].scrollIntoView(true);", Click_Experiment_Data_Combined_Addbutton);
				this.wait.until(ExpectedConditions.elementToBeClickable(Click_Experiment_Data_Combined_Addbutton));
				Click_Experiment_Data_Combined_Addbutton.click();
				}
		@FindBy(xpath = "//mat-icon[@id='saveDataTableRow_ID']")
		WebElement Click_Experiment_Data_Combined_Savebutton;  //LeftMenuIcon
		public void Click_Experiment_Data_Combined_Savebutton() {
			 js.executeScript("arguments[0].scrollIntoView(true);", Click_Experiment_Data_Combined_Savebutton);
				this.wait.until(ExpectedConditions.elementToBeClickable(Click_Experiment_Data_Combined_Savebutton));
				Click_Experiment_Data_Combined_Savebutton.click();
				}
		@FindBy(xpath = "//div[contains(text(),' DtbleCombined')]//mat-icon[@id='cancelAddingRow_Id']")
		WebElement Click_Experiment_Data_Combined_cancelbutton;  //LeftMenuIcon
		public void Click_Experiment_Data_Combined_cancelbutton() {
			 js.executeScript("arguments[0].scrollIntoView(true);", Click_Experiment_Data_Combined_cancelbutton);
				this.wait.until(ExpectedConditions.elementToBeClickable(Click_Experiment_Data_Combined_cancelbutton));
				Click_Experiment_Data_Combined_cancelbutton.click();
				}

		@FindBy(xpath = "//table[@id='displaySubtable_btn']//input[@id='shortIdNum']")
		WebElement Enter_Experiment_Data_Combined;  //LeftMenuIcon
		public void Enter_Experiment_Data_Combined(String value) {
			 js.executeScript("arguments[0].scrollIntoView(true);", Enter_Experiment_Data_Combined);
				this.wait.until(ExpectedConditions.elementToBeClickable(Enter_Experiment_Data_Combined));
				Enter_Experiment_Data_Combined.sendKeys(value);
				}
		@FindBy(xpath = "//input[@id='pinputtext']")
		WebElement Click_Experiment_Params;  //LeftMenuIcon
//		public void Click_Experiment_Params(String value) {
//			 js.executeScript("arguments[0].scrollIntoView(true);", Click_Experiment_Params);
//				this.wait.until(ExpectedConditions.elementToBeClickable(Click_Experiment_Params));
//				Click_Experiment_Params.sendKeys(value);
//				}
	 
		public void Click_Experiment_Params_date() {		
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			String date = dtf.format(now).toString();
//			WebElement toDaysDate = driver.findElement(By.xpath(
//					"//table[contains(@class,'p-datepicker-calendar')]//tbody//td/span[not(contains(@class,'p-disabled')) and text()='"
//							+ date1[2] + "']"));
			Click_Experiment_Params.sendKeys(date);
		}
		@FindBy(xpath = "//div[contains(text(),' Datatable')]//mat-icon[@id='addToDataTableList_Id']")
		WebElement Click_Experiment_Datatable_Addbutton;  //LeftMenuIcon
		public void Click_Experiment_Datatable_Addbutton() {
			 js.executeScript("arguments[0].scrollIntoView(true);", Click_Experiment_Datatable_Addbutton);
				this.wait.until(ExpectedConditions.elementToBeClickable(Click_Experiment_Datatable_Addbutton));
				Click_Experiment_Datatable_Addbutton.click();
				}	

		@FindBy(xpath = "//app-datatable-section-editor//mat-icon[@id='saveDataTableRow_Id']")
		WebElement Click_Experiment_Datatable_Savebutton;  //LeftMenuIcon
		public void Click_Experiment_Datatable_Savebutton() {
			 js.executeScript("arguments[0].scrollIntoView(true);", Click_Experiment_Datatable_Savebutton);
				this.wait.until(ExpectedConditions.elementToBeClickable(Click_Experiment_Datatable_Savebutton));
				Click_Experiment_Datatable_Savebutton.click();
				}	
		@FindBy(xpath = "//input[@id='withoutgrouping']")
		WebElement Enter_Experiment_Datatable_Individual;  //LeftMenuIcon
		public void Enter_Experiment_Datatable_Individualval(String value) {
			 js.executeScript("arguments[0].scrollIntoView(true);", Enter_Experiment_Datatable_Individual);
				this.wait.until(ExpectedConditions.elementToBeClickable(Enter_Experiment_Datatable_Individual));
				Enter_Experiment_Datatable_Individual.sendKeys(value);
				}
		@FindBy(xpath = "//div[contains(text(),' Datatable')]//mat-icon[@id='cancelAddingRow_Id']")
		WebElement Click_Experiment_Datatable_Cancelbutton;  //LeftMenuIcon
		public void Click_Experiment_Datatable_Cancelbutton() {
			 js.executeScript("arguments[0].scrollIntoView(true);", Click_Experiment_Datatable_Cancelbutton);
				this.wait.until(ExpectedConditions.elementToBeClickable(Click_Experiment_Datatable_Cancelbutton));
				Click_Experiment_Datatable_Cancelbutton.click();
				}	
		@FindBy(xpath = "//mat-icon[@id='openUploadFileDialog_Id']")
		WebElement Click_Experiment_Attachment_Uploadbutton;  //LeftMenuIcon
		public void Click_Experiment_Attachment_Uploadbutton() {
			 js.executeScript("arguments[0].scrollIntoView(true);", Click_Experiment_Attachment_Uploadbutton);
				this.wait.until(ExpectedConditions.elementToBeClickable(Click_Experiment_Attachment_Uploadbutton));
				Click_Experiment_Attachment_Uploadbutton.click();
				}	
		
		//**************************Experimrnt Attachement Methods*******************
		
		@FindBy(xpath = "//input[@id='password_Id']")
		WebElement Enter_Experiment_Attachment_Password;  //LeftMenuIcon
		public void Enter_Experiment_Attachment_Password(String value) {
			 js.executeScript("arguments[0].scrollIntoView(true);", Enter_Experiment_Attachment_Password);
				this.wait.until(ExpectedConditions.elementToBeClickable(Enter_Experiment_Attachment_Password));
				Enter_Experiment_Attachment_Password.sendKeys(value);
				}
		@FindBy(xpath = "//button[@id='validatePasswordSave_btn']")
		WebElement ClickOnAttachmentSubmit;  //LeftMenuIcon
		public void ClickOnAttachmentSubmit() {
			 js.executeScript("arguments[0].scrollIntoView(true);", ClickOnAttachmentSubmit);
				this.wait.until(ExpectedConditions.elementToBeClickable(ClickOnAttachmentSubmit));
				ClickOnAttachmentSubmit.click();
				}
		@FindBy(xpath = "//button[@id='fileUpload_Id']//input")
		WebElement uploadAttachmentFile;  //LeftMenuIcon
		public void uploadAttachmentFile(String value) {
			 js.executeScript("arguments[0].scrollIntoView(true);", uploadAttachmentFile);
//				this.wait.until(ExpectedConditions.elementToBeClickable(uploadAttachmentFile));
				uploadAttachmentFile.sendKeys(value);
				}
		@FindBy(xpath = "//input[@id='attachNameInputtext']")
		WebElement enterAttachName;  //LeftMenuIcon
		public void enterAttachmentName(String value) {
			 js.executeScript("arguments[0].scrollIntoView(true);", enterAttachName);
				this.wait.until(ExpectedConditions.elementToBeClickable(enterAttachName));
				enterAttachName.sendKeys(value);
				}
		
		@FindBy(xpath = "//button[@id='saveAttachment_Id']")
		WebElement clickOnsaveAttachment;  //LeftMenuIcon
		public void clickOnsaveAttachment() {
			 js.executeScript("arguments[0].scrollIntoView(true);", clickOnsaveAttachment);
				this.wait.until(ExpectedConditions.elementToBeClickable(clickOnsaveAttachment));
				clickOnsaveAttachment.click();
				}
		
		//****************************************Experiment Parameters Methods**************
		
		public void clcikOnExpparametersAddIcon() {
			WebElement element = driver.findElement(By.xpath("//mat-icon[@id='AddNewRow_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnExpparameterCheckbox() {
			WebElement element = driver.findElement(By.xpath("//app-quantitative-result-editor//tr[1]//mat-checkbox//div[@class='mdc-checkbox']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnSaveExpparameter() {
			WebElement element = driver.findElement(By.xpath("//mat-icon[@id='saveResult_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void enterExpParamCode(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='paramCodeInputtextCode']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterExpParamName(String value) {
			WebElement element = driver.findElement(By.xpath("//*[@id='filterDataitem_Id']//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clickAndSlectIOValue(String name) {
			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='readonlyrow_Id']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
								 js.executeScript("arguments[0].scrollIntoView(true);", element1);
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
		public void clickAndSlectUserEneteredOrFormula(String name) {
			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='setInputFormulaValue_Id']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
								 js.executeScript("arguments[0].scrollIntoView(true);", element1);
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
		public void enterExpFormula(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@Id='formulaStrInputtext']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clickAndSlectexpType(String name) {
			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='setParamValue_Id']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
								 js.executeScript("arguments[0].scrollIntoView(true);", element1);
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
		public void enterExpParametervalue(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='locale-indian']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clickAndExpSlectUOM(String name) {
			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='resUOM_Id']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
								 js.executeScript("arguments[0].scrollIntoView(true);", element1);
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
		public void enterConclusion(String desc) {
			WebElement frameElement = driver.findElement(By.xpath("//app-conclusion-editor//iframe"));
			driver.switchTo().frame(frameElement);
			
			WebElement desc_text=driver.findElement(By.xpath("//body[@id='tinymce']"));
			this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
			desc_text.click();	
			desc_text.clear();	
			desc_text.sendKeys(desc);
			
			driver.switchTo().defaultContent();

		}
	//***************************Experiment Save to till approve Methods***********************
		public void clcikOnSaveExperimentAfterEdits() {
			WebElement element = driver.findElement(By.xpath("//button[@id='authBeforeSaveExperimentId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void enterSaveComments(String desc) {
			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='saveAuthComments_ifr']"));
			driver.switchTo().frame(frameElement);
			
			WebElement desc_text=driver.findElement(By.xpath("//body[@data-id='saveAuthComments']"));
			this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
			desc_text.click();	
			desc_text.clear();	
			desc_text.sendKeys(desc);
			
			driver.switchTo().defaultContent();

		}
		public void enterSavePassword(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='passwordId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clcikOnConfirmExperimentSave() {
			WebElement element = driver.findElement(By.xpath("//button[@Id='saveExperimentIdAuth']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnSubmitApprovalExperimentAfterEdits() {
			WebElement element = driver.findElement(By.xpath("//button[@id='validateApproveReq_btn']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnYesonATRResultSubmissionAlert() {
			WebElement element = driver.findElement(By.xpath("//button[@id='checkResultAvailablesaveId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clickAndExpSlectApprover(String name) {
			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='verList']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
		public void enterApproveComments(String desc) {
			WebElement frameElement = driver.findElement(By.xpath("//*[@id='saveCommentsId']//iframe"));
			driver.switchTo().frame(frameElement);
			
			WebElement desc_text=driver.findElement(By.xpath("//body[@id='tinymce']"));
			this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
			desc_text.click();	
			desc_text.clear();	
			desc_text.sendKeys(desc);
			
			driver.switchTo().defaultContent();

		}
		public void clcikOnConfirmExperimentApproveSending() {
			WebElement element = driver.findElement(By.xpath("//button[@id='submitForApprovaId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void enterApprovePassword(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='passwordId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clcikOnToViewNotebook() {
			WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'To view the notebook')]/span"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clickOnExperiments(String expLink) {
			WebElement explink=driver.findElement(By.xpath("//tbody//tr/td[contains(@class,'column-experimentDisplayId')]//a[contains(text(),'"+expLink+"')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", explink);
			wait.until(ExpectedConditions.elementToBeClickable(explink));
			explink.click();		
		}//clickOnExperiments
		public String getStatusOfExperiment(String expCode) {
			WebElement expstatus = driver.findElement(By.xpath("//tbody//tr//td//*[self::span or self::a][contains(text(),'"+expCode+"')]/../following-sibling::td[contains(@class,'column-experimentStatus')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", expstatus);
			String status=this.wait.until(ExpectedConditions.elementToBeClickable(expstatus)).getText();
			return status.trim();
			}
		
	//*****************************Experiment return and Approve methods**************************************
		public void clickOnExperimentsUnderApprovalRequests(String expLink) {				//works for all experiment links
			WebElement explink=driver.findElement(By.xpath("//a[contains(text(),'"+expLink+"')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", explink);
			wait.until(ExpectedConditions.elementToBeClickable(explink));
			explink.click();		
		}
		public void clcikOnReturnExperiment() {
			WebElement element = driver.findElement(By.xpath("//button[@id='beforeSuggestImprovement_btn']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnApproveExperiment() {
			WebElement element = driver.findElement(By.xpath("//button[@id='approve_btn']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnSampledetailsAddcomments() {
			WebElement element = driver.findElement(By.xpath("//app-sample-section//mat-icon[@id='commentPopup_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnEditSubmittedTest() {
			WebElement element = driver.findElement(By.xpath("//app-sample-section//mat-icon[@id='dispSubmissionPopupId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnConfirmTestByTL() {
			WebElement element = driver.findElement(By.xpath("//button[@id='acceptTest_btn']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnRejectTestByTL() {
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Reject')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void enterAcceptComments(String desc) {                      
			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='comment_editorId_ifr']"));
			driver.switchTo().frame(frameElement);
			
			WebElement desc_text=driver.findElement(By.xpath("//body[@id='tinymce']"));
			this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
			desc_text.click();	
			desc_text.clear();	
			desc_text.sendKeys(desc);
			
			driver.switchTo().defaultContent();

		}
		public void enterrejectComments(String desc) {                     
			WebElement frameElement = driver.findElement(By.xpath("//*[@id='comment_editorId']//iframe"));
			driver.switchTo().frame(frameElement);
			
			WebElement desc_text=driver.findElement(By.xpath("//body[@id='tinymce']"));
			this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
			desc_text.click();	
			desc_text.clear();	
			desc_text.sendKeys(desc);
			
			driver.switchTo().defaultContent();

		}
		public void clcikOnDone() {
			WebElement element = driver.findElement(By.xpath("//button[@id='saveAccept']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnRejectCancel() {
			WebElement element = driver.findElement(By.xpath("//button[@id='confirmcancel_btn']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void enterSampleDetailsComments(String desc) {
			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='Sample Details section commentId_ifr']"));
			driver.switchTo().frame(frameElement);
			
			WebElement desc_text=driver.findElement(By.xpath("//body[@id='tinymce']"));
			this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
			desc_text.click();	
			desc_text.clear();	
			desc_text.sendKeys(desc);
			
			driver.switchTo().defaultContent();

		}
		public void clcikOnSDCommentsAdd() {
			WebElement element = driver.findElement(By.xpath("//button[@id='saveCommentsId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnSDCommentsCancel() {
			WebElement element = driver.findElement(By.xpath("//button[@id='expDataSerCancelId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void enterReworkComments(String desc) {
			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='reworkCommentsId_ifr']"));
			driver.switchTo().frame(frameElement);
			
			WebElement desc_text=driver.findElement(By.xpath("//body[@id='tinymce']"));
			this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
			desc_text.click();	
			desc_text.clear();	
			desc_text.sendKeys(desc);
			
			driver.switchTo().defaultContent();
		}
		public void enterReworkPassword(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='passwordId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clcikOnConfirmExperimentRework() {
			WebElement element = driver.findElement(By.xpath("//button[@id='sendForReworkId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnCancelExperimentRework() {
			WebElement element = driver.findElement(By.xpath("//button[@id='closeReworkDialogId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clickAndAimAchieved(String name) {
			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='aimListId']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
		public void enterApprovedComments(String desc) {
			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='approveCommentsId_ifr']"));
			driver.switchTo().frame(frameElement);
			
			WebElement desc_text=driver.findElement(By.xpath("//body[@id='tinymce']"));
			this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
			desc_text.click();	
			desc_text.clear();	
			desc_text.sendKeys(desc);
		
			driver.switchTo().defaultContent();
		}
		public void enterApprovedPassword(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='passwordId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clcikOnConfirmExperimentApproval() {
			WebElement element = driver.findElement(By.xpath("//button[@id='approveExperimentId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		public void clcikOnCancelExperimentApproval() {
			WebElement element = driver.findElement(By.xpath("//button[@id='cancelapproveExperimentId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
				this.wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();		
		}
		
}
