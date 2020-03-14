package com.Akif;

import java.util.NoSuchElementException;

/***
 * <p>
 * This class implement Circular Linked List and its operations.
 * </p>
 * @param <E> Type of Linked List
 */
public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    int size;
    public MyLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    /***
     * <p>
     *  This method adds a new element to the linked list.
     * </p>
     * @param index index of element
     * @param obj new element
     */
    public void add(int index,E obj){
        checkIndex(index);
        if (head==null && index == 0){
            addFirst (obj);
        }
        else if (index == size){
            addLast (obj);
        }
        else{
            Node<E> node = new Node<> (obj);
            Node<E> current = getNode (index-1);
            current.getNext ().setPrev (node);
            node.setNext (current.getNext ());
            node.setPrev (current);
            current.setNext (node);
            size++;
        }

    }

    /***
     * <p>
     *  This method adds a new element to the front of the linked list.
     * </p>
     * @param obj new element that will be added.
     */
    public void addFirst(E obj){
        Node<E> newNode = new Node<> (obj);
        if (head!=null){
            head.setPrev (newNode);
            newNode.setNext (head);
            newNode.setPrev (tail);
            head = newNode;
        }
        else {
            head = newNode;
            tail = newNode;
        }
        size++;
    }
    /***
     * <p>
     *  This method adds a new element to the end of the linked list.
     * </p>
     * @param obj new element that will be added.
     */
    public void addLast(E obj){
        if (head == null){
            addFirst (obj);
        }
        else{
            Node<E> newNode = new Node<> (obj);
            newNode.setPrev (tail);
            tail.setNext (newNode);
            tail = newNode;
            tail.setNext (head);
            size++;
        }
    }
    /***
     * <p>
     *  This method adds a new element to before existing element the linked list.
     * </p>
     * @param newObj new element that will be added.
     * @param existingObj object that is already in list
     * @throws NoSuchElementException if existing element is not in the list.
     */
    public void addBefore(E newObj,E existingObj){
        Node<E> node = getByObject (existingObj);
        if (node != null){

            if (node == head){
                addFirst (newObj);
            }
            else if (node == tail){
                addLast (newObj);
            }
            else{
                Node<E> newNode = new Node<> (newObj);
                node.getPrev ().setNext (newNode);
                newNode.setPrev (node.getPrev ());
                newNode.setNext (node);
                node.setPrev (newNode);
            }
            size++;
        }
        else {
            throw new NoSuchElementException ();
        }
    }

    /***
     * This method returns element that is in given index.
     * @param index index of element.
     * @return element that is found.
     */
    public E getByIndex(int index){
        checkIndex (index);
        return getNode (index).getData ();
    }
    /***
     * This method returns element that is obj.
     * @param obj element.
     * @return element that is found.
     */
    public Node<E> getByObject(E obj){
        Node<E> iter =head;
        for (int i =0 ;i<size;i++) {
            if (iter.getData ().equals (obj)) {
                return iter;
            }
            iter = iter.getNext ();
        }
        return null;
    }
    /***
     * This method deletes element from list.
     * @param obj element that will be deleted.
     * @return true if element found otherwise false.
     */
    public boolean remove(E obj){
        Node<E> iter = getByObject (obj);
       if (iter != null){
           if (iter == head){
               head =iter.getNext ();
               head.setPrev (tail);
           }
           else if(iter==tail){
               tail = iter.getPrev ();
               tail.setNext (head);
           }
           else {
               iter.getPrev ().setNext (iter.getNext ());
               iter.getNext ().setPrev (iter.getPrev ());
           }
           size--;
           return true;
       }
       return false;
    }
    /***
     * This method gives size of list.
     * @return size
     */
    public int size(){
        return size;
    }
    /***
     * This method gives a element from list according to given index.
     * @return element
     */
    public Node<E> getNode(int index){
        checkIndex (index);
        Node<E> iter =head;
        for (int i =0 ;i<index;i++){
            iter = iter.getNext ();
        }
        return iter;
    }
    /***
     * This method checks index value according to boards of the list.
     * @param index value will be checked.
     * @throws  ArrayIndexOutOfBoundsException if index value is not true.
     */
    public void checkIndex(int index){
        if (index<0 || index>size)
            throw new ArrayIndexOutOfBoundsException ();
    }
    /***
     * This method prints element to the screen .
     * @return shape of elements
     */
    @Override
    public String toString () {
        Node<E> iter = head;
        StringBuilder res = new StringBuilder ();
        while(iter!=tail){
            res.append ("==> ");
            res.append (iter.getData ().toString ()+"\n");
            iter = iter.getNext ();
        }
        res.append ("==> ");
        res.append (iter.getData ().toString ());
        return res.toString ();
    }
}
