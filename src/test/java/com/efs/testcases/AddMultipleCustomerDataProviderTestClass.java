package com.efs.testcases;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.efs.base.BaseClass_self;
import com.efs.dataprovider.DataProviders;
import com.efs.pageobjects.AddCustomerPage;
import com.efs.pageobjects.CustomerPage;
import com.efs.pageobjects.DashboardPage;
import com.efs.pageobjects.LoginPage;
import com.efs.utility.Log;

public class AddMultipleCustomerDataProviderTestClass extends BaseClass_self {
	// if cx created successfully then where it saved its index location is given at Log consol
	// if cx is not created then what are the Tooltips available are displayed and
	// if tooltip is not displayed, still page go forward to cx profile page then it
	// finding the the cx & not found then showing at Log that cx not created and tooltip not displayed
	// whatever webelement in List<String> type we get from PageObject is consider as suggested
	// whatever webelement in String[] type we get from TestClass is consider as available

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private CustomerPage customerPage;
	private AddCustomerPage addCustomerPage;
	private SoftAssert soft;

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
//	public int addCustomer_billingScheduleIndex;

	private List<String> suggestedBillingFormat;
	private String[] billingFormatAvailable;
//	public int addCustomer_billingFormatIndex;

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

	private String currentContact;


	@Test(priority = 0, dataProvider = "data-providerLogIn", dataProviderClass = DataProviders.class)
	public void loginTest(String userName, String password) {
		Log.startTestCase("SuperAdmin Login");

		loginPage = new LoginPage(driver, util);

		loginPage.typeUserName(userName);
		loginPage.typePassword(password);
		Log.info("Username and Password entered ");
		loginPage.clickOnSubmit();

		dashboardPage = new DashboardPage(driver, util);

		boolean flag = dashboardPage.verifyLoggedInAs();
		Assert.assertTrue(flag, "User not logged In as Super admin");
		Log.info("Super admin logged In successfully");

		Log.endTestCase("SuperAdmin Login");
	}

