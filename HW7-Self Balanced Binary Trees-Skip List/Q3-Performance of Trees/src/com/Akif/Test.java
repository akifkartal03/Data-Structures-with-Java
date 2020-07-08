package com.Akif;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * This class is to Compare the running times and their increase.
 */
public class Test {
    /**
     * to generate random numbers
     */
    private Random random = new Random();
    /**
     * start time of operation
     */
    private long startTime;
    /**
     * end time of operation
     */
    private long endTime;
    /**
     * write each test result a proper file to calculate average of them.
     */
    private FileWriter BST,rbBook,rbJava,bTree,slistBook,slistJava,slistQ2,insertAvg,deleteAvg;
    /**
     * An Integer array to test them.
     */
    private Integer[] array;
    /**
     * 10 element to delete
     */
    private Integer[] deletedArray;
    //data structures to test.
    /**
     * Regular binary search tree
     */
    private BinarySearchTree<Integer> binarySearchTree;
    /**
     * Red-Black tree implementation in the book
     */
    private RedBlackTree<Integer> redBlackTreeBook;
    /**
     * Red Black tree implementation in java
     */
    private TreeSet<Integer> redBlackTreeJava;
    /**
     * B-tree implementation in the book
     */
    private BTree<Integer> bTreeBook;
    /**
     * Skip list implementation in the book
     */
    private SkipList<Integer> skipListBook;
    /**
     * Skip list implementation in java
     */
    private ConcurrentSkipListSet<Integer> skipListJava;
    /**
     * Skip list in question Q2
     */
    private SkipArrayList<Integer> skipListQ2;
    /**
     * Start to test algorithms.
     */
    public void startTest() {
        try {
            //open files
            BST = new FileWriter("BST.txt");
            rbBook = new FileWriter("rbBook.txt");
            rbJava = new FileWriter("rbJava.txt");
            bTree = new FileWriter("bTree.txt");
            slistBook = new FileWriter("slistBook.txt");
            slistJava = new FileWriter("slistJava.txt");
            slistQ2 = new FileWriter("slistQ2.txt");
            insertAvg =new FileWriter("insertAvg.txt");
            deleteAvg =new FileWriter("deleteAvg.txt");
            //call test methods
            writeSize (10000);
            fillArrayAndTest (10000);
            writeSize (20000);
            fillArrayAndTest (20000);
            writeSize (40000);
            fillArrayAndTest (40000);
            writeSize (80000);
            fillArrayAndTest (80000);
            //close files
            BST.close();rbBook.close();rbJava.close();bTree.close();
            slistBook.close();slistJava.close();slistQ2.close();insertAvg.close ();deleteAvg.close ();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Test Binary Search Tree and return insertion and deletion time given double array.
     * @param time insertion and deletion time for testing size
     */
    private void testBST(double[] time){
        try {
            //create a new instance of BST
            binarySearchTree = new BinarySearchTree<> ();
            //add element from random array
            for (Integer integer : array) {
                binarySearchTree.add (integer);
            }
            //Insert 10 extra random numbers into the structures you built. Measure the running time and
            //calculate the average running time for each data structure and four different problem size.
            startTime = System.nanoTime ();
            for (int i = 0; i <10 ; i++) {
                binarySearchTree.add (random.nextInt(100000));
            }
            endTime = System.nanoTime();
            BST.write ("Insert time\n");
            BST.write ((endTime - startTime)/1000.0 +"\n"); //get microsecond
            time[0]=(endTime - startTime)/1000.0;//save time into array
            startTime = System.nanoTime ();
            //Perform 10 successful deletion operations from the structures you built. Measure the running time and
            //calculate the average running time for each data structure and four different problem size.
            for (int i = 0; i <10 ; i++) {
                binarySearchTree.remove (deletedArray[i]);
            }
            endTime = System.nanoTime();
            BST.write ("Delete time\n");
            BST.write ((endTime - startTime)/1000.0 +"\n");
            time[1]=(endTime - startTime)/1000.0; //save time into array

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    /**
     * Test Red-Black tree implementation in the book and return insertion and deletion time given double array.
     * @param time insertion and deletion time for testing size
     */
    private void testRBBOOK(double[] time){
        try {
            redBlackTreeBook = new RedBlackTree<> ();
            for (Integer integer : array) {
                redBlackTreeBook.add (integer);
            }
            startTime = System.nanoTime();
            for (int i = 0; i <10 ; i++) {
                redBlackTreeBook.add (random.nextInt(100000));
            }
            endTime = System.nanoTime();
            rbBook.write ("Insert time\n");
            rbBook.write ((endTime - startTime)/1000.0 +"\n");
            time[0]=(endTime - startTime)/1000.0;
            startTime = System.nanoTime ();
            for (int i = 0; i <10 ; i++) {
                redBlackTreeBook.remove (deletedArray[i]);
            }
            endTime = System.nanoTime();
            rbBook.write ("Delete time\n");
            rbBook.write ((endTime - startTime)/1000.0 +"\n");
            time[1]=(endTime - startTime)/1000.0;

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    /**
     * Test Red Black tree implementation in java and return insertion and deletion time given double array.
     * @param time insertion and deletion time for testing size
     */
    private void testRBJAVA(double[] time){
        try {
            redBlackTreeJava = new TreeSet<> ();
            for (Integer integer : array) {
                redBlackTreeJava.add (integer);
            }
            startTime = System.nanoTime();
            for (int i = 0; i <10 ; i++) {
                redBlackTreeJava.add (random.nextInt(100000));
            }
            endTime = System.nanoTime();
            rbJava.write ("Insert time\n");
            rbJava.write ((endTime - startTime)/1000.0 +"\n");
            time[0]=(endTime - startTime)/1000.0;
            startTime = System.nanoTime ();
            for (int i = 0; i <10 ; i++) {
                redBlackTreeJava.remove (deletedArray[i]);
            }
            endTime = System.nanoTime();
            rbJava.write ("Delete time\n");
            rbJava.write ((endTime - startTime)/1000.0 +"\n");
            time[1]=(endTime - startTime)/1000.0;


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    /**
     * Test B-tree implementation in the book and return insertion and deletion time given double array.
     * @param time insertion and deletion time for testing size
     */
    private void testBTREE(double[] time){
        try {
            bTreeBook = new BTree<> (50);
            for (Integer integer : array) {
                bTreeBook.add (integer);
            }
            startTime = System.nanoTime();
            for (int i = 0; i <10 ; i++) {
                bTreeBook.add (random.nextInt(100000));
            }
            endTime = System.nanoTime();
            bTree.write ("Insert time\n");
            bTree.write ((endTime - startTime)/1000.0 +"\n");
            time[0]=(endTime - startTime)/1000.0;
            startTime = System.nanoTime ();
           /* for (int i = 0; i <10 ; i++) {
                bTreeBook.remove (deletedArray[i]);
            }*/
            endTime = System.nanoTime();
            bTree.write ("Delete time\n");
            bTree.write ((endTime - startTime)/1000.0 +"\n");
            time[1]=(endTime - startTime)/1000.0;


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
    /**
     * Test Skip list implementation in the book and return insertion and deletion time given double array.
     * @param time insertion and deletion time for testing size
     */
    private void testSLISTBOOK(double[] time){
        try {
            skipListBook = new SkipList<> ();
            for (Integer integer : array) {
                skipListBook.add (integer);
            }
            startTime = System.nanoTime();
            for (int i = 0; i <10 ; i++) {
                skipListBook.add (random.nextInt(100000));
            }
            endTime = System.nanoTime();
            slistBook.write ("Insert time\n");
            slistBook.write ((endTime - startTime)/1000.0 +"\n");
            time[0]=(endTime - startTime)/1000.0;
            startTime = System.nanoTime ();
            for (int i = 0; i <10 ; i++) {
                skipListBook.remove (deletedArray[i]);
            }
            endTime = System.nanoTime();
            slistBook.write ("Delete time\n");
            slistBook.write ((endTime - startTime)/1000.0 +"\n");
            time[1]=(endTime - startTime)/1000.0;


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /**
     * Test Skip list implementation in java and return insertion and deletion time given double array.
     * @param time insertion and deletion time for testing size
     */
    private void testSLISTJAVA(double[] time){
        try {
            skipListJava = new ConcurrentSkipListSet<> ();
            for (Integer integer : array) {
                skipListJava.add (integer);
            }
            startTime = System.nanoTime();
            for (int i = 0; i <10 ; i++) {
                skipListJava.add (random.nextInt(100000));
            }
            endTime = System.nanoTime();
            slistJava.write ("Insert time\n");
            slistJava.write ((endTime - startTime)/1000.0 +"\n");
            time[0]=(endTime - startTime)/1000.0;
            startTime = System.nanoTime ();
            for (int i = 0; i <10 ; i++) {
                skipListJava.remove (deletedArray[i]);
            }
            endTime = System.nanoTime();
            slistJava.write ("Delete time\n");
            slistJava.write ((endTime - startTime)/1000.0 +"\n");
            time[1]=(endTime - startTime)/1000.0;

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /**
     * Test Skip list in question Q2 and return insertion and deletion time given double array.
     * @param time insertion and deletion time for testing size
     */
    private void testSLISTQ2(double[] time){
        try {
            skipListQ2 = new SkipArrayList<> (150);
            for (Integer integer : array) {
                skipListQ2.add (integer);
            }
            startTime = System.nanoTime();
            for (int i = 0; i <10 ; i++) {
                skipListQ2.add (random.nextInt(100000));
            }
            endTime = System.nanoTime();
            slistQ2.write ("Insert time\n");
            slistQ2.write ((endTime - startTime)/1000.0 +"\n");
            time[0]=(endTime - startTime)/1000.0;
            startTime = System.nanoTime ();
            for (int i = 0; i <10 ; i++) {
                skipListQ2.remove (deletedArray[i]);
            }
            endTime = System.nanoTime();
            slistQ2.write ("Delete time\n");
            slistQ2.write ((endTime - startTime)/1000.0 +"\n");
            time[1]=(endTime - startTime)/1000.0;

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * This method fills array with random numbers according to given size value.
     * Some of elements will be added to delete array to delete them.
     * @param size size of array
     */
    private void getRandomArray(int size){
        array = new Integer[size];
        deletedArray = new Integer[10];
        int number=0,k=0;
        for (int i = 0; i < size; i++)
        {
            number =random.nextInt(100000);//0 and 100000
            array[i] = number;
            //add 10 element
            if (i%1000==0&&k<10){
                deletedArray[k]=number;
                k++;
            }
        }
        deletedArray[9]=number;//add last element
    }
    /**
     * This method Insert a collection of randomly generated numbers for each data structure.
     * Perform this operation 10 times for 10.000, 20.000, 40.000 and 80.000 random numbers (10 times for each).
     * Also it performs 10 successful deletion operations from the structures you built. Measure the running time and
     * calculate the average running time for each data structure and four different problem size.
     * @param size size of test.
     */
    private void fillArrayAndTest(int size){
        //test with same array each of them for 1 iteration and 10 times
        //in each iteration array will be changed.
        //save running time into arrays
        /*
            index number for the time is;
           0 - Regular binary search tree
           1 - Red-Black tree implementation in the book
           2 - Red Black tree implementation in java
           3 - B-tree implementation in the book
           4 - Skip list implementation in the book
           5 - Skip list implementation in java
           6 - Skip list in question Q2
         */
        double[] sumInsert = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        double[] sumDelete = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        double[] res = new double[]{0.0,0.0};//insertion and deletion time from test methods
        double[] avgInsert = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        double[] avgDelete = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        for (int i = 0; i <10 ; i++) {
            getRandomArray (size);//get random array with given size
            //test each of them with this array.
            //insert and delete and get running time with res array
            testBST (res);
            sumInsert[0]+=res[0];
            sumDelete[0]+=res[1];
            testRBBOOK (res);
            sumInsert[1]+=res[0];
            sumDelete[1]+=res[1];
            testRBJAVA (res);
            sumInsert[2]+=res[0];
            sumDelete[2]+=res[1];
            testBTREE (res);
            sumInsert[3]+=res[0];
            sumDelete[3]+=res[1];
            testSLISTBOOK (res);
            sumInsert[4]+=res[0];
            sumDelete[4]+=res[1];
            testSLISTJAVA (res);
            sumInsert[5]+=res[0];
            sumDelete[5]+=res[1];
            testSLISTQ2 (res);
            sumInsert[6]+=res[0];
            sumDelete[6]+=res[1];
        }
        //get average of them
        for (int i = 0; i < 7; i++) {
            avgInsert[i]=sumInsert[i]/10.0;
            avgDelete[i]=sumDelete[i]/10.0;
        }
        //print them to the screen
        System.out.println ("***ARRAY SIZE = " +size+"***");
        for (int i = 0 ; i<60;i++) System.out.print("-");
        System.out.printf ("\nBST add avg: %.2f microsecond(us)\n",avgInsert[0]);
        System.out.printf ("BST delete avg: %.2f microsecond(us)\n",avgDelete[0]);
        //------------------------------------------------------------
        for (int i = 0 ; i<60;i++) System.out.print("-");
        System.out.printf ("\nRedBlack Book add avg: %.2f microsecond(us)\n",avgInsert[1]);
        System.out.printf ("RedBlack Book delete avg: %.2f microsecond(us)\n",avgDelete[1]);
        //------------------------------------------------------------
        for (int i = 0 ; i<60;i++) System.out.print("-");
        System.out.printf ("\nRedBlack java add avg: %.2f microsecond(us)\n",avgInsert[2]);
        System.out.printf ("RedBlack java delete avg: %.2f microsecond(us)\n",avgDelete[2]);
        //------------------------------------------------------------
        for (int i = 0 ; i<60;i++) System.out.print("-");
        System.out.printf ("\nB-Tree Book add avg: %.2f microsecond(us)\n",avgInsert[3]);
        System.out.printf ("B-Tree delete avg: %.2f microsecond(us)\n",avgDelete[3]);
        //------------------------------------------------------------
        for (int i = 0 ; i<60;i++) System.out.print("-");
        System.out.printf ("\nSkip List Book add avg: %.2f microsecond(us)\n",avgInsert[4]);
        System.out.printf ("Skip List Book delete avg: %.2f microsecond(us)\n",avgDelete[4]);
        //------------------------------------------------------------
        for (int i = 0 ; i<60;i++) System.out.print("-");
        System.out.printf ("\nSkip List java  add avg: %.2f microsecond(us)\n",avgInsert[5]);
        System.out.printf ("Skip List java  delete avg: %.2f microsecond(us)\n",avgDelete[5]);
        //------------------------------------------------------------
        for (int i = 0 ; i<60;i++) System.out.print("-");
        System.out.printf ("\nSkip List Q2  add avg: %.2f microsecond(us)\n",avgInsert[6]);
        System.out.printf ("Skip List Q2  delete avg: %.2f microsecond(us)\n",avgDelete[6]);
        for (int i = 0 ; i<60;i++) System.out.print("-");
        System.out.println ();
        //------------------------------------------------------------
        //write them into file
        try {
            deleteAvg.write ("***ARRAY SIZE = " +size+"***\n");
            insertAvg.write ("***ARRAY SIZE = " +size+"***\n");
            for (int i = 0; i <7 ; i++) {
                insertAvg.write (String.format ("%.2f\n",avgInsert[i]));
                deleteAvg.write (String.format ("%.2f\n",avgDelete[i]));
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /**
     * Write each file a title
     * @param size size of test array
     */
    private void writeSize(int size){
        try {
            //write each file given title.
            BST.write ("***ARRAY SIZE = " +size+"***\n");
            rbBook.write ("***ARRAY SIZE = " +size+"***\n");
            rbJava.write ("***ARRAY SIZE = " +size+"***\n");
            bTree.write ("***ARRAY SIZE = " +size+"***\n");
            slistJava.write ("***ARRAY SIZE = " +size+"***\n");
            slistBook.write ("***ARRAY SIZE = " +size+"***\n");
            slistQ2.write ("***ARRAY SIZE = " +size+"***\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
