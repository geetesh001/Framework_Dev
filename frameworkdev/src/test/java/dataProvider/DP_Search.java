package dataProvider;

import generic.Excel_Reader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DP_Search {
	
	@DataProvider(name="Valid_Search")
	public static Iterator<Object[]> valid_search(){
		
		return getData("Valid_Search");
		
	}
	
	@DataProvider(name="Invalid_Search")
	public static Iterator<Object[]> invalid_search(){
		
		return getData("Invalid_Search");
		
	}
	
	
	public static Iterator<Object[]> getData(String scriptName){
		Excel_Reader er = new Excel_Reader();
		List<Object[]> list=new ArrayList<Object[]>();
		for(int i=2;i<=er.getRowCount("Scenario_Search");i++){
			if(er.readCellValue("Scenario_Search", i, 4).equals(scriptName)){
				if(er.readCellValue("Scenario_Search", i, 3).equals("Y")){
					
					Object[] obj=new Object[4];
					obj[0]=er.readCellValue("Scenario_Search", i, 1);
					obj[1]=er.readCellValue("Scenario_Search", i, 2);
					obj[2]=er.readCellValue("Scenario_Search", i, 5);
					obj[3]=er.readCellValue("Scenario_Search", i, 6);
					
					list.add(obj);
				}
				
			}
			
		}
		
		return list.iterator();
	}

}
