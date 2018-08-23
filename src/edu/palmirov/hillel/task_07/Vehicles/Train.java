package edu.palmirov.hillel.task_07.Vehicles;

public class Train extends Vehicle {
    private String railType;
    private int railWidth;
    private boolean doorsAreOpened;
    private int maxSpeed;

    public Train(String vehicleType, String modelName,
                 String vehicleID, int passengersCapacity,
                 String sourceEnergyType, String steeringType,
                 int weight, int price,
                 String railType, int railWidth,
                 int maxSpeed) {
        super(vehicleType, modelName,
                vehicleID, passengersCapacity,
                sourceEnergyType, steeringType,
                weight, price);
        this.railType = railType;
        this.railWidth = railWidth;
        doorsAreOpened = false;
        this.maxSpeed = maxSpeed;
    }

    public String getRailType() {
        return railType;
    }

    public int getRailWidth() {
        return railWidth;
    }

    public boolean getDoorsAreOpened(){
        return doorsAreOpened;
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }

    private void setRailWidth(int railWidth){
        if(railWidth <= 0){
            this.railWidth = 1250;
        } else {
            this.railWidth = railWidth;
        }
    }

    private void setMaxSpeed(int maxSpeed){
        if(maxSpeed <= 0){
            this.maxSpeed = 100;
        } else {
          this.maxSpeed = maxSpeed;
        }
    }

    @Override
    void move() {
        System.out.println("Coming to ya!");
        super.move();
    }

    @Override
    void stop() {
        System.out.println("Well, I'm waiting...");
        super.stop();
    }

    public void soundHorn(){
        System.out.println("Get the hell out of my way, you, bags of bones and flash!");
    }

    protected void openTheDoor(){
        doorsAreOpened = true;
        System.out.println("The doors are opened!");
    }

    protected void closeTheDoors(){
        doorsAreOpened = false;
        System.out.println("The doors are closed!");
    }
}