package edu.palmirov.hillel.task_18;

/*
Task 18

Реализовать Double Linked List (двусвязный список).
Список должен хранить информацию в объектах типа String.
А также каждый узел должен иметь две обязательных ссылки: на предыдущий и следующий элементы.
В реализации должны быть имплементированы следующие публичные методы:
boolean contains(String node); // проверить наличие данных
void remove (String data); // удалить элемент
void insertBefore(String data); // Вставить элемент перед head
void insertAfter(String data); // Вставить элемент в конец списка tail
Node find(String data); // поиск по данным
void clear(); // удалить все элементы из списка
*/

public class Start {
    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAfter("Bravo");
        list.insertAfter("Charlie");
        list.insertAfter("Delta");
        list.insertAfter("Echo");
        list.insertAfter("Foxtrot");
        list.insertAfter("Golf");
        list.insertAfter("Hotel");
        list.insertAfter("India");
        list.insertAfter("Juliett");
        list.insertAfter("Kilo");
        list.insertAfter("Lima");
        list.insertAfter("Mike");
        list.insertBefore("Alpha");
        list.insertAfter("November");

        list.displayASC();
        System.out.println("The " + list.getClass().getSimpleName() + " length: " + list.length());
        System.out.println(list.find(7));

        System.out.println(list.contains("Xray"));
        System.out.println(list.getIndex("Juliett"));
        System.out.println(list.remove("Juliett"));
        list.displayASC();

        list.insert("Juliett", 10);
        list.displayASC();

        list.clear();
        System.out.println(list.getIndex("Alpha"));
    }
}