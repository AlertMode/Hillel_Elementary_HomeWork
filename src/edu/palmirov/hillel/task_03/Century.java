package edu.palmirov.hillel.task_03;

/*
 3. Написать функцию определения столетия по номеру года.
 Диапазон возможных значений для года может лежать в пределах от 1 до 2018.
 Например,
 На вход ф-ция принимает значение 1999, а на выходе возвращает число 20.
*/

public class Century {
    public static void main(String[] args){
        for(int j = 2018; j >= -2018; j--){
            System.out.println("Year :" + j + " Century: " + getCentury(j));
        }
    }

    public static int getCentury(int year){ // Universal method for getting the century's number from A.D. to B.C. years.
        double century = (double)year / 100;
        double fraction = century - (int)century;
        return (int)(fraction != 0 ? (fraction > 0 ? ++century : --century) : century);
    }

/*    public static int getCenturySimple(int year){ // Only for A.D. years.
        return ((double)year / 100) - (year / 100) != 0 ? (year / 100) + 1 : (year / 100);
    }*/
}