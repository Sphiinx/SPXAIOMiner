package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Player;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.framework.Task;
import TribotAPI.game.area.Area07;
import TribotAPI.game.worldhopper.WorldHopper07;
import TribotAPI.game.utiity.GetWorlds07;
import TribotAPI.game.utiity.Utility07;


/**
 * Created by Sphiinx on 1/17/2016.
 */
public class WorldHop implements Task {

    private int[] worlds;

    //<editor-fold defaultstate="collapsed" desc="Execution">
    public void execute() {
        Vars.get().isHoppingWorlds = true;
        if (worlds == null) {
            if (GetWorlds07.isWorldSwitcherOpen()) {
                worlds = GetWorlds07.getWorlds(Vars.get().worldType.getTextureID());
            } else {
                GetWorlds07.openWorldSwitcher();
            }
        } else {
            if (Area07.getPlayersInArea(Vars.get().radius) > Vars.get().playersToHop || Vars.get().shouldWeHop) {
                if (worlds != null) {
                    int world = worlds[General.random(0, worlds.length - 1)];
                    if (WorldHopper07.switchWorld(world)) {
                        if (Timing.waitCondition(new Condition() {
                            @Override
                            public boolean active() {
                                return Utility07.getCurrentWorld() == world;
                            }
                        }, General.random(5500, 6500))) {
                            Vars.get().isHoppingWorlds = false;
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    public String toString() {
        return "Changing worlds" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return Vars.get().area.distanceTo(Player.getPosition()) <= Vars.get().radius && Player.getAnimation() == -1 && (Vars.get().playersToHop > 0 || Vars.get().shouldWeHop);
    }

}