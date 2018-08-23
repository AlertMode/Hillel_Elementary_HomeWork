package edu.palmirov.hillel.task_24.animals;

import edu.palmirov.hillel.task_24.abilities.Flyable;

public class Chicken extends Animal implements Flyable {

    private boolean onTheFly = false;

    public Chicken(String name, int weight){
        super(name, weight);
    }

    public boolean getOnTheFly(){
        return onTheFly;
    }

    @Override
    public void takeOff() {
        onTheFly = true;
    }

    @Override
    public void land() {
        onTheFly = false;
    }
}