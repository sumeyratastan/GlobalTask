@smoke
Feature: Shopping feature
  User Story: User should be able to add items to shopping bag and update,check cart


  Scenario: Verify that user can add items to the cart
    When user open the "url"
    And user add "4" of "Gwyn Endurance Tee" to basket
    And user should see the adress is "United Kingdom"
    And user check the cart total is "$92.00"
    And user update the "3" of " Gwyn Endurance Tee"
    And user add "Gwyn Endurance Tee" to basket
    Then user checks all items price is "$116.00"

