/*
 * Created by JFormDesigner on Thu Jan 24 09:10:33 CET 2019
 */

package com.dana;

import java.awt.*;
import javax.swing.*;

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


}
