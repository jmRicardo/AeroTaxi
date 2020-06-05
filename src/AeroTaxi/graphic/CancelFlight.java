package AeroTaxi.graphic;

import AeroTaxi.AeroTaxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CancelFlight extends JFrame {
    private JPanel root;
    private JButton backButton;
    private JButton cancelButton;
    private JTextField dniText;
    private JLabel dniLabel;
    private JLabel exampleLabel;
    private JButton searchButton;
    private JLabel isValidLabel;
    private JList flightList;

    public CancelFlight() {

        ImageIcon img = new ImageIcon(AeroTaxi.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        backButton.addActionListener(actionEvent -> {
            dispose();
            MainWindow mainwindow = new MainWindow();
        });
        dniText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                checkStatus();
            }
        });

        flightList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        flightList.setLayoutOrientation(JList.VERTICAL);
        flightList.setVisibleRowCount(-1);

        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Jane Doe");
        listModel.addElement("John Smith");
        listModel.addElement("Kathy Green");
        listModel.addElement(AeroTaxi.airplanes);

        flightList.setModel(listModel);

        
    }

    private void checkStatus(){

        if (AeroTaxi.checkDni(dniText.getText())){
            isValidLabel.setForeground(Color.green);
            isValidLabel.setText("formato valido!");
            searchButton.setEnabled(true);
        }else{
            isValidLabel.setForeground(Color.red);
            isValidLabel.setText("formato invalido!");
            searchButton.setEnabled(false);
        }
    }


}
