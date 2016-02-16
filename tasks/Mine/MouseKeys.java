package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Inventory.Inventory07;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public class MouseKeys extends Task {

    public MouseKeys(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        if (Inventory07.mouseKeysDropAllExcept()) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    General.sleep(100);
                    return !Inventory.isFull();
                }
            }, General.random(2000, 2500));
        }
    }

    @Override
    public String toString() {
        return "Dropping items" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return Inventory.isFull();
    }

}

