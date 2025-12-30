package com.Runner;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataRead {

	
	@DataProvider(name="Excel")
	public  Object  [] [] login() throws IOException{
		return ReadExcel.readexcelfile();
	}
}
