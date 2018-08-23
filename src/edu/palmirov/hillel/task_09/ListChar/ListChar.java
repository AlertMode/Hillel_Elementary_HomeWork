package edu.palmirov.hillel.task_09.ListChar;
/*
A.
 Создайте класс-контейнер с именем ListChar, основное назначение которого - это хранение множества элементов типа char.
Размер ListChar по умолчание должен быть равен 30 элементам.
Предусмотрите возможность создания экземпляров вашего класса двумя способами:
1) через оператор new() без параметров;
2) через оператор new(size), где size - число определяющее размер вашего ListChar отличный от размера по умолчанию.

Функционал:
добавлять (add);
устанавливать новое значение по индексу (set);
доставать по индексу (get);
проверять наличие элемента (contains);
добавлять все элементы из другого контейнера (addAll);
проверять на равенство (equals);
очищать (clear);
находить индекс элемента (indexOf);
узнавать общий размер листа без учета занятых ячеек (getFullSize);
узнавать кол-во незанятых элементов списка (getFreeSize);
получать длину занятых ячеек листа (length);
если лист пустой, вернуть true (isEmpty);
сортировать (sort) (используйте один из алгоритмов:
bulb, insertion, selection, quicksort, mergesort, … or here your choice).
	Также сортировка может быть осуществлена как по возрастанию так и наоборот.
	сортировка определяется набором из всего двух возможных вариантов (ASC - возрастание, DESC - убывание).

В случае неудачи при попытке добавить новый элемент add верните false, например, при уже и так максимально заполненном листе. Аналогичное поведение для set и replace.
При имплементации replace, если реальный размер занятых ячеек добавляемого листа (length) превышает кол-во незанятых элементов расширяемого листа (getFreeSize), то не добавлять вообще ни одного элемента, а просто вернуть false.
Смотрите дополнительные комментарии напротив представленных сигнатур методов ниже.
Ваш класс должен иметь следующие сигнатуры для public методов:

public class ListChar {
  public boolean add(char e); // add a new char to list
  public boolean set(int index, char c); // set a char to a place located by the index
  public int get(int index); // get a code of char by the index or -1 in case element wasn't found by the index
  public boolean contains(char c); // true if list contains a char c
  public boolean addAll(ListChar listChar); // add all elements from another list
  public boolean equals(ListChar c); // compare two ListChar
  public void clear(); // clear all elements of list
  public int indexOf(char c); // return index of found element else if not then -1
   public int getFullSize(); // return full size of all list
   public int getFreeSize(); // return number of free elements of list
   public int length(); // return current size
   public boolean isEmpty(); // true, if list is empty
   public void sort(Direction d); // sorting elements inside current list
}

Для реализации Direction используйте перечисление enum с двумя возможными вариантами ASC и DESC).
*/

import java.util.Arrays;

public class ListChar {

    private int size = 30;
    private char[] array;
    private int currentIndex = 0;

    public ListChar(){
        //The default constructor;
        createArray(this.size);
    }

    public ListChar(int length){
        //The constructor for creating 'ListChar' array with a defined size.
        createArray(length);
    }

    private void createArray(int length){
        //Creates an array with the defined length.
        if(length > 1) {
            this.array = new char[length];
            size = array.length;
        } else {
            this.array = new char[this.size];
        }
    }

    private boolean outOfArrayBoundary(int index){
        //Returns 'true' if the index is set out of the boundary of the array.
        //Otherwise - 'false'.
        return array.length - 1 < index;
    }

    private boolean isSameSize(ListChar array){
        //Returns 'true' if the length of the both arrays is equal.
        return this.array.length == array.getFullSize();
    }

    public boolean add(char element){
        //Adds an element to the array. The elements' positions start from the very first cell [0]
        //and move to the very last [array.length - 1]. Each method call variable "currentIndex"
        // points on the new empty (sometimes not) cell in the array. Returns 'true' if the element
        //is added and 'false' if it isn't.
        boolean result = this.set(element, currentIndex);
        ++currentIndex;
        return result;
    }

    public boolean set(char element, int index){
        //Adds an element to the array with account of the input index.
        //Returns 'true' if the element is added and 'false' if it isn't.
        if(outOfArrayBoundary(index)){ return false; }

        array[index] = element;
        return true;
    }

    public int get(int index){
        //Returns the element's value by index. If there is no such index - returns '-1';
        if (outOfArrayBoundary(index)) { return -1; }

        return array[index];
    }

    public boolean contains(char value){
        //Returns 'true' if the input 'char' value exists in the array.
        for(char temp : this.array){
            if(temp == value){
                return true;
            }
        }
        return false;
    }

    public boolean addAll(ListChar array){
        //Returns 'true' if one array is totally added to the current;
        if(this.equals(array) || this.array.length - this.currentIndex < array.getFullSize()) {
            return false; }
        boolean result;
        for(int i = this.currentIndex, j = 0; i < this.getFullSize(); i++, j++){
            this.set((char)array.get(j), j);
        }
        return true;
    }

