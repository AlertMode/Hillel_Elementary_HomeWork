package edu.palmirov.hillel.task_04;

/*
Task 4:

a. Написать два варианта ф-ции определения сезона года по номеру месяца.
   Первый вариант ф-ции должен использовать if .. else .. if оператор.
   Второй вариант ф-ции должен использовать switch .. case.

   Подумайте о смысловой нагрузке при именовании ваших функций. Всегда старайтесь давать понятные другим людям имена.

b. Отдельным методом организовать конечный цикл с помощью for. Количество итераций 20.

Вывести сообщение в цикле такого вида
 - "Race 1"
 - "Race 2"
 - "Race 3"
   И т.д

Пропускать вывод сообщений о номере гонки на шагах: 6, 12, 18

Использовать данный метод в функции в главной функции main().

c. Создайте бесконечный циклы вида do .. while.
Внутри цикла сгенерируйте случайное число с помощь JDK библиотеки  Math.
double Math.random() - возвращает случайное число в диапазоне 0.0 <= Math.random() < 1.0;

Если случайное число более 0.5, вывести сообщение "eagle"?, а если меньше 0.5, то "tails".
Если "0.0", то немедленно выйти из цикла.

Оформите данное задание отдельным методом.

d. Организовать циклы do while обратного отсчета от 10 до 1 в выводом на экран.

e. Реализовать задачу таблицы умножения используя исключительно циклы вида while (не путать с do while).

f. Реализовать функцию по нахождению сумм цифр в числе.

g. Написать функцию нахождения факториала числа используя цикл любой вид цикла по желанию.

h. Написать функцию для вывода на экран арифметической прогрессии: 10, 12, 14, ..., 34, 36, 38.
 */

public class SelectionStatements {

    public static void main(String[] args){
        for(int j = 0; j <= 13; j++){
            System.out.println("Month # " + j + " Season: " + getYearSeasonIfElse(j));
        }

        System.out.println("============================================================"); //--------------------------

        for(int j = 0; j <= 13; j++){
            System.out.println("Month # " + j + " Season: " + getYearSeasonSwitch(j));
        }

        System.out.println("============================================================"); //--------------------------

        messageIteration("Race", 20,6);

        System.out.println("============================================================"); //--------------------------

        tossUpFunc();

        System.out.println("============================================================"); //--------------------------

        countingFunc(-200);

        System.out.println("============================================================"); //--------------------------

        multiplicationTable(10, 10);

        System.out.println("============================================================"); //--------------------------

        multiplicationTableA(100, 100);

        System.out.println("============================================================"); //--------------------------

        System.out.println(getDigitSum(9573409));

        System.out.println("============================================================"); //--------------------------

        System.out.println(getFactorial(10));

        System.out.println("============================================================"); //--------------------------

        System.out.println(getFactorialRecursion(7));

        System.out.println("============================================================"); //--------------------------

        getArithmeticProgression(2,2, "ASC");

        System.out.println("============================================================"); //--------------------------

        getArithmeticProgression(254, 7, "DESC");
    }

    public static String getYearSeasonIfElse(int value){ //Exercise 'a'-1
        if(value == 12 || value == 1 || value == 2){
            return "Winter";
        } else if(value >= 3 && value <=5){
            return "Spring";
        } else if(value >= 6 && value <= 8){
            return "Summer";
        } else if(value >= 9 && value <=11){
            return "Autumn";
        } else {
            return "Wrong input! There is no such a month!";
        }
    }

    public static String getYearSeasonSwitch(int value){ //Exercise 'a' - 2
        switch(value){
            case 12: return "Winter";
            case 1: return "Winter";
            case 2: return "Winter";
            case 3: return "Spring";
            case 4: return "Spring";
            case 5: return "Spring";
            case 6: return "Summer";
            case 7: return "Summer";
            case 8: return "Summer";
            case 9: return "Autumn";
            case 10: return "Autumn";
            case 11: return "Autumn";
            default: return "Wrong input! There is no such a month!";
        }
    }

