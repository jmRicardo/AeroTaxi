package AeroTaxi;

import AeroTaxi.airplanes.Airplane;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AeroTaxi {

    /// Arreglos estáticos
    private static final List<Airplane> airplanes = new ArrayList<>();;
    private static final List<User> users = new ArrayList<>();
    private static final List<Flight> flights = new ArrayList<>();

    /// Patrones
    private static final Pattern dniPattern = Pattern.compile("\\d{1,2}\\.\\d{3}\\.\\d{3}");

    /// Métodos estáticos utiles
    public static boolean checkDni(String DNI)
    {
        return dniPattern.matcher(DNI).matches();
    }
}
