package scripts.SPXAIOMiner.paint;

import org.tribot.api2007.Skills;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

import java.awt.*;

/**
 * Created by Sphiinx on 3/23/2016.
 */
public class PaintManager {

    public Variables variables;
    private Global global = new Global(this);
    private Normal normal = new Normal(this);
    private Master master = new Master(this);


    public PaintManager(Variables variables) {
        this.variables = variables;
    }

    //<editor-fold defaultstate="collapsed" desc="Get Information">
    public long getTimeRan() {
        return System.currentTimeMillis() - Constants.START_TIME;
    }

    public int getMasterTradesHr() {
        return (int) (variables.muleTrades * 3600000D / (System.currentTimeMillis() - Constants.START_TIME));
    }

    public int getGainedLevels() {
        return Skills.getActualLevel(Skills.SKILLS.MINING) - variables.startLevel;
    }

    public int getGainedXP() {
        return Skills.getXP(Skills.SKILLS.MINING) - variables.startXP;
    }

    public long getXPPerHour() {
        return (long) (getGainedXP() * 3600000D / getTimeRan());
    }

    public long getProfit() {
        return variables.oresMined * variables.orePrice;
    }

    public long getProfitPerHour() {
        return (long) (getProfit() * 3600000D / (System.currentTimeMillis() - Constants.START_TIME));
    }

    public long getOrePerHour() {
        return (long) (variables.oresMined * 3600000D / (System.currentTimeMillis() - Constants.START_TIME));
    }

    public long getProfitReset() {
        return variables.resetOresMined * variables.orePrice;
    }

    public long getTimeLeftUntilTrade() {
        if (variables.slaveSystem) {
            return variables.transferMade - getProfitReset();
        }
        return 0;
    }

    public int getOresMined() {
        return variables.oresMined;
    }

    public int getMuleTrades() {
        return variables.muleTrades;
    }

    public String getStatus() {
        return variables.status;
    }

    public double getVersion() {
        return variables.version;
    }

    public boolean drawRadius() {
        return variables.drawRadius;
    }

    public boolean radiusMine() {
        return variables.radiusMine;
    }

    public RSTile getArea() {
        return variables.area;
    }

    public int getRadius() {
        return variables.radius;
    }

    public boolean drawObjects() {
        return variables.drawObjects;
    }

    public RSObject[] getOreToDraw() {
        return variables.oreToDraw;
    }

    public boolean drawTiles() {
        return variables.drawTiles;
    }

    public RSTile getOreToDrawTilePosition() {
        return variables.oreToDraw[0].getPosition();
    }

    public boolean slaveSystem() {
        return variables.slaveSystem;
    }

    public int getTransferMinutes() {
        return variables.transferMinutes;
    }

    public int getTransferMade() {
        return variables.transferMade;
    }

    public int getOrePrice() {
        return variables.orePrice;
    }

    public long getMoneyLeftUntilTrade() {
        return variables.moneyLeftUntilTrade;
    }

    public long getTimeRanMinutes() {
        return variables.timeRanMinutes;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Global">
    public void drawRadius(Graphics g) {
        global.drawRadius(g);
    }

    public void drawObjects(Graphics g) {
        global.drawObjects(g);
    }

    public void drawTiles(Graphics g) {
        global.drawTiles(g);
    }

    public void drawCloseButton(Graphics g) {
        global.drawCloseButton(g);
    }

    public void drawGeneralInfo(Graphics g) {
        global.drawGlobalInfo(g);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Normal">
    public void drawNormalInfo(Graphics g) {
        normal.drawNormalInfo(g);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Master">
    public void drawMasterInfo(Graphics g) {
        master.drawMasterInfo(g);
    }
    //</editor-fold>

}

