package com.Akif;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

/**
 * This class is to compare the performance of new Table implementations with
 * HashTableOpen and HashTableChain classes in the book.
 */
public class Test {
    /**
     * to generate random numbers while adding table.
     */
    private Random random = new Random();
    /**
     * start time of filling table and getting values.
     */
    private long startTime;
    /**
     * end time of filling table and getting values.
     */
    private long endTime;
    /**
     * write each test result a proper file to draw a graph by using them.
     */
    private FileWriter hashOpen,hashChain,myHashOpen,myHashChain;
    /**
     * Create objects.
     */
    private HashTableOpen<Integer,Integer> bookTableOpen ;
    private MyHashTableOpen<Integer,Integer> myTableOpen;
    private HashTableChain<Integer,Integer> bookTableChain;
    private MyHashTableChain<Integer,Integer> myTableChain;
    /**
     * Start to test algorithms.
     */
    public void startTest() {
        try {
            //open files
            hashOpen = new FileWriter("hasOpen.txt");
            hashChain = new FileWriter("hashChain.txt");
            myHashOpen = new FileWriter("myHashOpen.txt");
            myHashChain = new FileWriter("myHashChain.txt");
            //call test methods
            test10000 ();
            test40000 ();
            test100000 ();
            //close files
            myHashOpen.close();myHashChain.close();hashChain.close();hashOpen.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Test each algorithm with table with a length of ten thousand (10000).
     */
    private void test10000(){
        try {
            bookTableOpen = new HashTableOpen<> ();
            myTableOpen= new MyHashTableOpen<> ();
            bookTableChain = new HashTableChain<> ();
            myTableChain= new MyHashTableChain<> ();
            System.out.println ("\t***TEST With Map Size = 10000***");
            for (int i = 0 ; i<60;i++) System.out.print("-");
            //write file to distinguish the times among algorithms.
            hashChain.write ("***TEST With Map Size = 10000***\n\n");
            hashOpen.write ("***TEST With Map Size = 10000***\n\n");
            myHashChain.write ("***TEST With Map Size = 10000***\n\n");
            myHashOpen.write ("***TEST With Map Size = 10000***\n\n");
            for (int j = 0; j < 1; j++) {
                //execute each table and save the times to the their own file and also print.
                //---------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Book HashOpenTable with 10000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    //keys are in order.
                    bookTableOpen.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+bookTableOpen.get (650));
                System.out.println ("900th key of open table: "+bookTableOpen.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 10000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                hashOpen.write ((endTime - startTime) +"\n");
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Book HashChainTable with 10000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    bookTableChain.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+bookTableChain.get (650));
                System.out.println ("900th key of open table: "+bookTableChain.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 10000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                hashChain.write ((endTime - startTime) +"\n");
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My HashOpenTable with 10000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    myTableOpen.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+myTableOpen.get (650));
                System.out.println ("900th key of open table: "+myTableOpen.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 10000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                myHashOpen.write ((endTime - startTime) +"\n");
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My HashChainTable with 10000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    myTableChain.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+myTableChain.get (650));
                System.out.println ("900th key of open table: "+myTableChain.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 10000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                myHashChain.write ((endTime - startTime) +"\n");
                System.out.println ();

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    /**
     * Test each algorithm with table with a length of forty thousand (40000).
     */
    private void test40000(){
        try {
            bookTableOpen = new HashTableOpen<> ();
            myTableOpen= new MyHashTableOpen<> ();
            bookTableChain = new HashTableChain<> ();
            myTableChain= new MyHashTableChain<> ();
            System.out.println ("\t***TEST With Map Size = 40000***");
            for (int i = 0 ; i<60;i++) System.out.print("-");
            //write file to distinguish the times among algorithms.
            hashChain.write ("***TEST With Map Size = 40000***\n\n");
            hashOpen.write ("***TEST With Map Size = 40000***\n\n");
            myHashChain.write ("***TEST With Map Size = 40000***\n\n");
            myHashOpen.write ("***TEST With Map Size = 40000***\n\n");
            for (int j = 0; j < 1; j++) {
                //execute each algorithm and save the times to the their own file and also print.
                //---------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Book HashOpenTable with 40000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 40000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    bookTableOpen.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+bookTableOpen.get (650));
                System.out.println ("900th key of open table: "+bookTableOpen.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 40000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                hashOpen.write ((endTime - startTime) +"\n");
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Book HashChainTable with 40000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 40000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    bookTableChain.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+bookTableChain.get (650));
                System.out.println ("900th key of open table: "+bookTableChain.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 40000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                hashChain.write ((endTime - startTime) +"\n");
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My HashOpenTable with 40000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 40000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    myTableOpen.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+myTableOpen.get (650));
                System.out.println ("900th key of open table: "+myTableOpen.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 40000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                myHashOpen.write ((endTime - startTime) +"\n");
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My HashChainTable with 40000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 40000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    myTableChain.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+myTableChain.get (650));
                System.out.println ("900th key of open table: "+myTableChain.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 40000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                myHashChain.write ((endTime - startTime) +"\n");
                System.out.println ();

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    /**
     * Test each algorithm with table with a length of one hundred thousand (100000).
     */
    private void test100000(){
        try {
            bookTableOpen = new HashTableOpen<> ();
            myTableOpen= new MyHashTableOpen<> ();
            bookTableChain = new HashTableChain<> ();
            myTableChain= new MyHashTableChain<> ();
            System.out.println ("\t***TEST With Map Size = 100000***");
            for (int i = 0 ; i<60;i++) System.out.print("-");
            //write file to distinguish the times among algorithms.
            hashChain.write ("***TEST With Map Size = 100000***\n\n");
            hashOpen.write ("***TEST With Map Size = 100000***\n\n");
            myHashChain.write ("***TEST With Map Size = 100000***\n\n");
            myHashOpen.write ("***TEST With Map Size = 100000***\n\n");
            for (int j = 0; j < 1; j++) {
                //execute each algorithm and save the times to the their own file and also print.
                //---------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Book HashOpenTable with 100000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 100000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    bookTableOpen.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+bookTableOpen.get (650));
                System.out.println ("900th key of open table: "+bookTableOpen.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 100000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                hashOpen.write ((endTime - startTime) +"\n");
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***Book HashChainTable with 100000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 100000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    bookTableChain.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+bookTableChain.get (650));
                System.out.println ("900th key of open table: "+bookTableChain.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 100000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                hashChain.write ((endTime - startTime) +"\n");
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My HashOpenTable with 100000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    myTableOpen.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+myTableOpen.get (650));
                System.out.println ("900th key of open table: "+myTableOpen.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 100000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                myHashOpen.write ((endTime - startTime) +"\n");
                //------------------------------------------------------------------------
                for (int i = 0 ; i<60;i++) System.out.print("-");
                System.out.println ("\n\t***My HashChainTable with 100000 element***");
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 100000; i++)
                {
                    //put key=ith element,value=random number
                    //values are random number
                    myTableChain.put (i,random.nextInt(1000));
                }
                System.out.println ("650th key of open table: "+myTableChain.get (650));
                System.out.println ("900th key of open table: "+myTableChain.get (900));
                endTime = System.currentTimeMillis();
                System.out.println("Book HashOpenTable put 100000 element and get 2 element time: "
                        + (endTime - startTime) + " ms");
                myHashChain.write ((endTime - startTime) +"\n");
                System.out.println ();

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

}
