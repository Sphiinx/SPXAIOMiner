package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.framework.Task;
import TribotAPI.game.utiity.Utility07;

/**
 * Created by Sphiinx on 1/17/2016.
 */
public class Powermine implements Task {

    public void execute() {
        Inventory.drop(Vars.get().oreType.getItemID());
    }

    public String toString() {
        return "Dropping items" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return Inventory.isFull();
    }

}