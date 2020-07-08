package com.Akif;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * This is class is to fill data from a file.
 */
public class TestDriver {
    /**
     * This methods fills the Software from "software.txt" file.
     * @param data software will be added to all data.
     */
    public static void fill( Data data){
        try {
            File f = new File ("software.txt");
            FileReader fr = new FileReader (f);
            BufferedReader bfr = new BufferedReader (fr);
            String line;
            int i =1;
            Software software = new Software ();
            while ((line = bfr.readLine()) != null) {
                if (i==1){
                    software.setName (line);
                }
                else if (i==2){
                    software.setQuantity (Integer.parseInt (line));
                }
                else if (i==3){
                    software.setPrice (Double.parseDouble (line));
                    data.addSoftware (software);
                    software=new Software ();
                    i=0;
                }
                i++;
            }
            fr.close (); //close file
        }catch (Exception e){
            for ( int k = 0; k < 45; k++) System.out.print("-");
            System.out.println("\nsoftware.txt file is not in the same directory!");
            System.out.println("To fill software automatically please add it!");
        }
    }
}
