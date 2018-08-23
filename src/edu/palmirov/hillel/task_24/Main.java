package edu.palmirov.hillel.task_24;

import edu.palmirov.hillel.task_24.animals.*;

/*
 * Task 24
 *
 * Создать интерфейс Eatable:
 * interface Eatable {
 *      void eat(String thing);
 * }
 *
 * Сделайте реализации классов Chiсken и Fish имплементирующих интерфейс Eatable.
 * Протестируйте ваши классы (в статическом методе main() );
 * Создайте анонимный класс еще для одного типа животного,
 * например подразумевая что это Worm, имплементирующего интерфейс Eatable.
 */

public class Main {
    public static void main(String[] args){
        Chicken chicken = new Chicken("Daugherty", 4);
        Fish fish = new Fish("Sam", 1);

        Human human = new Human("John", 89, "Fedor");

        human.eat(chicken);
        human.eat(fish);
        human.eat(new Animal("Worm", 2) {
            @Override
            public int getWeight(){
                return super.getWeight() * -10;
            }
        });
    }
}