package AeroTaxi;

import AeroTaxi.core.AeroTaxi;
import AeroTaxi.graphic.AdminLogin;
import javax.swing.*;

public class AdminMain {

    public static void main(String[] args) {

        AeroTaxi.actualizePastFlight();

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new AdminLogin());

    }
}
