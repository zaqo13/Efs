# EfsIndia

Testing Project EFS-India

The project is a shipment management system developed for a logistics company. The system allows customers to create new shipments and track existing ones on the EFS Logistics Solution website. The main goal of the project was to provide a seamless experience for customers/owner throughout the shipment creation, tracking and invoice-billing process.

Test Document

This repository contains the testing project for a software application. The purpose of this project is to perform end-to-end testing and validate the functionality of various pages and features of the application.

The test document outlines the test scenarios and expected results for each test case. Here is a summary of the test cases:

End-to-End Testing

    Page Classes: LoginPage, DashboardPage, AddShipmentPage, ShipmentPage
    Test Class: AddShipmentFnlTestClass
    Test Data File: AddShipmentExcel.xlsx
    Test Cases: Filling up shipment with all details, grabbing required field to validate added shipment calculation
    Expected Results: Shipment rates, destination, source, service type, and many more

City-to-City Slab Rate Testing

    Page Classes: LoginPage, DashboardPage, CityToCitySlabRatePage
    Test Class: SlabRateRegTestClass
    Test Data File: Not specified
    Test Cases: Obtaining the table of rates based on the shipment weight for a given origin and destination city, and determining the correct rate according to that weight.
    Expected Results: Must provide correct rate for given weight

ODA Rate Testing

    Page Classes: LoginPage, Dashboard, OdaRatePage
    Test Class: OdaRateTestClass
    Test Data File: Not specified
    Test Cases: If the pincode is Oda, then obtain the charges for Oda from the table which contains the weight in kg of shipments relative to Oda km from respective branch.
    Expected Results: Must provide correct rate for given weight and ODA km from nearby branch

Service Type Testing

    Page Classes: LoginPage, DashboardPage, ServiceTypePage, UpdateServiceSettingPage, AddShipmentPage
    Test Class: AddServiceTypeRegTestClass
    Test Data File: Not specified
    Test Cases: Configuring the ServiceType using the data obtained from the Excel sheet, and validating all rate structures for shipment.
    Expected Results: Shipment rates and all other charges must be correct according to the configuration

Test1 - Add Multiple Customers using Data Provider

    Page Classes: LoginPage, DashboardPage, CustomerPage, AddCustomerPage
    Test Class: AddMultipleCustomerDataProviderTestClass
    Test Data File: AddCustomerDataProvider.xlsx
    Test Cases: Adding multiple customers one by one using Data Provider. If incorrect data is provided, it should display the tooltip on the console/log.
    Expected Results: For invalid data, it must provide the correct tooltip.

Test2 - Add Multiple Customers using Factory Annotation

    Page Classes: LoginPage, Dashboard, CustomerPage, AddCustomerPage
    Test Class: AddMultipleCustomerFactoryTestClass
    Test Data File: AddCustomerFactory.xlsx
    Test Cases: Adding multiple customers one by one using Factory annotation. If incorrect data is provided and a tooltip is displayed, it should store the result in the respective rows of the Excel sheet.
    Expected Results: For invalid data, it must provide the correct tooltip and save the result in the Excel file at the respective row.

Test3 - Verify Multiple Customers with Incorrect Data using Utility Methods

    Page Classes: LoginPage, Dashboard, CustomerPage, ViewCustomerPage
    Test Class: VerificationMultiCuxWithIncorrectDataToExcelTestClass
    Test Data File: VerifyMultiCux.xlsx
    Test Cases: Adding multiple customers one by one using Factory annotation. If incorrect data is provided by the user, it validates using the utility methods and stores the result in the respective rows of the Excel sheet.
    Expected Results: For invalid data, it must provide the complete and correct result/evaluation and save the result in the Excel file at the respective row.
