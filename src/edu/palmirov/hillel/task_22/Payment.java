package edu.palmirov.hillel.task_22;

import java.math.*;

public class Payment{
    private int size = 1;
    private Item[] array = new Item[size];
    private int current = 0;


    //Adds new items to the array.
    public boolean add(String name, double price, int quantity){
        //Returns 'false' and quits the method without adding new element to the array,
        // if there is at least one variable, which meets its condition.
        if(name == null || price <= 0 || quantity <= 0){ return false; }

        //Increases the array if there is no room for the new array.
        if(!this.isEmpty()) {
            this.extendArray(1);
            ++this.current;
        }

        array[current] = new Item(name, price, quantity);

        return true;
    }


    //Deletes the last array from the array.
    public boolean delete(){
        return this.narrowArray(1);
    }


    //Displays all the array's elements information.
    public void printAll(){
        int count = 0;

        for(Item temp : this.array){
            //Returns 'true' if array's cell contains 'null' value.
            if(temp == null) {
                System.out.println("No data has been found!");
                return;
            }

            System.out.println("Item #" + ++count + ". Name: " + temp.getName() +
                    " >> Price per item: " + temp.getPricePerItem() +
                    " >> Quantity: " + temp.getQuantity() + " >> Total price: " + temp.getTotalPrice() +
                    ";");

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

        Item[] temp = new Item[this.array.length + size];
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

        Item[] temp = new Item[this.array.length - size];
        System.arraycopy(this.array, 0, temp, 0, temp.length);
        --this.current;

        array = temp;
        return true;
    }


    //Inner class, created to hold all the information about the bought array.
    private class Item {
        private String name;
        private double pricePerItem;
        private int quantity;
        private double totalPrice;

        private Item(String name, double price, int quantity){
            this.name = name;
            this.pricePerItem = price;
            this.quantity = quantity;
            //Sums up the price of the chosen array's samples and rounds to two decimal places.
            this.totalPrice = this.round(pricePerItem * quantity, 2);
        }

        public String getName() {
            return name;
        }

        public double getPricePerItem() {
            return pricePerItem;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        //Rounds the input value to the input decimal places.
        private double round(double value, int places){
            BigDecimal bigDecimal = new BigDecimal(value);
            return bigDecimal.setScale(places, RoundingMode.DOWN).doubleValue();
        }
    }
}