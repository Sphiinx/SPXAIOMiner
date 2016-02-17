package scripts.SPXAIOMiner.paint;


import org.tribot.api.Timing;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;
import scripts.SPXAIOMiner.API.Game.Projection.Projection07;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

import java.awt.*;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Global {

    public Variables variables;

    public Global(Variables variables) {
        this.variables = variables;
    }

    public void drawRadius(Graphics g) {
        if (variables.drawRadius && variables.radiusMine) {
            if (variables.area != null) {
                RSArea radiusArea = new RSArea(Player.getPosition(), variables.radius);
                Projection07.drawArea(radiusArea, g);
                Projection07.drawMinimapArea(radiusArea, g);
            }
        }
    }

    public void drawObjects(Graphics g) {
        if (variables.drawObjects) {
            Projection07.drawObject(variables.oreToDraw, g);
            Projection07.drawMinimapObject(variables.oreToDraw, g);
        }
    }

    public void drawTiles(Graphics g) {
        if (variables.drawTiles) {
            RSTile orePos = variables.oreToDraw[0].getPosition();
            Projection07.drawTile(orePos, g);
            Projection07.drawMinimapTile(orePos, g);
        }
    }

    public void drawCloseButton(Graphics g) {
        g.setColor(Constants.BLUE_COLOR);
        g.fillRect(Constants.CLOSE_PAINT.x, Constants.CLOSE_PAINT.y, Constants.CLOSE_PAINT.width, Constants.CLOSE_PAINT.height);
        g.setColor(Constants.TEXT_COLOR);
        g.setFont(Constants.LARGE_FONT);
        g.drawString("X", Constants.CLOSE_PAINT.x + 5, Constants.CLOSE_PAINT.y + 16);
    }

    public void generalInfo(Graphics g) {
        variables.timeRan = System.currentTimeMillis() - Constants.START_TIME;

        g.drawImage(Constants.PAINT, 0, 266, null);
        g.setColor(Constants.BLANK_COLOR);
        g.fillRect(Constants.CLOSE_PAINT.x, Constants.CLOSE_PAINT.y, Constants.CLOSE_PAINT.width, Constants.CLOSE_PAINT.height);
        g.setColor(Constants.TEXT_COLOR);
        g.setFont(Constants.LARGE_FONT);
        g.drawString("[SPX] AIO Miner", 75, 404);
        g.setFont(Constants.SMALL_FONT);
        g.drawString("" + Timing.msToString(variables.timeRan), 85, 354);
        g.drawString("" + variables.status, 85, 452);
        g.drawString("v" + variables.version, 245, 460);
    }

}

