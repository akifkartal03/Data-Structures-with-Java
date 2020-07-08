package com.Akif;

import java.util.LinkedList;

/** Implements the recursive merge sort algorithm to sort a LinkedList. In this version, copies
 of the sub-list of LinkedList are made, sorted, and then merged.
 */
 @SuppressWarnings("unchecked")
public class MyMergeSort {
    /** Sort the LinkedList using the merge sort algorithm.
     pre: list contains Comparable objects.
     post: list is sorted.
     @param list The LinkedList to be sorted
     */
    public static <T extends Comparable<T>> void sort(LinkedList<T> list) {
        // A table with one element is sorted already.
        if (list.size () > 1) {
            // Split table into halves.
            int halfSize = list.size () / 2;
            LinkedList<T> leftTable = new LinkedList<> ();
            LinkedList<T> rightTable = new LinkedList<> ();
            listCopy (list,0,leftTable,halfSize);
            listCopy (list,halfSize,rightTable,list.size ());
            // Sort the halves.
            sort(leftTable);
            sort(rightTable);
            // Merge the halves.
            merge(list, leftTable, rightTable);
        }
    }
    /** Merge two sequences.
     pre leftSequence and rightSequence are sorted.
     post outputSequence is the merged result and is sorted.
     @param outputSequence The destination
     @param leftSequence The left input
     @param rightSequence The right input
     */
    private static <T extends Comparable<T>> void merge(LinkedList<T> outputSequence,
                                                        LinkedList<T> leftSequence,
                                                        LinkedList<T> rightSequence) {
        int i = 0;
        // Index into the left input sequence.
        int j = 0;
        // Index into the right input sequence.
        int k = 0;
        // Index into the output sequence.
        // While there is data in both input sequences
        while (i < leftSequence.size () && j < rightSequence.size ()) {
            // Find the smaller and
            // insert it into the output sequence.
            if (leftSequence.get (i).compareTo(rightSequence.get (j)) < 0) {
                outputSequence.set (k++,leftSequence.get (i++));
            } else {
                outputSequence.set (k++,rightSequence.get (j++));
            }
        }
        // assert: one of the sequences has more items to copy.
        // Copy remaining input from left sequence into the output.
        while (i < leftSequence.size ()) {
            outputSequence.set (k++,leftSequence.get (i++));
        }
        // Copy remaining input from right sequence into output.
        while (j < rightSequence.size ()) {
            outputSequence.set (k++,rightSequence.get (j++));
        }
    }
    /**
     * This method copies a LinkedList from the specified source LinkedList,
     * beginning at the specified position(srcPos), to the destination LinkedList.
     * @param src source LinkedList
     * @param srcPos specified position to start copy
     * @param dest destination LinkedList
     * @param length size of copied element
     */
    private static <T extends Comparable<T>> void listCopy(LinkedList<T> src, int srcPos, LinkedList<T> dest,int length){
        for (int i = srcPos; i <length ; i++) {
            dest.add (src.get (i));
        }
    }
}
