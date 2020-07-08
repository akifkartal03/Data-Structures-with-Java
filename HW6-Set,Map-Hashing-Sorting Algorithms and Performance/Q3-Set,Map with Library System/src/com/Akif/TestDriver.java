package com.Akif;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * This is class is to fill data from a file.
 */
public class TestDriver {
    /**
     * This methods fills the book from "books.txt" file.
     * @param data book will be added to all data.
     */
    public static void fill( Data data){
        try {
            File f = new File ("books.txt");
            FileReader fr = new FileReader (f);
            BufferedReader bfr = new BufferedReader (fr);
            String line;
            int i =1;
            Book book = new Book ();
            while ((line = bfr.readLine()) != null) {
                if (i==1){
                    book.setAuthor (new Author (line));
                }
                else if (i==2){
                    book.setTitle (line);
                }
                else if (i==3){
                    book.setLocation (new Location (Character.getNumericValue(line.charAt (0)),
                            Character.getNumericValue(line.charAt (1))));
                    data.addBook (book);
                    i=0;
                }
                i++;
            }
            fr.close (); //close file
        }catch (Exception e){
            for ( int k = 0; k < 45; k++) System.out.print("-");
            System.out.println("\nbooks.txt file is not in the same directory!");
            System.out.println("To fill books automatically please add it!");
        }
    }
}
