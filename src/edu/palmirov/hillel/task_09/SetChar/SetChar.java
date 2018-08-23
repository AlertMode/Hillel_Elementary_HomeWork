package edu.palmirov.hillel.task_09.SetChar;

/*
B.
Реализуйте класс SetChar полностью повторяющий функционал списка, но с одним исключением.
Данный класс контейнер не может содержать дубликаты элементов.
Например, ваш объект класса SetChar в какой-то момент времени уже содержит такой набор элементов {a, g, v, d}
при попытке вызвать метод add(‘e’) произойдет успешное добавление нового элемента {a, g, v, d, e},
но если вызвать add(‘g’),  то новый элемент добавлен не будет и метод add(‘g’) - просто вернет false,
а набор элементов останется прежним.
*/

import edu.palmirov.hillel.task_09.ListChar.ListChar;

public class SetChar extends ListChar {

    //Just the default constructor. Nothing special here.
    public SetChar(){
        super();
    }

    //Well, another constructor with 'int' parameter.
    public SetChar(int length){
        super(length);
    }

    @Override
    public boolean add(char element) {
        //Returns 'true' if the element is added.
        return !this.hasSame(element) && super.add(element);
    }

    //An overridden "addAll" function for consuming only unique elements to its inner array.
    //If the 'char' element is already presented in the array, it won't be added.
    @Override
    public boolean addAll(ListChar array) {
        char[] chars = array.getUnique();
        if(chars.length > this.getFullSize() - this.getCurrentIndex()){ return false; }
        for (int i = 0; i < chars.length; i++) {
            if(!this.hasSame(chars[i])){
                super.add(chars[i]);
            }
        }
        return true;
    }

    //If there is no such an element in the whole array, it will be added.
    //So, the 'true' value will be returned. Otherwise, you'll get - 'false'.
    @Override
    public boolean set(char element, int index) {
        return !this.hasSame(element) && super.set(element, index);
    }

    @Override
    public boolean replace(ListChar array) {
        //Returns true if the all the elements are replaced.
        char[] host = array.getUnique();
        if(host.length > this.getFullSize()){
            return false;
        }
        this.clear();

        for(int i = 0; i < host.length; i++){
            this.add(host[i]);
        }
        return true;
    }

    protected boolean hasSame(char element){
        //Returns 'true' if the input 'char' element doesn't exists.
        for(int i = 0; i < this.getFullSize(); i++) {
            if (this.get(i) == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void randomFill() {
        //Randomly fills 'SetChar' array with unique elements;
        this.clear();
        int minChar = 0;
        int maxChar = 1_112_064;
        int range = (maxChar - minChar) + 1;
        for(int i = 0; i < this.getFullSize(); i++){
            char temp = 0;
            while(!this.add(temp)){
                temp = (char)((int)(Math.random() * range) + minChar);
            }
        }
    }

    @Override
    public void randomFill(int minChar, int maxChar) {
        //Randomly fills all the 'SetChar' cells with the input range values.
        if((maxChar < 0 || maxChar > 1_112_064) || minChar < 0){
            this.randomFill();
            return;
        }

        if(maxChar < minChar){
            int temp = maxChar;
            maxChar = minChar;
            minChar = temp;
        }

        int range = (maxChar - minChar) + 1;
        for(int i = 0; i < this.getFullSize(); i++){
            char temp = 0;
            while(!this.add(temp)){
                temp = (char)((int)(Math.random() * range) + minChar);
            }
            this.add(temp);
        }
    }
}