	@Test(priority = 1, dataProvider = "accountCreationData", dataProviderClass = DataProviders.class)
	public void addCustomerTest(String MainCustomerType, String CustomerName, String CustomerType,
			String ContactPersonName, String MobileNumber, String Telephone, String Email, String PanNumber,
			String TanNumber, String GstNumber, String City, String CustomerAddress, String Description,
			String IsTaxExempted, String CustomerTypeFromThree, String CreditMinLimitAmount,
			String CreditMaxLimitAmount, String CreditPeriod1NoOfDays, String CreditPeriod2NoOfDays,
			String BillingAddress, String PaymentType, String BillingSchedule, String BillingFormat,
			String SalesEmployess, String AccountEmployess, String OperationalEmployess, String CustomerSupport,
			String ContactToFind) {

		double num = Double.parseDouble(MobileNumber);
		MobileNumber = String.valueOf((long) num);

		double num2 = Double.parseDouble(Telephone);
		Telephone = String.valueOf((long) num2);

		IsTaxExempted = IsTaxExempted.replace(".00", "");
		CustomerTypeFromThree = CustomerTypeFromThree.replace(".00", "");

		CreditPeriod1NoOfDays = CreditPeriod1NoOfDays.replace(".00", "");
		CreditPeriod2NoOfDays = CreditPeriod2NoOfDays.replace(".00", "");

		double numToFind = Double.parseDouble(ContactToFind);
		ContactToFind = String.valueOf((long) numToFind);
		this.currentContact = ContactToFind;

		
// Add Customer
		Log.startTestCase("Add Customer");

		dashboardPage.clickOnCustomers();
		Log.info("Customer module clicked");

		customerPage = new CustomerPage(driver, util);

		customerPage.clickOnAddCustomer();
   
		addCustomerPage = new AddCustomerPage(driver, util);

		
////Customer Type main		
		suggestedMainCustomerType = addCustomerPage.availableMainCustomerType();

		mainCustomerTypeAvailable = new String[suggestedMainCustomerType.size()];


		mainCustomerTypeIndex = util.helperMatchIndexFordataAndListToArray(suggestedMainCustomerType, mainCustomerTypeAvailable,
				MainCustomerType);

		Assert.assertNotEquals(-1, mainCustomerTypeIndex, " " + MainCustomerType + " is not found at website,");

		Log.info("Availabe Main Customer Type options are " + Arrays.toString(mainCustomerTypeAvailable));

		addCustomerPage.selectMainCustomerType(mainCustomerTypeIndex);

		Log.info("Selected " + MainCustomerType + " option for Customer type");

		
////Customer Name

		addCustomerPage.typeCustomerName(CustomerName);

		
////Customer Type 

		addCustomerPage.clickOnCustomerTypeDropdown();
		addCustomerPage.selectCustomerType(CustomerType);

		suggestedCustomer = addCustomerPage.availableCustomertype();
		customerAvailable = suggestedCustomer.toArray(new String[0]);
//		customeravailable = addCustomerPage.availableCustomertype().toArray(new String[0]);

		Log.info("Available Customer type are " + Arrays.toString(customerAvailable));

		
/* Contact Person Name	*/
		addCustomerPage.typeContactPersonName(ContactPersonName);
		Log.info("Contact Person Name entered");

		
////Mobile Number		
		addCustomerPage.typeMobileNumber(MobileNumber);
		Log.info("Mobile Number entered");

////Telephone		

		
////Email		

		
////Pan Number		

		addCustomerPage.typePanNumber(PanNumber);
		Log.info("Pan Number entered");
//		System.out.println("type of PanNumber is "+addCustomerPage.getPanNumberValue().getClass().getName());

		Log.info("Passed parameter to PanNumber webelement is " + addCustomerPage.getPanNumberValue());

////Tan Number		

		
////Gst Number		

		
////City
		addCustomerPage.clickOnCityDropdown();
		Log.info("City drop down clicked");

		addCustomerPage.typeCity(City);

		String hintCity = addCustomerPage.isCityNotFound();
		Assert.assertNotEquals(hintCity, "No results found", City + " city is not available in database,");

		suggestedCitySearch = addCustomerPage.availableCitySearch();

//		cityAvailable = new String[suggestedCitySearch.size()];
		cityAvailable = suggestedCitySearch.toArray(new String[0]);

		addCustomer_CityIndex = util.helperMatchIndexFordataAndListToArray(suggestedCitySearch, cityAvailable, City);

		Assert.assertNotEquals(-1, addCustomer_CityIndex, " " + City + " this city is not availabe in database,");

		Log.info("Available city options under city " + City + " are" + Arrays.toString(cityAvailable));

		addCustomerPage.selectCity(addCustomer_CityIndex);
		Log.info(City + " is selected for City type");

////customer Address
		addCustomerPage.typeCustomerAddress(CustomerAddress);
		Log.info("Entered the Customer Address");

////Description


////Is Tax Exempted 
		suggestedIsTaxExempted = addCustomerPage.availableIsTaxExemptedOptions();
		isTaxExemptedAvailable = new String[suggestedIsTaxExempted.size()];

		addCustomer_isTaxExemptedIndex = util.helperMatchIndexFordataAndListToArray(suggestedIsTaxExempted, isTaxExemptedAvailable,
				IsTaxExempted);
		Log.info("Tax Exempted option are " + Arrays.toString(isTaxExemptedAvailable));

		addCustomerPage.selectIsTaxExempted(addCustomer_isTaxExemptedIndex);
		Log.info("Is Tax Exempted = " + util.helperYesOrNoToTrueOrFalse(IsTaxExempted));

////Customer Type (demo2)
//		addCustomerPage.selectCustomerTypeUsingSwitch(UserData.CustomerTypeToSelectFromThree);

////Customer Type (demo1)
		suggestedCustomerTypeFromThree = addCustomerPage.availableCustomerTypeFromThree();

		customerTypeFromThreeAvailable = new String[suggestedCustomerTypeFromThree.size()];

		addCustomer_CustomerTypeFromThree = util.helperMatchIndexFordataAndListToArray(suggestedCustomerTypeFromThree,
				customerTypeFromThreeAvailable, CustomerTypeFromThree);
		Log.info("Customer Type option are " + Arrays.toString(customerTypeFromThreeAvailable));

		addCustomerPage.selectCustomerTypeFromThreeDemo2(addCustomer_CustomerTypeFromThree);

////Min Limit Amount

		
////Max Limit Amount

		
////Period 1 No Of Days

		
////Period 2 No Of Days


////Billing Address


////Payment Type


////Billing Schedule 
		addCustomerPage.clickOnBillingScheduleDropdown();
		Log.info("Billing Schedule drop down is clicked");

		addCustomerPage.selectBillingSchedule(BillingSchedule);

		suggestedBillingSchedule = addCustomerPage.availableBillingSchedule();

		billingScheduleAvailable = suggestedBillingSchedule.toArray(new String[0]);
		Log.info("Available Billing Schedule are " + Arrays.toString(billingScheduleAvailable));
		Log.info(BillingSchedule + " is selected for Billing Schedule");

////Billing Format		
		

////Sales Employee 


////Account Employee
		

////Operational Employee  


////Customer Support 



//ToolTip
		boolean flagTooltip = addCustomerPage.isTooltipAvailable();
		if (flagTooltip) {
			suggestedToolTip = addCustomerPage.availableToolTip();

			ToolTipavailable = suggestedToolTip.toArray(new String[0]);

			Log.info("Duplicate Elements, which are already in use are " + Arrays.toString(ToolTipavailable));

		}
		// or for above method using Optional class
		
//		Optional<String[]> suggestedToolTip = Optional.empty();
//		
//		if (addCustomerPage.isTooltipAvailable()) {
//			suggestedToolTip = Optional.of(addCustomerPage.availableToolTip().toArray(new String[0]));
//			Log.info("Duplicate Elements, which are already in use are " + Arrays.toString(suggestedToolTip.get()));
//		}

		
		
		
////Submit
		addCustomerPage.clickOnSubmit();

//		//assertion as customer is not created due to presence of Tooltip

		if (flagTooltip) {
			Log.info("Customer is not created! Submit button doesnt accept the customer form!");
			Assert.assertFalse(flagTooltip, "Customer is not created as some inputs are already present in database");

		} else if (!flagTooltip) {
			// to verify that customer is been created //ContactToFind is currentContact ;

			customerPage = new CustomerPage(driver, util);
			List<String> suggestedCotactNo = customerPage.availableConatactOptions();

			boolean flag1 = false;
			for (int i = 0; i < suggestedCotactNo.size(); i++) {
				if (currentContact.equalsIgnoreCase(suggestedCotactNo.get(i))) {
					flag1 = true;
					Log.info("Customer is created at current index location " + i);
				}
			}
			if (flag1 == false) {
				Log.info("Tooltip is not available and customer profile is not found in customer list page");
//				Log.info("Customer is not created! Submit button doesnt accept the customer form");
				Log.info("error msg/tooltip is = " + Arrays.toString(ToolTipavailable));

			}
		}
	}
}
