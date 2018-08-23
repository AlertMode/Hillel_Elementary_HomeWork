package edu.palmirov.hillel.task_22;

/*
 * Task 22
 *
 * Создайте внутренние классы для следующих задач:
 *
 * 1. Создать класс Payment с внутренним классом, с помощью объектов
 * которого можно сформировать покупку из нескольких товаров.
 *
 * 2. Создать класс Catalog с внутренним классом,
 * с помощью объектов которого можно хранить информацию об истории выдач книги читателям.
 *
 * 3. Создать класс Computer с внутренним классом, с помощью объектов
 * которого можно хранить информацию об операционной системе, процессоре и оперативной памяти.
 *
 * 4. Создать класс Cinema с внутренним классом, с помощью объектов
 * которого можно хранить информацию о продолжительности, жанре и режиссерах фильма.
 */

public class Main {
    public static void main(String[] args){
        //'Payment' class test.
        Payment payment = new Payment();
        System.out.println("\nAchtung!\n\'Payment\' testing!");
        showAddStatus(payment.add("Medal of Honor", 234.56, 3));
        showAddStatus(payment.add("Delta Force", 289.99, 2));
        showAddStatus(payment.add("GTA2", 190, 1));

        payment.printAll();
        showDeleteStatus(payment.delete());
        payment.printAll();
        showDeleteStatus(payment.delete());
        payment.printAll();
        showDeleteStatus(payment.delete());
        payment.printAll();
        showDeleteStatus(payment.delete());
        payment.printAll();

        showAddStatus(payment.add("Grand Theft Auto: San Andreas", 139.99, 20));
        showAddStatus(payment.add("Red Orchestra 2: Heroes of Stalingrad", 200, 5));
        payment.printAll();


        //'Catalog' class test.
        Catalog catalog = new Catalog();
        System.out.println("\nAchtung!\n\'Catalog\' testing!");
        showAddStatus(catalog.add("Бесы", "Михаил Фёдорович Достоевский", "Владимир Ульянов"));
        showAddStatus(catalog.add("Преступление и Наказание", "Михаил Фёдорович Достоевский", "Нико Беллик"));
       showAddStatus(catalog.add("Generation \"П\"", "Виктор Пелевин", "Данила Багров"));
        catalog.printAll();

        showDeleteStatus(catalog.delete());
        catalog.printAll();
        showDeleteStatus(catalog.delete());
        catalog.printAll();
        showDeleteStatus(catalog.delete());
        catalog.printAll();
        showDeleteStatus(catalog.delete());
        catalog.printAll();

        showAddStatus(catalog.add("Безумец и его сыновья", "Илья Бояшев", "Вавилен Татарский"));
       showAddStatus(catalog.add("Депеш Мод", "Сергій Жадан", "Martin Lee Gore"));
        catalog.printAll();


        //'Computer' class testing.
        Computer computer = new Computer();
        System.out.println("\nAchtung!\n\'Computer\' testing!");
        showAddStatus(computer.add("Microsoft Windows XP SP3",
                "AMD Duron", 1.3, 1,
                "Samsung M368L3223ETM-CCC", 400, 256));
        showAddStatus(computer.add("Microsoft 7 SP1",
                "AMD Athlon 64 X2", 2.4, 2,
                "Samsung PC2-6400", 800, 2048));
        computer.printAll();

        showDeleteStatus(computer.delete());
        computer.printAll();
        showDeleteStatus(computer.delete());
        computer.printAll();
        showDeleteStatus(computer.delete());
        computer.printAll();

        showAddStatus(computer.add("Microsoft Windows 7 SP1",
                "AMD Athlon X4", 3, 4,
                "PC3-12800 DDR3", 1600, 1));
        showAddStatus(computer.add("Microsoft Windows 10",
                "Intel Core-i5 6600k", 3.5, 4,
                "Kingston DDR4-2133", 2133, 16383));
        computer.printAll();


        //'Cinema' class testing.
        Cinema cinema = new Cinema();
        System.out.println("\nAchtung!\n\'Computer\' testing!");
        showAddStatus(cinema.add("Saving Private Ryan", 1999, "Epic war movie",
                "Stephen Spielberg", 169, 481_800_000));
        showAddStatus(cinema.add("Grand Theft Auto", 1977, "Road movie",
                "Ron Howard", 84, 602_000));
        showAddStatus(cinema.add("The Thing", 1982, "Science fiction horror movie",
                "John Carpenter", 109, 15_000_000));

        showDeleteStatus(cinema.delete());
        cinema.printAll();
        showDeleteStatus(cinema.delete());
        cinema.printAll();
        showDeleteStatus(cinema.delete());
        cinema.printAll();

        showAddStatus(cinema.add("Apocalypse Now", 1979, "Epic war film",
                "Francis Ford Coppola", 153, 31_500_000));
        showAddStatus(cinema.add("Иди и смотри", 1985, "военная драма",
                "Элем Климов", 145, 500_000));

        cinema.printAll();
    }

    //Instead of writing "sout" each time.
    static void showAddStatus(boolean value){
        System.out.println("Adding operation status: "  + value);
    }

    //The same as in the previous comment.
    static void showDeleteStatus(boolean value){
        System.out.println("Deleting operation status: " + value);
    }
}