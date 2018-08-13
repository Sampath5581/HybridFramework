package com.crm.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.util.Excelreadutil;




public class xcelread {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		
		
	
		/*try {
			File file=new File("D:\\Selenium\\SeleniumPrograms\\HybridFramework\\src\\main\\java\\com\\crm\\qa\\Data\\Testdata.xlsx");
			FileInputStream fs=new FileInputStream(file);
			XSSFWorkbook wb=new XSSFWorkbook(fs);
			XSSFSheet xs=wb.getSheetAt(0);
			int rc=xs.getLastRowNum();
			for(int i=0;i<rc;i++)
			{
				String f=xs.getRow(i).getCell(0).getStringCellValue();
				System.out.println(f);
				wb.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
	
		Excelreadutil v=new Excelreadutil("D:\\Selenium\\SeleniumPrograms\\HybridFramework\\src\\main\\java\\com\\crm\\qa\\Data\\Testdata.xlsx");
		//System.out.println(v.getdata(0, 0, 0));
		int rows=v.getRowcount(0);
		//System.out.println(v.getdata(0, rows, 0);
	}
		
		
	}


