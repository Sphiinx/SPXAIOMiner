package scripts.SPXAIOMiner.tasks;

import org.tribot.api2007.Skills;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.API.Printing;
import scripts.SPXAIOMiner.AntiBan;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/16/2016.
 */
public class StopSettings extends Task{


    public StopSettings(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        Printing.status("You have reached your desired stopping level...");
        Printing.status("Stopping script...");
        AntiBan.destroy();
        vars.stopScript = true;
    }

    @Override
    public String toString() {
        return "Stopping script" + Utility07.loadingPeriods();
    }

    @Override
    public boolean validate() {
        int level = Skills.getActualLevel(Skills.SKILLS.MINING);
        return vars.levelToStop > 0 && level >= vars.levelToStop;
    }
}

