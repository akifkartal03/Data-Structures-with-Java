package com.Akif;

/**
 * Main class is to test program.
 */
public class Main {
    /**
     * main method of the program.
     * @param args Not used.
     */
    public static void main(String[] args) {
	    SkipArrayList<Integer> skipList = new SkipArrayList<> (5);
        skipList.printListInfo ();
	    skipList.add (20);
        skipList.add (30);
        skipList.add (8);
        skipList.add (47);
        skipList.add (18);
        System.out.println ();
        System.out.println (skipList);
        skipList.add (39);
        skipList.add (40);
        skipList.add (98);
        System.out.println ();
        System.out.println (skipList);
        skipList.remove (30);
        skipList.remove (18);
        System.out.println ();
        System.out.println (skipList);
        skipList.add (45);
        skipList.add (5);
        skipList.add (10);
        System.out.println ();
        System.out.println (skipList);

    }
}
