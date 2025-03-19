Feature: Verifying the find showroom feature in the sleepwell mattress website.

	Objective:
				The Find Showroom feature on the Sleepwell mattress website allows users 
				to locate Sleepwell showrooms based on their chosen city and area. 
				The feature enhances user experience by providing convenience in finding nearby stores. 

	Background: The prerequisites to verify is
		Given the user is in  homepage.
		And user clicks on Find Showroom and navigates to the store locator page.
		
  Scenario: Verify the sleepwell mattress store near to the given location
     When user select a city "TRIVANDRUM"
     And user select an area "KAZHAKUTTOM"
     Then validate that the store near to given area is displayed 
     
  Scenario: Verifying that error message is shown if invalid city is given
    When user select a city "PARIPALLY"
    Then validate that an error is shown
     
     
       
 


