package edu.palmirov.hillel.task_10.personnel;

public class SysAdmin extends Employee{
    private String employment = SysAdmin.class.getSimpleName();
    private int experience = 0;
    private static int count = 0;

    public SysAdmin() {
        this("Vadim", "WTF" + ++count, (byte)27, 5000);
    }

    public SysAdmin(String firstName, String lastName, byte age, int salary) {
        super(firstName, lastName, age, salary);
    }

    @Override
    public String getEmployment() {
        return employment;
    }

    @Override
    public String says() {
        return "Don't touch this and don't do that!";
    }

    public String useBandaidSolution(){
        ++experience;
        return "Have you tried to plug router out?";
    }
}