/*
 * BST implementation
 * K extends comparable: mens that K is a class 
 * that is forced to implement the compareTo method
 * 
 * Menaing, the key object has to have the compareTo
 * method implemnted so that it can be compared
 * against other objects
 */
public class BST<K extends Comparable<K>, V>{
    
    //Node class keeps pair (key, value) together in the BST
    private class Node{
        K key; // the data type is K
        V value; // the data type is V
        Node left; // left subtree
        Node right; //right subtree
        
        Node(K key, V value){
            this.key = key; //instance variable is initialized
            this.value = value;
            left=right=null;
        }
    }

    private Node root; //root of the BST
    private int size; //number of items in the BST

    //searches for trget and returns the value associated with that target
    public V get(K target){
        Node ptr = root; //start at the root

        while(ptr!=null){
            int cmp = target.compareTo(ptr.key);
            if(cmp ==0){
                //found the value
                return ptr.value;
            }
            else if (cmp<0){
                //target is smaller --> go left
                ptr = ptr.left;
            }
            else{
                //target is bigger --> go right
                ptr = ptr.right;
            }
        }
        return null; //target not found
    }

    public void put(K key, V value){

        //1. search for the key
        Node ptr = root;
        Node prev = null; //one step behind ptr
        int cmp;
        while(ptr!=null){
            cmp = key.compareTo(ptr.key);
            if(cmp == 0){
                //key is found
                ptr.value = value;
                return; //quit the method
            }
            prev=ptr;
            if (cmp<0){
                //prev = ptr;
                ptr = ptr.left;
            }
            else{
                //prev = ptr;
                ptr = ptr.right;
            }
        }

        //ptr==null
        //2.insert
        cmp = prev.key.compareTo(ptr.key);
        Node newNode = new Node(key, value);
        if(prev == null)
            root = newNode;
        else{
            if(cmp>0)
                prev.right = newNode;
            else
                prev.left = newNode;
        }
        
    }
}
