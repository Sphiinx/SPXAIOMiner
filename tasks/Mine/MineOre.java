package scripts.SPXAIOMiner.tasks.Mine;

import org.tribot.api.Clicking;
import org.tribot.api.DynamicClicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
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
import scripts.SPXAIOMiner.data.*;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.framework.Task;
import scripts.TribotAPI.game.area.Area07;
import scripts.TribotAPI.game.mouse.Mouse07;
import scripts.TribotAPI.game.utiity.Utility07;
import scripts.TribotAPI.game.walking.Walking07;
import scripts.TribotAPI.Printing;
import scripts.TribotAPI.antiban.AntiBan;

import java.awt.*;
import java.util.ArrayList;


/**
 * Created by Sphiinx on 1/16/2016.
 */
public class MineOre implements Task {

    private final Filter<RSObject> ORE_FILTER = oreFilter();
    private ArrayList<RSTile> depletedOres = new ArrayList<>();
    private RSObject oreToHover;
    private RSObject miningRock;
    private int rockID;
    private int createCache;
    private long check_time;
    private long totalWaitTime = 0;
    private RSTile anticipatedLocation;
    private RSMenuNode hoverNode = null;
    private RSItem tempItem = null;
    private boolean shouldHover;
    private boolean shouldOpenMenu;
    private boolean clickingResult;
    private boolean shouldMoveToAnticipated;

    //<editor-fold defaultstate="collapsed" desc="Execution">
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
        if (hoverNode == null || !ChooseOption.isOpen()) {
            return false;
        }

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

