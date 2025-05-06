package Chemia.Project.Creation.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Team_Creation_Page {

	WebDriver driver;
	WebDriverWait wait;
	 JavascriptExecutor js;

	
	public Team_Creation_Page(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		 js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void clickonAddTeamButton() {
	WebElement add_team = driver.findElement(By.xpath("//span[normalize-space() = 'Add Team']"));
	 js.executeScript("arguments[0].scrollIntoView(true);", add_team);
						 this.wait
								.until(ExpectedConditions
										.elementToBeClickable(add_team))
								.click();
	}//clickonAddTeamButton
	public void clickonAddTeamButtonARD() {
		WebElement add_team = driver.findElement(By.xpath("//mat-icon[@id='addTeamDialogId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", add_team);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(add_team))
									.click();
		}//clickonAddTeamButton
	public void clickAndSlectCRDTL(String tlvalue) {
		WebElement crdTlDopDown = driver.findElement(By.xpath("//p-dropdown[@id='tlListId' or @id='tlList']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", crdTlDopDown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(crdTlDopDown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+tlvalue+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}//clickAndSlectCRDTL
	public void clickAndSlectCRDHOD(String hod) {
		WebElement hodDopDown = driver.findElement(By.xpath("//p-dropdown[@id='hodListId' or @id='hodList']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", hodDopDown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(hodDopDown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+hod+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}//clickAndSlectCRDHOD
	public void enterTeamName(String TeamName) {
		WebElement teamName = driver.findElement(By.xpath("//input[@id='teamNameId' or @id='inputTeamNametext']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys(TeamName);
	}//enterTeamName

	public void enterTeamDescription(String desc) {
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='teamDescId_ifr' or @id='description_Id_ifr']"));
		driver.switchTo().frame(frameElement);
		
		WebElement desc_text=driver.findElement(By.xpath("//body[@id='tinymce']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(desc_text));
		desc_text.click();	
		desc_text.clear();	
		desc_text.sendKeys(desc);
		
		driver.switchTo().defaultContent();

	}//enterTeamDescription
	public void clickOnSaveteam() {
		WebElement save_button = driver.findElement(By.xpath("//span[normalize-space() = 'Save']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", save_button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(save_button))
									.click();
	}//clickOnSaveteam
	public void clickOncancelteam() {
		WebElement cancel_button = driver.findElement(By.xpath("//span[normalize-space() = 'Cancel']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", cancel_button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(cancel_button))
									.click();
	}//clickOncancelteam
	public void clickOnAddteamMembrARD() {
		WebElement element = driver.findElement(By.xpath("//mat-icon[@id='showAddTeamMemberDialog_IconID']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
	}//clickOnAddteamMembrARD
	public void clickonAddTeamMembersButton() {
		
		WebElement firstName = driver.findElement(By.xpath("//div[normalize-space() = 'First Name']"));
		firstName.click();//clicking first name to avoid leftmenu overlap on add button
		WebElement addteam_member = driver.findElement(By.xpath("//span[normalize-space() = 'ADD']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", addteam_member);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(addteam_member))
									.click();
		}//clickonAddTeamMembersButton
	public void clickOnuserDropdown() {
		WebElement addteam_member = driver.findElement(By.xpath("//p-multiselect//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", addteam_member);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(addteam_member))
									.click();
	}
	public void selectcheckboxForUser(String user) {
		WebElement addteacheckbox_member = driver.findElement(By.xpath("//span[normalize-space() = '"+user+"']//preceding-sibling::div"));
		 js.executeScript("arguments[0].scrollIntoView(true);", addteacheckbox_member);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(addteacheckbox_member))
									.click();
	}//selectcheckboxForUser
	public void closeMultiSelectPopup() {
		WebElement multiSelectPopup = driver.findElement(By.xpath("//button[contains(@class,'multiselect-close')]//timesicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", multiSelectPopup);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(multiSelectPopup))
									.click();
  }//closeMultiSelectPopup
	
	//**********************************************************************************************
	//**********************ARD Methods*******************************************************
	//*************************************************************************************
	
	//********************Team Creation Methods********************************************
	public void clickAndSlectARDTeamMembr(String hod) {
		WebElement userdropdown = driver.findElement(By.xpath("//p-dropdown[@id='adChemistsListDropdown']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", userdropdown);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(userdropdown))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+hod+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}//clickAndSlectARDTeamMembr
	public void clickOnReviewCheckBox() {
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='includeDateid']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", checkBox);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(checkBox))
									.click();		
	}
	public void clickOnSaveteamMembr() {
		WebElement checkBox = driver.findElement(By.xpath("//button[@id='addTeamMembersSave_btn']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", checkBox);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(checkBox))
									.click();		
	}
	//**********************create Test Technique Methods****************************
	public void clickonAddTestTechnique() {
		WebElement button = driver.findElement(By.xpath("//mat-icon[@id='addTestTechId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void enterTechniqueName(String name) {
		WebElement teamName = driver.findElement(By.xpath("//input[@id='atrtestTypeId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", teamName);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(teamName)).sendKeys(name);
	}
	public void enterDescription(String comments) {
		WebElement element = driver.findElement(By.xpath("//textarea[@id='descriptionId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(comments);
	}
	public void clickonSaveTestTechnique() {
		WebElement button = driver.findElement(By.xpath("//button[@id='saveDataitemId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void clickonCancelTestTechnique() {
		WebElement button = driver.findElement(By.xpath("//button[@id='CancelDataitemId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	
	//*********************Test Configurations Methods************************************
	
	public void clickonADDTestConfig() {
		WebElement button = driver.findElement(By.xpath("//*[@id='testConfigurationDiv']//button[@id='addButtonsId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void enterAnalysisTechnicalCode (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='analysisTechniqueCodeId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void enterTestType (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='atrtestTypeId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void enterTestSubType (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='atrtestSubtypeId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void clickAndSlectTestTechnique(String techniqueName) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='techniqueIdList1']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
								WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+techniqueName+"')]"));
								 js.executeScript("arguments[0].scrollIntoView(true);", element1);
				 this.wait.until(ExpectedConditions
						.elementToBeClickable(element1)).click();	
	}
	public void clickAndSlectResultType(String val) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='atrResultTypeId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
			 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+val+"')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element1);
			 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	}
	public void clickAndSlectUOMValueIfNum(String val) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='atrTestUOMId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
				 this.wait.until(ExpectedConditions
						.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+val+"')]")))).click();	
	}
	
	
	public void clickonADDResultParameter() {
		WebElement button = driver.findElement(By.xpath("//mat-icon[@mattooltip='Add Result Parameter']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void enterParameterName (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='inputtext']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void clickAndSlectPopupResultTypeAsText() {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='changeType_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//li//span[contains(text(),'TEXT')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
				}
	public void clickonCancelAddresultparamtr() {
		WebElement button = driver.findElement(By.xpath("//button[@id='resetResultValue']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void clickonSaveAddresultparamtr() {
		WebElement button = driver.findElement(By.xpath("//button[@id='saveResultParam']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	//************************Add Attributes Methods******************************* 
	public void clickonADDAttribute() {
		WebElement button = driver.findElement(By.xpath("//button[@id='addButtonsId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void enterAttributeName (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='atrAttributeNameId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void clickAndSlectAttribteType(String val) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='atrAttributeTypeId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+val+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();}
	public void enterMaxLength (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='locale-indian']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	
	//****************************************Add test Group methods***********************
	public void clickonADDTestGroup() {
		WebElement button = driver.findElement(By.xpath("//mat-icon[@id='addTestGroupId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void clickonSaveTestGroup() {
		WebElement button = driver.findElement(By.xpath("//mat-icon[@id='saveTestGroupId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void enterGroupName (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='groupNameId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void enterGroupDescr (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='groupDescId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).click();
									element.sendKeys(value);
	}
	public void clickonAddTestDetails() {
		WebElement button = driver.findElement(By.xpath("//mat-icon[@id='showTestDialogId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void clickonTestGroupRightArrow() {
		WebElement button = driver.findElement(By.xpath("//tr[1]//mat-icon[contains(text(),'keyboard_arrow_right')]"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void clickonAddTestCheckbox(String testName) {
		WebElement checkbox = driver.findElement(By.xpath("//td//mat-label[contains(text(),'"+testName+"')]//..//preceding-sibling::td//div[@class='mdc-checkbox']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(checkbox))
									.click();
		}
	
	//***********************************Form Type Methods************************
	public void clickonAddFormType() {
		WebElement button = driver.findElement(By.xpath("//button[@id='addformtypeId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void enterFortypeName (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='analysisTechniqueCodeId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).click();
									element.sendKeys(value);
	}
	public void enterFormTypeDescr (String value) {
		WebElement element = driver.findElement(By.xpath("//textarea[@id='descriptionId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void clickonAddFormAttribute() {
		WebElement button = driver.findElement(By.xpath("//button[@id='addRoleId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void clickonAttributeCheckboxforFomType(String attribute) {
		WebElement element = driver.findElement(By.xpath("//input[@id='applyFilterInput']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).clear();
		element.sendKeys(attribute);
		WebElement checkbox = driver.findElement(By.xpath("//td//mat-label[contains(text(),'"+attribute+"')]//..//preceding-sibling::td//div[@class='mdc-checkbox']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(checkbox))
									.click();
		}
	public void clickAndSlectFormType(String name) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='formTypeSelectedId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	}
	public void clickAndSlectTestGroup(String name) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='selectedTestGroup_Id']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	}
	public void clickonAddGroupInFormType() {
		WebElement button = driver.findElement(By.xpath("//button[@id='addTestGroupid']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	//**************************************************Excel Template Methods***********************
	
	//************************************Template Data Items Methods*************************************
	public void clickonAddTemplateDataItem() {
		WebElement button = driver.findElement(By.xpath("//button[@id='addButtonsId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(button))
									.click();
		}
	public void enterDataItemName (String value) {
		WebElement element = driver.findElement(By.xpath("//input[@id='dataitemnameId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	public void clickAndSlectDataType(String name) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='dataTypeId']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();	
	}
	public void clickAndSlectLengthcategory(String name) {
		WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='lengthCateId']//chevrondownicon"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element))
									.click();
							 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
							 js.executeScript("arguments[0].scrollIntoView(true);", element1);
							 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	}
	public void enterDataItemDescr(String value) {
		WebElement element = driver.findElement(By.xpath("//textarea[@id='descDataitem']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
							 this.wait
									.until(ExpectedConditions
											.elementToBeClickable(element)).sendKeys(value);
	}
	//************************************Template Sections Methods*************************************
		public void clickonAddTemplateSections() {
			WebElement button = driver.findElement(By.xpath("//button[@id='addButtonsId_ addNewSection']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void clickonSaveSections() {
			WebElement button = driver.findElement(By.xpath("//button[@id='validateSectionDataSaveId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void clickonCancelSections() {
			WebElement button = driver.findElement(By.xpath("//button[@id='cancel_btn_']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void clickonSectionShowPreview() {
//			WebElement button = driver.findElement(By.xpath("//button[@id='showPreviewBtn_']"));
//			 js.executeScript("arguments[0].scrollIntoView(true);", button);
//								 this.wait
//										.until(ExpectedConditions
//												.elementToBeClickable(button))
//										.click();
			}
		public void clickonBackToTemplateSections() {
			WebElement button = driver.findElement(By.xpath("//button[@id='editSectionDataBack_Id']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void enterSectionName(String value) {
			WebElement element = driver.findElement(By.xpath("//th[contains(text(),'Unique Identifier :')]//preceding-sibling::th//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterUniqueIdentifier(String value) {
			WebElement element = driver.findElement(By.xpath("//th[contains(text(),'Unique Identifier :')]//following-sibling::th//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clickAndSlectSectionType(String name) {
			WebElement element = driver.findElement(By.xpath("//p-dropdown[@id='sectionTypeDropDown']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
								 js.executeScript("arguments[0].scrollIntoView(true);", element1);
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();	
		}
		public void enterTemplateSectionDescr(String value) {
			WebElement element = driver.findElement(By.xpath("//th[@id='sectiondesc']//textarea"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
	
	//************Section::Rich Text*******************************************************
		public void enterSectionHeight (String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='updateHeight_']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).clear();	
								 element.sendKeys(value);
		}
	//************Section::Standard Preparation*******************************************************
				public void enterSectionHeightOnStandardPreparation (String value) {
					WebElement element = driver.findElement(By.xpath("//input[@id='sectionDescription_id']"));
					 js.executeScript("arguments[0].scrollIntoView(true);", element);
										 this.wait
												.until(ExpectedConditions
														.elementToBeClickable(element)).clear();	
												 element.sendKeys(value);
				}
	
	//**************Section::Combined**************************************************************
		//*******************Param*****************************
		public void clickonAddCombiParm() {
			WebElement button = driver.findElement(By.xpath("//button[@id='addButtonsId_id' or @id='addButtonsId_']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void clickonSaveCombiParm() {
			WebElement button = driver.findElement(By.xpath("//button[@id='saveNewItemId' or @id='saveid_']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
	
		public void clickAndSlectParamDataItem(String name) {
			WebElement element = driver.findElement(By.xpath("//p-autocomplete[@id='filterDataitemId' or @field='dataItemName']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]"));
								 js.executeScript("arguments[0].scrollIntoView(true);", element1);
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
		}
	//***************************Data Table*********************************
		public void clickonAddCombiDataTble() {
			WebElement button = driver.findElement(By.xpath("//button[@id='addButtonsId_' or @id='addButtonsId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void clickonSaveDataTble() {
			WebElement button = driver.findElement(By.xpath("//button[@id='saveNewItem' or @id='saveNewItemId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
	
		public void clickAndSlectDataTbleDataItem(String name) {
			WebElement element = driver.findElement(By.xpath("//p-autocomplete[@id='filterDataitemId_' or @id='dataItemNameId_filterDataitem']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//ul[@id='filterDataitemId__list' or @id='dataItemNameId_filterDataitem_list']//div[contains(text(),'"+name+"')]"));
								 js.executeScript("arguments[0].scrollIntoView(true);", element1);
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
						}
	
		public void enterDataTbaleName(String value) {
			WebElement element = driver.findElement(By.xpath("//th[contains(text(),' Datatable Name :')]//following-sibling::th//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterDescrDatatble(String value) {
			WebElement element = driver.findElement(By.xpath("//textarea[@id='textareaSubDataTableDesc' or @id='dataTableDescTextArea']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void enterDatatbleRelativewidth(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@type='number']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clickonAddItemSection() {
			WebElement button = driver.findElement(By.xpath("//button[@id='addItemPopup']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		
		//*********************************Section::Embeded excel***************************
		public void AddExcel() {
			WebElement addexcel= driver.findElement(By.xpath("//div[@id='formFileLg']//button"));//Giving two Ids to work on both expUpload and project level
			this.wait
					.until(ExpectedConditions
							.elementToBeClickable(addexcel)).click();
			
		}
		public void clickonSaveExcel() {
			WebElement button = driver.findElement(By.xpath("//button[@id='removeExcel_btn']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void clickonOkPDFPreview() {
			WebElement button = driver.findElement(By.xpath("//p-button[@id='clearViewAttach_btnId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		
	//**************************************Experiment Templates Creating Methods***********************************************
		public void clickonAddTemplate() {
			WebElement button = driver.findElement(By.xpath("//button[@id='addButtonsId_navigateToCreateExperimentTemplate']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		
		public void enterTemplateName(String value) {
			WebElement element = driver.findElement(By.xpath("//th[@id='tempnameId']//following-sibling::td//input"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		
		public void enterTemplateDescr (String value) {
			WebElement element = driver.findElement(By.xpath("//textarea[@id='templateDescriptionTextArea']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).click();
								 element.sendKeys(value);
		}
		
		public void clickonAddSectionsForTemplate() {
			WebElement button = driver.findElement(By.xpath("//button[@id='addButtonsId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		
		public void clickAndSlectSectionAndIncludeClone(int i,String section) {
			WebElement element = driver.findElement(By.xpath("//tr["+i+"]//p-dropdown[@id='projectCodeIdsectionName']//chevrondownicon"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element))
										.click();
								 WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'"+section+"')]"));
								 js.executeScript("arguments[0].scrollIntoView(true);", element1);
								 this.wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
					  WebElement includeClonecheckBox = driver.findElement(By.xpath("//table[@id='manufacturingFormula']//tr["+i+"]//td[6]//div[@class='mdc-checkbox']"));
					 js.executeScript("arguments[0].scrollIntoView(true);", includeClonecheckBox);
										 this.wait
												.until(ExpectedConditions
														.elementToBeClickable(includeClonecheckBox))
												.click();		 
		}
		
		public void clickonSaveSectionsForTemplate() {
			WebElement button = driver.findElement(By.xpath("//button[@id='saveTemplateSection']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void clickonPreviewTemplate() {
			WebElement button = driver.findElement(By.xpath("//button[@id='previewDialogsaveid']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void scrollTemplatePreview() throws InterruptedException {
//			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iFrame1']"));
//			driver.switchTo().frame(frameElement);
			this.wait
			.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//table[@id='staticsectionTable_']/..//div[normalize-space()='Summary']"))))
			.click();	
			
			  Actions actions = new Actions(driver);

	            // Scroll down using Page Down key multiple times
	            for (int i = 0; i < 10; i++) { // Adjust the count as needed
	                actions.sendKeys(Keys.PAGE_DOWN).perform();
	                Thread.sleep(1000); // Optional: add a short pause to see the effect
	            }
//				driver.switchTo().defaultContent();
		}
		public void clickonSaveExperimentTeplate() {
			WebElement button = driver.findElement(By.xpath("//button[@id='persistExperimentTemplateId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void clickonBackExperimentTeplate() {
			WebElement button = driver.findElement(By.xpath("//button[@id='saveidTemplateBean']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
	//******************************************************Submit and APprove Methods***********************
		public void clickOnExperimentTemplateLink(String link) {
			WebElement expTemplateLink = driver.findElement(By.xpath("//td[contains(@class,'templateName')]//a[contains(text(),'"+link+"')]"));
			 js.executeScript("arguments[0].scrollIntoView(true);", expTemplateLink);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(expTemplateLink))
										.click();
		}
		public void clickonSubmitExperimentTeplate() {
			WebElement button = driver.findElement(By.xpath("//button[@id='confirmSubmitTemplate']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		
		public void clickonYesForSubmitExperimentTeplate() {
			WebElement button = driver.findElement(By.xpath("//button[@id='submitForApproval_btn']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void clickonApproveExperimentTeplate() {
			WebElement button = driver.findElement(By.xpath("//button[@id='approveDialog']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
		public void enterApproverPassword(String value) {
			WebElement element = driver.findElement(By.xpath("//input[@id='passwordInput']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", element);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(element)).sendKeys(value);
		}
		public void clickonApproveExperimentTeplateAfterAuthentication() {
			WebElement button = driver.findElement(By.xpath("//button[@id='validateBeforeApproveId']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", button);
								 this.wait
										.until(ExpectedConditions
												.elementToBeClickable(button))
										.click();
			}
}
