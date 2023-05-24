package com.efs.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.efs.utility.Utility;
import com.efs.variables.Variable;

public class AddShipmentPage {

	@FindBy(id = "service_type_id")
	private WebElement ServiceTypeDropdown;
	// or xpath "//select[@id='service_type_id']"

	@FindBy(xpath = "//select[@name='docket_type']")
	private WebElement DocketNoDropdown;

	@FindBy(xpath = "//label[contains(text(), 'Docket Number')]/preceding-sibling::input")
	private WebElement Docketnumber;

	@FindBy(xpath = "//label[contains(text(),'Origin Pincode')]/preceding-sibling::input")
	private WebElement OriginPincode;

	@FindBy(xpath = "//label[contains(text(),'Destination Pincode')]/preceding-sibling::input[@class]")
	private WebElement DestinationPincode;

	@FindBy(xpath = "//select[@id='booking_type']")
	private WebElement BookingTypeDropdown;

	@FindBy(xpath = "//select[@id='insurance_type_id']")
	private WebElement InsuranceTypeDropdown;

	@FindBy(xpath = "//select[@id='pickup_type']")
	private WebElement PickupTypeDropdown;

	@FindBy(xpath = "//select[@id='delivery_type']")
	private WebElement DeliveryTypeDropdown;

	@FindBy(xpath = "//select[@id='delivery_type']/ancestor::div[@class='col-md-3 frm-padding-left-right']")
	private WebElement DeliveryTypeDropdownOrg;

	@FindBy(xpath = "//label[contains(text(),'Remark')]/preceding-sibling::input")
	private WebElement Remark;

	@FindBy(xpath = "//label[contains(text(),'COD')]/preceding-sibling::input")
	private WebElement CodCheckBox;

	@FindBy(xpath = "//label[contains(text(),'Walking')]/preceding-sibling::input")
	private WebElement WalkingCheckBox;

	@FindBy(xpath = "//label[contains(text(),'With Freight')]/preceding-sibling::input")
	private WebElement WithFreightCheckBox;

	@FindBy(xpath = "//a[@class='open_modal_packet_details']")
	private WebElement PackageDetails;

	@FindAll({ @FindBy(xpath = "//input[contains(@name, 'product[0]')]") })
	private List<WebElement> AddNoOfPacketsRow1;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement SubmitPackets;

	@FindBy(xpath = "//select[@id='material_desc_id']/following-sibling::div/button")
	private WebElement MaterialDescriptionDropdown;

	@FindBy(xpath = "//select[@id='material_desc_id']")
	private WebElement MaterialDescriptionOptions;

	@FindAll({ @FindBy(xpath = "//select[@id='material_desc_id']/following-sibling::div/div/button") })
	private List<WebElement> MaterialDescriptionOptionsCheckbox;

	@FindBy(xpath = "//select[@id='handling_type_id']/following-sibling::div/button")
	private WebElement HandlingCodeDropdown;

	@FindBy(xpath = "//select[@id='handling_type_id']")
	private WebElement HandlingCodeOptions;

	@FindAll({ @FindBy(xpath = "//select[@id='handling_type_id']/following-sibling::div/div/button") })
	private List<WebElement> HandlingCodeOptionCheckbox;

	@FindBy(xpath = "//textarea[@id='shipment_desc']")
	private WebElement ShipmentDescriptionText;
	// label[contains(text(),'Shipment Description')]/preceding::textarea

	@FindBy(xpath = "//input[@id='policy_number']")
	private WebElement PolicyNumber;

//	@FindBy(xpath = "//label[contains(text(),'Customer Code')]/preceding-sibling::span/input[@id='shipper_name']")
//	private WebElement ShipperNameOrCustomerCode;	
	// or //input[@id='shipper_name']

	@FindBy(xpath = "//input[@id='shipper_name']")
	private WebElement ShipperNameOrCustomerCode;

	@FindBy(xpath = "//form//input[@id='shipper_contact_person']")
	private WebElement ShipperContactPersonName;

