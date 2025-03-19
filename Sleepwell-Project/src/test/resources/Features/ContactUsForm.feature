Feature: Verifying the contact us form filling in saathi page of 
				 sleepwell mattress website.
				 
	Objective:
         To ensure the contact us form on the Saathi page of the 
         Sleepwell mattress website functions correctly by validating its behavior 
         when submitting with and without user details.

	Background: 
		Given the user in the homepage.
		And user clicks on menu icon.
		And user clicks on Institutional Enquiry
		And user clicks on Sleepwell Saathi: Sofa Refurbishment

  Scenario: Verifying that the submit button is disabled if no details is entered.
    When user clicks on Submit
    Then validate that the button is disabled since no data is entered.

  Scenario Outline: Verifying that after entering all details the form is submitted successfully
    When user enters details
      | firstname   | lastname   | email   | number   | message                                 |
      | <firstname> | <lastname> | <email> | <number> | <message>                               |
    Then validate the submission submitted message

    Examples:
      | firstname | lastname | email           | number      | message                                             |
      | Alina     | Mary     | Alin@gmail.com  | 9876543212  | Hey, We had a requirement for 100 spring mattresses |
      | John      | Doe      | john@gmail.com  | 1234567890  | Hi, I am interested in your furniture products      |
      
      
      