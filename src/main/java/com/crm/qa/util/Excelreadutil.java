package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excelreadutil {
	XSSFWorkbook wb;
	XSSFSheet xs;
	public Excelreadutil(String Excelpath)  {
		
		try {
			File src=new File(Excelpath);
			FileInputStream fs=new FileInputStream(src);
			wb = new XSSFWorkbook(fs);
			xs = wb.getSheetAt(0);
				} catch (Exception e) {
			System.out.println(e.getMessage());			
		}
	}
	
	public String getdata(int SheetNumber,int rown,int coln) {
		String data=xs.getRow(rown).getCell(coln).getStringCellValue();
		return data;
		}	
	public int getRowcount(int SheetIndex) {
		int j=wb.getSheetAt(SheetIndex).getLastRowNum();
		j=j+1;
		return j;		
	}
	}
	

	



     