package scripts.SPXAIOMiner.data.enums;


/**
 * Created by Sphiinx on 1/15/2016.
 */
public enum OreType {

    CLAY(6705, 434, Location.VARROCK_WEST, Location.RIMMINGTON, Location.CRAFTING_GUILD, Location.YANILLE),
    COPPER(4645, 436, Location.VARROCK_EAST, Location.LUMBRIDGE_EAST, Location.AL_KHARID, Location.WEST_FALADOR, Location.DWARVEN_MINE, Location.RIMMINGTON, Location.YANILLE, Location.PORT_KHAZARD),
    TIN(53, 438, Location.VARROCK_WEST, Location.VARROCK_EAST, Location.LUMBRIDGE_EAST, Location.BARBARIAN_VILLAGE, Location.WEST_FALADOR, Location.DWARVEN_MINE, Location.RIMMINGTON, Location.YANILLE, Location.PORT_KHAZARD),
    IRON(2576, 440, Location.VARROCK_WEST, Location.VARROCK_EAST, Location.AL_KHARID, Location.WEST_FALADOR, Location.DWARVEN_MINE, Location.RIMMINGTON, Location.EAST_ARDOUGNE, Location.SOUTH_ARDOUGNE, Location.YANILLE, Location.WILDERNESS_SOUTH, Location.WILDERNESS_NORTH),
    SILVER(74, 442, Location.VARROCK_WEST, Location.AL_KHARID, Location.CRAFTING_GUILD),
    COAL(10508, 453, Location.LUMBRIDGE_WEST, Location.AL_KHARID, Location.BARBARIAN_VILLAGE, Location.WEST_FALADOR, Location.DWARVEN_MINE, Location.MINING_GUILD, Location.EAST_ARDOUGNE, Location.SOUTH_ARDOUGNE, Location.COAL_TRUCKS, Location.WILDERNESS_SOUTHW, Location.WILDERNESS_SOUTH, Location.WILDERNESS_NORTH),
    GOLD(8885, 444, Location.AL_KHARID, Location.DWARVEN_MINE, Location.RIMMINGTON, Location.CRAFTING_GUILD),
    MITHRIL(-22239, 447, Location.LUMBRIDGE_WEST, Location.AL_KHARID, Location.MINING_GUILD, Location.YANILLE, Location.PORT_KHAZARD, Location.WILDERNESS_SOUTH),
    ADAMANTITE(21662, 449, Location.LUMBRIDGE_WEST, Location.AL_KHARID, Location.DWARVEN_MINE, Location.WILDERNESS_SOUTH),
    LIMESTONE(10295, 3211, Location.SILVAREA);
    //**TBA** RUNITE(-31437, 451),
    //**TBA** GEMS(-10335, 1625, 1627, 1629);
    //**TBA** GRANITE(),
    //**TBA** ESSENCE(),
    //**TBA** SANDSTONE(),

    private int color;
    private int itemID;
    private Location[] supportedLocations;

    public static OreType[] ore1 = new OreType[]{
            OreType.CLAY,
            OreType.COPPER,
            OreType.TIN
    };
    public static OreType[] ore2 = new OreType[]{
            OreType.CLAY,
            OreType.COPPER,
            OreType.TIN,
            OreType.IRON,
            OreType.LIMESTONE
    };
    public static OreType[] ore3 = new OreType[]{
            OreType.CLAY,
            OreType.COPPER,
            OreType.TIN,
            OreType.IRON,
            OreType.LIMESTONE,
            OreType.SILVER,
            OreType.COAL,
    };

    OreType(int color, int itemID, Location... supportedLocations) {
        this.color = color;
        this.itemID = itemID;
        this.supportedLocations = supportedLocations;
    }

    public int getColor() {
        return color;
    }

    public int getItemID() {
        return itemID;
    }

    public Location[] getLocations() {
        return supportedLocations;
    }

    public int getNotedItemID() {
        return itemID + 1;
    }

}