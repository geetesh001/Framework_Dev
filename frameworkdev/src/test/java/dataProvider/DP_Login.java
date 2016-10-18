package dataProvider;

import java.util.ArrayList;
import java.util.ListIterator;

import org.testng.annotations.DataProvider;

import generic.Excel_Reader;

public class DP_Login {
	
	@DataProvider(name="valid_login")
	public static ListIterator<Object[]> valid_login(){
		return data("Valid_Login_test");
	}
	
	@DataProvider(name="invalid_login")
	public static ListIterator<Object[]> invalid_login(){
		return data("Invalid_Login_test");
	}
	
	
	public static ListIterator<Object[]> data(String scriptName){
		
		Excel_Reader er=new Excel_Reader();
		ArrayList<Object[]> arr=new ArrayList<Object[]>();
		for(int i=2;i<er.getRowCount("Scenario_Login");i++){
			if(er.readCellValue("Scenario_Login", i, 4).equals(scriptName) &
					er.readCellValue("Scenario_Login", i, 3).equals("Y"))
			{
				Object[] obj=new Object[5];
				obj[0]=er.readCellValue("Scenario_Login", i, 1);
				obj[1]=er.readCellValue("Scenario_Login", i, 2);
				obj[2]=er.readCellValue("Scenario_Login", i, 5);
				obj[3]=er.readCellValue("Scenario_Login", i, 6);
				obj[4]=er.readCellValue("Scenario_Login", i, 7);
				arr.add(obj);
			}
			
		}
		return arr.listIterator();
	}

}
