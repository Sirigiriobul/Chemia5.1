package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CHEMIASOFT.Chemia.Utilites.setBrowser;

public class test {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		driver = setBrowser.browser();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		driver.get("https://fitpeo.com/revenue-calculator");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));
		WebElement element1 = driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']"));

        System.out.println("Attribute Value: " + element.getAttribute("style"));
        
        js.executeScript("arguments[0].scrollIntoView(true);", element1);
       
        Actions actions = new Actions(driver);
        element.click();

        for(int i=0;i<100;i++) {
        	 String ariaValueNow = (String) js.executeScript("return arguments[0].getAttribute('style');", element);
             System.out.println("Updated aria-valuenow: " + ariaValueNow);
             if(ariaValueNow.contentEquals("left: 40.8%;")) {
                 System.out.println("reached value " + "816");
                 actions.sendKeys(Keys.ARROW_RIGHT).perform();Thread.sleep(1000);
                 actions.sendKeys(Keys.ARROW_RIGHT).perform();Thread.sleep(1000);

                 actions.sendKeys(Keys.ARROW_RIGHT).perform();Thread.sleep(1000);

                 actions.sendKeys(Keys.ARROW_RIGHT).perform();Thread.sleep(1000);

                 break;
             }
             else {
                 // Perform Page Up (Send Page Up key)
                 actions.sendKeys(org.openqa.selenium.Keys.PAGE_UP).perform();
             }
        }
       
        String ariaValueNow = (String) js.executeScript("return arguments[0].getAttribute('style');", element);
        System.out.println("Updated aria-valuenow: " + ariaValueNow);

        // Close the browser
       // driver.quit();
	}

}
