package scripts.SPXAIOMiner.data.enums;

/**
 * Created by Sphiinx on 1/15/2016.
 */
public enum OreType {

    CLAY(6705, 434),
    COPPER(4645, 436),
    TIN(53, 438),
    IRON(2576, 440),
    SILVER(74, 442),
    COAL(10508, 453),
    GOLD(8885, 444),
    MITHRIL(-22239, 447),
    ADAMANTITE(21662, 449),
    RUNITE(-31437, 451),
    LIMESTONE(10295, 3211),
    GEMS(-10335, 1625, 1627, 1629);
    //**TBA** GRANITE(),
    //**TBA** ESSENCE(),
    //**TBA** SANDSTONE(),

    private int color;
    private int[] itemIDs;

    OreType(int color, int... itemID) {
        this.color = color;
        this.itemIDs = itemID;
    }

    public int getColor() {
        return color;
    }

    public int[] getItemIDs() {
        return itemIDs;
    }

    public int[] getNotedItemIDs() {
        int[] notedIDs = new int[itemIDs.length];
        for (int i = 0; i < itemIDs.length; i++) {
            notedIDs[i] = itemIDs[i] + 1;
        }
        return notedIDs;
    }

}

