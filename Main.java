package scripts.SPXAIOMiner;

import scripts.TribotAPI.color.Colors;
import scripts.TribotAPI.painting.mouse.SPXMouse07;
import scripts.TribotAPI.util.Logging;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.*;
import org.tribot.api2007.util.ThreadSettings;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.*;
import org.tribot.util.Util;

import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Vars;

import scripts.SPXAIOMiner.framework.Task;
import scripts.SPXAIOMiner.framework.TaskManager;
import scripts.SPXAIOMiner.gui.GUI;
import scripts.SPXAIOMiner.messagerecieved.Server;
import scripts.SPXAIOMiner.messagerecieved.Trade;
import scripts.SPXAIOMiner.paint.PaintManager;
import scripts.SPXAIOMiner.tasks.*;
import scripts.SPXAIOMiner.tasks.Mine.*;
import scripts.SPXAIOMiner.tasks.MuleSystem.MasterSystem;
import scripts.SPXAIOMiner.tasks.MuleSystem.TradeMaster;
import scripts.SPXAIOMiner.tasks.MuleSystem.WalkToMaster;
import scripts.SPXAIOMiner.tasks.MuleSystem.WithdrawItems;
import scripts.SPXAIOMiner.tasks.PickaxeUpgrading.EquipPickaxe;
import scripts.SPXAIOMiner.tasks.PickaxeUpgrading.GetPickaxe;
import scripts.SPXAIOMiner.tasks.PickaxeUpgrading.UpgradePickaxe;
import scripts.TribotAPI.game.pricechecking.PriceChecking07;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Sphiinx on 12/21/2015.
 */
@ScriptManifest(authors = "Sphiinx", category = "Mining", name = "[SPX] AIO Miner", version = 0.1)
public class Main extends Script implements MessageListening07, Painting, MouseSplinePainting, MousePainting, MouseActions, Ending {

    private GUI gui = new GUI();
    private PaintManager paintManager = new PaintManager();
    private Trade trade = new Trade();
    private Server server = new Server();
    private TaskManager taskManager = new TaskManager();
    private SPXMouse07 spxMouse07 = new SPXMouse07(Colors.RED_COLOR.getCOLOR(), Colors.GRAY_COLOR.getCOLOR());

    @Override
    public void run() {
        Vars.reset();
        General.useAntiBanCompliance(true);
        ThreadSettings.get().setClickingAPIUseDynamic(true);
        Logging.status("Thank you for using SPX Scripts " + General.getTRiBotUsername() + "!");
        Vars.get().path = new File(Util.getWorkingDirectory().getAbsolutePath(), "[SPX]AIOMiner_settings.ini");
        Vars.get().version = getClass().getAnnotation(ScriptManifest.class).version();
        getStartInformation();
        initializeGUI();
        getItemPrice();
        addCollection();
        loop(100, 150);
    }

    //<editor-fold defaultstate="collapsed" desc="Collection">
    private void addCollection() {
        if (Vars.get().progressiveMode) {
            taskManager.addTask(new Progressive());
        }
        if (Vars.get().worldHop) {
            taskManager.addTask(new WorldHop());
        }
        if (Vars.get().dropGems) {
            taskManager.addTask(new DropUnwanted());
        }
        if (Vars.get().slaveSystem) {
            taskManager.addTask(new TradeMaster(), new WalkToMaster(), new WithdrawItems());
        }
        if (Vars.get().upgradePickaxe) {
            taskManager.addTask(new UpgradePickaxe());
        }
        if (Vars.get().levelToStop > 0) {
            taskManager.addTask(new StopSettings());
        }
        if (Vars.get().masterSystem) {
            taskManager.addTask(new MasterSystem());
        } else {
            taskManager.addTask(new GetPickaxe(), new EquipPickaxe(), new WalkToQuarry(), new MineOre());
        }
        taskManager.addTask(new TimedActions());
        switch (Vars.get().mode) {
            case BANKING:
                taskManager.addTask(new DepositItems());
                break;
            case POWERMINE:
                taskManager.addTask(new Powermine());
                break;
            case M1D1:
                taskManager.addTask(new M1D1());
                break;
            case MOUSEKEYS:
                taskManager.addTask(new MouseKeys());
                break;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Loop">
    private void loop(int min, int max) {
        while (!Vars.get().stopScript) {
            Task task = taskManager.getValidTask();
            if (task != null) {
                task.execute();
                Vars.get().status = task.toString();
                General.sleep(min, max);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="InitializeGUI">
    private void initializeGUI() {
        EventQueue.invokeLater(() -> {
            try {
                sleep(50);
                Vars.get().status = "Initializing...";
                gui.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        do
            sleep(10);
        while (!Vars.get().guiComplete);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="StartInformation">
    private void getStartInformation() {
        Vars.get().startLevel = Skills.getActualLevel(Skills.SKILLS.MINING);
        Vars.get().startXP = Skills.getXP(Skills.SKILLS.MINING);
        Vars.get().resetTimeRan = Timing.currentTimeMillis();
    }

    private void getItemPrice() {
        if (Vars.get().oreType != null) {
            Vars.get().orePrice = PriceChecking07.getOSBuddyPrice(Vars.get().oreType.getItemID());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Painting">
    public void onPaint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setRenderingHints(Constants.ANTIALIASING);
        if (Login.getLoginState() == Login.STATE.INGAME) {
            if (!Vars.get().disablePaint) {
                paintManager.drawRadius(g);
                paintManager.drawObjects(g);
                paintManager.drawTiles(g);
                paintManager.drawGeneralInfo(g);
                if (Vars.get().masterSystem) {
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

    //<editor-fold defaultstate="collapsed" desc="Mouse">
    @Override
    public void paintMouse(Graphics graphics, Point point, Point point1) {
        spxMouse07.drawMouse(graphics);
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
            if (Vars.get().slaveSystem) {
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
            if (Vars.get().resetOresMined > 0) {
                Logging.status("Enabling slave system...");
                Vars.get().isSlaveSystemIsRunning = true;
            } else {
                Logging.status("We cannot enable the slave system unless we've mined more ore!");
            }
        }
        if (Constants.CLOSE_PAINT.contains(point) && i == 1 && !b) {
            Vars.get().disablePaint = !Vars.get().disablePaint;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Ending">
    @Override
    public void onEnd() {
        Logging.status("Thank you for using SPX Scripts " + General.getTRiBotUsername() + "!");
        DynamicSignature.sendSignatureData(Vars.get().timeRanMinutes, Vars.get().oresMined, Vars.get().profit, Vars.get().gainedXP, Vars.get().gainedLevels, Vars.get().muleTrades, Vars.get().muleTrades);
    }
    //</editor-fold>

}