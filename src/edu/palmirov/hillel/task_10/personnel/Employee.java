package edu.palmirov.hillel.task_10.personnel;

public class Employee extends Person {

    private String employment = Employee.class.getSimpleName();
    private int salary;
    private static int count = 0;

    public Employee() {
        this("Frank", "Oops" + ++count, (byte)30, 5000);
    }

    public Employee(String firstName, String lastName, byte age, int salary) {
        super(firstName, lastName, age);
        this.salary = salary;
    }

    @Override
    public String getEmployment() {
        return employment;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    @Override
    public String says() {
        return "Well, at least coffee vending machine stills works.";
    }

    public void isSleeping(){
        salary = salary - 500;
    }

    public void isWorking(){
        salary = salary - 1000;
    }
}