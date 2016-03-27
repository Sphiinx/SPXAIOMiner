package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.antiban.AntiBan;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public class M1D1 extends Task {

    public M1D1(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        Inventory.drop(vars.oreType.getItemID());
        AntiBan.waitItemInteractionDelay();
    }

    @Override
    public String toString() {
        return "Dropping items" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return Inventory.getCount(vars.oreType.getItemID()) > 0;
    }

}