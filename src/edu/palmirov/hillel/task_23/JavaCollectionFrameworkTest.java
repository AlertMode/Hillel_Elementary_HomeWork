package edu.palmirov.hillel.task_23;

import java.util.*;

/*
 * Task 23
 * Используя классы из Java Collection Framework реализовать:
 * 1. Каждую цифру числа  занести в стек. Вывести число, у которого цифры идут в обратном порядке;
 * 2. Определить несколько множеств на основе множества целых чисел.
 * Получить пересечение двух множеств.
 * 3. Создать список(list) объектов типа Book {String title, String author}.
 * Список книг может содержать дубликаты.
 * Получить результирующую коллекцию книг без дубликатов.
 * 4. Для той же коллекции книг получить их отсортированное представление (выбрать соответствующую структуру данных);
 * 5. Задана строка, состоящая из различной комбинации символов «(», «)», «[», «]», «{», «}».
 * Проверить правильность расстановки скобок используя стек.
*/

public class JavaCollectionFrameworkTest {

    public static void main(String[] args) {
        //Sub-task#1. Static nested class 'IntegerReverser' test.
        System.out.println("\'IntegerReverser\' testing");
        IntegerReverser integerReverser = new IntegerReverser();
        long number = 46384150352L;
        System.out.println("SORTING IN ASCENDING ORDER\n" +
                "Before: " + number);
        long result = integerReverser.reverse(number, Order.ASC);
        System.out.println("After: " + result +
                "\n------------------------------------------------\n" +
                "SORTING IN DESCENDING ORDER\n" +
                "Before: " + number);
        result = integerReverser.reverse(number, Order.DESC);
        System.out.println("After: " + result);

        //Sub-task #2. Static nested class 'NumberSetOps' test.
        System.out.println("================================================" +
                "\n\'NumberSetOps\' testing");
        ArrayList<Integer> set_1 = new ArrayList<>();
        ArrayList<Integer> set_2 = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            set_1.add(NumberSetOps.randomInRange(0, 14));
            set_2.add(NumberSetOps.randomInRange(0, 14));
        }

        System.out.println("Before intersection \nThe FIRST SET");
        NumberSetOps.displayAll(set_1);
        System.out.println("------------------------------------------------\n" +
                "Before intersection \nThe SECOND SET");
        NumberSetOps.displayAll(set_2);
        System.out.println("------------------------------------------------\n" +
                "After intersection");

        ArrayList<Integer> set_3 = NumberSetOps.getSetIntersection(set_1, set_2);
        NumberSetOps.displayAll(set_3);
        System.out.println("------------------------------------------------\n" +
                "Sorted intersection");
        set_3 = NumberSetOps.sort(set_3, Order.ASC);
        NumberSetOps.displayAll(set_3);

        //Sub-task #3 & #4. Static nested class 'Bookshelf' test.
        Bookshelf bookshelf = new Bookshelf();
        System.out.println("================================================"
                + "\n\'Bookshelf\' testing" +
                "\nAdding operation status: " + bookshelf.add("Пикник на обочине", "Братья Стругацкие") +
                "\nAdding operation status: " + bookshelf.add("Code Clean", "Robert Cecil Martin") +
                "\nAdding operation status: " + bookshelf.add("Code Clean", "Robert Cecil Martin") +
                "\nAdding operation status: " + bookshelf.add("Пикник на обочине", "Братья Стругацкие") +
                "\nAdding operation status: " + bookshelf.add("Фиеста", "Эрнест Хемингуєй") +
                "\nAdding operation status: " + bookshelf.add("Человеческие качества", "Аурелио Печчеи"));
        System.out.println("\nBooks on the shelf: ");

        bookshelf.displayAll();
        System.out.println("Removing duplicates operation status: " + bookshelf.removeDuplicates());
        bookshelf.displayAll();

        System.out.println("\nMethod sort() in action" +
                "\nOrder by title" +
                "\nSorting operation status: " + bookshelf.sort(Bookshelf.OrderBy.TITLE));
        bookshelf.displayAll();
        System.out.println("------------------------------------------------" +
                "\nOrder by author" +
                "\nSorting operation status: " + bookshelf.sort(Bookshelf.OrderBy.AUTHOR));
        bookshelf.displayAll();

        //Sub-task #5. Static nested class 'Syntax' test.
        System.out.println("================================================" +
                "\n\'Syntax\' testing");
        String text_1 = "«(», «)», «[», «]», «{», «}»";
        String text_2 = "(A + B) - [F * (2G / 3)]}";
        System.out.println("Balanced parenthesis test" +
                "\nChecking the FIRST TEXT: " + text_1 +
                "\nParenthesis are balanced: " + Syntax.checkParenthesis(text_1) +
                "\n------------------------------------------------" +
                "\nChecking the SECOND TEXT: " + text_2 +
                "\nParenthesis are balanced: " + Syntax.checkParenthesis(text_2));
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Sub-task #1.
     * This static class 'IntegerReverser' has been created to provide the ability of reversing any integer number.
     */
    public static class IntegerReverser {
        private LinkedList <Long> linkedList = new LinkedList<>();

