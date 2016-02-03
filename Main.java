package scripts.SPXAIOMiner;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.MousePainting;
import org.tribot.script.interfaces.MouseSplinePainting;
import org.tribot.script.interfaces.Painting;
import org.tribot.util.Util;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.API.Game.Projection.Projection07;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

import scripts.SPXAIOMiner.gui.GUI;
import scripts.SPXAIOMiner.nodes.DepositItems;
import scripts.SPXAIOMiner.nodes.Mine.*;
import scripts.SPXAIOMiner.nodes.WalkToQuarry;
import scripts.SPXAIOMiner.nodes.WorldHop;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sphiinx on 12/21/2015.
 */
@ScriptManifest(authors = "Sphiinx", category = "Mining", name = "[SPX] AIO Miner", version = 0.1)
public class Main extends Script implements Painting, MouseSplinePainting, MousePainting {

    private Variables variables = new Variables();
    private ArrayList<Node> nodes = new ArrayList<>();
    public GUI gui = new GUI(variables);

    @Override
    public void run() {
        variables.path = new File(Util.getWorkingDirectory().getAbsolutePath(), "[SPX]AIOMiner_" + General.getTRiBotUsername() + "_settings" + ".ini");
        initializeGui();
        General.println(variables.area);
        addCollection();
        variables.version = getClass().getAnnotation(ScriptManifest.class).version();
        loop(100, 150);
    }

    private void loop(int min, int max) {
        while (!variables.stopScript) {
            for (final Node node : nodes) {
                if (node.validate()) {
                    variables.status = node.toString();
                    node.execute();
                    General.sleep(min, max);
                }
            }
        }
    }

    private void addCollection() {
        if (variables.worldHop) {
            Collections.addAll(nodes, new WorldHop(variables));
        }
        if (variables.dropGems) {
            Collections.addAll(nodes, new DropUnwanted(variables));
        }
        if (variables.upgradePickaxe) {

        }
        switch (variables.mode) {
            case BANKING:
                Collections.addAll(nodes, new DepositItems(variables));
                break;
            case POWERMINE:
                Collections.addAll(nodes, new Powermine(variables));
                break;
            case M1D1:
                Collections.addAll(nodes, new M1D1(variables));
                break;
            case MOUSEKEYS:
                Collections.addAll(nodes, new MouseKeys(variables));
                break;
        }
        Collections.addAll(nodes, new WalkToQuarry(variables), new MineOre(variables));
    }

    public void initializeGui() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(50);
                    variables.status = "Initializing...";
                    gui.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        do
            sleep(10);
        while (!variables.guiComplete);
    }

    private void getStartLevels() {
    }

    private void getStartExp() {
    }

    public void onPaint(Graphics g1) {
        if (!variables.disablePaint) {
            Graphics2D g = (Graphics2D) g1;
            g.setRenderingHints(Constants.ANTIALIASING);
            if (Login.getLoginState() == Login.STATE.INGAME) {

                long timeRan = System.currentTimeMillis() - Constants.START_TIME;

                g.setColor(Constants.BLACK_COLOR);
                g.fillRoundRect(11, 220, 200, 110, 8, 8); // Paint background
                g.setColor(Constants.RED_COLOR);
                g.drawRoundRect(9, 218, 202, 112, 8, 8); // Red outline
                g.fillRoundRect(13, 223, 194, 22, 8, 8); // Title background
                g.setFont(Constants.TITLE_FONT);
                g.setColor(Color.WHITE);
                g.drawString("[SPX] AIO Miner", 18, 239);
                g.setFont(Constants.TEXT_FONT);
                g.drawString("Runtime: " + Timing.msToString(timeRan), 14, 260);
                g.drawString("Levels Gained: ", 14, 276);
                g.drawString("Gained Exp: ", 14, 293);
                g.drawString("Status: " + variables.status, 14, 310);
                g.drawString("v" + variables.version, 185, 326);

                if (variables.radiusMine && variables.area != null) {
                    RSArea radiusArea = new RSArea(new RSTile[]{
                            new RSTile(variables.area.getX() - variables.radius, variables.area.getY() + variables.radius, variables.area.getPlane()),
                            new RSTile(variables.area.getX() + variables.radius, variables.area.getY() + variables.radius, variables.area.getPlane()),
                            new RSTile(variables.area.getX() + variables.radius, variables.area.getY() - variables.radius, variables.area.getPlane()),
                            new RSTile(variables.area.getX() - variables.radius, variables.area.getY() - variables.radius, variables.area.getPlane()),
                    });
                    Projection07.drawArea(radiusArea, g);
                    Projection07.drawMinimapArea(radiusArea, g);
                }

            }
        }
    }

    @Override
    public void paintMouse(Graphics graphics, Point point, Point point1) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(Mouse.getPos().x - 13, Mouse.getPos().y - 13, 27, 27); // Square rectangle Stroke
        graphics.drawRect(Mouse.getPos().x, Mouse.getPos().y - 512, 1, 500); // Top y axis Line Stroke
        graphics.drawRect(Mouse.getPos().x, Mouse.getPos().y + 13, 1, 500); // Bottom y axis Line Stroke
        graphics.drawRect(Mouse.getPos().x + 13, Mouse.getPos().y, 800, 1); // Right x axis line Stroke
        graphics.drawRect(Mouse.getPos().x - 812, Mouse.getPos().y, 800, 1); // left x axis line Stroke
        graphics.fillOval(Mouse.getPos().x - 3, Mouse.getPos().y - 3, 7, 7); // Center dot stroke
        graphics.setColor(Constants.RED_COLOR);
        graphics.drawRect(Mouse.getPos().x - 12, Mouse.getPos().y - 12, 25, 25); // Square rectangle
        graphics.drawRect(Mouse.getPos().x, Mouse.getPos().y - 512, 0, 500); // Top y axis Line
        graphics.drawRect(Mouse.getPos().x, Mouse.getPos().y + 13, 0, 500); // Bottom y axis Line
        graphics.drawRect(Mouse.getPos().x + 13, Mouse.getPos().y, 800, 0); // Right x axis line
        graphics.drawRect(Mouse.getPos().x - 812, Mouse.getPos().y, 800, 0); // left x axis line
        graphics.fillOval(Mouse.getPos().x - 2, Mouse.getPos().y - 2, 5, 5); // Center dot
    }

    @Override
    public void paintMouseSpline(Graphics graphics, ArrayList<Point> arrayList) {
    }

}

