Feature: Replay
  As a player
  I want to see my playing history
  so that I can watch replay
  
Background: walking 
  Given player position is x = 1, y = 1
  And Walk to the West 2 tick
  And Walk to the North 1 tick
  And Walk to the East 2 tick

Scenario: history
  When game is over
  Then history collection will have any command with 5 ticks
  
  