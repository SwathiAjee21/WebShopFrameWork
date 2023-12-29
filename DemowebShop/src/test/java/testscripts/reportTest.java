package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import GenericLibrary.BaseClass;

public class reportTest extends BaseClass {
	
	ExtentReports report = new ExtentReports("./Reports/"+getSystemDate()+".html");
	
	ExtentTest test =  report.startTest("loginTest");
	
	@Test
	public void reportTest1() {
		WebDriver driver =  new ChromeDriver();
		test.log(LogStatus.INFO, "chrome browser launched");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "chrome is maximized");
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("swatajee@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Password@143");
		driver.findElement(By.cssSelector("[value='Log in']")).click();
		
		Assert.assertEquals(driver.findElement(By.linkText("Log out")).isDisplayed(),true);
		test.log(LogStatus.FAIL, "Log in Successful");
		report.endTest(test);
		
		driver.quit();
		
		}
	
	@Test
	public void reportTest2() {
		WebDriver driver =  new ChromeDriver();
		test.log(LogStatus.INFO, "chrome browser launched");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "chrome is maximized");
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("swatajee@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Password@143");
		driver.findElement(By.cssSelector("[value='Log in']")).click();
		
		Assert.assertEquals(driver.findElement(By.linkText("Log out")).isDisplayed(),true);
		test.log(LogStatus.PASS, "Log in Successful");
		report.endTest(test);
		report.flush();
		
		driver.quit();
	}
	
}
