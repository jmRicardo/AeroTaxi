package AeroTaxi;

import AeroTaxi.airplanes.Airplane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class AeroTaxi {

    /// Patrones
    private static final Pattern dniPattern = Pattern.compile("\\d{1,2}\\.\\d{3}\\.\\d{3}");
    private static final Pattern agePattern = Pattern.compile("\\d{2}");

    /// Rutas de aceeso a archivos
    public static final String airplanesPath = "airplanes.json";
    public static final String usersPath = "users.json";
    public static final String flightsPath = "flights.json";

    /// Arreglos estáticos
    public static final List<Airplane> airplanes = load(airplanesPath);
    public static final List<User> users = load(usersPath);
    //public static final List<Flight> flights = load(flightsPath);

    public static <T> List<T> load(String path)
    {
        List<T> list = new ArrayList<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(new File(path)));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            StringBuilder text = new StringBuilder();
            while (buffReader.ready()){
                text.append(buffReader.readLine());
            }
            T[] data = gson.fromJson(text.toString(), (Type) Object[].class);
            Collections.addAll(list,data);
            buffReader.close();
        }catch (FileNotFoundException e){
            System.out.println("Archivo no existe!");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> void save(String path,List<T> l){
        BufferedWriter buffwriter = null;
        try {
            buffwriter = new BufferedWriter(new FileWriter(new File(path),true));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String serialized = gson.toJson(l);
            buffwriter.write(serialized);
            buffwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainwindows = new MainWindow();
            }
        });

    }


    /// Métodos estáticos utiles
    public static boolean checkDni(String DNI)
    {
        return dniPattern.matcher(DNI).matches();
    }
    public static boolean checkAge(String age)
    {
        return agePattern.matcher(age).matches();
    }

}
