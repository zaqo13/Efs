package com.efs.utility;

/**
 *
 * TypeResult is a utility class that encapsulates a string value and a double
 * value with two decimal points precision.
 *
 */

public class TypeResult {

	private String stringValue;
	private double doubleValue;

	/**
	 * 
	 * Constructs a new TypeResult object with the given string value and double value.
	 * 
	 * @param stringValue  The string value of the result from excel file.
	 * @param numericValue The double value of the result with two decimal points precision 
	 * 					   from excel file.
	 */

	public TypeResult(String stringValue, double numericValue) {
		this.doubleValue = numericValue;
		this.stringValue = stringValue;
	}

	public String getStringValue() {

		return stringValue;
	}

	public String getDoubleValue() {

		return String.format("%.2f", doubleValue);
	}

}
