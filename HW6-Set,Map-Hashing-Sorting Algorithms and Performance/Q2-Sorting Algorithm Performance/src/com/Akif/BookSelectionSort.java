package com.Akif;

/** Implements the selection sort algorithm. */
@SuppressWarnings("unchecked")
public class BookSelectionSort {
    /** Sort the array using selection sort algorithm.
     pre table contains Comparable objects.
     post table is sorted.
     @param table The array to be sorted
     */
    public static void sort(Comparable[] table) {
        int n = table.length;
        for (int fill = 0; fill < n - 1; fill++) {
            // Invariant: table[0 . . . fill - 1] is sorted.
            int posMin = fill;
            for (int next = fill + 1; next < n; next++) {
                // Invariant: table[posMin] is the smallest item in
                // table[fill . . . next - 1].
                if (table[next].compareTo(table[posMin]) < 0) {
                    posMin = next;
                }
            }
            // assert: table[posMin] is the smallest item in
            // table[fill . . . n - 1].
            // Exchange table[fill] and table[posMin].
            Comparable temp = table[fill];
            table[fill] = table[posMin];
            table[posMin] = temp;
            // assert: table[fill] is the smallest item in
            // table[fill . . . n - 1].
        }
            // assert: table[0 . . . n - 1] is sorted.
    }
}
