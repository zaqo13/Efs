package com.efs.utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	
	// Wait for an element to become visible
	public WebElement waitForVisibilityOf(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	// Wait for an element attribute to contain the specified value
	public boolean waitForVisibilityOfAttributeContain(WebDriver driver, WebElement element, String attribute,
			String attrValue, int timeOut) {
		// this will search for the entered text which was send to webelement using
		// sendKeys
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.attributeContains(element, attribute, attrValue));
	}

	
	// Wait for an element to contain the specified text
	public boolean waitForTextToBePresentInWebElement(WebDriver driver, WebElement element, String textToBePresent,
			int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		boolean flag = wait.until(ExpectedConditions.textToBePresentInElement(element, textToBePresent));
		return flag;
	}

	
	// Wait for all elements in a list to become visible
	public List<WebElement> waitForVisibilityOfElements(WebDriver driver, List<WebElement> element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	

	/**
	 * Wait for an element to become clickable
	 *
	 * @param driver  WebDriver object
	 * @param element WebElement object to be clicked
	 * @param timeout Timeout in seconds
	 * @return WebElement object once it is clickable
	 * @throws Exception                       if any other exception occurs
	 * @throws TimeoutException                if the element is not clickable
	 *                                         within the specified timeout
	 * @throws StaleElementReferenceException  if the element is no longer attached
	 *                                         to the DOM
	 * @throws NoSuchElementException          if the element is not found in the
	 *                                         DOM
	 * @throws ElementNotInteractableException if the element is not in an
	 *                                         intractable state
	 */
	public WebElement waitForClickableElement(WebDriver driver, WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			System.err.println("Timeout waiting for element to be clickable: " + e.getMessage());
			throw e;
		} catch (StaleElementReferenceException e) {
			System.err.println("Element is no longer attached to the DOM: " + e.getMessage());
			throw e;
		} catch (NoSuchElementException e) {
			System.err.println("Element not found in the DOM: " + e.getMessage());
			throw e;
		} catch (ElementNotInteractableException e) {
			System.err.println("Element is not in an interactable state: " + e.getMessage());
			throw e;
		} catch (Exception e) {
			System.err.println("Error occurred while waiting for element to be clickable: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * Wait for an element to become stale (detached from the DOM)
	 * 
	 * @param driver  WebDriver instance
	 * @param element WebElement to wait for staleness of
	 * @param timeout Maximum time to wait for staleness of the element, in seconds
	 * @return true if the element becomes stale within the given timeout, false
	 *         otherwise
	 */
	public boolean waitForStalenessOf(WebDriver driver, WebElement element, int timeout) {
		// Create WebDriverWait instance with the given timeout
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		try {
			// Wait for the element to become stale (detached from the DOM)
			return wait.until(ExpectedConditions.stalenessOf(element));
		} catch (TimeoutException e) {
			// If the element is not stale within the given timeout, log an error message
			// and return false
			System.err.println("Element did not become stale within the given timeout: " + e.getMessage());
			return false;
		} catch (StaleElementReferenceException e) {
			// If the element is already stale, log a warning message and return true
			System.out.println("Element is already stale: " + e.getMessage());
			return true;
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
	}
	

	// Wait for an element to become invisible
	public boolean waitForInvisibilityOf(WebDriver driver, WebElement element, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		boolean bool = false;
		try {
			bool = wait.until(ExpectedConditions.invisibilityOf(element));
			return bool;
		} catch (TimeoutException e) {
			return bool;
		}
	}

	
	public List<String> helperWebElementsToStringListForAttribute( List<WebElement> options, List<String> dataList){
	//take a list of WebElements then extract Attribute from them and put them into dataList and returning it!
	//options==List of WebElements,  daataList==List of Attribute's text grabbed from WebElements
			
			String actual = "";
			for(int i=0; i<options.size(); i++ ) {
				actual = options.get(i).getAttribute("value");
				dataList.add(actual);
				
			}return dataList;
		}
	
	
	
	// Wait for an element to be absent (not visible)
	public boolean waitUntilAbsenceOf(WebDriver driver, WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	
	// Move to an element using Actions
	public void actionsMoveTo(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	
	// Click an element using Actions
	public void actionsClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	
	// moveToElement and page_up key
	public void actionMoveToPageUp(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		actions.sendKeys(Keys.PAGE_UP).perform();
	}

	
	// Check if an element is displayed
	public boolean elementIsDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
		}
		return flag;
	}

	// Check if an element is displayed
//	public boolean elementIsDisplayed(WebDriver driver, WebElement ele) {
//		boolean flag = false;
//		flag = findElement(driver, ele);
//		if (flag) {
//			System.out.println("Element is displayed");
//			flag = true;
//		} else {
//			System.out.println("Element is not displayed");
//			flag = false;
//		}
//		return flag;
//	}
//	

	
	// Find element and return boolean value
	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			if (ele.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	// Check if an element is enabled
	public boolean elementIsEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			if (ele.isEnabled()) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	
	// Check if an element is selected
	public boolean elementIsSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			if (ele.isSelected()) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	
	// Enter text into a textBox
	public boolean enterText(WebDriver driver, WebElement ele, String text) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			ele.clear();
			ele.sendKeys(text);
			// System.out.println(text + " entered successfully");
			flag = true;
		} else {
			// System.out.println("Unable to enter text");
			flag = false;
		}
		return flag;
	}

	
	// Click on an element
	public boolean clickElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			ele.click();
			// System.out.println("Element clicked successfully");
			flag = true;
		} else {
			// System.out.println("Element not found");
			flag = false;
		}
		return flag;
	}

	
	// Get text from an element
	public String getText(WebDriver driver, WebElement ele) {
		try {
			findElement(driver, ele);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ele.getText();
	}

	
	// Get attribute value of an element
	public String getAttributeValue(WebDriver driver, WebElement ele, String attributeName) {
		try {
			findElement(driver, ele);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ele.getAttribute(attributeName);
	}

	
	// Wait until element is visible using Fluent Wait
	public WebElement fluentWaitForvisibilityOf(WebDriver driver, WebElement element, int timeout,
			int pollingEveryMili) {
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout)) // Max waiting																	
				.pollingEvery(Duration.ofMillis(pollingEveryMili)) // polling frequency
				.ignoring(NoSuchElementException.class); // condition

		WebElement ele12 = (WebElement) wait2.until(ExpectedConditions.visibilityOf(element));
		return ele12;
	}
	

	// Switch to an iframe
	public WebElement switchToIframe(WebDriver driver, WebElement element) {
		// switching to iframe
		driver.switchTo().frame(element);
		return element;
	}

	
	// Handle alert pop-up
	public Alert alertPopup(WebDriver driver) {
//		//Alert pop up handling == hidden division, alert, child pop up
		Alert alt = driver.switchTo().alert();
		return alt;
	}

	
	// Scroll to desire element using js
	public WebElement jsScrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}

	
	// Enter text using JavaScriptExecutor
	public WebElement jsSendTexts(WebDriver driver, String text, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].value='" + text + "';", element);
		return element;
	}

	
	// Click on an element using JavaScriptExecutor
	public WebElement jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		return element;
	}

	
	// Scroll the page by x and y pixels using JavaScriptExecutor
	public void scrollByPixel(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}

	
	// Check whether the page is fully loaded using JavaScriptExecutor
	public boolean isPageLoaded(WebDriver driver) {
		// In this code, JavascriptExecutor interface is used to check whether the page
		// is fully loaded by checking the readyState of the document object.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (Boolean) js.executeScript("return document.readyState").equals("complete");
//	    "loading": The page is still loading.
//	    "interactive": The page has been loaded and the DOM (Document Object Model) has been parsed, but resources such as images, stylesheets and scripts may still be loading.
//	    "complete": The page has been fully loaded, including all resources such as images, stylesheets and scripts.
	}
	
	
	// Open new tab and navigate to given url
	public void jsOpenNewTabAndNavigateTo(WebDriver driver, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + url + "', '_blank');");
	}

	
	// Get the current URL of the page
	public String currentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	
	// Select an option from a drop-down menu by visible text
	public void selectDropDownByVisibleText(WebElement element, String visibleText) {
		Select st = new Select(element);
		st.selectByVisibleText(visibleText);
	}

	
	// Select an option from a drop-down menu by index
	public void selectDropDownByIndex(WebElement element, int indexOfText) {
		Select st = new Select(element);
		st.selectByIndex(indexOfText);
	}

	
	// Select an option from a drop-down menu by value
	public void selectDropDownByValue(WebElement element, String value) {
		Select st = new Select(element);
		st.selectByValue(value);
	}

	
	// Get all options from a drop-down menu
	public List<WebElement> selectGetAvailableOptions(WebElement element) {
		Select st = new Select(element);
		return st.getOptions();
	}

	
	// Getting selected options using Select class
	public List<WebElement> selectGetSelectedOptions(WebElement element) {
		Select st = new Select(element);
		return st.getAllSelectedOptions();
	}

	
	// Getting first selected option using Select class
	public WebElement selectGetFirstSelectedOption(WebElement element) {
		Select st = new Select(element);
		return st.getFirstSelectedOption();
	}

	
	// Handling exception when an element is not present
	public void exceptionIsElementPresent() {
		try {

		} catch (NoSuchElementException e) {
		}
	}

	// If getting StaleElementReferenceException then this method to re-try again
	public WebElement waitForClickableRetryingAndFinding(WebDriver driver, WebElement element, int maxAttempts,
			int waitTimeout) {
		int attempts = 0;
		while (attempts < maxAttempts) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, waitTimeout);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return element;
	}

	
