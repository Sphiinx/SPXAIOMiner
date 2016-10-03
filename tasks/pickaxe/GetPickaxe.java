package scripts.spxaiominer.tasks.pickaxe;

import org.tribot.api.General;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSItem;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.game.banking.Banking07;
import scripts.tribotapi.game.game.Game07;
import scripts.tribotapi.game.skills.mining.Mining07;
import scripts.tribotapi.game.skills.mining.enums.Pickaxe;
import scripts.tribotapi.game.timing.Timing07;
/**
 * Created by Sphiinx on 8/16/2016.
 */
public class GetPickaxe implements Task {


    @Override
    public boolean validate() {
        if (!Game07.isInGame() || Vars.get().is_upgrading_pickaxe)
            return false;

        return Equipment.SLOTS.WEAPON.getItem() == null && Mining07.getBestUsablePickaxe(false) == null;
    }

    @Override
    public void execute() {
        if (Banking07.isBankItemsLoaded()) {
            final RSItem[] inventory_cache = Inventory.getAll();
            if (Inventory.getAll().length > 0)
                if (Banking.depositAll() > 0)
                    Timing07.waitCondition(() -> inventory_cache.length != Inventory.getAll().length, General.random(1500, 2000));

            final Pickaxe best_usable_pickaxe = Mining07.getBestUsablePickaxe(true);
            if (best_usable_pickaxe == null)
                return;

            if (Banking07.withdrawItem(1, best_usable_pickaxe.getItemID()))
                if (Timing07.waitCondition(() -> Inventory.getAll().length > 0, General.random(1500, 2000)))
                    if (Mining07.getBestUsablePickaxe(false) == best_usable_pickaxe)
                        Vars.get().is_upgrading_pickaxe = false;

        } else {
            if (Banking07.isInBank()) {
                if (Banking.openBank())
                    Timing07.waitCondition(Banking::isBankScreenOpen, General.random(1500, 2000));
            } else {
                WebWalking.walkToBank();
            }
        }
    }

    @Override
    public String toString() {
        return "Getting pickaxe";
    }
}