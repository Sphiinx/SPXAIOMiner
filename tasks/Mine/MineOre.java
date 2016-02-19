package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api.Clicking;
import org.tribot.api.DynamicClicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api.rs3.*;
import org.tribot.api.types.generic.Condition;
import org.tribot.api.types.generic.Filter;
import org.tribot.api.util.Sorting;
import org.tribot.api.util.abc.preferences.WalkingPreference;
import org.tribot.api2007.*;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.*;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Area.Area07;
import scripts.SPXAIOMiner.API.Game.Mouse.Mouse07;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.API.Game.Walking.Walking07;
import scripts.SPXAIOMiner.API.Printing;
import scripts.SPXAIOMiner.AntiBan;
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.enums.OreType;

import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;


/**
 * Created by Sphiinx on 1/16/2016.
 */
public class MineOre extends Task {

    //    private RSObject currentOre;
    private RSObject oreToHover;
    private int rockID;
    private RSTile anticipatedLocation;
    private final Filter<RSObject> ORE_FILTER = oreFilter();
    private ArrayList<RSTile> depletedOres = new ArrayList<>();
    int createCache;
    int cacheToCheck;
    long check_time;
    private RSObject miningRock;
    private long totalWaitTime = 0;
    RSMenuNode hoverNode = null;
    RSItem tempItem = null;

