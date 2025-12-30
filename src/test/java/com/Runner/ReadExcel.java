package com.Runner;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String [][]  readexcelfile() throws IOException{
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook("C:\\Users\\abhil\\OneDrive\\Desktop\\Book1.xlsx");
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0); // to read the sheet number
		XSSFRow xssfRow = xssfSheet.getRow(1); // to read the data of row from sheet
		int lastrow = xssfSheet.getLastRowNum(); // to get the last number of row
		XSSFCell xssfCell = xssfRow.getCell(0); // to get the data of cell from row
		int lastcell = xssfRow.getLastCellNum(); //to get the last number of cell
		System.out.println(lastcell);
		System.out.println(xssfCell.getStringCellValue()); // to print the output of the excel
		//Above code is used to read the data from excel
		
		
		//below code is used to merge with the framwework
		String mydata [][] = new String [lastrow+1] [lastcell];  // we are using excel to data and excel id 2D array
		for (int row =0;row<=lastrow;row++) {         // to check the conditions with the help of index
			for (int cell=0;cell<lastcell;cell++) {  // to check the conditions with the help of index
				XSSFRow xssfRow1 = xssfSheet.getRow(row);
				XSSFCell xssfCell1 = xssfRow.getCell(cell);
				mydata [row][cell]=xssfCell1.getStringCellValue(); // to print the data in browser
				
			}
			
		}
		return mydata;
			
		
		
	}

}