// if getting StaleElementReferenceException then this method to try and catch element again!
// extra method
//	public WebElement waitForClickableRetryingAndFinding(WebDriver driver, WebElement element) {
//	    int attempts = 0;
//	    while(attempts < 2) {
//	        try {
//	        	WebDriverWait wait = new WebDriverWait(driver, 10);
//	            wait.until(ExpectedConditions.elementToBeClickable(element));
//	            break;
//	        } catch(TimeoutException | NoSuchElementException | ElementNotInteractableException e) {
//	            throw e;
//	        } catch(StaleElementReferenceException e) {	
//	            }
//	        attempts++;
//	    }
//	    return element;
//	}

	
	
	// If getting StaleElementReferenceException then this method to re-try again and returning boolean result
	public boolean waitForClickableRetryingAndFindingBoolean(WebDriver driver, WebElement element) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	// Convert Yes or No to 1 or 0 respectively
	public String helperYesOrNoToDigit(String ToSelectOption) {
		// if 1 then Yes, if 0 then No

		if (ToSelectOption.equalsIgnoreCase("Yes")) {
			return "1";
		} else if (ToSelectOption.equalsIgnoreCase("No")) {
			return "0";
		}
		return null;
	}

	
	// Convert Yes or No to boolean True or False respectively
	public Boolean helperYesOrNoToTrueOrFalse(String radioElement) {

		if (radioElement == null) {
			return null;
		}

		if (radioElement.equalsIgnoreCase("Yes")) {
			return true;
		} else if (radioElement.equalsIgnoreCase("No")) {
			return false;
		} else {
			return null;
		}

	}

