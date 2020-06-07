package AeroTaxi;

import AeroTaxi.airplanes.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import AeroTaxi.graphic.MainWindow;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AeroTaxi {

    /// Patrones
    private static final Pattern dniPattern = Pattern.compile("\\d{1,2}\\.\\d{3}\\.\\d{3}");
    private static final Pattern agePattern = Pattern.compile("\\d{2}");
    private static final Pattern datePattern = Pattern.compile("\\d{1,2}\\/\\d{1,2}\\/202\\d");

    /// Formato de Dia
    public static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /// Rutas de aceeso a archivos
    public static final String airplanesPath = "src/AeroTaxi/database/airplanes.json";
    public static final String usersPath = "src/AeroTaxi/database/users.json";
    public static final String flightsPath = "src/AeroTaxi/database/flights.json";
    public static final String logoPath = "src/AeroTaxi/images/logo2.png";
    public static final String iconPath = "src/AeroTaxi/images/aeroplano.png";


    /// Arreglos estáticos
    public static final List<Airplane> airplanes = loadFile(airplanesPath);
    public static final List<User> users = loadFile(usersPath);
    public static final List<Flight> flights = loadFile(flightsPath);

    /// Save and Load de nuestros 3 archivos en 4 funciones
    public static <T> void saveFile(String path, List<T> list)
    {
        BufferedWriter buff = null;
        try {
            buff = new BufferedWriter(new FileWriter(new File(path)));
        } catch (IOException e) {
            System.out.println("error al abrir el archivo para escritura!");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        String serialized = null;
        try {
            serialized = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            System.out.println("error al serializar!");
        }
        try {
            buff.write(serialized);
        } catch (IOException e) {
            System.out.println("error al escribir el archivo!");
        }
        try {
            buff.close();
        } catch (IOException e) {
            System.out.println("error al cerrar el archivo!");
        }
    }

    private static <T> List<T> loadFile(String path){
        List<T> list = new ArrayList<>();
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(new File(path)));
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            return list;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            list = mapper.readValue(buff, new TypeReference<ArrayList<T>>(){});
        } catch (IOException e) {
            System.out.println("Error al deserializar!");;
        }
        return list;
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
    public static List<Flight> searchFlyByDate(LocalDate ld){
        return  AeroTaxi.flights.stream().filter(x -> x.getDate().equals(ld)).collect(Collectors.toList());
    }
    public static List<Flight> searchFlyByUser(User user){
        return  AeroTaxi.flights.stream().filter(x -> x.getUsers().contains(user)).collect(Collectors.toList());
    }

    /// a mejorar
    public static String moreUsedAirplane(User user){
        List<Flight> list = searchFlyByUser(user);
        if (list==null)
            return "Ninguno";
        int gold = 0;
        int silver = 0;
        int bronze = 0;
        for (Flight l : list) {
            if (l.getPlane() instanceof Gold)
                gold++;
            if (l.getPlane() instanceof Silver)
                silver++;
            if (l.getPlane() instanceof Bronze)
                bronze++;
        }
        String result;
        if ()
        return
    }

   /* public static List<Flight> searchFlyByUser(User user) {
        List<Flight> list = new ArrayList<>();
        for (Flight flight : flights) {
            List<User> aux = flight.getUsers();
            if (aux!=null && aux.contains(user))
                 list.add(flight);
        }
        return list;
    }*/

    public static void sortFlyByDate(){
        // TODO
    }



    ///
    public static void main(String[] args) {

        System.out.println(flights);
        System.out.println(airplanes);
        System.out.println(users);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new MainWindow());

    }



}
