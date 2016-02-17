package scripts.SPXAIOMiner.messagerecieved;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.API.Game.WorldHopper.WorldHopper07;
import scripts.SPXAIOMiner.API.Printing;
import scripts.SPXAIOMiner.AntiBan;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/16/2016.
 */
public class Server {

    public Variables variables;

    public Server(Variables variables) {
        this.variables = variables;
    }

    public void incrementTrades() {
        variables.masterTrades++;
    }

    public void setSlaveSettings() {
        variables.resetOresMined = 0;
        variables.resetTimeRan = System.currentTimeMillis();
    }

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

    public void incrementOre(String string) {
        variables.oresMined++;
        variables.resetOresMined++;
    }

    public void performAntiban() {
        int sleep = AntiBan.getReactionTime();
        Printing.dev("Reaction Time: " + sleep);
        AntiBan.sleepReactionTime();
        AntiBan.incrementResourcesWon();
    }

}

