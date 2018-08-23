package edu.palmirov.hillel.task_29;

/*
 * Задача:
 * Вставьте корректный wildcard в сигнатуру метода makeJuice(Collection<...> juiceFruits)
 * Таким образом, чтобы код работал корректно согласно комментариям выше.
 */

import java.util.Arrays;
import java.util.Collection;

public class Juicer {
    void makeJuice(Collection<? extends Juiceable> juiceFruits) {
        for (Juiceable fruit : juiceFruits) {
            fruit.makeJuice();
        }
    }

    public static void main(String[] args){
        Juicer juicer = new Juicer();

        // Code below must work correctly since Apple is able to give some juice
        Collection<Apple> apples = Arrays.asList(new Apple(), new Apple());
        juicer.makeJuice(apples);

        // Code below must work correctly since Apricot is able to give some juice
        Collection<Apricot> apricots = Arrays.asList(new Apricot(), new Apricot());
        juicer.makeJuice(apricots);

        // Code below mustn't work correctly since AppleQuince isn't able to give juice
        Collection<AppleQuince> appleQuinces = Arrays.asList(new AppleQuince(), new AppleQuince());
        //juicer.makeJuice(appleQuinces); > can't be applied since makeJuice() accepts only classes,
        // implementing Juiceable interface

        // Code bellow mustn't work correctly since Fruit doesn't mean it's able to give juice always by definition
        Collection<Fruit> mixedFruits = Arrays.asList(new Apple(), new Apricot(), new AppleQuince());
        //juicer.makeJuice(mixedFruits); > can't be applied since makeJuice() accepts only classes,
        // implementing Juiceable interface

        // Code below must work correctly since the generics type has been set to Juiceable
        Collection<Juiceable> fixedMixedFruits = Arrays.asList(new Apple(), new Apricot());
        juicer.makeJuice(fixedMixedFruits);
    }
}