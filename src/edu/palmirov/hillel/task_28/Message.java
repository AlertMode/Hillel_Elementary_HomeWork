package edu.palmirov.hillel.task_28;

/*
* Task 28
*
* Написать generic-класс “Message<T>”.
* Который имеет два конструктора:
* без параметров;
* Принимает на вход объект типа T.
*
* А также getter и setter.
* Переопределите метод toString().
*
* Протестируйте созданный класс в методе static void main().
*/

public class Message<T> {
    private T type;

    public Message(){ };

    public Message(T type){
        this.type = type;
    }

    public void setType(T type){
        this.type = type;
    }

    public T getType(){
        return new Message<T>(this.type).type;
    }

    @Override
    public String toString(){
        return "Message{"
                + "type: "
                + type
                + "}";
    }
}