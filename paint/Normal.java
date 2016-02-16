package scripts.SPXAIOMiner.paint;

import org.tribot.api2007.Skills;
import scripts.SPXAIOMiner.API.Game.Utility.Utility07;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

import java.awt.*;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Normal {

    public Variables variables;

    public Normal(Variables variables) {
        this.variables = variables;
    }

    public void systemInfo(Graphics g) {
        variables.gainedLevels = Skills.getActualLevel(Skills.SKILLS.MINING) - variables.startLevel;
        variables.gainedXP = Skills.getXP(Skills.SKILLS.MINING) - variables.startXP;
        variables.xpPerHour = (long) (variables.gainedXP * 3600000D / variables.timeRan);
        variables.profit = variables.oresMined * variables.orePrice;
        variables.profitReset = variables.resetOresMined * variables.orePrice;
        variables.profitHR = (long) (variables.profit * 3600000D / (System.currentTimeMillis() - Constants.START_TIME));
        variables.oreHR = (long) (variables.oresMined * 3600000D / (System.currentTimeMillis() - Constants.START_TIME));
        variables.moneyLeftUntilTrade = variables.transferMade - variables.profitReset;

        g.drawString("Ore Mined: " + variables.oresMined + " [P/H: " + variables.oreHR + "] ", 282, 348);
        g.drawString("Exp P/H: " + variables.xpPerHour + " [Gained: " + variables.gainedXP + "] " + "(+" + variables.gainedLevels + ")", 282, 374);
        g.drawString("Profit P/H: " + Utility07.formatNumber(variables.profitHR) + " [Profit: " + Utility07.formatNumber(variables.profit) + "]", 282, 399);
        g.drawString("Next Mule Trade: " + variables.timeUntilTrade + " Minutes" + Utility07.loadingPeriods(), 282, 424);
        g.drawString("Mule Trades: " + variables.masterTrades, 282, 450);
        g.setColor(Constants.BLUE_COLOR);
        g.fillRect(Constants.START_SLAVESYSTEM.x, Constants.START_SLAVESYSTEM.y, Constants.START_SLAVESYSTEM.width, Constants.START_SLAVESYSTEM.height);
        g.setColor(Constants.TEXT_COLOR);
        g.setFont(Constants.LARGE_FONT);
        g.drawString("Start Slave System", Constants.START_SLAVESYSTEM.x + 10, Constants.START_SLAVESYSTEM.y + 16);
    }

}

