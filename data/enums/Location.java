package scripts.SPXAIOMiner.data.enums;

import org.tribot.api2007.types.RSTile;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public enum Location {

    VARROCK_WEST(new RSTile(3181, 3372, 0), OreType.TIN, OreType.IRON, OreType.SILVER, OreType.CLAY),
    VARROCK_EAST(new RSTile(3286, 3365, 0), OreType.IRON, OreType.TIN, OreType.COPPER),
    LUMBRIDGE_EAST(new RSTile(3227, 3148, 0), OreType.COPPER, OreType.TIN),
    LUMBRIDGE_WEST(new RSTile(3147, 3148, 0), OreType.COAL, OreType.MITHRIL, OreType.ADAMANTITE),
    AL_KHARID(new RSTile(3299, 3296, 0), OreType.COPPER, OreType.IRON, OreType.SILVER, OreType.COAL, OreType.GOLD, OreType.MITHRIL, OreType.ADAMANTITE),
    BARBARIAN_VILLAGE(new RSTile(3081, 3422, 0), OreType.TIN, OreType.COAL),
    WEST_FALADOR(new RSTile(2908, 3360, 0), OreType.COPPER, OreType.TIN, OreType.IRON, OreType.COAL),
    RIMMINGTON(new RSTile(2978, 3241, 0), OreType.TIN, OreType.COPPER, OreType.IRON, OreType.CLAY, OreType.GOLD),
    CRAFTING_GUILD(new RSTile(2940, 3286, 0), OreType.CLAY, OreType.SILVER, OreType.GOLD),
    SHILO_VILLAGE(new RSTile(2823, 3000, 0)),
    EAST_ARDOUGNE(new RSTile(2701, 3332, 0), OreType.IRON, OreType.COAL),
    SOUTH_ARDOUGNE(new RSTile(2604, 3221, 0), OreType.IRON, OreType.COAL),
    YANILLE(new RSTile(2630, 3140, 0), OreType.CLAY, OreType.COPPER, OreType.TIN, OreType.IRON, OreType.COAL, OreType.MITHRIL),
    PORT_KHAZARD(new RSTile(2654, 3170, 0), OreType.TIN, OreType.COPPER, OreType.MITHRIL),
    COAL_TRUCKS(new RSTile(2581, 3481, 0), OreType.COAL),
    WILDERNESS_SOUTHW(new RSTile(3017, 3592, 0), OreType.COAL),
    WILDERNESS_SOUTH(new RSTile(3106, 3567, 0), OreType.COAL, OreType.IRON),
    WILDERNESS_NORTH(new RSTile(3087, 3762, 0), OreType.IRON, OreType.COAL, OreType.MITHRIL, OreType.ADAMANTITE);
    // QUARRY(new RSTile(3171, 2912, 0)),
    // DWARVEN_MINE(new RSTile()),
    // MINING_GUILD(new RSTile()),
    // TZHARR(new RSTile()),
    // HEROS_GUILD(new RSTile()),

    private final RSTile area;
    private OreType[] supportedOre;

    Location(RSTile area, OreType... supportedOre) {
        this.area = area;
        this.supportedOre = supportedOre;
    }

    public OreType[] getOreType() {
        return supportedOre;
    }

    public RSTile getArea() {
        return area;
    }

}

