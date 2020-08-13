package july20;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import june20the.TestUtil;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ashish\\Desktop\\selenium drivers\\chromedriver_win32\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/login.cfm");
	}
	
	@DataProvider
	public Object[][] getLogindata() throws Exception
	{
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	}
	
	@Test(dataProvider="getLogindata")
	public void loginTest(String Username,String Password)
	{
	driver.findElement(By.xpath("//*[@id=\"loginForm\"]/input[1]")).sendKeys(Username);	
	driver.findElement(By.xpath("//*[@id=\"loginForm\"]/input[2]")).sendKeys(Password);
	WebElement loginbtn=driver.findElement(By.xpath("//*[@id=\"loginForm\"]/input[3]"));
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", loginbtn);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
