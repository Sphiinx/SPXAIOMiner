package scripts.SPXAIOMiner.tasks.MuleSystem;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSPlayer;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.data.Variables;

import java.awt.*;

/**
 * Created by Sphiinx on 2/4/2016.
 */
public class TradeMaster extends Task {

    public TradeMaster(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        RSPlayer[] master = Players.find(vars.masterName);
        if (master[0].isOnScreen()) {
            tradeMaster();
        } else {
            walkToMaster();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Trade Master">
    public void tradeMaster() {
        if (Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW || Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW) {
            if (Trading.getOpponentName().equals(vars.masterName)) {
                if (Trading.getOfferedItems(false).length > 0) {
                    acceptTrade();
                } else {
                    offerItems();
                }
            } else {
                scamPrevention();
            }
        } else {
            if (!Banking.isBankScreenOpen()) {
                if (Clicking.click("Trade with " + vars.masterName, vars.master[0])) {
                    Timing.waitCondition(new Condition() {
                        @Override
                        public boolean active() {
                            General.sleep(100);
                            return Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW;
                        }
                    }, General.random(3000, 3500));
                }
            } else {
                if (Banking.close()) {
                    Timing.waitCondition(new Condition() {
                        @Override
                        public boolean active() {
                            General.sleep(100);
                            return !Banking.isBankScreenOpen();
                        }
                    }, General.random(1000, 1200));
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="AcceptTrade">
    public void acceptTrade() {
        if (Trading.accept()) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    General.sleep(100);
                    return Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW || Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW || (Trading.getWindowState() != Trading.WINDOW_STATE.FIRST_WINDOW && Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW);
                }
            }, General.random(1000, 1200));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="OfferItems">
    public void offerItems() {
        if (Trading.offer(0, vars.oreType.getNotedItemIDs())) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    General.sleep(100);
                    return Trading.getOfferedItems(false).length > 0;
                }
            }, General.random(1000, 1200));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ScamPrevention">
    public void scamPrevention() {
        if (Trading.close()) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    General.sleep(100);
                    return Trading.getWindowState() != Trading.WINDOW_STATE.FIRST_WINDOW && Trading.getWindowState() != Trading.WINDOW_STATE.SECOND_WINDOW;
                }
            }, General.random(1000, 1200));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="WalkToMaster">
    public void walkToMaster() {
        Point p = Projection.tileToMinimap(vars.master[0].getPosition());
        if (Projection.isInMinimap(p)) {
            RSTile[] path = Walking.generateStraightScreenPath(vars.master[0].getPosition());
            if (Walking.walkScreenPath(path)) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return vars.master[0].isOnScreen();
                    }
                }, General.random(1000, 1200));
            }
        } else {
            WebWalking.walkTo(vars.master[0]);
        }
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Trading master" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        vars.master = Players.find(vars.masterName);
        if (Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW || Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW) {
            return true;
        }
        return vars.isSlaveSystemIsRunning && vars.master.length > 0 && Inventory.getCount(vars.oreType.getNotedItemIDs()) >= vars.resetOresMined;
    }

}

