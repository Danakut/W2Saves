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
import java.util.logging.Logger;
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

    Container contentPane;
    SaveHandler handler;


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        btnOpenFile = new JButton();
        lblR1Name = new JLabel();
        lblR2Name = new JLabel();
        lblR1Icon = new JLabel();
        lblR2Icon = new JLabel();
        lblR1AP = new JLabel();
        lblR2AP = new JLabel();
        lblStatus = new JLabel();
        lblStatusResult = new JLabel();

        //======== this ========
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
            "[]"));

        //---- btnOpenFile ----
        btnOpenFile.setText("Open File");
        btnOpenFile.addActionListener(e -> btnOpenFileActionClicked());
        contentPane.add(btnOpenFile, "cell 1 0");

        //---- lblR1Name ----
        lblR1Name.setText("text");
        contentPane.add(lblR1Name, "cell 1 1");

        //---- lblR2Name ----
        lblR2Name.setText("text");
        contentPane.add(lblR2Name, "cell 2 1");

        //---- lblR1Icon ----
        lblR1Icon.setText("text");
        contentPane.add(lblR1Icon, "cell 1 2");

        //---- lblR2Icon ----
        lblR2Icon.setText("text");
        contentPane.add(lblR2Icon, "cell 2 2");

        //---- lblR1AP ----
        lblR1AP.setText("text");
        contentPane.add(lblR1AP, "cell 1 3");

        //---- lblR2AP ----
        lblR2AP.setText("text");
        contentPane.add(lblR2AP, "cell 2 3");

        //---- lblStatus ----
        lblStatus.setText("Status");
        contentPane.add(lblStatus, "cell 1 11");

        //---- lblStatusResult ----
        lblStatusResult.setText("text");
        contentPane.add(lblStatusResult, "cell 2 11");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JButton btnOpenFile;
    private JLabel lblR1Name;
    private JLabel lblR2Name;
    private JLabel lblR1Icon;
    private JLabel lblR2Icon;
    private JLabel lblR1AP;
    private JLabel lblR2AP;
    private JLabel lblStatus;
    private JLabel lblStatusResult;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void myInit() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        contentPane = getContentPane();
        contentPane.setPreferredSize(new Dimension(600, 400));
        this.pack();

        handler = new SaveHandler();
    }

    private void btnOpenFileActionClicked() {
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
        lblR1Name.setText(person.name);

    }
}
