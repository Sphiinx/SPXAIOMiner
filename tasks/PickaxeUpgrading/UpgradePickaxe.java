package scripts.SPXAIOMiner.tasks.PickaxeUpgrading;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.banking.Banking07;
import scripts.SPXAIOMiner.api.game.game.Game07;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.api.Printing;
import scripts.SPXAIOMiner.antiban.AntiBan;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.enums.Pickaxe;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 2/12/2016.
 */
public class UpgradePickaxe extends Task {

    private ArrayList<Pickaxe> unaval_list = new ArrayList<>();
    private Pickaxe pickaxeToGet = null;
    public Variables variables;

    public UpgradePickaxe(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        withdrawItems();
    }

    //<editor-fold defaultstate="collapsed" desc="GetBestPickaxe">
    private void getBestPickaxe() {
        if (pickaxeToGet == null) {
            pickaxeToGet = vars.pickaxe.getBestPickaxe(vars.pickaxeInInventory);
            vars.pickaxe = pickaxeToGet;
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
                        if (vars.pickaxeInInventory) {
                            vars.isUpgradingPickaxe = false;
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
            vars.stopScript = true;
        } else {
            if (!Equipment.isEquipped(pickaxeToGet.getPickaxeID())) {
                unaval_list.add(pickaxeToGet);
            }
            pickaxeToGet = vars.pickaxe.getPreviousAxe();
            vars.pickaxe = pickaxeToGet;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="NeedsUpgrade">
    private boolean needsUpgrade() {
        RSItem pickaxe = Equipment.getItem(Equipment.SLOTS.WEAPON);
        if (pickaxe != null || Inventory.getCount(Constants.PICKAXES) > 0) {
            if (Banking.isBankScreenOpen()) {
                if (Equipment.getItem(Equipment.SLOTS.WEAPON).getID() != vars.pickaxe.getBestPickaxe(vars.pickaxeInInventory).getPickaxeID() || (Inventory.find(Constants.PICKAXES)[0].getID() != vars.pickaxe.getBestPickaxe(vars.pickaxeInInventory).getPickaxeID())) {
                    if (unaval_list.size() > 0) {
                        for (Pickaxe pick : unaval_list) {
                            if (pickaxeToGet == pick) {
                                pickaxeToGet = variables.pickaxe.getPreviousAxe();
                                return false;
                            } else {
                                if (!Equipment.isEquipped(pickaxeToGet.getPickaxeID())) {
                                    vars.isUpgradingPickaxe = true;
                                    return true;
                                }
                            }
                        }
                    } else {
                        vars.isUpgradingPickaxe = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Upgrading Pickaxe" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return Game07.isInGame() && vars.upgradePickaxe && needsUpgrade();
    }

}