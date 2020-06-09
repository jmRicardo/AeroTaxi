package AeroTaxi.graphic;

import AeroTaxi.core.AeroTaxi;
import AeroTaxi.core.Flight;
import AeroTaxi.utility.Path;

import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

public class AdminWindow extends JFrame {

    private JPanel root;
    private JButton exitButton;
    private JList usersList;
    private JList flightsList;
    private JTextField dateField;
    private JButton searchButton;
    private JTextField planeField;
    private JTextField totalField;
    private DefaultListModel users;
    private DefaultListModel flights;

    public AdminWindow(){

        ImageIcon img = new ImageIcon(Path.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(800,640);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        exitButton.addActionListener(actionEvent -> dispose());

        users = new DefaultListModel();
        flights = new DefaultListModel();

        users.addAll(AeroTaxi.users);

        usersList.setModel(users);
        flightsList.setModel(flights);

        usersList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = usersList.getSelectedIndex();
                planeField.setText(AeroTaxi.moreUsedAirplane(AeroTaxi.users.get(x)));
                double spend = AeroTaxi.getTotalSpendByUser(AeroTaxi.users.get(x));
                String spendString = NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                        .format(spend);
                totalField.setText(spendString);

            }
        });

        dateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                searchButton.setEnabled(AeroTaxi.checkDate(dateField.getText()));
            }
        });

        searchButton.addActionListener(e -> {
            flights.removeAllElements();
            LocalDate localDate;
            try{
                localDate =  LocalDate.parse(dateField.getText(),AeroTaxi.dateFormat);
                List<Flight> list = AeroTaxi.searchFlyByDate(localDate);
                if (list!=null){
                    for (Flight flight : list) {
                        flights.addElement("Fecha: "+ flight.getDate()+
                                "  Origen: "+ flight.getOrigin() +
                                "  Destino: " + flight.getDestiny() +
                                "  Avion:" + flight.getPlane().getClass().getName());
                    }
                }
            }catch (DateTimeParseException exception)
            {
                System.out.println("Fecha invalida!" + exception);
            }
        });
    }
}
