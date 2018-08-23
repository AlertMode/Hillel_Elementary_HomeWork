package edu.palmirov.hillel.task_20;

import edu.palmirov.hillel.task_18.*;

public class Deque extends DoublyLinkedList{


    //Adds an element to the beginning of the deque.
    public boolean addFirst(String string){
       if(string != null){
           this.insertBefore(string);
           return true;
       }

       return false;
    }


    //Adds an element to the end of the deque.
    public boolean addLast(String string){
        if(string != null){
            this.insertAfter(string);
            return true;
        }

        return false;
    }


    //Removes the very first element from the deque.
    public boolean removeFirst(){
        if(this.find(1) != null){
            this.remove(this.find(1).getData());
            return true;
        }

        return false;
    }


    //Removes the very last element from the deque.
    public boolean removeLast(){
        if(this.find(this.length()) != null){
            this.remove(this.find(this.length()).getData());
            return true;
        }

        return false;
    }


    //Returns the first element's string value without deleting 'ListNode' object it from deque.
    public String peekFirst(){
        return this.find(1) == null ? null : this.find(1).getData();
    }


    //Returns the last element's string value without deleting the 'ListNode' object it from deque.
    public String peekLast(){
        return this.find(this.length()) == null ? null : this.find(this.length()).getData();
    }


    //Returns the last element's string value and deletes the 'ListNode' object, which has contained string field.
    public String pop(){
        if(this.find(this.length()) != null){
            String element = this.find(this.length()).getData();
            this.remove(element);
            return element;
        }

        return null;
    }


    //Returns the first element's string value and deletes the 'ListNode' object, which has contained string field.
    public String poll(){
        if(this.find(this.length()) != null){
            String element = this.find(1).getData();
            this.remove(element);
            return element;
        }

        return null;
    }


    //Returns the number of existing deque elements.
    public int size(){
        return this.length();
    }
}