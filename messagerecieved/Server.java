package scripts.SPXAIOMiner.messagerecieved;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import scripts.SPXAIOMiner.data.Vars;
import scripts.TribotAPI.game.worldhopping.WorldHopper07;
import scripts.TribotAPI.game.utiity.Utility07;
import scripts.TribotAPI.antiban.AntiBan;

/**
 * Created by Sphiinx on 2/16/2016.
 */
public class Server {

    //<editor-fold defaultstate="collapsed" desc="Increment Trades">
    public void incrementTrades() {
        Vars.get().muleTrades++;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Set Slave Settings">
    public void setSlaveSettings() {
        Vars.get().resetOresMined = 0;
        Vars.get().resetTimeRan = System.currentTimeMillis();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Switch World">
    public void switchWorldBack() {
        if (Utility07.getCurrentWorld() != Vars.get().originalWorld) {
            if (Vars.get().switchSlaveBack) {
                if (WorldHopper07.switchWorld(Vars.get().originalWorld)) {
                    Timing.waitCondition(new Condition() {
                        @Override
                        public boolean active() {
                            General.sleep(100);
                            return Utility07.getCurrentWorld() == Vars.get().originalWorld;
                        }
                    }, General.random(2000, 2500));
                    Vars.get().isSlaveSystemIsRunning = false;
                }
            }
        } else {
            Vars.get().isSlaveSystemIsRunning = false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Increment Ore">
    public void incrementOre() {
        Vars.get().oresMined++;
        Vars.get().resetOresMined++;
        AntiBan.incrementResourcesWon();
    }
    //</editor-fold>

}