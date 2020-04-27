package com.dc4.webfulfillment.dataprovider;

import org.testng.annotations.DataProvider;

import com.dc4.webfulfillment.commons.ExcelDataConfig;

public class DataProviders {

	public static ExcelDataConfig config = new ExcelDataConfig(
			"C:\\Users\\shriniwas.alle\\git\\WebFulfillment\\Web-Fulfillment\\Data.xlsx");

	@DataProvider(name = "companyNames")
	public static Object[][] provider() {

		int rowCount = config.getRowCount(0);
		int colCount = config.getColCount(0);
		System.out.println("Row Count aahe:" + rowCount);
		System.out.println("Col Count aahe:" + colCount);
		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 0; i < rowCount - 1; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i][j] = config.getData("Sheet1", i + 1, j);
				System.out.println(data[i][j]);
			}
		}
		return data;
	}

}
