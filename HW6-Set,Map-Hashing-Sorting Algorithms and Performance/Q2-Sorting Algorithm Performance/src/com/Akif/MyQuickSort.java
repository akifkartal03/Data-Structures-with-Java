package com.Akif;

import java.util.LinkedList;

/** Implements the quick sort algorithm to sort a LinkedList. */
@SuppressWarnings("unchecked")
public class MyQuickSort {
    /**
     * Sort the list using the quick sort algorithm.
     * @param table The LinkedList to be sorted
      pre list contains Comparable objects.
      post list is sorted.
     */
    public static <T extends Comparable<T>> void sort (LinkedList<T> table) {
        // Sort the whole table.
        quickSort (table, 0, table.size () - 1);
    }
    /** Sort a part of the list using the quick sort algorithm.
     post The part of list from first through last is sorted.
     @param list The LinkedList to be sorted
     @param first The index of the low bound
     @param last The index of the high bound
     */
    private static <T extends Comparable<T>> void quickSort(LinkedList<T> list,
                                                            int first, int last) {
        if (first < last) { // There is data to be sorted.
            // Partition the table.
            int pivIndex = partition(list, first, last);
            // Sort the left half.
            quickSort(list, first, pivIndex - 1);
            // Sort the right half.
            quickSort(list, pivIndex + 1, last);
        }
    }
    /** Partition the list so that values from first to pivIndex
     are less than or equal to the pivot value, and values from
     pivIndex to last are greater than the pivot value.
     @param list The list to be partitioned
     @param first The index of the low bound
     @param last The index of the high bound
     @return The location of the pivot value
     */
    private static <T extends Comparable<T>> int partition(LinkedList<T> list,
                                                           int first, int last) {
        // Select the first item as the pivot value.
        T pivot = list.get (first);
        int up = first;
        int down = last;
        do {
            /* Invariant:
            All items in table[first . . . up - 1] <= pivot
            All items in table[down + 1 . . . last] > pivot
            */
            while ((up < last) && (pivot.compareTo(list.get (up)) >= 0)) {
                up++;
            }
            // assert: up equals last or table[up] > pivot.
            while (pivot.compareTo(list.get (down)) < 0) {
                down--;
            }
            // assert: down equals first or table[down] <= pivot.
            if (up < down) { // if up is to the left of down.
                // Exchange table[up] and table[down].
                swap(list, up, down);
            }
        } while (up < down); // Repeat while up is left of down.
        // Exchange table[first] and table[down] thus putting the
        // pivot value where it belongs.
        swap(list, first, down);
        // Return the index of the pivot value.
        return down;
    }
    /** Swap the items in list ith index and list jth index.
     * @param list The LinkedList that contains the items
     * @param i The index of one item
     * @param j The index of the other item
     */
    private static <T extends Comparable<T>> void swap(LinkedList<T> list, int i, int j){
        T temp = list.get (i);
        list.set (i,list.get (j));
        list.set (j,temp);
    }
}
