package com.efs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.efs.utility.Utility;

public class ViewCustomerPage {
	
	
	@FindBy(xpath = "//th[contains(text(), 'Contact Person Name ')]/following-sibling::td")
	private WebElement ContactPersonName;
	
	@FindBy(xpath = "//th[contains(text(), 'Customer Type')]/following-sibling::td")
	private WebElement CustomerCategory;
	
	@FindBy(xpath = "//th[contains(text(), 'Pan Number')]/following-sibling::td")
	private WebElement PanNumber;
	
	@FindBy(xpath = "//th[contains(text(), 'Tan Number ')]/following-sibling::td")
	private WebElement TanNumber;
	
	@FindBy(xpath = "//th[contains(text(), 'GST Number ')]/following-sibling::td")
	private WebElement GSTNumber;
	
	@FindBy(xpath = "//th[starts-with(text(), 'Tax Exempted')]/following-sibling::td")		//
	private WebElement TaxExempted;
	
	@FindBy(xpath = "//th[starts-with(text(), 'Address')]/following-sibling::td")
	private WebElement Address;
	
	@FindBy(xpath = "//th[starts-with(text(), 'Description')]/following-sibling::td")
	private WebElement Description;
	
	
	@FindBy(xpath = "//th[contains(text(), 'Payment Type')]/following-sibling::td")
	private WebElement PaymentType;
	
	@FindBy(xpath = "//th[contains(text(), 'Billing Schedule')]/following-sibling::td")
	private WebElement BillingSchedule;
	
	@FindBy(xpath = "//th[contains(text(), 'Billing Format')]/following-sibling::td")
	private WebElement BillingFormant;
	
	@FindBy(xpath = "//th[contains(text(), 'Credit Period 1')]/following-sibling::td")
	private WebElement CreditPeriod_1;
	
	@FindBy(xpath = "//th[contains(text(), 'Credit Period 2')]/following-sibling::td")
	private WebElement CreditPeriod_2;
	
	@FindBy(xpath = "//th[starts-with(text(), 'Credit Min Limit Amount')]/following-sibling::td")		//
	private WebElement CreditMinLimitAmount;
	
	@FindBy(xpath = "//th[starts-with(text(), 'Credit Max Limit Amount')]/following-sibling::td")
	private WebElement CreditMaxLimitAmount;
	
	@FindBy(xpath = "//th[starts-with(text(), 'Billing Address')]/following-sibling::td/p")
	private WebElement BillingAddress;
	
	
	@FindBy(xpath = "//th[contains(text(), 'Sales User Name')]/following-sibling::td")
	private WebElement SalesUserName;
	
	@FindBy(xpath = "//th[contains(text(), 'Account User Name')]/following-sibling::td")
	private WebElement AccountUserName;
	
	
	@FindBy(xpath = "//th[starts-with(text(), 'Operational User Name')]/following-sibling::td")		//
	private WebElement OperationalUserName;
	
	@FindBy(xpath = "//th[starts-with(text(), 'Customer Support User Name')]/following-sibling::td")
	private WebElement CustomerSupportUserName;
	

	@FindBy(xpath = "//div[@class='card-body']/strong[contains(text(),'Type')]/following-sibling::h6[1]")
	private WebElement CustomerType;		//MainCustomerTypeToSelect
	//old //small[contains(text(), 'Type ')]/following-sibling::h6[1]
	
	@FindBy(xpath = "//small[contains(text(), 'Customer ID')]/following-sibling::h6[1]")
	private WebElement CustomerID;
	
	@FindBy(xpath = "//div[@class='card-body']/strong[contains(text(),'Mobile Number')]/following-sibling::h6[1]")
	private WebElement MobileNumber;
	//old  //small[contains(text(), 'Mobile Number')]/following-sibling::h6[1]
	
