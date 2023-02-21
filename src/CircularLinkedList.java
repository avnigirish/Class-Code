public class CircularLinkedList<T> {
    
    private class Node<T>{
        T data;
        Node<T> next;
    }

    private Node<T> last;
    int size;
    
    public CircularLinkedList(){
        last = null;
        size=0;
    }

    public boolean isEmpty(){
        return last == null;
    }

    public void addToFront(T dataToInsert){
        Node<T> newNode = new Node<T>();
        newNode.data = dataToInsert;
        if(isEmpty()){
            //first node ot be added in the CLL
            newNode.next = newNode; // newNode points to itself    
            last = newNode;    
        }
        else{
            newNode.next = last.next;   // newNode points to the old first
            last.next = newNode;
        }
        //last = newNode; //this is the last node
        size++;
    }

    // Running time: O(1)
    public void removeFront(){
        if(!isEmpty()){
            if(last == last.next){
                //one item in the CLL
                last = null;
            }
            else{
                last.next = last.next.next;
            }
            size--;
        }
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        Node<T> ptr = last.next; //ptr points to the first Node
        do{
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }while(ptr != last.next);
        
    }
}
