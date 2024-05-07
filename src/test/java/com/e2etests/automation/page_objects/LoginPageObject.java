package com.e2etests.automation.page_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SetUp;

public class LoginPageObject {

	public ConfigFileReader configFileReader; // creation d'un objet pour l'utilisation d'une classe dans une autre
												// class

	@FindBy(how = How.ID, using = "user-name") // recherche des element a travers des annotations: creation des FindBy
												// // puis creation de l'element
	public static WebElement username;

	@FindBy(how = How.ID, using = "password")
	public static WebElement password;

	@FindBy(how = How.ID, using = "login-button")
	public static WebElement btnlogin;

	@FindBy(how = How.XPATH, using = "//span[@class='title']")
	public static WebElement elementpageconnection;

	@FindBy(how = How.XPATH, using = "//div[@id='login_button_container']//form//h3")
	public static WebElement elementnonpassant;

	@FindBy(how = How.ID, using = "react-burger-menu-btn")
	public static WebElement btnmenu;

	@FindBy(how = How.ID, using = "logout_sidebar_link")
	public static WebElement btnlogout;

	public LoginPageObject() { // creation du constructeur + initialitation du driver
		PageFactory.initElements(SetUp.getDriver(), this);
		configFileReader = new ConfigFileReader();

	}

	public void connectToApp() {
		SetUp.getDriver().get(configFileReader.getProperties("url"));
	}

	public void username() {
		username.sendKeys(configFileReader.getProperties("username"));
	}

	public void password() {
		password.sendKeys(configFileReader.getProperties("password"));
	}

	public void btnlogin() {
		btnlogin.click();
	}

	public void btnmenu() {
		btnmenu.click();
	}
	
	public void btnlogout() {
		WebDriverWait wait = new WebDriverWait(SetUp.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnlogout));
		btnlogout.click();
	}

	public String urlobtenu() {
		return SetUp.getDriver().getCurrentUrl();
	}

}
