package edu.palmirov.hillel.task_24.animals;

import edu.palmirov.hillel.task_24.abilities.Eatable;

public abstract class Animal implements Eatable {
    private String name;
    private int weight;

    public Animal(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null){ return false; }

        if(!Animal.class.isAssignableFrom(object.getClass())){ return false; }

        final Animal that = (Animal) object;
        return this.name.equals(that.name) && this.weight == that.weight;
    }

    @Override
    public boolean eat(Animal animal){
        if(animal == null){ return false; }

        System.out.printf("%s %s has eaten %s\n",
                this.getClass().getSimpleName(), this.getName(), animal.getName());
        System.out.printf("Energy %s %s: %d\n",
                animal.getWeight() == 1 || animal.getWeight() ==  -1 ? "Point" : "Points",
                animal.getWeight() > 0 ? "gained" : "lost",
                Math.abs(animal.getWeight()));
        this.weight += animal.getWeight();
        System.out.printf("Now %s %s has: %d energy %s\n",
                this.getClass().getSimpleName(), this.getName(), this.getWeight(),
                this.getWeight() == 1 || this.getWeight() ==  -1 ? "point" : "points");
        System.out.println("=================================================================");
        return true;
    }
}