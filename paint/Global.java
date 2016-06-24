package scripts.SPXAIOMiner.paint;


import scripts.TribotAPI.color.Colors;
import org.tribot.api.Timing;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.data.Constants;
import scripts.TribotAPI.painting.projection.Projection07;

import java.awt.*;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Global {

    public PaintManager paintManager;
    private Projection07 projection07 = new Projection07(Colors.RED_COLOR.getCOLOR(), Colors.GRAY_COLOR.getCOLOR());

    public Global(PaintManager paintManager) {
        this.paintManager = paintManager;
    }

    //<editor-fold defaultstate="collapsed" desc="Draw Radius">
    public void drawRadius(Graphics g) {
        if (paintManager.drawRadius() && paintManager.radiusMine()) {
            if (paintManager.getArea() != null) {
                RSArea radiusArea = new RSArea(Player.getPosition(), paintManager.getRadius());
                projection07.drawArea(radiusArea, g);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Draw Objects">
    public void drawObjects(Graphics g) {
        if (paintManager.drawObjects()) {
            projection07.drawObject(paintManager.getOreToDraw()[0], g);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Draw Tiles">
    public void drawTiles(Graphics g) {
        if (paintManager.drawTiles()) {
            RSTile orePos = paintManager.getOreToDrawTilePosition();
            projection07.drawTile(orePos, g);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Draw Close Button">
    public void drawCloseButton(Graphics g) {
        g.setColor(Constants.BLUE_COLOR);
        g.fillRect(Constants.CLOSE_PAINT.x, Constants.CLOSE_PAINT.y, Constants.CLOSE_PAINT.width, Constants.CLOSE_PAINT.height);
        g.setColor(Constants.TEXT_COLOR);
        g.setFont(Constants.LARGE_FONT);
        g.drawString("X", Constants.CLOSE_PAINT.x + 5, Constants.CLOSE_PAINT.y + 16);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Draw General Info">
    public void drawGlobalInfo(Graphics g) {
        g.drawImage(Constants.PAINT, 0, 266, null);
        g.setColor(Constants.BLANK_COLOR);
        g.fillRect(Constants.CLOSE_PAINT.x, Constants.CLOSE_PAINT.y, Constants.CLOSE_PAINT.width, Constants.CLOSE_PAINT.height);
        g.setColor(Constants.TEXT_COLOR);
        g.setFont(Constants.LARGE_FONT);
        g.drawString("[SPX] AIO Miner", 75, 404);
        g.setFont(Constants.SMALL_FONT);
        g.drawString("" + Timing.msToString(paintManager.getTimeRan()), 85, 354);
        g.drawString("" + paintManager.getStatus(), 85, 452);
        g.drawString("v" + paintManager.getVersion(), 245, 460);
    }
    //</editor-fold>

}