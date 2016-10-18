package OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory_LoginPage {
	
	
	
	@FindBy(xpath="//input[@name='logid']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@name='pswd']")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit'][@value='Login']")
	private WebElement submitButton;
	
	public Pagefactory_LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void write_userName(String uname){
		userName.sendKeys(uname);
	}
	
	public void write_password(String pwd){
		password.sendKeys(pwd);
	}
	
	public void click_submitButton(){
		submitButton.click();
	}
}
