package AeroTaxi;

import AeroTaxi.airplanes.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.TestOnly;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
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

    private static final RuntimeTypeAdapterFactory<Airplane> airplaneAdapterFactory = RuntimeTypeAdapterFactory.of(Airplane.class, "type")
            .registerSubtype(Gold.class, "Gold")
            .registerSubtype(Silver.class, "Silver")
            .registerSubtype(Bronze.class, "Bronze");

    /// Arreglos estáticos
    public static final List<Airplane> airplanes = new ArrayList<>();
    public static final List<User> users = load(usersPath,User.class);
    public static final List<Flight> flights = load(flightsPath,Flight.class);


    public static void toJson(String path,List<Airplane> lista) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)));
            ObjectMapper mapper = new ObjectMapper();
            String serialized = mapper.writeValueAsString(lista);
            bufferedWriter.write(serialized);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Error during serialization.", e);
        }
    }

   /* public static List<Airplane> fromJson(String path) {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(new File(path)));
            ObjectMapper mapper = new ObjectMapper();
            //Airplane[] listArr = mapper.readValue(buffReader);
            List<Airplane> lista = Arrays.asList(listArr);
            buffReader.close();
            return lista;
        } catch (IOException e) {
            throw new RuntimeException("Error during deserialization.", e);
        }
    }*/

        public static List<Airplane> loadAirplanes(String path)
    {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(new File(path)));
            Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapterFactory(airplaneAdapterFactory).create();
            StringBuilder text = new StringBuilder();
            while (buffReader.ready()){
                text.append(buffReader.readLine());
            }
            Airplane[] dataArr = gson.fromJson(text.toString(), Airplane[].class);
            List<Airplane> data = Arrays.asList(dataArr);
            buffReader.close();
            return data;
        }catch (FileNotFoundException e){
            System.out.println("Archivo no existe!");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
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

    /// Métodos estáticos utiles
    public static boolean checkDni(String DNI)
    {
        return dniPattern.matcher(DNI).matches();
    }
    public static boolean checkAge(String age)
    {
        return agePattern.matcher(age).matches();
    }
    public static User searchUser(String DNI){
      return users.stream().filter(x -> DNI.equals(x.getDNI())).findAny().orElse(null);
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



}
