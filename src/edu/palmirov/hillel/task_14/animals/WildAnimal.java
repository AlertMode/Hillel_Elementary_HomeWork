package edu.palmirov.hillel.task_14.animals;

public abstract class WildAnimal extends Animal {

    private String id;
    private boolean isPredator; //Enable of disable the "predator" attribute.

    public WildAnimal(int age, int weight, String color, boolean isPredator) {
        super(age, weight, color);
        this.setPredator(isPredator);
    }

    @Override
    public void vox(){
        super.vox();
        //If a WildAnimal child-class object's "isPredator" field is configured to 'true', the first message
        //(in brackets) will be displayed. Otherwise, the second. Pretty logic, isn't it?
        System.out.println("I'm a wild animal!" + (isPredator ? " And I'm angry!" : " And I'm friendly. Well, almost." +
                "Just don't touch me."));
    }

    public void setPredator(boolean value){
        this.isPredator = value;
    }

    public boolean getIsPredator(){
        return this.isPredator;
    }
}