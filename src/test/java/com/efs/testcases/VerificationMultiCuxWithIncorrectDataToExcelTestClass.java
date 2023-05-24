package com.efs.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.efs.base.BaseClass_self;
import com.efs.pageobjects.CustomerPage;
import com.efs.pageobjects.DashboardPage;
import com.efs.pageobjects.LoginPage;
import com.efs.pageobjects.ViewCustomerPage;
import com.efs.utility.ExcelSet;
import com.efs.utility.ExcelUtilityVr2;
import com.efs.utility.Log;

//@Test(groups="personalReg")
public class VerificationMultiCuxWithIncorrectDataToExcelTestClass extends BaseClass_self {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private CustomerPage customerPage;
	private ViewCustomerPage viewCustomerPage;

	private List<String> suggestedConatact;
	private String[] contactAvailable;
	private int contactIndex = -1;
	private List<String> dataError2;
	private int IndexCurrentRow;
	private String MainCustomerType, CustomerName, CustomerType, ContactPersonName, MobileNumber, Telephone, Email,
			PanNumber, TanNumber, GstNumber, City, CustomerAddress, Description, IsTaxExempted, CustomerTypeFromThree,
			CreditMinLimitAmount, CreditMaxLimitAmount, CreditPeriod1NoOfDays, CreditPeriod2NoOfDays, BillingAddress,
			PaymentType, BillingSchedule, BillingFormat, SalesEmployess, AccountEmployess, OperationalEmployess,
			CustomerSupport, ContactToFind;
 
	private static int ExcelSheetNumber = 0;

	
	
	@Factory
	public static Object[] factoryMethod() throws IOException {
		// parameter == (excel_fileName, sheet_index)
		String[][] excelData = (String[][]) ExcelUtilityVr2.getTestDataVr2("VerifyMultiCux.xlsx", ExcelSheetNumber);
		Object[] testInstance = new Object[excelData.length];
		for (int i = 0; i < excelData.length; i++) {

			testInstance[i] = new VerificationMultiCuxWithIncorrectDataToExcelTestClass(excelData[i][0],
					excelData[i][1], excelData[i][2], excelData[i][3], excelData[i][4], excelData[i][5],
					excelData[i][6], excelData[i][7], excelData[i][8], excelData[i][9], excelData[i][10],
					excelData[i][11], excelData[i][12], excelData[i][13], excelData[i][14], excelData[i][15],
					excelData[i][16], excelData[i][17], excelData[i][18], excelData[i][19], excelData[i][20],
					excelData[i][21], excelData[i][22], excelData[i][23], excelData[i][24], excelData[i][25],
					excelData[i][26], excelData[i][27], i);
		}
		return testInstance;
	}