	@FindBy(xpath = "//textarea[@id='shipper_address1']")
	private WebElement ShipperAddress1;

	@FindBy(xpath = "//textarea[@name='shipper_address2']")
	private WebElement ShipperAddress2;

	@FindBy(xpath = "//input[@id='consignee_name']")
	private WebElement ConsigneeNameOrCustomerCode;

	@FindBy(xpath = "//input[@id='consignee_contact_person']")
	private WebElement ConsigneeContactPersonName;

	@FindBy(xpath = "//textarea[@id='consignee_address']")
	private WebElement ConsigneeAddress1;

	@FindBy(xpath = "//textarea[@id='consignee_address1']")
	private WebElement ConsigneeAddress2;

	@FindBy(xpath = "//select[@id='city']/following-sibling::span")
	private WebElement ShipperCityDropdown;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement ShipperCitySearch;
	//// ul[@id='select2-city-results']/../preceding-sibling::span/input

	@FindAll({ @FindBy(xpath = "//ul[@id='select2-city-results']/li") })
	private List<WebElement> ShipperCitySearchOptions;

	@FindBy(xpath = "//ul[@id='select2-city-results']/li[last()]")
	private WebElement ShipperCityLastOption;

	@FindBy(xpath = "//span[@class='select2-results']/ul/li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement HighlightedShipperCity;

	@FindBy(xpath = "//input[@id='shipper_contact_number']")
	private WebElement ShipperMobileNumber;

	@FindBy(xpath = "//input[@id='shipper_pincode']")
	private WebElement ShipperPincode;

	@FindBy(xpath = "//input[@id='shipper_gst_number']")
	private WebElement ShipperGstNumber;

	@FindBy(xpath = "//span[@id='select2-consignee_city_id-container']/..")
	private WebElement ConsigneeCityDropdown;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement ConsigneeCitySearch;

	@FindAll({ @FindBy(xpath = "//ul[@id='select2-consignee_city_id-results']/li") })
	private List<WebElement> ConsigneeCitySearchOptions;

	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']/following-sibling::li[last()]")
	private WebElement HighlightedConsigneeCityOptions;

	@FindBy(xpath = "//input[@id='consignee_contact']")
	private WebElement ConsigneeMobileNumber;

	@FindBy(xpath = "//input[@id='consignee_pincode']")
	private WebElement ConsigneePincode;

	@FindBy(xpath = "//form[@id='frm_shipment']//a[@class='open_modal_packet_details']")
	private WebElement PacketDetails;

	@FindAll({ @FindBy(xpath = "//table[@id='RateTable']/tbody/tr/td[3]/input") })
	private List<WebElement> ShipmentUnitRateOptions;

	@FindAll({
			@FindBy(xpath = "(//table[@id='RateTable']/tbody/tr/td[5]) /input |  //table[@id='RateTable']/tbody/tr/td[5]/div/input") })
	private List<WebElement> ShipmentToatalRateOptions;

	@FindBy(xpath = "//table[@id='RateTable']/tbody/tr/td[contains(text(),'Discount')]/following-sibling::td/select")
	private WebElement DiscountDropdown;

	@FindBy(xpath = "//p/span[@id='subtotal_span']")
	private WebElement SubtotalAmount;

	@FindBy(xpath = "//p/span[@id='discount_amount_span']")
	private WebElement DiscountAmount;

	@FindBy(xpath = "//span[@class='cgst_span_lbl']/span[@class='final_cgst_percentage_span_lbl']")
	private WebElement CgstAmount;

	@FindBy(xpath = "//span[@class='sgst_span_lbl']/span[@class='final_sgst_percentage_span_lbl']")
	private WebElement SgstAmount;

	@FindBy(xpath = "//span[@class='igst_span_lbl']/span[@class='final_igst_percentage_span_lbl']")
	private WebElement IgstAmount;

	@FindBy(xpath = "//span[@id='shipment_final_total_span']")
	private WebElement TotalAmount;

	@FindBy(xpath = "//label[contains(text(),'Invoice Date')]/preceding-sibling::input")
	private WebElement invoiceDate;

	@FindBy(xpath = "//input[@name='origin_city_name']")
	private WebElement OriginCity;

	@FindBy(xpath = "//input[@name='destination_city_name']")
	private WebElement DestinationCity;

	@FindBy(xpath = "//label/b[contains(text(),'Shipper Details')]")
	private WebElement DummyClick;

	@FindBy(xpath = "//form//div/input[@id='chargebal_weight']")
	private WebElement ChargableWeight;

	@FindBy(xpath = "//input[@id='btn_calcuate']")
	private WebElement Calculate;

//	Shipment Summary
	@FindBy(xpath = "//input[@name='docate_charges_rate_cal']")
	private WebElement DocateChargesRate;

	@FindBy(xpath = "//table[@id='RateTable']/tbody/tr/td/input[@name='freight_rate']")
	private WebElement TotalFreightTotal;

	@FindBy(xpath = "//input[@name='docate_charges']")
	private WebElement TotalDocketCharges;

	@FindBy(xpath = "//input[@name='fuel_charges_rate_cal']")
	private WebElement FuleCharges;

	@FindBy(xpath = "//input[@name='fuel_charges']")
	private WebElement TotalFuleCharges;

	@FindBy(xpath = "//input[@name='oda_charges_rate_cal']")
	private WebElement OdaCharges;

	@FindBy(xpath = "//input[@name='oda_charges']")
	private WebElement TotalOdaCharges;

	@FindBy(xpath = "//input[@name='cod_charges_rate_cal']")
	private WebElement CodCharges;

	@FindBy(xpath = "//input[@name='cod_charges']")
	private WebElement TotalCodCharges;

	@FindBy(xpath = "//input[@name='fov_charges_rate_cal']")
	private WebElement FovCharges;

	@FindBy(xpath = "//input[@name='fov_charges']")
	private WebElement TotalFovCharges;

	@FindBy(xpath = "//input[@name='topay_charges_rate_cal']")
	private WebElement ToPayCharges;

	@FindBy(xpath = "//input[@name='topay_charges']")
	private WebElement TotalToPayCharges;

	@FindBy(xpath = "//input[@name='caf_charges_rate_cal']")
	private WebElement CafCharges;

	@FindBy(xpath = "//input[@name='caf_charges']")
	private WebElement TotalCafCharges;

//	Invoice
	@FindBy(xpath = "//label[contains(text(),'Amount')]/preceding-sibling::input")
	private WebElement InvoiceAmount;

	private WebDriver driver;
	private Utility util;

	private List<WebElement> serviceTypeWebElements;
	private List<WebElement> docketNoWebElements;
	private List<WebElement> handlingCodeWebElements;

	public AddShipmentPage(WebDriver driver, Utility util) {

		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);

	}

//Service Type
	public void clickOnServiceTypeDropdown() {

		util.waitForVisibilityOf(driver, ServiceTypeDropdown, 10).click();
	}

