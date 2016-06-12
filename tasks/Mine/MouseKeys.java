package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.framework.Task;
import scripts.TribotAPI.game.inventory.Inventory07;
import scripts.TribotAPI.game.utiity.Utility07;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public class MouseKeys implements Task {

    public void execute() {
        if (Inventory07.mouseKeysDropAllExcept(Constants.PICKAXES)) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    General.sleep(100);
                    return !Inventory.isFull();
                }
            }, General.random(2000, 2500));
        }
    }

    public String toString() {
        return "Dropping items" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return Inventory.isFull();
    }

}