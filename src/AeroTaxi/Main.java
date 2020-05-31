package AeroTaxi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainwindows = new MainWindow();
            }
        });
    }
}

////// facu gay
///// 2 comentario
///// 3 comentario