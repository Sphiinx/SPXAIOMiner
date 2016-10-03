package scripts.spxaiominer;

import com.allatori.annotations.DoNotRename;
import javafx.scene.control.*;
import org.tribot.api.Timing;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;
import org.tribot.util.Util;
import scripts.spxaiominer.data.Vars;
import scripts.spxaiominer.data.enums.MiningLocation;
import scripts.spxaiominer.data.enums.Mode;
import scripts.spxaiominer.data.enums.OreType;
import scripts.tribotapi.Client;
import scripts.generalapi.FileManagment;
import scripts.generalapi.PostRequest;
import scripts.tribotapi.game.worldswitcher.enums.SwitcherWorldType;
import scripts.tribotapi.gui.AbstractGUIController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import scripts.tribotapi.util.Logging;
import scripts.tribotapi.util.Utility;

/**
 * Created by Sphiinx on 8/5/2016.
 */
@DoNotRename
public class GUIController extends AbstractGUIController {

    @FXML
    @DoNotRename
    public ResourceBundle resources;

    @FXML
    @DoNotRename
    private URL location;

    @FXML
    @DoNotRename
    private Button start;

    @FXML
    @DoNotRename
    private ChoiceBox<MiningLocation> mining_location;

    @FXML
    @DoNotRename
    private ComboBox<OreType> ore_type;

    @FXML
    @DoNotRename
    private ChoiceBox<Mode> mode;

    @FXML
    @DoNotRename
    private CheckBox drop_gems;

    @FXML
    @DoNotRename
    private CheckBox world_hop;

    @FXML
    @DoNotRename
    private ComboBox<SwitcherWorldType> world_type;

    @FXML
    @DoNotRename
    private Spinner<Integer> hop_if_players_greater_than;

    @FXML
    @DoNotRename
    private CheckBox hop_if_no_ores_available;

    @FXML
    @DoNotRename
    private CheckBox radius_mine;

    @FXML
    @DoNotRename
    private Spinner<Integer> radius_amount;

    @FXML
    @DoNotRename
    private ComboBox<OreType> radius_ore_type;

    @FXML
    @DoNotRename
    private CheckBox disable_abc2_sleeps;

    @FXML
    @DoNotRename
    private CheckBox upgrade_pickaxe;

    @FXML
    @DoNotRename
    private CheckBox is_mule;

    @FXML
    @DoNotRename
    private CheckBox is_slave;

    @FXML
    @DoNotRename
    private TextField mule_username;

    @FXML
    @DoNotRename
    private Spinner<Integer> mule_world;

    @FXML
    @DoNotRename
    private TextField mule_location;

    @FXML
    @DoNotRename
    private Spinner<Integer> transfer_after_minutes;

    @FXML
    @DoNotRename
    private Spinner<Integer> transfer_after_profit;

    @FXML
    @DoNotRename
    private Spinner<Integer> transfer_variation;

    @FXML
    @DoNotRename
    private CheckBox switch_slave_back_to_original_world;

    @FXML
    @DoNotRename
    private TextArea bug_clientdebug;

    @FXML
    @DoNotRename
    private TextArea bug_stacktrace;

    @FXML
    @DoNotRename
    private TextArea bug_description;

    @FXML
    @DoNotRename
    private TextArea bug_botdebug;

    @FXML
    @DoNotRename
    private Button send_report;

    @FXML
    @DoNotRename
    private Label report_sent;

    @FXML
    @DoNotRename
    private Label report_spam;

    @FXML
    @DoNotRename
    private Hyperlink join_discord;

    @FXML
    @DoNotRename
    private Hyperlink add_skype;

    @FXML
    @DoNotRename
    private Hyperlink private_message;

    @FXML
    @DoNotRename
    private Hyperlink website_link;

    @FXML
    @DoNotRename
    private Button load_settings;

    @FXML
    @DoNotRename
    private Button save_settings;

    @FXML
    @DoNotRename
    private TextField settings_file_name;

    @FXML
    @DoNotRename
    private ComboBox<String> saved_settings;

