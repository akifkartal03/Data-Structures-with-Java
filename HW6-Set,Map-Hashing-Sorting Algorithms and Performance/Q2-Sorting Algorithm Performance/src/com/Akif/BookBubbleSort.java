package com.Akif;
/** Implementation of the heapsort algorithm. */
@SuppressWarnings("unchecked")
public class BookBubbleSort {
    /**
     * Sort the array using bubble sort algorithm.
     * @param table The array to be sorted
     pre table contains Comparable items.
     post table is sorted.
     */
    public static <T extends Comparable<T>> void sort(T[] table) {
        int pass = 1;
        boolean exchanges = false;
        do {
            // Invariant: Elements after table.length - pass + 1
            // are in place.
            exchanges = false; // No exchanges yet.
            // Compare each pair of adjacent elements.
            for (int i = 0; i < table.length - pass; i++) {
                if (table[i].compareTo(table[i + 1]) > 0) {
                    // Exchange pair.
                    T temp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = temp;
                    exchanges = true; // Set flag.
                }
            }
            pass++;
        } while (exchanges);
        // assert: Array is sorted.
    }
}
