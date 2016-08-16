package scripts.spxaiominer.tasks.slave;

import org.tribot.api.General;
import org.tribot.api.Timing;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;

/**
 * Created by Sphiinx on 8/6/2016.
 */
public class EnableTransfer implements Task {


    @Override
    public boolean validate() {
        if (Vars.get().is_upgrading_pickaxe)
            return false;

        return !Vars.get().is_transferring && ((Vars.get().transfer_after_profit > 0 && Vars.get().profit >= General.random(0, Vars.get().transfer_variation) + Vars.get().transfer_after_profit) || (Vars.get().transfer_after_minutes > 0 && Timing.timeFromMark(Vars.get().slave_time_ran) / 60000 >= General.random(0, Vars.get().transfer_variation) + Vars.get().transfer_after_minutes));

    }

    @Override
    public void execute() {
        General.println("Executing");
        Vars.get().is_transferring = true;
    }

    @Override
    public String toString() {
        return "Enabling transfer system";
    }
}

