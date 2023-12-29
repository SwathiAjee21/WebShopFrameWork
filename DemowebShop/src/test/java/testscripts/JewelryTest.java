package testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import ObjectRepository.HomePage;
import ObjectRepository.JewelryPage;


public class JewelryTest extends BaseClass{
	
	@Test
	public void diamondHeartTest_001() {
		HomePage homePage = new HomePage(driver);
		JewelryPage jewelryPage = new JewelryPage(driver);
		
		//Takes ScreenShot of Web Page
		getScreenshotOfWebPage(driver);
		
		//Click on Jewelry
		clickElement(homePage.getjewelryLink());
		
		//Takes Screenshot on Diamond Heart
		getScreenshotOfWebElement(jewelryPage.getBlackAndWhiteDiamondHeartImage());
	
	}

}
