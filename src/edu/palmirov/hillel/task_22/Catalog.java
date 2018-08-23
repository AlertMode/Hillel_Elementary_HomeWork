package edu.palmirov.hillel.task_22;

import java.util.*;

public class Catalog{
    private int size = 1;
    private Checkout[] array = new Checkout[size];
    private int current = 0;


    //Adds new items to the array.
    public boolean add(String bookTitle, String author, String customerName){
        //Returns 'false' and quits the method without adding new element to the array,
        // if there is at least one variable, which meets its condition.
        if(bookTitle == null || author == null || customerName == null){ return false; }

        //Increases the array if there is no room for the new array.
        if(!this.isEmpty()) {
            this.extendArray(1);
            ++this.current;
        }

        //Assigns to the current array's cell newly created 'Checkout' object with the input arguments.
        array[current] = new Checkout(bookTitle, author, customerName);

        return true;
    }


    //Deletes the last array from the array.
    public boolean delete(){
        return this.narrowArray(1);
    }


    //Displays all the array's elements information.
    public void printAll(){
        int count = 0;

        for(Checkout temp : this.array){
            //Returns 'true' if array's cell contains 'null' value.
            if(temp == null) {
                System.out.println("No data has been found!");
                return;
            }

            System.out.println("Checkout #" + ++count + ". Title: " + temp.getBookTitle() +
                    " >> Author: " + temp.getAuthor() + " >> Date: " +
                    temp.getCheckoutMonth() + "/" + temp.getCheckoutDay() + "/" + temp.checkoutYear +
                    ">> Customer: " + temp.getCustomerName() + ";");

            //Prints new line when the array's last element will be used.
            if(count == this.array.length - 1){ System.out.println(); }
        }
    }


    //Returns 'true' value if the current index points on the empty array's cell.
    private boolean isEmpty(){
        return this.array[current] == null;
    }


    //Increases the field array by the input size. Returns 'true' value if the increasing was permitted.
    //Other wise - 'false'.
    private boolean extendArray(int size){
        //Return 'false' value if the input size is less than or equal to zero value.
        if(size <= 0){ return false; }

        Checkout[] temp = new Checkout[this.array.length + size];
        System.arraycopy(this.array, 0, temp, 0, this.array.length);
        array = temp;

        return true;
    }


    //Decreases the field array by the input size. Returns 'true' value if the decreasing was permitted.
    //Other wise - 'false'.
    private boolean narrowArray(int size){
        //Return 'false' value if the input size is greater than or equal to the zero value
        // or the current index points on the array's last element, which has 'null' value.
        if(size <= 0 || this.array[this.current] == null) { return false; }

        //Sets the first array's cell to 'null' value and decreases the current index by one
        // if there is only one cell in the array. Otherwise, the if-statement will be skipped.
        if(this.array.length == 1) {
            this.array[current] = null;
            return true;
        }

        Checkout[] temp = new Checkout[this.array.length - size];
        System.arraycopy(this.array, 0, temp, 0, temp.length);
        --this.current;

        array = temp;
        return true;
    }


    //Inner class, created to hold all the information about the bought array.
    private class Checkout {
        private String bookTitle;
        private String author;
        private int checkoutMonth;
        private int checkoutDay;
        private int checkoutYear;
        private String customerName;

        private Checkout(String bookTitle, String author, String customerName) {
            this.bookTitle = bookTitle;
            this.author = author;

            /*
             * Receives current date. Each array's cell gets an integer value:
             * [0] = month;
             * [1] = day;
             * [2] = year;
            */
            int[] date = this.dateMM_DD_YYYY();

            this.checkoutMonth = date[0];
            this.checkoutDay = date[1];
            this.checkoutYear = date[2];

            this.customerName = customerName;
        }

        public String getBookTitle() {
            return bookTitle;
        }

        public String getAuthor() {
            return author;
        }

        public int getCheckoutMonth() {
            return checkoutMonth;
        }

        public int getCheckoutDay() {
            return checkoutDay;
        }

        public int getCheckoutYear() {
            return checkoutYear;
        }

        public String getCustomerName() {
            return customerName;
        }


        //Returns the array with separated date in US format: MM.DD.YYYY.
        private int[] dateMM_DD_YYYY(){
            int[] array = new int[3];

            //Determines the current date.
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            //Assigns integer values, describing month, day and year, to the three array's cells.
            /*
            * '+ 1' is so called "duct tape" is used due to 'Calendar.MONTH'
            * point of departure that starts from zero value like any array dose.
            */
            array[0] = calendar.get(Calendar.MONTH) + 1;
            array[1] = calendar.get(Calendar.DAY_OF_MONTH);
            array[2] = calendar.get(Calendar.YEAR);

            return array;
        }
    }
}