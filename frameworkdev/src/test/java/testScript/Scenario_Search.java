package testScript;

import generic.Base_Class;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import OR.Pagefactory_HomePage;
import dataProvider.DP_Search;

public class Scenario_Search extends Base_Class{

	@Test(dataProvider="Valid_Search",dataProviderClass=DP_Search.class)
	public void search(String TC_id,String order,String searchTxt,String result) {
		
		Pagefactory_HomePage homePage=new Pagefactory_HomePage(driver);
		homePage.searchText(searchTxt);
		homePage.clickOnSearchButton();
		String numberofBooks = homePage.getNumberofBooks();
		SoftAssert asrt=new SoftAssert();
		asrt.assertEquals(Double.valueOf(numberofBooks), Double.valueOf(result));
		
		screenshots(TC_id,order);
		asrt.assertAll();
		
	}

}