//	Helper Methods

	// Extracts text from each web element in the given list and adds it to the dataList
	public List<String> helperWebElementsToStringList(List<WebElement> options, List<String> dataList) {
		// take a list of WebElements then extract text from them and put them into dataList and returning it!
		// options==List of WebElements, daataList==List of text grabbed from WebElements

		String actual = "";
		for (int i = 0; i < options.size(); i++) {
			actual = options.get(i).getText();
			dataList.add(actual);
//			System.out.println("optionValue " + actual);
//			if (options.get(i).getText() != null) {
//				dataList.add(actual);
//			}
		}
		return dataList;
	}
	
	
//	or for above method
	
	/**
	 * Extracts the text from each WebElement in the given list and adds it to the
	 * provided List of Strings.
	 *
	 * @param options  the list of WebElements from which the text needs to be
	 *                 extracted
	 * @param dataList the List of Strings to which the extracted text needs to be
	 *                 added
	 * @return the updated List of Strings with the extracted text
	 */
	public List<String> extractTextFromWebElements(List<WebElement> options, List<String> dataList) {
		// Loop through the list of WebElements and extract their text content
		for (WebElement option : options) {
			String actual = option.getText();
			dataList.add(actual);
		}
		return dataList;
	}
	
	
	/**
	 * Extracts text from each web element in the given list and adds it to the
	 * dataList as Doubles.
	 * 
	 * @param options  the list of WebElements to extract text from
	 * @param dataList the list to add the extracted Double values to
	 * @return the updated dataList
	 */
	public List<Double> helperWebElementsToDoubleList(List<WebElement> options, List<Double> dataList) {
		String actual = "";
		for (int i = 0; i < options.size(); i++) {
			actual = options.get(i).getText();
			dataList.add(Double.parseDouble(actual));
		}
		return dataList;
	}


	
	// Iterates through the list of suggestedOptions and compares each element with the given itemToSelect.
	// If there is a match, it sets the index to that element's index and returns the index. Otherwise, it returns -1.
	public int helperMatchIndexFordataAndListToArray(List<String> suggestedOptions, String[] dataAvailable, String iteamToSelect) {
		int index = -1;
		boolean flag = false;
		for (int i = 0; i < suggestedOptions.size(); i++) {
			dataAvailable[i] = suggestedOptions.get(i);
//			if (iteamToSelect.equalsIgnoreCase(suggestedOptions.get(i))) {
//				index = i;
//			}
			if (iteamToSelect.contentEquals(suggestedOptions.get(i))) {
				index = i;
				flag = true;
			}
		}
		if (flag == true) {
			return index;
		} else {
			return -1;
		}
	}
	
	
