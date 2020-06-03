package AeroTaxi;

import AeroTaxi.airplanes.Airplane;
import AeroTaxi.airplanes.Gold;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton buscarVuelosButton;
    private JPanel root;
    private JButton backButton;
    //asd
    public NewFlight() throws HeadlessException {

        ImageIcon img = new ImageIcon("aeroplano.png");
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        origenCombo.addItem("Buenos Aires");
        origenCombo.addItem("Cordoba");
        origenCombo.addItem("Santiago");
        origenCombo.addItem("Montevideo");

        for (Airplane a : AeroTaxi.airplanes) {
            airplanesCombo.addItem(a.getRate());
        }


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                MainWindow mainwindow = new MainWindow();
            }
        });

        //se espera que el combo box origen haga la accion, despues se remueve siempre los del combobox destino y seguido la series de if
        //selecciona la opcion del origen y despues se asignan los destinos correspondientes
        origenCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destinyCombo.removeAllItems();
                if (origenCombo.getSelectedItem().equals("Montevideo")) {
                    destinyCombo.addItem("Cordoba");
                    destinyCombo.addItem("Santiago");
                    destinyCombo.addItem("Buenos Aires");
                }

                if (origenCombo.getSelectedItem().equals("Buenos Aires")) {
                    destinyCombo.addItem("Cordoba");
                    destinyCombo.addItem("Santiago");
                    destinyCombo.addItem("Montevideo");
                }

                if (origenCombo.getSelectedItem().equals("Cordoba")) {
                    destinyCombo.addItem("Buenos Aires");
                    destinyCombo.addItem("Santiago");
                    destinyCombo.addItem("Montevideo");
                }

                if (origenCombo.getSelectedItem().equals("Santiago")) {
                    destinyCombo.addItem("Cordoba");
                    destinyCombo.addItem("Buenos Aires");
                    destinyCombo.addItem("Montevideo");
                }
            }

        });

        okButton.addActionListener(e -> {

                Flight flight = new Flight();
                AeroTaxi.flights.add(flight);
                AeroTaxi.save(AeroTaxi.flightsPath,AeroTaxi.flights);
        });
    }
}
