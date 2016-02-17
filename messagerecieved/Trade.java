package scripts.SPXAIOMiner.messagerecieved;

import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 2/16/2016.
 */
public class Trade {

    public Variables variables;

    public Trade(Variables variables) {
        this.variables = variables;
    }

    public void getPlayerTrading(String string) {
        if (variables.masterSystem) {
            variables.playerTrading = string;
        }
    }

}

