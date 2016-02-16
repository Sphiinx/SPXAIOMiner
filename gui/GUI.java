package scripts.SPXAIOMiner.gui;

import org.tribot.api.General;
import org.tribot.api2007.Player;
import scripts.SPXAIOMiner.API.Game.Game.Game07;
import scripts.SPXAIOMiner.AntiBan;
import scripts.SPXAIOMiner.data.Variables;
import scripts.SPXAIOMiner.data.enums.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class GUI extends JFrame {

    public Variables variables;
    private Settings settings = new Settings(this);

    public GUI(Variables variables) {
        this.variables = variables;
        initComponents();
    }

    //<editor-fold defaultstate="collapsed" desc="Variables">
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
    public JCheckBox runFromCombat;
    public JCheckBox upgradePickaxe;
    public JCheckBox worldHopOresAval;

    public JComboBox<OreType> oreType;
    public JComboBox<Mode> droppingMode;
    public JComboBox<Worlds> worldHopMode;
    public JComboBox<OreType> radiusOreType;
    public JComboBox<Location> quarryLocation;

    public JSpinner variation;
    public JSpinner masterWorld;
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
        start = new JButton();
        disablePaint = new JCheckBox();
        dropGems = new JCheckBox();
        variation = new JSpinner();
        worldHop = new JCheckBox();
        drawTiles = new JCheckBox();
        oreType = new JComboBox<>();
        loadSettings = new JButton();
        masterWorld = new JSpinner();
        radiusMine = new JCheckBox();
        saveSettings = new JButton();
        drawRadius = new JCheckBox();
        drawObjects = new JCheckBox();
        radiusAmount = new JSpinner();
        slaveSystem = new JCheckBox();
        transferMade = new JSpinner();
        masterSystem = new JCheckBox();
        disableRadius = new JCheckBox();
        runFromCombat = new JCheckBox();
        droppingMode = new JComboBox<>();
        transferMinutes = new JSpinner();
        upgradePickaxe = new JCheckBox();
        worldHopMode = new JComboBox<>();
        masterLocation = new JTextField();
        masterUsername = new JTextField();
        radiusOreType = new JComboBox<>();
        quarryLocation = new JComboBox<>();
        worldHopOresAval = new JCheckBox();
        worldHopPlayersNear = new JSpinner();
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
        jLabel9.setText("If no ores are avalible:");

        jLabel10.setFont(new Font("Ubuntu", 0, 12));
        jLabel10.setText("World Hopping Mode:");

        worldHop.setFont(new Font("Ubuntu", 0, 12));
        worldHop.setText("Yes");
        worldHop.setFocusPainted(false);
        worldHop.addActionListener(evt -> worldHopActionPerformed());

        worldHopMode.setFont(new Font("Ubuntu", 0, 12));
        worldHopMode.setModel(new DefaultComboBoxModel<>(Worlds.values()));
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

        jLabel19.setFont(new Font("Ubuntu", 0, 12));
        jLabel19.setText("Master World:");

        masterWorld.setFont(new Font("Ubuntu", 0, 12));
        masterWorld.setModel(new SpinnerNumberModel(300, 300, 399, 1));

        jLabel20.setFont(new Font("Ubuntu", 0, 12));
        jLabel20.setText("Master Location:");

        masterLocation.setFont(new Font("Ubuntu", 0, 12));
        masterLocation.setText("(0000, 0000, 0)");

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

        transferMinutes.setFont(new Font("Ubuntu", 0, 12));
        transferMinutes.setModel(new SpinnerNumberModel(1, 1, 999999999, 1));
        transferMinutes.setMinimumSize(new Dimension(29, 22));
        transferMinutes.setName("");
        transferMinutes.setPreferredSize(new Dimension(29, 22));

        transferMade.setFont(new Font("Ubuntu", 0, 12));
        transferMade.setModel(new SpinnerNumberModel(1, 1, 999999999, 1));

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

        jLabel26.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel26.setText("Run From Combat:");

        runFromCombat.setFont(new java.awt.Font("Ubuntu", 0, 12));
        runFromCombat.setText("Yes");

        jLabel25.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel25.setText("Draw Radius:");

        drawRadius.setText("Yes");

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
                                                        .addComponent(jLabel26))
                                                .addGap(127, 127, 127)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(upgradePickaxe, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                        .addComponent(runFromCombat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel25))
                                                .addGap(152, 152, 152)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(drawObjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(drawRadius, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(171, 171, 171)
                                                .addComponent(drawTiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(156, 156, 156)
                                                .addComponent(disablePaint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                        .addComponent(runFromCombat)
                                        .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(drawObjects))
                                .addGap(19, 19, 19)
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
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(184, Short.MAX_VALUE))
        );

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

    //<editor-fold defaultstate="collapsed" desc="Setting Variables">
    private void startActionPerformed() {
        if (radiusMine.isSelected()) {
            if (Game07.isInGame()) {
                variables.radiusMine = true;
                variables.oreType = ((OreType) radiusOreType.getSelectedItem());
                variables.radius = Integer.parseInt(radiusAmount.getValue().toString());
                variables.area = Player.getPosition();
            } else {
                General.println("For radius mining, please start the script logged in...");
                General.println("Stopping script...");
                AntiBan.destroy();
                variables.stopScript = true;
            }
        } else {
            variables.oreType = ((OreType) oreType.getSelectedItem());
            variables.area = ((Location) quarryLocation.getSelectedItem()).getArea();
        }

        if (dropGems.isSelected()) {
            variables.dropGems = true;
        }

        if (worldHop.isSelected()) {
            variables.worldHop = true;
            variables.playersToHop = Integer.parseInt(worldHopPlayersNear.getValue().toString());
            variables.worlds = ((Worlds) worldHopMode.getSelectedItem());
            if (worldHopOresAval.isSelected()) {
                variables.oresHop = true;
            }
        }

        if (masterSystem.isSelected()) {
            if (Game07.isInGame()) {
                variables.masterSystem = true;
                variables.currentMasterPosition = Player.getPosition();
            } else {
                General.println("For the Master System, please start the script logged in...");
                General.println("Stopping script...");
                AntiBan.destroy();
                variables.stopScript = true;
            }
        }

        if (slaveSystem.isSelected()) {
            variables.slaveSystem = true;
            variables.isSlaveSystemIsRunning = false;
            variables.masterWorld = Integer.parseInt(masterWorld.getValue().toString());
            variables.masterName = masterUsername.getText();
            variables.masterPositon = masterLocation.getText();
            variables.transferMinutes = Integer.parseInt(transferMinutes.getValue().toString());
            variables.transferMade = Integer.parseInt(transferMade.getValue().toString());
            variables.variation = Integer.parseInt(variation.getValue().toString());
        }

        if (upgradePickaxe.isSelected()) {
            variables.upgradePickaxe = true;
        }

        if (runFromCombat.isSelected()) {
            variables.runFromCombat = true;
        }

        if (drawObjects.isSelected()) {
            variables.drawObjects = true;
        }

        if (!drawRadius.isSelected()) {
            variables.drawRadius = false;
        }

        if (drawTiles.isSelected()) {
            variables.drawTiles = true;
        }

        if (disablePaint.isSelected()) {
            variables.disablePaint = true;
        }

        variables.pickaxe = Pickaxe.BRONZE;
        variables.mode = ((Mode) droppingMode.getSelectedItem());
        variables.guiComplete = true;
        setVisible(false);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Listeners">
    private void radiusAmountstateChanged() {
        if (radiusMine.isSelected()) {
            variables.radius = Integer.parseInt(radiusAmount.getValue().toString());
            if (variables.area == null) {
                variables.area = Player.getPosition();
            }
        }
    }

    private void saveSettingsActionPerformed() {
        if (settings.saveSettings()) {
            General.println("Successfully saved settings.");
        }
    }

    private void loadSettingsActionPerformed() {
        if (settings.loadSettings()) {
            General.println("Successfully loaded settings.");
        }
    }

    private void quarryLocationActionPerformed() {
        Location selectedLoc = ((Location) quarryLocation.getSelectedItem());
        oreType.setModel(new DefaultComboBoxModel<>(selectedLoc.getOreType()));
    }

    private void worldHopActionPerformed() {
        setWorldHopTab(worldHop.isSelected());
    }

    private void radiusMineActionPerformed() {
        variables.radiusMine = radiusMine.isSelected();
        setRadiusMineTab(radiusMine.isSelected());
        disableLocationTab(radiusMine.isSelected());
    }

    private void masterSystemActionPerformed() {
        disableLocationTab(masterSystem.isSelected());
        disableDroppingTab(masterSystem.isSelected());
        disableWorldHopTab(masterSystem.isSelected());
        disableRadiusTab(masterSystem.isSelected());
        disableSlaveTab(masterSystem.isSelected());
        disableTransferringTab(masterSystem.isSelected());
        disableSettingsTab(masterSystem.isSelected());
    }

    private void slaveSystemActionPerformed() {
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
        transferMinutes.setEnabled(!isSelected);
        transferMade.setEnabled(!isSelected);
    }

    public void disableSettingsTab(boolean isSelected) {
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
    }

    public void setRadiusMineTab(boolean isSelected) {
        radiusAmount.setEnabled(isSelected);
        radiusOreType.setEnabled(isSelected);
    }

    public void setWorldHopTab(boolean isSelected) {
        worldHopMode.setEnabled(isSelected);
        worldHopPlayersNear.setEnabled(isSelected);
        worldHopOresAval.setEnabled(isSelected);
    }
    //</editor-fold>

}