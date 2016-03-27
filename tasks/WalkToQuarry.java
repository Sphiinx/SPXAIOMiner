package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.Constants;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class WalkToQuarry extends Task {

    public WalkToQuarry(Variables v) {
        super(v);
    }

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
    public void execute() {
        WebWalking.walkTo(vars.area, new Condition() {
            @Override
            public boolean active() {
                General.sleep(100);
                return vars.area.distanceTo(Player.getPosition()) <= vars.radius;
            }
        }, General.random(50, 100));
    }//</editor-fold>

    @Override
    public String toString() {
        return "Walking to quarry" + Utility07.loadingPeriods();
    }

    //<editor-fold defaultstate="collapsed" desc="Validation">
    @Override
    public boolean validate() {
        return !vars.isSlaveSystemIsRunning &&
                !vars.isUpgradingPickaxe &&
                !Inventory.isFull() &&
                vars.area.distanceTo(Player.getPosition()) >= vars.radius &&
                (Inventory.getCount(Constants.PICKAXES) > 0 || Equipment.getItem(Equipment.SLOTS.WEAPON) != null);
    }
    //</editor-fold>

}