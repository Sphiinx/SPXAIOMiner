package scripts.SPXAIOMiner.nodes.Mine;

import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/17/2016.
 */
public class Powermine extends Node {

    public Powermine(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        Inventory.drop(Inventory.getAll());
    }

    @Override
    public String toString() {
        return "Dropping items...";
    }

    @Override
    public boolean validate() {
        return Inventory.isFull();
    }

}

