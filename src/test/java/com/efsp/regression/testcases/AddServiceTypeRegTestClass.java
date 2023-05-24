package com.efsp.regression.testcases;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.efs.base.BaseClass_self;
import com.efs.pageobjects.AddShipmentPage;
import com.efs.pageobjects.DashboardPage;
import com.efs.pageobjects.ServiceTypePage;
import com.efs.pageobjects.UpdateServiceSettingPage;
import com.efs.utility.Log;
import com.efs.variables.Variable;

public class AddServiceTypeRegTestClass extends BaseClass_self {

	private DashboardPage dashboardPage;
	private ServiceTypePage serviceTypePage;
	private UpdateServiceSettingPage updateServiceSettingPage;
	private AddShipmentPage addShipmentPage;

	private int serviceTypeIndex;

	private ArrayList<String> browserTabs;

	@Test(alwaysRun = true)
	public void step01UptoServicetypePage() {

		Log.startTestCase("Get Service Type values/radio button status");

		util.jsOpenNewTabAndNavigateTo(driver, prop.getProperty("url"));

		browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(3));

		dashboardPage = new DashboardPage(driver, util);
		dashboardPage.clickOnServiceType();

		serviceTypePage = new ServiceTypePage(driver, util);

	}

	@Test()
	public void step201ServicesTypes() {

		serviceTypePage.availableServiceType();

		serviceTypeIndex = util.helperMatchIndexForDataToSearch(Variable.stpAvailableServicetype,
				Variable.aspServiceTypeToSelect);

		serviceTypePage.selectServiceType(serviceTypeIndex);

		Log.info(Variable.aspServiceTypeToSelect + " = selected from available services = "
				+ Arrays.toString(Variable.stpAvailableServicetype.toArray(new String[0])));

		updateServiceSettingPage = new UpdateServiceSettingPage(driver, util);
	}

	@Test()
	public void test01ServiceCategory() {

	}

	@Test()
	public void test02CalculationDependancyOfRateMaster() {

		updateServiceSettingPage.getRateType();

		Log.info(Variable.RateType + " = is selected from Freight Rate Type ");

		updateServiceSettingPage.getRateArea();

		Log.info(Variable.RateArea + " = is selected from Freight Rate Area");
	}

	@Test
	public void test03GstPercentage() {

		updateServiceSettingPage.getGstPercentage();

		Log.info(Variable.GstPercentage + " = is selected from list of Gst Percentage");
	}

	@Test
	public void test04FreightRate() {

		updateServiceSettingPage.getFreightMiniCost();
		Log.info(Variable.FreightMinimumCost + " = Freight Minimum Cost");

		updateServiceSettingPage.getFreightMinimumKg();
		Log.info(Variable.FreightMinimumKg + " = Freight Minimum Kg");
	}

	@Test
	public void test05FuelSurcharge() {

		updateServiceSettingPage.isFuelSurchargeSelected();

		Log.info(Variable.FuelSurchargeRadio + " = for Fuel Sur Charge rate");

		updateServiceSettingPage.getFuelPercentageCost();

		Log.info(Variable.FuelPercentageCost + " = Fuel Percentage");
	}

	@Test
	public void test06Caf() {

		updateServiceSettingPage.isCafSelected();
		Log.info(Variable.CafRadio + " = for Caf selected");

		updateServiceSettingPage.getCafMinimumCost();
		Log.info(Variable.CafMinimumCost + " = Caf Minimum Cost");

		updateServiceSettingPage.getCafPercentageCost();
		Log.info(Variable.CafPercentageCost + " = Caf Percentage");
	}

	@Test
	public void test07Cod() {

	}

	@Test
	public void test08ToPay() {

	}

	@Test
	public void test09DocketCharge() {

	}

	@Test
	public void test10FovCarrierRisk() {

	}

	@Test
	public void test11FovOwnerRisk() {

	}

	@Test
	public void test12OdaCharges() {

	}

	@Test
	public void test13PickupCharges() {

	}

	@Test
	public void test14DeliveryCharges() {

	}

	@Test
	public void test15CustomClearanceaCharges() {

	}

	@Test
	public void test16OtherCharges() {

		updateServiceSettingPage.isOtherChargesRadioSelected();
		Log.info(Variable.OtherChargesRadio + " = for Other charges selection");
		Log.endTestCase("Get Service Type values/radio button status");
	}

	@Test
	public void test17FreightRateValidation() {
		Log.startTestCase("validation of calculation");

		double finalFreightTotal;
		double calculationFreightTotal = Variable.FinalFreightValue * Variable.chargeableWeight;
		Log.info(Variable.FinalFreightValue + " Variable.FinalFreightValue cityTocity slab rate");

		if (calculationFreightTotal > Variable.FreightMinimumCost) {

			finalFreightTotal = calculationFreightTotal;
			Log.info(calculationFreightTotal
					+ " Variable.FinalFreightValue * Variable.chargeableWeight from calculation");
		} else {
			finalFreightTotal = Variable.FreightMinimumCost;
			Log.info(Variable.FreightMinimumCost + " Variable.FreightMinimumCost from service setting page");
		}
//		Log.info(Variable.availableTotalFreightRate+" Variable.availableTotalFreightRate from addShipment summary table");

		try {
			Assert.assertEquals(Variable.availableTotalFreightRate, finalFreightTotal, "Total freight rate is wrong!");
		} catch (AssertionError e) {
			Log.info(finalFreightTotal + " Freight Rate is not validate" + e.getMessage());
			throw e;
		}
		Log.info(finalFreightTotal + " Freight rate total validation successfull");

	}

	@Test
	public void test18DocketChargesValidation() {

		double calculationDocketCharges;

		if (Variable.DocketChargeRadio) {
			if (Variable.DocketChargeMinimumCost == Variable.availableDocketCharges) {

				calculationDocketCharges = (Variable.DocketChargePerKgCost * Variable.chargeableWeight)
						+ Variable.DocketChargeMinimumCost;
				Log.info(calculationDocketCharges + " calculationDocketCharges from calculation");
				double availabeTotalDocketCharges = Variable.availableTotalDocketCharges;
				Assert.assertEquals(availabeTotalDocketCharges, calculationDocketCharges,"Total Docket Charges are wrong");
				Log.info("Docket charges is validate");

			} else {
				String errorMsg = "docket charge at shipment summary is null/dose not matched!";
				Log.info(errorMsg);
				Assert.fail(errorMsg);
			}
		} else if (!Variable.DocketChargeRadio) {
			String errorMsg = "DocketChargeRadio is off, still value is available";
			Log.info("Docket charges radio button is off");
			Assert.assertTrue(util.helperFormatIntOrDecimalOnly(String.valueOf(Variable.availableTotalDocketCharges)),errorMsg);
		}

	}

	@Test
	public void test19FuleCharges() {

		double calculationFuleCharges;

		if (Variable.FuelSurchargeRadio) {
			if (Variable.FuelPercentageCost == Variable.availableFuleCharges) {

				calculationFuleCharges = (Variable.availableTotalFreightRate * Variable.FuelPercentageCost) / 100;
				Log.info(calculationFuleCharges
						+ " (Variable.availableTotalFreightRate * Variable.FuelPercentageCost) / 100) from calculation ");
				Assert.assertEquals(Variable.availableTotalFuleCharges, calculationFuleCharges,
						"Total Fuel Charges are wrong");
				Log.info("Fule charges is validate");
			} else {
				String errorMsg = "Fuel charges at addShipment summary is null/does not matched";
				Log.info(errorMsg);
				Assert.fail(errorMsg);
			}
		} else if (!Variable.FuelSurchargeRadio) {
			Log.info("Fuel charges radio button is off");
		}

	}

	@Test
	public void test20OdaCharges() {

		double calculationOdaCharges;

		if (Variable.OdaChargesRadio) {

			calculationOdaCharges = Variable.availableOdaCharges * Variable.chargeableWeight;
			Log.info(calculationOdaCharges
					+ " Variable.avaialbleOdaCharges * Variable.chargeableWeight from calculation");
			Assert.assertEquals(Variable.availableTotalOdaCharges, calculationOdaCharges,
					"Total Oda Charges are wrong");
			Log.info("Oda charges is validate");
		} else if (!Variable.OdaChargesRadio) {
			String errorMsg = "OdaChargesRadio is off still getting value at summary of addShipment page";
			Log.info("Oda charges radio button is off");
//			Assert.assertFalse(util.helperFormatIntOrDecimalOnly(String.valueOf(Variable.availableOdaCharges)), errorMsg);
			Assert.assertFalse(Variable.availableOdaCharges > 0, errorMsg);
		}
	}

	@Test
	public void test21CodCharges() {

		double finalCodValue;
		double calculationCod;
		if (Variable.CodRadio) {
			if (Variable.isCodRadioSelected) {

				calculationCod = (Variable.CodPercentageCost * Variable.availableInvoiceAmount) / 100;

				if (Variable.CodMinimumCost > calculationCod) {
					String errorMsg = "Cod minimum cost is selected but not matched at addShipment summary page";
					finalCodValue = Variable.CodMinimumCost;
					Assert.assertEquals(Variable.availableCodCharges, Variable.CodMinimumCost, errorMsg);
//					Assert.assertEquals(Variable.CodMinimumCost, Variable.availableTotalCodCharges );
//				} else if(Variable.CodMinimumCost < calculationCod) {
				} else {
					String errorMsg = "Cod minimum percentage cost is selected but not matched at addShipment summary page";
					finalCodValue = calculationCod;
					Assert.assertEquals(Variable.availableCodCharges, Variable.CodPercentageCost, errorMsg);
//					Assert.assertEquals(Variable.availableTotalCodCharges, calculationCod, errorMsg);
				}
				try {
					Assert.assertEquals(Variable.availableTotalCodCharges, finalCodValue, "total cod value is wrong!");
					Log.info("Cod value is validate");
				} catch (AssertionError e) {
					Log.info("Cod value is not validate" + e.getMessage());
					throw e;
				}

			} else if (!Variable.isCodRadioSelected) {
				Log.info("Cod option is not selected at addShipment page");
			}

		} else if (!Variable.CodRadio) {
			Log.info("Cod Radio button is off");
		}
	}

	@Test
	public void test22FovCharges() {
		String ownerRisk = "Owner Risk";
		String carrierRisk = "Carrier Risk";
		double calculationFov;

//		if(!Variable.FovCarrierRiskRadio) {
//			Log.info("Fov Carrier/Owner Risk is turned off!");
//		}

		if (Variable.FovCarrierRiskRadio) {

			if (Variable.selectedFovCharges.equalsIgnoreCase(carrierRisk)) {
				calculationFov = (Variable.FovCarrierRiskPercentageCost * Variable.availableTotalFreightRate) / 100;

				if (calculationFov > Variable.FovCarrierRiskMinimumCost) {
					Log.info(calculationFov
							+ " (Variable.FovCarrierRiskPercentageCost * Variable.availableTotalFreightRate) / 100");
					String validate = "Fov Carrier Risk is validate through FovCarrierRiskPercentageCost";
					String errorMsg = "Variable.FovCarrierRiskPercentageCost is selected but not matched at addShipment summary";
					Assert.assertEquals(Variable.availableTotalFovCharges, calculationFov, errorMsg);
					Assert.assertEquals(Variable.availableFovCharges, Variable.FovCarrierRiskPercentageCost, errorMsg);
					Log.info(validate);
				} else {
					Log.info(Variable.FovCarrierRiskMinimumCost + " Variable.FovCarrierRiskMinimumCost");
					String validate = "Fov Carrier Risk is validate through FovCarrierRiskMinimumCost";
					String errorMsg = "Variable.FovCarrierRiskMinimumCost is selected but not matched at addShipment summary";
					Assert.assertEquals(Variable.availableTotalFovCharges, Variable.FovCarrierRiskMinimumCost,
							errorMsg);
					Assert.assertEquals(Variable.availableFovCharges, Variable.FovCarrierRiskMinimumCost, errorMsg);
					Log.info(validate);
				}
			} else if (Variable.selectedFovCharges.equalsIgnoreCase(ownerRisk)) {
				calculationFov = (Variable.FovOwnerPercentageCost * Variable.availableTotalFreightRate) / 100;

				if (calculationFov > Variable.FovOwnerMinimumCost) {
					Log.info(calculationFov
							+ " (Variable.FovOwnerPercentageCost * Variable.availableTotalFreightRate) / 100");
					String validate = "Fov Owner Risk is validate through FovOwnerPercentageCost";
					String errorMsg = "Variable.FovOwnerPercentageCost is selected but not matched at addShipment summary";
					Assert.assertEquals(Variable.availableTotalFovCharges, calculationFov, errorMsg);
					Assert.assertEquals(Variable.availableFovCharges, Variable.FovOwnerPercentageCost, errorMsg);
					Log.info(validate);
				} else {
					Log.info(Variable.FovOwnerMinimumCost + " Variable.FovOwnerMinimumCost");
					String validate = "Fov Owner Risk is validate through FovOwnerMinimumCost";
					String errorMsg = "Variable.FovOwnerMinimumCost is selected but not matched at addShipment summary";
					Assert.assertEquals(Variable.availableTotalFovCharges, Variable.FovOwnerMinimumCost, errorMsg);
					Assert.assertEquals(Variable.availableFovCharges, Variable.FovOwnerMinimumCost, errorMsg);
					Log.info(validate);
				}

			}
		} else if (!Variable.FovCarrierRiskRadio) {
			Log.info("Fov Carrier/Owner Risk is turned odd!");
		}
	}

	@Test
	public void test23ToPayCharges() {

		double calculationToPayCharges;

		if (Variable.ToPayRadio) {

			if (Variable.selectedBookingType.equalsIgnoreCase("To pay")) {
				calculationToPayCharges = (Variable.ToPayPercentageCost * Variable.availableTotalFreightRate) / 100;

				if (calculationToPayCharges > Variable.ToPayMinimumCost) {
					Log.info(calculationToPayCharges
							+ " (Variable.ToPayPercentageCost * Variable.availableTotalFreightRate) / 100");
					String errorMsgTotal = "Total: To Pay charge are not validate";
					String errorMsgRate = "Rate: To Pay charges is not validate";
					String validate = "Total To Pay charges are validate through calculationToPayCharges";

					Assert.assertEquals(Variable.availableTotalToPayCharges, calculationToPayCharges, errorMsgTotal);
					Assert.assertEquals(Variable.availableToPayCharges, Variable.ToPayPercentageCost, errorMsgRate);
					Log.info(validate);

				} else {
					Log.info(Variable.ToPayMinimumCost + " Variable.ToPayMinimumCost");
					String errorMsgTotal = "Total: To Pay charge are not validate";
					String errorMsgRate = "Rate: To Pay charges is not validate";
					String validate = "Total To Pay charges are validate through Variable.ToPayMinimumCost";

					Assert.assertEquals(Variable.availableTotalToPayCharges, Variable.ToPayMinimumCost, errorMsgTotal);
					Assert.assertEquals(Variable.availableToPayCharges, Variable.ToPayMinimumCost, errorMsgRate);
					Log.info(validate);
				}
			} else if (!Variable.selectedBookingType.equalsIgnoreCase("To pay")) {
				Log.info("To Pay Booking type is not selected!");
			}

		} else if (!Variable.ToPayRadio) {

			Log.info("To Pay Charges Radio button is off!");
		}
	}

	@Test
	public void test24CafCharges() {

		double calculationCafCharges;

		if (Variable.CafRadio) {
			calculationCafCharges = (Variable.CafPercentageCost * Variable.availableTotalFreightRate) / 100;

			if (calculationCafCharges > Variable.CafMinimumCost) {
				Log.info(calculationCafCharges
						+ " (Variable.CafPercentageCost * Variable.availableTotalFreightRate) / 100");

				String errorMsgTotal = "Total: Caf charges are not validate";
				String errorMsgRate = "Rate: Caf charges are not validate";
				String validate = "Caf charges are validate through calculationCafCharges";

				Assert.assertEquals(Variable.availableTotalCafCharges, calculationCafCharges, errorMsgTotal);
				Assert.assertEquals(Variable.availableCafCharges, Variable.CafPercentageCost, errorMsgRate);
				Log.info(validate);
			} else {

				Log.info(Variable.CafMinimumCost + " Variable.CafMinimumCost");
				String errorMsgTotal = "Total: Caf charges are not validate";
				String errorMsgRate = "Rate: Caf charges are not validate";
				String validate = "Caf charges are validate through Variable.CafMinimumCost";

				Assert.assertEquals(Variable.availableTotalCafCharges, Variable.CafMinimumCost, errorMsgTotal);
				Assert.assertEquals(Variable.availableCafCharges, Variable.CafMinimumCost, errorMsgRate);
				Log.info(validate);
			}

		} else if (!Variable.CafRadio) {

			Log.info("Caf charges Radio button is off!");
		}
		
		Log.endTestCase("validation of calculation");
	}

	@Test
	public void test25SwitchToMainPage() {

		driver.switchTo().window(browserTabs.get(0));

		addShipmentPage = new AddShipmentPage(driver, util);

		addShipmentPage.scrollDown();
	}

}
