package edu.palmirov.hillel.task_02;

/*
2. Дополнить программу калькулятор следующим функциями, контракт которых описан ниже.
а) Написать ф-цию со следующим контрактом:
    public static long castToLong(double val);
	Реализовать соответствующую операцию привидения типа (casting).
    В методе main передайте разные значения и проанализируйте результат.
    Например, передайте в ф-цию значение "100.134",  "12.0" и пр.

b) Реализовать ф-цию с контрактом:
   public static byte checkSign(byte b);
   В том случае, если число отрицательное ф-ция должна выводить значение всегда -128, а в иных случаях 0.
   Поэкспериментируйте с разными значениями, например: -5, -128, -127, 0, 64, 127.
   Напоминаю, что в языке java все числовые литералы воспринимаются как тип int.
   Поэтому для передачи значения в эту ф-цию используйте приведение типа "(byte)", например:
    byte value = checkSign((byte) -10);
    "-10" - это числовой литерал, кот. имеет тип int, для того чтобы его передать в ф-цию, кот. ожидает на входе значение byte мы приводим литерал типа int к типу byte операцией кастования: “(required_type) original_type”

c) Реализовать ф-цию с контрактом:
    public static int checkEvenNumber(double value);
    Ф-ция должна реализовать проверку четности числа без учета дробной части числа.
    Если число чётное ф-ция выводит число 1, во всех остальных случаях 0.
    Испробуйте эту ф-цию с четными и нечетными числами.
    Note: Для реализации проверки запрещено использовать оператор получения остатка от деления "%", строковые типы и пр. Т.е необходимо реализовать только с помощью битовых операций.

d)    Реализовать ф-цию со следующим контрактом:
    public static long bitWiseDivByFour(double number);
    Реализовать ф-цию быстрого деления числа на 4 с помощью битовых операций.
    Поэкспериментируйте передавая разные значения, например: 100, 32, 8, 6, 4, 3, 1, 0, -100.
*/

public class BitwiseOperations {
    public static void main(String[] args) {
        System.out.println(castToLong(234.67));
        System.out.println(checkSign((byte) -5));
        System.out.println(checkEvenNumber(39.89));
        System.out.println(bitWiseDivByFour(100.5));
    }

    public static long castToLong(double value){ //The given function returns a casted value from double to long.
        return (long)value;
    }

    public static byte checkSign(byte value){ //This function returns "0" if the input value is positive or "-128" in case the value is negative.
        return (byte)(value & 0b10000000);
    }

    public static long checkEvenNumber(double value){ //This function checks any integer or floating-point number for being even.
        return 1 ^ ((long) value & 1);
    }

    public static long bitWiseDivByFour(double number){ //This function multiplies any integer or floating-point number by four by means of nit shift operator '>>'.
        return (long)number >> 2;
    }

}