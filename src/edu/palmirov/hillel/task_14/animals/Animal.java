package edu.palmirov.hillel.task_14.animals;

/*
Task 14

1. Реализовать иерархию классов животных.
Базовый класс Animal(животное) сделать абстрактным классом.
Подумать какие методы должны быть абстрактными (соответственно должны быть реализованы в классах наследниках), а какие будут иметь общий функционал со всеми животными.

Классы:
Животное,
Рыбка,
Собака,
Кот,
Волк,
Лев,
Жираф,
Домашнее,
Крокодил,
Дикое,
Хомяк,
Собака-поводырь.

Поля:
id (у всех животных),
name (у домашних),
age(у всех животных),
weight(у всех животных),
color(у всех животных),
isVaccinated(у домашних),
isPredator(у диких),
isTrained (дресированная - у собаки-поводыря).
методы:
public - издать голос (у всех),
public - отвести домой (у поводыря)
вспомогательные методы на ваше усмотрение.

2. В приложении, издавать голос следующим образом :

возвращается строка,
у всех начинается “Hello, ” + :
если есть имя  “my name is <name>.”
если дикое “I am a wild animal”
если хищник “ and I am angry ”
если собака “Woof”
если кот “Meow”
если собака-поводырь и дрессированная “I can take you home.”
рыбка отличается от всех ее реплика “....”
*/

public abstract class Animal {
    private String id;
    private int age;
    private int weight;
    private String color;
    private static int counter = 0; //Created to count the number of created objects.
    //Each new created number will be assign to variable "id".


    public Animal(int age, int weight, String color){
        this.id = ++counter + "-" + this.getClass().getName();
        setAge(age);
        setWeight(weight);
        setColor(color);
    }

    //All child classes will override this method to produce any kind animal voices.
    public void vox(){
        System.out.print("Hello, ");
    };

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    //Returns the total amount of all "Animal's" created sub-classes.
    public int totalObjects(){
        return this.counter;
    }
}