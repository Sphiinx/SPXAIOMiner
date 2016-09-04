package scripts.spxaiominer.tasks.slave;

import org.tribot.api.General;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Trading;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSItem;
import scripts.spxaiominer.data.Cons;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.task_framework.framework.TaskManager;
import scripts.tribotapi.game.banking.Banking07;
import scripts.tribotapi.game.mining.enums.Pickaxe;
import scripts.tribotapi.game.timing.Timing07;
import scripts.tribotapi.util.Logging;

/**
 * Created by Sphiinx on 8/6/2016.
 */
public class WithdrawTransferItems implements Task {


    @Override
    public boolean validate() {
        if (Vars.get().is_upgrading_pickaxe)
            return false;

        return Vars.get().is_transferring && !Vars.get().is_switching_to_slave_world && !Inventory.isFull() && Trading.getWindowState() == null && Inventory.getCount(Vars.get().ore_type.getItemID() + 1) < Vars.get().ore_mined;
    }

    @Override
    public void execute() {
        if (Banking07.isBankItemsLoaded()) {
            if (Inventory.getCount(Vars.get().ore_type.getItemID()) > 0) {
                if (Banking.depositAllExcept(Pickaxe.getItemIDs()) > 0)
                    Timing07.waitCondition(() -> Inventory.getCount(Vars.get().ore_type.getItemID()) <= 0, General.random(1500, 2000));
            } else {
                if (!Banking07.isNotedSelected()) {
                    if (Banking07.selectNote())
                        Timing07.waitCondition(Banking07::isNotedSelected, General.random(1500, 2000));
                } else {
                    final RSItem item_to_withdraw = Banking07.findItem(Vars.get().ore_type.getItemID());
                    if (item_to_withdraw != null) {
                        final RSItem[] inventory_cache = Inventory.getAll();
                        if (Banking07.withdrawItem(Vars.get().slave_ores_mined, item_to_withdraw.getID()))
                            Timing07.waitCondition(() -> inventory_cache.length != Inventory.getAll().length, General.random(1500, 2000));
                    } else {
                        Logging.warning("We weren't able to find the items to transfer.");
                        TaskManager.stopProgram(true);
                    }
                }
            }
        } else {
            if (!Banking07.isInBank())
                WebWalking.walkToBank();

            if (Banking.openBank())
                Timing07.waitCondition(Banking07::isBankItemsLoaded, General.random(1500, 2000));
        }
    }

    @Override
    public String toString() {
        return "Withdrawing transfer items";
    }
}