	public void availableServiceTypeOptions() {

		serviceTypeWebElements = util.selectGetAvailableOptions(ServiceTypeDropdown);
		Variable.availableServiceTye = new ArrayList<String>();
		util.helperWebElementsToStringList(serviceTypeWebElements, Variable.availableServiceTye);
	}

	public void selectServiceType(String serviceTypeToSelect) {

		Variable.aspServiceTypeToSelect = serviceTypeToSelect;
		util.selectDropDownByVisibleText(ServiceTypeDropdown, serviceTypeToSelect);
	}

//Docket No	
	public void clickOnDocketNo() {

		util.waitForVisibilityOf(driver, DocketNoDropdown, 10).click();
	}

	public void availableDocketNoOptions() {

		docketNoWebElements = util.selectGetAvailableOptions(DocketNoDropdown);
		Variable.availableDocketNo = new ArrayList<String>();
		util.helperWebElementsToStringList(docketNoWebElements, Variable.availableDocketNo);
	}

	public void selectDocketNoByText(String docketNoTextToSelect) {

		util.selectDropDownByVisibleText(DocketNoDropdown, docketNoTextToSelect);
	}

	public void selectDocketNoByIndex(int docketNoIndexToSelect) {

		util.selectDropDownByIndex(DocketNoDropdown, docketNoIndexToSelect);
	}

//Docket Number	
	public void typeDocketNumber(String docketNumberToType) {
	}

//Origin Pincode	
	public void typeOriginPincode(String originPincodeToType) {
	}

//OriginCity
	public void getOriginCity() {

		Variable.enteredOriginCity = util.waitForVisibilityOf(driver, OriginCity, 10).getAttribute("value");
	}

//Destination Pincode	
	public void typeDestinationPincode(String destinationPincodeToType) {
	}

//DestinationCity
	public void getDestinationCity() {
	}

//Booking Type
	public void clickOnBookingType() {
	}

