package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.framework.Task;
import scripts.TribotAPI.game.inventory.Inventory07;
import scripts.TribotAPI.game.utiity.Utility07;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public class DropUnwanted implements Task {

    public void execute() {
        Inventory.drop(Constants.GEMS);
    }

    public String toString() {
        return "Dropping items" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return Inventory.getCount(Constants.GEMS) > 0;
    }

}