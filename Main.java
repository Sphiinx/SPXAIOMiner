package scripts.spxaiominer;

import com.allatori.annotations.DoNotRename;
import org.tribot.api.Timing;
import org.tribot.api2007.types.RSArea;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.*;
import scripts.spxaiominer.data.Vars;
import scripts.spxaiominer.tasks.*;
import scripts.spxaiominer.tasks.dropping.DropGems;
import scripts.spxaiominer.tasks.dropping.M1D1;
import scripts.spxaiominer.tasks.dropping.MouseKeys;
import scripts.spxaiominer.tasks.dropping.Powermine;
import scripts.spxaiominer.tasks.mule.AcceptSlaveTrade;
import scripts.spxaiominer.tasks.mule.WalkBackToMuleTile;
import scripts.spxaiominer.tasks.pickaxe.GetPickaxe;
import scripts.spxaiominer.tasks.pickaxe.UpgradePickaxe;
import scripts.spxaiominer.tasks.slave.*;
import scripts.spxaiominer.tasks.pickaxe.EquipPickaxe;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.AbstractScript;
import scripts.tribotapi.antiban.AntiBan;
import scripts.tribotapi.game.pricechecking.PriceChecking07;
import scripts.tribotapi.game.utiity.Utility07;
import scripts.tribotapi.gui.GUI;
import scripts.tribotapi.painting.paint.Calculations;
import scripts.tribotapi.painting.paint.SkillData;
import scripts.tribotapi.painting.paint.enums.DataPosition;
import scripts.tribotapi.painting.projection.ProjectionManager;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sphiinx on 8/5/2016.
 */
@ScriptManifest(authors = "Sphiinx", category = "Mining", name = "SPX AIO Miner", version = 1.3)
@DoNotRename
public class Main extends AbstractScript implements Painting, MousePainting, MouseSplinePainting, MessageListening07, EventBlockingOverride, Ending {

    private ProjectionManager projection_manager = new ProjectionManager();

