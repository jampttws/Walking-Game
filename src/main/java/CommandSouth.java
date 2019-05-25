public class CommandSouth extends Command{

    public CommandSouth(int tick, Player player){
        super(tick, player);
    }

    @Override
    public void execute(){ getPlayer().turnSouth(); }

    @Override
    public String toString(){ return "CommandSouth"; }

}
