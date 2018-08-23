package edu.palmirov.hillel.task_14.animals;

public abstract class DomesticAnimal extends Animal {

    private String id;
    private String name; //Contains the name of a pet.
    private boolean isVaccinated;

    public DomesticAnimal(int age, int weight, String color, String name, boolean isVaccinated) {
        super(age, weight, color);
        this.name = name;
        this.setVaccinated(isVaccinated);
    }

    @Override
    public void vox() {
        super.vox();
        System.out.println("I'm a domestic animal: " + this.getClass().getSimpleName() + ". And my name is " + name +
                ".\n" + (isVaccinated ? "Don't worry! I'm vaccinated." : "You should think about vaccinating me!"));
    }

    public void setVaccinated(boolean value){
        this.isVaccinated = value;
    }

    public boolean getIsVaccinated(){
        return this.isVaccinated;
    }
}