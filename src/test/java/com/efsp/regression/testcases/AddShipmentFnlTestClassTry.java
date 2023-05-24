package com.efsp.regression.testcases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.efs.base.BaseClass_self;
import com.efs.pageobjects.AddShipmentPage;
import com.efs.pageobjects.DashboardPage;
import com.efs.pageobjects.LoginPage;
import com.efs.pageobjects.ShipmentPage;
import com.efs.utility.ExcelUtilityVr2;
import com.efs.utility.Log;
import com.efs.variables.Variable;

public class AddShipmentFnlTestClassTry extends BaseClass_self {
	// following this naming culture, for multiPincode and multiCx/multi anything
	// whatever webelement in List<string> type we get from PageObject pages is
	// consider as available
	// and whatever webelement in Sting[] type we get from TestClass pages is
	// consider as suggested
	
	           
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private AddShipmentPage addShipmentPage;
	private ShipmentPage shipmentPage;

	private String[] suggestedMaterialDescription;
	private int availableMaterialDiscriptionListSize;
	private int materialDescriptionIndex;

	private String[] suggestedServiceType;
	private int availableServiceTypeSize;
	private int serviceTypeIndex;

	private String[] suggestedDocketNo;
	private int availableDocketNoSize;
	private int docketNoIndex;

	private int shipperCityIndex;
	private int consigneeCityIndex;

	private String[] suggestedBookingType;
	private String[] suggestedInsuranceType;
	private String[] suggestedPickupType;
	private String[] suggestedDeliveryType;
	private String[] suggestedHandlingCode;

	private List<String> suggestedShipmentDescriptionText;

	private String ServiceType, DocketNo, DocketNumber, OriginPincode, DestinationPincode, BookingType, InsuranceType,
			PickupType, DeliveryType, Remark, Cod, Walking, WithFreight, GrossWeightKg, LengthCm, WidthCm, HeightCm,
			NoOfPackets, MaterialDescription, HandlingCode, PolicyNumber, ShipperName, ShipperContactPersonName,
			ShipperAddress1, ShipperAddress2, ShipperCity, ShipperMobileNumber, ShipperPincode, ShipperGstNumber,
			ConsigneeName, ConsigneeContactPersonName, ConsigneeAddress1, ConsigneeAddress2, ConsigneeCity,
			ConsigneeMobileNumber, ConsigneePincode;


	public AddShipmentFnlTestClassTry(String ServiceType, String DocketNo, String DocketNumber, String OriginPincode,
			String DestinationPincode, String BookingType, String InsuranceType, String PickupType, String DeliveryType,
			String Remark, String Cod, String Walking, String WithFreight, String GrossWeightKg, String LengthCm,
			String WidthCm, String HeightCm, String NoOfPackets, String MaterialDescription, String HandlingCode,
			String PolicyNumber, String ShipperName, String ShipperContactPersonName, String ShipperAddress1,
			String ShipperAddress2, String ShipperCity, String ShipperMobileNumber, String ShipperPincode,
			String ShipperGstNumber, String ConsigneeName, String ConsigneeContactPersonName, String ConsigneeAddress1,
			String ConsigneeAddress2, String ConsigneeCity, String ConsigneeMobileNumber, String ConsigneePincode) {

		this.ServiceType = ServiceType;
		this.DocketNo = DocketNo;
		this.DocketNumber = DocketNumber;
		this.OriginPincode = OriginPincode.replace(".00", "");
		this.DestinationPincode = DestinationPincode.replace(".00", "");
		this.BookingType = BookingType;
		this.InsuranceType = InsuranceType;
		this.PickupType = PickupType;
		this.DeliveryType = DeliveryType;
		this.Remark = Remark;
		this.Cod = Cod;
		this.Walking = Walking;
		this.WithFreight = WithFreight;

		this.GrossWeightKg = GrossWeightKg;
		this.Walking = Walking;
		this.LengthCm = LengthCm;
		this.WithFreight = WithFreight;
		this.WidthCm = WidthCm;
		this.HeightCm = HeightCm;
		this.NoOfPackets = NoOfPackets;
		this.MaterialDescription = MaterialDescription;
		this.HandlingCode = HandlingCode;
		this.PolicyNumber = PolicyNumber;
		this.ShipperName = ShipperName;
		this.ShipperContactPersonName = ShipperContactPersonName;
		this.ShipperAddress1 = ShipperAddress1;
		this.ShipperAddress2 = ShipperAddress2;
		this.ShipperCity = ShipperCity;
		this.ShipperMobileNumber = ShipperMobileNumber.replace(".00", "");
		this.ShipperPincode = ShipperPincode.replace(".00", "");
		this.ShipperGstNumber = ShipperGstNumber.replace(".00", "");
		this.ConsigneeName = ConsigneeName;
		this.ConsigneeContactPersonName = ConsigneeContactPersonName;
		this.ConsigneeAddress1 = ConsigneeAddress1;
		this.ConsigneeAddress2 = ConsigneeAddress2;
		this.ConsigneeCity = ConsigneeCity;
		this.ConsigneeMobileNumber = ConsigneeMobileNumber.replace(".00", "");
		this.ConsigneePincode = ConsigneePincode.replace(".00", "");
		Log.info("ShipperContactPersonName " + ShipperContactPersonName);

	}

