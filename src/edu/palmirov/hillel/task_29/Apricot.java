package edu.palmirov.hillel.task_29;

public class Apricot extends Fruit implements Juiceable {
    @Override
    public void makeJuice(){
        System.out.println("The juice has been made of " + this.getClass().getSimpleName());
    }
}