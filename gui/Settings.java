package scripts.SPXAIOMiner.gui;

import scripts.SPXAIOMiner.api.Printing;

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
            if (!gui.variables.path.exists()) {
                gui.variables.path.createNewFile();
            }

            gui.variables.properties.clear();

            gui.variables.properties.put("pickupBirdsNests", String.valueOf(gui.dropGems.isSelected()));

            gui.variables.properties.put("worldHop", String.valueOf(gui.worldHop.isSelected()));

            gui.variables.properties.put("worldHopLogsAval", String.valueOf(gui.worldHopOresAval.isSelected()));

            gui.variables.properties.put("radiusChop", String.valueOf(gui.radiusMine.isSelected()));

            gui.variables.properties.put("masterSystem", String.valueOf(gui.masterSystem.isSelected()));

            gui.variables.properties.put("slaveSystem", String.valueOf(gui.slaveSystem.isSelected()));

            gui.variables.properties.put("upgradeAxe", String.valueOf(gui.upgradePickaxe.isSelected()));

            gui.variables.properties.put("drawObjects", String.valueOf(gui.drawObjects.isSelected()));

            gui.variables.properties.put("drawTiles", String.valueOf(gui.drawTiles.isSelected()));

            gui.variables.properties.put("disablePaint", String.valueOf(gui.disablePaint.isSelected()));

            gui.variables.properties.put("axeInInventory", String.valueOf(gui.pickaxeInInventory.isSelected()));

            gui.variables.properties.put("switchSlaveBack", String.valueOf(gui.switchSlaveBack.isSelected()));

            gui.variables.properties.put("disableSleeps", String.valueOf(gui.disableSleeps.isSelected()));

            gui.variables.properties.put("useProgressive", String.valueOf(gui.useProgressive.isSelected()));

            gui.variables.properties.put("worldHopPlayersNear", String.valueOf(gui.worldHopPlayersNear.getValue()));

            gui.variables.properties.put("radiusAmount", String.valueOf(gui.radiusAmount.getValue()));

            gui.variables.properties.put("masterWorld", String.valueOf(gui.masterWorld.getValue()));

            gui.variables.properties.put("transferMinutes", String.valueOf(gui.transferMinutes.getValue()));

            gui.variables.properties.put("transferMade", String.valueOf(gui.transferMade.getValue()));

            gui.variables.properties.put("variation", String.valueOf(gui.variation.getValue()));

            gui.variables.properties.put("levelToStop", String.valueOf(gui.levelToStop.getValue()));

            gui.variables.properties.put("treesLocation", String.valueOf(gui.quarryLocation.getSelectedIndex()));

            gui.variables.properties.put("logType", String.valueOf(gui.oreType.getSelectedIndex()));

            gui.variables.properties.put("droppingMode", String.valueOf(gui.droppingMode.getSelectedIndex()));

            gui.variables.properties.put("worldHopMode", String.valueOf(gui.worldHopMode.getSelectedIndex()));

            gui.variables.properties.put("radiusLogType", String.valueOf(gui.radiusOreType.getSelectedIndex()));

            gui.variables.properties.put("log1", String.valueOf(gui.ore1.getSelectedIndex()));

            gui.variables.properties.put("log2", String.valueOf(gui.ore2.getSelectedIndex()));

            gui.variables.properties.put("log3", String.valueOf(gui.ore3.getSelectedIndex()));

            gui.variables.properties.put("location1", String.valueOf(gui.location1.getSelectedIndex()));

            gui.variables.properties.put("location2", String.valueOf(gui.location2.getSelectedIndex()));

            gui.variables.properties.put("location3", String.valueOf(gui.location3.getSelectedIndex()));

            gui.variables.properties.put("masterUsername", String.valueOf(gui.masterUsername.getText()));

            gui.variables.properties.put("masterLocation", String.valueOf(gui.masterLocation.getText()));

            gui.variables.properties.store(new FileOutputStream(gui.variables.path), "Settings");

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
            if (!gui.variables.path.exists()) {
                gui.variables.path.createNewFile();
            }

            gui.variables.properties.load(new FileInputStream(gui.variables.path));

            gui.dropGems.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("pickupBirdsNests")));

            gui.worldHop.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("worldHop")));
            gui.setWorldHopTab(gui.worldHop.isSelected());

            gui.worldHopOresAval.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("worldHopLogsAval")));

            gui.radiusMine.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("radiusChop")));
            gui.setRadiusMineTab(gui.radiusMine.isSelected());
            gui.disableLocationTab(gui.radiusMine.isSelected());
            gui.variables.radiusMine = gui.radiusMine.isSelected();

            gui.masterSystem.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("masterSystem")));
            gui.disableLocationTab(gui.masterSystem.isSelected());
            gui.disableDroppingTab(gui.masterSystem.isSelected());
            gui.disableRadiusTab(gui.masterSystem.isSelected());
            gui.disableSlaveTab(gui.masterSystem.isSelected());
            gui.disableTransferringTab(gui.masterSystem.isSelected());
            gui.disableSettingsTab(gui.masterSystem.isSelected());

            gui.slaveSystem.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("slaveSystem")));
            gui.disableMasterTab(gui.slaveSystem.isSelected());
            gui.switchSlaveBack.setEnabled(gui.slaveSystem.isSelected());

            gui.upgradePickaxe.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("upgradeAxe")));

            gui.drawObjects.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("drawObjects")));

            gui.drawTiles.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("drawTiles")));

            gui.disablePaint.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("disablePaint")));

            gui.pickaxeInInventory.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("axeInInventory")));

            gui.switchSlaveBack.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("switchSlaveBack")));

            gui.disableSleeps.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("disableSleeps")));

            gui.useProgressive.setSelected(Boolean.valueOf(gui.variables.properties.getProperty("useProgressive")));
            gui.disableLocationTab(gui.useProgressive.isSelected());
            gui.setProgressiveTab(gui.useProgressive.isSelected());

            gui.worldHopPlayersNear.setValue(Integer.parseInt(gui.variables.properties.getProperty("worldHopPlayersNear")));

            gui.radiusAmount.setValue(Integer.parseInt(gui.variables.properties.getProperty("radiusAmount")));

            gui.masterWorld.setValue(Integer.parseInt(gui.variables.properties.getProperty("masterWorld")));

            gui.transferMinutes.setValue(Integer.parseInt(gui.variables.properties.getProperty("transferMinutes")));

            gui.transferMade.setValue(Integer.parseInt(gui.variables.properties.getProperty("transferMade")));

            gui.variation.setValue(Integer.parseInt(gui.variables.properties.getProperty("variation")));

            gui.levelToStop.setValue(Integer.parseInt(gui.variables.properties.getProperty("levelToStop")));

            gui.quarryLocation.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("treesLocation", "0")));

            gui.oreType.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("logType", "0")));

            gui.droppingMode.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("droppingMode", "0")));

            gui.worldHopMode.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("worldHopMode", "0")));

            gui.radiusOreType.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("radiusLogType", "0")));

            gui.ore1.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("log1", "0")));

            gui.ore2.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("log2", "0")));

            gui.ore3.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("log3", "0")));

            gui.location1.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("location1", "0")));

            gui.location2.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("location2", "0")));

            gui.location3.setSelectedIndex(Integer.parseInt(gui.variables.properties.getProperty("location3", "0")));

            gui.masterUsername.setText(String.valueOf(gui.variables.properties.getProperty("masterUsername")));

            gui.masterLocation.setText(String.valueOf(gui.variables.properties.getProperty("masterLocation")));

            return true;
        } catch (Exception e2) {
            Printing.status("Sorry, unable to load settings.");
            e2.printStackTrace();
        }
        return false;
    }
    //</editor-fold>

}