$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/replay.feature");
formatter.feature({
  "line": 1,
  "name": "Replay",
  "description": "As a player\nI want to see my playing history\nso that I can watch replay",
  "id": "replay",
  "keyword": "Feature"
});
formatter.before({
  "duration": 940868,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "walking",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "player position is x \u003d 1, y \u003d 1",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Walk to the West 2 tick",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Walk to the North 1 tick",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Walk to the East 2 tick",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 23
    },
    {
      "val": "1",
      "offset": 30
    }
  ],
  "location": "StepDefGame.player_is_in_position(int,int)"
});
formatter.result({
  "duration": 229102853,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "West",
      "offset": 12
    },
    {
      "val": "2",
      "offset": 17
    }
  ],
  "location": "StepDefGame.walk_to_which_way(String,int)"
});
formatter.result({
  "duration": 6237418,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "North",
      "offset": 12
    },
    {
      "val": "1",
      "offset": 18
    }
  ],
  "location": "StepDefGame.walk_to_which_way(String,int)"
});
formatter.result({
  "duration": 252088,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "East",
      "offset": 12
    },
    {
      "val": "2",
      "offset": 17
    }
  ],
  "location": "StepDefGame.walk_to_which_way(String,int)"
});
formatter.result({
  "duration": 267286,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "history",
  "description": "",
  "id": "replay;history",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "game is over",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "history collection will have any command with 5 ticks",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefGame.game_is_over()"
});
formatter.result({
  "duration": 5334662,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 46
    }
  ],
  "location": "StepDefGame.history_collection_will_have_command_with_tick(int)"
});
formatter.result({
  "duration": 5010963,
  "status": "passed"
});
});