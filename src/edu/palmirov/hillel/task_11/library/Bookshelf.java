package edu.palmirov.hillel.task_11.library;


public class Bookshelf {
    private Book[] books;
    private int lastIndex;

    public Bookshelf() {
        this.create();
    }

    public Bookshelf(Book book) {
        this();
        this.add(book);
    }

    private void create() {
        this.books = new Book[1];
    }

    //Adds new 'Book' object to the array.
    public void add(Book book) {
        extend();
        this.books[this.books.length - 1] = book;
    }

    //Adds all the elements from 'Book' array.
    public void addAll(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            add(books[i]);
        }
    }

    //Adds all the elements from another 'Bookshelf' object.
    public void addAll(Bookshelf books){
        Book[] temp = books.getBooks();
        for (int i = 0; i < temp.length; i++) {
            add(temp[i]);
        }
    }

    //Deletes the last added 'Book' object from the array.
    public boolean delete() {
        return narrow();
    }

    //Deletes all the elements from the elements.
    public boolean deleteAll() {
        int length = this.books.length;
        boolean statement = true;
        for (int i = 0; i < length; i++) {
            statement = narrow();
        }
        return statement;
    }

    //Returns 'Book' object if it, of course, exists by the input index.
    public Book getBook(int index) {
        if (index > this.books.length || index < 0) {
            return null;
        }
        return this.books[index];
    }

    //Returns the index of the input 'Book' object if its copy exists in the array.
    //Otherwise, the return value is '-1'.
    public int getIndex(Book book) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].equals(book)) {
                return i;
            }
        }
        return -1;
    }

    //Extends the array.
    private void extend() {
        if (this.books[this.books.length - 1] == null) {
            return;
        }
        Book[] temp = new Book[this.books.length + 1];
        System.arraycopy(this.books, 0, temp, 0, this.books.length);
        this.books = temp;
    }

    //Narrow the array.
    private boolean narrow() {
        if (this.books.length == 1) {
            return false;
        }
        Book[] temp = new Book[this.books.length - 1];
        System.arraycopy(books, 0, temp, 0, temp.length);
        this.books = temp;
        return true;
    }

    //Returns the size (length) of the array.
    public int getSize() {
        return this.books.length;
    }

    //Returns the 'Book' array.
    public Book[] getBooks() {
        return this.books;
    }

    //Sorts the 'Book' array by the title of the books in ascending or descending directions.
    public void sortByTitle(Direction direction) {
        boolean condition;
        for (int i = 0; i < this.books.length; i++) {
            char array[] = this.books[i].getTitle().substring(0, 1).toCharArray();
            for (int j = 0; j < this.books.length; j++) {
                char[] temp = this.books[j].getTitle().substring(0, 1).toCharArray();
                switch (direction) {
                    case ASC:
                        condition = array[0] < temp[0];
                        break;
                    case DESC:
                        condition = array[0] > temp[0];
                        break;
                    default:
                        System.out.println("Wrong function argument input!");
                        return;
                }
                if (condition) {
                    Book book = this.books[i];
                    this.books[i] = this.books[j];
                    this.books[j] = book;
                }
            }
        }
    }
}