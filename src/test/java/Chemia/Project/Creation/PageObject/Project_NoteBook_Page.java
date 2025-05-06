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

public class Project_NoteBook_Page {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public Project_NoteBook_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	@FindBy(xpath = "//button[@id='addNoteBookId']//span[text()=' Add']")
	WebElement addNotebook; //Clicking on add project icon 

	public void clickOnAddInNotebookTab() {
		this.wait.until(ExpectedConditions.elementToBeClickable(addNotebook));
		this.addNotebook.click();
	}//clickOnAddInNotebookTab
	
	//button[@id='reopenButtonId']//span[text()=' Re-Open']
	
	@FindBy(xpath = "//button[@id='reopenButtonId']//span[text()=' Re-Open']")
	WebElement reOpenNotebook; //Clicking on add project icon 

	public void clickOnReopenInNotebookTab() {
		this.wait.until(ExpectedConditions.elementToBeClickable(reOpenNotebook));
		this.reOpenNotebook.click();
	}//clickOnReopenInNotebookTab
	
	@FindBy(xpath = "//button[@id='addNewNotebookId']//span[text()=' Save']")
	WebElement saveNotebook; //Clicking on add project icon 

	public void clickOnsaveforNotebook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(saveNotebook));
		this.saveNotebook.click();
	}//clickOnsaveforNotebook
	
	@FindBy(xpath = "//button[@id='cancelNewNotebookId']//span[text()=' Cancel ']")
	WebElement cancelNotebook; //Clicking on add project icon 

	public void clickOnCancelforNotebook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(cancelNotebook));
		this.cancelNotebook.click();
	}//clickOnsaveforNotebook
	
	@FindBy(id = "nbName")
	WebElement noteBookname_input; //Clicking on add project icon 

	public void clearNoteBookName() {
		this.wait.until(ExpectedConditions.elementToBeClickable(noteBookname_input));
		noteBookname_input.sendKeys(Keys.chord(Keys.CONTROL,"a"));
				// Select all text
		noteBookname_input.sendKeys(Keys.BACK_SPACE);
				// Delete selected text

	}//clearNoteBookName
	
	public void enterNoteBookName(String notebookName) {
		this.wait.until(ExpectedConditions.elementToBeClickable(noteBookname_input));
		this.noteBookname_input.sendKeys(notebookName);
	}//clearNoteBookName
	
	@FindBy(xpath = "//textarea[@inputid='textarea']")
	WebElement Description_noteBook; //Clicking on add project icon 

	public void enterDescriptionNoteBook(String Description) {
		this.wait.until(ExpectedConditions.elementToBeClickable(Description_noteBook));
		this.Description_noteBook.clear();
		this.Description_noteBook.click();
		this.Description_noteBook.sendKeys(Description);
	}//clearNoteBookName

	public void clickOnNotebook(String notebook) {
//		WebElement noteBook=driver.findElement(By.xpath("//p-carousel[@id='carousel']//div//h4[text()='"+notebook+"']/../img[@id='noteBookImage' or @id='closednoteBookImage']"));
//		wait.until(ExpectedConditions.elementToBeClickable(noteBook));
//		noteBook.click();	
		 WebElement element=driver.findElement(By.xpath("//p-carousel[@id='carousel']//div//h4[text()='"+notebook+"']/../img[@id='noteBookImage' or @id='closednoteBookImage']"));
		 this.wait
				.until(ExpectedConditions
						.elementToBeClickable(element));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}//clickOnNotebook
	
	@FindBy(xpath = "//button[@id='editId']//span[text()=' Edit']")
	WebElement edit_noteBook; //Clicking on add project icon 

	public void editNoteBook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(edit_noteBook));
		this.edit_noteBook.click();
	}//editNoteBook
	
	@FindBy(xpath = "//button[@id='closeId']//span[text()=' Close']")
	WebElement close_noteBook; //Clicking on add project icon 

	public void closeNoteBook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(close_noteBook));
		this.close_noteBook.click();
	}//closeNoteBook
	
	@FindBy(xpath = "//p-confirmdialog//button//span[text()='Yes']")
	WebElement closePopup_Yes_noteBook; //it will work for multiple popup Yes Button.

	public void clickYesOnCloseNoteBookPopup() {
		this.wait.until(ExpectedConditions.elementToBeClickable(closePopup_Yes_noteBook));
		this.closePopup_Yes_noteBook.click();
	}//clickYesOnCloseNoteBookPopup
	
	@FindBy(xpath = "//textarea[@id='nbCloseComments']")
	WebElement closeComments_noteBook;  
	
	@FindBy(xpath = "//button[@id='closeNoteBookId']//span[text()=' Save ']")
	WebElement savecoment_noteBook;

	public void saveCloseNoteBook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(savecoment_noteBook));
		this.savecoment_noteBook.click();
	}//saveCloseNoteBook

	public void entercloseCommentsInNoteBook(String comment) {
		this.wait.until(ExpectedConditions.elementToBeClickable(closeComments_noteBook));
		this.closeComments_noteBook.clear();
		this.closeComments_noteBook.click();
		this.closeComments_noteBook.sendKeys(comment);
	}//clearNoteBookName
	
	@FindBy(xpath = "//button[@id='deactivateId']//span[text()=' Deactivate']")
	WebElement deactivate_noteBook;

	public void deactivateNoteBook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(deactivate_noteBook));
		this.deactivate_noteBook.click();
	}//deactivateNoteBook
	
	@FindBy(id = "notebookName")
	WebElement Summary_noteBookname_input;

	public void clearNoteBookNameInSummary() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Summary_noteBookname_input));
		Summary_noteBookname_input.sendKeys(Keys.chord(Keys.CONTROL,"a"));
				// Select all text
		Summary_noteBookname_input.sendKeys(Keys.BACK_SPACE);
				// Delete selected text

	}//clearNoteBookNameInSummary
	
	public void changeNoteBookNameTo(String notebookName) {
		this.wait.until(ExpectedConditions.elementToBeClickable(Summary_noteBookname_input));
		this.Summary_noteBookname_input.sendKeys(notebookName);
	}//changeNoteBookNameTo
	
	@FindBy(xpath = "//button[@id='edisaveIdtId']//span[text()=' Save']")
	WebElement saveChanges_noteBook;

	public void saveChangesNoteBook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(saveChanges_noteBook));
		this.saveChanges_noteBook.click();
	}//deactivateNoteBook
	
	@FindBy(xpath = "//button[@id='cancelId']//span[text()=' Cancel ']")
	WebElement cancelChanges_noteBook; 

	public void cancelChangesNoteBook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(cancelChanges_noteBook));
		this.cancelChanges_noteBook.click();
	}//cancelChangesNoteBook

	public void selectNoteBookInNoteBookTab(String notebook) {
		WebElement checkBoxNotebook=driver.findElement(By.xpath("//tbody//tr//td[contains(text(),' "+notebook+" ')]/../td[contains(@class,'column-select')]//span"));
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxNotebook));
		checkBoxNotebook.click();		
	}//selectNoteBookInNoteBookTab
	
	@FindBy(xpath = "//button//span[text()='Yes']")
	WebElement yes_reopen_noteBook; 

	public void clickyesReopenNoteBook() {
		this.wait.until(ExpectedConditions.elementToBeClickable(yes_reopen_noteBook));
		this.yes_reopen_noteBook.click();
	}//clickyesReopenNoteBook

	public String getNotebookStatus(String noteBook) {
		WebElement notebookStatus=driver.findElement(By.xpath("//tbody//tr//td[contains(text(),' "+noteBook+" ')]/../td[contains(@class,'column-nbStatus')]"));
		wait.until(ExpectedConditions.elementToBeClickable(notebookStatus));	
		return notebookStatus.getText();
	}//getNotebookStatus
	
	}//Project_NoteBook_Page

