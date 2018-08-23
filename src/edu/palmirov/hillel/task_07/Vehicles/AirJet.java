package edu.palmirov.hillel.task_07.Vehicles;

public class AirJet extends Vehicle {
    private int wingspan;
    private int maxFlightDistance;
    private int maxFlightCeiling;
    private int maxSpeed;
    private boolean landingGearUp;

    public AirJet(String vehicleType, String modelName,
                  String vehicleID, int passengersCapacity,
                  String sourceEnergyType, String steeringType,
                  int weight, int price, int wingspan,
                  int maxFlightDistance, int maxFlightCeiling,
                  int maxSpeed) {
        super(vehicleType, modelName,
                vehicleID, passengersCapacity,
                sourceEnergyType, steeringType,
                weight, price);
        this.wingspan = wingspan;
        maxFlightDistanceCheck(maxFlightDistance);
        maxFlightCeilingCheck(maxFlightCeiling);
        setMaxSpeed(maxSpeed);
        this.landingGearUp = false;
    }

    private void maxFlightDistanceCheck(int value){
        if(value <= 0){
            this.maxFlightDistance = 10_000;
        } else {
            this.maxFlightDistance = value;
        }
    }

    private void maxFlightCeilingCheck(int value){
        if(value <= 0){
            this.maxFlightCeiling = 13_500;
        } else {
          this.maxFlightCeiling = value;
        }
    }

    private void setMaxSpeed(int value){
        if(value <= 0){
            this.maxSpeed = 1000;
        } else {
            this.maxSpeed = value;
        }
    }

    @Override
    void move() {
        System.out.println("Riders on the storm...");
        super.move();
    }

    @Override
    void stop() {
        System.out.println("Attention! The landing has been started!");
        super.stop();
    }

    protected void dropLandingGear(){
        landingGearUp = false;
        System.out.println("The landing gear has been drop!");
    }

    protected void raiseLandingGear(){
        landingGearUp = true;
        System.out.println("The landing gear has been raised!");
    }

    public void soundHorn(){
        System.out.println("Playing \"The Ride of Valkyries\"");
    }
}