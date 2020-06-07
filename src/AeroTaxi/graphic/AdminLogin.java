package AeroTaxi.graphic;

import AeroTaxi.AeroTaxi;

import javax.swing.*;
import java.awt.*;

public class AdminLogin extends JFrame {

    private JPanel root;

    public AdminLogin() {

        ImageIcon img = new ImageIcon(AeroTaxi.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
