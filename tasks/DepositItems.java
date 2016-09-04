package scripts.spxaiominer.tasks;

import org.tribot.api.General;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSTile;
import scripts.spxaiominer.data.Cons;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.game.banking.Banking07;
import scripts.tribotapi.game.banking.DepositBox07;
import scripts.tribotapi.game.inventory.Inventory07;
import scripts.tribotapi.game.mining.enums.Pickaxe;
import scripts.tribotapi.game.timing.Timing07;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class DepositItems implements Task {

    private final RSTile RIMMINGTON_DEPOSIT_BOX = new RSTile(3045, 3235, 0);
    private final RSTile PORTKHAZARD_DEPOSIT_BOX = new RSTile(2663, 3160, 0);
    private RSItem item_to_deposit;

    @Override
    public boolean validate() {
        if (Vars.get().is_upgrading_pickaxe)
            return false;

        return Inventory.isFull();
    }

    @Override
    public void execute() {
        if (isUsingCustomBank()) {
            if (DepositBox07.isAtDepositBox()) {
                if (item_to_deposit == null) {
                    if (Inventory.getCount(Cons.GEM_NAMES) > 0)
                        item_to_deposit = Inventory07.getItem(Cons.GEM_NAMES);
                    else
                        item_to_deposit = Inventory07.getItem(Vars.get().ore_type.getItemID());
                } else {
                    if (DepositBox07.deposit(0, item_to_deposit))
                        Timing07.waitCondition(() -> Inventory.getCount(Vars.get().ore_type.getItemID()) <= 0, General.random(2000, 2500));
                }
            } else {
                walkToCustomBank();
            }
        } else {
            if (Banking07.isBankItemsLoaded()) {
                final RSItem[] inventory_cache = Inventory.getAll();
                if (Banking.depositAllExcept(Pickaxe.getItemIDs()) > 0)
                    Timing07.waitCondition(() -> inventory_cache.length != Inventory.getAll().length, General.random(1500, 2000));
            } else {
                if (!Banking07.isInBank())
                    WebWalking.walkToBank();

                if (Banking.openBank())
                    Timing07.waitCondition(Banking07::isBankItemsLoaded, General.random(1500, 2000));
            }
        }
    }

    private boolean isUsingCustomBank() {
        switch (Vars.get().mining_location) {
            case RIMMINGTON:
                return true;
            case PORT_KHAZARD:
                return true;
        }

        return false;
    }

    private void walkToCustomBank() {
        switch (Vars.get().mining_location) {
            case RIMMINGTON:
                WebWalking.walkTo(RIMMINGTON_DEPOSIT_BOX);
                break;
            case PORT_KHAZARD:
                WebWalking.walkTo(PORTKHAZARD_DEPOSIT_BOX);
                break;
        }
    }

    @Override
    public String toString() {
        return "Depositing items";
    }

}

