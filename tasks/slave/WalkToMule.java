package scripts.spxaiominer.tasks.slave;

import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSPlayer;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.game.player.Player07;
import scripts.tribotapi.game.timing.Timing07;
import scripts.tribotapi.game.worldswitcher.WorldSwitcher07;

/**
 * Created by Sphiinx on 8/6/2016.
 */
public class WalkToMule implements Task {

    @Override
    public boolean validate() {
        if (Vars.get().is_upgrading_pickaxe)
            return false;

        final RSPlayer player_to_trade = Player07.getPlayer(Vars.get().mule_username);
        return Vars.get().is_transferring && !Vars.get().is_switching_to_slave_world && player_to_trade == null && Inventory.getCount(Vars.get().ore_type.getItemID() + 1) >= Vars.get().ore_mined;
    }

    @Override
    public void execute() {
        if (Player07.getCurrentWorld() != Vars.get().mule_world) {
            if (Banking.isBankScreenOpen())
                if (Banking.close())
                    Timing07.waitCondition(() -> !Banking.isBankScreenOpen(), General.random(1500, 2000));

            Vars.get().slave_world = Player07.getCurrentWorld();
            if (WorldSwitcher07.switchWorld(Vars.get().mule_world))
                Timing07.waitCondition(() -> Player07.getCurrentWorld() == Vars.get().mule_world, General.random(6500, 7000));
        } else {WebWalking.walkTo(Vars.get().mule_location, new Condition() {
            @Override
            public boolean active() {
                final RSPlayer player_to_trade = Player07.getPlayer(Vars.get().mule_username);
                return player_to_trade != null && player_to_trade.isOnScreen();
            }
        }, 250);

        }
    }

    @Override
    public String toString() {
        return "Walking to mule";
    }
}

