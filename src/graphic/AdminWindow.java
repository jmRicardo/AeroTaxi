package graphic;

import javax.swing.*;

public class AdminWindow extends JFrame {

    private JPanel root;
    private JButton exitButton;

    public AdminWindow(){

        ImageIcon img = new ImageIcon("aeroplano.png");
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
