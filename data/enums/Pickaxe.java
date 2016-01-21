package scripts.SPXAIOMiner.data.enums;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public enum Pickaxe {

    BRONZE(1, 1, 1265),
    IRON(1, 1, 1267),
    STEEL(5, 6, 1269),
    BLACK(10, 11, 12297),
    MITHRIL(20, 21, 1273),
    ADAMANT(30, 31, 1271),
    RUNE(40, 41, 1275),
    DRAGON(60, 61, 15259);

    private int attackLevel;
    private int miningLevel;
    private int pickaxeID;

    Pickaxe(int attackLevel, int miningLevel, int itemID) {
        this.attackLevel = attackLevel;
        this.miningLevel = miningLevel;
        this.pickaxeID = itemID;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public int getPickaxeID() {
        return pickaxeID;
    }


}

