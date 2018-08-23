package edu.palmirov.hillel.task_16.abstraction;

public abstract class Book {
    private String title;
    private int year;

    public Book(String title, int year) {
        setTitle(title);
        setYear(year);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    //Returns the two concatenated values of "title" and "year" variables.
    public abstract String getContent();
}