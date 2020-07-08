package com.Akif;

import java.util.*;

/***
 * This class is implementation of Deque class which implements Deque interface
 * and extends from AbstractCollection Class .
 * It uses DoubleLinkedList class references to keep data.
 * @see DoubleLinkedList
 * @param <E> Type of the list
 */
@SuppressWarnings("unchecked")
public class MyDeque<E> extends AbstractCollection<E> implements Deque<E> {
    private DoubleLinkedList<E> data;
    private DoubleLinkedList<E> removedNodes;
    public MyDeque(){
        data = new DoubleLinkedList<> ();
        removedNodes = new DoubleLinkedList<> ();
    }

    /***
     * Inserts the specified element into the queue
     * represented by this deque (in other words, at the tail of this deque).
     * This method is equivalent to addLast(E).
     * @param e the element to add
     * @return true since there is no capacity restrictions.
     */
    @Override
    public boolean add (E e) {
        addLast (e);
        return true;
    }

    /***
     * Inserts the specified element at the front of this deque.
     * if it is possible to do so immediately without violating capacity restrictions.
     * @param e the element to add
     */
    @Override
    public void addFirst (E e) {
        if (removedNodes.size ()>0)
            data.addByNode (0,e,removedNodes.removeAndGetNode (0));
        else
            data.addFirst (e);
    }

    /***
     * Inserts the specified element at the end of this deque.
     * if it is possible to do so immediately without violating capacity restrictions.
     * @param e the element to add
     */
    @Override
    public void addLast (E e) {
        if (removedNodes.size ()>0)
            data.addByNode (data.size (),e,removedNodes.removeAndGetNode (0));
        else
            data.add (e);
    }

    /***
     * Inserts the specified element into the queue.
     * represented by this deque (in other words, at the tail of this deque)
     * @param e the element to add
     * @return true if the element was added to this deque, else false
     */
    @Override
    public boolean offer (E e) {
        offerLast (e);
        return true;
    }

    /***
     * Inserts the specified element at the front of this deque
     * unless it would violate capacity restrictions.
     * @param e the element to add
     * @return true if the element was added to this deque, else false
     */
    @Override
    public boolean offerFirst (E e) {
        addFirst (e);
        return true;
    }

    /***
     * Inserts the specified element at the end of this deque
     * unless it would violate capacity restrictions.
     * @param e the element to add
     * @return true if the element was added to this deque, else false
     */
    @Override
    public boolean offerLast (E e) {
        addLast (e);
        return true;
    }

    /***
     * Retrieves and removes the first element of this deque. This method differs
     * from pollFirst only in that it throws an exception if this deque is empty.
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E removeFirst () {
        if (isEmpty ())
            throw new NoSuchElementException ();
        return removeF ();
    }

    /***
     * Retrieves and removes the last element of this deque. This method differs
     * from pollLast only in that it throws an exception if this deque is empty.
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E removeLast () {
        if (isEmpty ())
            throw new NoSuchElementException ();
        return removeL ();
    }

    /***
     * Retrieves and removes the first element of this deque,
     * or returns null if this deque is empty.
     * @return the head of this deque, or null if this deque is empty.
     */
    @Override
    public E pollFirst () {
        if (isEmpty ())
           return null;
        return removeF ();
    }

    /***
     * Retrieves and removes the last element of this deque,
     * or returns null if this deque is empty.
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E pollLast () {
        if (isEmpty ())
            return null;
        return removeL ();
    }

    /***
     * Retrieves, but does not remove, the first element of this deque. This method differs
     * from peekFirst only in that it throws an exception if this deque is empty.
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E getFirst () {
        if (isEmpty ())
            throw new NoSuchElementException();
        return getF ();
    }

    /***
     * Retrieves, but does not remove, the last element of this deque. This method differs
     * from peekLast only in that it throws an exception if this deque is empty.
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E getLast () {
        if (isEmpty ())
            throw new NoSuchElementException();
        return getL ();
    }

    /***
     * Retrieves, but does not remove, the first element of this deque,
     * or returns null if this deque is empty.
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public E peekFirst () {
        if (isEmpty ())
            return null;
        return getF ();
    }

    /***
     * Retrieves, but does not remove, the last element of this deque,
     * or returns null if this deque is empty
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E peekLast () {
        if (isEmpty ())
            return null;
        return getL ();
    }

    /***
     * Removes the first occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * @param o element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean removeFirstOccurrence (Object o) {
        if (o == null)
            throw new NullPointerException ();
        if (data.contains (o)){
            removedNodes.addByNode (removedNodes.size (),(E)o,data.removeAndGetNode (data.indexOfFirst (o)));
            return true;
        }
        else{
            return false;
        }
    }

    /***
     * Removes the last occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * @param o element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean removeLastOccurrence (Object o) {
        if (o == null)
            throw new NullPointerException ();
        if (data.contains (o)){
            removedNodes.addByNode (removedNodes.size (),(E)o,data.removeAndGetNode (data.indexOfLast (o)));
            return true;
        }
        else{
            return false;
        }
    }

    /***
     * Retrieves and removes the head of the queue
     * represented by this deque (in other words, the first element of this deque).
     * This method differs from poll only in that it throws an exception if this deque is empty.
     * This method is equivalent to removeFirst().
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E remove () {
        return removeFirst ();
    }

    /***
     * Retrieves and removes the head of the queue represented by this deque
     * (in other words, the first element of this deque), or returns null if this deque is empty.
     * This method is equivalent to pollFirst().
     * @return the first element of this deque, or null if this deque is empty
     */
    @Override
    public E poll () {
        return pollFirst ();
    }

