package edu.palmirov.hillel.task_16;

/*
Task 16

Имеются описания двух интерфейсов:

public interface Digital {
    void display();
}

public interface Searchable {
    int found(String text);
}

Реализовать абстрактный класс Book с методами:
 - String getTitle();
 - int getYear();
 - abstract getContent();

Реализовать не абстрактный класс DigitalBook имплементирующий интерфейсы Searchable и Digital.
 - getContent() метод должен возвращать строку вида: "[title] - [year]"
 - display() метод должен выводить строку полученную из метода getContent().
 - found() метод должен возвращать какое-то число, например, любое число от 1 до 1000.
  (Смысл метода - поиск заданного текста в эл. книге,
    но в нашем случае мы создаем просто метод-заглушку без настоящей реализации).

Реализовать не абстрактный класс OldDigitalBook имплементирующий только интерфейс Digital.
 - getContent() метод делает все тоже самое что и в классе DigitalBook.

Реализовать не абстрактный класс PaperBook с методами:
 - getContent() метод должен возвращать строку вида "IncompatibleBookFormat"

Реализовать основной класс с методом public static void main(String[] args) в котором:
  a. создать несколько экземпляров электронных (двух видов) и бумажных книг;
  b. поместить все экземпляры книг(всех типов) в один массив;
  c. в цикле перебирая каждый элемент массива книг сделать следующее:
    - если текущая книга имплементирует интерфейс Digital и Searchable, то вызвать метод display() для каждой из книг, а также выводить результат вызова метода found();
	- если текущая книга имплементирует только интерфейс Digital, то вызвать метод display() для каждой из книг;
    - если текущая книга не имплементирует интерфейс Digital, то выводить на экран результат вызова метода getContent().

Примечание: проверить имплементирует ли экземпляр класса какой-либо интерфейс можно с помощью оператора "instanceof", например
  boolean result = currentBook instanceof Searchable;

Совет: выполняя это задание (и не только это) можно создать sub-package с названием например abstraction и поместить туда все описания интерфейсов и абстрактных классов.


Task 17

После выполнения Task 16.
Добавьте еще один интерфейс ModernDigital, который должен быть унаследован от двух ранее созданных интерфейсов: Searchable и Digital, а также должен содержать еще одну дополнительную сигнатуру для метода:
void updateFirmWare();

Реализуйте класс ModernDigitalBook имплементирующий интерфейс ModernDigital.
Имплементация методов не принципиальна (можно оставить хоть пустыми).
Note: Наследование в интерфейсов в java делается с пом. ключевого слова extends через запятую в случае необходимости наследоваться сразу от нескольких интерфейсов, например, “interface ... extends CanCopy, CanPaste, Can Remove”,
где CanCopy, CanPaste, Can Remove - некие существующие интерфейсы.
*/

import edu.palmirov.hillel.task_16.abstraction.*;

public class Start {
    public static void main(String[] args){
        ModernDigitalBook modernDigitalBook1 = new ModernDigitalBook("Ководство", 2014);
        ModernDigitalBook modernDigitalBook2 = new ModernDigitalBook("The mist", 1980);
        DigitalBook digitalBook1 = new DigitalBook("Что делать?", 1867);
        DigitalBook digitalBook2 = new DigitalBook("Forrest Gump", 1986);
        OldDigitalBook oldDigitalBook1 = new OldDigitalBook("C++ for Dummies", 1994);
        OldDigitalBook oldDigitalBook2 = new OldDigitalBook("Чапаев и Пустота", 1996);
        PaperBook paperBook1 = new PaperBook("Начала", 1948);
        PaperBook paperBook2 = new PaperBook("The Naked and The Dead", 1948);

        Book[] array = new Book[]{modernDigitalBook1, modernDigitalBook2,
                digitalBook1, digitalBook2,
                oldDigitalBook1, oldDigitalBook2,
                paperBook1, paperBook2};

        for(int i = 0; i < array.length; i++){
            if(array[i] instanceof ModernDigital){
                ModernDigitalBook temp = (ModernDigitalBook) array[i];
                temp.displays();
                System.out.println(temp.found("StG-44"));
                temp.updateFirmWare();
                borderLine();
            }

            if((array[i] instanceof Searchable && array[i] instanceof Digital) && !(array[i] instanceof ModernDigitalBook)){
                DigitalBook temp = (DigitalBook) array[i];
                temp.displays();
                System.out.println(temp.found("Hi!"));
                borderLine();
            }

            if(array[i] instanceof Digital && !(array[i] instanceof Searchable) && !(array[i] instanceof ModernDigitalBook)){
                OldDigitalBook temp = (OldDigitalBook) array[i];
                temp.displays();
                borderLine();
            }

            if(!(array[i] instanceof Digital) && !(array[i] instanceof Searchable)){
                PaperBook temp = (PaperBook)array[i];
                System.out.println(temp.getContent());
                borderLine();
            }
        }
    }

    private static void borderLine(){
        System.out.println("-----------------------------------------------------");
    }
}