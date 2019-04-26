Feature: Testing different features

  Background:
    Given I am connected to the database

  @vijay
  Scenario: Check the API call returns 200
    When user makes an API call then they get a valid status code back

  Scenario Outline: response code is validated when an API call is made
    Given I submit dynamic query parameters
      | queryParam     | queryParamValue                                    |
      | q              | london                                             |
      | X-RapidAPI-Key | 939b2a40eamsh167250aef50fb89p11a291jsn1dfd0debd5d6 |

    Given I submit dynamic headers
      | headerType     | headerValue                                        |
      | X-RapidAPI-Key | 939b2a40eamsh167250aef50fb89p11a291jsn1dfd0debd5d6 |

    When I submit an API call
    Then I should get a valid response of: '<value>'
    And  the response should contain this '<node>' and '<nodevalue>'

    Examples:
      | value | node | nodevalue |
      | 200   | cod  | 200       |



