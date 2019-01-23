package com.dana;

import com.dana.Exceptions.InvalidSkillValueException;
import com.dana.entities.Ranger;
import com.dana.entities.Skill;
import com.dana.entities.Trait;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangerPanel extends JPanel {


    Ranger rangerData;

    static final String[] ATTRIBUTES_IN_ORDER = {"Coordination", "Luck", "Awareness", "Strength", "Speed", "Intelligence", "Charisma"};
    Color panelTextColor = new Color(243, 144, 47);
    Color panelBackground = Color.black;
    int mainRowIndex = 0;

    private JButton btnEdit;
    private JLabel lblName;
    private JLabel lblRank;
    private JLabel lblIcon;
    private JLabel lblAP;
    private JLabel lblLevel;
    private JLabel lblCon;
    private JProgressBar prbrExp;
    private JLabel lblCombatInit;
    private JLabel lblCombatInitValue;
    private JLabel lblCombatSpeed;
    private JLabel lblCombatSpeedValue;
    private JLabel lblEvasion;
    private JLabel lblEvasionValue;

    public RangerPanel(Ranger ranger) {
        this.rangerData = ranger;

        setBackground(panelBackground);
        setLayout(new MigLayout(
            "insets 20px,hidemode 3",
            // columns
            "[grow, fill]",
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

        //---- btnEdit ----
        btnEdit = new JButton();
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        add(btnEdit, "cell 0 " + mainRowIndex++);

        //---- lblName ----
        lblName = new JLabel();
        lblName.setText(rangerData.name);
        add(lblName, "cell 0 " + mainRowIndex++);

        //---- lblRank ----
        lblRank = new JLabel();
        lblRank.setText(rangerData.getRank());
        add(lblRank, "cell 0 " + mainRowIndex++);

        //---- lblIcon ----
        ImageIcon source = new ImageIcon("/" + rangerData.portrait.toString());
        ImageIcon portraitIcon = new ImageIcon(source.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lblIcon = new JLabel();
        lblIcon.setIcon(portraitIcon);
        setPanelBorder(lblIcon, "", panelTextColor);
        add(lblIcon, "cell 0 " + mainRowIndex++);

        //---- lblLevel ----
        lblLevel = new JLabel();
        lblLevel.setText("Level " + rangerData.level);
        add(lblLevel, "cell 0 " + mainRowIndex++);

        //---- prbrExp ----
        prbrExp = new JProgressBar(rangerData.getExpToThisLevel(), rangerData.getExpToNextLevel());
        prbrExp.setValue(rangerData.exp);
        prbrExp.setStringPainted(true);
        prbrExp.setString(rangerData.exp + " /" + rangerData.getExpToNextLevel());
        add(prbrExp, "cell 0 " + mainRowIndex++);

        //---- lblCon ----
        lblCon = new JLabel();
        lblCon.setText("CON " + rangerData.currentHp + " / " + rangerData.getCon());
        add(lblCon, "cell 0 " + mainRowIndex++);

        //---- lblAP ----
        lblAP = new JLabel();
        lblAP.setText("AP " + rangerData.getAP());
        add(lblAP, "cell 0 " + mainRowIndex++);

        //---- lblCombatInit ----
        lblCombatInit = new JLabel();
        lblCombatInit.setText("Combat Initiative");
        add(lblCombatInit, "cell 0 " + mainRowIndex);

        //---- lblCombatInitValue ----
        lblCombatInitValue = new JLabel();
        lblCombatInitValue.setText(rangerData.getInitiative());
        add(lblCombatInitValue, "cell 0 " + mainRowIndex++);

        //---- lblCombatSpeed ----
        lblCombatSpeed = new JLabel();
        lblCombatSpeed.setText("Combat Speed");
        add(lblCombatSpeed, "cell 0 " + mainRowIndex);

        //---- lblCombatSpeedValue ----
        lblCombatSpeedValue = new JLabel();
        lblCombatSpeedValue.setText(rangerData.getCombatSpeed());
        add(lblCombatSpeedValue, "cell 0 " + mainRowIndex++);

        //---- lblEvasion ----
        lblEvasion = new JLabel();
        lblEvasion.setText("Evasion");
        add(lblEvasion, "cell 0 " + mainRowIndex);

        //---- lblEvasionValue ----
        lblEvasionValue = new JLabel();
        lblEvasionValue.setText(rangerData.getEvasion());
        add(lblEvasionValue, "cell 0 " + mainRowIndex++);

        add(createAttributePanel(), "cell 0 " + mainRowIndex++ );
        add(createSkillPanel(), "cell 0 " + mainRowIndex++);
        if (!rangerData.quirks.isEmpty()) {
            add(createQuirkPanel(), "cell 0 " + mainRowIndex++);
        }
        if (!rangerData.traits.isEmpty()) {
            add(createTraitPanel(), "cell 0 " + mainRowIndex++);
        }

        /*---------------coloring the components-----------*/
        setTextColor(this, panelTextColor);
        btnEdit.setForeground(new Color(203, 112, 45));
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

    private JPanel createAttributePanel() {
        JPanel pnlAttributes = new JPanel();
        pnlAttributes.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[grow, fill]" +
                        "[trailing]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        for (int rowIndex = 0; rowIndex < ATTRIBUTES_IN_ORDER.length; rowIndex++) {
            //attribute name
            JLabel attrLabel = new JLabel();
            String attribute = ATTRIBUTES_IN_ORDER[rowIndex];
            attrLabel.setText(attribute);
            pnlAttributes.add(attrLabel, "cell 0 " + rowIndex) ;

            //attribute value - can be queried for name of its corresponding attribute
            JLabel valueLabel = new JLabel();
            valueLabel.setName(attribute);
            valueLabel.setText(rangerData.getAttributeValue(attribute.toLowerCase()));
            pnlAttributes.add(valueLabel, "cell 1 " + rowIndex);
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
                "[grow, fill]" +
                        "[trailing]",
                // rows
                        "[]"));
        int rowIndex = 0;
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
                pnlSkills.add(skillLabel, "cell 0 " + rowIndex);

                JLabel valueLabel = new JLabel();
                valueLabel.setName(skill.getXmlName());
                try {
                    valueLabel.setText(calculateSkillLevelfromValue(skill.getValue()));
                } catch (InvalidSkillValueException ex) {
                    skillLabel.setText("Value of " + skill.getDisplayName() + " not parsed.");
                }

                pnlSkills.add(valueLabel, "cell 1 " + rowIndex);

                rowIndex++;
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

    private JPanel createTraitPanel() {
        JPanel pnlTraits = new JPanel();
        pnlTraits.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[grow, fill]",
                // rows
                "[]"));
        int rowIndex = 0;
        if (rangerData.traits.size() > 1) {
            Collections.sort(rangerData.traits);
        }

        for (Trait trait : rangerData.traits) {
            JLabel traitLabel = new JLabel();
            traitLabel.setText(trait.getDisplayName());
            pnlTraits.add(traitLabel, "cell 0 " + rowIndex);
            rowIndex++;
        }

        pnlTraits.setBackground(panelBackground);
        setTextColor(pnlTraits, panelTextColor);
        setPanelBorder(pnlTraits, "Traits", panelTextColor);

        return pnlTraits;
    }

    private JPanel createQuirkPanel() {
        JPanel pnlQuirks = new JPanel();
        pnlQuirks.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[grow, fill]",
                // rows
                "[]"));
        int rowIndex = 0;
        if (rangerData.quirks.size() > 1) {
            Collections.sort(rangerData.quirks);
        }

        for (Trait quirk : rangerData.quirks) {
            JLabel quirkLabel = new JLabel();
            quirkLabel.setText(quirk.getDisplayName());
            pnlQuirks.add(quirkLabel, "cell 0 " + rowIndex);
            rowIndex++;
        }

        pnlQuirks.setBackground(panelBackground);
        setTextColor(pnlQuirks, panelTextColor);
        setPanelBorder(pnlQuirks, "Quirks", panelTextColor);

        return pnlQuirks;
    }

}
