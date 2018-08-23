package edu.palmirov.hillel.task_14.animals;

public class Lion extends WildAnimal {

    private String id;

    public Lion(int age, int weight, String color, boolean isPredator) {
        super(age, weight, color, isPredator);
    }

    @Override
    public void vox() {
        super.vox();
        System.out.println("I'm a " + this.getClass().getSimpleName() +
                ".\nI say: Arg-g-g-g!"); //Lion's roar.
    }
}