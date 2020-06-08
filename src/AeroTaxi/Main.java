package AeroTaxi;

import AeroTaxi.graphic.MainWindow;

import javax.swing.*;

public class Main {

    ///
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new MainWindow());

    }
}
