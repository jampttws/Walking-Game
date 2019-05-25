Feature: walk
  As a player
  I want myself to walk in the frame
  so that I can play game

Background: Set starter position
  Given player position is x = 1, y = 1

Scenario: Walk up
  When I click to walk up
  Then player position will be x = 1, y = 0

Scenario: Walk down
  When I click to walk down
  Then player position will be x = 1, y = 2

Scenario: Walk right
  When I click to walk to the right side
  Then player position will be x = 2, y = 1

Scenario:  Walk left
  When I click to walk to the left side
  Then player position will be x = 0, y = 1

