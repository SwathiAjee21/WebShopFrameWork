package testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GenericLibrary.BaseClass;
import ObjectRepository.BookPage;
import ObjectRepository.HomePage;

public class BooksTest extends BaseClass{
	
	@Test
	public void verifyBookPage_001() {
		HomePage homePage = new HomePage(driver);
		BookPage bookPage = new BookPage(driver);
		Reporter.log("Verify books page", true);
		
		//Click on BOOKS Link
		homePage.getBooksLink().click();
		
		String pageHeading = bookPage.getBooksPageHeading().getText();
		//Assert.assertEquals(pageHeading, "Books", "Books is not displayed");
		try {
			Assert.assertEquals(pageHeading, "Computer", "Books is not displayed");	
		    test.log(LogStatus.PASS, "Test case completed");
		}
		catch(AssertionError e) {
			String path=getScreenshotOfWebPage(driver);
			test.log(LogStatus.FAIL, test.addScreenCapture(path));
			//or you can write directly
			//test.log(LogStatus.FAIL, test.addScreenCapture(getScreenshotOfWebPage(driver)));
		}
		Reporter.log("Test case Completed and it passed ", true);
	}
	
	@Test
    public void sortBooksByNameAndPrice_002() throws InterruptedException {
    	HomePage homepage = new HomePage(driver);
    	BookPage bookpage = new BookPage(driver);
    	
    	//click on Books Link
    	homepage.getBooksLink().click();
    	
    	//sort the books from Z To A
    	selectOptionByIndex(bookpage.getSortByDropdown(), 2);
    	Thread.sleep(2000);
    	
    	//sort by books from created on by value
    	selectOptionByValue(bookpage.getSortByDropdown(),"created on");
    	Thread.sleep(2000);
    	
    	//sort by books from position by visible text
    	selectOptionByVisibleText(bookpage.getSortByDropdown(), "Position");
    	Thread.sleep(2000);
 
	}
	@Test
    public void sortBookByNameAndPrice_002()throws InterruptedException {
    	HomePage homepage = new HomePage(driver);
    	BookPage bookpage = new BookPage(driver);
    	//click on books link
    	homepage.getBooksLink().click();
    	
    	//sort the books from Z to A
    	selectOptionByIndex(bookpage.getPageSizeDropdown(), 2);
    	Thread.sleep(2000);
    	
    }
    
}
