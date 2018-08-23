package edu.palmirov.hillel.task_07.Vehicles;

public abstract class Vehicle {
    private String vehicleType;
    private String modelName;
    private String vehicleID;
    private int passengersCapacity;
    private String sourceEnergyType;
    private String steeringType;
    private int weight;
    private int price;
    private boolean onTheMove;

    public Vehicle(String vehicleType, String modelName,
                   String vehicleID, int passengersCapacity,
                   String sourceEnergyType, String steeringType,
                   int weight, int price) {
        this.vehicleType = vehicleType;
        this.modelName = modelName;
        this.vehicleID = vehicleID;
        this.passengersCapacity = passengersCapacity;
        this.sourceEnergyType = sourceEnergyType;
        this.steeringType = steeringType;
        this.weight = weight;
        priceCheck(price);
    }

    public String getVehicleType(){
        return vehicleType;
    }

    public String getModelName() {
        return modelName;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public String getSourceEnergyType() {
        return sourceEnergyType;
    }

    public String getSteeringType() {
        return steeringType;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public boolean getOnTheMove(){
        return onTheMove;
    }

    void move(){
        onTheMove = true;
        System.out.println("The " + vehicleType + " : " + modelName + " is moving!");
    }

    void stop(){
        onTheMove = false;
        System.out.println("The " + vehicleType + " : " + modelName + " is stationary!");
    }

    protected void changePrice(int price){
        if(price >= 0){
            this.price = price;
        } else {
            priceCheck(price);
        }
    }

    private void priceCheck(int value){
        if(value > 0){
            this.price = Math.abs(value);
        }
    }

}