package edu.palmirov.hillel.task_26;

/*
 * Task 26
 *
 * Создайте список (List)  объектов типа Book.
 * Отсортируйте их по возрастанию (по году издания).
 * Класс Book содержит иформацию о наименовании книги, авторе и год издания(число типа int).
 *
 * Отсортировать коллекцию книг можно воспользовавшись библиотечным методом
 * класса Collections.sort() передав в качестве аргумента коллекцию для сортировки.
 *
 * Note: Для того чтобы сделать объекты класса Book сортабельными(могущими быть отсортированными),
 * необходимо чтобы класс Book имплементировал интерфейс Comparable.
 *
 * public class Book implements Comparable<Book> {
 *      …..
 * }
 *
 * Переопределите единственный метод compareTo() интерфейса Comparable таким образом,
 * чтобы была возможность сортировать книги по году издания.
 */

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<Book> bookshelf = new LinkedList<>();
        bookshelf.add(new Book("Das Boot", "Lothar-Günther Buchheim", 1973));
        bookshelf.add(new Book("Lord of the Flies", "William Golding", 1954));
        bookshelf.add(new Book("Heart of Darkness", "Joseph Conrad", 1899));
        bookshelf.add(new Book("The Godfather", "Mario Puzo", 1969));
        bookshelf.add(new Book("Дракон", "Евгений Шварц", 1944));
        bookshelf.add(new Book("Хіба ревуть воли, як ясла повні?", "Панас Мирний", 1875));
        bookshelf.add(new Book("В круге первом", "Александр Солженицын",1968));
        bookshelf.add(new Book("Чапаев и Пустота", "Виктор Пелевин", 1996));
        bookshelf.add(new Book("P.O.W. Люди войны", "Андрей Цаплиенко", 2011));
        bookshelf.add(new Book("Object-Oriented Programming in C++", "Robert Lafore",2012));

        System.out.println("BEFORE SORTING");
        printAll(bookshelf);

        System.out.println("=========================================================================\n" +
                "AFTER SORTING IN ASCENDING ORDER");
        Collections.sort(bookshelf);
        printAll(bookshelf);

        System.out.println("=========================================================================\n" +
                "AFTER SORTING IN DESCENDING ORDER");
        Collections.reverse(bookshelf);
        printAll(bookshelf);
    }

    private static void printAll(List<Book> list){
        for(int i = 0; i < list.size(); i++){
            System.out.printf("Book #%-2d :: \"%7s\" by %-3s, %-3d\n",
                    i + 1, list.get(i).getTitle(), list.get(i).getAuthor(), list.get(i).getDateOfPublishing());
        }
    }
}