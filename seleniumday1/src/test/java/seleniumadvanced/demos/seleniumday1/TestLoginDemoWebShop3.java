package seleniumadvanced.demos.seleniumday1;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//To show group we need to write group = groupname in all the classes
public class TestLoginDemoWebShop3 {
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String value,ITestContext result ) {
		
		System.out.println(result.getCurrentXmlTest().getName()+"test started");
		if(value.equals("chrome"))		
		{
			System.setProperty("webdriver.chrome.driver","C:\\Srijana Gurung\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver =  new ChromeDriver();
		}
		else if(value.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Srijana Gurung\\Drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
			driver =  new InternetExplorerDriver();	
		}
	    
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterTest
	public void afterTest(ITestContext result) {
		System.out.println(result.getCurrentXmlTest().getName()+"test stopped");
		driver.close();
	}
	@Test(dataProvider="dp1")
	public void testDemoWebShopLogin(String username,String password)
	{
	    
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
		driver.findElement(By.linkText("Log out")).click();
	}
	@DataProvider(name="dp1")
	public Object[][] getData()
	{
		return TestReadExcel.testreadexcel();
	}

}
