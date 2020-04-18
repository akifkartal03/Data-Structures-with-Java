package com.Akif;

import java.util.Iterator;

/***
 * Main class to test each method in MyDeque Class.
 * @see MyDeque
 * @see DoubleLinkedList
 */
public class Main {
    /***
     * Main method of the program.
     * @param args Not used.
     */
    public static void main(String[] args) {
        //everything is clear here without extra comments.
        //to see more clear each test, I separated them with '------------'
	    MyDeque<Integer> myDeque = new MyDeque<> ();
        System.out.println ("\t\t***TEST WITH INTEGER VALUES***");
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nAdd 6(0 to 5) piece element with 'addFirst' method to an empty list.");
        for (int i = 0 ; i<6;i++){
            myDeque.addFirst (i);
        }
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nAdd 6(5 to 10) piece element with 'add' method");
        for (int i = 5 ; i<11;i++){
            myDeque.add (i);
        }
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nAdd 5(10 to 15) piece element with 'addLast' method");
        for (int i = 11 ; i<16;i++){
            myDeque.addLast (i);
        }
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nRemove element with 'remove()' method");
        myDeque.remove ();
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nRemove element with 'removeLast' method");
        myDeque.removeLast ();
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nRemove '11' with 'remove(11)' method");
        myDeque.remove (11);
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nAdd '5' with 'offer()' method");
        myDeque.offer (5);
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nAdd '15' with 'offerLast()' method");
        myDeque.offerLast (15);
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nAdd '3' with 'offerFirst()' method");
        myDeque.offerFirst (3);
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nRemove '5' with 'removeLastOccurrence()' method");
        myDeque.removeLastOccurrence (5);
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nRemove '3' with 'removeFirstOccurrence()' method");
        myDeque.removeFirstOccurrence (3);
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nRemove element with 'poll()' method");
        myDeque.poll ();
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nRemove element with 'pollFirst()' method");
        myDeque.pollFirst ();
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nRemove element with 'pollLast()' method");
        myDeque.pollLast ();
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nAdd '8' with 'push()' method");
        myDeque.push (8);
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nRemove element with 'pop()' method");
        myDeque.pop ();
        System.out.println (myDeque);
        System.out.println ("Size: "+myDeque.size ());
        System.out.println ("Removed Size: "+myDeque.removedSize ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nGet methods test results");
        System.out.println (myDeque);
        System.out.println ("getFirst(): "+myDeque.getFirst ());
        System.out.println ("getLast(): "+myDeque.getLast ());
        System.out.println ("peek(): "+myDeque.peek ());
        System.out.println ("peekFirst(): "+myDeque.peekFirst ());
        System.out.println ("peekLast(): "+myDeque.peekLast ());
        System.out.println ("element(): "+myDeque.element ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nOther test results");
        System.out.println (myDeque);
        System.out.println ("contains(111): "+myDeque.contains (111));
        System.out.println ("isEmpty(): "+myDeque.isEmpty ());
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //-----------------------------------------------------------
        System.out.println ("\nPrint all list with iterator");
        Iterator<Integer> iterator = myDeque.iterator ();
        while (iterator.hasNext ()){
            System.out.print (iterator.next ()+" ");
        }
        System.out.println ();
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //-----------------------------------------------------------
        System.out.println ("\nPrint all list with descending iterator");
        iterator = myDeque.descendingIterator ();
        while (iterator.hasNext ()){
            System.out.print (iterator.next ()+" ");
        }
        System.out.println ();
        for (int i = 0 ; i<100;i++) System.out.print("-");

    }
}
