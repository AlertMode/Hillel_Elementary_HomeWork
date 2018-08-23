package edu.palmirov.hillel.task_16;

import edu.palmirov.hillel.task_16.abstraction.*;

public class PaperBook extends Book {
    public PaperBook(String title, int year) {
        super(title, year);
    }

    @Override
    public String getContent() {
        return "IncompatibleBookFormat";
    }
}
