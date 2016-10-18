package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	FileInputStream fs=null;
	XSSFWorkbook workbook=null;
	
	public Excel_Reader(){
		try {
			 fs =new FileInputStream(Utility.getValue("dataExcelSheetPath"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			 workbook=new XSSFWorkbook(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(workbook!=null)
			System.out.println("connection successful");
		else
			System.out.println("Connection failed");
		try {
			fs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public XSSFSheet getSheet(String sheetName){
		XSSFSheet sheet = workbook.getSheet(sheetName);
		return sheet;
	}
	
	public int getRowCount(String sheetName){
		int lastRowNum = getSheet(sheetName).getLastRowNum();
		return lastRowNum+1;
	}
	
	public short getColumnCount(String sheetName,int rowNum){
		short lastCellNum = getSheet(sheetName).getRow(rowNum).getLastCellNum();
		return lastCellNum;
	}
	
	public String readCellValue(String SheetName,int rowNum,int colNum){
		String value=null;
		XSSFCell cell = getSheet(SheetName).getRow(rowNum-1).getCell(colNum-1);
		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
			value=String.valueOf(cell.getNumericCellValue());
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			value=cell.getStringCellValue();
		if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			value="";
		return value;
	}
	
	public void writeCellValue(String sheetName,int rowNum,int colNum,String data){
		
		XSSFSheet sheet = getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		if(row==null)
			sheet.createRow(rowNum);
		XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
		if(cell==null)
			sheet.getRow(rowNum).createCell(colNum);
		sheet.getRow(rowNum).getCell(colNum).setCellValue(data);
		writeExcel();
	}
	
	public void writeExcel(){
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("E:\\AA_SELENIUM_BASICS\\zz_eclipse_project\\frameworkdev\\src\\Test_Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
