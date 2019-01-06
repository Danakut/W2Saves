package com.dana;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {



    public static void main( String[] args ) {
        SwingUtilities.invokeLater(App::run);
    }

    public static void run() {
        MainScreen screen = new MainScreen();
        screen.setVisible(true);
    }
}
