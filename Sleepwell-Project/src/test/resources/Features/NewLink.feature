Feature: Verify clicking New link takes us to new products page.
				 
	Objective:
  			As a user of the shopping website,
  			I want to verify that clicking on the New link on the homepage
  			navigates me to a dedicated page displaying new products,
  			so that I can easily discover and explore the latest offerings.

  Scenario: Verify New Link Navigation and Content
    Given the user in the homepage
    When I click the new page link
    Then I validate the new page outcomes