package com.efs.utility;

/**
 *
 * The Result class represents the result of a search operation in an Excel
 * file. It contains both a string and a numeric value, which correspond to the
 * value of the first cell in a column that matches the search header, and its
 * row number, respectively.
 *
 */

public class Result {

	private String stringValue;
	private double doubleValue;
	private long longValue;

	/**
	 * Creates a new Result object with the specified string and numeric values.
	 *
	 * @param stringValue  the string value of the first cell in a column that
	 *                     matches the search header
	 * @param numericValue the numeric value of the first cell in a column that
	 *                     matches the search header
	 */

	public Result(String stringValue, double numericValue) {
		this.stringValue = stringValue;
		this.doubleValue = numericValue;
	}

	/**
	 * Returns the string value
	 *
	 * @return the string value
	 */

	
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * Returns the long value of the first cell in a column that matches the search
	 * header, rounded to the nearest integer.
	 *
	 * @return the long value of the first cell in a column that matches the search
	 *         header
	 */

	
	public String getlongValue() {

		longValue = (long) doubleValue; // 1.0

		stringValue = Long.toString(longValue);
		return stringValue;
	}
}