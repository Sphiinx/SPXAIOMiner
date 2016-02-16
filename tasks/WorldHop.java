package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Player;
import org.tribot.api2007.Players;
import org.tribot.api2007.types.RSPlayer;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.API.Game.WorldHopper.WorldHopper07;
import scripts.SPXAIOMiner.data.Variables;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 1/17/2016.
 */
public class WorldHop extends Task {

    private ArrayList<RSPlayer> playerList = new ArrayList<>();

    public WorldHop(Variables v) {
        super(v);
    }

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
    public void execute() {
        if (playerCheck() || vars.shouldWeHop) {
            General.println(playerList.toString());
            int world = vars.worlds.getRandomWorld();
            if (WorldHopper07.switchWorld(world)) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        return Utility07.getCurrentWorld() == world;
                    }
                }, General.random(4500, 6500));
                playerList.clear();
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="PlayerCheck">
    private boolean playerCheck() {
        if (Player.getRSPlayer().getName() != null) {
            final String playerName = Player.getRSPlayer().getName();
            if (vars.playersToHop > 0) {
                RSPlayer[] players = Players.getAll();
                for (RSPlayer player : players) {
                    if (!player.getName().equals(playerName)) {
                        if (player.getPosition().distanceTo(Player.getRSPlayer().getPosition()) <= vars.radius) {
                            playerList.add(player);
                            if (playerList.size() > vars.playersToHop) {
                                return true;
                            }
                        } else {
                            if (playerList.contains(player)) {
                                playerList.remove(player);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Hopping worlds" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return vars.area.distanceTo(Player.getPosition()) <= vars.radius && Player.getAnimation() == -1 && (vars.playersToHop > 0 || vars.shouldWeHop);
    }

}

