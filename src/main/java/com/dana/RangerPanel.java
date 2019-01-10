package com.dana;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RangerPanel extends JPanel {

    final Color panelTextColor = new Color(243, 144, 47);
    final Color panelBackground = Color.black;


    private JPanel pnlAttributes;

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

    public RangerPanel() {

        initComponents();
        setBackground(panelBackground);
        setLayout(new MigLayout(
            "insets 20px,hidemode 3",
            // columns
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
        add(lblName, "cell 0 0");

        //---- lblRank ----
        lblRank.setText("Technical Sergeant");
        add(lblRank, "cell 0 1");

        //---- lblIcon ----
        lblIcon.setText("pic here");
        add(lblIcon, "cell 0 2");

        //---- lblAP ----
        lblAP.setText("AP 8");
        add(lblAP, "cell 0 3");

        //---- lblLevel ----
        lblLevel.setText("Level 14");
        add(lblLevel, "cell 0 3");

        //---- lblCon ----
        lblCon.setText("CON 126 / 137");
        add(lblCon, "cell 0 4");

        //---- lblExp ----
        lblExp.setText("Exp 13 964 / 14 100");
        add(lblExp, "cell 0 5");

        //---- lblCombatInit ----
        lblCombatInit.setText("Combat Initiative");
        add(lblCombatInit, "cell 0 6");

        //---- lblCombatInitValue ----
        lblCombatInitValue.setText("10");
        add(lblCombatInitValue, "cell 0 6");

        //---- lblCombatSpeed ----
        lblCombatSpeed.setText("Combat Speed");
        add(lblCombatSpeed, "cell 0 7");

        //---- lblCombatSpeedValue ----
        lblCombatSpeedValue.setText("2.1");
        add(lblCombatSpeedValue, "cell 0 7");

        //---- lblCritChance ----
        lblCritChance.setText("Critical Chance");
        add(lblCritChance, "cell 0 8");

        //---- lblCritChanceValue ----
        lblCritChanceValue.setText("38 %");
        add(lblCritChanceValue, "cell 0 8");

        //---- lblArmor ----
        lblArmor.setText("Armor");
        add(lblArmor, "cell 0 9");

        //---- lblArmorValue ----
        lblArmorValue.setText("2");
        add(lblArmorValue, "cell 0 9");

        //---- lblEvasion ----
        lblEvasion.setText("Evasion");
        add(lblEvasion, "cell 0 10");

        //---- lblEvasionValue ----
        lblEvasionValue.setText("6 %");
        add(lblEvasionValue, "cell 0 10");




        //pnlAttributes
        pnlAttributes.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        {
            //---- lblCoordination ----
            lblCoordination.setText("Coordination");
            pnlAttributes.add(lblCoordination, "cell 0 0");

            //---- lblCoordinationValue ----
            lblCoordinationValue.setText("2");
            pnlAttributes.add(lblCoordinationValue, "cell 1 0,alignx trailing");

            //---- lblLuck ----
            lblLuck.setText("Luck");
            pnlAttributes.add(lblLuck, "cell 0 1");

            //---- lblLuckValue ----
            lblLuckValue.setText("2");
            pnlAttributes.add(lblLuckValue, "cell 1 1,alignx trailing");

            //---- lblAwareness ----
            lblAwareness.setText("Awareness");
            pnlAttributes.add(lblAwareness, "cell 0 2, growx");

            //---- lblAwarenessValue ----
            lblAwarenessValue.setText("3");
            pnlAttributes.add(lblAwarenessValue, "cell 1 2,alignx trailing");

            //---- lblStrength ----
            lblStrength.setText("Strength");
            pnlAttributes.add(lblStrength, "cell 0 3");

            //---- lblStrengthValue ----
            lblStrengthValue.setText("2");
            pnlAttributes.add(lblStrengthValue, "cell 1 3,alignx trailing");

            //---- lblSpeed ----
            lblSpeed.setText("Speed");
            pnlAttributes.add(lblSpeed, "cell 0 4");

            //---- lblSpeedValue ----
            lblSpeedValue.setText("4");
            pnlAttributes.add(lblSpeedValue, "cell 1 4,alignx trailing");

            //---- lblIntelligence ----
            lblIntelligence.setText("Intelligence");
            pnlAttributes.add(lblIntelligence, "cell 0 5");

            //---- lblIntelligenceValue ----
            lblIntelligenceValue.setText("10");
            pnlAttributes.add(lblIntelligenceValue, "cell 1 5,alignx trailing");

            //---- lblCharisma ----
            lblCharisma.setText("Charisma");
            pnlAttributes.add(lblCharisma, "cell 0 6");

            //---- lblCharismaValue ----
            lblCharismaValue.setText("6");
            pnlAttributes.add(lblCharismaValue, "cell 1 6,alignx trailing");
        }

        pnlAttributes.setBackground(panelBackground);
        setTextColor(pnlAttributes, panelTextColor);
        setPanelBorder(pnlAttributes, "Attributes", panelTextColor);
        add(pnlAttributes, "cell 0 13");

//        //---- lblSmartAss ----
//        lblSmartAss.setText("Smart Ass");
//        add(lblSmartAss, "cell 0 22");
//
//        //---- lblSmartAssValue ----
//        lblSmartAssValue.setText("6");
//        panel.add(lblSmartAssValue, "cell 0 22,alignx trailing,growx 0");
//
//        //---- lblHandguns ----
//        lblHandguns.setText("Handguns");
//        panel.add(lblHandguns, "cell 0 23");
//
//        //---- lblHandgunsValue ----
//        lblHandgunsValue.setText("6");
//        panel.add(lblHandgunsValue, "cell 0 23,alignx trailing,growx 0");
//
//        //---- lblKissAss ----
//        lblKissAss.setText("Kiss Ass");
//        panel.add(lblKissAss, "cell 0 24");
//
//        //---- lblKissAssValue ----
//        lblKissAssValue.setText("4");
//        panel.add(lblKissAssValue, "cell 0 24,alignx trailing,growx 0");
//
//        //---- lblSurgeon ----
//        lblSurgeon.setText("Surgeon");
//        panel.add(lblSurgeon, "cell 0 25");
//
//        //---- lblSurgeonlblSurgeonValue ----
//        lblSurgeonlblSurgeonValue.setText("4");
//        panel.add(lblSurgeonlblSurgeonValue, "cell 0 25,alignx trailing,growx 0");
//
//        //---- lblCompScience ----
//        lblCompScience.setText("Computer Science");
//        panel.add(lblCompScience, "cell 0 26");
//
//        //---- lblCompScienceValue ----
//        lblCompScienceValue.setText("4");
//        panel.add(lblCompScienceValue, "cell 0 26,alignx trailing,growx 0");


        setTextColor(this, panelTextColor);
    }

    private void setTextColor(JComponent container, Color textColor) {
        for (Component panelItem : container.getComponents()) {
            panelItem.setForeground(textColor);
        }
    }

    private void setPanelBorder(JComponent container, String title, Color textColor) {
        Border border = new TitledBorder(
                new LineBorder(panelTextColor, 3, true),
                title,
                TitledBorder.LEADING,
                TitledBorder.TOP,
                new Font("Noto Sans", Font.BOLD, 16),
                textColor);

        container.setBorder(border);

    }


    private void initComponents() {
        pnlAttributes = new JPanel();

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
    }

}
