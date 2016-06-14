package scripts.SPXAIOMiner.tasks;

import org.tribot.api2007.Skills;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.data.enums.OreType;
import scripts.SPXAIOMiner.framework.Task;
import TribotAPI.util.Logging;
import TribotAPI.game.game.Game07;
import TribotAPI.game.pricechecking.PriceChecking07;

/**
 * Created by Sphiinx on 2/27/2016.
 */
public class Progressive implements Task {

    public void execute() {
        Logging.status("Setting progressive mode LogType...");
        Vars.get().oreType = getBestOreType();
        Vars.get().orePrice = PriceChecking07.getOSBuddyPrice(Vars.get().oreType.getItemID());
    }

    //<editor-fold defaultstate="collapsed" desc="Get Best Ore">
    private OreType getBestOreType() {
        int mining = Skills.getCurrentLevel(Skills.SKILLS.MINING);

        if (mining >= 30) {
            Vars.get().area = Vars.get().location3;
            return Vars.get().ore3;
        } else if (mining >= 15) {
            Vars.get().area = Vars.get().location2;
            return Vars.get().ore2;
        } else {
            Vars.get().area = Vars.get().location1;
            return Vars.get().ore1;
        }
    }
    //</editor-fold>

    public String toString() {
        return "";
    }

    public boolean validate() {
        return Game07.isInGame() && Vars.get().oreType != getBestOreType();
    }
}