package edu.palmirov.hillel.task_20;

/**
 Task 20

 На основании выполненного задания № 18 (double linked list) реализовать структуру данных двусторонняя очередь (deque). Очередь, из которой элементы могут быть извлечены как с одной стороны (классический случай First-In-First-Out), так и с другой стороны (Last-In-First-Out). Другими словами очередь и стек в одном “флаконе”.
 Имплементируйте класс Deque для обработки данных типа String.
 Реализуйте такие методы имеющие следующие имена:
 boolean addFirst(String element); // добавить в начало
 boolean addLast(String element); // добавить в конец
 boolean removeFirst(); // удалить элемент из head без извлечения
 boolean removeLast(); // удалить элемент из tail без извлечения
 String peekFirst(); // получить первый не удаляя из очереди
 String peekLast(); // получить последний элемент не удаляя из очереди
 String pop(); // извлекает последний элемент (tail) из очереди и удаляет его
 String poll(); // извлекает первый элемент (head) из очереди и удаляет его
 boolean contain(String element); // проверяет наличие элемента в очереди
 size() - возвращает размер очереди
 */

public class Main {
    public static void main(String[] args){
        Deque deque = new Deque();

        //Checking the work of empty deque.
        System.out.println("Adding the an element to the deque's head: " + deque.addFirst(null));
        System.out.println("Adding the an element to the deque's tail: " + deque.addFirst(null));

        System.out.println("Removing the very first element from the deque: " + deque.removeFirst());
        System.out.println("Removing the very last element from the deque: " + deque.removeLast());

        System.out.println("Show the first element: " + deque.peekFirst());
        System.out.println("Show the second element: " + deque.peekLast());

        System.out.println("Get the first element: " + deque.poll());
        System.out.println("Get the last element: " + deque.pop());

        System.out.println("Contains: " + deque.contains(null));

        System.out.println("Size: " + deque.size());

        //Checking the work of stuffed deque.
        System.out.println("Adding the an element to the deque's head: " + deque.addFirst("Hello"));
        deque.addFirst("WTF?!");
        deque.addFirst("Yippee-Ki-Yay");
        System.out.println("Adding the an element to the deque's tail: " + deque.addLast("World"));
        deque.addLast("Wow-effect");
        deque.addLast("Do a barrel-roll!");

        System.out.println("Show the first element: " + deque.peekFirst());
        System.out.println("Show the last element: " + deque.peekLast());

        System.out.println("Removing the very first element from the deque: " + deque.removeFirst());
        System.out.println("Removing the very last element from the deque: " + deque.removeLast());

        System.out.println("Show the first element: " + deque.peekFirst());
        System.out.println("Show the last element: " + deque.peekLast());

        System.out.println("Get the first element: " + deque.poll());
        System.out.println("Get the last element: " + deque.pop());

        System.out.println("Show the first element: " + deque.peekFirst());
        System.out.println("Show the last element: " + deque.peekLast());

        System.out.println("Contains: " + deque.contains("World"));

        System.out.println("Size: " + deque.size());
    }
}