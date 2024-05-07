package com.e2etests.automation.page_objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SetUp;

public class BuyCartPageObject {
	
	public ConfigFileReader configFileReader;
	public WebDriverWait wait;

	@FindBy(how=How.ID,using="add-to-cart-sauce-labs-bike-light")
	public static WebElement btnaddcart;
	
	@FindBy(how=How.ID,using="remove-sauce-labs-bike-light")
	public static WebElement btnremovecart;
	
	
	@FindBy(how=How.XPATH,using="//div[@id='shopping_cart_container']/a")
	public static WebElement panier;
	
	@FindBy(how=How.ID,using="checkout")
	public static WebElement btnCheckOut;
	
	@FindBy (how=How.ID,using="first-name")
	public static WebElement champFirstName;
	
	@FindBy (how=How.ID,using="last-name")
	public static WebElement champLastName;
	
	@FindBy (how=How.ID,using="postal-code")
	public static WebElement champcodepostal;
	
	@FindBy (how=How.ID,using="continue")
	public static WebElement btnContinue;
	
	@FindBy (how=How.XPATH,using="button[id='finish']")
	public static WebElement btnFinish;
	
	@FindBy (how=How.XPATH,using="//button[@id='back-to-products']")
	public static WebElement btnBackHome;
	
	public static WebElement W;
	
	public BuyCartPageObject() {
		PageFactory.initElements(SetUp.getDriver(), this);
		configFileReader=new ConfigFileReader();
		wait=new WebDriverWait(SetUp.getDriver(), Duration.ofSeconds(10));
		
	}
	
	public void clickaddtocart() {
		btnaddcart.click();
	}
	
	public void clickpanier() {
		panier.click();
	}
	
	public String url(){
		return SetUp.getDriver().getCurrentUrl();
	}
	
	public void clickCheckOut() {
		btnCheckOut.click();
	}
	
	public void saisieFirstName() {
		champFirstName.sendKeys(configFileReader.getProperties("FirstName"));
	}
	
	public void saisieLastName() {
		champLastName.sendKeys(configFileReader.getProperties("LastName"));
	}
	
	public void saisieCodePostal() {
		champcodepostal.sendKeys(configFileReader.getProperties("CodePostal"));
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public void clickBackHome() {
		btnBackHome.click();
	
	}
}