    @FXML
    @DoNotRename
    void initialize() {
        mining_location.getItems().setAll(MiningLocation.values());
        mining_location.getSelectionModel().select(0);

        ore_type.getItems().setAll(mining_location.getSelectionModel().getSelectedItem().getSupportedOre());
        ore_type.getSelectionModel().select(0);

        radius_ore_type.getItems().setAll(OreType.values());
        radius_ore_type.getSelectionModel().select(0);

        mode.getItems().setAll(Mode.values());
        mode.getSelectionModel().select(0);

        world_type.getItems().setAll(SwitcherWorldType.values());
        world_type.getSelectionModel().select(0);

        join_discord.setOnAction((event) -> Utility.openURL("https://discordapp.com/invite/0yCbdv5qTOWmxUD5"));

        add_skype.setOnAction((event -> Utility.openURL("http://hatscripts.com/addskype/?sphiin.x")));

        private_message.setOnAction((event -> Utility.openURL("https://tribot.org/forums/profile/176138-sphiinx/")));

        website_link.setOnAction((event -> Utility.openURL("http://spxscripts.com/")));

        mining_location.setOnAction(event -> {
            ore_type.getItems().setAll(mining_location.getSelectionModel().getSelectedItem().getSupportedOre());
            ore_type.getSelectionModel().select(0);
        });

        send_report.setOnAction((event) -> {
            if (PostRequest.LAST_SENT_TIME <= 0 || Timing.timeFromMark(PostRequest.LAST_SENT_TIME) > 60000) {
                if (!PostRequest.sendReportData(Client.getManifest(Main.class).name(), Client.getManifest(Main.class).version(), bug_description.getText(), bug_stacktrace.getText(), bug_clientdebug.getText(), bug_botdebug.getText()))
                    report_sent.setText("UH OH! There seems to have been an error with your report!");

                report_sent.setOpacity(1);
                report_spam.setOpacity(0);
                PostRequest.LAST_SENT_TIME = Timing.currentTimeMillis();
            } else {
                report_sent.setOpacity(0);
                report_spam.setOpacity(1);
            }
        });

        // Radius mining action event
        radius_mine.setOnAction((event) -> {
            Vars.get().radius_mine = radius_mine.isSelected();
            Vars.get().mining_location_tile = Player.getPosition();
        });

        // Radius mining action event
        radius_amount.valueProperty().addListener((observable, oldValue, newValue) -> {
            Vars.get().radius = radius_amount.getValue();
        });

        // Start action event
        start.setOnAction((event) -> {
            // Mule system
            if (is_slave.isSelected()) {
                Vars.get().is_slave = is_slave.isSelected();
                Vars.get().mule_username = mule_username.getText();
                Vars.get().mule_world = mule_world.getValue();
                Vars.get().transfer_after_minutes = transfer_after_minutes.getValue();
                Vars.get().transfer_after_profit = transfer_after_profit.getValue();
                Vars.get().transfer_variation = transfer_variation.getValue();
                Vars.get().switch_slave_back_to_original_world = switch_slave_back_to_original_world.isSelected();
                final String mule_location_text = mule_location.getText().replaceAll("[()]", "");
                final String[] mule_location_split = mule_location_text.split(",");
                int x = Integer.parseInt(mule_location_split[0].trim());
                int y = Integer.parseInt(mule_location_split[1].trim());
                int plane = Integer.parseInt(mule_location_split[2].trim());
                Vars.get().mule_location = new RSTile(x, y, plane);
            }

            // Settings
                Vars.get().upgrade_pickaxe = upgrade_pickaxe.isSelected();
                Vars.get().disable_abc2_sleeps = disable_abc2_sleeps.isSelected();

            // Mule system
                Vars.get().is_mule = is_mule.isSelected();

            // World hopping
            Vars.get().world_hop = world_hop.isSelected();
            Vars.get().world_type = world_type.getSelectionModel().getSelectedItem();
            Vars.get().hop_if_no_ores_available = hop_if_no_ores_available.isSelected();
            Vars.get().hop_if_players_greater_than = hop_if_players_greater_than.getValue();

            // Radius mining
            if (radius_mine.isSelected()) {
                Vars.get().ore_type = radius_ore_type.getSelectionModel().getSelectedItem();
                Vars.get().radius = radius_amount.getValue();
                Vars.get().radius_mine = radius_mine.isSelected();
            } else {
                // Normal mining
                Vars.get().mining_location = mining_location.getSelectionModel().getSelectedItem();
                Vars.get().mining_location_tile = Vars.get().mining_location.getTile();
                Vars.get().ore_type = ore_type.getSelectionModel().getSelectedItem();
                Vars.get().radius = 30;
            }

            Vars.get().mode = mode.getSelectionModel().getSelectedItem();
            Vars.get().drop_gems = drop_gems.isSelected();
            getGUI().close();
        });

        // Setting the settings list
        final String[] settings_files = FileManagment.getFileNamesInDirectory(Util.getWorkingDirectory().getAbsolutePath() + File.separator + "SPXScripts" + File.separator + "SPX_AIO_Miner");
        if (settings_files != null) {
            saved_settings.getItems().setAll(settings_files);
            saved_settings.getSelectionModel().select(0);
        }

        // Save settings action event
        save_settings.setOnAction((event -> {
            if (saveSettings()) {
                Logging.status("Settings successfully saved.");
            }
        }));

        // Load settings action event
        load_settings.setOnAction(event -> {
            if (loadSettings())
                Logging.status("Settings successfully loaded.");
        });
    }

