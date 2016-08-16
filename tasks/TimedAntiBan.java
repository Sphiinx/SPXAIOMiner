package scripts.spxaiominer.tasks;

import org.tribot.api2007.Player;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.antiban.AntiBan;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class TimedAntiBan implements Task {


    @Override
    public boolean validate() {
        return Player.getAnimation() != -1 || Player.isMoving();
    }

    @Override
    public void execute() {
        AntiBan.timedActions();
    }

    @Override
    public String toString() {
        return "Performing Anti-Ban";
    }

}

