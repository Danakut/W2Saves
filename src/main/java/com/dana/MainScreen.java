/*
 * Created by JFormDesigner on Thu Jan 03 12:33:04 CET 2019
 */

package com.dana;

import javax.swing.border.*;
import com.dana.entities.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;
import java.util.List;

import net.miginfocom.swing.*;

/**
 * @author Dita Přikrylová
 */
public class MainScreen extends JFrame {
    public MainScreen() {
        initComponents();
        myInit();
    }

    Container contentPane;
    SaveHandler handler;

    private List<JPanel> listRanger;
    private List<JLabel> listName;
    private List<JLabel> listRank;
    private List<JLabel> listIcon;
    private List<JLabel> listAP;
    private List<JLabel> listLevel;
    private List<JLabel> listCon;
    private List<JLabel> listExp;
    private List<JLabel> listCombatInit;
    private List<JLabel> listCombatInitValue;
    private List<JLabel> listCombatSpeed;
    private List<JLabel> listCombatSpeedValue;
    private List<JLabel> listCritChance;
    private List<JLabel> listCritChanceValue;
    private List<JLabel> listArmor;
    private List<JLabel> listArmorValue;
    private List<JLabel> listEvasion;
    private List<JLabel> listEvasionValue;
    private List<JLabel> listCoordination;
    private List<JLabel> listCoordinationValue;
    private List<JLabel> listLuck;
    private List<JLabel> listLuckValue;
    private List<JLabel> listAwareness;
    private List<JLabel> listAwarenessValue;
    private List<JLabel> listStrength;
    private List<JLabel> listStrengthValue;
    private List<JLabel> listSpeed;
    private List<JLabel> listSpeedValue;
    private List<JLabel> listIntelligence;
    private List<JLabel> listIntelligenceValue;
    private List<JLabel> listCharisma;
    private List<JLabel> listCharismaValue;


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        mnbMenus = new JMenuBar();
        mnFile = new JMenu();
        mItemLoadFile = new JMenuItem();
        pnlRanger = new JPanel();
        lblName = new JLabel();
        lblRank = new JLabel();
        lblIcon = new JLabel();
        lblAP = new JLabel();
        lblLevel = new JLabel();
        lblCon = new JLabel();
        lblExp = new JLabel();
        lblCombatInit = new JLabel();
        lblCombatInitValue = new JLabel();
        lblCombatSpeed = new JLabel();
        lblCombatSpeedValue = new JLabel();
        lblCritChance = new JLabel();
        lblCritChanceValue = new JLabel();
        lblArmor = new JLabel();
        lblArmorValue = new JLabel();
        lblEvasion = new JLabel();
        lblEvasionValue = new JLabel();
        lblCoordination = new JLabel();
        lblCoordinationValue = new JLabel();
        lblLuck = new JLabel();
        lblLuckValue = new JLabel();
        lblAwareness = new JLabel();
        lblAwarenessValue = new JLabel();
        lblStrength = new JLabel();
        lblStrengthValue = new JLabel();
        lblSpeed = new JLabel();
        lblSpeedValue = new JLabel();
        lblIntelligence = new JLabel();
        lblIntelligenceValue = new JLabel();
        lblCharisma = new JLabel();
        lblCharismaValue = new JLabel();
        lblSmartAss = new JLabel();
        lblSmartAssValue = new JLabel();
        lblHandguns = new JLabel();
        lblHandgunsValue = new JLabel();
        lblKissAss = new JLabel();
        lblKissAssValue = new JLabel();
        lblSurgeon = new JLabel();
        lblSurgeonlblSurgeonValue = new JLabel();
        lblCompScience = new JLabel();
        lblCompScienceValue = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("W2Saves");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[top]" +
            "[]"));

        //======== mnbMenus ========
        {

            //======== mnFile ========
            {
                mnFile.setText("File");

                //---- mItemLoadFile ----
                mItemLoadFile.setText("Load Savegame into Editor");
                mItemLoadFile.addActionListener(e -> mItemLoadFileActionPerformed());
                mnFile.add(mItemLoadFile);
            }
            mnbMenus.add(mnFile);
        }
        setJMenuBar(mnbMenus);

        //======== pnlRanger ========
        {
            pnlRanger.setBackground(Color.black);
            pnlRanger.setLayout(new MigLayout(
                "insets 10px,hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- lblName ----
            lblName.setText("Alys Dorne");
            lblName.setForeground(new Color(243, 144, 47));
            lblName.setFont(lblName.getFont().deriveFont(lblName.getFont().getStyle() & ~Font.BOLD, lblName.getFont().getSize() + 10f));
            pnlRanger.add(lblName, "cell 0 0");

            //---- lblRank ----
            lblRank.setText("Technical Sergeant");
            lblRank.setFont(lblRank.getFont().deriveFont(lblRank.getFont().getStyle() | Font.BOLD));
            lblRank.setForeground(Color.orange);
            pnlRanger.add(lblRank, "cell 0 1");

            //---- lblIcon ----
            lblIcon.setText("pic here");
            lblIcon.setForeground(Color.orange);
            pnlRanger.add(lblIcon, "cell 0 2");

            //---- lblAP ----
            lblAP.setText("AP 8");
            pnlRanger.add(lblAP, "cell 0 3");

            //---- lblLevel ----
            lblLevel.setText("Level 14");
            pnlRanger.add(lblLevel, "cell 0 3");

            //---- lblCon ----
            lblCon.setText("CON 126 / 137");
            pnlRanger.add(lblCon, "cell 0 4");

            //---- lblExp ----
            lblExp.setText("Exp 13 964 / 14 100");
            pnlRanger.add(lblExp, "cell 0 5");

            //---- lblCombatInit ----
            lblCombatInit.setText("Combat Initiative");
            pnlRanger.add(lblCombatInit, "cell 0 6");

            //---- lblCombatInitValue ----
            lblCombatInitValue.setText("10");
            pnlRanger.add(lblCombatInitValue, "cell 0 6");

            //---- lblCombatSpeed ----
            lblCombatSpeed.setText("Combat Speed");
            pnlRanger.add(lblCombatSpeed, "cell 0 7");

            //---- lblCombatSpeedValue ----
            lblCombatSpeedValue.setText("2.1");
            pnlRanger.add(lblCombatSpeedValue, "cell 0 7");

            //---- lblCritChance ----
            lblCritChance.setText("Critical Chance");
            pnlRanger.add(lblCritChance, "cell 0 8");

            //---- lblCritChanceValue ----
            lblCritChanceValue.setText("38 %");
            pnlRanger.add(lblCritChanceValue, "cell 0 8");

            //---- lblArmor ----
            lblArmor.setText("Armor");
            pnlRanger.add(lblArmor, "cell 0 9");

            //---- lblArmorValue ----
            lblArmorValue.setText("2");
            pnlRanger.add(lblArmorValue, "cell 0 9");

            //---- lblEvasion ----
            lblEvasion.setText("Evasion");
            pnlRanger.add(lblEvasion, "cell 0 10");

            //---- lblEvasionValue ----
            lblEvasionValue.setText("6 %");
            pnlRanger.add(lblEvasionValue, "cell 0 10");

            //---- lblCoordination ----
            lblCoordination.setText("Coordination");
            lblCoordination.setBorder(new TitledBorder(new LineBorder(Color.orange, 3, true), "Title", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("Noto Sans", Font.BOLD, 16), Color.orange));
            pnlRanger.add(lblCoordination, "cell 0 13,growx");

            //---- lblCoordinationValue ----
            lblCoordinationValue.setText("2");
            pnlRanger.add(lblCoordinationValue, "cell 0 13,alignx trailing,growx 0");

            //---- lblLuck ----
            lblLuck.setText("Luck");
            pnlRanger.add(lblLuck, "cell 0 14");

            //---- lblLuckValue ----
            lblLuckValue.setText("2");
            pnlRanger.add(lblLuckValue, "cell 0 14,alignx trailing,growx 0");

            //---- lblAwareness ----
            lblAwareness.setText("Awareness");
            pnlRanger.add(lblAwareness, "cell 0 15");

            //---- lblAwarenessValue ----
            lblAwarenessValue.setText("3");
            pnlRanger.add(lblAwarenessValue, "cell 0 15,alignx trailing,growx 0");

            //---- lblStrength ----
            lblStrength.setText("Strength");
            pnlRanger.add(lblStrength, "cell 0 16");

            //---- lblStrengthValue ----
            lblStrengthValue.setText("2");
            pnlRanger.add(lblStrengthValue, "");

            //---- lblSpeed ----
            lblSpeed.setText("Speed");
            pnlRanger.add(lblSpeed, "cell 0 17");

            //---- lblSpeedValue ----
            lblSpeedValue.setText("4");
            pnlRanger.add(lblSpeedValue, "cell 0 17,alignx trailing,growx 0");

            //---- lblIntelligence ----
            lblIntelligence.setText("Intelligence");
            pnlRanger.add(lblIntelligence, "cell 0 18");

            //---- lblIntelligenceValue ----
            lblIntelligenceValue.setText("10");
            pnlRanger.add(lblIntelligenceValue, "cell 0 18,alignx trailing,growx 0");

            //---- lblCharisma ----
            lblCharisma.setText("Charisma");
            pnlRanger.add(lblCharisma, "cell 0 19");

            //---- lblCharismaValue ----
            lblCharismaValue.setText("6");
            pnlRanger.add(lblCharismaValue, "cell 0 19,alignx trailing,growx 0");

            //---- lblSmartAss ----
            lblSmartAss.setText("Smart Ass");
            pnlRanger.add(lblSmartAss, "cell 0 22");

            //---- lblSmartAssValue ----
            lblSmartAssValue.setText("6");
            pnlRanger.add(lblSmartAssValue, "cell 0 22,alignx trailing,growx 0");

            //---- lblHandguns ----
            lblHandguns.setText("Handguns");
            pnlRanger.add(lblHandguns, "cell 0 23");

            //---- lblHandgunsValue ----
            lblHandgunsValue.setText("6");
            pnlRanger.add(lblHandgunsValue, "cell 0 23,alignx trailing,growx 0");

            //---- lblKissAss ----
            lblKissAss.setText("Kiss Ass");
            pnlRanger.add(lblKissAss, "cell 0 24");

            //---- lblKissAssValue ----
            lblKissAssValue.setText("4");
            pnlRanger.add(lblKissAssValue, "cell 0 24,alignx trailing,growx 0");

            //---- lblSurgeon ----
            lblSurgeon.setText("Surgeon");
            pnlRanger.add(lblSurgeon, "cell 0 25");

            //---- lblSurgeonlblSurgeonValue ----
            lblSurgeonlblSurgeonValue.setText("4");
            pnlRanger.add(lblSurgeonlblSurgeonValue, "cell 0 25,alignx trailing,growx 0");

            //---- lblCompScience ----
            lblCompScience.setText("Computer Science");
            pnlRanger.add(lblCompScience, "cell 0 26");

            //---- lblCompScienceValue ----
            lblCompScienceValue.setText("4");
            pnlRanger.add(lblCompScienceValue, "cell 0 26,alignx trailing,growx 0");
        }
        contentPane.add(pnlRanger, "cell 1 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JMenuBar mnbMenus;
    private JMenu mnFile;
    private JMenuItem mItemLoadFile;
    private JPanel pnlRanger;
    private JLabel lblName;
    private JLabel lblRank;
    private JLabel lblIcon;
    private JLabel lblAP;
    private JLabel lblLevel;
    private JLabel lblCon;
    private JLabel lblExp;
    private JLabel lblCombatInit;
    private JLabel lblCombatInitValue;
    private JLabel lblCombatSpeed;
    private JLabel lblCombatSpeedValue;
    private JLabel lblCritChance;
    private JLabel lblCritChanceValue;
    private JLabel lblArmor;
    private JLabel lblArmorValue;
    private JLabel lblEvasion;
    private JLabel lblEvasionValue;
    private JLabel lblCoordination;
    private JLabel lblCoordinationValue;
    private JLabel lblLuck;
    private JLabel lblLuckValue;
    private JLabel lblAwareness;
    private JLabel lblAwarenessValue;
    private JLabel lblStrength;
    private JLabel lblStrengthValue;
    private JLabel lblSpeed;
    private JLabel lblSpeedValue;
    private JLabel lblIntelligence;
    private JLabel lblIntelligenceValue;
    private JLabel lblCharisma;
    private JLabel lblCharismaValue;
    private JLabel lblSmartAss;
    private JLabel lblSmartAssValue;
    private JLabel lblHandguns;
    private JLabel lblHandgunsValue;
    private JLabel lblKissAss;
    private JLabel lblKissAssValue;
    private JLabel lblSurgeon;
    private JLabel lblSurgeonlblSurgeonValue;
    private JLabel lblCompScience;
    private JLabel lblCompScienceValue;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void myInit() {

        contentPane = getContentPane();
        contentPane.setPreferredSize(new Dimension(1000, 800));
        initPanelVariables();
        this.pack();


        //TODO toto jsou pokusy - pozdeji vymazat
//        contentPane.add(addRangerPanel(0), "cell 2 1");
//        contentPane.add(addRangerPanel(1), "cell 3 1");
        contentPane.add(new RangerPanel(), "cell 2 1");


        pack();

        handler = new SaveHandler();
    }

    private void initPanelVariables() {
        listRanger = new ArrayList<>();
        listName = new ArrayList<>();
        listRank = new ArrayList<>();
        listIcon = new ArrayList<>();
        listAP = new ArrayList<>();
        listLevel = new ArrayList<>();
        listCon = new ArrayList<>();
        listExp = new ArrayList<>();
        listCombatInit = new ArrayList<>();
        listCombatInitValue = new ArrayList<>();
        listCombatSpeed = new ArrayList<>();
        listCombatSpeedValue = new ArrayList<>();
        listCritChance = new ArrayList<>();
        listCritChanceValue = new ArrayList<>();
        listArmor = new ArrayList<>();
        listArmorValue = new ArrayList<>();
        listEvasion = new ArrayList<>();
        listEvasionValue = new ArrayList<>();
        listCoordination = new ArrayList<>();
        listCoordinationValue = new ArrayList<>();
        listLuck = new ArrayList<>();
        listLuckValue = new ArrayList<>();
        listAwareness = new ArrayList<>();
        listAwarenessValue = new ArrayList<>();
        listStrength = new ArrayList<>();
        listStrengthValue = new ArrayList<>();
        listSpeed = new ArrayList<>();
        listSpeedValue = new ArrayList<>();
        listIntelligence = new ArrayList<>();
        listIntelligenceValue = new ArrayList<>();
        listCharisma = new ArrayList<>();
        listCharismaValue = new ArrayList<>();
    }

    //create a panel that will display Ranger information - return value must be appended to contentPane to be visible
    private JPanel addRangerPanel(int rangerIndex) {

        final Color panelTextColor = new Color(243, 144, 47);
        final Color panelBackground = Color.black;

        listRanger.add(new JPanel());
        listName.add(new JLabel());
        listRank.add(new JLabel());
        listIcon.add(new JLabel());
        listAP.add(new JLabel());
        listLevel.add(new JLabel());
        listCon.add(new JLabel());
        listExp.add(new JLabel());
        listCombatInit.add(new JLabel());
        listCombatInitValue.add(new JLabel());
        listCombatSpeed.add(new JLabel());
        listCombatSpeedValue.add(new JLabel());
        listCritChance.add(new JLabel());
        listCritChanceValue.add(new JLabel());
        listArmor.add(new JLabel());
        listArmorValue.add(new JLabel());
        listEvasion.add(new JLabel());
        listEvasionValue.add(new JLabel());
        listCoordination.add(new JLabel());
        listCoordinationValue.add(new JLabel());
        listLuck.add(new JLabel());
        listLuckValue.add(new JLabel());
        listAwareness.add(new JLabel());
        listAwarenessValue.add(new JLabel());
        listStrength.add(new JLabel());
        listStrengthValue.add(new JLabel());
        listSpeed.add(new JLabel());
        listSpeedValue.add(new JLabel());
        listIntelligence.add(new JLabel());
        listIntelligenceValue.add(new JLabel());
        listCharisma.add(new JLabel());;
        listCharismaValue.add(new JLabel());

        JPanel panel = listRanger.get(rangerIndex);
        JLabel lblName = listName.get(rangerIndex);
        JLabel lblRank = listRank.get(rangerIndex);
        JLabel lblIcon = listIcon.get(rangerIndex);
        JLabel lblAP = listAP.get(rangerIndex);
        JLabel lblLevel = listLevel.get(rangerIndex);
        JLabel lblCon = listCon.get(rangerIndex);
        JLabel lblExp = listExp.get(rangerIndex);
        JLabel lblCombatInit = listCombatInit.get(rangerIndex);
        JLabel lblCombatInitValue = listCombatInitValue.get(rangerIndex);
        JLabel lblCombatSpeed = listCombatSpeed.get(rangerIndex);
        JLabel lblCombatSpeedValue = listCombatSpeedValue.get(rangerIndex);
        JLabel lblCritChance = listCritChance.get(rangerIndex);
        JLabel lblCritChanceValue = listCritChanceValue.get(rangerIndex);
        JLabel lblArmor = listArmor.get(rangerIndex);
        JLabel lblArmorValue = listArmorValue.get(rangerIndex);
        JLabel lblEvasion = listEvasion.get(rangerIndex);
        JLabel lblEvasionValue = listEvasionValue.get(rangerIndex);
        JLabel lblCoordination = listCoordination.get(rangerIndex);
        JLabel lblCoordinationValue = listCoordinationValue.get(rangerIndex);
        JLabel lblLuck = listLuck.get(rangerIndex);
        JLabel lblLuckValue = listLuckValue.get(rangerIndex);
        JLabel lblAwareness = listAwareness.get(rangerIndex);
        JLabel lblAwarenessValue = listAwarenessValue.get(rangerIndex);
        JLabel lblStrength = listStrength.get(rangerIndex);
        JLabel lblStrengthValue = listStrengthValue.get(rangerIndex);
        JLabel lblSpeed = listSpeed.get(rangerIndex);
        JLabel lblSpeedValue = listSpeedValue.get(rangerIndex);
        JLabel lblIntelligence = listIntelligence.get(rangerIndex);
        JLabel lblIntelligenceValue = listIntelligenceValue.get(rangerIndex);
        JLabel lblCharisma = listCharisma.get(rangerIndex);
        JLabel lblCharismaValue = listCharismaValue.get(rangerIndex);


        panel.setBackground(panelBackground);
        panel.setLayout(new MigLayout(
                "hidemode 3,alignx center",
                // columns
                "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        //---- lblName ----
        lblName.setText("Alys Dorne");
        lblName.setForeground(new Color(243, 144, 47));
        lblName.setFont(lblName.getFont().deriveFont(lblName.getFont().getStyle() | Font.BOLD, lblName.getFont().getSize() + 10f));
        panel.add(lblName, "cell 0 0");

        //---- lblRank ----
        lblRank.setText("Technical Sergeant");
        lblRank.setFont(lblRank.getFont().deriveFont(lblRank.getFont().getStyle() | Font.BOLD)); //TODO this is where I'm currently add - BOLD does not apply at runtime (but shows in .jfd preview) - why??
        panel.add(lblRank, "cell 0 1");

        //---- lblIcon ----
        lblIcon.setText("pic here");
        panel.add(lblIcon, "cell 0 2");

        //---- lblAP ----
        lblAP.setText("AP 8");
        panel.add(lblAP, "cell 0 3");

        //---- lblLevel ----
        lblLevel.setText("Level 14");
        panel.add(lblLevel, "cell 0 3");

        //---- lblCon ----
        lblCon.setText("CON 126 / 137");
        panel.add(lblCon, "cell 0 4");

        //---- lblExp ----
        lblExp.setText("Exp 13 964 / 14 100");
        panel.add(lblExp, "cell 0 5");

        //---- lblCombatInit ----
        lblCombatInit.setText("Combat Initiative");
        panel.add(lblCombatInit, "cell 0 6");

        //---- lblCombatInitValue ----
        lblCombatInitValue.setText("10");
        panel.add(lblCombatInitValue, "cell 0 6");

        //---- lblCombatSpeed ----
        lblCombatSpeed.setText("Combat Speed");
        panel.add(lblCombatSpeed, "cell 0 7");

        //---- lblCombatSpeedValue ----
        lblCombatSpeedValue.setText("2.1");
        panel.add(lblCombatSpeedValue, "cell 0 7");

        //---- lblCritChance ----
        lblCritChance.setText("Critical Chance");
        panel.add(lblCritChance, "cell 0 8");

        //---- lblCritChanceValue ----
        lblCritChanceValue.setText("38 %");
        panel.add(lblCritChanceValue, "cell 0 8");

        //---- lblArmor ----
        lblArmor.setText("Armor");
        panel.add(lblArmor, "cell 0 9");

        //---- lblArmorValue ----
        lblArmorValue.setText("2");
        panel.add(lblArmorValue, "cell 0 9");

        //---- lblEvasion ----
        lblEvasion.setText("Evasion");
        panel.add(lblEvasion, "cell 0 10");

        //---- lblEvasionValue ----
        lblEvasionValue.setText("6 %");
        panel.add(lblEvasionValue, "cell 0 10");

        //---- lblCoordination ----
        lblCoordination.setText("Coordination");
        panel.add(lblCoordination, "cell 0 13");

        //---- lblCoordinationValue ----
        lblCoordinationValue.setText("2");
        panel.add(lblCoordinationValue, "cell 0 13,alignx trailing,growx 0");

        //---- lblLuck ----
        lblLuck.setText("Luck");
        panel.add(lblLuck, "cell 0 14");

        //---- lblLuckValue ----
        lblLuckValue.setText("2");
        panel.add(lblLuckValue, "cell 0 14,alignx trailing,growx 0");

        //---- lblAwareness ----
        lblAwareness.setText("Awareness");
        panel.add(lblAwareness, "cell 0 15");

        //---- lblAwarenessValue ----
        lblAwarenessValue.setText("3");
        panel.add(lblAwarenessValue, "cell 0 15,alignx trailing,growx 0");

        //---- lblStrength ----
        lblStrength.setText("Strength");
        panel.add(lblStrength, "cell 0 16");

        //---- lblStrengthValue ----
        lblStrengthValue.setText("2");
        panel.add(lblStrengthValue, "cell 0 16,alignx trailing,growx 0");

        //---- lblSpeed ----
        lblSpeed.setText("Speed");
        panel.add(lblSpeed, "cell 0 17");

        //---- lblSpeedValue ----
        lblSpeedValue.setText("4");
        panel.add(lblSpeedValue, "cell 0 17,alignx trailing,growx 0");

        //---- lblIntelligence ----
        lblIntelligence.setText("Intelligence");
        panel.add(lblIntelligence, "cell 0 18");

        //---- lblIntelligenceValue ----
        lblIntelligenceValue.setText("10");
        panel.add(lblIntelligenceValue, "cell 0 18,alignx trailing,growx 0");

        //---- lblCharisma ----
        lblCharisma.setText("Charisma");
        panel.add(lblCharisma, "cell 0 19");

        //---- lblCharismaValue ----
        lblCharismaValue.setText("6");
        panel.add(lblCharismaValue, "cell 0 19,alignx trailing,growx 0");

        //---- lblSmartAss ----
        lblSmartAss.setText("Smart Ass");
        panel.add(lblSmartAss, "cell 0 22");

        //---- lblSmartAssValue ----
        lblSmartAssValue.setText("6");
        panel.add(lblSmartAssValue, "cell 0 22,alignx trailing,growx 0");

        //---- lblHandguns ----
        lblHandguns.setText("Handguns");
        panel.add(lblHandguns, "cell 0 23");

        //---- lblHandgunsValue ----
        lblHandgunsValue.setText("6");
        panel.add(lblHandgunsValue, "cell 0 23,alignx trailing,growx 0");

        //---- lblKissAss ----
        lblKissAss.setText("Kiss Ass");
        panel.add(lblKissAss, "cell 0 24");

        //---- lblKissAssValue ----
        lblKissAssValue.setText("4");
        panel.add(lblKissAssValue, "cell 0 24,alignx trailing,growx 0");

        //---- lblSurgeon ----
        lblSurgeon.setText("Surgeon");
        panel.add(lblSurgeon, "cell 0 25");

        //---- lblSurgeonlblSurgeonValue ----
        lblSurgeonlblSurgeonValue.setText("4");
        panel.add(lblSurgeonlblSurgeonValue, "cell 0 25,alignx trailing,growx 0");

        //---- lblCompScience ----
        lblCompScience.setText("Computer Science");
        panel.add(lblCompScience, "cell 0 26");

        //---- lblCompScienceValue ----
        lblCompScienceValue.setText("4");
        panel.add(lblCompScienceValue, "cell 0 26,alignx trailing,growx 0");

        for (Component panelItem : panel.getComponents()) {
            panelItem.setForeground(panelTextColor);
        }

        return panel;
    }
    
    

    private void mItemLoadFileActionPerformed() {
        Path saveFile = null;
        try {
            saveFile = chooseSaveFile();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //ToDo show a file detail (e.g. date of save) and ask whether this is the desired file; only then open (or let user choose again)

        try {
            handler.openFile(saveFile);
            handler.init();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        displayPerson(handler.persons.get(1));
    }


    private Path chooseSaveFile() throws FileNotFoundException {

        JFileChooser openChooser = new JFileChooser("./src/resources");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("W2 Savegames - .xml", "xml");
        openChooser.setFileFilter(filter);
        int returnVal = openChooser.showOpenDialog(contentPane);
        if (returnVal != JFileChooser.APPROVE_OPTION) {
            throw new FileNotFoundException("Výběr souboru k nahrání zrušen uživatelem.");
        }
        Path saveFile = openChooser.getSelectedFile().toPath();

        if (!Files.exists(saveFile)) {
            JOptionPane.showMessageDialog(contentPane, "Vybraný soubor nebyl nalezen.");
            throw new FileNotFoundException("Vybraný soubor nebyl nalezen.");
        }

        return saveFile;
    }

    private void displayPerson (Ranger person) {

    }
}
