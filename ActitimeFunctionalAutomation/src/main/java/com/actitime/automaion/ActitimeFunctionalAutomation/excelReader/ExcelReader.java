package com.actitime.automaion.ActitimeFunctionalAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public FileInputStream fileinpath;
	public FileOutputStream fileout = null;
	public String path;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
	
	
	public ExcelReader(String path) {
		this.path = path;
		try {
			fileinpath = new FileInputStream(path);
			workbook  = new XSSFWorkbook(fileinpath);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}		
	}
	
	public String[][] getDataFromSheet(String sheetname, String excelname) {
		String[][] dataSets = null;
		try {	
		XSSFSheet sheet = workbook.getSheet(sheetname);
		//count no of active row
		int numrow = sheet.getLastRowNum()+1;
		System.out.println("no of rows in excel" + numrow);
		//count no. of active column
		int totalcolumn = sheet.getRow(0).getLastCellNum();
		System.out.println("no of column in excel" + totalcolumn);
		//create array for row and column
		 dataSets = new String[numrow-1][totalcolumn];
		//read data from row
		for(int i = 1;i<numrow;i++) {
			XSSFRow row = sheet.getRow(i);
			//System.out.println(row);
		//read data from column 
			for ( int j = 0;j<totalcolumn;j++) {
				XSSFCell cell = row.getCell(j);
				System.out.println("cell adress"+cell.getAddress());
				//if data of the excel is string
				if(cell.getCellTypeEnum()==CellType.STRING) {
				dataSets	[i-1][j]=cell.getStringCellValue();
				System.out.println("the current value is " + dataSets	[i-1][j]);
		
				}
				//if data is numeric
				else if(cell.getCellTypeEnum()==CellType.NUMERIC) {
					String cellText = String.valueOf(cell.getNumericCellValue());
					dataSets[i-1][j]=cellText;		
				}
				//if data is boolean
				else {
					dataSets[i-1][j]=String.valueOf(cell.getBooleanCellValue());
					return dataSets;
				}
			}
		}
		
		//
		
		}
	catch(Exception e){
		System.out.println("uanble to read excel" + e.getStackTrace());
	}	
		//return dataSets;
		return dataSets;
	}
	
	@SuppressWarnings("deprecation")
	public String getcelldata(String sheetname,String colname,int rownum) {
		
		int col_num = 0;
		int index = workbook.getSheetIndex(sheetname);
		sheet = workbook.getSheetAt(index);
		XSSFRow row = sheet.getRow(0);
		for(int i=0; i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().equals(colname)) {
			col_num = i;
			break;
		}
		}
		row = sheet.getRow(rownum-1);
		 XSSFCell cell = row.getCell(col_num);
			 if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
				 return cell.getStringCellValue();
			 }
			 else if (cell.getCellType()==Cell.CELL_TYPE_BLANK) {
				 return "";
			 }
		 
		return null;
	}
	
	
	
	
	
	

}