	public VerificationMultiCuxWithIncorrectDataToExcelTestClass(String MainCustomerType, String CustomerName,
			String CustomerType, String ContactPersonName, String MobileNumber, String Telephone, String Email,
			String PanNumber, String TanNumber, String GstNumber, String City, String CustomerAddress,
			String Description, String IsTaxExempted, String CustomerTypeFromThree, String CreditMinLimitAmount,
			String CreditMaxLimitAmount, String CreditPeriod1NoOfDays, String CreditPeriod2NoOfDays,
			String BillingAddress, String PaymentType, String BillingSchedule, String BillingFormat,
			String SalesEmployess, String AccountEmployess, String OperationalEmployess, String CustomerSupport,
			String ContactToFind, int IndexCurrentRow) {

		this.MainCustomerType = MainCustomerType;
		this.CustomerName = CustomerName;
		this.CustomerType = CustomerType;
		this.ContactPersonName = ContactPersonName;

		double num1 = Double.parseDouble(MobileNumber);
		long number = (long) num1;
		this.MobileNumber = String.valueOf(number);

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
//	and finally @AfterClass will add the failed values/result/validation to corresponding rows.

	@AfterClass(alwaysRun = true)
	public void resetApplicationLogout() {
		// To add failed testcase value to their corresponding row values!
		// and logout function to iterate the excel data row for multiple cux verification!

		String result = String.join(", ", dataError2);
		int indexCurrentRow = IndexCurrentRow + 1;
		try {
			ExcelSet.setExcelData(result, indexCurrentRow, ExcelSheetNumber);		// (dataToStore, currentRowNo, SheetNo)
		} catch (IOException e) {
			throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
		} 
		dashboardPage.clickOnLogout();
	}

	@Test(description = "Logging into app", alwaysRun = true)
	public void step01UptoCustomerPage() {
		
		loginPage = new LoginPage(driver, util);

		String userName = prop.getProperty("userName");
		String password = prop.getProperty("password");
		loginPage.typeUserName(userName);
		loginPage.typePassword(password);
		loginPage.clickOnSubmit();
		Log.info("Login using username and password is '" + userName + "', '" + password + "'");

		// verify login
		dashboardPage = new DashboardPage(driver, util);
		
		boolean flag = dashboardPage.verifyLoggedInAs();
		Assert.assertTrue(flag, "User not logged in as " + userName);
		Log.info(userName + " login verified");
		
		customerPage = new CustomerPage(driver, util);
		viewCustomerPage = new ViewCustomerPage(driver, util);

		dashboardPage.clickOnCustomers();
		dataError2 = new ArrayList<String>();
		Log.endTestCase("Login & then upto Customer Page");

	}

	@Test(alwaysRun = true, description = "Searching for mobile number in customer List", dependsOnMethods = {
			"step01UptoCustomerPage" })
	public void step02FindingMobNo() {

		// method for finding profile corresponds to given pincode until last page of customerPage profiles!
		int pincodLastPage = customerPage.getNumberOfCustomerPages();
		int nextPage = 1;
		boolean flag1 = false;
		while (!(flag1 || nextPage == pincodLastPage + 1)) {
			try {
				suggestedConatact = customerPage.availableConatactOptions();
			} catch (StaleElementReferenceException e) {
				suggestedConatact = customerPage.availableConatactOptions();
			}

			for (int i = 0; i < suggestedConatact.size(); i++) {
				if (ContactToFind.equals(suggestedConatact.get(i))) {
					Assert.assertEquals(ContactToFind, suggestedConatact.get(i));
					Log.info("Created customer found at Sr. No. " + (i + 1) + "of current page is " + ContactToFind);
					flag1 = true;
					contactIndex = i;
					break;
				}
			}
			if (!flag1) {
				customerPage.clickOnNextPageOfCustomer();
				nextPage++;
				if (nextPage == pincodLastPage + 1) {
					Log.error("Contact not found in any pages");
				}
			} else {
				Log.info("Created customer found at Sr. No. " + (contactIndex + 1) + "of current page is "
						+ ContactToFind);
			}

		}

		try {
			Assert.assertNotEquals(-1, contactIndex, "Mobile number does not found in Customer List");
		} catch (AssertionError e) {
			dataError2.add(ContactToFind + "-ContactToFind");
			throw e;
		}

		String customerNameFromCustomerList = customerPage.displayNameOption(contactIndex);

		Log.info("Name corresponds to contact = " + ContactToFind + " is = " + customerNameFromCustomerList);
		Log.info("   ");
		customerPage.selectCustomerId(contactIndex);

		viewCustomerPage.clickOnProfileTag();
	}

	

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_Profile" })
	public void test01ValidateContactPersonName() {
		String actualValue = viewCustomerPage.verifyContactPersonName();
		String expectedValue = ContactPersonName;
		String errorMessage = "Contact Person Name does not match exactly or contains invalid characters!";
		boolean isValidCustomer = true;

//	    P98rwaa pa56til
		// Check if actual value contains only alphabetical characters and spaces
		if (!actualValue.matches("^[a-zA-Z ]+$")) {
			errorMessage = "ContactPersonName (format is incorrect contain special symbol/digits)";
			dataError2.add(actualValue + "-" + errorMessage);
			Log.error(errorMessage);
			isValidCustomer = false;
//            Assert.fail(errorMessage);
		}

		if (!actualValue.equals(expectedValue)) {
			errorMessage = "Contact Person Name does not match exactly!";
			dataError2.add(actualValue + "-ContactPersonName(does not match exactly/missing some char)");
			Log.error(errorMessage);
			isValidCustomer = false;
		}

//        Assert.assertEquals(actualValue, expectedValue, errorMessage);
		if (!isValidCustomer) {
			Assert.fail(errorMessage);
		}
		Log.info("Contact Person Name validated successfully. Value = " + actualValue);

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_Profile" })
	public void test02ValidateCustomerCategory() {

		Log.info("dataError2 = " + dataError2.toString());

		String actualValue = viewCustomerPage.verifyCustomerCategory();
		String expectedValue = CustomerType;
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			dataError2.add(actualValue + "-CustomerType");
			throw e;
		}
		Log.info("Customer category validate = " + actualValue);
	}


	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_Profile" })
	public void test03ValidatePanNumber() {
		String actualValue = viewCustomerPage.verifyPanNumber();
		String expectedValue = PanNumber;
		String errorMessage = "PAN Number does not match!";
		boolean isValidPan = true;

//	    VFPR89015
		if (!util.helperFormat10ExactLength(actualValue)) {

			dataError2.add(actualValue + "-PanNumber(Invalid length, must be 10 char only)");
			Log.error("PAN Number should be exactly 10 characters long");
			isValidPan = false;
		}

		if (!util.helperFormat10AllCapitalWithoutSymbolFirstLastChar(actualValue)) {
			dataError2.add(actualValue
					+ "-PanNumber(special symbol/digits/small case letter/start or end letter is not capital char)");
			Log.error("Invalid(symbol/digits/caseSensitive) PAN Number format");
			isValidPan = false;
		}

		try {
			Assert.assertEquals(actualValue, expectedValue, errorMessage);
		} catch (AssertionError e) {
			dataError2.add(actualValue + "-PanNumber(Invalid format)");
			Log.error("PAN Number does not match!");
			isValidPan = false;
			throw e;
		}

		if (!isValidPan) {
			Assert.fail("Pan Number validation is failed");
		} else {
			Log.info("PAN Number validated successfully. Value = " + actualValue);
		}

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_Profile" })
	public void test04ValidateTanNumber() {
		String actualValue = viewCustomerPage.verifyTanNumber();
		String expectedValue = TanNumber;
		String errorMessage = "TanNumber does not match exactly or contains invalid characters!";
		boolean isTanValid = true;

		if (!util.helperFormat10AllCapitalWithoutSymbolFirstLastChar(actualValue)) {

			dataError2.add(actualValue + "-TanNumber (small case letter/symbols/start or end letter is digit/symbol)");
			Log.error(errorMessage);
			isTanValid = false;
		}

		if (!util.helperFormat10ExactLength(actualValue)) {

			dataError2.add(actualValue + "-TanNumber (Invalid length, must be 10 char only)");
			Log.error("TAN Number should be exactly 10 characters long");
			isTanValid = false;
		}

		try {
			Assert.assertEquals(actualValue, expectedValue, "Tan Number dose not matched");
		} catch (AssertionError e) {
			dataError2.add(actualValue + "-TanNumber Tan Number dose not matched");
			Log.error(errorMessage);
			isTanValid = false;
			throw e;
		}

		if (!isTanValid) {
			Assert.fail("Tan Number validation falied");
		} else {
			Log.info("Tan number validate = " + actualValue);

		}
	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test05ValidateGSTNumber() {
		String actualVString = viewCustomerPage.verifyGSTNumber();
		String expectedValue = GstNumber;
		String errorMessage = "GstNumber does not match exactly or contains invalid characters or invalid character sequence!";
		boolean isGstValid = true;

		if (!util.helperFormat15Gst(actualVString)) {
			dataError2.add(actualVString + "-GstNumber (small case letters/symbols/incorrect gst format sequence)");
			Log.error(errorMessage);
			isGstValid = false;
		}

		if (!util.helperFormat15ExactLength(actualVString)) {
			dataError2.add(actualVString + "-GstNumber (Invalid length, must be 15 char only)");
			Log.error(errorMessage);
			isGstValid = false;
		}

		try {
			Assert.assertEquals(actualVString, expectedValue, "GST Number dose not matched, ");
		} catch (AssertionError e) {
			dataError2.add(actualVString + "-GstNumber GST Number dose not matched");
			Log.error(errorMessage);
			throw e;
		}

		if (!isGstValid) {
			Assert.fail(errorMessage);
		} else {
			Log.info("GST number validate = " + actualVString);
		}

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test06ValidateTaxExempted() {
		String actualVString = util.helperYesOrNoToDigit(viewCustomerPage.verifyTaxExempted());
		String expectedValue = IsTaxExempted;
		try {
			Assert.assertEquals(actualVString, expectedValue, "Tax Exempted dose not matched ");
		} catch (AssertionError e) {
			dataError2.add(actualVString + "-IsTaxExempted");
			throw e;
		}
		Log.info("Tax Exempted validate = " + actualVString);
	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test07ValidateCustomerAddress() {
		String actualVString = viewCustomerPage.verifyAddress().replace("\n", "").trim();
		String expectedValue = CustomerAddress;
		Log.info("test07 address = " + actualVString);
		try {
			Assert.assertEquals(actualVString, expectedValue, "Customer Address dose not matched ");
		} catch (AssertionError e) {
			dataError2.add(actualVString + "-CustomerAddress");
			throw e;
		}
		Log.info("Customer Address validate = " + actualVString);
	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test08ValidateDescription() {
		String actualVString = viewCustomerPage.verifyDescription();
		String expectedValue = Description;
		try {
			Assert.assertEquals(actualVString, expectedValue, "Description dose not matched ");
		} catch (AssertionError e) {
			dataError2.add(actualVString + "-Description");
			throw e;
		}
		Log.info("Description validate = " + actualVString);
	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test09ValidatePaymentType() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test10ValidateBillingSchedule() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test11ValidateBillingFormant() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test12ValidateCreditPeriod_1() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test13ValidateCreditPeriod_2() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test14ValidateCreditMinLimitAmount() {

		String actualVString = viewCustomerPage.verifyCreditMinLimitAmount();
		String expectedValue = CreditMinLimitAmount; // .concat(".00")
		String errorMString = "CreditMinLimitAmount does not match exactly or contains invalid characters or limit exceed";
		boolean isCreditMinValid = true;

		// only passing digits with fraction numbers like:- 1,2,3,454.23,24.12 etc
		if (!util.helperFormatIntOrDecimalOnly(actualVString)) {
			errorMString = "(alphabetic char/special symbol present/negative value)";
			dataError2.add(actualVString + "-CreditMiniLimitAmount " + errorMString);
			Log.error(errorMString);
			isCreditMinValid = false;
		}
		// max limit is 100000000.00
		if (!util.helperFormatLessThanOrEqual(Double.parseDouble(actualVString), 100000000.00)) {
			errorMString = "Credit minimum limit exceeded";
			dataError2.add(actualVString + "-CreditMiniLimitAmount " + errorMString);
			isCreditMinValid = false;
			Log.error(errorMString);
		}

		try {
			Assert.assertEquals(actualVString, expectedValue, "Credit Min Limit Amount dose not matched ");
		} catch (AssertionError e) {
			dataError2.add(actualVString + "-CreditMiniLimitAmount (Credit Min Limit Amount dose not matched)");
			Log.error(errorMString);
			throw e;
		}

		if (!isCreditMinValid) {
			Assert.fail(errorMString);
		} else {
			Log.info("Credit Min Limit Amount validate = " + actualVString);
		}
	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test15ValidateCreditMaxLimitAmount() {
		
	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test16ValidateBillingAddress() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test17ValidateSalesUserName() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test18ValidateAccountUserName() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test19ValidateOperationalUserName() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test20ValidateCustomerSupportUserName() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test21ValidateMainCustomerType() {

	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test22ValidateMobileNumber() {
		// now this field accepts only digits max upto 10
		String actualVString = viewCustomerPage.verifyMobileNumber();
		String expectedValue = MobileNumber;
		try {
			if (!util.helperFormat10ExactLength(actualVString)) {
				dataError2.add(actualVString + "-MobileNumber(Invalid length/less than 10 digits)");
				Log.error("Mobile Number should be exactly 10 characters long");
				Assert.fail("Mobile Number should be exactly 10 characters long");
			}
		} catch (AssertionError e) {
			dataError2.add(actualVString+"-MobileNumber");
			throw e;
		}
		Log.info("Mobile Number validate = " + actualVString);
	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test23ValidateCity() {
	}

	
	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test24ValidateCustomerName() {
		String actualVString = viewCustomerPage.verifyUserName();
		String expectedValue = CustomerName;
		String errorMessage = "Customer Name does not match exactly or contains invalid characters!";
		boolean isCustomerValid = true;

		// Check if actual value contains only alphabetical characters and spaces
		if (!util.helperFormatOnlyCharCaseInsensitive(actualVString)) {
			errorMessage = "CustomerName (contains digits/invalid symbols)";
			dataError2.add(actualVString + "-" + errorMessage);
			Log.error(errorMessage);
			isCustomerValid = false;
		}

		try {
			Assert.assertEquals(actualVString, expectedValue, errorMessage);
		} catch (AssertionError e) {
			errorMessage = "CustomerName does not match exactly!";
			dataError2.add(actualVString + "-" + errorMessage);
			Log.error(errorMessage);
			throw e;
		}

		if (!isCustomerValid) {
			Assert.fail(errorMessage);
		} else {
			Log.info("Customer Name validated successfully = " + actualVString);
		}
	}

	@Test(alwaysRun = false, dependsOnMethods = { "step02FindingMobNo" }, groups = { "Validate_Customer_profile" })
	public void test25ValidateEmailID() {

	}

}