	public void availableBookingTypeOptions() {
	}

	public void selectBookingType(String bookingTypeToSelect) {
	}

	public void availableInsuranceTypeOptions() {
	}

	public void selectInsuranceType(String insuranceTypeToSelect) {
	}

//Pickup Type
	public void clickOnPickupType() {
	}

	public void availablePickupTypeOptions() {

	}

	public void selectPickupType(String pickupTypeToSelect) {
	}

//Delivery Type	
	public void clickOnDeliveryType() {
	}

	public void availableDeliveryTypeOptions() {
	}

	public void selectDeliveryType(String deliveryTypeToSelect) {
	}

//Remark
	public void typeRemark(String remark) {
	}

//COD
	public void clickOnCodCheckBox(String cod) {

		boolean shouldSelectCod = util.helperYesOrNoToTrueOrFalse(cod);
		boolean isCodSelected = CodCheckBox.isSelected();
		if ((shouldSelectCod && !isCodSelected) || (!shouldSelectCod && isCodSelected)) {

			util.waitForVisibilityOf(driver, CodCheckBox, 10).click();
		}
	}

//Walking	
	public void clickOnWalkingCheckBox(String walkingCheckBox) {
	}

//With Freight
	public void clickOnWithFrieghtCheckBox(String WithFreight) {

		boolean shouldSelectWithFreight = util.helperYesOrNoToTrueOrFalse(WithFreight); // no
		boolean isWithFreightIsSelected = WithFreightCheckBox.isSelected(); // yes

		if ((shouldSelectWithFreight && !isWithFreightIsSelected)
				|| (!shouldSelectWithFreight && isWithFreightIsSelected)) {
			util.waitForVisibilityOf(driver, WithFreightCheckBox, 10).click();
		}
	}

//Material Description
	public void clickOnMaterialDescriptionDropdown() {
	}

	public void availableMaterialDiscriptionOptionsDemo11() {
	}

	public void selectMaterialDiscriptionDemo11(String name) {
	}

//Handling Code
	public void clickOnHandlingCodeDropdown() {

		util.waitForVisibilityOf(driver, HandlingCodeDropdown, 10).click();
	}

	public void availableHandlingCodeOptions() {

		util.waitForVisibilityOf(driver, HandlingCodeDropdown, 10);
		handlingCodeWebElements = util.selectGetAvailableOptions(HandlingCodeOptions);
		Variable.availableHandlingCode = new ArrayList<String>();
		util.helperWebElementsToStringList(handlingCodeWebElements, Variable.availableHandlingCode);
	}

