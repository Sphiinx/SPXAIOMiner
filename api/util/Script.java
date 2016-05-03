package scripts.SPXAIOMiner.api.util;

import org.tribot.script.ScriptManifest;

/**
 * Created by Sphiinx on 4/20/2016.
 */
public class Script {

    /**
     * Gets the current script version from the ScriptManifest.
     *
     * @return The script version from the ScriptManifest.
     */
    public static double getVersion(Class main) {
        return main.getClass().getAnnotation(ScriptManifest.class).version();
    }

}

