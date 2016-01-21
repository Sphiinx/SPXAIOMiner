package scripts.SPXAIOMiner.nodes;

import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api.types.generic.Filter;
import org.tribot.api2007.*;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSObject;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class WalkToQuarry extends Node {

    private final Filter<RSObject> ORE_FILTER = oreFilter();

    RSObject[] objects;

    public WalkToQuarry(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        WebWalking.walkTo(vars.area, new Condition() {
            @Override
            public boolean active() {
                General.sleep(100);
                objects = Objects.getAll(20, ORE_FILTER);
                return vars.area.distanceTo(Player.getPosition()) <= vars.radius && objects.length > 0;
            }
        }, General.random(50, 100));
    }

    public Filter<RSObject> oreFilter() {
        return new Filter<RSObject>() {
            @Override
            public boolean accept(RSObject rsObject) {
                if (colorCheck(rsObject)) {
                    return true;
                }
                return false;
            }
        }.combine(Filters.Objects.nameEquals("Rocks"), true);
    }

    public boolean colorCheck(RSObject object) {
        for (short color : object.getDefinition().getModifiedColors()) {
            if (color == vars.oreType.getColor()) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Walking to quarry...";
    }

    @Override
    public boolean validate() {
        objects = Objects.getAll(20, ORE_FILTER);
        return !Inventory.isFull() && (vars.area.distanceTo(Player.getPosition()) >= vars.radius || objects.length <= 0);
    }

}

