Feature: Game over
  As a creater
  I want player die when they attack with enemy
  so that game will be over

Scenario: Attack enemy
  Given an enemy is in position x = 2, y = 2
  When player attack with enemy
  Then game is over

