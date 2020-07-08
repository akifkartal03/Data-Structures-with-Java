package com.Akif;

/**
 * Main class is to test program.
 */
public class Main {
    /**
     * Main method of the program.
     * @param args Not used.
     */
    public static void main(String[] args) {
        //Create an empty heap
        MaxHeap heap = new MaxHeap();
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));
        heap.add(new AgeData(50));
        heap.add(new AgeData(5));
        heap.add(new AgeData(15));
        System.out.println ("\t\t***All Heap***");
        for (int i = 0 ; i<55;i++) System.out.print("-");
        System.out.println ();
        System.out.println (heap);
        for (int i = 0 ; i<55;i++) System.out.print("-");
        System.out.println ();
        System.out.println ("Find age 10 : "+ heap.find (new AgeData (10)));
        System.out.print ("Younger than age 10: ");
        System.out.println(heap.youngerThan(10));
        System.out.print ("Older than age 5: ");
        System.out.println(heap.olderThan(5));
        for (int i = 0 ; i<55;i++) System.out.print("-");
        System.out.println ();
        System.out.println ("\t***All Heap after remove element 10 from heap***");
        heap.remove (new AgeData (10));
        for (int i = 0 ; i<55;i++) System.out.print("-");
        System.out.println ();
        System.out.println (heap);
    }
}
