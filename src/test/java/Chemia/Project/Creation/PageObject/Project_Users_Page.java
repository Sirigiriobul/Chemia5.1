/*
	 Created Date:09/03/2024
	 Created By:Swathi Boda
	 Module:CRD
	 Functionality: Users Tab in both Projects and Notebook 
*/
package Chemia.Project.Creation.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project_Users_Page {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public Project_Users_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
}

	//******************************Project level WebElements***************************

	@FindBy(xpath = "//mat-icon[@id='projectUsrId']")
	WebElement projectUsrs_tab; // projectUsersTab
	
	@FindBy(xpath = "//mat-icon[@id='projectSummaryId']")
	WebElement projectSUmmary_tab; //  projectSUmmary tab
	
	@FindBy(xpath = "//mat-icon[@id='projectRosUsrId']")
	WebElement projectROS_tab; // projectROS tab
	
	@FindBy(xpath = "//mat-icon[@id='projectNotebooksUsrId']")
	WebElement projectNotebook_tab; // projectROS tab
	
	@FindBy(xpath = "//mat-icon[@id='projectAttachmentUsrId']")
	WebElement projectAttachment_tab; // projectAttachment tab
	
	@FindBy(xpath = "//mat-icon[@id='projectParamsUsrId']")
	WebElement projectExpParamtrs_tab; // projectExpParamtrs tab
	
	@FindBy(xpath = "//mat-icon[@id='projectEventsId']")
	WebElement projectEvents_tab; // projectEvents tab
	
//	@FindBy(xpath = "//td[text()='Rup-crd-hod']/..//td//button[@id='removeUser']/span")
//	WebElement delete_button; // delete_button
	
//	@FindBy(xpath = "//td[text()='Rup-crd-hod']/..//td//button[@id='sendNotification']/span")
//	WebElement notify_button; // notify_button
	
	@FindBy(xpath = "//button[@id='addUser']")
	WebElement addButton_user; // addUser button project level
	
	@FindBy(xpath = "//div//span[text()='Confirm User Remove']")
	WebElement confirmUser_popup; // confirmUser_popup
	
	@FindBy(xpath = "//div//span[text()='Confirm User Remove']/..//div/button")
	WebElement confirmUser_popup_close; // ConfirmUserPopup Close button
	
	@FindBy(xpath = "//button/span[text()='Yes']")
	WebElement removeUser_yes; // Remove user yes button
	
	@FindBy(xpath = "//button/span[text()='No']")
	WebElement removeUser_No; // Remove user No button
	
	@FindBy(xpath = "//p-dialog[@id='addUserDialogid']//div//span[text()='Add User(s)']")
	WebElement addUsers_Popup; // addUsers Popup 
	
	@FindBy(xpath = "//p-dialog[@id='addUserDialogid']//div//span[text()='Add User(s)']/../div/button/span")
	WebElement addUsersPopup_close; // addUsers Popup close
	
	@FindBy(xpath = "//p-dropdown[@id='roleId']//div[@aria-label='dropdown trigger']")
	WebElement selectUserRole_dropdown; // selectUserRole dropdown
	
//	@FindBy(xpath = "//p-dropdownitem//Li/span[text()='QA Manager']")
//	WebElement selectspecific_role; // select specific role
	
	@FindBy(xpath = "//input[@id='id']")
	WebElement searchUser_input; // searchUser input
	
