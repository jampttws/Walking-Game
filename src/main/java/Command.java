public abstract class Command {

    private int tick;
    private Player player;


    public Command(int tick, Player player){
        this.tick = tick;
        this.player = player;
    }

    public abstract void execute();

    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public int getTick(){
        return this.tick;
    }

    public void setTick(int tick){
        this.tick = tick;
    }

    public abstract String toString();


}