	public void selectHandlingCode(String handlingCodeToSelect) {

		util.selectDropDownByVisibleText(HandlingCodeOptions, handlingCodeToSelect);
		util.waitForClickableElement(driver, HandlingCodeDropdown, 10).click();
		HandlingCodeOptionCheckbox.get(Variable.availableHandlingCode.indexOf(handlingCodeToSelect)).click();
	}

//Shipment Description 
	public void getShipmentDescriptionText() {

		Variable.availableShipmentDescriptionText = util.waitForVisibilityOf(driver, ShipmentDescriptionText, 10).getAttribute("value");
	}

//Shipper Name Or Customer Code
	public void typeShipperName(String shipperNameToType) {
	}

//Shippers Contact Person Name
	public void typeShipperContactPersonName(String contactPersonNameToType) {
	}

//Shipper Address 1 
	public void typeShipperAddress1(String shipperAddressToType) {
	}

//Shipper Address 2
	public void typeShipperAddress2(String shipperAddressToType) {
	}

//Consignee Name Or Customer Code
	public void typeConsigneeName(String consigneeNameToType) {
	}

//Consignee Contact Person Name
	public void typeConsigneeContactPersonName(String contactPersonNameToType) {
	}

//Consignee Address 1 
	public void typeConsigneeAddress1(String consigneeAddressToType) {
	}

//Consignee Address 2
	public void typeConsigneeAddress2(String consigneeAddressToType) {
	}

//Shipper City
	public void clickOnShipperCity() {
	}

	public void typeShipperCity(String shipperCityToType) {
	}

	public void availableShipperCity() {
	}

	public void selectShipperCity(int cityToSelect) {
	}

//Shipper Mobile number
	public void typeShipperMobileNumber(String mobileNumberToType) {
	}

//Shipper Pincode
	public void typeShipperPincode(String shipperPincodeToType) {
	}

//Shipper Gst Number
	public void typeShipperGstNumber(String shipperGstToType) {
	}

//Consignee City
	public void clickOnConsigneeCityDropdown() {
	}

	public void typeConsigneeCity(String consigneeCityToType) {
	}

	public void availableConsigneeCityOptions() {
	}

	public void selectConsigneeCity(int consigneeCityToType) {
	}

	public void typeConsigneeMobileNumber(String consigneeMobileNumberToType) {
	}

	public void typeConsigneePincode(String consigneePincodeToType) {
	}

	public void clickOnPacketDetails() {
	}

	public void typeGrossWeight(String grossWeight, String length, String width, String height, String NoOfPackets) {
	}

	public void getVolumetricWeight() {
		util.waitForVisibilityOf(driver, AddNoOfPacketsRow1.get(4), 10).sendKeys(Keys.BACK_SPACE);
		Variable.availableVolumetricWeight = util.waitForVisibilityOf(driver, AddNoOfPacketsRow1.get(4), 10).getText();
	}

	public void clickOnSubmitPackets() {

		util.waitForVisibilityOf(driver, SubmitPackets, 10).click();
		util.alertPopup(driver).accept();
	}

	public void getChargebleWeight() {

		Variable.chargeableWeight = Double.parseDouble(util.waitForVisibilityOf(driver, ChargableWeight, 10).getAttribute("value"));
	}

	public void getDocateRate() {
	}

	public void clickOnCalculate() {
	}

	public void getTotalFreightRate() {
		util.actionMoveToPageUp(driver, Calculate);
		Variable.availableTotalFreightRate = Double.parseDouble(util.waitForVisibilityOf(driver, TotalFreightTotal, 10).getAttribute("value"));
	}

	public void getDocketCharges() {

		Variable.availableDocketCharges = Double.parseDouble(util.waitForVisibilityOf(driver, DocateChargesRate, 10).getAttribute("value"));

		Variable.availableTotalDocketCharges = Double.parseDouble(util.waitForVisibilityOf(driver, TotalDocketCharges, 10).getAttribute("value"));
	}

	public void getFuleCharges() {
	}

	public void getOdaCharges() {
	}

	public void getCodCharges() {
	}

	public void getInvoiceAmount() {

		String str = (util.waitForVisibilityOf(driver, InvoiceAmount, 10).getAttribute("value"));
		Variable.availableInvoiceAmount = Double.parseDouble(str);
	}

	public void getFovCharges() {
	}

	public void getToPayCharges() {
	}

	public void getCafCharges() {

	}

	public void scrollDown() {
		util.jsScrollIntoView(driver, Calculate);
	}

}
