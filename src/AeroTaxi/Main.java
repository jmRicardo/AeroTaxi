package AeroTaxi;

import javax.swing.*;
//hola mundo

public class Main {

    public static void main(String[] args) {

        String manaGay;
        //// es cierto



        double toga;
        int seba = 007;
        int trolo;
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