
package com.Akif;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A Skip List where each node in the lowest-level list keeps several
 * elements instead of just one element as in a B-tree node.
 */
@SuppressWarnings ("unchecked")
public class SkipArrayList<E extends Comparable<E>> implements SearchTree<E> {

    /**
     * Static class to contain the data array and the links
     * @param <E> The element type
     */
    protected static class SLNode<E extends Comparable<E>> {

        public SLNode<E>[] links;
        /** The number of data items in this node */
        public int size = 0;
        /** The information */
        public E[] data;

        /**
         * Create a node of level n
         * @param n The level of this node
         * @param order The size of a node
         */
        @SuppressWarnings("unchecked")
        public SLNode(int n, int order) {
            links = (SLNode<E>[]) new SLNode[n];
            data = (E[]) new Comparable[order - 1];
            size = 0;
        }

        /**
         * Compare the item with elements and return result
         * @param item an element to be compared
         * @return if is there any bigger element return 1 if any element equal return 0 , otherwise return -1
         */
        public int compare(E item){
            for (int i = 0; i <size ; i++) {
                if (data[i].compareTo (item)>0)
                    return 1;
                else if (data[i].compareTo (item)==0)
                    return 0;
            }
            return -1;
        }

        /**
         * gets an element from array
         * @param index index of element
         * @return an element from array
         */
        public E get(int index){
            return data[index];
        }

        /**
         * Sets the given element to the array
         * @param index index of element
         * @param element new  value
         */
        public void set(int index,E element){
            data[index]=element;
        }

        /**
         * adds an element to the array and sorts after
         * @param element element to be added
         */
        public void add(E element){
            data[size]=element;
            size++;
            sort ();
        }

        /**
         * Sorts the elements using selection sort
         */
        public void sort(){
            int n = size;
            for (int fill = 0; fill < n - 1; fill++) {
                int posMin = fill;
                for (int next = fill + 1; next < n; next++) {
                    if (data[next].compareTo(data[posMin]) < 0) {
                        posMin = next;
                    }
                }
                E temp = data[fill];
                data[fill] = data[posMin];
                data[posMin] = temp;
            }
        }

        /**
         * Sets array and size with new values.
         * @param arr new array
         * @param s new size
         */
        public void set(E[] arr,int s){
            data=arr;
            size=s;
        }

        /**
         * returns index of given value
         * @param item element to be searched
         * @return index of given value
         */
        private int getIndex(E item){
            for (int i = 0; i <size ; i++) {
                if (item.compareTo (data[i])==0)
                    return i;
            }
            return -1;
        }

        /**
         * Remove an element from the array by shifting the elements
         * @param item item to be removed
         */
        public void remove(E item){
            int index = getIndex (item);
            if (index!=-1){
                for (int i = index + 1; i < size; i++) {
                    data[i-1] = data[i];
                }
                size--;
            }
        }
    }
    /** The maximum element in a node */
    private int max;
    /** The minimum element in a node */
    private int min;
    /**
     * Maximum level(default)
     */
    int maxLevel = 2;
    /**
     * Nominal maximum capacity
     */
    int maxCap = computeMaxCap(maxLevel);
    /**
     * Natural Log of 2
     */
    static final double LOG2 = Math.log(2.0);
    /**
     * A random number generator
     */
    final static Random rand = new Random();
    /**
     * The current size of the skipList(node number)
     */
    int size;
    /**
     * The head node is a dummy node, it contains no data
     */
    protected SLNode<E> head ;
    /**
     * Construct a Skip List with a specified order
     * @param order - the size of a node
     * @throws IllegalArgumentException if order less than 3
     */
    public SkipArrayList(int order) {
        if (order < 3) {
            throw new IllegalArgumentException("order < 3");
        }
        head = new SLNode<>(maxLevel, order);
        size =0;
        max=order-1; //max element number
        min = (int) (Math.ceil (order/2.0) - 1); //min element number
    }
    /**
     * Method to compute the maximum capacity, given the maximum level. It
     * computes Math.pow(2, maxLevel) - 1, using shift.
     * @return Math.pow(2, maxLevel+1) - 1;
     */
    private static int computeMaxCap(int maxLevel) {
        return ~(~0 << maxLevel);
    }

