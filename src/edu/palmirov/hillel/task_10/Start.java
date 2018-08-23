package edu.palmirov.hillel.task_10;

import edu.palmirov.hillel.task_10.personnel.*;

public class Start {
    public static void main(String[] args){
        Client client = new Client();
        Employee employee = new Employee();
        SysAdmin sysAdmin = new SysAdmin();
        Worker worker = new Worker();
        Manager manager = new Manager();

        //System.out.println(sysAdmin instanceof Client); Impossible
        System.out.println(worker instanceof Person);
        //System.out.println(worker instanceof Manager); Impossible
        System.out.println(sysAdmin instanceof Person);
        //System.out.println(manager instanceof Client); Impossible
        //System.out.println(client instanceof Employee); Impossible
        System.out.println(client instanceof Person);
    }
}