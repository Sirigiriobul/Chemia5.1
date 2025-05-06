package CHEMIASOFT.ARD.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ARD_LeftMenuItemsPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public ARD_LeftMenuItemsPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
	}
	@FindBy(xpath = "//mat-icon[normalize-space()='home']")
	WebElement Clickingonhomebutton; //Clicking on add project icon 

	public void Clickingonhomebutton() {

		 js.executeScript("arguments[0].scrollIntoView(true);", Clickingonhomebutton);
			this.wait.until(ExpectedConditions.elementToBeClickable(Clickingonhomebutton));
			this.Clickingonhomebutton.click();


	}
	@FindBy(xpath = "//a[@id='sidebar-toggle']")
	WebElement clickonLeftMenuIcon;  //LeftMenuIcon
	
	public void clickonLeftMenuIcon() {
		 js.executeScript("arguments[0].scrollIntoView(true);", clickonLeftMenuIcon);
			this.wait.until(ExpectedConditions.elementToBeClickable(clickonLeftMenuIcon));
			
			clickonLeftMenuIcon.click();
			}
	@FindBy(xpath = "//span[contains(text(),'ATR Menu')]")
	WebElement ATRMenu;// ATR Menu on left Menu

	public void ATRMenu() {
		 js.executeScript("arguments[0].scrollIntoView(true);", ATRMenu);
			this.wait.until(ExpectedConditions.elementToBeClickable(ATRMenu));
			
			ATRMenu.click();
	
	}
	public void  ClickOnARDTeam() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'ARD Team']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		this.wait.until(ExpectedConditions.elementToBeClickable(element));
		
		element.click();
		
	}
	//***********************TL LeftMenu Items*******************
	public void clcikOnTL_ATRTeams() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'ATR Teams']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_MyTeam() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'My Team']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_Configurations() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'Configurations']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_TestTechniques() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'Test Techniques']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_TestConfiguration() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'Test Configuration']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_ATRAttributes() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'ATR Attributes']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_TestGroups() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'Test Groups']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_FormTypes() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'Form Types']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_TLEvents() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'TL Events']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_ADExperiments() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'AD Experiments']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_TemplateDataItems() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'Template Data items']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_ExperimentTemplate() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'Experiment Template']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_ExperimentTemplateSections() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'Experiment Template Sections']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTL_TemplatePendingApproval() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'Template Pending Approval']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	//*****************************************Analyst left menu methods******************
	public void clcikOnATRForms() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space() = 'ATR Forms']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnMyATRs() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='My ATRs']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	public void clcikOnTeamATRs() {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Team ATRs']"));

		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();		
	}
	
	
}
