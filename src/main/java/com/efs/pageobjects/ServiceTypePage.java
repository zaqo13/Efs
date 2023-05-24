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

public class ServiceTypePage {

	@FindAll({ @FindBy(xpath = "//table[@id='service']/tbody/tr/td[@class='sorting_1']") })
	private List<WebElement> ServiceTypeOptions;

	@FindAll({ @FindBy(xpath = "//a[@title='update']") })
	private List<WebElement> ServiceTypeOptionsSettings;

	
	private WebDriver driver;
	private Utility util;
	
	public List<String> ServiceTypeList;

	
	public ServiceTypePage(WebDriver driver, Utility util) {
		
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}

	
	
	
	public List<String> availableServiceTypeWithReturnTypeList() {

		util.waitForVisibilityOfElements(driver, ServiceTypeOptions, 10);
		ServiceTypeList = new ArrayList<String>();
		return util.helperWebElementsToStringList(ServiceTypeOptions, ServiceTypeList);
	}

//or for above method, either we can use return type as List or we can store the data in another class & access it from that class

	public void availableServiceType() {

		util.waitForVisibilityOfElements(driver, ServiceTypeOptions, 10);
		Variable.stpAvailableServicetype = new ArrayList<String>();
		util.helperWebElementsToStringList(ServiceTypeOptions, Variable.stpAvailableServicetype);

	}

	public void selectServiceType(int serviceTypeIndexToSelect) {

		ServiceTypeOptionsSettings.get(serviceTypeIndexToSelect).click();
	}

}
