package scripts.SPXAIOMiner.messagerecieved;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.api.game.worldhopper.WorldHopper07;
import scripts.SPXAIOMiner.antiban.AntiBan;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/16/2016.
 */
public class Server {

    public Variables variables;

    public Server(Variables variables) {
        this.variables = variables;
    }

    //<editor-fold defaultstate="collapsed" desc="Increment Trades">
    public void incrementTrades() {
        variables.muleTrades++;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Set Slave Settings">
    public void setSlaveSettings() {
        variables.resetOresMined = 0;
        variables.resetTimeRan = System.currentTimeMillis();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Switch World">
    public void switchWorldBack() {
        if (Utility07.getCurrentWorld() != variables.originalWorld) {
            if (variables.switchSlaveBack) {
                if (WorldHopper07.switchWorld(variables.originalWorld)) {
                    Timing.waitCondition(new Condition() {
                        @Override
                        public boolean active() {
                            General.sleep(100);
                            return Utility07.getCurrentWorld() == variables.originalWorld;
                        }
                    }, General.random(2000, 2500));
                    variables.isSlaveSystemIsRunning = false;
                }
            }
        } else {
            variables.isSlaveSystemIsRunning = false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Increment Ore">
    public void incrementOre() {
        variables.oresMined++;
        variables.resetOresMined++;
        AntiBan.incrementResourcesWon();
    }
    //</editor-fold>

}