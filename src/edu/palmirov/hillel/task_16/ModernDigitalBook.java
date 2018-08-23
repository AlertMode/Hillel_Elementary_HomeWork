package edu.palmirov.hillel.task_16;

import edu.palmirov.hillel.task_16.abstraction.*;

public class ModernDigitalBook extends Book implements ModernDigital {

    public ModernDigitalBook(String title, int year) {
        super(title, year);
    }

    @Override
    public String getContent() {
        return "[" + this.getTitle() + "]" + " - "
                + "[" + this.getYear() + "]";
    }

    @Override
    public void updateFirmWare() {
        System.out.println("\"BoomU\" has been updated!\nActivated.");
    }

    @Override
    public void displays() {
        System.out.println(this.getContent());
    }

    @Override
    public int found(String text) {
        int min = 1;
        int max = 10;
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
