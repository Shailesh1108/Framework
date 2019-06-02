package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;

public class ExcelDataProvider 
{
	WebDriver wb;
	public ExcelDataProvider()
	{
		try {
			FileInputStream fis = new FileInputStream("./Test_Data/Data.xlsx");
			wb= new XSSFWorkbook(fis);
		}
		catch (Exception e)
		{
			System.out.println("Unable to read Excel File" + e.getMessage());
		}
	}
	
	public String getStringData(int SheetIndex,int row, int column)
	{
		return wb.getSheetAt(SheetIndex).getRow(Row).getCell(Column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row, int column)
	{
		return wb.getSheet(sheetName).getRow(Row).getCell(Column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row, int column)
	{
		return wb.getSheet(sheetName).getRow(Row).getCell(Column).getNumericCellValue();
	}
			

}
