package AeroTaxi.graphic;

import AeroTaxi.core.AeroTaxi;
import AeroTaxi.core.User;
import AeroTaxi.core.Flight;
import AeroTaxi.utility.JSONUtily;
import AeroTaxi.utility.Path;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

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

    private List<Flight> userFlights;
    User find = null;
    DefaultListModel listModel;

    public CancelFlight() {

        root.setBackground(SwingUtil.backgroundColor);
        backButton.setBackground(SwingUtil.buttonColor);
        cancelButton.setBackground(SwingUtil.buttonColor);
        searchButton.setBackground(SwingUtil.buttonColor);
        dniText.setBackground(SwingUtil.buttonColor);
        flightList.setBackground(SwingUtil.listBackColor);
        backButton.setForeground(SwingUtil.textColor);
        cancelButton.setForeground(SwingUtil.textColor);
        dniText.setForeground(SwingUtil.textColor);
        dniLabel.setForeground(SwingUtil.textColor);
        exampleLabel.setForeground(SwingUtil.textColor);
        searchButton.setForeground(SwingUtil.textColor);
        isValidLabel.setForeground(SwingUtil.textColor);
        flightList.setForeground(SwingUtil.textColor);





        ImageIcon img = new ImageIcon(Path.iconPath);
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

        /// lista de vuelos por DNI, la lista se actualiza y automaticamente se ve reflejada en la JList
        listModel = new DefaultListModel();
        flightList.setModel(listModel);

        searchButton.addActionListener(e -> {
            find = AeroTaxi.searchUser(dniText.getText());
            if (find == null){
                showMessageDialog(null, "El usuario no existe!");
            }
            else{
                userFlights = AeroTaxi.searchFlyByUser(find);
                for (Flight flight : userFlights) {
                    if (!flight.isDone())
                        listModel.addElement(flight);
                }
            }

        });

        cancelButton.addActionListener(e -> {
            int x = flightList.getSelectedIndex();
            Flight aux = userFlights.get(x);
            if (aux.getDate().equals(LocalDate.now())){
                showMessageDialog(null,"No se puede cancelar un vuelo con menos de 24hs de anticipación");
            }else{
                showMessageDialog(null,"Vuelvo cancelado!");
                userFlights.get(x).getUsers().remove(find.getDNI());
                JSONUtily.saveFile(Path.flightsPath,AeroTaxi.flights);
            }
            listModel.removeAllElements();

        });
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
