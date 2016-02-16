package scripts.SPXAIOMiner.tasks.PickaxeUpgrading;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/12/2016.
 */
public class EquipPickaxe extends Task {

    public EquipPickaxe(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        if (Banking.isBankScreenOpen()) {
            if (Banking.close()) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return !Banking.isBankScreenOpen();
                    }
                }, General.random(1000, 1200));
            }
        } else {
            RSItem[] pickaxe = Inventory.find(vars.pickaxe.getPickaxeID());
            if (Clicking.click("Wield", pickaxe[0])) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return Equipment.isEquipped(vars.pickaxe.getPickaxeID());
                    }
                }, General.random(1000, 1200));
                vars.isUpgradingPickaxe = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Equipping Pickaxe" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return Inventory.getCount(vars.pickaxe.getPickaxeID()) > 0;
    }

}

