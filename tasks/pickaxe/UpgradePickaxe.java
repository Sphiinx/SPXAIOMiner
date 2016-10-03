package scripts.spxaiominer.tasks.pickaxe;

import org.tribot.api.General;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Equipment;
import scripts.spxaiominer.data.Vars;
import scripts.tribotapi.game.banking.Banking07;
import scripts.tribotapi.game.game.Game07;
import scripts.tribotapi.game.skills.mining.Mining07;
import scripts.tribotapi.game.skills.mining.enums.Pickaxe;
import scripts.tribotapi.game.timing.Timing07;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class UpgradePickaxe extends GetPickaxe {

    private Pickaxe appropriate_pickaxe;
    private Pickaxe current_pickaxe;

    @Override
    public boolean validate() {
        if (!Game07.isInGame() || Vars.get().is_upgrading_pickaxe)
            return false;

        if (!Banking07.isBankItemsLoaded())
            return false;

        appropriate_pickaxe = Mining07.currentAppropriatePickaxe();
        current_pickaxe = Mining07.getBestUsablePickaxe(false);

        return current_pickaxe != null && current_pickaxe != appropriate_pickaxe && Banking07.findItem(appropriate_pickaxe.getItemID()) != null;

    }

    @Override
    public void execute() {
        Vars.get().is_upgrading_pickaxe = true;

        super.execute();

        if (Equipment.getItems().length > 0)
            if (Banking.depositEquipment())
                Timing07.waitCondition(() -> Equipment.getItems().length <= 0, General.random(1500, 2000));
    }

    @Override
    public String toString() {
        return "Upgrading pickaxe";
    }

}