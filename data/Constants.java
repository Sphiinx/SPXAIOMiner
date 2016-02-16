package scripts.SPXAIOMiner.data;

import org.tribot.api2007.types.RSTile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Sphiinx on 1/15/2016.
 */
public class Constants {

    public static final long START_TIME = System.currentTimeMillis();
    public static Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch (IOException e) {
            return null;
        }
    }
    public static final String[] GEMS = new String[] {
            "Uncut sapphire",
            "Uncut emerald",
            "Uncut ruby",
            "Uncut diamond"
    };
    public static final RSTile[] SHILO_VILLAGE_PATH = new RSTile[] {
            new RSTile(2824, 2999, 0), new RSTile(2829, 2989, 0),
            new RSTile(2828, 2980, 0), new RSTile(2831, 2976, 0),
            new RSTile(2831, 2966, 0), new RSTile(2846, 2960, 0),
            new RSTile(2853, 2955, 0)
    };
    public static final RSTile SAFE_ZONE = new RSTile(3222, 3217, 0);

    //<editor-fold defaultstate="collapsed" desc="Paint Info">
    public static final Image PAINT = getImage("http://i.imgur.com/qNbS3Yp.png");
    public static final Color BLUE_COLOR = new Color(4, 49, 73, 240);
    public static final Color TEXT_COLOR = new Color(249, 196, 70, 250);
    public static final Color BLANK_COLOR = new Color(249, 196, 70, 0);
    public static final Font LARGE_FONT = new Font("Arial Bold", 0, 16);
    public static final Font SMALL_FONT = new Font("Arial Bold", 0, 12);
    public static final RenderingHints ANTIALIASING = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    public static final Rectangle CLOSE_PAINT = new Rectangle(494, 312, 21, 21);
    public static final Rectangle START_SLAVESYSTEM = new Rectangle(560, 205, 165, 20);
    //</editor-fold>

}

