package com.Akif;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

/**
 * This class is to test running time of sorting algorithm by using
 * 105 different array and list and then get average of this times.
 */
@SuppressWarnings("unchecked")
public class Test {
    /**
     * to generate random numbers
     */
    private Random random = new Random();
    /**
     * start time of sorting
     */
    private long startTime;
    /**
     * end time of sorting
     */
    private long endTime;
    /**
     * write each test result a proper file to calculate average of them.
     */
    private FileWriter bubble,insertion,selection,quick,shell,merge,heap,my_merge,my_quick;
    /**
     * An Integer array to test them.
     */
    private Integer[] array;
    /**
     * Copy of the Integer array to test an algorithm with same array after another sorting.
     */
    private Integer[] arrayCopy;
    /**
     * An Integer LinkedList to test my sorting algorithms.
     */
    private LinkedList<Integer> linkedList1;
    /**
     * Copy of the Integer LinkedList to test an algorithm with same LinkedList after another sorting.
     */
    private LinkedList<Integer> linkedList1Copy;

    /**
     * Start to test algorithms.
     */
    public void startTest() {
        try {
            //open files
            bubble = new FileWriter("bubble.txt");
            insertion = new FileWriter("insertion.txt");
            selection = new FileWriter("selection.txt");
            quick = new FileWriter("quick.txt");
            shell = new FileWriter("shell.txt");
            merge = new FileWriter("merge.txt");
            heap = new FileWriter("heap.txt");
            my_merge = new FileWriter("my_merge.txt");
            my_quick = new FileWriter("my_quick.txt");
            //call test methods
            test10000 ();
            test40000 ();
            test100000 ();
            test150000 ();
            test180000 ();
            //close files
            bubble.close();insertion.close();selection.close();quick.close();
            shell.close();merge.close();heap.close();my_merge.close();my_quick.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Test each algorithm with arrays/linked lists with a length of ten thousand (10000).
     */
    private void test10000(){
        try {
            System.out.println ("\t***ARRAY/LIST SIZE = 10000***");
            for (int i = 0 ; i<60;i++) System.out.print("-");
            //write file to distinguish the times among algorithms.
            bubble.write ("***ARRAY/LIST SIZE = 10000***\n\n");
            insertion.write ("***ARRAY/LIST SIZE = 10000***\n\n");
            selection.write ("***ARRAY/LIST SIZE = 10000***\n\n");
            quick.write ("***ARRAY/LIST SIZE = 10000***\n\n");
            shell.write ("***ARRAY/LIST SIZE = 10000***\n\n");
            merge.write ("***ARRAY/LIST SIZE = 10000***\n\n");
            heap.write ("***ARRAY/LIST SIZE = 10000***\n\n");
            my_merge.write ("***ARRAY/LIST SIZE = 10000***\n\n");
            my_quick.write ("***ARRAY/LIST SIZE = 10000***\n\n");
            //sort 20 random and 1 sorted array each sorting algorithm and calculate the times.
            for (int j = 0; j < 21; j++) {
                if (j+1==21)
                    getSortedArrayAndList (10000);//fill array,arrayCopy, list and listCopy as sorted.
                else
                    getRandomArrayAndList (10000);//fill array ,arrayCopy, list and listCopy as random.
                //execute each algorithm and save the times to the their own file and also print.
                //---------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Selection Sort***");
                startTime = System.currentTimeMillis();
                BookSelectionSort.sort (array);
                endTime = System.currentTimeMillis();
                selection.write ((endTime - startTime) +"\n");
                System.out.println(" Book Selection sort time is " + (endTime - startTime) + " ms");
                System.out.println(" Book Selection sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);//return same array old form(not sorted)
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Bubble Sort***");
                startTime = System.currentTimeMillis ();
                BookBubbleSort.sort (array);
                endTime = System.currentTimeMillis();
                bubble.write ((endTime - startTime) +"\n");
                System.out.println(" Book Bubble sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Bubble sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Insertion Sort***");
                startTime = System.currentTimeMillis();
                BookInsertionSort.sort (array);
                endTime = System.currentTimeMillis();
                insertion.write ((endTime - startTime) +"\n");
                System.out.println(" Book Insertion sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Insertion sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Shell Sort***");
                startTime = System.currentTimeMillis();
                BookShellSort.sort (array);
                endTime = System.currentTimeMillis();
                shell.write ((endTime - startTime) +"\n");
                System.out.println(" Book Shell sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Shell sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Merge Sort***");
                startTime = System.currentTimeMillis();
                BookMergeSort.sort (array);
                endTime = System.currentTimeMillis();
                merge.write ((endTime - startTime) +"\n");
                System.out.println(" Book Merge sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Merge sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Heap Sort***");
                startTime = System.currentTimeMillis();
                BookHeapSort.sort (array);
                endTime = System.currentTimeMillis();
                heap.write ((endTime - startTime) +"\n");
                System.out.println(" Book Heap sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Heap sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Quick Sort***");
                startTime = System.currentTimeMillis();
                BookQuickSort.sort (array);
                endTime = System.currentTimeMillis();
                quick.write ((endTime - startTime) +"\n");
                System.out.println(" Book Quick sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Quick sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My Merge Sort***");
                startTime = System.currentTimeMillis();
                MyMergeSort.sort (linkedList1);
                endTime = System.currentTimeMillis();
                my_merge.write ((endTime - startTime) +"\n");
                System.out.println(" My Merge sort time is " + (endTime-startTime) + "ms");
                System.out.println(" My Merge sort is successful (true/false): "+ verifyList (linkedList1));
                reloadList (linkedList1,linkedList1Copy);//return list old form
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My Quick Sort***");
                startTime = System.currentTimeMillis();
                MyQuickSort.sort (linkedList1);
                endTime = System.currentTimeMillis();
                my_quick.write ((endTime - startTime) +"\n");
                System.out.println(" My Quick sort time is " + (endTime-startTime) + "ms");
                System.out.println(" My Quick sort is successful (true/false): "+ verifyList (linkedList1));
                reloadList (linkedList1,linkedList1Copy);
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ();

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    /**
     * Test each algorithm with arrays/linked lists with a length of forty thousand (40000).
     */
    private void test40000(){
        try {
            System.out.println ("\t***ARRAY/LIST SIZE = 40000***");
            for (int i = 0 ; i<60;i++) System.out.print("-");
            bubble.write ("***ARRAY/LIST SIZE = 40000***\n\n");
            insertion.write ("***ARRAY/LIST SIZE = 40000***\n\n");
            selection.write ("***ARRAY/LIST SIZE = 40000***\n\n");
            quick.write ("***ARRAY/LIST SIZE = 40000***\n\n");
            shell.write ("***ARRAY/LIST SIZE = 40000***\n\n");
            merge.write ("***ARRAY/LIST SIZE = 40000***\n\n");
            heap.write ("***ARRAY/LIST SIZE = 40000***\n\n");
            my_merge.write ("***ARRAY/LIST SIZE = 40000***\n\n");
            my_quick.write ("***ARRAY/LIST SIZE = 40000***\n\n");
            for (int j = 0; j < 21; j++) {
                if (j + 1 == 21)
                    getSortedArrayAndList (40000);
                else
                    getRandomArrayAndList (40000);
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Selection Sort***");
                startTime = System.currentTimeMillis ();
                BookSelectionSort.sort (array);
                endTime = System.currentTimeMillis ();
                selection.write ((endTime - startTime) + "\n");
                System.out.println (" Book Selection sort time is " + (endTime - startTime) + " ms");
                System.out.println (" Book Selection sort is successful (true/false): " + verifyArray (array));
                reloadArray (array, arrayCopy);//return array old form
                //------------------------------------------------------------------------
                for (int i = 0; i < 60; i++) System.out.print ("-");
                System.out.println ("\n\t***Bubble Sort***");
                startTime = System.currentTimeMillis ();
                BookBubbleSort.sort (array);
                endTime = System.currentTimeMillis ();
                bubble.write ((endTime - startTime) + "\n");
                System.out.println (" Book Bubble sort time is " + (endTime - startTime) + " ms");
                System.out.println (" Book Bubble sort is successful (true/false): " + verifyArray (array));
                reloadArray (array, arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0; i < 60; i++) System.out.print ("-");
                System.out.println ("\n\t***Insertion Sort***");
                startTime = System.currentTimeMillis ();
                BookInsertionSort.sort (array);
                endTime = System.currentTimeMillis ();
                insertion.write ((endTime - startTime) + "\n");
                System.out.println (" Book Insertion sort time is " + (endTime - startTime) + " ms");
                System.out.println (" Book Insertion sort is successful (true/false): " + verifyArray (array));
                reloadArray (array, arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0; i < 60; i++) System.out.print ("-");
                System.out.println ("\n\t***Shell Sort***");
                startTime = System.currentTimeMillis ();
                BookShellSort.sort (array);
                endTime = System.currentTimeMillis ();
                shell.write ((endTime - startTime) + "\n");
                System.out.println (" Book Shell sort time is " + (endTime - startTime) + " ms");
                System.out.println (" Book Shell sort is successful (true/false): " + verifyArray (array));
                reloadArray (array, arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0; i < 60; i++) System.out.print ("-");
                System.out.println ("\n\t***Merge Sort***");
                startTime = System.currentTimeMillis ();
                BookMergeSort.sort (array);
                endTime = System.currentTimeMillis ();
                merge.write ((endTime - startTime) + "\n");
                System.out.println (" Book Merge sort time is " + (endTime - startTime) + " ms");
                System.out.println (" Book Merge sort is successful (true/false): " + verifyArray (array));
                reloadArray (array, arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0; i < 60; i++) System.out.print ("-");
                System.out.println ("\n\t***Heap Sort***");
                startTime = System.currentTimeMillis ();
                BookHeapSort.sort (array);
                endTime = System.currentTimeMillis ();
                heap.write ((endTime - startTime) + "\n");
                System.out.println (" Book Heap sort time is " + (endTime - startTime) + " ms");
                System.out.println (" Book Heap sort is successful (true/false): " + verifyArray (array));
                reloadArray (array, arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0; i < 60; i++) System.out.print ("-");
                System.out.println ("\n\t***Quick Sort***");
                startTime = System.currentTimeMillis ();
                BookQuickSort.sort (array);
                endTime = System.currentTimeMillis ();
                quick.write ((endTime - startTime) + "\n");
                System.out.println (" Book Quick sort time is " + (endTime - startTime) + " ms");
                System.out.println (" Book Quick sort is successful (true/false): " + verifyArray (array));
                reloadArray (array, arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0; i < 60; i++) System.out.print ("-");
                System.out.println ("\n\t***My Merge Sort***");
                startTime = System.currentTimeMillis ();
                MyMergeSort.sort (linkedList1);
                endTime = System.currentTimeMillis ();
                my_merge.write ((endTime - startTime) + "\n");
                System.out.println (" My Merge sort time is " + (endTime - startTime) + "ms");
                System.out.println (" My Merge sort is successful (true/false): " + verifyList (linkedList1));
                reloadList (linkedList1, linkedList1Copy);//return list old form
                //------------------------------------------------------------------------
                for (int i = 0; i < 60; i++) System.out.print ("-");
                System.out.println ("\n\t***My Quick Sort***");
                startTime = System.currentTimeMillis ();
                MyQuickSort.sort (linkedList1);
                endTime = System.currentTimeMillis ();
                my_quick.write ((endTime - startTime) + "\n");
                System.out.println (" My Quick sort time is " + (endTime - startTime) + "ms");
                System.out.println (" My Quick sort is successful (true/false): " + verifyList (linkedList1));
                reloadList (linkedList1, linkedList1Copy);
                for (int i = 0; i < 60; i++) System.out.print ("-");
                System.out.println ();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    /**
     * Test each algorithm with arrays/linked lists with a length of one hundred thousand (100000).
     */
    private void test100000(){
        try {
            System.out.println ("\t***ARRAY/LIST SIZE = 100000***");
            for (int i = 0 ; i<60;i++) System.out.print("-");
            bubble.write ("***ARRAY/LIST SIZE = 100000***\n\n");
            insertion.write ("***ARRAY/LIST SIZE = 100000***\n\n");
            selection.write ("***ARRAY/LIST SIZE = 100000***\n\n");
            quick.write ("***ARRAY/LIST SIZE = 100000***\n\n");
            shell.write ("***ARRAY/LIST SIZE = 100000***\n\n");
            merge.write ("***ARRAY/LIST SIZE = 100000***\n\n");
            heap.write ("***ARRAY/LIST SIZE = 100000***\n\n");
            my_merge.write ("***ARRAY/LIST SIZE = 100000***\n\n");
            my_quick.write ("***ARRAY/LIST SIZE = 100000***\n\n");
            for (int j = 0; j < 21; j++) {
                if (j+1==21)
                    getSortedArrayAndList (100000);
                else
                    getRandomArrayAndList (100000);
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Selection Sort***");
                startTime = System.currentTimeMillis();
                BookSelectionSort.sort (array);
                endTime = System.currentTimeMillis();
                selection.write ((endTime - startTime) +"\n");
                System.out.println(" Book Selection sort time is " + (endTime - startTime) + " ms");
                System.out.println(" Book Selection sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);//return array old form
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Bubble Sort***");
                startTime = System.currentTimeMillis ();
                BookBubbleSort.sort (array);
                endTime = System.currentTimeMillis();
                bubble.write ((endTime - startTime) +"\n");
                System.out.println(" Book Bubble sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Bubble sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Insertion Sort***");
                startTime = System.currentTimeMillis();
                BookInsertionSort.sort (array);
                endTime = System.currentTimeMillis();
                insertion.write ((endTime - startTime) +"\n");
                System.out.println(" Book Insertion sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Insertion sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Shell Sort***");
                startTime = System.currentTimeMillis();
                BookShellSort.sort (array);
                endTime = System.currentTimeMillis();
                shell.write ((endTime - startTime) +"\n");
                System.out.println(" Book Shell sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Shell sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Merge Sort***");
                startTime = System.currentTimeMillis();
                BookMergeSort.sort (array);
                endTime = System.currentTimeMillis();
                merge.write ((endTime - startTime) +"\n");
                System.out.println(" Book Merge sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Merge sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Heap Sort***");
                startTime = System.currentTimeMillis();
                BookHeapSort.sort (array);
                endTime = System.currentTimeMillis();
                heap.write ((endTime - startTime) +"\n");
                System.out.println(" Book Heap sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Heap sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Quick Sort***");
                startTime = System.currentTimeMillis();
                BookQuickSort.sort (array);
                endTime = System.currentTimeMillis();
                quick.write ((endTime - startTime) +"\n");
                System.out.println(" Book Quick sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Quick sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My Merge Sort***");
                startTime = System.currentTimeMillis();
                MyMergeSort.sort (linkedList1);
                endTime = System.currentTimeMillis();
                my_merge.write ((endTime - startTime) +"\n");
                System.out.println(" My Merge sort time is " + (endTime-startTime) + "ms");
                System.out.println(" My Merge sort is successful (true/false): "+ verifyList (linkedList1));
                reloadList (linkedList1,linkedList1Copy);//return list old form
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My Quick Sort***");
                startTime = System.currentTimeMillis();
                MyQuickSort.sort (linkedList1);
                endTime = System.currentTimeMillis();
                my_quick.write ((endTime - startTime) +"\n");
                System.out.println(" My Quick sort time is " + (endTime-startTime) + "ms");
                System.out.println(" My Quick sort is successful (true/false): "+ verifyList (linkedList1));
                reloadList (linkedList1,linkedList1Copy);
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ();

            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    /**
     * Test each algorithm with arrays/linked lists with a length of one hundred and fifty thousand (150000) .
     */
    private void test150000(){
        try {
            System.out.println ("\t***ARRAY/LIST SIZE = 150000***");
            for (int i = 0 ; i<60;i++) System.out.print("-");
            bubble.write ("***ARRAY/LIST SIZE = 150000***\n\n");
            insertion.write ("***ARRAY/LIST SIZE = 150000***\n\n");
            selection.write ("***ARRAY/LIST SIZE = 150000***\n\n");
            quick.write ("***ARRAY/LIST SIZE = 150000***\n\n");
            shell.write ("***ARRAY/LIST SIZE = 150000***\n\n");
            merge.write ("***ARRAY/LIST SIZE = 150000***\n\n");
            heap.write ("***ARRAY/LIST SIZE = 150000***\n\n");
            my_merge.write ("***ARRAY/LIST SIZE = 150000***\n\n");
            my_quick.write ("***ARRAY/LIST SIZE = 150000***\n\n");
            for (int j = 0; j < 21; j++) {
                if (j+1==21)
                    getSortedArrayAndList (150000);
                else
                    getRandomArrayAndList (150000);
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Selection Sort***");
                startTime = System.currentTimeMillis();
                BookSelectionSort.sort (array);
                endTime = System.currentTimeMillis();
                selection.write ((endTime - startTime) +"\n");
                System.out.println(" Book Selection sort time is " + (endTime - startTime) + " ms");
                System.out.println(" Book Selection sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);//return array old form
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Bubble Sort***");
                startTime = System.currentTimeMillis ();
                BookBubbleSort.sort (array);
                endTime = System.currentTimeMillis();
                bubble.write ((endTime - startTime) +"\n");
                System.out.println(" Book Bubble sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Bubble sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Insertion Sort***");
                startTime = System.currentTimeMillis();
                BookInsertionSort.sort (array);
                endTime = System.currentTimeMillis();
                insertion.write ((endTime - startTime) +"\n");
                System.out.println(" Book Insertion sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Insertion sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Shell Sort***");
                startTime = System.currentTimeMillis();
                BookShellSort.sort (array);
                endTime = System.currentTimeMillis();
                shell.write ((endTime - startTime) +"\n");
                System.out.println(" Book Shell sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Shell sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Merge Sort***");
                startTime = System.currentTimeMillis();
                BookMergeSort.sort (array);
                endTime = System.currentTimeMillis();
                merge.write ((endTime - startTime) +"\n");
                System.out.println(" Book Merge sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Merge sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Heap Sort***");
                startTime = System.currentTimeMillis();
                BookHeapSort.sort (array);
                endTime = System.currentTimeMillis();
                heap.write ((endTime - startTime) +"\n");
                System.out.println(" Book Heap sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Heap sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Quick Sort***");
                startTime = System.currentTimeMillis();
                BookQuickSort.sort (array);
                endTime = System.currentTimeMillis();
                quick.write ((endTime - startTime) +"\n");
                System.out.println(" Book Quick sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Quick sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My Merge Sort***");
                startTime = System.currentTimeMillis();
                MyMergeSort.sort (linkedList1);
                endTime = System.currentTimeMillis();
                my_merge.write ((endTime - startTime) +"\n");
                System.out.println(" My Merge sort time is " + (endTime-startTime) + "ms");
                System.out.println(" My Merge sort is successful (true/false): "+ verifyList (linkedList1));
                reloadList (linkedList1,linkedList1Copy);//return list old form
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My Quick Sort***");
                startTime = System.currentTimeMillis();
                MyQuickSort.sort (linkedList1);
                endTime = System.currentTimeMillis();
                my_quick.write ((endTime - startTime) +"\n");
                System.out.println(" My Quick sort time is " + (endTime-startTime) + "ms");
                System.out.println(" My Quick sort is successful (true/false): "+ verifyList (linkedList1));
                reloadList (linkedList1,linkedList1Copy);
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ();

            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
    /**
     * Test each algorithm with arrays/linked lists with a length of one hundred and eighty thousand (180000).
     */
    private void test180000(){
        try {
            System.out.println ("\t***ARRAY/LIST SIZE = 180000***");
            for (int i = 0 ; i<60;i++) System.out.print("-");
            bubble.write ("***ARRAY/LIST SIZE = 180000***\n\n");
            insertion.write ("***ARRAY/LIST SIZE = 180000***\n\n");
            selection.write ("***ARRAY/LIST SIZE = 180000***\n\n");
            quick.write ("***ARRAY/LIST SIZE = 180000***\n\n");
            shell.write ("***ARRAY/LIST SIZE = 180000***\n\n");
            merge.write ("***ARRAY/LIST SIZE = 180000***\n\n");
            heap.write ("***ARRAY/LIST SIZE = 180000***\n\n");
            my_merge.write ("***ARRAY/LIST SIZE = 180000***\n\n");
            my_quick.write ("***ARRAY/LIST SIZE = 180000***\n\n");
            for (int j = 0; j < 21; j++) {
                if (j+1==21)
                    getSortedArrayAndList (180000);
                else
                    getRandomArrayAndList (180000);
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Selection Sort***");
                startTime = System.currentTimeMillis();
                BookSelectionSort.sort (array);
                endTime = System.currentTimeMillis();
                selection.write ((endTime - startTime) +"\n");
                System.out.println(" Book Selection sort time is " + (endTime - startTime) + " ms");
                System.out.println(" Book Selection sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);//return array old form
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Bubble Sort***");
                startTime = System.currentTimeMillis ();
                BookBubbleSort.sort (array);
                endTime = System.currentTimeMillis();
                bubble.write ((endTime - startTime) +"\n");
                System.out.println(" Book Bubble sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Bubble sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Insertion Sort***");
                startTime = System.currentTimeMillis();
                BookInsertionSort.sort (array);
                endTime = System.currentTimeMillis();
                insertion.write ((endTime - startTime) +"\n");
                System.out.println(" Book Insertion sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Insertion sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Shell Sort***");
                startTime = System.currentTimeMillis();
                BookShellSort.sort (array);
                endTime = System.currentTimeMillis();
                shell.write ((endTime - startTime) +"\n");
                System.out.println(" Book Shell sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Shell sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Merge Sort***");
                startTime = System.currentTimeMillis();
                BookMergeSort.sort (array);
                endTime = System.currentTimeMillis();
                merge.write ((endTime - startTime) +"\n");
                System.out.println(" Book Merge sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Merge sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Heap Sort***");
                startTime = System.currentTimeMillis();
                BookHeapSort.sort (array);
                endTime = System.currentTimeMillis();
                heap.write ((endTime - startTime) +"\n");
                System.out.println(" Book Heap sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Heap sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Quick Sort***");
                startTime = System.currentTimeMillis();
                BookQuickSort.sort (array);
                endTime = System.currentTimeMillis();
                quick.write ((endTime - startTime) +"\n");
                System.out.println(" Book Quick sort time is " + (endTime-startTime) + " ms");
                System.out.println(" Book Quick sort is successful (true/false): "+ verifyArray (array));
                reloadArray (array,arrayCopy);
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My Merge Sort***");
                startTime = System.currentTimeMillis();
                MyMergeSort.sort (linkedList1);
                endTime = System.currentTimeMillis();
                my_merge.write ((endTime - startTime) +"\n");
                System.out.println(" My Merge sort time is " + (endTime-startTime) + "ms");
                System.out.println(" My Merge sort is successful (true/false): "+ verifyList (linkedList1));
                reloadList (linkedList1,linkedList1Copy);//return list old form
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My Quick Sort***");
                startTime = System.currentTimeMillis();
                MyQuickSort.sort (linkedList1);
                endTime = System.currentTimeMillis();
                my_quick.write ((endTime - startTime) +"\n");
                System.out.println(" My Quick sort time is " + (endTime-startTime) + "ms");
                System.out.println(" My Quick sort is successful (true/false): "+ verifyList (linkedList1));
                reloadList (linkedList1,linkedList1Copy);
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ();
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /** Verifies that the elements in array test are in increasing order.(Sorted)
     @param test The array to verify
     @return true if the elements are in increasing order;
     false if any 2 elements are not in increasing order
     */
    private boolean verifyArray(Comparable[] test) {
        boolean ok = true;
        int i = 0;
        while (ok && i < test.length - 1) {
            ok = test[i].compareTo(test[i + 1]) <= 0;
            i++;
        }
        return ok;
    }
    /** Verifies that the elements in list test are in increasing order.(Sorted)
     @param test The list to verify
     @return true if the elements are in increasing order;
     false if any 2 elements are not in increasing order
     */
    private <T extends Comparable<T>> boolean verifyList(LinkedList<T> test) {
        boolean ok = true;
        int i = 0;
        while (ok && i < test.size () - 1) {
            ok = test.get (i).compareTo(test.get (i+1)) <= 0;
            i++;
        }
        return ok;
    }

    /**
     * This method copies a LinkedList from the specified source LinkedList(Copy of it before sorted),
     * beginning at the first element of the list, to the destination LinkedList.
     * @param list a LinkedList to be copied.
     * @param listCopy original list to copy
     */
    private <T extends Comparable<T>> void reloadList(LinkedList<T> list ,LinkedList<T> listCopy){
        for (int i = 0; i < list.size (); i++) {
            list.set (i,listCopy.get (i));
        }
    }
    /**
     * This method copies an array from the specified source array(Copy of it before sorted),
     * beginning at the first element of the list, to the destination LinkedList.
     * @param arr an array to be copied.
     * @param arrCopy original array to copy
     */
    private <T extends Comparable<T>> void reloadArray(T[] arr ,T[] arrCopy){
        for (int i = 0; i < arr.length; i++) {
            arr[i]=arrCopy[i];
        }
    }

    /**
     * This method creates random array and list with same elements according to given size value.
     * @param size size of list and array
     */
    private void getRandomArrayAndList(int size){
        array = new Integer[size];
        arrayCopy = new Integer[size];
        linkedList1 = new LinkedList<> ();
        linkedList1Copy = new LinkedList<> ();
        int number;
        for (int i = 0; i < size; i++)
        {
            number =random.nextInt(100000);//0 and 100000
            linkedList1.add(number);
            linkedList1Copy.add (number);
            array[i] = number;
            arrayCopy[i] = number;
        }
    }
    /**
     * This method creates sorted array and list with same elements according to given size value.
     * @param size size of list and array
     */
    private void getSortedArrayAndList(int size){
        array = new Integer[size];
        arrayCopy = new Integer[size];
        linkedList1 = new LinkedList<> ();
        linkedList1Copy = new LinkedList<> ();
        for (int i = 0; i < size; i++)
        {
            linkedList1.add(i);
            linkedList1Copy.add (i);
            array[i] = i;
            arrayCopy[i] = i;
        }
    }
}