    @Override
    protected GUI getGUI() {
        try {
            return new GUI(new URL("http://spxscripts.com/spxaiominer/GUI.fxml"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void run() {
        Vars.reset();
        Vars.get().slave_time_ran = System.currentTimeMillis();
        super.run();
    }

    @Override
    public void addTasks(Task... tasks) {
        if (!Vars.get().is_mule) {
            switch (Vars.get().mode) {
                case BANKING:
                    super.addTasks(new DepositItems());
                    break;
                case POWERMINE:
                    super.addTasks(new Powermine());
                    break;
                case M1D1:
                    super.addTasks(new M1D1());
                    break;
                case MOUSEKEYS:
                    super.addTasks(new MouseKeys());
                    break;
            }
            if (Vars.get().upgrade_pickaxe)
                super.addTasks(new UpgradePickaxe());
            if (Vars.get().drop_gems)
                super.addTasks(new DropGems());
            if (Vars.get().world_hop)
                super.addTasks(new WorldHop());
            if (Vars.get().is_slave)
                super.addTasks(new EnableTransfer(), new WithdrawTransferItems(), new WalkToMule(), new TradeMule());
            if (Vars.get().switch_slave_back_to_original_world)
                super.addTasks(new SwitchBackToOriginalWorld());
            super.addTasks(new GetPickaxe(), new EquipPickaxe(), new WalkToMiningLocation(), new MineOre(), new TimedAntiBan());
        } else {
            super.addTasks(new WalkBackToMuleTile(), new AcceptSlaveTrade());
        }
    }

    @Override
    public void onPaint(Graphics g) {
        super.onPaint(g);
        if (Vars.get().ore_type != null) {
            if (Vars.get().ore_price <= 0)
                Vars.get().ore_price = PriceChecking07.getOSBuddyPrice(Vars.get().ore_type.getItemID());

            Vars.get().profit = Vars.get().ore_price * Vars.get().ore_mined;
        }
        if (!Vars.get().is_mule) {
            paint_manager.drawGeneralData("Mined: ", Vars.get().ore_mined + Calculations.getPerHour(Vars.get().ore_mined, this.getRunningTime()), DataPosition.TWO, g);
            paint_manager.drawGeneralData("Profit: ", Utility07.formatNumber(Vars.get().profit) + Calculations.getGPPerHour(Vars.get().profit, this.getRunningTime()), DataPosition.THREE, g);
            paint_manager.drawGeneralData("Mining: ", paint_manager.getSkillData(SkillData.MINING, this.getRunningTime()), DataPosition.FOUR, g);
            paint_manager.drawGeneralData("Status: ", task_manager.getStatus() + Utility07.getLoadingPeriods(), DataPosition.FIVE, g);

            if (Vars.get().is_slave) {
                paint_manager.drawGeneralData("Mule trades: ", Vars.get().mule_trades + Calculations.getGPPerHour(Vars.get().mule_trades, this.getRunningTime()), DataPosition.SIX, g);
                paint_manager.drawGeneralData("Next trade: ", getTimeUntilTransfer() + " minutes" + Utility07.getLoadingPeriods(), DataPosition.SEVEN, g);
            }
        } else {
            paint_manager.drawGeneralData("Mule trades: ", Vars.get().mule_trades + Calculations.getGPPerHour(Vars.get().mule_trades, this.getRunningTime()), DataPosition.TWO, g);
            paint_manager.drawGeneralData("Status: ", task_manager.getStatus() + Utility07.getLoadingPeriods(), DataPosition.THREE, g);
        }

        if (Vars.get().radius_mine) {
            final RSArea radius_area = new RSArea(Vars.get().mining_location_tile, Vars.get().radius);
            projection_manager.drawArea(radius_area, g);
            projection_manager.drawMinimapArea(Vars.get().mining_location_tile, Vars.get().radius, g);
        }
    }

    private long getTimeUntilTransfer() {
        if (Vars.get().is_transferring)
            return 0;

        if (Vars.get().transfer_after_minutes <= 0 && Vars.get().transfer_after_profit <= 0)
            return 0;

        if (Vars.get().transfer_after_profit <= Vars.get().transfer_after_minutes)
            return Vars.get().transfer_after_minutes - Timing.timeFromMark(Vars.get().slave_time_ran) / 60000;
        else {
            if (Vars.get().profit <= 0)
                return 0;

            return (long) ((Vars.get().transfer_after_profit - Vars.get().profit) / ((3600000.0 / this.getRunningTime()) * Vars.get().profit) * 60);
        }
    }

    @Override
    public void serverMessageReceived(String s) {
        if (s.contains("You manage to mine some") || s.contains("You just mined")) {
            Vars.get().ore_mined++;
            Vars.get().slave_ores_mined++;
            AntiBan.incrementResourcesWon();
        }

        if (s.contains("Accepted trade.")) {
            if (!Vars.get().is_mule) {
                Vars.get().mule_trades++;
                Vars.get().slave_ores_mined = 0;
                Vars.get().slave_time_ran = System.currentTimeMillis();
                if (!Vars.get().switch_slave_back_to_original_world)
                    Vars.get().is_transferring = false;
                Vars.get().is_switching_to_slave_world = true;
            } else {
                Vars.get().slave_trading_name = null;
            }
        }
    }

    @Override
    public void playerMessageReceived(String s, String s1) {

    }

    @Override
    public void duelRequestReceived(String s, String s1) {

    }

    @Override
    public void clanMessageReceived(String s, String s1) {

    }

    @Override
    public void tradeRequestReceived(String s) {
        Vars.get().slave_trading_name = s;
    }

    @Override
    public void personalMessageReceived(String s, String s1) {

    }

    @Override
    public void onEnd() {
        SignatureData.sendSignatureData(this.getRunningTime() / 1000, Vars.get().ore_mined, Vars.get().profit, SkillData.getTotalExperienceGained(), SkillData.getTotalLevelsGained(), Vars.get().mule_trades, Vars.get().mule_trades);
        super.onEnd();
    }

}

