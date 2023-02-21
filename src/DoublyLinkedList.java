// T is a place holder for the data type
// T is an abstract data type
// T cannot be a primatve type
//if you need a DLL of int, then use an integer (wrapper for int)
public class DoublyLinkedList<T>{
    private class Node<T>{
        T data;    // data part
        Node<T> next;      // link to next node in the DLL
        Node<T> prev;      // link to the previous node in the DLL
    }

    private Node<T> first; // reference to the first node in the DLL
    private int size;

    //contructor
    public DoublyLinkedList(){
        first = null;
        size = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    public void addToFront (T dataToInsert){
        Node<T> newNode = new Node<T>();
        newNode.data = dataToInsert; //update data
        newNode.next = first; //points to oldFirst
        newNode.prev = null; 
        if(!isEmpty()){
            first.prev = newNode; //oldFirst points to the newFirst
        } 
        first = newNode; 
        size++;
    }

    public void print(){
        System.out.print("null -> ");
        for(Node<T> ptr = first; ptr!=null; ptr = ptr.next){
            System.out.print(ptr.data + " <-> ");
        }
        System.out.println("-> null");
    }

    public boolean addAfter(T dataToInsert, T target){
        // search for target
        Node<T> ptr = first;
        while (ptr != null && !ptr.data.equals(target)){
            ptr = ptr.next;
        }
        // 1. target not found
        if(ptr == null){
            return false;
        }
        
        //2. target found
        // create node
        Node<T> newNode = new Node<T>();
        newNode.data = dataToInsert;
        newNode.next = ptr.next;
        newNode.prev = ptr;
        ptr.next = newNode;
        if(newNode.next != null){
            newNode.next.prev = newNode;
        }
        size++;
        return true;
    }

    public static void main (String[] args){
        DoublyLinkedList<String> dll = new DoublyLinkedList<>(); //empty dll
        dll.addToFront("Rockstar");
        dll.addToFront("Our line are sealed!");
        dll.addToFront("Flowers");
        dll.addToFront("Funkbot 1000");
        dll.addToFront("Funkybot");
        dll.addAfter("Pyramids", "Flowers");
        dll.print();
    }
}