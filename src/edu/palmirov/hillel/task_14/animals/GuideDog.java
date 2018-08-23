package edu.palmirov.hillel.task_14.animals;

public class GuideDog extends Dog {

    private String id;
    private boolean isTrained;

    public GuideDog(int age, int weight, String color, String name, boolean isVaccinated, boolean isTrained){
        super(age, weight, color, name, isVaccinated);
        this.setTrained(isTrained);
    }

    public void setTrained(boolean value){
        this.isTrained = value;
    }

    public boolean getIsTrained(){
        return this.isTrained;
    }

    @Override
    public void vox() {
        super.vox();
        System.out.println(this.takeHome());
    }

    private String takeHome(){
        return this.isTrained ? "I can take you home!" : "I'm not trained. Sorry, I can't take you home.";
    }
}