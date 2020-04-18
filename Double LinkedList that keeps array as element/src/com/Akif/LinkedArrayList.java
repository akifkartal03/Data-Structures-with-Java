package com.Akif;

import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/***
 * This class is implementation of Java Linked List.
 * Each node contains an array of elements with constant capacity.
 * @param <E> Type of the List
 */
@SuppressWarnings("unchecked")
public class LinkedArrayList<E> extends AbstractList<E> implements List<E>  {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    private int nodeSize =0;
    /***
     * Appends the specified element into array that at the end of this list.
     * If the capacity of the array is exhausted, it creates a new node (containing an empty
     * array) at the end of the linked list.
     * @param e element to be appended to this list
     * @return true if this collection changed as a result of the call
     */
    public boolean add(E e){
        MyListIterator iter = new MyListIterator (size);
        iter.add (e);
        //our collection permits duplicates and already contains the specified element
        return true;// Returns true if this collection changed as a result of the call.
    }

    /***
     * Inserts the specified element at the specified position in this list.
     * If the capacity of the array is exhausted, it creates a new node (containing an empty
     * array) at the specified position in the linked list.
     * @param index index at which the specified element is to be inserted
     * @param obj element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index,E obj){
        MyListIterator iter = new MyListIterator (index);
        iter.add (obj);
    }
    /***
     * This method adds a new element at front of the linked list.
     * If the capacity of the array is exhausted, it creates a new node (containing an empty
     * array) in front of the linked list.
     * @param obj new element that will be added.
     */
    public void addFirst(E obj){
        MyListIterator iter = new MyListIterator (0);
        iter.add (obj);
    }
    /***
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get (int index) {
        MyListIterator iter = new MyListIterator (index);
        return iter.get ();
    }
    /***
     * Returns the first element in this list.
     * @return the first element in this list.
     */
    public E getFirst(){
        MyListIterator iter = new MyListIterator (0);
        return iter.get ();
    }
    /***
     * Returns the last element in this list.
     * @return the last element in this list.
     */
    public E getLast(){
        MyListIterator iter = new MyListIterator (size-1);
        return iter.get ();
    }

    /***
     * Removes the first occurrence of the specified element from this list, if it is present.
     * @param obj element to be removed from this list, if present
     * @return true if this list contained the specified element, otherwise false
     */
    public boolean remove(Object obj){
        MyListIterator iter = new MyListIterator (0);
        int index;
        while (iter.hasNext ()){
            if (iter.next ().equals (obj)){
                index=iter.nextItem.searchAndGetIndex ((E)obj);
                iter.nextItem.remove (index);
                size--;
                if (iter.nextItem.getSize () == 0)
                    iter.remove ();
                return true;
            }
        }
        return false;
    }

    /***
     * Removes the element at the specified position in this list.
     * Returns the removed first element of  at the specified position in this list.
     * @param index the index of the element to be removed
     * @return removed first element at the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E remove(int index){
        MyListIterator iter = new MyListIterator (index);
        size--;
        E temp = iter.nextItem.remove (iter.arrayIndex);
        if (iter.nextItem.getSize ()==0){
            iter.remove ();
        }
        return temp;
    }
    /***
     * Returns size of the list.
     * @return size of the list.
     */
    @Override
    public int size () {
        return size;
    }

    /***
     * Returns node size of the linked list.
     * @return node size of the linked list.
     */
    public int getNodeSize(){
        return nodeSize;
    }
    /***
     *  Returns the index of the first occurrence of the specified element in this list
     *  or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list
     * or -1 if this list does not contain the element
     */
    @Override
    public int indexOf (Object o) {
        MyListIterator iter = new MyListIterator (0);
        int index,i=0;
        while (iter.hasNext ()){
            if (iter.next ().equals (o)){
                return iter.elementIndex-1;
            }
        }
        return -1;
    }