    public boolean saveSettings() {
        try {
            if (Vars.get().file_path == null)
                FileManagment.createFile(Util.getWorkingDirectory().getAbsolutePath() + File.separator + "SPXScripts" + File.separator + "SPX_AIO_Miner", settings_file_name.getText(), ".ini");

            Vars.get().file_path = FileManagment.getFileInDirectory(Util.getWorkingDirectory().getAbsolutePath() + File.separator + "SPXScripts" + File.separator + "SPX_AIO_Miner", settings_file_name.getText() + ".ini");
            Vars.get().file_properties.put("tree_location", String.valueOf(mining_location.getSelectionModel().getSelectedIndex()));
            Vars.get().file_properties.put("tree_type", String.valueOf(ore_type.getSelectionModel().getSelectedIndex()));
            Vars.get().file_properties.put("mode", String.valueOf(mode.getSelectionModel().getSelectedIndex()));
            Vars.get().file_properties.put("pick_up_nests", String.valueOf(drop_gems.isSelected()));
            Vars.get().file_properties.put("world_hop", String.valueOf(world_hop.isSelected()));
            Vars.get().file_properties.put("world_type", String.valueOf(world_type.getSelectionModel().getSelectedIndex()));
            Vars.get().file_properties.put("hop_if_players_greater_than", String.valueOf(hop_if_players_greater_than.getValue()));
            Vars.get().file_properties.put("hop_if_no_trees_available", String.valueOf(hop_if_no_ores_available.isSelected()));
            Vars.get().file_properties.put("radius_chop", String.valueOf(radius_mine.isSelected()));
            Vars.get().file_properties.put("radius_amount", String.valueOf(radius_amount.getValue()));
            Vars.get().file_properties.put("radius_ore_type", String.valueOf(radius_ore_type.getSelectionModel().getSelectedIndex()));
            Vars.get().file_properties.put("disable_abc2_sleeps", String.valueOf(disable_abc2_sleeps.isSelected()));
            Vars.get().file_properties.put("upgrade_axe", String.valueOf(upgrade_pickaxe.isSelected()));
            Vars.get().file_properties.put("is_mule", String.valueOf(is_mule.isSelected()));
            Vars.get().file_properties.put("is_slave", String.valueOf(is_slave.isSelected()));
            Vars.get().file_properties.put("mule_username", String.valueOf(mule_username.getText()));
            Vars.get().file_properties.put("mule_world", String.valueOf(mule_world.getValue()));
            Vars.get().file_properties.put("mule_location", String.valueOf(mule_location.getText()));
            Vars.get().file_properties.put("transfer_after_minutes", String.valueOf(transfer_after_minutes.getValue()));
            Vars.get().file_properties.put("transfer_after_profit", String.valueOf(transfer_after_profit.getValue()));
            Vars.get().file_properties.put("transfer_variation", String.valueOf(transfer_variation.getValue()));
            Vars.get().file_properties.put("switch_slave_back_to_original_world", String.valueOf(switch_slave_back_to_original_world.isSelected()));
            Vars.get().file_properties.store(new FileOutputStream(Vars.get().file_path), "Settings");

            return true;
        } catch (Exception e) {
            Logging.warning("Failed to save settings.");
            e.printStackTrace();
        }

        return false;
    }

