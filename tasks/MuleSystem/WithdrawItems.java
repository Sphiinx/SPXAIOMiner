package scripts.SPXAIOMiner.tasks.MuleSystem;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.banking.Banking07;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.Constants;

/**
 * Created by Sphiinx on 2/3/2016.
 */
public class WithdrawItems extends Task {

    public WithdrawItems(Variables v) {
        super(v);
    }

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
    public void execute() {
        vars.originalWorld = Utility07.getCurrentWorld();
        if (Banking.isBankScreenOpen()) {
            withdrawItems();
        } else {
            Banking07.openBank();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DepositInventory">
    public boolean depositInventory() {
        if (vars.pickaxeInInventory && Inventory.getCount(Constants.PICKAXES) > 0) {
            RSItem[] pick = Inventory.find(Constants.PICKAXES);
            return Banking07.depositAllExcept(pick[0].getID());
        } else {
            return Banking07.depositInventory();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Withdraw Items">
    public void withdrawItems() {
        depositInventory();
        if (Banking07.isBankItemsLoaded()) {
            if (Banking07.isNotedSelected()) {
                if (Banking.find(vars.oreType.getItemID()).length > 0) {
                    if (Banking07.withdrawItem(vars.oreType.getItemID(), vars.resetOresMined)) {
                        Timing.waitCondition(new Condition() {
                            @Override
                            public boolean active() {
                                General.sleep(100);
                                return Inventory.getCount(vars.oreType.getItemID()) >= vars.resetOresMined;
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
    //</editor-fold>

    @Override
    public String toString() {
        return "Withdrawing items" + Utility07.loadingPeriods();
    }

    //<editor-fold defaultstate="collapsed" desc="Validation">
    @Override
    public boolean validate() {
        vars.timeRanMinutes = (Timing.timeFromMark(vars.resetTimeRan) / 60000) + General.random(0, vars.variation);
        vars.orePriceTotal = (vars.orePrice * vars.resetOresMined) + General.random(0, vars.variation);
        if (Trading.getWindowState() != Trading.WINDOW_STATE.FIRST_WINDOW && Trading.getWindowState() != Trading.WINDOW_STATE.SECOND_WINDOW) {
            if (Inventory.getCount(vars.oreType.getNotedItemID()) < vars.resetOresMined) {
                if (vars.transferMinutes > 0 && vars.timeRanMinutes >= vars.transferMinutes) {
                    General.println("True 1");
                    vars.isSlaveSystemIsRunning = true;
                    return true;
                }
                if (vars.transferMade > 0 && vars.orePriceTotal >= vars.transferMade) {
                    General.println("True 2");
                    vars.isSlaveSystemIsRunning = true;
                    return true;
                }
                return vars.isSlaveSystemIsRunning;
            }
        }
        return false;
    }
    //</editor-fold>

}