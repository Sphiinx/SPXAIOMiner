package scripts.SPXAIOMiner.tasks.MuleSystem;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSPlayer;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.banking.Banking07;
import scripts.SPXAIOMiner.api.game.game.Game07;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/3/2016.
 */
public class MasterSystem extends Task {

    public MasterSystem(Variables v) {
        super(v);
    }

    //<editor-fold defaultstate="collapsed" desc="Execution">
    @Override
    public void execute() {
        if (Inventory.isFull()) {
            if (Banking.isBankScreenOpen()) {
                Banking07.depositInventory();
            } else {
                Banking07.openBank();
            }
        } else if (!vars.currentMasterPosition.isOnScreen()) {
            WebWalking.walkTo(vars.currentMasterPosition);
        } else {
            tradeSlave();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="TradeSlave">
    public void tradeSlave() {
        if (Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW || Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW) {
            if (Trading.getOfferedItems(true).length > 0) {
                acceptTrade();
            }
        } else {
            RSPlayer[] player = Players.find(vars.playerTrading);
            if (vars.playerTrading != null && player != null) {
                if (vars.playerTrading.length() > 0 && player.length > 0) {
                    if (Clicking.click("Trade with " + vars.playerTrading, player[0])) {
                        Timing.waitCondition(new Condition() {
                            @Override
                            public boolean active() {
                                General.sleep(100);
                                return Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW;
                            }
                        }, General.random(1000, 1200));
                    }
                }
            }
        }
    }
    //</editor-fold-

    //<editor-fold defaultstate="collapsed" desc="AcceptTrade">
    public void acceptTrade() {
        if (Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW) {
            if (Trading.accept()) {
                Timing.waitCondition(new Condition() {
                    @Override
                    public boolean active() {
                        General.sleep(100);
                        return Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW;
                    }
                }, General.random(1000, 1200));
            }
        } else {
            if (Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW) {
                if (Trading.accept()) {
                    Timing.waitCondition(new Condition() {
                        @Override
                        public boolean active() {
                            General.sleep(100);
                            return Trading.getWindowState() != Trading.WINDOW_STATE.FIRST_WINDOW && Trading.getWindowState() != Trading.WINDOW_STATE.SECOND_WINDOW;
                        }
                    }, General.random(1000, 1200));
                }
                vars.playerTrading = null;
            }
        }
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Master System" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return vars.masterSystem && Game07.isInGame();
    }

}