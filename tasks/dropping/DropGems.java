package scripts.spxaiominer.tasks.dropping;

import org.tribot.api2007.Inventory;
import scripts.spxaiominer.data.Cons;
import scripts.task_framework.framework.Task;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class DropGems implements Task {


    @Override
    public boolean validate() {
        return Inventory.getCount(Cons.GEM_NAMES) > 0;
    }

    @Override
    public void execute() {
        Inventory.drop(Cons.GEM_NAMES);
    }

    @Override
    public String toString() {
        return "Dropping gems";
    }

}

