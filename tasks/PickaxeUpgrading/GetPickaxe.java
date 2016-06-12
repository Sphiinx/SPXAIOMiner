package scripts.SPXAIOMiner.tasks.PickaxeUpgrading;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.data.enums.Pickaxe;
import scripts.SPXAIOMiner.framework.Task;
import scripts.TribotAPI.game.banking.Banking07;
import scripts.TribotAPI.game.game.Game07;
import scripts.TribotAPI.game.utiity.Utility07;
import scripts.TribotAPI.Printing;
import scripts.TribotAPI.antiban.AntiBan;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class GetPickaxe implements Task {

    private ArrayList<Pickaxe> unaval_list = new ArrayList<>();
    private Pickaxe pickaxeToGet = null;

    public void execute() {
        if (Banking.isBankScreenOpen()) {
            withdrawItems();
        } else {
            Banking07.openBank();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="GetBestPickaxe">
    private void getBestPickaxe() {
        if (pickaxeToGet == null) {
            pickaxeToGet = Vars.get().pickaxe.getBestPickaxe(Vars.get().pickaxeInInventory);
            Vars.get().pickaxe = pickaxeToGet;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="WithdrawPickaxe">
    public void withdrawItems() {
        Banking07.depositInventory();
        if (Banking07.isBankItemsLoaded()) {
            getBestPickaxe();
            if (pickaxeToGet != null) {
                if (Banking.find(pickaxeToGet.getPickaxeID()).length > 0) {
                    Banking07.depositEquipment();
                    if (Banking07.withdrawItem(pickaxeToGet.getPickaxeID(), 1)) {
                        Timing.waitCondition(new Condition() {
                            @Override
                            public boolean active() {
                                General.sleep(100);
                                return Inventory.getCount(pickaxeToGet.getPickaxeID()) >= 1;
                            }
                        }, General.random(750, 1000));
                        if (Vars.get().pickaxeInInventory) {
                            Vars.get().isUpgradingPickaxe = false;
                        }
                    }
                } else {
                    getNextPickaxe();
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GetNextPickaxe">
    private void getNextPickaxe() {
        if (pickaxeToGet == Pickaxe.BRONZE) {
            Printing.status("We could not find a pickaxe in the bank...");
            Printing.status("Stopping script...");
            AntiBan.destroy();
            Vars.get().stopScript = true;
        } else {
            if (!Equipment.isEquipped(pickaxeToGet.getPickaxeID())) {
                unaval_list.add(pickaxeToGet);
            }
            pickaxeToGet = Vars.get().pickaxe.getPreviousAxe();
            Vars.get().pickaxe = pickaxeToGet;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="NeedsPickaxe">
    private boolean needsPickaxe() {
        RSItem pickaxe = Equipment.getItem(Equipment.SLOTS.WEAPON);
        if (pickaxe == null && Inventory.getCount(Constants.PICKAXES) <= 0) {
            if (!Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    return Equipment.getItem(Equipment.SLOTS.WEAPON) != null || Inventory.getCount(Constants.PICKAXES) >  0;
                }
            }, General.random(5000, 6000))) {
                Vars.get().isUpgradingPickaxe = true;
                return true;
            }
        }
        return false;
    }
    //</editor-fold>

    public String toString() {
        return "Getting pickaxe" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return Game07.isInGame() && needsPickaxe();
    }
}