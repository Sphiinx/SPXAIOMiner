package scripts.SPXAIOMiner.tasks;

import org.tribot.api2007.Skills;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.api.Printing;
import scripts.SPXAIOMiner.antiban.AntiBan;
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