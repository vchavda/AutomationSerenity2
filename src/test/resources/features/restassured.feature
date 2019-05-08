Feature: Testing different features

  Background:
    Given I am connected to the database

  @vijay
  Scenario Outline: response code is validated when an API call is made
    Given I submit dynamic query parameters
      | queryParam     | queryParamValue                                    |
      | q              | london                                             |
      | X-RapidAPI-Key | 939b2a40eamsh167250aef50fb89p11a291jsn1dfd0debd5d6 |

    Given I submit dynamic headers
      | headerType     | headerValue                                        |
      | X-RapidAPI-Key | 939b2a40eamsh167250aef50fb89p11a291jsn1dfd0debd5d6 |

    When I submit an API call with this path '/forecast'
    Then I should get a valid response of: '<value>'
    And  the response should contain this '<node>' and '<nodevalue>'

    Examples:
      | value | node | nodevalue |
      | 200   | cod  | 200       |


    Scenario: To make a call to static json
      When I submit a static API Call
      Then I should get a valid response of: '200'
      And  the response should contain this 'surname' and 'Bloggs'


      #Scenario: To make a wiremock call
       #\\\\ When I submit a wiremock API call
