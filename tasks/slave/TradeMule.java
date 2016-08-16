package scripts.spxaiominer.tasks.slave;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSPlayer;
import scripts.spxaiominer.data.Vars;
import scripts.task_framework.framework.Task;
import scripts.tribotapi.game.player.Player07;
import scripts.tribotapi.game.timing.Timing07;

/**
 * Created by Sphiinx on 8/6/2016.
 */
public class TradeMule implements Task {

    @Override
    public boolean validate() {
        if (Vars.get().is_upgrading_pickaxe)
            return false;

        final RSPlayer player_to_trade = Player07.getPlayer(Vars.get().mule_username);
        return Vars.get().is_transferring && !Vars.get().is_switching_to_slave_world && player_to_trade != null && (Inventory.getCount(Vars.get().ore_type.getItemID() + 1) >= Vars.get().ore_mined || Trading.getWindowState() != null);
    }

    @Override
    public void execute() {
        if (Banking.isBankScreenOpen())
            if (Banking.close())
                Timing07.waitCondition(() -> !Banking.isBankScreenOpen(), General.random(1500, 2000));

        final RSPlayer player_to_trade = Player07.getPlayer(Vars.get().mule_username);
        if (player_to_trade == null)
            return;

        if (player_to_trade.isOnScreen()) {
            if (Trading.getWindowState() != null) {
                if (!Trading.getOpponentName().equals(Vars.get().mule_username)) {
                    if (Trading.close())
                        Timing07.waitCondition(() -> Trading.getWindowState() == null, General.random(1500, 2000));
                } else {
                    if (Trading.getWindowState() == Trading.WINDOW_STATE.FIRST_WINDOW) {
                        if (Trading.getOfferedItems(false).length <= 0) {
                            if (Trading.offer(0, Vars.get().ore_type.getItemID() + 1))
                                Timing07.waitCondition(() -> Trading.getOfferedItems(false).length > 0, General.random(2500, 3000));
                        } else {
                            if (Trading.hasAccepted(false))
                                return;

                            if (Trading.accept())
                                Timing07.waitCondition(() -> Trading.hasAccepted(false), General.random(2500, 3000));
                        }
                    } else {
                        if (Trading.getWindowState() == Trading.WINDOW_STATE.SECOND_WINDOW) {
                            if (Trading.hasAccepted(false))
                                return;

                            if (Trading.getOfferedItems(false).length <= 0)
                                return;

                            if (Trading.accept())
                                Timing07.waitCondition(() -> Trading.hasAccepted(false), General.random(2500, 3000));
                        }
                    }
                }
            } else {
                if (Clicking.click("Trade with " + Vars.get().mule_username, player_to_trade))
                    Timing07.waitCondition(() -> Trading.getWindowState() != null, General.random(4500, 5000));
            }
        } else {
            WebWalking.walkTo(player_to_trade, new Condition() {
                @Override
                public boolean active() {
                    final RSPlayer player_to_trade = Player07.getPlayer(Vars.get().mule_username);
                    return player_to_trade != null && player_to_trade.isOnScreen();
                }
            }, 250);
        }
    }

    @Override
    public String toString() {
        return "Trading mule";
    }
}

