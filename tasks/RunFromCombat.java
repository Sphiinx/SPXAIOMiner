package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.WebWalking;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Combat.Combat07;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.AntiBan;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;


/**
 * Created by Sphiinx on 2/10/2016.
 */
public class RunFromCombat extends Task {

    public RunFromCombat(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        AntiBan.activateRun();
        WebWalking.walkTo(Constants.SAFE_ZONE, new Condition() {
            @Override
            public boolean active() {
                General.sleep(100);
                return !Combat07.isInCombat();
            }
        }, General.random(100, 150));
    }

    @Override
    public String toString() {
        return "Running from Combat" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        return Combat07.isInCombat();
    }

}

