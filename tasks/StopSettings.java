package scripts.SPXAIOMiner.tasks;

import org.tribot.api2007.Skills;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.framework.Task;
import scripts.TribotAPI.game.utiity.Utility07;
import scripts.TribotAPI.Printing;
import scripts.TribotAPI.antiban.AntiBan;

/**
 * Created by Sphiinx on 2/16/2016.
 */
public class StopSettings implements Task {

    public void execute() {
        Printing.status("You have reached your desired stopping level...");
        Printing.status("Stopping script...");
        AntiBan.destroy();
        Vars.get().stopScript = true;
    }

    public String toString() {
        return "Stopping script" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        int level = Skills.getActualLevel(Skills.SKILLS.MINING);
        return Vars.get().levelToStop > 0 && level >= Vars.get().levelToStop;
    }
}