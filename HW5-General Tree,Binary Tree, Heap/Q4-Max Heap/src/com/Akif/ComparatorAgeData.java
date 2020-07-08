package com.Akif;

import java.util.Comparator;

/***
 * A completed Comparator class which implements Comparator interface.
 * This is used for MaxHeap class.
 */
public class ComparatorAgeData implements Comparator<AgeData> {
    /***
     * Compares its two arguments for order. Returns a negative integer, zero, or a positive integer
     * as the first argument is less than, equal to, or greater than the second.
     * AgeData objects are compared according to the number of people at that age.
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to,
     * or greater than the second.
     */
    @Override
    public int compare (AgeData o1, AgeData o2) {
        if (o1.getTotal ()==o2.getTotal ())
            return 0;
        else if (o1.getTotal ()>o2.getTotal ())
            return 1;
        else
            return -1;
    }
}
