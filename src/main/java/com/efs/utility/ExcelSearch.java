package com.efs.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * Utility class for searching into Excel file by header name
 *
 */

public class ExcelSearch {

	/**
	 * Searches for a specific header in an Excel file and returns the value of the
	 * corresponding column.
	 * 
	 * @param fileName     the name of the Excel file to search
	 * @param searchHeader the name of the column header to search for
	 * @return an instance of Result containing the value of the first cell in the
	 *         column that matches the search header, and its row number
	 * @throws IllegalArgumentException If the searchHeader is not found in the Excel file.
	 * @throws IOException  If an I/O error occurs.
	 * 
	 */

	public static Result searchByHeader(String fileName, String searchHeader) {
		try {
			// Open the excel file
			FileInputStream inputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\TestData\\" + fileName + ".xlsx");
			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(1);
			Row headerRow = sheet.getRow(0);
			int columnIndex = -1;

			// Iterate through the header row to get the column index of the specific header
			for (Cell cell : headerRow) {
				if (cell.getStringCellValue().equals(searchHeader)) {
					columnIndex = cell.getColumnIndex();
					break;
				}
			}
			if (columnIndex == -1) {
				throw new IllegalArgumentException("Column '" + searchHeader + "' not found");
			}

			// Iterate through the rest of the rows to get the value of the specific column
			for (Row row : sheet) {
				if (row.getRowNum() == 0) {
					continue;
				}
				Cell cell = row.getCell(columnIndex);

				// Check if the cell is null
				if (cell == null) {
					inputStream.close();
					return new Result(null, 0);
				}
				CellType cellType = cell.getCellType();
//	            CellType cellType = cell.getCellTypeEnum();
				switch (cellType) {
				case NUMERIC:
					double numericValue = cell.getNumericCellValue();
					inputStream.close();
					return new Result(null, (long) numericValue);
				case STRING:
					String stringValue = cell.getStringCellValue();
					inputStream.close();
					return new Result(stringValue, 0);
				case BLANK:
					inputStream.close();
					return new Result(null, 0);
				case ERROR:
					inputStream.close();
					return new Result(null, 0);
				default:
					inputStream.close();
					return new Result(null, 0);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("An I/O error occurred while reading the Excel file.", e);
		}
		return null;
	}
}