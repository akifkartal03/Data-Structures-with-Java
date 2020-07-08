package com.Akif;
/**
 * Main Class is to start the program.
 * */
public class Main {
    /**
     * main method of the program.
     * @param args Not used.
     */
    public static void main(String[] args) {
        //create object by giving data structure that implements search tree.
        //I did this since the question asks "it should be possible to use any data
											//structure implementing search tree interface in your implementation."
    	//So by using oop features I encapsulate all implemention detail from customer.
    	//Customer use this by giving any data structure that implements search tree.
    	//to test I used BinarySearchTree class from book.
        SoftwareStoreSystem softwareStoreSystem = new SoftwareStoreSystem (new BinarySearchTree<> ());
        softwareStoreSystem.startSystem ();//start system by showing main menu of the sytem to the user. 
    }


}
