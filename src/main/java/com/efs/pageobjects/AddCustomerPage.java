 package com.efs.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.efs.utility.Utility;

public class AddCustomerPage {
	
	
	@FindAll({@FindBy(xpath = "//input[@name='customer_type']")})
	private List<WebElement> MainCustomerTypeOptions;
	
	@FindAll({@FindBy(xpath = "//input[@name='customer_type']//following-sibling::span")})
	private List<WebElement> MainCustomerTypeOptionsText;
	
	@FindBy(xpath = "//input[@name='customer_type'][last()]")
	private WebElement LastMainCustomerType;
	
	@FindBy(xpath = "//label[contains(text(),'Customer Name')]//preceding-sibling::input")
	private WebElement CustomerName;
	
	@FindBy(xpath = "//select[@name= 'customer_category']")
	private WebElement CustomerTypeDropdown;
	
	@FindBy(xpath = "//label[contains(text(),'Contact Person Name')]//preceding-sibling::input")
	private WebElement ContactPersonName;

	@FindBy(xpath = "//label[contains(text(),'Mobile Number')]//preceding-sibling::input")
	private WebElement MobileNumber;
	
	@FindBy(xpath = "//label[contains(text(),'Telephone')]//preceding-sibling::input")
	private WebElement Telephone;
	
	@FindBy(xpath = "//label[contains(text(),'Email')]//preceding-sibling::input")
	private WebElement Email;
	
	@FindBy(xpath = "//label[contains(text(),'Pan Number')]//preceding-sibling::input")
	private WebElement PanNumber;
	
	@FindBy(xpath = "//label[contains(text(),'Tan Number')]//preceding-sibling::input")
	private WebElement TanNumber;
	
	@FindBy(xpath = "//label[contains(text(),'Gst Number')]//preceding-sibling::input")
	private WebElement GstNumber;
	
	@FindBy(xpath ="//span[@aria-labelledby='select2-city-container']")
	private WebElement CityDropdown;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement CitySearch;
	
	@FindAll({@FindBy(xpath = "//span//span//span//ul/li")})
	private List<WebElement> CitySearchOptions;
	//span[@class='select2-results']/ul/li
	
