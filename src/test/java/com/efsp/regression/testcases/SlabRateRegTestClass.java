package com.efsp.regression.testcases;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.efs.base.BaseClass_self;
import com.efs.pageobjects.CityToCitySlabRatePage;
import com.efs.pageobjects.DashboardPage;
import com.efs.pageobjects.LoginPage;
import com.efs.utility.Log;
import com.efs.variables.Variable;



// In order to determine the slab rate for given weight of shipment, 
// we need to know the origin city, destination city, and chargeable weight. 
// The slab rate may vary depending on both the cities and the weight. 
// Therefore, we must ascertain the rate based on both of these parameters.

public class SlabRateRegTestClass extends BaseClass_self {

	private DashboardPage dashboardPage;
	private CityToCitySlabRatePage cityToCitySlabRatePage;

	
	@Test(priority = 0)
	public void step01UptoSlabRatePage() {

		Log.startTestCase("SlabRateRegTestClass");

		// switching to new tab and entering new link for getting freight rate from
		// cityToCity slab rate page/module
		util.jsOpenNewTabAndNavigateTo(driver, prop.getProperty("url"));

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(0));		//tabs.get(0)==original window/0th window

		driver.switchTo().window(tabs.get(1)); // second window opened by js

		dashboardPage = new DashboardPage(driver, util);

		dashboardPage.clickOnCityToCitySlabRate();

		cityToCitySlabRatePage = new CityToCitySlabRatePage(driver, util);

	}

	
	
	@Test(priority = 1)
	public void FreightRateDependsOnChargeableWeight() {

		Log.info("value of Variable.enteredOriginCity = " + Variable.enteredOriginCity);
		Log.info("value of Variable.enteredDestinationCity = " + Variable.enteredDestinationCity);

		cityToCitySlabRatePage.getWeightRanges();
		cityToCitySlabRatePage.clickAndTypeOriginCity(Variable.enteredOriginCity);
		cityToCitySlabRatePage.selectOriginCity();
		cityToCitySlabRatePage.clickAndTypeDestinationCity(Variable.enteredDestinationCity);
		cityToCitySlabRatePage.selectDestinationCity();
		cityToCitySlabRatePage.getCitySearchedRangesValues();

		int weightRangeSize = Variable.availableWeightRange.size();
		String[] ranges = new String[weightRangeSize];
		ranges = Variable.availableWeightRange.toArray(new String[0]);
		Log.info(Arrays.toString(ranges) + " weigth ranges are");

// Weight slabs ==	[1-10, 11-20, 21-50, 51-100, 101-250, 251-500, 501-1000, 1001-0]

		int[] rangeMin = new int[weightRangeSize];
		int[] rangeMax = new int[weightRangeSize];

		for (int i = 0; i < weightRangeSize; i++) {

			String[] range = Variable.availableWeightRange.get(i).split("-");
			rangeMin[i] = Integer.parseInt(range[0]);
			rangeMax[i] = Integer.parseInt(range[1]);
		}

		Log.info(Arrays.toString(rangeMin) + " rangeMin");
		Log.info(Arrays.toString(rangeMax) + " rangteMax");
		
	
		int index = -1;
		for (int j = 0; j < rangeMin.length; j++) {

			if (Variable.chargeableWeight >= rangeMin[j] && Variable.chargeableWeight <= rangeMax[j]) {

				index = j;
				Log.info("index value =" + index);
				break;
			}
		}

		Log.info(Arrays.toString(Variable.availableSearcheWeightRange.toArray(new Double[0])));

		Variable.FinalFreightValue = Variable.availableSearcheWeightRange.get(index);

		Log.info("Final Freight value is Variable.FinalFreightValue = " + Variable.FinalFreightValue
				+ ", for weight Variable.chargeableWeight = " + Variable.chargeableWeight);

		Log.endTestCase("SlabRateRegTestClass");

	}

}
