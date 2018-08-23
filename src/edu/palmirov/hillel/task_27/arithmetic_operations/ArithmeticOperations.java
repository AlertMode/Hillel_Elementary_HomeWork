package edu.palmirov.hillel.task_27.arithmetic_operations;

import java.util.Random;
import edu.palmirov.hillel.task_27.exceptions.NonZeroArgsException;
import edu.palmirov.hillel.task_27.exceptions.InvalidOperationException;
import edu.palmirov.hillel.task_27.exceptions.MinMaxMismatchingException;

/*
 * Task 27
 *
 * Создать два собственных Exception класса:
 *
 *
 * Check exception:
 * Имя класса: NonZeroArgsException.
 * bMessage: “Arguments cannot be negative.”
 *
 *
 * Unchecked exception:
 * Имя класса: InvalidOperationException.
 * Message: “This operation doesn’t allow here.”
 *
 * 3) Предположим имеется такой статический метод:
 *
 * public static long processPositiveNumbers(int[] nums, char op) throws NonZeroArgsException {
 *        long result = 0;
 *        for (int num : nums) {
 *            if (num<0) {
 *                throw new NonZeroArgsException("Arguments are less zero.");
 *            }
 *            switch (op) {
 *                case '+' :
 *                    result += num;
 *                    break;
 *               case '-' :
 *                   result -= num;
 *                   break;
 *               case '*':
 *                   result *= num;
 *                   break;
 *               default:
 *                   throw new InvalidOperationException("Not supported operation.");
 *           }
 *       }
 *       return result;
 *   }
 *
 * Ваша задача написать код, который который будет передавать массив целых чисел в метод processPositiveNumbers(),
 * а также обрабатывать (try..catch) соответствующее checked  исключение,
 * а именно выводить стектрейс на экран printStackTrace().
 */

public class ArithmeticOperations {

    private static int count = 1;

    public static void main(String[] args){
        yippeeKiYay(10, 0, 10);
        yippeeKiYay(10, -1, 9);
        yippeeKiYay(10, 10, 1);
        geronimo(-1, 0, 10, '+');
        geronimo(10, 0, 10, '/');
    }


    public static void yippeeKiYay(int length, int min, int max){
        System.out.println("Exception test #" + count++);
        long addition = 0;
        long subtraction = 0;
        long multiplication = 1;

        try {
            int[] array = fillArray(length, min, max);
            addition = processPositiveNumbers(array, '+');
            subtraction = processPositiveNumbers(array, '-');
            multiplication = processPositiveNumbers(array, '*');
        } catch (MinMaxMismatchingException e){
            System.err.println("Oops! Something goes wrong with array filling up!");
            e.printStackTrace();
        } catch (NonZeroArgsException e){
            System.err.println("Well, its all about zero value in an arrays' cell.");
            e.printStackTrace();
        } catch (InvalidOperationException e){
            System.err.println("Bad news, mate: there is no such an operation.");
            e.printStackTrace();
        } catch (NegativeArraySizeException e){
            System.err.println("Arrr, mate! Look at your array's length input value...");
            e.printStackTrace();
        } finally{
            System.out.println( "Addition: " + addition +
                    "\nSubtraction: " + subtraction +
                    "\nMultiplication: " + multiplication +
                    "\nHave a nice day, pal!" +
                    "\n----------------------------------------------");
        }
    }


    public static void geronimo(int length, int min, int max, char operation){
        System.out.println("Exception test #" + count++);
        long result = 0;
        if(operation == '*'){ result = 1; }

        try {
            int[] array = fillArray(length, min, max);
            result = processPositiveNumbers(array, operation);

        } catch (MinMaxMismatchingException e){
            System.err.println("Oops! Something goes wrong with array filling up!");
            e.printStackTrace();
        } catch (NonZeroArgsException e){
            System.err.println("Well, its all about zero value in an arrays' cell.");
            e.printStackTrace();
        } catch (InvalidOperationException e) {
            System.err.println("Bad news, mate: there is no such an operation.");
            e.printStackTrace();
        } catch (NegativeArraySizeException e){
            System.err.println("Arrr, mate! Look at your array's length input value...");
            e.printStackTrace();
        } finally{
            System.out.println(operation + " : " + result +
                    "\nHave a nice day, pal!" +
                    "\n----------------------------------------------");
        }
    }


    public static long processPositiveNumbers(int[] numbers,
                                              char operation) throws NonZeroArgsException, InvalidOperationException{
        long result = 0;
        for(int number : numbers){
            if(number < 0){
                throw new NonZeroArgsException("Arguments are less then zero!");
            }

            switch(operation){
                case '+': result += number; break;
                case '-': result -= number; break;
                case '*': result *= number; break;
                default: throw new InvalidOperationException("Not supported operation!");
            }
        }
        return result;
    }


    public static int[] fillArray(int length, int min, int max)
            throws NegativeArraySizeException, MinMaxMismatchingException{
        if(length < 0){
            throw new NegativeArraySizeException("The length has negative value!");
        }

        int[] array = new int[length];
        for(int i = 0; i < array.length; i++){
            int temp = 0;

            do {
                temp = randomNumber(min, max);
            } while(hasSame(array, temp));

            array[i] = temp;
        }
        return array;
    }


    private static boolean hasSame(int[] array, int value){
        for(int cell : array){
            if(cell == value) { return true; }
        }
        return false;
    }


    private static int randomNumber(int min, int max) throws MinMaxMismatchingException{
        if(min >= max){
            throw new MinMaxMismatchingException("Minimum value is equal to or bigger than maximum value!");
        }

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}