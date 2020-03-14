package com.Akif;

/***
 * Node Class will be used in Linked List.
 * @param <E> Type of a node.
 */
public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> prev;

    public Node (E data) {
        this.data = data;
        next = null;
        prev = null;
    }
    public Node (E data, Node<E> next, Node<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public Node<E> getNext () {
        return next;
    }
    public void setNext (Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev () {
        return prev;
    }

    public void setPrev (Node<E> prev) {
        this.prev = prev;
    }

    public E getData () {
        return data;
    }

    public void setData (E data) {
        this.data = data;
    }
}