    /***
     * Returns a MyListIterator over the elements in this list (in proper sequence).
     * @return  MyListIterator over the elements in this list (in proper sequence)
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
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     */
    @Override
    public boolean isEmpty () {
        return size==0;
    }
    /***
     * Returns true if this list contains the specified element.
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
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
    @Override
    public String toString () {
        MyListIterator iter = new MyListIterator (0);
        StringBuilder result = new StringBuilder ();
        while (iter.hasNext ()){
            result.append (iter.nextItem.toString ());
            iter.go ();
            if (iter.nextItem!=null)
                result.append ("==>");
        }
        return result.toString ();
    }
    /***
     * This class is implementation of Java ListIterator<E> interface.
     */
    private class MyListIterator implements ListIterator<E> {
        private Node<E> nextItem;
        private Node<E> lastItem;
        private int index;
        private int flag;
        private int elementIndex;
        private E nextElement;
        private int arrayIndex;
        /***
         * One parameter constructor to create a iterator from a specific position on the list.
         * @param i starting position of the iterator
         */
        public MyListIterator(int i){
            if (i<0 || i>size)
                throw new IndexOutOfBoundsException("Invalid Index"+i);
            lastItem = null;
            if (i==size){
                index=nodeSize;
                nextItem = tail;
                elementIndex=size;
                arrayIndex = 0;
                flag = 1;
            }
            else if(i==0){
                arrayIndex =0;
                elementIndex =0;
                index=0;
                nextItem = head;
                flag = 2;
                int k =0;
                nextElement = nextItem.get (k);
            }
            else{
                arrayIndex =0;
                elementIndex =0;
                index=0;
                nextItem = head;
                flag = 2;
                int k =0;
                nextElement = nextItem.get (k);
                for (int j =0 ;j<=i;j++){
                    if (nextItem.getSize () == k){
                        nextItem=nextItem.next;
                        index++;
                        k=0;
                        arrayIndex=0;
                        nextElement = nextItem.get (k);
                        k++;
                    }
                    else{
                        nextElement = nextItem.get (k);
                        k++;
                        arrayIndex++;
                        elementIndex++;
                    }
                }
            }

        }

        /***
         * Inserts the specified element into the list.
         * @param obj the element to insert
         */
        public void add(E obj){
            if (nextItem!=null){
                if (!nextItem.is_full ()){
                    nextItem.add (obj);
                }
                else{
                    if (nextItem == head && flag == 2){
                        Node<E> newNode= new Node<E> (obj);
                        newNode.next = nextItem;
                        nextItem.prev=newNode;
                        head = newNode;
                        index++;
                        nodeSize++;
                    }
                    else if (nextItem == tail && flag == 1){
                        Node<E> newNode = new Node<E>(obj);
                        tail.next = newNode;
                        newNode.prev = tail;
                        tail = newNode;
                        index++;
                        nodeSize++;
                    }
                    else{
                        Node<E> newNode = new Node<> (obj);
                        newNode.prev = nextItem.prev;
                        nextItem.prev.next = newNode;
                        newNode.next = nextItem;
                        nextItem.prev = newNode;
                        index++;
                        nodeSize++;
                    }
                }
            }
            else{
                head =new Node<> (obj);
                tail = head;
                index++;
                nodeSize++;
            }
            size++;
            lastItem = null;
        }

        /***
         * Returns true if this list iterator has more elements when traversing the list in the forward direction.
         * @return true if the list iterator has more elements when traversing the list in the forward direction.
         */
        public boolean hasNext(){
            return nextItem!= null;
        }