    public MineOre(Variables v) {
        super(v);
    }

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
    public void execute() {
        Mouse07.fixSelected();

        if (!isMining()) {
            RSObject rock = getActualOre();
            if (rock != null)
                mineOre(rock);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="IsMining">
    private boolean isMining() {
        return Player.getAnimation() != -1 && !Player.isMoving();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HoverMenuNode">
    private boolean hoverMenuNode() {
        if (hoverNode == null || !ChooseOption.isOpen() || isOreDepleted(oreToHover))
            return false;

        Rectangle rectangle = hoverNode.getArea();
        if (rectangle != null) {
            if (!rectangle.contains(Mouse.getPos())) {
                tempItem = new RSItem(0, 0, 0, RSItem.TYPE.OTHER);
                tempItem.setArea(rectangle);
                return Clicking.hover(tempItem);
            } else
                return true;
        }
        return false;
    }
    //</editor-fold>



    //<editor-fold defaultstate="collapsed" desc="MineOre">
    private void mineOre(RSObject currentOre) {
        rockID = currentOre.getID();
        miningRock = currentOre;
        if (Inventory.isFull()) {
            return;
        }

        if (currentOre.isOnScreen()) {

            int sleep = AntiBan.getReactionTime();
            Printing.status("Reaction Time: " + sleep);
            AntiBan.sleepReactionTime();

            boolean clickingResult;

            if (tempItem != null && ChooseOption.isOpen())
                clickingResult = Clicking.click(tempItem);
            else
                clickingResult = Clicking.click("Mine", currentOre);


            if (clickingResult) {
                long startTime = System.currentTimeMillis();
                if (Timing.currentTimeMillis() > check_time) {
                    check_time = Timing.currentTimeMillis() + General.random(20000, 30000);
                }
                boolean shouldHover = AntiBan.should_hover;
                boolean shouldOpenMenu = AntiBan.should_open_menu;
                Printing.status("Should Hover: " + shouldHover);
                Printing.status("Should Open Menu: " + shouldOpenMenu);

                if (shouldHover) {
                    RSObject[] potentialTargets = getAllObjects();
                    oreToHover = AntiBan.selectNextTarget(potentialTargets);
                } else {
                    oreToHover = null;
                    tempItem = null;
                }

                long timeout = totalWaitTime > 10000 && vars.oresMined > 0 ? (totalWaitTime / vars.oresMined) * 2 : 40000;

                if (Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);

                        if (!AntiBan.leaveGame()) {
                            if (shouldHover && Mouse.isInBounds() && oreToHover != null) {
                                if (shouldOpenMenu) {
                                    if (!hoverMenuNode() && !ChooseOption.isOpen() && DynamicClicking.clickRSObject(oreToHover, 3)) {
                                        if (Timing.waitCondition(new Condition() {
                                            @Override
                                            public boolean active() {
                                                return ChooseOption.isOpen();
                                            }
                                        }, General.random(750, 1000))) {

                                            RSMenuNode[] nodes = ChooseOption.getMenuNodes();
                                            for (RSMenuNode node : nodes) {
                                                if (!node.correlatesTo(oreToHover))
                                                    return false;

                                                if (node.getAction().contains("Mine")) {
                                                    hoverNode = node;
                                                    hoverMenuNode();
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    Clicking.hover(oreToHover);
                                }
                            }
                        }

                        return isOreDepleted(currentOre);
                    }
                }, timeout)) {
                    long waitTime = Timing.timeFromMark(startTime);

                    totalWaitTime += waitTime;
                    if (vars.oresMined > 0) {
                        waitTime = (int) (totalWaitTime / vars.oresMined);
                    } else {
                        waitTime = 6000;
                    }
                    AntiBan.generateTrackers((int) waitTime);
                    depletedOres.add(currentOre.getPosition());
                    AntiBan.incrementResourcesWon();
                    createCache = Inventory.getAll().length;
                    isOreStolen();

                    double winPercentage = (AntiBan.getResourcesWon() + AntiBan.getResourcesLost()) / AntiBan.getResourcesWon();
                    if (winPercentage < 50.0 && Timing.currentTimeMillis() >= check_time) {
                        if (AntiBan.shouldSwitchResources(Area07.getPlayersInArea(vars.radius))) {
                            if (vars.worldHop) {
                                vars.shouldWeHop = true;
                            }
                        }
                    }
                    AntiBan.resetShouldHover();
                    AntiBan.resetShouldOpenMenu();

                    if (shouldHover && oreToHover != null) {
                        mineOre(oreToHover);
                    }
                }

            }
        } else {
            if (AntiBan.getABCUtil().generateWalkingPreference(Player.getPosition().distanceTo(currentOre)) == WalkingPreference.SCREEN) {
                Walking07.sceenWalkToObject(currentOre);
            } else {
                WebWalking.walkTo(currentOre);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="IsOreDepleted">
    private boolean isOreDepleted(RSObject object) {
        RSObjectDefinition def = object.getDefinition();

        if (def != null) {

            RSObject[] chk = Objects.getAt(object);

            if (chk.length > 0) {
                int id = chk[0].getID();
                return rockID != id;
            }


        }
        return true;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="IsOreStolen">
    private void isOreStolen() {
        cacheToCheck = Inventory.getAll().length;
        if (createCache != 0 && cacheToCheck != 0) {
            if (createCache == cacheToCheck) {
                AntiBan.incrementResourcesLost();
            }
        }
        createCache = 0;
        cacheToCheck = 0;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GetActualOre">
    private RSObject getActualOre() {
        RSObject[] actualOres = getAllObjects();
        if (actualOres.length > 0) {

            if (vars.oresHop) {
                vars.shouldWeHop = false;
            }
            vars.oreToDraw = actualOres;
            return AntiBan.selectNextTarget(actualOres);
        } else {
            if (vars.oresHop) {
                vars.shouldWeHop = true;
            }
            if (AntiBan.getABCUtil().shouldMoveToAnticipated()) {
                AntiBan.sleepReactionTime();
                AntiBan.goToAnticipated(anticipatedLocation);
            }
        }

        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ColorCheck">
    private boolean colorCheck(RSObject object) {
        for (short color : object.getDefinition().getModifiedColors()) {
            if (color == vars.oreType.getColor()) {
                return true;
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="OreFilter">
    private Filter<RSObject> oreFilter() {
        return new Filter<RSObject>() {
            @Override
            public boolean accept(RSObject rsObject) {

                if (rsObject.equals(miningRock))
                    return false;

                RSTile pos = rsObject.getPosition();
                if (depletedOres.size() > 0) {
                    for (RSObject object : Objects.getAt(depletedOres.get(0))) {
                        if (rsObject.equals(object)) {
                            depletedOres.remove(pos);
                            anticipatedLocation = pos;
                        }
                    }
                }
                return colorCheck(rsObject) && Player.getPosition().distanceTo(rsObject) <= vars.radius;
            }
        }.combine(Filters.Objects.nameContains("Rock"), true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GetAllObjects">
    private RSObject[] getAllObjects() {
        RSObject[] objects = Objects.getAll(vars.radius, ORE_FILTER);
        Sorting.sortByDistance(objects, Player.getPosition(), true);
        return objects;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Mining ore" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return !vars.isSlaveSystemIsRunning &&
                !Inventory.isFull() && vars.area.distanceTo(Player.getPosition()) <= vars.radius &&
                (Inventory.getCount(Constants.PICKAXES) > 0 || Equipment.getItem(Equipment.SLOTS.WEAPON) != null);
    }

}