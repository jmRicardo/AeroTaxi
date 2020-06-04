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
    private City departure;
    private City destiny;

    private boolean isDone;

    public Flight(){}

    public Flight(Airplane plane, LocalDate date, City departure, City destiny) {
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

    public City getOrigin() {
        return departure;
    }

    public void setOrigin(City origin) {
        this.departure = origin;
    }

    public City getDestiny() {
        return destiny;
    }

    public void setDestiny(City destiny) {
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
