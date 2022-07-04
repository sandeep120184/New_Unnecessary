package com.dc.rns.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.dc.rns.qa.Base.BaseTest;


public class ExcelReader extends BaseTest{

public static Workbook wk;
public static Sheet sh;
	


//	public static String fpath =System.getProperty("user.dir")
//			+ "/java/com/dc/rns/qa/TestData/LoginData.xlsx";
	
public static String fpath = "D:\\New-Unnecessary\\src\\main\\java\\com\\dc\\rns\\qa\\TestData\\LoginData.xlsx";
//public static String fpath ="D:/New-Unnecessary/src/main/java/com/dc/rns/qa/TestData/LoginData.xlsx";
	
	public static Object[][] getData(String sheetname){
		
		try {
			
			FileInputStream file = new FileInputStream(fpath);
			try {
				wk = WorkbookFactory.create(file);
				} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sh = wk.getSheet(sheetname);
		int strRow =sh.getLastRowNum();
		int strcol =sh.getRow(0).getLastCellNum();
	
		Object[][] data = new Object[strRow][strcol];
	
			
		for(int i=0;i<strRow;i++)
		{
			for(int j=0;j<strcol;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).toString();
				System.out.println("value is:"+data[i][j]);
			}
		}
		return data;
	}
}
