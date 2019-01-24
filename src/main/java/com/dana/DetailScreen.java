/*
 * Created by JFormDesigner on Thu Jan 24 09:10:33 CET 2019
 */

package com.dana;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.dana.entities.Ranger;
import net.miginfocom.swing.*;

/**
 * @author Dita Přikrylová
 */
public class DetailScreen extends JPanel {

    static final String[] ATTRIBUTES_IN_ORDER = {"Coordination", "Luck", "Awareness", "Strength", "Speed", "Intelligence", "Charisma"};
    Color panelTextColor = new Color(243, 144, 47);
    Color panelBackground = Color.black;

    private Container myContentPane;
    Ranger rangerData;


    //vhodne pouzit pro tvorbu noveho rangera
    public DetailScreen() {
        initComponents();
        rangerData = new Ranger();

    }

    //vhodne pouzit pro editaci
    public DetailScreen(Ranger ranger) {
        initComponents();
        rangerData = ranger;
        myInit();


    }

    private void myInit() {
        this.remove(label1);
        this.add(createBasicPanel(), "cell 0 0");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        label6 = new JLabel();

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("basic info + derived stats");
        label1.setBackground(Color.red);
        label1.setOpaque(true);
        add(label1, "cell 0 0");

        //---- label3 ----
        label3.setText("attributes");
        label3.setBackground(Color.orange);
        label3.setOpaque(true);
        add(label3, "cell 1 0");

        //---- label5 ----
        label5.setText("skills");
        label5.setBackground(Color.magenta);
        label5.setOpaque(true);
        add(label5, "cell 2 0 1 2,growy");

        //---- label2 ----
        label2.setText("non-essential stats (e.g. ethnicity)");
        label2.setOpaque(true);
        label2.setBackground(Color.pink);
        add(label2, "cell 0 1");

        //---- label4 ----
        label4.setText("traits");
        label4.setOpaque(true);
        label4.setBackground(Color.yellow);
        add(label4, "cell 1 1");

        //---- label6 ----
        label6.setText("switch character panel");
        add(label6, "cell 0 2");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JLabel label3;
    private JLabel label5;
    private JLabel label2;
    private JLabel label4;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private JPanel createBasicPanel() {
        JPanel basicPanel = new JPanel();
        basicPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]"));
        int mainRowIndex = 0;

        //---- lblName ----
        JLabel lblName = new JLabel();
        lblName.setText(rangerData.name);
        basicPanel.add(lblName, "cell 0 " + mainRowIndex++);

        //---- lblRank ----
        JLabel lblRank = new JLabel();
        lblRank.setText(rangerData.getRank());
        basicPanel.add(lblRank, "cell 0 " + mainRowIndex++);

        //---- lblIcon ----
        ImageIcon source = new ImageIcon("/" + rangerData.portrait.toString());
        ImageIcon portraitIcon = new ImageIcon(source.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel lblIcon = new JLabel();
        lblIcon.setIcon(portraitIcon);
        setPanelBorder(lblIcon, "", panelTextColor);
        basicPanel.add(lblIcon, "cell 0 " + mainRowIndex++);

        //---- lblLevel ----
        JLabel lblLevel = new JLabel();
        lblLevel.setText("Level " + rangerData.level);
        basicPanel.add(lblLevel, "cell 0 " + mainRowIndex++);

        //---- prbrExp ----
        JProgressBar prbrExp = new JProgressBar(rangerData.getExpToThisLevel(), rangerData.getExpToNextLevel());
        prbrExp.setValue(rangerData.exp);
        prbrExp.setStringPainted(true);
        prbrExp.setString(rangerData.exp + " /" + rangerData.getExpToNextLevel());
        basicPanel.add(prbrExp, "cell 0 " + mainRowIndex++);

        //---- lblCon ----
        JLabel lblCon = new JLabel();
        lblCon.setText("CON " + rangerData.currentHp + " / " + rangerData.getCon());
        basicPanel.add(lblCon, "cell 0 " + mainRowIndex++);

        //---- lblAP ----
        JLabel lblAP = new JLabel();
        lblAP.setText("AP " + rangerData.getAP());
        basicPanel.add(lblAP, "cell 0 " + mainRowIndex++);

        //---- lblCombatInit ----
        JLabel lblCombatInit = new JLabel();
        lblCombatInit.setText("Combat Initiative");
        basicPanel.add(lblCombatInit, "cell 0 " + mainRowIndex);

        //---- lblCombatInitValue ----
        JLabel lblCombatInitValue = new JLabel();
        lblCombatInitValue.setText(rangerData.getInitiative());
        basicPanel.add(lblCombatInitValue, "cell 0 " + mainRowIndex++);

        //---- lblCombatSpeed ----
        JLabel lblCombatSpeed = new JLabel();
        lblCombatSpeed.setText("Combat Speed");
        basicPanel.add(lblCombatSpeed, "cell 0 " + mainRowIndex);

        //---- lblCombatSpeedValue ----
        JLabel lblCombatSpeedValue = new JLabel();
        lblCombatSpeedValue.setText(rangerData.getCombatSpeed());
        basicPanel.add(lblCombatSpeedValue, "cell 0 " + mainRowIndex++);

        //---- lblArmor ----
        JLabel lblArmor = new JLabel();
        lblArmor.setText("Armor");
        basicPanel.add(lblArmor, "cell 0 " + mainRowIndex);

        //---- lblArmorValue ----
        JLabel lblArmorValue = new JLabel();
        lblArmorValue.setText("0"); //TODO will be replaced with actual armor value when it is possible to calculate
        basicPanel.add(lblArmorValue, "cell 0 " + mainRowIndex++);


        //---- lblEvasion ----
        JLabel lblEvasion = new JLabel();
        lblEvasion.setText("Evasion");
        basicPanel.add(lblEvasion, "cell 0 " + mainRowIndex);

        //---- lblEvasionValue ----
        JLabel lblEvasionValue = new JLabel();
        lblEvasionValue.setText(rangerData.getEvasion());
        basicPanel.add(lblEvasionValue, "cell 0 " + mainRowIndex++);

        return basicPanel;
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

}
