package edu.palmirov.hillel.task_08;

public class LeapYear {

    private boolean isLeapYear(int year){
        //Returns 'true' if the input year is leap.
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    public String getInfo(int month, int year){
        //Returns 'String' data message that contains the information about
        //the input month and year.

        if(isLeapYear(year)){ //if statement calls function to checks a year for leap meaning.
            Month.FEB.setFeb(29);
        } else {
            Month.FEB.setFeb(28);
        }

        Month result = null; //A temp reference variable which will be referencing to the already created
        //'enum' type objects.

        switch(month){
            case 1: result = Month.JAN;
                break;
            case 2: result = Month.FEB;
                break;
            case 3: result = Month.MAR;
                break;
            case 4: result = Month.APR;
                break;
            case 5: result = Month.MAY;
                break;
            case 6: result = Month.JUN;
                break;
            case 7: result = Month.JUL;
                break;
            case 8: result = Month.AUG;
                break;
            case 9: result = Month.SEPT;
                break;
            case 10: result = Month.OCT;
                break;
            case 11: result = Month.NOV;
                break;
            case 12: result = Month.DEC;
                break;
            default: return "Error! Month with index #" + month + " doesn't exists!"; //Returns this message
        }
        return result.getName() + " " + year + " and " + result.getDays() + " days.";
    }
}