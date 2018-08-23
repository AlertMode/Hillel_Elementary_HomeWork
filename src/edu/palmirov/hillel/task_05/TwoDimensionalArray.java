package edu.palmirov.hillel.task_05;

/*
Task 5

b. Двумерный массив 10х10, заполнить случайными числами от -20 до 20. Реализовать функции:
    определения суммы всех элементов массива,
    среднее арифметическое,
    минимальный элемент,
    максимальный элемент,
    кол-во положительных элементов,
    кол-во отрицательных элементов.
 */

public class TwoDimensionalArray {
    public static void main(String[] args){
        int[][] intArray = getFullTwoDimensionalArrayInt(10, 10, -20, 20);
        double[][] doubleArray = getFullTwoDimensionalArrayDouble(10, 10, -20, 20);
        printIntegerCellValue(intArray);
        printDoubleCellValue(doubleArray);
        System.out.println("The sum of all the two dimensional array's elements" +
                "\nInteger: " + getArrayIntegerSum(intArray) +
                "\nDouble: " + getArrayDoubleSum(doubleArray) +
                "\n-------------------------------------------------------------------\n");
        System.out.println("The arithmetical average of the two dimensional array's elements" +
                "\nInteger: " + getArithmeticAverageInt(intArray) +
                "\nDouble: " + getArithmeticAverageDouble(doubleArray) +
                "\n-------------------------------------------------------------------\n");
        System.out.println("The minimum value of the two dimensional array's elements " +
                "\nInteger: " + getMinimumArrayValueInt(intArray) +
                "\nDouble: " + getMinimumArrayValueDouble(doubleArray) +
                "\n-------------------------------------------------------------------\n");
        System.out.println("The maximum value of the two dimensional array's elements" +
                        "\nInteger: " + getMaximumArrayValueInt(intArray) +
                        "\nDouble: " + getMaximumArrayValueDouble(doubleArray) +
                        "\n-------------------------------------------------------------------\n");
        System.out.println("The number of positive values of the two dimensional array's elements" +
                "\nInteger: " + getPositiveElementsQuantityInt(intArray) +
                "\nDouble: " + getPositiveElementsQuantityDouble(doubleArray) +
                "\n-------------------------------------------------------------------\n");
        System.out.println("The number of negative values of the two dimensional array's elements" +
                "\nInteger: " + getNegativeElementsQuantityInt(intArray) +
                "\nDouble: " + getNegativeElementsQuantityDouble(doubleArray) +
                "\n-------------------------------------------------------------------\n");
        System.out.println("The number of zero values of the two dimensional array's elements" +
                "\nInteger: " + getZeroElementsQuantityInt(intArray) +
                "\nDouble: " + getZeroElementsQuantityDouble(doubleArray) +
                "\n-------------------------------------------------------------------\n");
    }

    public static int[][] getFullTwoDimensionalArrayInt(int firstColumn, int secondColumn, int minNumb, int maxNumb){
        //This function fill a double dimension array
        // with a randomly generated integer numbers,
        // a range of which is defined by user.
        int [][] intArray = new int[firstColumn][secondColumn];
        for (int i = 0; i < intArray.length; i++) {
            for(int j = 0; j < intArray[i].length; j++){
                intArray[i][j] = randomIntegerNumber(minNumb, maxNumb);
            }
        }
        return intArray;
    }

    public static double[][] getFullTwoDimensionalArrayDouble(int firstColumn, int secondColumn, double minNumb, double maxNumb){
        //This function fill a double dimension array
        // with a randomly generated floating-point numbers,
        // a range of which is defined by user.
        double [][] doubleArray = new double[firstColumn][secondColumn];
        for (int i = 0; i < doubleArray.length; i++) {
            for(int j = 0; j < doubleArray[i].length; j++){
                doubleArray[i][j] = round(randomDoubleNumber(minNumb, maxNumb), 2);
            }
        }
        return doubleArray;
    }

    public static double round(double value, int precision) {
        if(precision == 0){
            precision = 2;
        } else {
            precision = Math.abs(precision);
        }
        //This secondary function rounds any floating-point number
        // to any decimal places.
        // Source:  https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    private static int randomIntegerNumber(int minNumb, int maxNumb){
        //This function returns a randomly generated integer number
        //within the defined range.
        if(maxNumb < minNumb){
            minNumb += maxNumb;
            maxNumb = minNumb - maxNumb;
        } else if(maxNumb == minNumb){
            maxNumb = 100;
            minNumb = -100;
        }
        int range = (maxNumb - minNumb)+ 1;
        return (int)(Math.random() * range) + minNumb;
    }

    private static double randomDoubleNumber(double minNumb, double maxNumb){
        //This function returns a randomly generated floating-point number
        //within the defined range.
        if(maxNumb < minNumb){
            minNumb += maxNumb;
            maxNumb = minNumb - maxNumb;
        } else if(maxNumb == minNumb){
            maxNumb = 100;
            minNumb = -100;
        }
        double range = maxNumb - minNumb;

        return (Math.random() * range) + minNumb;
    }