	@FindBy(xpath = "//div[@class='card-body']/strong[contains(text(),'City')]/following-sibling::h6[1]")		//
	private WebElement City;
	//old  //small[contains(text(), 'City')]/following-sibling::h6[1]
	
	@FindBy(xpath = "//div[@class='card-body']/strong[contains(text(),'State')]/following-sibling::h6[1]")
	private WebElement State;
	//old  //small[contains(text(), 'State')]/following-sibling::h6[1]
	
	@FindBy(xpath = "//div[@class='card-body']/strong[contains(text(),'Country')]/following-sibling::h6[1]")
	private WebElement Country;
	//old   //small[contains(text(), 'Country')]/following-sibling::h6[1]
	
	
	@FindBy(xpath = "//div[@class='card-body']/center/h5")
	private WebElement UserName;
	//old  //img/following-sibling::h4[@class='card-title m-t-15']
	
	@FindBy(xpath = "//div[@class='card-body']/center/h6")
	private WebElement EmailID;		//  //img/following-sibling::h6
	//old  //img/following-sibling::h4[@class='card-title m-t-15']/following-sibling::h6
	
	@FindBy(xpath = "//a/span[contains(text(),'super admin')]")
	private WebElement SuperAdminLogout;
	
	@FindBy(xpath = "//a[contains(@href,'http://xyz.in/EFS/v4/logout')]")
	private WebElement LogoutButtton;
	
	@FindBy(xpath = "//a[contains(text(),'Profile')][not(contains(text(),'View Profile'))]")
	private WebElement ProfileText;
	
	
	@FindBy(xpath = "//ul/li/a[contains(text(),'Profile')]")
	private WebElement ProfileTag;
	
	
	private WebDriver driver;
	private Utility util;
	
	
	
	
	public ViewCustomerPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);	
	}
	
	
	
	public void clickOnProfileTag() {
		
		util.waitForVisibilityOf(driver, ProfileTag, 10).click();
	}
	
	public void demoString() {
	}
	
	
	public String verifyContactPersonName() {
		return util.waitForVisibilityOf(driver, ContactPersonName, 10).getText();
	}
	
	
	public String verifyCustomerCategory() {
	}
	
	
	public String verifyPanNumber() {
	}
	
	
	public String verifyTanNumber() {
	}
	
	
	public String verifyGSTNumber() {
	}
	
	public String verifyTaxExempted() {
	}
	
	public String verifyAddress() {
	}
	
	public String verifyDescription() {
	}
	
	
	
	public String verifyPaymentType() {
		return util.waitForVisibilityOf(driver, PaymentType, 10).getText();
	}
	
	public String verifyBillingSchedule() {
	}
	
	public String verifyBillingFormant() {
	}
	
	public String verifyCreditPeriod_1() {
	}
	
	public String verifyCreditPeriod_2() {
	}
	
	public String verifyCreditMinLimitAmount() {
	}
	
	public String verifyCreditMaxLimitAmount() {
	}
	
	public String verifyBillingAddress() {
	}
	
	
	
	public String verifySalesUserName() {
		return util.waitForVisibilityOf(driver, SalesUserName, 10).getText();
	}
	
	public String verifyAccountUserName() {
	}
	
	
	
	public String verifyOperationalUserName() {
	}
	
	public String verifyCustomerSupportUserName() {
	}
	
	
	
	public String verifyCustomerType() {
		//MainCustomerTypeToSelect
	}
	
	public String verifyCustomerID() {
	}
	
	public String verifyMobileNumber() {
	}
	
	public String verifyCity() {
	}
	
	public String verifyState() {
	}
	
	public String verifyCountry() {
	}
	
	public String verifyUserName() {
	}
	
	public String verifyEmailID() {
	}
	
	
	public boolean isProfileTextDisplay() {
	}
	
	public void clickOnLogout() {
		util.waitForVisibilityOf(driver, SuperAdminLogout, 10).click();
		util.waitForVisibilityOf(driver, LogoutButtton, 10).click();
	}
	
	

}
