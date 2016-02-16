package scripts.SPXAIOMiner.tasks.PickaxeUpgrading;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Banking.Banking07;
import scripts.SPXAIOMiner.API.Game.Game.Game07;
import scripts.SPXAIOMiner.API.Game.Inventory.Inventory07;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.AntiBan;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.enums.Location;
import scripts.SPXAIOMiner.data.enums.Pickaxe;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 2/12/2016.
 */
public class WithdrawPickaxe extends Task {

    private Pickaxe pickaxe_to_get = null;
    private ArrayList<Pickaxe> unaval_list = new ArrayList<>();

    public WithdrawPickaxe(Variables v) {
        super(v);
    }

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
    public void execute() {
        if (Banking07.isInBank()) {
            if (Banking.isBankScreenOpen()) {
                withdrawItems();
            } else {
                openBank();
            }
        } else {
            if (vars.area.equals(Location.SHILO_VILLAGE.getArea())) {
                Walking.walkPath(Walking.randomizePath(scripts.SPXAIOMiner.data.Constants.SHILO_VILLAGE_PATH, 2, 2));
            } else {
                walkToBank();
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DepositEquipment">
    public void depositEquipment() {
        if (Equipment.getItem(Equipment.SLOTS.WEAPON) != null) {
            if (Banking.depositEquipment()) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return Equipment.getItem(Equipment.SLOTS.WEAPON) == null;
                    }
                }, General.random(1000, 1200));
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DepositInventory">
    public void depositInventory() {
        if (Inventory07.getAmountOfSpace() != 28) {
            if (Banking.depositAll() > 0) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return Inventory07.getAmountOfSpace() == 28;
                    }
                }, General.random(1000, 1200));
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="WithdrawItems">
    public void withdrawItems() {
        depositInventory();
        if (Banking07.isBankItemsLoaded()) {
            if (pickaxe_to_get == null) {
                pickaxe_to_get = vars.pickaxe.getBestPickaxe();
                vars.pickaxe = pickaxe_to_get;
            }
            if (pickaxe_to_get != null) {
                if (Banking.find(pickaxe_to_get.getPickaxeID()).length > 0) {
                    depositEquipment();
                    if (Banking07.withdrawItem(pickaxe_to_get.getPickaxeID(), 1)) {
                        Timing.waitCondition(new Condition() {
                            @Override
                            public boolean active() {
                                General.sleep(100);
                                return Inventory.getCount(pickaxe_to_get.getPickaxeID()) >= 1;
                            }
                        }, General.random(750, 1000));
                    }
                } else {
                    if (pickaxe_to_get == Pickaxe.BRONZE) {
                        General.println("We could not find a pickaxe in the bank...");
                        General.println("Stopping script...");
                        AntiBan.destroy();
                        vars.stopScript = true;
                    } else {
                        if (!Equipment.isEquipped(pickaxe_to_get.getPickaxeID())) {
                            unaval_list.add(pickaxe_to_get);
                        }
                        pickaxe_to_get = vars.pickaxe.getPreviousAxe();
                        vars.pickaxe = pickaxe_to_get;
                    }
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="OpenBank">
    public void openBank() {
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="WalkToBank">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Status">
    @Override
    public String toString() {
        return "Upgrading Pickaxe" + Utility07.loadingPeriods();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Validation">
    @Override
    public boolean validate() {
        if (Game.getGameState() == 30 && Game07.isInGame()) {
            if (Equipment.getItem(Equipment.SLOTS.WEAPON) != null) {
                if (vars.upgradePickaxe && Banking.isBankScreenOpen() && Banking.find(vars.pickaxe.getPickaxeID()).length > 0) {
                    if (Equipment.getItem(Equipment.SLOTS.WEAPON).getID() != vars.pickaxe.getBestPickaxe().getPickaxeID()) {
                        if (unaval_list.size() > 0) {
                            for (Pickaxe pick : unaval_list) {
                                if (pickaxe_to_get == pick) {
                                    pickaxe_to_get = vars.pickaxe.getPreviousAxe();
                                    return false;
                                } else {
                                    if (!Equipment.isEquipped(pickaxe_to_get.getPickaxeID()) && pickaxe_to_get != pick) {
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
            } else {
                if (Inventory.find(vars.pickaxe.getPickaxeID()).length <= 0) {
                    vars.isUpgradingPickaxe = true;
                    return true;
                }
            }
        }
        return false;
    }
    //</editor-fold>

}

