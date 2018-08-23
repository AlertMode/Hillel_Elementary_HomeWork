package edu.palmirov.hillel.task_15;

/*
Task 15

Реализовать класс книга и посчитать сколько раз книга была издана, другими словами узнать сколько раз был вызван конструктор(ы).
*/

public class Book {

    private String title;
    private int pageQuantity;
    private int id;
    private static int counter = 0;

    public Book(String title, int pageQuantity) {
        this.title = title;
        this.pageQuantity = pageQuantity;
        this.id = ++counter;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }

    public String getTitle() {
        return title;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public int getId(){
        return id;
    }

    public static int getCounter(){
        return counter;
    }
}