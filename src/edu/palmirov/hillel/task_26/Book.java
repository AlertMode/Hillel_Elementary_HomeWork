package edu.palmirov.hillel.task_26;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int dateOfPublishing;

    public Book(String title, String author, int dateOfPublishing) {
        this.title = title;
        this.author = author;
        this.dateOfPublishing = dateOfPublishing;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getDateOfPublishing() {
        return dateOfPublishing;
    }

    /**
     * Being only an interface's method, 'compareTo()' is to be overridden by
     * creating the certain way of comparing definite class' field to another one.
     */
    @Override
    public int compareTo(Book that) {
        return Integer.compare(this.getDateOfPublishing(), that.getDateOfPublishing());
    }
}
