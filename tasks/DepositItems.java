package scripts.SPXAIOMiner.tasks;

import org.tribot.api2007.*;

import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Banking.Banking07;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.enums.Location;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class DepositItems extends Task {

    public DepositItems(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        if (Banking.isBankScreenOpen()) {
            Banking07.depositInventory();
        } else {
            if (vars.area.equals(Location.SHILO_VILLAGE.getArea())) {
                Walking.walkPath(Walking.randomizePath(scripts.SPXAIOMiner.data.Constants.SHILO_VILLAGE_PATH, 2, 2));
            } else {
                Banking07.openBank();
            }
        }
    }

    @Override
    public String toString() {
        return "Depositing items" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return Inventory.isFull();
    }

}

