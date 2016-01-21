package scripts.SPXAIOMiner;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.*;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.MousePainting;
import org.tribot.script.interfaces.MouseSplinePainting;
import org.tribot.script.interfaces.Painting;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;
import scripts.SPXAIOMiner.gui.GUI;
import scripts.SPXAIOMiner.nodes.DepositItems;
import scripts.SPXAIOMiner.nodes.Mine.*;
import scripts.SPXAIOMiner.nodes.WalkToQuarry;
import scripts.SPXAIOMiner.nodes.WorldHop;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sphiinx on 12/21/2015.
 */
@ScriptManifest(authors = "Sphiinx", category = "Mining", name = "[SPX] AIO Miner", version = 0.1)
public class Main extends Script implements Painting {

    private Variables variables = new Variables();
    private ArrayList<Node> nodes = new ArrayList<>();
    public GUI gui = new GUI(variables);

    @Override
    public void run() {
        initializeGui();
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

                if (variables.drawObjects) {
                    if (variables.targetOre.isOnScreen()) {
                        g.setColor(Constants.RED_COLOR);
                        for (Polygon p : variables.targetOre.getModel().getTriangles()) {
                            g.drawPolygon(p);
                        }
                    }
                }

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
            }
        }
    }

}

