package scripts.SPXAIOMiner.data;

/**
 * Created by Sphiinx on 1/15/2016.
 */
public enum OreType {

    // RUNEESSENCE(),
    CLAY(6705),
    COPPER(4645),
    TIN(53),
    // LIMESTONE(),
    IRON(2576),
    SILVER(7366),
    COAL(7580),
    // PUREESSENCE(),
    // SANDSTONE(),
    GOLD(8885),
    // GEMROCKS(),
    // GRANITE(),
    MITHRIL(-22239),
    ADAMANTITE(21662),
    RUNITE(-31437);

    private int color;

    OreType(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

}

