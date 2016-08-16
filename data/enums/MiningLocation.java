package scripts.spxaiominer.data.enums;

import org.tribot.api2007.types.RSTile;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public enum MiningLocation {

    VARROCK_WEST(new RSTile(3181, 3372, 0), new RSTile(3171, 3389, 0), OreType.CLAY, OreType.TIN, OreType.IRON, OreType.SILVER),
    VARROCK_EAST(new RSTile(3285, 3366, 0), new RSTile(3222, 3217, 0), OreType.COPPER, OreType.TIN, OreType.IRON),
    LUMBRIDGE_EAST(new RSTile(3227, 3148, 0), new RSTile(3222, 3217, 0), OreType.COPPER, OreType.TIN),
    LUMBRIDGE_WEST(new RSTile(3147, 3148, 0), new RSTile(3222, 3217, 0), OreType.COAL, OreType.MITHRIL, OreType.ADAMANTITE),
    AL_KHARID(new RSTile(3299, 3296, 0), new RSTile(3222, 3217, 0), OreType.COPPER, OreType.IRON, OreType.SILVER, OreType.COAL, OreType.GOLD, OreType.MITHRIL, OreType.ADAMANTITE),
    BARBARIAN_VILLAGE(new RSTile(3081, 3422, 0), new RSTile(3222, 3217, 0), OreType.TIN, OreType.COAL),
    WEST_FALADOR(new RSTile(2908, 3360, 0), new RSTile(3222, 3217, 0), OreType.COPPER, OreType.TIN, OreType.IRON, OreType.COAL),
    DWARVEN_MINE(new RSTile(3045, 9777, 0), new RSTile(3222, 3217, 0), OreType.COPPER, OreType.COAL, OreType.TIN, OreType.IRON, OreType.GOLD, OreType.MITHRIL, OreType.ADAMANTITE),
    MINING_GUILD(new RSTile(3040, 9738, 0), new RSTile(3222, 3217, 0), OreType.COAL, OreType.MITHRIL),
    RIMMINGTON(new RSTile(2978, 3241, 0), new RSTile(3222, 3217, 0), OreType.TIN, OreType.COPPER, OreType.IRON, OreType.CLAY, OreType.GOLD),
    CRAFTING_GUILD(new RSTile(2940, 3286, 0), new RSTile(3222, 3217, 0), OreType.CLAY, OreType.SILVER, OreType.GOLD),
    EAST_ARDOUGNE(new RSTile(2701, 3332, 0), new RSTile(3222, 3217, 0), OreType.IRON, OreType.COAL),
    SOUTH_ARDOUGNE(new RSTile(2604, 3221, 0), new RSTile(3222, 3217, 0), OreType.IRON, OreType.COAL),
    YANILLE(new RSTile(2630, 3140, 0), new RSTile(3222, 3217, 0), OreType.CLAY, OreType.COPPER, OreType.TIN, OreType.IRON, OreType.COAL, OreType.MITHRIL),
    PORT_KHAZARD(new RSTile(2653, 3169, 0), new RSTile(3222, 3217, 0), OreType.TIN, OreType.COPPER, OreType.MITHRIL),
    SILVAREA(new RSTile(3372, 3500, 0), new RSTile(3222, 3217, 0), OreType.LIMESTONE),
    COAL_TRUCKS(new RSTile(2581, 3481, 0), new RSTile(3222, 3217, 0), OreType.COAL),
    WILDERNESS_SOUTHW(new RSTile(3017, 3592, 0), new RSTile(3222, 3217, 0), OreType.COAL),
    WILDERNESS_SOUTH(new RSTile(3106, 3567, 0), new RSTile(3222, 3217, 0), OreType.COAL, OreType.IRON),
    WILDERNESS_NORTH(new RSTile(3087, 3762, 0), new RSTile(3222, 3217, 0), OreType.IRON, OreType.COAL, OreType.MITHRIL, OreType.ADAMANTITE);

    private final RSTile TILE;
    private final RSTile SAFE_TILE;
    private final OreType[] SUPPORTED_ORE;

    MiningLocation(RSTile tile, RSTile safe_tile, OreType... supported_ore) {
        this.TILE = tile;
        this.SAFE_TILE = safe_tile;
        this.SUPPORTED_ORE = supported_ore;
    }

    public RSTile getTile() {
        return TILE;
    }

    public RSTile getSafeTile() {
        return SAFE_TILE;
    }

    public OreType[] getSupportedOre() {
        return SUPPORTED_ORE;
    }

}
