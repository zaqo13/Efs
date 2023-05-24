package com.efs.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility class to set data in an Excel file.
 */
public class ExcelSet {

	/**
	 * Sets the data in the Excel file at the specified row and sheet index.
	 * 
	 * @param data       The data to be set in the Excel file
	 * @param rowIndex   The row index where the data needs to be set
	 * @param sheetIndex The sheet index where the data needs to be set
	 * @throws IOException If an I/O error occurs
	 */

	public static void setExcelData(String data, int rowIndex, int sheetIndex) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\TestData\\" + "AddCustomerExcel.xlsx";

		FileInputStream inputStream = null;
		XSSFWorkbook workbook = null;
		FileOutputStream outputStream = null;

		try {
			// Open the Excel file
			inputStream = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(inputStream);

			// Get the sheet and row where the data needs to be set
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			XSSFRow row = sheet.getRow(rowIndex);

			// Set the data in the specified cell
			XSSFCell cell = row.createCell(28);
			cell.setCellValue(data);

			// Save the changes to the Excel file
			outputStream = new FileOutputStream(filePath);
			workbook.write(outputStream);

		} catch (IOException e) {
			// Handle any I/O errors that occur
			throw e;

		} finally {
			// Close the input and output streams and the workbook
			if (inputStream != null) {
				inputStream.close();
			}

			if (outputStream != null) {
				outputStream.close();
			}

			if (workbook != null) {
				workbook.close();
			}
		}
	}
}