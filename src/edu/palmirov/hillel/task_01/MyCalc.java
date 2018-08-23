package edu.palmirov.hillel.task_01;

/*
Реализовать класс MyCalc для вещественных чисел (чисел с плавающей точкой) со следующим набором методов/функций:

double add(double val1, val2); // сложение
double sub(double val1, double val2); // вычитание
double mul(double val1, double val2); // умножение
double div(double val1, double val2); // деление
double mod(double val1, double val2); // остаток от деления
double avg(double val1, double val2) // среднее арифметическое
double pow(double val) // степень числа во 2-й степени
double percent(double val1, double percent); // процент от числа

Реализовать метод main в классе MyCalc и испытать написанные ф-кции.

public static void main(String[] args) {
			System.out.println(add(1, 2));
		….
}
 */

public class MyCalc {
    public static void main(String[] args){
        System.out.printf("%.2f %n", addition(45.333, 345.65));
        System.out.printf("%.2f %n", subtraction(35.456, 6.9));
        System.out.printf("%.2f %n", multiplication(7833.001, 2.78));
        System.out.printf("%.2f %n", division(453.346, 67.3));
        System.out.printf("%.2f %n", arithmeticalAverage(128.128, 32.32));
        System.out.printf("%.2f %n", secondPower(2.22));
        System.out.printf("%.2f %n", getPercentNumber(5635.574, 3));
    }

    public static double addition(double value_1, double value_2){
        return value_1 + value_2;
    }

    public static double subtraction(double value_1, double value_2){
        return value_1 - value_2;
    }

    public static double multiplication(double value_1, double value_2){
        return value_1 * value_2;
    }

    public static double division(double value_1, double value_2){
        return value_1 / value_2;
    }

    public static double arithmeticalAverage(double value_1, double value_2){
        return (value_1 + value_2) / 2;
    }

    public static double secondPower(double value){
        return value * value;
    }

    public static double getPercentNumber(double value, double percent){
        return value * percent / 100;
    }
}