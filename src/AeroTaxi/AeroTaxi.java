package AeroTaxi;

import AeroTaxi.airplanes.Airplane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    private static final String airplanesPath = "airplanes.json";
    private static final String usersPath = "users.json";
    private static final String flightsPath = "flights.json";

    /// Arreglos estáticos
    public static final List<Airplane> airplanes = load(airplanesPath,new Airplane());
   // public static final List<User> users = load(usersPath,new User());
   // public static final List<Flight> flights = load(flightsPath,new Flight());

    private static <T> List<T> load(String path,T t)
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(AeroTaxi.airplanes);

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
