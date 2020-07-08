package com.Akif;

import java.util.ArrayList;

/***
 * This class is where the user can add/remove words and print the puzzle words with
 * their cross words and indexes.
 */
public class Main {
	/***
	 * Main method of the program.
	 * @param args arguments from outside.
	 */
    public static void main(String[] args) {
    	/*
    	Here, I simulated the puzzle that is in pdf as a picture. So ;
    	PUZZLES word has 2 crossword these are FUN and CROSSWORD;
    	FUN word has 1 crossword this is PUZZLES;
    	CROSSWORD word has 2 crossword these are PUZZLES and ARE;
    	ARE word has 1 crossword this is CROSSWORD;
    	 */
    	CrossWordPuzzle crossWordPuzzle = new CrossWordPuzzle ();
    	//create words
		WordLinkedList wordLinkedList = new WordLinkedList ("PUZZLES");
		WordLinkedList wordLinkedList1 = new WordLinkedList ("FUN");
		WordLinkedList wordLinkedList2 = new WordLinkedList ("CROSSWORD");
		WordLinkedList wordLinkedList3 = new WordLinkedList ("ARE");
		//create a list of word to add cross word
		ArrayList<WordLinkedList> wordLinkedLists = new ArrayList<> ();
		//create a itself index list(Puzzle word itself cross indexes)
		ArrayList<Integer> ii = new ArrayList<> ();
		ii.add (1); //fun
		ii.add (6); //crossword
		//create a other index list (Puzzle word cross other indexes(fun and crossword))
		ArrayList<Integer> oi = new ArrayList<> ();
		oi.add (1); //fun
		oi.add (4); //crossword
		//add the words to list(fun and crossword)
		wordLinkedLists.add (wordLinkedList1);
		wordLinkedLists.add (wordLinkedList2);
		//add all words to puzzle with their specified crosses and cross indexes
    	crossWordPuzzle.addWord (wordLinkedList1);
    	crossWordPuzzle.addWord (wordLinkedList3);
    	//add a cross between CROSSWORD and ARE words.
		crossWordPuzzle.addWord (wordLinkedList2,wordLinkedList3,1,1);
		//add all cross of PUZZLE word (puzzle word has most crossword so we don't need to add cross other words(fun and crossword))
	    crossWordPuzzle.addWord (wordLinkedList,wordLinkedLists,ii,oi);
	    //print each word separately in the puzzle with its cross words and indexes as in the real puzzle.
	    crossWordPuzzle.print ();
	    crossWordPuzzle.removeWord (wordLinkedList,ii);
		for (int j=0;j<50;j++) System.out.print ("-");
	    System.out.println ("\n****Print results After removed 'PUZZLES' word****");
		crossWordPuzzle.print ();

    }
}