	@FindBy(xpath = "//span[@class='select2-results']/ul/li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement LastCitySearchOptions;
	
	@FindBy(xpath = "//label[contains(text(),'Customer Address')]//preceding-sibling::textarea")
	private WebElement CustomerAddress;
	
	@FindBy(xpath = "//label[text()='Description']//preceding-sibling::textarea")
	private WebElement Description;
	
	@FindAll({@FindBy(xpath ="//span[contains(text(),'Is Tax Exempted')]//following-sibling::input")})
	private List<WebElement> IsTaxExemptedOptions;  
	
	@FindAll({@FindBy(xpath ="//span[starts-with(text(),'Is Tax')]//following-sibling::input")})
	private List<WebElement> IsTaxExemptedOptionsDemo; 
	//span[contains(text(),'Is Tax Exempted')]//following-sibling::input[@value]
	//span[starts-with(text(),'Is Tax')]//following-sibling::input
	
	@FindAll({@FindBy(xpath = "//input[@value='3']//preceding-sibling::span//following-sibling::input")})
	private List<WebElement> CustomerTypeFromThreeOptions;
	
	@FindBy(xpath = "//input[@value='3']//preceding-sibling::input[@value='1']")
	private WebElement NormalCustomerType;
	
	@FindBy(xpath = "//input[@value='3']//preceding-sibling::input[@value='2']")
	private WebElement BranchCustomerType;
	
	@FindBy(xpath = "//span[contains(text(),'Customer Type')]//following-sibling::input[@value='3']")
	private WebElement CentralCustomerType;
	
	@FindBy(xpath = "//label[contains(text(),'Cr.Min Limit Amount')]//preceding-sibling::input")
	private WebElement MinLimitAmount;
	
	@FindBy(xpath = "//label[contains(text(),'Cr.Max Limit Amount')]//preceding-sibling::input")
	private WebElement MaxLimitAmount;
	
	@FindBy(xpath = "//label[contains(text(),'Cr.Period(No of Days)')]//preceding-sibling::input")
	private WebElement Period1NoOfDays;
	
	@FindBy(xpath = "//label[contains(text(),'Cr.Period2(No of Days)')]//preceding-sibling::input")
	private WebElement Period2NoOfDays;
	
	@FindBy(xpath = "//label[contains(text(),'Billing Address')]//preceding-sibling::textarea")
	private WebElement BillingAddress;
	
	@FindBy(xpath = "//select[@id='payment_type']//following-sibling::span//span[@class='selection']")
	private WebElement PaymentTypeDropdown;
	
	@FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']/input")
	private WebElement PaymentTypeSearch;
	
	@FindBy(xpath = "//span[@class='select2-results']/ul/li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement HighlightedPaymentOption;
	
	@FindAll({@FindBy(xpath = "//span[@class='select2-results']/ul/li")})
	private List<WebElement> PaymentTypeOptions;
	
	@FindBy(xpath = "//select[@name='billing_schedule']")
	private WebElement BillingScheduleDropdown;
	
	@FindBy(xpath = "//select[@name='billing_format']")
	private WebElement BillingFormatDropdown;
	
	@FindBy(xpath = "//select[@id='sales_user_id']//following-sibling::span/span")
	private WebElement SalesEmployeeDropdown;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement SalesEmployeeSearch;
	
	@FindAll({@FindBy(xpath = "//span[@class='select2-results']//ul//li")})
	private List<WebElement> SalesEmployeeOptions;
	
	@FindBy(xpath = "//span//ul//li[@class= 'select2-results__option select2-results__option--highlighted']")
	private WebElement HighLightedSalesEmployeeOption;
	
	@FindBy(xpath = "//select[@id='account_user_id']//following-sibling::span")
	private WebElement AccountEmployeeDropdown;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement AccountEmployeeSearch;
	
	@FindAll({@FindBy(xpath = "//span[@class='select2-results']//ul//li")})
	private List<WebElement> AccountEmployeeOptions;
	
	@FindBy(xpath = "//span//ul//li[@class= 'select2-results__option select2-results__option--highlighted']")
	private WebElement HighLightedAccountEmployeeOption;
	
	@FindBy(xpath = "//select[@id='operational_user_id']//following-sibling::span")
	private WebElement OperationalEmployeeDropdown;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement OperationalEmployeeSearch;
	
	@FindAll({@FindBy(xpath = "//span[@class='select2-results']//ul//li")})
	private List<WebElement> OperationalEmployeeOptions;
	
	@FindBy(xpath = "//span//ul//li[@class= 'select2-results__option select2-results__option--highlighted']")
	private WebElement HighLightedOperationaltEmployeeOption;
	
	@FindBy(xpath = "//select[@id='customer_support_user_id']//following-sibling::span")
	private WebElement CustomerSupportDropdown;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement CustomerSupportSearch;
	
	@FindAll({@FindBy(xpath = "//span[@class='select2-results']//ul//li")})
	private List<WebElement> CustomerSupportOptions;
	
	@FindBy(xpath = "//span//ul//li[@class= 'select2-results__option select2-results__option--highlighted']")
	private WebElement HighLightedCustomerSupportOption;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Submit;
	
	@FindAll({@FindBy(xpath = "//div[@role='tooltip']")})
	private List<WebElement> TooltipOptions;
	
	@FindBy(xpath = "//div[@role='tooltip'][last()]")
	private WebElement LastTooltip;
	
	@FindBy(xpath = "//ul[@class='select2-results__options']//li[contains(text(),'No results found')]")
	private WebElement NoResultFoundForCity;
	
	@FindBy(xpath = "//li[@role='treeitem'][1][not(contains(text(),'Searching…'))]")
	private WebElement CommonCitySearchHint;
	
	@FindBy(xpath = "//div/input[@name='pan_number']/following-sibling::span[@style='visibility: visible;']")
	private WebElement PanInvalidData;
	
	@FindBy(xpath = "//div/input[@name='tan_number']/following-sibling::span[@style='visibility: visible;']")
	private WebElement TanInvalidData;
	
	@FindBy(xpath = "//div/input[@name='gst_number']/following-sibling::span[@style='visibility: visible;']")
	private WebElement GstInvalidData;
	
	@FindAll({@FindBy(xpath = "//div/input/following-sibling::span[@style='visibility: visible;']")})
	private List<WebElement> OptionsInvalidData;
	
	@FindBy(xpath = "(//div/label/span)[1]")
	private WebElement DummyClick;

//sample xpath //span[contains(text(),'Yes')]//preceding-sibling::b[starts-with(text(),'Pickup')]
	
	
	

	
	
	private WebDriver driver;
	private Utility util;
	
	public List<String> MainCustomerTypeList;
	public List<String> CustomertypeList;
	public List <WebElement> op;
	public List<String> CitySearchList;
	public List<String> demoList;
	public List<String> IsTaxExemptedList;
	public List<String> CustomerTypeFromThreeList;
	public List<String> PaymentTypeList;
	private List<WebElement> BillingScheduleOptions;
	public  List<String> BillingScheduleList;
	public List<String> BillingFormatList;
	public List<String> SalesEmployeeList;
	public List<String> AccountEmployeeList;
	public List<String> OperationalEmployeeList;
	public List<String> CustomerSupportList;
	public List<String> ToolTipList;
	public List<String> ErrorTipList;
	
	public AddCustomerPage(WebDriver driver, Utility util) {
		
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	
		
	

//Customer Type Main
	public List<String> availableMainCustomerType() {
		util.waitForVisibilityOfElements(driver, MainCustomerTypeOptionsText, 10);
		util.waitForVisibilityOf(driver, LastMainCustomerType, 10);
		
		MainCustomerTypeList = new ArrayList<String>();
		
		return util.helperWebElementsToStringList(MainCustomerTypeOptionsText, MainCustomerTypeList);
	}
	
	public void selectMainCustomerType(int MainCustomerTypeIndex) {
		MainCustomerTypeOptions.get(MainCustomerTypeIndex).click();
	}
	

//Customer Name
	public void typeCustomerName(String customerName) {
		util.waitForVisibilityOf(driver, CustomerName, 10).sendKeys(customerName);
	}
	
	
	
//Customer Type
	
	public void clickOnCustomerTypeDropdown() {
		util.waitForVisibilityOf(driver, CustomerTypeDropdown, 10).click();
	}
	
	public void selectCustomerType(String customerType) {
		util.selectDropDownByVisibleText(CustomerTypeDropdown, customerType);
	}
	
	public List<String>  availableCustomertype () {
		
		op = util.selectGetAvailableOptions(CustomerTypeDropdown);
		CustomertypeList = new ArrayList<String>();			
		return util.helperWebElementsToStringList(op,CustomertypeList ); 	
	}	
	
	
	
//Contact Person Info
	public void typeContactPersonName(String contactPersonName) {
		util.waitForVisibilityOf(driver, ContactPersonName, 10).sendKeys(contactPersonName);
		
	}
	
	public void typeMobileNumber(String mobileNumber) {
	}
	
	
	public void typeTelephone(String telephone) {
	}
	
	
	public void typeEmail(String email) {
	}
	
	
	public void typePanNumber(String panNumber) {
	}
	
	
	public boolean isPanNumberInvalid() {
		try {
			boolean flagIsValid = util.elementIsDisplayed(driver, PanInvalidData);
			return flagIsValid;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public String availablePanErrorTip() {
		return util.waitForVisibilityOf(driver, PanInvalidData, 10).getText();
	}
	
	
	
	public String getPanNumberValue() {
		return util.waitForVisibilityOf(driver, PanNumber, 10).getAttribute("value");
	}
	
	public void typeTanNumber(String tanNumber) {
	}
	
	
	public boolean isTanNumberInvalid() {
	}
	
	
	public String availableTanErrorTip(){
	}
	
	
	
	public void typeGstNumber(String gstNumber) {
	}
	
	
	public boolean isGstInvalid() {
	}
	
	
	public String avaiableGstErrorTip() {
		
	}
	
	
	
	public void clickOnCityDropdown() {
	}
	
	
	public void typeCity(String city) {
	}
	
	
	public boolean isCityNotFoundDemo()  {
//		extra method (included new methods related to this in Utility class)
		
//		Thread.sleep(5000);
//		boolean demo99 = util.findElement(driver, NoResultFoundForCity);		//these two combination is working correctly but i dont have to use thread.sleep so below methods created
//		return demo99;
		
//		String demo34 = util.waitForVisibilityOf(driver, CitySearch, 10).getAttribute("value");	//this will return the entered value(using sendKeys) in the <input (text) tag in DOM structure
//		System.out.print("Entred value for city is "+demo34);

//		boolean flag33 = util.waitForVisibilityOfAttributeContain(driver, CitySearch, "type", "search" ,10);
////	System.out.println(" flag33- CitySearch <input tag must contain 'type' attribute and its value as 'search' == "+flag33);
//
//		boolean flag44=false;
//		flag44 = util.waitForTextToBePresentInWebElement(driver, CommonCitySearchHint, "Nashik", 10 );
//	    System.out.println(" flag44- if given webelement contains the the provided text then its returns true == "+flag44);
//		return flag44;
		return false;
	}
	
	
	public String isCityNotFound() {
		return util.waitForVisibilityOf(driver, CommonCitySearchHint, 10).getText();	
	}
	
	
	
	public List<String> availableCitySearch() {
		util.waitForClickableElement(driver, LastCitySearchOptions, 10);
		util.waitForVisibilityOfElements(driver, CitySearchOptions, 10);
		CitySearchList = new ArrayList <String>();
		
		return util.helperWebElementsToStringList(CitySearchOptions, CitySearchList);
	}
	
	
	public void selectCity(int cityIndex) {
//		util.waitForVisibilityOf(driver, LastCitySearchOptions, 10);
//		util.waitForVisibilityOfElements(driver, CitySearchOptions, 10).get(cityIndex).click();
//		util.waitForClickable(driver, CitySearchOptions.get(cityIndex), 10).click();
//		all above method to call for clicking webElement is not needed as the List of Webelements are already found out! 
		CitySearchOptions.get(cityIndex).click();
	}
	
	
	
//Customer Address
	public void typeCustomerAddress(String customerAddress) {
	}
	
	
//Description
	public void typeDescription(String description) {
	}
	
	
//Is Tax Exempted 
	public List<String> availableIsTaxExemptedOptions(){
		util.waitForVisibilityOfElements(driver, IsTaxExemptedOptionsDemo, 10);
		IsTaxExemptedList = new ArrayList<String>();
		return util.helperWebElementsToStringListForAttribute(IsTaxExemptedOptions, IsTaxExemptedList);
	}
	
	
	public void selectIsTaxExempted(int indextIsTaxExempted) {
		IsTaxExemptedOptions.get(indextIsTaxExempted).click();
	}
	

//Customer Type (demo2)
	public void selectCustomerTypeUsingSwitch(int customerTypeToselect) {
		
		switch(customerTypeToselect){
		case 1 : util.waitForVisibilityOf(driver, NormalCustomerType, 10).click();
			break;
		case 2 : util.waitForVisibilityOf(driver, BranchCustomerType, 10).click();
			break;
		case 3 : util.waitForVisibilityOf(driver, CentralCustomerType, 10).click();
			
		}
		
	}

//Customer Type (demo1)
	public List<String> availableCustomerTypeFromThree(){
	}
	
	
	public void selectCustomerTypeFromThreeDemo2(int CustomerTypeFromThreeToSelect) {
	}
	
	
	
//Min Limit Amount
	public void typeMinLimitAmount(String minLimitAmount) {
		util.waitForVisibilityOf(driver, MinLimitAmount, 10).sendKeys(String.valueOf(minLimitAmount));
	}	
	
	
	
//Max Limit Amount
	public void typeMaxLimitAmount(String maxLimitAmount) {
	}
	
	
//Period 1 No Of Days	
	public void typePeriod1NoOfDays	(String period1NoOfDays	) {
	}
	
	
	
//Period 2 No Of Days type
	public void typePeriod2NoOfDays	(String period2NoOfDays	) {
	}
	
	
	
//Billing Address type
	public void typeBillingAddress	(String billingAddress	) {
	}
	
	

	
//Payment Type
	public void clickOnPaymentTypeDropdown() {
	}
	
	
	public void typePaymentType(String paymentType) {
	}

	
	public List<String> availablePaymentType(){
	}
	
	public void selectPaymentType(int paymenttypeIndex) {
	}
	
	
	
//Billing Schedule Dropdown 	
	public void clickOnBillingScheduleDropdown() {
		util.waitForVisibilityOf(driver, BillingScheduleDropdown, 10).click();
	}
	
	
	public List<String> availableBillingSchedule(){
		BillingScheduleOptions =util.selectGetAvailableOptions(BillingScheduleDropdown);	
		BillingScheduleList = new ArrayList<String>();
		return util.helperWebElementsToStringList(BillingScheduleOptions, BillingScheduleList);
	}
	
	
	public void selectBillingSchedule(String billingScheduleToSelect) {
		util.selectDropDownByVisibleText(BillingScheduleDropdown, billingScheduleToSelect);
	}
	
	
	
	
//Billing Format Dropdown	
	public void clickOnBillingFormatDropdown() {
	}
	
	
	public List<String> availableBillingFormat(){
	}
	
	
	public void selectBillingFormat(String billingFormatToSelect) {
	}
	
	
	
	
//Sales Employee Dropdown	
	public void  clickOnSalesEmployeeDropdown() {
		util.waitForVisibilityOf(driver, SalesEmployeeDropdown, 10).click();
	}
	
	public void typeSalesEmployee(String salesEmployeeToSelect) {
		util.waitForVisibilityOf(driver, SalesEmployeeSearch, 10).sendKeys(salesEmployeeToSelect);
	}
	
	public List<String> avaliableSalesEmployee() {
		util.waitForVisibilityOf(driver, HighLightedSalesEmployeeOption, 10);
		util.waitForVisibilityOfElements(driver, SalesEmployeeOptions, 10);
		
		SalesEmployeeList = new ArrayList<String>();
		
		return util.helperWebElementsToStringList(SalesEmployeeOptions, SalesEmployeeList);
	}
	
	public void selectSalesEmployee(int salesEmployeeToSelect) {
		SalesEmployeeOptions.get(salesEmployeeToSelect).click();
	}
	
	
	
//Account Employee Dropdown	
	public void  clickOnAccountEmployeeDropdown() {
	}
	
	public void typeAccountEmployee(String accountEmployeeToSelect) {
	}
	
	public List<String> avaliableAccountEmployee() {
	}
	
	public void selectAccountEmployee(int accountEmployeeToSelect) {
	}	
	
	
	
//Operational Employee Dropdown	
	public void  clickOnOperationalEmployeeDropdown() {
	}
		
	public void typeOperationalEmployee(String operationalEmployeeToSelect) {
	}
		
	public List<String> avaliableOperationalEmployee() {
	}
		
	public void selectOperationalEmployee(int operationalEmployeeToSelect) {
	}

	
	
	
	
//Customer Support Dropdown
	public void  clickOnCustomerSupportDropdown() {
	}
			
	public void typeCustomerSupport(String customerSupportToSelect) {
	}
			
	public List<String> avaliableCustomerSupport() {
	}
			
	public void selectCustomerSupport(int customerSupportToSelect) {
	}	
	
	
	
	public boolean isTooltipAvailable() {
//		//extra method
		try{
			boolean bool = util.elementIsDisplayed(driver, LastTooltip);
			return bool;
		}catch(Exception e) {
			return false;
		}
		
//		//or for above method  //still in progress
//		try{
//		    if(util.elementIsDisplayed(driver, LastTooltip)) {
//		        System.out.println("Element is present and displayed");
//		        return true;
//		    }
//		    else {
//		        System.out.println("Element is present but not displayed"); 
//		        return true;
//		    }
//		}catch (NoSuchElementException e) {
//		    	System.out.println("Element is not present, hence not displayed as well");
//		    	return false;
//		}
		
	}
	
	
	
	public List<String> availableToolTip() {
		util.waitForVisibilityOfElements(driver, TooltipOptions, 10);
		
		ToolTipList = new ArrayList<String>();
		
		return util.helperWebElementsToStringList(TooltipOptions, ToolTipList);
	}
	
	
//Submit
	public void clickOnSubmit() {
		util.waitForClickableElement(driver, Submit, 10).submit();
//		util.waitForVisibilityOf(driver, Submit, 10).click();
	}
	
	
	public boolean untilSubmitIsGone() {
		//still in progress
		
//		boolean submitFlag = util.waitForStalenessOf(driver, Submit, 5);
//		boolean submitFlag = util.waitForInvisibilityOf(driver, Submit, 30);
//		boolean sub2Flag = util.elementIsDisplayed(driver, Submit);
//		boolean sub3Flag = util.findElement(driver, Submit);
		
//		try {
//			util.waitForStalenessOf(driver, Submit, 10);
//			return true;
//		}catch(TimeoutException e){
//			return false;
//		}
//		
		try {
			util.waitUntilAbsenceOf(driver, Submit, 10);
			return true;
		}catch(TimeoutException e) {
			return false;
		}
		

	}

	
	public boolean isSubmitButtonGone() {
		
		return util.waitUntilAbsenceOf(driver, Submit, 10);
	}
	
	


	

	
	
	
	
	
	
	
	
	
	
}
