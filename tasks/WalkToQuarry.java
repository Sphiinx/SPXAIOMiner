package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.enums.Location;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class WalkToQuarry extends Task {

    public WalkToQuarry(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        if (vars.area.equals(Location.SHILO_VILLAGE.getArea())) {
            Walking.walkPath(Walking.invertPath(Walking.randomizePath(Constants.SHILO_VILLAGE_PATH, 2, 2)));
            } else {
            WebWalking.walkTo(vars.area, new Condition() {
                @Override
                public boolean active() {
                    General.sleep(100);
                    return vars.area.distanceTo(Player.getPosition()) <= vars.radius;
                }
            }, General.random(50, 100));
        }
    }

    @Override
    public String toString() {
        return "Walking to quarry" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return !vars.isSlaveSystemIsRunning && !vars.isUpgradingPickaxe &&
                !Inventory.isFull() && vars.area.distanceTo(Player.getPosition()) >= vars.radius &&
                Equipment.getItem(Equipment.SLOTS.WEAPON) != null;
    }

}

