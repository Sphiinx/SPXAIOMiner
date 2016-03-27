package scripts.SPXAIOMiner.data.enums;

import org.tribot.api2007.Skills;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public enum Pickaxe {

    BRONZE(1, 1, 1265, null),
    IRON(1, 1, 1267, BRONZE),
    STEEL(5, 6, 1269, IRON),
    BLACK(10, 11, 12297, STEEL),
    MITHRIL(20, 21, 1273, BLACK),
    ADAMANT(30, 31, 1271, MITHRIL),
    RUNE(40, 41, 1275, ADAMANT),
    DRAGON(60, 61, 15259, RUNE);

    private int attackLevel;
    private int miningLevel;
    private int pickaxeID;
    private Pickaxe previousPickaxe;

    Pickaxe(int attackLevel, int miningLevel, int itemID, Pickaxe previousPickaxe) {
        this.attackLevel = attackLevel;
        this.miningLevel = miningLevel;
        this.pickaxeID = itemID;
        this.previousPickaxe = previousPickaxe;
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

    public Pickaxe getPreviousAxe() {
        return previousPickaxe;
    }

    public Pickaxe getBestPickaxe(boolean pickaxeInInventory) {
        int attack = Skills.getCurrentLevel(Skills.SKILLS.ATTACK);
        int mining = Skills.getCurrentLevel(Skills.SKILLS.MINING);

        if (pickaxeInInventory) {
            if (mining >= DRAGON.getMiningLevel()) {
                return DRAGON;
            } else if (mining >= RUNE.getMiningLevel()) {
                return RUNE;
            } else if (mining >= ADAMANT.getMiningLevel()) {
                return ADAMANT;
            } else if (mining >= MITHRIL.getMiningLevel()) {
                return MITHRIL;
            } else if (mining >= BLACK.getMiningLevel()) {
                return BLACK;
            } else if (mining >= STEEL.getMiningLevel()) {
                return STEEL;
            } else if (mining >= IRON.getMiningLevel()) {
                return IRON;
            } else {
                return BRONZE;
            }
        } else {
            if (attack >= DRAGON.getAttackLevel() && mining >= DRAGON.getMiningLevel()) {
                return DRAGON;
            } else if (attack >= RUNE.getAttackLevel() && mining >= RUNE.getMiningLevel()) {
                return RUNE;
            } else if (attack >= ADAMANT.getAttackLevel() && mining >= ADAMANT.getMiningLevel()) {
                return ADAMANT;
            } else if (attack >= MITHRIL.getAttackLevel() && mining >= MITHRIL.getMiningLevel()) {
                return MITHRIL;
            } else if (attack >= BLACK.getAttackLevel() && mining >= BLACK.getMiningLevel()) {
                return BLACK;
            } else if (attack >= STEEL.getAttackLevel() && mining >= STEEL.getMiningLevel()) {
                return STEEL;
            } else if (attack >= IRON.getAttackLevel() && mining >= IRON.getMiningLevel()) {
                return IRON;
            } else {
                return BRONZE;
            }
        }
    }

}