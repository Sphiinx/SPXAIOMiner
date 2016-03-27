package scripts.SPXAIOMiner.paint;

import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Slave {

    public Variables variables;
    public PaintManager paintManager;

    public Slave(Variables variables, PaintManager paintManager) {
        this.variables = variables;
        this.paintManager = paintManager;
    }

    //<editor-fold defaultstate="collapsed" desc="Get Slave Info">
    public void getSlaveInfo() {
        if (paintManager.slaveSystem()) {
            if (paintManager.getTransferMinutes() > 0 || paintManager.getTransferMade() > 0) {
                if (paintManager.getTransferMade() <= paintManager.getTransferMinutes()) {
                    variables.moneyLeftUntilTrade = (paintManager.getOrePerHour() * paintManager.getOrePrice()) / paintManager.getMoneyLeftUntilTrade();
                } else {
                    variables.timeUntilTrade = paintManager.getTransferMinutes() - paintManager.getTimeRanMinutes();
                }
            } else {
                variables.timeUntilTrade = 0;
            }
        }
    }
    //</editor-fold>

}