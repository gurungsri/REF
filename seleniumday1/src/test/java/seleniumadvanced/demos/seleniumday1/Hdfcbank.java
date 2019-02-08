package seleniumadvanced.demos.seleniumday1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hdfcbank {
	@Test
	public void hdfcbank() {
		System.setProperty("webdriver.chrome.driver","C:\\Srijana Gurung\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://hdfcbank.com");
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']")));
		act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']")));
		act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
		act1.click(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
		act1.perform();
		
		String url =driver.getCurrentUrl();
		Assert.assertTrue(url.contains("credit_cards"));
		driver.close();
		
	}

}
