package com.Akif;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

/***
 * This class is to handle heap operations by using ArrayList.
 */
public class MaxHeap {
    /** The ArrayList to hold the data. */
    private ArrayList<AgeData> data;
    /** An optional reference to a Comparator object. */
    Comparator<AgeData> comparator = null;

    /***
     * No parameter constructor to initialize ArrayList.
     */
    public MaxHeap() {
        data = new ArrayList<>();
    }

    /***
     * No parameter constructor to initialize ArrayList and a Comparator.
     * @param comparator The comparator used to order this heap.
     */
    public MaxHeap(Comparator<AgeData> comparator) {
        data = new ArrayList<>();
        this.comparator = comparator;
    }
    /** Insert an item into the heap.
     pre: The ArrayList data is in heap order.
     @param item The item to be inserted
     @throws NullPointerException if the item to be inserted is null.
     */
    public boolean add(AgeData item) {
        if (data.contains (item)){
            data.get (data.indexOf (item)).incrementTotal ();
        }
        else{
            data.add(item);
        }
        //this part is took from book
        //only one little part is changed.
        int child = data.size()-1;
        int parent = (child - 1) / 2;
        while (parent >= 0 && compare(data.get(parent),
                data.get(child)) < 0) {
            swap(parent, child);
            child = parent;
            parent = (child-1) / 2;
        }
        return true;
    }
    /** Remove an item from the heap.
     pre: The ArrayList data is in heap order.
     @return The removed element value or null if empty.
     */
    public AgeData remove(AgeData item) {
        if (isEmpty()) {
            return null;
        }
        if (data.contains (item)){
            int index = data.indexOf (item);
            AgeData result = data.get (index);
            if (result.getTotal ()>1){
                result.decrementTotal ();
            }
            else{
                data.remove (index);
            }
            //this part is took from book
            //only one little part is changed.
            int parent = index;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= data.size()) {
                    break; // Out of heap.
                }
                int rightChild = leftChild + 1;
                int minChild = leftChild;
                if (rightChild < data.size()
                        && compare(data.get(leftChild),
                        data.get(rightChild)) < 0) {
                    minChild = rightChild;
                }
                if (compare(data.get(parent),
                        data.get(minChild)) < 0) {
                    swap(parent, minChild);
                    parent = minChild;
                } else {
                    break;
                }
            }
            return result;
        }
        else{
            throw new NoSuchElementException ();
        }
    }

    /***
     * Find the AgeData object with the same age and return it.
     * @param item an AgeData object of any age.
     * @return Same age AgeData object with given parameter.
     */
    public AgeData find(AgeData item) {
        if (data.contains (item)){
            return data.get (data.indexOf (item));
        }
        else
            throw new NoSuchElementException ();
    }

    /***
     * Returns the number of people younger than given age.
     * @param age any age to check.
     * @return number of people younger than given age.
     */
    public int youngerThan(int age){
        int counter =0;
        for (int i = 0 ; i<data.size ();i++){
            if (data.get (i).getAge ()<age)
                counter = counter+data.get (i).getTotal ();
        }
        return counter;
    }
    /***
     * Returns the number of people older than given age.
     * @param age any age to check.
     * @return number of people older than given age.
     */
    public int olderThan(int age){
        int counter =0;
        for (int i = 0 ; i<data.size ();i++){
            if (data.get (i).getAge ()>age)
                counter = counter+data.get (i).getTotal ();
        }
        return counter;
    }
    /*** Compare two items using either a Comparator object's compare method
     or their natural ordering using method compareTo.
     @pre: If comparator is null, left and right implement Comparable<E>.
     @param left One AgeData item
     @param right The other AgeData item
     @return Negative int if left less than right,
     0 if left equals right,positive int if left > right
     @throws ClassCastException if AgeData items are not Comparable
     */
    @SuppressWarnings("unchecked")
    private int compare(AgeData left, AgeData right) {
        //this part is completely took from book
        if (comparator != null) { // A Comparator is defined.
            return comparator.compare(left, right);
        } else { // Use left's compareTo method.
            return ((Comparable<AgeData>) left).compareTo(right);
        }
    }

    /***
     * Exchanges the object references in data ArrayList at indexes i and j.
     * @param i firs index
     * @param j second index
     */
    private void swap(int i, int j){
        AgeData temp = data.get (i);
        data.set(i,data.get (j));
        data.set (j,temp);
    }

    /***
     * Returns true if this heap contains no elements.
     * @return true if this heap contains no elements
     */
    public boolean isEmpty(){
        return data.size () == 0;
    }

    /***
     * Returns a string representation of this heap.
     * @return a string representation of this heap
     */
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder ();
       for (int i = 0 ; i<data.size ();i++){
           sb.append (data.get (i).toString ());
           sb.append ("\n");
       }
       return sb.toString ();
    }
}
