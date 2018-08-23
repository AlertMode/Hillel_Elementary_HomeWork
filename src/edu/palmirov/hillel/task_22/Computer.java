package edu.palmirov.hillel.task_22;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Computer {
    private int size = 1;
    private TechnicalSpecifications[] array = new TechnicalSpecifications[size];
    private int current = 0;


    //Adds new items to the array.
    public boolean add(String os_name, String cpu_model, double cpu_frequency,
                       int cpu_cores, String ram_model, double ram_frequency,
                       int ram_capacity){
        //Returns 'false' and quits the method without adding new element to the array,
        // if there is at least one variable, which meets its condition.
        if(os_name == null
                || cpu_model == null || cpu_frequency <= 0 || cpu_cores <= 0
                || ram_model == null || ram_frequency <= 0 || ram_capacity <= 0){ return false; }

        //Increases the array if there is no room for the new array.
        if(!this.isEmpty()) {
            this.extendArray(1);
            ++this.current;
        }

        array[current] = new TechnicalSpecifications(os_name, cpu_model, cpu_frequency, cpu_cores,
                ram_model, ram_frequency, ram_capacity);

        return true;
    }


    //Deletes the last array from the array.
    public boolean delete(){
        return this.narrowArray(1);
    }


    //Displays all the array's elements information.
    public void printAll(){
        int count = 0;

        for(TechnicalSpecifications temp : this.array){
            //Returns 'true' if array's cell contains 'null' value.
            if(temp == null) {
                System.out.println("No data has been found!");
                return;
            }

            System.out.println("============================================================================\n" +
                    "PC #" + ++count + ". OS: " + temp.getOs_name() +
                    "\n----------------------------------------------------------------------------\n" +
                    " >> CPU model: " + temp.getCpu_model() + " >> CPU frequency: " + temp.getCpu_frequency() +
                    "GHz >> CPU cores: " + temp.getCpu_cores() +
                    "\n----------------------------------------------------------------------------\n" +
                    " >> RAM model: " + temp.getRam_model() + " >> RAM frequency: " + temp.getCpu_frequency() +
                    "MHz >> RAM capacity: " + temp.getRam_capacity() + "MB;" +
                    "\n><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><");

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

        TechnicalSpecifications[] temp = new TechnicalSpecifications[this.array.length + size];
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

        TechnicalSpecifications[] temp = new TechnicalSpecifications[this.array.length - size];
        System.arraycopy(this.array, 0, temp, 0, temp.length);
        --this.current;

        array = temp;
        return true;
    }


    //Inner class, created to hold all the information about PC's technical specifications.
    private class TechnicalSpecifications {
        private String os_name;
        private String cpu_model;
        private double cpu_frequency;
        private int cpu_cores;
        private String ram_model;
        private double ram_frequency;
        private int ram_capacity;

        public TechnicalSpecifications(String os_name, String cpu_model, double cpu_frequency,
                                       int cpu_cores, String ram_model, double ram_frequency,
                                       int ram_capacity) {
            this.os_name = os_name;
            this.cpu_model = cpu_model;
            this.cpu_frequency = this.round(cpu_frequency, 2);
            this.cpu_cores = cpu_cores;
            this.ram_model = ram_model;
            this.ram_frequency = this.round(ram_frequency, 2);
            this.ram_capacity = ram_capacity;
        }

        public String getOs_name() {
            return os_name;
        }

        public String getCpu_model() {
            return cpu_model;
        }

        public double getCpu_frequency() {
            return cpu_frequency;
        }

        public int getCpu_cores() {
            return cpu_cores;
        }

        public String getRam_model() {
            return ram_model;
        }

        public double getRam_frequency() {
            return ram_frequency;
        }

        public int getRam_capacity() {
            return ram_capacity;
        }

        //Rounds the input value to the input decimal places.
        private double round(double value, int places){
            BigDecimal bigDecimal = new BigDecimal(value);
            return bigDecimal.setScale(places, RoundingMode.DOWN).doubleValue();
        }
    }
}