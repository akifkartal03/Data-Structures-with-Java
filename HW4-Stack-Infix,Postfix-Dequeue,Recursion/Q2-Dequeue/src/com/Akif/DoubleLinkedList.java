package com.Akif;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/***
 * This class is implementation of Java LinkedList Class.
 * Each node contains an element with E type.
 * @param <E> Type of the List
 */
public class DoubleLinkedList<E> {
    /***
     * Head reference of the list
     */
    private Node<E> head;
    /***
     * Tail reference of the list
     */
    private Node<E> tail;
    /***
     * Size of the list
     */
    private int size;

    /***
     * No parameter constructor to initialize values.
     */
    public DoubleLinkedList(){
        head =null;
        tail = null;
        size=0;
    }
    /***
     * Inserts the specified element at the specified position in this list.
     * @param index index at which the specified element is to be inserted
     * @param obj element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index,E obj){
        MyListIterator iter = new MyListIterator (index);
        iter.add (obj);
    }
    /***
     * This method adds a new element in front of the linked list.
     * @param obj new element that will be added.
     */
    public void addFirst(E obj){
        MyListIterator iter = new MyListIterator (0);
        iter.add (obj);
    }
    /***
     * Appends the specified element at the end of this list.
     * @param obj element to be appended to this list
     */
    public boolean add(E obj){
        MyListIterator iter = new MyListIterator (size);
        iter.add (obj);
        return true;
    }
    /***
     * Inserts the specified element at the specified position in this list
     * without creating a new node it uses given node to add.
     * @param index index at which the specified element is to be inserted
     * @param obj element to be inserted
     * @param removedNode a removed node to use again while adding a new element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void addByNode(int index,E obj,Node<E> removedNode){
        MyListIterator iter = new MyListIterator (index);
        iter.addByNode (removedNode,obj);
    }
    /***
     * Returns the first element in this list.
     * @return the first element in this list.
     */
    public E getFirst(){
        if (head == null)
            throw new NoSuchElementException ();
        return head.data;

    }
    /***
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index){
        MyListIterator iter = new MyListIterator (index);
        return iter.nextItem.data;
    }
    /***
     * Returns the last element in this list.
     * @return the last element in this list.
     */
    public E getLast(){
        return tail.data;
    }
    /***
     * Removes the first occurrence of the specified element from this list, if it is present.
     * @param obj element to be removed from this list, if present
     * @return true if this list contained the specified element, otherwise false
     */
    public boolean remove(E obj){
        MyListIterator iter = new MyListIterator (0);
        while (iter.hasNext ()){
            if (iter.nextItem.data == obj){
                iter.remove ();
                return true;
            }
            iter.next();
        }
        return false;
    }
    /***
     * Removes the element at the specified position in this list.
     * Returns removed Node
     * @param index the index of the element to be removed
     * @return removed Node at the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Node<E> removeAndGetNode(int index){
        MyListIterator iter = new MyListIterator (index);
        return iter.removeAndGetNode ();
    }
    /***
     * Removes the element at the specified position in this list.
     * Returns removed element at the specified position in this list.
     * @param index the index of the element to be removed
     * @return removed element at the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E remove(int index){
        MyListIterator iter = new MyListIterator (index);
        E temp = iter.get ();
        iter.remove ();
        return temp;
    }
    /***
     * Returns size of the list.
     * @return size of the list.
     */
    public int size(){
        return size;
    }
    /***
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     */
    public boolean isEmpty(){
        return size==0;
    }
    /***
     *  Returns the index of the first occurrence of the specified element in this list
     *  or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list
     * or -1 if this list does not contain the element
     */
    public int indexOfFirst (Object o) {
        MyListIterator iter = new MyListIterator (0);
        int i=0;
        while (iter.hasNext ()){
            if (iter.next ().equals (o)){
                return i;
            }
            i++;
        }
        return -1;
    }
    /***
     *  Returns the index of the last occurrence of the specified element in this list
     *  or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in this list
     * or -1 if this list does not contain the element
     */
    public int indexOfLast (Object o) {
        MyListIterator iter = new MyListIterator (0);
        int i=0,index=-1;
        while (iter.hasNext ()){
            if (iter.next ().equals (o)){
                index=i;
            }
            i++;
        }
        return index;
    }
    /***
     * Returns true if this list contains the specified element.
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains (Object o) {
        MyListIterator iter = new MyListIterator (0);
        while (iter.hasNext ()){
            if (iter.next ().equals (o)){
                return true;
            }
        }
        return false;
    }
    /***
     * Returns a string to print list to the screen in a good shape.
     * @return a string to print list to the screen in a good shape.
     */
    public String toString(){
        if (!isEmpty ()){
            MyListIterator iter =new MyListIterator (0);
            StringBuilder result = new StringBuilder ();
            while (iter.hasNext ()){
                result.append (iter.next ());
                if (iter.nextItem!=null)
                    result.append ("==>");
            }
            return result.toString ();
        }
        else
            return "Empty";
    }
    /***
     * Returns a MyListIterator over the elements in this list (in proper sequence).
     * Iterator starts from first element in the list.
     * @return  MyListIterator starts from first element in the list.
     */
    public MyListIterator myListIterator(){
        return new MyListIterator (0);
    }
    /***
     * Returns a MyListIterator over the elements in this list (in proper sequence),
     * starting at the specified position in the list.
     * @param index index of the first element to be returned from the list iterator (by a call to next)
     * @return MyListIterator over the elements in this list (in proper sequence),
     * starting at the specified position in the list.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public MyListIterator myListIterator(int index){
        return new MyListIterator (index);
    }
    /***
     * Returns a MyListIterator over the elements in this list in reverse sequential order.
     * The elements will be returned in order from last (tail) to first (head).
     * @return a MyListIterator over the elements in this list in reverse sequence.
     */
    public MyListIterator getDescendingIterator(){
        MyListIterator dIter = new MyListIterator (size);
        dIter.openReverseOrder ();
        return dIter;
    }
    /***
     * Node class to build a linked list.
     * It has next and prev node references.
     * @param <E> Type of data
     */
    private static class Node<E>{
        /***
         * Data in each node
         */
        private E data;
        /***
         * Next reference
         */
        private Node<E> next;
        /***
         * Prev reference
         */
        private Node<E> prev ;
        /***
         * One parameter constructor it initializes the references and data.
         * @param item an element to put in node as data.
         */
        public Node(E item){
            data = item;
            next=null;
            prev = null;
        }
        /***
         * A constructor it initializes the references and data.
         * @param item an element to put node as data.
         * @param n a next reference
         * @param p a previous reference
         */
        public Node(E item,Node<E> n ,Node<E> p){
            data = item;
            next = n;
            prev =p;
        }
    }
    /***
     * This class is implementation of Java ListIterator<E> interface.
     */
    private class MyListIterator implements ListIterator<E>, Iterator<E> {
        /***
         * Current cursor point of iterator.
         */
        private Node<E> nextItem;
        /***
         * Last Cursor point of iterator.
         */
        private Node<E> lastItem;
        /***
         * Index of current cursor.
         */
        private int index;
        /***
         * A flag that to use iterator reverse order.
         */
        private boolean flag;
        /***
         * One parameter constructor to create a iterator
         * from a specific position on the list.
         * @param i starting position of the iterator
         */
        public MyListIterator(int i){
            if (i<0 || i>size)
                throw new IndexOutOfBoundsException("Invalid Index"+i);
            lastItem = null;
            flag=false;
            if (i==size){
                index=size;
                nextItem = null;
            }
            else{
                nextItem = head;
                for (index =0 ;index<i;index++){
                    nextItem = nextItem.next;
                }
            }

        }
        /***
         * Inserts the specified element into the list.
         * It adds by creating a new node.
         * @param obj the element to insert
         */
        public void add(E obj){
            addByNode (new Node<E> (obj),obj);
        }
        /***
         * Inserts the specified element into the list.
         * It adds without creating a new node it uses given node to add element.
         * @param obj the element to insert
         */
        public void addByNode(Node<E> oldNode,E obj){
            oldNode.data =obj;
            if (head == null){
                head =oldNode;
                tail = head;
            }
            else if (nextItem == head){
                oldNode.next = nextItem;
                nextItem.prev=oldNode;
                head = oldNode;
            }
            else if (nextItem == null){
                tail.next = oldNode;
                oldNode.prev = tail;
                tail = oldNode;

            }
            else{
                oldNode.prev = nextItem.prev;
                nextItem.prev.next = oldNode;
                oldNode.next = nextItem;
                nextItem.prev = oldNode;
            }
            size++;
            index++;
            lastItem = null;
        }
        /***
         * Returns true if this list iterator has more elements when traversing the list in the forward direction.
         * @return true if the list iterator has more elements when traversing the list in the forward direction.
         */
        public boolean hasNext(){
            if (!flag) {
                return nextItem!= null;
            }
            else {
                return hasPrevious ();
            }
        }
        /***
         * Returns true if this list iterator has more elements when traversing the list in the reverse direction.
         * @return true if the list iterator has more elements when traversing the list in the reverse direction.
         */
        public boolean hasPrevious(){
            return size>1 && nextItem!=head;
        }
        /***
         * Returns the next element in the list and advances the cursor position.
         * @return the next element in the list
         * @throws NoSuchElementException if the iteration has no next element
         */
        public E next(){
            if (!flag){
                if (!hasNext ()){
                    throw new NoSuchElementException ();
                }
                lastItem = nextItem;
                nextItem =nextItem.next;
                index++;
                return lastItem.data;
            }
            else {
                return previous ();
            }

        }
        /***
         * Returns the index of the element that would be returned by a subsequent call to next().
         * @return the index of the element that would be returned by a subsequent call to next,
         * or list size if the list iterator is at the end of the list.
         */
        public int nextIndex(){
            return index+1;
        }
        /***
         * Returns  the previous element in the list and moves the cursor position backwards.
         * @return the previous element in the list.
         * @throws NoSuchElementException if the iteration has no previous element.
         */
        public E previous(){
            if (!hasPrevious ())
                throw new NoSuchElementException ();
            if (nextItem == null)
                nextItem = tail;
            else
                nextItem = nextItem.prev;
            lastItem = nextItem;
            index--;
            return lastItem.data;
        }
        /***
         * Returns the index of the element that would be returned by a subsequent call to previous().
         * @return the index of the element that would be returned by a subsequent call to previous,
         * or -1 if the list iterator is at the beginning of the list.
         */
        public int previousIndex(){
            return index-1;
        }
        /***
         * Removes from the list the last element that was returned by next() or previous()
         * @throws NoSuchElementException if the list is empty
         */
        public void remove(){
           removeAndGetNode ();
        }
        /***
         * Removes from the list the last element that was returned by next() or previous().
         * It returns removed node from the list.
         * @throws NoSuchElementException if the list is empty
         * @return removed node from the list.
         */
        public Node<E> removeAndGetNode(){
            Node<E> temp;
            if (head == null){
                throw new NoSuchElementException ();
            }
            else if (head.next == null){
                temp = head;
                nextItem = null;
                head = null;
                tail = null;
                size--;
                index--;
            }
            else if (nextItem.next == null){
                temp= nextItem;
                nextItem.prev.next = null;
                tail = nextItem.prev;
                size--;
                index--;
            }
            else if (nextItem.prev == null){
                temp=nextItem;
                nextItem.next.prev =null;
                head = nextItem.next;
                size--;
                index--;
            }
            else{
                temp=nextItem;
                nextItem.prev.next = nextItem.next;
                nextItem.next.prev = nextItem.prev;
                size--;
                index--;
            }
            lastItem = null;
            temp.prev=null;
            temp.next=null;
            return temp;
        }

        /***
         * Returns current element while traversing with iterator.
         * It doesn't advances the cursor position.
         * @return current element while traversing with iterator
         */
        public E get(){
            return nextItem.data;
        }
        /***
         * Replaces the last element returned by next() or previous() with the specified element.
         * @param e the element with which to replace the last element returned by next or previous.
         * @throws IllegalStateException if neither next nor previous have been called,
         * or remove or add have been called after the last call to next or previous.
         */
        public void set(E e){
            if (lastItem!=null){
                lastItem.data = e;
            }
            else{
                throw new IllegalStateException ();
            }
        }

        /***
         * This method opens reverse order
         */
        public void openReverseOrder(){
            flag=true;
        }

        /***
         * This method closes reverse order.
         */
        public void closeReverseOrder(){
            flag=false;
        }
    }

}
