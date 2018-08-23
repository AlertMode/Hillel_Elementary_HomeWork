package edu.palmirov.hillel.task_13;

/*Task 13
        *примечание: эта задача только для тех, кто успешно выполнил задачу 9 и 12.

        Для Task 9 измените программу таким образом, чтобы при нехватке свободного места для выполнения добавления нового элемента с помощью методов add() и addAll()
        выполнялось расширение необходимого размера объекта контейнера в 2 раза с целью иметь возможность добавить новые элементы.

        Возможно, для выполнения этого задания вам понадобится иметь возможность копировать массивы. Сделать это можно как минимум двумя наиболее быстрыми способами:
        System.arraycopy(src, 0, dst, 0, length);
        где src - массив источник,
        2-й параметр - начальный индекс копирования,
        dst - массив приемник,
        3-й параметр - начальный индекс массива приемника,
        4-й параметр - количество копируемых элементов из src->dst.
        Воспользоваться одним из методов класса Arrays:
        char[] copyOf(char[] original, int newLength)
        где original - массив источник;
        newLength - новая длина возвращаемого массива.
*/

import edu.palmirov.hillel.task_13.CharList.*;

public class Start {
    public static void main(String[] args){
        CharList charList = new CharList();
        String message = "gnag  ag:Bpi-98IBF BGaebnaa nvafreayj";
        charList.addAll(message.toCharArray());
        printAll(charList);
        charList.add('%');
        printAll(charList);
        charList.sort(Way.ASC);
        printAll(charList);
    }

    static void printAll(CharList charList){
        for (int i = 0; i < charList.getSize(); i++) {
            System.out.println(i + " :: " + (char)charList.get(i));
        }
        System.out.println("=========");
    }
}