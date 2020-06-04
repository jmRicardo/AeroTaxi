package AeroTaxi.airplanes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bronze.class, name = "AeroTaxi.airplanes.Bronze"),
        @JsonSubTypes.Type(value = Silver.class, name = "AeroTaxi.airplanes.Silver"),
        @JsonSubTypes.Type(value = Gold.class, name = "AeroTaxi.airplanes.Gold")
})
public abstract class Airplane {

    private int fuel;
    private double cost;
    private int capacity;
    private double maxSpeed;
    private Propulsion engine;
    private int rate;

    protected Airplane(){}

    protected Airplane(int fuel, double cost, int capacity, double maxSpeed, Propulsion engine, int rate) {
        this.fuel = fuel;
        this.cost = cost;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.engine = engine;
        this.rate = rate;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Propulsion getEngine() {
        return engine;
    }

    public void setEngine(Propulsion engine) {
        this.engine = engine;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fuel=" + fuel +
                ", cost=" + cost +
                ", capacity=" + capacity +
                ", maxSpeed=" + maxSpeed +
                ", engine=" + engine +
                ", rate=" + rate +
                '}';
    }
}
