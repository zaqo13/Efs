package com.efs.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * A utility class for working with Excel files.
 */

public class ExcelUtilityVr2 {
	// Get the data from excel file

	private static long originalValue;
	private static long longValue;
	private static String doubleToStringValue;
	private static String stringValue;

	/**
	 * Get the test data from an Excel file.
	 *
	 * @param fileName   the name of the Excel file to read
	 * @param indexSheet the index of the sheet within the Excel file to read
	 * @return a two-dimensional array of strings containing the test data
	 * @throws FileNotFoundException if the specified Excel file is not found
	 * 
	 */

	public static Object[][] getTestDataVr2(String fileName, int indexSheet) {
//	   	FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName+".xlsx");
//	    Workbook workbook = WorkbookFactory.create(inputStream);
//	    Sheet sheet = workbook.getSheetAt(1);
//	    Row headerRow = sheet.getRow(0);
//	    int columnIndex = -1;

		FileInputStream inputStream = null;

		// Open the excel file
		try {
			inputStream = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + fileName);
			// rest of the code
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
			throw new RuntimeException(e);
		}

		try {
			// Get the workbook instance for the excel file
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Get the sheet from the workbook
			Sheet sheet = workbook.getSheetAt(indexSheet);

			// Get the number of rows in the sheet
			int rowCount = sheet.getLastRowNum();

			// Get the number of columns in the sheet
			int columnCount = sheet.getRow(0).getLastCellNum();

			// Create a 2D array to store the test data
			String[][] data = new String[rowCount][columnCount];

			// Iterate over the rows in the sheet
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {

				// i+1 == test data starts from 2nd row from excel sheet i.e. 1st index thats
				// why 0+1 by default;
				Row row = sheet.getRow(rowIndex + 1);
				for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {

					// j=0 becoz test data starts from 1st column from excel sheet i.e. 0th index
					// thats why 0 by default;
					Cell cell = row.getCell(columnIndex);
//		            	System.out.println("value of cell = row.getCell(j) == "+cell);

//		            	 if(cell == null) {
//		 	                fis.close();
//		 	                return null;
//		 	            }
					if (cell != null) {

						CellType cellType = cell.getCellType();

						// (whole numbers, fractional numbers, dates)
						if (cellType == CellType.NUMERIC) {

							double numericValue = cell.getNumericCellValue();
							// Do something with numeric value
//			            	System.out.println("numericValue  ==  "+numericValue);

//			            	originalValue = (long) Math.round(numericValue);
//			        	    System.out.println("originalValue  == "+originalValue);

//			        	    String doubleToStringValue = Double.toString(numericValue);
//			        	    System.out.println("doubleToStringValue == "+doubleToStringValue);

//			        	    longValue = (long)numericValue;//1.0
//			        	    System.out.println("longValue == "+longValue);

// why convert all to string becoz the range of NUMERIC values in test data is 
//beyond int range comes in long so its better to just convert single long than to use long dataType

							stringValue = String.format("%.2f", numericValue);
							data[rowIndex][columnIndex] = stringValue;

						} else if (cellType == CellType.STRING) {

							String stringValue = cell.getStringCellValue();
//			            	System.out.println("  stringValue  ==  "+stringValue);
							data[rowIndex][columnIndex] = stringValue;

//			            	} else if(cellType == null) {
//			                	data[i][j] = null;

						} else if (cell.getCellType() == CellType.BLANK) {

							data[rowIndex][columnIndex] = "";
						}
					}
				}
//		            System.out.println("value of rows == "+rowIndex+" and columns are = "+columnIndex);		
			}

			return data;
		} catch (IOException e) {
			throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException("Error closing file input stream: " + e.getMessage(), e);
			}
		}
	}
}

//or for above (if/switch)	            	

//	            	switch(cellType) {
//	            	case NUMERIC:
//	            		double numericValue = cell.getNumericCellValue();
//	        	    	longValue = (long)numericValue;//1.0
//	        	    	stringValue = Long.toString(longValue);
//	        	    	data[i][j] = stringValue;
//	            	
//	            	case STRING:
//	            		String stringValue = cell.getStringCellValue();
//	            	    data[i][j] = stringValue;
//	            		
//	            	case BLANK:
//	            		data[i][j] = null;
//					case BOOLEAN:
//						break;
//					case ERROR:
//						break;
//					case FORMULA:
//						break;
//					case _NONE:	
//						break;
//					default:
//						break;
//	            	}		            	
//	            }
////	            System.out.println("value of rows == "+i+" and columns are = "+j);
//	        }
//	    	fis.close();
//	        return data;
//	    }
//	}
//
// 
//
// using Result class which acts as a POJO(Plain Old Java Object) to store and transfer the results of the Excel search operation.
//			
//	                
//	                if(cell == null) {
//	                	fis.close();
//		                return new Result(null, 0);
//		            }
//		            CellType cellType = cell.getCellType();
////		            CellType cellType = cell.getCellTypeEnum();
//		            switch(cellType) {
//		                case NUMERIC:
//		                    double numericValue = cell.getNumericCellValue();
//		                    inputStream.close();
//		                    return new Result(null, (long)numericValue);
//		                case STRING:
//		                    String stringValue = cell.getStringCellValue();
//		                    inputStream.close();
//		                    return new Result(stringValue, 0);
//	  	                case BOOLEAN:
//		                    boolean booleanValue = cell.getBooleanCellValue();
//		                    inputStream.close();
//		                    return new Result( booleanValue ? "true" : "false",0);
//		                case BLANK:
//		                    inputStream.close();
//		                    return new Result(null, 0);
//		                case ERROR:
//		                    inputStream.close();
//		                    return new Result(null, 0);
//		                default:
//		                    inputStream.close();
//		                    return new Result(null, 0);
//		            }
//		        }
