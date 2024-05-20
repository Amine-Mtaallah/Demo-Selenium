package com.e2etests.automation.step_definitions;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.e2etests.automation.page_objects.LoginPageObject;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	public LoginPageObject loginPageObject;
	public ConfigFileReader configFilReader;

	public LoginStepDefinition() {
		loginPageObject = new LoginPageObject();
		configFilReader = new ConfigFileReader();
	}

	@Given("Je me connecte a l application SWAGLABS")
	public void jeMeConnecteALApplicationSWAGLABS() {
		loginPageObject.connectToApp();
	}

	@When("Je saisis le username")
	public void jeSaisisLeUsername() {
		loginPageObject.username();
	}

	@When("Je saisis le password")
	public void jeSaisisLePassword() {
		loginPageObject.password();
	}

	@When("Je clique sur le bouton login")
	public void jeCliqueSurLeBoutonLogin() {
		loginPageObject.btnlogin();
	}

	@Then("Je me rederige vers la page d acceuil {string}")
	public void jeMeRederigeVersLaPageDAcceuil(String attendu) {
		String obtenu = LoginPageObject.elementpageconnection.getText();
		Assert.assertEquals(attendu, obtenu);
	}

	@Then("Un message d erreur s affiche {string}")
	public void unMessageDErreurSAffiche(String attendu1) {
		String obtenu1=LoginPageObject.elementnonpassant.getText();
		Assert.assertEquals(obtenu1, attendu1);
	    
	}

	@When("Je clique sur le menu principal")
	public void jeCliqueSurLeMenuPrincipal() {
	    loginPageObject.btnmenu();
	}
	@When("Je clique sur Logout de la liste deroulante du menu principal")
	public void jeCliqueSurLogoutDeLaListeDeroulanteDuMenuPrincipal() {
		loginPageObject.btnlogout();
		
	}
	@Then("Je me redirige vers la page d authentification {string}")
	public void jeMeRedirigeVersLaPageDAuthentification(String urlattendu) {
	   String urlobtenu= loginPageObject.urlobtenu();
	   Assert.assertEquals("https://www.saucedemo.com/", urlobtenu);
	}
}
