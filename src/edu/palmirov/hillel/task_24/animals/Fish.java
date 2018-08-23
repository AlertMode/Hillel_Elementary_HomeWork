package edu.palmirov.hillel.task_24.animals;

import edu.palmirov.hillel.task_24.abilities.Swimmable;

public class Fish extends Animal implements Swimmable {
    private boolean underWater = true;

    public Fish(String name, int weight) {
        super(name, weight);
    }

    public boolean getUnderWater(){
        return underWater;
    }

    @Override
    public void dive() {
        underWater = true;
    }

    @Override
    public void comeUp() {
        underWater = false;
    }
}