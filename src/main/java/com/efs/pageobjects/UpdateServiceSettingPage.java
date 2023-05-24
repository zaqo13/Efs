package com.efs.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.efs.utility.Utility;
import com.efs.variables.Variable;

public class UpdateServiceSettingPage {

	@FindAll({ @FindBy(xpath = "//input[@name='cust_type']") })
	private List<WebElement> ServiceCategoryOptions;

	@FindAll({ @FindBy(xpath = "//div[@id='type']//span[@class='size_update_service_setting']") })
	private List<WebElement> ServiceCategoryOptionsText;

	@FindBy(xpath = "//input[@name='frient_rate_calcuate_by'] [@checked]")
	private WebElement FreightRateType;

	@FindBy(xpath = "//input[@name='frient_rate_calcuate_by'] [@checked]/following-sibling::span")
	private WebElement FreightRateTypeText;

	@FindBy(xpath = "//input[@name='frient_rate_city_or_zone'] [@checked]/following-sibling::span[1]")
	private WebElement FreightRateArea;

	@FindBy(xpath = "//span[@id='select2-gst_percentage-container']")
	private WebElement GstPercentage;

	@FindBy(xpath = "//tbody/tr/td/input[@name='frient_minimum_cost']")
	private WebElement FreightMinimumCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='freight_minium_kg']")
	private WebElement FreightMinimumKg;

	@FindBy(xpath = "//tbody/tr/td/input[@name='fuel_charges_percent_cost']")
	private WebElement FuelPercentageCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='fuel_surcharge'][@checked]/following-sibling::span[1]")
	private WebElement FuelSurchargeRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='caf'][@checked]/following-sibling::span[1]")
	private WebElement CafRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='caf_minimum_cost']")
	private WebElement CafMinimumCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='caf_percentage']")
	private WebElement CafPercentageCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='cod'][@checked]/following-sibling::span[1]")
	private WebElement CodRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='cod_minimum_cost']")
	private WebElement CodMinimumCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='cod_invoice_percent_cost']")
	private WebElement CodPercentageCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='to_pay'][@checked]/following-sibling::span[1]")
	private WebElement ToPayRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='topay_minimum_cost']")
	private WebElement ToPayMinimumCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='topay_percent_cost']")
	private WebElement ToPayPercentageCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='docket_charge'][@checked]/following-sibling::span[1]")
	private WebElement DocketChargeRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='docket_charges_minimum_cost']")
	private WebElement DocketChargeMinimumCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='docket_charges_per_kg_cost']")
	private WebElement DocketChargePerKgCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='carrier_risk'][@checked]/following-sibling::span[1]")
	private WebElement FovCarrierRiskRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='carrier_risk_minimum_cost']")
	private WebElement FovCarrierMinimumCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='carrier_risk_percentage']")
	private WebElement FovCarrierPercentageCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='owner_risk_minimum_cost']")
	private WebElement FovOwnerMinimumCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='owner_risk_percentage']")
	private WebElement FovOwnerPercentageCost;

	@FindBy(xpath = "//tbody/tr/td/input[@name='oda'][@checked]/following-sibling::span[1]")
	private WebElement OdaChargesRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='pickup'][@checked]/following-sibling::span[1]")
	private WebElement PickupChargesRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='delivery'][@checked]/following-sibling::span[1]")
	private WebElement DeliveryChargesRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='custom_clearance'][@checked]/following-sibling::span[1]")
	private WebElement CustomClearanceRadio;

	@FindBy(xpath = "//tbody/tr/td/input[@name='other_charge'][@checked]/following-sibling::span[1]")
	private WebElement OtherChargesRadio;

	private WebDriver driver;
	private Utility util;

	public UpdateServiceSettingPage(WebDriver driver, Utility util) {

		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}

	public void availableServiceCategory() {

		util.waitForVisibilityOfElements(driver, ServiceCategoryOptions, 10);
		Variable.ussAvailableServiceCategoryOptions = new ArrayList<String>();
		util.helperWebElementsToStringList(ServiceCategoryOptionsText, Variable.ussAvailableServiceCategoryOptions);
	}

	public void selectServiceCategory(int serviceCategoryToSelect) {

		ServiceCategoryOptions.get(serviceCategoryToSelect).click();
	}
	
	public void isCafSelected() {

		String cafRadio = util.waitForVisibilityOf(driver, CafRadio, 10).getText();
		Variable.CafRadio = util.helperYesOrNoToTrueOrFalse(cafRadio);
	}

	public void getCafMinimumCost() {

		Variable.CafMinimumCost = Double.parseDouble(util.waitForVisibilityOf(driver, CafMinimumCost, 10).getAttribute("value"));
	}

	public void getRateType() {	
//		RateTypes ==  Additional,      Slab Flat,      Flat   
	}

	public void getRateArea() {
//		RateAreas == City to City,      City to Zone,      Zone to Zone,       Subzone to Subzone
	}

	public void getGstPercentage() {
	}

	public void getFreightMiniCost() {
	}

	public void getFreightMinimumKg() {
	}

	public void isFuelSurchargeSelected() {
	}

	public void getFuelPercentageCost() {
	}

	public void getCafPercentageCost() {
	}

	public void isCodSelected() {
	}

	public void getCodMinimumCost() {
	}

	public void getCodPercentageCost() {
	}

	public void isToPaySelected() {
	}

	public void getToPayMinimumCost() {
	}

	public void getToPayPercentageCost() {
	}

	public void isDocketChargeSelected() {
	}

	public void getDocketChargeMinimumCost() {
	}

	public void getDocketChargePerKgCost() {
	}

	public void isFovCarrierRiskSelected() {
	}

	public void getFovCarrierRiskMinimumCost() {
	}

	public void getFovCarrierRiskPercentageCost() {
	}

	public void getFovOwnerMinimumCost() {
	}

	public void getFovOwnerPercentageCost() {
	}

	public void isOdaChargesSelected() {
	}

	public void isPickupChargesSelected() {
	}

	public void isDeliveryChargesRadioSelected() {
	}

	public void isCustomClearanceRadioSelected() {
	}

	public void isOtherChargesRadioSelected() {
	}

}
