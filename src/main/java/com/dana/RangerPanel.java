package com.dana;

import com.dana.Exceptions.InvalidSkillValueException;
import com.dana.entities.Ranger;
import com.dana.entities.Skill;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangerPanel extends JPanel {

    Ranger rangerData;

    static final String[] ATTRIBUTES_IN_ORDER = {"Coordination", "Luck", "Awareness", "Strength", "Speed", "Intelligence", "Charisma"};
    Color panelTextColor = new Color(243, 144, 47);
    Color panelBackground = Color.black;

//    private JPanel pnlAttributes;

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
        this.rangerData = ranger;

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
        lblName.setText(rangerData.name);
        add(lblName, "cell 0 0");

        //---- lblRank ----
        lblRank.setText(rangerData.getRank());
        add(lblRank, "cell 0 1");

        //---- lblIcon ----
        lblIcon.setText("pic here");
        add(lblIcon, "cell 0 2");

        //---- lblAP ----
        lblAP.setText("AP " + rangerData.getAP());
        add(lblAP, "cell 0 3");

        //---- lblLevel ----
        lblLevel.setText("Level " + rangerData.level);
        add(lblLevel, "cell 0 3");

        //---- lblCon ----
        lblCon.setText("CON " + rangerData.currentHp + " / " + rangerData.getCon());
        add(lblCon, "cell 0 4");

        //---- lblExp ----
        lblExp.setText("Exp " + rangerData.exp + " / " + rangerData.getExpToNextLevel());
        add(lblExp, "cell 0 5");

        //---- lblCombatInit ----
        lblCombatInit.setText("Combat Initiative");
        add(lblCombatInit, "cell 0 6");

        //---- lblCombatInitValue ----
        lblCombatInitValue.setText(rangerData.getInitiative());
        add(lblCombatInitValue, "cell 0 6");

        //---- lblCombatSpeed ----
        lblCombatSpeed.setText("Combat Speed");
        add(lblCombatSpeed, "cell 0 7");

        //---- lblCombatSpeedValue ----
        lblCombatSpeedValue.setText(rangerData.getCombatSpeed());
        add(lblCombatSpeedValue, "cell 0 7");

        //---- lblEvasion ----
        lblEvasion.setText("Evasion");
        add(lblEvasion, "cell 0 8");

        //---- lblEvasionValue ----
        lblEvasionValue.setText(rangerData.getEvasion());
        add(lblEvasionValue, "cell 0 8");

        add(createAttributePanel(), "cell 0 9" );
        add(createSkillPanel(), "cell 0 10");

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
//        pnlAttributes = new JPanel();

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

    private JPanel createAttributePanel() {
        JPanel pnlAttributes = new JPanel();
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

        for (int i = 0; i < ATTRIBUTES_IN_ORDER.length; i++) {
            //attribute name
            JLabel attrLabel = new JLabel();
            String attribute = ATTRIBUTES_IN_ORDER[i];
            attrLabel.setText(attribute);
            pnlAttributes.add(attrLabel, "cell 0 " + i) ;

            //attribute value - can be queried for name of its corresponding attribute
            JLabel valueLabel = new JLabel();
            valueLabel.setName(attribute);
            valueLabel.setText(rangerData.getAttributeValue(attribute.toLowerCase()));
            pnlAttributes.add(valueLabel, "cell 1 " + i + ", alignx trailing" );
        }

        pnlAttributes.setBackground(panelBackground);
        setTextColor(pnlAttributes, panelTextColor);
        setPanelBorder(pnlAttributes, "Attributes", panelTextColor);

        return pnlAttributes;
    }

    private JPanel createSkillPanel() {
        JPanel pnlSkills = new JPanel();
        pnlSkills.setLayout(new MigLayout(
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
        int i = 0;
        List<Skill> skillsToSort = new ArrayList<>();

        for (String skillXmlName : Skill.SKILL_MAP.keySet()) {
            Skill skill = rangerData.getSkill(skillXmlName);
            if (skill.getValue() > 0) {
                skillsToSort.add(skill);
            }
        }
        Collections.sort(skillsToSort);

        for (Skill skill: skillsToSort) {

                JLabel skillLabel = new JLabel();
                skillLabel.setText(skill.getDisplayName());
                pnlSkills.add(skillLabel, "cell 0 " + i);

                JLabel valueLabel = new JLabel();
                valueLabel.setName(skill.getXmlName());
                try {
                    valueLabel.setText(calculateSkillLevelfromValue(skill.getValue()));
                } catch (InvalidSkillValueException ex) {
                    skillLabel.setText("Value of " + skill.getDisplayName() + " not parsed.");
                }

                pnlSkills.add(valueLabel, "cell 1 " + i + ", alignx trailing");

                i++;
        }


        pnlSkills.setBackground(panelBackground);
        setTextColor(pnlSkills, panelTextColor);
        setPanelBorder(pnlSkills, "Skills", panelTextColor);

        return pnlSkills;
    }

    private String calculateSkillLevelfromValue(int value) throws InvalidSkillValueException {

        switch (value) {
            case 2: return Integer.toString(1);
            case 4: return Integer.toString(2);
            case 6: return Integer.toString(3);
            case 10: return Integer.toString(4);
            case 14: return Integer.toString(5);
            case 18: return Integer.toString(6);
            case 24: return Integer.toString(7);
            case 30: return Integer.toString(8);
            case 36: return Integer.toString(9);
            case 44: return Integer.toString(10);
            default: throw new InvalidSkillValueException("Skill value " + value + " is not valid.");
        }
    }

}