    public static void messageIteration(String message, int iteration, int pitch){ //Exercise 'b'
        for(int j = 0; iteration >= j; j++){
            if(j % pitch != 0){
                System.out.println(message + " #" + j );
            }
        }
    }

    public static void tossUpFunc(){ //Exercise 'c'
        do{
            double randVal = Math.random();
            if(randVal > 0.5){
                System.out.println("Eagle!");
            } else if (randVal > 0.1 && randVal < 0.5){
                System.out.println("Tails!");
            } else {
                System.out.println("Ridge!");
                return;
            }
        }while(true);
    }

    public static int valueCheck(int number, int defaultValue) {
        //A secondary function, created in order
        // to check a number for negative or below zero value;
        if(number < 0){
            number *= -1;
        } else if (number == 0){
            number = defaultValue;
            System.out.println("The default value has been set: " + defaultValue + "\n");
        }
        return number;
    }

    public static void countingFunc(int number){ //Exercise 'd'
        number = valueCheck(number, 10);
        do{
            System.out.println(number--);
        }while(number > 0);
    }

    public static void multiplicationTable(int numbers, int multiplier){ // Exercise 'e'
        numbers = valueCheck(numbers, 10);
        multiplier = valueCheck(multiplier, 10);
        int temp = numbers;
       while(multiplier > 0){
           while(temp > 0){
               System.out.println(multiplier + " * " + temp + " = " + multiplier * temp);
               --temp;
           }
           --multiplier;
           temp = numbers;
           System.out.println("--------------");
       }
    }

    public static byte digitCounter(int number){
        //A secondary function, created in order
        // to check a quantity of digits the input number has.
        byte counter = 0;
        int temp = 1;
        while(temp <= Math.abs(number)) {
            ++counter;
            temp *= 10;
        }
        return counter;
    }

    public static void multiplicationTableA(int numbers, int multiplier){ // Exercise 'e' Table Edition
        numbers = valueCheck(numbers, 10);
        multiplier = valueCheck(multiplier, 10);
        byte digitsA = digitCounter(numbers);
        byte digitsB = digitCounter(multiplier);
        byte digitsC = digitCounter(numbers * multiplier);
        String format = "%" + digitsA + "d %2s %" + digitsB + "d %2s %" + digitsC + "d %4s\t"; //Adjusts the format for "printf"
        int numb_A = 1;
        int numb_B = 1;
        while(numb_A <= numbers){
            while(numb_B <= multiplier){
                System.out.printf(format, numb_A, " * ", numb_B, " = ", (numb_A * numb_B), "||");
                ++numb_B;
            }
            System.out.println();
            ++numb_A;
            numb_B = 1;
        }
    }

    public static int getDigitSum(int number){ //Exercise 'f'
        double temp = (double)valueCheck(number, 225);
        double result = 0;
        while(temp > 0){
            temp = temp / 10;
            result = result + Math.round(10 * (temp - (int)temp));
            temp = (int)temp;
        }
        return (int)result;
    }

    public static long getFactorial(int number){ //Exercise 'g'
        long factorial = 1;
        for(int j = number; j > 0; --j){
            factorial *= number;
            --number;
        }
        return factorial;
    }

    public static long getFactorialRecursion(int number){ //Exercise 'g' "Recursion-Edition"
        long factorial;
        if(number == 1){
            return 1;
        }
        factorial = getFactorialRecursion(number - 1) * number;
        return factorial;
    }

    public static void getArithmeticProgression(int startingNumber, int pitch, String mode){ //Exercise 'h'
        startingNumber = valueCheck(startingNumber, 10);
        switch(mode){
            case "ASC":
                long limit = startingNumber * 100;
                while(startingNumber <= limit){
                    System.out.println(startingNumber);
                    startingNumber += pitch;

                }
                break;
            case "DESC":
                while(startingNumber >= 0){
                    System.out.println(startingNumber);
                    startingNumber -= pitch;
                }
                break;
        }
    }
}