package com.Akif;

/** Implementation of the heapsort algorithm. */
@SuppressWarnings("unchecked")
public class BookHeapSort {
    /**
     * Sort the array using heapsort algorithm.
     * @param table The array to be sorted
     pre table contains Comparable items.
     post table is sorted.
     */
    public static <T extends Comparable<T>> void sort (T[] table) {
        buildHeap (table);
        shrinkHeap (table);
    }
    /**
     * buildHeap transforms the table into a heap.
     * @param table The array to be transformed into a heap
      pre The array contains at least one item.
     post All items in the array are in heap order.
     */
    private static <T extends Comparable<T>> void buildHeap (T[] table) {
        int n = 1;
        // Invariant: table[0 . . . n - 1] is a heap.
        while (n < table.length) {
            n++; // Add a new item to the heap and reheap.
            int child = n -1;
            int parent = (child -1) /2; // Find parent.
            while (parent >= 0
                    && table[parent].compareTo (table[child]) < 0) {
                swap (table, parent, child);
                child = parent;
                parent = (child -1) /2;
            }
        }
    }
    /** shrinkHeap transforms a heap into a sorted array.
     pre All items in the array are in heap order.
     post The array is sorted.
     @param table The array to be sorted
     */
    private static <T extends Comparable<T>> void shrinkHeap(T[] table) {
        int n = table.length;
        // Invariant: table[0 . . . n - 1] forms a heap.
        // table[n . . . table.length - 1] is sorted.
        while (n > 0) {
            n--;
            swap(table, 0, n);
            // table[1 . . . n - 1] form a heap.
            // table[n . . . table.length - 1] is sorted.
            int parent = 0;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= n) {
                    break; // No more children.
                }
                int rightChild = leftChild + 1;
                // Find the larger of the two children.
                int maxChild = leftChild;
                if (rightChild < n // There is a right child.
                        && table[leftChild].compareTo(table[rightChild]) < 0) {maxChild = rightChild;
                }
                // If the parent is smaller than the larger child,
                if (table[parent].compareTo(table[maxChild]) < 0) {
                    // Swap the parent and child.
                    swap(table, parent, maxChild);
                    // Continue at the child level.
                    parent = maxChild;
                } else { // Heap property is restored.
                    break; // Exit the loop.
                }
            }
        }
    }
    /** Swap the items in table[i] and table[j].
     * @param table The array that contains the items
     * @param i The index of one item
     * @param j The index of the other item
     */
    private static <T extends Comparable<T>> void swap(T[] table,
                                                       int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }

}