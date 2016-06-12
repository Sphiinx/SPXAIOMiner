package scripts.SPXAIOMiner.tasks.MuleSystem;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSPlayer;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.framework.Task;
import scripts.TribotAPI.game.utiity.Utility07;

import java.awt.*;

/**
 * Created by Sphiinx on 2/4/2016.
 */
public class TradeMaster implements Task {

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
    public void execute() {
        RSPlayer[] master = Players.find(Vars.get().masterName);
        if (master[0].isOnScreen()) {
            tradeMaster();
        } else {
            walkToMaster();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Trade Master">
    public void tradeMaster() {
        if (Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW || Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW) {
            if (Trading.getOpponentName().equals(Vars.get().masterName)) {
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
                if (Clicking.click("Trade with " + Vars.get().masterName, Vars.get().master[0])) {
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
        if (Trading.offer(0, Vars.get().oreType.getNotedItemID())) {
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
        Point p = Projection.tileToMinimap(Vars.get().master[0].getPosition());
        if (Projection.isInMinimap(p)) {
            RSTile[] path = Walking.generateStraightScreenPath(Vars.get().master[0].getPosition());
            if (Walking.walkScreenPath(path)) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return Vars.get().master[0].isOnScreen();
                    }
                }, General.random(1000, 1200));
            }
        } else {
            WebWalking.walkTo(Vars.get().master[0]);
        }
    }
    //</editor-fold>

    public String toString() {
        return "Trading master" + Utility07.loadingPeriods();
    }

    //<editor-fold defaultstate="collapsed" desc="Validation">
    public boolean validate() {
        Vars.get().master = Players.find(Vars.get().masterName);
        if (Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW || Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW) {
            return true;
        }
        return Vars.get().isSlaveSystemIsRunning && Vars.get().master.length > 0 && Inventory.getCount(Vars.get().oreType.getNotedItemID()) >= Vars.get().resetOresMined;
    }
    //</editor-fold>

}