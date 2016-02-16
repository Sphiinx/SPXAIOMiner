package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;

import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Banking.Banking07;
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
        if (Banking07.isInBank()) {
            openBank();
        } else {
            if (vars.area.equals(Location.SHILO_VILLAGE.getArea())) {
                Walking.walkPath(Walking.randomizePath(Constants.SHILO_VILLAGE_PATH, 2, 2));
            } else {
                walkToBank();
            }
        }
    }

    private void openBank() {
        if (Banking.isBankScreenOpen()) {
            if (Banking.depositAll() > 0) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return Inventory07.getCount() <= 0;
                    }
                }, General.random(750, 1000));
            }
        } else {
            if (Banking.openBank()) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return Banking.isBankScreenOpen();
                    }
                }, General.random(750, 1000));
            }
        }
    }

    private void walkToBank() {
        if (WebWalking.walkToBank()) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    General.sleep(100);
                    return Banking.isInBank();
                }
            }, General.random(750, 1000));
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