    public boolean loadSettings() {
        try {

            Vars.get().file_path = FileManagment.getFileInDirectory(Util.getWorkingDirectory().getAbsolutePath() + File.separator + "SPXScripts" + File.separator + "SPX_AIO_Miner", saved_settings.getSelectionModel().getSelectedItem());
            Vars.get().file_properties.load(new FileInputStream(Vars.get().file_path));
            mining_location.getSelectionModel().select(Integer.parseInt(Vars.get().file_properties.getProperty("tree_location", "0")));
            ore_type.getSelectionModel().select(Integer.parseInt(Vars.get().file_properties.getProperty("tree_type", "0")));
            mode.getSelectionModel().select(Integer.parseInt(Vars.get().file_properties.getProperty("mode", "0")));
            drop_gems.setSelected(Boolean.valueOf(Vars.get().file_properties.getProperty("pick_up_nests")));
            world_hop.setSelected(Boolean.valueOf(Vars.get().file_properties.getProperty("world_hop")));
            world_type.getSelectionModel().select(Integer.parseInt(Vars.get().file_properties.getProperty("world_type", "0")));
            hop_if_players_greater_than.getValueFactory().setValue(Integer.parseInt(Vars.get().file_properties.getProperty("hop_if_players_greater_than")));
            hop_if_no_ores_available.setSelected(Boolean.valueOf(Vars.get().file_properties.getProperty("hop_if_no_trees_available")));
            radius_mine.setSelected(Boolean.valueOf(Vars.get().file_properties.getProperty("radius_chop")));
            radius_amount.getValueFactory().setValue(Integer.parseInt(Vars.get().file_properties.getProperty("radius_amount")));
            radius_ore_type.getSelectionModel().select(Integer.parseInt(Vars.get().file_properties.getProperty("radius_ore_type", "0")));
            disable_abc2_sleeps.setSelected(Boolean.valueOf(Vars.get().file_properties.getProperty("disable_abc2_sleeps")));
            upgrade_pickaxe.setSelected(Boolean.valueOf(Vars.get().file_properties.getProperty("upgrade_axe")));
            is_mule.setSelected(Boolean.valueOf(Vars.get().file_properties.getProperty("is_mule")));
            is_slave.setSelected(Boolean.valueOf(Vars.get().file_properties.getProperty("is_slave")));
            mule_username.setText(String.valueOf(Vars.get().file_properties.getProperty("mule_username")));
            mule_world.getValueFactory().setValue(Integer.parseInt(Vars.get().file_properties.getProperty("mule_world")));
            mule_location.setText(String.valueOf(Vars.get().file_properties.getProperty("mule_location")));
            transfer_after_minutes.getValueFactory().setValue(Integer.parseInt(Vars.get().file_properties.getProperty("transfer_after_minutes")));
            transfer_after_profit.getValueFactory().setValue(Integer.parseInt(Vars.get().file_properties.getProperty("transfer_after_profit")));
            transfer_variation.getValueFactory().setValue(Integer.parseInt(Vars.get().file_properties.getProperty("transfer_variation")));
            switch_slave_back_to_original_world.setSelected(Boolean.valueOf(Vars.get().file_properties.getProperty("switch_slave_back_to_original_world")));

            return true;
        } catch (IOException e) {
            Logging.warning("Failed to load settings.");
            e.printStackTrace();
        }

        return false;
    }

}

