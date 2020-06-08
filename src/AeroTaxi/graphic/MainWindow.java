package AeroTaxi.graphic;

import AeroTaxi.core.AeroTaxi;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel root;
    private JButton reserveButton;
    private JButton cancelButton;
    private JButton exitButton;
    private JLabel image;

    public MainWindow(){


        reserveButton.setForeground(SwingUtil.textColor);
        cancelButton.setForeground(SwingUtil.textColor);
        exitButton.setForeground(SwingUtil.textColor);
        image.setIcon(new ImageIcon(AeroTaxi.logoPath));
        ImageIcon img = new ImageIcon(AeroTaxi.iconPath);
        this.setIconImage(img.getImage());
         add(root);
         setResizable(false);
         setSize(300,500);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setLocationRelativeTo(null);
         setVisible(true);


        exitButton.addActionListener(actionEvent -> dispose());

        reserveButton.addActionListener(actionEvent -> {
            dispose();
            UserWindow userwindow = new UserWindow();
        });
        cancelButton.addActionListener(e -> {
            dispose();
            new CancelFlight();
        });
    }
}