//	@FindBy(xpath = "//span[text()='Mr.Rup Chand-TL ( Rup-crd-TL )']//preceding-sibling::input")
//	WebElement serachuser_checkBox; // user checkbox 
	
	@FindBy(xpath = "//input[@Id='searchUserId']")
	WebElement notebook_search; // note book search box
	
	@FindBy(xpath = "//label[text()=' SwaN']//preceding-sibling::input")
	WebElement notebook_checkbox; // notebook checkbox
	
	@FindBy(xpath = "//button[@id='saveUser']/span[text()=' Save ']")
	WebElement adduser_save; // adduser_save
	
	@FindBy(xpath = "//button[@id='cancelUser']/span[text()=' Cancel ']")
	WebElement adduser_cancel; // adduser_cancel
	
	
	//******************************Notebook level WebElements***************************
	
	@FindBy(xpath = "//mat-icon[@id='notebookUsrId']")
	WebElement notebookUsers_tab; // notebookUsers tab
	
	@FindBy(xpath = "//mat-icon[@id='notebookSummaryId']")
	WebElement notebookSummary_tab; // notebookUsers tab
	
	@FindBy(xpath = "//mat-icon[@id='notebookExpId']")
	WebElement notebookExperiment_tab; // notebookUsers tab
	
	@FindBy(xpath = "//mat-icon[@id='notebookEventsId']")
	WebElement notebookAuditTrail_tab; // notebookUsers tab
	
	
	@FindBy(xpath = "//button//span[normalize-space()='Add']")
	WebElement notebookAdd_button; // notebookAdd button and also for Users add button
	
//	@FindBy(xpath = "//td[text()='Rup-crd-hod']/../td//button//span[normalize-space()='edit']")
//	WebElement edit_button; // edit button
	
//	@FindBy(xpath = "//td[text()='Rup-crd-hod']/../td//button//span[normalize-space()='delete']")
//	WebElement notebookuser_delete_button; //notebook level delete_button
	
//	@FindBy(xpath = "//td[text()='Rup-crd-hod']/../td//button//span[normalize-space()='notifications']")
//	WebElement notebooklevel_notify_button; // notebook level notify button
	@FindBy(xpath = "//span[text()='Confirm User Remove']")
	WebElement removeUser_popup_notebook; // remove user notebook popup
	
	@FindBy(xpath = "//span[text()='Confirm User Remove']/../div//span")
	WebElement removeUser_popup_close_notebook; // remove user notebook popup close button
	
	@FindBy(xpath = "//div//span[text()='Yes']")
	WebElement remove_user_Yes_notebook; //remove user yes button notebook
	
	@FindBy(xpath = "//div//span[text()='No']")
	WebElement remove_user_No_notebook; //remove user No button notebook
	
//	@FindBy(xpath = "//td[text()='Rup-crd-hod']/../td//button[@id='addUserPrivId']//span[normalize-space()='check_circle']")
//	WebElement saveChanges_button; // save Changes for specific user button
	
//	@FindBy(xpath = "//td[text()='Rup-crd-hod']/../td//button[@id='cancelUserPrivId']//span[normalize-space()='cancel']")
//	WebElement cancelChanges_button; // cancel Changes for specific user button
	
	@FindBy(xpath = "//div//span[text()='Add User(s)']")
	WebElement notebook_addusers_popup; // addusers popup
	
	@FindBy(xpath = "//div//span[text()='Add User(s)']/..//div//span")
	WebElement notebook_addusers_popup_close; // addusers popup close trigger
	
	@FindBy(xpath = "//button[@id='saveUsers']/span[text()=' Save ']")
	WebElement adduserspopup_save; // adduser popup save button
	
	@FindBy(xpath = "//button[@id='cancelUsers']/span[text()=' Cancel ']")
	WebElement adduserspopup_cancel; // adduser popup cancel button
	
	
