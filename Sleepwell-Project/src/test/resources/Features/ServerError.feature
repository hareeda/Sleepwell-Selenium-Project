Feature: Verify appropriate error message for server error

	Objective:
         To ensure users are presented with clear and 
         informative error messages when encountering server errors, 
         enhancing user experience and facilitating prompt issue resolution.

  Scenario: User encounters a server error
    Given the user is on the application homepage
    When the user clicks on cart button it triggers a server error
    Then the user should be displayed an appropriate error message
    And the error message should clearly indicate a server error.