        /**
         * The only method, available for calling from 'IntegerReverser' class.
         * Returns the reversed input number.
         */
        private long reverse(long number, Order order){
            this.separate(number); //Slits number into digits and passes them to the 'LinkedList'.

            this.sortLinkedList(this.linkedList, order); //Sorts the 'LinkedList' by the input order's value.

            /*
             * Forms a number from all the 'LinkedList' storing digit
             * and returns the value.
             */
            return this.combine();
        }

        //Splits number into the digits and pushed each digit to the 'LinkedList'.
        private void separate(long number){
            while(number > 0){
                this.linkedList.add(number % 10);
                number /= 10;
            }
        }

        /**
         * Sorts the 'LinkedList' in ascending or descending order.
         */
        private boolean sortLinkedList(LinkedList<Long> inputList, Order order){
            if(inputList.isEmpty()){ return false; }

            if(order == Order.ASC){
                Collections.sort(inputList);
            } else {
                Collections.sort(inputList, Collections.reverseOrder());
            }
            return true;
        }

        /**
         * Arranges every digit in the 'LinkedList' from the very first to the very last
         * by multiplying then on descending oder of magnitude, which is the size of the 'LinkedList',
         * decreasing due to the digit's extraction.
         */
        private long combine(){
            long temp = 0;

            while(!linkedList.isEmpty()){
                /*
                 * Adds the result of multiplying each extracted digit by the 'LinkedList' decreasing size,
                 * which plays the role of the power in 'Math.pow'.
                 */
                temp += this.linkedList.removeLast() * (long)(Math.pow(10, this.linkedList.size()));
            }

            return temp;
        }
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Sub-task #2.
     * Static class 'NumberSetOps' chooses among two ArrayLists only analogous elements and forms new ArrayList,
     * containing them.
     */
    private static class NumberSetOps{
        /**
         * Returns the intersection of two ArrayList sets' numbers.
         */
        private static ArrayList<Integer> getSetIntersection(ArrayList<Integer> set_1, ArrayList<Integer> set_2){
            if(set_1.isEmpty() || set_2.isEmpty()){ return null; }

            set_1.retainAll(set_2);
            return set_1;
        }

        /**
         * Displays all the 'ArrayList' elements.
         */
        private static void displayAll(ArrayList<Integer> set){
            if(set.isEmpty()){ return; }

            for (int i = 0; i < set.size(); i++){
                System.out.printf("Cell #%d: %d\n",i + 1, set.get(i));
            }
        }

        /**
         * Sorts an integer ArrayList in ascending or descending order.
         */
        private static ArrayList<Integer> sort(ArrayList<Integer> set, Order order){
            if(set.isEmpty()){ return null; }

            if(order == Order.ASC){
                Collections.sort(set);
            } else {
                Collections.reverse(set);
            }

            set = NumberSetOps.removeDuplicates(set);

            return set;
        }


        /**
         * Removes all the duplicates from ArrayList.
         */
        private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> set){
            if(set.isEmpty()){ return null; }

            //Adding 'ArrayList' to 'HashSet', which provides duplicate cleaning.
            Set<Integer> hashSets = new HashSet<>(set);
            set.clear(); //Removing all the elements from ArrayList.
            set.addAll(hashSets); //Adding sorted list.
            return set;
        }

        /**
         * Randomly generates an integer number in the defined range.
         */
        private static int randomInRange(int min, int max){
            Random random = new Random();
            return random.nextInt((max - min) + 1) + min;
        }
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Sub-task #3 and #4
     * Static class 'Bookshelf' contains sub-class 'Books' objects and sorts them.
    */
    private static class Bookshelf{
        //Contains 'Book' type objects.
        private ArrayList <Book> shelf = new ArrayList<>();

        /**
         * Creates new 'Book' object and adds to it input values.
         * Returns 'false' and prevents the creation of the 'Book' object
         * if both the input values has 'null' values.
         * Otherwise, 'true' will be returned.
         */
        private boolean add(String title, String author){
            if(title == null || author == null){ return false; }

            this.shelf.add(new Book(title, author));
            return true;
        }

        //Removes all the duplicates from the 'book' collection.
        private boolean removeDuplicates(){
            /*
             * If the 'ArrayList' contains no objects - 'false' will be returned.
             * Otherwise, 'true'.
             */
            if(shelf.isEmpty()){
                return false;
            }

            //'LinkedHashSet' deletes all duplicates in the input list.
            Set<Book> hashSet = new LinkedHashSet<>(this.shelf);
            this.shelf.clear();
            //Passes processed 'LinkedHashSet' list to 'ArrayList'.
            this.shelf.addAll(hashSet);

            return true;
        }

