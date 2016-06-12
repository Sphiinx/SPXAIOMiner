package scripts.SPXAIOMiner.data;

import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSPlayer;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.data.enums.*;
import scripts.TribotAPI.game.utiity.enums.WorldType;

import java.io.File;
import java.util.Properties;

/**
 * Created by Sphiinx on 1/15/2016.
 */
public class Vars {

    public static Vars vars;

    public static Vars get() {
        return vars == null ? vars = new Vars() : vars;
    }

    public static void reset() {
        vars = null;
    }

    //<editor-fold defaultstate="collapsed" desc="Booleans">
    public boolean oresHop;
    public boolean worldHop;
    public boolean dropGems;
    public boolean drawTiles;
    public boolean stopScript;
    public boolean radiusMine;
    public boolean drawObjects;
    public boolean shouldWeHop;
    public boolean guiComplete;
    public boolean slaveSystem;
    public boolean disablePaint;
    public boolean masterSystem;
    public boolean disableSleeps;
    public boolean upgradePickaxe;
    public boolean progressiveMode;
    public boolean isHoppingWorlds;
    public boolean switchSlaveBack;
    public boolean drawRadius = true;
    public boolean isUpgradingPickaxe;
    public boolean pickaxeInInventory;
    public boolean isSlaveSystemIsRunning;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Doubles">
    public double version;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Longs">
    public long resetTimeRan;
    public long timeRanMinutes;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Integers">
    public int profit;
    public int startXP;
    public int gainedXP;
    public int orePrice;
    public int oresMined;
    public int variation;
    public int startLevel;
    public int levelToStop;
    public int radius = 25;
    public int masterWorld;
    public int transferMade;
    public int gainedLevels;
    public int playersToHop;
    public int muleTrades;
    public int orePriceTotal;
    public int originalWorld;
    public int resetOresMined;
    public int transferMinutes;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Other">
    public File path;

    public Mode mode;
    public WorldType worldType;
    public OreType oreType;
    public OreType ore1;
    public OreType ore2;
    public OreType ore3;
    public Pickaxe pickaxe;

    public RSTile area;
    public RSTile location1;
    public RSTile location2;
    public RSTile location3;
    public RSTile safePosition;
    public RSTile currentMasterPosition;

    public String status;
    public String masterName;
    public String masterPositon;
    public String playerTrading;

    public RSPlayer[] master;
    public RSObject[] oreToDraw;

    public Properties properties = new Properties();
    //</editor-fold>

}