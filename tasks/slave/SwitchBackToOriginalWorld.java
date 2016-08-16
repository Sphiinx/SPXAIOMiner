package scripts.spxaiominer.tasks.slave;

import org.tribot.api.General;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.game.player.Player07;
import scripts.tribotapi.game.timing.Timing07;
import scripts.tribotapi.game.worldswitcher.WorldSwitcher07;

/**
 * Created by Sphiinx on 8/6/2016.
 */
public class SwitchBackToOriginalWorld implements Task {


    @Override
    public boolean validate() {
        if (Vars.get().is_upgrading_pickaxe)
            return false;

        return Vars.get().is_switching_to_slave_world && Player07.getCurrentWorld() != Vars.get().slave_world;
    }

    @Override
    public void execute() {
        if (WorldSwitcher07.switchWorld(Vars.get().slave_world))
            Timing07.waitCondition(() -> Player07.getCurrentWorld() == Vars.get().slave_world, General.random(6500, 7000));

        Vars.get().is_switching_to_slave_world = false;
        Vars.get().is_transferring = false;
    }

    @Override
    public String toString() {
        return "Switching back to original world";
    }
}

