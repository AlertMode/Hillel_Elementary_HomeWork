package edu.palmirov.hillel.task_18;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;


    //The inner class, created to contain 'String' data and the links of the next and the previous 'ListNode' objects.
    public static class ListNode {
        private String data;
        private ListNode next;
        private ListNode previous;

        public ListNode(String data){
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    //Returns the 'true' value if the input "data" exists in 'DoublyLinkedList'.
    //Otherwise - 'false'.
    public boolean contains(String data){
        if(this.isEmpty()){ return false; }

        ListNode temp = this.head;
        int i = 0;

        while(i <= this.length){
            if(temp == null){ return false; }
            if(temp.data.equals(data)){ return true; }
            temp = temp.next;
            ++i;
        }
        return false;
    }


    //Returns the index of the 'ListNode' element in the 'DoublyLinkedList' if the element has the same 'String' value
    // as the input "data".
    public int getIndex(String data){
        if(this.isEmpty()){ return -1; }

        int i = 1;

        for(ListNode temp = this.head; temp != null; temp = temp.next){
            if(temp.data.equals(data)){ return i; }
            ++i;
        }

        return -1;
    }


    //Returns 'true' if such 'String' "data" value exists in 'DoublyLinkedList' and the 'LinkNode',
    // containing the given 'String' value, is deleted. Otherwise - 'false'.
    public boolean remove(String data){
        if(this.isEmpty() || !this.contains(data)){ return false; }

        //In case there is only one 'ListNode' element in the 'DoublyLinkedList'.
        if(this.length == 1 && this.head.data.equals(data)){
            this.head = null;
            this.tail = null;
            --this.length;
            return true;
        }

        //If the sought element occupies the first position - head.
        if(this.head.data.equals(data)){
            this.head = this.head.next;
            this.head.previous = null;
            --this.length;
            return true;
        }

        //In case the sought element is in the end of the 'DoublyLinkedList'.
        if(this.tail.data.equals(data)){
            this.tail = this.tail.previous;
            this.tail.next = null;
            --this.length;
            return true;
        }

        //Loop starts if the 'ListNode' element is possibly situated somewhere in the middle of the 'DoublyLinkedList'
        // or straight after the first/next element.
        for(ListNode current = this.head; current != null; current = current.next){
            if(current.data.equals(data)){
                ListNode previousElement = current.previous;
                ListNode nextElement = current.next;
                previousElement.next = nextElement;
                nextElement.previous = previousElement;
                --this.length;
                return true;
            }
        }
        return false; //If there is no such an element in ''DoublyLinkedList' at all.
    }

    //Inserts a new 'ListNode' object in the end ("tail") of the 'DoublyLinkedList'.
    public void insertAfter(String value){
        ListNode newNode = new ListNode(value);
        if(this.isEmpty()){
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        newNode.previous = this.tail;
        this.tail = newNode;
        ++this.length;
    }


    //Inserts a new 'ListNode' object in the beginning ("head") of the 'DoublyLinkedList'.
    public void insertBefore(String value){
        ListNode newNode = new ListNode(value);
        if(this.isEmpty()){
            this.tail = newNode;
        } else {
            this.head.previous = newNode;
        }
        newNode.next = this.head;
        this.head = newNode;
        ++this.length;
    }

    //Creates and inserts by index the new 'ListNode' element with the input 'String' message in the 'DoublyLinkedList'.
    public void insert(String data, int index){
        if(index > this.length || index < 1){ return; }

        //If there is no elements in the 'DoublyLinkedList' at all.
        if(this.length == 0){
            this.insertBefore(data);
            return;
        }

        //If the index points on the last element in the 'DoublyLinkedList'.
        if(index == this.length){
            this.insertAfter(data);
            return;
        }

        int i = 1;

        //If the input index points on the position somewhere in the middle of 'DoublyLinkedList'.
        for(ListNode current = this.head; current != null; current = current.next, i++){
            if(index == i){
                ListNode newDataToInsert = new ListNode(data);
                ListNode previousNode = current.previous;

                previousNode.next = newDataToInsert;
                newDataToInsert.previous = previousNode;
                newDataToInsert.next = current;
                current.previous = newDataToInsert;

                ++length;
                return;
            }
        }
    }

    //Returns 'ListNode' copy of the existing one in the 'DoublyLinkedList'. If it already exists there.
    //Otherwise, 'null' value will be returned.
    public ListNode find(String data){
        if(this.isEmpty() || !this.contains(data)){ return null; }

        //Checking of all the 'ListNode' elements is in the the 'DoublyLinkedList' for having
        // the similar 'String' "data" as the input one.
        for(ListNode current = this.head; current != null; current = current.next){
            if(current.data.equals(data)){
                return current;
            }
        }
        return null; //If there is no such an element in ''DoublyLinkedList' at all.
    }

    //Returns 'ListNode' "data" value by the input index, if it, of course, exsits in the DoublyLinkedList.
    //Otherwise, 'null' value will be returned.
    public ListNode find(int index){
        if(this.isEmpty() || this.length < index || index < 0){ return null; }

        ListNode temp = this.head;
        int i = 1;

        while(i <= this.length){
            if(temp == null){ return null; }
            if(i == index){ return temp; }
            temp = temp.next;
            ++i;
        }
        return null;
    }


    //Returns the quantity of 'ListNode' objects inside the DoublyLinkedList.
    public int length(){
        return length;
    }


    //Removes all the'ListNode' elements from 'DoublyLinkedList'.
    public void clear(){
        if(this.isEmpty()) { return; }
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    //Displays all the 'ListNode' "data" elements of 'DoublyLinkedList' in the list in ascending way.
    public void displayASC(){
        if(this.isEmpty()) { return; }

        ListNode temp = this.head;
        int count = 0;
        int line = 1;

        while(temp != null){
            if(count == 0) { //If "count" has zero value, the "line" marks newly created line.
                System.out.print(line + " : ");
            }
            System.out.print(temp.data);
             if(temp.next == null){
                 System.out.println();
                 return; }
             temp = temp.next;
             ++count;
             if(count >= 10){ //Starts new line after each tenth iteration.
                 System.out.println();
                 count = 0;
                 ++line;
                 continue;
             }
            System.out.print(" <--> ");
        }
    }


    //Displays all the 'ListNode' "data" elements of DoublyLinkedList in the list in descending way.
    public void displayDESC(){
        if(this.isEmpty()) { return; }

        ListNode temp = this.tail;
        int count = 0;
        int line = 1;

        while(temp != null){
            if(count == 0) { //If "count" has zero value, the "line" marks newly created line.
                System.out.print(line + " : ");
            }
            System.out.print(temp.data);
            if(temp.previous == null){
                System.out.println();
                return; }
            temp = temp.previous;
            ++count;
            if(count >= 10){ //Starts new line after each tenth iteration.
                System.out.println();
                count = 0;
                ++line;
                continue;
            }
            System.out.print(" <--> ");
        }
    }

    //Checks if the ''DoublyLinkedList' has no 'ListNode' elements at all.
    private boolean isEmpty(){
        return length == 0;
    }
}