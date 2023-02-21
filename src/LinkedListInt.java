import java.util.NoSuchElementException;

public class LinkedListInt{

    //linked list of integers

    //private class: only visible inside LinkedListInt
    private class Node{
        private int data; // data part
        private Node next; //link part

        // constructor for the Node class
        Node (int dataToInsert, Node link){
            data = dataToInsert;
            next = link;
        }
    }

    //instance varuables of the LinkedListInt class
    private Node front;

    // constructor
     LinkedListInt(){
        front = null; // empty LL
     }

     // inserts a node to the front of the LL
     // Running time: f(n) = 2 => O(1)
     public void addToFront (int nodeData){
        Node newNode = new Node(nodeData, front);
        front = newNode;
     }

     public void deleteFront(){
        if(front == null){
            // reate an objext of type exception
            // throw/send it back to the method that called this method
            throw new NoSuchElementException("Linked list is empty");
        }
        front = front.next; // front points to the seond node of the LL
        // the old front will be removed when the garbage collector wakes up
     }
     
     // Iterates through the LL and prints all its data
     // Running time: f(n) = n+1 => O(n)
     // Count ptr assignment: f(n) = n+1
     public void print(){
        Node ptr = front; //ptr is pointing to the first node of LL
        while (ptr != null){
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("\\");
     }

     public boolean search (int target){
        Node ptr = front;
        while (ptr!=null){
            if(ptr.data == target){
                return true;
            }
            ptr = ptr.next; // ptr points to the next node in the LL
        }
        return false;
     }

     public boolean insertAfter (int target, int dataToInsert){
        Node ptr = front;
        while (ptr!=null){
            if(ptr.data ==target){
                //insert dataToInsert after the object that holds target
                Node newNode = new Node (dataToInsert, ptr);
                ptr.next = newNode;
                return true;
            }
            ptr = ptr.next;
        }
        return false;
     }

     public boolean delete (int target){
        Node ptr = front;
        Node prev = null;
        while (ptr!=null){
            if(ptr.data==target){
                if(ptr==front) //dataTodDelete is at the first node of the LL
                    front = front.next;
                else
                    prev.next = ptr.next;
                return true;
            }
            prev = ptr;
            ptr = ptr.next;
        }
        // dataToDelete not found
        return false;
     }

     //client: test the LinkedListInt class
     public static void main (String[]args){
        LinkedListInt lli = new LinkedListInt();
        try{
            lli.deleteFront();
        }catch(NoSuchElementException referenceToExceptionObject){
            System.out.println("Oops, Empty Linked list");
        }
        lli.addToFront(9);
        lli.addToFront(8);
        lli.addToFront(5);
        lli.addToFront(2);
        lli.addToFront(1);
        lli.print();
        lli.deleteFront();
        lli.print();
        lli.insertAfter(5, 6);
        lli.print();
     }
}