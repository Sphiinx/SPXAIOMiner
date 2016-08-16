package scripts.spxaiominer.tasks.dropping;

import org.tribot.api.General;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.game.timing.Timing07;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class M1D1 implements Task {


    @Override
    public boolean validate() {
        return Inventory.getCount(Vars.get().ore_type.getItemID()) > 0;
    }

    @Override
    public void execute() {
        final RSItem[] inventory_cache = Inventory.getAll();
        if (Inventory.drop(Vars.get().ore_type.getItemID()) > 0)
            Timing07.waitCondition(() -> inventory_cache.length != Inventory.getAll().length, General.random(1500, 2000));
    }

    @Override
    public String toString() {
        return "Dropping ore";
    }

}

