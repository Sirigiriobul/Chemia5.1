package Chemia.Project.Creation.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project_Creation_Page {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public Project_Creation_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
}
	
	@FindBy(xpath = "//div[contains(@class,'p-toast-summary')]")
	WebElement TostMessage; // Tost Message

	public String GetTostMessage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(TostMessage));
		return this.TostMessage.getText();
		
	}
		@FindBy(id = "addProject")
		WebElement addProjecticon; //Clicking on add project icon 

		public void addProjecticon() {
			this.wait.until(ExpectedConditions.elementToBeClickable(addProjecticon));
			this.addProjecticon.click();
	
		}
		@FindBy(xpath = "//span[@class='button-text']")
		WebElement Go_button; //Clicking on add project icon 

		public void Go_button() {
			this.wait.until(ExpectedConditions.elementToBeClickable(Go_button));
			this.Go_button.click();
	
		}
		
		@FindBy(xpath = "//span[text()=' Save']")
		WebElement Clickingonsavebutton; //Clicking on add project icon 

		public void Clickingonsavebutton() {
			this.wait.until(ExpectedConditions.elementToBeClickable(Clickingonsavebutton));
			this.Clickingonsavebutton.click();
	
		}
		@FindBy(xpath = "//button[@class='mat-focus-indicator remove-button mat-raised-button mat-button-base']")
		WebElement Clickingoncancelbutton; //Clicking on add project icon 

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
		
	
		@FindBy(xpath = "//textarea[@inputid='textarea']")
		WebElement EnteringDescription; //Clicking on add project icon 

		public void EnteringDescription(String value) {
			this.wait.until(ExpectedConditions.elementToBeClickable(EnteringDescription));
			this.EnteringDescription.sendKeys(value);
	
		}
	

		@FindBy(xpath = "//textarea[@formcontrolname='description']")
		WebElement DescriptionClear;

		public void DescriptionClear() {
			this.wait.until(ExpectedConditions.elementToBeClickable(DescriptionClear));
			this.DescriptionClear.clear();

		}
		
		public void GetprojectName(String ProjectName) {
			
			List<WebElement> AllProjectNames = driver.findElements(By.xpath("//li[@role='option']"));
			
			for(WebElement IndiviualProjectName : AllProjectNames) {
				
				String ProjectCode = IndiviualProjectName.getText().split(" ")[0].trim(); 
				
				if(ProjectCode.equals(ProjectName)) {
					
					wait.until(ExpectedConditions.elementToBeClickable(IndiviualProjectName));
					IndiviualProjectName.click();
					break;
					
				}
				
			}
			
		

		}
	
		@FindBy(xpath = "//mat-icon[normalize-space()='home']")
		WebElement Clickingonhomebutton; //Clicking on add project icon 

		public void Clickingonhomebutton() {
			this.wait.until(ExpectedConditions.elementToBeClickable(Clickingonhomebutton));
			this.Clickingonhomebutton.click();
	
	
		}
		
	
		public void DropdownButton() {
			this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Select Project')]/following-sibling::div[@aria-label='dropdown trigger']//chevrondownicon"))))
					.click();
//path updated - 5.1
		}
		public void Yesbuttononcloseproject() {
			this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Yes']"))))
					.click();

		}
		public void Yesbuttonondeactivateproject() {
			this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Yes']"))))
					.click();

		}
		
		
		
		public void YesbuttononReopenproject() {
			this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Yes']"))))
					.click();

		}
		
		public void ReopenProject() {
			this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//button[@id='reopen']"))))
					.click();

		}
		/*
		public void ClickClosedProject(int i) {
			this.wait
					.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr["+ i +"]//td[1]"))))
					.click();

		}
		*/
		
		
		
		@FindBy(xpath = "//button[@id='editSummary']")
		WebElement Clickingoneditbutton; //Clicking on add project icon 

		public void Clickingoneditbutton() {
			this.wait.until(ExpectedConditions.elementToBeClickable(Clickingoneditbutton));
			this.Clickingoneditbutton.click();
		}
		
		@FindBy(xpath = "//button[@id='closeButton']")
			WebElement Clickingonclosebutton; //Clicking on add project icon 

			public void Clickingonclosebutton() {
				this.wait.until(ExpectedConditions.elementToBeClickable(Clickingonclosebutton));
				this.Clickingonclosebutton.click();
			}
	
		@FindBy(xpath = "//button[@id='deactivateButton']")
			WebElement Clickingondeactivatebutton; //Clicking on add project icon 

			public void Clickingondeactivatebutton() {
				this.wait.until(ExpectedConditions.elementToBeClickable(Clickingondeactivatebutton));
				this.Clickingondeactivatebutton.click();
			}
			
			public String GetClosedProject(int i) {
				return this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[1]"))))
						.getText();

			}

			public void ClickClosedProject(String Value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr//td[1]"))))
						.click();
				
			}
			
			public void Clickingonnotebooktab() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//mat-icon[@id='projectNotebooksUsrId']"))))
						.click();
				
			}
			
			public void Addbuttonfornotebook() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='addNoteBookId']"))))
						.click();
				
			}
			
			public void Enteringnotebookdescription() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//textarea[@inputid='textarea']"))))
						.sendKeys("Notebook created");
				
			}
			
			public void Savebuttonfornotebook() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='addNewNotebookId']"))))
						.click();
				
			}
			public void Clickingonbread_crumbicon() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//span[@class='ng-star-inserted'][2]"))))
						.click();
				
			}
			
			public void Clickingonsearch() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//a[@id='searchMainId']"))))
						.click();
				
			}
			
			
			public void Clickingoncriteriasearch() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//mat-icon[@id='searchCriId']"))))
						.click();
				
			}
			
			public void Clickingonsearchproject() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//mat-radio-button[@id='projectSerachId']"))))
						.click();
				
			}
			
			public void Clickingonprojectstatus() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='selectedProjectStatusId']"))))
						.click();
				
			}
			
			public void Selectingstatus() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//span[text()='DEACTIVATED']"))))
						.click();
				
			}
			public void Clickingonprojectsearch() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//mat-icon[@id='searchId']"))))
						.click();
				
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
								.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='atttype']"))))
						.click();
				
			}
			
			public void Clickingonattsavebutton() {
				WebElement element=driver.findElement(By.xpath("//button[@id='save']"));
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
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='attName']"))))
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
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='attValueidText']"))))
						.sendKeys("50");
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
			
			//************************************ROS Secction**********************

			public void ROS_addbutton() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='addRouteButtonId']"))))
						.click();
			}
			
			public void Entering_route_initial_value(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='routeInitial']"))))
						.sendKeys(value);
			}
			public void Entering_route_name_value(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='routeName']"))))
						.sendKeys(value);
			}
			
			public void Entering_route_description_value(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='routeDescription']"))))
						.sendKeys(value);
			}
			public void Fileuploadbutton() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='fileUploadClick']"))))
						.click();
			}
			public void Routesavebutton() {
//				 this.wait
//						.until(ExpectedConditions
//								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='saveButton']"))))
//						.click();
				 WebElement element=driver.findElement(By.xpath("//button[@id='saveButton']/span"));
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(element));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
			
			
			//td//mat-label[normalize-space()='R_1']/..//preceding-sibling::td//mat-icon[normalize-space()='keyboard_arrow_right']			
			public void Routearrowbutton(String route) throws Exception {
				WebElement routetrigger=driver.findElement(By.xpath("//tbody/tr//td//mat-label[normalize-space()='"+route+"']/..//preceding-sibling::td//mat-icon[1]"));
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(routetrigger));
					Thread.sleep(3000);

				 routetrigger.click();
		}

			//tr[2]/td//th/mat-icon[@id='saveStage']
			
			public void Stageaddbutton(String route) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//tbody//tr//mat-label[normalize-space()='"+route+"']/ancestor::tr/following-sibling::tr[1]/td//th/mat-icon[@id='saveStage']"))))
						.click();

			}
			public void Entering_stageinitial_value(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='StageInitialId1']"))))
						.sendKeys(value);
			}
			
			public void Entering_stage_value(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='stageIdName']"))))
						.sendKeys(value);
			}
			public void Entering_stage_description(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//textarea[@id='stageDescriptionText']"))))
						.sendKeys(value);
			}
			public void Schemeuploadbutton() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='uploadClickStage']"))))
						.click();
			}
			public void Inputaddbutton() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='addInputButtonId']"))))
						.click();
			}
			public void Inputtypedropdown() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//tr[1]/td/p-dropdown[@id='inputTypeDropDownId']"))))
						.click();
			}
			public void Selectinginputtype(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//span[normalize-space()='"+value+"']"))))
						.click();
				//span[normalize-space()='KSM']
			}
			public void Clickingon_Chemicalname() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='chemicalNameId']"))))
						.click();
			}
			
			public void Entering_Chemicalname(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//div[@id='chemicalNameId']//input"))))//5.1 changed
						.sendKeys(value);
			}
			public void Entering_CAS_NO(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='caseId']"))))
						.sendKeys(value);
			}
			public void Entering_molWt(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='molWt']"))))
						.sendKeys(value);
			}
			public void Entering_Density(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='density']"))))
						.sendKeys(value);
			}
			public void Entering_Formula(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='formula']"))))
						.sendKeys(value);
			}
			public void Entering_Strength(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='strength']"))))
						.sendKeys(value);
			}
			public void Deleteinputbutton() {
//				 this.wait
//						.until(ExpectedConditions
//								.elementToBeClickable(driver.findElement(By.xpath("//tr[2]/td/button[@id='deleteInputButton']"))))
//						.click();
				 WebElement element=driver.findElement(By.xpath("//tr[2]/td/button[@id='deleteInputButton']"));
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(element));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
			public void Stageinputsavebutton() {
//				 this.wait
//						.until(ExpectedConditions
//								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='addsaveStageButtonId']"))))
//						.click();
				
				 WebElement element=driver.findElement(By.xpath("//button[@id='addsaveStageButtonId']"));
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(element));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
			
			//************************************Attachments**********************
			public void ClickingonAttachmenttab() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//div[@id='mat-tab-label-1-4']"))))
						.click();
			}
			public void Attachmentuploadbutton() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//span[text()=' Upload']"))))
						.click();
			}
			
			public void Entering_Attachment_password(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@name='password']"))))
						.sendKeys(value);

	}
			public void Entering_password(String value) {
				 JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("document.body.style.zoom = '0.75';");
//			        driver.manage().window().fullscreen();
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@name='password']"))))
						.sendKeys(value);
					driver.manage().window().maximize();

	}
	public void Attachment_Auth_Confirm_Button() {
			driver.manage().window().fullscreen();
			 WebElement element=driver.findElement(By.xpath("//button[@id='saveExperimentIdAuth']"));
			 this.wait
					.until(ExpectedConditions
							.elementToBeClickable(element));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			driver.manage().window().maximize();

	}
			public void Attachment_File(String path) {
				WebElement attachFile= driver.findElement(By.xpath("//input[@id='fileId' or @id='expAttachMultiple']"));//Giving two Ids to work on both expUpload and project level
				this.wait
						.until(ExpectedConditions
								.elementToBeClickable(attachFile));
				 attachFile.sendKeys(path);
			}
			public void Entering_Attachment_Name(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='attachName' or @id='expAttachNameId']"))))//Giving two Ids to work on both expUpload and project level
						.sendKeys(value);
			}
			public void Entering_Attachment_Description(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//tbody/tr[1]/td[3]/textarea[1]"))))
						.sendKeys(value);
			}
			
			public void Attachment_Save_Button() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='saveAttachment' or @id='saveExpAttachment']"))))//Giving two Ids to work on both expUpload and project level
						.click();
			}
			public void AttachmentPopUoCLose_Button() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//div//span[text()='Upload File']/..//div//button"))))
						.click();
			}
			
			//************************************Experiment Parameters*************************
			
			public void experimentparametersaddbutton() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='addResultParameter']"))))
						.click();
			}
						
			public void Experiment_Parameter_Code(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='parameterCode' or @id='expCode']"))))//2 Id's given to work for both project and experiment level
						.sendKeys(value);
			}
			public void Experiment_Parameter_Name(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='resultParameterName' or @id='resultParamName']"))))
						.sendKeys(value);
			}
			public void Experiment_Parameter_I_O_Dropdown() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='type' or @id='resultInptType']"))))
						.click();
			}
			public void Experiment_Parameter_Input(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//li[@aria-label='"+value+"']"))))
						.click();
			}
			public void Experiment_Parameter_Output() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//li[@aria-label='OUTPUT']"))))
						.click();
			}
			public void Experiment_Parameter_Formula_dropdown() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='formulaId' or @id='resultInpFormula']"))))
						.click();
			}
			
			public void Experiment_Parameter_Formula_User_Entered(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//li[@aria-label='"+value+"']"))))
						.click();
			}
			public void enterFormulaForAExpparameter(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//td//input[@id='inputFormula']"))))
						.sendKeys(value);
			}
			public void Experiment_Parameter_Formula() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//li[@aria-label='FORMULA']"))))
						.click();
			}	
			public void Experiment_Parameter_TYPE_Dropdown() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='resultType' or @id='expResultType']"))))
						.click();
			}	
			public void Experiment_Parameter_Type(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//li[@aria-label='"+value+"']"))))
						.click();
			}
			public void Experiment_Parameter_Type_Text() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//li[@aria-label='TEXT']"))))
						.click();
			}
			public void Experiment_Parameter_UOM() {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//p-dropdown[@id='uomListId' or @id='expResultuom']"))))
						.click();
			}	
			public void Experiment_Parameter_UOM_Values(String val) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//span[text()='"+val+"']"))))
						.click();
			}	
			public void Experiment_Parameter_Description(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='resultParameterRemarks']"))))
						.sendKeys(value);
			}
			public void Experiment_Parameter_Save() {
//				 this.wait
//						.until(ExpectedConditions
//								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='addResult']/span"))))
//						.click();
				 WebElement element=driver.findElement(By.xpath("//button[@id='addResult']/span"));
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(element));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}	
			public void Experiment_Parameter_Cancel() {
//				 this.wait
//						.until(ExpectedConditions
//								.elementToBeClickable(driver.findElement(By.xpath("//button[@id='cancelResult']"))))
//						.click();
				 WebElement element=driver.findElement(By.xpath("//button[@id='cancelResult']/span"));
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(element));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}	
			public void Experiment_Parameter_Formula_Value(String value) {
				 this.wait
						.until(ExpectedConditions
								.elementToBeClickable(driver.findElement(By.xpath("//input[@id='inputFormula' or @id='inputtext']"))))
						.sendKeys(value);
			}
		
}