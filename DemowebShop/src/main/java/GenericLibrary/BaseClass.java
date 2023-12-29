package GenericLibrary;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass extends webDriverUtility {
	
	public WebDriver driver;

	@BeforeSuite
	  public void beforeSuite() {
		   report=new ExtentReports(REPORT_PATH+getSystemDate()+".html");
	       Reporter.log("connect to datebase", true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Close connection to database", true);
		report.flush();
	}
	
	@BeforeTest
	  public void beforeTest() {
			Reporter.log("before test", true);	
	}
	
	@AfterTest
		 public void afterTest() {
				Reporter.log("After test", true);	
	}
			
	@BeforeClass 
	public void beforeclass () {
			Reporter. log ("Before class", true);
			String browser=FileUtility. getProperty("browser");
			String url=FileUtility.getProperty("URL");
			
			if (browser. equalsIgnoreCase ("chrome")){
			driver=new ChromeDriver();			
			}
			else if (browser.equalsIgnoreCase ("edge")) {
			driver=new EdgeDriver();
			}
			else if (browser.equalsIgnoreCase ("firefox")) {
			driver=new FirefoxDriver ();
			}
			else {
				driver=new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);
             //initObjects();
	}
			@AfterClass
			public void afterclass () {
			Reporter. log ("After class", true);
			driver.quit();
			}
			
	@BeforeMethod
	//public void beforeMethod() {
	public void beforeMethod(Method method) {
		
		String methodName = method.getName(); //to print the testname as method name
		test=report.startTest(methodName);
		
		Reporter.log("Login");
		HomePage homepage = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		//click on login link
		homepage.getLoginLink().click();
		
		//enter the email
		loginpage.getEmailTextField().sendKeys(FileUtility.getProperty("email"));
		
		//enter password
		loginpage.getPasswordTextField().sendKeys(FileUtility.getProperty("password"));
		
		//click on remember me checkbox
		loginpage.getRememberMeCheckBox().click();
		
		//click on login button
		loginpage.getLoginButton().click();
		
	}
	@AfterMethod
	public void aftermethod () {
	Reporter. log ("Log out");
	driver. findElement (By. linkText ("Log out")).click();
    report.endTest(test);
	}
} 