package edu.palmirov.hillel.task_10.personnel;

public class Manager extends Employee{
    private String employment = Manager.class.getSimpleName();
    private int pridePoints;
    private static int count = 0;

    public Manager() {
        this("Steve", "Theverysmart" + ++count, (byte)34, 30_000, 9999);
    }

    public Manager(String firstName, String lastName, byte age, int salary, int pridePoints) {
        super(firstName, lastName, age, salary);
        this.pridePoints = pridePoints;
    }

    @Override
    public String getEmployment() {
        return employment;
    }

    public int getPridePoints() {
        return pridePoints;
    }

    public void setPridePoints(int pridePoints) {
        this.pridePoints = pridePoints;
    }

    @Override
    public String says() {
        ++pridePoints;
        return "Work harder! I'm genius! The genius is talking to you!";
    }
}