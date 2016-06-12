package scripts.SPXAIOMiner.gui;

import org.tribot.api.General;
import scripts.SPXAIOMiner.data.Vars;
import scripts.TribotAPI.Printing;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Sphiinx on 2/4/2016.
 */
public class Settings {

    private GUI gui;

    public Settings(GUI gui) {
        this.gui = gui;
    }

    //<editor-fold defaultstate="collapsed" desc="Save Settings">
    public boolean saveSettings() {
        try {
            if (!Vars.get().path.exists()) {
                Vars.get().path.createNewFile();
            }

            Vars.get().properties.clear();

            Vars.get().properties.put("pickupBirdsNests", String.valueOf(gui.dropGems.isSelected()));

            Vars.get().properties.put("worldHop", String.valueOf(gui.worldHop.isSelected()));

            Vars.get().properties.put("worldHopLogsAval", String.valueOf(gui.worldHopOresAval.isSelected()));

            Vars.get().properties.put("radiusChop", String.valueOf(gui.radiusMine.isSelected()));

            Vars.get().properties.put("masterSystem", String.valueOf(gui.masterSystem.isSelected()));

            Vars.get().properties.put("slaveSystem", String.valueOf(gui.slaveSystem.isSelected()));

            Vars.get().properties.put("upgradeAxe", String.valueOf(gui.upgradePickaxe.isSelected()));

            Vars.get().properties.put("drawObjects", String.valueOf(gui.drawObjects.isSelected()));

            Vars.get().properties.put("drawTiles", String.valueOf(gui.drawTiles.isSelected()));

            Vars.get().properties.put("disablePaint", String.valueOf(gui.disablePaint.isSelected()));

            Vars.get().properties.put("axeInInventory", String.valueOf(gui.pickaxeInInventory.isSelected()));

            Vars.get().properties.put("switchSlaveBack", String.valueOf(gui.switchSlaveBack.isSelected()));

            Vars.get().properties.put("disableSleeps", String.valueOf(gui.disableSleeps.isSelected()));

            Vars.get().properties.put("useProgressive", String.valueOf(gui.useProgressive.isSelected()));

            Vars.get().properties.put("worldHopPlayersNear", String.valueOf(gui.worldHopPlayersNear.getValue()));

            Vars.get().properties.put("radiusAmount", String.valueOf(gui.radiusAmount.getValue()));

            Vars.get().properties.put("masterWorld", String.valueOf(gui.masterWorld.getValue()));

            Vars.get().properties.put("transferMinutes", String.valueOf(gui.transferMinutes.getValue()));

            Vars.get().properties.put("transferMade", String.valueOf(gui.transferMade.getValue()));

            Vars.get().properties.put("variation", String.valueOf(gui.variation.getValue()));

            Vars.get().properties.put("levelToStop", String.valueOf(gui.levelToStop.getValue()));

            Vars.get().properties.put("treesLocation", String.valueOf(gui.quarryLocation.getSelectedIndex()));

            Vars.get().properties.put("logType", String.valueOf(gui.oreType.getSelectedIndex()));

            Vars.get().properties.put("droppingMode", String.valueOf(gui.droppingMode.getSelectedIndex()));

            Vars.get().properties.put("worldHopMode", String.valueOf(gui.worldHopMode.getSelectedIndex()));

            Vars.get().properties.put("radiusLogType", String.valueOf(gui.radiusOreType.getSelectedIndex()));

            Vars.get().properties.put("log1", String.valueOf(gui.ore1.getSelectedIndex()));

            Vars.get().properties.put("log2", String.valueOf(gui.ore2.getSelectedIndex()));

            Vars.get().properties.put("log3", String.valueOf(gui.ore3.getSelectedIndex()));

            Vars.get().properties.put("location1", String.valueOf(gui.location1.getSelectedIndex()));

            Vars.get().properties.put("location2", String.valueOf(gui.location2.getSelectedIndex()));

            Vars.get().properties.put("location3", String.valueOf(gui.location3.getSelectedIndex()));

            Vars.get().properties.put("masterUsername", String.valueOf(gui.masterUsername.getText()));

            Vars.get().properties.put("masterLocation", String.valueOf(gui.masterLocation.getText()));

            Vars.get().properties.store(new FileOutputStream(Vars.get().path), "Settings");

            return true;
        } catch (Exception e1) {
            Printing.status("Sorry, unable to save settings.");
            e1.printStackTrace();
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Load Settings">
    public boolean loadSettings() {
        try {
            if (!Vars.get().path.exists()) {
                Vars.get().path.createNewFile();
            }

            Vars.get().properties.load(new FileInputStream(Vars.get().path));

            gui.dropGems.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("pickupBirdsNests")));

            gui.worldHop.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("worldHop")));
            gui.setWorldHopTab(gui.worldHop.isSelected());

