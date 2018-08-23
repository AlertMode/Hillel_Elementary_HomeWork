package edu.palmirov.hillel.special_task_1_with_jcf.actors;

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