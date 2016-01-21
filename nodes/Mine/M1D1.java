package scripts.SPXAIOMiner.nodes.Mine;

import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public class M1D1 extends Node {

    public M1D1(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        Inventory.drop(vars.oreType.getItemID());
    }

    @Override
    public String toString() {
        return "Dropping items...";
    }

    @Override
    public boolean validate() {
        return Inventory.getCount(vars.oreType.getItemID()) > 0;
    }

}

