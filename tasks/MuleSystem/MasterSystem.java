package scripts.SPXAIOMiner.tasks.MuleSystem;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSPlayer;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.framework.Task;
import TribotAPI.game.banking.Banking07;
import TribotAPI.game.game.Game07;
import TribotAPI.game.utiity.Utility07;

/**
 * Created by Sphiinx on 2/3/2016.
 */
public class MasterSystem implements Task {

    //<editor-fold defaultstate="collapsed" desc="Execution">
    public void execute() {
        if (Inventory.isFull()) {
            if (Banking.isBankScreenOpen()) {
                Banking07.depositInventory();
            } else {
                Banking07.openBank();
            }
        } else if (!Vars.get().currentMasterPosition.isOnScreen()) {
            WebWalking.walkTo(Vars.get().currentMasterPosition);
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
            RSPlayer[] player = Players.find(Vars.get().playerTrading);
            if (Vars.get().playerTrading != null && player != null) {
                if (Vars.get().playerTrading.length() > 0 && player.length > 0) {
                    if (Clicking.click("Trade with " + Vars.get().playerTrading, player[0])) {
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
                Vars.get().playerTrading = null;
            }
        }
    }
    //</editor-fold>

    public String toString() {
        return "Master System" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return Vars.get().masterSystem && Game07.isInGame();
    }

}