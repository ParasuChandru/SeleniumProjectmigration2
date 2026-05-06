Feature: MyAccount-Login Feature
  Description: This feature will test a Login feature

  #Simple login without parameters
	Scenario: Log-in with valid username and password 
	Given Open the browser
	When Enter the URL "http://automationtesting.com/"
	And Click on My Account Menu
	And Enter registered username and password
	And Click on login button
	Then User must successfully login to the web page