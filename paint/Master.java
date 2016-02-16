package scripts.SPXAIOMiner.paint;

import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

import java.awt.*;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Master {

    public Variables variables;

    public Master(Variables variables) {
        this.variables = variables;
    }

    public void systemInfo(Graphics g) {
        long tradesHR = (long) (variables.masterTrades * 3600000D / (System.currentTimeMillis() - Constants.START_TIME));

        g.drawString("Master Trades: " + variables.masterTrades, 282, 348);
        g.drawString("Master Trades P/H: " + tradesHR, 282, 374);
        g.drawString(" ", 282, 450);
    }

}

