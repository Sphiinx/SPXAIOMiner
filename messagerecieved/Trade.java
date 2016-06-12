package scripts.SPXAIOMiner.messagerecieved;

import scripts.SPXAIOMiner.data.Vars;

/**
 * Created by Sphiinx on 2/16/2016.
 */
public class Trade {

    public void getPlayerTrading(String string) {
        if (Vars.get().masterSystem) {
            Vars.get().playerTrading = string;
        }
    }

}

