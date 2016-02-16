package scripts.SPXAIOMiner.API;

import org.tribot.api.General;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Printing {

    /**
     * Prints the specified text via the Client Debug with the header "Debug: ".
     *
     * @param text The text that is being printed.
     */
    public static void dev(Object text) {
        General.println("Debug: " + text);
    }

    /**
     * Prints the specified text via the Client Debug with the header "WARNING: "
     * <p>
     * @param text The text that is being printed.
     */
    public static void warn(Object text) {
        General.println("WARNING: " + text);
    }

    /**
     * Prints the specified text via the Client Debug with the header "ERROR: ".
     * <p>
     * @param text The text that is being printed.
     */
    public static void err(Object text) {
        General.println("ERROR: " + text);
    }

    /**
     * Prints the specified text via the Client Debug with the header "Status: ".
     * <p>
     * @param text The text that is being printed.
     */
    public static void status(Object text) {
        General.println("Status: " + text);
    }

    /**
     * Prints the specified text via the Bot Debug.
     * <p>
     * @param text The text that is being printed.
     */
    public static void bot(String text) {
        General.println(text);
    }

}

