package edu.palmirov.hillel.task_14.animals;

public class Wolf extends WildAnimal {

    private String id;

    public Wolf(int age, int weight, String color, boolean isPredator) {
        super(age, weight, color, isPredator);
    }

    @Override
    public void vox() {
        super.vox();
        System.out.println("I'm a " + this.getClass().getSimpleName() +
                ".\nI say: H-o-o-o-o-o-wl!");
    }
}