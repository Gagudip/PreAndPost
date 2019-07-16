package com.nmcportal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelReader {

	public static String path = "C:\\Users\\gsingh\\eclipse-workspace\\PreAndPostChecks\\Input\\Input.xls";
	public static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;

	private static HSSFWorkbook workbook = null;
	private static HSSFSheet sheet = null;
	private static HSSFRow row = null;
	public static java.util.List<String> ls;
	public static Map<String, String> map;

	public Map<String, String> GetData(int sheetnumber) throws Throwable {

		fis = new FileInputStream(path);
		workbook = new HSSFWorkbook(fis);
		sheet = workbook.getSheetAt(sheetnumber);
		Iterator<Row> rowIterator = sheet.iterator();
		map = new HashMap<String, String>();
		String key = null;
		String value = null;

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {

				case Cell.CELL_TYPE_STRING:

					key = cell.getStringCellValue();

					if (row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {

						cell = cellIterator.next();

						value = cell.getStringCellValue();

						map.put(key, value);

					}

					break;

				case Cell.CELL_TYPE_NUMERIC:
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						value = NumberToTextConverter.toText(cell.getNumericCellValue());

					}

					break;
				}

			}
		}

		return map;
		
	}

	
	
	
	
	
	
	
	
	public void ReadExcel(String Execution) throws Throwable {

		// this.path = path;
		fis = new FileInputStream(path);
		workbook = new HSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		map = new HashMap<String, String>();
		String key = null;
		String value = null;

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();

			// use a default value that will never occur in
			// the sheet

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {

				case Cell.CELL_TYPE_STRING:

					key = cell.getStringCellValue();

					if (row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {

						cell = cellIterator.next();

						value = cell.getStringCellValue();

						map.put(key, value);

					}

					break;

				case Cell.CELL_TYPE_NUMERIC:
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						value = NumberToTextConverter.toText(cell.getNumericCellValue());

					}

					break;
				}

			}
		}
	}

	public static List<String> ReadInputExcel() throws IOException {

		fis = new FileInputStream(path);
		workbook = new HSSFWorkbook(fis);
		sheet = workbook.getSheetAt(2);
		Iterator<Row> rowIterator = sheet.iterator();
		ls = new ArrayList<>();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.iterator();

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();

				if (cell.getCellType() == cell.CELL_TYPE_STRING) {

					ls.add(cell.getStringCellValue());

				}

			}

		}

		return ls;

	}
}
