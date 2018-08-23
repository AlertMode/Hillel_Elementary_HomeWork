package edu.palmirov.hillel.task_22;

public class Cinema {
    private int size = 1;
    private Movie[] array = new Movie[size];
    private int current = 0;


    //Adds new items to the array.
    public boolean add(String title, int productionYear, String genre,
                       String director, int duration, int budget){
        //Returns 'false' and quits the method without adding new element to the array,
        // if there is at least one variable, which meets its condition.
        if(title == null || productionYear <= 0 || genre == null
                || director == null || duration <= 0 || budget <= 0){ return false; }

        //Increases the array if there is no room for the new array.
        if(!this.isEmpty()) {
            this.extendArray(1);
            ++this.current;
        }

        array[current] = new Movie(title, productionYear, genre,
                director, duration, budget);

        return true;
    }


    //Deletes the last array from the array.
    public boolean delete(){
        return this.narrowArray(1);
    }


    //Displays all the array's elements information.
    public void printAll(){
        int count = 0;

        for(Movie temp : this.array){
            //Returns 'true' if array's cell contains 'null' value.
            if(temp == null) {
                System.out.println("No data has been found!");
                return;
            }

            System.out.println("Movie #" + ++count +
                    ". \n=============================================================\n" +
                    "Title: " + temp.getTitle() +
                    "\nGenre: " + temp.getGenre() +
                    "\nYear: " + temp.getGenre() +
                    "\nDuration: " + temp.getDuration() + " minutes" +
                    "\nDirector: " + temp.getDirector() +
                    "\nBudget: " + temp.getBudget() + " $" +
                    "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

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

        Movie[] temp = new Movie[this.array.length + size];
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

        Movie[] temp = new Movie[this.array.length - size];
        System.arraycopy(this.array, 0, temp, 0, temp.length);
        --this.current;

        array = temp;
        return true;
    }


    //Inner class, created to hold all the information about the bought array.
    private class Movie {
        private String title;
        private int productionYear;
        private String genre;
        private String director;
        private int duration;
        private int budget;

        public Movie(String title, int productionYear, String genre,
                     String director, int duration, int budget) {
            this.title = title;
            this.productionYear = productionYear;
            this.genre = genre;
            this.director = director;
            this.duration = duration;
            this.budget = budget;
        }

        public String getTitle() {
            return title;
        }

        public int getProductionYear() {
            return productionYear;
        }

        public String getGenre() {
            return genre;
        }

        public String getDirector() {
            return director;
        }

        public int getDuration() {
            return duration;
        }

        public int getBudget() {
            return budget;
        }
    }
}