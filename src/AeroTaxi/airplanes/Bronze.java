package AeroTaxi.airplanes;

import AeroTaxi.AeroTaxi;

public class Bronze extends Airplane{
    public Bronze(int fuel, double cost, int capacity, double maxSpeed, Propulsion engine) {
        super(fuel, cost, capacity, maxSpeed, engine, 3000);
    }
}
