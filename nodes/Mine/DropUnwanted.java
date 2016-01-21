package scripts.SPXAIOMiner.nodes.Mine;

import org.tribot.api2007.Inventory;
import scripts.API.Game.Inventory.Inventory07;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public class DropUnwanted extends Node{

    public DropUnwanted(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        Inventory07.drop(Constants.GEMS);
    }

    @Override
    public String toString() {
        return "Dropping items...";
    }

    @Override
    public boolean validate() {
        return Inventory.getCount(Constants.GEMS) > 0;
    }

}

