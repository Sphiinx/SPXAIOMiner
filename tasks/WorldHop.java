package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Player;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.area.Area07;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.api.game.worldhopper.WorldHopper07;
import scripts.SPXAIOMiner.data.Variables;


/**
 * Created by Sphiinx on 1/17/2016.
 */
public class WorldHop extends Task {

    public WorldHop(Variables v) {
        super(v);
    }

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
    public void execute() {
        if (Area07.getPlayersInArea(vars.radius) > vars.playersToHop || vars.shouldWeHop) {
            int world = vars.worlds.getRandomWorld();
            if (WorldHopper07.switchWorld(world)) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        return Utility07.getCurrentWorld() == world;
                    }
                }, General.random(5500, 6500));
            }
        }
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