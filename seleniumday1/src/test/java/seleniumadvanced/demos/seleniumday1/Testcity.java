package seleniumadvanced.demos.seleniumday1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Testcity {
	@Test (groups = "action1")
	public void testCities() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","C:\\Srijana Gurung\\Drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("https://www.cleartrip.com");
			
			//FROM
			
			WebElement from =driver.findElement(By.id("FromTag"));
			Actions act1=new Actions(driver);
			Thread.sleep(5000);
			act1.keyDown(from,Keys.SHIFT).perform();
			Thread.sleep(5000);
			act1.sendKeys(from,"hyd").perform();
			Thread.sleep(5000);
			act1.sendKeys(Keys.ENTER).perform();
			
			String result =driver.findElement(By.id("From")).getAttribute("value");
			Assert.assertEquals(result,"HYD");
			
			
			// TO
			WebElement to =driver.findElement(By.id("ToTag"));
			to.sendKeys("ban");
			//Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ui-id-2")));
					
					
			WebElement ul= driver.findElement(By.id("ui-id-2"));
			List <WebElement> list = ul.findElements(By.tagName("li"));
			Assert.assertEquals(10, list.size());
			for(WebElement li:list)
			{
				if(li.getText().contains("BKK"))
				{
					li.click();
					break;
				}
			}
		
			
	}

}
