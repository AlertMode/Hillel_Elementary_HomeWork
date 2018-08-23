package edu.palmirov.hillel.task_07.Vehicles;

public class Car extends Vehicle {

    private int wheelsQuantity;
    private int doorsQuantity;
    private String engineName;
    private String engineID;
    private String fuelType;
    private int fuelCapacity;
    private int maxSpeed;
    private boolean doorsAreOpened;

    public Car(String vehicleType, String modelName,
               String vehicleID, int passengersCapacity,
               String sourceEnergyType, String steeringType,
               int weight, int price,
               int wheelsQuantity, int doorsQuantity,
               String engineName, String engineID,
               String fuelType, int fuelCapacity, int maxSpeed) {
        super(vehicleType, modelName,
                vehicleID, passengersCapacity,
                sourceEnergyType, steeringType,
                weight, price);
        this.wheelsQuantity = wheelsQuantity;
        this.doorsQuantity = doorsQuantity;
        this.engineName = engineName;
        this.engineID = engineID;
        this.fuelType = fuelType;
        fuelCapacityCheck(fuelCapacity);
        maxSpeedCheck(maxSpeed);
        doorsAreOpened =  false;
    }

    public int getWheelsQuantity(){
        return  wheelsQuantity;
    }

    public int getDoorsQuantity() {
        return doorsQuantity;
    }

    public String getEngineName() {
        return engineName;
    }

    public String getEngineID() {
        return engineID;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    private void fuelCapacityCheck(int value){
        if(value < 30){
            this.fuelCapacity = 30;
        }
    }

    private void maxSpeedCheck(int value){
        if(value <= 0){
            this.maxSpeed = 90;
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public boolean getDoorsAreOpened(){
        return doorsAreOpened;
    }

    @Override
    void move() {
        System.out.println("Go!");
        super.move();
    }

    @Override
    void stop() {
        System.out.println("Stop!");
        super.stop();
    }

    void openTheDoors(){
        doorsAreOpened = true;
        System.out.println("The doors are opened!");
    }

    void closeTheDoors(){
        doorsAreOpened = false;
        System.out.println("The doors are closed");
    }

    protected void setEngineID(String code){
        this.engineID = code;
    }

    public void soundHorn(){
        System.out.println("Beep! Be-e-e-e-ep!");
    }

}