        /***
         * Returns true if this list iterator has more elements when traversing the list in the reverse direction.
         * @return true if the list iterator has more elements when traversing the list in the reverse direction.
         */
        public boolean hasPrevious(){
            return nodeSize!=0 && nextItem!= null && nextItem.prev !=null;
        }
        /***
         * Returns the next element in the list and advances the cursor position.
         * @return the next element in the list
         * @throws NoSuchElementException if the iteration has no next element
         */
        public E next(){
            if (!hasNext ()){
                throw new NoSuchElementException ();
            }
            if (arrayIndex>=nextItem.getSize ()){
                lastItem = nextItem;
                nextItem =nextItem.next;
                index++;
                arrayIndex=0;
            }
            if (nextItem!=null){
                nextElement = nextItem.get (arrayIndex);
                elementIndex++;
                arrayIndex++;
                return nextElement;
            }
            else{
                return nextElement;
            }
        }
        public void go(){
            if (!hasNext ()){
                throw new NoSuchElementException ();
            }
            lastItem = nextItem;
            nextItem =nextItem.next;
            index++;
        }
        /***
         * Returns the index of the element that would be returned by a subsequent call to next().
         * @return the index of the element that would be returned by a subsequent call to next,
         * or list size if the list iterator is at the end of the list.
         */
        public int nextIndex(){
            return elementIndex+1;
        }
        /***
         * Returns the previous element in the list and moves the cursor position backwards.
         * @return the previous element in the list.
         * @throws NoSuchElementException if the iteration has no previous element.
         */
        public E previous(){
            if (!hasPrevious ())
                throw new NoSuchElementException ();
            if (nextItem == null)
                nextItem = tail;
            else{
                if (arrayIndex==0){
                    nextItem = nextItem.prev;
                    lastItem = nextItem;
                    index--;
                    arrayIndex = nextItem.getSize ();
                }
                arrayIndex--;
                elementIndex--;
                nextElement = nextItem.get (arrayIndex);
            }
            return nextElement;
        }

        /***
         * Returns the index of the element that would be returned by a subsequent call to previous().
         * @return the index of the element that would be returned by a subsequent call to previous,
         * or -1 if the list iterator is at the beginning of the list.
         */
        public int previousIndex(){
            return elementIndex-1;
        }

        /***
         * Removes from the list the last element that was returned by next() or previous()
         * @throws NoSuchElementException if the list is empty
         */
        public void remove(){
            if (head == null){
                throw new NoSuchElementException ();
            }
            else if (head != null && head.next == null){
                nextItem = null;
                head = null;
                tail = null;
                nodeSize--;
                index--;
            }
            else if (nextItem.next == null){
                nextItem.prev.next = null;
                tail = nextItem.prev;
                nodeSize--;
                index--;
            }
            else if (nextItem.prev == null && nextItem.next !=null){
                nextItem.next.prev =null;
                head = nextItem.next;
                nodeSize--;
                index--;
            }
            else{
                nextItem.prev.next = nextItem.next;
                nextItem.next.prev = nextItem.prev;
                nodeSize--;
                index--;
            }
            lastItem = null;
        }

        /***
         * Replaces the last element( returned by next() or previous() with the specified element.
         * @param e the element with which to replace the last element returned by next or previous.
         * @throws IllegalStateException if neither next nor previous have been called,
         * or remove or add have been called after the last call to next or previous.
         */
        public void set(E e){
            if (lastItem!=null){
                lastItem.set (lastItem.getSize ()-1,e);
            }
            else{
                throw new IllegalStateException ();
            }
        }
        public E get(){
            return nextElement;
        }
    }

    /***
     * Node class to build a linked list.
     * @param <E> Type of each node.
     */
    private static class Node<E>{
        private E[] data;
        private Node<E> next;
        private Node<E> prev;
        private int size;
        private int capacity;
        /***
         * No parameter constructor it initializes array with constant(10) size.
         * Next and prev references will be null.
         */
        public Node(){
            capacity = 10;
            size=0;
            data = (E[]) new Object[capacity];
            next = null;
            prev = null;
        }
        /***
         * One parameter constructor it initializes array with constant(10) size.
         * It adds the specified element to the 0th index of the array.
         * Next and prev references will be null.
         * @param element the element to insert.
         */
        public Node(E element){
            capacity = 10;
            size=0;
            data = (E[]) new Object[capacity];
            data[size] =element;
            size++;
            next = null;
            prev = null;
        }
        /***
         * Two parameter constructor it initializes array with specified array
         * Next and prev references will be null.
         * @param arr the array to insert.
         * @param size size of array.
         */
        public Node(E[] arr,int size){
            data = arr;
            this.size = size;
            capacity = arr.length;
            next = null;
            prev = null;
        }

