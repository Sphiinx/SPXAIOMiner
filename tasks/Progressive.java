package scripts.SPXAIOMiner.tasks;

import org.tribot.api2007.Skills;
import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.game.Game07;
import scripts.SPXAIOMiner.api.game.pricechecking.PriceChecking07;
import scripts.SPXAIOMiner.api.Printing;
import scripts.SPXAIOMiner.data.Variables;
import scripts.SPXAIOMiner.data.enums.OreType;

/**
 * Created by Sphiinx on 2/27/2016.
 */
public class Progressive extends Task {

    public Progressive(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        Printing.status("Setting progressive mode LogType...");
        vars.oreType = getBestOreType();
        vars.orePrice = PriceChecking07.getOSbuddyPrice(vars.oreType.getItemID());
    }

    //<editor-fold defaultstate="collapsed" desc="Get Best Ore">
    private OreType getBestOreType() {
        int mining = Skills.getCurrentLevel(Skills.SKILLS.MINING);

        if (mining >= 30) {
            vars.area = vars.location3;
            return vars.ore3;
        } else if (mining >= 15) {
            vars.area = vars.location2;
            return vars.ore2;
        } else {
            vars.area = vars.location1;
            return vars.ore1;
        }
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean validate() {
        return Game07.isInGame() && vars.oreType != getBestOreType();
    }
}