package scripts.SPXAIOMiner.data.enums;

import org.tribot.api.General;

/**
 * Created by Sphiinx on 1/17/2016.
 */
public enum Worlds {

    MEMBERS(new int[] {
            2, 3, 4, 5, 6, 9, 10, 11, 12, 13, 14, 17, 18, 20, 21, 22, 27, 28,
            29, 30, 33, 34, 36, 38, 41, 42, 43, 44, 46, 49, 50, 51, 53, 54,
            58, 59, 61, 62, 65, 66, 67, 68, 69, 70, 73, 75, 76, 77, 78
    }),

    FREE(new int[] {
            1, 8, 16, 26, 35, 81, 82, 83, 84, 85, 93, 94
    }),

    PVP(new int[] {
            25, 37
    }),

    DEADMAN(new int[] {
            19, 45, 52, 57, 60, 74
    });

    private int[] worlds;

    Worlds(int[] worlds) {
        this.worlds = worlds;
    }

    public int[] getWorlds() {
        return worlds;
    }

    public int getRandomWorld() {
        return worlds[General.random(0, worlds.length -1)];
    }

}