    public boolean replace(ListChar array){
        //Returns 'true' if one array is successfully copied to another.
        if(this.equals(array) || this.array.length < array.getFullSize()) { return false; }

        for(int i = 0; i < this.array.length; i++){
            this.array[i] = (char)array.get(i);
        }
        return true;
    }

    @Override
    public boolean equals(Object object){
        //Returns 'true' if the both objects are equal.
        if(object == null){
            return false;
        }
        if(this == object){
            return true;
        }
        if(!ListChar.class.isAssignableFrom(object.getClass())){
            return true;
        }
        ListChar that = (ListChar)object;
        boolean size = this.size == that.getFullSize();
        boolean array = Arrays.equals(this.array, that.toChar());
        boolean currentIndex = this.currentIndex == that.getCurrentIndex();

        return size && array && currentIndex;
    }

    public void clear(){
        //Set all the array's elements to '0' value.
        for(int i = 0; i < this.array.length; i++){
            this.array[i] = 0;
        }
        currentIndex = 0;
    }

    public int indexOf(char value){
        //Returns the array's index if such 'char' value exists in the array.
        for(int temp : this.array){
            if(temp == value){
                return temp;
            }
        }
        return -1;
    }

    public int getFullSize(){
        //Returns the size of the 'ListChar' array.
        return size;
    }

    public int getFreeSize(){
        //Returns the quantity (size) of the 'ListChar' array's empty cells.
        return this.array.length - (currentIndex + 1);
//        int count = 0;
//        for(int temp : this.array){
//            if(temp == 0){
//                ++count;
//            }
//        }
//        return count;
    }

    public int length(){
        //Returns the size of the 'ListChar' array's filled cells.
        return currentIndex + 1;
//        int count = 0;
//        for(int temp : this.array){
//            if(temp != 0){
//                ++count;
//            }
//        }
//        return count;
    }

    public boolean isEmpty(){
        //Returns 'true' if the values of all array's cells are '0'.
        if(currentIndex == 0 && this.array[currentIndex] == 0){
            return true;
        }
        return false;
//        for(int temp : this.array){
//            if(temp != 0){
//                return false;
//            }
//        }
//        return true;
    }

    public void sort(Direction value){
        //The given method sorts the 'ListChar' array by using bubble algorithm.
        boolean condition;
        int length = this.array.length;
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                switch (value){
                    case ASC: condition = array[i] > array[j];
                    break;
                    case DESC: condition = array[i] < array[j];
                    break;
                    default:
                        System.out.println("Wrong function argument input!");
                        return;
                }
                if(condition){
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void randomFill(){
        //Randomly fills all the 'ListChar' cells with the default range values.
        this.clear();
        int minChar = 0;
        int maxChar = 1_112_064;
        int range = (maxChar - minChar) + 1;
        for(int j = 0; j < this.getFullSize(); j++){
            this.add((char)((int)(Math.random() * range) + minChar));
        }
    }

    public void randomFill(int minChar, int maxChar){
        //Randomly fills all the 'ListChar' cells with the input range values.
        this.clear();
        if((maxChar < 0 || maxChar > 1_112_064) || minChar < 0){
            randomFill();
            return;
        }

        if(maxChar < minChar){
            int temp = maxChar;
            maxChar = minChar;
            minChar = temp;
        }

        int range = (maxChar - minChar) + 1;
        for(int j = 0; j < this.getFullSize(); j++){
            this.add((char)((int)(Math.random() * range) + minChar));
        }
    }

    public void printAll(){
        //Prints all the existing cells in the "ListChar" array.
        for(int i = 0; i < this.getFullSize(); i++){
            System.out.println("Cell #" + i + " : " + (char)this.get(i));
        }
    }

    public char[] toChar(){
        //Returns the 'char' array with the all elements.
        return this.array;
    }

    public int getUniqueLength() {
        //Returns the number of unique elements in the array.
        int counter = 0;
        int result = 0;
        for (int i = 0; i < this.getFullSize(); i++) {
            char temp = (char) this.get(i);
                if (this.contains(temp)) { ++counter; }
                if(counter == 1){
                    ++result;
                }
                counter = 0;
        }
        return result;
    }

    public char[] getUnique(){
        //Returns 'char' array with the unique elements.
        char[] temp = new char[getUniqueLength()];
        int counter = 0;
        for (int i = 0; i < this.getFullSize(); i++) {
            char value = (char)this.get(i);
            boolean statement = false;
            for (int j = 0; j < temp.length; j++) {
                if(temp[j] == value){ statement = true; break; }
            }
            if(!statement){
                temp[counter] = value;
                ++counter;
            }
        }
        return temp;
    }

    public int quantityOf(char value){
        //Returns the quantity of the input 'char' value in the array.
        int counter = 0;
        for(char temp : this.array){
            if(temp == value){
                ++counter;
            }
        }
        return counter;
    }

    public int getCurrentIndex(){
        //Returns the value of the index, pointing on the next cells after last added element.
        return currentIndex;
    }
}