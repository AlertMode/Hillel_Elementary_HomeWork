package edu.palmirov.hillel.task_14.animals;

public class LittleFish extends DomesticAnimal {
    private String id;

    public LittleFish(int age, int weight, String color, String name, boolean isVaccinated) {
        super(age, weight, color, name, isVaccinated);
        this.id = super.getId();
    }

    @Override
    public void vox() {
        super.vox();
        System.out.println("I'm a " + this.getClass().getSimpleName() +
                ".\nI say: .....");
    }
}