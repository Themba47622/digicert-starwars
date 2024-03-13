Feature: Star Wars Films Tests (GUI)

  @sanity-ui
  Scenario: Sort movies by ’Title’ and assert the last movie in the list is ‘The Phantom Menace’
    Given I am on the Star Wars films landing page
    When I sort movies by the Title
    Then The last movie displayed should be "The Phantom Menace"

  @sanity-ui
  Scenario: View the movie ‘The Empire Strikes Back’ and check if the ‘Species’ list has ‘Wookie’
    Given I am on the Star Wars films landing page
    When I select the The Empire Strikes Back movie
    Then The specie "Wookie" should be on the Species table list

  @sanity-ui
  Scenario: Assert that ‘Planets’ ‘Camino’ is not part of the movie ‘The Phantom Menace’
    Given I am on the Star Wars films landing page
    When I select the The Phantom Menace movie
    Then The planet "Camino" should not be on the Planets table list