    /***
     * Retrieves, but does not remove, the head of the queue represented by this deque
     * (in other words, the first element of this deque). This method differs from peek
     * only in that it throws an exception if this deque is empty.
     * This method is equivalent to getFirst().
     * @return the head of the queue represented by this deque.
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E element () {
        return getFirst ();
    }

    /***
     * Retrieves, but does not remove, the head of the queue represented by this deque
     * (in other words, the first element of this deque), or returns null if this deque is empty.
     * This method is equivalent to peekFirst().
     * @return the head of the queue represented by this deque, or null if this deque is empty
     */
    @Override
    public E peek () {
        return peekFirst ();
    }

    /***
     * Pushes an element onto the stack
     * represented by this deque (in other words, at the head of this deque)
     * This method is equivalent to addFirst(E).
     * @param e the element to push
     */
    @Override
    public void push (E e) {
        addFirst (e);
    }

    /***
     * Pops an element from the stack represented by this deque.
     * In other words, removes and returns the first element of this deque.
     * This method is equivalent to removeFirst().
     * @return the element at the front of this deque
     */
    @Override
    public E pop () {
        return removeFirst ();
    }

    /***
     * Removes the first occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * @param o element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove (Object o) {
        return removeFirstOccurrence (o);
    }

    /***
     * Returns true if this list contains the specified element.
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains (Object o) {
        return data.contains (o);
    }
    /***
     * Returns size of the list.
     * @return size of the list.
     */
    @Override
    public int size () {
        return data .size ();
    }

    /***
     * Returns removed elements size.
     * @return removed elements size.
     */
    public int removedSize () {
        return removedNodes .size ();
    }
    /***
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     */
    @Override
    public boolean isEmpty () {
        return data.isEmpty ();
    }

    /***
     * Returns an iterator over the elements in this deque in proper sequence.
     * The elements will be returned in order from first (head) to last (tail).
     * @return an iterator over the elements in this deque in proper sequence
     */
    @Override
    public Iterator<E> iterator () {
        return data.myListIterator ();
    }

    /***
     * Returns an iterator over the elements in this deque in reverse sequential order.
     * The elements will be returned in order from last (tail) to first (head).
     * @return an iterator over the elements in this deque in reverse sequence
     */
    @Override
    public Iterator<E> descendingIterator () {
        return data.getDescendingIterator ();
    }

    /***
     * Returns a string to print list to the screen in a good shape.
     * @return a string to print list to the screen in a good shape.
     */
    public String toString(){
        return String.format ("Data: %s \nRemoved Data: %s\n",data.toString (),removedNodes.toString ());
    }

    /***
     * A common method to remove last element of the list.
     * It removes last element and add it to removed element list.
     * @return the tail of this deque
     */
    private E removeL(){
        removedNodes.addByNode (removedNodes.size (),data.getLast (),data.removeAndGetNode (data.size ()-1));
        return removedNodes.getLast ();
    }
    /***
     * A common helper method to remove first element of the list.
     * It removes first element and add it to removed element list.
     * @return the head of this deque
     */
    private E removeF(){
        removedNodes.addByNode (removedNodes.size (),data.getFirst (),data.removeAndGetNode (0));
        return removedNodes.getLast ();
    }
    /***
     * A common helper method to get first element of the list.
     * @return the head of this deque
     */
    private E getF(){
        return data.getFirst ();
    }
    /***
     * A common helper method to get last element of the list.
     * @return the tail of this deque
     */
    private E getL(){
        return data.getLast ();
    }

}
