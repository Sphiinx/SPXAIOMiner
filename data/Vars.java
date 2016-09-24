package scripts.spxaiominer.data;

import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import scripts.spxaiominer.data.enums.MiningLocation;
import scripts.spxaiominer.data.enums.Mode;
import scripts.spxaiominer.data.enums.OreType;
import scripts.tribotapi.game.worldswitcher.enums.SwitcherWorldType;

import java.io.File;
import java.util.Properties;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public class Vars {

    public static Vars vars;

    public static Vars get() {
        return vars == null ? vars = new Vars() : vars;
    }

    public static void reset() {
        vars = null;
    }

    public int profit;
    public int radius;
    public int ore_price;
    public int ore_mined;
    public int mule_world;
    public int mule_trades;
    public int slave_world;
    public int slave_ores_mined;
    public int transfer_variation;
    public int transfer_after_profit;
    public int transfer_after_minutes;
    public int hop_if_players_greater_than;

    public long slave_time_ran;

    public boolean is_mule;
    public boolean is_slave;
    public boolean drop_gems;
    public boolean world_hop;
    public boolean radius_mine;
    public boolean upgrade_pickaxe;
    public boolean is_transferring;
    public boolean disable_abc2_sleeps;
    public boolean is_upgrading_pickaxe;
    public boolean hop_if_no_ores_available;
    public boolean is_switching_to_slave_world;
    public boolean switch_slave_back_to_original_world;

    public String mule_username;
    public String slave_trading_name;

    public RSTile mule_location;
    public RSTile mining_location_tile;

    public Mode mode;
    public OreType ore_type;
    public MiningLocation mining_location;
    public SwitcherWorldType world_type;


    public File file_path;
    public Properties file_properties = new Properties();

}

