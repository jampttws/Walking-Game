public class CommandNorth extends Command {

    public CommandNorth(int tick, Player player){
        super(tick, player);
    }

    @Override
    public void execute(){ getPlayer().turnNorth(); }

    @Override
    public String toString(){ return "CommandNorth"; }

}