        private boolean sort(OrderBy orderBy){
            /*
             * If the 'ArrayList' contains no objects - 'false' will be returned.
             * Otherwise, 'true'.
             */
            if(shelf.isEmpty()){
                return false;
            }

            /*
             * Used with lambda expression. Quite compact and effective.
             * Source code: https://www.programiz.com/java-programming/examples/sort-custom-objects-property
             */
            if(orderBy == OrderBy.AUTHOR){
                this.shelf.sort((e1, e2) -> e1.getAuthor().compareTo(e2.getAuthor()));
            } else {
                this.shelf.sort((e1, e2) -> e1.getTitle().compareTo(e2.getTitle()));
            }

            return true;
        }

        //Displays the every containing in 'ArrayList' object's data.
        private void displayAll(){
            if(this.shelf.isEmpty()){
                System.out.println("ArrayList is empty!");
                return;
            }

            for (int i = 0; i < this.shelf.size(); i++){
                System.out.printf("Data #%d >> Author: %s || Title: %s", i + 1,
                        this.shelf.get(i).getAuthor(), this.shelf.get(i).getTitle());
                if(this.shelf.size() > i){ System.out.println(); }
            }
        }

        //Is used by method 'sort()' to determine the order of sorting: by title or by author.
        private enum OrderBy{
            AUTHOR,
            TITLE;
        }

        /**
         * Pretty simple static nested class of the static nested class,
         * containing only two fields and two 'getters' functions.
         * Nothing special about it. Just a 'Book' class.
         */
        private static class Book{
            private String title;
            private String author;

            public Book(String title, String author) {
                this.title = title;
                this.author = author;
            }

            public String getTitle() {
                return title;
            }

            public String getAuthor() {
                return author;
            }

            @Override
            //Checks two objects for equality.
            public boolean equals(Object object){
                if(object == null){ return false; }

                if(!Book.class.isAssignableFrom(object.getClass())){ return false; }

                final Book other = (Book) object;

                //Checks both objects 'title' and 'author' fields for equality.
                boolean titleCheck = (this.title == null ? other.title != null : !this.title.equals(other.title));
                boolean authorCheck = (this.author == null ? (other.author != null) : !this.author.equals(other.author));

                return !titleCheck && !authorCheck;
            }

           /*
            * Nothing special. Just overridden 'hashCode()' method. The external class' method 'sort()'
            * uses the overridden method below.
            */
            @Override
            public int hashCode() {
                return Objects.hash(this.author, this.title);
            }
        }
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Sub-task #5
     * Static class 'Syntax' provides a method 'checkParenthesis'.
     */
    private static class Syntax{
        /**
         * Returns 'true' value if the input text contains correctly balanced parenthesis.
         */
        public static boolean checkParenthesis(String text){
            //If the input 'String' variable has 'null' value, exception will be thrown.
            if(text == null){
                throw new IllegalArgumentException();
            }

            /*
             * Returns 'true' if the 'String' variable is empty.
             * Well, the absence of parenthesis means the absence of parenthesis balancing error.
             */
            if(text.isEmpty()){ return true; }

            Stack <Character> stack = new Stack<>();

            //Checks every 'String' character.
            for(int i = 0; i < text.length(); i++){
                char current = text.charAt(i);

                //If the current 'char' variable has got any opening parenthesis.
                if (current == '(' || current == '[' || current == '{') {
                    stack.push(current);
                }

                //If the current 'char' variable has got any closing parenthesis.
                if(current == ')' || current == ']' || current == '}'){
                    /*
                     * If there is no value in 'Stack' and the current sign is closing parenthesis,
                     * 'false, will be returned.
                     */
                    if(stack.isEmpty()){ return false; }

                    //Containing the 'Stack' top element, that is assumed to be opening parenthesis.
                    char last = stack.peek();
                    //Checks 'last' and 'current' variables for the compliance with conditions.
                    if(last == '(' && current == ')'
                            || last == '[' && current == ']'
                            || last == '{' && current == '}'){
                        /* If one of the conditions is upheld, the last added parenthesis to the 'Stack' top
                         * will be thrown away.
                         */
                        stack.pop();
                        //Otherwise, there is parenthesis absence of mismatching.
                    } else { return false; }
                }
            }
            /*
             * Not empty 'Stack', means that, at least, one opening parenthesis isn't balanced.
             * 'False' will be returned in this case. Otherwise, 'true'.
             */
            return stack.isEmpty();
        }
    }

    /*
     * Provides only two variants of choosing: ascending or descending order for the sorting method.
     * Was created with an eye to prevent misprints.
     */
    public enum Order{
        ASC,
        DESC;
    }
}