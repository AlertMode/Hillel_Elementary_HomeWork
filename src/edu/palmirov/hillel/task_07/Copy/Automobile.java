package edu.palmirov.hillel.task_07.Copy;

import edu.palmirov.hillel.task_07.Vehicles.Car;

public class Automobile extends Car {
    public Automobile(String vehicleType, String modelName,
                      String vehicleID, int passengersCapacity,
                      String sourceEnergyType, String steeringType,
                      int weight, int price,
                      int wheelsQuantity, int doorsQuantity,
                      String engineName, String engineID,
                      String fuelType, int fuelCapacity, int maxSpeed) {
        super(vehicleType, modelName,
                vehicleID, passengersCapacity,
                sourceEnergyType, steeringType,
                weight, price,
                wheelsQuantity, doorsQuantity,
                engineName, engineID,
                fuelType, fuelCapacity,
                maxSpeed);
    }

    @Override
    protected void setEngineID(String code) {
        super.setEngineID(code);
    }
}
