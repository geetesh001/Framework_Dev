package OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory_HomePage {

	@FindBy(xpath="//*[text()='Sign In']")
	private WebElement signinButton;
	
	@FindBy(id="srchword")
	private WebElement searchTxt;
	
	@FindBy(xpath="//input[@value='Search for books']")
	private WebElement searchButton;
	
	@FindBy(id="find")
	private WebElement numOfBooks;
	
	public Pagefactory_HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void searchText(String text){
		searchTxt.sendKeys(text);
	}
	
	public void clickOnSearchButton(){
		searchButton.click();
	}
	
	public String getNumberofBooks(){
		return numOfBooks.getText();
	}
	
	public void click_Signin(){
		signinButton.click();
	}
}
