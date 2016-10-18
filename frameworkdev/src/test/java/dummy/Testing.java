package dummy;

import generic.Excel_Reader;

public class Testing {

	public static void main(String[] args) {
		
		Excel_Reader obj=new Excel_Reader();
		System.out.println(obj.getRowCount("Scenario_Search"));
		System.out.println(obj.getColumnCount("Scenario_Search", 3));
		System.out.println(obj.readCellValue("Scenario_Search", 5, 5));
		

	}

}
