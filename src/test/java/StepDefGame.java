import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefGame {

    private Player player;
    private Enemy enemy;
    private Point point;
    private World world;
    private int totalPoint;
    private int checkPoint;
    private List<String> checkHistory;

    @Before
    public void init() {
        player = new Player(1, 1);
        enemy = new Enemy(1, 1);
        point = new Point(1, 1);
        world = new World(10);
        totalPoint = 0;
        checkPoint = 0;
        checkHistory = new ArrayList<String>();
    }

    @Given("player position is x = (\\d+), y = (\\d+)")
    public void player_is_in_position(int x, int y){
        player.setPosition(x, y);
    }

   @When("I click to walk up")
    public void I_click_walk_up(){
        player.turnNorth();
        player.move();
   }

    @When("I click to walk down")
    public void I_click_walk_down(){
        player.turnSouth();
        player.move();
    }

    @When("I click to walk to the right side")
    public void I_click_walk_right(){
        player.turnEast();
        player.move();
    }

    @When("I click to walk to the left side")
    public void I_click_walk_left(){
        player.turnWest();
        player.move();
    }

    @Then("player position will be x = (\\d+), y = (\\d+)")
    public void current_position_will_be(int x, int y){
        assertEquals(x, player.getX());
        assertEquals(y, player.getY());
   }

   @Given("an enemy is in position x = (\\d+), y = (\\d+)")
    public void an_enemy_is_in_position(int x, int y){
        enemy.setPosition(x, y);
   }

   @When("player attack with enemy")
    public void player_attack_with_enemy(){
        player.setPosition(enemy.getX(), enemy.getY());
   }

   @Then("game is over")
    public void game_is_over(){
        assertTrue(enemy.hit(player));
   }

   @Given("point is in position x = (\\d+), y = (\\d+)")
    public void point_is_in_position(int x, int y) {
        point.setPosition(x, y);
   }

   @When("player is attacked point")
    public void player_is_attacked_point() {
        player.setPosition(point.getX(), point.getY());
        if(player.hit(point)) totalPoint += point.getValue();
    }

    @Then("total point increase (\\d+) point")
    public void total_point_increase(int p){
        assertEquals(checkPoint+p, totalPoint);
    }

    @Given("Walk to the (.+) (\\d+) tick")
    public void walk_to_which_way(String way, int tick){
        for(int i = 0; i < tick; i++){
            if(way.equals("West")) {
                world.turnPlayerWest();
                checkHistory.add("CommandWest");
            } else if(way.equals("East")){
                world.turnPlayerEast();
                checkHistory.add("CommandEast");
            } else if(way.equals("South")) {
                world.turnPlayerSouth();
                checkHistory.add("CommandSouth");
            } else if(way.equals("North")){
                world.turnPlayerNorth();
                checkHistory.add("CommandNorth");
            }
        }
    }

    @Then("history collection will have any command with (\\d+) ticks")
    public void history_collection_will_have_command_with_tick(int tick){
        assertEquals(tick, world.getHistories().size());
        for(int i = 0; i < tick; i++){
            assertEquals(checkHistory.get(i), world.getHistories().get(i).toString());
        }
    }






}
