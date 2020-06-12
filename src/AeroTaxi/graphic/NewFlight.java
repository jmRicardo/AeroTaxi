package AeroTaxi.graphic;

import AeroTaxi.core.*;
import AeroTaxi.core.airplanes.*;
import AeroTaxi.utility.JSONUtily;
import AeroTaxi.utility.Path;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class NewFlight extends JFrame{
    private JLabel dateLabel;
    private JTextField dateField;
    private JLabel destinyLabel;
    private JComboBox origenCombo;
    private JComboBox destinyCombo;
    private JTextField companionField;
    private JButton okButton;
    private JLabel planeLabel;
    private JComboBox airplanesCombo;
    private JButton searchButton;
    private JPanel root;
    private JButton backButton;
    private JTextField totalCost;

    private List<Flight> list;
    private Flight newFlight;
    private LocalDate localDate;
    private Airplane airplane;
    private City origin,destiny;
    private User user;
    private int passengers;


    public NewFlight(User user) throws HeadlessException {


        System.out.println(user);

        list = null;
        newFlight = new Flight();
        this.user = user;
        passengers = 0;

        ImageIcon img = new ImageIcon(Path.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);;

        for (City c:City.values()){
            origenCombo.addItem(c.name());
            destinyCombo.addItem(c.name());
        }

        origenCombo.setSelectedIndex(0);
        destinyCombo.setSelectedIndex(1);
        companionField.setText("0");


        origenCombo.addActionListener(e -> {
            activeFieldsSearch(false);
            while (origenCombo.getSelectedIndex() == destinyCombo.getSelectedIndex())
                destinyCombo.setSelectedIndex(new Random().nextInt(City.values().length));
        });

        destinyCombo.addActionListener(e -> {
            activeFieldsSearch(false);
            while (origenCombo.getSelectedIndex() == destinyCombo.getSelectedIndex())
                origenCombo.setSelectedIndex(new Random().nextInt(City.values().length));
        });

        backButton.addActionListener(actionEvent -> {
            dispose();
            new MainWindow();
        });

        okButton.addActionListener(e -> {

            Flight flight;
            flight = list.stream().filter(x -> destiny.equals(x.getDestiny()) && origin.equals(x.getOrigin()) && airplane.equals(x.getPlane())).findFirst().orElse(null);

            if (flight==null){
                AeroTaxi.flights.add(newFlight);
                saveOK();
            }
            else if (AeroTaxi.checkAirplaneCapacityPerFly(flight) > passengers + 1) {
                flight.getUsers().put(user.getDNI(),1+passengers);
                saveOK();
            }
            else{
                showMessageDialog(null,"No disponemos de esa capacidad de asientos en ese Vuelo!");
            }
        });

        searchButton.addActionListener(e -> {


            list = AeroTaxi.searchFlyByDate(localDate);

            //crea e inicializa el vuelo con los parametros cargados hasta el momento ylos default
            origin = City.valueOf(Objects.requireNonNull(origenCombo.getSelectedItem()).toString());
            newFlight.setOrigin(origin);
            destiny = City.valueOf(Objects.requireNonNull(destinyCombo.getSelectedItem()).toString());
            newFlight.setDestiny(destiny);
            newFlight.addUsers(user.getDNI(),1);

            List<Airplane> delete = new ArrayList<>();
            for (Flight f : list) {
                if (!(origin.equals(f.getOrigin()) && destiny.equals(f.getDestiny())))
                    delete.add(f.getPlane());
            }
            fillAirplanes(delete);
            airplanesCombo.setSelectedIndex(0);

            if (list.stream().anyMatch(x -> x.getUsers().containsKey(user.getDNI()) && x.getOrigin().equals(origin) && x.getDestiny().equals(destiny))){
                showMessageDialog(null,"el usuario ya esta cargado en ese vuelo");
                activeFieldsSearch(false);
            }
            else{
                activeFieldsSearch(true);
                actualizeAirplane();
                actualizePassengers();
                actualizeCost();
            }
        });

        dateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                checkDateStatus();
            }
        });


        airplanesCombo.addActionListener(e -> {
            actualizeAirplane();
        });
        companionField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                actualizePassengers();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                actualizePassengers();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                actualizePassengers();
            }
        });
    }

    public void actualizeCost(){
        String totalFormated = NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                .format(calculateCost());
        totalCost.setText(totalFormated);
    }

    public void actualizeAirplane(){
        airplane = AeroTaxi.airplanes.stream().filter(x -> Objects.equals(airplanesCombo.getSelectedItem(), x.toString())).findAny().orElse(null);
        if (newFlight!=null && airplane!=null)
        {
            newFlight.setPlane(airplane);
            actualizeCost();
        }
    }

    public void actualizePassengers(){
        String text = companionField.getText();
        if (newFlight!=null && AeroTaxi.checkPassengers(text)){
            passengers = Integer.parseInt(text);
            newFlight.getUsers().computeIfPresent(user.getDNI(),(x,y) -> (1 + passengers));
            actualizeCost();
        }
    }

    public void fillAirplanes(List<Airplane> delete){
        airplanesCombo.removeAllItems();
        for (Airplane a : AeroTaxi.airplanes){  //recorre la lista de aviones para mostrar en el Box
            if (!delete.contains(a))
                airplanesCombo.addItem(a.toString());
        }
    }



    public void checkDateStatus()
    {
        String date = dateField.getText();
        boolean enabled =  AeroTaxi.checkDate(date);
        activeFieldsDate(enabled);
        activeFieldsSearch(false);
        if (enabled){
            localDate = LocalDate.parse(date,AeroTaxi.dateFormat);
            boolean valid = AeroTaxi.checkValidDate(localDate);
            if (!valid){
                showMessageDialog(null, "Fecha invalida / ya paso!");
                dateField.setText("");
                activeFieldsDate(false);
            }
            else
                newFlight.setDate(localDate);
        }
    }

    public void activeFieldsDate(Boolean enabled)
    {
        searchButton.setEnabled(enabled);
        origenCombo.setEnabled(enabled);
        destinyCombo.setEnabled(enabled);
    }
    public void activeFieldsSearch(Boolean enabled)
    {
        companionField.setEnabled(enabled);
        airplanesCombo.setEnabled(enabled);
        okButton.setEnabled(enabled);
    }

    public double calculateCost(){
        return newFlight.costPerUser(user);
    }

    private void saveOK(){
        showMessageDialog(null,"Vuelo reservado con exito!");
        JSONUtily.saveFile(Path.flightsPath,AeroTaxi.flights);
        dispose();
        new MainWindow();
    }




}
