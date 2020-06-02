package AeroTaxi;

import AeroTaxi.airplanes.Airplane;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AeroTaxi {

    /// Arreglos estáticos
    private static final List<Airplane> airplanes = new ArrayList<>();
    private static final List<User> users = new ArrayList<>();
    private static final List<Flight> flights = new ArrayList<>();

    /// Patrones
    private static final Pattern dniPattern = Pattern.compile("\\d{1,2}\\.\\d{3}\\.\\d{3}");
    private static final Pattern agePattern = Pattern.compile("\\d{2}");

    /// Rutas de aceeso a archivos
    public static final String airplanesPath = "airplanes.json";
    public static final String usersPath = "users.json";
    public static final String flightsPath = "flights.json";


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
