package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.framework.Task;
import TribotAPI.game.utiity.Utility07;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class WalkToQuarry implements Task {

    //<editor-fold defaultstate="collapsed" desc="Execution">
    public void execute() {
        WebWalking.walkTo(Vars.get().area, new Condition() {
            @Override
            public boolean active() {
                General.sleep(100);
                return Vars.get().area.distanceTo(Player.getPosition()) <= Vars.get().radius;
            }
        }, General.random(50, 100));
    }//</editor-fold>

    public String toString() {
        return "Walking to quarry" + Utility07.loadingPeriods();
    }

    //<editor-fold defaultstate="collapsed" desc="Validation">
    public boolean validate() {
        return !Vars.get().isSlaveSystemIsRunning &&
                !Vars.get().isUpgradingPickaxe &&
                !Inventory.isFull() &&
                Vars.get().area.distanceTo(Player.getPosition()) >= Vars.get().radius &&
                (Inventory.getCount(Constants.PICKAXES) > 0 || Equipment.getItem(Equipment.SLOTS.WEAPON) != null);
    }
    //</editor-fold>

}