package AeroTaxi;

import AeroTaxi.airplanes.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AeroTaxi {  //guille noob

    /// Patrones
    private static final Pattern dniPattern = Pattern.compile("\\d{1,2}\\.\\d{3}\\.\\d{3}");
    private static final Pattern agePattern = Pattern.compile("\\d{2}");
    private static final Pattern datePattern = Pattern.compile("\\d{1,2}\\/\\d{1,2}\\/202\\d");

    /// Rutas de aceeso a archivos
    public static final String airplanesPath = "airplanes.json";
    public static final String usersPath = "users.json";
    public static final String flightsPath = "flights.json";

    /// Adapter para usar reconocer herencia
    private static final RuntimeTypeAdapterFactory<Airplane> airplaneAdapterFactory = RuntimeTypeAdapterFactory.of(Airplane.class, "type")
            .registerSubtype(Gold.class, "Gold")
            .registerSubtype(Silver.class, "Silver")
            .registerSubtype(Bronze.class, "Bronze");

    /// Arreglos estáticos
    public static final List<Airplane> airplanes = loadAirplanes();
    public static final List<User> users = load(usersPath,User.class);
    public static final List<Flight> flights = load(flightsPath,Flight.class);

    /// Save and Load de nuestros 3 archivos en 4 funciones
    private static List<Airplane> loadAirplanes(){
        List<Airplane> airplanes = new ArrayList<>();
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(new File("airplanes.json")));
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            airplanes = mapper.readValue(buff, new TypeReference<ArrayList<Airplane>>(){});
        } catch (IOException e) {
            System.out.println("Error al deserializar!");;
        }
        return airplanes;
    }

    public static <T> List<T> load(String path,Class<T> t)
    {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(new File(path)));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            StringBuilder text = new StringBuilder();
            while (buffReader.ready()){
                text.append(buffReader.readLine());
            }
            List<T> data = gson.fromJson(text.toString(), TypeToken.getParameterized(List.class, t).getType());
            buffReader.close();
            return data;
        }catch (FileNotFoundException e){
            System.out.println("Archivo no existe!");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static <T> void save(String path,List<T> lista){
        BufferedWriter buffwriter = null;
        try {
            buffwriter = new BufferedWriter(new FileWriter(new File(path)));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String serialized = gson.toJson(lista);
            buffwriter.write(serialized);
            buffwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /// Métodos estáticos rapidos y utiles
    public static boolean checkDni(String DNI)
    {
        return dniPattern.matcher(DNI).matches();
    }
    public static boolean checkAge(String age)
    {
        return agePattern.matcher(age).matches();
    }
    public static boolean checkDate(String date)
    {
        return datePattern.matcher(date).matches();
    }
    public static User searchUser(String DNI){
      return users.stream().filter(x -> DNI.equals(x.getDNI())).findAny().orElse(null);
    }



    ///
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });

    }



}
