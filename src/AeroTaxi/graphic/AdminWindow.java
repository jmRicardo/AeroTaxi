package AeroTaxi.graphic;

import AeroTaxi.AeroTaxi;

import javax.swing.*;

public class AdminWindow extends JFrame {

    private JPanel root;
    private JButton exitButton;

    public AdminWindow(){

        ImageIcon img = new ImageIcon(AeroTaxi.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(800,640);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        exitButton.addActionListener(actionEvent -> dispose());
    }
}