            gui.worldHopOresAval.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("worldHopLogsAval")));

            gui.radiusMine.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("radiusChop")));
            gui.setRadiusMineTab(gui.radiusMine.isSelected());
            gui.disableLocationTab(gui.radiusMine.isSelected());
            Vars.get().radiusMine = gui.radiusMine.isSelected();

            gui.masterSystem.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("masterSystem")));
            gui.disableLocationTab(gui.masterSystem.isSelected());
            gui.disableDroppingTab(gui.masterSystem.isSelected());
            gui.disableRadiusTab(gui.masterSystem.isSelected());
            gui.disableSlaveTab(gui.masterSystem.isSelected());
            gui.disableTransferringTab(gui.masterSystem.isSelected());
            gui.disableSettingsTab(gui.masterSystem.isSelected());

            gui.slaveSystem.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("slaveSystem")));
            gui.disableMasterTab(gui.slaveSystem.isSelected());
            gui.switchSlaveBack.setEnabled(gui.slaveSystem.isSelected());

            gui.upgradePickaxe.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("upgradeAxe")));

            gui.drawObjects.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("drawObjects")));

            gui.drawTiles.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("drawTiles")));

            gui.disablePaint.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("disablePaint")));

            gui.pickaxeInInventory.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("axeInInventory")));

            gui.switchSlaveBack.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("switchSlaveBack")));

            gui.disableSleeps.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("disableSleeps")));

            gui.useProgressive.setSelected(Boolean.valueOf(Vars.get().properties.getProperty("useProgressive")));
            gui.disableLocationTab(gui.useProgressive.isSelected());
            gui.setProgressiveTab(gui.useProgressive.isSelected());

            gui.worldHopPlayersNear.setValue(Integer.parseInt(Vars.get().properties.getProperty("worldHopPlayersNear")));

            gui.radiusAmount.setValue(Integer.parseInt(Vars.get().properties.getProperty("radiusAmount")));

            gui.masterWorld.setValue(Integer.parseInt(Vars.get().properties.getProperty("masterWorld")));

            gui.transferMinutes.setValue(Integer.parseInt(Vars.get().properties.getProperty("transferMinutes")));

            gui.transferMade.setValue(Integer.parseInt(Vars.get().properties.getProperty("transferMade")));

            gui.variation.setValue(Integer.parseInt(Vars.get().properties.getProperty("variation")));

            gui.levelToStop.setValue(Integer.parseInt(Vars.get().properties.getProperty("levelToStop")));

            gui.quarryLocation.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("treesLocation", "0")));

            gui.oreType.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("logType", "0")));

            gui.droppingMode.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("droppingMode", "0")));

            gui.worldHopMode.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("worldHopMode", "0")));

            gui.radiusOreType.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("radiusLogType", "0")));

            gui.ore1.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("log1", "0")));

            gui.ore2.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("log2", "0")));

            gui.ore3.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("log3", "0")));

            gui.location1.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("location1", "0")));

            gui.location2.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("location2", "0")));

            gui.location3.setSelectedIndex(Integer.parseInt(Vars.get().properties.getProperty("location3", "0")));

            gui.masterUsername.setText(String.valueOf(Vars.get().properties.getProperty("masterUsername")));

            gui.masterLocation.setText(String.valueOf(Vars.get().properties.getProperty("masterLocation")));

            return true;
        } catch (Exception e2) {
            Printing.status("Sorry, unable to load settings.");
            e2.printStackTrace();
        }
        return false;
    }
    //</editor-fold>

}