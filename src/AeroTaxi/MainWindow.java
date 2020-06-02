package AeroTaxi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel root;
    private JButton reserveButton;
    private JButton cancelButton;
    private JButton exitButton;
    private JLabel image;

    public MainWindow(){


        image.setIcon(new ImageIcon("logo2.png"));

        ImageIcon img = new ImageIcon("aeroplano.png");
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
    }
}
