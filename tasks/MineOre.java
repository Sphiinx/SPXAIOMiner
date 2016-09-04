package scripts.spxaiominer.tasks;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api.types.generic.Filter;
import org.tribot.api.util.Sorting;
import org.tribot.api.util.abc.preferences.WalkingPreference;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSObjectDefinition;
import org.tribot.api2007.types.RSTile;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.antiban.AntiBan;
import scripts.tribotapi.game.mining.enums.Pickaxe;

import scripts.tribotapi.game.objects.Objects07;
import scripts.tribotapi.game.timing.Timing07;
import scripts.tribotapi.game.walking.Walking07;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class MineOre implements Task {

    private RSTile current_ore_tile;

    @Override
    public boolean validate() {
        if (Vars.get().is_upgrading_pickaxe)
            return false;

        final RSObject ore = Objects07.getObjectByColorInArea(Vars.get().mining_location_tile, Vars.get().radius, Vars.get().ore_type.COLOR, true);
        return !Vars.get().is_transferring && ore != null && !Inventory.isFull() && (Inventory.getCount(Pickaxe.getItemIDs()) > 0 || Equipment.isEquipped(Pickaxe.getItemIDs()));
    }

    @Override
    public void execute() {
        final RSObject ore = getOreToMine();
        if (ore == null)
            return;

        if (Player.getAnimation() != -1) {
            General.println("Current: " + current_ore_tile);
            General.println("Next: " + ore.getPosition());
        }

        if (Player.isMoving())
            return;

        if (ore.isOnScreen()) {
            if (isMiningEmptyRock() || Player.getAnimation() == -1) {
                if (Clicking.click("Mine Rocks", ore)) {
                    if (Timing07.waitCondition(() -> Player.getAnimation() != -1 || Player.isMoving(), General.random(3000, 3500)))
                        current_ore_tile = ore.getPosition();
                }
            }
        } else {
            walkToOre(ore);
        }
    }

    private RSObject getOreToMine() {
        if (Player.getAnimation() != -1 || isMiningEmptyRock() || Player.getAnimation() == -1)
            return oreFilter(Vars.get().mining_location_tile, Vars.get().radius, Vars.get().ore_type.COLOR, current_ore_tile, false);

        return null;
    }

    private RSObject oreFilter(RSTile tile, int distance, int color, RSTile current_ore_tile, boolean sort_objects) {
        return Objects07.getObject(distance, sort_objects, new Filter<RSObject>() {
            @Override
            public boolean accept(RSObject object) {
                final RSArea radius_area = new RSArea(tile, distance);
                if (!radius_area.contains(object))
                    return false;

                if (object.getPosition() == current_ore_tile)
                    return false;

                final RSObjectDefinition object_definition = object.getDefinition();
                if (object_definition == null)
                    return false;

                for (short object_color : object_definition.getModifiedColors()) {
                    if (object_color == color) {
                        return true;
                    }
                }

                return false;
            }
        });
    }

    private boolean isMiningEmptyRock() {
        final RSObject possible_empty_ore = Objects07.getObjectAt(current_ore_tile);
        if (possible_empty_ore == null)
            return false;

        final RSObjectDefinition object_definition = possible_empty_ore.getDefinition();
        if (object_definition == null)
            return false;

        return object_definition.getModifiedColors().length <= 0;
    }

    private void walkToOre(RSObject object) {
        if (AntiBan.getABCUtil().generateWalkingPreference(Player.getPosition().distanceTo(object)) == WalkingPreference.SCREEN) {
            Walking07.screenWalkToRSObject(object);
        } else {
            WebWalking.walkTo(object, new Condition() {
                @Override
                public boolean active() {
                    return object != null && object.isOnScreen();
                }
            }, 250);
        }
    }

    @Override
    public String toString() {
        return "Mining " + Vars.get().ore_type;
    }

}

