package scripts.spxaiominer.data.enums;

/**
 * Created by Sphiinx on 8/5/2016.
 */
public enum OreType {

    CLAY(6705, 434, MiningLocation.VARROCK_WEST, MiningLocation.RIMMINGTON, MiningLocation.CRAFTING_GUILD, MiningLocation.YANILLE),
    COPPER(4645, 436, MiningLocation.VARROCK_EAST, MiningLocation.LUMBRIDGE_EAST, MiningLocation.AL_KHARID, MiningLocation.WEST_FALADOR, MiningLocation.DWARVEN_MINE, MiningLocation.RIMMINGTON, MiningLocation.YANILLE, MiningLocation.PORT_KHAZARD),
    TIN(53, 438, MiningLocation.VARROCK_WEST, MiningLocation.VARROCK_EAST, MiningLocation.LUMBRIDGE_EAST, MiningLocation.BARBARIAN_VILLAGE, MiningLocation.WEST_FALADOR, MiningLocation.DWARVEN_MINE, MiningLocation.RIMMINGTON, MiningLocation.YANILLE, MiningLocation.PORT_KHAZARD),
    IRON(2576, 440, MiningLocation.VARROCK_WEST, MiningLocation.VARROCK_EAST, MiningLocation.AL_KHARID, MiningLocation.WEST_FALADOR, MiningLocation.DWARVEN_MINE, MiningLocation.RIMMINGTON, MiningLocation.EAST_ARDOUGNE, MiningLocation.SOUTH_ARDOUGNE, MiningLocation.YANILLE, MiningLocation.WILDERNESS_SOUTH, MiningLocation.WILDERNESS_NORTH),
    SILVER(74, 442, MiningLocation.VARROCK_WEST, MiningLocation.AL_KHARID, MiningLocation.CRAFTING_GUILD),
    COAL(10508, 453, MiningLocation.LUMBRIDGE_WEST, MiningLocation.AL_KHARID, MiningLocation.BARBARIAN_VILLAGE, MiningLocation.WEST_FALADOR, MiningLocation.DWARVEN_MINE, MiningLocation.MINING_GUILD, MiningLocation.EAST_ARDOUGNE, MiningLocation.SOUTH_ARDOUGNE, MiningLocation.COAL_TRUCKS, MiningLocation.WILDERNESS_SOUTHW, MiningLocation.WILDERNESS_SOUTH, MiningLocation.WILDERNESS_NORTH),
    GOLD(8885, 444, MiningLocation.AL_KHARID, MiningLocation.DWARVEN_MINE, MiningLocation.RIMMINGTON, MiningLocation.CRAFTING_GUILD),
    MITHRIL(-22239, 447, MiningLocation.LUMBRIDGE_WEST, MiningLocation.AL_KHARID, MiningLocation.MINING_GUILD, MiningLocation.YANILLE, MiningLocation.PORT_KHAZARD, MiningLocation.WILDERNESS_SOUTH),
    ADAMANTITE(21662, 449, MiningLocation.LUMBRIDGE_WEST, MiningLocation.AL_KHARID, MiningLocation.DWARVEN_MINE, MiningLocation.WILDERNESS_SOUTH),
    LIMESTONE(10295, 3211, MiningLocation.SILVAREA);

    public final int COLOR;
    public final int ITEM_ID;
    public final MiningLocation[] SUPPORTED_LOCATIONS;

    OreType(int color, int item_id, MiningLocation... supported_locations) {
        this.COLOR = color;
        this.ITEM_ID = item_id;
        this.SUPPORTED_LOCATIONS = supported_locations;
    }

    public int getColor() {
        return COLOR;
    }

    public int getItemID() {
        return ITEM_ID;
    }

    public MiningLocation[] getSupportedLocations() {
        return SUPPORTED_LOCATIONS;
    }

}