    public static void printIntegerCellValue(int[][] array){
        //A secondary function, created to print the every subarrays' integer value
        //of the main array.
        for (int j = 0; j < array.length; j++){
            for(int i = 0; i < array[j].length; i++){
                System.out.println("Subarray #" + j + " || Cell #" + i + " || Value: " + array[j][i]);
            }
            System.out.println("===================================================================");
        }
        System.out.println();
    }

    public static void printDoubleCellValue(double[][] array){
        //A secondary function, created to print the every subarrays' double value
        //of the main array.
        for (int j = 0; j < array.length; j++){
            for(int i = 0; i < array[j].length; i++){
                System.out.println("Subarray #" + j + " || Cell #" + i + " || Value: " + array[j][i]);
            }
            System.out.println("===================================================================");
        }
        System.out.println();
    }

    private static long getArrayIntegerSum(int[][] array){ //Exercise 'b.1' - Integer
        //This function returns the sum of all subarrays cells' integer numbers.
        long sum = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                sum += array[i][j];
            }
        }
        return sum;
    }

    private static double getArrayDoubleSum(double[][] array){ //Exercise 'b.1' - Double
        //This function returns the sum of all subarrays cells' floating-point numbers.
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return round(sum, 2);
    }

    private static long getArithmeticAverageInt(int[][] array){ //Exercise 'b.2' - Integer
        //Returns an average mean of two dimensional array's integer cells.
        int amount = 0;
        for(int i = 0; i < array.length; i++){
            amount += array[i].length;
        }
        return getArrayIntegerSum(array) / amount;
    }

    private static double getArithmeticAverageDouble(double[][] array){ //Exercise 'b.2' - Double
        //Returns an average mean of two dimensional array's floating-point cells.
        int amount = 0;
        for(int i = 0; i < array.length; i++){
            amount += array[i].length;
        }
        return round(getArrayDoubleSum(array) / amount, 2);
    }

    private static String getMinimumArrayValueInt(int[][] array){ //Exercise 'b.3' - Integer
        //Returns the minimum value of two dimensional array's integer cells.
        int minimumValue = 0;
        int subarr = 0;
        int cell = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(minimumValue > array[i][j]){
                minimumValue = array[i][j];
                subarr = i;
                cell = j;
                }
            }
        }
        return "Subarray #" + subarr + " || Cell #" + cell + " || Value: " + minimumValue;
    }

    private static String getMinimumArrayValueDouble(double[][] array){ //Exercise 'b.3' - Double
        //Returns the minimum value of two dimensional array's floating-point cells.
        double minimumValue = 0;
        int subarr = 0;
        int cell = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(minimumValue > array[i][j]){
                    minimumValue = array[i][j];
                    subarr = i;
                    cell = j;
                }
            }
        }
        return "Subarray #" + subarr + " || Cell #" + cell + " || Value: " + round(minimumValue, 2);
    }

    private static String getMaximumArrayValueInt(int[][] array){ //Exercise 'b.4' - Integer
        //Returns the maximum value of two dimensional array's integer cells.
        int maximumValue = 0;
        int subarr = 0;
        int cell = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(maximumValue < array[i][j]){
                    maximumValue = array[i][j];
                    subarr = i;
                    cell = j;
                }
            }
        }
        return "Subarray #" + subarr + " || Cell #" + cell + " || Value: " + maximumValue;
    }

    private static String getMaximumArrayValueDouble(double[][] array){ //Exercise 'b.4' - Double
        //Returns the maximum value of two dimensional array's integer cells.
        double maximumValue = 0;
        int subarr = 0;
        int cell = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(maximumValue < array[i][j]){
                    maximumValue = array[i][j];
                    subarr = i;
                    cell = j;
                }
            }
        }
        return "Subarray #" + subarr + " || Cell #" + cell + " || Value: " + round(maximumValue, 2);
    }

    private static int getPositiveElementsQuantityInt(int[][] array){ //Exercise 'b.5' - Integer
        //Returns a number of positive values in an integer two dimensional array.
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] > 0){
                    ++counter;
                }
            }
        }
        return counter;
    }

    private static int getPositiveElementsQuantityDouble(double[][] array){ //Exercise 'b.5' - Double
        //Returns a number of positive values in a double two dimensional array.
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] > 0){
                    ++counter;
                }
            }
        }
        return counter;
    }

    private static int getNegativeElementsQuantityInt(int[][] array){ //Exercise 'b.6' - Integer
        //Returns a number of negative values in an integer two dimensional array.
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] < 0){
                    ++counter;
                }
            }
        }
        return counter;
    }

    private static int getNegativeElementsQuantityDouble(double[][] array){ //Exercise 'b.6' - Double
        //Returns a number of negative values in a double two dimensional array.
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] < 0){
                    ++counter;
                }
            }
        }
        return counter;
    }

    private static int getZeroElementsQuantityInt(int[][] array){ //Exercise 'b.7' - Integer
        //Returns a number of zero values in an integer two dimensional array.
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == 0){
                    ++counter;
                }
            }
        }
        return counter;
    }

    private static int getZeroElementsQuantityDouble(double[][] array){ //Exercise 'b.7' - Double
        //Returns a number of zero values in a double two dimensional array.
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == 0){
                    ++counter;
                }
            }
        }
        return counter;
    }
}