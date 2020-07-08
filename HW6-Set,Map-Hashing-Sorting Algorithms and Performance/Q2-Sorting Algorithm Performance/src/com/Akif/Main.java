package com.Akif;

/**
 * Main class of the program.
 */
public class Main {
    /**
     * main method of the program
     * @param args Not used.
     */
    public static void main(String[] args) {
        try {
            Test test=new Test ();
            test.startTest ();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
