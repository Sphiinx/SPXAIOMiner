package scripts.SPXAIOMiner.tasks.PickaxeUpgrading;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.banking.Banking07;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/12/2016.
 */
public class EquipPickaxe extends Task {

    public EquipPickaxe(Variables v) {
        super(v);
    }

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
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
            vars.isUpgradingPickaxe = false;
        }

    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Equipping Axe" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return !vars.pickaxeInInventory && Equipment.getItem(Equipment.SLOTS.WEAPON) == null && Inventory.getCount(Constants.PICKAXES) > 0;
    }

}