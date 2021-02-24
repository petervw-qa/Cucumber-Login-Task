Feature: Use Login Feature On DemoSite

	Scenario: Register and Login on DemoSite
		Given That I can access the demosite
		When I click on the register tab
		And I register a user
		And I register a password
		And I click on the login tab
		And I enter my user details
		And I enter my password details
		And I click login
		Then I should be able to log in successfully