package com.dc4.webfulfillment.commons;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelDataConfig(String excelPath) {
		try {
			File file = new File(excelPath);
			FileInputStream inputStream = new FileInputStream(file);
			wb = new XSSFWorkbook(inputStream);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(String sheetName, int row, int col) {
		sheet = wb.getSheet(sheetName);
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}

	public int getColCount(int sheetIndex) {
		sheet = wb.getSheetAt(sheetIndex);
		int col = sheet.getRow(0).getLastCellNum();
		return col;
	}
}