	@Factory
	public static Object[] factoryMethodAddShipment() {

		String[][] excelData = null;
		excelData = (String[][]) ExcelUtilityVr2.getTestDataVr2("AddShipmentExcel.xlsx", 0); // (FileName, sheetNumber)
		Object[] testInstance = new Object[excelData.length];
		
		for (int i = 0; i < excelData.length; i++) {

			testInstance[i] = new AddShipmentFnlTestClassTry(excelData[i][0], excelData[i][1], excelData[i][2],
					excelData[i][3], excelData[i][4], excelData[i][5], excelData[i][6], excelData[i][7],
					excelData[i][8], excelData[i][9], excelData[i][10], excelData[i][11], excelData[i][12],
					excelData[i][13], excelData[i][14], excelData[i][15], excelData[i][16], excelData[i][17],
					excelData[i][18], excelData[i][19], excelData[i][20], excelData[i][21], excelData[i][22],
					excelData[i][23], excelData[i][24], excelData[i][25], excelData[i][26], excelData[i][27],
					excelData[i][28], excelData[i][29], excelData[i][30], excelData[i][31], excelData[i][32],
					excelData[i][33], excelData[i][34], excelData[i][35]);
		}
		return testInstance;
	}

	
	
	@Test(priority = 0, alwaysRun = true)
	public void step01loginTest() {

		Log.startTestCase("Login");

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

		Log.endTestCase("Login");

	}

