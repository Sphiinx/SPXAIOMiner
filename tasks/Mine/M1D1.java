package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.framework.Task;
import TribotAPI.game.utiity.Utility07;
import TribotAPI.antiban.AntiBan;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public class M1D1 implements Task {

    public void execute() {
        Inventory.drop(Vars.get().oreType.getItemID());
        AntiBan.waitItemInteractionDelay();
    }

    public String toString() {
        return "Dropping items" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return Inventory.getCount(Vars.get().oreType.getItemID()) > 0;
    }

}