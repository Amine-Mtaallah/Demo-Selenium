@connexion
Feature: Tester le connection a la page d acceuil de l application SWAGLABS
  Autant que utilisateur je souhaite Tester le connection a la page d acceuil de l application SWAGLABS

  Background: Je souhaite me connecter a l apllication SWAGLABS
    Given Je me connecte a l application SWAGLABS
    When Je saisis le username
    And Je saisis le password
    And Je clique sur le bouton login

  @connection-cas-passant
  Scenario: Connection a la page d acceuil avec un cas passant
    
    Autant que utilisateur je souhaite Tester le connection a la page d acceuil de l application SWAGLABS avec un cas passant

    Then Je me rederige vers la page d acceuil "Products"

  @connection-multi-comptes
  Scenario Outline: Connection multi Comptes
    
    Autant que utilisateur je souhaite Tester le connection a la page d acceuil de l application SWAGLABS avec plusieurs comptes

    Then Je me rederige vers la page d acceuil "Products"

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  @connexion-cas-non-passant
  Scenario: Je souhaite tester la connexion de l application avec un cas non passant
    
    Autant que utilisateur je souhaite Tester le connection a la page d acceuil de l application SWAGLABS avec un cas non passant

    Then Un message d erreur s affiche "Epic sadface: Username and password do not match any user in this service"

  @deconnection
  Scenario: Deconnection et redirection a la page d authentification
    
    Autant que utilisateur je souhaite me deconnecter de la page d acceuil et me rediriger vers la page d authentification

    And Je me rederige vers la page d acceuil "Products"
    And Je clique sur le menu principal
    And Je clique sur Logout de la liste deroulante du menu principal
    Then Je me redirige vers la page d authentification "url"
