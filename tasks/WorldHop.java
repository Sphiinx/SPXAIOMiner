package scripts.spxaiominer.tasks;

import org.tribot.api.General;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.game.area.Area07;
import scripts.tribotapi.game.objects.Objects07;
import scripts.tribotapi.game.player.Player07;
import scripts.tribotapi.game.timing.Timing07;
import scripts.tribotapi.game.worldswitcher.GetSwitcherWorlds07;
import scripts.tribotapi.game.worldswitcher.WorldSwitcher07;
import scripts.generalapi.util.ArrayUtil;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class WorldHop implements Task {

    @Override
    public boolean validate() {
        if (Vars.get().is_upgrading_pickaxe)
            return false;

        final RSObject ore = Objects07.getObjectByColorInArea(Vars.get().mining_location_tile, Vars.get().radius, Vars.get().ore_type.COLOR, true);
        return !Vars.get().is_transferring && Vars.get().world_hop && (Vars.get().hop_if_no_ores_available && ore == null && Player.getPosition().distanceTo(Vars.get().mining_location_tile) <= Vars.get().radius) || (Player.getPosition().distanceTo(Vars.get().mining_location_tile) <= Vars.get().radius && Area07.getPlayersInArea(Vars.get().radius) > Vars.get().hop_if_players_greater_than && Vars.get().hop_if_players_greater_than > 0);

    }

    @Override
    public void execute() {
        final int world = ArrayUtil.getRandomInt(GetSwitcherWorlds07.getWorlds(Vars.get().world_type.getTextureID()));
        if (WorldSwitcher07.switchWorld(world))
            Timing07.waitCondition(() -> Player07.getCurrentWorld() == world, General.random(6500, 7000));

    }

    @Override
    public String toString() {
        return "Switching worlds";
    }
}

