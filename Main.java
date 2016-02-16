package scripts.SPXAIOMiner;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.*;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.*;
import org.tribot.script.interfaces.Painting;
import org.tribot.util.Util;
import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.API.Game.PriceChecking.PriceChecking07;
import scripts.SPXAIOMiner.API.Paint;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

import scripts.SPXAIOMiner.gui.GUI;
import scripts.SPXAIOMiner.paint.Global;
import scripts.SPXAIOMiner.paint.Master;
import scripts.SPXAIOMiner.paint.Normal;
import scripts.SPXAIOMiner.paint.Slave;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Sphiinx on 12/21/2015.
 */
@ScriptManifest(authors = "Sphiinx", category = "Mining", name = "[SPX] AIO Miner", version = 0.2)
public class Main extends Script implements MessageListening07, Painting, MouseSplinePainting, MousePainting, MouseActions, Ending {

    private Variables variables = new Variables();
    private GUI gui = new GUI(variables);
    private Global global = new Global(variables);
    private Master master = new Master(variables);
    private Normal normal = new Normal(variables);
    private Slave slave = new Slave(variables);
    private Collection collection = new Collection(variables);

    @Override
    public void run() {
        General.useAntiBanCompliance(true);
        tribotUserCheck();
        General.println("Thank you for using SPX Scripts " + General.getTRiBotUsername() + "!");
        variables.path = new File(Util.getWorkingDirectory().getAbsolutePath(), "[SPX]AIOMiner_" + General.getTRiBotUsername() + "_settings" + ".ini");
        variables.version = getClass().getAnnotation(ScriptManifest.class).version();
        getStartInformation();
        initializeGui();
        getItemPrice();
        collection.addCollection();
        loop(100, 150);
    }

    private void loop(int min, int max) {
        while (!variables.stopScript) {
            collection.tasks.stream().filter(Task::validate).forEach(task -> {
                variables.status = task.toString();
                task.execute();
                General.sleep(min, max);
            });
        }
    }

    private void tribotUserCheck() {
        if (General.getTRiBotUsername().equals("Sphiinx") ||
                General.getTRiBotUsername().equals("xSlapppz") ||
                General.getTRiBotUsername().equals("silver8787") ||
                General.getTRiBotUsername().equals("sibbernski") ||
                General.getTRiBotUsername().equals("Netami") ||
                General.getTRiBotUsername().equals("Duvy") ||
                General.getTRiBotUsername().equals("plasmaftw") ||
                General.getTRiBotUsername().equals("ohParadox") ||
                General.getTRiBotUsername().equals("jakerules13") ||
                General.getTRiBotUsername().equals("kokon") ||
                General.getTRiBotUsername().equals("jake miler") ||
                General.getTRiBotUsername().equals("YoHoJo") ||
                General.getTRiBotUsername().equals("jack351") ||
                General.getTRiBotUsername().equals("Doomed")) {
            General.println("Your Tribot profile has been accepted.");
            General.println("Username: " + General.getTRiBotUsername());

        } else {
            General.println("You're not currently one of the beta testers!");
            General.println("Username: " + General.getTRiBotUsername());
            General.println("Stopping Script...");
            stopScript();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="InitializeGUI">
    public void initializeGui() {
        EventQueue.invokeLater(() -> {
            try {
                sleep(50);
                variables.status = "Initializing...";
                gui.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        do
            sleep(10);
        while (!variables.guiComplete);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="StartInformation">
    private void getStartInformation() {
        variables.resetTimeRan = System.currentTimeMillis();
        variables.startLevel = Skills.getActualLevel(Skills.SKILLS.MINING);
        variables.startXP = Skills.getXP(Skills.SKILLS.MINING);
        variables.resetTimeRan = Timing.currentTimeMillis();
    }

    private void getItemPrice() {
        variables.orePrice = PriceChecking07.getGEPrice(variables.oreType.getItemIDs()[0]);
        if (variables.orePrice == 0) {
            General.println("We were unable to get the current prices for the Ore...");
            General.println("Runescapes website may be having issues...");
            General.println("Stopping script...");
            AntiBan.destroy();
            variables.stopScript = true;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Painting">
    public void onPaint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setRenderingHints(Constants.ANTIALIASING);
        if (Login.getLoginState() == Login.STATE.INGAME) {
            if (!variables.disablePaint) {
                global.drawRadius(g);
                global.drawObjects(g);
                global.drawTiles(g);
                global.generalInfo(g);
                if (variables.masterSystem) {
                    master.systemInfo(g);
                } else {
                    normal.systemInfo(g);
                    slave.systemInfo(g);
                }
            } else {
                global.drawCloseButton(g);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MousePainting">
    @Override
    public void paintMouse(Graphics graphics, Point point, Point point1) {
        Paint.drawMouse(graphics);
    }

    @Override
    public void paintMouseSpline(Graphics graphics, ArrayList<Point> arrayList) {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MessageListening07">
    @Override
    public void tradeRequestReceived(String s) {
        if (variables.masterSystem) {
            variables.playerTrading = s;
        }
    }

    @Override
    public void serverMessageReceived(String s) {
        if (s.contains("Accepted trade.")) {
            variables.masterTrades++;
            if (variables.slaveSystem) {
                variables.resetOresMined = 0;
                variables.resetTimeRan = System.currentTimeMillis();
                variables.isSlaveSystemIsRunning = false;
            }
        }
        if (s.contains("You manage to mine some") || s.contains("You just mined")) {
            AntiBan.sleepReactionTime();
            AntiBan.incrementResourcesWon();
            variables.oresMined++;
            variables.resetOresMined++;
        }
    }

    @Override
    public void playerMessageReceived(String s, String s1) {

    }

    @Override
    public void personalMessageReceived(String s, String s1) {

    }

    @Override
    public void duelRequestReceived(String s, String s1) {

    }

    @Override
    public void clanMessageReceived(String s, String s1) {

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MouseActions">
    @Override
    public void mouseReleased(Point point, int i, boolean b) {

    }

    @Override
    public void mouseMoved(Point point, boolean b) {

    }

    @Override
    public void mouseDragged(Point point, int i, boolean b) {

    }

    @Override
    public void mouseClicked(Point point, int i, boolean b) {
        if (Constants.START_SLAVESYSTEM.contains(point) && i == 1 && !b) {
            if (variables.resetOresMined > 0) {
                variables.isSlaveSystemIsRunning = true;
            } else {
                General.println("We cannot enable the slave system unless we've mined more ore!");
            }

        }
        if (Constants.CLOSE_PAINT.contains(point) && i == 1 && !b) {
            variables.disablePaint = !variables.disablePaint;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Ending">
    @Override
    public void onEnd() {
        DyanmicSignature.sendSignatureData(variables.timeRan / 1000, variables.oresMined, variables.profit, variables.gainedXP, variables.gainedLevels, variables.masterTrades, variables.masterTrades);
    }
    //</editor-fold>

}

