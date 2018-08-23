package edu.palmirov.hillel.task_11;

/*
Task 11

Создайте классы Book, Author и BookShelf.
Подумайте об отношении между этими классами. Как их скомпоновать между собою?
Можно ли применить наследование по отношению к ним?

Класс книга должен содержать минимальный набор полей:
название книги;
кол-во страниц;
информацию об авторе книги.

Класс Author должен содержать информацию о человеке написавшем книгу:
имя и фамилия автора;
год рождения;

Класс Bookshelf  должен хранить информацию о книгах, которые хранятся на книжной полке.
набор книг разных авторов.

Задача:
Есть две книжных полки: общая книжная полка содержащая множество разных книг,
но она может содержать одинаковые книги (повторяющиеся 2 раза одинаковые книжки) и пустая книжная полка.
Ваша задача отобрать только повторяющиеся книги и сложить их в пустую книжную полку.

Примечание:

Для реализации этой задачи вам придется переопределить метод
boolean equals(Object obj) для ваших классов.
Подумайте для каких именно классов нужно переопределять метод equals(),
а для каких классов не нужно исходя из условия задачи.

Также напоминаю, две строки можно сравнить с помощью метода equals(), например:
str1= “abc”; str2 = “bca”; boolean result = str1.equals(str2) // result будет содержать false
str1= “bca”; str2 = “bca”; boolean result = str1.equals(str2) // result будет содержать true
*/

import edu.palmirov.hillel.task_11.library.*;

public class Start {
    public static void main(String[] args){
        Author author1 = new Author("Фёдор", "Достоевский", 1821);
        Author author2 = new Author("Phillip", "Caputo", 1941);
        Author author3 = new Author("Стивен", "Строгац", 1959);
        Author author4 = new Author("Алесь", "Адамович", 1927);
        Author author5 = new Author("Bjarne", "Stroustrup", 1950);
        Author author6 = new Author("Norman", "Mailer", 1923);
        Author author7 = new Author("Владимир", "Познер", 1934);
        Author author8 = author1;

        Book book1 = new Book("Преступлние и Наказание", 672, author1);
        Book book2 = new Book("Идиот", 640, author1);
        Book book3 = new Book("The Rumor of War", 384, author2);
        Book book4 = new Book("10,000 Days of Thunder: A History of the Vietnam War", 128, author2);
        Book book5 = new Book("Удовольствие от х", 293, author3);
        Book book6 = new Book("Хатынская повесть", 240, author4);
        Book book7 = new Book("Каратели. Радость ножа, или Жизнеописания гипербореев", 392, author4);
        Book book8 = new Book("The C++ Programming Language. 4th Edition", 1368, author5);
        Book book9 = new Book("Programming: Principles and Practice Using C++ (2nd Edition)", 1312, author5);
        Book book10 = new Book("The Naked and The Dead", 721, author6);
        Book book11 = new Book("Прощание с иллюзиями", 480, author7);

        Bookshelf bookshelfA = new Bookshelf(book11);
        bookshelfA.add(book9);
        bookshelfA.add(book3);
        bookshelfA.add(book5);
        bookshelfA.add(book5);
        bookshelfA.add(book8);
        bookshelfA.add(book11);
        bookshelfA.add(book3);
        bookshelfA.add(book6);

        printAll(bookshelfA);

        System.out.println("-------------------------------------------------------------");

        Bookshelf bookshelfB = new Bookshelf();
        bookshelfB = copyDuplicates(bookshelfA, bookshelfB);

        printAll(bookshelfB);

        System.out.println("-------------------------------------------------------------");

        bookshelfB.sortByTitle(Direction.DESC);
        printAll(bookshelfB);
    }
    
    static Bookshelf copyDuplicates(Bookshelf bookshelfA, Bookshelf bookshelfB) {
        int count = 0;
        for (int i = 0; i < bookshelfA.getSize(); i++) {
            Book book = bookshelfA.getBook(i);
            for (int j = 0; j < bookshelfA.getSize(); j++) {
                if (book.equals(bookshelfA.getBook(j))) {
                    ++count;
                }
            }
            if (count > 1) {
                bookshelfB.add(book);
            }
            count = 0;
        }
        return bookshelfB;
    }

    static void printAll(Bookshelf bookshelf){
        for (int i = 0; i < bookshelf.getSize(); i++) {
            Book book = bookshelf.getBook(i);
            Author author = book.getAuthor();
            System.out.println("Title: " + book.getTitle() +
                    "\nPages: " + book.getPage() +
                    "\nAuthor: " + author.getFirstName() +
                    " " + author.getLastName() + "\n");
        }
    }
}