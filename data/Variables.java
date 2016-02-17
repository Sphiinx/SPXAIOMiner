package scripts.SPXAIOMiner.data;

import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSPlayer;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.data.enums.Mode;
import scripts.SPXAIOMiner.data.enums.OreType;
import scripts.SPXAIOMiner.data.enums.Pickaxe;
import scripts.SPXAIOMiner.data.enums.Worlds;

import java.io.File;
import java.util.Properties;

/**
 * Created by Sphiinx on 1/15/2016.
 */
public class Variables {

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
    public boolean runFromCombat;
    public boolean upgradePickaxe;
    public boolean switchSlaveBack;
    public boolean drawRadius = true;
    public boolean isUpgradingPickaxe;
    public boolean pickaxeInInventory;
    public boolean isSlaveSystemIsRunning;

    public double version;

    public long oreHR;
    public long timeRan;
    public long profitHR;
    public long xpPerHour;
    public long resetTimeRan;
    public long timeRanMinutes;
    public long timeUntilTrade;
    public long moneyLeftUntilTrade;

    public int profit;
    public int startXP;
    public int gainedXP;
    public int orePrice;
    public int oresMined;
    public int variation;
    public int startLevel;
    public int levelToStop;
    public int profitReset;
    public int radius = 30;
    public int masterWorld;
    public int transferMade;
    public int gainedLevels;
    public int playersToHop;
    public int masterTrades;
    public int orePriceTotal;
    public int originalWorld;
    public int resetOresMined;
    public int transferMinutes;

    public File path;

    public Mode mode;
    public Worlds worlds;
    public OreType oreType;
    public Pickaxe pickaxe;

    public RSTile area;
    public RSTile currentMasterPosition;

    public String status;
    public String masterName;
    public String masterPositon;
    public String playerTrading;

    public RSPlayer[] master;
    public RSObject[] oreToDraw;

    public Properties properties = new Properties();

}

