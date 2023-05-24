package com.efs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.efs.utility.Utility;

public class DashboardPage {

	@FindBy(xpath = "//span[contains(text(),'super admin')]")
	private WebElement LoggedInAs;

	@FindBy(xpath = "//ul//li//a//span[contains(text(), 'External Module')]")
	private WebElement ExternalModule;

	@FindBy(xpath = "//a[contains(text(),'Branch')]")
	private WebElement Branch;

	@FindBy(xpath = "//ul//li//ul//li//a[contains(text(),'Pincode')]")
	private WebElement Pincode;

	@FindBy(xpath = "//span[contains(text(),'Customer')]")
	private WebElement Cust;

	@FindBy(xpath = "//span[contains(text(),'Customer')]//following::ul//li//a[contains(text(),'Customer')]")
	private WebElement Customer;

	@FindBy(xpath = "//a[contains(text(),'Service Type')]")
	private WebElement ServiceType;

	@FindBy(linkText = "Shipment")
	private WebElement ShipmentByLinkeText;

	@FindBy(xpath = "//span[contains(text(),'Shipment')]")
	private WebElement ShipmentOld;

	@FindBy(xpath = "//a[contains(text(),'Shipment')][1]")
	private WebElement Shipment;

	@FindBy(xpath = "//li/a[contains(text(),'City To City')]/following-sibling::ul/li/a[contains(text(),'Slab Rate')]")
	private WebElement CityToCitySlabRate;

	@FindBy(xpath = "//a/span[contains(text(),'super admin')]")
	private WebElement SuperAdminLogout;

	@FindBy(xpath = "//li/a/span[contains(text(),'Rate Master')]/ancestor::a")
	private WebElement RateMaster;

	@FindBy(xpath = "//a[contains(text(),'ODA Rate')]")
	private WebElement OdaRates;

	@FindBy(xpath = "//a[contains(@href,'http://xyz.in/EFS/v4/logout')]")
	private WebElement LogoutButtton;

	
	
	private WebDriver driver;
	private Utility util;

	
	public DashboardPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}

	
	
	
	public boolean verifyLoggedInAs() {
		return util.elementIsDisplayed(driver, LoggedInAs);

	}

	public void clickBranch() {

		util.jsClick(driver, Branch);
	}

	public void clickOnPincode() {
		util.jsClick(driver, Pincode);
	}

	public void clickOnCustomers() {

		util.jsClick(driver, Customer);
	}

	public void clickOnServiceType() {
		util.jsClick(driver, ServiceType);
	}

	public void clickOnShipment() {
		util.jsClick(driver, Shipment);
	}

	public void clickOnCityToCitySlabRate() {

		util.jsClick(driver, CityToCitySlabRate);

	}

	public void clickOnOdaRate() {

		util.jsClick(driver, OdaRates);
	}

	public void clickOnLogout() {
		util.waitForVisibilityOf(driver, SuperAdminLogout, 10).click();
		util.waitForVisibilityOf(driver, LogoutButtton, 10).click();
	}

}
