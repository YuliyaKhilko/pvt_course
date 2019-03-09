Feature: Test hotel rating 

@Tag1
Scenario Outline: Check that toprated hotel rating is higher then 8.0 
	Given I am on main page 
	When I type "<city>" in search field 
	And I select "<number1>" of adults 
	And I select "<number2>" of rooms 
	And I click Search button 
	And I select sorting by stars descending 
	And I open details of first hotel 
	Then I see that hotel rating is higher than "<rating>" 
	Examples: 
		|city|number1|number2|rating|
		|Moscow|2|1|8.0|
		|Moscow|4|2|8.5|
