package com.Akif;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.ListIterator;

/***
 * This class provides the some of the edit functionality of a text editor.
 * To keep the text by using a java list, list stores each character of text.
 * To use this class you need to specify which list you will use.
 */
public class SimpleTextEditor {
    /***
     * A list of characters to keep text.
     */
    private List<Character> text;

    /***
     * One parameter constructor initializes the list according to specified type.
     * @param listType type of list that you will use.
     */
    public SimpleTextEditor(List<Character> listType){
        text = listType;
    }

    /***
     * This method to read from a text file which is specified and construct the text.
     * It uses add method of the list and simple loop structure.
     * @param fileName name of the file that will be read the text.
     */
    public void read(String fileName){
        int ascii;
        char character;
        try {
            File f = new File (fileName);
            FileReader fr = new FileReader (f);
            ascii = fr.read ();//get a character from file with ascii code
            while (ascii!=-1){ //if the end of the stream has not been reached
                character = (char)ascii; //convert to character
                text.add (character); //add the character end of the list by using add method
                ascii = fr.read (); //go ahead to read
            }
            fr.close (); //close file
        }catch (Exception e){
            e.printStackTrace ();
        }
    }

    /***
     * This method adds one or more characters (given as a string) at the specified
     * position (given as an integer index) in the text.
     * It uses simple for loop with index structure to add.
     * @param newItem characters to add.
     * @param index specified position to add.
     */
    public void add(String newItem,int index){
        for (int i =0;i<newItem.length ();i++ ){
            text.add (index+i,newItem.charAt (i));
        }
    }
    /***
     * This method returns the start index of the first occurrence of the searched
     * group of characters.
     * It uses simple for loop with index structure to find.
     * @param searchItem group of characters to be searched
     * @return start index of the first occurrence of the searched group of characters.
     */
    public int find(String searchItem){
        StringBuilder string=new StringBuilder ();
        for (int i=0;i<text.size ();i++ ){
            string.append (text.get (i));
        }
        return string.indexOf (searchItem);
    }
    /***
     * This method replaces all occurrences of a character with another character in the text.
     * It uses simple for loop with index structure to replace.
     * @param oldCh a character to be changed.
     * @param newCh a character to be replaced with old character.
     */
    public void replaceAll(char oldCh,char newCh){
        for (int i =0;i<text.size ();i++ ){
            if (text.get (i).equals (oldCh)){
                text.set (i,newCh);
            }
        }
    }

    /***
     * Returns the text as a string
     * @return the text as a string
     */
    public String toString(){
        StringBuilder string=new StringBuilder ();
        for (int i=0;i<text.size ();i++ ){
            string.append (text.get (i));
        }
        return string.toString ();
    }
    /***
     * This method to read from a text file which is specified and construct the text.
     * It uses add method of the iterator (ListIterator) and  navigates on the List.
     * @param fileName name of the file that will be read the text.
     */
    public void readByIterator(String fileName){
        ListIterator<Character> listIterator =text.listIterator (0);
        int ascii;
        char character;
        try {
            File f = new File (fileName);
            FileReader fr = new FileReader (f);
            ascii = fr.read ();
            while (ascii!=-1){
                character = (char)ascii;
                listIterator.add (character);
                ascii = fr.read ();
            }
            fr.close ();
        }catch (Exception e){
            e.printStackTrace ();
        }
    }
    /***
     * This method adds one or more characters (given as a string) at the specified
     * position (given as an integer index) in the text.
     * It uses iterator(ListIterator) to navigate on the List to add.
     * @param newItem characters to add.
     * @param index specified position to add.
     */
    public void addByIterator(String newItem,int index){
        ListIterator<Character> listIterator =text.listIterator (index);
        for (int i =0;i<newItem.length ();i++ ){
            listIterator.add (newItem.charAt (i));
        }
    }
    /***
     * This method returns the start index of the first occurrence of the searched
     * group of characters.
     * It uses iterator(ListIterator) to navigate on the List to find.
     * @param searchItem group of characters to be searched
     * @return start index of the first occurrence of the searched group of characters.
     */
    public int findByIterator(String searchItem){
        StringBuilder string=new StringBuilder ();
        ListIterator<Character> listIterator =text.listIterator (0);
        while(listIterator.hasNext ()){
            string.append (listIterator.next ());
        }
        return string.indexOf (searchItem);
    }
    /***
     * This method replaces all occurrences of a character with another character in the text.
     * It uses iterator(ListIterator) to navigate on the List to replace.
     * @param oldCh a character to be changed.
     * @param newCh a character to be replaced with old character.
     */
    public void replaceAllByIterator(char oldCh,char newCh){
        ListIterator<Character> listIterator =text.listIterator (0);
        while(listIterator.hasNext ()){
            if (listIterator.next ().equals (oldCh)){
                listIterator.set (newCh);
            }
        }
    }

}
