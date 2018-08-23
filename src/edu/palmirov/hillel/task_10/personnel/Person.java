package edu.palmirov.hillel.task_10.personnel;

/*
Task 10

Реализовать иерархию классов представленную на схеме ниже:

https://docs.google.com/document/d/1pHdju46T6X-Nusmktf6iYhX7rWkTefijkH3Z0B11FJQ/edit

Отношения между классами заданы стрелками. Например, класс Client наследуется от базового класса personnel.
Набор свойств и набор методов на для данных классов на ваше усмотрение.
Задача:
Проверить является ли объект класса SysAdmin наследником класса Client.
Проверить является ли объект класса Worker наследником класса Person.
Проверить является ли объект класса Worker наследником класса Manager.
Проверить является ли объект класса SysAdmin наследником класса Person.
Проверить является ли объект класса Manager наследником класса Client.
Проверить является ли объект класса Client наследником класса Employee.
Проверить является ли объект класса Client наследником класса Person.

Для выполнения вышеперечисленных проверок используем java оператор instanceof .

B.

Для класса personnel создайте хотя бы 1 свой конструктор, который будет принимать минимум 1 аргумент.

Для класса Employee создайте хотя бы 2 конструктора.

Выполните соответствующие изменения, если они нужны, в классах наследниках для осуществления корректного их конструирования при создании объектов.

*/

public class Person {
    private String firstName;
    private String lastName;
    private byte age;
    private String employment = Person.class.getSimpleName();
    private static int count = 0;

    public Person(){
        this("John", "#" + ++count, (byte)28);
    }

    public Person(String firstName, String lastName, byte age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public byte getAge() {
        return age;
    }

    public String getEmployment(){
        return employment;
    }

    //A simple function, returning 'String' message.
    public String says(){
        return "What the hell is going on?";
    }
}