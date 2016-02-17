package scripts.SPXAIOMiner.paint;

import scripts.SPXAIOMiner.data.Variables;

import java.awt.*;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Slave {

    public Variables variables;

    public Slave(Variables variables) {
        this.variables = variables;
    }

    public void systemInfo() {
        if (variables.slaveSystem) {
            if (variables.transferMade <= variables.transferMinutes) {
                variables.timeUntilTrade = (variables.oreHR * variables.orePrice) / variables.moneyLeftUntilTrade;
            } else {
                variables.timeUntilTrade = variables.transferMinutes - variables.timeRanMinutes;
            }
        }
    }

}

