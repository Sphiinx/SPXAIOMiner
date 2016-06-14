package scripts.SPXAIOMiner.tasks.MuleSystem;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Players;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.framework.Task;
import TribotAPI.game.banking.Banking07;
import TribotAPI.game.utiity.Utility07;
import TribotAPI.game.worldhopper.WorldHopper07;

/**
 * Created by Sphiinx on 2/3/2016.
 */
public class WalkToMaster implements Task {

    //<editor-fold defaultstate="collapsed" desc="Execution">
    public void execute() {
        if (Utility07.getCurrentWorld() != Vars.get().masterWorld) {
            Banking07.closeBank();
            if (WorldHopper07.switchWorld(Vars.get().masterWorld)) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return Utility07.getCurrentWorld() == Vars.get().masterWorld;
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
        String tileString = Vars.get().masterPositon.replaceAll("[()]", "");
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
        Vars.get().master = Players.find(Vars.get().masterName);
        return Vars.get().isSlaveSystemIsRunning && Vars.get().master.length <= 0 && Inventory.getCount(Vars.get().oreType.getNotedItemID()) >= Vars.get().resetOresMined;
    }

}