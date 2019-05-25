Feature: Collecting point
  As a player
  I want to collect a point
  so that my point will be increase

Scenario: Get point
  Given point is in position x = 3, y = 5
  When player is attacked point
  Then total point increase 1 point