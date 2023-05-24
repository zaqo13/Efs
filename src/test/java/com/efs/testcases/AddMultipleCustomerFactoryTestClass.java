package com.efs.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.efs.base.BaseClass_self;
import com.efs.pageobjects.AddCustomerPage;
import com.efs.pageobjects.CustomerPage;
import com.efs.pageobjects.DashboardPage;
import com.efs.pageobjects.LoginPage;
import com.efs.utility.ExcelSet;
import com.efs.utility.ExcelUtilityVr2;
import com.efs.utility.Log;

public class AddMultipleCustomerFactoryTestClass extends BaseClass_self {
	// if cx created successfully then where it saved its index location is given to Log
	// if cx is not created then what are the Tooltips available are displayed and
	// if tooltip is not displayed, still page go forward to cx profile page then it
	// finding the the cx & not found then showing at Log that cx not created and
	// tooltip not displayed
	// whatever webelement in List<String> type we get from PageObject is
	// consider/writen as suggested
	// whatever webelement in String[] type we get from TestClass is
	// consider/writen as available

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private CustomerPage customerPage;
	private AddCustomerPage addCustomerPage;

	private int index = -1;

	private List<String> suggestedMainCustomerType;
	private String[] mainCustomerTypeAvailable;
	public int mainCustomerTypeIndex;

	private List<String> suggestedCustomer;
	private String[] customerAvailable;

	private List<String> suggestedCitySearch;
	private String[] cityAvailable;
	public int addCustomer_CityIndex;

	private List<String> suggestedIsTaxExempted;
	private String[] isTaxExemptedAvailable;
	public int addCustomer_isTaxExemptedIndex;

	private List<String> suggestedCustomerTypeFromThree;
	private String[] customerTypeFromThreeAvailable;
	public int addCustomer_CustomerTypeFromThree;

	private List<String> suggestedPaymentType;
	private String[] paymentTypeAvailable;
	public int addCustomer_paymentTypeIndex;

	private List<String> suggestedBillingSchedule;
	private String[] billingScheduleAvailable;
	// public int addCustomer_billingScheduleIndex;

	private List<String> suggestedBillingFormat;
	private String[] billingFormatAvailable;
	// public int addCustomer_billingFormatIndex;

	private List<String> suggestedSalesEmployee;
	private String[] salesEmployeeAvailable;
	public int addCustomer_salesEmployeeIndex;

	private List<String> suggestedAccountEmployee;
	private String[] accountEmployeeAvailable;
	public int addCustomer_accountEmployeeIndex;

	private List<String> suggestedOperationalEmployee;
	private String[] operationalEmployeeAvailable;
	public int addCustomer_operationalEmployeeIndex;

	private List<String> suggestedCustomerSupport;
	private String[] customerSupportAvailable;
	public int addCustomer_customerSupportIndex;

	List<String> suggestedToolTip;
	String[] ToolTipavailable;

	List<String> suggestedErrorTip;

	private String currentContact;
	private List<String> dataError2;
	private int IndexCurrentRow;
	private static int ExcelSheetNumber = 0;

	private String MainCustomerType, CustomerName, CustomerType, ContactPersonName, MobileNumber, Telephone, Email,
			PanNumber, TanNumber, GstNumber, City, CustomerAddress, Description, IsTaxExempted, CustomerTypeFromThree,
			CreditMinLimitAmount, CreditMaxLimitAmount, CreditPeriod1NoOfDays, CreditPeriod2NoOfDays, BillingAddress,
			PaymentType, BillingSchedule, BillingFormat, SalesEmployess, AccountEmployess, OperationalEmployess,
			CustomerSupport, ContactToFind;

	@Factory
	public static Object[] factoryMethodAddCux() {

		String[][] excelData = null;
		excelData = (String[][]) ExcelUtilityVr2.getTestDataVr2("AddCustomerFactory.xlsx", ExcelSheetNumber);
		Object[] testInstance = new Object[excelData.length];
		for (int i = 0; i < excelData.length; i++) {

			testInstance[i] = new AddMultipleCustomerFactoryTestClass(excelData[i][0], excelData[i][1], excelData[i][2],
					excelData[i][3], excelData[i][4], excelData[i][5], excelData[i][6], excelData[i][7],
					excelData[i][8], excelData[i][9], excelData[i][10], excelData[i][11], excelData[i][12],
					excelData[i][13], excelData[i][14], excelData[i][15], excelData[i][16], excelData[i][17],
					excelData[i][18], excelData[i][19], excelData[i][20], excelData[i][21], excelData[i][22],
					excelData[i][23], excelData[i][24], excelData[i][25], excelData[i][26], excelData[i][27], i);
		}
		return testInstance;
	}

