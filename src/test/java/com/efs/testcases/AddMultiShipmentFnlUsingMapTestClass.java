package com.efs.testcases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

public class AddMultiShipmentFnlUsingMapTestClass extends BaseClass_self {
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

	private Map<String, String> dataMap;

	private String ServiceType, DocketNo, DocketNumber, OriginPincode, DestinationPincode, BookingType, InsuranceType,
			PickupType, DeliveryType, Remark, Cod, Walking, WithFreight, GrossWeightKg, LengthCm, WidthCm, HeightCm,
			NoOfPackets, MaterialDescription, HandlingCode, PolicyNumber, ShipperName, ShipperContactPersonName,
			ShipperAddress1, ShipperAddress2, ShipperCity, ShipperMobileNumber, ShipperPincode, ShipperGstNumber,
			ConsigneeName, ConsigneeContactPersonName, ConsigneeAddress1, ConsigneeAddress2, ConsigneeCity,
			ConsigneeMobileNumber, ConsigneePincode;

	
	public AddMultiShipmentFnlUsingMapTestClass(String[] data) {

		dataMap = createDataMap(data);
		
		this.ServiceType = dataMap.get("ServiceType");
		this.DocketNo = dataMap.get("DocketNo");
		this.DocketNumber = dataMap.get("DocketNumber");
		this.OriginPincode = dataMap.get("OriginPincode").replace(".00", "");
		this.DestinationPincode = dataMap.get("DestinationPincode").replace(".00", "");
		this.BookingType = dataMap.get("BookingType");
		this.InsuranceType = dataMap.get("InsuranceType");
		this.PickupType = dataMap.get("PickupType");
		this.DeliveryType = dataMap.get("DeliveryType");
		this.Remark = dataMap.get("Remark");
		this.Cod = dataMap.get("Cod");
		this.Walking = dataMap.get("Walking");
		this.WithFreight = dataMap.get("WithFreight");
		
		this.GrossWeightKg = dataMap.get("GrossWeightKg");
		this.Walking = dataMap.get("Walking");
		this.LengthCm = dataMap.get("LengthCm");
		this.WithFreight = dataMap.get("WithFreight");
		this.WidthCm = dataMap.get("WidthCm");
		this.HeightCm = dataMap.get("HeightCm");
		this.NoOfPackets = dataMap.get("NoOfPackets");
		this.MaterialDescription = dataMap.get("MaterialDescription");
		this.HandlingCode = dataMap.get("HandlingCode");
		this.PolicyNumber = dataMap.get("PolicyNumber");
		this.ShipperName = dataMap.get("ShipperName");
		this.ShipperContactPersonName = dataMap.get("ShipperContactPersonName");
		this.ShipperAddress1 = dataMap.get("ShipperAddress1");
		this.ShipperAddress2 = dataMap.get("ShipperAddress2");
		this.ShipperCity = dataMap.get("ShipperCity");
		this.ShipperMobileNumber = dataMap.get("ShipperMobileNumber").replace(".00", "");
		this.ShipperPincode = dataMap.get("ShipperPincode").replace(".00", "");
		this.ShipperGstNumber = dataMap.get("ShipperGstNumber").replace(".00", "");
		this.ConsigneeName = dataMap.get("ConsigneeName");
		this.ConsigneeContactPersonName = dataMap.get("ConsigneeContactPersonName");
		this.ConsigneeAddress1 = dataMap.get("ConsigneeAddress1");
		this.ConsigneeAddress2 = dataMap.get("ConsigneeAddress2");
		this.ConsigneeCity = dataMap.get("ConsigneeCity");
		this.ConsigneeMobileNumber = dataMap.get("ConsigneeMobileNumber").replace(".00", "");
		this.ConsigneePincode = dataMap.get("ConsigneePincode").replace(".00", "");	
		Log.info("ShipperContactPersonName "+ShipperContactPersonName);
	}

	private Map<String, String> createDataMap(String[] data) {
		Map<String, String> map = new HashMap<>();
		map.put("ServiceType", data[0]);
		map.put("DocketNo", data[1]);
		map.put("DocketNumber", data[2]);
		map.put("OriginPincode", data[3].replace(".00", "") );
		map.put("DestinationPincode", data[4].replace(".00", ""));
		map.put("BookingType", data[5] );
		map.put("InsuranceType", data[6] );
		map.put("PickupType", data[7] );
		map.put("DeliveryType", data[8] );
		map.put("Remark", data[9] );
		map.put("Cod", data[10] );
		map.put("Walking", data[11] );
		map.put("WithFreight", data[12] );
		
		map.put("GrossWeightKg", data[13] );

		map.put("LengthCm", data[14] );
		map.put("WidthCm", data[15] );
		map.put("HeightCm", data[16] );
		map.put("NoOfPackets", data[17] );
		map.put("MaterialDescription", data[18] );
		map.put("HandlingCode", data[19] );
		map.put("PolicyNumber", data[20] );
		map.put("ShipperName", data[21] );
		map.put("ShipperContactPersonName", data[22] );
		map.put("ShipperAddress1", data[23] );
		map.put("ShipperAddress2", data[24] );
		map.put("ShipperCity", data[25] );
		map.put("ShipperMobileNumber", data[26].replace(".00", "") );
		map.put("ShipperPincode", data[27].replace(".00", "") );
		map.put("ShipperGstNumber", data[28].replace(".00", "") );
		map.put("ConsigneeName", data[29] );
		map.put("ConsigneeContactPersonName", data[30] );
		map.put("ConsigneeAddress1", data[31] );
		map.put("ConsigneeAddress2", data[32] );
		map.put("ConsigneeCity", data[33] );
		map.put("ConsigneeMobileNumber", data[34].replace(".00", "") );
		map.put("ConsigneePincode", data[35].replace(".00", "") );
		
		Log.info("ShipperContactPersonName "+map.get("ShipperContactPersonName"));
		return map;
	}

	
	@Factory
	public static Object[] factoryMethodAddShipment() {

		String[][] excelData = null;
		excelData =  (String[][]) ExcelUtilityVr2.getTestDataVr2("AddShipmentExcel.xlsx", 0); // (FileName, sheetNumber)
		Object[] testInstance = new Object[excelData.length];
		for (int i = 0; i < excelData.length; i++) {

			testInstance[i] = new AddMultiShipmentFnlUsingMapTestClass(excelData[i]);
		}
		return testInstance;
	}
	


	@AfterClass(alwaysRun = true)
	public void resetAndSaveToExcel() {
		
		dashboardPage.clickOnLogout();
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
		addShipmentPage.saveShipment();

		Log.endTestCase("Add Shipmnet");
	}



}
