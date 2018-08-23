package edu.palmirov.hillel.task_05;

import static edu.palmirov.hillel.task_05.TwoDimensionalArray.*;
import static edu.palmirov.hillel.task_04.SelectionStatements.*;
/*
Task 5 "true"

c. В числовой матрице 5x2 поменять местами два столбца,
т. е. все элементы одного столбца поставить на соответствующие им позиции другого,
а его элементы второго переместить в первый.
 */

public class ArrayMatrixTable {
    public static void main(String[] args){
        int[][] intArray = getFullTwoDimensionalArrayInt(5, 2, -40, 40);
        double[][] doubleArray = getFullTwoDimensionalArrayDouble(4, 5, -100, 100 );
        System.out.println("The exchange of subarrays' integer matrix column \n\nBefore the exchange:");
        printMatrixArray(intArray);
        getMatrixArrayTablesExchange(intArray);
        System.out.println("\nAfter the exchange:");
        printMatrixArray(intArray);
        System.out.println("The exchange of subarrays floating-point matrix column \n\nBefore the exchange:");
        printMatrixArray(doubleArray);
        getMatrixArrayTablesExchange(doubleArray);
        System.out.println("\nAfter the exchange:");
        printMatrixArray(doubleArray);
        System.out.println("The biggest sum among the matrix columns " +
                "\nInteger: " + getMatrixTableSum(intArray) +
                "\nDouble: " + getMatrixTableSum(doubleArray));
    }

    public static int getTwoDimensionalArrayMaxDigitValue(int[][] array){ //Remade from exercise 'b.4' - Integer
        //Returns the maximum digit value of two dimensional array's integer cells.
        int maximumDigit = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                int absValue = Math.abs(array[i][j]);
                if(maximumDigit < absValue){
                    maximumDigit = absValue;
                }
            }
        }
        return maximumDigit;
    }

    public static double getTwoDimensionalArrayMaxDigitValue(double[][] array){ //Remade from exercise 'b.4' - Integer
        //Returns the maximum digit value of two dimensional array's floating-point cells.
        double maximumDigit = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                double absValue = Math.abs(array[i][j]);
                if(maximumDigit < absValue){
                    maximumDigit = absValue;
                }
            }
        }
        return maximumDigit;
    }

    private static void printMatrixArray(int[][] array){
        //A secondary method, created in order to easily print
        // the cells' integer values of all subarrays.
        int numberLength = digitCounter(getTwoDimensionalArrayMaxDigitValue(array));
        String format = "%" + (numberLength + 3) + "d\f";
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.printf(format, array[i][j]);
            }
            System.out.println();
        }
    }

    private static void printMatrixArray(double[][] array){
        //A secondary method, created in order to easily print
        // the cells' floating-point values of all subarrays.
        String digits = Double.toString(getTwoDimensionalArrayMaxDigitValue(array));
        int numberLength = digits.length();
        String format = "%" + (numberLength + 3) + ".2f\f";
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.printf(format, array[i][j]);
            }
            System.out.println();
        }
    }

    private static void getMatrixArrayTablesExchange(int[][] array){ //Exercise 'c' - Integer
        //The given method reverse the positions of the integer subarray's cells,
        //starting from the very first and the very last cells,
        //leading the exchange actions to the middle of the subarray.
        for(int i = 0; i < array.length; i++){
            for(int head = 0, tail = array[i].length - 1; head < array[i].length >> 1; head++, tail--){
                array[i][tail] += array[i][head];
                array[i][head] = array[i][tail] - array[i][head];
                array[i][tail] -= array[i][head];
            }
        }
    }

    private static void getMatrixArrayTablesExchange(double[][] array){ //Exercise 'c' - Double
        //The given method reverse the positions of the floating-point subarray's cells,
        //starting from the very first and the very last cells,
        //leading the exchange actions to the middle of the subarray.
        for(int i = 0; i < array.length; i++){
            for(int head = 0, tail = array[i].length - 1; head < array[i].length >> 1; head++, tail--){
                double temp = array[i][head];
                array[i][head] = array[i][tail];
                array[i][tail] = temp;
            }
        }
    }

    private static String getMatrixTableSum(int[][] array){ //Exercise 'd' - Integer
        //Returns the String-message, displaying the number of matrix column
        // with the biggest integer sum.
        int[] storage = new int[array[0].length];
        for(int i = 0; i < array[0].length; i++){
            for(int j = 0; j < array.length; j++){
                storage[i] += array[j][i];
            }
        }
        int[] result = getOneDimensionalArrayMaxValue(storage);
        return "Column #" + result[1] + " The sum: " + result[0];
    }

    private static int[] getOneDimensionalArrayMaxValue(int[] array){
        //A secondary function, created in order to find out the max value
        //among cells of an input integer array.
        int[] result = new int[]{array[0], 0};
        for(int i = 0; i < array.length; i++){
            if(result[0] < array[i]){
                result[0] = array[i];
                result[1] = i;
            }
        }
        return result;
    }

    private static String getMatrixTableSum(double[][] array){ //Exercise 'd' - Double
        //Returns the String-message, displaying the number of matrix column
        // with the biggest floating-point sum.
        double[] storage = new double[array[0].length];
        for(int i = 0; i < array[0].length; i++){
            for(int j = 0; j < array.length; j++){
                storage[i] = round(storage[i] + array[j][i], 2);
            }
        }
        double[] result = getOneDimensionalArrayMaxValue(storage);
        return "Column #" + (int)result[1] + " The sum: " + result[0];
    }

    private static double[] getOneDimensionalArrayMaxValue(double[] array){
        //A secondary function, created in order to find out the max value
        //among cells of an input integer array.
        double[] result = new double[]{array[0], 0};
        for(int i = 0; i < array.length; i++){
            if(result[0] < array[i]){
                result[0] = array[i];
                result[1] = i;
            }
        }
        return result;
    }
}