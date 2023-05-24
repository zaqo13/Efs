package com.efs.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * This is a Java class named "ExcelFile" that reads data from an Excel file
 * using the Apache POI library. It contains a method named "excelIndex" that
 * takes two integer parameters (row and column indices) and returns the value
 * of the corresponding cell from the Excel file. The method returns a custom
 * object of type "TypeResult" that contains the value as a string or a double,
 * depending on the cell type. The class also has a main method that
 * demonstrates how to use the "excelIndex" method to retrieve data from the
 * Excel file.
 *
 *
 * @param r - the row index of the cell to retrieve
 * @param c - the column index of the cell to retrieve
 * @return a custom object of type "TypeResult" that contains the value as a
 *         	 string or a double, depending on the cell type
 *
 */

public class ExcelFile {
	// by providing input in matrix form (x,y) and final . method will be from TypeResult class
	// which returning (String, double) datatype, depending on method call

	// Instance variables
	private static FileInputStream file1 = null;
	private static String filePath = null;
	private static Cell customeCell = null;

	// Constructor
	public ExcelFile() {
		// Set the file path to the Excel file
		filePath = (System.getProperty("user.dir") + "\\TestData\\PincodeExcel.xlsx");
		try {
			// Try to create a new FileInputStream object using the file path
			ExcelFile.file1 = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// If the file is not found, print the stack trace
			e.printStackTrace();
		}
	}

	// Static method to get data from an Excel file based on row and column indices
	public static TypeResult excelIndex(int r, int c) {
		// Create a new ExcelFile object to initialize the file input stream
		new ExcelFile();
		try {
			// Get the cell at the specified row and column indices from the "Sheet1" sheet of the Excel file
			customeCell = WorkbookFactory.create(file1).getSheet("Sheet1").getRow(r).getCell(c);
			// Get the cell type of the cell
			CellType cellType = customeCell.getCellType();
			switch (cellType) {
			// If the cell contains a numeric value, get the numeric value and return it
			case NUMERIC:
				double numericValue = customeCell.getNumericCellValue();
				System.out.println("numericValue = " + numericValue);
				file1.close();
				return new TypeResult(null, numericValue);
			// If the cell contains a string value, get the string value and return it
			case STRING:
				String stringValue = customeCell.getStringCellValue();
				System.out.println("stringValue = " + stringValue);
				file1.close();
				return new TypeResult(stringValue, 0);
			// If the cell is blank, return null
			case BLANK:
				file1.close();
				return new TypeResult(null, 0);
			// If the cell contains a boolean value, get the boolean value and return it
			case BOOLEAN:
				boolean boolValue = customeCell.getBooleanCellValue();
				file1.close();
				return new TypeResult(boolValue ? "true" : "false", 0);
			// For all other cell types, return null
			default:
				file1.close();
				return new TypeResult(null, 0);
			}
		} catch (EncryptedDocumentException e) {
			// If the workbook is encrypted and cannot be read, print the stack trace
			e.printStackTrace();
		} catch (IOException e) {
			// If there is an I/O exception, print the stack trace
			e.printStackTrace();
		}
		// If there is an error, return null
		return null;
	}

	public static void main(String[] args) {

		// Get the string value of the cell at row 0, column 0 and print it
		String demo22 = ExcelFile.excelIndex(0, 0).getStringValue();
		System.out.println("value of (0,0) index of excel file which is in String dataType is " + demo22);

		// Get the double value of the cell at row 1, column 1 and print it
		String demo23 = ExcelFile.excelIndex(1, 1).getDoubleValue();
		System.out.println("value of (1,1) index of excel file which is in Double dataType is " + demo23);

	}

}