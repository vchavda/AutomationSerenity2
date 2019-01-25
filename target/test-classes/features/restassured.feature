Feature: Testing different features 

@vijay 
Scenario: Check the API call returns 200 
	When user makes an API call then they get a valid status code back 
	
Scenario Outline: response code is validated when an API call is made 
	Given I submit dynamic query parameters 
		|queryParam	|queryParamValue						|
		|query		|Churchgate								|
		|key		|AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg|
		
	When I submit an API call 
	Then I should get a valid response of: '<value>' 
	And  the response should contain this '<node>' and '<nodevalue>' 
	
	Examples: 
		|	value		| node 		| nodevalue 	|
		|	200			| name		| [Churchgate]	|
