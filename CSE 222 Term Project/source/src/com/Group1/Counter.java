package com.Group1;

/**
 * It provide unique ID for toDo
 */
public class Counter {
    private static int counter = 0;
    public static int getID(){
        counter++;
        return counter;
    }
}
