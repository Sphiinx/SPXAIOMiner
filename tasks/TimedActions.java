package scripts.SPXAIOMiner.tasks;

import org.tribot.api2007.Player;
import scripts.SPXAIOMiner.framework.Task;
import TribotAPI.game.utiity.Utility07;
import TribotAPI.antiban.AntiBan;

/**
 * Created by Sphiinx on 5/21/2016.
 */
public class TimedActions implements Task {

    public void execute() {
        AntiBan.timedActions();
    }

    public String toString() {
        return "Mining ore" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return Player.getAnimation() != -1 || Player.isMoving();
    }

}

