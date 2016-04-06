package scripts.SPXAIOMiner.antiban;

import org.tribot.api2007.Player;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/27/2016.
 */
public class TimedActions extends Task{


    public TimedActions(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        AntiBan.timedActions();
    }

    @Override
    public String toString() {
        return "Mining ore" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return Player.getAnimation() != -1 || Player.isMoving();
    }

}

