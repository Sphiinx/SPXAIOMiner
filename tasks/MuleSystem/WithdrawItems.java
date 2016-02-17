package scripts.SPXAIOMiner.tasks.MuleSystem;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Banking.Banking07;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.enums.Location;

/**
 * Created by Sphiinx on 2/3/2016.
 */
public class WithdrawItems extends Task {

    public WithdrawItems(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        vars.originalWorld = Utility07.getCurrentWorld();
        if (Banking.isBankScreenOpen()) {
            withdrawItems();
        } else {
            if (vars.area.equals(Location.SHILO_VILLAGE.getArea())) {
                Walking.walkPath(Walking.randomizePath(scripts.SPXAIOMiner.data.Constants.SHILO_VILLAGE_PATH, 2, 2));
            } else {
                Banking07.openBank();
            }
        }
    }

    public boolean depositInventory() {
        if (vars.pickaxeInInventory) {
            RSItem[] pick = Inventory.find(Constants.PICKAXES);
            return Banking07.depositAllExcept(pick[0].getID());
        } else {
            return Banking07.depositInventory();
        }
    }

    public void withdrawItems() {
        depositInventory();
        if (Banking07.isBankItemsLoaded()) {
            if (Banking07.isNotedSelected()) {
                if (Banking.find(vars.oreType.getItemIDs()).length > 0) {
                    if (Banking07.withdrawItem(vars.oreType.getItemIDs()[0], vars.resetOresMined)) {
                        Timing.waitCondition(new Condition() {
                            @Override
                            public boolean active() {
                                General.sleep(100);
                                return Inventory.getCount(vars.oreType.getItemIDs()) >= vars.resetOresMined;
                            }
                        }, General.random(750, 1000));
                    }
                }
            } else {
                if (Banking07.selectNote()) {
                    Timing.waitCondition(new Condition() {
                        @Override
                        public boolean active() {
                            General.sleep(100);
                            return Banking07.isNotedSelected();
                        }
                    }, General.random(1000, 1200));
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Withdrawing items" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        vars.timeRanMinutes = (Timing.timeFromMark(vars.resetTimeRan) / 60000) + General.random(0, vars.variation);
        vars.orePriceTotal = (vars.orePrice * vars.resetOresMined) + General.random(0, vars.variation);
        if (Trading.getWindowState() != Trading.WINDOW_STATE.FIRST_WINDOW && Trading.getWindowState() != Trading.WINDOW_STATE.SECOND_WINDOW) {
            if (Inventory.getCount(vars.oreType.getNotedItemIDs()) < vars.resetOresMined && (vars.timeRanMinutes >= vars.transferMinutes || vars.orePriceTotal >= vars.transferMade)) {
                if (vars.isSlaveSystemIsRunning) {
                    return true;
                } else {
                    vars.isSlaveSystemIsRunning = true;
                    return true;
                }
            }
        }
        return false;
    }

}