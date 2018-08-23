package edu.palmirov.hillel.task_08;

/*
Task 8

Написать функцию, которая принимает в качестве параметров месяц и год и выводит, сколько дней в этом месяце.
	Для ввода месяца и года используйте числовые значения
(например, январь - 1 месяц, март - 3 и т.д.)
Для названия месяцев и вывода информации используйте enum. Например,
“January 1981 and 31 days” или “February 2016 and 29 days”.
*/

import java.util.Scanner;

public class Start {
    public static void main(String[] args){

       int month = input("the month");
       int year = input("the year");
       System.out.println("-----------------------");
       LeapYear date = new LeapYear();
       System.out.println(date.getInfo(month, year));
    }

    public static int input(String message){
        //The function created for data input and its check.
        Scanner scanner = new Scanner(System.in);
        int value;
            System.out.print("Please enter " + message + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Wrong input!");
                scanner.next();
            }
            value = scanner.nextInt();
        return value;
    }
}