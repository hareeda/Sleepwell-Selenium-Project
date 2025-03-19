Feature: Validating the offer link in the Sleepwell website.
				 
	Objective:
  			As a user of the Sleepwell website,
  			I want to verify that clicking on the offer link from the homepage
  			navigates me to the corresponding page containing offers provided by Sleepwell,
  			so that I can view and potentially avail of any current promotions or discounts.

  Scenario: Verify Offer Link Navigation and Content
    Given the user in the Homepage
    When I click the offer link
    Then I validate offer outcomes

 