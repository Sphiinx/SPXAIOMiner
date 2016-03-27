package scripts.SPXAIOMiner.tasks.MuleSystem;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Players;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.banking.Banking07;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.api.game.worldhopper.WorldHopper07;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/3/2016.
 */
public class WalkToMaster extends Task {

    public WalkToMaster(Variables v) {
        super(v);
    }

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
    public void execute() {
        if (Utility07.getCurrentWorld() != vars.masterWorld) {
            Banking07.closeBank();
            if (WorldHopper07.switchWorld(vars.masterWorld)) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return Utility07.getCurrentWorld() == vars.masterWorld;
                    }
                }, General.random(2000, 2500));
            }
        } else {
            WebWalking.walkTo(getPos());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GetPosition">
    public RSTile getPos() {
        String tileString = vars.masterPositon.replaceAll("[()]", "");
        String[] tileStringArr = tileString.split(",");
        int x = Integer.parseInt(tileStringArr[0].trim());
        int y = Integer.parseInt(tileStringArr[1].trim());
        int plane = Integer.parseInt(tileStringArr[2].trim());
        return new RSTile(x, y, plane);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Walking to Master" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        vars.master = Players.find(vars.masterName);
        return vars.isSlaveSystemIsRunning && vars.master.length <= 0 && Inventory.getCount(vars.oreType.getNotedItemID()) >= vars.resetOresMined;
    }

}