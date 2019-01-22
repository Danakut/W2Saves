/*
 * Created by JFormDesigner on Thu Jan 03 12:33:04 CET 2019
 */

package com.dana;

import com.dana.entities.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.*;

/**
 * @author Dita Přikrylová
 */
public class MainScreen extends JFrame {
    public MainScreen() {
        initComponents();
        myInit();
    }

    private Container myContentPane;
    private SaveHandler handler;

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        mnbMenus = new JMenuBar();
        mnFile = new JMenu();
        mItemLoadFile = new JMenuItem();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("W2Saves");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[trailing]" +
            "[fill]" +
            "[right]" +
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
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JMenuBar mnbMenus;
    private JMenu mnFile;
    private JMenuItem mItemLoadFile;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void myInit() {

        myContentPane = getContentPane();
        myContentPane.setPreferredSize(new Dimension(1400, 800));
        this.pack();
        this.setLocationRelativeTo(null);

        handler = new SaveHandler();

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

        for (int i = 0; i < handler.getRangerCount(); i++) {
            displayPerson(handler.getRanger(i), i);
        }
    }


    private Path chooseSaveFile() throws FileNotFoundException {

        JFileChooser openChooser = new JFileChooser("..");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("W2 Savegames - .xml", "xml");
        openChooser.setFileFilter(filter);
        int returnVal = openChooser.showOpenDialog(myContentPane);
        if (returnVal != JFileChooser.APPROVE_OPTION) {
            throw new FileNotFoundException("Výběr souboru k nahrání zrušen uživatelem.");
        }
        Path saveFile = openChooser.getSelectedFile().toPath();

        if (!Files.exists(saveFile)) {
            JOptionPane.showMessageDialog(myContentPane, "Vybraný soubor nebyl nalezen.");
            throw new FileNotFoundException("Vybraný soubor nebyl nalezen.");
        }

        return saveFile;
    }

    private void displayPerson (Ranger person, int column) {
        myContentPane.add(new RangerPanel(person), "cell " + column + " 1");
        pack();

    }
}
