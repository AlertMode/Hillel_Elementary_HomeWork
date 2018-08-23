package edu.palmirov.hillel.task_05;

import static edu.palmirov.hillel.task_05.TwoDimensionalArray.*;
/*
Task 5 "false"

c. В числовой матрице 5x2 поменять местами два столбца,
т. е. все элементы одного столбца поставить на соответствующие им позиции другого,
а его элементы второго переместить в первый.
 */

public class ArraysExchange {
    public static void main(String[] args){
        int[][] intArray = getFullTwoDimensionalArrayInt(5, 2, -40, 40);
        double[][] doubleArray = getFullTwoDimensionalArrayDouble(3, 2, -500, 500);
        System.out.println("The exchange of integer subarrays \n\nBefore the exchange:");
        printIntegerCellValue(intArray);
        getSubarraysExchange(intArray);
        System.out.println("After the exchange:");
        printIntegerCellValue(intArray);
        System.out.println("The exchange of floating-point subarrays \n\nBefore the exchange:");
        printDoubleCellValue(doubleArray);
        getSubarraysExchange(doubleArray);
        System.out.println("After the exchange:");
        printDoubleCellValue(doubleArray);
    }

    private static void getSubarraysExchange(int[][] array){ //Task "c" - Integer
        //The given method reverse the positions of the integer subarrays,
        //starting from the very first and the very last subarray,
        //leading the exchange actions to the middle of the main array.
        for(int i = 0, j = array.length - 1; i < array.length >> 1; i++, j--){
                int[] temp = array[i].clone();
                array[i] = array[j].clone();
                array[j] = temp.clone();
        }
    }

    private static void getSubarraysExchange(double[][] array){ //Task "c" - Double
        //The given method reverse the positions of the floating-point subarrays,
        //starting from the very first and the very last subarrays,
        //leading the exchange actions to the middle of the main array.
        for(int i = 0, j = array.length - 1; i < array.length >> 1; i++, j--){
            double[] temp = array[i].clone();
            array[i] = array[j].clone();
            array[j] = temp.clone();
        }
    }
}