package edu.palmirov.hillel.task_16;

import edu.palmirov.hillel.task_16.abstraction.*;

public class DigitalBook extends Book implements Digital,Searchable {

    public DigitalBook(String title, int year) {
        super(title, year);
    }

    @Override
    //Displays a simple message, describing book's title and year of publishing.
    public void displays() {
        System.out.println(this.getContent());
    }

    @Override
    //Returns a random number from 1 to 1000;
    public int found(String text) {
        int min = 1;
        int max = 10;
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    @Override
    public String getContent() {
        return "[" + this.getTitle() + "]" + " - "
                + "[" + this.getYear() + "]";
    }
}