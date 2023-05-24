package com.efs.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.efs.utility.Utility;
import com.efs.variables.Variable;

public class OdaRatePage {
	
	@FindAll({@FindBy(xpath = "//thead[@id='rates']//th[position()>=2]/b")})
	private List<WebElement> KilometerOptions;
	
	
	@FindAll({@FindBy(xpath = "//thead[@id='rates']/following-sibling::tbody//td[1]")})
	private List<WebElement> WeightOptions;
	
	
	@FindAll({@FindBy(xpath = "//thead[@id='rates']/following-sibling::tbody/tr")})
	private List<WebElement> WeightRangeOptions;
	
	@FindBy(xpath = "//table//tr[")
	private WebElement tableCell;

	
	private WebDriver driver;
	private Utility util;
	
	
	
	
	
	public OdaRatePage (WebDriver driver, Utility util) {
		
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void availableKilometerOptions() {
		
		util.waitForVisibilityOfElements(driver, KilometerOptions, 10);
		Variable.availableOdaKilometerSlab = new ArrayList<String>();
		
		util.helperWebElementsToStringList(KilometerOptions, Variable.availableOdaKilometerSlab);		
	}
	
	
	public void availableWeightOptions() {
		
		util.waitForVisibilityOfElements(driver, WeightOptions, 10);
		Variable.availableOdaWeightSlab = new ArrayList<String>();
		Variable.availableOdaWeightArray = new String[WeightOptions.size()];
		
		util.helperWebElementsToStringList(WeightOptions, Variable.availableOdaWeightSlab);
//or
//		for(WebElement element : WeightOptions) {
//			Variable.availableOdaWeightSlab.add(element.getText());
//		}
		
//or		
//		for(int i=0; i<WeightOptions.size(); i++) {
//			Variable.availableOdaWeightSlab.add(WeightOptions.get(i).getText());
//		}
//		
//or
//		
//		for(int j=0; j<WeightOptions.size(); j++) {
//		
//			Variable.availableOdaWeightArray[j] = WeightOptions.get(j).getText();
//		}
			
	} 
	
	
	public void getWeightRangeLine(String  weight, String km) {
		
		util.waitForVisibilityOfElements(driver, WeightRangeOptions, 10);
		
		//thead[@id='rates']/following-sibling::tbody/tr[4]/td[3]
		
		
		String beforeXpath = "//thead[@id='rates']/following-sibling::tbody/tr["+weight +"]/td["+km+"]";

		
//		String beforeXpath = "//thead[@id='rates']/following-sibling::tbody/tr[";
//		String afterXpath = "4]/td[3]";
				
		WebElement cell = driver.findElement(By.xpath(beforeXpath));
		Variable.cellValueString = cell.getText();
	}

}
