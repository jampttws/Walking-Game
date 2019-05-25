import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class World extends Observable {

    private int tick;
    private int size;

    private Player player;
    private Thread thread;
    private boolean notOver;
    private long delayed = 500;
    private int pointNumber = 5;
    private int enemyCount = 10;
    private int sumPoint;

    private Enemy[] enemies;
    private Point[] points;
    private List<Command> histories = new ArrayList<Command>();
    private boolean replayMode = false;

    public World(int size) {
        this.size = size;
        tick = 0;
        sumPoint = 0;
        player = new Player(size/2, size/2);
        enemies = new Enemy[enemyCount];
        points = new Point[pointNumber];

        Random random = new Random();
        for(int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(random.nextInt(size), random.nextInt(size));
            if(i < pointNumber){
                points[i] = new Point(random.nextInt(size), random.nextInt(size));
            }
        }
    }

    public void start() {
        player.reset();
        player.setPosition(size/2, size/2);
        tick = 0;
        sumPoint = 0;
        notOver = true;
        thread = new Thread() {
            @Override
            public void run() {
                while(notOver) {
                    if(replayMode){
                        for(Command c : histories){
                            if(c.getTick() == tick){
                                c.execute();
                            }
                        }
                    }
                    tick++;
                    if(tick%2 ==0) for(Point p : points) p.setPosition(p.getX(), p.getY()-1);
                    else for(Point p : points) p.setPosition(p.getX(), p.getY()+1);
                    player.move();
                    checkCollisions();
                    checkPoint();
                    setChanged();
                    notifyObservers();
                    waitFor(delayed);
                }
            }
        };
        thread.start();
    }

    private void checkCollisions() {
        for(Enemy e : enemies) {
            if(e.hit(player)) {
                notOver = false;
            }
        }
    }

    private void checkPoint(){
        Random ran = new Random();
        for(Point p : points){
            if(p.hit(player)){
                sumPoint += p.getValue();
                p.setPosition(ran.nextInt(size), ran.nextInt(size));
            }
        }
    }

    private void waitFor(long delayed) {
        try {
            Thread.sleep(delayed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getTick() {
        return tick;
    }

    public int getSize() {
        return size;
    }

    public Player getPlayer() {
        return player;
    }

    public void setReplayMode(){
        this.replayMode = true;
    }

    public int getSumPoint() { return this.sumPoint; }

    public void turnPlayerNorth() {
        CommandNorth command = new CommandNorth(tick, player);
        command.execute();
        histories.add(command);
    }

    public void turnPlayerSouth() {
        CommandSouth command = new CommandSouth(tick, player);
        command.execute();
        histories.add(command);
    }

    public void turnPlayerWest() {
        CommandWest command = new CommandWest(tick, player);
        command.execute();
        histories.add(command);
    }

    public void turnPlayerEast() {
        CommandEast command = new CommandEast(tick, player);
        command.execute();
        histories.add(command);
    }

    public List<Command> getHistories(){ return histories; }

    public Enemy[] getEnemies() { return enemies; }

    public Point[] getPoints() { return points; }

    public boolean isGameOver() { return !notOver; }
}
