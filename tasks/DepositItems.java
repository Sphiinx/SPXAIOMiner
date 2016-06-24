package scripts.SPXAIOMiner.tasks;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.*;

import org.tribot.api2007.types.RSItem;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.data.enums.Location;
import scripts.SPXAIOMiner.framework.Task;
import scripts.TribotAPI.game.banking.Banking07;
import scripts.TribotAPI.game.banking.DepositBox07;
import scripts.TribotAPI.game.inventory.Inventory07;
import scripts.TribotAPI.game.utiity.Utility07;


/**
 * Created by Sphiinx on 1/16/2016.
 */
public class DepositItems implements Task {

    public void execute() {
        handleBanking();
    }

    //<editor-fold defaultstate="collapsed" desc="HandleBanking">
    private void handleBanking() {
        if (isUsingCustomPath()) {
            if (DepositBox07.isAtDepositBox()) {
                handleDepositBox();
            } else {
                useCustomPaths();
            }
        } else {
            if (Banking.isBankScreenOpen()) {
                if (Vars.get().pickaxeInInventory) {
                    RSItem[] pick = Inventory.find(Constants.PICKAXES);
                    Banking07.depositAllExcept(pick[0].getID());
                } else {
                    Banking07.depositInventory();
                }
            } else {
                Banking07.openBank();
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Check Custom Path">
    private boolean isUsingCustomPath() {
        return Vars.get().area.equals(Location.RIMMINGTON.getLocation()) ||
                Vars.get().area.equals(Location.PORT_KHAZARD.getLocation());
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Handle Deposit Box">
    private void handleDepositBox() {
        RSItem[] ore = Inventory.find(Vars.get().oreType.getItemID());
        if (DepositBox07.deposit(0, ore[0])) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    return Inventory07.getAmountOfSpace() == 0;
                }
            }, General.random(2000, 3000));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Use Custom Path">
    private void useCustomPaths() {
        if (Vars.get().area.equals(Location.RIMMINGTON.getLocation())) {
            WebWalking.walkTo(Constants.RIMMINGTON_DEPOSIT_BOX);
        } else{
            if (Vars.get().area.equals(Location.PORT_KHAZARD.getLocation())) {
                WebWalking.walkTo(Constants.PORTKHAZARD_DEPOSIT_BOX);
            }
        }
    }
    //</editor-fold>

    public String toString() {
        return "Depositing items" + Utility07.loadingPeriods();
    }

    public boolean validate() {
        return Inventory.isFull();
    }

}