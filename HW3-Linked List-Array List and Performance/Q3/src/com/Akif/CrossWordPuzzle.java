package com.Akif;

import java.util.ArrayList;
import java.util.List;

/***
 * This class is to use WordLinkedList class by keeping a list of WordLinkedList.
 */
public class CrossWordPuzzle {
    /***
     * A list to keep a list of WordLinkedList
     */
    private List<WordLinkedList> puzzle;

    /***
     * No parameter constructor initializes the list with an empty ArrayList.
     */
    public CrossWordPuzzle(){
        puzzle = new ArrayList<> ();
    }

    /***
     * This method adds a word to the puzzle with its specified crosses as parameter.
     * Parameters are list since word may have more than one crossword.
     * To use this parameters and method correctly you have to create a list that,
     * each list should contain related elements in same index.
     * For example if 1th index of crosswords contains a word, itself index of this word must be in 1th index of
     * itselfIndexes list and also other index of this word must be in 1th index in otherIndexes list.
     * @param word a word to add puzzle.
     * @param crossWords a list of crosswords if this word has more than one crossword.
     * @param itselfIndexes since this word has more than one crossword a list of index of cross letters(node) in this word.
     * @param otherIndexes since this word has more than one crossword a list of index of cross letters(node) in other words.
     */
    public void addWord(WordLinkedList word,ArrayList<WordLinkedList> crossWords,ArrayList<Integer> itselfIndexes,ArrayList<Integer> otherIndexes ){
        for (int i = 0 ; i<crossWords.size ();i++){
            word.addCross (crossWords.get (i),itselfIndexes.get (i),otherIndexes.get (i));
        }
        puzzle.add (word);
    }

    /***
     * This method adds a word to the puzzle with its specified cross as parameter.
     * @param word a word to add puzzle.
     * @param crossWord other WordLinkedList object to add a cross between them.
     * @param itselfIndex index of cross letter(node) in my word.
     * @param otherIndex index of cross letter(node) in other word.
     */
    public void addWord(WordLinkedList word,WordLinkedList crossWord,int itselfIndex,int otherIndex){
        word.addCross (crossWord,itselfIndex,otherIndex);
        puzzle.add (word);
    }

    /***
     * This method adds a word to the puzzle without a cross.
     * @param word a word to add puzzle.
     */
    public void addWord(WordLinkedList word){
        puzzle.add (word);
    }

    /***
     * This method removes a word from the puzzle and its specified crosses as parameter.
     * @param word a word that will be deleted
     * @param itselfIndexes a list of index of cross letters(node) in this word.
     */
    public void removeWord(WordLinkedList word,ArrayList<Integer> itselfIndexes){
        for (int i = 0 ; i<itselfIndexes.size ();i++){
            word.removeCross (itselfIndexes.get (i));
        }
        puzzle.remove (word);
    }

    /***
     * This method removes only a word from the puzzle.
     * @param word a word that will be deleted.
     */
    public void removeWord(WordLinkedList word){
        puzzle.remove (word);
    }

    /***
     * This method prints each word separately in the puzzle with its cross words and indexes as in the real puzzle.
     */
    public void print(){
        for (int i = 0 ; i<puzzle.size ();i++){
            for (int j=0;j<50;j++) System.out.print ("-");
            System.out.println("\n'"+puzzle.get (i).toString ()+"' word with its cross words and indexes.\n");
            puzzle.get (i).print ();
        }
    }
}
