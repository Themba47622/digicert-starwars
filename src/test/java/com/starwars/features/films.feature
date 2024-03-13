Feature: Star Wars Films Tests (API)

  @sanity-api
  Scenario: Get the list of movies and check if the movies count is 6
    When I send a GET request to "https://swapi-node.now.sh/api/films"
    Then the response status should be "200"
    And the JSON response "count" equals "6"

  @sanity-api
  Scenario: Get the 3rd movie and check if the director of the movie is ‘Richard Marquand’
    When I send a GET request to "https://swapi-node.now.sh/api/films/3"
    Then the response status should be "200"
    And the JSON response "fields.director" equals "Richard Marquand"

  @sanity-api
  Scenario: Get the 5th movie and assert that ’Producers’ are not ‘Gary Kurtz, George Lucas'
    When I send a GET request to "https://swapi-node.now.sh/api/films/5"
    Then the response status should be "200"
    And the JSON response "fields.producer" is not equals "Gary Kurtz, George Lucas"