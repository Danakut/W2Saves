package com.dana;

import com.dana.entities.Ranger;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RangerPanel extends JPanel {

    Ranger ranger;


    static final String[] ATTRIBUTE_ARRAY = {"coordination", "luck", "awareness", "strength", "speed", "intelligence", "charisma"};
    Color panelTextColor = new Color(243, 144, 47);
    Color panelBackground = Color.black;

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
    private JLabel lblEvasion;
    private JLabel lblEvasionValue;
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

    public RangerPanel(Ranger ranger) {
        this.ranger = ranger;

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
        lblName.setText(ranger.name);
        add(lblName, "cell 0 0");

        //---- lblRank ----
        lblRank.setText(ranger.getRank());
        add(lblRank, "cell 0 1");

        //---- lblIcon ----
        lblIcon.setText("pic here");
        add(lblIcon, "cell 0 2");

        //---- lblAP ----
        lblAP.setText("AP " + ranger.getAP());
        add(lblAP, "cell 0 3");

        //---- lblLevel ----
        lblLevel.setText("Level " + ranger.level);
        add(lblLevel, "cell 0 3");

        //---- lblCon ----
        lblCon.setText("CON " + ranger.currentHp + " / " + ranger.getCon());
        add(lblCon, "cell 0 4");

        //---- lblExp ----
        lblExp.setText("Exp " + ranger.exp + " / " + ranger.getexpToNextLevel());
        add(lblExp, "cell 0 5");

        //---- lblCombatInit ----
        lblCombatInit.setText("Combat Initiative");
        add(lblCombatInit, "cell 0 6");

        //---- lblCombatInitValue ----
        lblCombatInitValue.setText(ranger.getInitiative());
        add(lblCombatInitValue, "cell 0 6");

        //---- lblCombatSpeed ----
        lblCombatSpeed.setText("Combat Speed");
        add(lblCombatSpeed, "cell 0 7");

        //---- lblCombatSpeedValue ----
        lblCombatSpeedValue.setText(ranger.getCombatSpeed());
        add(lblCombatSpeedValue, "cell 0 7");

        //---- lblEvasion ----
        lblEvasion.setText("Evasion");
        add(lblEvasion, "cell 0 10");

        //---- lblEvasionValue ----
        lblEvasionValue.setText(ranger.getEvasion());
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

        for (int i = 0; i < ATTRIBUTE_ARRAY.length; i++) {

            //attribute name
            JLabel attrLabel = new JLabel();
            String attribute = ATTRIBUTE_ARRAY[i];
            attrLabel.setText(attribute);
            pnlAttributes.add(attrLabel, "cell 0 " + i) ;

            //attribute value - can be queried for name of its corresponding attribute
            JLabel valueLabel = new JLabel();
            valueLabel.setName(attribute);
            valueLabel.setText(ranger.getAttributeValue(attribute));
            pnlAttributes.add(valueLabel, "cell 1 " + i + ", alignx trailing" );

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
        lblEvasion = new JLabel();
        lblEvasionValue = new JLabel();
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
