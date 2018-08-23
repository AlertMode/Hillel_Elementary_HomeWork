package edu.palmirov.hillel.task_06;

/*
Task 6

Написать рекурсивную функцию подсчета суммы элементов этого ряда для первых N элементов:
	F = K*1 + K*2 +K*3 + K*4 +K*5 + … + K*N,

	где N <= 30, а K - константа K = 3

	При N = 1, сумма будет равна: ‘3’.
	При N = 30, сумма должна быть равна: ‘463255047212913’.

	Note: Используйте для конечной суммы тип данных long.

      b.  Написать функцию сравнения двух одномерных массивов типа char.
	В случае, если содержимое массивов равно, то возвращать true, а иначе false.
	Note: Используйте при этом цикл вида foreach: for (type your_variable: array[] )
*/

public class Loops {
    public static void main(String[] args)
    {
        System.out.println(elementCounter(3, 30) + "\n");
        char[] arrayA = randomFiller(10);
        char[] arrayB = randomFiller(10);
        System.out.println("The array 'A'");
        printArray(arrayA);
        System.out.println("The array 'B'");
        printArray(arrayB);
        System.out.println("The result of checking their similarity: " + compare(arrayA, arrayB) + "\n");
        char[] arrayC = new char[]{'e', '4', '%', '[', '\'', 'n', '/'};
        char[] arrayD = new char[]{'e', '4', '%', '[', '\'', 'n', '/'};
        System.out.println("The array 'C'");
        printArray(arrayC);
        System.out.println("The array 'D'");
        printArray(arrayD);
        System.out.println("The result of checking their similarity: " + compare(arrayC, arrayD));

    }

    private static long elementCounter(int constant, int value) //Exercise 'a'
    {
        //Returns the sum of constant's and value's products. The value is descending step-by-step
        // to '0' value by each function call.
        if(value == 0){
            return 0;
        }
        if(constant == 0){
            constant = 1;
        }
        return elementCounter(constant, value - 1) + constant * value;
    }

    private static char[] randomFiller(int arrayLength)
    {   //A secondary method, created in order to generate random characters
        // in a range of '0' to '1,112,064' that are presented in UTF-8.
        int minChar = 0;
        int maxChar = 1_112_064;
        int range = (maxChar - minChar) + 1;
        char[] array = new char[arrayLength];
        for(int i = 0; i < arrayLength; i++){
           array[i] = (char)((int)(Math.random() * range) + minChar);
        }
        return array;
    }

    private static void printArray(char[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("Array[" + i + "]: " + array[i]);
        }
        System.out.println();
    }

    private static boolean compare(char[] arrayA, char[] arrayB) //Exercise 'a'
    {
        //Returns 'true' if every two cells from two char arrays have the same characters,
        //and 'false' if they don't.
        if(arrayA == arrayB) { return false; }
        if(arrayA.length != arrayB.length) { return false; }
        int index = 0;
        for(int cell : arrayA){
            if(cell != arrayB[index]){
                return false;
            }
            ++index;
        }
        return true;
    }
}