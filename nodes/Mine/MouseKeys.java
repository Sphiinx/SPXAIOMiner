package scripts.SPXAIOMiner.nodes.Mine;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;
import scripts.SPXAIOMiner.API.Framework.Node;
import scripts.SPXAIOMiner.API.Game.Inventory.Inventory07;
import scripts.SPXAIOMiner.data.Variables;

/**
 * Created by Sphiinx on 1/18/2016.
 */
public class MouseKeys extends Node {

    public MouseKeys(Variables v) {
        super(v);
    }

    @Override
    public void execute() {
        if (Inventory07.mouseKeysDropAllExcept()) {
            Timing.waitCondition(new Condition() {
                @Override
                public boolean active() {
                    return !Inventory.isFull();
                }
            }, General.random(2000, 2500));
        }
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

