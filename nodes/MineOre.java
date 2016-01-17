package scripts.SPXAIOMiner.nodes;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api.types.generic.Filter;
import org.tribot.api.util.Sorting;
import org.tribot.api2007.*;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class MineOre extends Node{

    private final Filter<RSObject> ORE_FILTER = oreFilter();

    public MineOre(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        mineOre();
    }

    private void mineOre() {
        getActualOre();
        if (vars.targetOre != null) {
            if (vars.targetOre.isOnScreen()) {
                if (Player.getAnimation() == -1 && !Player.isMoving()) {
                    if (Clicking.click("Mine", vars.targetOre)) {
                        Timing.waitCondition(new Condition() {
                            @Override
                            public boolean active() {
                                return Player.getAnimation() != -1;
                            }
                        }, General.random(1000, 1200));
                    }
                }
            } else {
                RSTile[] path = Walking.generateStraightScreenPath(vars.targetOre.getPosition());
                if (Walking.walkScreenPath(path)) {
                    Timing.waitCondition(new Condition() {
                        @Override
                        public boolean active() {
                            return vars.targetOre.isOnScreen();
                        }
                    }, General.random(1200, 1500));
                }
            }
        }
    }

    private void getActualOre() {
        RSObject[] actualOre = getAllObjects();
        if (actualOre.length > 0) {
            vars.targetOre = actualOre[0];
        } else {
            vars.targetOre = null;
        }
    }

    private RSObject[] getAllObjects() {
        RSObject[] objects = Objects.getAll(20, ORE_FILTER);
        Sorting.sortByDistance(objects, Player.getPosition(), true);
        return objects;
    }

    private Filter<RSObject> oreFilter() {
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

    private boolean colorCheck(RSObject object) {
        for (short color : object.getDefinition().getModifiedColors()) {
            if (color == 53) { //TODO CHANGE COLOR
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Mining ore...";
    }

    @Override
    public boolean validate() {
        return !Inventory.isFull();
    }

}

