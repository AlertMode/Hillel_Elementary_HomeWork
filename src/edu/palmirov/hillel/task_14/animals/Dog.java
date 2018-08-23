package edu.palmirov.hillel.task_14.animals;

public class Dog extends DomesticAnimal {

    private String id;

    public Dog(int age, int weight, String color, String name, boolean isVaccinated) {
        super(age, weight, color, name, isVaccinated);
    }

    @Override
    public void vox() {
        super.vox();
        System.out.println("I'm a " + this.getClass().getSimpleName() +
                ".\nI say: Woof-woof!");
    }
}