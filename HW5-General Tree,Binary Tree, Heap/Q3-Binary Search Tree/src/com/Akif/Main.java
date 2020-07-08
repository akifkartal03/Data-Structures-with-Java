package com.Akif;

/**
 * Main class is to test the program.
 */
public class Main {
    /**
     * main method of the program.
     * @param args Not used.
     */
    public static void main(String[] args) {
        AgeSearchTree ageTree = new AgeSearchTree();
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(10));
        ageTree.remove (new AgeData(15));
        ageTree.remove (new AgeData(10));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(10));
        System.out.println ("\t\t***All Tree***");
        for (int i = 0 ; i<100;i++) System.out.print("-");
        System.out.println ();
        System.out.println (ageTree);
        for (int i = 0 ; i<100;i++) System.out.print("-");
        System.out.println ();
        System.out.println ("Find age 10 : "+ ageTree.find (new AgeData (10)));
        System.out.print ("Younger than age 15: ");
        System.out.println(ageTree.youngerThan(15));
        System.out.print ("Older than age 15: ");
        System.out.println(ageTree.olderThan(15));
        for (int i = 0 ; i<100;i++) System.out.print("-");
        System.out.println ();
    }
}
