package com.Akif;

/** Implements the insertion sort algorithm. */
@SuppressWarnings("unchecked")
public class BookInsertionSort {
    /**
     * Sort the table using insertion sort algorithm.
     * @param table The array to be sorted
     * pre table contains Comparable objects.
     * post table is sorted.
     */
    public static <T extends Comparable<T>> void sort (T[] table) {
        for (int nextPos = 1; nextPos < table.length; nextPos++) {
            // Invariant: table[0 . . . nextPos - 1] is sorted.
            // Insert element at position nextPos
            // in the sorted subarray.
            insert (table, nextPos);
        } // End for.
    } // End sort.
    /** Insert the element at nextPos where it belongs
     * in the array.
      pre table[0 . . . nextPos - 1] is sorted.
      post table[0 . . . nextPos] is sorted.
     * @param table The array being sorted
     * @param nextPos The position of the element to insert
     */
    private static <T extends Comparable<T>> void insert(T[] table,
                                                         int nextPos) {
        T nextVal = table[nextPos];
        // Element to insert.
        while (nextPos > 0 && nextVal.compareTo(table
                [nextPos - 1]) < 0) {
            table[nextPos] = table[nextPos - 1];
            // Shift down.
            nextPos--;
            // Check next smaller element.
        }
        // Insert nextVal at nextPos.
        table[nextPos] = nextVal;
    }
}
