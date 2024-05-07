@buy-cart
Feature: Selectionner un produit et l acheter
  Autant que utilisateur je jeux selectionner un produit de la page d acceuil

  Background: Je souhaite me connecter et acheter un produit
    Given Je me connecte a l application SWAGLABS
    When Je saisis le username
    When Je saisis le password
    And Je clique sur le bouton login
    And Je me rederige vers la page d acceuil "Products"
    And Je clique sur Add to cart du Bike Light

  @select-one-cart
  Scenario: Selectionner un seule produit
    Then Le bouton Add to cart devient "Remove"
    Then Le bouton Remove soit rouge "#e2231a"

  @verification-panier
  Scenario: Verifier l ajout du produit au panier
    Then Le bouton Add to cart devient "Remove"
    Then Le bouton Remove soit rouge "#e2231a"
    Then Un produit s ajout et le panier affiche le numero "1"

  @confirmation-achat
  Scenario: Verifier le processus d achat complet
    Then Je clique sur l icone du chariot
    Then Je me rederige vers la page Your Cart
    Then Je clique sur le bouton Checkout
    And Je me rederige vers la page Checkout: Your Information
    And Je remplis le champ First Name
    And Je remplis le champ Last Name
    And Je remplis le champ Zip Postal Code
    And Je clique sur continuer
    And Je me rederige vers la page Checkout:Overview
    And Je clique sur le bouton Finish
    And Je me rederige vers la page Checkout:Complete!
    Then Je clique sur le bouton Back Home
    Then Je me rederige vers la page Products
