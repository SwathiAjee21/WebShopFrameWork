package GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

	
	//THIS CLASS CREATED FOR ALL REUSABLE METHODS 
	//@AUTHOR USER
	public class webDriverUtility implements FrameWorkConstants {
		
		public static WebDriver driver;
		public static Actions action;
		public static JavascriptExecutor je;
		public static ExtentReports report;
		public static ExtentTest test;
		
		
	public static void selectOptionByIndex(WebElement dropdown, int index) {
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}
	
	public static void selectOptionByValue(WebElement dropdown, String value) {
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}
	
	public static void selectOptionByVisibleText(WebElement dropdown, String text) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
	}
	
	//SWITCH TO WINDOW USING TITLE
	public static void switchToWindowByTitle(WebDriver driver , String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title)) {
				break;
			}
		}
		
	}
	//SWITCH TO WINDOW USING URL
	public static void switchToWindowByURL(WebDriver driver, String url) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}
	     
	//SWITCH TO FRAME USING INDEX
	public static void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	//SWITCH TO FRAME USING NAME OR ID
	public static void switchToFrameByNameorId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	//SWITCH TO FRAME USING WEBELEMENT
	public static void switchToFrameByWebElement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	//ALL WEBDRIVER METHODS
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
		/**
		 * This method is used to take the screenshot of entire webpage
		 * @param driver
		 * @return 
		 */
	public static String getScreenshotOfWebPage(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		String imagePath = SCREENSHOT_PATH+getSystemDate()+".png";
		File perm=new File(imagePath);
		
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+imagePath;
	}
	/**
	 * This method is used to take screenshot of webelement
	 * @param element
	 */
//	public static void getScreenshotOfWebElement(WebElement element) {
//		File temp=element.getScreenshotAs(OutputType.FILE);
//		File perm=new File(SCREENSHOT_PATH+getSystemDate()+".png");
//		try {
//			FileHandler.copy(temp, perm);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	//for taking screenshot in report
	public static String getScreenshotOfWebElement(WebElement element) {
		File temp=element.getScreenshotAs(OutputType.FILE);
		String imagePath = SCREENSHOT_PATH+getSystemDate()+".png";
		File perm=new File(imagePath);
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+imagePath;
	}

	public static void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public static void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public static String switchToAlertAndGetText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	
	public static void switchToAlertAndSsndText(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
//	methods to handle mouse actions
	public static void mouseHover(WebDriver driver,WebElement element) {
		action.moveToElement(element).perform();
	}
	public static void mouseClick(WebDriver driver,WebElement element) {
		action.click(element).perform();
	}
	
	public static void rightClick(WebDriver driver, WebElement element) {
		action.contextClick(element).perform();
	}
	
	
	//Get the system date and time
	public static String getSystemDate() {
		return LocalDateTime.now().toString().replace(":", "_").replace("-","_");
	}
	//METHOD TO HANDLE HIDDEN OR DISABLED BUTTON
	
	public static void clickOnHiddenOrDisabledElement (WebDriver driver,WebElement element) {
		
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();",element);
		
	}
	
	//METHOD TO HANDLE HIDDEN OR DISABLED TEXT FIELD
	
	public static void enterTextToHiddenOrDisabledElement(WebDriver driver, WebElement element, String value) {
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].value='"+value+"';", element);
	}
	
	//METHOD TO SCROLL THE WINDOW BY GIVEN X AND Y VALUE
	
	public static void scrollByXAndYValue(WebDriver driver, int x ,int y) {
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	//METHOD TO SCROLL THE WINDOW TO THE GIVEN X AND Y VALUE
	
		public static void scrollToXAndYValue(WebDriver driver, int x ,int y) {
			
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollTo("+x+","+y+");");
		}
		
		//METHOD TO SCROLL THE WINDOW TO THE GIVEN X AND Y VALUE

		public static void scrollIntoView(WebDriver driver, WebElement element, boolean position ) {
			
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("argument[0].scrollIntoView("+position+");", element);
		}
		
		//methods to initialize objects like javascript executor,actions
		public static void initObjects() {
			action=new Actions(driver);
			je=(JavascriptExecutor)driver;
		}

}


//Switch to window using title
//Switch to window using url
//Switch to frame using index
//Switch to frame using name or id
//Switch to frame using webelement
//all webdriver methods
//methods to take screen shot
//method to handle alert
//methods to handle mouse actions
