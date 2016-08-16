package scripts.spxaiominer.tasks.mule;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.Trading;
import org.tribot.api2007.types.RSPlayer;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.task_framework.framework.TaskManager;
import scripts.tribotapi.game.inventory.Inventory07;
import scripts.tribotapi.game.player.Player07;
import scripts.tribotapi.game.timing.Timing07;

/**
 * Created by Sphiinx on 8/6/2016.
 */
public class AcceptSlaveTrade implements Task {


    @Override
    public boolean validate() {
        final RSPlayer player_to_trade = Player07.getPlayer(Vars.get().slave_trading_name);
        if (player_to_trade == null)
            TaskManager.setStatus("Waiting for slave");
        return player_to_trade != null && !Inventory.isFull();
    }

    @Override
    public void execute() {
        if (Vars.get().mule_location == null)
            Vars.get().mule_location = Player.getPosition();

        final RSPlayer player_to_trade = Player07.getPlayer(Vars.get().slave_trading_name);
        if (player_to_trade == null)
            return;

        if (Trading.getWindowState() != null) {
            if (Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW) {
                handleTrade();
            } else {
                if (Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW) {
                    handleTrade();
                }
            }
        } else {
            if (Clicking.click("Trade with " + Vars.get().slave_trading_name, player_to_trade))
                Timing07.waitCondition(() -> Trading.getWindowState() != null, General.random(4500, 5000));
        }
    }

    private void handleTrade() {
        if (Trading.hasAccepted(false))
            return;

        if (Trading.getOfferedItems(true).length <= 0)
            return;

        if (Trading.getOfferedItems(true).length > Inventory07.getAmountOfSpace())
            if (Trading.close())
                Timing07.waitCondition(() -> Trading.getWindowState() == null, General.random(1500, 2000));

        if (Trading.accept())
            Timing07.waitCondition(() -> Trading.hasAccepted(false), General.random(2500, 3000));
    }

    @Override
    public String toString() {
        return "Aceepting trade";
    }
}