        /***
         * Two parameter constructor it initializes array with specified array and
         * initializes references with specified elements
         * @param arr array to insert
         * @param size size of array
         * @param n next reference
         * @param p prev reference
         */
        public Node(E[] arr,int size,Node<E> n ,Node<E> p){
            data = arr;
            this.size = size;
            capacity = arr.length;
            next = n;
            prev= p;
        }
        /***
         * Appends the specified element to the end of this array.
         * @param value element to be appended to this array.
         * @throws ArrayIndexOutOfBoundsException if the array size is full
         */
        public void add(E value){
            if (is_full ()){
                throw new ArrayIndexOutOfBoundsException();
            }
            data[size]=value;
            size++;
        }
        /***
         * Removes the element at the specified position in this array.
         * It shifts the elements (coming after the removed element) in that array only.
         * @param index the index of the element to be removed
         * @return removed element.
         * @throws ArrayIndexOutOfBoundsException if the index is out of range
         */
        public E remove(int index){
            if (!checkBorder(index))
                throw new ArrayIndexOutOfBoundsException(index);
            E temp = data[index];
            // shift the elements (coming after the removed element)
            for (int i = index + 1 ; i < size; i++){
                data[i-1] = data[i];
            }
            size--;
            return temp;
        }
        /***
         * Searches for specified element in the array.
         * if finds return index of the element,otherwise return -1
         * @param item element will be searched.
         * @return  if finds return index of the element,otherwise return -1
         */
        public int searchAndGetIndex(E item){
            for (int i = 0; i<size;i++){
                if (data[i].equals (item)){
                    return i;
                }
            }
            return -1;
        }

        /***
         * Returns the element at the specified position in this list.
         * @param index index of the element to return
         * @return the element at the specified position in this list
         * @throws ArrayIndexOutOfBoundsException if the index is out of range
         */
        public E get(int index){
            if (!checkBorder(index))
                throw new ArrayIndexOutOfBoundsException(index);
            return data[index];
        }

        /***
         * Replaces the element at the specified position in this list with the specified element.
         * @param index index of the element to replace
         * @param newValue element to be stored at the specified position
         * @throws ArrayIndexOutOfBoundsException if the index is out of range
         */
        public void set(int index, E newValue){
            if (!checkBorder(index))
                throw new ArrayIndexOutOfBoundsException(index);
            data[index] = newValue;
        }

        /***
         * Returns size of array.
         * @return size of array.
         */
        public int getSize(){return size;}

        /***
         * It checks whether array is full or not.
         * @return true if array is full,otherwise false
         */
        public boolean is_full(){
            return capacity==size;
        }

        /***
         * It checks whether index is out of range or not.
         * @param index index value will be checked.
         * @return true if index is okay otherwise false
         */
        private boolean checkBorder(int index){
            return index >= 0 && index < size;
        }

        /***
         * Compares the specified Node with this Node for equality.
         * @param obj the Node to be compared for equality with this Node
         * @return true if the specified Node is equal to this Node
         */
        @Override
        public boolean equals (Object obj) {
            if (obj == null)
                return false;
            if (getClass () != obj.getClass ())
                return false;
            Node<E> temp = (Node<E>)obj;
            if (next!= temp.next || prev != temp.prev || size!= temp.size || capacity!= temp.capacity)
                return false;
            else{
                for (int i=0;i<getSize ();i++){
                    if (!get (i).equals (temp.get (i)))
                        return false;
                }
            }
            return true;
        }

        /***
         * Returns array as a string to print array to the screen in a good shape.
         * @return array as a string to print array to the screen in a good shape.
         */
        @Override
        public String toString () {
            StringBuilder result = new StringBuilder ();
            result.append ("[");
            for (int i=0;i<getSize ();i++){
                result.append (get (i));
                if (i!=getSize ()-1)
                    result.append (", ");
            }
            result.append ("]");
            return result.toString ();
        }
    }

}