	public AddMultipleCustomerFactoryTestClass(String MainCustomerType, String CustomerName, String CustomerType,
			String ContactPersonName, String MobileNumber, String Telephone, String Email, String PanNumber,
			String TanNumber, String GstNumber, String City, String CustomerAddress, String Description,
			String IsTaxExempted, String CustomerTypeFromThree, String CreditMinLimitAmount,
			String CreditMaxLimitAmount, String CreditPeriod1NoOfDays, String CreditPeriod2NoOfDays,
			String BillingAddress, String PaymentType, String BillingSchedule, String BillingFormat,
			String SalesEmployess, String AccountEmployess, String OperationalEmployess, String CustomerSupport,
			String ContactToFind, int IndexCurrentRow) {

		this.MainCustomerType = MainCustomerType;
		this.CustomerName = CustomerName;
		this.CustomerType = CustomerType;
		this.ContactPersonName = ContactPersonName;

		double number = Double.parseDouble(MobileNumber);
		this.MobileNumber = String.valueOf((long) number);

		double num2 = Double.parseDouble(Telephone);
		this.Telephone = String.valueOf((long) num2);

		this.Email = Email;
		this.PanNumber = PanNumber;
		this.TanNumber = TanNumber;
		this.GstNumber = GstNumber;
		this.City = City;
		this.CustomerAddress = CustomerAddress;
		this.Description = Description;

		this.IsTaxExempted = IsTaxExempted.replaceAll(".00", "");
		this.CustomerTypeFromThree = CustomerTypeFromThree.replace(".00", "");
		this.CreditMinLimitAmount = CreditMinLimitAmount;
		this.CreditMaxLimitAmount = CreditMaxLimitAmount;
		this.CreditPeriod1NoOfDays = CreditPeriod1NoOfDays.replace(".00", "");
		this.CreditPeriod2NoOfDays = CreditPeriod2NoOfDays.replace(".00", "");
		this.BillingAddress = BillingAddress;
		this.PaymentType = PaymentType;
		this.BillingSchedule = BillingSchedule;
		this.BillingFormat = BillingFormat;
		this.SalesEmployess = SalesEmployess;
		this.AccountEmployess = AccountEmployess;
		this.OperationalEmployess = OperationalEmployess;
		this.CustomerSupport = CustomerSupport;

		double contact = Double.parseDouble(ContactToFind);
		this.ContactToFind = String.valueOf((long) contact);
		this.IndexCurrentRow = IndexCurrentRow;
	}
	
	
//	It is important to note that you'll need to login and logout for each account being verified.
//	You can include the login code inside step01 and logout code inside @AfterClass 
//	This way, for each iteration, the test methods will use the expected values 
//	and finally @AfterClass will add the failed values to corresponding rows.

	@AfterClass(alwaysRun = true)
	public void resetApplicationLogout() {
		// To add failed testcase value to their corresponding row values!
		// and logout function to iterate the excel data row for multiple cux verification!

		String result = String.join(", ", dataError2);
		int indexCurrentRow = IndexCurrentRow + 1;
//		int indexCurrentColumn = 28;
//		ExcelSet.setExcelData(result, indexCurrentRow, ExcelSheetNumber, indexCurrentColumn);	// (dataToStore, currentRowNo, sheetNo, emptyColumnIndex)
		try {
			ExcelSet.setExcelData(result, indexCurrentRow, ExcelSheetNumber);			// (dataToStore, currentRowNo, SheetNo)
		} catch (IOException e) {
			throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
		}
		dashboardPage.clickOnLogout();
	}

	@Test(priority = 0, alwaysRun = true)
	public void step01loginTest() {
		Log.startTestCase("SuperAdmin Login");

		loginPage = new LoginPage(driver, util);

		loginPage.typeUserName(prop.getProperty("userName"));
		loginPage.typePassword(prop.getProperty("password"));
		Log.info("Username and Password entered ");
		loginPage.clickOnSubmit();

		dashboardPage = new DashboardPage(driver, util);

		boolean flag = dashboardPage.verifyLoggedInAs();
		Assert.assertTrue(flag, "User not logged In as Super admin");
		Log.info("Super admin logged In successfully");

		 Log.endTestCase("SuperAdmin Login");
	}

