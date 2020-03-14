package com.Akif;
import java.util.ListIterator;
import java.util.NoSuchElementException;
public class DLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public void add(int index,E obj){
        ListIter iter = new ListIter (index);
        iter.add (obj);
    }
    public void addFirst(E obj){
        ListIter iter = new ListIter (0);
        iter.add (obj);
    }
    public void addLast(E obj){
        ListIter iter = new ListIter (size);
        iter.add (obj);
    }
    public E getFirst(){
        if (head == null)
            throw new NoSuchElementException ();
        return head.data;

    }
    public E get(int index){
        ListIter iter = new ListIter (index);
        return iter.nextItem.data;
    }
    public E getLast(){
        return tail.data;
    }
    public boolean remove(E obj){
        ListIter iter = new ListIter (0);
        while (iter.hasNext ()){
            if (iter.nextItem.data == obj){
                iter.remove ();
                return true;
            }
            iter.next();
        }
        return false;
    }
    public int size(){
        return size;
    }
    private static class Node<E>{
        private E data;
        private Node<E> next = null;
        private Node<E> prev = null;
        public Node(E item){
            data = item;
            next=null;
            prev = null;
        }
        public Node(E item,Node<E> n ,Node<E> p){
            data = item;
            next = n;
            prev =p;
        }
    }
    private class ListIter implements ListIterator<E> {
        private Node<E> nextItem;
        private Node<E> lastItem;
        private int index;
        public ListIter(int i){
            if (i<0 || i>size)
                throw new IndexOutOfBoundsException("Invalid Index"+i);
            lastItem = null;
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
        public void add(E obj){
            if (head == null){
                head =new Node<> (obj);
                tail = head;
            }
            else if (nextItem == head){
                Node<E> newNode= new Node<E> (obj);
                newNode.next = nextItem;
                nextItem.prev=newNode;
                head = newNode;
            }
            else if (nextItem == null){
                Node<E> newNode = new Node<E>(obj);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;

            }
            else{
                Node<E> newNode = new Node<> (obj);
                newNode.prev = nextItem.prev;
                nextItem.prev.next = newNode;
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            size++;
            index++;
            lastItem = null;
        }
        public boolean hasNext(){
            return nextItem!= null;
        }
        public boolean hasPrevious(){
            return  (nextItem == null && size!=0) || nextItem.prev !=null;
        }
        public E next(){
            if (!hasNext ()){
                throw new NoSuchElementException ();
            }
            lastItem = nextItem;
            nextItem =nextItem.next;
            index++;
            return lastItem.data;
        }
        public int nextIndex(){
            return index+1;
        }
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
        public int previousIndex(){
            return index-1;
        }
        public void remove(){
            if (head == null){
                throw new NoSuchElementException ();
            }
            else if (head != null && head.next == null){
                nextItem = null;
                head = null;
                tail = null;
                size--;
                index--;
            }
            else if (nextItem.next == null){
                nextItem.prev.next = null;
                tail = nextItem.prev;
                size--;
                index--;
            }
            else if (nextItem.prev == null && nextItem.next !=null){
                nextItem.next.prev =null;
                head = nextItem.next;
                size--;
                index--;
            }
            else{
                nextItem.prev.next = nextItem.next;
                nextItem.next.prev = nextItem.prev;
                size--;
                index--;
            }
            lastItem = null;
        }

        public void set(E e){

        }
    }
    public String toString(){
        ListIter iter =new ListIter (0);
        StringBuilder result = new StringBuilder ();
        while (iter.hasNext ()){
            result.append (iter.next ());
            if (iter.nextItem!=null)
                result.append ("==>");
        }
        return result.toString ();
    }
    public ListIter listIterator(){
        return new ListIter (0);
    }
}
