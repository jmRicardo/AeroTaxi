package AeroTaxi;

import AeroTaxi.graphic.AdminLogin;
import javax.swing.*;

public class AdminMain {

    public static void main(String[] args) {

        System.out.println(AeroTaxi.flights);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminLogin();
            }
        });

    }
}
