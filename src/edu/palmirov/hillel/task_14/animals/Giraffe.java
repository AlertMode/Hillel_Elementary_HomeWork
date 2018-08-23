package edu.palmirov.hillel.task_14.animals;

public class Giraffe extends WildAnimal{
    private String id;

    public Giraffe(int age, int weight, String color, boolean isPredator) {
        super(age, weight, color, isPredator);
    }

    @Override
    public void vox() {
        super.vox();
        System.out.println("I'm a" + this.getClass().getSimpleName() +
                ".\nI say: I'm too silent to your ears, pall!");
    }
}