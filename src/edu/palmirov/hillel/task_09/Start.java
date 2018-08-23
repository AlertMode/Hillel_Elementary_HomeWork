package edu.palmirov.hillel.task_09;

import edu.palmirov.hillel.task_09.ListChar.Direction;
import edu.palmirov.hillel.task_09.ListChar.ListChar;
import edu.palmirov.hillel.task_09.SetChar.SetChar;

public class Start {
    public static void main(String[] args){
        startListChar();
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        startSetChar();
    }

    private static void startListChar(){
        ListChar data = new ListChar(40);

        ListChar anotherData = new ListChar(40);
        data.printAll();
        lineBordering();

        anotherData.printAll();
        lineBordering();

        System.out.println(anotherData.set('+', 0) + "\n");
        anotherData.printAll();
        lineBordering();

        data.randomFill();
        data.printAll();
        lineBordering();

        anotherData.replace(data);
        anotherData.printAll();
        lineBordering();

        System.out.println(anotherData.equals(data));
        lineBordering();

        Direction downDir = Direction.DESC;
        Direction upDir = Direction.ASC;
        data.sort(downDir);
        anotherData.sort(upDir);
        data.printAll();
        lineBordering();

        anotherData.printAll();
        lineBordering();

        ListChar five = new ListChar(5);
        anotherData.clear();

        for(int i = 0; i <= anotherData.getFullSize() - 6; i++){
            anotherData.add((char)(i + 50));
        }

        five.randomFill(89, 98);

        anotherData.printAll();
        lineBordering();

        five.printAll();
        lineBordering();

        System.out.println(anotherData.addAll(five));
        anotherData.printAll();
        lineBordering();
    }

    private static void startSetChar(){
        SetChar data = new SetChar(10);
        data.randomFill(65, 122);
        SetChar anotherData = new SetChar(10);
        anotherData.randomFill();

        data.printAll();
        lineBordering();

        anotherData.printAll();
        lineBordering();


        ListChar parent = new ListChar(5);
        parent.randomFill(65, 122);
        System.out.println(parent.getUniqueLength());

        parent.printAll();
        lineBordering();

        anotherData.clear();
        for(int i = 0; i < 5; i++){
            anotherData.add((char)(i + 78));
        }

        anotherData.printAll();
        lineBordering();

        anotherData.addAll(parent);
        anotherData.printAll();
        lineBordering();
    }

    private static void lineBordering(){
        System.out.println("----------------------------------------------------\n");
    }

}