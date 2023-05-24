package com.efsp.regression.testcases;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.efs.base.BaseClass_self;
import com.efs.pageobjects.DashboardPage;
import com.efs.pageobjects.OdaRatePage;
import com.efs.utility.Log;
import com.efs.variables.Variable;

// If the pincode is Oda, then obtain the charges for Oda from the table 
// which contains the weight in kg of shipments relative to Oda km from branch.

public class OdaRateTestClass extends BaseClass_self {

	private DashboardPage dashboardPage;
	private OdaRatePage odaRatePage;

	@Test
	public void test01uptoLogin() {

		Log.startTestCase("OdaRateTestClass");

		util.jsOpenNewTabAndNavigateTo(driver, prop.getProperty("url"));

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(2));

		dashboardPage = new DashboardPage(driver, util);
		dashboardPage.clickOnOdaRate();
	}

	@Test
	public void test03getRates() {

		odaRatePage = new OdaRatePage(driver, util);

		odaRatePage.availableKilometerOptions();
		odaRatePage.availableWeightOptions();
		Log.info(Arrays.toString(Variable.availableOdaKilometerSlab.toArray(new String[0])));
		Log.info(Arrays.toString(Variable.availableOdaWeightSlab.toArray(new String[0])));
	}

	@Test
	public void test04findtRates() {

		int indexKm = -1;
		int indexWeight = -1;

		int kmRangeSize = Variable.availableOdaKilometerSlab.size();

		int[] rangeMinKm = new int[kmRangeSize];
		int[] rangeMaxKm = new int[kmRangeSize];

		for (int i = 0; i < kmRangeSize; i++) {

			String[] rangeSplit = Variable.availableOdaKilometerSlab.get(i).split("-");

			rangeMinKm[i] = Integer.parseInt(rangeSplit[0]);
			rangeMaxKm[i] = Integer.parseInt(rangeSplit[1]);
		}

		Log.info("oda Km Min splitting result:- " + Arrays.toString(rangeMinKm));
		Log.info("oda Km Max splitting result:- " + Arrays.toString(rangeMaxKm));


		for (int j = 0; j < rangeMaxKm.length; j++) {

			if (Variable.availableOdaKm >= rangeMinKm[j] && Variable.availableOdaKm <= rangeMaxKm[j]) {

				indexKm = j + 2;
				Log.info("indexKm value = " + indexKm);
				break;
			}
		}


		

		int weightRangeSize = Variable.availableOdaWeightSlab.size();

		int[] rangeMinWeight = new int[weightRangeSize];
		int[] rangeMaxWeight = new int[weightRangeSize];

		for (int i = 0; i < weightRangeSize; i++) {

			String[] rangeSplit = Variable.availableOdaWeightSlab.get(i).split("-");
			String[] rangePrefix = rangeSplit[1].split("\\(.*\\)"); // "\(.*\)" but due to readability of compiler we
																	// have to use \ multiple back slash

//			Log.info(" rangePrefix = "+Arrays.toString(rangePrefix));

			rangeMinWeight[i] = Integer.parseInt(rangeSplit[0]);
			rangeMaxWeight[i] = Integer.parseInt(rangePrefix[0]);
		}

		Log.info("oda weight Min splitting result:- " + Arrays.toString(rangeMinWeight));
		Log.info("oda weight Max splitting result:- " + Arrays.toString(rangeMaxWeight));


		for (int j = 0; j < rangeMaxWeight.length; j++) {

			int rangeMinW = rangeMinWeight[j];
			int rangeMaxW = rangeMaxWeight[j];

			if (Variable.chargeableWeight >= rangeMinW && Variable.chargeableWeight <= rangeMaxW) {

				indexWeight = j + 1;
				Log.info("indexWeight value = " + indexWeight);
				break;
			}
		}

		
		
		
		Log.info("Found location of desired weight wrt to km is = (" + indexKm + "," + indexWeight + ")");

		odaRatePage.getWeightRangeLine(String.valueOf(indexWeight), String.valueOf(indexKm));

		Log.info("result cell value is " + Variable.cellValueString);

	}

}
