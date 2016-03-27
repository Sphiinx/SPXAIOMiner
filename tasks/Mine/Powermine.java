package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/17/2016.
 */
public class Powermine extends Task {

    public Powermine(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        Inventory.drop(vars.oreType.getItemID());
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