package scripts.spxaiominer.tasks.mule;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;

/**
 * Created by Sphiinx on 8/6/2016.
 */
public class WalkBackToMuleTile implements Task {

    @Override
    public boolean validate() {
        return Vars.get().mule_location != null && Player.getPosition().distanceTo(Vars.get().mule_location) > 5;
    }

    @Override
    public void execute() {
        Vars.get().slave_trading_name = null;
        WebWalking.walkTo(Vars.get().mule_location, new Condition() {
            @Override
            public boolean active() {
                return Player.getPosition().distanceTo(Vars.get().mule_location) <= 5;
            }
        }, 250);
    }

    @Override
    public String toString() {
        return "Walking to mule tile";
    }
}

