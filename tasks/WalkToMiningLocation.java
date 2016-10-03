package scripts.spxaiominer.tasks;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSObject;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.game.skills.mining.Mining07;
import scripts.tribotapi.game.objects.Objects07;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class WalkToMiningLocation implements Task {


    @Override
    public boolean validate() {
        if (Vars.get().is_upgrading_pickaxe)
            return false;

        final RSObject ore = Objects07.getObjectByColorInArea(Vars.get().mining_location_tile, Vars.get().radius, Vars.get().ore_type.getColor(), true);
        return !Vars.get().is_transferring && (ore == null && Player.getPosition().distanceTo(Vars.get().mining_location_tile) > Vars.get().radius) && !Inventory.isFull() && Mining07.getBestUsablePickaxe(false) != null;
    }

    @Override
    public void execute() {
        WebWalking.walkTo(Vars.get().mining_location_tile, new Condition() {
            @Override
            public boolean active() {
                final RSObject ore = Objects07.getObjectByColorInArea(Vars.get().mining_location_tile, Vars.get().radius, Vars.get().ore_type.getColor(), true);
                return ore != null && ore.isOnScreen();
            }
        }, 250);
    }

    @Override
    public String toString() {
        return "Walking to mining location";
    }

}

