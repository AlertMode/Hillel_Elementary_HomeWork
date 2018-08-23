package edu.palmirov.hillel.task_16;

import edu.palmirov.hillel.task_16.abstraction.*;

public class OldDigitalBook extends Book implements Digital {

    public OldDigitalBook(String title, int year) {
        super(title, year);
    }

    @Override
    public String getContent() {
        return "[" + this.getTitle() + "]" + " - "
                + "[" + this.getYear() + "]";
    }

    @Override
    public void displays() {
        System.out.println(this.getContent());
    }
}