    /**
     * Method to generate a logarithmic distributed integer between 1 and
     * maxLevel. I.E. 1/2 values returned are 1, 1/4 are 2, 1/8 are 3, 1/16 are
     * 4, etc.
     * @return a random logarithmic distributed integer between 1 and maxLevel
     */
    private int logRandom() {
        int r = rand.nextInt(maxCap);
        int k = (int) (Math.log(r + 1) / LOG2);
        if (k > maxLevel - 1) {
            k = maxLevel - 1;
        }
        return maxLevel - k;
    }

    /**
     * Search for an item in the list
     * @param item The item being sought
     * @return A SLNode array which references the nodes preceding the sought
     * item at each level.
     */
    private SLNode<E>[] search(E item) {
        SLNode<E>[] result = (SLNode<E>[]) new SLNode[maxLevel];
        SLNode<E> current = head;
        for (int i = current.links.length - 1; i >= 0; i--) {
            while (current.links[i] != null
                    && current.links[i].compare (item) < 0) {
                current = current.links[i];
            }
            result[i] = current;
        }
        return result;
    }

    /**
     * Find an object in the skip list
     * @param target The item being sought
     * @return A reference to the object in the skip list that compares equal as
     * determined by compareTo to the target. If not found null is returned.
     */
    @Override
    public E find(E target) {
        SLNode<E>[] update = search(target);
        if (update[0].links[0] != null
                && update[0].links[0].compare (target) == 0) {
            return target;
        } else {
            return null;
        }
    }
    /**
     * Removes the specified element from this list if it is present.
     * @param target object to be removed from this set, if present.
     * @return target if this list contained the specified element otherwise null.
     */
    @Override
    public E delete (E target) {
        if (remove (target))
            return target;
        return null;
    }
    /**
     * Removes the specified element from this list if it is present.
     * @param target object to be removed from this set, if present.
     * @return true if this list contained the specified element.
     */
    @Override
    public boolean remove (E target) {
        //search for element to remove
        SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
        SLNode<E> current = head;
        for (int i = current.links.length-1; i >= 0; i--) {
            while (current.links[i] != null
                    && current.links[i].compare (target) < 0) {
                current = current.links[i];
            }
            pred[i] = current;
        }
        current =current.links[0];
        //if it is in the list remove it
        if (current != null && current.compare (target) == 0) {
            if (current.size==1){
                for (int i = 0; i <maxLevel ; i++) {
                    if (pred[i].links[i]!=current)
                        break;
                    pred[i].links[i] = current.links[i];
                }
                //if size less than 2^(maxLevel-1)
                //decrement the maxLevel
                size--;//decrement the size
                if (size < computeMinLevel (maxLevel)) {
                    maxLevel--;
                    maxCap = computeMaxCap(maxLevel);
                    head.links = Arrays.copyOf(head.links, maxLevel);
                    pred = Arrays.copyOf(pred, maxLevel);
                    pred[maxLevel - 1] = head;
                }
            }
            else{
                current.remove (target);
            }
            return true;
        }
        return false;//this list doesn't contain the specified element.
    }
    /**
     * Returns 2^(maxLevel-1)
     * @param level max level of the list.
     * @return 2^(maxLevel-1)
     */
    private int computeMinLevel(int level){
        return (int) (Math.pow (2,maxLevel-1));
    }
    /**
     * Inserts item where it belongs in the skip list.
     * @param item The item to be inserted
     * @return true If the item is inserted, false if the item was already in
     * the tree.
     */
    @Override
    public boolean add(E item) {
        SLNode<E>[] update = search(item);
        if (update[0].links[0] != null
                && update[0].links[0].compare (item) == 0) {
            return false; // Item already in Skip List
        }
        if (size==0){
            size++;
            if (size > maxCap) {
                maxLevel++;
                maxCap = computeMaxCap(maxLevel);
                head.links = Arrays.copyOf(head.links, maxLevel);
                update = Arrays.copyOf(update, maxLevel);
                update[maxLevel - 1] = head;
            }
            // Create new node for item
            SLNode<E> newNode = new SLNode<>(logRandom(),max+1);
            // Splice new node into list
            newNode.add (item);
            for (int i = 0; i < newNode.links.length; i++) {
                newNode.links[i] = update[i].links[i];
                update[i].links[i] = newNode;
            }
            return true;
        }
        else{
            if (update[0].links[0] != null && update[0].links[0].size==max) {
                // Increment size and adjust maxLevel
                size++;
                if (size > maxCap) {
                    maxLevel++;
                    maxCap = computeMaxCap(maxLevel);
                    head.links = Arrays.copyOf(head.links, maxLevel);
                    update = Arrays.copyOf(update, maxLevel);
                    update[maxLevel - 1] = head;
                }
                // Create new node for item
                SLNode<E> newNode = new SLNode<>(logRandom(),max+1);
                // Splice new node into list
                newNode.add (item);
                for (int i = 0; i < newNode.links.length; i++) {
                    newNode.links[i] = update[i].links[i];
                    update[i].links[i] = newNode;
                }
                sort ();
                return true;
            }
            else{
                if (update[0].links[0] != null){
                    update[0].links[0].add (item);
                }
                else{
                    if (update[0].size==max){
                        size++;
                        if (size > maxCap) {
                            maxLevel++;
                            maxCap = computeMaxCap(maxLevel);
                            head.links = Arrays.copyOf(head.links, maxLevel);
                            update = Arrays.copyOf(update, maxLevel);
                            update[maxLevel - 1] = head;
                        }
                        // Create new node for item
                        SLNode<E> newNode = new SLNode<>(logRandom(),max+1);
                        // Splice new node into list
                        newNode.add (item);
                        for (int i = 0; i < newNode.links.length; i++) {
                            newNode.links[i] = update[i].links[i];
                            update[i].links[i] = newNode;
                        }
                    }
                    else
                        update[0].add (item);
                }
                sort ();
                return true;
            }
        }

    }
    /**
     * Determine if an item is in the tree
     * @param target Item being sought in tree
     * @return true If the item is in the tree, false otherwise
     */
    @Override
    public boolean contains(E target) {
        return find(target) != null;
    }

