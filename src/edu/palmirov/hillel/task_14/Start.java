package edu.palmirov.hillel.task_14;

import edu.palmirov.hillel.task_14.animals.*;

public class Start {
    public static void main(String[] args){
        animalsInAction();
    }

    private static void animalsInAction(){
        Lion lion = new Lion(4, 110, "brown", true);
        Wolf wolf = new Wolf(2, 78, "grey", true);
        Giraffe giraffe = new Giraffe(1, 100, "brown, white and black", false);
        Dog dog = new Dog(3, 56, "balck", "Kusya", true);
        GuideDog guideDog = new GuideDog(3, 80, "white", "Muhtar", true, true);
        Cat cat = new Cat(6, 5, "red and white", "Barsik", true);
        LittleFish littleFish = new LittleFish(2, 1, "golden", "Jack", false);
        Hamster hamster = new Hamster(1, 2, "brown", "Stinky", false);

        lion.vox();
        System.out.println(lion.getId() + "\n");
        wolf.vox();
        System.out.println(wolf.getId() + "\n");
        giraffe.vox();
        System.out.println(giraffe.getId() + "\n");
        dog.vox();
        System.out.println(dog.getId() + "\n");
        guideDog.vox();
        System.out.println(guideDog.getId() + "\n");
        cat.vox();
        System.out.println(cat.getId() + "\n");
        littleFish.vox();
        System.out.println(littleFish.getId() + "\n");
        hamster.vox();
        System.out.println(hamster.getId());
    }
}