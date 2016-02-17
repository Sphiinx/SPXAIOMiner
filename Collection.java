package scripts.SPXAIOMiner;

import scripts.SPXAIOMiner.API.Framework.Task;
import scripts.SPXAIOMiner.data.Variables;
import scripts.SPXAIOMiner.tasks.*;
import scripts.SPXAIOMiner.tasks.Mine.*;
import scripts.SPXAIOMiner.tasks.MuleSystem.MasterSystem;
import scripts.SPXAIOMiner.tasks.MuleSystem.TradeMaster;
import scripts.SPXAIOMiner.tasks.MuleSystem.WalkToMaster;
import scripts.SPXAIOMiner.tasks.MuleSystem.WithdrawItems;
import scripts.SPXAIOMiner.tasks.PickaxeUpgrading.EquipPickaxe;
import scripts.SPXAIOMiner.tasks.PickaxeUpgrading.GetPickaxe;
import scripts.SPXAIOMiner.tasks.PickaxeUpgrading.UpgradePickaxe;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Collection {

    public Variables variables;
    public ArrayList<Task> tasks = new ArrayList<>();

    public Collection(Variables variables) {
        this.variables = variables;
    }

    //<editor-fold defaultstate="collapsed" desc="Collection">
    public void addCollection() {
        if (variables.runFromCombat) {
            Collections.addAll(tasks, new RunFromCombat(variables));
        }
        if (variables.worldHop) {
            Collections.addAll(tasks, new WorldHop(variables));
        }
        if (variables.dropGems) {
            Collections.addAll(tasks, new DropUnwanted(variables));
        }
        if (variables.slaveSystem) {
            Collections.addAll(tasks, new TradeMaster(variables), new WalkToMaster(variables), new WithdrawItems(variables));
        }
        if (variables.upgradePickaxe) {
            Collections.addAll(tasks, new UpgradePickaxe(variables));
        }
        if (variables.levelToStop > 0) {
            Collections.addAll(tasks, new StopSettings(variables));
        }
        if (variables.masterSystem) {
            Collections.addAll(tasks, new MasterSystem(variables));
        } else {
            Collections.addAll(tasks, new GetPickaxe(variables), new EquipPickaxe(variables), new WalkToQuarry(variables), new MineOre(variables));
        }
        switch (variables.mode) {
            case BANKING:
                Collections.addAll(tasks, new DepositItems(variables));
                break;
            case POWERMINE:
                Collections.addAll(tasks, new Powermine(variables));
                break;
            case M1D1:
                Collections.addAll(tasks, new M1D1(variables));
                break;
            case MOUSEKEYS:
                Collections.addAll(tasks, new MouseKeys(variables));
                break;
        }
    }
    //</editor-fold>

}

