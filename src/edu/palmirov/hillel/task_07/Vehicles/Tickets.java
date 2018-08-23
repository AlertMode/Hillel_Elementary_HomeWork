package edu.palmirov.hillel.task_07.Vehicles;

public class Tickets {
    private String name;
    private int price;
    private String id;
    private boolean isChecked;

    public Tickets(String name, int price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.isChecked = false;
    }

    private void priceCheck(int value){
        if(value <= 0){
            this.price = 150;
        } else {
            this.price = value;
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    protected void check(){
        this.isChecked = true;
        System.out.println("The ticket has been checked!");
    }
}