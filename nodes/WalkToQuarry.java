package scripts.SPXAIOMiner.nodes;

import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.WebWalking;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class WalkToQuarry extends Node{

    public WalkToQuarry(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        General.println("Walking...");
        WebWalking.walkTo(vars.area, new Condition() {
            @Override
            public boolean active() {
                return vars.targetOre != null && vars.targetOre.isOnScreen();
            }
        }, General.random(50, 100));
    }


    @Override
    public String toString() {
        return "Walking to quarry...";
    }

    @Override
    public boolean validate() {
        return !Inventory.isFull() && vars.targetOre == null;
    }

}

