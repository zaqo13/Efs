package com.efs.utility;

import org.apache.log4j.Logger;


/**
 * This class provides logging utilities using the Log4j library.
 */


public class Log {

	/** The logger instance. */
	public static Logger Log = Logger.getLogger(Log.class.getName());

	
	/**
	 * Logs a message indicating the start of a test case.
	 *
	 * @param sTestCaseName the name of the test case.
	 */
	public static void startTestCase(String sTestCaseName) {
		Log.info("=====================================" + sTestCaseName
				+ " TEST START=========================================");
	}

	public static void endTestCase(String sTestCaseName) {
		Log.info("=====================================" + sTestCaseName
				+ " TEST END=========================================");
	}

	
	
	/**
	 * Gets the stack trace element of the caller of the logging method.
	 *
	 * @return the stack trace element of the caller.
	 */
	private static StackTraceElement getCallerStackTraceElement() {
		
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // The first two elements of the stack trace are the Thread.getStackTrace() and this method, so we skip them.
		return stackTrace[2];
	}
	
	
	/**
	 * Logs an informational message with line number.
	 *
	 * @param message the message to log.
	 */
	public static void info(String message) {
		StackTraceElement caller = getCallerStackTraceElement();
		Log.info(caller.getLineNumber() + " - " + message);
	}
	

	public static void warn(String message) {
		StackTraceElement caller = getCallerStackTraceElement();
		Log.warn(caller.getLineNumber() + " - " + message);
	}

	public static void error(String message) {
		StackTraceElement caller = getCallerStackTraceElement();
		Log.error(caller.getLineNumber() + " - " + message);

	}

	public static void fatal(String message) {
		StackTraceElement caller = getCallerStackTraceElement();
		Log.fatal(caller.getLineNumber() + " - " + message);
	}

	public static void debug(String message) {
		StackTraceElement caller = getCallerStackTraceElement();
		Log.debug(caller.getLineNumber() + " - " + message);
	}

}
