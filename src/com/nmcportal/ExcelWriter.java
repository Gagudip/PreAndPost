package com.nmcportal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ExcelWriter {

	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	public static String path = "C:\\Users\\gsingh\\eclipse-workspace\\PreAndPostChecks\\Input\\Input.xls";
	private HSSFWorkbook workbook = null;
	private HSSFSheet sheet = null;
	private HSSFRow row = null;
	private HSSFCell cell = null;
	int counter = 0;

	public void WriteTimeStamp(int sheetnumber, String text, int counter) throws Throwable {

		fis = new FileInputStream(path);
		workbook = new HSSFWorkbook(fis);
		sheet = workbook.getSheetAt(sheetnumber);

		int LastRowNum = sheet.getLastRowNum();
		Row row = sheet.createRow(counter);

		row.createCell(0).setCellValue(text);
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\gsingh\\eclipse-workspace\\PreAndPostChecks\\Input\\Input.xls");
		workbook.write(fileOut);
		fileOut.close();

	}


	public void WriteWebTable( String Value, int cell) throws Throwable {

		row.createCell(cell).setCellValue(Value);
		FileOutputStream fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		fileOut.close();

	}
	
	public void IncreaseRow(int sheetnumber) throws Throwable {
		fis = new FileInputStream(path);
		workbook = new HSSFWorkbook(fis);
		sheet = workbook.getSheetAt(sheetnumber);
		
		int lastrow = sheet.getLastRowNum()+1;
		
		row = sheet.createRow(lastrow);
	}



}
