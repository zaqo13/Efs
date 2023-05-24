package com.efs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.efs.utility.Utility;

public class ShipmentPage {

	@FindBy(xpath = "//a[contains(@href, 'add_shipment')]/h5")
	private WebElement CreateNewShipment;
	// or xpath "//h5[contains(text(),'Create New')]"
	// or xpath "//a[contains(@href, 'add_shipment')]/h5"
	// or css "a[href='http://xyz.in/XYZ/v4/admin/Shipment/add_shipment'] h5"
	// or linkText "Create new"
	// or partialLinkText "Create"

	
	WebDriver driver;
	Utility util;

	
	public ShipmentPage(WebDriver driver, Utility util) {

		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}

	
	
	
	public void clickOnCreateNewShipment() {
		util.jsClick(driver, CreateNewShipment);
	}

}
