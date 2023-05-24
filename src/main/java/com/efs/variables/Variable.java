package com.efs.variables;

import java.util.List;

public class Variable {
	
//	AddShipmentPage
	public static List<String> availableConsigneeCity;
	
	public static List<String> availableMaterialDiscription;
	
	public static List<String> availableMaterialDiscriptionListDemo2;

	public static List<String> availableServiceTye;

	public static List<String> availableDocketNo;
	
	public static List<String> availableBookingType;
	
	public static List<String> availableInsuranceType;
	
	public static List<String> availablePickupType;
	
	public static List<String> availableDeliveryType;
	
	public static List<String> availableHandlingCode;

	public static List<String> availableShipmentDescription;
	
	public static List<String> availableShipperCity;
	
	
	
	public static String availableShipmentDescriptionText;
	public static String availablePolicyNumberText;
	public static String availableVolumetricWeight;
	public static String enteredOriginCity;
	public static String enteredDestinationCity;
	
	public static String selectedFovCharges;
	public static String selectedBookingType;
	
	public static String enteredDestinationPincode;
	
	public static double chargeableWeight;
	public static double availableTotalDocketCharges;
	public static double availableFuleCharges;
	public static double availableTotalFuleCharges;
	public static double availableOdaCharges;
	public static double availableTotalOdaCharges;
	public static double availableCodCharges;
	public static double availableTotalCodCharges;
	public static double availableFovCharges;
	public static double availableTotalFovCharges;
	public static double availableTotalToPayCharges;
	public static double availableToPayCharges;
	public static double availableCafCharges;
	public static double availableTotalCafCharges;
	
	public static double availableInvoiceAmount;
	public static boolean isCodRadioSelected;
	
	public static String aspServiceTypeToSelect = "SFC-FTL";


	
	
//UpdateServiceTypePage, stp==ServiceTypePage, asp==AddServicePage, uss==Update Service Settings
	
	public static List<String> stpAvailableServicetype;
	
	public static List<String> ussAvailableServiceCategoryOptions;
	
	public static String ussServiceCategoryToSelect = "Default";
	
	public static String RateType = "";
	public static String RateArea = "";
	public static String GstPercentage;
	public static double FreightMinimumCost;
	public static String FreightMinimumKg;
	public static double FuelPercentageCost;
	public static boolean FuelSurchargeRadio;
	public static boolean CafRadio;
	public static double CafMinimumCost;
	public static double CafPercentageCost;
	public static boolean CodRadio;
	public static double CodMinimumCost;
	public static double CodPercentageCost;
	public static boolean ToPayRadio;
	public static double ToPayMinimumCost;
	public static double ToPayPercentageCost;
	public static boolean DocketChargeRadio;
	public static double DocketChargeMinimumCost;
	public static double DocketChargePerKgCost;
	public static boolean FovCarrierRiskRadio;
	public static double FovCarrierRiskMinimumCost;
	public static double FovCarrierRiskPercentageCost;
	public static double FovOwnerMinimumCost;
	public static double FovOwnerPercentageCost;
	public static boolean OdaChargesRadio;
	public static String PickupChargesRadio;
	public static String DeliveryChargesRadio;
	public static String CustomClearanceRadio;
	public static String OtherChargesRadio;
	
	
	public static int RateTypeIndex;
	
	
//	CityToCitySlabRate
	
	public static List<String> availableWeightRange;
	public static List<Double> availableSearcheWeightRange;

//	calculation of rates for shipment summary
	public static double FinalFreightValue;
	public static double availableTotalFreightRate;
	public static double availableDocketCharges; 

	
	
//	Oda Rate
	
	public static List<String> availableOdaKilometerSlab;
	public static List<String> availableOdaWeightSlab;
	
	public static String[] availableOdaWeightArray;
	
	public static String cellValueString ;
	
	
// Oda Kilometer from pincode
	
	public static double availableOdaKm ;
	
	
//	Pincode Page
	
	public static List<String> availablePincode;
	
//	public static String pincodeOdaKm;
}
