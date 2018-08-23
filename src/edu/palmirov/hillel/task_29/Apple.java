package edu.palmirov.hillel.task_29;

public class Apple extends Fruit implements Juiceable{
    @Override
    public void makeJuice() {
        System.out.println(this.getClass().getName() + " : Juice has been made!");
    }
}