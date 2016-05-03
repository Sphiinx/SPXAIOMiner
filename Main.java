package scripts.SPXAIOMiner;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.*;
import org.tribot.api2007.util.ThreadSettings;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.*;
import org.tribot.script.interfaces.Painting;
import org.tribot.util.Util;

import scripts.SPXAIOMiner.api.framework.Task;
import scripts.SPXAIOMiner.api.game.pricechecking.PriceChecking07;
import scripts.SPXAIOMiner.api.Paint;
import scripts.SPXAIOMiner.api.Printing;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

import scripts.SPXAIOMiner.gui.GUI;
import scripts.SPXAIOMiner.messagerecieved.Server;
import scripts.SPXAIOMiner.messagerecieved.Trade;
import scripts.SPXAIOMiner.paint.*;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Sphiinx on 12/21/2015.
 */
@ScriptManifest(authors = "Sphiinx", category = "Mining", name = "[SPX] AIO Miner", version = 0.1)
public class Main extends Script implements MessageListening07, Painting, MouseSplinePainting, MousePainting, MouseActions, Ending {

    private Variables variables = new Variables();
    private GUI gui = new GUI(variables);
    private PaintManager paintManager = new PaintManager(variables);
    private Collection collection = new Collection(variables);
    private Trade trade = new Trade(variables);
    private Server server = new Server(variables);

    @Override
    public void run() {
        General.useAntiBanCompliance(true);
        ThreadSettings.get().setClickingAPIUseDynamic(true);
        setDebugging();
        Printing.status("Thank you for using SPX Scripts " + General.getTRiBotUsername() + "!");
        variables.path = new File(Util.getWorkingDirectory().getAbsolutePath(), "[SPX]AIOMiner_" + General.getTRiBotUsername() + "_settings" + ".ini");
        variables.version = getClass().getAnnotation(ScriptManifest.class).version();
        getStartInformation();
        initializeGUI();
        getItemPrice();
        collection.addCollection();
        loop(100, 150);
    }

    //<editor-fold defaultstate="collapsed" desc="Loop">
    private void loop(int min, int max) {
        while (!variables.stopScript) {
            collection.tasks.stream().filter(Task::validate).forEach(task -> {
                variables.status = task.toString();
                task.execute();
                General.sleep(min, max);
            });
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SetDebugging">
    private void setDebugging() {
        Printing.isDebugging = this.getRepoID() == -1;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="InitializeGUI">
    private void initializeGUI() {
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
        variables.startLevel = Skills.getActualLevel(Skills.SKILLS.MINING);
        variables.startXP = Skills.getXP(Skills.SKILLS.MINING);
        variables.resetTimeRan = Timing.currentTimeMillis();
    }

    private void getItemPrice() {
        if (variables.oreType != null) {
            variables.orePrice = PriceChecking07.getOSbuddyPrice(variables.oreType.getItemID());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Painting">
    public void onPaint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setRenderingHints(Constants.ANTIALIASING);
        if (Login.getLoginState() == Login.STATE.INGAME) {
            if (!variables.disablePaint) {
                paintManager.drawRadius(g);
                paintManager.drawObjects(g);
                paintManager.drawTiles(g);
                paintManager.drawGeneralInfo(g);
                if (variables.masterSystem) {
                    paintManager.drawMasterInfo(g);
                } else {
                    paintManager.drawNormalInfo(g);
                }
            } else {
                paintManager.drawCloseButton(g);
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
        trade.getPlayerTrading(s);
    }

    @Override
    public void serverMessageReceived(String s) {
        if (s.contains("You manage to mine some") || s.contains("You just mined")) {
            server.incrementOre();
        }
        if (s.contains("Accepted trade.")) {
            if (variables.slaveSystem) {
                server.incrementTrades();
                server.setSlaveSettings();
                server.switchWorldBack();
            }
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
                Printing.status("Enabling slave system...");
                variables.isSlaveSystemIsRunning = true;
            } else {
                Printing.status("We cannot enable the slave system unless we've mined more ore!");
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
        Printing.status("Thank you for using SPX Scripts " + General.getTRiBotUsername() + "!");
        DynamicSignature.sendSignatureData(variables.timeRanMinutes, variables.oresMined, variables.profit, variables.gainedXP, variables.gainedLevels, variables.muleTrades, variables.muleTrades);
    }
    //</editor-fold>

}