//********************************************methods project level**********************************************************************
	
	
	public void clickUsersTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(projectUsrs_tab));
		this.projectUsrs_tab.click();		
	}//clickUsersTabProjectLevel
	
	public void clickSUmmaryTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(projectSUmmary_tab));
		this.projectSUmmary_tab.click();		
	}//clickSUmmaryTabProjectLevel
	
	public void clickROSTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(projectROS_tab));
		this.projectROS_tab.click();		
	}//clickROSTabProjectLevel
	
	public void clickAttachmentTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(projectAttachment_tab));
		this.projectAttachment_tab.click();		
	}//clickUsersTabProjectLevel
	
	public void clickNoteBookTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(projectNotebook_tab));
		this.projectNotebook_tab.click();		
	}//clickNoteBookTabProjectLevel
	
	public void clickExpparametersTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(projectExpParamtrs_tab));
		this.projectExpParamtrs_tab.click();		
	}//clickExpparametersTabProjectLevel
	
	public void clickEventsTabProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(projectEvents_tab));
		this.projectEvents_tab.click();		
	}//clickEventsTabProjectLevel
	
	public void clickdeleteProjectLevel(String user) {
		WebElement delete_button = driver.findElement(By.xpath("//td[text()='"+user+"']/..//td//button[@id='removeUser']/span"));
//		this.wait.until(ExpectedConditions.elementToBeClickable(delete_button));
//		delete_button.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete_button);		
		}//clickdeleteProjectLevel
	
	public void clicknotifyProjectLevel(String user) {
		WebElement notify_button = driver.findElement(By.xpath("//td[text()='"+user+"']/..//td//button[@id='sendNotification']/span"));
		this.wait.until(ExpectedConditions.elementToBeClickable(notify_button));
		notify_button.click();
		}//clicknotifyProjectLevel
	
	public void clickOnAddProjectLevel() {
		try {
			Thread.sleep(2000);
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollBy(0, document.body.scrollHeight);");
			wait.until(ExpectedConditions.elementToBeClickable(addButton_user));
			
			action = new Actions(driver);
			action.moveToElement(addButton_user).build().perform();
			addButton_user.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.print("Unable to Click on Add Button in project level");
		}
	}//clickOnAddProjectLevel
	
	public void clickYesRemoveUserProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(removeUser_yes));
		this.removeUser_yes.click();		
	}//clickYesRemoveUserProjectLevel
	
	public void clickNoRemoveUserProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(removeUser_No));
		this.removeUser_No.click();		
	}//clickNoRemoveUserProjectLevel
	
	public boolean isAddUsersPopupDisplayed() {
		boolean flag;
		flag=this.addUsers_Popup.isDisplayed();
		return flag;
		}//isAddUsersPopupDisplayed
	
	public void clickroledropdownProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(selectUserRole_dropdown));
		this.selectUserRole_dropdown.click();		
	}//clickroledropdownProjectLevel
	
	//p-dropdownitem//Li/span[text()='QA Manager']
	public void slectRoleProjectLevel(String role) {
		WebElement selectedrole=driver.findElement(By.xpath("//p-dropdownitem//Li/span[text()='"+role+"']"));
		wait.until(ExpectedConditions.elementToBeClickable(selectedrole));
		selectedrole.click();		
	}//slectRoleProjectLevel
	
	public void searchUsersProjectLevel(String user) {
		this.wait.until(ExpectedConditions.elementToBeClickable(searchUser_input));
		this.searchUser_input.sendKeys(user);		
	}//searchUsersProjectLevel
	
	public void clickUserCheckboxProjectLevel(String user) {
		//span[contains(text(),'ss_test')]//preceding-sibling::input
		WebElement userCheckbox=driver.findElement(By.xpath("//span[contains(text(),'"+user+"')]//preceding-sibling::input"));
		wait.until(ExpectedConditions.elementToBeClickable(userCheckbox));
		userCheckbox.click();		
	}//clickUserCheckboxProjectLevel
	
	public void searchNotebookProjectLevel(String noteBook) {
		this.wait.until(ExpectedConditions.elementToBeClickable(notebook_search));
		this.notebook_search.sendKeys(noteBook);		
	}//searchNotebookProjectLevel
	
	public void clicNotebookCheckboxProjectLevel(String notebbook) {
		//label[text()=' SwaN']//preceding-sibling::input
		WebElement notebookCheckbox=driver.findElement(By.xpath("//label//span[contains(text(),'"+notebbook+"')]//preceding-sibling::input"));
		wait.until(ExpectedConditions.elementToBeClickable(notebookCheckbox));
		notebookCheckbox.click();		
	}//clicNotebookCheckboxProjectLevel
	
	public void clickSaveOnAdduesrsProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(adduser_save));
		this.adduser_save.click();		
	}//clickSaveOnAdduesrsProjectLevel
	
	public void clickCancelOnAdduesrsProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(adduser_cancel));
		this.adduser_cancel.click();		
	}//clickCancelOnAdduesrsProjectLevel
	
	@FindBy(xpath = "//tbody//tr//td[contains(@class,'column-displayName')]")
	WebElement getDspalyName; // Tost Message for notebook level

	public String getFirstDIsplayName() {
		this.wait.until(ExpectedConditions.elementToBeClickable(getDspalyName));
		return this.getDspalyName.getText();
	}

	
	
	public void clicCancelOnAdduesrsProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(adduser_cancel));
		this.adduser_cancel.click();		
	}//clicCancelOnAdduesrsProjectLevel
	
	public void closeAdduesrsPopupProjectLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(addUsersPopup_close));
		this.addUsersPopup_close.click();		
	}//clicCancelOnAdduesrsProjectLevel
	
	public String getNamewithUserName(String userName) {
		//tbody//tr//td[contains(text(),'SS_CRD_TL')]/../td[contains(@class,'column-name')]
		WebElement name=driver.findElement(By.xpath("//tbody//tr//td[contains(text(),'"+userName+"')]/../td[contains(@class,'column-name')]"));
		wait.until(ExpectedConditions.elementToBeClickable(name));
		return name.getText();
		}//clicNotebookCheckboxProjectLevel
	
	
	//********************************************methods NoteBook level**********************************************************************
	public void clicOnNotebookProjectLevel(String notebbook) {
		//label[text()=' SwaN']//preceding-sibling::input
		WebElement notebookCheckbox=driver.findElement(By.xpath("//label//span[contains(text(),'"+notebbook+"')]//preceding-sibling::input"));
		wait.until(ExpectedConditions.elementToBeClickable(notebookCheckbox));
		notebookCheckbox.click();		
	}//clicOnNotebookProjectLevel
	
	public void clickOnUsersTabNotebookLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(notebookUsers_tab));
		this.notebookUsers_tab.click();		
	}//clickOnUsersTabNotebookLevel
	
	public void clickOnSummaryTabNotebookLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(notebookSummary_tab));
		this.notebookSummary_tab.click();		
	}//clickOnSummaryTabNotebookLevel
	
	public void clickExperimentTabNotebookLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(notebookExperiment_tab));
		this.notebookExperiment_tab.click();		
	}//clickExperimentTabNotebookLevel
	
	public void clickOnAudittrailTabNotebookLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(notebookAuditTrail_tab));
		this.notebookAuditTrail_tab.click();		
	}//clickOnUsersTabNotebookLevel
	
	public void clickOnAddNotebookLevel() {
		try {
			Thread.sleep(2000);
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollBy(0, document.body.scrollHeight);");
			wait.until(ExpectedConditions.elementToBeClickable(notebookAdd_button));
			
			action = new Actions(driver);
			action.moveToElement(notebookAdd_button).build().perform();
			notebookAdd_button.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.print("Unable to Click on Add Button in project level");
		}
	}//clickOnAddNotebookLevel
	
	public void clickOnspecificUserEditNotebookLevel() {
		WebElement edit_button = driver.findElement(By.xpath("//td[text()='Rup-crd-hod']/../td//button//span[normalize-space()='edit']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(edit_button));
		edit_button.click();	
	}//clickOnspecificUserEditNotebookLevel
	
	public void clickOnspecificUserDeleteNotebookLevel() {
		WebElement delete_button = driver.findElement(By.xpath("//td[text()='Rup-crd-hod']/../td//button//span[normalize-space()='delete']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(delete_button));
		delete_button.click();	
	}//clickOnspecificUserDeleteNotebookLevel
	
	public void clickOnspecificUserNotifyNotebookLevel() {
		WebElement notify_button = driver.findElement(By.xpath("//td[text()='Rup-crd-hod']/../td//button//span[normalize-space()='notifications']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(notify_button));
		notify_button.click();	
	}//clickOnspecificUserNotifyNotebookLevel
	
	public void clickOnProjectbreadcrumb(String project) {
		WebElement project_breadcrumb = driver.findElement(By.xpath("//span[@class='ng-star-inserted']//a[normalize-space()='"+project+"']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(project_breadcrumb));
		project_breadcrumb.click();	
	}//clickOnProjectbreadcrumb
	
	
	//tr//td[text()='Rup-crd-chemist']/..//input[@id='viewIdExp']
	public boolean checkViewColumnidealstate(String user) {
		boolean flag;
		WebElement view_icon = driver.findElement(By.xpath("//tr//td[text()='"+user+"']/..//input[@id='viewIdExp'"));
		String attr=view_icon.getAttribute("class");
		if(attr.contains("ng-valid"))
		flag=false;
		else
		flag=true;
			
		return flag;
	}//checkViewColumnidealstate
	
	public void closeRemoveUsersPopupNotebookLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(removeUser_popup_close_notebook));
		this.removeUser_popup_close_notebook.click();		
	}//closeRemoveUsersPopupNotebookLevel
	
	
	
	public void clickyesOnRemoveUsersPopupNotebookLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(remove_user_Yes_notebook));
		this.remove_user_Yes_notebook.click();		
	}//clickyesOnRemoveUsersPopupNotebookLevel
	
	public void clickNoOnRemoveUsersPopupNotebookLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(remove_user_No_notebook));
		this.remove_user_No_notebook.click();		
	}//clickNoOnRemoveUsersPopupNotebookLevel
	
	public void clickOnSavechangesForspecificUserNotebookLevel(String user) {	
		
		WebElement saveChanges= driver.findElement(By.xpath("//td[text()='"+user+"]/../td//button[@id='addUserPrivId']//span[normalize-space()='check_circle']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(saveChanges));
		saveChanges.click();	
	}//clickNoOnRemoveUsersPopupbookLevel
	
	public void clickOncancelchangesForspecificUserNotebookLevel(String user) {	
		
		WebElement cancelChanges= driver.findElement(By.xpath("//td[text()='"+user+"]/../td//button[@id='cancelUserPrivId']//span[normalize-space()='cancel']"));
		this.wait.until(ExpectedConditions.elementToBeClickable(cancelChanges));
		cancelChanges.click();	
	}//clickNoOnRemoveUsersPopupbookLevel
	
	public void clickYesOnAdduserPopupNotebookLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(adduserspopup_save));
		this.adduserspopup_save.click();		
	}//clickYesOnAdduserPopupNotebookLevel
	
	public void clickCancelOnAdduserPopupNotebookLevel() {
		this.wait.until(ExpectedConditions.elementToBeClickable(adduserspopup_cancel));
		this.adduserspopup_cancel.click();		
	}//clickCancelOnAdduserPopupNotebookLevel
	
	public void clickcheckBoxofUserInAdduserPopupNotebookLevel(String user) {	
		WebElement checkBox_user= driver.findElement(By.xpath("//label[contains(text(),'"+user+"')]//preceding-sibling::input"));
		this.wait.until(ExpectedConditions.elementToBeClickable(checkBox_user));
		checkBox_user.click();	
	}//clickcheckBoxofUserInAdduserPopupNotebookLevel
	
	public boolean isUseraddedInNotebook(String user) {
		WebElement userExist=driver.findElement(By.xpath("//tbody//tr//td[contains(@class, 'column-username') and contains(text(), '"+user+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(userExist));	
		return userExist.isDisplayed();
	}//getNotebookStatus
	
}//Project_Users_Page
