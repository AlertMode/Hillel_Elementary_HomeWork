package edu.palmirov.hillel.task_24.animals;

import edu.palmirov.hillel.task_24.abilities.*;

public class Human extends Animal implements Swimmable, FullMouthed {

    private String surname;
    private boolean onTheSurface = true;

    public Human(String name, int weight, String surname) {
        super(name, weight);
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isOnTheSurface() {
        return onTheSurface;
    }

    @Override
    public void dive() {
        onTheSurface = false;
    }

    @Override
    public void comeUp() {
        onTheSurface = true;
    }

    @Override
    public String bestWishes() {
        return "1011-10101-1100-1! 2-D-21-14-1C!";
    }

    @Override
    public boolean eat(Animal animal) {
        boolean result = super.eat(animal);

        if(animal.getName().equalsIgnoreCase("worm")){
            System.out.println(bestWishes()); }

        return result;
    }
}