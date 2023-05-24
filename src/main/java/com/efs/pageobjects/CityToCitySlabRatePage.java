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

public class CityToCitySlabRatePage {

	@FindAll({ @FindBy(xpath = "(//div/table[@id='tbl_rate_module']/thead/tr/th)[position() >3]/b") })
	private List<WebElement> WeightRange;

//	@FindBy(xpath = "(//table[@id='tbl_rate_module']/thead/tr/th)[position() = 4]/b")
//	private WebElement FirstRangeWeight;

	@FindBy(xpath = "//div/table[@id='tbl_rate_module']/tbody/tr/td[last()]")
	private WebElement FirstRowLastCol;

	@FindBy(xpath = "//span[@aria-labelledby='select2-state-container']")
	private WebElement OriginState;

	@FindBy(xpath = "//span[@aria-labelledby='select2-city-container']")
	private WebElement OriginCity;

	@FindBy(xpath = "//span[@aria-labelledby='select2-destination_city_id-container']")
	private WebElement DestinationCity;

	@FindBy(xpath = "//span/input[@type='search']")
	private WebElement OriginSearchBox;

	@FindBy(xpath = "(//ul[@id='select2-city-results']/li)[1]")
	private WebElement OriginFirstSearchIteam;

	@FindBy(xpath = "(//ul[@id='select2-destination_city_id-results']/li)[1]")
	private WebElement DestinationFirstSearchIteam;

	@FindBy(xpath = "//ul/li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement HighlightedFirstOption;

	@FindAll({ @FindBy(xpath = "(//table/tbody/tr/td)[position() >3]") })
	private List<WebElement> FreightValueOptions;

//	

	private WebDriver driver;
	private Utility util;

	public CityToCitySlabRatePage(WebDriver driver, Utility util) {

		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}

	
	
	
	public void clickOnOriginState() {
	}

	public void typeOriginState(String originState) {
	}

	public void clickAndTypeOriginCity(String originCityToType) {
		util.waitForVisibilityOf(driver, OriginCity, 10).click();
		util.waitForVisibilityOf(driver, OriginSearchBox, 10).sendKeys(originCityToType);
	}

	public void selectOriginCity() {
	}

	public void clickAndTypeDestinationCity(String destinationCityToType) {
	}

	public void selectDestinationCity() {
	}

	public void getWeightRanges() {
//		[0-10, 11-20, 21-50, 51-100, 101-250, 251-500, 501-1000, 1001-0]

		util.waitForVisibilityOfElements(driver, WeightRange, 10);
		Variable.availableWeightRange = new ArrayList<String>();
		util.helperWebElementsToStringList(WeightRange, Variable.availableWeightRange);

	}

	public void getCitySearchedRangesValues() {

		util.waitForVisibilityOfElements(driver, FreightValueOptions, 10);
		Variable.availableSearcheWeightRange = new ArrayList<Double>();
		util.helperWebElementsToDoubleList(FreightValueOptions, Variable.availableSearcheWeightRange);
	}

}
