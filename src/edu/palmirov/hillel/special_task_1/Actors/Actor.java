package edu.palmirov.hillel.special_task_1.Actors;

public abstract class Actor {
    private String name;


    public Actor(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}