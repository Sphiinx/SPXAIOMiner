package scripts.SPXAIOMiner.gui;

import scripts.TribotAPI.util.Logging;
import org.tribot.api2007.Player;
import scripts.SPXAIOMiner.data.Constants;
import scripts.SPXAIOMiner.data.Vars;
import scripts.SPXAIOMiner.data.enums.*;
import scripts.TribotAPI.game.game.Game07;
import scripts.TribotAPI.game.utiity.enums.WorldType;
import scripts.TribotAPI.antiban.AntiBan;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class GUI extends JFrame {

    public Vars vars;
    private Settings settings = new Settings(this);

    public GUI() {
        initComponents();
    }

    //<editor-fold defaultstate="collapsed" desc="Vars">
    public JButton start;
    public JButton loadSettings;
    public JButton saveSettings;

    public JCheckBox dropGems;
    public JCheckBox worldHop;
    public JCheckBox drawTiles;
    public JCheckBox radiusMine;
    public JCheckBox drawRadius;
    public JCheckBox drawObjects;
    public JCheckBox slaveSystem;
    public JCheckBox masterSystem;
    public JCheckBox disableRadius;
    public JCheckBox disableSleeps;
    public JCheckBox upgradePickaxe;
    public JCheckBox useProgressive;
    public JCheckBox switchSlaveBack;
    public JCheckBox worldHopOresAval;
    public JCheckBox pickaxeInInventory;

    public JComboBox<OreType> ore1;
    public JComboBox<OreType> ore2;
    public JComboBox<OreType> ore3;
    public JComboBox<OreType> oreType;
    public JComboBox<Mode> droppingMode;
    public JComboBox<Location> location1;
    public JComboBox<Location> location2;
    public JComboBox<Location> location3;
    public JComboBox<WorldType> worldHopMode;
    public JComboBox<OreType> radiusOreType;
    public JComboBox<Location> quarryLocation;

    public JSpinner variation;
    public JSpinner masterWorld;
    public JSpinner levelToStop;
    public JSpinner radiusAmount;
    public JSpinner transferMade;
    public JSpinner transferMinutes;
    public JSpinner worldHopPlayersNear;

    public JTextField masterLocation;
    public JTextField masterUsername;

    public JCheckBox disablePaint;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GUI">
    @SuppressWarnings("unchecked")
    private void initComponents() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        JLabel jLabel10 = new JLabel();
        JLabel jLabel11 = new JLabel();
        JLabel jLabel12 = new JLabel();
        JLabel jLabel13 = new JLabel();
        JLabel jLabel14 = new JLabel();
        JLabel jLabel15 = new JLabel();
        JLabel jLabel16 = new JLabel();
        JLabel jLabel17 = new JLabel();
        JLabel jLabel18 = new JLabel();
        JLabel jLabel19 = new JLabel();
        JLabel jLabel20 = new JLabel();
        JLabel jLabel21 = new JLabel();
        JLabel jLabel22 = new JLabel();
        JLabel jLabel23 = new JLabel();
        JLabel jLabel24 = new JLabel();
        JLabel jLabel25 = new JLabel();
        JLabel jLabel26 = new JLabel();
        JLabel jLabel27 = new JLabel();
        JLabel jLabel28 = new JLabel();
        JLabel jLabel29 = new JLabel();
        JLabel jLabel30 = new JLabel();
        JLabel jLabel31 = new JLabel();
        JLabel jLabel32 = new JLabel();
        JLabel jLabel33 = new JLabel();
        JLabel jLabel34 = new JLabel();
        JLabel jLabel35 = new JLabel();
        JLabel jLabel36 = new JLabel();
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        JPanel jPanel5 = new JPanel();
        JPanel jPanel6 = new JPanel();
        JPanel jPanel7 = new JPanel();
        JPanel jPanel8 = new JPanel();
        JPanel jPanel9 = new JPanel();
        JPanel jPanel10 = new JPanel();
        JPanel jPanel11 = new JPanel();
        JPanel jPanel12 = new JPanel();
        JPanel jPanel13 = new JPanel();
        JPanel jPanel14 = new JPanel();
        JPanel jPanel15 = new JPanel();
        JPanel jPanel16 = new JPanel();
        JPanel jPanel17 = new JPanel();
        JPanel jPanel18 = new JPanel();

        start = new JButton();
        ore1 = new JComboBox<>();
        ore2 = new JComboBox<>();
        ore3 = new JComboBox<>();
        dropGems = new JCheckBox();
        variation = new JSpinner();
        worldHop = new JCheckBox();
        drawTiles = new JCheckBox();
        oreType = new JComboBox<>();
        loadSettings = new JButton();
        levelToStop = new JSpinner();
        masterWorld = new JSpinner();
        radiusMine = new JCheckBox();
        saveSettings = new JButton();
        drawRadius = new JCheckBox();
        location1 = new JComboBox<>();
        location2 = new JComboBox<>();
        location3 = new JComboBox<>();
        drawObjects = new JCheckBox();
        radiusAmount = new JSpinner();
        slaveSystem = new JCheckBox();
        transferMade = new JSpinner();
        masterSystem = new JCheckBox();
        disablePaint = new JCheckBox();
        disableSleeps = new JCheckBox();
        disableRadius = new JCheckBox();
        droppingMode = new JComboBox<>();
        transferMinutes = new JSpinner();
        upgradePickaxe = new JCheckBox();
        worldHopMode = new JComboBox<>();
        useProgressive = new JCheckBox();
        switchSlaveBack = new JCheckBox();
        masterLocation = new JTextField();
        masterUsername = new JTextField();
        radiusOreType = new JComboBox<>();
        quarryLocation = new JComboBox<>();
        worldHopOresAval = new JCheckBox();
        worldHopPlayersNear = new JSpinner();
        pickaxeInInventory = new JCheckBox();

        JTabbedPane jTabbedPane2 = new JTabbedPane();

        jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Location", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Ubuntu", 0, 14)));

        jLabel2.setFont(new Font("Ubuntu", 0, 12));
        jLabel2.setText("Location:");

        jLabel3.setFont(new Font("Ubuntu", 0, 12));
        jLabel3.setText("Ore Type:");

        quarryLocation.setFont(new Font("Ubuntu", 0, 12));
        quarryLocation.setModel(new DefaultComboBoxModel<>(Location.values()));
        quarryLocation.addActionListener(evt -> quarryLocationActionPerformed());

        oreType.setFont(new Font("Ubuntu", 0, 12));
        Location selectedLoc = ((Location) quarryLocation.getSelectedItem());
        oreType.setModel(new DefaultComboBoxModel<>(selectedLoc.getOreType()));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(oreType, 0, 124, Short.MAX_VALUE)
                                        .addComponent(quarryLocation, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(quarryLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(oreType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Method", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Ubuntu", 0, 14)));

        jLabel6.setFont(new Font("Ubuntu", 0, 12));
        jLabel6.setText("Mode:");

        jLabel11.setFont(new Font("Ubuntu", 0, 12));
        jLabel11.setText("Drop Gems:");

        droppingMode.setFont(new Font("Ubuntu", 0, 12));
        droppingMode.setModel(new DefaultComboBoxModel<>(Mode.values()));

        dropGems.setFont(new Font("Ubuntu", 0, 12));
        dropGems.setText("Yes");
        dropGems.setFocusPainted(false);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel11))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dropGems, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(droppingMode, 0, 124, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(droppingMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(dropGems))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(BorderFactory.createTitledBorder(null, "World Hopping", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Ubuntu", 0, 14)));

        jLabel7.setFont(new Font("Ubuntu", 0, 12));
        jLabel7.setText("World Hopping:");

        jLabel8.setFont(new Font("Ubuntu", 0, 12));
        jLabel8.setText("If players in area are greater than:");

        jLabel9.setFont(new Font("Ubuntu", 0, 12));
        jLabel9.setText("If no ores are available:");

        jLabel10.setFont(new Font("Ubuntu", 0, 12));
        jLabel10.setText("World Hopping Mode:");

        worldHop.setFont(new Font("Ubuntu", 0, 12));
        worldHop.setText("Yes");
        worldHop.setFocusPainted(false);
        worldHop.addActionListener(evt -> worldHopActionPerformed());

        worldHopMode.setFont(new Font("Ubuntu", 0, 12));
        worldHopMode.setModel(new DefaultComboBoxModel<>(WorldType.values()));
        worldHopMode.setEnabled(false);

        worldHopPlayersNear.setFont(new Font("Ubuntu", 0, 12));
        worldHopPlayersNear.setModel(new SpinnerNumberModel(0, 0, 999999999, 1));
        worldHopPlayersNear.setEnabled(false);

        worldHopOresAval.setFont(new Font("Ubuntu", 0, 12));
        worldHopOresAval.setText("Yes");
        worldHopOresAval.setEnabled(false);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel10))
                                                .addGap(112, 112, 112)
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(worldHop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(worldHopMode, 0, 130, Short.MAX_VALUE)))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(worldHopPlayersNear)
                                                        .addComponent(worldHopOresAval, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(worldHop))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(worldHopMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(worldHopPlayersNear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(worldHopOresAval))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("General", jPanel1);

        jPanel8.setBorder(BorderFactory.createTitledBorder(null, "Options", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Ubuntu", 0, 14)));

        jLabel4.setFont(new Font("Ubuntu", 0, 12));
        jLabel4.setText("Radius Mining:");

        radiusMine.setFont(new Font("Ubuntu", 0, 12));
        radiusMine.setText("Yes");
        radiusMine.setFocusPainted(false);
        radiusMine.addActionListener(evt -> radiusMineActionPerformed());

        radiusAmount.setFont(new Font("Ubuntu", 0, 12));
        radiusAmount.setModel(new SpinnerNumberModel(0, 0, 40, 1));
        radiusAmount.setEnabled(false);
        radiusAmount.addChangeListener(evt -> radiusAmountstateChanged());

        jLabel5.setFont(new Font("Ubuntu", 0, 12));
        jLabel5.setText("Radius:");

        jLabel14.setFont(new Font("Ubuntu", 0, 12));
        jLabel14.setText("Ore Type:");

        radiusOreType.setFont(new Font("Ubuntu", 0, 12));
        radiusOreType.setModel(new DefaultComboBoxModel<>(OreType.values()));
        radiusOreType.setEnabled(false);

        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                                                .addComponent(radiusMine, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(radiusAmount)
                                                        .addComponent(radiusOreType, 0, 124, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(radiusMine))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(radiusAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(radiusOreType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(303, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Radius Mining", jPanel7);

        jPanel10.setBorder(BorderFactory.createTitledBorder(null, "Master", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Ubuntu", 0, 14)));

        jLabel16.setFont(new Font("Ubuntu", 0, 12));
        jLabel16.setText("Master System:");

        masterSystem.setFont(new Font("Ubuntu", 0, 12));
        masterSystem.setText("Yes");
        masterSystem.addActionListener(evt -> masterSystemActionPerformed());

        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(masterSystem, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(masterSystem))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(BorderFactory.createTitledBorder(null, "Slave", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Ubuntu", 0, 14)));

        jLabel17.setFont(new Font("Ubuntu", 0, 12));
        jLabel17.setText("Slave System:");

        slaveSystem.setFont(new Font("Ubuntu", 0, 12));
        slaveSystem.setText("Yes");
        slaveSystem.addActionListener(evt -> slaveSystemActionPerformed());

        jLabel18.setFont(new Font("Ubuntu", 0, 12));
        jLabel18.setText("Master Username:");

        masterUsername.setFont(new Font("Ubuntu", 0, 12));
        masterUsername.setEnabled(false);

        jLabel19.setFont(new Font("Ubuntu", 0, 12));
        jLabel19.setText("Master World:");

        masterWorld.setFont(new Font("Ubuntu", 0, 12));
        masterWorld.setModel(new SpinnerNumberModel(1, 1, 99, 1));
        masterWorld.setEnabled(false);

        jLabel20.setFont(new Font("Ubuntu", 0, 12));
        jLabel20.setText("Master Location:");

        masterLocation.setFont(new Font("Ubuntu", 0, 12));
        masterLocation.setText("(0000, 0000, 0)");
        masterLocation.setEnabled(false);

        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20))
                                .addGap(135, 135, 135)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(masterUsername)
                                        .addComponent(slaveSystem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(masterWorld)
                                        .addComponent(masterLocation, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(slaveSystem))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(masterUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19)
                                        .addComponent(masterWorld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(masterLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(BorderFactory.createTitledBorder(null, "Transferring", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Ubuntu", 0, 14)));

        jLabel21.setFont(new Font("Ubuntu", 0, 12));
        jLabel21.setText("After this amount of time(Minutes):");

        jLabel22.setFont(new Font("Ubuntu", 0, 12));
        jLabel22.setText("After this amount of money made(GP):");

        jLabel24.setFont(new Font("Ubuntu", 0, 12));
        jLabel24.setText("Variation:");


        variation.setFont(new Font("Ubuntu", 0, 12));
        variation.setModel(new SpinnerNumberModel(0, 0, 999999999, 1));
        variation.setEnabled(false);

        transferMinutes.setFont(new Font("Ubuntu", 0, 12));
        transferMinutes.setModel(new SpinnerNumberModel(0, 0, 999999999, 1));
        transferMinutes.setMinimumSize(new Dimension(29, 22));
        transferMinutes.setName("");
        transferMinutes.setPreferredSize(new Dimension(29, 22));
        transferMinutes.setEnabled(false);

        transferMade.setFont(new Font("Ubuntu", 0, 12));
        transferMade.setModel(new SpinnerNumberModel(0, 0, 999999999, 1));
        transferMade.setEnabled(false);

        GroupLayout jPanel12Layout = new GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(transferMinutes, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(transferMade, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(variation, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21)
                                        .addComponent(transferMinutes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(transferMade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(variation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
        );

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel11, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane2.addTab("Mule System", jPanel9);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));
        jPanel6.setPreferredSize(new java.awt.Dimension(384, 161));

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel12.setText("Upgrade Pickaxe:");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel13.setText("Draw Objects:");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel15.setText("Disable Paint:");

        upgradePickaxe.setFont(new java.awt.Font("Ubuntu", 0, 12));
        upgradePickaxe.setText("Yes");
        upgradePickaxe.setFocusPainted(false);

        drawObjects.setFont(new java.awt.Font("Ubuntu", 0, 12));
        drawObjects.setText("Yes");
        drawObjects.setFocusPainted(false);

        disablePaint.setFont(new java.awt.Font("Ubuntu", 0, 12));
        disablePaint.setText("Yes");
        disablePaint.setFocusPainted(false);

        jLabel23.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel23.setText("Draw Tiles:");

        drawTiles.setFont(new java.awt.Font("Ubuntu", 0, 12));
        drawTiles.setText("Yes");

        jLabel25.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel25.setText("Draw Radius:");

        drawRadius.setFont(new java.awt.Font("Ubuntu", 0, 12));
        drawRadius.setText("Yes");

        jLabel27.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel27.setText("Switch slave back to original world:");

        switchSlaveBack.setFont(new java.awt.Font("Ubuntu", 0, 12));
        switchSlaveBack.setText("Yes");

        jLabel28.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel28.setText("Mine with pickaxe in inventory:");

        pickaxeInInventory.setFont(new java.awt.Font("Ubuntu", 0, 12));
        pickaxeInInventory.setText("Yes");

        jLabel29.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel29.setText("Level to stop:");

        levelToStop.setFont(new java.awt.Font("Ubuntu", 0, 12));
        levelToStop.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel28))
                                                .addGap(60, 60, 60)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(upgradePickaxe, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                        .addComponent(pickaxeInInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addGap(38, 38, 38)
                                                .addComponent(switchSlaveBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(152, 152, 152)
                                                .addComponent(drawObjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel25)
                                                .addGap(160, 160, 160)
                                                .addComponent(drawRadius, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(171, 171, 171)
                                                .addComponent(drawTiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel15)
                                                        .addComponent(jLabel29))
                                                .addGap(156, 156, 156)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(disablePaint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(levelToStop, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(upgradePickaxe))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel28)
                                        .addComponent(pickaxeInInventory))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(switchSlaveBack))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(drawObjects))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(drawRadius))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23)
                                        .addComponent(drawTiles))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(disablePaint))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel29)
                                        .addComponent(levelToStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(100, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Settings", jPanel2);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Level", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel30.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel30.setText("Level 1-15:");

        jLabel26.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel26.setText("Level 15-30:");

        jLabel31.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel31.setText("Level 30+:");

        ore1.setFont(new java.awt.Font("Ubuntu", 0, 12));
        ore1.setModel(new DefaultComboBoxModel<>(OreType.ore1));
        ore1.addActionListener(evt -> ore1ActionPerformed());
        ore1.setEnabled(false);

        ore2.setFont(new java.awt.Font("Ubuntu", 0, 12));
        ore2.setModel(new DefaultComboBoxModel<>(OreType.ore2));
        ore2.addActionListener(evt -> ore2ActionPerformed());
        ore2.setEnabled(false);

        ore3.setFont(new java.awt.Font("Ubuntu", 0, 12));
        ore3.setModel(new DefaultComboBoxModel<>(OreType.ore3));
        ore3.addActionListener(evt -> ore3ActionPerformed());
        ore3.setEnabled(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel30)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel31))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ore1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ore2, 0, 124, Short.MAX_VALUE)
                                        .addComponent(ore3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel30)
                                        .addComponent(ore1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel26)
                                        .addComponent(ore2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel31)
                                        .addComponent(ore3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel32.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel32.setText("Level 1-15 Location:");

        jLabel33.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel33.setText("Level 15-30 Location:");

        jLabel34.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel34.setText("Level 30+ Location:");

        location1.setFont(new java.awt.Font("Ubuntu", 0, 12));
        OreType o1 = ((OreType) ore1.getSelectedItem());
        location1.setModel(new DefaultComboBoxModel<>(o1.getLocations()));
        location1.setEnabled(false);

        location2.setFont(new java.awt.Font("Ubuntu", 0, 12));
        OreType o2 = ((OreType) ore2.getSelectedItem());
        location2.setModel(new DefaultComboBoxModel<>(o2.getLocations()));
        location2.setEnabled(false);

        location3.setFont(new java.awt.Font("Ubuntu", 0, 12));
        OreType o3 = ((OreType) ore3.getSelectedItem());
        location3.setModel(new DefaultComboBoxModel<>(o3.getLocations()));
        location3.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel32)
                                        .addComponent(jLabel33)
                                        .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(location1, 0, 124, Short.MAX_VALUE)
                                        .addComponent(location2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(location3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel32)
                                        .addComponent(location1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel33)
                                        .addComponent(location2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel34)
                                        .addComponent(location3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel35.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel35.setText("Use Progressive Mode:");

        useProgressive.setFont(new java.awt.Font("Ubuntu", 0, 12));
        useProgressive.setText("Temp Disabled");
        useProgressive.setEnabled(false);
        useProgressive.addActionListener(evt -> useProgressiveActionPerformed());

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                .addComponent(useProgressive, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel35)
                                        .addComponent(useProgressive))
                                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Progressive", jPanel13);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel36.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel36.setText("Disable ABC2 sleeps:");

        disableSleeps.setFont(new java.awt.Font("Ubuntu", 0, 12));
        disableSleeps.setText("Yes");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addComponent(disableSleeps, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel36)
                                        .addComponent(disableSleeps))
                                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(389, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ABC", jPanel17);

        jTabbedPane2.addTab("Settings", jPanel2);

        start.setFont(new java.awt.Font("Ubuntu", 0, 18));
        start.setText("Start");

        jTabbedPane2.addTab("Settings", jPanel2);

        start.setFont(new Font("Ubuntu", 0, 18));
        start.setText("Start");
        start.addActionListener(evt -> startActionPerformed());

        saveSettings.setFont(new Font("Ubuntu", 0, 12));
        saveSettings.setText("Save Settings");
        saveSettings.addActionListener(evt -> saveSettingsActionPerformed());

        loadSettings.setFont(new Font("Ubuntu", 0, 12));
        loadSettings.setText("Load Settings");
        loadSettings.addActionListener(evt -> loadSettingsActionPerformed());

        jLabel1.setIcon(new JLabel() {
            public Icon getIcon() {
                try {
                    return new ImageIcon(
                            new URL("http://i.imgur.com/IAZPBUc.png")
                    );
                } catch (MalformedURLException ignored) {
                }
                return null;
            }
        }.getIcon());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jTabbedPane2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(saveSettings)
                                                .addGap(37, 37, 37)
                                                .addComponent(start, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loadSettings)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jLabel1)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedPane2, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(start, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveSettings)
                                        .addComponent(loadSettings))
                                .addContainerGap())
        );

        pack();
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setting Vars">
    private void startActionPerformed() {
        if (radiusMine.isSelected()) {
            if (Game07.isInGame()) {
                Vars.get().radiusMine = true;
                Vars.get().oreType = ((OreType) radiusOreType.getSelectedItem());
                Vars.get().radius = Integer.parseInt(radiusAmount.getValue().toString());
                Vars.get().area = Player.getPosition();
                Vars.get().safePosition = Constants.DEFAULT_SAFE_ZONE;
            } else {
                Logging.status("For radius mining, please start the script logged in...");
                Logging.status("Stopping script...");
                AntiBan.destroy();
                Vars.get().stopScript = true;
            }
        } else {
            if (useProgressive.isSelected()) {
                Vars.get().progressiveMode = true;
                Vars.get().oreType = ((OreType) ore1.getSelectedItem());
                Vars.get().ore1 = ((OreType) ore1.getSelectedItem());
                Vars.get().ore2 = ((OreType) ore2.getSelectedItem());
                Vars.get().ore3 = ((OreType) ore3.getSelectedItem());
                Vars.get().area = ((Location) location1.getSelectedItem()).getLocation();
                Vars.get().location1 = ((Location) location1.getSelectedItem()).getLocation();
                Vars.get().location2 = ((Location) location2.getSelectedItem()).getLocation();
                Vars.get().location3 = ((Location) location3.getSelectedItem()).getLocation();
            } else {
                Vars.get().oreType = ((OreType) oreType.getSelectedItem());
                Vars.get().area = ((Location) quarryLocation.getSelectedItem()).getLocation();
                Vars.get().safePosition = ((Location) quarryLocation.getSelectedItem()).getSafePosition();
            }
        }

        if (dropGems.isSelected()) {
            Vars.get().dropGems = true;
        }

        if (worldHop.isSelected()) {
            Vars.get().worldHop = true;
            Vars.get().playersToHop = Integer.parseInt(worldHopPlayersNear.getValue().toString());
            Vars.get().worldType = ((WorldType) worldHopMode.getSelectedItem());
            if (worldHopOresAval.isSelected()) {
                Vars.get().oresHop = true;
            }
        }

        if (masterSystem.isSelected()) {
            if (Game07.isInGame()) {
                Vars.get().masterSystem = true;
                Vars.get().currentMasterPosition = Player.getPosition();
            } else {
                Logging.status("For the Master System, please start the script logged in...");
                Logging.status("Stopping script...");
                AntiBan.destroy();
                Vars.get().stopScript = true;
            }
        }

        if (slaveSystem.isSelected()) {
            Vars.get().slaveSystem = true;
            Vars.get().isSlaveSystemIsRunning = false;
            Vars.get().masterWorld = Integer.parseInt(masterWorld.getValue().toString());
            Vars.get().masterName = masterUsername.getText();
            Vars.get().masterPositon = masterLocation.getText();
            Vars.get().transferMinutes = Integer.parseInt(transferMinutes.getValue().toString());
            Vars.get().transferMade = Integer.parseInt(transferMade.getValue().toString());
            Vars.get().variation = Integer.parseInt(variation.getValue().toString());
        }

        if (disableSleeps.isSelected()) {
            Vars.get().disableSleeps = true;
        }

        if (upgradePickaxe.isSelected()) {
            Vars.get().upgradePickaxe = true;
        }

        if (pickaxeInInventory.isSelected()) {
            Vars.get().pickaxeInInventory = true;
        }

        if (switchSlaveBack.isSelected()) {
            Vars.get().switchSlaveBack = true;
        }

        if (drawObjects.isSelected()) {
            Vars.get().drawObjects = true;
        }

        if (!drawRadius.isSelected()) {
            Vars.get().drawRadius = false;
        }

        if (drawTiles.isSelected()) {
            Vars.get().drawTiles = true;
        }

        if (disablePaint.isSelected()) {
            Vars.get().disablePaint = true;
        }

        Vars.get().pickaxe = Pickaxe.BRONZE;
        Vars.get().mode = ((Mode) droppingMode.getSelectedItem());
        Vars.get().levelToStop = Integer.parseInt(levelToStop.getValue().toString());
        Vars.get().guiComplete = true;
        setVisible(false);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Listeners">
    private void radiusAmountstateChanged() {
        if (radiusMine.isSelected()) {
            Vars.get().radius = Integer.parseInt(radiusAmount.getValue().toString());
            if (Vars.get().area == null) {
                Vars.get().area = Player.getPosition();
            }
        }
    }

    private void useProgressiveActionPerformed() {
        disableLocationTab(useProgressive.isSelected());
        setProgressiveTab(useProgressive.isSelected());
    }

    private void saveSettingsActionPerformed() {
        if (settings.saveSettings()) {
            Logging.status("Successfully saved settings.");
        }
    }

    private void loadSettingsActionPerformed() {
        if (settings.loadSettings()) {
            Logging.status("Successfully loaded settings.");
        }
    }

    private void quarryLocationActionPerformed() {
        Location selectedLoc = ((Location) quarryLocation.getSelectedItem());
        oreType.setModel(new DefaultComboBoxModel<>(selectedLoc.getOreType()));
    }

    private void ore1ActionPerformed() {
        OreType o1 = ((OreType) ore1.getSelectedItem());
        location1.setModel(new DefaultComboBoxModel<>(o1.getLocations()));
    }

    private void ore2ActionPerformed() {
        OreType o2 = ((OreType) ore2.getSelectedItem());
        location2.setModel(new DefaultComboBoxModel<>(o2.getLocations()));
    }

    private void ore3ActionPerformed() {
        OreType o3 = ((OreType) ore3.getSelectedItem());
        location3.setModel(new DefaultComboBoxModel<>(o3.getLocations()));
    }

    private void worldHopActionPerformed() {
        setWorldHopTab(worldHop.isSelected());
    }

    private void radiusMineActionPerformed() {
        drawRadius.setEnabled(true);
        Vars.get().radiusMine = radiusMine.isSelected();
        setRadiusMineTab(radiusMine.isSelected());
        disableLocationTab(radiusMine.isSelected());
    }

    private void masterSystemActionPerformed() {
        if (masterSystem.isSelected()) {
            disableLocationTab(masterSystem.isSelected());
            disableDroppingTab(masterSystem.isSelected());
            disableWorldHopTab(masterSystem.isSelected());
            disableRadiusTab(masterSystem.isSelected());
            disableSlaveTab(masterSystem.isSelected());
            disableTransferringTab(masterSystem.isSelected());
            disableSettingsTab(masterSystem.isSelected());
        } else {
            disableLocationTab(masterSystem.isSelected());
            disableDroppingTab(masterSystem.isSelected());
            worldHop.setEnabled(true);
            disableRadiusTab(masterSystem.isSelected());
            slaveSystem.setEnabled(true);
            disableSettingsTab(masterSystem.isSelected());
        }
    }

    private void slaveSystemActionPerformed() {
        switchSlaveBack.setEnabled(true);
        disableMasterTab(slaveSystem.isSelected());
        setSlaveSystemTab(slaveSystem.isSelected());
    }

    public void disableLocationTab(boolean isSelected) {
        quarryLocation.setEnabled(!isSelected);
        oreType.setEnabled(!isSelected);
    }

    public void disableDroppingTab(boolean isSelected) {
        droppingMode.setEnabled(!isSelected);
        dropGems.setEnabled(!isSelected);
    }

    public void disableWorldHopTab(boolean isSelected) {
        worldHop.setEnabled(!isSelected);
        worldHopMode.setEnabled(!isSelected);
        worldHopPlayersNear.setEnabled(!isSelected);
        worldHopOresAval.setEnabled(!isSelected);
    }

    public void disableRadiusTab(boolean isSelected) {
        radiusMine.setEnabled(!isSelected);
        radiusAmount.setEnabled(!isSelected);
        radiusOreType.setEnabled(!isSelected);
    }

    public void disableMasterTab(boolean isSelected) {
        masterSystem.setEnabled(!isSelected);
    }

    public void disableSlaveTab(boolean isSelected) {
        slaveSystem.setEnabled(!isSelected);
        masterUsername.setEnabled(!isSelected);
        masterWorld.setEnabled(!isSelected);
        masterLocation.setEnabled(!isSelected);
    }

    public void disableTransferringTab(boolean isSelected) {
        variation.setEnabled(!isSelected);
        transferMinutes.setEnabled(!isSelected);
        transferMade.setEnabled(!isSelected);
    }

    public void disableSettingsTab(boolean isSelected) {
        pickaxeInInventory.setEnabled(!isSelected);
        disablePaint.setEnabled(!isSelected);
        levelToStop.setEnabled(!isSelected);
        upgradePickaxe.setEnabled(!isSelected);
        drawObjects.setEnabled(!isSelected);
        drawTiles.setEnabled(!isSelected);
    }

    public void setSlaveSystemTab(boolean isSelected) {
        masterUsername.setEnabled(isSelected);
        masterWorld.setEnabled(isSelected);
        masterLocation.setEnabled(isSelected);
        transferMinutes.setEnabled(isSelected);
        transferMade.setEnabled(isSelected);
        variation.setEnabled(isSelected);
    }

    public void setRadiusMineTab(boolean isSelected) {
        radiusAmount.setEnabled(isSelected);
        radiusOreType.setEnabled(isSelected);
    }

    public void setProgressiveTab(boolean isSelected) {
        ore1.setEnabled(isSelected);
        ore2.setEnabled(isSelected);
        ore3.setEnabled(isSelected);
        location1.setEnabled(isSelected);
        location2.setEnabled(isSelected);
        location3.setEnabled(isSelected);
    }

    public void setWorldHopTab(boolean isSelected) {
        worldHopMode.setEnabled(isSelected);
        worldHopPlayersNear.setEnabled(isSelected);
        worldHopOresAval.setEnabled(isSelected);
    }
    //</editor-fold>

}