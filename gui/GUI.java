package scripts.SPXAIOMiner.gui;



import org.tribot.api.General;
import org.tribot.api2007.Player;
import scripts.SPXAIOMiner.API.Game.Game.Game07;
import scripts.SPXAIOMiner.data.Variables;
import scripts.SPXAIOMiner.data.enums.Location;
import scripts.SPXAIOMiner.data.enums.Mode;
import scripts.SPXAIOMiner.data.enums.OreType;
import scripts.SPXAIOMiner.data.enums.Worlds;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class GUI extends javax.swing.JFrame {

    private Variables variables;

    public GUI(Variables variables) {
        this.variables = variables;
        initComponents();
    }

    private void initComponents() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quarryLocation = new javax.swing.JComboBox();
        oreType = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        droppingMode = new javax.swing.JComboBox();
        dropGems = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        worldHop = new javax.swing.JCheckBox();
        worldHopMode = new javax.swing.JComboBox();
        worldHopPlayersNear = new javax.swing.JSpinner();
        worldHopOresAval = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        radiusMine = new javax.swing.JCheckBox();
        radiusAmount = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        radiusOreType = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        masterSystem = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        slaveSystem = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        masterUsername = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        masterWorld = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        masterLocation = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        transferMinutes = new javax.swing.JTextField();
        transferMade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        upgradePickaxe = new javax.swing.JCheckBox();
        drawObjects = new javax.swing.JCheckBox();
        disablePaint = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        drawTiles = new javax.swing.JCheckBox();
        start = new javax.swing.JButton();
        saveSettings = new javax.swing.JButton();
        loadSettings = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24));
        jLabel1.setText("SPX AIO Miner");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel2.setText("Location:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel3.setText("Ore Type:");

        quarryLocation.setFont(new java.awt.Font("Ubuntu", 0, 12));
        quarryLocation.setModel(new javax.swing.DefaultComboBoxModel<>(Location.values()));
        quarryLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarryLocationActionPerformed(evt);
            }
        });

        oreType.setFont(new java.awt.Font("Ubuntu", 0, 12));
        Location selectedLoc = ((Location) quarryLocation.getSelectedItem());
        oreType.setModel(new javax.swing.DefaultComboBoxModel<>(selectedLoc.getOreType()));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(oreType, 0, 124, Short.MAX_VALUE)
                                        .addComponent(quarryLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(quarryLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(oreType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dropping", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel6.setText("Dropping Mode:");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel11.setText("Drop Gems:");

        droppingMode.setFont(new java.awt.Font("Ubuntu", 0, 12));
        droppingMode.setModel(new javax.swing.DefaultComboBoxModel<>(Mode.values()));

        dropGems.setFont(new java.awt.Font("Ubuntu", 0, 12));
        dropGems.setText("Yes");
        dropGems.setFocusPainted(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dropGems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(droppingMode, 0, 124, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(droppingMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(dropGems))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "World Hopping", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel7.setText("World Hopping:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel8.setText("If players in area are greater than:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel9.setText("If no ores are avalible:");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel10.setText("World Hopping Mode:");

        worldHop.setFont(new java.awt.Font("Ubuntu", 0, 12));
        worldHop.setText("Yes");
        worldHop.setFocusPainted(false);
        worldHop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                worldHopActionPerformed(evt);
            }
        });

        worldHopMode.setFont(new java.awt.Font("Ubuntu", 0, 12));
        worldHopMode.setModel(new javax.swing.DefaultComboBoxModel<>(Worlds.values()));
        worldHopMode.setEnabled(false);

        worldHopPlayersNear.setFont(new java.awt.Font("Ubuntu", 0, 12));
        worldHopPlayersNear.setModel(new javax.swing.SpinnerNumberModel(0, 0, 40, 1));
        worldHopPlayersNear.setEnabled(false);

        worldHopOresAval.setFont(new java.awt.Font("Ubuntu", 0, 12));
        worldHopOresAval.setText("Yes");
        worldHopOresAval.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel10))
                                                .addGap(112, 112, 112)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(worldHop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(worldHopMode, 0, 130, Short.MAX_VALUE)))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(worldHopPlayersNear)
                                                        .addComponent(worldHopOresAval, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(worldHop))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(worldHopMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(worldHopPlayersNear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(worldHopOresAval))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("General", jPanel1);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel4.setText("Radius Mining:");

        radiusMine.setFont(new java.awt.Font("Ubuntu", 0, 12));
        radiusMine.setText("Yes");
        radiusMine.setFocusPainted(false);
        radiusMine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiusMineActionPerformed(evt);
            }
        });

        radiusAmount.setFont(new java.awt.Font("Ubuntu", 0, 12));
        radiusAmount.setModel(new javax.swing.SpinnerNumberModel(0, 0, 40, 1));
        radiusAmount.setEnabled(false);
        radiusAmount.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radiusAmountstateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel5.setText("Radius:");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel14.setText("Ore Type:");

        radiusOreType.setFont(new java.awt.Font("Ubuntu", 0, 12));
        radiusOreType.setModel(new javax.swing.DefaultComboBoxModel<>(OreType.values()));
        radiusOreType.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                                                .addComponent(radiusMine, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(radiusAmount)
                                                        .addComponent(radiusOreType, 0, 124, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(radiusMine))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(radiusAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(radiusOreType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(303, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Radius Mining", jPanel7);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Master", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel16.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel16.setText("Master System:");

        masterSystem.setFont(new java.awt.Font("Ubuntu", 0, 12));
        masterSystem.setText("Yes");
        masterSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterSystemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(masterSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(masterSystem))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Slave", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel17.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel17.setText("Slave System:");

        slaveSystem.setFont(new java.awt.Font("Ubuntu", 0, 12));
        slaveSystem.setText("Yes");
        slaveSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slaveSystemActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel18.setText("Master Username:");

        masterUsername.setFont(new java.awt.Font("Ubuntu", 0, 12));

        jLabel19.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel19.setText("Master World:");

        masterWorld.setFont(new java.awt.Font("Ubuntu", 0, 12));
        masterWorld.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        jLabel20.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel20.setText("Master Location:");

        masterLocation.setFont(new java.awt.Font("Ubuntu", 0, 12));
        masterLocation.setText("(0000, 0000, 0)");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20))
                                .addGap(135, 135, 135)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(masterUsername)
                                        .addComponent(slaveSystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(masterWorld)
                                        .addComponent(masterLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(slaveSystem))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(masterUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19)
                                        .addComponent(masterWorld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(masterLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transferring", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14)));

        jLabel21.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel21.setText("After this amount of time(Minutes):");

        jLabel22.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel22.setText("After this amount of money made(GP):");

        transferMinutes.setFont(new java.awt.Font("Ubuntu", 0, 12));

        transferMade.setFont(new java.awt.Font("Ubuntu", 0, 12));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(transferMinutes)
                                        .addComponent(transferMade, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21)
                                        .addComponent(transferMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(transferMade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Mule System", jPanel9);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel15))
                                .addGap(137, 137, 137)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(upgradePickaxe, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                        .addComponent(drawObjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(disablePaint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(drawTiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                        .addComponent(jLabel13)
                                        .addComponent(drawObjects))
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
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(267, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Settings", jPanel2);

        start.setFont(new java.awt.Font("Ubuntu", 0, 18));
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        saveSettings.setFont(new java.awt.Font("Ubuntu", 0, 12));
        saveSettings.setText("Save Settings");
        saveSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSettingsActionPerformed(evt);
            }
        });

        loadSettings.setFont(new java.awt.Font("Ubuntu", 0, 12));
        loadSettings.setText("Load Settings");
        loadSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadSettingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(134, 134, 134))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTabbedPane2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(saveSettings)
                                                .addGap(37, 37, 37)
                                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loadSettings)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveSettings)
                                        .addComponent(loadSettings))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private boolean saveSettings() {
        try {
            if (!variables.path.exists()) {
                variables.path.createNewFile();
            }

            variables.properties.clear();

            variables.properties.put("dropGems", String.valueOf(dropGems.isSelected()));

            variables.properties.put("worldHop", String.valueOf(worldHop.isSelected()));

            variables.properties.put("worldHopOresAval", String.valueOf(worldHopOresAval.isSelected()));

            variables.properties.put("radiusMine", String.valueOf(radiusMine.isSelected()));

            variables.properties.put("masterSystem", String.valueOf(masterSystem.isSelected()));

            variables.properties.put("slaveSystem", String.valueOf(slaveSystem.isSelected()));

            variables.properties.put("upgradePickaxe", String.valueOf(upgradePickaxe.isSelected()));

            variables.properties.put("drawObjects", String.valueOf(drawObjects.isSelected()));

            variables.properties.put("drawTiles", String.valueOf(drawTiles.isSelected()));

            variables.properties.put("disablePaint", String.valueOf(disablePaint.isSelected()));

            variables.properties.put("worldHopPlayersNear", String.valueOf(worldHopPlayersNear.getValue()));

            variables.properties.put("radiusAmount", String.valueOf(radiusAmount.getValue()));

            variables.properties.put("masterWorld", String.valueOf(masterWorld.getValue()));

            variables.properties.put("quarryLocation", String.valueOf(quarryLocation.getSelectedIndex()));

            variables.properties.put("oreType", String.valueOf(oreType.getSelectedIndex()));

            variables.properties.put("droppingMode", String.valueOf(droppingMode.getSelectedIndex()));

            variables.properties.put("worldHopMode", String.valueOf(worldHopMode.getSelectedIndex()));

            variables.properties.put("radiusOreType", String.valueOf(radiusOreType.getSelectedIndex()));

            variables.properties.put("masterUsername", String.valueOf(masterUsername.getText()));

            variables.properties.put("transferMinutes", String.valueOf(transferMinutes.getText()));

            variables.properties.put("transferMade", String.valueOf(transferMade.getText()));

            variables.properties.put("masterLocation", String.valueOf(masterLocation.getText()));

            variables.properties.store(new FileOutputStream(variables.path), "Settings");

            return true;
        } catch (Exception e1) {
            General.println("Sorry, unable to save settings.");
            e1.printStackTrace();
        }
        return false;
    }

    public boolean loadSettings() {
        try {
            if (!variables.path.exists()) {
                variables.path.createNewFile();
            }

            variables.properties.load(new FileInputStream(variables.path));

            // Checkbox 1
            dropGems.setSelected(Boolean.valueOf(variables.properties.getProperty("dropGems")));

            // Checkbox 2
            worldHop.setSelected(Boolean.valueOf(variables.properties.getProperty("worldHop")));
            setWorldHopTab(worldHop.isSelected());

            // Checkbox 3
            worldHopOresAval.setSelected(Boolean.valueOf(variables.properties.getProperty("worldHopOresAval")));

            // Checkbox 4
            radiusMine.setSelected(Boolean.valueOf(variables.properties.getProperty("radiusMine")));
            if (radiusMine.isSelected()) {
                variables.radiusMine = true;
            }
            setRadiusMineTab(radiusMine.isSelected());
            disableLocationTab(radiusMine.isSelected());

            // Checkbox 5
            masterSystem.setSelected(Boolean.valueOf(variables.properties.getProperty("masterSystem")));
            disableLocationTab(masterSystem.isSelected());
            disableDroppingTab(masterSystem.isSelected());
            disableWorldHopTab(masterSystem.isSelected());
            disableRadiusTab(masterSystem.isSelected());
            disableSlaveTab(masterSystem.isSelected());
            disableTransferringTab(masterSystem.isSelected());
            disableSettingsTab(masterSystem.isSelected());

            // Checkbox 6
            slaveSystem.setSelected(Boolean.valueOf(variables.properties.getProperty("slaveSystem")));
            disableMasterTab(slaveSystem.isSelected());

            // Checkbox 7
            upgradePickaxe.setSelected(Boolean.valueOf(variables.properties.getProperty("upgradePickaxe")));

            // Checkbox 8
            drawObjects.setSelected(Boolean.valueOf(variables.properties.getProperty("drawObjects")));

            // Checkbox 9
            drawTiles.setSelected(Boolean.valueOf(variables.properties.getProperty("drawTiles")));

            // Checkbox 10
            disablePaint.setSelected(Boolean.valueOf(variables.properties.getProperty("disablePaint")));

            // Spiiner 1
            worldHopPlayersNear.setValue(Integer.parseInt(variables.properties.getProperty("worldHopPlayersNear")));

            // Spiiner 2
            radiusAmount.setValue(Integer.parseInt(variables.properties.getProperty("radiusAmount")));

            // Spiiner 3
            masterWorld.setValue(Integer.parseInt(variables.properties.getProperty("masterWorld")));

            // Combo Box 1
            quarryLocation.setSelectedIndex(Integer.parseInt(variables.properties.getProperty("quarryLocation", "0")));

            // Combo Box 2
            oreType.setSelectedIndex(Integer.parseInt(variables.properties.getProperty("oreType", "0")));

            // Combo Box 3
            droppingMode.setSelectedIndex(Integer.parseInt(variables.properties.getProperty("droppingMode", "0")));

            // Combo Box 4
            worldHopMode.setSelectedIndex(Integer.parseInt(variables.properties.getProperty("worldHopMode", "0")));

            // Combo Box 5
            radiusOreType.setSelectedIndex(Integer.parseInt(variables.properties.getProperty("radiusOreType", "0")));

            // Text Box 1
            masterUsername.setText(String.valueOf(variables.properties.getProperty("masterUsername")));

            // Text Box 2
            transferMade.setText(String.valueOf(variables.properties.getProperty("transferMade")));

            // Text Box 3
            transferMinutes.setText(String.valueOf(variables.properties.getProperty("transferMinutes")));

            // Text Box 4
            masterLocation.setText(String.valueOf(variables.properties.getProperty("masterLocation")));

            return true;
        } catch (Exception e2) {
            General.println("Sorry, unable to load settings.");
            e2.printStackTrace();
        }
        return false;
    }

    private void startActionPerformed(java.awt.event.ActionEvent evt) {
        if (dropGems.isSelected()) {
            variables.dropGems = true;
        }

        if (upgradePickaxe.isSelected()) {
            variables.upgradePickaxe = true;
        }

        if (worldHop.isSelected()) {
            variables.worldHop = true;
            variables.playersToHop = Integer.parseInt(worldHopPlayersNear.getValue().toString());
            variables.worlds = ((Worlds) worldHopMode.getSelectedItem());
            if (worldHopOresAval.isSelected()) {
                variables.oresHop = true;
            }
        }

        if (drawObjects.isSelected()) {
            variables.drawObjects = true;
        }

        if (disablePaint.isSelected()) {
            variables.disablePaint = true;
        }
        if (radiusMine.isSelected()) {
            variables.radiusMine = true;
            variables.oreType = ((OreType) radiusOreType.getSelectedItem());
            variables.radius = Integer.parseInt(radiusAmount.getValue().toString());
            if (Game07.isInGame()) {
                variables.area = Player.getPosition();
            } else {
                General.println("For radius mining, please start the script logged in...");
                General.println("Stopping script...");
                variables.stopScript = true;
            }
        } else {
            variables.oreType = ((OreType) oreType.getSelectedItem());
            variables.area = ((Location) quarryLocation.getSelectedItem()).getArea();
        }

        variables.mode = ((Mode) droppingMode.getSelectedItem());
        variables.guiComplete = true;
        setVisible(false);
    }

    private void radiusAmountstateChanged(javax.swing.event.ChangeEvent evt) {
        if (radiusMine.isSelected()) {

            variables.radius = Integer.parseInt(radiusAmount.getValue().toString());
            if (variables.area == null) {
                variables.area = Player.getPosition();
            }
        }
    }

    private void saveSettingsActionPerformed(java.awt.event.ActionEvent evt) {
        if (saveSettings()) {
            General.println("Successfully saved settings.");
        }
    }

    private void loadSettingsActionPerformed(java.awt.event.ActionEvent evt) {
        if (loadSettings()) {
            General.println("Successfully loaded settings.");
        }
    }

    private void quarryLocationActionPerformed(java.awt.event.ActionEvent evt) {
        Location selectedLoc = ((Location) quarryLocation.getSelectedItem());
        oreType.setModel(new javax.swing.DefaultComboBoxModel<>(selectedLoc.getOreType()));
    }

    private void worldHopActionPerformed(java.awt.event.ActionEvent evt) {
        setWorldHopTab(worldHop.isSelected());
    }

    private void radiusMineActionPerformed(java.awt.event.ActionEvent evt) {
        if (radiusMine.isSelected()) {
            variables.radiusMine = true;
        } else {
            variables.radiusMine = false;
        }
        setRadiusMineTab(radiusMine.isSelected());
        disableLocationTab(radiusMine.isSelected());
    }

    private void masterSystemActionPerformed(java.awt.event.ActionEvent evt) {
        disableLocationTab(masterSystem.isSelected());
        disableDroppingTab(masterSystem.isSelected());
        disableWorldHopTab(masterSystem.isSelected());
        disableRadiusTab(masterSystem.isSelected());
        disableSlaveTab(masterSystem.isSelected());
        disableTransferringTab(masterSystem.isSelected());
        disableSettingsTab(masterSystem.isSelected());
    }

    private void slaveSystemActionPerformed(java.awt.event.ActionEvent evt) {
        disableMasterTab(slaveSystem.isSelected());
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

    public void setRadiusMineTab(boolean isSelected) {
        radiusAmount.setEnabled(isSelected);
        radiusOreType.setEnabled(isSelected);
    }

    public void setWorldHopTab(boolean isSelected) {
        worldHopMode.setEnabled(isSelected);
        worldHopPlayersNear.setEnabled(isSelected);
        worldHopOresAval.setEnabled(isSelected);
    }

    private javax.swing.JCheckBox disablePaint;
    private javax.swing.JCheckBox drawObjects;
    private javax.swing.JCheckBox drawTiles;
    private javax.swing.JCheckBox dropGems;
    private javax.swing.JComboBox droppingMode;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton loadSettings;
    private javax.swing.JTextField masterLocation;
    private javax.swing.JCheckBox masterSystem;
    private javax.swing.JTextField masterUsername;
    private javax.swing.JSpinner masterWorld;
    private javax.swing.JComboBox oreType;
    JComboBox<Location> quarryLocation;
    private javax.swing.JSpinner radiusAmount;
    private javax.swing.JCheckBox radiusMine;
    private javax.swing.JComboBox radiusOreType;
    private javax.swing.JButton saveSettings;
    private javax.swing.JCheckBox slaveSystem;
    private javax.swing.JButton start;
    private javax.swing.JTextField transferMade;
    private javax.swing.JTextField transferMinutes;
    private javax.swing.JCheckBox upgradePickaxe;
    private javax.swing.JCheckBox worldHop;
    private javax.swing.JComboBox worldHopMode;
    private javax.swing.JCheckBox worldHopOresAval;
    private javax.swing.JSpinner worldHopPlayersNear;
}