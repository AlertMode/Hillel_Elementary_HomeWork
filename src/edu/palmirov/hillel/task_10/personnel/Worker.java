package edu.palmirov.hillel.task_10.personnel;

public class Worker extends Employee{
    private String employment = Worker.class.getSimpleName();
    private long angerPoint = 666;
    private static int count = 0;

    public Worker() {
        this("Bruce", "Ash" + ++count, (byte)25, 3000);
    }

    public Worker(String firstName, String lastName, byte age, int salary) {
        super(firstName, lastName, age, salary);
    }

    public long getAngerPoint() {
        return angerPoint;
    }

    @Override
    public String says() {
        ++angerPoint;
        return "God damn this stupid PC!";
    }
}