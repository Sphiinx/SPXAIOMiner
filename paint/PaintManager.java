package scripts.SPXAIOMiner.paint;

import org.tribot.api2007.Skills;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Vars;

import java.awt.*;

/**
 * Created by Sphiinx on 3/23/2016.
 */
public class PaintManager {

    private Global global = new Global(this);
    private Normal normal = new Normal(this);
    private Master master = new Master(this);

    //<editor-fold defaultstate="collapsed" desc="Get Information">
    public long getTimeRan() {
        return System.currentTimeMillis() - Constants.START_TIME;
    }

    public int getMasterTradesHr() {
        return (int) (Vars.get().muleTrades * 3600000D / (System.currentTimeMillis() - Constants.START_TIME));
    }

    public int getGainedLevels() {
        return Skills.getActualLevel(Skills.SKILLS.MINING) - Vars.get().startLevel;
    }

    public int getGainedXP() {
        return Skills.getXP(Skills.SKILLS.MINING) - Vars.get().startXP;
    }

    public long getXPPerHour() {
        return (long) (getGainedXP() * 3600000D / getTimeRan());
    }

    public long getProfit() {
        return Vars.get().oresMined * Vars.get().orePrice;
    }

    public long getProfitPerHour() {
        return (long) (getProfit() * 3600000D / (System.currentTimeMillis() - Constants.START_TIME));
    }

    public long getOrePerHour() {
        return (long) (Vars.get().oresMined * 3600000D / (System.currentTimeMillis() - Constants.START_TIME));
    }

    public long getProfitReset() {
        return Vars.get().resetOresMined * Vars.get().orePrice;
    }

    public int getOresMined() {
        return Vars.get().oresMined;
    }

    public int getMuleTrades() {
        return Vars.get().muleTrades;
    }

    public String getStatus() {
        return Vars.get().status;
    }

    public double getVersion() {
        return Vars.get().version;
    }

    public boolean drawRadius() {
        return Vars.get().drawRadius;
    }

    public boolean radiusMine() {
        return Vars.get().radiusMine;
    }

    public RSTile getArea() {
        return Vars.get().area;
    }

    public int getRadius() {
        return Vars.get().radius;
    }

    public boolean drawObjects() {
        return Vars.get().drawObjects;
    }

    public RSObject[] getOreToDraw() {
        return Vars.get().oreToDraw;
    }

    public boolean drawTiles() {
        return Vars.get().drawTiles;
    }

    public RSTile getOreToDrawTilePosition() {
        return Vars.get().oreToDraw[0].getPosition();
    }

    public boolean slaveSystem() {
        return Vars.get().slaveSystem;
    }

    public int getTransferMinutes() {
        return Vars.get().transferMinutes;
    }

    public int getTransferMade() {
        return Vars.get().transferMade;
    }

    public int getOrePrice() {
        return Vars.get().orePrice;
    }

    public long getMoneyLeftUntilTrade() {
        return Vars.get().transferMade - getProfitReset();
    }

    public long getTimeRanMinutes() {
        return Vars.get().timeRanMinutes;
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

    //<editor-fold defaultstate="collapsed" desc="Slave">
    public long getTimeUntilTrade() {
        if (slaveSystem()) {
            if (!Vars.get().isSlaveSystemIsRunning) {
                if (getTransferMinutes() > 0 || getTransferMade() > 0) {
                    if (getTransferMade() <= getTransferMinutes()) {
                        return getTransferMinutes() - getTimeRanMinutes();
                    } else {
                        return (getMoneyLeftUntilTrade() / getProfitPerHour()) * 60;
                    }
                }
            }
        }
        return 0;
    }
    //</editor-fold>

}

