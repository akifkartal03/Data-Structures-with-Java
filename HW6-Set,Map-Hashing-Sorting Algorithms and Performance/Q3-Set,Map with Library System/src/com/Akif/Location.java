package com.Akif;

import java.util.Random;
/**
 * This is a general location class.
 */
public class Location {
    /**
     * Code of location
     */
    private String code;
    /**
     * Shelf number of location
     */
    private int shelfNumber;
    /**
     * Corridor number of Location
     */
    private int corridorNumber;

    /**
     * No parameter constructor to initialize a default location.
     */
    public Location(){
        this(0,0);
    }

    /**
     * Two parameter constructor to initialize Location with given information.
     * While doing this it also creates code of location.
     * @param shelfNumber Shelf number of location
     * @param corridorNumber Corridor number of Location
     */
    public Location (int shelfNumber, int corridorNumber) {
        this.shelfNumber = shelfNumber;
        this.corridorNumber = corridorNumber;
        Random random = new Random ();
        this.code = String.format ("c%ds%d.%d",corridorNumber,shelfNumber,random.nextInt (10000));
    }
    //setter and getter.
    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public int getShelfNumber () {
        return shelfNumber;
    }

    public void setShelfNumber (int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public int getCorridorNumber () {
        return corridorNumber;
    }

    public void setCorridorNumber (int corridorNumber) {
        this.corridorNumber = corridorNumber;
    }
}
