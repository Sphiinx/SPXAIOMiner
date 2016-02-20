package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;

import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Banking.Banking07;
import scripts.SPXAIOMiner.API.Game.Banking.DepositBox07;
import scripts.SPXAIOMiner.API.Game.Inventory.Inventory07;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.Constants;
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
        handleBanking();
    }

    private void handleBanking() {
        if (isUsingCustomPath()) {
            if (DepositBox07.isAtDepositBox()) {
                handleDepositBox();
            } else {
                useCustomPaths();
            }
        } else {
            if (Banking.isBankScreenOpen()) {
                if (vars.pickaxeInInventory) {
                    RSItem[] pick = Inventory.find(Constants.PICKAXES);
                    Banking07.depositAllExcept(pick[0].getID());
                } else {
                    Banking07.depositInventory();
                }
            } else {
                Banking07.openBank();
            }
        }
    }

    private boolean isUsingCustomPath() {
        return vars.area.equals(Location.RIMMINGTON.getLocation()) ||
                vars.area.equals(Location.PORT_KHAZARD.getLocation()) ||
                vars.area.equals(Location.SHILO_VILLAGE.getLocation());
    }

    private void handleDepositBox() {
        RSItem[] ore = Inventory.find(vars.oreType.getItemIDs());
        if (DepositBox07.deposit(0, ore[0])) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    return Inventory07.getAmountOfSpace() == 0;
                }
            }, General.random(2000, 3000));
        }
    }

    private void useCustomPaths() {
        if (vars.area.equals(Location.RIMMINGTON.getLocation())) {
            WebWalking.walkTo(Constants.RIMMINGTON_DEPOSIT_BOX);
        } else if (vars.area.equals(Location.PORT_KHAZARD.getLocation())) {
            WebWalking.walkTo(Constants.PORTKHAZARD_DEPOSIT_BOX);
        } else {
            if (vars.area.equals(Location.SHILO_VILLAGE.getLocation())) {
                Walking.walkPath(Walking.randomizePath(Constants.SHILO_VILLAGE_PATH, 2, 2));
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

