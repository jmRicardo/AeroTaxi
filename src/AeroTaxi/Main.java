package AeroTaxi;

import javax.swing.*;
//hola mundo

public class Main {

    public static void main(String[] args) {

        int seba = 007;
        float gato;

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

// seba trolo