    /**
     * Remove all data from the tree
     */
    public void clear() {
        for (int i = 0; i < maxLevel; i++) {
            head.links[i] = null;
        }
        size = 0;
    }

    /**
     * Return a list containing the contents of the search tree in ascending order.
     * @return a list containing the contents of the search tree in ascending order.
     */
    public List<E> toList() {
        List<E> list = new ArrayList<>();
        SLNode<E> current = head.links[0];
        while (current != null) {
            list.addAll (Arrays.asList (current.data));
            current = current.links[0];
        }
        return list;
    }
    /**
     * Returns max level of list.
     * @return max level of list.
     */
    public int getMaxLevel () {
        return maxLevel;
    }
    /**
     * Returns max capacity of list.
     * @return max capacity of list.
     */
    public int getMaxCap () {
        return maxCap;
    }
    /**
     * Returns size of list.
     * @return size of list.
     */
    public int size () {
        return size;
    }

    /**
     * Returns String representation of skip list
     * @return String representation of skip list
     */
    @Override
    public String toString () {
        StringBuilder sList=new StringBuilder ();
        for(int i=0;i<maxLevel;i++)
        {
            SLNode<E> list = head.links[i];
            sList.append ("Level "+i+":");
            while(list != null)
            {
                if (list.data!=null)
                    sList.append (Arrays.toString (list.data) +", ");
                list=list.links[i];
            }
            sList.append ("\n");
        }
        return sList.toString ();
    }

    /**
     * Sorts the array nodes.
     */
    private void sort(){
        for(int i=0;i<maxLevel;i++)
        {
            SLNode<E> list = head.links[i];
            while(list != null)
            {
                if (list.links[0]!=null && list.data[0].compareTo (list.links[0].data[0])>0){
                    E[] temp = list.data;
                    int s =list.size;
                    list.set (list.links[0].data,list.links[0].size);
                    list.links[0].set (temp,s);
                }
                list=list.links[0];
            }

        }
    }

    /**
     * Prints Skip List information
     */
    public void printListInfo(){
        System.out.println ("***Skip List information***");
        System.out.println ("Order: "+(max+1));
        System.out.println ("Maximum number of elements in a node: "+max);
        System.out.println ("Minimum number of elements in a node: "+min);
        System.out.println ("Maximum level of the list: "+maxLevel);
        System.out.println ("Maximum Capacity of the list: "+maxCap);
    }
}
