package edu.palmirov.hillel.task_15;

public class Start {

    public static void main(String[] args){
        bookInAction();
    }

    private static void bookInAction(){
        Book book1 = new Book("Сто лет одиночества", 544);
        Book book2 = new Book("The War of Don Emmanuel's Nether Parts", 368);
        Book book3 = new Book("Пропавшие комиссары. Фальсификация фотографий и произведений искусства в сталинскую эпоху", 208);
        Book book4 = new Book("Человек в поисках смысла", 368);

        displayBook(book1);
        displayBook(book2);
        displayBook(book3);
        displayBook(book4);

        System.out.println("\n------------------\nTotal books quantity: " + Book.getCounter());
    }

    private static void displayBook(Book book){
        System.out.println("Title: " + book.getTitle() + "\nPages: " + book.getPageQuantity() +
                "\nBook id: " + book.getId());
    }
}