    //<editor-fold defaultstate="collapsed" desc="SleepReactionTime">
    private void sleepReactionTime() {
        if (!Vars.get().disableSleeps) {
            int sleep = AntiBan.getReactionTime();
            Printing.status("Reaction Time: " + sleep);
            AntiBan.sleepReactionTime();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GenerateCheckTime">
    private void generateCheckTime() {
        if (Timing.currentTimeMillis() > check_time) {
            check_time = Timing.currentTimeMillis() + General.random(20000, 30000);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HandleHoverCheck">
    private void handleHoverCheck() {
        shouldHover = AntiBan.should_hover;
        shouldOpenMenu = AntiBan.should_open_menu;
        Printing.status("Should Hover: " + shouldHover);
        Printing.status("Should Open Menu: " + shouldOpenMenu);
        if (shouldHover) {
            RSObject[] potentialTargets = getAllObjects();
            oreToHover = AntiBan.selectNextTarget(potentialTargets);
        } else {
            oreToHover = null;
            tempItem = null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HandleHovering">
    private boolean handleHovering() {
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
                                if (!node.correlatesTo(oreToHover)) {
                                    return false;
                                }

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
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GenerateTrackers">
    private void generateTrackers(long startTime) {
        long waitTime = Timing.timeFromMark(startTime);
        totalWaitTime += waitTime;

        if (Vars.get().oresMined > 0) {
            waitTime = (int) (totalWaitTime / Vars.get().oresMined);
        } else {
            waitTime = 6000;
        }
        AntiBan.generateTrackers((int) waitTime);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SwitchResources">
    private void switchResources() {
        if (AntiBan.getResourcesWon() > 0 && AntiBan.getResourcesLost() > 0) {
            double winPercentage = (AntiBan.getResourcesWon() + AntiBan.getResourcesLost()) / AntiBan.getResourcesWon();

            if (winPercentage < 50.0 && Timing.currentTimeMillis() >= check_time) {
                if (AntiBan.shouldSwitchResources(Area07.getPlayersInArea(Vars.get().radius))) {
                    if (Vars.get().worldHop) {
                        Vars.get().shouldWeHop = true;
                    }
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GenerateWalkingPreference">
    private void generateWalkingPreference(RSObject currentOre) {
        if (AntiBan.getABCUtil().generateWalkingPreference(Player.getPosition().distanceTo(currentOre)) == WalkingPreference.SCREEN) {
            Walking07.sceenWalkToObject(currentOre);
        } else {
            WebWalking.walkTo(currentOre);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HandleClicking">
    private void handleClicking(RSObject currentOre) {
        if (tempItem != null && ChooseOption.isOpen())
            clickingResult = Clicking.click(tempItem);
        else
            clickingResult = Clicking.click("Mine", currentOre);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MineOre">
    private void mineOre(RSObject currentOre) {
        rockID = currentOre.getID();
        miningRock = currentOre;

        if (Inventory.isFull()) {
            return;
        }

        if (!currentOre.isOnScreen()) {
            generateWalkingPreference(currentOre);
        } else {
            sleepReactionTime();
            handleClicking(currentOre);
            if (clickingResult) {
                long startTime = System.currentTimeMillis();
                generateCheckTime();
                handleHoverCheck();
                long timeout = totalWaitTime > 10000 && Vars.get().oresMined > 0 ? (totalWaitTime / Vars.get().oresMined) * 2 : 6500;

                if (Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        generateTrackers(startTime);
                        switchResources();
                        handleHovering();
                        AntiBan.timedActions();
                        return isOreDepleted(currentOre);
                    }
                }, timeout)) {
                    depletedOres.add(currentOre.getPosition());
                    shouldMoveToAnticipated = true;
                    createCache = Inventory.getAll().length;
                    isOreStolen();
                    AntiBan.resetShouldHover();
                    AntiBan.resetShouldOpenMenu();
                    if (shouldHover && oreToHover != null) {
                        mineOre(oreToHover);
                    }
                }

            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="IsOreDepleted">
    private boolean isOreDepleted(RSObject object) {
        if (object != null) {
            RSObject[] check = Objects.getAt(object);

            if (check.length > 0) {
                int id = check[0].getID();
                return rockID != id;
            }
            return true;
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="IsOreStolen">
    private void isOreStolen() {
        int cacheToCheck = Inventory.getAll().length;
        if (createCache != 0 && cacheToCheck != 0) {
            if (createCache == cacheToCheck) {
                AntiBan.incrementResourcesLost();
            }
        }
        createCache = 0;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GetActualOre">
    private RSObject getActualOre() {
        RSObject[] actualOres = getAllObjects();
        if (actualOres.length > 0) {
            if (Vars.get().oresHop) {
                Vars.get().shouldWeHop = false;
            }
            Vars.get().oreToDraw = actualOres;
            return AntiBan.selectNextTarget(actualOres);
        } else {
            if (Vars.get().oresHop) {
                Vars.get().shouldWeHop = true;
            }
            if (shouldMoveToAnticipated && AntiBan.getABCUtil().shouldMoveToAnticipated()) {
                AntiBan.sleepReactionTime();
                AntiBan.goToAnticipated(anticipatedLocation);
                shouldMoveToAnticipated = false;
            }
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ColorCheck">
    private boolean colorCheck(RSObject object) {
        for (short color : object.getDefinition().getModifiedColors()) {
            if (color == Vars.get().oreType.getColor()) {
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
                return colorCheck(rsObject) && Player.getPosition().distanceTo(rsObject) <= Vars.get().radius;
            }
        }.combine(Filters.Objects.nameContains("Rock"), true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GetAllObjects">
    private RSObject[] getAllObjects() {
        RSObject[] objects = Objects.getAll(Vars.get().radius, ORE_FILTER);
        Sorting.sortByDistance(objects, Player.getPosition(), true);
        return objects;
    }
    //</editor-fold>

    public String toString() {
        return "Mining ore" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return !Vars.get().isSlaveSystemIsRunning &&
                !Vars.get().isHoppingWorlds &&
                !Inventory.isFull() &&
                Vars.get().area.distanceTo(Player.getPosition()) <= Vars.get().radius &&
                (Inventory.getCount(Constants.PICKAXES) > 0 || Equipment.getItem(Equipment.SLOTS.WEAPON) != null);
    }

}