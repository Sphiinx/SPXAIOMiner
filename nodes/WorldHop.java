package scripts.SPXAIOMiner.nodes;

import org.tribot.api2007.Player;
import org.tribot.api2007.Players;
import org.tribot.api2007.types.RSPlayer;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.API.Game.WorldHopper.WorldHopper07;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/17/2016.
 */
public class WorldHop extends Node {

    RSPlayer[] players;

    public WorldHop(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        if (playerCheck() || vars.shouldWeHop) {
            WorldHopper07.switchWorld(WorldHopper07.getRandomWorld(vars.worlds.getWorlds()));
        }
    }

    private boolean playerCheck() {
        if (vars.playersToHop > 0) {
            players = Players.getAll();
            if (!players.equals(Player.getRSPlayer())) {
                if (players.length > vars.playersToHop) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Hopping worlds...";
    }

    @Override
    public boolean validate() {
        return vars.area.distanceTo(Player.getPosition()) <= vars.radius && Player.getAnimation() == -1 && (vars.playersToHop > 0 || vars.shouldWeHop);
    }

}

