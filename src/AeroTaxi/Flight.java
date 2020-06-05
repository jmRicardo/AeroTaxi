package AeroTaxi;

import AeroTaxi.airplanes.Airplane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private List<User> users;
    private Airplane plane;
    private String date;
    private City departure;
    private City destiny;

    private boolean isDone;

    public Flight(Airplane plane, String date, City departure, City destiny) {
        this.users = new ArrayList<User>();
        this.plane = plane;
        this.date = date;
        this.departure = departure;
        this.destiny = destiny;
        this.isDone = false;
    }

    public Flight() {
    }

    public void addUser(User user)
    {
        users.add(user);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Flight{" +
                "users=" + users +
                ", plane=" + plane +
                ", date='" + date + '\'' +
                ", departure=" + departure +
                ", destiny=" + destiny +
                ", isDone=" + isDone +
                '}';
    }
}