	@Test(alwaysRun = true, dependsOnMethods = { "step01loginTest" }, description = "going upto addCustomer page/link")
	public void step02UptoAddCux() {

		Log.startTestCase("Add Customer");

		dashboardPage.clickOnCustomers();
		Log.info("Customer module clicked");

		customerPage = new CustomerPage(driver, util);

		customerPage.clickOnAddCustomer();

		addCustomerPage = new AddCustomerPage(driver, util);

		dataError2 = new ArrayList<String>();

	}

	// Customer Type main
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test01MianCustomerType() {

		suggestedMainCustomerType = addCustomerPage.availableMainCustomerType();

		mainCustomerTypeAvailable = new String[suggestedMainCustomerType.size()];

		mainCustomerTypeIndex = util.helperMatchIndexFordataAndListToArray(suggestedMainCustomerType,
				mainCustomerTypeAvailable, MainCustomerType);

		Assert.assertNotEquals(-1, mainCustomerTypeIndex, " " + MainCustomerType + " is not found at website,");

		Log.info("Availabe Main Customer Type options are " + Arrays.toString(mainCustomerTypeAvailable));

		addCustomerPage.selectMainCustomerType(mainCustomerTypeIndex);

		Log.info("Selected " + MainCustomerType + " option for Customer type");
	}

	// Customer Name
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void tes02CustomerNmae() {

		addCustomerPage.typeCustomerName(CustomerName);
	}

	// Customer Type
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test03CustomerType() {

		addCustomerPage.clickOnCustomerTypeDropdown();
		addCustomerPage.selectCustomerType(CustomerType);

		suggestedCustomer = addCustomerPage.availableCustomertype();
		customerAvailable = suggestedCustomer.toArray(new String[0]);
		// customeravailable = addCustomerPage.availableCustomertype().toArray(new String[0]);

		Log.info("Available Customer type are " + Arrays.toString(customerAvailable));
	}

	// Contact Person Name
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test04ContactPersonName() {

	}

	// Mobile Number
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test05MobileNumber() {

	}

	// Telephone
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test06Telephone() {

	}

	// Email
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test07Email() {

	}

	// Pan Number
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test08PnaNumber() {
		addCustomerPage.typePanNumber(PanNumber);
		Log.info("Pan Number entered");

		boolean flagError = addCustomerPage.isPanNumberInvalid();

		if (flagError) {

			String errorTip = addCustomerPage.availablePanErrorTip();
			dataError2.add("(" + errorTip + ")");
		}
		Log.info("Passed parameter to PanNumber webelement is " + addCustomerPage.getPanNumberValue());
	}

	// Tan Number
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test09tanNumber() {

	}

	// Gst Number
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test10GstNumber() {

	}

	// City
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test11City() {

		addCustomerPage.clickOnCityDropdown();
		Log.info("City drop down clicked");

		addCustomerPage.typeCity(City);

		String hintCity = addCustomerPage.isCityNotFound();
		Assert.assertNotEquals(hintCity, "No results found", City + " city is not available in database,");

		suggestedCitySearch = addCustomerPage.availableCitySearch();

		// cityAvailable = new String[suggestedCitySearch.size()];
		cityAvailable = suggestedCitySearch.toArray(new String[0]);

		addCustomer_CityIndex = util.helperMatchIndexFordataAndListToArray(suggestedCitySearch, cityAvailable, City);

		Assert.assertNotEquals(-1, addCustomer_CityIndex, " " + City + " this city is not availabe in database,");

		Log.info("Available city options under city " + City + " are" + Arrays.toString(cityAvailable));

		addCustomerPage.selectCity(addCustomer_CityIndex);
		Log.info(City + " is selected for City type");
	}

	// customer Address
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test12CutomerAddress() {

	}

	// Description
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test13Description() {

	}

