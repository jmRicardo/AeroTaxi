package AeroTaxi.core;

import AeroTaxi.core.airplanes.*;
import AeroTaxi.utility.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static AeroTaxi.utility.JSONUtily.loadFile;

public class AeroTaxi {

    /// Patrones
    private static final Pattern dniPattern = Pattern.compile("\\d{1,2}\\.\\d{3}\\.\\d{3}");
    private static final Pattern agePattern = Pattern.compile("\\d{2}");
    private static final Pattern datePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");

    /// Formato de Dia
    public static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    /// Arreglos estáticos
    public static final List<Airplane> airplanes = loadFile(Path.airplanesPath);
    public static final List<User> users = loadFile(Path.usersPath);
    public static final List<Flight> flights = loadFile(Path.flightsPath);


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

    public static User searchUser(String DNI)
    {
      return users.stream().filter(x -> DNI.equals(x.getDNI())).findAny().orElse(null);
    }
    public static List<Flight> searchFlyByDate(LocalDate ld)
    {
        return  flights.stream().filter(x -> x.getDate().equals(ld)).collect(Collectors.toList());
    }

    public static List<Flight> searchFlyByUser(User user)
    {
        return  flights.stream().filter(x -> x.getUsers().containsKey(user.getDNI())).collect(Collectors.toList());
    }

    /// a mejorar
    public static String moreUsedAirplane(User user)
    {
        List<Flight> list = searchFlyByUser(user);
        if (list.isEmpty())
            return "Ninguno";
        HashMap<Airplane,Integer> map = new HashMap<>();
        for (Flight l : list) {
            Airplane aux = l.getPlane();
            if (map.containsKey(aux))
                map.put(aux,map.get(aux) + 1);
            else
                map.put(aux, 1);
        }
        return map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey().toString();
    }

    public static double getTotalSpendByUser(User user)
    {
        List<Flight> list = searchFlyByUser(user);
        return  !list.isEmpty() ? list.stream().mapToDouble(x -> x.costPerUser(user)).sum() : 0 ;
    }

    public static boolean checkAirplaneCapacityPerFly(Flight flight)
    {
        int capacity = flight.getPlane().getCapacity();
        int passengers = flight.getUsers().values().stream().mapToInt(Integer::valueOf).sum();
        return passengers < capacity;
    }

    public static boolean checkValidDate(LocalDate date){
        return date.compareTo(LocalDate.now()) >= 0;
    }

    public static int calculateDistance (City departure,City destiny){
        int aux = 0;
        if ((departure == City.Buenos_Aires) && (destiny == City.Cordoba) || (departure == City.Cordoba) && (destiny == City.Buenos_Aires)){
            aux = 695;
        }
        if ((departure == City.Buenos_Aires) && (destiny == City.Santiago) || (departure == City.Santiago) && (destiny == City.Buenos_Aires)){
            aux = 1400;
        }
        if ((departure == City.Buenos_Aires) && (destiny == City.Montevideo) || (departure == City.Montevideo) && (destiny == City.Buenos_Aires)){
            aux = 950;
        }
        if ((departure == City.Cordoba) && (destiny == City.Montevideo) || (departure == City.Montevideo) && (destiny == City.Cordoba)){
            aux = 1190;
        }
        if ((departure == City.Cordoba) && (destiny == City.Santiago) || (departure == City.Santiago) && (destiny == City.Cordoba)){
            aux = 1050;
        }
        if ((departure == City.Montevideo) && (destiny == City.Santiago) || (departure == City.Santiago) && (destiny == City.Montevideo)){
            aux = 2100;
        }
        return aux;
    }


}
