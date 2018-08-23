package edu.palmirov.hillel.task_05;

/*
Task 5

a. Определить является ли число палиндромом
    (123456 - нет)(123321 - да)
    (9239329 - да)
 */

public class PalindromeNumber {
    public static void main(String[] args){
        System.out.println(getCheckForPalindrome(45673));
        System.out.println(getCheckForPalindrome(9167619));
        System.out.println(getCheckForPalindrome(1000001));
    }

    private static String getCheckForPalindrome(int number){ //Exercise 'a'
        //The given function takes any integer number
        //and checks it for being palindrome.
        byte[] array = getDigitArray(number);
        byte length = (byte)(array.length / 2);
        for (int i = 0, j = array.length - 1; i < length; i++, j--) {
            if(array[i] != array[j]){
                return "Number \"" + number + "\" isn't palindrome!";
            }
        }
        return "Number \"" + number + "\" is palindrome!";
    }

    private static byte[] getDigitArray(int number){
        //A secondary function, created in order
        //to convert an integer number into the array
        // with separated number's digits.
        byte [] array = new byte[digitCounter(number)];
        for (byte j = 0; number > 0; j++){
            array[j] = (byte)(number % 10);
            number /= 10;
        }
        return array;
    }

    private static byte digitCounter(int number){
        //A secondary function, created in order
        // to check a quantity of digits the input number has.
        byte counter = 0;
        int temp = 1;
        while(temp <= number) {
            ++counter;
            temp *= 10;
        }
        return counter;
    }
}