	// Is Tax Exempted
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test14TaxExempted() {

	}

	
	// Customer Type (demo1)
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test15CustomerType() {

		suggestedCustomerTypeFromThree = addCustomerPage.availableCustomerTypeFromThree();

		customerTypeFromThreeAvailable = new String[suggestedCustomerTypeFromThree.size()];

		addCustomer_CustomerTypeFromThree = util.helperMatchIndexFordataAndListToArray(suggestedCustomerTypeFromThree,
				customerTypeFromThreeAvailable, CustomerTypeFromThree);
		Log.info("Customer Type option are " + Arrays.toString(customerTypeFromThreeAvailable));

		addCustomerPage.selectCustomerTypeFromThreeDemo2(addCustomer_CustomerTypeFromThree);
	}
	
// or for above method using switch		
	
	// Customer Type (demo2)
	@Test(dependsOnMethods = {"step2UptoAddCux"})
	public void test15CustomerTypeVr2() {
		
		addCustomerPage.selectCustomerTypeUsingSwitch(Integer.valueOf(CustomerTypeFromThree));
	}
	

	// Min Limit Amount
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test16CreditMinAmount() {

	}

	// Max Limit Amount
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test17CreditMaxAmount() {

	}

	// Period 1 No Of Days
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test18Period1Days() {

	}

	// Period 2 No Of Days
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test19Period2Days() {

	}

	// Billing Address
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test20BillingAddress() {

	}

	// Payment Type
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test21PaymentType() {

	}

	// Billing Schedule
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test22BillingSchedule() {

		addCustomerPage.clickOnBillingScheduleDropdown();
		Log.info("Billing Schedule drop down is clicked");

		addCustomerPage.selectBillingSchedule(BillingSchedule);

		suggestedBillingSchedule = addCustomerPage.availableBillingSchedule();

		billingScheduleAvailable = suggestedBillingSchedule.toArray(new String[0]);
		Log.info("Available Billing Schedule are " + Arrays.toString(billingScheduleAvailable));
		Log.info(BillingSchedule + " is selected for Billing Schedule");
	}

	// Billing Format
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test23BillingFormat() {

	}

	// Sales Employee
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test24SalesEmployee() {

	}

	// Account Employee
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test25AccountEmployee() {

	}

	// Operational Employee
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test26OperationalEmployee() {

	}

	// Customer Support
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test27CustomerSupport() {

	}

	// ToolTip
	@Test(dependsOnMethods = { "step02UptoAddCux" })
	public void test28ToolTip() {

		boolean flagTooltip = addCustomerPage.isTooltipAvailable();
		
		if (flagTooltip) {
			String errorMsg = "Duplicate Elements, which are already in use are ";
			suggestedToolTip = addCustomerPage.availableToolTip();

			ToolTipavailable = suggestedToolTip.toArray(new String[0]);

			Log.info(errorMsg + Arrays.toString(ToolTipavailable));

			dataError2.add(errorMsg + Arrays.toString(ToolTipavailable));
			// addCustomerPage.clickOnSubmit();
			// for checking even though tooltip is there by clicking on submit it should not go to next page,
			// if its going then rest code will get some exception and test will fail.

// or for above method using Optional class
			
//			Optional<String[]> suggestedToolTip = Optional.empty();
//			
//			if (addCustomerPage.isTooltipAvailable()) {
//				suggestedToolTip = Optional.of(addCustomerPage.availableToolTip().toArray(new String[0]));
//				Log.info("Duplicate Elements, which are already in use are " + Arrays.toString(suggestedToolTip.get()));
//			}
		}

		// Submit
		addCustomerPage.clickOnSubmit();

		// assertion as customer is not created due to presence of Tooltip
		if (flagTooltip) {
			Log.info("Customer is not created! Submit button doesnt accept the customer form");
			Assert.assertFalse(flagTooltip, "Customer is not created as some inputs are already present in database");

		} else if (!flagTooltip) {
			// to verify that customer is been created //ContactToFind is currentContact ;

			customerPage = new CustomerPage(driver, util);
			List<String> suggestedCotactNo = customerPage.availableConatactOptions();

			boolean flagContactNo = false;
			for (int i = 0; i < suggestedCotactNo.size(); i++) {
				if (currentContact.equalsIgnoreCase(suggestedCotactNo.get(i))) {
					flagContactNo = true;
					Log.info("Customer is created at current index location " + i);
				}
			}
			if (!flagContactNo) {
				Log.info("Tooltip is not available and customer profile is not found in customer list page");
				Log.info("error msg/tooltip is = " + Arrays.toString(ToolTipavailable));

			}
		}

	}

}
