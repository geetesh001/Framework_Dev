package testScript;

import generic.Base_Class;

import org.testng.annotations.Test;

import OR.Pagefactory_HomePage;
import OR.Pagefactory_LoginPage;
import dataProvider.DP_Login;

public class Scenario_Login extends Base_Class{

	@Test(dataProvider="invalid_login",dataProviderClass=DP_Login.class)
	public void login(String TC_id,String order,String userName,String password,String exptResult){
		Pagefactory_HomePage homePage=new Pagefactory_HomePage(driver);
		homePage.click_Signin();
		Pagefactory_LoginPage login=new Pagefactory_LoginPage(driver);
		login.write_userName(userName);
		login.write_password(password);
		login.click_submitButton();
	}

}
