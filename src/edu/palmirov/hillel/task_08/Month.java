package edu.palmirov.hillel.task_08;

/*
The given class is created in order to analyze the
input month's index and a year, and than return a 'String' message.
*/

public enum Month {
    JAN("January", 31),
    FEB("February", 0),
    MAR("March", 31),
    APR("April", 30),
    MAY("May", 31),
    JUN("June", 30),
    JUL("July", 31),
    AUG("August", 31),
    SEPT("September", 30),
    OCT("October", 31),
    NOV("November", 30),
    DEC("December", 31);

    private String name;
    private int days;

    Month(String name, int days){
        //The custom class constructor.
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public void setFeb(int number){
        if(number == 29){
            FEB.days = number;
        } else if (number == 28){
            FEB.days = number;
        }
    }
}