package scripts.SPXAIOMiner.data.enums;

/**
 * Created by Sphiinx on 1/15/2016.
 */
public enum OreType {

    // RUNEESSENCE(),
    CLAY(6705, 434),
    COPPER(4645, 436),
    TIN(53, 438),
    // LIMESTONE(),
    IRON(2576, 440),
    SILVER(7366, 442),
    COAL(7580, 453),
    // PUREESSENCE(),
    // SANDSTONE(),
    // GEM(),
    GOLD(8885, 444),
    // GEMROCKS(),
    // GRANITE(),
    MITHRIL(-22239, 447),
    ADAMANTITE(21662, 449),
    RUNITE(-31437, 451);

    private int color;
    private int itemID;

    OreType(int color, int itemID) {
        this.color = color;
        this.itemID = itemID;
    }

    public int getColor() {
        return color;
    }

    public int getItemID() {
        return itemID;
    }

}

