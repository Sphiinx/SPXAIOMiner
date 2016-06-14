package scripts.SPXAIOMiner.tasks.MuleSystem;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.framework.Task;
import TribotAPI.game.banking.Banking07;
import TribotAPI.game.utiity.Utility07;

/**
 * Created by Sphiinx on 2/3/2016.
 */
public class WithdrawItems implements Task {

    //<editor-fold defaultstate="collapsed" desc="Execution">
    public void execute() {
        Vars.get().originalWorld = Utility07.getCurrentWorld();
        if (Banking.isBankScreenOpen()) {
            withdrawItems();
        } else {
            Banking07.openBank();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DepositInventory">
    public boolean depositInventory() {
        if (Vars.get().pickaxeInInventory && Inventory.getCount(Constants.PICKAXES) > 0) {
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
                if (Banking.find(Vars.get().oreType.getItemID()).length > 0) {
                    if (Banking07.withdrawItem(Vars.get().oreType.getItemID(), Vars.get().resetOresMined)) {
                        Timing.waitCondition(new Condition() {
                            @Override
                            public boolean active() {
                                General.sleep(100);
                                return Inventory.getCount(Vars.get().oreType.getItemID()) >= Vars.get().resetOresMined;
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

    public String toString() {
        return "Withdrawing items" + Utility07.loadingPeriods();
    }

    //<editor-fold defaultstate="collapsed" desc="Validation">
    public boolean validate() {
        Vars.get().timeRanMinutes = (Timing.timeFromMark(Vars.get().resetTimeRan) / 60000) + General.random(0, Vars.get().variation);
        Vars.get().orePriceTotal = (Vars.get().orePrice * Vars.get().resetOresMined) + General.random(0, Vars.get().variation);
        if (Trading.getWindowState() != Trading.WINDOW_STATE.FIRST_WINDOW && Trading.getWindowState() != Trading.WINDOW_STATE.SECOND_WINDOW) {
            if (Inventory.getCount(Vars.get().oreType.getNotedItemID()) < Vars.get().resetOresMined) {
                if (Vars.get().transferMinutes > 0 && Vars.get().timeRanMinutes >= Vars.get().transferMinutes) {
                    General.println("True 1");
                    Vars.get().isSlaveSystemIsRunning = true;
                    return true;
                }
                if (Vars.get().transferMade > 0 && Vars.get().orePriceTotal >= Vars.get().transferMade) {
                    General.println("True 2");
                    Vars.get().isSlaveSystemIsRunning = true;
                    return true;
                }
                return Vars.get().isSlaveSystemIsRunning;
            }
        }
        return false;
    }
    //</editor-fold>

}