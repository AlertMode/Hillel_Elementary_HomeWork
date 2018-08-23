package edu.palmirov.hillel.task_13.CharList;

import java.util.Arrays;

public class CharList {
    private char[] array; //The 'char' array. Nothing special. Pass on, please.
    private int activeIndex = 0; //Points on the latest added element by add() method.

    //Well, it's the default constructor with the defined size of the future 'char' array.
    public CharList(){
        this(10);
    }

    //The constructor, providing the possibility of creating an array with the user definable length.
    public CharList(int size){
        create(size);
    }

    //Creates a new array 'char' object with the input of planned length.
    private void create(int length){
        int condition = 1;
        int plan = 1;
        if(length < condition){ length = plan; }
        this.array = new char[length];
    }

    //Adds one value to the 'char' array. Pretty logical, isn't it, my friend?
    public void add(char value){
        if(this.array[activeIndex] != 0){
            extend(1);
            ++activeIndex;
        }
        this.array[activeIndex] = value;
    }

    //Adds one value to the 'char' array's cell with the user definable index.
    public boolean set(char value, int index){
        if(this.outOfArrayBoundary(index)){ return false; }
        this.array[index] = value;
        return true;
    }

    //Adds every 'char' cell array's value to the class array.
    public void addAll(char[] array){
        if(array == null){ return; }

        int freeSpace = this.array.length;
        if(this.activeIndex != 0){
            freeSpace = this.array.length - this.activeIndex + 1;
        }

        if(freeSpace < array.length){ extend(array.length - freeSpace); }

        System.arraycopy(array, 0, this.array, activeIndex, array.length);
        this.activeIndex += array.length - 1;
    }

    //If array contains the cell with the input index, 'int' value (should be later converted by another user)
    //will be returned.
    public int get(int index){
        if(outOfArrayBoundary(index)){ return -1;}
        return (int)array[index];
    }

    //Returns 'true' if the index is set out of the boundary of the array.
    //Otherwise - 'false'.
    private boolean outOfArrayBoundary(int index){
        return this.array.length - 1 < index;
    }

    //Extends the 'char' array's size.
    private void extend(int amount){
            char[] temp = new char[this.array.length + amount];
            System.arraycopy(this.array, 0, temp, 0, this.array.length);
            this.array = temp;
    }

    //Narrows the 'char' array's size.
    private void narrow(int amount){
            char[] temp = new char[this.array.length - amount];
            System.arraycopy(this.array, 0, temp, 0, temp.length);
            this.array = temp;
    }

    //Returns 'char' array length.
    public int getSize(){
        return this.array.length;
    }

    //Returns 'char' array.
    public char[] toArray(){
        return this.array;
    }

    public int getActiveIndex(){
        return this.activeIndex;
    }

    //This method uses "bubble sort" to arrange the 'char' array.
    public void sort(Way way) {
        boolean condition;
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array.length; j++) {
                char temp = this.array[j];
                switch (way) {
                    case ASC:
                        condition = this.array[i] < this.array[j];
                        break;
                    case DESC:
                        condition = this.array[i] > this.array[j];
                        break;
                    default:
                        return;
                }
                if (condition) {
                    char book = this.array[i];
                    this.array[i] = this.array[j];
                    this.array[j] = book;
                }
            }
        }
    }

    @Override
    //Returns 'true' if the both objects are equal.
    public boolean equals(Object object) {
        if(object == null) { return false; }
        if(this == object) { return true; }
        if(!CharList.class.isAssignableFrom(object.getClass())){ return false;}
        CharList that = (CharList)object;

        boolean array = Arrays.equals(this.array, that.toArray());
        boolean activeIndex = this.activeIndex == that.getActiveIndex();

        return array && activeIndex;
    }

    //Sets the user definable array's cell to 'zero' value.
    public boolean clear(int index){
        if(this.outOfArrayBoundary(index)){
            return false;
        }
        this.array[index] = 0;
        if(index == this.activeIndex){ --this.activeIndex; }
        return true;
    }

    //Sets all array's cells to 'zero' value.
    public void clearAll(){
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = 0;
        }
        this.activeIndex = 0;
    }


    //Deletes all the cell from array.
    public void deleteAll(){
        int length = this.array.length - 1;
        this.narrow(length);
        this.activeIndex = 0;
    }

    //Returns 'true' if the input index points on the occupied array's cell.
    private boolean isOccupied(int index){
        return this.outOfArrayBoundary(index) || this.array[index] != 0;
    }
}