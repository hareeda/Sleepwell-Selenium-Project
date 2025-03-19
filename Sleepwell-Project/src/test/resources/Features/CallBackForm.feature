Feature: Verifying the call back form filling in saathi page of 
					sleepwell mattress website.
					
	Objective:
         To ensure the callback form on the Saathi page of the 
         Sleepwell mattress website functions correctly by validating its behavior 
         when submitting with and without user details.

	Background: The prerequisites to verify is
		Given the user is in the homepage.
		And user clicks on the menu icon.
		And user clicks on Institutional Enquiry link
		And user clicks on Sleepwell Saathi: Sofa Refurbishment button
		And user click on Mattress@Home button

  Scenario: Verifying that the submit button is disabled if no details are entered.
    When user click on Submit
    Then validates that the button is disabled since no details is entered.

  Scenario Outline: Verifying that after entering all details the call back form is submitted successfully
    When the user enters details 
      | name   | phonenum   | email   | pin   |
      | <name> | <phonenum> | <email> | <pin> | 
    Then validate the submission submited message
    
    Examples:
      | name   |   phonenum |      email       |   pin   |
      | Alina  | 9876543221 | Alin@gmail.com   | 654321  |
      | Deva   | 9871235456 | Deva@gmail.com   | 678943  |
      | Shikha | 9605034617 | Shikha@gmail.com | 678705  |
     