	@Test(alwaysRun = true, dependsOnMethods = { "step01loginTest" })
	public void step2UptoAddShipmentPage() {

		Log.startTestCase("Add Shipmnet ");
		dashboardPage.clickOnShipment();

		shipmentPage = new ShipmentPage(driver, util);

		shipmentPage.clickOnCreateNewShipment();

		addShipmentPage = new AddShipmentPage(driver, util);

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test01ServiceType() {

		addShipmentPage.clickOnServiceTypeDropdown();
		addShipmentPage.availableServiceTypeOptions();
		availableServiceTypeSize = Variable.availableServiceTye.size();
		suggestedServiceType = new String[availableServiceTypeSize];
		serviceTypeIndex = util.helperMatchIndexFordata(availableServiceTypeSize, Variable.availableServiceTye,
				suggestedServiceType, ServiceType);
		addShipmentPage.selectServiceType(Variable.availableServiceTye.get(serviceTypeIndex));
		Log.info(ServiceType + " = Service Type = " + Arrays.toString(suggestedServiceType));

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test02DocketNo() {

//		addShipmentPage.clickOnDocketNo();
//		addShipmentPage.availableDocketNo();
//		availableDocketNoSize = Variable.availableDocketNo.size();
//		suggestedDocketNo = new String[availableDocketNoSize];
//		docketNoIndex = util.helperMatchIndexFordata(availableDocketNoSize, Variable.availableDocketNo, suggestedDocketNo, DocketNo);
//		addShipmentPage.selectDocketNoByIndex(docketNoIndex);

		// or for above// as this webelement having select/option tag in it so we can
		// handle it using regular methods or using select class predefine methods!

		addShipmentPage.clickOnDocketNo();
		addShipmentPage.availableDocketNoOptions();
		suggestedDocketNo = Variable.availableDocketNo.toArray(new String[0]);
		addShipmentPage.selectDocketNoByText(DocketNo);

		Log.info(DocketNo + " = Docket No. = " + Arrays.toString(suggestedDocketNo));
	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test03DocketNumber() {

		addShipmentPage.typeDocketNumber(DocketNumber);
		Log.info(DocketNumber + " = Docket Number entered");
	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test04OriginPincode() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test05DestinationPincode() {

		addShipmentPage.typeDestinationPincode(DestinationPincode);

		Variable.enteredDestinationPincode = DestinationPincode;

		Log.info(DestinationPincode + " = Destination Pincode entered");

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test06BookingType() {

		addShipmentPage.clickOnBookingType();
		addShipmentPage.availableBookingTypeOptions();
		suggestedBookingType = Variable.availableBookingType.toArray(new String[0]);
		addShipmentPage.selectBookingType(BookingType);

		Log.info(BookingType + " =Booking Type options " + Arrays.toString(suggestedBookingType));
	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test07InsuranceType() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test08PickupType() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test09DeliveryType() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test10Remark() {

		addShipmentPage.typeRemark(Remark);
		Log.info(Remark + " Remark entered");
	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test11CodCheckbox() {

		Variable.isCodRadioSelected = util.helperYesOrNoToTrueOrFalse(Cod);
		addShipmentPage.clickOnCodCheckBox(Cod);
		Log.info("Cod chekbox clicked");
	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test12WakingCheckbox() {

		addShipmentPage.clickOnWalkingCheckBox(Walking);
		Log.info("Walking checkbox clicked");
	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test13WithFreightCheckbox() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test14PacketDetails() {

		addShipmentPage.clickOnPacketDetails();
		addShipmentPage.typeGrossWeight(GrossWeightKg, LengthCm, WidthCm, HeightCm, NoOfPackets);
		addShipmentPage.getVolumetricWeight();
		Log.info(Variable.availableVolumetricWeight + " = getVolumetricWeight()");
		addShipmentPage.clickOnSubmitPackets();

		addShipmentPage.getChargebleWeight();
		Log.info(Variable.chargeableWeight + " final chargeable weight is");

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test15MaterialDescription() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test16HandlingCode() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test17ShipmentDescription() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test18PolicyNumber() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test19ShipperName() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test20ShipperContactPersonName() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test21ShipperAddress1() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test22ShipperAddress2() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test41ConsigneeName() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test42ConsigneeContactPersonName() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test43ConsigneeAddress1() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test44ConsigneeAddress2() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test27ShipperCity() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test28ShipperMobileNumber() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test29ShipperPincode() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test30ShipperGstNumber() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test31ConsigneeCity() {

		addShipmentPage.clickOnConsigneeCityDropdown();
		addShipmentPage.typeConsigneeCity(ConsigneeCity);
		addShipmentPage.availableConsigneeCityOptions();
		int availableConsigneeCitySize = Variable.availableConsigneeCity.size();
		String[] suggestedConsigneeCity = new String[availableConsigneeCitySize];
		consigneeCityIndex = util.helperMatchIndexFordata(availableConsigneeCitySize, Variable.availableConsigneeCity,
				suggestedConsigneeCity, ConsigneeCity);
		addShipmentPage.selectConsigneeCity(consigneeCityIndex);
	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test32ConsigneeMobileNumber() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test33ConsigneePincode() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test34getOriginDestinationCityNames() {

	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test35FinalClick() {

		addShipmentPage.clickOnCalculate();

		Log.endTestCase("Add Shipmnet");
	}

	@Test(dependsOnMethods = { "step2UptoAddShipmentPage" })
	public void test40getRates() {
		Log.startTestCase("test40getRates");

		addShipmentPage.getTotalFreightRate();
		addShipmentPage.getDocketCharges();
		Log.info(Variable.availableDocketCharges + " Variable.availableDocketCharges");
		Log.info(Variable.availableTotalDocketCharges + " Variable.availableTotalDocketCharges");

		addShipmentPage.getFuleCharges();
		Log.info(Variable.availableFuleCharges + " Variable.availableFuleCharges");
		Log.info(Variable.availableTotalFuleCharges + " Variable.availableTotalFuleCharges");

		addShipmentPage.getOdaCharges();
		Log.info(Variable.availableOdaCharges + " Variable.availableOdaCharges");
		Log.info(Variable.availableTotalOdaCharges + " Variable.availableTotalOdaCharges");

		addShipmentPage.getCodCharges();
		addShipmentPage.getInvoiceAmount();
		Log.info(Variable.availableCodCharges + " Variable.availableCodCharges");
		Log.info(Variable.availableTotalCodCharges + " Variable.availableTotalCodCharges");
		Log.info(Variable.availableInvoiceAmount + " Variable.availableInvoiceAmount");

		addShipmentPage.getFovCharges();
		Log.info(Variable.availableTotalFovCharges + " Variable.availableTotalFovCharges");
		Log.info(Variable.availableFovCharges + " Variable.availableFovCharges");
		Variable.selectedFovCharges = InsuranceType;
		Variable.selectedBookingType = BookingType;

		addShipmentPage.getToPayCharges();
		Log.info(Variable.availableTotalToPayCharges + " Variable.availableTotalToPayCharges");
		Log.info(Variable.availableToPayCharges + " Variable.availableToPayCharges");

		addShipmentPage.getCafCharges();
		Log.info(Variable.availableCafCharges + " Variable.availableCafCharges");
		Log.info(Variable.availableTotalCafCharges + " Variable.availableTotalCafCharges");

		Log.endTestCase("test45getRates");

	}

}
