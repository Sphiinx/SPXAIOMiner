package scripts.SPXAIOMiner.tasks.PickaxeUpgrading;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.framework.Task;
import scripts.TribotAPI.game.banking.Banking07;
import scripts.TribotAPI.game.utiity.Utility07;

/**
 * Created by Sphiinx on 2/12/2016.
 */
public class EquipPickaxe implements Task {

    //<editor-fold defaultstate="collapsed" desc="Execution">
    public void execute() {
        Banking07.closeBank();
        RSItem[] pickaxe = Inventory.find(Constants.PICKAXES);
        if (Clicking.click("Wield", pickaxe[0])) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    General.sleep(100);
                    return Equipment.isEquipped(Constants.PICKAXES);
                }
            }, General.random(1000, 1200));
            Vars.get().isUpgradingPickaxe = false;
        }

    }
    //</editor-fold>

    public String toString() {
        return "Equipping Axe" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return !Vars.get().pickaxeInInventory && Equipment.getItem(Equipment.SLOTS.WEAPON) == null && Inventory.getCount(Constants.PICKAXES) > 0;
    }

}