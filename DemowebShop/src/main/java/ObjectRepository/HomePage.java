package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
	
	//public HomePage(WebDriver driver) {
	  //PageFactory.initElements(driver, this);
	//}
	
	public HomePage (WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	@FindBy (linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy (partialLinkText ="Shopping")
	private WebElement shoppingcartLink ;
	
	@FindBy (partialLinkText = "Wishlist")
	private WebElement wishlistLink;
	
	@FindBy (id="small-searchterms")
	private WebElement searchTextField;
	
	@FindBy (partialLinkText = "Jewelry ")
	private WebElement jewelryLink;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingcartLink() {
		return shoppingcartLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	@FindBy (css = "[value='Search']")
	private WebElement searchButton;
	
	@FindBy (partialLinkText = "BOOKS")
	private WebElement booksLink;
	
	public WebElement getBooksLink() {
		return booksLink;
		
	}

	public WebElement getjewelryLink() {
		return jewelryLink;
	}
}