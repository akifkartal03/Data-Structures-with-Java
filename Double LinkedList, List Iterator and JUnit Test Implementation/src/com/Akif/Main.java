package com.Akif;

import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
	    DLinkedList<Integer> numbers = new DLinkedList<> ();
	    for (int i= 0;i<10;i++){
            numbers.add (i,i*2);
        }
	    numbers.remove (12);
        numbers.remove (0);
        numbers.remove (18);
        numbers.addFirst (5);
        numbers.addLast (20);
        System.out.println (numbers.toString ());
        System.out.println ("size: "+numbers.size ());
        System.out.println ("7th: "+numbers.get (7));
        System.out.println ("first: "+numbers.getFirst ());
        System.out.println ("last: "+numbers.getLast ());



    }
}
