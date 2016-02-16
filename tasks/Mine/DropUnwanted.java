package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Inventory.Inventory07;

import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public class DropUnwanted extends Task {

    public DropUnwanted(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        Inventory07.drop(Constants.GEMS);
    }

    @Override
    public String toString() {
        return "Dropping items" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return Inventory.getCount(Constants.GEMS) > 0;
    }

}

