package CHEMIASOFT.Chemia.Embedded_Excel.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRD_Left_Menu_Tabs {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public CRD_Left_Menu_Tabs(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@FindBy(xpath = "//a[@id='sidebar-toggle']")
	WebElement clickonLeftMenuIcon;  //LeftMenuIcon
	
	public void clickonLeftMenuIcon() {
		this.wait.until(ExpectedConditions.elementToBeClickable(clickonLeftMenuIcon));
		clickonLeftMenuIcon.click();
		
	}
	// ATR Menu on Left Menu
	@FindBy(xpath = "//span[contains(text(),'ATR Menu')]")
	WebElement ATRMenu;// ATR Menu on left Menu

	public void ATRMenu() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ATRMenu));
		ATRMenu.click();
	}
	
	@FindBy(xpath = "//span[contains(text(),' Re Assign Reviewer ')]")
	WebElement ReAssigenReviwer; // Re-assign reviewer tab on ATR menu on left Menu

	public void ReAssigenReviwer() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ReAssigenReviwer));
		ReAssigenReviwer.click();
	}
	
	@FindBy(xpath = "//span[contains(text(),' Project ATRs ')]")
	WebElement  ProjectATRs ; 

	public void  ProjectATRs() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ProjectATRs));
		ProjectATRs .click();
	}
	
	@FindBy(xpath = "//span[contains(text(),' My ATR ')]")
	WebElement  MyATR ; 

	public void  MyATR() {
		this.wait.until(ExpectedConditions.elementToBeClickable(MyATR));
		MyATR .click();
	}
	
	@FindBy(xpath = "//span[contains(text(),' ATR Pending For Submission ')]")
	WebElement  ATRPendingForSubmission ; 

	public void  ATRPendingForSubmission() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ATRPendingForSubmission));
		ATRPendingForSubmission .click();
	}
	
	
	@FindBy(xpath = "//span[contains(text(),' Pending Clarification ')]")
	WebElement  PendingClarification ; 

	public void  PendingClarification() {
		this.wait.until(ExpectedConditions.elementToBeClickable(PendingClarification));
		PendingClarification .click();
	}
	
	@FindBy(xpath = "//span[contains(text(),'Project ')]")
	WebElement Project; // Re-assign reviewer tab on ATR menu on left Menu

	public void Project() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Project));
		Project.click();
	}
	
	@FindBy(xpath = "//span[contains(text(),' Closed Projects ')]")
	WebElement ClosedProjects ; 

	public void ClosedProject() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ClosedProjects));
		ClosedProjects.click();
	}
	
	@FindBy(xpath = "//span[contains(text(),'Open Projects')]")
	WebElement  OpenProjects  ; 

	public void  OpenProjects () {
		this.wait.until(ExpectedConditions.elementToBeClickable( OpenProjects ));
		 OpenProjects .click();
	}
	
	@FindBy(xpath = " //span[contains(text(),'Lookup')]")
	WebElement  Lookup ; 

	public void  Lookup () {
		this.wait.until(ExpectedConditions.elementToBeClickable(Lookup));
		Lookup .click();
	}
	
	 
	@FindBy(xpath = "  //span[contains(text(), 'LookupData ')]")
	WebElement  LookupData ; 

	public void  LookupData () {
		this.wait.until(ExpectedConditions.elementToBeClickable(LookupData));
		LookupData .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Experiment Action ')]")
	WebElement  ExperimentAction ; 

	public void  ExperimentAction () {
		this.wait.until(ExpectedConditions.elementToBeClickable(ExperimentAction));
		ExperimentAction .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Review Requests')]")
	WebElement  ReviewRequests ; 

	public void  ReviewRequests() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ReviewRequests));
		ReviewRequests .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Unlock Requests ')]")
	WebElement  UnlockRequests ; 

	public void  UnlockRequests() {
		this.wait.until(ExpectedConditions.elementToBeClickable(UnlockRequests));
		UnlockRequests .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), ' Re-Assign Reviewer ')]")
	WebElement  ReAssignReviewer ; 

	public void  ReAssignReviewer () {
		this.wait.until(ExpectedConditions.elementToBeClickable(ReAssignReviewer));
		ReAssignReviewer  .click();
	}

	@FindBy(xpath = "//span[contains(text(), 'Report Menu ')]")
	WebElement  ReportMenu ; 

	public void  ReportMenu() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ReportMenu));
		ReportMenu .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), ' Delayed Submission ')]")
	WebElement  DelayedSubmission ; 

	public void  DelayedSubmission() {
		this.wait.until(ExpectedConditions.elementToBeClickable(DelayedSubmission));
		DelayedSubmission .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), ' Delayed Approval ')]")
	WebElement  DelayedApproval ; 

	public void  DelayedApproval() {
		this.wait.until(ExpectedConditions.elementToBeClickable(DelayedApproval));
		DelayedApproval .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), ' Inactive Experiment ')]")
	WebElement  InactiveExperiment ; 

	public void  InactiveExperiment() {
		this.wait.until(ExpectedConditions.elementToBeClickable(InactiveExperiment));
		InactiveExperiment .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Master Data ')]")
	WebElement  MasterData ; 

	public void  MasterData() {
		this.wait.until(ExpectedConditions.elementToBeClickable(MasterData));
		MasterData .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Embedded Excel Template ')]")
	WebElement  EmbeddedExcelTemplate ; 
	
	public void  EmbeddedExcelTemplate() {
		this.wait.until(ExpectedConditions.elementToBeClickable(EmbeddedExcelTemplate));
		EmbeddedExcelTemplate .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), 'ATR  ')]")
	WebElement  ATR ; 

	public void  ATR() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ATR));
		ATR .click();
	}
	
	@FindBy(xpath = "//li[1]//span[contains(text(), 'Team')]")
	WebElement  Team ; 

	public void  Team() {
		this.wait.until(ExpectedConditions.elementToBeClickable(Team));
		Team .click();
	}
	
	
	@FindBy(xpath = "//li[2]//span[contains(text(), ' Team ATRs ')]")
	WebElement  TeamATRs ; 

	public void  TeamATRs() {
		this.wait.until(ExpectedConditions.elementToBeClickable(TeamATRs));
		TeamATRs .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Experiment Menu ')]")
	WebElement  ExperimentMenu ; 

	public void  ExperimentMenu() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ExperimentMenu));
		ExperimentMenu .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), ' On-Going experiments ')]")
	WebElement  OnGoingexperiments ; 

	public void  OnGoingexperiments() {
		this.wait.until(ExpectedConditions.elementToBeClickable(OnGoingexperiments));
		OnGoingexperiments .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), ' Submitted Experiments ')]")
	WebElement  SubmittedExperiments ; 

	public void  SubmittedExperiments() {
		this.wait.until(ExpectedConditions.elementToBeClickable(SubmittedExperiments));
		SubmittedExperiments .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Pending for Review ')]")
	WebElement  PendingforReview ; 

	public void  PendingforReview() {
		this.wait.until(ExpectedConditions.elementToBeClickable(PendingforReview));
		PendingforReview .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), ' Verified Experiments ')]")
	WebElement  VerifiedExperiments ; 

	public void  VerifiedExperiments() {
		this.wait.until(ExpectedConditions.elementToBeClickable(VerifiedExperiments));
		VerifiedExperiments .click();
	}
	
	@FindBy(xpath = "//span[contains(text(), ' Review Comments ')]")
	WebElement  ReviewComments ; 

	public void  ReviewComments() {
		this.wait.until(ExpectedConditions.elementToBeClickable(ReviewComments));
		ReviewComments .click();
	}
	
	//li[1]//span[contains(text(), 'Team')]
	//li[4]//span[contains(text(), 'ATR')]
	@FindBy(xpath = "//li[4]//span[contains(text(), 'ATR')]")
	WebElement  TL_ATR_Leftmenu ; 

	public void  TL_ATR() {
		this.wait.until(ExpectedConditions.elementToBeClickable(TL_ATR_Leftmenu));
		TL_ATR_Leftmenu .click();
	}
	@FindBy(xpath = "//li[2]//span[contains(text(), 'Team')]")
	WebElement  TL_ATR_Team ; 

	public void  TL_ATR_team() {
		this.wait.until(ExpectedConditions.elementToBeClickable(TL_ATR_Team));
		TL_ATR_Team .click();
	}
	
	
	
	
}
