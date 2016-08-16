package scripts.spxaiominer.tasks.pickaxe;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Skills;
import org.tribot.api2007.types.RSItem;
import scripts.spxaiominer.data.Cons;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.game.inventory.Inventory07;
import scripts.tribotapi.game.mining.Mining07;
import scripts.tribotapi.game.mining.enums.Pickaxe;
import scripts.tribotapi.game.timing.Timing07;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class EquipPickaxe implements Task {

    private Pickaxe best_usable_pickaxe;

    @Override
    public boolean validate() {
        best_usable_pickaxe = Mining07.getBestUsablePickaxe(false);
        return best_usable_pickaxe != null && !Equipment.isEquipped(best_usable_pickaxe.getItemID()) && Skills.getActualLevel(Skills.SKILLS.ATTACK) >= best_usable_pickaxe.getAttackLevel();
    }

    @Override
    public void execute() {
        if (Banking.isBankScreenOpen())
            if (Banking.close())
                Timing07.waitCondition(() -> !Banking.isBankScreenOpen(), General.random(1500, 2000));

        final RSItem item_to_equip = Inventory07.getItem(Cons.PICKAXE_IDS);
        if (item_to_equip == null)
            return;

        if (Clicking.click("Wield", item_to_equip))
            Timing07.waitCondition(() -> Equipment.isEquipped(Cons.PICKAXE_IDS), General.random(2000, 2500));
    }

    @Override
    public String toString() {
        return "Equipping pickaxe";
    }

}