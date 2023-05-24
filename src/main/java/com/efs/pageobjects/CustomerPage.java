package com.efs.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.efs.utility.Utility;


public class CustomerPage {
	
	
	@FindBy(xpath = "//h4[contains(text(), 'Customer List')]/following::a[1]")
	private WebElement AddCustomer;
	
	@FindAll({@FindBy(xpath = "//table[@id='tbl_customer']/tbody/tr/td[6]")})
	private List<WebElement> ConatactOptions;
	
	@FindAll(@FindBy(xpath = "(//table[@id='tbl_customer']//tbody//tr//td[6])[last()]"))
	private WebElement ConatactOptionsLast;
	
	@FindAll({@FindBy(xpath = "//table[@id='tbl_customer']//tbody//tr//td[2]")})
	private List<WebElement> NameOptions;

	@FindAll({@FindBy(xpath = "//table[@id='tbl_customer']//tbody//tr//td//a[@title='view']")})
	private List<WebElement> ViewOptions;
	
	@FindBy(xpath = "//a/span[contains(text(),'super admin')]")
	private WebElement SuperAdminLogout;
	
	@FindBy(xpath = "//a[contains(@href,'http://xyz.in/EFS/v4/logout')]")
	private WebElement LogoutButtton;
	
	@FindBy(xpath = "//li[starts-with(@class,'paginate_button page-item')][last()-1]")
	private WebElement NoOfCustomerPages;
	
	@FindBy(xpath = "//li[@id='tbl_customer_next']")
	private WebElement NextCustomerPage;
	
	
	private WebDriver driver;
	private Utility util;
	public List<String> ContactOptionsList;
	
	public List<String> demo11;
	
	
	
	public CustomerPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	
	

	
	public void clickOnAddCustomer() {
		util.waitForVisibilityOf(driver, AddCustomer, 10).click();
	}
	
	
	public void availableConatactOptionsDemo() {
		//extra method
		util.waitForVisibilityOfElements(driver, ConatactOptions, 10);
		
		ContactOptionsList = new ArrayList<String>();
		
		List<String> demo11 = new ArrayList<String>();
		
		demo11 = util.helperWebElementsToStringList(ConatactOptions, ContactOptionsList);
		
		for(int i=0; i<demo11.size(); i++) {
			System.out.println(demo11.get(i));
		}
		
	}
	
	
	public List<String> availableConatactOptions() {
		
//		util.fluentWaitForvisibilityOf(driver, ConatactOptionsLast, 10, 300);
//		util.waitForVisibilityOf(driver, ConatactOptionsLast, 10);
		util.waitForVisibilityOfElements(driver, ConatactOptions, 10);
		
		
		ContactOptionsList = new ArrayList<String>();
		
		demo11  = new ArrayList<String>();
		
		demo11 = util.helperWebElementsToStringList(ConatactOptions, ContactOptionsList);
		
		return demo11;
		
	}
	
	public String displayNameOption(int nameIndexFromContactIndex) {
		
		util.waitForVisibilityOfElements(driver, NameOptions, 10);
		
		String name = NameOptions.get(nameIndexFromContactIndex).getText();
		
		return name;
	}
	
	
	
	public void selectCustomerId(int index) {
		ViewOptions.get(index).click();
	}
	
	
	public void clickOnLogout() {
		util.waitForVisibilityOf(driver, SuperAdminLogout, 10).click();
		util.waitForVisibilityOf(driver, LogoutButtton, 10).click();
	}
	
	
	public boolean isAddCustomerDisplay() {
		boolean br = util.findElement(driver, AddCustomer);
		return br;
	}	
	
	
	public String getCurrentUrl() {
		String url = util.currentUrl(driver);
		return url;
	}
	
	
	public int getNumberOfCustomerPages() {
		
		int lastPage = Integer.parseInt(util.waitForVisibilityOf(driver, NoOfCustomerPages, 10).getText());
		return lastPage;
	}
	
	
	
	public void clickOnNextPageOfCustomer() {
		util.waitForClickableElement(driver, NextCustomerPage, 10).click();
	}
	

}
