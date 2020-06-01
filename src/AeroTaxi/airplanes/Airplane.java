package AeroTaxi.airplanes;

public class Airplane {

    private int fuel;
    private double cost;
    private int capacity;
    private double maxSpeed;
    private Propulsion engine;
    private int rate;

    public Airplane(int fuel, double cost, int capacity, double maxSpeed, Propulsion engine, int rate) {
        this.fuel = fuel;
        this.cost = cost;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.engine = engine;
        this.rate = rate;
    }

    public double getCost() {
        return cost;
    }

    public int getRate() {
        return rate;
    }
}
