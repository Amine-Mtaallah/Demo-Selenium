package com.e2etests.automation.step_definitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.page_objects.BuyCartPageObject;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SetUp;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyCartStepDefinition {

	public BuyCartPageObject buyCartPageObject;
	public ConfigFileReader configFileReader;
	public WebDriverWait wait;

	public BuyCartStepDefinition() {
		buyCartPageObject = new BuyCartPageObject();
		configFileReader = new ConfigFileReader();
		wait = new WebDriverWait(SetUp.getDriver(), Duration.ofSeconds(10));
	}

	@When("Je clique sur Add to cart du Bike Light")
	public void jeCliqueSurAddToCartDuBikeLight() {
		buyCartPageObject.clickaddtocart();
	}

	@Then("Le bouton Add to cart devient {string}")
	public void leBoutonAddToCartDevient(String msgremove) {

		String msgremoveOB = buyCartPageObject.btnremovecart.getText();
		Assert.assertEquals(msgremoveOB, msgremove);
	}

	@Then("Le bouton Remove soit rouge {string}")
	public void leBoutonRemoveSoitRouge(String string) {

		String colorobtenu = buyCartPageObject.btnremovecart.getCssValue(configFileReader.getProperties("c"));
		Color c1 = Color.fromString(colorobtenu);
		String c2 = c1.asHex();
		Assert.assertEquals(c2, "#e2231a");
	}

	@Then("Un produit s ajout et le panier affiche le numero {string}")
	public void unProduitSAjoutEtLePanierAfficheLeNumero(String string) {
		String msgpanier = buyCartPageObject.panier.getText();
		configFileReader.getProperties("numeroPanier");
		Assert.assertEquals(msgpanier, "1");
	}

	@Then("Je clique sur l icone du chariot")
	public void jeCliqueSurLIconeDuChariot() {
		buyCartPageObject.clickpanier();
	}

	@Then("Je me rederige vers la page Your Cart")
	public void jeMeRederigeVersLaPageYourCart() {
		String obtenuYourCart = buyCartPageObject.url();
		Assert.assertEquals(obtenuYourCart, configFileReader.getProperties("urlYourCart"));
	}

	@Then("Je clique sur le bouton Checkout")
	public void jeCliqueSurLeBoutonCheckout() {
		buyCartPageObject.clickCheckOut();
	}

	@Then("Je me rederige vers la page Checkout: Your Information")
	public void jeMeRederigeVersLaPageCheckoutYourInformation() {
		String obtenuYourInformation = buyCartPageObject.url();
		Assert.assertEquals(obtenuYourInformation, configFileReader.getProperties("urlYourInformation"));
	}

	@Then("Je remplis le champ First Name")
	public void jeRemplisLeChampFirstName() {
		buyCartPageObject.saisieFirstName();
	}

	@Then("Je remplis le champ Last Name")
	public void jeRemplisLeChampLastName() {
		buyCartPageObject.saisieLastName();
	}

	@Then("Je remplis le champ Zip Postal Code")
	public void jeRemplisLeChampZipPostalCode() {
		buyCartPageObject.saisieCodePostal();
	}

	@Then("Je clique sur continuer")
	public void jeCliqueSurContinuer() {
		buyCartPageObject.clickContinue();
	}

	@Then("Je me rederige vers la page Checkout:Overview")
	public void jeMeRederigeVersLaPageCheckoutOverview() {
		String obtenuOverview = buyCartPageObject.url();
		Assert.assertEquals(obtenuOverview, configFileReader.getProperties("urlOverview"));
	}

	@Then("Je clique sur le bouton Finish")
	public void jeCliqueSurLeBoutonFinish() {
		((JavascriptExecutor) SetUp.getDriver()).executeScript("window.scrollBy(0,600)", "");
		WebElement W = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='finish']")));
		W.click();
	}

	@Then("Je me rederige vers la page Checkout:Complete!")
	public void jeMeRederigeVersLaPageCheckoutComplete() {
		String obtenuComplete = buyCartPageObject.url();
		Assert.assertEquals(obtenuComplete, configFileReader.getProperties("urlColmplete"));
	}

	@Then("Je clique sur le bouton Back Home")
	public void jeCliqueSurLeBoutonBackHome() {
		buyCartPageObject.clickBackHome();
	}

	@Then("Je me rederige vers la page Products")
	public void jeMeRederigeVersLaPageProducts() {
		String obtenuBackHome = buyCartPageObject.url();
		Assert.assertEquals(obtenuBackHome, configFileReader.getProperties("urlProducts"));
	}

}
