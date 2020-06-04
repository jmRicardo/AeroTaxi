package AeroTaxi;

import AeroTaxi.airplanes.Airplane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private List<User> users;
    private Airplane plane;
    private LocalDate date;
    private int distance;
    private String departure;
    private String destiny;

    private boolean isDone;

    public Flight(){}

    public Flight(List<User> users, Airplane plane, LocalDate date, String departure, String destiny) {
        this.users = new ArrayList<User>();
        this.plane = plane;
        this.date = date;
        this.distance = calculateDistance();
        this.departure = departure;
        this.destiny = destiny;
        this.isDone = false;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Airplane getPlane() {
        return plane;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getOrigin() {
        return departure;
    }

    public void setOrigin(String origin) {
        this.departure = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int calculateDistance (){
        int aux = 0;
        if ((departure.equals("Buenos Aires") && destiny.equals("Cordoba")) || (departure.equals("Cordoba") && destiny.equals("Buenos Aires"))){
            aux = 695;
        }
        if ((departure.equals("Buenos Aires") && destiny.equals("Santiago")) || (departure.equals("Santiago") && destiny.equals("Buenos Aires"))){
            aux = 1400;
        }
        if ((departure.equals("Buenos Aires") && destiny.equals("Montevideo")) || (departure.equals("Montevideo") && destiny.equals("Buenos Aires"))){
            aux = 950;
        }
        if ((departure.equals("Cordoba") && destiny.equals("Montevideo")) || (departure.equals("Montevideo") && destiny.equals("Cordoba"))){
            aux = 1190;
        }
        if ((departure.equals("Cordoba") && destiny.equals("Santiago")) || (departure.equals("Santiago") && destiny.equals("Cordoba"))){
            aux = 1050;
        }
        if ((departure.equals("Montevideo") && destiny.equals("Santiago")) || (departure.equals("Santiago") && destiny.equals("Montevideo"))){
            aux = 2100;
        }
        return aux;
    }

    public double costOfFlight (){  //costo total de un vuelo
        return distance * plane.getCost() + (users.size() * 3500) + plane.getRate();
    }
}