//	or for above method 
	
	/**
	 * Iterates through the list of suggested options and compares each element with
	 * the given item to select. If there is a match, it returns the index of that
	 * element. Otherwise, it returns -1.
	 * 
	 * 
	 * @param suggestedOptions List of suggested options to compare against
	 * @param dataAvailable    Array to store the elements from suggestedOptions
	 * @param itemToSelect     Item to find in the list of suggested options
	 * @return Index of the item to select if found, -1 otherwise
	 */
	public int findIndexInList(List<String> suggestedOptions, String[] dataAvailable, String itemToSelect) {
		int index = -1;
		boolean flagFound = false;

		// Populate the dataAvailable array with the elements from the suggestedOptions list
		for (int i = 0; i < suggestedOptions.size(); i++) {
			dataAvailable[i] = suggestedOptions.get(i);
		}

		// Compare each element in the suggestedOptions list with the given itemToSelect
		// If there is a match, set the index to that element's index and return the
		// index. Otherwise, return -1.
		for (int i = 0; i < suggestedOptions.size(); i++) {
			if (itemToSelect.contentEquals(suggestedOptions.get(i))) {
				index = i;
				flagFound = true;
				break;
			}
		}

		if (flagFound) {
			return index;
		} else {
			return -1;
		}
	}
	

	
	// Iterates through the list of suggestedOptions and compares each element with the given itemToSelect.
	// If there is a match, it sets the index to that element's index and returns the index. Otherwise, it returns -1.
	public int helperMatchIndexForDataToSearch(List<String> suggestedOptions, String iteamToSelect) {
		int index = -1;
		boolean flag = false;
		for (int i = 0; i < suggestedOptions.size(); i++) {
//			if (iteamToSelect.equalsIgnoreCase(suggestedOptions.get(i))) {
//				index = i;
//			}
			if (iteamToSelect.contentEquals(suggestedOptions.get(i))) {
				index = i;
				flag = true;
			}
		}
		if (flag == true) {
			return index;
		} else {
			return -1;
		}
	}

	
	
	// Takes in the size of the suggestedOptions, a list of suggestedOptions, an array to store dataAvailable, and an itemToSelect
	// Searches through the list of suggestedOptions to find the index of the itemToSelect, stores the dataAvailable into an array
	// Returns the index of the itemToSelect if found, -1 otherwise
	public int helperMatchIndexFordata(int suggestedOptionsSize, List<String> suggestedOptions, String[] dataAvailable, String iteamToSelect) {
		int index = -1;
		boolean flag = false;
		for (int i = 0; i < suggestedOptionsSize; i++) {
			dataAvailable[i] = suggestedOptions.get(i);
			if (iteamToSelect.equalsIgnoreCase(suggestedOptions.get(i))) {
				index = i;
				flag = true;
			}
		}
		if (flag) {
			return index;
		} else {
			return -1;
		}
	}

	
//RegEx validation!
	

	// This method checks if the string has exactly 10 characters
	// Typically used for validating mobile numbers, PAN numbers, TAN numbers, etc.
	public boolean helperFormat10ExactLength(String actualValue) {
		return (actualValue.length() == 10);
	}

	
	// This method checks if the string has exactly 15 characters
	// Typically used for validating GST identification numbers, etc.
	public boolean helperFormat15ExactLength(String actualValue) {
		return (actualValue.length() == 15);
	}

	
	
	// This method checks if the string has 10 characters
	// All characters must be in capital case, first and last characters must be capital and the
	// characters/digits in between must be in the format without any symbols.
	public boolean helperFormat10AllCapitalWithoutSymbolFirstLastChar(String actualValue) {
		// 10 char long length only, All capital char, first and last char is Capital
		// and in between char/digit and format is without any symbol.
		return (actualValue.matches("^[A-Z][A-Z0-9]{8}[A-Z]$"));		//^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}$
	}

	
	
	// This method checks if the string has 15 characters
	// The first 2 characters must be an integer, followed by 10 characters/digits,
	// then a single digit, the letter "Z", and finally a single character/digit.
	// Typically used for validating GST identification numbers, etc.
	public boolean helperFormat15Gst(String actualValue) {
		// first 2 digit int, next 10 char/digit, single digit, "Z", single digit/char
		return (actualValue.matches("[0-9]{2}[A-Z0-9]{10}[0-9]Z[0-9A-Z]"));				//	78ABCQQFG3456ZN
	}


	
	// This method checks if the string contains only integer or decimal numbers.
	public boolean helperFormatIntOrDecimalOnly(String actualValue) {
		// integer or decimal number only
		return (actualValue.matches("^[0-9]+[\\.]?[0-9]+"));
	}

	
	
	// This method checks if the first double value is less than or equal to the second double value.
	// It returns true if the condition is satisfied, otherwise returns false.
	public boolean helperFormatLessThanOrEqual(double actualValue, double compareValue) {
		// compare both values for Less than or Equal to format (<=)
		return actualValue <= compareValue;
	}

	
	
	// This method checks if the string contains only characters and is case insensitive.
	public boolean helperFormatOnlyCharCaseInsensitive(String actualValue) {
		// only character and case insensitive
		return (actualValue.matches("^[a-zA-Z]+$"));
	}




}
