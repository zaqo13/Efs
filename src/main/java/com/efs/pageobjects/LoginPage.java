package com.efs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.efs.utility.Utility;

public class LoginPage {

	@FindBy(xpath = "//input[@id='username']")
	private WebElement Useraname;

	@FindBy(xpath = "//form//div//input[@id='password']")
	private WebElement Password;

	@FindBy(xpath = "//form//div//button[@type='submit']")
	private WebElement Submit;

	private WebDriver driver;
	private Utility util;

	public LoginPage(WebDriver drive, Utility util) {

		this.driver = drive;
		this.util = util;
		PageFactory.initElements(driver, this);

	}

	public void typeUserName(String userName) {
		// all below methods to send text to form input text is working
		util.elementIsDisplayed(driver, Useraname);
		util.waitForVisibilityOf(driver, Useraname, 10).sendKeys(userName);

//		util.jsSendTexts(driver, userName, Useraname );
//		util.jsScrollIntoView(driver, Useraname).sendKeys(userName);
//		util.elementIsDisplayed(driver, Useraname); Useraname.sendKeys(userName);

	}

	public void typePassword(String pwd) {
//		util.waitForClickable(driver, Password, 10).sendKeys(pwd);
		util.jsScrollIntoView(driver, Password).sendKeys(pwd);

	}

	public void clickOnSubmit() {
//		util.waitForVisibilityOf(driver, Submit, 10).click();
		util.actionsClick(driver, Submit);
	}

}
