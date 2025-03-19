Feature: Warranty Registration

  Background: 
    Given the user is on the homepage
    When the user clicks on the menu bar
    And the user clicks Warranty Registration from the menu
    And the user should see the warranty registration form

  Scenario Outline: Invalid data displays appropriate error messages
    When the user selects Amazon as the purchase source
    And the user enters "<SerialNumber>" in the serial number field
    And the user enters "<DateOfPurchase>" in the date of purchase field
    And the user enters "<FirstName>" in the first name field
    And the user enters "<LastName>" in the last name field
    And the user enters "<Email>" in the email ID field
    And the user enters "<MobileNumber>" in the mobile number field
    And the user enters "<Pincode>" in the pincode field
    And the user clicks the Register button
    Then the user should see a serial number error message "<ErrorMessage1>"

    And the user enters "<InvalidMobileNumber>" in the mobile number field
    And the user clicks the Register button again
    Then the user should see a mobile error message "<ErrorMessage2>"

    Examples: 
      | PurchaseSource | SerialNumber | DateOfPurchase | FirstName | LastName | Email                | MobileNumber | Pincode | ErrorMessage1           | InvalidMobileNumber | ErrorMessage2          |
      | Amazon         | 12354667     | 06/08/2024     | John      | Doe      | john.doe@example.com | 9876543210   | 691571  | Serial number not found | 123456677           | Invalid Mobile number  |

