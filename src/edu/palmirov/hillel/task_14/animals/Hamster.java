package edu.palmirov.hillel.task_14.animals;

public class Hamster extends DomesticAnimal {
    private String id;
    private static int counter = 0;

    public Hamster(int age, int weight, String color, String name, boolean isVaccinated) {
        super(age, weight, color, name, isVaccinated);
        this.id = super.getId();
    }

    @Override
    public void vox() {
        super.vox();
        System.out.println("I'm a " + this.getClass().getSimpleName() +
                ".\nI say: Yeah. That's smell...");
    }
}