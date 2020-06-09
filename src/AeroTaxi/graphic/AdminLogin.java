package AeroTaxi.graphic;

import AeroTaxi.utility.Path;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.util.Arrays;

public class AdminLogin extends JFrame {

    private JPanel root;
    private JTextField adminField;
    private JPasswordField passField;
    private JButton exitButton;
    private JLabel passLabel;
    private JLabel userLabel;
    private JButton enterButton;
    private JLabel image;
    private JPanel logoPanel;

    private char[] password;
    private String adminUser;



    public AdminLogin() {

        image.setIcon(new ImageIcon(Path.logoPath));
        ImageIcon img = new ImageIcon(Path.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        password = new char[]{'1','2','3','4'};
        adminUser = "admin";


        exitButton.addActionListener(actionEvent -> dispose());
        enterButton.addComponentListener(new ComponentAdapter() {
        });
        enterButton.addActionListener(e -> {
            if (adminField.getText().equals(adminUser) && Arrays.equals(passField.getPassword(), password)){
                dispose();
                new AdminWindow();
            }
        });
    }
}
