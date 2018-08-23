package edu.palmirov.hillel.task_10.personnel;

public class Client extends Person {

    private String employment = Client.class.getSimpleName();
    private long cash;
    private static int count = 0;

    public Client() {
        this("Michael", "Some" + ++count, (byte)13, 10_000);
    }

    public Client(String firstName, String lastName, byte age, long cash) {
        super(firstName, lastName, age);
        this.cash = cash;
    }

    public void setCash(long cash) {
        this.cash = cash;
    }

    public long getCash() {
        return cash;
    }

    @Override
    public String getEmployment() {
        return employment;
    }

    @Override
    public String says() {
        return "Get my money back, pigs!";
    }

    public String isRight(){
        return "I've got " + cash + "$! I'm the boss!";
    }
}