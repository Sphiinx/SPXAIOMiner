package scripts.SPXAIOMiner.paint;

import scripts.SPXAIOMiner.api.game.utiity.Utility07;
import scripts.SPXAIOMiner.data.Constants;

import java.awt.*;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Normal {

    public PaintManager paintManager;

    public Normal(PaintManager paintManager) {
        this.paintManager = paintManager;
    }

    //<editor-fold defaultstate="collapsed" desc="Draw Normal Info">
    public void drawNormalInfo(Graphics g) {
        g.drawString("Ore Mined: " + paintManager.getOresMined() + " [P/H: " + paintManager.getOrePerHour() + "] ", 282, 348);
        g.drawString("Exp P/H: " + paintManager.getXPPerHour() + " [Gained: " + paintManager.getGainedXP() + "] " + "(+" + paintManager.getGainedLevels() + ")", 282, 374);
        g.drawString("Profit P/H: " + Utility07.formatNumber(paintManager.getProfitPerHour()) + " [Profit: " + Utility07.formatNumber(paintManager.getProfit()) + "]", 282, 399);
        g.drawString("Next Mule Trade: " + paintManager.getTimeLeftUntilTrade() + " Minutes" + Utility07.loadingPeriods(), 282, 424);
        g.drawString("Mule Trades: " + paintManager.getMuleTrades(), 282, 450);

        g.setColor(Constants.BLUE_COLOR);
        g.fillRect(Constants.START_SLAVESYSTEM.x, Constants.START_SLAVESYSTEM.y, Constants.START_SLAVESYSTEM.width, Constants.START_SLAVESYSTEM.height);
        g.setColor(Constants.TEXT_COLOR);
        g.setFont(Constants.LARGE_FONT);
        g.drawString("Start Slave System", Constants.START_SLAVESYSTEM.x + 10, Constants.START_SLAVESYSTEM.y + 16);
    }
    //</editor-fold>

}